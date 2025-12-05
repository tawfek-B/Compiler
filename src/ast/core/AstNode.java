package ast.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AstNode {
    protected List<AstNode> children = new ArrayList<>();

    public List<AstNode> getChildren() {
        return children;
    }
    public void addChild(AstNode child) {
        children.add(child);
    }
    public String getName() {
        return "this.getName()";
    }
}
