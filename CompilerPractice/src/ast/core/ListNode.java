package ast.core;

import ast.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class ListNode extends ASTNode{

    public List<ASTNode> elements = new ArrayList<>();


    public ListNode( int line) {
        super("List", line);
    }

    public void addElements(ASTNode element){
        elements.add(element);
        add(element);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }


}
