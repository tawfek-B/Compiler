package app;

import ast.core.AstNode;
import ast.html.*;
import ast.css.*;
import ast.jinja.*;

public class Main {

    public static void main(String[] args) {

        // HTML
        HtmlTextNode textNode = new HtmlTextNode("Hello, world!");
        HtmlAttributeNode classAttr = new HtmlAttributeNode("class", "title");
        HtmlTagNode divNode = new HtmlTagNode("div");
        divNode.addAttribute(classAttr);
        divNode.addChild(textNode);

        HtmlDocumentNode htmlDoc = new HtmlDocumentNode();
        htmlDoc.addChild(divNode);

        // CSS
        CssDeclarationNode decl1 = new CssDeclarationNode("color", "red", false);
        CssDeclarationNode decl2 = new CssDeclarationNode("font-size", "16px", true);

        CssSelectorNode selector = new CssSelectorNode(".title");
        selector.addChild(decl1);
        selector.addChild(decl2);

        CssRuleNode cssRule = new CssRuleNode();
        cssRule.addChild(selector);

        AstNode cssDoc = new AstNode() {
            @Override
            public String getName() { return "CssDocument"; }
        };
        cssDoc.addChild(cssRule);

        JinjaVarNode jinjaVar = new JinjaVarNode("user_name");

        String jinjaBody = "Welcome, {{ user_name}}! }}";

        JinjaIfNode jinjaIf = new JinjaIfNode("user_logged_in", jinjaBody);

        AstNode jinjaDoc = new AstNode() {
            @Override
            public String getName() { return "JinjaDocument"; }
        };
        jinjaDoc.addChild(jinjaIf);

        AstNode root = new AstNode() {
            @Override
            public String getName() { return "Root"; }
        };
        root.addChild(htmlDoc);
        root.addChild(cssDoc);
        root.addChild(jinjaDoc);

        printAst(root, 0);
    }

    private static void printAst(AstNode node, int indent) {
        String prefix = " ".repeat(indent * 2);

        String info = node.toString();
        System.out.println(prefix + node.getClass().getSimpleName());

        for (AstNode child : node.getChildren()) {
            printAst(child, indent + 1);
        }
    }
}