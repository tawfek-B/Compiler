package ast.core;

public class UnaryNode extends ASTNode {
    public final String operator; // "-", "not"
    public ASTNode expression;

    public UnaryNode(String operator, ASTNode expression, int line) {
        super("UnaryOperation(" + operator + ")", line);
        this.operator = operator;
        this.expression = expression;
        add(expression);
    }
}
