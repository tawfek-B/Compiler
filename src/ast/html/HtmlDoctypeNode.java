package ast.html;

import ast.HtmlWithCssVisitor;

public class HtmlDoctypeNode extends HtmlNode {
    private String text;

    public HtmlDoctypeNode(String text, int line) {
        super("DoctypeNode", line);
        this.text = text;
    }

    @Override
    public String toString() {
        return "DoctypeNode: " + text;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
