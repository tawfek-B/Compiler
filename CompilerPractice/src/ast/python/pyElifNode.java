package ast.python;

import ast.ASTVisitor;
import ast.core.ASTNode;

public class pyElifNode extends ASTNode {
    public pyElifNode(int line){
        super("Elif",line);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
