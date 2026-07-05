package ast.core; // (or your actual package)

public class AssignmentNode extends StatementNode {

    // CHANGED: From IdentifierNode to ExpressionNode
    private final ExpressionNode target;
    private final ExpressionNode value;

    public AssignmentNode(
            ExpressionNode target, // CHANGED parameter type
            ExpressionNode value,
            int line,
            int column
    ) {
        super(line, column);
        this.target = target;
        this.value = value;

        add(target);
        add(value);
    }

    // CHANGED: Return type to ExpressionNode
    public ExpressionNode getTarget() {
        return target;
    }

    public ExpressionNode getValue() {
        return value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}