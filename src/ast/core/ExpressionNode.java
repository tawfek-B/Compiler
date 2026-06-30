package ast.core;

public abstract class ExpressionNode extends ASTNode {

    protected ExpressionNode(int line, int column) {
        super(line, column);
    }

    protected ExpressionNode(String type, int line, int column) {
        super(type == null ? "Expression Node" : type, line, column);
    }

    @Override
    public abstract <T> T accept(ASTVisitor<T> visitor);

    @Override
    public abstract <T> T accept(HtmlWithCssVisitor<T> visitor);
}
