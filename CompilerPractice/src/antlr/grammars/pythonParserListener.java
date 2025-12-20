// Generated from C:/Users/DELL/IdeaProjects/CompilerPractice/src/grammars/pythonParser.g4 by ANTLR 4.13.2
package antlr.grammars;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pythonParser}.
 */
public interface pythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(pythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(pythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decorated_LN_Function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDecorated_LN_Function_Statement(pythonParser.Decorated_LN_Function_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decorated_LN_Function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDecorated_LN_Function_Statement(pythonParser.Decorated_LN_Function_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decorated_Function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDecorated_Function_Statement(pythonParser.Decorated_Function_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decorated_Function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDecorated_Function_Statement(pythonParser.Decorated_Function_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign_Statement(pythonParser.Assign_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign_Statement(pythonParser.Assign_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_Statement(pythonParser.If_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_Statement(pythonParser.If_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_Statement(pythonParser.While_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_Statement(pythonParser.While_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code try_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterTry_Statement(pythonParser.Try_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code try_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitTry_Statement(pythonParser.Try_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for_Each_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_Each_Statement(pythonParser.For_Each_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for_Each_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_Each_Statement(pythonParser.For_Each_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunction_Statement(pythonParser.Function_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunction_Statement(pythonParser.Function_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_Statement(pythonParser.Return_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_Statement(pythonParser.Return_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_Statement(pythonParser.Expression_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_Statement(pythonParser.Expression_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code routeDecorator}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterRouteDecorator(pythonParser.RouteDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code routeDecorator}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitRouteDecorator(pythonParser.RouteDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link pythonParser#functionDec}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(pythonParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link pythonParser#functionDec}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(pythonParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parameterListDeclaration}
	 * labeled alternative in {@link pythonParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterListDeclaration(pythonParser.ParameterListDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parameterListDeclaration}
	 * labeled alternative in {@link pythonParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterListDeclaration(pythonParser.ParameterListDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link pythonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(pythonParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link pythonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(pythonParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link pythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssign(pythonParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link pythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssign(pythonParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnValue}
	 * labeled alternative in {@link pythonParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(pythonParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnValue}
	 * labeled alternative in {@link pythonParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(pythonParser.ReturnValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifBlock}
	 * labeled alternative in {@link pythonParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(pythonParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifBlock}
	 * labeled alternative in {@link pythonParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(pythonParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elifBlock}
	 * labeled alternative in {@link pythonParser#elifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElifBlock(pythonParser.ElifBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elifBlock}
	 * labeled alternative in {@link pythonParser#elifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElifBlock(pythonParser.ElifBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elseBlock}
	 * labeled alternative in {@link pythonParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(pythonParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elseBlock}
	 * labeled alternative in {@link pythonParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(pythonParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forEachLoop}
	 * labeled alternative in {@link pythonParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForEachLoop(pythonParser.ForEachLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forEachLoop}
	 * labeled alternative in {@link pythonParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForEachLoop(pythonParser.ForEachLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link pythonParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(pythonParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link pythonParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(pythonParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exceptBlock}
	 * labeled alternative in {@link pythonParser#exceptStatement}.
	 * @param ctx the parse tree
	 */
	void enterExceptBlock(pythonParser.ExceptBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exceptBlock}
	 * labeled alternative in {@link pythonParser#exceptStatement}.
	 * @param ctx the parse tree
	 */
	void exitExceptBlock(pythonParser.ExceptBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tryBlock}
	 * labeled alternative in {@link pythonParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryBlock(pythonParser.TryBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tryBlock}
	 * labeled alternative in {@link pythonParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryBlock(pythonParser.TryBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code finallyBlock}
	 * labeled alternative in {@link pythonParser#finallyStatement}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(pythonParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code finallyBlock}
	 * labeled alternative in {@link pythonParser#finallyStatement}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(pythonParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(pythonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(pythonParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link pythonParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpression(pythonParser.CompareExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link pythonParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpression(pythonParser.CompareExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addsubExpression}
	 * labeled alternative in {@link pythonParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddsubExpression(pythonParser.AddsubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addsubExpression}
	 * labeled alternative in {@link pythonParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddsubExpression(pythonParser.AddsubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code muldivExpression}
	 * labeled alternative in {@link pythonParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMuldivExpression(pythonParser.MuldivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code muldivExpression}
	 * labeled alternative in {@link pythonParser#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMuldivExpression(pythonParser.MuldivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpression(pythonParser.ParenthesisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpression(pythonParser.ParenthesisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterListExpression(pythonParser.ListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitListExpression(pythonParser.ListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dictExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDictExpression(pythonParser.DictExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dictExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDictExpression(pythonParser.DictExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(pythonParser.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(pythonParser.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(pythonParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(pythonParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(pythonParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(pythonParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpression(pythonParser.TrueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpression(pythonParser.TrueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpression(pythonParser.FalseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpression(pythonParser.FalseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdExpression(pythonParser.IdExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdExpression(pythonParser.IdExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link pythonParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(pythonParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link pythonParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(pythonParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code argumentListExpression}
	 * labeled alternative in {@link pythonParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentListExpression(pythonParser.ArgumentListExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code argumentListExpression}
	 * labeled alternative in {@link pythonParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentListExpression(pythonParser.ArgumentListExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listLiteralExpression}
	 * labeled alternative in {@link pythonParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteralExpression(pythonParser.ListLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listLiteralExpression}
	 * labeled alternative in {@link pythonParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteralExpression(pythonParser.ListLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dictLiteralExpression}
	 * labeled alternative in {@link pythonParser#dictLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDictLiteralExpression(pythonParser.DictLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dictLiteralExpression}
	 * labeled alternative in {@link pythonParser#dictLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDictLiteralExpression(pythonParser.DictLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dictPairExpression}
	 * labeled alternative in {@link pythonParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterDictPairExpression(pythonParser.DictPairExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dictPairExpression}
	 * labeled alternative in {@link pythonParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitDictPairExpression(pythonParser.DictPairExpressionContext ctx);
}