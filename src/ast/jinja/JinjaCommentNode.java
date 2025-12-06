package ast.jinja;

import ast.core.ASTNode;

public class JinjaCommentNode extends ASTNode {
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
}
