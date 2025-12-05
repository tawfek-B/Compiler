package ast.jinja;

import ast.core.AstNode;

public class JinjaCommentNode extends AstNode {
    private String comment;
    public JinjaCommentNode(String comment) {
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
