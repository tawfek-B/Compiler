// Generated from C:/Users/Asus/ANTLR/CompilerPractice/src/grammars/HTMLWithCSSParser.g4 by ANTLR 4.13.2
package antlr.grammars;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTMLWithCSSParser}.
 */
public interface HTMLWithCSSParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void enterHtmlDocument(HTMLWithCSSParser.HtmlDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void exitHtmlDocument(HTMLWithCSSParser.HtmlDocumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seaWsItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterSeaWsItem(HTMLWithCSSParser.SeaWsItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seaWsItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitSeaWsItem(HTMLWithCSSParser.SeaWsItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scriptletItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterScriptletItem(HTMLWithCSSParser.ScriptletItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scriptletItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitScriptletItem(HTMLWithCSSParser.ScriptletItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xmlItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterXmlItem(HTMLWithCSSParser.XmlItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xmlItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitXmlItem(HTMLWithCSSParser.XmlItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dtdItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterDtdItem(HTMLWithCSSParser.DtdItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dtdItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitDtdItem(HTMLWithCSSParser.DtdItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlCommentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterHtmlCommentItem(HTMLWithCSSParser.HtmlCommentItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlCommentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitHtmlCommentItem(HTMLWithCSSParser.HtmlCommentItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalCommentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterConditionalCommentItem(HTMLWithCSSParser.ConditionalCommentItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalCommentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitConditionalCommentItem(HTMLWithCSSParser.ConditionalCommentItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaExprItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExprItem(HTMLWithCSSParser.JinjaExprItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaExprItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExprItem(HTMLWithCSSParser.JinjaExprItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaBlockItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlockItem(HTMLWithCSSParser.JinjaBlockItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaBlockItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlockItem(HTMLWithCSSParser.JinjaBlockItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaCommfsentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterJinjaCommfsentItem(HTMLWithCSSParser.JinjaCommfsentItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaCommfsentItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitJinjaCommfsentItem(HTMLWithCSSParser.JinjaCommfsentItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlElementItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElementItem(HTMLWithCSSParser.HtmlElementItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlElementItem}
	 * labeled alternative in {@link HTMLWithCSSParser#documentItem}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElementItem(HTMLWithCSSParser.HtmlElementItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlPairedTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlPairedTag(HTMLWithCSSParser.HtmlPairedTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlPairedTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlPairedTag(HTMLWithCSSParser.HtmlPairedTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlVoidTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlVoidTag(HTMLWithCSSParser.HtmlVoidTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlVoidTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlVoidTag(HTMLWithCSSParser.HtmlVoidTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scriptletElement}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterScriptletElement(HTMLWithCSSParser.ScriptletElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scriptletElement}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitScriptletElement(HTMLWithCSSParser.ScriptletElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scriptTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterScriptTag(HTMLWithCSSParser.ScriptTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scriptTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitScriptTag(HTMLWithCSSParser.ScriptTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code styleTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterStyleTag(HTMLWithCSSParser.StyleTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code styleTag}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitStyleTag(HTMLWithCSSParser.StyleTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullStyle}
	 * labeled alternative in {@link HTMLWithCSSParser#style}.
	 * @param ctx the parse tree
	 */
	void enterFullStyle(HTMLWithCSSParser.FullStyleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullStyle}
	 * labeled alternative in {@link HTMLWithCSSParser#style}.
	 * @param ctx the parse tree
	 */
	void exitFullStyle(HTMLWithCSSParser.FullStyleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaExpr}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpr(HTMLWithCSSParser.JinjaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaExpr}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpr(HTMLWithCSSParser.JinjaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaBlockTag}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlockTag(HTMLWithCSSParser.JinjaBlockTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaBlockTag}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlockTag(HTMLWithCSSParser.JinjaBlockTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaRawBlock}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaRawBlock(HTMLWithCSSParser.JinjaRawBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaRawBlock}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaRawBlock(HTMLWithCSSParser.JinjaRawBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jinjaComm}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaComment}.
	 * @param ctx the parse tree
	 */
	void enterJinjaComm(HTMLWithCSSParser.JinjaCommContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jinjaComm}
	 * labeled alternative in {@link HTMLWithCSSParser#jinjaComment}.
	 * @param ctx the parse tree
	 */
	void exitJinjaComm(HTMLWithCSSParser.JinjaCommContext ctx);
	/**
	 * Enter a parse tree produced by the {@code htmlContentBlock}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContentBlock(HTMLWithCSSParser.HtmlContentBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlContentBlock}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContentBlock(HTMLWithCSSParser.HtmlContentBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textData}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlChardata}.
	 * @param ctx the parse tree
	 */
	void enterTextData(HTMLWithCSSParser.TextDataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textData}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlChardata}.
	 * @param ctx the parse tree
	 */
	void exitTextData(HTMLWithCSSParser.TextDataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code wsData}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlChardata}.
	 * @param ctx the parse tree
	 */
	void enterWsData(HTMLWithCSSParser.WsDataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code wsData}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlChardata}.
	 * @param ctx the parse tree
	 */
	void exitWsData(HTMLWithCSSParser.WsDataContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attr}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterAttr(HTMLWithCSSParser.AttrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attr}
	 * labeled alternative in {@link HTMLWithCSSParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitAttr(HTMLWithCSSParser.AttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#htmlMisc}.
	 * @param ctx the parse tree
	 */
	void enterHtmlMisc(HTMLWithCSSParser.HtmlMiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#htmlMisc}.
	 * @param ctx the parse tree
	 */
	void exitHtmlMisc(HTMLWithCSSParser.HtmlMiscContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(HTMLWithCSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(HTMLWithCSSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HTMLWithCSSParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HTMLWithCSSParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#atstatement}.
	 * @param ctx the parse tree
	 */
	void enterAtstatement(HTMLWithCSSParser.AtstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#atstatement}.
	 * @param ctx the parse tree
	 */
	void exitAtstatement(HTMLWithCSSParser.AtstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#media}.
	 * @param ctx the parse tree
	 */
	void enterMedia(HTMLWithCSSParser.MediaContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#media}.
	 * @param ctx the parse tree
	 */
	void exitMedia(HTMLWithCSSParser.MediaContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#media_query}.
	 * @param ctx the parse tree
	 */
	void enterMedia_query(HTMLWithCSSParser.Media_queryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#media_query}.
	 * @param ctx the parse tree
	 */
	void exitMedia_query(HTMLWithCSSParser.Media_queryContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#media_term}.
	 * @param ctx the parse tree
	 */
	void enterMedia_term(HTMLWithCSSParser.Media_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#media_term}.
	 * @param ctx the parse tree
	 */
	void exitMedia_term(HTMLWithCSSParser.Media_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#media_rule}.
	 * @param ctx the parse tree
	 */
	void enterMedia_rule(HTMLWithCSSParser.Media_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#media_rule}.
	 * @param ctx the parse tree
	 */
	void exitMedia_rule(HTMLWithCSSParser.Media_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#keyframe_block}.
	 * @param ctx the parse tree
	 */
	void enterKeyframe_block(HTMLWithCSSParser.Keyframe_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#keyframe_block}.
	 * @param ctx the parse tree
	 */
	void exitKeyframe_block(HTMLWithCSSParser.Keyframe_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#keyframe_selector}.
	 * @param ctx the parse tree
	 */
	void enterKeyframe_selector(HTMLWithCSSParser.Keyframe_selectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#keyframe_selector}.
	 * @param ctx the parse tree
	 */
	void exitKeyframe_selector(HTMLWithCSSParser.Keyframe_selectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void enterRuleset(HTMLWithCSSParser.RulesetContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void exitRuleset(HTMLWithCSSParser.RulesetContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#combined_selector}.
	 * @param ctx the parse tree
	 */
	void enterCombined_selector(HTMLWithCSSParser.Combined_selectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#combined_selector}.
	 * @param ctx the parse tree
	 */
	void exitCombined_selector(HTMLWithCSSParser.Combined_selectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#combinator}.
	 * @param ctx the parse tree
	 */
	void enterCombinator(HTMLWithCSSParser.CombinatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#combinator}.
	 * @param ctx the parse tree
	 */
	void exitCombinator(HTMLWithCSSParser.CombinatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(HTMLWithCSSParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(HTMLWithCSSParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#selpart}.
	 * @param ctx the parse tree
	 */
	void enterSelpart(HTMLWithCSSParser.SelpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#selpart}.
	 * @param ctx the parse tree
	 */
	void exitSelpart(HTMLWithCSSParser.SelpartContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(HTMLWithCSSParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(HTMLWithCSSParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#pseudo}.
	 * @param ctx the parse tree
	 */
	void enterPseudo(HTMLWithCSSParser.PseudoContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#pseudo}.
	 * @param ctx the parse tree
	 */
	void exitPseudo(HTMLWithCSSParser.PseudoContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(HTMLWithCSSParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(HTMLWithCSSParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(HTMLWithCSSParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(HTMLWithCSSParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#terms}.
	 * @param ctx the parse tree
	 */
	void enterTerms(HTMLWithCSSParser.TermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#terms}.
	 * @param ctx the parse tree
	 */
	void exitTerms(HTMLWithCSSParser.TermsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(HTMLWithCSSParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(HTMLWithCSSParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#funct}.
	 * @param ctx the parse tree
	 */
	void enterFunct(HTMLWithCSSParser.FunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#funct}.
	 * @param ctx the parse tree
	 */
	void exitFunct(HTMLWithCSSParser.FunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#any}.
	 * @param ctx the parse tree
	 */
	void enterAny(HTMLWithCSSParser.AnyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#any}.
	 * @param ctx the parse tree
	 */
	void exitAny(HTMLWithCSSParser.AnyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLWithCSSParser#margin_rule}.
	 * @param ctx the parse tree
	 */
	void enterMargin_rule(HTMLWithCSSParser.Margin_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLWithCSSParser#margin_rule}.
	 * @param ctx the parse tree
	 */
	void exitMargin_rule(HTMLWithCSSParser.Margin_ruleContext ctx);
}