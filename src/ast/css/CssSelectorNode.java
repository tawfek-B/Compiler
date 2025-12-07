package ast.css;

import ast.core.ASTNode;
import visitors.CssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssSelectorNode extends CssNode {
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

    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        for (CssDeclarationNode declaration : declarations) {
            children.add(declaration);
        }
        return children;
    }

    @Override
    public String toString(){
        return "CssSelectorNode: " + selector;
    }

    public <T> T accept(CssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
