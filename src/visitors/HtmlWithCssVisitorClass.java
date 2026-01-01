package visitors;

import antlr.grammars.HTMLWithCSSLexer;
import antlr.grammars.HTMLWithCSSParser;
import antlr.grammars.HTMLWithCSSParserBaseVisitor;
import ast.core.*;
import ast.css.*;
import ast.html.*;
import ast.jinja.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import table.LabelTable;
import table.SymbolTable;

import java.util.List;

public class HtmlWithCssVisitorClass extends HTMLWithCSSParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitHtmlDocument(HTMLWithCSSParser.HtmlDocumentContext ctx) {
        HtmlDocumentNode root = new HtmlDocumentNode(1, 0);
        ctx.documentItem().forEach(item -> {
            ASTNode node = item.accept(this);
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
        return new HtmlTextNode(text, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitScriptletItem(HTMLWithCSSParser.ScriptletItemContext ctx) {
        Token t = ctx.SCRIPTLET().getSymbol();
        return new HtmlTextNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
    }

    @Override
    public ASTNode visitXmlItem(HTMLWithCSSParser.XmlItemContext ctx) {
        Token t = ctx.XML().getSymbol();
        return new HtmlTextNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
    }

    @Override
    public ASTNode visitDtdItem(HTMLWithCSSParser.DtdItemContext ctx) {
        Token t = ctx.DTD().getSymbol();
        return new HtmlDoctypeNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
    }

    @Override
    public ASTNode visitHtmlCommentItem(HTMLWithCSSParser.HtmlCommentItemContext ctx) {
        Token t = ctx.HTML_COMMENT().getSymbol();
        return new HtmlCommentNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
    }

    @Override
    public ASTNode visitConditionalCommentItem(HTMLWithCSSParser.ConditionalCommentItemContext ctx) {
        Token t = ctx.HTML_CONDITIONAL_COMMENT().getSymbol();
        return new HtmlCommentNode("Conditional: " + ctx.getText(), t.getLine(), t.getCharPositionInLine());
    }

    @Override
    public ASTNode visitJinjaExprItem(HTMLWithCSSParser.JinjaExprItemContext ctx) {
        return ctx.jinjaExpression().accept(this);
    }

    @Override
    public ASTNode visitJinjaBlockItem(HTMLWithCSSParser.JinjaBlockItemContext ctx) {
        return ctx.jinjaBlock().accept(this);
    }

    @Override
    public ASTNode visitJinjaCommentItem(HTMLWithCSSParser.JinjaCommentItemContext ctx) {
        return ctx.jinjaComment().accept(this);
    }

    @Override
    public ASTNode visitHtmlElementItem(HTMLWithCSSParser.HtmlElementItemContext ctx) {
        return ctx.htmlElement().accept(this);
    }

    // paired tags (like <div></div>)
    @Override
    public ASTNode visitHtmlPairedTag(HTMLWithCSSParser.HtmlPairedTagContext ctx) {
        TerminalNode tagNode = ctx.TAG_NAME(0);
        String tag = tagNode.getText().toLowerCase();
        int line = tagNode.getSymbol().getLine();
        int column = tagNode.getSymbol().getCharPositionInLine();
        HtmlTagNode node = new HtmlTagNode(tag, line, column);

        // Attributes
        for (HTMLWithCSSParser.HtmlAttributeContext attrCtx : ctx.htmlAttribute()) {
            HTMLWithCSSParser.AttrContext attr = (HTMLWithCSSParser.AttrContext) attrCtx;
            TerminalNode nameNode = attr.TAG_NAME();
            String name = nameNode.getText().toLowerCase();
            TerminalNode valueNode = attr.ATTVALUE_VALUE();
            String value = valueNode != null ? stripQuotes(valueNode.getText()) : "";
            node.addAttribute(new HtmlAttributeNode(name, value, line, column));
        }

        // Content
        if (ctx.htmlContent() != null) {
            ASTNode content = ctx.htmlContent().accept(this);
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
            String value = valueNode != null ? stripQuotes(valueNode.getText()) : "";
            node.addAttribute(new HtmlAttributeNode(name, value, line, column));
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
            ASTNode cssContent = ctx.stylesheet().accept(this);
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
            ASTNode node = stmt.accept(this);

            if (node instanceof CssRuleNode cssNode) {
                doc.addRule(cssNode);
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
                CssDeclarationNode decl = (CssDeclarationNode) declCtx.accept(this);
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

        return new CssDeclarationNode(property, value, important, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitMargin_rule(HTMLWithCSSParser.Margin_ruleContext ctx) {
        String area = ctx.MARGIN_AREA().getText();  // like @top-center
        int line = ctx.start.getLine();
        int column = ctx.start.getCharPositionInLine();

        CssMarginRuleNode marginRule = new CssMarginRuleNode(area.substring(1), line, column);  // this removes the @

        if (ctx.declarations() != null) {
            for (var declCtx : ctx.declarations().declaration()) {
                CssDeclarationNode decl = (CssDeclarationNode) declCtx.accept(this);
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
                CssKeyframeBlockNode block = (CssKeyframeBlockNode) blockCtx.accept(this);
                kf.addBlock(block);
            }
            return kf;

        } else if (ctx.MEDIA() != null) {
            CssMediaRuleNode media = new CssMediaRuleNode(line, column);
            String query = ctx.media() != null ? ctx.media().getText() : "";
            media.addQuery(new CssMediaQueryNode(query, line, column));
            for (var ruleCtx : ctx.media_rule()) {
                ASTNode rule = ruleCtx.accept(this);
                if (rule instanceof CssNode cssRule) {
                    media.addRule(cssRule);
                }
            }
            return media;

        }else if (ctx.FONTFACE() != null) {
            CssAtRuleNode fontFace = new CssAtRuleNode("font-face", "", line, column);

            if (ctx.declarations() != null) {
                for (var declCtx : ctx.declarations().declaration()) {
                    CssDeclarationNode decl = (CssDeclarationNode) declCtx.accept(this);
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
                    CssDeclarationNode decl = (CssDeclarationNode) declCtx.accept(this);
                    page.addChild(decl);
                }
            }

            for (var marginCtx : ctx.margin_rule()) {
                CssMarginRuleNode marginRule = (CssMarginRuleNode) marginCtx.accept(this);
                page.addChild(marginRule);
            }
            return page;

        } else if (ctx.CHARSET() != null) {
            return new CssAtRuleNode("charset", ctx.STRING() != null ? ctx.STRING().getText() : "", line, column);

        } else if (ctx.IMPORT() != null) {
            String value = "";
            if (ctx.STRING() != null) value = ctx.STRING().getText();
            else if (ctx.URI() != null) value = ctx.URI().getText();
            return new CssAtRuleNode("import", value, line, column);

        }

        return new CssAtRuleNode(start.getText().substring(1).split("\\s")[0], ctx.getText(), line, column);
    }

    public ASTNode visitTextData(HTMLWithCSSParser.TextDataContext ctx) {
        Token t = ctx.HTML_TEXT().getSymbol();
        return new HtmlTextNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
    }

    // === Jinja ===

    private ASTNode parseJinjaExpression(String rawExpr, int line, int column) {
        // example: "user.name + 'hello' > 5" or "products|length > 0" or "item.price"
        rawExpr = rawExpr.trim();


        if (rawExpr.contains(" + ")) {
            String[] parts = rawExpr.split("\\s*\\+\\s*", 2);
            ExpressionNode left = parseSimpleTerm(parts[0], line, column);
            ExpressionNode right = parseSimpleTerm(parts[1], line, column);
            return new BinaryExpressionNode(left, "+", right, line, column);
        }

        if (rawExpr.contains(" > ")) {
            String[] parts = rawExpr.split("\\s*>\\s*", 2);
            ExpressionNode left = parseSimpleTerm(parts[0], line, column);
            ExpressionNode right = parseSimpleTerm(parts[1], line, column);
            return new BinaryExpressionNode(left, ">", right, line, column);
        }

        // user.name
//        if (rawExpr.contains(".")) {
//            System.out.println("LOL");
//            System.out.println(rawExpr);
//            String[] parts = rawExpr.split("\\.", 2);
//            ExpressionNode left = parseSimpleTerm(parts[0], line, column);
//            ExpressionNode right = new IdentifierNode(parts[1], line, column);
//            return new BinaryExpressionNode(left, ".", right, line, column);
//        }
        if(rawExpr.contains(".")) {
            return new IdentifierNode(rawExpr, line, column);
        }

        // identifiers, strings, numbers
        return parseSimpleTerm(rawExpr, line, column);
    }

    private ExpressionNode parseSimpleTerm(String term, int line, int column) {
        term = term.trim();


        if (term.startsWith("'") || term.startsWith("\"")) {
            // String literal
            return new StringLiteralNode(stripQuotes(term), line, column);
        }

        if (term.matches("-?\\d+(\\.\\d+)?")) {
            // number
            try {
                return new NumberLiteralNode(term, line, column);
            } catch (NumberFormatException e) {
                // fallback
            }
        }

        if (term.equals("true") || term.equals("false")) {
            return new BooleanLiteralNode(Boolean.parseBoolean(term), line, column);
        }

        // default
        return new IdentifierNode(term, line, column);
    }

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
        String rawContent = ctx.JINJA_BLOCK_CONTENT().getText().trim();

        String blockName = "anonymous";
        // Handle common cases: "block title", "block content", "extends base.html", etc.
        if (rawContent.startsWith("block ")) {
            String after = rawContent.substring(6).trim();
            int space = after.indexOf(' ');
            blockName = (space != -1) ? after.substring(0, space).trim() : after.trim();
        } else if (rawContent.startsWith("extends ")) {
            blockName = "extends_" + rawContent.substring(8).trim().replace("\"", "").replace(".html", "");
        } else if (rawContent.startsWith("for ")) {
            blockName = "function_for_" + rawContent.substring(4).trim().replace("\"", "").replace(".html", "").replace(" ", "_");
        } else if (rawContent.equals("else")) {
            blockName = "function_else" + rawContent.substring(4).trim().replace("\"", "").replace(".html", "");
        } else if (rawContent.startsWith("if ")) {
            blockName =  "function_if_" + rawContent.substring(3).trim().replace("\"", "").replace(".html", "");
        } else if(rawContent.startsWith("with ")) {
            blockName = "function_with_" + rawContent.substring(5).trim().replace("\"", "").replace(".html", "").replace(" ", "_");
        } else if(rawContent.startsWith("endblock") || rawContent.startsWith("endfor") || rawContent.startsWith("endif") || rawContent.startsWith("endwith")) {
            blockName = "end";
        }

        JinjaBlockNode node = new JinjaBlockNode(blockName, t.getLine(), t.getCharPositionInLine());

        return node;
    }

    @Override
    public ASTNode visitJinjaRawBlock(HTMLWithCSSParser.JinjaRawBlockContext ctx) {
        Token t = ctx.JINJA_RAW_OPEN().getSymbol();
        return new JinjaRawHtmlNode(ctx.JINJA_RAW_CONTENT().getText(), t.getLine(), t.getCharPositionInLine());
    }

    @Override
    public ASTNode visitJinjaComm(HTMLWithCSSParser.JinjaCommContext ctx) {
        Token t = ctx.JINJA_COMMENT_OPEN().getSymbol();
        return new JinjaCommentNode(ctx.getText(), t.getLine(), t.getCharPositionInLine());
    }

    // inside tags (text, elements, jinja.... etc)
    @Override
    public ASTNode visitHtmlContentBlock(HTMLWithCSSParser.HtmlContentBlockContext ctx) {
        DummyNode container = new DummyNode(0, 0);
        for (int i = 0; i < ctx.getChildCount(); i++) {
            var child = ctx.getChild(i);
            if (child instanceof ParserRuleContext ruleCtx) {
                ASTNode node = ruleCtx.accept(this);
                if (node != null) container.add(node);
            } else if (child instanceof TerminalNode terminal) {
                int type = terminal.getSymbol().getType();
                if (type == HTMLWithCSSLexer.HTML_TEXT || type == HTMLWithCSSLexer.SEA_WS) {
                    String text = terminal.getText();
                    if (!text.trim().isEmpty() || text.contains("\n")) {
                        container.add(new HtmlTextNode(text, terminal.getSymbol().getLine(), terminal.getSymbol().getCharPositionInLine()));
                    }
                }
            }
        }
        return container;
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