package ast.core;

import ast.core.*;
import java.util.ArrayList;
import java.util.List;

public class TupleExpressionNode extends ExpressionNode {

    private final List<ExpressionNode> elements = new ArrayList<>();

    public TupleExpressionNode(int line, int column) {
        super("Tuple Expression Node", line, column);
    }

    public void addElement(ExpressionNode expr) {
        elements.add(expr);
        add(expr);
        expr.setParent(this);
    }

    public List<ExpressionNode> getElements() {
        return elements;
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