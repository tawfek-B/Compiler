// Generated from C:/Users/Asus/ANTLR/Compiler/src/grammars/pythonParser.g4 by ANTLR 4.13.2
package antlr.grammars;
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
	 * Visit a parse tree produced by the {@code decorated_LN_Function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated_LN_Function_Statement(pythonParser.Decorated_LN_Function_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decorated_Function_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated_Function_Statement(pythonParser.Decorated_Function_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionStatement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(pythonParser.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code import_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_Statement(pythonParser.Import_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code global_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_Statement(pythonParser.Global_StatementContext ctx);
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
	 * Visit a parse tree produced by the {@code while_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_Statement(pythonParser.While_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code try_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_Statement(pythonParser.Try_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_Statement(pythonParser.Return_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_Statement(pythonParser.Break_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_Statement(pythonParser.Continue_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pass_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPass_Statement(pythonParser.Pass_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_Statement(pythonParser.Expression_StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleImport}
	 * labeled alternative in {@link pythonParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleImport(pythonParser.SimpleImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fromImport}
	 * labeled alternative in {@link pythonParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromImport(pythonParser.FromImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#dottedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedName(pythonParser.DottedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#importNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportNames(pythonParser.ImportNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#globalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalStatement(pythonParser.GlobalStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decoratorWithArgs}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorWithArgs(pythonParser.DecoratorWithArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleDecorator}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDecorator(pythonParser.SimpleDecoratorContext ctx);
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
	 * Visit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link pythonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(pythonParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code augmentedAssignment}
	 * labeled alternative in {@link pythonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugmentedAssignment(pythonParser.AugmentedAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link pythonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(pythonParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#augAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugAssign(pythonParser.AugAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnValue}
	 * labeled alternative in {@link pythonParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValue(pythonParser.ReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code passBlock}
	 * labeled alternative in {@link pythonParser#passStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPassBlock(pythonParser.PassBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakBlock}
	 * labeled alternative in {@link pythonParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakBlock(pythonParser.BreakBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueBlock}
	 * labeled alternative in {@link pythonParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueBlock(pythonParser.ContinueBlockContext ctx);
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
	 * Visit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link pythonParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(pythonParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exceptBlock}
	 * labeled alternative in {@link pythonParser#exceptStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptBlock(pythonParser.ExceptBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tryBlock}
	 * labeled alternative in {@link pythonParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryBlock(pythonParser.TryBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code finallyBlock}
	 * labeled alternative in {@link pythonParser#finallyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(pythonParser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(pythonParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link pythonParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(pythonParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link pythonParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(pythonParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(pythonParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notInExpression}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotInExpression(pythonParser.NotInExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code toComparison}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToComparison(pythonParser.ToComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link pythonParser#compareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(pythonParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(pythonParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addsubExpression}
	 * labeled alternative in {@link pythonParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddsubExpression(pythonParser.AddsubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code muldivExpression}
	 * labeled alternative in {@link pythonParser#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuldivExpression(pythonParser.MuldivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListCompExpression(pythonParser.ListCompExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subscriptionExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptionExpression(pythonParser.SubscriptionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(pythonParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisExpression(pythonParser.ParenthesisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noneExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneExpression(pythonParser.NoneExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictCompExpression(pythonParser.DictCompExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpression(pythonParser.FalseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCompExpression(pythonParser.SetCompExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictExpression(pythonParser.DictExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(pythonParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpression(pythonParser.IdExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(pythonParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpression(pythonParser.TrueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeAccess}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeAccess(pythonParser.AttributeAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpression(pythonParser.ListExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code generatorAtomExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorAtomExpression(pythonParser.GeneratorAtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link pythonParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComprehension(pythonParser.ComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listComprehensionExpression}
	 * labeled alternative in {@link pythonParser#listComp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehensionExpression(pythonParser.ListComprehensionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code generatorExpression}
	 * labeled alternative in {@link pythonParser#generatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorExpression(pythonParser.GeneratorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setComprehensionExpression}
	 * labeled alternative in {@link pythonParser#setComp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetComprehensionExpression(pythonParser.SetComprehensionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictComprehensionExpression}
	 * labeled alternative in {@link pythonParser#dictComp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictComprehensionExpression(pythonParser.DictComprehensionExpressionContext ctx);
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
	 * Visit a parse tree produced by the {@code positionalArgument}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionalArgument(pythonParser.PositionalArgumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code keywordArgument}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordArgument(pythonParser.KeywordArgumentContext ctx);
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