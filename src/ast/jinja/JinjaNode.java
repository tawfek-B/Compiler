package ast.jinja;

import ast.core.ASTNode;
import ast.html.HtmlNode;

public abstract class JinjaNode extends ASTNode {

    protected JinjaNode(String type, int line) {
        super(type, line);
    }

    public void addChild(JinjaNode child) {
        this.children.add(child);
    }
}
