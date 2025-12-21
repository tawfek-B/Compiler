package ast.css;

import ast.HtmlWithCssVisitor;
import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CssMarginRuleNode extends CssNode {
    private String area;
    private List<CssDeclarationNode> declarations = new ArrayList<>();

    public CssMarginRuleNode(String area, int line) {
        super("CSS Margin Rule Node", line);
        this.area = area;
    }

    public void addDeclaration(CssDeclarationNode declaration) {
        declarations.add(declaration);
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
    public String toString() {
        return "CssMarginRuleNode: " + area;
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}