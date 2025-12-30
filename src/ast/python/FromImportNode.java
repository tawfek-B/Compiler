package ast.python;

import ast.core.*;

public class FromImportNode extends StatementNode {

    private final IdentifierNode module;
    private final IdentifierNode name;

    public FromImportNode(
            IdentifierNode module,
            IdentifierNode name,
            int line,
            int column
    ) {
        super(line, column);
        this.module = module;
        this.name = name;

        add(module);
        add(name);
    }

    public IdentifierNode getModule() {
        return module;
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
