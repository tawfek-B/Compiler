package ast.jinja;

import ast.HtmlWithCssVisitor;

public class JinjaVarNode extends JinjaNode {

    private String name;

    public JinjaVarNode(String name, int line) {
        super("Jinja Var Node", line);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JinjaVarNode: " + name;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
