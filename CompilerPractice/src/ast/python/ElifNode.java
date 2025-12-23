package ast.python;

import ast.core.*;

public class ElifNode extends StatementNode {

    private final ExpressionNode condition;
    private final BlockNode block;

    public ElifNode(
            ExpressionNode condition,
            BlockNode block,
            int line,
            int column
    ) {
        super(line, column);
        this.condition = condition;
        this.block = block;

        add(condition);
        add(block);
    }

    public ExpressionNode getCondition() {
        return condition;
    }

    public BlockNode getBlock() {
        return block;
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
