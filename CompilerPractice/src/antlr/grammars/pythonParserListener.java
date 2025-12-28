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
	 * Enter a parse tree produced by the {@code import_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterImport_Statement(pythonParser.Import_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code import_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitImport_Statement(pythonParser.Import_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code global_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_Statement(pythonParser.Global_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code global_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_Statement(pythonParser.Global_StatementContext ctx);
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
	 * Enter a parse tree produced by the {@code for_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_Statement(pythonParser.For_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_Statement(pythonParser.For_StatementContext ctx);
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
	 * Enter a parse tree produced by the {@code break_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak_Statement(pythonParser.Break_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak_Statement(pythonParser.Break_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continue_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue_Statement(pythonParser.Continue_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continue_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue_Statement(pythonParser.Continue_StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pass_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPass_Statement(pythonParser.Pass_StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pass_Statement}
	 * labeled alternative in {@link pythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPass_Statement(pythonParser.Pass_StatementContext ctx);
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
	 * Enter a parse tree produced by the {@code simpleImport}
	 * labeled alternative in {@link pythonParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleImport(pythonParser.SimpleImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleImport}
	 * labeled alternative in {@link pythonParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleImport(pythonParser.SimpleImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fromImport}
	 * labeled alternative in {@link pythonParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterFromImport(pythonParser.FromImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fromImport}
	 * labeled alternative in {@link pythonParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitFromImport(pythonParser.FromImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void enterDottedName(pythonParser.DottedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void exitDottedName(pythonParser.DottedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonParser#importNames}.
	 * @param ctx the parse tree
	 */
	void enterImportNames(pythonParser.ImportNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#importNames}.
	 * @param ctx the parse tree
	 */
	void exitImportNames(pythonParser.ImportNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonParser#globalStatement}.
	 * @param ctx the parse tree
	 */
	void enterGlobalStatement(pythonParser.GlobalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#globalStatement}.
	 * @param ctx the parse tree
	 */
	void exitGlobalStatement(pythonParser.GlobalStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decoratorWithArgs}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecoratorWithArgs(pythonParser.DecoratorWithArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decoratorWithArgs}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecoratorWithArgs(pythonParser.DecoratorWithArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleDecorator}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDecorator(pythonParser.SimpleDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleDecorator}
	 * labeled alternative in {@link pythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDecorator(pythonParser.SimpleDecoratorContext ctx);
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
	 * Enter a parse tree produced by the {@code augmentedAssignment}
	 * labeled alternative in {@link pythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAugmentedAssignment(pythonParser.AugmentedAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code augmentedAssignment}
	 * labeled alternative in {@link pythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAugmentedAssignment(pythonParser.AugmentedAssignmentContext ctx);
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
	 * Enter a parse tree produced by {@link pythonParser#augAssign}.
	 * @param ctx the parse tree
	 */
	void enterAugAssign(pythonParser.AugAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#augAssign}.
	 * @param ctx the parse tree
	 */
	void exitAugAssign(pythonParser.AugAssignContext ctx);
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
	 * Enter a parse tree produced by the {@code passBlock}
	 * labeled alternative in {@link pythonParser#passStatement}.
	 * @param ctx the parse tree
	 */
	void enterPassBlock(pythonParser.PassBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code passBlock}
	 * labeled alternative in {@link pythonParser#passStatement}.
	 * @param ctx the parse tree
	 */
	void exitPassBlock(pythonParser.PassBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakBlock}
	 * labeled alternative in {@link pythonParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakBlock(pythonParser.BreakBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakBlock}
	 * labeled alternative in {@link pythonParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakBlock(pythonParser.BreakBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueBlock}
	 * labeled alternative in {@link pythonParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueBlock(pythonParser.ContinueBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueBlock}
	 * labeled alternative in {@link pythonParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueBlock(pythonParser.ContinueBlockContext ctx);
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
	 * Enter a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link pythonParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(pythonParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link pythonParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(pythonParser.ForLoopContext ctx);
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
	 * Enter a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link pythonParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(pythonParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalOrExpression}
	 * labeled alternative in {@link pythonParser#logicalOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(pythonParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link pythonParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(pythonParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link pythonParser#logicalAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(pythonParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(pythonParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(pythonParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notInExpression}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotInExpression(pythonParser.NotInExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notInExpression}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotInExpression(pythonParser.NotInExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code toComparison}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterToComparison(pythonParser.ToComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code toComparison}
	 * labeled alternative in {@link pythonParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitToComparison(pythonParser.ToComparisonContext ctx);
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
	 * Enter a parse tree produced by {@link pythonParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(pythonParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(pythonParser.CompOpContext ctx);
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
	 * Enter a parse tree produced by the {@code listCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterListCompExpression(pythonParser.ListCompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitListCompExpression(pythonParser.ListCompExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscriptionExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptionExpression(pythonParser.SubscriptionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscriptionExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptionExpression(pythonParser.SubscriptionExpressionContext ctx);
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
	 * Enter a parse tree produced by the {@code noneExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNoneExpression(pythonParser.NoneExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noneExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNoneExpression(pythonParser.NoneExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dictCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDictCompExpression(pythonParser.DictCompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dictCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDictCompExpression(pythonParser.DictCompExpressionContext ctx);
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
	 * Enter a parse tree produced by the {@code setCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterSetCompExpression(pythonParser.SetCompExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setCompExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitSetCompExpression(pythonParser.SetCompExpressionContext ctx);
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
	 * Enter a parse tree produced by the {@code attributeAccess}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAttributeAccess(pythonParser.AttributeAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeAccess}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAttributeAccess(pythonParser.AttributeAccessContext ctx);
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
	 * Enter a parse tree produced by the {@code generatorAtomExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterGeneratorAtomExpression(pythonParser.GeneratorAtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code generatorAtomExpression}
	 * labeled alternative in {@link pythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitGeneratorAtomExpression(pythonParser.GeneratorAtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link pythonParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComprehension(pythonParser.ComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comprehension}
	 * labeled alternative in {@link pythonParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComprehension(pythonParser.ComprehensionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listComprehensionExpression}
	 * labeled alternative in {@link pythonParser#listComp}.
	 * @param ctx the parse tree
	 */
	void enterListComprehensionExpression(pythonParser.ListComprehensionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listComprehensionExpression}
	 * labeled alternative in {@link pythonParser#listComp}.
	 * @param ctx the parse tree
	 */
	void exitListComprehensionExpression(pythonParser.ListComprehensionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code generatorExpression}
	 * labeled alternative in {@link pythonParser#generatorExpr}.
	 * @param ctx the parse tree
	 */
	void enterGeneratorExpression(pythonParser.GeneratorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code generatorExpression}
	 * labeled alternative in {@link pythonParser#generatorExpr}.
	 * @param ctx the parse tree
	 */
	void exitGeneratorExpression(pythonParser.GeneratorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setComprehensionExpression}
	 * labeled alternative in {@link pythonParser#setComp}.
	 * @param ctx the parse tree
	 */
	void enterSetComprehensionExpression(pythonParser.SetComprehensionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setComprehensionExpression}
	 * labeled alternative in {@link pythonParser#setComp}.
	 * @param ctx the parse tree
	 */
	void exitSetComprehensionExpression(pythonParser.SetComprehensionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dictComprehensionExpression}
	 * labeled alternative in {@link pythonParser#dictComp}.
	 * @param ctx the parse tree
	 */
	void enterDictComprehensionExpression(pythonParser.DictComprehensionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dictComprehensionExpression}
	 * labeled alternative in {@link pythonParser#dictComp}.
	 * @param ctx the parse tree
	 */
	void exitDictComprehensionExpression(pythonParser.DictComprehensionExpressionContext ctx);
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
	 * Enter a parse tree produced by the {@code positionalArgument}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterPositionalArgument(pythonParser.PositionalArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code positionalArgument}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitPositionalArgument(pythonParser.PositionalArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code keywordArgument}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterKeywordArgument(pythonParser.KeywordArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code keywordArgument}
	 * labeled alternative in {@link pythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitKeywordArgument(pythonParser.KeywordArgumentContext ctx);
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