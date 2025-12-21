package ast.html;

import ast.core.ASTNode;

public abstract class HtmlNode extends ASTNode {
    protected HtmlNode(String type, int line) {
        super(type, line);
    }

    public void addChild(HtmlNode child) {
        this.children.add(child);
    }

}
