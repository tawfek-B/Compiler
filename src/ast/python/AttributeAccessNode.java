package ast.python;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;
import ast.core.HtmlWithCssVisitor;

public class AttributeAccessNode extends ExpressionNode {

    private ExpressionNode object;
    private String attribute;

    public AttributeAccessNode(ExpressionNode object, String attribute,
                               int line, int column) {
        super(line, column);
        this.object = object;
        this.attribute = attribute;
    }

    public ExpressionNode getObject() {
        return object;
    }

    public String getAttribute() {
        return attribute;
    }

    @Override
    public String toString() {
        return "AttributeAccess(" + object + "." + attribute + ")";
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