// Generated from C:/Users/DELL/IdeaProjects/CompilerPractice/src/grammars/pythonParser.g4 by ANTLR 4.13.2
package grammars;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link pythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface pythonParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link pythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(pythonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_Statement(pythonParser.Assign_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_Statement(pythonParser.If_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_Statement(pythonParser.For_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for_Each_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_Each_Statement(pythonParser.For_Each_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_Statement(pythonParser.Function_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decorated_Function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated_Function_Statement(pythonParser.Decorated_Function_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_Statement(pythonParser.Return_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_Statement(pythonParser.Expression_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routeDecorator}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteDecorator(pythonParser.RouteDecoratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link pythonParser#functionDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(pythonParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parameterListDeclaration}
	 * labeled alternative in {@link pythonParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterListDeclaration(pythonParser.ParameterListDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link pythonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(pythonParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnValue}
	 * labeled alternative in {@link pythonParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValue(pythonParser.ReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifBlock}
	 * labeled alternative in {@link pythonParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(pythonParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elifBlock}
	 * labeled alternative in {@link pythonParser#elifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifBlock(pythonParser.ElifBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elseBlock}
	 * labeled alternative in {@link pythonParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(pythonParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link pythonParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(pythonParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forEachLoop}
	 * labeled alternative in {@link pythonParser#forEachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachLoop(pythonParser.ForEachLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(pythonParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(pythonParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code muldivExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuldivExpression(pythonParser.MuldivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(pythonParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(pythonParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpression(pythonParser.IdExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addsubExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddsubExpression(pythonParser.AddsubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(pythonParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpression(pythonParser.TrueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpression(pythonParser.ParenthesisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpression(pythonParser.FalseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression(pythonParser.ListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictExpression}
	 * labeled alternative in {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictExpression(pythonParser.DictExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link pythonParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(pythonParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code argumentListExpression}
	 * labeled alternative in {@link pythonParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentListExpression(pythonParser.ArgumentListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listLiteralExpression}
	 * labeled alternative in {@link pythonParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteralExpression(pythonParser.ListLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictLiteralExpression}
	 * labeled alternative in {@link pythonParser#dictLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictLiteralExpression(pythonParser.DictLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictPairExpression}
	 * labeled alternative in {@link pythonParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictPairExpression(pythonParser.DictPairExpressionContext ctx);
}