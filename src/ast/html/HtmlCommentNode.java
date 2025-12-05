package ast.html;

import ast.core.AstNode;

public class HtmlCommentNode extends AstNode {
    private String comment;

    public HtmlCommentNode(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "HtmlCommentNode: " + comment;
    }

}
