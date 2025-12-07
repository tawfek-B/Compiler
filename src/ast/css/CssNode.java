package ast.css;

import ast.core.ASTNode;
import visitors.CssVisitor;
import visitors.HtmlVisitor;

public abstract class CssNode extends ASTNode {

    protected CssNode(String type, int line) {
        super(type, line);
    }

    public abstract <T> T accept(CssVisitor<T> visitor);
}
