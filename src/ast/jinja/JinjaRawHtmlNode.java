package ast.jinja;

import ast.core.AstNode;

public class JinjaRawHtmlNode extends AstNode {
    private String html;
    public JinjaRawHtmlNode(String html) {
        this.html = html;
    }
    public String getHtml() {
        return html;
    }

    @Override
    public String toString() {
        return "JinjaRawHtmlNode: " + html;
    }
}
