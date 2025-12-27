package ast.css;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class CssKeyframeDeclarationNode extends CssNode {
    private String property;
    private String value;
    private boolean important;

    public CssKeyframeDeclarationNode(String property, String value, boolean important, int line, int column) {
        super("CSS Keyframe Declaration", line, column);
        this.value = value;
        this.property = property;
        this.important = important;
    }

    public String getProperty() {
        return property;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CSS Keyframe Declaration: " + property + " = " + value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}
