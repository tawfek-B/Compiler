package visitors;

import antlr.grammars.HTMLWithCSSLexer;
import antlr.grammars.HTMLWithCSSParser;
import antlr.grammars.HTMLWithCSSParserBaseVisitor;
import ast.core.*;
import ast.css.*;
import ast.html.*;
import ast.jinja.*;
import ast.python.AttributeAccessNode;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import table.LabelTable;
import table.SymbolTable;

import java.util.List;
import java.util.Stack;

public class HtmlWithCssVisitorClass extends HTMLWithCSSParserBaseVisitor<ASTNode> {


    // safe visit for all nodes
    @SuppressWarnings("Unchecked")
    private <T extends ASTNode> T safeVisit(org.antlr.v4.runtime.tree.ParseTree ctx){
        if(ctx == null) return null;
        ASTNode node = visit(ctx);

        if(node == null){
            System.out.println("Warning: visit returned null for: "+ ctx.getText());
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
                        attrNode.add(new JinjaExpressionNode(expr,line1,column1));
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
        HtmlTagNode node = new HtmlTagNode("script", start.getLine(),  start.getCharPositionInLine());
        String body = ctx.SCRIPT_BODY() != null ? ctx.SCRIPT_BODY().getText() : ctx.SCRIPT_SHORT_BODY().getText();
        node.add(new HtmlTextNode(body, start.getLine(),  start.getCharPositionInLine()));
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
                System.err.println("Warning: Unexpected CSS content type: " + cssContent.getClass().getSimpleName());
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
        if(ctx.combined_selector(0) != null && ctx.combined_selector(0).selector(0) != null && ctx.combined_selector(0).selector(0).selpart(0) != null)
             selectorText = new StringBuilder(ctx.combined_selector(0).selector(0).selpart(0).CLASSKEYWORD().getText());
        else
            selectorText = new StringBuilder(ctx.combined_selector(0).selector(0).getText());   //this will fix any selectors that don't have . like body
        // Selectors
        for (HTMLWithCSSParser.Combined_selectorContext selCtx : ctx.combined_selector()) {
            if(selCtx.selector(0) != null && selCtx.selector(0).selpart(0) != null && selCtx.selector(0).selpart(0).CLASSKEYWORD() != null) {
                for(int i = 1; i < selCtx.selector().size(); i++) {
                if(selCtx.selector(i) != null)
                    selectorText.append(" ").append(selCtx.selector(i).getText());
                }
            }

            CssSelectorNode selectorNode = new CssSelectorNode(selectorText.toString(), selCtx.start.getLine(),  selCtx.start.getCharPositionInLine());
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

    public ASTNode visitDeclaration(HTMLWithCSSParser.DeclarationContext ctx) {
        String property = ctx.IDENT().getText();
        String value = ctx.terms() != null ? ctx.terms().getText() : "";
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

        }else if (ctx.FONTFACE() != null) {
            CssAtRuleNode fontFace = new CssAtRuleNode("font-face", "", line, column);

            if (ctx.declarations() != null) {
                for (var declCtx : ctx.declarations().declaration()) {
                    CssDeclarationNode decl = safeVisit(declCtx);
                    fontFace.addChild(decl);
                }
            }
            return fontFace;
        }

        else if (ctx.PAGE() != null) {
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

    // === Jinja ===

    private ASTNode parseJinjaExpression(String rawExpr, int line, int column) {
        rawExpr = rawExpr.trim();

        if (rawExpr.contains(".")) {
            // product.name → AttributeAccess
            String[] parts = rawExpr.split("\\.");
            ExpressionNode current = new IdentifierNode(parts[0], line, column);

            for (int i = 1; i < parts.length; i++) {
                current = new AttributeAccessNode(current, parts[i], line, column);
            }
            return current;
        }

        if (rawExpr.contains("(")) {
            // Simple function call like url_for(...)
            return new IdentifierNode(rawExpr, line, column); // can be enhanced later
        }

        return new IdentifierNode(rawExpr, line, column);
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

        JinjaExpressionNode node = new JinjaExpressionNode(parsedExpr, line, column);
        return node;
    }


    @Override
    public ASTNode visitJinjaBlockTag(HTMLWithCSSParser.JinjaBlockTagContext ctx) {
        Token t = ctx.JINJA_BLOCK_OPEN().getSymbol();
        String rawContent = ctx.JINJA_BLOCK_CONTENT().getText().trim();

        String blockName;

        if (rawContent.startsWith("if ")) {
            blockName = "if";
        }
        else if (rawContent.startsWith("for ")) {
            blockName = "for";
        }
        else if (rawContent.startsWith("with ")) {
            blockName = "with";
        }
        else if (rawContent.startsWith("block ")) {
            String after = rawContent.substring(6).trim();
            int space = after.indexOf(' ');
            String name = (space != -1) ? after.substring(0, space) : after;
            blockName = "block:" + name;
        }
        else if (rawContent.equals("else")) {
            blockName = "else";
        }
        else if (rawContent.startsWith("endif")) {
            blockName = "endif";
        }
        else if (rawContent.startsWith("endfor")) {
            blockName = "endfor";
        }
        else if (rawContent.startsWith("endwith")) {
            blockName = "endwith";
        }
        else if (rawContent.startsWith("endblock")) {
            blockName = "endblock";
        }
        else {
            blockName = "unknown";
        }

        return new JinjaBlockNode(blockName, t.getLine(), t.getCharPositionInLine());
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
            var child = ctx.getChild(i);
            ASTNode node = null;

            if (child instanceof ParserRuleContext ruleCtx) {
                node = safeVisit(ruleCtx);
            }
            else if (child instanceof TerminalNode terminal) {
                int type = terminal.getSymbol().getType();
                if (type == HTMLWithCSSLexer.HTML_TEXT || type == HTMLWithCSSLexer.SEA_WS) {
                    String text = terminal.getText();
                    if (!text.trim().isEmpty() || text.contains("\n")) {
                        node = new HtmlTextNode(
                                text,
                                terminal.getSymbol().getLine(),
                                terminal.getSymbol().getCharPositionInLine()
                        );
                    }
                }
            }

            if (node == null) continue;

            // === JINJA BLOCK LOGIC ===
            if (node instanceof JinjaBlockNode jinjaNode) {
                String name = jinjaNode.getName();

                // END blocks
                if (name.startsWith("end")) {
                    if (!stack.isEmpty()) {
                        JinjaBlockNode completed = stack.pop();

                        if (stack.isEmpty()) {
                            root.add(completed);
                        } else {
                            stack.peek().add(completed);
                        }
                    }
                    continue;
                }

                // ELSE block
                if (name.equals("else")) {
                    if (!stack.isEmpty()) {
                        stack.peek().add(jinjaNode);
                        stack.push(jinjaNode);
                    }
                    continue;
                }

                // START block
                stack.push(jinjaNode);
                continue;
            }

            // NORMAL NODE
            if (stack.isEmpty()) {
                root.add(node);
            } else {
                stack.peek().add(node);
            }
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