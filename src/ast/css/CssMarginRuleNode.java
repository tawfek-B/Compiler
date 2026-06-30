package ast.css;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssMarginRuleNode extends CssNode {
    private String area;
    private List<CssDeclarationNode> declarations = new ArrayList<>();

    public CssMarginRuleNode(String area, int line, int column) {
        super("CSS Margin Rule Node", line,  column);
        this.area = area;
    }

    public void addDeclaration(CssDeclarationNode declaration) {
        declarations.add(declaration);
        declaration.setParent(this);
    }

    public String getArea() {
        return area;
    }

    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(declarations);
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
        return "CssMarginRuleNode: " + area;
    }
}