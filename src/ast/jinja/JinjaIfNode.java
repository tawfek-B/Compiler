package ast.jinja;

import ast.core.AstNode;

public class JinjaIfNode extends AstNode {
    private String condition;
    private String body;
    public JinjaIfNode(String condition, String body) {
        this.condition = condition;
        this.body = body;
    }
    public String getCondition() {
        return condition;
    }
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "JinjaIfNode: " + condition + " -> " + body;
    }
}
