package ast.css;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CssSelectorNode extends ASTNode {
    private String selector;
    private List<CssDeclarationNode> declarations = new ArrayList<>();
    public CssSelectorNode(String selector, int line) {
        super("Css Selector Node", line);
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
    public List<ASTNode> getChildren() {
        return new ArrayList<>(declarations);
    }
}
