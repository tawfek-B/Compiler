package ast.jinja;

import ast.core.ASTNode;
import visitors.JinjaVisitor;

public class JinjaForNode extends JinjaNode {
    private String variable;
    private String iterable;
    private String body;

    public JinjaForNode(String variable, String iterable, String body, int line) {
        super("Jinja for loop", line);
        this.variable = variable;
        this.iterable = iterable;
        this.body = body;
    }
    public String  getVariable() {
        return variable;
    }
    public String getIterable() {
        return iterable;
    }
    public String getBody() {
        return body;
    }

    @Override
    public String toString(){
        return "JinjaForNode: for " + variable + " in " + iterable + " -> " + body;
    }

    public <T> T accept(JinjaVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
