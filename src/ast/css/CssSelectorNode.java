package ast.css;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssSelectorNode extends CssNode {

    private String selector;
    private List<CssDeclarationNode> declarations = new ArrayList<>();

    public CssSelectorNode(String selector, int line, int column) {
        super("Css Selector Node", line, column);
        this.selector = selector;
    }

    public void addDeclaration(CssDeclarationNode decl) {
        declarations.add(decl);
        decl.setParent(this);
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
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    @Override
    public String toString(){
        return "CssSelectorNode: " + selector;
    }
}
