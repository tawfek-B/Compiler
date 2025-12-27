package ast.core;

public abstract class LiteralNode extends ExpressionNode {

    protected LiteralNode(int line, int column) {
        super(line, column);
    }

    @Override
    public abstract <T> T accept(ASTVisitor<T> visitor);

    @Override
    public abstract <T> T accept(HtmlWithCssVisitor<T> visitor);
}
