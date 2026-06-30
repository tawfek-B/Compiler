package ast.html;

import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class HtmlTextNode extends HtmlNode {

    private String text;

    public HtmlTextNode(String text, int line, int column) {
        super("Html Text Node", line,  column);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "HtmlTextNode: \"" + text + "\"";
    }


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}