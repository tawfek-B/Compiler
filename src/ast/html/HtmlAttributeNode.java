package ast.html;

import ast.core.ASTNode;

public class HtmlAttributeNode extends ASTNode {
    private String name;
    private String value;

    public HtmlAttributeNode(String name, String value,  int line) {
        super("Css Attribute Node", line);
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
        return "HtmlAttributeNode: " + name + " = " + value;
    }
}
