package ast.css;

import ast.core.ASTNode;

public class CssKeyframeSelectorNode extends ASTNode {
    private String selector;

    public CssKeyframeSelectorNode(String selector, int line) {
        super("CSS Keyframe selector", line);
        this.selector = selector;
    }
    @Override
    public String toString() {
        return "CSS Keyframe selector: " + selector;
    }
}
