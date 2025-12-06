package ast.core;

import ast.ASTVisitor;

public class ProgramNode extends ASTNode{
    public ProgramNode(int line){
        super("program" , line);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
