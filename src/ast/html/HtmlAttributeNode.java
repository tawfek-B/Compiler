package ast.html;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class HtmlAttributeNode extends HtmlNode {
    private String name;
    private String value;

    public HtmlAttributeNode(String name, String value,  int line, int column) {
        super("Html Attribute Node", line, column);
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "HtmlAttributeNode: " + name + " = \"" + value + "\"";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
