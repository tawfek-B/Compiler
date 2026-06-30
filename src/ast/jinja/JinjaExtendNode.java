package ast.jinja;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaExtendNode extends ASTNode {

    private final ASTNode templatePath;
    private final String path;

    public JinjaExtendNode(ASTNode templatePath, String path, int line, int column) {
        super("extends", line, column);
        this.templatePath = templatePath;
        this.path = path;
    }

    public ASTNode getTemplatePath() {
        return templatePath;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "EXTEND JINJA: " + this.path;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}