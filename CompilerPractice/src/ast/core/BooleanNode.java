package ast.core;

public class BooleanNode extends ASTNode{
    public final boolean value;

    public BooleanNode(boolean value,int line){
        super("Boolean(" + value + ")" , line);
        this.value = value;
    }
}
