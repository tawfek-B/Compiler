package ast.jinja;

import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaVarNode extends JinjaNode {

    private String name;

    public JinjaVarNode(String name, int line,  int column) {
        super("Jinja Var Node", line,  column);
        this.name = name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JinjaVarNode: " + name;
    }

}
