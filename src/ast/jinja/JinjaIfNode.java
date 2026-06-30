package ast.jinja;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;
import ast.core.HtmlWithCssVisitor;

public class JinjaIfNode extends JinjaNode {

    private ExpressionNode condition;
    private JinjaNode thenBlock;
    private JinjaNode elseBlock;

    public JinjaIfNode(ExpressionNode condition, int line, int column) {
        super("Jinja If Node", line, column);
        this.condition = condition;
    }

    public ExpressionNode getCondition() { return condition; }

    public JinjaNode getThenBlock() { return thenBlock; }
    public void setThenBlock(JinjaNode thenBlock) { this.thenBlock = thenBlock; }

    public JinjaNode getElseBlock() { return elseBlock; }
    public void setElseBlock(JinjaNode elseBlock) { this.elseBlock = elseBlock; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}