package ast.jinja;

import ast.core.ASTNode;

public class JinjaBlockNode extends ASTNode {
    private String name;
    public JinjaBlockNode(String name, int line) {
        super("Jinja Block Node", line);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JinjaBlockNode: " + name;
    }

}
