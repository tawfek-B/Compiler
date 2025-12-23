package ast.python;

import ast.core.*;

public class ExceptNode extends StatementNode {

    private final ExpressionNode exceptionType;
    private final String alias;
    private final BlockNode block;

    public ExceptNode(
            ExpressionNode exceptionType,
            String alias,
            BlockNode block,
            int line,
            int column
    ) {
        super(line, column);
        this.exceptionType = exceptionType;
        this.alias = alias;
        this.block = block;

        add(exceptionType);
        add(block);
    }

    public ExpressionNode getExceptionType() {
        return exceptionType;
    }

    public String getAlias() {
        return alias;
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
