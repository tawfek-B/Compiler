package ast.jinja;

import ast.core.AstNode;

public class JinjaExpressionNode extends AstNode {
    private String expression;
    public JinjaExpressionNode(String expression) {
        this.expression = expression;
    }
    public String getExpression() {
        return expression;
    }
}
