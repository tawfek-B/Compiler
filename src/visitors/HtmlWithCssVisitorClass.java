package visitors;

import antlr.grammars.HTMLWithCSSLexer;
import antlr.grammars.HTMLWithCSSParser;
import antlr.grammars.HTMLWithCSSParserBaseVisitor;
import ast.core.*;
import ast.css.*;
import ast.html.*;
import ast.jinja.*;
import ast.python.AttributeAccessNode;
import ast.python.KeywordArgumentNode;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.jinja.JinjaBlockNode.BlockType;
import table.LabelTable;
import table.SymbolTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static ast.jinja.JinjaBlockNode.BlockType.*;

public class HtmlWithCssVisitorClass extends HTMLWithCSSParserBaseVisitor<ASTNode> {

    private final List<String> errors = new ArrayList<>();

    // safe visit for all nodes
    @SuppressWarnings("Unchecked")
    private <T extends ASTNode> T safeVisit(org.antlr.v4.runtime.tree.ParseTree ctx) {
        if (ctx == null) return null;
        ASTNode node = visit(ctx);

        if (node == null) {
            System.out.println("Semantic Warning: visit returned null for: " + ctx.getText());
        }
        return (T) node;
    }

    @Override
    public ASTNode visitHtmlDocument(HTMLWithCSSParser.HtmlDocumentContext ctx) {
        HtmlDocumentNode root = new HtmlDocumentNode(1, 0);
        ctx.documentItem().forEach(item -> {
            ASTNode node = safeVisit(item);
            if (node != null) root.add(node);
        });
        return root;
    }

