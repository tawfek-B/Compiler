package ast.jinja;

import ast.core.ASTVisitor;
import ast.core.ExpressionNode;
import ast.core.HtmlWithCssVisitor;

public class JinjaWithAssignmentNode extends ExpressionNode {

    private final String name;
    private final ExpressionNode value;

    public JinjaWithAssignmentNode(String name, ExpressionNode value, int line, int column) {
        super("jinja-with-assignment", line, column);
        this.name = name;
        this.value = value;

        this.add(value);
    }

    public String getName() {
        return name;
    }

    public ExpressionNode getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "JINJA WITH ASSIGNMENT NODE\t" + name + "\t" + value;
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