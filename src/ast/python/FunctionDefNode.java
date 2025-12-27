package ast.python;

import ast.core.*;

import java.util.List;

public class FunctionDefNode extends StatementNode {

    private final String name;
    private final List<ParameterNode> parameters;
    private final BlockNode body;
    private final List<DecoratorNode> decorators;

    public FunctionDefNode(
            String name,
            List<ParameterNode> parameters,
            BlockNode body,
            List<DecoratorNode> decorators,
            int line,
            int column
    ) {
        super(line, column);
        this.name = name;
        this.parameters = parameters;
        this.body = body;
        this.decorators = decorators;

        decorators.forEach(this::add);
        parameters.forEach(this::add);
        add(body);
    }

    public String getName() {
        return name;
    }

    public List<ParameterNode> getParameters() {
        return parameters;
    }

    public BlockNode getBody() {
        return body;
    }

    public List<DecoratorNode> getDecorators() {
        return decorators;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return null;
    }

    public void setBody(ASTNode child) {
        body.add(child);
    }
}
