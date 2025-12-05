package ast.jinja;

import ast.core.AstNode;

public class JinjaVarNode extends AstNode {
    private String name;
    public JinjaVarNode(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
