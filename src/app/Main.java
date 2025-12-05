package app;

import ast.core.AstNode;
import ast.html.*;
import ast.css.*;
import ast.jinja.*;

public class Main {
    public static void main(String[] args) {

        HtmlDocumentNode htmlDoc = new HtmlDocumentNode();

        //HTML
        HtmlTagNode htmlTag = new HtmlTagNode("html");
        HtmlTagNode headTag = new HtmlTagNode("head");
        HtmlTagNode bodyTag = new HtmlTagNode("body");

        HtmlTextNode titleText = new HtmlTextNode("Test");
        HtmlTagNode titleTag = new HtmlTagNode("title");
        titleTag.addChild(titleText);

        headTag.addChild(titleTag);

        HtmlAttributeNode bodyAttr = new HtmlAttributeNode("style", "margin:0; padding:20px;");
        bodyTag.addAttribute(bodyAttr);

        HtmlTextNode bodyText = new HtmlTextNode("This is an html text");
        HtmlTagNode divTag = new HtmlTagNode("div");
        divTag.addChild(bodyText);
        bodyTag.addChild(divTag);

        htmlTag.addChild(headTag);
        htmlTag.addChild(bodyTag);
        htmlDoc.addChild(htmlTag);

        System.out.println("HTML");
        printAst(htmlDoc, 0);

        //CSS
        CssDocumentNode cssDoc = new CssDocumentNode();

        CssSelectorNode selector = new CssSelectorNode(".box");
        selector.addDeclaration(new CssDeclarationNode("width", "100px", true));
        selector.addDeclaration(new CssDeclarationNode("height", "200px", false));
        selector.addDeclaration(new CssDeclarationNode("background", "#ff0000", true));

        cssDoc.addChild(selector);

        System.out.println("\nCSS");
        printAst(cssDoc, 0);

        //Jinja
        JinjaDocumentNode jinjaDoc = new JinjaDocumentNode();

        JinjaIfNode ifNode = new JinjaIfNode("user.is_admin", "Show admin panel");
        JinjaForNode forNode = new JinjaForNode("item", "items", "Render item");

        JinjaVarNode varNode = new JinjaVarNode("username");
        JinjaExpressionNode exprNode = new JinjaExpressionNode("user.age + 1");

        jinjaDoc.addChild(ifNode);
        jinjaDoc.addChild(forNode);
        jinjaDoc.addChild(varNode);
        jinjaDoc.addChild(exprNode);

        System.out.println("\nJinja");
        printAst(jinjaDoc, 0);
    }

    public static void printAst(AstNode node, int indent) {
        String prefix = "  ".repeat(indent);
        System.out.println(prefix + node);

        for (AstNode child : node.getChildren()) {
            printAst(child, indent + 1);
        }
    }
}