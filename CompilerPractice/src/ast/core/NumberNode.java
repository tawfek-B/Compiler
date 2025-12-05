package ast.core;

public class NumberNode extends ASTNode{

    public final double value;

    public NumberNode(double value, int line){
        super("number(" + value + ")",line);
        this.value = value;

    }
}
