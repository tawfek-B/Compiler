package ast.html;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class HtmlCommentNode extends HtmlNode {

    private String comment;

    public HtmlCommentNode(String comment,  int line, int column) {
        super("Html Comment Node", line, column);
        this.comment = comment;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "HtmlCommentNode: " + comment;
    }

}
