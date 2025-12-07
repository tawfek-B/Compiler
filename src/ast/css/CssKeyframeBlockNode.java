package ast.css;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;
import visitors.CssVisitor;

public class CssKeyframeBlockNode extends CssNode {
    private List<CssKeyframeSelectorNode> selectors = new ArrayList<>();
    private List<CssKeyframeDeclarationNode> declarations = new ArrayList<>();

    public CssKeyframeBlockNode(int line) {
        super("CSS Keyframe Block Node", line);
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
    public String toString() {
        return "CSS Keyframe Block Node";
    }

    public <T> T accept(CssVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
