package visitors;

import ast.core.*;
import ast.python.*;
import table.*;

import java.util.UUID;

public class SymbolTableVisitor implements ASTVisitor<Void> {

    private final SymbolTable symbolTable;
    private final LabelTable labelTable;

    public SymbolTableVisitor(SymbolTable symbolTable, LabelTable labelTable) {
        this.symbolTable = symbolTable;
        this.labelTable = labelTable;
    }

    // program

    @Override
    public Void visit(ProgramNode node) {
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        return null;
    }

    // block

    @Override
    public Void visit(BlockNode node) {
        for (ASTNode stmt : node.getChildren()) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(StatementNode node) {
        return null;
    }

    // functions

    @Override
    public Void visit(FunctionDefNode node) {

        SymbolRow functionSymbol = symbolTable.addSymbol(
                node.getName(),
                "function",
                null,
                node.getLine(),
                node.getColumn()
        );

        labelTable.generateLabel(functionSymbol);

        symbolTable.enterScope(node.getName());

        for (ParameterNode param : node.getParameters()) {
            symbolTable.addSymbol(
                    param.getName(),
                    "parameter",
                    null,
                    param.getLine(),
                    param.getColumn()
            );
        }

        if (node.getBody() != null ) {

            node.getBody().accept(this);
        }
        symbolTable.exitScope();
        return null;
    }


    @Override
    public Void visit(ParameterNode node) {
        return null;
    }

    @Override
    public Void visit(DecoratorNode node) {
        return null;
    }

    // assignment

    @Override
    public Void visit(AssignmentNode node) {
        IdentifierNode id = node.getTarget();

        if (!symbolTable.existsInCurrentScope(id.getName())) {
            symbolTable.addSymbol(
                    id.getName(),
                    "variable",
                    null,
                    id.getLine(),
                    id.getColumn()
            );
        }

        if (node.getValue() != null) {
            node.getValue().accept(this);
        }

        return null;
    }


    // if statements

    @Override
    public Void visit(IfNode node) {
        labelTable.generateAnonymousLabel();

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getThenBlock() != null) {
            node.getThenBlock().accept(this);
        }


        for (ElifNode e : node.getElifBlocks()) {
            e.accept(this);
        }

        if (node.getElseBlock() != null) {
            node.getElseBlock().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(ElifNode node) {
        labelTable.generateAnonymousLabel();
        node.getCondition().accept(this);
        node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(ElseNode node) {
        labelTable.generateAnonymousLabel();
        node.getBlock().accept(this);
        return null;
    }

    // loops

    @Override
    public Void visit(WhileNode node) {
        labelTable.generateAnonymousLabel();

        node.getCondition().accept(this);
        node.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(ForNode node) {

        SymbolRow forSymbol = symbolTable.addSymbol(
                node.getVariable().getName(),
                "loop_var",
                null,
                node.getVariable().getLine(),
                node.getVariable().getColumn()
        );

        labelTable.generateLabel(forSymbol);

        if (node.getIterable() != null) {
            node.getIterable().accept(this);
        }

        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        return null;
    }

    // try and except blocks

    @Override
    public Void visit(TryNode node) {
        labelTable.generateAnonymousLabel();

        node.getTryBlock().accept(this);

        for (ExceptNode e : node.getExceptBlocks()) {
            e.accept(this);
        }

        if (node.getFinallyBlock() != null) {
            node.getFinallyBlock().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ExceptNode node) {
        labelTable.generateAnonymousLabel();

        if (node.getExceptionType() != null) {
            node.getExceptionType().accept(this);
        }

        node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(FinallyNode node) {
        labelTable.generateAnonymousLabel();
        node.getBlock().accept(this);
        return null;
    }

    // expressions

    @Override
    public Void visit(BinaryExpressionNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNode node) {
        return null;
    }

    @Override
    public Void visit(ComparisonNode node) {

        if (node.getLeft() != null) {
            node.getLeft().accept(this);
        }
        if (node.getRight() != null) {
            node.getRight().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(LogicalExpressionNode node) {
        return null;
    }

    @Override
    public Void visit(CallExpressionNode node) {
        node.getCallee().accept(this);
        for (ExpressionNode arg : node.getArguments()) {
            arg.accept(this);
        }
        return null;
    }

    @Override public Void visit(IdentifierNode node) { return null; }
    @Override public Void visit(NumberLiteralNode node) { return null; }
    @Override public Void visit(StringLiteralNode node) { return null; }
    @Override public Void visit(BooleanLiteralNode node) { return null; }

    @Override
    public Void visit(NullLiteralNode node) {
        return null;
    }

    @Override public Void visit(ListNode node) { return null; }
    @Override public Void visit(DictNode node) { return null; }
    @Override public Void visit(KeyValueNode node) { return null; }
    @Override public Void visit(ReturnNode node) { return null; }

    @Override
    public Void visit(ExpressionNode node) {
        return null;
    }

    @Override public Void visit(BreakNode node) { return null; }
    @Override public Void visit(ContinueNode node) { return null; }

    @Override
    public Void visit(ArgumentListNode argumentListNode) {
        return null;
    }
}
