package ast.css;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;
import visitors.CssVisitor;

public class CssDocumentNode extends CssNode {

    private List<CssNode> rules = new ArrayList<>();

    public CssDocumentNode(int line) {
        super("CSS Document Node", line);
    }
    public void addRule(CssRuleNode rule) {
        rules.add(rule);
    }

    @Override
    public String toString() {
        return "CSS Document Node";
    }

    public <T> T accept(CssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
