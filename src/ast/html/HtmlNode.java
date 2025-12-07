package ast.html;

import ast.core.ASTNode;
import visitors.HtmlVisitor;

public abstract class HtmlNode extends ASTNode {
    protected HtmlNode(String type, int line) {
        super(type, line);
    }
    public abstract <T> T accept(HtmlVisitor<T> visitor);


}
