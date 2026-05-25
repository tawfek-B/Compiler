package ast.python;

import ast.core.*;

import java.util.ArrayList;
import java.util.List;

public class GlobalNode extends StatementNode {

    private final List<IdentifierNode> names;

    public GlobalNode(List<IdentifierNode> names, int line, int column) {
        super(line, column);
        this.names = names != null ? names : new ArrayList<>();
        this.names.forEach(this::add);
    }

    public List<IdentifierNode> getNames() {
        return names;
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
