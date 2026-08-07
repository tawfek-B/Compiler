package ast.python;

import ast.core.*;

public class FromImportNode extends StatementNode {

    private final IdentifierNode module;
    private final IdentifierNode name;
    private final String rawText; 

    public FromImportNode(
            IdentifierNode module,
            IdentifierNode name,
            int line,
            int column
    ) {
        this(module, name, null, line, column);
    }

    public FromImportNode(
            IdentifierNode module,
            IdentifierNode name,
            String rawText,
            int line,
            int column
    ) {
        super(line, column);
        this.module = module;
        this.name = name;
        this.rawText = rawText;

        add(module);
        add(name);
    }

    public IdentifierNode getModule() {
        return module;
    }

    public IdentifierNode getName() {
        return name;
    }

    public String getRawText() {
        return rawText;
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