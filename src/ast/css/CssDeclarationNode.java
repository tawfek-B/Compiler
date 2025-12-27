package ast.css;

import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class CssDeclarationNode extends CssNode {
    private String property;
    private String value;
    private boolean important;

    public CssDeclarationNode(String property, String value,  boolean important, int line, int column) {
        super("Css Declaration Node", line, column);
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
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(ast.core.HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}
