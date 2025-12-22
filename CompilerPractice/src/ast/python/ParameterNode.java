package ast.python;

import ast.core.ASTVisitor;
import ast.core.ASTNode;

public class ParameterNode extends ASTNode {

    private final String name;

    public ParameterNode(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
