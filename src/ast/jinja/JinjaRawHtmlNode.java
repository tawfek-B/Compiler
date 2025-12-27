package ast.jinja;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaRawHtmlNode extends JinjaNode {

    private String html;

    public JinjaRawHtmlNode(String html,  int line, int column) {
        super("Jinja Raw Html Node", line,  column);
        this.html = html;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    public String getHtml() {
        return html;
    }

    @Override
    public String toString() {
        return "JinjaRawHtmlNode: " + html;
    }

}
