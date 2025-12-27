package ast.html;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class HtmlDocumentNode extends HtmlNode {

    public HtmlDocumentNode(int line, int column) {
        super("HTML Document Node", line, column);
    }

    @Override
    public String toString() {
        return "HTML Document Node";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}
