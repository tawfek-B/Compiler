package ast.core;

import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {

    protected final String type;
    protected final int line;
    protected final int column;
    protected final List<ASTNode> children = new ArrayList<>();

    protected ASTNode(String type ,int line, int column) {
        this.type = type;
        this.line = line;
        this.column = column;
    }

    protected ASTNode(int line, int column) {
        this.type = "python";
        this.line = line;
        this.column = column;
    }



    public void add(ASTNode child) {
        if (child != null) {
            children.add(child);
        }
    }

    public List<ASTNode> getChildren() {
        return children;
    }

    public String getType() {
        return type;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public abstract <T> T accept(ASTVisitor<T> visitor);

    public abstract <T> T accept(HtmlWithCssVisitor<T> visitor);


    public void print(String indent) {
        System.out.println(
                indent + getClass().getSimpleName() +
                        " (line=" + line + ", col=" + column + ")"
        );
        for (ASTNode child : children) {
            child.print(indent + "  ");
        }
    }
}
