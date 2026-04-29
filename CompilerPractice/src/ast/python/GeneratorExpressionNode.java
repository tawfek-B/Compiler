package ast.python;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;
import ast.core.HtmlWithCssVisitor;
import ast.core.IdentifierNode;

public class GeneratorExpressionNode extends ExpressionNode {

    private ExpressionNode result;
    private IdentifierNode variable;
    private ExpressionNode iterable;
    private ExpressionNode condition;

    public GeneratorExpressionNode(ExpressionNode result,
                                   IdentifierNode variable,
                                   ExpressionNode iterable,
                                   ExpressionNode condition,
                                   int line, int column) {
        super(line, column);
        this.result = result;
        this.variable = variable;
        this.iterable = iterable;
        this.condition = condition;
    }

    public ExpressionNode getResult() { return result; }
    public IdentifierNode getVariable() { return variable; }
    public ExpressionNode getIterable() { return iterable; }
    public ExpressionNode getCondition() { return condition; }

    @Override
    public String toString() {
        return "Generator(" + result + " for " + variable +
                " in " + iterable +
                (condition != null ? " if " + condition : "") + ")";
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