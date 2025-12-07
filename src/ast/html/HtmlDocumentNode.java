package ast.html;

import visitors.HtmlVisitor;

public class HtmlDocumentNode extends HtmlNode {
    public HtmlDocumentNode(int line) {
        super("HTML Document Node", line);
    }

    @Override
    public String toString() {
        return "HTML Document Node";
    }

    public <T> T accept(HtmlVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
