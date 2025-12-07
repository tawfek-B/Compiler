package ast.jinja;

import ast.core.ASTNode;
import visitors.JinjaVisitor;

public class JinjaRawHtmlNode extends JinjaNode {
    private String html;
    public JinjaRawHtmlNode(String html,  int line) {
        super("Css Raw Node", line);
        this.html = html;
    }
    public String getHtml() {
        return html;
    }

    @Override
    public String toString() {
        return "JinjaRawHtmlNode: " + html;
    }

    public <T> T accept(JinjaVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
