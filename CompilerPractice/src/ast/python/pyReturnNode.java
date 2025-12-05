package ast.python;

import ast.core.ASTNode;

public class pyReturnNode extends ASTNode {
    public ASTNode value;

    public pyReturnNode(int line){
        super("Return",line);
    }

    public void setValue( ASTNode value){
        this.value = value;
        if(value != null)
            add(value);
    }
}
