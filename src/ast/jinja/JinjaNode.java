package ast.jinja;

import ast.core.ASTNode;
import visitors.JinjaVisitor;

public abstract class JinjaNode extends ASTNode {
    protected JinjaNode(String type, int line) {
        super(type, line);
    }
    public abstract <T> T accept(JinjaVisitor<T> visitor);
}
