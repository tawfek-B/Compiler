package ast.jinja;

import ast.HtmlWithCssVisitor;

public class JinjaExpressionNode extends JinjaNode {

    private String expression;

    public JinjaExpressionNode(String expression, int line) {
        super("Jinja Expression Node", line);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}