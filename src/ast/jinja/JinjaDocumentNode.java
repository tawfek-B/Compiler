package ast.jinja;

import ast.core.ASTNode;
import visitors.JinjaVisitor;

public class JinjaDocumentNode extends JinjaNode {
    public JinjaDocumentNode(int line) {
        super("Jinja Document Node", line);
    }

    @Override
    public String toString() {
        return "Jinja Document Node";
    }

    public <T> T accept(JinjaVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
