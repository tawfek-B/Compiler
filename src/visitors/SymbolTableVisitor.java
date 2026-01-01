package visitors;

import ast.core.*;
import ast.css.CssDocumentNode;
import ast.css.CssNode;
import ast.css.CssRuleNode;
import ast.css.CssSelectorNode;
import ast.html.HtmlDocumentNode;
import ast.html.HtmlTagNode;
import ast.jinja.JinjaBlockNode;
import ast.jinja.JinjaExpressionNode;
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

        if (node.getBody() != null) {

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

    @Override
    public Void visit(IdentifierNode node) {
        return null;
    }

    @Override
    public Void visit(NumberLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(StringLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(BooleanLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(NullLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(ListNode node) {
        return null;
    }

    @Override
    public Void visit(DictNode node) {
        return null;
    }

    @Override
    public Void visit(KeyValueNode node) {
        return null;
    }

    @Override
    public Void visit(ReturnNode node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNode node) {
        return null;
    }

    @Override
    public Void visit(BreakNode node) {
        return null;
    }

    @Override
    public Void visit(ContinueNode node) {
        return null;
    }

    @Override
    public Void visit(ArgumentListNode argumentListNode) {
        return null;
    }

    @Override
    public Void visit(HtmlDocumentNode node) {

        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(JinjaBlockNode node) {
        String blockName = node.getName();

        if (!node.getName().equals("end")) {

            String blockLabel = labelTable.generateBlockLabel(blockName);

            symbolTable.addSymbol(
                    blockName,
                    "jinja_block",
                    blockLabel,
                    node.getLine(),
                    node.getColumn()
            );

            symbolTable.enterScope("jinja_block_" + blockName);

            for (ASTNode child : node.getChildren()) {
                child.accept(this);
            }

            symbolTable.exitScope();
        }

        return null;
    }

    @Override
    public Void visit(CssDocumentNode node) {

        for (CssRuleNode child : node.getRules()) {
            child.accept(this);
            for (CssSelectorNode sel : child.getSelectors()) {
                String selText = sel.getSelector().trim();
                if (selText.startsWith(".")) {
                    String className = selText.substring(1);
                    symbolTable.addSymbol(
                            className,
                            "css_class",
                            String.valueOf(child.getDeclarations().size()) + " declarations",
                            sel.getLine(),
                            sel.getColumn()
                    );
                } else {
                    symbolTable.addSymbol(
                            selText,
                            "css_selector",
                            String.valueOf(child.getDeclarations().size()) + " declarations",
                            sel.getLine(),
                            sel.getColumn()
                    );
                }
            }
        }

        for (CssRuleNode rule : node.getRules()) {
            rule.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(HtmlTagNode node) {

        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(JinjaExpressionNode node) {

        if (node.getExpression() != null) {
            collectJinjaVariables(node.getExpression(), node.getLine(), node.getColumn());
        }
        return null;
    }

    private void collectJinjaVariables(ASTNode expr, int line, int column) {
        if (expr == null) return;

        if (expr instanceof IdentifierNode id) {
            symbolTable.addSymbol(id.getName(), "jinja_variable", null, line, column);
        } else if (expr instanceof BinaryExpressionNode bin) {
            if (bin.getOperator().equals(".")) {
                collectJinjaVariables(bin.getLeft(), line, column);
            }
            else if (bin.getOperator().equals("|")) {
                collectJinjaVariables(bin.getRight(), line, column);
            }
            collectJinjaVariables(bin.getLeft(), line, column);
            collectJinjaVariables(bin.getRight(), line, column);
        } else if (expr instanceof CallExpressionNode call) {
            if (call.getCallee() instanceof IdentifierNode funcId) {
                symbolTable.addSymbol(funcId.getName(), "jinja_function", null, line, column);
            }
            for (ExpressionNode arg : call.getArguments()) {
                collectJinjaVariables(arg, line, column);
            }
        } else {
            for (ASTNode child : expr.getChildren()) {
                collectJinjaVariables(child, line, column);
            }
        }
    }
}
