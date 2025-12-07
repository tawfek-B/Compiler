package ast.html;

import ast.core.ASTNode;
import visitors.HtmlVisitor;

public class HtmlTextNode extends HtmlNode {
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

    public <T> T accept(HtmlVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
