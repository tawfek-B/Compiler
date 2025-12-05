package ast.jinja;

import ast.core.AstNode;

public class JinjaIfNode extends AstNode {
    private String variable;
    private String iterable;
    public JinjaIfNode(String variable, String iterable) {
        this.variable = variable;
        this.iterable = iterable;
    }
    public String getVariable() {
        return variable;
    }
    public String getIterable() {
        return iterable;
    }
}
