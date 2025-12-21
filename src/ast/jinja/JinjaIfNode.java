package ast.jinja;

import ast.HtmlWithCssVisitor;

public class JinjaIfNode extends JinjaNode {

    private String condition;
    private String body;

    public JinjaIfNode(String condition, String body,  int line) {
        super("Jinja If Node", line);
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

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
