package ast.core;

public class BooleanLiteralNode extends LiteralNode {

    private final boolean value;

    public BooleanLiteralNode(boolean value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public boolean getValue() {
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
