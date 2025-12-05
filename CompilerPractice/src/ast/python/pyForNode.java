package ast.python;

import ast.core.ASTNode;

public class pyForNode extends ASTNode {
    public pyForNode(int line){
        super("For",line);
    }
}
