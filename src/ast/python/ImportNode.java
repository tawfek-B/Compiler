package ast.python;

import ast.core.*;

public class ImportNode extends StatementNode {

    private final IdentifierNode module;

    public ImportNode(IdentifierNode module, int line, int column) {
        super(line, column);
        this.module = module;
        add(module);
    }

    public IdentifierNode getModule() {
        return module;
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
