package app;
import ast.core.ASTNode;
import ast.html.*;
import ast.css.*;
import ast.jinja.*;

public class Main {
    public static void main(String[] args) {
        // HTML
        HtmlDocumentNode htmlDoc = new HtmlDocumentNode(1);

        HtmlTagNode htmlTag = new HtmlTagNode("html", 1);
        htmlDoc.addChild(htmlTag);

        HtmlTagNode headTag = new HtmlTagNode("head", 2);
        htmlTag.addChild(headTag);
        HtmlTagNode titleTag = new HtmlTagNode("title", 3);
        headTag.addChild(titleTag);
        titleTag.addChild(new HtmlTextNode("HTML + CSS Grammar Test", 4));

        HtmlTagNode bodyTag = new HtmlTagNode("body", 5);
        htmlTag.addChild(bodyTag);
        bodyTag.addChild(new HtmlAttributeNode("style", "margin:0; padding:20px;", 5));
        HtmlTagNode divTag = new HtmlTagNode("div", 6);
        bodyTag.addChild(divTag);
        divTag.addChild(new HtmlTextNode("This div uses inline style and CSS animation", 7));

        // CSS
        CssDocumentNode cssDoc = new CssDocumentNode(10);

        CssSelectorNode boxSelector = new CssSelectorNode(".box", 11);
        boxSelector.addDeclaration(new CssDeclarationNode("width", "100px", true, 12));
        boxSelector.addDeclaration(new CssDeclarationNode("height", "200px", true, 13));
        boxSelector.addDeclaration(new CssDeclarationNode("background", "#ff0000", false, 14));
        cssDoc.addChild(boxSelector);

        // @keyframes
        CssKeyframesNode slideinKeyframes = new CssKeyframesNode("slidein", 15);
        CssKeyframeBlockNode fromBlock = new CssKeyframeBlockNode(16);
        fromBlock.addDeclaration(new CssKeyframeDeclarationNode("transform", "translateX(-100%)", true, 16));
        CssKeyframeBlockNode fiftyBlock = new CssKeyframeBlockNode(17);
        fiftyBlock.addDeclaration(new CssKeyframeDeclarationNode("opacity", "0.5", false, 17));
        CssKeyframeBlockNode toBlock = new CssKeyframeBlockNode(18);
        toBlock.addDeclaration(new CssKeyframeDeclarationNode("transform", "translateX(0)", false, 18));
        slideinKeyframes.addBlock(fromBlock);
        slideinKeyframes.addBlock(fiftyBlock);
        slideinKeyframes.addBlock(toBlock);
        cssDoc.addChild(slideinKeyframes);

        CssSelectorNode bodySelector = new CssSelectorNode("body", 10);
        bodySelector.addDeclaration(new CssDeclarationNode("background", "white", true, 11));

        CssRuleNode bodyRule = new CssRuleNode(10);
        bodyRule.addSelector(bodySelector);
        CssMediaQueryNode mediaQuery = new CssMediaQueryNode("screen and (min-width: 600px)", 9);
        mediaQuery.addRule(bodyRule);

        cssDoc.addChild(mediaQuery);

        // Jinja2
        JinjaDocumentNode jinjaDoc = new JinjaDocumentNode(30);
        jinjaDoc.addChild(new JinjaIfNode("user.is_admin", "Show admin panel", 31));
        jinjaDoc.addChild(new JinjaForNode("item", "items", "Render item", 32));
        jinjaDoc.addChild(new JinjaVarNode("username", 33));
        jinjaDoc.addChild(new JinjaExpressionNode("user.age + 1", 34));

        System.out.println("\n__________HTML AST__________");
        printAst(htmlDoc, 0);

        System.out.println("\n__________CSS AST__________");
        printAst(cssDoc, 0);

        System.out.println("\n__________Jinja2 AST__________");
        printAst(jinjaDoc, 0);
    }
    public static void printAst(ASTNode node, int indent) {
        String prefix = "  ".repeat(indent);
        System.out.println(prefix + node);

        for (ASTNode child : node.getChildren()) {
            printAst(child, indent + 1);
        }
    }
}