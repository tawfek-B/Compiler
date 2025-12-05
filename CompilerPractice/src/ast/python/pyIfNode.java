package ast.python;

import ast.core.ASTNode;

public class pyIfNode extends ASTNode {
    public pyIfNode(int line){
        super("If",line);
    }
}
