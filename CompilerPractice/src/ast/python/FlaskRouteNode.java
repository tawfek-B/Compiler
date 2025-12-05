package ast.python;

import ast.core.ASTNode;

public class FlaskRouteNode extends ASTNode {

    public final String path;
    public FlaskRouteNode(String path, int line){
        super("Route(" + path + ")",line);
        this.path = path;
    }
}
