package ast.css;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class CssKeyframeSelectorNode extends CssNode {
    private String selector;

    public CssKeyframeSelectorNode(String selector, int line, int column) {
        super("CSS Keyframe selector", line, column);
        this.selector = selector;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    @Override
    public String toString() {
        return "CSS Keyframe selector: " + selector;
    }

}
