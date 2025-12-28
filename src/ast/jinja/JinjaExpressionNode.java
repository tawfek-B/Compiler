package ast.jinja;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaExpressionNode extends JinjaNode {
    private final ASTNode expression;

    public JinjaExpressionNode(ASTNode expression, int line, int column) {
        super("Jinja Expression Node", line, column);
        this.expression = expression;
        if (expression != null) {
            add(expression);
        }
    }

    public ASTNode getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "JinjaExpressionNode: " + (expression != null ? expression.getClass().getSimpleName() : "null");
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}