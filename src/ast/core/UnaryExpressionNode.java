package ast.core;

public class UnaryExpressionNode extends ExpressionNode {

    private final String operator;
    private final ExpressionNode operand;

    public UnaryExpressionNode(
            String operator,
            ExpressionNode operand,
            int line,
            int column
    ) {
        super(line, column);
        this.operator = operator;
        this.operand = operand;

        add(operand);
    }

    public String getOperator() {
        return operator;
    }

    public ExpressionNode getOperand() {
        return operand;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);

    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);

    }
}
