package ast.python;

import ast.core.*;
import java.util.ArrayList;
import java.util.List;

public class FromImportNode extends StatementNode {

    private final IdentifierNode module;
    private final List<IdentifierNode> importedNames;

    public FromImportNode(IdentifierNode module, List<IdentifierNode> importedNames, int line, int column) {
        super(line, column);
        this.module = module;
        this.importedNames = importedNames != null ? importedNames : new ArrayList<>();

        add(module);
        this.importedNames.forEach(this::add);
    }

    public IdentifierNode getModule() { return module; }
    public List<IdentifierNode> getImportedNames() { return importedNames; }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return null;
    }
}