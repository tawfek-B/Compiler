package ast.css;

import ast.core.ASTNode;

public class CssAtRuleNode extends ASTNode {
    private String name;
    private String value;

    public CssAtRuleNode(String name, String value, int line) {
        super("Css Rule Node", line);
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
        return "CssAtRuleNode: " + name;
    }

}
