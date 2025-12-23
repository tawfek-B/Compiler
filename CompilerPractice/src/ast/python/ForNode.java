package ast.python;

import ast.core.*;

public class ForNode extends StatementNode {

    private final IdentifierNode variable;
    private final ExpressionNode iterable;
    private final BlockNode body;

    public ForNode(
            IdentifierNode variable,
            ExpressionNode iterable,
            BlockNode body,
            int line,
            int column
    ) {
        super(line, column);
        this.variable = variable;
        this.iterable = iterable;
        this.body = body;

        add(variable);
        add(iterable);
        add(body);
    }

    public IdentifierNode getVariable(){
        return variable;

    }
    public ExpressionNode getIterable(){
        return iterable;

    }
    public BlockNode getBody(){
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
