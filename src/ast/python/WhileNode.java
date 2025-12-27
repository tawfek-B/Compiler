package ast.python;

import ast.core.*;

public class WhileNode extends StatementNode {

    private final ExpressionNode condition;
    private final BlockNode body;

    public WhileNode(
            ExpressionNode condition,
            BlockNode body,
            int line,
            int column
    ) {
        super(line, column);
        this.condition = condition;
        this.body = body;

        add(condition);
        add(body);
    }

    public ExpressionNode getCondition() {
        return condition;
    }

    public BlockNode getBody() {
        return body;
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
