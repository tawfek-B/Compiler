package ast.core;

public class ReturnNode extends StatementNode {

    private final ExpressionNode expression;

    public ReturnNode(ExpressionNode expression, int line, int column) {
        super(line, column);
        this.expression = expression;
        add(expression);
    }



    public ExpressionNode getExpression() {
        return expression;
    }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);

    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this.getExpression());

    }

    public ASTNode setValue(ASTNode value) {
        return value;
    }
}
