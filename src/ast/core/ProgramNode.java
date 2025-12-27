package ast.core;

public class ProgramNode extends ASTNode {

    public ProgramNode(int line, int column) {
        super(line, column);
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
