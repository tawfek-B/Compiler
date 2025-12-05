package ast.css;

import ast.core.AstNode;

import java.util.ArrayList;
import java.util.List;

public class CssSelectorNode extends AstNode {
    private String selector;
    private List<CssDeclarationNode> declarations = new ArrayList<>();
    public CssSelectorNode(String selector) {
        this.selector = selector;
    }
    public void addDeclaration(CssDeclarationNode decl) {
        declarations.add(decl);
    }
    public String getSelector() {
        return selector;
    }
    public List<CssDeclarationNode> getDeclarations() {
        return declarations;
    }

    @Override
    public String toString(){
        return "CssSelectorNode: " + selector;
    }

    @Override
    public List<AstNode> getChildren() {
        return new ArrayList<>(declarations);
    }
}
