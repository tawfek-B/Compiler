package ast.core;

import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {

    public final String type;
    public final int line;
    public final List<ASTNode> children = new ArrayList<>();

    protected ASTNode(String type, int line) {
        this.type = type;
        this.line = line;
    }

    public void add(ASTNode child){
        if(child != null)
            children.add(child);
    }

    public void addChild(ASTNode child){
        if(child != null)
            children.add(child);
    }

    public void print(String indent){
        System.out.println(indent + type + " line(" + line + ")");
        for(ASTNode c : children)
            c.print(indent + " ");
    }

    public List<ASTNode> getChildren(){
        return children;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}