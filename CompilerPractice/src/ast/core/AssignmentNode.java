package ast.core;

public class AssignmentNode extends StatementNode {

    private final IdentifierNode target;
    private final ExpressionNode value;

    public AssignmentNode(
            IdentifierNode target,
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

    public IdentifierNode getTarget() {
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
