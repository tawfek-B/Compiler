package ast.css;

import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssDocumentNode extends CssNode {

    private List<CssNode> rules = new ArrayList<>();

    public CssDocumentNode(int line, int column) {
        super("CSS Document Node", line, column);
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

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}