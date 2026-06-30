package ast.visitors;

import ast.core.*;
import ast.css.CssDocumentNode;
import ast.css.CssRuleNode;
import ast.html.HtmlAttributeNode;
import ast.html.HtmlDocumentNode;
import ast.html.HtmlTagNode;
import ast.jinja.*;
import ast.python.*;

public class PythonBaseASTVisitor<T> implements ASTVisitor<T> {

    // core nodes

    @Override
    public T visit(ProgramNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(BlockNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(StatementNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ExpressionNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(AssignmentNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ReturnNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(BinaryExpressionNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(UnaryExpressionNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(CallExpressionNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(IdentifierNode node) {
        return null;
    }

    @Override
    public T visit(NumberLiteralNode node) {
        return null;
    }

    @Override
    public T visit(StringLiteralNode node) {
        return null;
    }

    @Override
    public T visit(BooleanLiteralNode node) {
        return null;
    }

    @Override
    public T visit(NullLiteralNode node) {
        return null;
    }

    @Override
    public T visit(GlobalNode node) {
        return null;
    }

    // python nodes

    @Override
    public T visit(FunctionDefNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ParameterNode node) {
        return null;
    }

    @Override
    public T visit(DecoratorNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(IfNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ElifNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ElseNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(WhileNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ForNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(TryNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ExceptNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(FinallyNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ListNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(DictNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(KeyValueNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(ComparisonNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(LogicalExpressionNode node) {
        return visitChildren(node);
    }

    @Override
    public T visit(BreakNode node) {
        return null;
    }

    @Override
    public T visit(ContinueNode node) {
        return null;
    }

    @Override
    public T visit(ArgumentListNode argumentListNode) {
        return argumentListNode.accept(this);
    }

    @Override
    public T visit(HtmlDocumentNode node) {

        return null;
    }

    @Override
    public T visit(JinjaExpressionNode node) {

        return null;
    }

    @Override
    public T visit(JinjaWithAssignmentNode node) {
        return null;
    }

    @Override
    public T visit(JinjaEndNode node) {
        return null;
    }

    @Override
    public T visit(JinjaBlockNode node) {

        return null;
    }

    @Override
    public T visit(JinjaIfNode node) {
        return null;
    }

    @Override
    public T visit(JinjaExtendNode node) {
        return null;
    }

    @Override
    public T visit(JinjaElseNode node) {
        return null;
    }

    @Override
    public T visit(JinjaForNode node) {
        return null;
    }

    @Override
    public T visit(HtmlTagNode node) {
        return null;
    }

    @Override
    public T visit(HtmlAttributeNode node) {
        return null;
    }

    @Override
    public T visit(TupleExpressionNode node) {
        return null;
    }

    @Override
    public T visit(MixedWebNode mixedWebNode) {
        return null;
    }

    @Override
    public T visit(CssDocumentNode node) {
        return null;
    }


    //  helper

    protected T visitChildren(ASTNode node) {
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        return null;
    }
}
