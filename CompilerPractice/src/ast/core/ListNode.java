package ast.core;

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


}
