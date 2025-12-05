package ast.python;

import ast.core.ASTNode;

public class pyElifNode extends ASTNode {
    public pyElifNode(int line){
        super("Elif",line);
    }
}
