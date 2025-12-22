package ast.python;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;

public class LogicalExpressionNode extends ExpressionNode {

    private final ExpressionNode left;
    private final String operator;
    private final ExpressionNode right;

    public LogicalExpressionNode(
            ExpressionNode left,
            String operator,
            ExpressionNode right,
            int line,
            int column
    ) {
        super(line, column);
        this.left = left;
        this.operator = operator;
        this.right = right;

        add(left);
        add(right);
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public String getOperator() {
        return operator;
    }

    public ExpressionNode getRight() {
        return right;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
