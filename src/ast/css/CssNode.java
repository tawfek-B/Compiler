package ast.css;

import ast.core.ASTNode;
import ast.html.HtmlNode;

import java.util.ArrayList;
import java.util.List;

public abstract class CssNode extends ASTNode {

    List<ASTNode> children = new ArrayList<ASTNode>();

    protected CssNode(String type, int line,int column) {
        super(type, line, column);
    }

    public void addChild(CssNode child) {
        this.children.add(child);
        child.setParent(this);
    }

    public List<ASTNode> getChildren() {
        return children;
    }
}
