package ast.python;

import ast.core.*;

public class ListComprehensionNode extends ExpressionNode {

    private final ExpressionNode expression;
    private final IdentifierNode variable;
    private final ExpressionNode iterable;
    private final ExpressionNode condition; // optional `if` filter clause

    public ListComprehensionNode(
            ExpressionNode expression,
            IdentifierNode variable,
            ExpressionNode iterable,
            int line,
            int column
    ) {
        this(expression, variable, iterable, null, line, column);
    }

    public ListComprehensionNode(
            ExpressionNode expression,
            IdentifierNode variable,
            ExpressionNode iterable,
            ExpressionNode condition,
            int line,
            int column
    ) {
        super(line, column);
        this.expression = expression;
        this.variable = variable;
        this.iterable = iterable;
        this.condition = condition;

        add(expression);
        add(variable);
        add(iterable);
        if (condition != null) add(condition);
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

    public ExpressionNode getCondition() {
        return condition;
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