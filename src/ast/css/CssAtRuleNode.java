package ast.css;

import ast.core.AstNode;

public class CssAtRuleNode extends AstNode {
    private String name;

    public CssAtRuleNode(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CssAtRuleNode: " + name;
    }

}
