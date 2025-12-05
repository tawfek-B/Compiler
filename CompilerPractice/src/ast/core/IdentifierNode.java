package ast.core;

public class IdentifierNode extends ASTNode{
    public final String name;

    public IdentifierNode(String name,int line){
        super("Identifier(" + name + ")" , line);
        this.name = name;
    }
}
