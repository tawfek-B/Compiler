package ast.css;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssRuleNode extends CssNode {
    private List<CssDeclarationNode> declarations = new ArrayList<>();
    private List<CssSelectorNode> selectors = new ArrayList<>();

    public CssRuleNode(int line, int column) {
        super("CSS Rule Node", line, column);
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
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(ast.core.HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    @Override
    public String toString() {
        return "CSS Rule Node";
    }

}
