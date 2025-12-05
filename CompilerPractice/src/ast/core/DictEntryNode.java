package ast.core;

public class DictEntryNode extends ASTNode{

    public final String key;
    public ASTNode value;

    protected DictEntryNode(String key,ASTNode value, int line) {
        super("DictEntry(" + key + ")", line);
        this.key = key;
        this.value = value;
        add(value);
    }
}
