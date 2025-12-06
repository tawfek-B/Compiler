package ast.css;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CssMediaQueryNode extends ASTNode {
    private String query;
    List<CssRuleNode> rules = new ArrayList<>();

    public CssMediaQueryNode(String query, int line) {
        super("CSS Media Query Node", line);
        this.query = query;
    }

    public void addRule(CssRuleNode rule) {
        this.rules.add(rule);
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(rules);
        return children;
    }

    @Override
    public String toString() {
        return "CSS Media Query Node: " + query;
    }
}
