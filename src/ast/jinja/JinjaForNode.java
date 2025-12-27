package ast.jinja;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaForNode extends JinjaNode {
    private String variable;
    private String iterable;
    private String body;

    public JinjaForNode(String variable, String iterable, String body, int line, int column) {
        super("Jinja for loop", line, column);
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

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}
