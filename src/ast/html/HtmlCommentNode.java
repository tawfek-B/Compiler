package ast.html;

import ast.HtmlWithCssVisitor;

public class HtmlCommentNode extends HtmlNode {

    private String comment;

    public HtmlCommentNode(String comment,  int line) {
        super("Html Comment Node", line);
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "HtmlCommentNode: " + comment;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
