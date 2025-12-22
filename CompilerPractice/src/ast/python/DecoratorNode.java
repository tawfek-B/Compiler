package ast.python;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;

public class DecoratorNode extends ExpressionNode {

    private final ExpressionNode expression;

    public DecoratorNode(ExpressionNode expression, int line, int column) {
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
}
