package ast.css;

import ast.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssDocumentNode extends CssNode {

    private List<CssNode> rules = new ArrayList<>();

    public CssDocumentNode(int line) {
        super("CSS Document Node", line);
    }
    public void addRule(CssNode rule) {
        rules.add(rule);
    }

    public List<CssNode> getRules() {
        return rules;
    }

    @Override
    public String toString() {
        return "CSS Document Node";
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}