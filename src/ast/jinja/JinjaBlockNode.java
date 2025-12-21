package ast.jinja;

import ast.HtmlWithCssVisitor;

public class JinjaBlockNode extends JinjaNode {

    private String name;

    public JinjaBlockNode(String name, int line) {
        super("Jinja Block Node", line);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JinjaBlockNode: " + name;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