    @Override
    public ASTNode visitSeaWsItem(HTMLWithCSSParser.SeaWsItemContext ctx) {
        String text = ctx.getText();
        if (text.trim().isEmpty() && !text.contains("\n")) {
            return null;
        }
        HtmlTextNode node = new HtmlTextNode(text, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitScriptletItem(HTMLWithCSSParser.ScriptletItemContext ctx) {
        Token t = ctx.SCRIPTLET().getSymbol();
        HtmlTextNode node = new HtmlTextNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitXmlItem(HTMLWithCSSParser.XmlItemContext ctx) {
        Token t = ctx.XML().getSymbol();
        HtmlTextNode node = new HtmlTextNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitDtdItem(HTMLWithCSSParser.DtdItemContext ctx) {
        Token t = ctx.DTD().getSymbol();
        HtmlDoctypeNode node = new HtmlDoctypeNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitHtmlCommentItem(HTMLWithCSSParser.HtmlCommentItemContext ctx) {
        Token t = ctx.HTML_COMMENT().getSymbol();
        HtmlCommentNode node = new HtmlCommentNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitConditionalCommentItem(HTMLWithCSSParser.ConditionalCommentItemContext ctx) {
        Token t = ctx.HTML_CONDITIONAL_COMMENT().getSymbol();
        HtmlCommentNode node = new HtmlCommentNode("Conditional: " + ctx.getText(), t.getLine(), t.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitJinjaExprItem(HTMLWithCSSParser.JinjaExprItemContext ctx) {
        return safeVisit(ctx.jinjaExpression());
    }

    @Override
    public ASTNode visitJinjaBlockItem(HTMLWithCSSParser.JinjaBlockItemContext ctx) {
        return safeVisit(ctx.jinjaBlock());
    }

    @Override
    public ASTNode visitJinjaCommentItem(HTMLWithCSSParser.JinjaCommentItemContext ctx) {
        return safeVisit(ctx.jinjaComment());
    }

    @Override
    public ASTNode visitHtmlElementItem(HTMLWithCSSParser.HtmlElementItemContext ctx) {
        return safeVisit(ctx.htmlElement());
    }

    // paired tags (like <div></div>)
    @Override
    public ASTNode visitHtmlPairedTag(HTMLWithCSSParser.HtmlPairedTagContext ctx) {
        TerminalNode tagNode = ctx.TAG_NAME(0);
        String tag = tagNode.getText().toLowerCase();
        int line = tagNode.getSymbol().getLine();
        int column = tagNode.getSymbol().getCharPositionInLine();
        HtmlTagNode node = new HtmlTagNode(tag, line, column);

        for (HTMLWithCSSParser.HtmlAttributeContext attrCtx : ctx.htmlAttribute()) {
            HTMLWithCSSParser.AttrContext attr = (HTMLWithCSSParser.AttrContext) attrCtx;

            TerminalNode nameNode = attr.TAG_NAME();
            String name = nameNode.getText().toLowerCase();

            TerminalNode valueNode = attr.ATTVALUE_VALUE();
            int line1 = nameNode.getSymbol().getLine();
            int column1 = nameNode.getSymbol().getCharPositionInLine();

            String rawValue = valueNode != null ? stripQuotes(valueNode.getText()) : "";

            HtmlAttributeNode attrNode = new HtmlAttributeNode(name, "", line1, column1);

            if (rawValue.contains("{{")) {

                String[] parts = rawValue.split("(?=\\{\\{)|(?<=\\}\\})");

                for (String part : parts) {

                    part = part.trim();
                    if (part.isEmpty()) continue;

                    if (part.startsWith("{{") && part.endsWith("}}")) {

                        String inner = part.substring(2, part.length() - 2).trim();
                        ASTNode expr = parseJinjaExpression(inner, line1, column1);

                        attrNode.add(new JinjaExpressionNode(expr, line1, column1));

                    } else {
                        attrNode.add(new HtmlTextNode(part, line1, column1));
                    }
                }

            } else {
                attrNode.setValue(rawValue);
            }


            node.addAttribute(attrNode);
        }

        // Content
        if (ctx.htmlContent() != null) {
            ASTNode content = safeVisit(ctx.htmlContent());
            if (content instanceof DummyNode dummy) {
                dummy.getChildren().forEach(node::add);
            } else if (content != null) {
                node.add(content);
            }
        }
        return node;
    }

    // single tags (like <br/> <img/>)
    @Override
    public ASTNode visitHtmlVoidTag(HTMLWithCSSParser.HtmlVoidTagContext ctx) {
        TerminalNode tagNode = ctx.TAG_NAME();
        String tag = tagNode.getText().toLowerCase();
        int line = tagNode.getSymbol().getLine();
        int column = tagNode.getSymbol().getCharPositionInLine();
        HtmlTagNode node = new HtmlTagNode(tag, line, column);

        for (HTMLWithCSSParser.HtmlAttributeContext attrCtx : ctx.htmlAttribute()) {
            HTMLWithCSSParser.AttrContext attr = (HTMLWithCSSParser.AttrContext) attrCtx;

            TerminalNode nameNode = attr.TAG_NAME();
            String name = nameNode.getText().toLowerCase();

            TerminalNode valueNode = attr.ATTVALUE_VALUE();
            int line1 = nameNode.getSymbol().getLine();
            int column1 = nameNode.getSymbol().getCharPositionInLine();

            String rawValue = valueNode != null ? stripQuotes(valueNode.getText()) : "";

            HtmlAttributeNode attrNode = new HtmlAttributeNode(name, "", line1, column1);

            if (rawValue.contains("{{")) {
                String[] parts = rawValue.split("(?=\\{\\{)|(?<=\\}\\})");

                for (String part : parts) {
                    part = part.trim();
                    if (part.startsWith("{{") && part.endsWith("}}")) {
                        String inner = part.substring(2, part.length() - 2).trim();
                        ASTNode expr = parseJinjaExpression(inner, line1, column1);
                        attrNode.add(new JinjaExpressionNode(expr, line1, column1));
                    } else if (!part.isEmpty()) {
                        attrNode.add(new HtmlTextNode(part, line1, column1));
                    }
                }
            } else {
                attrNode.setValue(rawValue);
            }

            node.addAttribute(attrNode);
        }
        return node;
    }

    // <script>
    @Override
    public ASTNode visitScriptTag(HTMLWithCSSParser.ScriptTagContext ctx) {
        Token start = ctx.SCRIPT_OPEN().getSymbol();
        HtmlTagNode node = new HtmlTagNode("script", start.getLine(), start.getCharPositionInLine());
        String body = ctx.SCRIPT_BODY() != null ? ctx.SCRIPT_BODY().getText() : ctx.SCRIPT_SHORT_BODY().getText();
        node.add(new HtmlTextNode(body, start.getLine(), start.getCharPositionInLine()));
        return node;
    }

    // <style>
    @Override
    public ASTNode visitStyleTag(HTMLWithCSSParser.StyleTagContext ctx) {
        Token start = ctx.getStart();
        HtmlTagNode styleTag = new HtmlTagNode("style", start.getLine(), start.getCharPositionInLine());

        // The key change: use ctx.stylesheet() instead of ctx.style()
        if (ctx.stylesheet() != null) {
            ASTNode cssContent = safeVisit(ctx.stylesheet());
            if (cssContent instanceof CssDocumentNode cssDoc) {
                styleTag.add(cssDoc);
            } else if (cssContent != null) {
                System.err.println("Semantic Warning: Unexpected CSS content type: " + cssContent.getClass().getSimpleName());
                styleTag.add(cssContent);
            }
        } else {
            System.err.println("Warning: No stylesheet content inside <style> at line " + start.getLine());
        }

        return styleTag;
    }

    @Override
    public ASTNode visitStylesheet(HTMLWithCSSParser.StylesheetContext ctx) {
        CssDocumentNode doc = new CssDocumentNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());

        ctx.CDO().forEach(t -> doc.add(new HtmlTextNode(t.getText(), t.getSymbol().getLine(), t.getSymbol().getCharPositionInLine())));
        ctx.CDC().forEach(t -> doc.add(new HtmlTextNode(t.getText(), t.getSymbol().getLine(), t.getSymbol().getCharPositionInLine())));

        for (HTMLWithCSSParser.StatementContext stmt : ctx.statement()) {
            ASTNode node = safeVisit(stmt);

            if (node instanceof CssNode cssNode) {
                doc.addRule((CssRuleNode) cssNode);
            } else if (node != null) {
                doc.add(node);
            }
        }

        return doc;
    }

    @Override
    public ASTNode visitRuleset(HTMLWithCSSParser.RulesetContext ctx) {
        CssRuleNode rule = new CssRuleNode(ctx.start.getLine(), ctx.getStart().getCharPositionInLine());
        StringBuilder selectorText = new StringBuilder();
        if (ctx.combined_selector(0) != null && ctx.combined_selector(0).selector(0) != null && ctx.combined_selector(0).selector(0).selpart(0) != null)
            selectorText = new StringBuilder(ctx.combined_selector(0).selector(0).selpart(0).CLASSKEYWORD().getText());
        else
            selectorText = new StringBuilder(ctx.combined_selector(0).selector(0).getText());   //this will fix any selectors that don't have . like body
        // Selectors
        for (HTMLWithCSSParser.Combined_selectorContext selCtx : ctx.combined_selector()) {
            if (selCtx.selector(0) != null && selCtx.selector(0).selpart(0) != null && selCtx.selector(0).selpart(0).CLASSKEYWORD() != null) {
                for (int i = 1; i < selCtx.selector().size(); i++) {
                    if (selCtx.selector(i) != null)
                        selectorText.append(" ").append(selCtx.selector(i).getText());
                }
            }

            CssSelectorNode selectorNode = new CssSelectorNode(selectorText.toString(), selCtx.start.getLine(), selCtx.start.getCharPositionInLine());
            rule.addSelector(selectorNode);
        }

        // Declarations
        if (ctx.declarations() != null) {
            for (HTMLWithCSSParser.DeclarationContext declCtx : ctx.declarations().declaration()) {
                CssDeclarationNode decl = safeVisit(declCtx);
                if (decl != null) {
                    rule.addDeclaration(decl);
                }
            }
        }

        return rule;
    }

    private boolean needsSpace(
            StringBuilder sb,
            String next
    ) {

        if (sb.isEmpty()) return false;

        char last = sb.charAt(sb.length() - 1);

        if (last == '(' || last == '/' || last == ',') {
            return false;
        }

        if (next.equals(")") || next.equals(",")) {
            return false;
        }

        return true;
    }

    private String rebuildCssValue(
            HTMLWithCSSParser.TermsContext ctx
    ) {

        if (ctx == null) return "";

        StringBuilder sb = new StringBuilder();

        for (var child : ctx.children) {

            String text = child.getText();

            if (needsSpace(sb, text)) {
                sb.append(" ");
            }

            sb.append(text);
        }

        return sb.toString().trim();
    }

    public ASTNode visitDeclaration(HTMLWithCSSParser.DeclarationContext ctx) {
        String property = ctx.IDENT().getText();
        String value = rebuildCssValue(ctx.terms());
        boolean important = ctx.IMPORTANT() != null;

        CssDeclarationNode node = new CssDeclarationNode(property, value, important, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitMargin_rule(HTMLWithCSSParser.Margin_ruleContext ctx) {
        String area = ctx.MARGIN_AREA().getText();  // like @top-center
        int line = ctx.start.getLine();
        int column = ctx.start.getCharPositionInLine();

        CssMarginRuleNode marginRule = new CssMarginRuleNode(area.substring(1), line, column);  // this removes the @

        if (ctx.declarations() != null) {
            for (var declCtx : ctx.declarations().declaration()) {
                CssDeclarationNode decl = safeVisit(declCtx);
                if (decl != null) {
                    marginRule.addDeclaration(decl);
                }
            }
        }

        return marginRule;
    }

    @Override
    public ASTNode visitAtstatement(HTMLWithCSSParser.AtstatementContext ctx) {
        Token start = ctx.start;
        int line = start.getLine();
        int column = start.getCharPositionInLine();

        if (ctx.KEYFRAMES() != null) {
            String name = ctx.IDENT() != null ? ctx.IDENT().getText() : "anonymous";
            CssKeyframesNode kf = new CssKeyframesNode(name, line, column);
            for (var blockCtx : ctx.keyframe_block()) {
                CssKeyframeBlockNode block = safeVisit(blockCtx);
                kf.addBlock(block);
            }
            return kf;

        } else if (ctx.MEDIA() != null) {
            CssMediaRuleNode media = new CssMediaRuleNode(line, column);
            String query = ctx.media() != null ? ctx.media().getText() : "";
            media.addQuery(new CssMediaQueryNode(query, line, column));
            for (var ruleCtx : ctx.media_rule()) {
                ASTNode rule = safeVisit(ruleCtx);
                if (rule instanceof CssNode cssRule) {
                    media.addRule(cssRule);
                }
            }
            return media;

        } else if (ctx.FONTFACE() != null) {
            CssAtRuleNode fontFace = new CssAtRuleNode("font-face", "", line, column);

            if (ctx.declarations() != null) {
                for (var declCtx : ctx.declarations().declaration()) {
                    CssDeclarationNode decl = safeVisit(declCtx);
                    fontFace.addChild(decl);
                }
            }
            return fontFace;
        } else if (ctx.PAGE() != null) {
            String pseudo = ctx.pseudo() != null ? ctx.pseudo().getText() : "";
            CssAtRuleNode page = new CssAtRuleNode("page", pseudo, line, column);

            // Declarations
            if (ctx.declarations() != null) {
                for (var declCtx : ctx.declarations().declaration()) {
                    CssDeclarationNode decl = safeVisit(declCtx);
                    page.addChild(decl);
                }
            }

            for (var marginCtx : ctx.margin_rule()) {
                CssMarginRuleNode marginRule = safeVisit(marginCtx);
                page.addChild(marginRule);
            }
            return page;

        } else if (ctx.CHARSET() != null) {
            CssAtRuleNode node = new CssAtRuleNode("charset", ctx.STRING() != null ? ctx.STRING().getText() : "", line, column);
            return node;

        } else if (ctx.IMPORT() != null) {
            String value = "";
            if (ctx.STRING() != null) value = ctx.STRING().getText();
            else if (ctx.URI() != null) value = ctx.URI().getText();
            CssAtRuleNode node = new CssAtRuleNode("import", value, line, column);
            return node;

        }

        CssAtRuleNode node = new CssAtRuleNode(start.getText().substring(1).split("\\s")[0], ctx.getText(), line, column);
        return node;
    }

    public ASTNode visitTextData(HTMLWithCSSParser.TextDataContext ctx) {
        Token t = ctx.HTML_TEXT().getSymbol();
        HtmlTextNode node = new HtmlTextNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
        return node;
    }
    //    private ExpressionNode parseSimpleTerm(String term, int line, int column) {
//        term = term.trim();
//
//
//        if (term.startsWith("'") || term.startsWith("\"")) {
//            // String literal
//            StringLiteralNode node = new StringLiteralNode(stripQuotes(term), line, column);
//            return node;
//        }
//
//        if (term.matches("-?\\d+(\\.\\d+)?")) {
//            // number
//            try {
//                NumberLiteralNode node = new NumberLiteralNode(term, line, column);
//                return node;
//            } catch (NumberFormatException e) {
//                // fallback
//            }
//        }
//
//        if (term.equals("true") || term.equals("false")) {
//            BooleanLiteralNode node =new BooleanLiteralNode(Boolean.parseBoolean(term), line, column);
//            return node;
//        }
//
//        // default
//        IdentifierNode node =new IdentifierNode(term, line, column);
//        return node;
//    }

    @Override
    public ASTNode visitJinjaExpr(HTMLWithCSSParser.JinjaExprContext ctx) {

        Token openToken = ctx.JINJA_EXPR_OPEN().getSymbol();
        int line = openToken.getLine();
        int column = openToken.getCharPositionInLine();
        String content = ctx.JINJA_EXPR_CONTENT().getText().trim();
        ASTNode parsedExpr = parseJinjaExpression(content, line, column);

        return new JinjaExpressionNode(parsedExpr, line, column);
    }


    @Override
    public ASTNode visitJinjaBlockTag(HTMLWithCSSParser.JinjaBlockTagContext ctx) {
        Token t = ctx.JINJA_BLOCK_OPEN().getSymbol();
        String raw = ctx.JINJA_BLOCK_CONTENT().getText().trim();

        // ================= IF =================
        if (raw.startsWith("if ")) {

            String conditionText = raw.substring(3).trim();

            ASTNode condition = parseJinjaExpression(
                    conditionText,
                    t.getLine(),
                    t.getCharPositionInLine()
            );

            return JinjaBlockNode.ifBlock(
                    condition,
                    conditionText,
                    t.getLine(),
                    t.getCharPositionInLine()
            );
        }

        // ================= BLOCK =================

        if (raw.startsWith("block ")) {

            String name = raw.substring(6).trim();

            IdentifierNode blockName = new IdentifierNode(name, t.getLine(), t.getCharPositionInLine());

            return JinjaBlockNode.namedBlock(blockName, t.getLine(), t.getCharPositionInLine());
        }

        // ================= FOR =================
        if (raw.startsWith("for ")) {

            String expr = raw.substring(4).trim();

            int inIndex = expr.indexOf(" in ");

            if (inIndex == -1) {
                return null;
            }

            String left = expr.substring(0, inIndex).trim();
            String right = expr.substring(inIndex + 4).trim();

            ASTNode iterable =
                    parseJinjaExpression(
                            right,
                            t.getLine(),
                            t.getCharPositionInLine()
                    );

            ExpressionNode variable;

            if (left.contains(",")) {

                TupleExpressionNode tuple =
                        new TupleExpressionNode(
                                t.getLine(),
                                t.getCharPositionInLine()
                        );

                for (String part : left.split(",")) {

                    tuple.addElement(
                            new IdentifierNode(
                                    part.trim(),
                                    t.getLine(),
                                    t.getCharPositionInLine()
                            )
                    );
                }

                variable = tuple;
            } else {

                variable =
                        new IdentifierNode(
                                left,
                                t.getLine(),
                                t.getCharPositionInLine()
                        );
            }

            JinjaBlockNode node = JinjaBlockNode.forBlock(variable, iterable, expr, t.getLine(), t.getCharPositionInLine());

            node.setCondition(variable);

            return node;
        }

        // ================= WITH =================
        if (raw.startsWith("with ")) {

            String expr = raw.substring(5).trim();

            List<JinjaWithAssignmentNode> assignments = new ArrayList<>();

            for (String part : splitTopLevel(expr, ',')) {


                int eq = findTopLevelAssignment(part);

                if (eq == -1) continue;

                String name = part.substring(0, eq).trim();
                String value = part.substring(eq + 1).trim();

                assignments.add(
                        new JinjaWithAssignmentNode(
                                name,
                                (ExpressionNode) parseJinjaExpression(value, t.getLine(), t.getCharPositionInLine()),
                                t.getLine(),
                                t.getCharPositionInLine()
                        )
                );
            }

            return JinjaBlockNode.withBlock(assignments, t.getLine(), t.getCharPositionInLine());
        }
        // ================= ELSE =================

        if (raw.startsWith("else")) {
            return new JinjaElseNode(t.getLine(), t.getCharPositionInLine());
        }

        // ================= EXTENDS =================
        if (raw.startsWith("extends")) {

            String expr = raw.substring(8).trim();

            ASTNode template = parseJinjaExpression(expr, t.getLine(), t.getCharPositionInLine());

            return new JinjaExtendNode(template, expr, t.getLine(), t.getCharPositionInLine());
        }

        // ================= END =================
        if (raw.startsWith("end")) {
            return new JinjaEndNode(raw, t.getLine(), t.getCharPositionInLine());
        }

        // ================= UNKNOWN JINJA TAG =================
        addError(
                "Unknown Jinja tag: {% " + raw + " %}",
                t.getLine(),
                t.getCharPositionInLine()
        );

        IdentifierNode blockName = new IdentifierNode(raw, t.getLine(), t.getCharPositionInLine());

        return JinjaBlockNode.unknownBlock(blockName, t.getLine(), t.getCharPositionInLine());
    }

    @Override
    public ASTNode visitJinjaRawBlock(HTMLWithCSSParser.JinjaRawBlockContext ctx) {
        Token t = ctx.JINJA_RAW_OPEN().getSymbol();
        JinjaRawHtmlNode node = new JinjaRawHtmlNode(ctx.JINJA_RAW_CONTENT().getText(), t.getLine(), t.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitJinjaComm(HTMLWithCSSParser.JinjaCommContext ctx) {
        Token t = ctx.JINJA_COMMENT_OPEN().getSymbol();
        JinjaCommentNode node = new JinjaCommentNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
        return node;
    }

    @Override
    public ASTNode visitHtmlContentBlock(HTMLWithCSSParser.HtmlContentBlockContext ctx) {

        DummyNode root = new DummyNode(0, 0);
        Stack<JinjaBlockNode> stack = new Stack<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {

            ASTNode node = null;
            var child = ctx.getChild(i);

            if (child instanceof ParserRuleContext ruleCtx) {
                node = safeVisit(ruleCtx);
            } else if (child instanceof TerminalNode terminal) {
                int type = terminal.getSymbol().getType();
                if (type == HTMLWithCSSLexer.HTML_TEXT || type == HTMLWithCSSLexer.SEA_WS) {
                    String text = terminal.getText();
                    if (!text.trim().isEmpty() || text.contains("\n")) {
                        node = new HtmlTextNode(text, terminal.getSymbol().getLine(), terminal.getSymbol().getCharPositionInLine());
                    }
                }
            }

            if (node == null) continue;

            // === ELSE ===
            if (node instanceof JinjaElseNode) {
                if (!stack.isEmpty() && stack.peek().getJinjaType() == BlockType.IF) {
                    stack.peek().setElseBlock((JinjaElseNode) node);
                } else {
                    addError("'{% else %}' without matching '{% if %}'",
                            node.getLine(), node.getColumn());
                }
                continue;
            }

            // === END TAG ===
            if (node instanceof JinjaEndNode end) {
                if (stack.isEmpty()) {
                    addError("Unexpected '{% " + end.getRaw() + " %}' (no open block)",
                            end.getLine(), end.getColumn());
                } else {
                    JinjaBlockNode top = stack.pop();
                    if (!matches(top, end)) {
                        addError("Mismatched end tag: expected '{% end" +
                                        top.getJinjaType().name().toLowerCase() + " %}', got '{% " +
                                        end.getRaw() + " %}'",
                                end.getLine(), end.getColumn());
                        // Push back so outer blocks can still close
                        stack.push(top);
                    }
                }
                continue;
            }

            // === OPENING BLOCKS ===
            if (node instanceof JinjaBlockNode block) {

                switch (block.getJinjaType()) {
                    case IF, FOR, WITH, BLOCK -> {
                        attach(root, stack, block);
                        stack.push(block);
                    }
                    case UNKNOWN -> {
                        attach(root, stack, block);
                        // Don't push unknown blocks onto stack
                    }
                }
                continue;
            }

            attach(root, stack, node);
        }

        // === REPORT UNCLOSED BLOCKS ===
        while (!stack.isEmpty()) {
            JinjaBlockNode unclosed = stack.pop();
            String tag = unclosed.getJinjaType().name().toLowerCase();

            addError(
                    "Missing '{% end" + tag + " %}' for '{% " + tag + " %}' block opened at line " +
                            unclosed.getLine() + ", col " + unclosed.getColumn(),
                    unclosed.getLine(),
                    unclosed.getColumn()
            );
        }

        return root;
    }

    private String stripQuotes(String s) {
        if (s == null || s.length() < 2) return "";
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }

    private void attach(DummyNode root,
                        Stack<JinjaBlockNode> stack,
                        ASTNode node) {

        if (!stack.isEmpty()) {

            JinjaBlockNode parent = stack.peek();
            parent.add(node);

        } else {

            root.add(node);
        }
    }

    private boolean matches(JinjaBlockNode block, JinjaEndNode end) {
        String raw = end.getRaw().trim().toLowerCase();

        return switch (block.getJinjaType()) {
            case IF    -> raw.startsWith("endif") || raw.startsWith("end if");
            case FOR   -> raw.startsWith("endfor") || raw.startsWith("end for");
            case WITH  -> raw.startsWith("endwith") || raw.startsWith("end with");
            case BLOCK -> raw.startsWith("endblock") || raw.startsWith("end block");
            case UNKNOWN -> true; // don't complain about unknown
        };
    }

    private int findTopLevelAssignment(String expr) {
        int depth = 0;
        boolean inSingleQuote = false;
        boolean inDoubleQuote = false;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // toggle quotes
            if (c == '\'' && !inDoubleQuote) inSingleQuote = !inSingleQuote;
            else if (c == '"' && !inSingleQuote) inDoubleQuote = !inDoubleQuote;

            if (inSingleQuote || inDoubleQuote) continue;

            if (c == '(') depth++;
            else if (c == ')') depth--;

            if (c == '=' && depth == 0) {

                char prev = (i > 0) ? expr.charAt(i - 1) : '\0';
                char next = (i + 1 < expr.length()) ? expr.charAt(i + 1) : '\0';

                // skip ==, !=, <=, >=
                if (prev == '=' || prev == '!' || prev == '<' || prev == '>') continue;
                if (next == '=') continue;

                return i;
            }
        }

        return -1;
    }

    private int findMatchingParen(String s, int start) {
        int depth = 0;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') depth++;
            else if (c == ')') depth--;

            if (depth == 0) return i;
        }

        return -1;
    }

    private boolean isFunctionCall(String expr) {
        expr = expr.trim();

        int open = expr.indexOf('(');
        if (open <= 0) return false;

        if (!expr.endsWith(")")) return false;

        int close = findMatchingParen(expr, open);
        return close == expr.length() - 1;
    }

    private List<String> splitTopLevel(String text, char delimiter) {

        List<String> parts = new ArrayList<>();

        int depth = 0;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if (c == '(') depth++;
            else if (c == ')') depth--;

            if (c == delimiter && depth == 0) {
                parts.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        if (!current.isEmpty()) {
            parts.add(current.toString());
        }

        return parts;
    }

    private int findTopLevelDot(String expr) {

        int parenDepth = 0;
        boolean inSingleQuote = false;
        boolean inDoubleQuote = false;

        for (int i = 0; i < expr.length(); i++) {

            char c = expr.charAt(i);

            if (c == '\'' && !inDoubleQuote) {
                inSingleQuote = !inSingleQuote;
                continue;
            }

            if (c == '"' && !inSingleQuote) {
                inDoubleQuote = !inDoubleQuote;
                continue;
            }

            if (inSingleQuote || inDoubleQuote) {
                continue;
            }

            if (c == '(') {
                parenDepth++;
                continue;
            }

            if (c == ')') {
                parenDepth--;
                continue;
            }

            if (c == '.' && parenDepth == 0) {
                return i;
            }
        }

        return -1;
    }

    private List<ExpressionNode> parseArguments(String text, int line, int column) {

        List<ExpressionNode> args = new ArrayList<>();

        for (String part : splitTopLevel(text, ',')) {

            part = part.trim();
            if (part.isEmpty()) continue;

            int eq = findTopLevelAssignment(part);

            if (eq != -1) {

                String name = part.substring(0, eq).trim();
                String value = part.substring(eq + 1).trim();

                ExpressionNode valueNode =
                        (ExpressionNode) parseJinjaExpression(value, line, column);

                args.add(new KeywordArgumentNode(
                        name,
                        valueNode,
                        line,
                        column
                ));

            } else {

                ASTNode parsed = parseJinjaExpression(part, line, column);

                if (parsed instanceof ExpressionNode expr) {
                    args.add(expr);
                }
            }
        }

        return args;
    }

    private List<ExpressionNode> parseArguments(String text, int line, int column, boolean allowAssignment) {

        List<ExpressionNode> args = new ArrayList<>();

        for (String part : splitTopLevel(text, ',')) {

            part = part.trim();
            if (part.isEmpty()) continue;

            int eq = allowAssignment ? findTopLevelAssignment(part) : -1;

            if (eq != -1) {

                String name = part.substring(0, eq).trim();
                String value = part.substring(eq + 1).trim();

                ASTNode valueNode = parseJinjaExpression(value, line, column);

                if (valueNode instanceof ExpressionNode expr) {
                    args.add(new KeywordArgumentNode(name, expr, line, column));
                }

            } else {

                ASTNode parsed = parseJinjaExpression(part, line, column);

                if (parsed instanceof ExpressionNode expr) {
                    args.add(expr);
                }
            }
        }

        return args;
    }

    public ExpressionNode parseSimpleJinjaExpression(String rawExpr, int line, int column) {
        rawExpr = rawExpr.trim();

        // STRING
        if ((rawExpr.startsWith("'") && rawExpr.endsWith("'")) ||
                (rawExpr.startsWith("\"") && rawExpr.endsWith("\""))) {

            return new StringLiteralNode(stripQuotes(rawExpr), line, column);
        }

        // BOOLEAN (case-insensitive + Python-style)
        if (rawExpr.equalsIgnoreCase("True") || rawExpr.equalsIgnoreCase("False")) {
            return new BooleanLiteralNode(Boolean.parseBoolean(rawExpr.toLowerCase()), line, column);
        }

        // NUMBER
        if (rawExpr.matches("-?\\d+(\\.\\d+)?")) {
            return new NumberLiteralNode(rawExpr, line, column);
        }

        return new IdentifierNode(rawExpr, line, column);
    }

    private ASTNode parseJinjaExpression(String rawExpr, int line, int column) {
        rawExpr = rawExpr.trim();

        System.out.println("DEBUG parseJinjaExpression() → Input: '" + rawExpr + "'");

        // ================= ASSIGNMENT =================
        int assignIndex = findTopLevelAssignment(rawExpr);
        if (assignIndex != -1) {

            String left = stripQuotes(rawExpr.substring(0, assignIndex).trim());
            String right = rawExpr.substring(assignIndex + 1).trim();

            return new BinaryExpressionNode(
                    new IdentifierNode(left, line, column),
                    "=",
                    (ExpressionNode) parseJinjaExpression(right, line, column),
                    line,
                    column
            );
        }


        // ================= FILTER (PIPE) =================
        int pipeIndex = findLastTopLevelPipe(rawExpr);
        if (pipeIndex != -1) {
            String left = rawExpr.substring(0, pipeIndex).trim();
            String right = rawExpr.substring(pipeIndex + 1).trim();

            ExpressionNode leftExpr = (ExpressionNode) parseJinjaExpression(left, line, column);
            ExpressionNode rightExpr = (ExpressionNode) parseJinjaExpression(right, line, column);

            return new BinaryExpressionNode(leftExpr, "|", rightExpr, line, column);
        }


        // ================= DOT ACCESS =================
        int dot = findTopLevelDot(rawExpr);

        if (dot != -1) {

            String left = rawExpr.substring(0, dot).trim();
            String right = rawExpr.substring(dot + 1).trim();

            return new AttributeAccessNode(
                    (ExpressionNode) parseJinjaExpression(left, line, column),
                    right,
                    line,
                    column
            );
        }

        // ================= FUNCTION CALL =================
        if (isFunctionCall(rawExpr)) {

            int parenIndex = rawExpr.indexOf('(');
            String funcName = rawExpr.substring(0, parenIndex).trim();

            int closeIndex = findMatchingParen(rawExpr, parenIndex);
            if (closeIndex == -1) {
                return new IdentifierNode(rawExpr, line, column);
            }

            String argsText = rawExpr.substring(parenIndex + 1, closeIndex).trim();

            IdentifierNode callee = new IdentifierNode(funcName, line, column);

            List<ExpressionNode> args = new ArrayList<>();

            if (!argsText.isEmpty()) {
                List<ExpressionNode> parsedArgs = parseArguments(argsText, line, column);

                for (ExpressionNode arg : parsedArgs) {
                    if (arg != null) {
                        args.add(arg);
                    }
                }
            }

            return new CallExpressionNode(callee, args, line, column);

        }

        return parseSimpleJinjaExpression(rawExpr, line, column);
    }

    @Override
    public ASTNode visitTopLevelTextItem(HTMLWithCSSParser.TopLevelTextItemContext ctx) {
        return safeVisit(ctx.htmlChardata());
    }

    @Override
    public ASTNode visitWsData(HTMLWithCSSParser.WsDataContext ctx) {
        return safeVisit(ctx.SEA_WS()); // Or handle as HtmlTextNode
    }

    private int findLastTopLevelPipe(String expr) {
        int parenDepth = 0;
        boolean inSingleQuote = false;
        boolean inDoubleQuote = false;
        int lastPipe = -1;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == '\'' && !inDoubleQuote) {
                inSingleQuote = !inSingleQuote;
                continue;
            }
            if (c == '"' && !inSingleQuote) {
                inDoubleQuote = !inDoubleQuote;
                continue;
            }
            if (inSingleQuote || inDoubleQuote) continue;

            if (c == '(') {
                parenDepth++;
                continue;
            }
            if (c == ')') {
                parenDepth--;
                continue;
            }

            if (c == '|' && parenDepth == 0) {
                lastPipe = i;
            }
        }
        return lastPipe;
    }

    private void addError(String message, int line, int column) {
        errors.add(String.format(
                "Semantic Error at line %d, col %d: %s",
                line,
                column,
                message
        ));
    }

    public List<String> getErrors() {
        return errors;
    }


    private static class DummyNode extends ASTNode {
        DummyNode(int line, int column) {
            super("content-container", line, column);
        }


        @Override
        public <T> T accept(ASTVisitor<T> visitor) {
            return null;
        }

        @Override
        public <T> T accept(HtmlWithCssVisitor<T> visitor) {
            return null;
        }
    }
}