package ast.jinja;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaEndNode extends ASTNode {

    private final String raw;

    public JinjaEndNode(String raw, int line, int column) {
        super("jinja_end", line, column);
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
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