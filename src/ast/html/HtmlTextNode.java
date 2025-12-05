package ast.html;

import ast.core.AstNode;

public class HtmlTextNode extends AstNode {
    private String text;

    public HtmlTextNode(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "HtmlTextNode: \"" + text + "\"";
    }
}
