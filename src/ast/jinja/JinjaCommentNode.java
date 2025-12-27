package ast.jinja;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaCommentNode extends JinjaNode {

    private String comment;

    public JinjaCommentNode(String comment,  int line, int column) {
        super("Jinja Comment Node", line, column);
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "JinjaCommentNode: " + comment;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return  visitor.visit(this); }
}
