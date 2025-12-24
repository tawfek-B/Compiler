package ast.python;

import ast.core.*;

public class GlobalNode extends StatementNode {

    private final IdentifierNode name;

    public GlobalNode(IdentifierNode name, int line, int column) {
        super(line, column);
        this.name = name;
        add(name);
    }

    public IdentifierNode getName() {
        return name;
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
