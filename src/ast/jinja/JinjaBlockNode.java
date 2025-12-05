package ast.jinja;

import ast.core.AstNode;

public class JinjaBlockNode extends AstNode {
    private String name;
    public JinjaBlockNode(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
