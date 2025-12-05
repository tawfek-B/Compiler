package ast.css;

import ast.core.AstNode;

public class CssMarginRuleNode extends AstNode {
    private String area;

    public CssMarginRuleNode(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "CssMarginRuleNode: " + area;
    }
}
