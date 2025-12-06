package ast.html;

import ast.core.ASTNode;

public class HtmlCommentNode extends ASTNode {
    private String comment;

    public HtmlCommentNode(String comment,  int line) {
        super("Css Comment Node", line);
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
