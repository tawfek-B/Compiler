package visitors;

import ast.core.*;
import ast.python.*;
import antlr.grammars.pythonParser;
import antlr.grammars.pythonParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class PythonASTBuilderVisitor extends pythonParserBaseVisitor<ASTNode> {

    // program

    @Override
    public ASTNode visitProgram(pythonParser.ProgramContext ctx) {
        ProgramNode program =
                new ProgramNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());

        for (pythonParser.StatementContext stmt : ctx.statement()) {
            program.add(visit(stmt));
        }
        return program;
    }

    //  block

    @Override
    public ASTNode visitBlockStatement(pythonParser.BlockStatementContext ctx) {
        BlockNode block =
                new BlockNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());

        for (pythonParser.StatementContext stmt : ctx.statement()) {
            block.add(visit(stmt));
        }
        return block;
    }

    // imports and globals

    @Override
    public ASTNode visitSimpleImport(pythonParser.SimpleImportContext ctx) {
        return new ImportNode(
                new IdentifierNode(
                        ctx.ID().getText(),
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitFromImport(pythonParser.FromImportContext ctx) {
        String firstChildName = ctx.getChild(0).getText() !=null ? ctx.getChild(0).getText() : null;
        String secondChildName = ctx.getChild(1).getText() !=null ? ctx.getChild(1).getText() : null;
        return new FromImportNode(
                new IdentifierNode(
                        firstChildName,
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                new IdentifierNode(
                        secondChildName,
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitGlobalStatement(pythonParser.GlobalStatementContext ctx) {
        return new GlobalNode(
                new IdentifierNode(
                        ctx.ID().toString(),
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    // statements

    @Override
    public ASTNode visitAssign(pythonParser.AssignContext ctx) {
        StringBuilder idName = new StringBuilder();
        for(TerminalNode ids : ctx.ID()) {

            idName.append(ids.getText() + (ctx.ID().get(ctx.ID().size()-1).equals(ids) ? "" : "."));
        }
        IdentifierNode id = new IdentifierNode(
                idName.toString(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );

        ExpressionNode value =
                (ExpressionNode) visit(ctx.expr());

        return new AssignmentNode(
                id,
                value,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitReturnValue(pythonParser.ReturnValueContext ctx) {
        ExpressionNode expr =
                ctx.expr() != null
                        ? (ExpressionNode) visit(ctx.expr())
                        : null;

        return new ReturnNode(
                expr,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitBreakBlock(pythonParser.BreakBlockContext ctx) {
        return new BreakNode(
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitContinueBlock(pythonParser.ContinueBlockContext ctx) {
        return new ContinueNode(
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitPassBlock(pythonParser.PassBlockContext ctx) {
        return new PassNode(
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    // if / else / elif

    @Override
    public ASTNode visitIfBlock(pythonParser.IfBlockContext ctx) {
        ExpressionNode condition = ctx.expr() !=null ?
                (ExpressionNode) visit(ctx.expr()) : null;

        BlockNode thenBlock = ctx.block() !=null ?
                (BlockNode) visit(ctx.block()) : null;

        List<ElifNode> elifs = new ArrayList<>();
        for (var e : ctx.elifStatement()) {
            elifs.add((ElifNode) visit(e));
        }

        ElseNode elseNode = null;
        if (ctx.elseStatement() != null) {
            elseNode = (ElseNode) visit(ctx.elseStatement());
        }

        return new IfNode(
                condition,
                thenBlock,
                elifs,
                elseNode,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitElifBlock(pythonParser.ElifBlockContext ctx) {
        return new ElifNode(
                (ExpressionNode) visit(ctx.expr()),
                (BlockNode) visit(ctx.block()),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitElseBlock(pythonParser.ElseBlockContext ctx) {
        return new ElseNode(
                (BlockNode) visit(ctx.block()),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    // loops

    @Override
    public ASTNode visitWhileLoop(pythonParser.WhileLoopContext ctx) {
        return new WhileNode(
                (ExpressionNode) visit(ctx.expr()),
                (BlockNode) visit(ctx.block()),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitForLoop(pythonParser.ForLoopContext ctx) {

        ExpressionNode iterable = ctx.expr() !=null ?
                (ExpressionNode) visit(ctx.expr()) : null;

        BlockNode body = ctx.block() !=null ?
                (BlockNode) visit(ctx.block()) : null;


        return new ForNode(
                new IdentifierNode(
                        ctx.ID().getText(),
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                iterable,
                body,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    // try / except / finally

    @Override
    public ASTNode visitTryBlock(pythonParser.TryBlockContext ctx) {
        BlockNode tryBlock =
                (BlockNode) visit(ctx.block());

        List<ExceptNode> excepts = new ArrayList<>();
        for (var ex : ctx.exceptStatement()) {
            excepts.add((ExceptNode) visit(ex));
        }

        FinallyNode finallyNode = null;
        if (ctx.finallyStatement() != null) {
            finallyNode = (FinallyNode) visit(ctx.finallyStatement());
        }

        return new TryNode(
                tryBlock,
                excepts,
                finallyNode,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitExceptBlock(pythonParser.ExceptBlockContext ctx) {
        ExpressionNode type = null;
        if (ctx.expr() != null) {
            type = (ExpressionNode) visit(ctx.expr());
        }

        return new ExceptNode(
                type,
                null,
                (BlockNode) visit(ctx.block()),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    @Override
    public ASTNode visitFinallyBlock(pythonParser.FinallyBlockContext ctx) {
        return new FinallyNode(
                (BlockNode) visit(ctx.block()),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    // functions and decorators





    @Override
    public ASTNode visitFunctionDeclaration(pythonParser.FunctionDeclarationContext ctx) {
        List<ParameterNode> params = new ArrayList<>();

        if (ctx.parameterList() != null) {
            pythonParser.ParameterListDeclarationContext pctx =
                    (pythonParser.ParameterListDeclarationContext) ctx.parameterList();

            for (var id : pctx.ID()) {
                params.add(new ParameterNode(
                        id.getText(),
                        id.getSymbol().getLine(),
                        id.getSymbol().getCharPositionInLine()
                ));
            }
        }

        return new FunctionDefNode(
                ctx.ID().getText(),
                params,
                (BlockNode) visit(ctx.block()),
                new ArrayList<>(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitSimpleDecorator(pythonParser.SimpleDecoratorContext ctx) {
        return new DecoratorNode(
                new StringLiteralNode(
                        ctx.ID().getText(),
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitParameterListDeclaration(pythonParser.ParameterListDeclarationContext ctx) {
        return new ParameterNode(
                ctx.ID().toString(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    // expressions

    @Override
    public ASTNode visitCompareExpression(pythonParser.CompareExpressionContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.addExpr(0));

        for (int i = 1; i < ctx.addExpr().size(); i++) {
            left = new ComparisonNode(
                    left,
                    ctx.getChild(2 * i - 1).getText(),
                    (ExpressionNode) visit(ctx.addExpr(i)),
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }
        return left;
    }


    @Override
    public ASTNode visitFunctionCallExpression(
            pythonParser.FunctionCallExpressionContext ctx
    ) {
        List<ExpressionNode> args = new ArrayList<>();

        if (ctx.argumentList() != null) {
            pythonParser.ArgumentListExpressionContext argCtx =
                    (pythonParser.ArgumentListExpressionContext) ctx.argumentList();

            for (var e : argCtx.argument()) {
                args.add((ExpressionNode) visit(e));
            }
        }

        return new CallExpressionNode(
                new IdentifierNode(
                        ctx.ID().getText(),
                        ctx.ID().getSymbol().getLine(),
                        ctx.ID().getSymbol().getCharPositionInLine()
                ),
                args,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }



    @Override
    public ASTNode visitListLiteralExpression(pythonParser.ListLiteralExpressionContext ctx) {
        List<ExpressionNode> elements = new ArrayList<>();

        for (var e : ctx.expr()) {
            elements.add((ExpressionNode) visit(e));
        }

        return new ListNode(
                elements,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitListComprehensionExpression(pythonParser.ListComprehensionExpressionContext ctx) {
        // The expression that gets evaluated for each item: [ <this> for ... ]
        ExpressionNode resultExpr = (ExpressionNode) visit(ctx.expr());

        // For most simple cases we expect exactly one comprehension clause
        // (you can later extend to support multiple for-clauses if needed)

        if (ctx.comp().size() != 1) {
            // You can throw an exception or handle multiple for-clauses later
            throw new UnsupportedOperationException(
                    "Multiple 'for' clauses in list comprehensions are not yet supported");
        }

        // Get the first (and usually only) comprehension clause
        pythonParser.ComprehensionContext comp = (pythonParser.ComprehensionContext) ctx.comp(1);

        if(comp != null) {

            // The loop variable (x in "for x in ...")
            IdentifierNode target = new IdentifierNode(
                    comp.ID().getText(),
                    comp.ID().getSymbol().getLine(),
                    comp.ID().getSymbol().getCharPositionInLine()
            );

            // The iterable expression (after "in")
            ExpressionNode iterableExpr = (ExpressionNode) visit(comp.expr(0));

            // Optional if-condition
            ExpressionNode condition = null;
            if (comp.expr().size() > 1) {
                condition = (ExpressionNode) visit(comp.expr(1));
            }

            return new ListComprehensionNode(
                    resultExpr,       // what to put in the list
                    target,           // the loop variable
                    iterableExpr,     // the source collection
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }
        return null;
    }

    @Override
    public ASTNode visitDictLiteralExpression(pythonParser.DictLiteralExpressionContext ctx) {
        List<KeyValueNode> entries = new ArrayList<>();

        for (var p : ctx.pair()) {
            entries.add((KeyValueNode) visit(p));
        }

        return new DictNode(
                entries,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitDictPairExpression(pythonParser.DictPairExpressionContext ctx) {
        String IDValueName = ctx.STRING() !=null ? ctx.getChild(0).getText() : null;
        return new KeyValueNode(
                new IdentifierNode(
                        IDValueName,
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                (ExpressionNode) visit(ctx.expr()),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }



    // atom

    @Override
    public ASTNode visitIdExpression(pythonParser.IdExpressionContext ctx) {
        return new IdentifierNode(ctx.ID().getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitNumberExpression(pythonParser.NumberExpressionContext ctx) {
        return new NumberLiteralNode(ctx.NUMBER().getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitStringExpression(pythonParser.StringExpressionContext ctx) {
        return new StringLiteralNode(ctx.STRING().getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitTrueExpression(pythonParser.TrueExpressionContext ctx) {
        return new BooleanLiteralNode(true,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitFalseExpression(pythonParser.FalseExpressionContext ctx) {
        return new BooleanLiteralNode(false,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine());
    }
}
