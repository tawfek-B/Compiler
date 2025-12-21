package ast.html;

import ast.HtmlWithCssVisitor;

public class HtmlAttributeNode extends HtmlNode {
    private String name;
    private String value;

    public HtmlAttributeNode(String name, String value,  int line) {
        super("Html Attribute Node", line);
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

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
