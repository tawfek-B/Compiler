package ast.jinja;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaDocumentNode extends JinjaNode {

    public JinjaDocumentNode(int line, int column) {
        super("Jinja Document Node", line, column);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    @Override
    public String toString() {
        return "Jinja Document Node";
    }

}
