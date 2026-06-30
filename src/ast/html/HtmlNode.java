package ast.html;

import ast.core.ASTNode;

public abstract class HtmlNode extends ASTNode {
    protected HtmlNode(String type, int line, int column) {
        super(type, line, column);
    }

    public void addChild(HtmlNode child) {
        this.children.add(child);
        child.setParent(this);
    }

}
