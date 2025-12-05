package ast.python;

import ast.core.ASTNode;

public class pyForEachNode extends ASTNode {
    public final String var;
    public final String iterable;

    public pyForEachNode(String var, String iterable ,int line){
        super("ForEach(" + var + "in" + iterable + ")" , line);
        this.var = var;
        this.iterable = iterable;

    }
}
