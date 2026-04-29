package ast.python;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;
import ast.core.HtmlWithCssVisitor;

public class SubscriptionNode extends ExpressionNode {

    private ExpressionNode object;
    private ExpressionNode index;

    public SubscriptionNode(ExpressionNode object, ExpressionNode index,
                            int line, int column) {
        super(line, column);
        this.object = object;
        this.index = index;
    }

    public ExpressionNode getObject() {
        return object;
    }

    public ExpressionNode getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Subscription(" + object + "[" + index + "])";
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