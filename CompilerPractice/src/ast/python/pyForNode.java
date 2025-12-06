package ast.python;

import ast.ASTVisitor;
import ast.core.ASTNode;

public class pyForNode extends ASTNode {
    public pyForNode(int line){
        super("For",line);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
