package ast.jinja;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;
import ast.core.HtmlWithCssVisitor;

public class JinjaForNode extends JinjaNode {

    private ExpressionNode variable;
    private ExpressionNode iterable;
    private JinjaNode body;

    public JinjaForNode(ExpressionNode variable,
                        ExpressionNode iterable,
                        int line,
                        int column) {
        super("Jinja For Node", line, column);
        this.variable = variable;
        this.iterable = iterable;
    }

    public ExpressionNode getVariable() { return variable; }
    public ExpressionNode getIterable() { return iterable; }

    public JinjaNode getBody() { return body; }
    public void setBody(JinjaNode body) { this.body = body; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}