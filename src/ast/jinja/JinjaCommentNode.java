package ast.jinja;

import ast.core.ASTNode;
import visitors.JinjaVisitor;

public class JinjaCommentNode extends JinjaNode {
    private String comment;
    public JinjaCommentNode(String comment,  int line) {
        super("Css Comment Node", line);
        this.comment = comment;
    }
    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "JinjaCommentNode: " + comment;
    }

    public <T> T accept(JinjaVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
