package ast.python;

import ast.ASTVisitor;
import ast.core.ASTNode;

public class pyElseNode extends ASTNode {
    public pyElseNode(int line){
        super("Else",line);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
