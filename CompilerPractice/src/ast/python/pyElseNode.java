package ast.python;

import ast.core.ASTNode;

public class pyElseNode extends ASTNode {
    public pyElseNode(int line){
        super("Else",line);
    }
}
