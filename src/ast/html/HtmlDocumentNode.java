package ast.html;


import ast.HtmlWithCssVisitor;

public class HtmlDocumentNode extends HtmlNode {

    public HtmlDocumentNode(int line) {
        super("HTML Document Node", line);
    }

    @Override
    public String toString() {
        return "HTML Document Node";
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
