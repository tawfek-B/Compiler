package ast.jinja;

import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaIfNode extends JinjaNode {

    private String condition;
    private String body;

    public JinjaIfNode(String condition, String body,  int line, int column) {
        super("Jinja If Node", line, column);
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

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}
