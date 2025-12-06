package ast.html;

import ast.core.ASTNode;

public class HtmlTextNode extends ASTNode {
    private String text;

    public HtmlTextNode(String text, int line) {
        super("Html Text Node", line);
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
