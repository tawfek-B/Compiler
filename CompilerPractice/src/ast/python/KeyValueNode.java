package ast.python;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;

public class KeyValueNode extends ExpressionNode {

    private final ExpressionNode key;
    private final ExpressionNode value;

    public KeyValueNode(
            ExpressionNode key,
            ExpressionNode value,
            int line,
            int column
    ) {
        super(line, column);
        this.key = key;
        this.value = value;

        add(key);
        add(value);
    }

    public ExpressionNode getKey() {
        return key;
    }

    public ExpressionNode getValue() {
        return value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
