package ast.html;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class HtmlDoctypeNode extends HtmlNode {
    private String text;

    public HtmlDoctypeNode(String text, int line, int column) {
        super("DoctypeNode", line,  column);
        this.text = text;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    @Override
    public String toString() {
        return "DoctypeNode: " + text;
    }


}
