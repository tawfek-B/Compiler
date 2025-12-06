package ast.jinja;

import ast.core.ASTNode;

public class JinjaIfNode extends ASTNode {
    private String condition;
    private String body;
    public JinjaIfNode(String condition, String body,  int line) {
        super("Css If Node", line);
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
        return "JinjaIfNode: if " + condition + " then " + body;
    }
}
