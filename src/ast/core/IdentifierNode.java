package ast.core;

public class IdentifierNode extends ExpressionNode {

    private final String name;

    public IdentifierNode(String name, int line, int column) {
        super(line, column);
        this.name = name;
    }

    public String getName() {
        return name;
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
