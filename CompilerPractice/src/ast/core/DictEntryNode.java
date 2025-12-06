package ast.core;

import ast.ASTVisitor;

public class DictEntryNode extends ASTNode{

    public final String key;
    public ASTNode value;

    protected DictEntryNode(String key,ASTNode value, int line) {
        super("DictEntry(" + key + ")", line);
        this.key = key;
        this.value = value;
        add(value);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
