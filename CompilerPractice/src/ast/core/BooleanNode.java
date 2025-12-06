package ast.core;

import ast.ASTVisitor;

public class BooleanNode extends ASTNode{
    public final boolean value;

    public BooleanNode(boolean value,int line){
        super("Boolean(" + value + ")" , line);
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
