//package visitors;
//
//import ast.core.*;
//import ast.python.*;
//import antlr.grammars.pythonParser;
//import antlr.grammars.pythonParserBaseVisitor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.antlr.v4.runtime.misc.Interval;
//import org.antlr.v4.runtime.tree.ParseTree.*;
//import org.antlr.v4.runtime.tree.TerminalNode;
//
//public class PythonASTBuilderVisitor extends pythonParserBaseVisitor<ASTNode> {
//
//    // safe visit for all nodes
//    @SuppressWarnings("Unchecked")
//    private <T extends ASTNode> T safeVisit(org.antlr.v4.runtime.tree.ParseTree ctx){
//        if(ctx == null) return null;
//        ASTNode node = visit(ctx);
//
//        if(node == null){
//            System.out.println("Warning: visit returned null for: "+ ctx.getText());
//        }
//        return (T) node;
//    }
//
//    // program
//
//    @Override
//    public ASTNode visitProgram(pythonParser.ProgramContext ctx) {
//        ProgramNode program =
//                new ProgramNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());
//
//        for (pythonParser.StatementContext stmt : ctx.statement()) {
//            ASTNode child = safeVisit(stmt);
//            if(child != null){
//                program.add(child);
//            }
//        }
//        return program;
//    }
//
//    //  block
//
//    @Override
//    public ASTNode visitBlockStatement(pythonParser.BlockStatementContext ctx) {
//        BlockNode block =
//                new BlockNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());
//
//        for (pythonParser.StatementContext stmt : ctx.statement()) {
//            ASTNode blockNode = safeVisit(stmt);
//            if(blockNode != null){
//                block.add(blockNode);
//            }
//        }
//        return block;
//    }
//
//    // imports and globals
//
//    @Override
//    public ASTNode visitSimpleImport(pythonParser.SimpleImportContext ctx) {
//        String rawText = ctx.start.getInputStream().getText(
//                Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex())
//        );
//        return new ImportNode(
//                new IdentifierNode(
//                        ctx.ID().getText(),
//                        ctx.start.getLine(),
//                        ctx.start.getCharPositionInLine()
//                ),
//                rawText,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitFromImport(pythonParser.FromImportContext ctx) {
//        String firstChildName = ctx.getChild(0).getText() !=null ? ctx.getChild(0).getText() : null;
//        String secondChildName = ctx.getChild(1).getText() !=null ? ctx.getChild(1).getText() : null;
//        String rawText = ctx.start.getInputStream().getText(
//                Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex())
//        );
//        return new FromImportNode(
//                new IdentifierNode(
//                        firstChildName,
//                        ctx.start.getLine(),
//                        ctx.start.getCharPositionInLine()
//                ),
//                new IdentifierNode(
//                        secondChildName,
//                        ctx.start.getLine(),
//                        ctx.start.getCharPositionInLine()
//                ),
//                rawText,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitGlobalStatement(pythonParser.GlobalStatementContext ctx) {
//        return new GlobalNode(
//                new IdentifierNode(
//                        ctx.ID().toString(),
//                        ctx.start.getLine(),
//                        ctx.start.getCharPositionInLine()
//                ),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//
//    // statements
//
//    @Override
//    public ASTNode visitAssign(pythonParser.AssignContext ctx) {
//        // 1. Start with the first ID as a base IdentifierNode
//        ExpressionNode target = new IdentifierNode(
//                ctx.ID(0).getText(),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//
//        // 2. Chain AttributeAccessNodes for subsequent IDs (e.g., self.x.y)
//        for (int i = 1; i < ctx.ID().size(); i++) {
//            target = new AttributeAccessNode(
//                    target, // The left side (e.g., 'self' or 'self.x')
//                    ctx.ID(i).getText(), // The right side attribute (e.g., 'x' or 'y')
//                    ctx.start.getLine(),
//                    ctx.start.getCharPositionInLine()
//            );
//        }
//
//        ExpressionNode value = safeVisit(ctx.expr());
//
//        return new AssignmentNode(
//                target,
//                value,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitReturnValue(pythonParser.ReturnValueContext ctx) {
//        ExpressionNode expr = safeVisit(ctx.expr());
//
//        return new ReturnNode(
//                expr,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitBreakBlock(pythonParser.BreakBlockContext ctx) {
//        return new BreakNode(
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitContinueBlock(pythonParser.ContinueBlockContext ctx) {
//        return new ContinueNode(
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitPassBlock(pythonParser.PassBlockContext ctx) {
//        return new PassNode(
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    // if / else / elif
//
//    @Override
//    public ASTNode visitIfBlock(pythonParser.IfBlockContext ctx) {
//        ExpressionNode condition =  safeVisit(ctx.expr());
//
//        BlockNode thenBlock = safeVisit(ctx.block());
//
//        List<ElifNode> elifs = new ArrayList<>();
//        for (var e : ctx.elifStatement()) {
//            ElifNode elifNode = safeVisit(e);
//            if(elifNode != null){
//                elifs.add(elifNode);
//            }
//        }
//
//        ElseNode elseNode = safeVisit(ctx.elseStatement());
//
//
//        return new IfNode(
//                condition,
//                thenBlock,
//                elifs,
//                elseNode,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitElifBlock(pythonParser.ElifBlockContext ctx) {
//        ExpressionNode condition = safeVisit(ctx.expr());
//
//        BlockNode body = safeVisit(ctx.block());
//        return new ElifNode(
//                condition,
//                body,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitElseBlock(pythonParser.ElseBlockContext ctx) {
//
//        BlockNode body = safeVisit(ctx.block());
//        return new ElseNode(
//                body,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    // loops
//
//    @Override
//    public ASTNode visitWhileLoop(pythonParser.WhileLoopContext ctx) {
//
//        ExpressionNode condition = safeVisit(ctx.expr());
//
//        BlockNode body = safeVisit(ctx.block());
//        return new WhileNode(
//                condition,
//                body,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitForLoop(pythonParser.ForLoopContext ctx) {
//
//        ExpressionNode iterable = safeVisit(ctx.expr());
//
//        BlockNode body = safeVisit(ctx.block());
//
//
//        return new ForNode(
//                new IdentifierNode(
//                        ctx.ID().getText(),
//                        ctx.start.getLine(),
//                        ctx.start.getCharPositionInLine()
//                ),
//                iterable,
//                body,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    // try / except / finally
//
//    @Override
//    public ASTNode visitTryBlock(pythonParser.TryBlockContext ctx) {
//        BlockNode tryBlock = safeVisit(ctx.block());
//
//        List<ExceptNode> excepts = new ArrayList<>();
//        for (var ex : ctx.exceptStatement()) {
//            ExceptNode exceptNode = safeVisit(ex);
//            if(exceptNode != null){
//                excepts.add(exceptNode);
//            }
//        }
//
//        FinallyNode finallyNode = safeVisit(ctx.finallyStatement());
//
//
//        return new TryNode(
//                tryBlock,
//                excepts,
//                finallyNode,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitExceptBlock(pythonParser.ExceptBlockContext ctx) {
//        ExpressionNode type = safeVisit(ctx.expr());
//
//
//        BlockNode body = safeVisit(ctx.block());
//        return new ExceptNode(
//                type,
//                null,
//                body,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//
//    @Override
//    public ASTNode visitFinallyBlock(pythonParser.FinallyBlockContext ctx) {
//        BlockNode body = safeVisit(ctx.block());
//        return new FinallyNode(
//                body,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    // functions and decorators
//
//    @Override
//    public ASTNode visitFunctionDeclaration(pythonParser.FunctionDeclarationContext ctx) {
//        List<ParameterNode> params = new ArrayList<>();
//
//        if (ctx.parameterList() != null) {
//            pythonParser.ParameterListDeclarationContext pctx =
//                    (pythonParser.ParameterListDeclarationContext) ctx.parameterList();
//
//            for (var id : pctx.ID()) {
//                params.add(new ParameterNode(
//                        id.getText(),
//                        id.getSymbol().getLine(),
//                        id.getSymbol().getCharPositionInLine()
//                ));
//            }
//        }
//
//        BlockNode body = safeVisit(ctx.block());
//
//        return new FunctionDefNode(
//                ctx.ID().getText(),
//                params,
//                body,
//                new ArrayList<>(),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitSimpleDecorator(pythonParser.SimpleDecoratorContext ctx) {
//        return new DecoratorNode(
//                new StringLiteralNode(
//                        ctx.ID().getText(),
//                        ctx.start.getLine(),
//                        ctx.start.getCharPositionInLine()
//                ),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitParameterListDeclaration(pythonParser.ParameterListDeclarationContext ctx) {
//        return new ParameterNode(
//                ctx.ID().toString(),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    // expressions
//
//    @Override
//    public ASTNode visitCompareExpression(pythonParser.CompareExpressionContext ctx) {
//        ExpressionNode left = safeVisit(ctx.addExpr(0));
//
//        for (int i = 1; i < ctx.addExpr().size(); i++) {
//            ExpressionNode right = safeVisit(ctx.addExpr(i));
//            left = new ComparisonNode(
//                    left,
//                    ctx.getChild(2 * i - 1).getText(),
//                    right,
//                    ctx.start.getLine(),
//                    ctx.start.getCharPositionInLine()
//            );
//        }
//        return left;
//    }
//
//    // function calls
//
//    @Override
//    public ASTNode visitCallExpression(pythonParser.CallExpressionContext ctx) {
//
//        ExpressionNode caller = safeVisit(ctx.atom());
//
//        List<ExpressionNode> args = new ArrayList<>();
//
//        if (ctx.argumentList() != null) {
//            pythonParser.ArgumentListExpressionContext argCtx =
//                    (pythonParser.ArgumentListExpressionContext) ctx.argumentList();
//
//            for (var e : argCtx.argument()) {
//                ExpressionNode argumentNode = safeVisit(e);
//                if(argumentNode != null){
//                    args.add(argumentNode);
//                }
//            }
//        }
//
//        return new CallExpressionNode(
//                caller,
//                args,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    // attributes
//
//    @Override
//    public ASTNode visitAttributeAccess(pythonParser.AttributeAccessContext ctx) {
//
//        ExpressionNode object = safeVisit(ctx.atom());
//
//        return new AttributeAccessNode(
//                object,
//                ctx.ID().getText(),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitSubscriptionExpression(pythonParser.SubscriptionExpressionContext ctx) {
//
//        ExpressionNode object = safeVisit(ctx.atom());
//        ExpressionNode index = safeVisit(ctx.expr());
//
//        return new SubscriptionNode(
//                object,
//                index,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitParenthesisExpression(pythonParser.ParenthesisExpressionContext ctx) {
//        return safeVisit(ctx.expr());
//    }
//
//    @Override
//    public ASTNode visitPositionalArgument(pythonParser.PositionalArgumentContext ctx) {
//        return safeVisit(ctx.expr());
//    }
//
//    @Override
//    public ASTNode visitKeywordArgument(pythonParser.KeywordArgumentContext ctx) {
//        return new KeywordArgumentNode(
//                ctx.ID().getText(),
//                safeVisit(ctx.expr()),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    // addExpr : mulExpr ((PLUS | MINUS) mulExpr)* #addsubExpression
//    @Override
//    public ASTNode visitAddsubExpression(pythonParser.AddsubExpressionContext ctx) {
//        ExpressionNode left = safeVisit(ctx.mulExpr(0));
//
//        for (int i = 1; i < ctx.mulExpr().size(); i++) {
//            ExpressionNode right = safeVisit(ctx.mulExpr(i));
//            left = new BinaryExpressionNode(
//                    left,
//                    ctx.getChild(2 * i - 1).getText(), // '+' or '-'
//                    right,
//                    ctx.start.getLine(),
//                    ctx.start.getCharPositionInLine()
//            );
//        }
//        return left;
//    }
//
//    // mulExpr : atom ((MULTIPLY | DIVIDE | MODIFY) atom)* #muldivExpression
//    @Override
//    public ASTNode visitMuldivExpression(pythonParser.MuldivExpressionContext ctx) {
//        ExpressionNode left = safeVisit(ctx.atom(0));
//
//        for (int i = 1; i < ctx.atom().size(); i++) {
//            ExpressionNode right = safeVisit(ctx.atom(i));
//            left = new BinaryExpressionNode(
//                    left,
//                    ctx.getChild(2 * i - 1).getText(), // '*', '/', or '%'
//                    right,
//                    ctx.start.getLine(),
//                    ctx.start.getCharPositionInLine()
//            );
//        }
//        return left;
//    }
//
//    // generator expression
//
//    @Override
//    public ASTNode visitGeneratorExpression(pythonParser.GeneratorExpressionContext ctx) {
//
//        ExpressionNode resultExpr = safeVisit(ctx.expr());
//
//        if (ctx.comp().size() != 1) {
//            throw new UnsupportedOperationException(
//                    "Multiple 'for' clauses in generator expressions are not supported yet");
//        }
//
//        pythonParser.ComprehensionContext comp = (pythonParser.ComprehensionContext) ctx.comp(0);
//
//        IdentifierNode target = new IdentifierNode(
//                comp.ID().getText(),
//                comp.ID().getSymbol().getLine(),
//                comp.ID().getSymbol().getCharPositionInLine()
//        );
//
//        ExpressionNode iterable = safeVisit(comp.expr(0));
//
//        ExpressionNode condition = null;
//        if (comp.expr().size() > 1) {
//            condition = safeVisit(comp.expr(1));
//        }
//
//        return new GeneratorExpressionNode(
//                resultExpr,
//                target,
//                iterable,
//                condition,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    // list literals
//
//    @Override
//    public ASTNode visitListLiteralExpression(pythonParser.ListLiteralExpressionContext ctx) {
//        List<ExpressionNode> elements = new ArrayList<>();
//
//        for (var e : ctx.expr()) {
//            ExpressionNode elementNode = safeVisit(e);
//            if(elementNode != null){
//                elements.add(elementNode);
//            }
//        }
//
//        return new ListNode(
//                elements,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitNoneExpression(pythonParser.NoneExpressionContext ctx) {
//        return new NoneLiteralNode(
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//
//    @Override
//    public ASTNode visitListComprehensionExpression(pythonParser.ListComprehensionExpressionContext ctx) {
//        ExpressionNode resultExpr = safeVisit(ctx.expr());
//
//
//        if (ctx.comp().size() != 1) {
//            throw new UnsupportedOperationException(
//                    "Multiple 'for' clauses in list comprehensions are not yet supported");
//        }
//
//        pythonParser.ComprehensionContext comp = (pythonParser.ComprehensionContext) ctx.comp(0);
//
//        if(comp != null) {
//
//            IdentifierNode target = new IdentifierNode(
//                    comp.ID().getText(),
//                    comp.ID().getSymbol().getLine(),
//                    comp.ID().getSymbol().getCharPositionInLine()
//            );
//
//            ExpressionNode iterableExpr = safeVisit(comp.expr(0));
//
//            ExpressionNode condition = null;
//            if (comp.expr().size() > 1) {
//                condition = safeVisit(comp.expr(1));
//            }
//
//            return new ListComprehensionNode(
//                    resultExpr,
//                    target,
//                    iterableExpr,
//                    condition,
//                    ctx.start.getLine(),
//                    ctx.start.getCharPositionInLine()
//            );
//        }
//        return null;
//    }
//
//    // dict literals
//
//    @Override
//    public ASTNode visitDictLiteralExpression(pythonParser.DictLiteralExpressionContext ctx) {
//        List<KeyValueNode> entries = new ArrayList<>();
//
//        for (var p : ctx.pair()) {
//            KeyValueNode entryNode = safeVisit(p);
//            if(entryNode != null){
//                entries.add(entryNode);
//            }
//        }
//
//        return new DictNode(
//                entries,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//    @Override
//    public ASTNode visitDictPairExpression(pythonParser.DictPairExpressionContext ctx) {
//        String IDValueName = ctx.STRING() !=null ? ctx.getChild(0).getText() : null;
//        ExpressionNode body = safeVisit(ctx.expr());
//        return new KeyValueNode(
//                new IdentifierNode(
//                        IDValueName,
//                        ctx.start.getLine(),
//                        ctx.start.getCharPositionInLine()
//                ),
//                body,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine()
//        );
//    }
//
//
//
//    // atom
//
//    @Override
//    public ASTNode visitIdExpression(pythonParser.IdExpressionContext ctx) {
//        return new IdentifierNode(ctx.ID().getText(),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine());
//    }
//
//    @Override
//    public ASTNode visitNumberExpression(pythonParser.NumberExpressionContext ctx) {
//        return new NumberLiteralNode(ctx.NUMBER().getText(),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine());
//    }
//
//    @Override
//    public ASTNode visitStringExpression(pythonParser.StringExpressionContext ctx) {
//        return new StringLiteralNode(ctx.STRING().getText(),
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine());
//    }
//
//    @Override
//    public ASTNode visitTrueExpression(pythonParser.TrueExpressionContext ctx) {
//        return new BooleanLiteralNode(true,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine());
//    }
//
//    @Override
//    public ASTNode visitFalseExpression(pythonParser.FalseExpressionContext ctx) {
//        return new BooleanLiteralNode(false,
//                ctx.start.getLine(),
//                ctx.start.getCharPositionInLine());
//    }
//}

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

    // safe visit for all nodes
    @SuppressWarnings("Unchecked")
    private <T extends ASTNode> T safeVisit(org.antlr.v4.runtime.tree.ParseTree ctx){
        if(ctx == null) return null;
        ASTNode node = visit(ctx);

        if(node == null){
            System.out.println("Warning: visit returned null for: "+ ctx.getText());
        }
        return (T) node;
    }

    // program

    @Override
    public ASTNode visitProgram(pythonParser.ProgramContext ctx) {
        ProgramNode program =
                new ProgramNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());

        for (pythonParser.StatementContext stmt : ctx.statement()) {
            ASTNode child = safeVisit(stmt);
            if(child != null){
                program.add(child);
            }
        }
        return program;
    }

    //  block

    @Override
    public ASTNode visitBlockStatement(pythonParser.BlockStatementContext ctx) {
        BlockNode block =
                new BlockNode(ctx.start.getLine(), ctx.start.getCharPositionInLine());

        for (pythonParser.StatementContext stmt : ctx.statement()) {
            ASTNode blockNode = safeVisit(stmt);
            if(blockNode != null){
                block.add(blockNode);
            }
        }
        return block;
    }

    // imports and globals

    @Override
    public ASTNode visitSimpleImport(pythonParser.SimpleImportContext ctx) {
        String rawText = ctx.start.getInputStream().getText(
                org.antlr.v4.runtime.misc.Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex())
        );
        return new ImportNode(
                new IdentifierNode(
                        ctx.ID().getText(),
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                rawText,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitFromImport(pythonParser.FromImportContext ctx) {
        String firstChildName = ctx.getChild(0).getText() !=null ? ctx.getChild(0).getText() : null;
        String secondChildName = ctx.getChild(1).getText() !=null ? ctx.getChild(1).getText() : null;
        String rawText = ctx.start.getInputStream().getText(
                org.antlr.v4.runtime.misc.Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex())
        );
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
                rawText,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitGlobalStatement(pythonParser.GlobalStatementContext ctx) {
        return new GlobalNode(
                new IdentifierNode(
                        ctx.ID(0).getText(),
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
        ExpressionNode target = new IdentifierNode(
                ctx.ID(0).getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );

        for (int i = 1; i < ctx.ID().size(); i++) {
            target = new AttributeAccessNode(
                    target,
                    ctx.ID(i).getText(),
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }

        ExpressionNode value = safeVisit(ctx.expr());

        return new AssignmentNode(
                target,
                value,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitReturnValue(pythonParser.ReturnValueContext ctx) {
        ExpressionNode expr = safeVisit(ctx.expr());

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
        ExpressionNode condition =  safeVisit(ctx.expr());

        BlockNode thenBlock = safeVisit(ctx.block());

        List<ElifNode> elifs = new ArrayList<>();
        for (var e : ctx.elifStatement()) {
            ElifNode elifNode = safeVisit(e);
            if(elifNode != null){
                elifs.add(elifNode);
            }
        }

        ElseNode elseNode = safeVisit(ctx.elseStatement());


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
        ExpressionNode condition = safeVisit(ctx.expr());

        BlockNode body = safeVisit(ctx.block());
        return new ElifNode(
                condition,
                body,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitElseBlock(pythonParser.ElseBlockContext ctx) {

        BlockNode body = safeVisit(ctx.block());
        return new ElseNode(
                body,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    // loops

    @Override
    public ASTNode visitWhileLoop(pythonParser.WhileLoopContext ctx) {

        ExpressionNode condition = safeVisit(ctx.expr());

        BlockNode body = safeVisit(ctx.block());
        return new WhileNode(
                condition,
                body,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitForLoop(pythonParser.ForLoopContext ctx) {

        ExpressionNode iterable = safeVisit(ctx.expr());

        BlockNode body = safeVisit(ctx.block());


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
        BlockNode tryBlock = safeVisit(ctx.block());

        List<ExceptNode> excepts = new ArrayList<>();
        for (var ex : ctx.exceptStatement()) {
            ExceptNode exceptNode = safeVisit(ex);
            if(exceptNode != null){
                excepts.add(exceptNode);
            }
        }

        FinallyNode finallyNode = safeVisit(ctx.finallyStatement());


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
        ExpressionNode type = safeVisit(ctx.expr());


        BlockNode body = safeVisit(ctx.block());
        return new ExceptNode(
                type,
                null,
                body,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    @Override
    public ASTNode visitFinallyBlock(pythonParser.FinallyBlockContext ctx) {
        BlockNode body = safeVisit(ctx.block());
        return new FinallyNode(
                body,
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

        List<DecoratorNode> decorators = new ArrayList<>();

        for (var decoratorCtx : ctx.decorator()) {
            DecoratorNode decoratorNode = safeVisit(decoratorCtx);
            if (decoratorNode != null) {
                decorators.add(decoratorNode);
            }
        }


        BlockNode body = safeVisit(ctx.block());

        return new FunctionDefNode(
                ctx.ID().getText(),
                params,
                body,
                decorators,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    private ASTNode buildDecoratedFunction(pythonParser.DecoratorContext decoratorCtx,
                                           pythonParser.FunctionDecContext functionDecCtx) {
        DecoratorNode decorator = safeVisit(decoratorCtx);
        FunctionDefNode fn = safeVisit(functionDecCtx);

        if (fn == null) return null;

        List<DecoratorNode> decorators = new ArrayList<>(fn.getDecorators());
        if (decorator != null) {
            decorators.add(0, decorator);
        }

        return new FunctionDefNode(
                fn.getName(),
                fn.getParameters(),
                fn.getBody(),
                decorators,
                fn.getLine(),
                fn.getColumn()
        );
    }

    @Override
    public ASTNode visitDecorated_LN_Function_Statement(pythonParser.Decorated_LN_Function_StatementContext ctx) {
        return buildDecoratedFunction(ctx.decorator(), ctx.functionDec());
    }

    @Override
    public ASTNode visitDecorated_Function_Statement(pythonParser.Decorated_Function_StatementContext ctx) {
        return buildDecoratedFunction(ctx.decorator(), ctx.functionDec());
    }

    private List<ExpressionNode> extractArguments(pythonParser.ArgumentListContext argumentList) {
        List<ExpressionNode> args = new ArrayList<>();
        if (argumentList != null) {
            pythonParser.ArgumentListExpressionContext argCtx =
                    (pythonParser.ArgumentListExpressionContext) argumentList;
            for (var e : argCtx.argument()) {
                ExpressionNode argumentNode = safeVisit(e);
                if (argumentNode != null) {
                    args.add(argumentNode);
                }
            }
        }
        return args;
    }

    @Override
    public ASTNode visitSimpleDecorator(pythonParser.SimpleDecoratorContext ctx) {
        ExpressionNode callee = new IdentifierNode(
                ctx.ID().getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );

        List<ExpressionNode> args = extractArguments(ctx.argumentList());

        ExpressionNode expression = new CallExpressionNode(
                callee,
                args,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );

        return new DecoratorNode(
                expression,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitDecoratorWithArgs(pythonParser.DecoratorWithArgsContext ctx) {
        List<TerminalNode> ids = ctx.ID();

        ExpressionNode callee = new IdentifierNode(
                ids.get(0).getText(),
                ids.get(0).getSymbol().getLine(),
                ids.get(0).getSymbol().getCharPositionInLine()
        );

        for (int i = 1; i < ids.size(); i++) {
            callee = new AttributeAccessNode(
                    callee,
                    ids.get(i).getText(),
                    ids.get(i).getSymbol().getLine(),
                    ids.get(i).getSymbol().getCharPositionInLine()
            );
        }

        List<ExpressionNode> args = extractArguments(ctx.argumentList());

        ExpressionNode expression = new CallExpressionNode(
                callee,
                args,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );

        return new DecoratorNode(
                expression,
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
        ExpressionNode left = safeVisit(ctx.addExpr(0));

        for (int i = 1; i < ctx.addExpr().size(); i++) {
            ExpressionNode right = safeVisit(ctx.addExpr(i));
            left = new ComparisonNode(
                    left,
                    ctx.getChild(2 * i - 1).getText(),
                    right,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }
        return left;
    }

    // function calls

    @Override
    public ASTNode visitCallExpression(pythonParser.CallExpressionContext ctx) {

        ExpressionNode caller = safeVisit(ctx.atom());

        List<ExpressionNode> args = new ArrayList<>();

        if (ctx.argumentList() != null) {
            pythonParser.ArgumentListExpressionContext argCtx =
                    (pythonParser.ArgumentListExpressionContext) ctx.argumentList();

            for (var e : argCtx.argument()) {
                ExpressionNode argumentNode = safeVisit(e);
                if(argumentNode != null){
                    args.add(argumentNode);
                }
            }
        }

        return new CallExpressionNode(
                caller,
                args,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    // attributes

    @Override
    public ASTNode visitAttributeAccess(pythonParser.AttributeAccessContext ctx) {

        ExpressionNode object = safeVisit(ctx.atom());

        return new AttributeAccessNode(
                object,
                ctx.ID().getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitSubscriptionExpression(pythonParser.SubscriptionExpressionContext ctx) {

        ExpressionNode object = safeVisit(ctx.atom());
        ExpressionNode index = safeVisit(ctx.expr());

        return new SubscriptionNode(
                object,
                index,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitParenthesisExpression(pythonParser.ParenthesisExpressionContext ctx) {
        return safeVisit(ctx.expr());
    }

    @Override
    public ASTNode visitPositionalArgument(pythonParser.PositionalArgumentContext ctx) {
        return safeVisit(ctx.expr());
    }

    @Override
    public ASTNode visitKeywordArgument(pythonParser.KeywordArgumentContext ctx) {
        return new KeywordArgumentNode(
                ctx.ID().getText(),
                safeVisit(ctx.expr()),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitAddsubExpression(pythonParser.AddsubExpressionContext ctx) {
        ExpressionNode left = safeVisit(ctx.mulExpr(0));

        for (int i = 1; i < ctx.mulExpr().size(); i++) {
            ExpressionNode right = safeVisit(ctx.mulExpr(i));
            left = new BinaryExpressionNode(
                    left,
                    ctx.getChild(2 * i - 1).getText(), // '+' or '-'
                    right,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }
        return left;
    }

    @Override
    public ASTNode visitMuldivExpression(pythonParser.MuldivExpressionContext ctx) {
        ExpressionNode left = safeVisit(ctx.atom(0));

        for (int i = 1; i < ctx.atom().size(); i++) {
            ExpressionNode right = safeVisit(ctx.atom(i));
            left = new BinaryExpressionNode(
                    left,
                    ctx.getChild(2 * i - 1).getText(), // '*', '/', or '%'
                    right,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }
        return left;
    }

    // generator expression

    @Override
    public ASTNode visitGeneratorExpression(pythonParser.GeneratorExpressionContext ctx) {

        ExpressionNode resultExpr = safeVisit(ctx.expr());

        if (ctx.comp().size() != 1) {
            throw new UnsupportedOperationException(
                    "Multiple 'for' clauses in generator expressions are not supported yet");
        }

        pythonParser.ComprehensionContext comp = (pythonParser.ComprehensionContext) ctx.comp(0);

        IdentifierNode target = new IdentifierNode(
                comp.ID().getText(),
                comp.ID().getSymbol().getLine(),
                comp.ID().getSymbol().getCharPositionInLine()
        );

        ExpressionNode iterable = safeVisit(comp.expr(0));

        ExpressionNode condition = null;
        if (comp.expr().size() > 1) {
            condition = safeVisit(comp.expr(1));
        }

        return new GeneratorExpressionNode(
                resultExpr,
                target,
                iterable,
                condition,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    // list literals

    @Override
    public ASTNode visitListLiteralExpression(pythonParser.ListLiteralExpressionContext ctx) {
        List<ExpressionNode> elements = new ArrayList<>();

        for (var e : ctx.expr()) {
            ExpressionNode elementNode = safeVisit(e);
            if(elementNode != null){
                elements.add(elementNode);
            }
        }

        return new ListNode(
                elements,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitNoneExpression(pythonParser.NoneExpressionContext ctx) {
        return new NoneLiteralNode(
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    @Override
    public ASTNode visitListComprehensionExpression(pythonParser.ListComprehensionExpressionContext ctx) {
        ExpressionNode resultExpr = safeVisit(ctx.expr());


        if (ctx.comp().size() != 1) {
            throw new UnsupportedOperationException(
                    "Multiple 'for' clauses in list comprehensions are not yet supported");
        }

        pythonParser.ComprehensionContext comp = (pythonParser.ComprehensionContext) ctx.comp(0);

        if(comp != null) {

            IdentifierNode target = new IdentifierNode(
                    comp.ID().getText(),
                    comp.ID().getSymbol().getLine(),
                    comp.ID().getSymbol().getCharPositionInLine()
            );

            ExpressionNode iterableExpr = safeVisit(comp.expr(0));

            ExpressionNode condition = null;
            if (comp.expr().size() > 1) {
                condition = safeVisit(comp.expr(1));
            }

            return new ListComprehensionNode(
                    resultExpr,
                    target,
                    iterableExpr,
                    condition,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }
        return null;
    }

    // dict literals

    @Override
    public ASTNode visitDictLiteralExpression(pythonParser.DictLiteralExpressionContext ctx) {
        List<KeyValueNode> entries = new ArrayList<>();

        for (var p : ctx.pair()) {
            KeyValueNode entryNode = safeVisit(p);
            if(entryNode != null){
                entries.add(entryNode);
            }
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
        ExpressionNode body = safeVisit(ctx.expr());
        return new KeyValueNode(
                new IdentifierNode(
                        IDValueName,
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine()
                ),
                body,
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

    @Override
    public ASTNode visitLogicalOrExpression(pythonParser.LogicalOrExpressionContext ctx) {
        ExpressionNode left = safeVisit(ctx.logicalAndExpr(0));
        for (int i = 1; i < ctx.logicalAndExpr().size(); i++) {
            ExpressionNode right = safeVisit(ctx.logicalAndExpr(i));
            left = new LogicalExpressionNode(
                    left, "or", right,
                    ctx.start.getLine(), ctx.start.getCharPositionInLine()
            );
        }
        return left;
    }

    @Override
    public ASTNode visitLogicalAndExpression(pythonParser.LogicalAndExpressionContext ctx) {
        ExpressionNode left = safeVisit(ctx.notExpr(0));
        for (int i = 1; i < ctx.notExpr().size(); i++) {
            ExpressionNode right = safeVisit(ctx.notExpr(i));
            left = new LogicalExpressionNode(
                    left, "and", right,
                    ctx.start.getLine(), ctx.start.getCharPositionInLine()
            );
        }
        return left;
    }

    @Override
    public ASTNode visitToComparison(pythonParser.ToComparisonContext ctx) {
        return safeVisit(ctx.compareExpr());
    }

    @Override
    public ASTNode visitNotExpression(pythonParser.NotExpressionContext ctx) {
        ExpressionNode operand = safeVisit(ctx.notExpr());
        return new UnaryExpressionNode(
                "not", operand,
                ctx.start.getLine(), ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitNotInExpression(pythonParser.NotInExpressionContext ctx) {
        ExpressionNode operand = safeVisit(ctx.compareExpr());
        return new UnaryExpressionNode(
                "not in", operand,
                ctx.start.getLine(), ctx.start.getCharPositionInLine()
        );
    }
}