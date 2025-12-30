// Generated from C:/Users/Asus/ANTLR/CompilerPractice/src/grammars/HTMLWithCSSParser.g4 by ANTLR 4.13.2
package antlr.grammars;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLWithCSSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLWithCSSParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocument(HTMLWithCSSParser.HtmlDocumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seaWsItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeaWsItem(HTMLWithCSSParser.SeaWsItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scriptletItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptletItem(HTMLWithCSSParser.ScriptletItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xmlItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlItem(HTMLWithCSSParser.XmlItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dtdItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDtdItem(HTMLWithCSSParser.DtdItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlCommentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlCommentItem(HTMLWithCSSParser.HtmlCommentItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalCommentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalCommentItem(HTMLWithCSSParser.ConditionalCommentItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaExprItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExprItem(HTMLWithCSSParser.JinjaExprItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaBlockItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockItem(HTMLWithCSSParser.JinjaBlockItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaCommentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaCommentItem(HTMLWithCSSParser.JinjaCommentItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlElementItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElementItem(HTMLWithCSSParser.HtmlElementItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code topLevelTextItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelTextItem(HTMLWithCSSParser.TopLevelTextItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlPairedTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlPairedTag(HTMLWithCSSParser.HtmlPairedTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlVoidTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlVoidTag(HTMLWithCSSParser.HtmlVoidTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scriptletElement}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptletElement(HTMLWithCSSParser.ScriptletElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scriptTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptTag(HTMLWithCSSParser.ScriptTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code styleTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleTag(HTMLWithCSSParser.StyleTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullStyle}
	 * labeled alternative in {@link HTMLWithCSSParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullStyle(HTMLWithCSSParser.FullStyleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaExpr}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpr(HTMLWithCSSParser.JinjaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaBlockTag}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockTag(HTMLWithCSSParser.JinjaBlockTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaRawBlock}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaRawBlock(HTMLWithCSSParser.JinjaRawBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jinjaComm}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaComm(HTMLWithCSSParser.JinjaCommContext ctx);
	/**
	 * Visit a parse tree produced by the {@code htmlContentBlock}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlContentBlock(HTMLWithCSSParser.HtmlContentBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textData}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlChardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextData(HTMLWithCSSParser.TextDataContext ctx);
	/**
	 * Visit a parse tree produced by the {@code wsData}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlChardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWsData(HTMLWithCSSParser.WsDataContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attr}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr(HTMLWithCSSParser.AttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#htmlMisc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlMisc(HTMLWithCSSParser.HtmlMiscContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(HTMLWithCSSParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(HTMLWithCSSParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#atstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtstatement(HTMLWithCSSParser.AtstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#media}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMedia(HTMLWithCSSParser.MediaContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#media_query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMedia_query(HTMLWithCSSParser.Media_queryContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#media_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMedia_term(HTMLWithCSSParser.Media_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#media_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMedia_rule(HTMLWithCSSParser.Media_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#keyframe_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyframe_block(HTMLWithCSSParser.Keyframe_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#keyframe_selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyframe_selector(HTMLWithCSSParser.Keyframe_selectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#ruleset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleset(HTMLWithCSSParser.RulesetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#combined_selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombined_selector(HTMLWithCSSParser.Combined_selectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#combinator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombinator(HTMLWithCSSParser.CombinatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(HTMLWithCSSParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#selpart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelpart(HTMLWithCSSParser.SelpartContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(HTMLWithCSSParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#pseudo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPseudo(HTMLWithCSSParser.PseudoContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(HTMLWithCSSParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(HTMLWithCSSParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerms(HTMLWithCSSParser.TermsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(HTMLWithCSSParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#funct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunct(HTMLWithCSSParser.FunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#any}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny(HTMLWithCSSParser.AnyContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLWithCSSParser#margin_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMargin_rule(HTMLWithCSSParser.Margin_ruleContext ctx);
}