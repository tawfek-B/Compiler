package ast.jinja;

import ast.core.ASTNode;
import visitors.JinjaVisitor;

public class JinjaVarNode extends JinjaNode {
    private String name;
    public JinjaVarNode(String name, int line) {
        super("Css Var Node", line);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JinjaVarNode: " + name;
    }

    public <T> T accept(JinjaVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
