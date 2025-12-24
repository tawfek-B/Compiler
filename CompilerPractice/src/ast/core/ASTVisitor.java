package ast.core;

import ast.python.*;

public interface ASTVisitor<T> {

    T visit(ProgramNode node);
    T visit(BlockNode node);

    // Statements
    T visit(StatementNode node);
    T visit(AssignmentNode node);
    T visit(ReturnNode node);

    // Expressions
    T visit(ExpressionNode node);
    T visit(BinaryExpressionNode node);
    T visit(UnaryExpressionNode node);
    T visit(CallExpressionNode node);

    // Identifiers & Literals
    T visit(IdentifierNode node);
    T visit(NumberLiteralNode node);
    T visit(StringLiteralNode node);
    T visit(BooleanLiteralNode node);
    T visit(NullLiteralNode node);



    T visit(FunctionDefNode node);
    T visit(ParameterNode parameterNode);
    T visit(DecoratorNode node);
    T visit(IfNode node);
    T visit(ElifNode node);
    T visit(ElseNode node);
    T visit(WhileNode node);
    T visit(ForNode node);
    T visit(TryNode node);
    T visit(ExceptNode node);
    T visit(FinallyNode node);
    T visit(ListNode node);
    T visit(DictNode node);
    T visit(KeyValueNode node);
    T visit(ComparisonNode node);
    T visit(LogicalExpressionNode node);
    T visit(BreakNode node);
    T visit(ContinueNode node);
    T visit(ArgumentListNode argumentListNode);
}
