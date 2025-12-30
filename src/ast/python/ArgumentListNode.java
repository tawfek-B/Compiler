package ast.python;

import ast.core.*;

import java.util.List;

public class ArgumentListNode extends ASTNode {

    private final List<ExpressionNode> arguments;

    public ArgumentListNode(
            List<ExpressionNode> arguments,
            int line,
            int column
    ) {
        super(line, column);
        this.arguments = arguments;

        for (ExpressionNode arg : arguments) {
            add(arg);
        }
    }

    public List<ExpressionNode> getArguments() {
        return arguments;
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
