package ast.css;

import ast.HtmlWithCssVisitor;
import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CssAtRuleNode extends CssNode {
    private String name;
    private String value;

    public CssAtRuleNode(String name, String value, int line) {
        super("Css At Rule Node", line);
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
        return "CssAtRuleNode: @" + name + " " + value;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }

}