package ast.core;

import ast.ASTVisitor;

public class IdentifierNode extends ASTNode{
    public final String name;

    public IdentifierNode(String name,int line){
        super("Identifier(" + name + ")" , line);
        this.name = name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
