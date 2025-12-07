package ast.jinja;

import ast.core.ASTNode;
import visitors.JinjaVisitor;

public class JinjaExpressionNode extends JinjaNode {
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

    public <T> T accept(JinjaVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
