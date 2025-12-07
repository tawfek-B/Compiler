package ast.css;

import ast.core.ASTNode;
import visitors.CssVisitor;

public class CssDeclarationNode extends CssNode {
    private String property;
    private String value;
    private boolean important;

    public CssDeclarationNode(String property, String value,  boolean important, int line) {
        super("Css Declaration Node", line);
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

    public <T> T accept(CssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
