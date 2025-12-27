package ast.css;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssMediaQueryNode extends CssNode {
    private String query;
    List<CssRuleNode> rules = new ArrayList<>();

    public CssMediaQueryNode(String query, int line,  int column) {
        super("CSS Media Query Node", line, column);
        this.query = query;
    }

    public void addRule(CssRuleNode rule) {
        this.rules.add(rule);
    }

    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(rules);
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
        return "CSS Media Query Node: " + query;
    }
}
