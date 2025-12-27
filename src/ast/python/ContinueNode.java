package ast.python;

import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;
import ast.core.StatementNode;

public class ContinueNode extends StatementNode {

    public ContinueNode(int line, int column) {
        super(line, column);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return null;
    }
}
