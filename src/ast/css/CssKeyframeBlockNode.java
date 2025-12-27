package ast.css;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;

public class CssKeyframeBlockNode extends CssNode {
    private List<CssKeyframeSelectorNode> selectors = new ArrayList<>();
    private List<CssKeyframeDeclarationNode> declarations = new ArrayList<>();

    public CssKeyframeBlockNode(int line, int column) {
        super("CSS Keyframe Block Node", line, column);
    }

    public void addSelector(CssKeyframeSelectorNode selector) {
        selectors.add(selector);
    }
    public void addDeclaration(CssKeyframeDeclarationNode declaration) {
        declarations.add(declaration);
    }

    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(selectors);
        children.addAll(declarations);
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
        return "CSS Keyframe Block Node";
    }

}
