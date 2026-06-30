package ast.jinja;

import ast.core.ASTNode;
import ast.html.HtmlNode;

public abstract class JinjaNode extends ASTNode {

    protected JinjaNode(String type, int line, int column) {
        super(type, line, column);
    }

    public void addChild(JinjaNode child) {
        this.children.add(child);
        child.setParent(this);
    }
}
