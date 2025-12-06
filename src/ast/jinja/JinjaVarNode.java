package ast.jinja;

import ast.core.ASTNode;

public class JinjaVarNode extends ASTNode {
    private String name;
    public JinjaVarNode(String name, int line) {
        super("Css Var Node", line);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JinjaVarNode: " + name;
    }

}
