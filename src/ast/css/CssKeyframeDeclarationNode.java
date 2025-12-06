package ast.css;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CssKeyframeDeclarationNode extends ASTNode {
    private String property;
    private String value;
    private boolean important;


    public CssKeyframeDeclarationNode(String property, String value, boolean important, int line) {
        super("CSS Keyframe Declaration", line);
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
}
