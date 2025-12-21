package ast.jinja;

import ast.HtmlWithCssVisitor;

public class JinjaDocumentNode extends JinjaNode {

    public JinjaDocumentNode(int line) {
        super("Jinja Document Node", line);
    }

    @Override
    public String toString() {
        return "Jinja Document Node";
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
