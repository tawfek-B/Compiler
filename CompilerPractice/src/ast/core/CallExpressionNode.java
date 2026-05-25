package ast.core;

import java.util.List;

public class CallExpressionNode extends ExpressionNode {

    private final ExpressionNode callee;
    private final List<ExpressionNode> arguments;

    public CallExpressionNode(
            ExpressionNode callee,
            List<ExpressionNode> arguments,
            int line,
            int column
    ) {
        super(line, column);
        this.callee = callee;
        this.arguments = arguments != null ? arguments : List.of();

        add(callee);
        this.arguments.forEach(this::add);
    }

    public ExpressionNode getCallee() {
        return callee;
    }

    public List<ExpressionNode> getArguments() {
        return arguments;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);

    }

    public void addArguments(ExpressionNode arg) {
        arguments.add(arg);
    }
}
