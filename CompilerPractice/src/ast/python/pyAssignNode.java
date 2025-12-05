package ast.python;

import ast.core.ASTNode;

public class pyAssignNode extends ASTNode {
    public final String name;

    public pyAssignNode(String name, int line) {
        super("Assignment(" + name + ")", line);
        this.name = name;
    }
}
