package ast.jinja;

import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaBlockNode extends JinjaNode {

    private String name;

    public JinjaBlockNode(String name, int line, int column) {
        super("Jinja lol Node", line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JinjaBlockNode: " + name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}
