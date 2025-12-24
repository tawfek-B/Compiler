package ast.python;

import ast.core.*;

public class ListComprehensionNode extends ExpressionNode {

    private final ExpressionNode expression;
    private final IdentifierNode variable;
    private final ExpressionNode iterable;

    public ListComprehensionNode(
            ExpressionNode expression,
            IdentifierNode variable,
            ExpressionNode iterable,
            int line,
            int column
    ) {
        super(line, column);
        this.expression = expression;
        this.variable = variable;
        this.iterable = iterable;

        add(expression);
        add(variable);
        add(iterable);
    }

    public ExpressionNode getExpression() {
        return expression;
    }

    public IdentifierNode getVariable() {
        return variable;
    }

    public ExpressionNode getIterable() {
        return iterable;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return null;
    }
}
