package ast.jinja;

import ast.core.ASTNode;

public class JinjaRawHtmlNode extends ASTNode {
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
}
