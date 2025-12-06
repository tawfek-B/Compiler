package ast.python;

import ast.ASTVisitor;
import ast.core.ASTNode;

public class pyIfNode extends ASTNode {
    public pyIfNode(int line){
        super("If",line);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
