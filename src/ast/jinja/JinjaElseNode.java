package ast.jinja;

import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class JinjaElseNode extends JinjaNode {

    public JinjaElseNode(int line, int column) {
        super("Jinja Else Node", line, column);
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