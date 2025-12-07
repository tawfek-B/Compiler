package ast.css;

import ast.core.ASTNode;
import visitors.CssVisitor;

public class CssMarginRuleNode extends CssNode {
    private String area;
//    private List<CssDeclarationNode> declarations = new ArrayList<>();

    public CssMarginRuleNode(String area, int line) {
        super("CSS Margin Rule Node", line);
        this.area = area;
    }
    
//    public void addDeclaration(CssDeclarationNode declaration) {
//        declarations.add(declaration);
//    }

    public String getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "CssMarginRuleNode: " + area;
    }

    public <T> T accept(CssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
