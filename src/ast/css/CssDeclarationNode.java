package ast.css;

import ast.core.AstNode;

public class CssDeclarationNode extends AstNode {
    private String property;
    private String value;
    private boolean important;

    public CssDeclarationNode(String property, String value,  boolean important) {
        this.property = property;
        this.value = value;
        this.important = important;
    }
    public String getProperty() {
        return property;
    }
    public String getValue() {
        return value;
    }
    public boolean isImportant() {
        return important;
    }

    @Override
    public String toString() {
        return "CssDeclarationNode: " + property + " = " + value;
    }
}
