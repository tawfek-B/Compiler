package ast.core;

import ast.ASTVisitor;

public class BinaryNode extends ASTNode {
    public final String operator; // "+", "-", "*", "/", "<", "==", "and", etc.
    public ASTNode left;
    public ASTNode right;

    public BinaryNode(String operator, ASTNode left, ASTNode right, int line) {
        super("BinaryOperation(" + operator + ")", line);
        this.operator = operator;
        this.left = left;
        this.right = right;
        add(left);
        add(right);
    }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
