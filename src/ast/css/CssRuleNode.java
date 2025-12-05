package ast.css;

import ast.core.AstNode;

import java.util.ArrayList;
import java.util.List;

public class CssRuleNode extends AstNode {
    private List<CssDeclarationNode> declarations = new ArrayList<>();
    private List<CssSelectorNode> selectors = new ArrayList<>();

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
}
