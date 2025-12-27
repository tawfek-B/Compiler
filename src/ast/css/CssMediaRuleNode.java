package ast.css;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssMediaRuleNode extends CssNode {
    private List<CssMediaQueryNode> queries = new ArrayList<>();
    private List<CssNode> rules = new ArrayList<>();

    public CssMediaRuleNode(int line, int column) {
        super("CSS Media Rule Node", line, column);
    }

    public void addQuery(CssMediaQueryNode query) {
        queries.add(query);
    }
    public void addRule(CssNode rule) {
        rules.add(rule);
    }

    public List<ASTNode> getChildren()
    {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(rules);
        children.addAll(queries);
        return children;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    @Override
    public String toString() {
        return "CSS Media Rule Node";
    }

}
