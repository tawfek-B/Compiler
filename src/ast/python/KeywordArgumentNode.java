package ast.python;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;
import ast.core.HtmlWithCssVisitor;

public class KeywordArgumentNode extends ExpressionNode {

    private String key;
    private ExpressionNode value;

    public KeywordArgumentNode(String key, ExpressionNode value,
                               int line, int column) {
        super(line, column);
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public ExpressionNode getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "KeywordArg(" + key + "=" + value + ")";
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