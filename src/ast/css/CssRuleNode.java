package ast.css;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;
import visitors.CssVisitor;

public class CssRuleNode extends CssNode {
    private List<CssDeclarationNode> declarations = new ArrayList<>();
    private List<CssSelectorNode> selectors = new ArrayList<>();

    public CssRuleNode(int line) {
        super("CSS Rule Node", line);
    }

    public List<CssDeclarationNode> getDeclarations() {
        return declarations;
    }
    public List<CssSelectorNode> getSelectors() {
        return selectors;
    }
    public void addDeclaration(CssDeclarationNode declaration) {
        declarations.add(declaration);
    }
    public void addSelector(CssSelectorNode selector) {
        selectors.add(selector);
    }

    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(declarations);
        children.addAll(selectors);
        return children;
    }

    @Override
    public String toString() {
        return "CSS Rule Node";
    }

    public <T> T accept(CssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
