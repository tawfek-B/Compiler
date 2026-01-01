// Generated from C:/Users/DELL/IdeaProjects/CompilerPractice/src/grammars/HTMLWithCSSParser.g4 by ANTLR 4.13.2
package antlr.grammars;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class HTMLWithCSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		JINJA_BLOCK_OPEN=1, JINJA_EXPR_OPEN=2, JINJA_COMMENT_OPEN=3, JINJA_RAW_OPEN=4, 
		JINJA_ENDRAW=5, TAG_OPEN=6, SCRIPT_OPEN=7, STYLE_OPEN=8, HTML_COMMENT=9, 
		HTML_CONDITIONAL_COMMENT=10, XML=11, CDATA=12, DTD=13, SCRIPTLET=14, SEA_WS=15, 
		HTML_TEXT=16, TAG_CLOSE=17, TAG_SLASH_CLOSE=18, TAG_SLASH=19, TAG_EQUALS=20, 
		TAG_NAME=21, TAG_WHITESPACE=22, ATTVALUE_VALUE=23, ATTRIBUTE=24, SCRIPT_BODY=25, 
		SCRIPT_SHORT_BODY=26, STYLE_CLOSE=27, CHARSET=28, IMPORT=29, KEYFRAMES=30, 
		MEDIA=31, PAGE=32, MARGIN_AREA=33, VIEWPORT=34, FONTFACE=35, ATKEYWORD=36, 
		CLASSKEYWORD=37, STRING=38, UNCLOSED_STRING=39, HASH=40, INDEX=41, NUMBER=42, 
		PERCENTAGE=43, DIMENSION=44, URI=45, UNCLOSED_URI=46, UNIRANGE=47, CDO=48, 
		CDC=49, SEMICOLON=50, COLON=51, COMMA=52, LCURLY=53, RCURLY=54, LPAREN=55, 
		RPAREN=56, LBRACKET=57, RBRACKET=58, EXCLAMATION=59, TILDE=60, MINUS=61, 
		PLUS=62, ASTERISK=63, POUND=64, INCLUDES=65, DASHMATCH=66, STARTSWITH=67, 
		ENDSWITH=68, CONTAINS=69, EQUALS=70, SLASH=71, GREATER=72, FUNCTION=73, 
		IDENT=74, S=75, COMMENT=76, SL_COMMENT=77, IMPORTANT=78, CSS_TEXT=79, 
		JINJA_BLOCK_CLOSE=80, JINJA_BLOCK_CONTENT=81, JINJA_EXPR_CLOSE=82, JINJA_EXPR_CONTENT=83, 
		JINJA_COMMENT_CLOSE=84, JINJA_COMMENT_CONTENT=85, JINJA_RAW_END=86, JINJA_RAW_CONTENT=87;
	public static final int
		RULE_htmlDocument = 0, RULE_documentItem = 1, RULE_htmlElement = 2, RULE_jinjaExpression = 3, 
		RULE_jinjaBlock = 4, RULE_jinjaComment = 5, RULE_htmlContent = 6, RULE_htmlChardata = 7, 
		RULE_htmlAttribute = 8, RULE_htmlMisc = 9, RULE_stylesheet = 10, RULE_statement = 11, 
		RULE_atstatement = 12, RULE_media = 13, RULE_media_query = 14, RULE_media_term = 15, 
		RULE_media_rule = 16, RULE_keyframe_block = 17, RULE_keyframe_selector = 18, 
		RULE_ruleset = 19, RULE_combined_selector = 20, RULE_combinator = 21, 
		RULE_selector = 22, RULE_selpart = 23, RULE_attribute = 24, RULE_pseudo = 25, 
		RULE_declarations = 26, RULE_declaration = 27, RULE_terms = 28, RULE_term = 29, 
		RULE_funct = 30, RULE_any = 31, RULE_margin_rule = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlDocument", "documentItem", "htmlElement", "jinjaExpression", "jinjaBlock", 
			"jinjaComment", "htmlContent", "htmlChardata", "htmlAttribute", "htmlMisc", 
			"stylesheet", "statement", "atstatement", "media", "media_query", "media_term", 
			"media_rule", "keyframe_block", "keyframe_selector", "ruleset", "combined_selector", 
			"combinator", "selector", "selpart", "attribute", "pseudo", "declarations", 
			"declaration", "terms", "term", "funct", "any", "margin_rule"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{%'", "'{{'", "'{#'", "'{% raw %}'", null, "'<'", null, null, 
			null, null, null, null, null, null, null, null, null, "'/>'", null, null, 
			null, null, null, null, null, null, "'</style>'", null, "'@import'", 
			"'@keyframes'", "'@media'", "'@page'", null, "'@viewport'", "'@font-face'", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'<!--'", "'<--'", "';'", "':'", "','", "'{'", "'}'", "'('", "')'", "'['", 
			"']'", "'!'", "'~'", "'-'", "'+'", "'*'", "'#'", "'~='", "'|='", "'^='", 
			"'$='", "'*='", null, null, null, null, null, null, null, null, null, 
			null, "'%}'", null, "'}}'", null, "'#}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "JINJA_BLOCK_OPEN", "JINJA_EXPR_OPEN", "JINJA_COMMENT_OPEN", "JINJA_RAW_OPEN", 
			"JINJA_ENDRAW", "TAG_OPEN", "SCRIPT_OPEN", "STYLE_OPEN", "HTML_COMMENT", 
			"HTML_CONDITIONAL_COMMENT", "XML", "CDATA", "DTD", "SCRIPTLET", "SEA_WS", 
			"HTML_TEXT", "TAG_CLOSE", "TAG_SLASH_CLOSE", "TAG_SLASH", "TAG_EQUALS", 
			"TAG_NAME", "TAG_WHITESPACE", "ATTVALUE_VALUE", "ATTRIBUTE", "SCRIPT_BODY", 
			"SCRIPT_SHORT_BODY", "STYLE_CLOSE", "CHARSET", "IMPORT", "KEYFRAMES", 
			"MEDIA", "PAGE", "MARGIN_AREA", "VIEWPORT", "FONTFACE", "ATKEYWORD", 
			"CLASSKEYWORD", "STRING", "UNCLOSED_STRING", "HASH", "INDEX", "NUMBER", 
			"PERCENTAGE", "DIMENSION", "URI", "UNCLOSED_URI", "UNIRANGE", "CDO", 
			"CDC", "SEMICOLON", "COLON", "COMMA", "LCURLY", "RCURLY", "LPAREN", "RPAREN", 
			"LBRACKET", "RBRACKET", "EXCLAMATION", "TILDE", "MINUS", "PLUS", "ASTERISK", 
			"POUND", "INCLUDES", "DASHMATCH", "STARTSWITH", "ENDSWITH", "CONTAINS", 
			"EQUALS", "SLASH", "GREATER", "FUNCTION", "IDENT", "S", "COMMENT", "SL_COMMENT", 
			"IMPORTANT", "CSS_TEXT", "JINJA_BLOCK_CLOSE", "JINJA_BLOCK_CONTENT", 
			"JINJA_EXPR_CLOSE", "JINJA_EXPR_CONTENT", "JINJA_COMMENT_CLOSE", "JINJA_COMMENT_CONTENT", 
			"JINJA_RAW_END", "JINJA_RAW_CONTENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HTMLWithCSSParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HTMLWithCSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlDocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HTMLWithCSSParser.EOF, 0); }
		public List<DocumentItemContext> documentItem() {
			return getRuleContexts(DocumentItemContext.class);
		}
		public DocumentItemContext documentItem(int i) {
			return getRuleContext(DocumentItemContext.class,i);
		}
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterHtmlDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitHtmlDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitHtmlDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_htmlDocument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126942L) != 0)) {
				{
				{
				setState(66);
				documentItem();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentItemContext extends ParserRuleContext {
		public DocumentItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentItem; }
	 
		public DocumentItemContext() { }
		public void copyFrom(DocumentItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SeaWsItemContext extends DocumentItemContext {
		public TerminalNode SEA_WS() { return getToken(HTMLWithCSSParser.SEA_WS, 0); }
		public SeaWsItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterSeaWsItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitSeaWsItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitSeaWsItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprItemContext extends DocumentItemContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public JinjaExprItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterJinjaExprItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitJinjaExprItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitJinjaExprItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockItemContext extends DocumentItemContext {
		public JinjaBlockContext jinjaBlock() {
			return getRuleContext(JinjaBlockContext.class,0);
		}
		public JinjaBlockItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterJinjaBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitJinjaBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitJinjaBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DtdItemContext extends DocumentItemContext {
		public TerminalNode DTD() { return getToken(HTMLWithCSSParser.DTD, 0); }
		public DtdItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterDtdItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitDtdItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitDtdItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlCommentItemContext extends DocumentItemContext {
		public TerminalNode HTML_COMMENT() { return getToken(HTMLWithCSSParser.HTML_COMMENT, 0); }
		public HtmlCommentItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterHtmlCommentItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitHtmlCommentItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitHtmlCommentItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementItemContext extends DocumentItemContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlElementItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterHtmlElementItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitHtmlElementItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitHtmlElementItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TopLevelTextItemContext extends DocumentItemContext {
		public HtmlChardataContext htmlChardata() {
			return getRuleContext(HtmlChardataContext.class,0);
		}
		public TopLevelTextItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterTopLevelTextItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitTopLevelTextItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitTopLevelTextItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XmlItemContext extends DocumentItemContext {
		public TerminalNode XML() { return getToken(HTMLWithCSSParser.XML, 0); }
		public XmlItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterXmlItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitXmlItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitXmlItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommentItemContext extends DocumentItemContext {
		public JinjaCommentContext jinjaComment() {
			return getRuleContext(JinjaCommentContext.class,0);
		}
		public JinjaCommentItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterJinjaCommentItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitJinjaCommentItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitJinjaCommentItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScriptletItemContext extends DocumentItemContext {
		public TerminalNode SCRIPTLET() { return getToken(HTMLWithCSSParser.SCRIPTLET, 0); }
		public ScriptletItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterScriptletItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitScriptletItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitScriptletItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalCommentItemContext extends DocumentItemContext {
		public TerminalNode HTML_CONDITIONAL_COMMENT() { return getToken(HTMLWithCSSParser.HTML_CONDITIONAL_COMMENT, 0); }
		public ConditionalCommentItemContext(DocumentItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterConditionalCommentItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitConditionalCommentItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitConditionalCommentItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentItemContext documentItem() throws RecognitionException {
		DocumentItemContext _localctx = new DocumentItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_documentItem);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SeaWsItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(SEA_WS);
				}
				break;
			case 2:
				_localctx = new ScriptletItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(SCRIPTLET);
				}
				break;
			case 3:
				_localctx = new XmlItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(XML);
				}
				break;
			case 4:
				_localctx = new DtdItemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(DTD);
				}
				break;
			case 5:
				_localctx = new HtmlCommentItemContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(HTML_COMMENT);
				}
				break;
			case 6:
				_localctx = new ConditionalCommentItemContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				match(HTML_CONDITIONAL_COMMENT);
				}
				break;
			case 7:
				_localctx = new JinjaExprItemContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				jinjaExpression();
				}
				break;
			case 8:
				_localctx = new JinjaBlockItemContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
				jinjaBlock();
				}
				break;
			case 9:
				_localctx = new JinjaCommentItemContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(82);
				jinjaComment();
				}
				break;
			case 10:
				_localctx = new HtmlElementItemContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(83);
				htmlElement();
				}
				break;
			case 11:
				_localctx = new TopLevelTextItemContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(84);
				htmlChardata();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlVoidTagContext extends HtmlElementContext {
		public TerminalNode TAG_OPEN() { return getToken(HTMLWithCSSParser.TAG_OPEN, 0); }
		public TerminalNode TAG_NAME() { return getToken(HTMLWithCSSParser.TAG_NAME, 0); }
		public TerminalNode TAG_SLASH_CLOSE() { return getToken(HTMLWithCSSParser.TAG_SLASH_CLOSE, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public HtmlVoidTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterHtmlVoidTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitHtmlVoidTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitHtmlVoidTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScriptletElementContext extends HtmlElementContext {
		public TerminalNode SCRIPTLET() { return getToken(HTMLWithCSSParser.SCRIPTLET, 0); }
		public ScriptletElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterScriptletElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitScriptletElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitScriptletElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlPairedTagContext extends HtmlElementContext {
		public List<TerminalNode> TAG_OPEN() { return getTokens(HTMLWithCSSParser.TAG_OPEN); }
		public TerminalNode TAG_OPEN(int i) {
			return getToken(HTMLWithCSSParser.TAG_OPEN, i);
		}
		public List<TerminalNode> TAG_NAME() { return getTokens(HTMLWithCSSParser.TAG_NAME); }
		public TerminalNode TAG_NAME(int i) {
			return getToken(HTMLWithCSSParser.TAG_NAME, i);
		}
		public List<TerminalNode> TAG_CLOSE() { return getTokens(HTMLWithCSSParser.TAG_CLOSE); }
		public TerminalNode TAG_CLOSE(int i) {
			return getToken(HTMLWithCSSParser.TAG_CLOSE, i);
		}
		public TerminalNode TAG_SLASH() { return getToken(HTMLWithCSSParser.TAG_SLASH, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public HtmlContentContext htmlContent() {
			return getRuleContext(HtmlContentContext.class,0);
		}
		public HtmlPairedTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterHtmlPairedTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitHtmlPairedTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitHtmlPairedTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScriptTagContext extends HtmlElementContext {
		public TerminalNode SCRIPT_OPEN() { return getToken(HTMLWithCSSParser.SCRIPT_OPEN, 0); }
		public TerminalNode SCRIPT_BODY() { return getToken(HTMLWithCSSParser.SCRIPT_BODY, 0); }
		public TerminalNode SCRIPT_SHORT_BODY() { return getToken(HTMLWithCSSParser.SCRIPT_SHORT_BODY, 0); }
		public ScriptTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterScriptTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitScriptTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitScriptTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StyleTagContext extends HtmlElementContext {
		public TerminalNode STYLE_OPEN() { return getToken(HTMLWithCSSParser.STYLE_OPEN, 0); }
		public StylesheetContext stylesheet() {
			return getRuleContext(StylesheetContext.class,0);
		}
		public TerminalNode STYLE_CLOSE() { return getToken(HTMLWithCSSParser.STYLE_CLOSE, 0); }
		public StyleTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterStyleTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitStyleTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitStyleTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlElement);
		int _la;
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new HtmlPairedTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(TAG_OPEN);
				setState(88);
				match(TAG_NAME);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(89);
					htmlAttribute();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(TAG_CLOSE);
				setState(97);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(96);
					htmlContent();
					}
					break;
				}
				setState(99);
				match(TAG_OPEN);
				setState(100);
				match(TAG_SLASH);
				setState(101);
				match(TAG_NAME);
				setState(102);
				match(TAG_CLOSE);
				}
				break;
			case 2:
				_localctx = new HtmlVoidTagContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(TAG_OPEN);
				setState(104);
				match(TAG_NAME);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(105);
					htmlAttribute();
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				match(TAG_SLASH_CLOSE);
				}
				break;
			case 3:
				_localctx = new ScriptletElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(SCRIPTLET);
				}
				break;
			case 4:
				_localctx = new ScriptTagContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				match(SCRIPT_OPEN);
				setState(114);
				_la = _input.LA(1);
				if ( !(_la==SCRIPT_BODY || _la==SCRIPT_SHORT_BODY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 5:
				_localctx = new StyleTagContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(STYLE_OPEN);
				setState(116);
				stylesheet();
				setState(117);
				match(STYLE_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ParserRuleContext {
		public JinjaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpression; }
	 
		public JinjaExpressionContext() { }
		public void copyFrom(JinjaExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprContext extends JinjaExpressionContext {
		public TerminalNode JINJA_EXPR_OPEN() { return getToken(HTMLWithCSSParser.JINJA_EXPR_OPEN, 0); }
		public TerminalNode JINJA_EXPR_CONTENT() { return getToken(HTMLWithCSSParser.JINJA_EXPR_CONTENT, 0); }
		public TerminalNode JINJA_EXPR_CLOSE() { return getToken(HTMLWithCSSParser.JINJA_EXPR_CLOSE, 0); }
		public JinjaExprContext(JinjaExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterJinjaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitJinjaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitJinjaExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExpressionContext jinjaExpression() throws RecognitionException {
		JinjaExpressionContext _localctx = new JinjaExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_jinjaExpression);
		try {
			_localctx = new JinjaExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(JINJA_EXPR_OPEN);
			setState(122);
			match(JINJA_EXPR_CONTENT);
			setState(123);
			match(JINJA_EXPR_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockContext extends ParserRuleContext {
		public JinjaBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlock; }
	 
		public JinjaBlockContext() { }
		public void copyFrom(JinjaBlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaRawBlockContext extends JinjaBlockContext {
		public TerminalNode JINJA_RAW_OPEN() { return getToken(HTMLWithCSSParser.JINJA_RAW_OPEN, 0); }
		public TerminalNode JINJA_RAW_CONTENT() { return getToken(HTMLWithCSSParser.JINJA_RAW_CONTENT, 0); }
		public TerminalNode JINJA_RAW_END() { return getToken(HTMLWithCSSParser.JINJA_RAW_END, 0); }
		public JinjaRawBlockContext(JinjaBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterJinjaRawBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitJinjaRawBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitJinjaRawBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockTagContext extends JinjaBlockContext {
		public TerminalNode JINJA_BLOCK_OPEN() { return getToken(HTMLWithCSSParser.JINJA_BLOCK_OPEN, 0); }
		public TerminalNode JINJA_BLOCK_CONTENT() { return getToken(HTMLWithCSSParser.JINJA_BLOCK_CONTENT, 0); }
		public TerminalNode JINJA_BLOCK_CLOSE() { return getToken(HTMLWithCSSParser.JINJA_BLOCK_CLOSE, 0); }
		public JinjaBlockTagContext(JinjaBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterJinjaBlockTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitJinjaBlockTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitJinjaBlockTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockContext jinjaBlock() throws RecognitionException {
		JinjaBlockContext _localctx = new JinjaBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_jinjaBlock);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JINJA_BLOCK_OPEN:
				_localctx = new JinjaBlockTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(JINJA_BLOCK_OPEN);
				setState(126);
				match(JINJA_BLOCK_CONTENT);
				setState(127);
				match(JINJA_BLOCK_CLOSE);
				}
				break;
			case JINJA_RAW_OPEN:
				_localctx = new JinjaRawBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(JINJA_RAW_OPEN);
				setState(129);
				match(JINJA_RAW_CONTENT);
				setState(130);
				match(JINJA_RAW_END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommentContext extends ParserRuleContext {
		public JinjaCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaComment; }
	 
		public JinjaCommentContext() { }
		public void copyFrom(JinjaCommentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommContext extends JinjaCommentContext {
		public TerminalNode JINJA_COMMENT_OPEN() { return getToken(HTMLWithCSSParser.JINJA_COMMENT_OPEN, 0); }
		public TerminalNode JINJA_COMMENT_CONTENT() { return getToken(HTMLWithCSSParser.JINJA_COMMENT_CONTENT, 0); }
		public TerminalNode JINJA_COMMENT_CLOSE() { return getToken(HTMLWithCSSParser.JINJA_COMMENT_CLOSE, 0); }
		public JinjaCommContext(JinjaCommentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterJinjaComm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitJinjaComm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitJinjaComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaCommentContext jinjaComment() throws RecognitionException {
		JinjaCommentContext _localctx = new JinjaCommentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_jinjaComment);
		try {
			_localctx = new JinjaCommContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(JINJA_COMMENT_OPEN);
			setState(134);
			match(JINJA_COMMENT_CONTENT);
			setState(135);
			match(JINJA_COMMENT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentContext extends ParserRuleContext {
		public HtmlContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContent; }
	 
		public HtmlContentContext() { }
		public void copyFrom(HtmlContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentBlockContext extends HtmlContentContext {
		public List<HtmlChardataContext> htmlChardata() {
			return getRuleContexts(HtmlChardataContext.class);
		}
		public HtmlChardataContext htmlChardata(int i) {
			return getRuleContext(HtmlChardataContext.class,i);
		}
		public List<HtmlElementContext> htmlElement() {
			return getRuleContexts(HtmlElementContext.class);
		}
		public HtmlElementContext htmlElement(int i) {
			return getRuleContext(HtmlElementContext.class,i);
		}
		public List<TerminalNode> CDATA() { return getTokens(HTMLWithCSSParser.CDATA); }
		public TerminalNode CDATA(int i) {
			return getToken(HTMLWithCSSParser.CDATA, i);
		}
		public List<TerminalNode> HTML_COMMENT() { return getTokens(HTMLWithCSSParser.HTML_COMMENT); }
		public TerminalNode HTML_COMMENT(int i) {
			return getToken(HTMLWithCSSParser.HTML_COMMENT, i);
		}
		public List<TerminalNode> HTML_CONDITIONAL_COMMENT() { return getTokens(HTMLWithCSSParser.HTML_CONDITIONAL_COMMENT); }
		public TerminalNode HTML_CONDITIONAL_COMMENT(int i) {
			return getToken(HTMLWithCSSParser.HTML_CONDITIONAL_COMMENT, i);
		}
		public List<JinjaExpressionContext> jinjaExpression() {
			return getRuleContexts(JinjaExpressionContext.class);
		}
		public JinjaExpressionContext jinjaExpression(int i) {
			return getRuleContext(JinjaExpressionContext.class,i);
		}
		public List<JinjaBlockContext> jinjaBlock() {
			return getRuleContexts(JinjaBlockContext.class);
		}
		public JinjaBlockContext jinjaBlock(int i) {
			return getRuleContext(JinjaBlockContext.class,i);
		}
		public List<JinjaCommentContext> jinjaComment() {
			return getRuleContexts(JinjaCommentContext.class);
		}
		public JinjaCommentContext jinjaComment(int i) {
			return getRuleContext(JinjaCommentContext.class,i);
		}
		public HtmlContentBlockContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterHtmlContentBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitHtmlContentBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitHtmlContentBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_htmlContent);
		try {
			int _alt;
			_localctx = new HtmlContentBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(145);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SEA_WS:
					case HTML_TEXT:
						{
						setState(137);
						htmlChardata();
						}
						break;
					case TAG_OPEN:
					case SCRIPT_OPEN:
					case STYLE_OPEN:
					case SCRIPTLET:
						{
						setState(138);
						htmlElement();
						}
						break;
					case CDATA:
						{
						setState(139);
						match(CDATA);
						}
						break;
					case HTML_COMMENT:
						{
						setState(140);
						match(HTML_COMMENT);
						}
						break;
					case HTML_CONDITIONAL_COMMENT:
						{
						setState(141);
						match(HTML_CONDITIONAL_COMMENT);
						}
						break;
					case JINJA_EXPR_OPEN:
						{
						setState(142);
						jinjaExpression();
						}
						break;
					case JINJA_BLOCK_OPEN:
					case JINJA_RAW_OPEN:
						{
						setState(143);
						jinjaBlock();
						}
						break;
					case JINJA_COMMENT_OPEN:
						{
						setState(144);
						jinjaComment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlChardataContext extends ParserRuleContext {
		public HtmlChardataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlChardata; }
	 
		public HtmlChardataContext() { }
		public void copyFrom(HtmlChardataContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextDataContext extends HtmlChardataContext {
		public TerminalNode HTML_TEXT() { return getToken(HTMLWithCSSParser.HTML_TEXT, 0); }
		public TextDataContext(HtmlChardataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterTextData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitTextData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitTextData(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WsDataContext extends HtmlChardataContext {
		public TerminalNode SEA_WS() { return getToken(HTMLWithCSSParser.SEA_WS, 0); }
		public WsDataContext(HtmlChardataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterWsData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitWsData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitWsData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlChardataContext htmlChardata() throws RecognitionException {
		HtmlChardataContext _localctx = new HtmlChardataContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_htmlChardata);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_TEXT:
				_localctx = new TextDataContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(HTML_TEXT);
				}
				break;
			case SEA_WS:
				_localctx = new WsDataContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(SEA_WS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeContext extends ParserRuleContext {
		public HtmlAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttribute; }
	 
		public HtmlAttributeContext() { }
		public void copyFrom(HtmlAttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrContext extends HtmlAttributeContext {
		public TerminalNode TAG_NAME() { return getToken(HTMLWithCSSParser.TAG_NAME, 0); }
		public TerminalNode TAG_EQUALS() { return getToken(HTMLWithCSSParser.TAG_EQUALS, 0); }
		public TerminalNode ATTVALUE_VALUE() { return getToken(HTMLWithCSSParser.ATTVALUE_VALUE, 0); }
		public AttrContext(HtmlAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeContext htmlAttribute() throws RecognitionException {
		HtmlAttributeContext _localctx = new HtmlAttributeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_htmlAttribute);
		int _la;
		try {
			_localctx = new AttrContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(TAG_NAME);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TAG_EQUALS) {
				{
				setState(155);
				match(TAG_EQUALS);
				setState(156);
				match(ATTVALUE_VALUE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlMiscContext extends ParserRuleContext {
		public TerminalNode HTML_COMMENT() { return getToken(HTMLWithCSSParser.HTML_COMMENT, 0); }
		public TerminalNode HTML_CONDITIONAL_COMMENT() { return getToken(HTMLWithCSSParser.HTML_CONDITIONAL_COMMENT, 0); }
		public TerminalNode SEA_WS() { return getToken(HTMLWithCSSParser.SEA_WS, 0); }
		public HtmlMiscContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlMisc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterHtmlMisc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitHtmlMisc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitHtmlMisc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlMiscContext htmlMisc() throws RecognitionException {
		HtmlMiscContext _localctx = new HtmlMiscContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_htmlMisc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 34304L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StylesheetContext extends ParserRuleContext {
		public List<TerminalNode> CDO() { return getTokens(HTMLWithCSSParser.CDO); }
		public TerminalNode CDO(int i) {
			return getToken(HTMLWithCSSParser.CDO, i);
		}
		public List<TerminalNode> CDC() { return getTokens(HTMLWithCSSParser.CDC); }
		public TerminalNode CDC(int i) {
			return getToken(HTMLWithCSSParser.CDC, i);
		}
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 211141174236127L) != 0)) {
				{
				setState(165);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(161);
					match(CDO);
					}
					break;
				case 2:
					{
					setState(162);
					match(CDC);
					}
					break;
				case 3:
					{
					setState(163);
					match(S);
					}
					break;
				case 4:
					{
					setState(164);
					statement();
					}
					break;
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public RulesetContext ruleset() {
			return getRuleContext(RulesetContext.class,0);
		}
		public AtstatementContext atstatement() {
			return getRuleContext(AtstatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSKEYWORD:
			case HASH:
			case COLON:
			case LCURLY:
			case LBRACKET:
			case ASTERISK:
			case IDENT:
			case S:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				ruleset();
				}
				break;
			case CHARSET:
			case IMPORT:
			case KEYFRAMES:
			case MEDIA:
			case PAGE:
			case VIEWPORT:
			case FONTFACE:
			case ATKEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				atstatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtstatementContext extends ParserRuleContext {
		public TerminalNode CHARSET() { return getToken(HTMLWithCSSParser.CHARSET, 0); }
		public TerminalNode IMPORT() { return getToken(HTMLWithCSSParser.IMPORT, 0); }
		public TerminalNode SEMICOLON() { return getToken(HTMLWithCSSParser.SEMICOLON, 0); }
		public TerminalNode STRING() { return getToken(HTMLWithCSSParser.STRING, 0); }
		public TerminalNode URI() { return getToken(HTMLWithCSSParser.URI, 0); }
		public TerminalNode UNCLOSED_STRING() { return getToken(HTMLWithCSSParser.UNCLOSED_STRING, 0); }
		public TerminalNode UNCLOSED_URI() { return getToken(HTMLWithCSSParser.UNCLOSED_URI, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public MediaContext media() {
			return getRuleContext(MediaContext.class,0);
		}
		public TerminalNode PAGE() { return getToken(HTMLWithCSSParser.PAGE, 0); }
		public TerminalNode LCURLY() { return getToken(HTMLWithCSSParser.LCURLY, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(HTMLWithCSSParser.RCURLY, 0); }
		public PseudoContext pseudo() {
			return getRuleContext(PseudoContext.class,0);
		}
		public List<Margin_ruleContext> margin_rule() {
			return getRuleContexts(Margin_ruleContext.class);
		}
		public Margin_ruleContext margin_rule(int i) {
			return getRuleContext(Margin_ruleContext.class,i);
		}
		public TerminalNode VIEWPORT() { return getToken(HTMLWithCSSParser.VIEWPORT, 0); }
		public TerminalNode FONTFACE() { return getToken(HTMLWithCSSParser.FONTFACE, 0); }
		public TerminalNode MEDIA() { return getToken(HTMLWithCSSParser.MEDIA, 0); }
		public List<Media_ruleContext> media_rule() {
			return getRuleContexts(Media_ruleContext.class);
		}
		public Media_ruleContext media_rule(int i) {
			return getRuleContext(Media_ruleContext.class,i);
		}
		public TerminalNode KEYFRAMES() { return getToken(HTMLWithCSSParser.KEYFRAMES, 0); }
		public TerminalNode IDENT() { return getToken(HTMLWithCSSParser.IDENT, 0); }
		public List<Keyframe_blockContext> keyframe_block() {
			return getRuleContexts(Keyframe_blockContext.class);
		}
		public Keyframe_blockContext keyframe_block(int i) {
			return getRuleContext(Keyframe_blockContext.class,i);
		}
		public TerminalNode ATKEYWORD() { return getToken(HTMLWithCSSParser.ATKEYWORD, 0); }
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public AtstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterAtstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitAtstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitAtstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtstatementContext atstatement() throws RecognitionException {
		AtstatementContext _localctx = new AtstatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atstatement);
		int _la;
		try {
			int _alt;
			setState(341);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHARSET:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(CHARSET);
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(IMPORT);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(176);
					match(S);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(182);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 106377749987328L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(183);
					match(S);
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN || _la==IDENT) {
					{
					setState(189);
					media();
					}
				}

				setState(192);
				match(SEMICOLON);
				}
				break;
			case PAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				match(PAGE);
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(194);
					pseudo();
					}
				}

				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(197);
					match(S);
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(203);
				match(LCURLY);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(204);
					match(S);
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(210);
				declarations();
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MARGIN_AREA) {
					{
					{
					setState(211);
					margin_rule();
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(217);
				match(RCURLY);
				}
				break;
			case VIEWPORT:
				enterOuterAlt(_localctx, 4);
				{
				setState(219);
				match(VIEWPORT);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(220);
					match(S);
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(226);
				match(LCURLY);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(227);
					match(S);
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(233);
				declarations();
				setState(234);
				match(RCURLY);
				}
				break;
			case FONTFACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(236);
				match(FONTFACE);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(237);
					match(S);
					}
					}
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(243);
				match(LCURLY);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(244);
					match(S);
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250);
				declarations();
				setState(251);
				match(RCURLY);
				}
				break;
			case MEDIA:
				enterOuterAlt(_localctx, 6);
				{
				setState(253);
				match(MEDIA);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(254);
					match(S);
					}
					}
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN || _la==IDENT) {
					{
					setState(260);
					media();
					}
				}

				setState(263);
				match(LCURLY);
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(264);
						match(S);
						}
						} 
					}
					setState(269);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 211141171090399L) != 0)) {
					{
					{
					setState(270);
					media_rule();
					setState(274);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(271);
							match(S);
							}
							} 
						}
						setState(276);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
					}
					}
					}
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(282);
				match(RCURLY);
				}
				break;
			case KEYFRAMES:
				enterOuterAlt(_localctx, 7);
				{
				setState(283);
				match(KEYFRAMES);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(284);
					match(S);
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(290);
				match(IDENT);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(291);
					match(S);
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(297);
				match(LCURLY);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(298);
					match(S);
					}
					}
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PERCENTAGE || _la==IDENT) {
					{
					{
					setState(304);
					keyframe_block();
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==S) {
						{
						{
						setState(305);
						match(S);
						}
						}
						setState(310);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(316);
				match(RCURLY);
				}
				break;
			case ATKEYWORD:
				enterOuterAlt(_localctx, 8);
				{
				setState(317);
				match(ATKEYWORD);
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(318);
						match(S);
						}
						} 
					}
					setState(323);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(324);
						any();
						}
						} 
					}
					setState(329);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				setState(339);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LCURLY:
					{
					setState(330);
					match(LCURLY);
					setState(334);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(331);
							any();
							}
							} 
						}
						setState(336);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
					}
					setState(337);
					match(RCURLY);
					}
					break;
				case SEMICOLON:
					{
					setState(338);
					match(SEMICOLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MediaContext extends ParserRuleContext {
		public List<Media_queryContext> media_query() {
			return getRuleContexts(Media_queryContext.class);
		}
		public Media_queryContext media_query(int i) {
			return getRuleContext(Media_queryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HTMLWithCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HTMLWithCSSParser.COMMA, i);
		}
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public MediaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_media; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterMedia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitMedia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitMedia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MediaContext media() throws RecognitionException {
		MediaContext _localctx = new MediaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_media);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			media_query();
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(344);
				match(COMMA);
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(345);
					match(S);
					}
					}
					setState(350);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(351);
				media_query();
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Media_queryContext extends ParserRuleContext {
		public List<Media_termContext> media_term() {
			return getRuleContexts(Media_termContext.class);
		}
		public Media_termContext media_term(int i) {
			return getRuleContext(Media_termContext.class,i);
		}
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public Media_queryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_media_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterMedia_query(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitMedia_query(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitMedia_query(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Media_queryContext media_query() throws RecognitionException {
		Media_queryContext _localctx = new Media_queryContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_media_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(357);
				media_term();
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(358);
					match(S);
					}
					}
					setState(363);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(366); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LPAREN || _la==IDENT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Media_termContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(HTMLWithCSSParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(HTMLWithCSSParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(HTMLWithCSSParser.RPAREN, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public TerminalNode COLON() { return getToken(HTMLWithCSSParser.COLON, 0); }
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public Media_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_media_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterMedia_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitMedia_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitMedia_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Media_termContext media_term() throws RecognitionException {
		Media_termContext _localctx = new Media_termContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_media_term);
		int _la;
		try {
			setState(394);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				match(IDENT);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				match(LPAREN);
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(370);
					match(S);
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(376);
				match(IDENT);
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(377);
					match(S);
					}
					}
					setState(382);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(383);
					match(COLON);
					setState(387);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==S) {
						{
						{
						setState(384);
						match(S);
						}
						}
						setState(389);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(390);
					terms();
					}
				}

				setState(393);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Media_ruleContext extends ParserRuleContext {
		public RulesetContext ruleset() {
			return getRuleContext(RulesetContext.class,0);
		}
		public AtstatementContext atstatement() {
			return getRuleContext(AtstatementContext.class,0);
		}
		public Media_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_media_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterMedia_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitMedia_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitMedia_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Media_ruleContext media_rule() throws RecognitionException {
		Media_ruleContext _localctx = new Media_ruleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_media_rule);
		try {
			setState(398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSKEYWORD:
			case HASH:
			case COLON:
			case LCURLY:
			case LBRACKET:
			case ASTERISK:
			case IDENT:
			case S:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				ruleset();
				}
				break;
			case CHARSET:
			case IMPORT:
			case KEYFRAMES:
			case MEDIA:
			case PAGE:
			case VIEWPORT:
			case FONTFACE:
			case ATKEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				atstatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Keyframe_blockContext extends ParserRuleContext {
		public List<Keyframe_selectorContext> keyframe_selector() {
			return getRuleContexts(Keyframe_selectorContext.class);
		}
		public Keyframe_selectorContext keyframe_selector(int i) {
			return getRuleContext(Keyframe_selectorContext.class,i);
		}
		public TerminalNode LCURLY() { return getToken(HTMLWithCSSParser.LCURLY, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(HTMLWithCSSParser.RCURLY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(HTMLWithCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HTMLWithCSSParser.COMMA, i);
		}
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public Keyframe_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyframe_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterKeyframe_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitKeyframe_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitKeyframe_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyframe_blockContext keyframe_block() throws RecognitionException {
		Keyframe_blockContext _localctx = new Keyframe_blockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_keyframe_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			keyframe_selector();
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(401);
				match(COMMA);
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(402);
					match(S);
					}
					}
					setState(407);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(408);
				keyframe_selector();
				}
				}
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(414);
			match(LCURLY);
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(415);
				match(S);
				}
				}
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(421);
			declarations();
			setState(422);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Keyframe_selectorContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(HTMLWithCSSParser.IDENT, 0); }
		public TerminalNode PERCENTAGE() { return getToken(HTMLWithCSSParser.PERCENTAGE, 0); }
		public Keyframe_selectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyframe_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterKeyframe_selector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitKeyframe_selector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitKeyframe_selector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyframe_selectorContext keyframe_selector() throws RecognitionException {
		Keyframe_selectorContext _localctx = new Keyframe_selectorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_keyframe_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			_la = _input.LA(1);
			if ( !(_la==PERCENTAGE || _la==IDENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RulesetContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(HTMLWithCSSParser.LCURLY, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(HTMLWithCSSParser.RCURLY, 0); }
		public List<Combined_selectorContext> combined_selector() {
			return getRuleContexts(Combined_selectorContext.class);
		}
		public Combined_selectorContext combined_selector(int i) {
			return getRuleContext(Combined_selectorContext.class,i);
		}
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HTMLWithCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HTMLWithCSSParser.COMMA, i);
		}
		public RulesetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterRuleset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitRuleset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitRuleset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesetContext ruleset() throws RecognitionException {
		RulesetContext _localctx = new RulesetContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ruleset);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & 412385034249L) != 0)) {
				{
				setState(426);
				combined_selector();
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(427);
					match(COMMA);
					setState(431);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(428);
							match(S);
							}
							} 
						}
						setState(433);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
					}
					setState(434);
					combined_selector();
					}
					}
					setState(439);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(442);
			match(LCURLY);
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(443);
				match(S);
				}
				}
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(449);
			declarations();
			setState(450);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Combined_selectorContext extends ParserRuleContext {
		public List<SelectorContext> selector() {
			return getRuleContexts(SelectorContext.class);
		}
		public SelectorContext selector(int i) {
			return getRuleContext(SelectorContext.class,i);
		}
		public List<CombinatorContext> combinator() {
			return getRuleContexts(CombinatorContext.class);
		}
		public CombinatorContext combinator(int i) {
			return getRuleContext(CombinatorContext.class,i);
		}
		public Combined_selectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_combined_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterCombined_selector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitCombined_selector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitCombined_selector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Combined_selectorContext combined_selector() throws RecognitionException {
		Combined_selectorContext _localctx = new Combined_selectorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_combined_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			selector();
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & 446786715657L) != 0)) {
				{
				{
				setState(453);
				combinator();
				setState(454);
				selector();
				}
				}
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CombinatorContext extends ParserRuleContext {
		public TerminalNode GREATER() { return getToken(HTMLWithCSSParser.GREATER, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public TerminalNode PLUS() { return getToken(HTMLWithCSSParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(HTMLWithCSSParser.TILDE, 0); }
		public CombinatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_combinator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterCombinator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitCombinator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitCombinator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CombinatorContext combinator() throws RecognitionException {
		CombinatorContext _localctx = new CombinatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_combinator);
		try {
			int _alt;
			setState(488);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GREATER:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				match(GREATER);
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(462);
						match(S);
						}
						} 
					}
					setState(467);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				match(PLUS);
				setState(472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(469);
						match(S);
						}
						} 
					}
					setState(474);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				}
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 3);
				{
				setState(475);
				match(TILDE);
				setState(479);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(476);
						match(S);
						}
						} 
					}
					setState(481);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				}
				}
				break;
			case CLASSKEYWORD:
			case HASH:
			case COLON:
			case LBRACKET:
			case ASTERISK:
			case IDENT:
			case S:
				enterOuterAlt(_localctx, 4);
				{
				setState(485);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(482);
						match(S);
						}
						} 
					}
					setState(487);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(HTMLWithCSSParser.IDENT, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public TerminalNode ASTERISK() { return getToken(HTMLWithCSSParser.ASTERISK, 0); }
		public List<SelpartContext> selpart() {
			return getRuleContexts(SelpartContext.class);
		}
		public SelpartContext selpart(int i) {
			return getRuleContext(SelpartContext.class,i);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_selector);
		int _la;
		try {
			int _alt;
			setState(514);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
			case IDENT:
			case S:
				enterOuterAlt(_localctx, 1);
				{
				setState(490);
				_la = _input.LA(1);
				if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 6145L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(494);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(491);
						selpart();
						}
						} 
					}
					setState(496);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				}
				setState(500);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(497);
						match(S);
						}
						} 
					}
					setState(502);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				}
				break;
			case CLASSKEYWORD:
			case HASH:
			case COLON:
			case LBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(504); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(503);
						selpart();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(506); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(511);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(508);
						match(S);
						}
						} 
					}
					setState(513);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelpartContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(HTMLWithCSSParser.HASH, 0); }
		public TerminalNode CLASSKEYWORD() { return getToken(HTMLWithCSSParser.CLASSKEYWORD, 0); }
		public TerminalNode LBRACKET() { return getToken(HTMLWithCSSParser.LBRACKET, 0); }
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(HTMLWithCSSParser.RBRACKET, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public PseudoContext pseudo() {
			return getRuleContext(PseudoContext.class,0);
		}
		public SelpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterSelpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitSelpart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitSelpart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelpartContext selpart() throws RecognitionException {
		SelpartContext _localctx = new SelpartContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_selpart);
		int _la;
		try {
			setState(529);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				match(HASH);
				}
				break;
			case CLASSKEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				match(CLASSKEYWORD);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(518);
				match(LBRACKET);
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(519);
					match(S);
					}
					}
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(525);
				attribute();
				setState(526);
				match(RBRACKET);
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 4);
				{
				setState(528);
				pseudo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(HTMLWithCSSParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(HTMLWithCSSParser.IDENT, i);
		}
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public TerminalNode EQUALS() { return getToken(HTMLWithCSSParser.EQUALS, 0); }
		public TerminalNode INCLUDES() { return getToken(HTMLWithCSSParser.INCLUDES, 0); }
		public TerminalNode DASHMATCH() { return getToken(HTMLWithCSSParser.DASHMATCH, 0); }
		public TerminalNode STARTSWITH() { return getToken(HTMLWithCSSParser.STARTSWITH, 0); }
		public TerminalNode ENDSWITH() { return getToken(HTMLWithCSSParser.ENDSWITH, 0); }
		public TerminalNode CONTAINS() { return getToken(HTMLWithCSSParser.CONTAINS, 0); }
		public TerminalNode STRING() { return getToken(HTMLWithCSSParser.STRING, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(IDENT);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(532);
				match(S);
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 63L) != 0)) {
				{
				setState(538);
				_la = _input.LA(1);
				if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 63L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(539);
					match(S);
					}
					}
					setState(544);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(545);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==IDENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(549);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(546);
					match(S);
					}
					}
					setState(551);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PseudoContext extends ParserRuleContext {
		public List<TerminalNode> COLON() { return getTokens(HTMLWithCSSParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(HTMLWithCSSParser.COLON, i);
		}
		public TerminalNode IDENT() { return getToken(HTMLWithCSSParser.IDENT, 0); }
		public TerminalNode FUNCTION() { return getToken(HTMLWithCSSParser.FUNCTION, 0); }
		public TerminalNode RPAREN() { return getToken(HTMLWithCSSParser.RPAREN, 0); }
		public TerminalNode NUMBER() { return getToken(HTMLWithCSSParser.NUMBER, 0); }
		public TerminalNode INDEX() { return getToken(HTMLWithCSSParser.INDEX, 0); }
		public List<SelectorContext> selector() {
			return getRuleContexts(SelectorContext.class);
		}
		public SelectorContext selector(int i) {
			return getRuleContext(SelectorContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(HTMLWithCSSParser.MINUS, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HTMLWithCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HTMLWithCSSParser.COMMA, i);
		}
		public PseudoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pseudo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterPseudo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitPseudo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitPseudo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PseudoContext pseudo() throws RecognitionException {
		PseudoContext _localctx = new PseudoContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_pseudo);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(COLON);
			setState(556);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(555);
				match(COLON);
				}
			}

			setState(604);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case IDENT:
				{
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(558);
					match(MINUS);
					}
				}

				setState(561);
				match(IDENT);
				}
				break;
			case FUNCTION:
				{
				setState(562);
				match(FUNCTION);
				setState(566);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(563);
						match(S);
						}
						} 
					}
					setState(568);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				}
				setState(595);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(570);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(569);
						match(MINUS);
						}
					}

					setState(572);
					match(IDENT);
					}
					break;
				case 2:
					{
					setState(574);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(573);
						match(MINUS);
						}
					}

					setState(576);
					match(NUMBER);
					}
					break;
				case 3:
					{
					setState(578);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(577);
						match(MINUS);
						}
					}

					setState(580);
					match(INDEX);
					}
					break;
				case 4:
					{
					setState(581);
					selector();
					setState(592);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(582);
						match(COMMA);
						setState(586);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(583);
								match(S);
								}
								} 
							}
							setState(588);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
						}
						setState(589);
						selector();
						}
						}
						setState(594);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(597);
					match(S);
					}
					}
					setState(602);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(603);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(HTMLWithCSSParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(HTMLWithCSSParser.SEMICOLON, i);
		}
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(606);
				declaration();
				}
			}

			setState(621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(609);
				match(SEMICOLON);
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(610);
					match(S);
					}
					}
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(616);
					declaration();
					}
				}

				}
				}
				setState(623);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(HTMLWithCSSParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(HTMLWithCSSParser.COLON, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public TerminalNode IMPORTANT() { return getToken(HTMLWithCSSParser.IMPORTANT, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(IDENT);
			setState(625);
			match(COLON);
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(626);
				match(S);
				}
				}
				setState(631);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & 111694332919L) != 0)) {
				{
				setState(632);
				terms();
				}
			}

			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTANT) {
				{
				setState(635);
				match(IMPORTANT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermsContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitTerms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitTerms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermsContext terms() throws RecognitionException {
		TermsContext _localctx = new TermsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(638);
				term();
				}
				}
				setState(641); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & 111694332919L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(HTMLWithCSSParser.IDENT, 0); }
		public TerminalNode NUMBER() { return getToken(HTMLWithCSSParser.NUMBER, 0); }
		public TerminalNode PERCENTAGE() { return getToken(HTMLWithCSSParser.PERCENTAGE, 0); }
		public TerminalNode DIMENSION() { return getToken(HTMLWithCSSParser.DIMENSION, 0); }
		public TerminalNode STRING() { return getToken(HTMLWithCSSParser.STRING, 0); }
		public TerminalNode UNCLOSED_STRING() { return getToken(HTMLWithCSSParser.UNCLOSED_STRING, 0); }
		public TerminalNode URI() { return getToken(HTMLWithCSSParser.URI, 0); }
		public TerminalNode UNCLOSED_URI() { return getToken(HTMLWithCSSParser.UNCLOSED_URI, 0); }
		public TerminalNode HASH() { return getToken(HTMLWithCSSParser.HASH, 0); }
		public TerminalNode UNIRANGE() { return getToken(HTMLWithCSSParser.UNIRANGE, 0); }
		public FunctContext funct() {
			return getRuleContext(FunctContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(HTMLWithCSSParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(HTMLWithCSSParser.PLUS, 0); }
		public TerminalNode COMMA() { return getToken(HTMLWithCSSParser.COMMA, 0); }
		public TerminalNode SLASH() { return getToken(HTMLWithCSSParser.SLASH, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_term);
		try {
			setState(658);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(643);
				match(IDENT);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(644);
				match(NUMBER);
				}
				break;
			case PERCENTAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(645);
				match(PERCENTAGE);
				}
				break;
			case DIMENSION:
				enterOuterAlt(_localctx, 4);
				{
				setState(646);
				match(DIMENSION);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(647);
				match(STRING);
				}
				break;
			case UNCLOSED_STRING:
				enterOuterAlt(_localctx, 6);
				{
				setState(648);
				match(UNCLOSED_STRING);
				}
				break;
			case URI:
				enterOuterAlt(_localctx, 7);
				{
				setState(649);
				match(URI);
				}
				break;
			case UNCLOSED_URI:
				enterOuterAlt(_localctx, 8);
				{
				setState(650);
				match(UNCLOSED_URI);
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 9);
				{
				setState(651);
				match(HASH);
				}
				break;
			case UNIRANGE:
				enterOuterAlt(_localctx, 10);
				{
				setState(652);
				match(UNIRANGE);
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 11);
				{
				setState(653);
				funct();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 12);
				{
				setState(654);
				match(MINUS);
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 13);
				{
				setState(655);
				match(PLUS);
				}
				break;
			case COMMA:
				enterOuterAlt(_localctx, 14);
				{
				setState(656);
				match(COMMA);
				}
				break;
			case SLASH:
				enterOuterAlt(_localctx, 15);
				{
				setState(657);
				match(SLASH);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(HTMLWithCSSParser.FUNCTION, 0); }
		public TerminalNode RPAREN() { return getToken(HTMLWithCSSParser.RPAREN, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public TermsContext terms() {
			return getRuleContext(TermsContext.class,0);
		}
		public FunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterFunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitFunct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitFunct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctContext funct() throws RecognitionException {
		FunctContext _localctx = new FunctContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_funct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			match(FUNCTION);
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(661);
				match(S);
				}
				}
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(668);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & 111694332919L) != 0)) {
				{
				setState(667);
				terms();
				}
			}

			setState(670);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnyContext extends ParserRuleContext {
		public AnyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitAny(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitAny(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyContext any() throws RecognitionException {
		AnyContext _localctx = new AnyContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_any);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			matchWildcard();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Margin_ruleContext extends ParserRuleContext {
		public TerminalNode MARGIN_AREA() { return getToken(HTMLWithCSSParser.MARGIN_AREA, 0); }
		public TerminalNode LCURLY() { return getToken(HTMLWithCSSParser.LCURLY, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(HTMLWithCSSParser.RCURLY, 0); }
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
		}
		public Margin_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_margin_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterMargin_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitMargin_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitMargin_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Margin_ruleContext margin_rule() throws RecognitionException {
		Margin_ruleContext _localctx = new Margin_ruleContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_margin_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			match(MARGIN_AREA);
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(675);
				match(S);
				}
				}
				setState(680);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(681);
			match(LCURLY);
			setState(685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(682);
				match(S);
				}
				}
				setState(687);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(688);
			declarations();
			setState(689);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001W\u02b4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0005\u0000D\b\u0000"+
		"\n\u0000\f\u0000G\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001V\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002[\b\u0002\n\u0002\f\u0002^\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002b\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"k\b\u0002\n\u0002\f\u0002n\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"x\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u0084\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u0092\b\u0006\n\u0006\f\u0006\u0095\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0099\b\u0007\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u009e\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00a6"+
		"\b\n\n\n\f\n\u00a9\t\n\u0001\u000b\u0001\u000b\u0003\u000b\u00ad\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u00b2\b\f\n\f\f\f\u00b5\t\f\u0001\f\u0001"+
		"\f\u0005\f\u00b9\b\f\n\f\f\f\u00bc\t\f\u0001\f\u0003\f\u00bf\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00c4\b\f\u0001\f\u0005\f\u00c7\b\f\n\f\f\f"+
		"\u00ca\t\f\u0001\f\u0001\f\u0005\f\u00ce\b\f\n\f\f\f\u00d1\t\f\u0001\f"+
		"\u0001\f\u0005\f\u00d5\b\f\n\f\f\f\u00d8\t\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0005\f\u00de\b\f\n\f\f\f\u00e1\t\f\u0001\f\u0001\f\u0005\f\u00e5\b"+
		"\f\n\f\f\f\u00e8\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ef"+
		"\b\f\n\f\f\f\u00f2\t\f\u0001\f\u0001\f\u0005\f\u00f6\b\f\n\f\f\f\u00f9"+
		"\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0100\b\f\n\f\f\f"+
		"\u0103\t\f\u0001\f\u0003\f\u0106\b\f\u0001\f\u0001\f\u0005\f\u010a\b\f"+
		"\n\f\f\f\u010d\t\f\u0001\f\u0001\f\u0005\f\u0111\b\f\n\f\f\f\u0114\t\f"+
		"\u0005\f\u0116\b\f\n\f\f\f\u0119\t\f\u0001\f\u0001\f\u0001\f\u0005\f\u011e"+
		"\b\f\n\f\f\f\u0121\t\f\u0001\f\u0001\f\u0005\f\u0125\b\f\n\f\f\f\u0128"+
		"\t\f\u0001\f\u0001\f\u0005\f\u012c\b\f\n\f\f\f\u012f\t\f\u0001\f\u0001"+
		"\f\u0005\f\u0133\b\f\n\f\f\f\u0136\t\f\u0005\f\u0138\b\f\n\f\f\f\u013b"+
		"\t\f\u0001\f\u0001\f\u0001\f\u0005\f\u0140\b\f\n\f\f\f\u0143\t\f\u0001"+
		"\f\u0005\f\u0146\b\f\n\f\f\f\u0149\t\f\u0001\f\u0001\f\u0005\f\u014d\b"+
		"\f\n\f\f\f\u0150\t\f\u0001\f\u0001\f\u0003\f\u0154\b\f\u0003\f\u0156\b"+
		"\f\u0001\r\u0001\r\u0001\r\u0005\r\u015b\b\r\n\r\f\r\u015e\t\r\u0001\r"+
		"\u0005\r\u0161\b\r\n\r\f\r\u0164\t\r\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u0168\b\u000e\n\u000e\f\u000e\u016b\t\u000e\u0004\u000e\u016d\b\u000e"+
		"\u000b\u000e\f\u000e\u016e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u0174\b\u000f\n\u000f\f\u000f\u0177\t\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u017b\b\u000f\n\u000f\f\u000f\u017e\t\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u0182\b\u000f\n\u000f\f\u000f\u0185\t\u000f\u0001\u000f\u0003"+
		"\u000f\u0188\b\u000f\u0001\u000f\u0003\u000f\u018b\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u018f\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u0194\b\u0011\n\u0011\f\u0011\u0197\t\u0011\u0001\u0011\u0005"+
		"\u0011\u019a\b\u0011\n\u0011\f\u0011\u019d\t\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u01a1\b\u0011\n\u0011\f\u0011\u01a4\t\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u01ae\b\u0013\n\u0013\f\u0013\u01b1\t\u0013\u0001\u0013"+
		"\u0005\u0013\u01b4\b\u0013\n\u0013\f\u0013\u01b7\t\u0013\u0003\u0013\u01b9"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u01bd\b\u0013\n\u0013\f\u0013"+
		"\u01c0\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u01c9\b\u0014\n\u0014\f\u0014\u01cc"+
		"\t\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u01d0\b\u0015\n\u0015\f\u0015"+
		"\u01d3\t\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u01d7\b\u0015\n\u0015"+
		"\f\u0015\u01da\t\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u01de\b\u0015"+
		"\n\u0015\f\u0015\u01e1\t\u0015\u0001\u0015\u0005\u0015\u01e4\b\u0015\n"+
		"\u0015\f\u0015\u01e7\t\u0015\u0003\u0015\u01e9\b\u0015\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u01ed\b\u0016\n\u0016\f\u0016\u01f0\t\u0016\u0001\u0016"+
		"\u0005\u0016\u01f3\b\u0016\n\u0016\f\u0016\u01f6\t\u0016\u0001\u0016\u0004"+
		"\u0016\u01f9\b\u0016\u000b\u0016\f\u0016\u01fa\u0001\u0016\u0005\u0016"+
		"\u01fe\b\u0016\n\u0016\f\u0016\u0201\t\u0016\u0003\u0016\u0203\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0209\b\u0017"+
		"\n\u0017\f\u0017\u020c\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u0212\b\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u0216"+
		"\b\u0018\n\u0018\f\u0018\u0219\t\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u021d\b\u0018\n\u0018\f\u0018\u0220\t\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u0224\b\u0018\n\u0018\f\u0018\u0227\t\u0018\u0003\u0018\u0229\b"+
		"\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u022d\b\u0019\u0001\u0019\u0003"+
		"\u0019\u0230\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0235"+
		"\b\u0019\n\u0019\f\u0019\u0238\t\u0019\u0001\u0019\u0003\u0019\u023b\b"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u023f\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u0243\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u0249\b\u0019\n\u0019\f\u0019\u024c\t\u0019\u0001\u0019"+
		"\u0005\u0019\u024f\b\u0019\n\u0019\f\u0019\u0252\t\u0019\u0003\u0019\u0254"+
		"\b\u0019\u0001\u0019\u0005\u0019\u0257\b\u0019\n\u0019\f\u0019\u025a\t"+
		"\u0019\u0001\u0019\u0003\u0019\u025d\b\u0019\u0001\u001a\u0003\u001a\u0260"+
		"\b\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0264\b\u001a\n\u001a\f\u001a"+
		"\u0267\t\u001a\u0001\u001a\u0003\u001a\u026a\b\u001a\u0005\u001a\u026c"+
		"\b\u001a\n\u001a\f\u001a\u026f\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0005\u001b\u0274\b\u001b\n\u001b\f\u001b\u0277\t\u001b\u0001\u001b\u0003"+
		"\u001b\u027a\b\u001b\u0001\u001b\u0003\u001b\u027d\b\u001b\u0001\u001c"+
		"\u0004\u001c\u0280\b\u001c\u000b\u001c\f\u001c\u0281\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0003\u001d\u0293\b\u001d\u0001\u001e\u0001\u001e\u0005"+
		"\u001e\u0297\b\u001e\n\u001e\f\u001e\u029a\t\u001e\u0001\u001e\u0003\u001e"+
		"\u029d\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 "+
		"\u0001 \u0005 \u02a5\b \n \f \u02a8\t \u0001 \u0001 \u0005 \u02ac\b \n"+
		" \f \u02af\t \u0001 \u0001 \u0001 \u0001 \u0000\u0000!\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@\u0000\u0007\u0001\u0000\u0019\u001a\u0002\u0000\t\n\u000f"+
		"\u000f\u0002\u0000&\'-.\u0002\u0000++JJ\u0002\u0000??JK\u0001\u0000AF"+
		"\u0002\u0000&&JJ\u0321\u0000E\u0001\u0000\u0000\u0000\u0002U\u0001\u0000"+
		"\u0000\u0000\u0004w\u0001\u0000\u0000\u0000\u0006y\u0001\u0000\u0000\u0000"+
		"\b\u0083\u0001\u0000\u0000\u0000\n\u0085\u0001\u0000\u0000\u0000\f\u0093"+
		"\u0001\u0000\u0000\u0000\u000e\u0098\u0001\u0000\u0000\u0000\u0010\u009a"+
		"\u0001\u0000\u0000\u0000\u0012\u009f\u0001\u0000\u0000\u0000\u0014\u00a7"+
		"\u0001\u0000\u0000\u0000\u0016\u00ac\u0001\u0000\u0000\u0000\u0018\u0155"+
		"\u0001\u0000\u0000\u0000\u001a\u0157\u0001\u0000\u0000\u0000\u001c\u016c"+
		"\u0001\u0000\u0000\u0000\u001e\u018a\u0001\u0000\u0000\u0000 \u018e\u0001"+
		"\u0000\u0000\u0000\"\u0190\u0001\u0000\u0000\u0000$\u01a8\u0001\u0000"+
		"\u0000\u0000&\u01b8\u0001\u0000\u0000\u0000(\u01c4\u0001\u0000\u0000\u0000"+
		"*\u01e8\u0001\u0000\u0000\u0000,\u0202\u0001\u0000\u0000\u0000.\u0211"+
		"\u0001\u0000\u0000\u00000\u0213\u0001\u0000\u0000\u00002\u022a\u0001\u0000"+
		"\u0000\u00004\u025f\u0001\u0000\u0000\u00006\u0270\u0001\u0000\u0000\u0000"+
		"8\u027f\u0001\u0000\u0000\u0000:\u0292\u0001\u0000\u0000\u0000<\u0294"+
		"\u0001\u0000\u0000\u0000>\u02a0\u0001\u0000\u0000\u0000@\u02a2\u0001\u0000"+
		"\u0000\u0000BD\u0003\u0002\u0001\u0000CB\u0001\u0000\u0000\u0000DG\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"FH\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0005\u0000\u0000"+
		"\u0001I\u0001\u0001\u0000\u0000\u0000JV\u0005\u000f\u0000\u0000KV\u0005"+
		"\u000e\u0000\u0000LV\u0005\u000b\u0000\u0000MV\u0005\r\u0000\u0000NV\u0005"+
		"\t\u0000\u0000OV\u0005\n\u0000\u0000PV\u0003\u0006\u0003\u0000QV\u0003"+
		"\b\u0004\u0000RV\u0003\n\u0005\u0000SV\u0003\u0004\u0002\u0000TV\u0003"+
		"\u000e\u0007\u0000UJ\u0001\u0000\u0000\u0000UK\u0001\u0000\u0000\u0000"+
		"UL\u0001\u0000\u0000\u0000UM\u0001\u0000\u0000\u0000UN\u0001\u0000\u0000"+
		"\u0000UO\u0001\u0000\u0000\u0000UP\u0001\u0000\u0000\u0000UQ\u0001\u0000"+
		"\u0000\u0000UR\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UT\u0001"+
		"\u0000\u0000\u0000V\u0003\u0001\u0000\u0000\u0000WX\u0005\u0006\u0000"+
		"\u0000X\\\u0005\u0015\u0000\u0000Y[\u0003\u0010\b\u0000ZY\u0001\u0000"+
		"\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000"+
		"_a\u0005\u0011\u0000\u0000`b\u0003\f\u0006\u0000a`\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0005\u0006\u0000"+
		"\u0000de\u0005\u0013\u0000\u0000ef\u0005\u0015\u0000\u0000fx\u0005\u0011"+
		"\u0000\u0000gh\u0005\u0006\u0000\u0000hl\u0005\u0015\u0000\u0000ik\u0003"+
		"\u0010\b\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000ox\u0005\u0012\u0000\u0000px\u0005\u000e\u0000"+
		"\u0000qr\u0005\u0007\u0000\u0000rx\u0007\u0000\u0000\u0000st\u0005\b\u0000"+
		"\u0000tu\u0003\u0014\n\u0000uv\u0005\u001b\u0000\u0000vx\u0001\u0000\u0000"+
		"\u0000wW\u0001\u0000\u0000\u0000wg\u0001\u0000\u0000\u0000wp\u0001\u0000"+
		"\u0000\u0000wq\u0001\u0000\u0000\u0000ws\u0001\u0000\u0000\u0000x\u0005"+
		"\u0001\u0000\u0000\u0000yz\u0005\u0002\u0000\u0000z{\u0005S\u0000\u0000"+
		"{|\u0005R\u0000\u0000|\u0007\u0001\u0000\u0000\u0000}~\u0005\u0001\u0000"+
		"\u0000~\u007f\u0005Q\u0000\u0000\u007f\u0084\u0005P\u0000\u0000\u0080"+
		"\u0081\u0005\u0004\u0000\u0000\u0081\u0082\u0005W\u0000\u0000\u0082\u0084"+
		"\u0005V\u0000\u0000\u0083}\u0001\u0000\u0000\u0000\u0083\u0080\u0001\u0000"+
		"\u0000\u0000\u0084\t\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0003\u0000"+
		"\u0000\u0086\u0087\u0005U\u0000\u0000\u0087\u0088\u0005T\u0000\u0000\u0088"+
		"\u000b\u0001\u0000\u0000\u0000\u0089\u0092\u0003\u000e\u0007\u0000\u008a"+
		"\u0092\u0003\u0004\u0002\u0000\u008b\u0092\u0005\f\u0000\u0000\u008c\u0092"+
		"\u0005\t\u0000\u0000\u008d\u0092\u0005\n\u0000\u0000\u008e\u0092\u0003"+
		"\u0006\u0003\u0000\u008f\u0092\u0003\b\u0004\u0000\u0090\u0092\u0003\n"+
		"\u0005\u0000\u0091\u0089\u0001\u0000\u0000\u0000\u0091\u008a\u0001\u0000"+
		"\u0000\u0000\u0091\u008b\u0001\u0000\u0000\u0000\u0091\u008c\u0001\u0000"+
		"\u0000\u0000\u0091\u008d\u0001\u0000\u0000\u0000\u0091\u008e\u0001\u0000"+
		"\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\r\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0099\u0005\u0010\u0000"+
		"\u0000\u0097\u0099\u0005\u000f\u0000\u0000\u0098\u0096\u0001\u0000\u0000"+
		"\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u000f\u0001\u0000\u0000"+
		"\u0000\u009a\u009d\u0005\u0015\u0000\u0000\u009b\u009c\u0005\u0014\u0000"+
		"\u0000\u009c\u009e\u0005\u0017\u0000\u0000\u009d\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u0011\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0007\u0001\u0000\u0000\u00a0\u0013\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a6\u00050\u0000\u0000\u00a2\u00a6\u00051\u0000\u0000\u00a3"+
		"\u00a6\u0005K\u0000\u0000\u00a4\u00a6\u0003\u0016\u000b\u0000\u00a5\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a8\u0015\u0001\u0000\u0000\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ad\u0003&\u0013\u0000\u00ab\u00ad\u0003"+
		"\u0018\f\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ad\u0017\u0001\u0000\u0000\u0000\u00ae\u0156\u0005\u001c"+
		"\u0000\u0000\u00af\u00b3\u0005\u001d\u0000\u0000\u00b0\u00b2\u0005K\u0000"+
		"\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b6\u00ba\u0007\u0002\u0000\u0000\u00b7\u00b9\u0005K\u0000\u0000"+
		"\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000"+
		"\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bd\u00bf\u0003\u001a\r\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0"+
		"\u0156\u00052\u0000\u0000\u00c1\u00c3\u0005 \u0000\u0000\u00c2\u00c4\u0003"+
		"2\u0019\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c8\u0001\u0000\u0000\u0000\u00c5\u00c7\u0005K\u0000"+
		"\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cf\u00055\u0000\u0000\u00cc\u00ce\u0005K\u0000\u0000\u00cd"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d6\u00034\u001a\u0000\u00d3\u00d5\u0003@ \u0000\u00d4\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da\u0005"+
		"6\u0000\u0000\u00da\u0156\u0001\u0000\u0000\u0000\u00db\u00df\u0005\""+
		"\u0000\u0000\u00dc\u00de\u0005K\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000"+
		"\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e6\u00055\u0000\u0000"+
		"\u00e3\u00e5\u0005K\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ea\u00034\u001a\u0000\u00ea\u00eb"+
		"\u00056\u0000\u0000\u00eb\u0156\u0001\u0000\u0000\u0000\u00ec\u00f0\u0005"+
		"#\u0000\u0000\u00ed\u00ef\u0005K\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f7\u00055\u0000\u0000"+
		"\u00f4\u00f6\u0005K\u0000\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000\u00f9"+
		"\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fb\u00034\u001a\u0000\u00fb\u00fc"+
		"\u00056\u0000\u0000\u00fc\u0156\u0001\u0000\u0000\u0000\u00fd\u0101\u0005"+
		"\u001f\u0000\u0000\u00fe\u0100\u0005K\u0000\u0000\u00ff\u00fe\u0001\u0000"+
		"\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000"+
		"\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000"+
		"\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u0106\u0003\u001a"+
		"\r\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u010b\u00055\u0000\u0000"+
		"\u0108\u010a\u0005K\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a"+
		"\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\u0001\u0000\u0000\u0000\u010c\u0117\u0001\u0000\u0000\u0000\u010d"+
		"\u010b\u0001\u0000\u0000\u0000\u010e\u0112\u0003 \u0010\u0000\u010f\u0111"+
		"\u0005K\u0000\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0111\u0114\u0001"+
		"\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001"+
		"\u0000\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000\u0114\u0112\u0001"+
		"\u0000\u0000\u0000\u0115\u010e\u0001\u0000\u0000\u0000\u0116\u0119\u0001"+
		"\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001"+
		"\u0000\u0000\u0000\u0118\u011a\u0001\u0000\u0000\u0000\u0119\u0117\u0001"+
		"\u0000\u0000\u0000\u011a\u0156\u00056\u0000\u0000\u011b\u011f\u0005\u001e"+
		"\u0000\u0000\u011c\u011e\u0005K\u0000\u0000\u011d\u011c\u0001\u0000\u0000"+
		"\u0000\u011e\u0121\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000"+
		"\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0122\u0001\u0000\u0000"+
		"\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0122\u0126\u0005J\u0000\u0000"+
		"\u0123\u0125\u0005K\u0000\u0000\u0124\u0123\u0001\u0000\u0000\u0000\u0125"+
		"\u0128\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0001\u0000\u0000\u0000\u0127\u0129\u0001\u0000\u0000\u0000\u0128"+
		"\u0126\u0001\u0000\u0000\u0000\u0129\u012d\u00055\u0000\u0000\u012a\u012c"+
		"\u0005K\u0000\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001"+
		"\u0000\u0000\u0000\u012e\u0139\u0001\u0000\u0000\u0000\u012f\u012d\u0001"+
		"\u0000\u0000\u0000\u0130\u0134\u0003\"\u0011\u0000\u0131\u0133\u0005K"+
		"\u0000\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000"+
		"\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000"+
		"\u0000\u0000\u0135\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000"+
		"\u0000\u0000\u0137\u0130\u0001\u0000\u0000\u0000\u0138\u013b\u0001\u0000"+
		"\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000"+
		"\u0000\u0000\u013a\u013c\u0001\u0000\u0000\u0000\u013b\u0139\u0001\u0000"+
		"\u0000\u0000\u013c\u0156\u00056\u0000\u0000\u013d\u0141\u0005$\u0000\u0000"+
		"\u013e\u0140\u0005K\u0000\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u0140"+
		"\u0143\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141"+
		"\u0142\u0001\u0000\u0000\u0000\u0142\u0147\u0001\u0000\u0000\u0000\u0143"+
		"\u0141\u0001\u0000\u0000\u0000\u0144\u0146\u0003>\u001f\u0000\u0145\u0144"+
		"\u0001\u0000\u0000\u0000\u0146\u0149\u0001\u0000\u0000\u0000\u0147\u0145"+
		"\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u0153"+
		"\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u014a\u014e"+
		"\u00055\u0000\u0000\u014b\u014d\u0003>\u001f\u0000\u014c\u014b\u0001\u0000"+
		"\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000"+
		"\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u0151\u0001\u0000"+
		"\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0151\u0154\u00056\u0000"+
		"\u0000\u0152\u0154\u00052\u0000\u0000\u0153\u014a\u0001\u0000\u0000\u0000"+
		"\u0153\u0152\u0001\u0000\u0000\u0000\u0154\u0156\u0001\u0000\u0000\u0000"+
		"\u0155\u00ae\u0001\u0000\u0000\u0000\u0155\u00af\u0001\u0000\u0000\u0000"+
		"\u0155\u00c1\u0001\u0000\u0000\u0000\u0155\u00db\u0001\u0000\u0000\u0000"+
		"\u0155\u00ec\u0001\u0000\u0000\u0000\u0155\u00fd\u0001\u0000\u0000\u0000"+
		"\u0155\u011b\u0001\u0000\u0000\u0000\u0155\u013d\u0001\u0000\u0000\u0000"+
		"\u0156\u0019\u0001\u0000\u0000\u0000\u0157\u0162\u0003\u001c\u000e\u0000"+
		"\u0158\u015c\u00054\u0000\u0000\u0159\u015b\u0005K\u0000\u0000\u015a\u0159"+
		"\u0001\u0000\u0000\u0000\u015b\u015e\u0001\u0000\u0000\u0000\u015c\u015a"+
		"\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015f"+
		"\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015f\u0161"+
		"\u0003\u001c\u000e\u0000\u0160\u0158\u0001\u0000\u0000\u0000\u0161\u0164"+
		"\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0001\u0000\u0000\u0000\u0163\u001b\u0001\u0000\u0000\u0000\u0164\u0162"+
		"\u0001\u0000\u0000\u0000\u0165\u0169\u0003\u001e\u000f\u0000\u0166\u0168"+
		"\u0005K\u0000\u0000\u0167\u0166\u0001\u0000\u0000\u0000\u0168\u016b\u0001"+
		"\u0000\u0000\u0000\u0169\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001"+
		"\u0000\u0000\u0000\u016a\u016d\u0001\u0000\u0000\u0000\u016b\u0169\u0001"+
		"\u0000\u0000\u0000\u016c\u0165\u0001\u0000\u0000\u0000\u016d\u016e\u0001"+
		"\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001"+
		"\u0000\u0000\u0000\u016f\u001d\u0001\u0000\u0000\u0000\u0170\u018b\u0005"+
		"J\u0000\u0000\u0171\u0175\u00057\u0000\u0000\u0172\u0174\u0005K\u0000"+
		"\u0000\u0173\u0172\u0001\u0000\u0000\u0000\u0174\u0177\u0001\u0000\u0000"+
		"\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000"+
		"\u0000\u0176\u0178\u0001\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000"+
		"\u0000\u0178\u017c\u0005J\u0000\u0000\u0179\u017b\u0005K\u0000\u0000\u017a"+
		"\u0179\u0001\u0000\u0000\u0000\u017b\u017e\u0001\u0000\u0000\u0000\u017c"+
		"\u017a\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d"+
		"\u0187\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017f"+
		"\u0183\u00053\u0000\u0000\u0180\u0182\u0005K\u0000\u0000\u0181\u0180\u0001"+
		"\u0000\u0000\u0000\u0182\u0185\u0001\u0000\u0000\u0000\u0183\u0181\u0001"+
		"\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184\u0186\u0001"+
		"\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0186\u0188\u0003"+
		"8\u001c\u0000\u0187\u017f\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000"+
		"\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u018b\u00058\u0000"+
		"\u0000\u018a\u0170\u0001\u0000\u0000\u0000\u018a\u0171\u0001\u0000\u0000"+
		"\u0000\u018b\u001f\u0001\u0000\u0000\u0000\u018c\u018f\u0003&\u0013\u0000"+
		"\u018d\u018f\u0003\u0018\f\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018e"+
		"\u018d\u0001\u0000\u0000\u0000\u018f!\u0001\u0000\u0000\u0000\u0190\u019b"+
		"\u0003$\u0012\u0000\u0191\u0195\u00054\u0000\u0000\u0192\u0194\u0005K"+
		"\u0000\u0000\u0193\u0192\u0001\u0000\u0000\u0000\u0194\u0197\u0001\u0000"+
		"\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000"+
		"\u0000\u0000\u0196\u0198\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000"+
		"\u0000\u0000\u0198\u019a\u0003$\u0012\u0000\u0199\u0191\u0001\u0000\u0000"+
		"\u0000\u019a\u019d\u0001\u0000\u0000\u0000\u019b\u0199\u0001\u0000\u0000"+
		"\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019e\u0001\u0000\u0000"+
		"\u0000\u019d\u019b\u0001\u0000\u0000\u0000\u019e\u01a2\u00055\u0000\u0000"+
		"\u019f\u01a1\u0005K\u0000\u0000\u01a0\u019f\u0001\u0000\u0000\u0000\u01a1"+
		"\u01a4\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a2"+
		"\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a5\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a6\u00034\u001a\u0000\u01a6\u01a7"+
		"\u00056\u0000\u0000\u01a7#\u0001\u0000\u0000\u0000\u01a8\u01a9\u0007\u0003"+
		"\u0000\u0000\u01a9%\u0001\u0000\u0000\u0000\u01aa\u01b5\u0003(\u0014\u0000"+
		"\u01ab\u01af\u00054\u0000\u0000\u01ac\u01ae\u0005K\u0000\u0000\u01ad\u01ac"+
		"\u0001\u0000\u0000\u0000\u01ae\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad"+
		"\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b2"+
		"\u0001\u0000\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b4"+
		"\u0003(\u0014\u0000\u01b3\u01ab\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b9\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001"+
		"\u0000\u0000\u0000\u01b8\u01aa\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001"+
		"\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01be\u0005"+
		"5\u0000\u0000\u01bb\u01bd\u0005K\u0000\u0000\u01bc\u01bb\u0001\u0000\u0000"+
		"\u0000\u01bd\u01c0\u0001\u0000\u0000\u0000\u01be\u01bc\u0001\u0000\u0000"+
		"\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c0\u01be\u0001\u0000\u0000\u0000\u01c1\u01c2\u00034\u001a\u0000"+
		"\u01c2\u01c3\u00056\u0000\u0000\u01c3\'\u0001\u0000\u0000\u0000\u01c4"+
		"\u01ca\u0003,\u0016\u0000\u01c5\u01c6\u0003*\u0015\u0000\u01c6\u01c7\u0003"+
		",\u0016\u0000\u01c7\u01c9\u0001\u0000\u0000\u0000\u01c8\u01c5\u0001\u0000"+
		"\u0000\u0000\u01c9\u01cc\u0001\u0000\u0000\u0000\u01ca\u01c8\u0001\u0000"+
		"\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb)\u0001\u0000\u0000"+
		"\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000\u01cd\u01d1\u0005H\u0000\u0000"+
		"\u01ce\u01d0\u0005K\u0000\u0000\u01cf\u01ce\u0001\u0000\u0000\u0000\u01d0"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d1"+
		"\u01d2\u0001\u0000\u0000\u0000\u01d2\u01e9\u0001\u0000\u0000\u0000\u01d3"+
		"\u01d1\u0001\u0000\u0000\u0000\u01d4\u01d8\u0005>\u0000\u0000\u01d5\u01d7"+
		"\u0005K\u0000\u0000\u01d6\u01d5\u0001\u0000\u0000\u0000\u01d7\u01da\u0001"+
		"\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001"+
		"\u0000\u0000\u0000\u01d9\u01e9\u0001\u0000\u0000\u0000\u01da\u01d8\u0001"+
		"\u0000\u0000\u0000\u01db\u01df\u0005<\u0000\u0000\u01dc\u01de\u0005K\u0000"+
		"\u0000\u01dd\u01dc\u0001\u0000\u0000\u0000\u01de\u01e1\u0001\u0000\u0000"+
		"\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000\u0000"+
		"\u0000\u01e0\u01e9\u0001\u0000\u0000\u0000\u01e1\u01df\u0001\u0000\u0000"+
		"\u0000\u01e2\u01e4\u0005K\u0000\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000"+
		"\u01e4\u01e7\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000"+
		"\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e9\u0001\u0000\u0000\u0000"+
		"\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e8\u01cd\u0001\u0000\u0000\u0000"+
		"\u01e8\u01d4\u0001\u0000\u0000\u0000\u01e8\u01db\u0001\u0000\u0000\u0000"+
		"\u01e8\u01e5\u0001\u0000\u0000\u0000\u01e9+\u0001\u0000\u0000\u0000\u01ea"+
		"\u01ee\u0007\u0004\u0000\u0000\u01eb\u01ed\u0003.\u0017\u0000\u01ec\u01eb"+
		"\u0001\u0000\u0000\u0000\u01ed\u01f0\u0001\u0000\u0000\u0000\u01ee\u01ec"+
		"\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000\u01ef\u01f4"+
		"\u0001\u0000\u0000\u0000\u01f0\u01ee\u0001\u0000\u0000\u0000\u01f1\u01f3"+
		"\u0005K\u0000\u0000\u01f2\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f6\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f2\u0001\u0000\u0000\u0000\u01f4\u01f5\u0001"+
		"\u0000\u0000\u0000\u01f5\u0203\u0001\u0000\u0000\u0000\u01f6\u01f4\u0001"+
		"\u0000\u0000\u0000\u01f7\u01f9\u0003.\u0017\u0000\u01f8\u01f7\u0001\u0000"+
		"\u0000\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa\u01f8\u0001\u0000"+
		"\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb\u01ff\u0001\u0000"+
		"\u0000\u0000\u01fc\u01fe\u0005K\u0000\u0000\u01fd\u01fc\u0001\u0000\u0000"+
		"\u0000\u01fe\u0201\u0001\u0000\u0000\u0000\u01ff\u01fd\u0001\u0000\u0000"+
		"\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200\u0203\u0001\u0000\u0000"+
		"\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u0202\u01ea\u0001\u0000\u0000"+
		"\u0000\u0202\u01f8\u0001\u0000\u0000\u0000\u0203-\u0001\u0000\u0000\u0000"+
		"\u0204\u0212\u0005(\u0000\u0000\u0205\u0212\u0005%\u0000\u0000\u0206\u020a"+
		"\u00059\u0000\u0000\u0207\u0209\u0005K\u0000\u0000\u0208\u0207\u0001\u0000"+
		"\u0000\u0000\u0209\u020c\u0001\u0000\u0000\u0000\u020a\u0208\u0001\u0000"+
		"\u0000\u0000\u020a\u020b\u0001\u0000\u0000\u0000\u020b\u020d\u0001\u0000"+
		"\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020d\u020e\u00030\u0018"+
		"\u0000\u020e\u020f\u0005:\u0000\u0000\u020f\u0212\u0001\u0000\u0000\u0000"+
		"\u0210\u0212\u00032\u0019\u0000\u0211\u0204\u0001\u0000\u0000\u0000\u0211"+
		"\u0205\u0001\u0000\u0000\u0000\u0211\u0206\u0001\u0000\u0000\u0000\u0211"+
		"\u0210\u0001\u0000\u0000\u0000\u0212/\u0001\u0000\u0000\u0000\u0213\u0217"+
		"\u0005J\u0000\u0000\u0214\u0216\u0005K\u0000\u0000\u0215\u0214\u0001\u0000"+
		"\u0000\u0000\u0216\u0219\u0001\u0000\u0000\u0000\u0217\u0215\u0001\u0000"+
		"\u0000\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u0228\u0001\u0000"+
		"\u0000\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u021a\u021e\u0007\u0005"+
		"\u0000\u0000\u021b\u021d\u0005K\u0000\u0000\u021c\u021b\u0001\u0000\u0000"+
		"\u0000\u021d\u0220\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000\u0000"+
		"\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f\u0221\u0001\u0000\u0000"+
		"\u0000\u0220\u021e\u0001\u0000\u0000\u0000\u0221\u0225\u0007\u0006\u0000"+
		"\u0000\u0222\u0224\u0005K\u0000\u0000\u0223\u0222\u0001\u0000\u0000\u0000"+
		"\u0224\u0227\u0001\u0000\u0000\u0000\u0225\u0223\u0001\u0000\u0000\u0000"+
		"\u0225\u0226\u0001\u0000\u0000\u0000\u0226\u0229\u0001\u0000\u0000\u0000"+
		"\u0227\u0225\u0001\u0000\u0000\u0000\u0228\u021a\u0001\u0000\u0000\u0000"+
		"\u0228\u0229\u0001\u0000\u0000\u0000\u02291\u0001\u0000\u0000\u0000\u022a"+
		"\u022c\u00053\u0000\u0000\u022b\u022d\u00053\u0000\u0000\u022c\u022b\u0001"+
		"\u0000\u0000\u0000\u022c\u022d\u0001\u0000\u0000\u0000\u022d\u025c\u0001"+
		"\u0000\u0000\u0000\u022e\u0230\u0005=\u0000\u0000\u022f\u022e\u0001\u0000"+
		"\u0000\u0000\u022f\u0230\u0001\u0000\u0000\u0000\u0230\u0231\u0001\u0000"+
		"\u0000\u0000\u0231\u025d\u0005J\u0000\u0000\u0232\u0236\u0005I\u0000\u0000"+
		"\u0233\u0235\u0005K\u0000\u0000\u0234\u0233\u0001\u0000\u0000\u0000\u0235"+
		"\u0238\u0001\u0000\u0000\u0000\u0236\u0234\u0001\u0000\u0000\u0000\u0236"+
		"\u0237\u0001\u0000\u0000\u0000\u0237\u0253\u0001\u0000\u0000\u0000\u0238"+
		"\u0236\u0001\u0000\u0000\u0000\u0239\u023b\u0005=\u0000\u0000\u023a\u0239"+
		"\u0001\u0000\u0000\u0000\u023a\u023b\u0001\u0000\u0000\u0000\u023b\u023c"+
		"\u0001\u0000\u0000\u0000\u023c\u0254\u0005J\u0000\u0000\u023d\u023f\u0005"+
		"=\u0000\u0000\u023e\u023d\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000"+
		"\u0000\u0000\u023f\u0240\u0001\u0000\u0000\u0000\u0240\u0254\u0005*\u0000"+
		"\u0000\u0241\u0243\u0005=\u0000\u0000\u0242\u0241\u0001\u0000\u0000\u0000"+
		"\u0242\u0243\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000\u0000"+
		"\u0244\u0254\u0005)\u0000\u0000\u0245\u0250\u0003,\u0016\u0000\u0246\u024a"+
		"\u00054\u0000\u0000\u0247\u0249\u0005K\u0000\u0000\u0248\u0247\u0001\u0000"+
		"\u0000\u0000\u0249\u024c\u0001\u0000\u0000\u0000\u024a\u0248\u0001\u0000"+
		"\u0000\u0000\u024a\u024b\u0001\u0000\u0000\u0000\u024b\u024d\u0001\u0000"+
		"\u0000\u0000\u024c\u024a\u0001\u0000\u0000\u0000\u024d\u024f\u0003,\u0016"+
		"\u0000\u024e\u0246\u0001\u0000\u0000\u0000\u024f\u0252\u0001\u0000\u0000"+
		"\u0000\u0250\u024e\u0001\u0000\u0000\u0000\u0250\u0251\u0001\u0000\u0000"+
		"\u0000\u0251\u0254\u0001\u0000\u0000\u0000\u0252\u0250\u0001\u0000\u0000"+
		"\u0000\u0253\u023a\u0001\u0000\u0000\u0000\u0253\u023e\u0001\u0000\u0000"+
		"\u0000\u0253\u0242\u0001\u0000\u0000\u0000\u0253\u0245\u0001\u0000\u0000"+
		"\u0000\u0254\u0258\u0001\u0000\u0000\u0000\u0255\u0257\u0005K\u0000\u0000"+
		"\u0256\u0255\u0001\u0000\u0000\u0000\u0257\u025a\u0001\u0000\u0000\u0000"+
		"\u0258\u0256\u0001\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000"+
		"\u0259\u025b\u0001\u0000\u0000\u0000\u025a\u0258\u0001\u0000\u0000\u0000"+
		"\u025b\u025d\u00058\u0000\u0000\u025c\u022f\u0001\u0000\u0000\u0000\u025c"+
		"\u0232\u0001\u0000\u0000\u0000\u025d3\u0001\u0000\u0000\u0000\u025e\u0260"+
		"\u00036\u001b\u0000\u025f\u025e\u0001\u0000\u0000\u0000\u025f\u0260\u0001"+
		"\u0000\u0000\u0000\u0260\u026d\u0001\u0000\u0000\u0000\u0261\u0265\u0005"+
		"2\u0000\u0000\u0262\u0264\u0005K\u0000\u0000\u0263\u0262\u0001\u0000\u0000"+
		"\u0000\u0264\u0267\u0001\u0000\u0000\u0000\u0265\u0263\u0001\u0000\u0000"+
		"\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u0269\u0001\u0000\u0000"+
		"\u0000\u0267\u0265\u0001\u0000\u0000\u0000\u0268\u026a\u00036\u001b\u0000"+
		"\u0269\u0268\u0001\u0000\u0000\u0000\u0269\u026a\u0001\u0000\u0000\u0000"+
		"\u026a\u026c\u0001\u0000\u0000\u0000\u026b\u0261\u0001\u0000\u0000\u0000"+
		"\u026c\u026f\u0001\u0000\u0000\u0000\u026d\u026b\u0001\u0000\u0000\u0000"+
		"\u026d\u026e\u0001\u0000\u0000\u0000\u026e5\u0001\u0000\u0000\u0000\u026f"+
		"\u026d\u0001\u0000\u0000\u0000\u0270\u0271\u0005J\u0000\u0000\u0271\u0275"+
		"\u00053\u0000\u0000\u0272\u0274\u0005K\u0000\u0000\u0273\u0272\u0001\u0000"+
		"\u0000\u0000\u0274\u0277\u0001\u0000\u0000\u0000\u0275\u0273\u0001\u0000"+
		"\u0000\u0000\u0275\u0276\u0001\u0000\u0000\u0000\u0276\u0279\u0001\u0000"+
		"\u0000\u0000\u0277\u0275\u0001\u0000\u0000\u0000\u0278\u027a\u00038\u001c"+
		"\u0000\u0279\u0278\u0001\u0000\u0000\u0000\u0279\u027a\u0001\u0000\u0000"+
		"\u0000\u027a\u027c\u0001\u0000\u0000\u0000\u027b\u027d\u0005N\u0000\u0000"+
		"\u027c\u027b\u0001\u0000\u0000\u0000\u027c\u027d\u0001\u0000\u0000\u0000"+
		"\u027d7\u0001\u0000\u0000\u0000\u027e\u0280\u0003:\u001d\u0000\u027f\u027e"+
		"\u0001\u0000\u0000\u0000\u0280\u0281\u0001\u0000\u0000\u0000\u0281\u027f"+
		"\u0001\u0000\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000\u02829\u0001"+
		"\u0000\u0000\u0000\u0283\u0293\u0005J\u0000\u0000\u0284\u0293\u0005*\u0000"+
		"\u0000\u0285\u0293\u0005+\u0000\u0000\u0286\u0293\u0005,\u0000\u0000\u0287"+
		"\u0293\u0005&\u0000\u0000\u0288\u0293\u0005\'\u0000\u0000\u0289\u0293"+
		"\u0005-\u0000\u0000\u028a\u0293\u0005.\u0000\u0000\u028b\u0293\u0005("+
		"\u0000\u0000\u028c\u0293\u0005/\u0000\u0000\u028d\u0293\u0003<\u001e\u0000"+
		"\u028e\u0293\u0005=\u0000\u0000\u028f\u0293\u0005>\u0000\u0000\u0290\u0293"+
		"\u00054\u0000\u0000\u0291\u0293\u0005G\u0000\u0000\u0292\u0283\u0001\u0000"+
		"\u0000\u0000\u0292\u0284\u0001\u0000\u0000\u0000\u0292\u0285\u0001\u0000"+
		"\u0000\u0000\u0292\u0286\u0001\u0000\u0000\u0000\u0292\u0287\u0001\u0000"+
		"\u0000\u0000\u0292\u0288\u0001\u0000\u0000\u0000\u0292\u0289\u0001\u0000"+
		"\u0000\u0000\u0292\u028a\u0001\u0000\u0000\u0000\u0292\u028b\u0001\u0000"+
		"\u0000\u0000\u0292\u028c\u0001\u0000\u0000\u0000\u0292\u028d\u0001\u0000"+
		"\u0000\u0000\u0292\u028e\u0001\u0000\u0000\u0000\u0292\u028f\u0001\u0000"+
		"\u0000\u0000\u0292\u0290\u0001\u0000\u0000\u0000\u0292\u0291\u0001\u0000"+
		"\u0000\u0000\u0293;\u0001\u0000\u0000\u0000\u0294\u0298\u0005I\u0000\u0000"+
		"\u0295\u0297\u0005K\u0000\u0000\u0296\u0295\u0001\u0000\u0000\u0000\u0297"+
		"\u029a\u0001\u0000\u0000\u0000\u0298\u0296\u0001\u0000\u0000\u0000\u0298"+
		"\u0299\u0001\u0000\u0000\u0000\u0299\u029c\u0001\u0000\u0000\u0000\u029a"+
		"\u0298\u0001\u0000\u0000\u0000\u029b\u029d\u00038\u001c\u0000\u029c\u029b"+
		"\u0001\u0000\u0000\u0000\u029c\u029d\u0001\u0000\u0000\u0000\u029d\u029e"+
		"\u0001\u0000\u0000\u0000\u029e\u029f\u00058\u0000\u0000\u029f=\u0001\u0000"+
		"\u0000\u0000\u02a0\u02a1\t\u0000\u0000\u0000\u02a1?\u0001\u0000\u0000"+
		"\u0000\u02a2\u02a6\u0005!\u0000\u0000\u02a3\u02a5\u0005K\u0000\u0000\u02a4"+
		"\u02a3\u0001\u0000\u0000\u0000\u02a5\u02a8\u0001\u0000\u0000\u0000\u02a6"+
		"\u02a4\u0001\u0000\u0000\u0000\u02a6\u02a7\u0001\u0000\u0000\u0000\u02a7"+
		"\u02a9\u0001\u0000\u0000\u0000\u02a8\u02a6\u0001\u0000\u0000\u0000\u02a9"+
		"\u02ad\u00055\u0000\u0000\u02aa\u02ac\u0005K\u0000\u0000\u02ab\u02aa\u0001"+
		"\u0000\u0000\u0000\u02ac\u02af\u0001\u0000\u0000\u0000\u02ad\u02ab\u0001"+
		"\u0000\u0000\u0000\u02ad\u02ae\u0001\u0000\u0000\u0000\u02ae\u02b0\u0001"+
		"\u0000\u0000\u0000\u02af\u02ad\u0001\u0000\u0000\u0000\u02b0\u02b1\u0003"+
		"4\u001a\u0000\u02b1\u02b2\u00056\u0000\u0000\u02b2A\u0001\u0000\u0000"+
		"\u0000bEU\\alw\u0083\u0091\u0093\u0098\u009d\u00a5\u00a7\u00ac\u00b3\u00ba"+
		"\u00be\u00c3\u00c8\u00cf\u00d6\u00df\u00e6\u00f0\u00f7\u0101\u0105\u010b"+
		"\u0112\u0117\u011f\u0126\u012d\u0134\u0139\u0141\u0147\u014e\u0153\u0155"+
		"\u015c\u0162\u0169\u016e\u0175\u017c\u0183\u0187\u018a\u018e\u0195\u019b"+
		"\u01a2\u01af\u01b5\u01b8\u01be\u01ca\u01d1\u01d8\u01df\u01e5\u01e8\u01ee"+
		"\u01f4\u01fa\u01ff\u0202\u020a\u0211\u0217\u021e\u0225\u0228\u022c\u022f"+
		"\u0236\u023a\u023e\u0242\u024a\u0250\u0253\u0258\u025c\u025f\u0265\u0269"+
		"\u026d\u0275\u0279\u027c\u0281\u0292\u0298\u029c\u02a6\u02ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}