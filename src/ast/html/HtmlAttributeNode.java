package ast.html;

import ast.core.AstNode;

public class HtmlAttributeNode extends AstNode {
    private String name;
    private String value;

    public HtmlAttributeNode(String name, String value) {
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
