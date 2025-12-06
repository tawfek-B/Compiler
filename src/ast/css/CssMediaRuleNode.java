package ast.css;

import ast.core.ASTNode;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.ArrayList;
import java.util.List;

public class CssMediaRuleNode extends ASTNode {
    private List<CssMediaQueryNode> queries = new ArrayList<>();
    private List<ASTNode> rules = new ArrayList<>();

    public CssMediaRuleNode(int line) {
        super("CSS Media Rule Node", line);
    }

    public void addQuery(CssMediaQueryNode query) {
        queries.add(query);
    }
    public void addRule(ASTNode rule) {
        rules.add(rule);
    }

    @Override
    public List<ASTNode>  getChildren()
    {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(rules);
        children.addAll(queries);
        return children;
    }

    @Override
    public String toString() {
        return "CSS Media Rule Node";
    }
}
