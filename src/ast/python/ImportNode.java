package ast.python;

import ast.core.*;

public class ImportNode extends StatementNode {

    private final IdentifierNode module;
    private final String rawText;

    public ImportNode(IdentifierNode module, int line, int column) {
        this(module, null, line, column);
    }

    public ImportNode(IdentifierNode module, String rawText, int line, int column) {
        super(line, column);
        this.module = module;
        this.rawText = rawText;
        add(module);
    }

    public IdentifierNode getModule() {
        return module;
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