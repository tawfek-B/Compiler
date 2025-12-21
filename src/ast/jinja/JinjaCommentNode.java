package ast.jinja;

import ast.HtmlWithCssVisitor;

public class JinjaCommentNode extends JinjaNode {

    private String comment;

    public JinjaCommentNode(String comment,  int line) {
        super("Jinja Comment Node", line);
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "JinjaCommentNode: " + comment;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
