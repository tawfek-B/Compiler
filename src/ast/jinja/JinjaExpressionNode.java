package ast.jinja;

import ast.core.ASTNode;

public class JinjaExpressionNode extends ASTNode {
    private String expression;
    public JinjaExpressionNode(String expression,  int line) {
        super("Css Expression Node", line);
        this.expression = expression;
    }
    public String getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "JinjaExpressionNode: " + expression;
    }

}
