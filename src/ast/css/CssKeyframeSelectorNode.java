package ast.css;

import ast.core.ASTNode;
import visitors.CssVisitor;

public class CssKeyframeSelectorNode extends CssNode {
    private String selector;

    public CssKeyframeSelectorNode(String selector, int line) {
        super("CSS Keyframe selector", line);
        this.selector = selector;
    }
    @Override
    public String toString() {
        return "CSS Keyframe selector: " + selector;
    }

    public <T> T accept(CssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
