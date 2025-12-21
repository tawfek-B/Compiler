package ast.jinja;

import ast.HtmlWithCssVisitor;

public class JinjaRawHtmlNode extends JinjaNode {

    private String html;

    public JinjaRawHtmlNode(String html,  int line) {
        super("Jinja Raw Html Node", line);
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

    @Override
    public String toString() {
        return "JinjaRawHtmlNode: " + html;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
