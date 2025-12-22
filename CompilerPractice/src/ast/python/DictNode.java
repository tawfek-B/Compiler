package ast.python;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;

import java.util.List;

public class DictNode extends ExpressionNode {

    private final List<KeyValueNode> entries;

    public DictNode(List<KeyValueNode> entries, int line, int column) {
        super(line, column);
        this.entries = entries;
        entries.forEach(this::add);
    }

    public List<KeyValueNode> getEntries() {
        return entries;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void addEntry(KeyValueNode entry) {
        entries.add(entry);
    }
}
