package ast.python;

import ast.core.ASTNode;
import ast.core.ExpressionNode;
import ast.core.ASTVisitor;

import java.util.List;

public class ListNode extends ExpressionNode {

    private final List<ExpressionNode> elements;

    public ListNode(List<ExpressionNode> elements, int line, int column) {
        super(line, column);
        this.elements = elements;
        elements.forEach(this::add);
    }

    public List<ExpressionNode> getElements() {
        return elements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void addElements(ExpressionNode el) {
        elements.add(el);
    }
}
