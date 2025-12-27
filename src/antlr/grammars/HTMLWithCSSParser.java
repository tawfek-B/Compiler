// Generated from C:/Users/Asus/ANTLR/CompilerPractice/src/grammars/HTMLWithCSSParser.g4 by ANTLR 4.13.2
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
		RULE_htmlDocument = 0, RULE_documentItem = 1, RULE_htmlElement = 2, RULE_style = 3, 
		RULE_jinjaExpression = 4, RULE_jinjaBlock = 5, RULE_jinjaComment = 6, 
		RULE_htmlContent = 7, RULE_htmlChardata = 8, RULE_htmlAttribute = 9, RULE_htmlMisc = 10, 
		RULE_stylesheet = 11, RULE_statement = 12, RULE_atstatement = 13, RULE_media = 14, 
		RULE_media_query = 15, RULE_media_term = 16, RULE_media_rule = 17, RULE_keyframe_block = 18, 
		RULE_keyframe_selector = 19, RULE_ruleset = 20, RULE_combined_selector = 21, 
		RULE_combinator = 22, RULE_selector = 23, RULE_selpart = 24, RULE_attribute = 25, 
		RULE_pseudo = 26, RULE_declarations = 27, RULE_declaration = 28, RULE_terms = 29, 
		RULE_term = 30, RULE_funct = 31, RULE_any = 32, RULE_margin_rule = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlDocument", "documentItem", "htmlElement", "style", "jinjaExpression", 
			"jinjaBlock", "jinjaComment", "htmlContent", "htmlChardata", "htmlAttribute", 
			"htmlMisc", "stylesheet", "statement", "atstatement", "media", "media_query", 
			"media_term", "media_rule", "keyframe_block", "keyframe_selector", "ruleset", 
			"combined_selector", "combinator", "selector", "selpart", "attribute", 
			"pseudo", "declarations", "declaration", "terms", "term", "funct", "any", 
			"margin_rule"
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
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 61406L) != 0)) {
				{
				{
				setState(68);
				documentItem();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SeaWsItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(SEA_WS);
				}
				break;
			case 2:
				_localctx = new ScriptletItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(SCRIPTLET);
				}
				break;
			case 3:
				_localctx = new XmlItemContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(XML);
				}
				break;
			case 4:
				_localctx = new DtdItemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(DTD);
				}
				break;
			case 5:
				_localctx = new HtmlCommentItemContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				match(HTML_COMMENT);
				}
				break;
			case 6:
				_localctx = new ConditionalCommentItemContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				match(HTML_CONDITIONAL_COMMENT);
				}
				break;
			case 7:
				_localctx = new JinjaExprItemContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				jinjaExpression();
				}
				break;
			case 8:
				_localctx = new JinjaBlockItemContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				jinjaBlock();
				}
				break;
			case 9:
				_localctx = new JinjaCommentItemContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(84);
				jinjaComment();
				}
				break;
			case 10:
				_localctx = new HtmlElementItemContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(85);
				htmlElement();
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
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
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
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new HtmlPairedTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(TAG_OPEN);
				setState(89);
				match(TAG_NAME);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(90);
					htmlAttribute();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				match(TAG_CLOSE);
				setState(98);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(97);
					htmlContent();
					}
					break;
				}
				setState(100);
				match(TAG_OPEN);
				setState(101);
				match(TAG_SLASH);
				setState(102);
				match(TAG_NAME);
				setState(103);
				match(TAG_CLOSE);
				}
				break;
			case 2:
				_localctx = new HtmlVoidTagContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(TAG_OPEN);
				setState(105);
				match(TAG_NAME);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(106);
					htmlAttribute();
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(TAG_SLASH_CLOSE);
				}
				break;
			case 3:
				_localctx = new ScriptletElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(SCRIPTLET);
				}
				break;
			case 4:
				_localctx = new ScriptTagContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				match(SCRIPT_OPEN);
				setState(115);
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
				setState(116);
				style();
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
	public static class StyleContext extends ParserRuleContext {
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
	 
		public StyleContext() { }
		public void copyFrom(StyleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FullStyleContext extends StyleContext {
		public TerminalNode STYLE_OPEN() { return getToken(HTMLWithCSSParser.STYLE_OPEN, 0); }
		public StylesheetContext stylesheet() {
			return getRuleContext(StylesheetContext.class,0);
		}
		public TerminalNode STYLE_CLOSE() { return getToken(HTMLWithCSSParser.STYLE_CLOSE, 0); }
		public FullStyleContext(StyleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).enterFullStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLWithCSSParserListener ) ((HTMLWithCSSParserListener)listener).exitFullStyle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLWithCSSParserVisitor ) return ((HTMLWithCSSParserVisitor<? extends T>)visitor).visitFullStyle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_style);
		try {
			_localctx = new FullStyleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(STYLE_OPEN);
			setState(120);
			stylesheet();
			setState(121);
			match(STYLE_CLOSE);
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
		enterRule(_localctx, 8, RULE_jinjaExpression);
		try {
			_localctx = new JinjaExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(JINJA_EXPR_OPEN);
			setState(124);
			match(JINJA_EXPR_CONTENT);
			setState(125);
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
		enterRule(_localctx, 10, RULE_jinjaBlock);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JINJA_BLOCK_OPEN:
				_localctx = new JinjaBlockTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(JINJA_BLOCK_OPEN);
				setState(128);
				match(JINJA_BLOCK_CONTENT);
				setState(129);
				match(JINJA_BLOCK_CLOSE);
				}
				break;
			case JINJA_RAW_OPEN:
				_localctx = new JinjaRawBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(JINJA_RAW_OPEN);
				setState(131);
				match(JINJA_RAW_CONTENT);
				setState(132);
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
		enterRule(_localctx, 12, RULE_jinjaComment);
		try {
			_localctx = new JinjaCommContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(JINJA_COMMENT_OPEN);
			setState(136);
			match(JINJA_COMMENT_CONTENT);
			setState(137);
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
		enterRule(_localctx, 14, RULE_htmlContent);
		try {
			int _alt;
			_localctx = new HtmlContentBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(147);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SEA_WS:
					case HTML_TEXT:
						{
						setState(139);
						htmlChardata();
						}
						break;
					case TAG_OPEN:
					case SCRIPT_OPEN:
					case STYLE_OPEN:
					case SCRIPTLET:
						{
						setState(140);
						htmlElement();
						}
						break;
					case CDATA:
						{
						setState(141);
						match(CDATA);
						}
						break;
					case HTML_COMMENT:
						{
						setState(142);
						match(HTML_COMMENT);
						}
						break;
					case HTML_CONDITIONAL_COMMENT:
						{
						setState(143);
						match(HTML_CONDITIONAL_COMMENT);
						}
						break;
					case JINJA_EXPR_OPEN:
						{
						setState(144);
						jinjaExpression();
						}
						break;
					case JINJA_BLOCK_OPEN:
					case JINJA_RAW_OPEN:
						{
						setState(145);
						jinjaBlock();
						}
						break;
					case JINJA_COMMENT_OPEN:
						{
						setState(146);
						jinjaComment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(151);
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
		enterRule(_localctx, 16, RULE_htmlChardata);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_TEXT:
				_localctx = new TextDataContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(HTML_TEXT);
				}
				break;
			case SEA_WS:
				_localctx = new WsDataContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
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
		enterRule(_localctx, 18, RULE_htmlAttribute);
		int _la;
		try {
			_localctx = new AttrContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(TAG_NAME);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TAG_EQUALS) {
				{
				setState(157);
				match(TAG_EQUALS);
				setState(158);
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
		enterRule(_localctx, 20, RULE_htmlMisc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
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
		enterRule(_localctx, 22, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 211141174236127L) != 0)) {
				{
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CDO:
					{
					setState(163);
					match(CDO);
					}
					break;
				case CDC:
					{
					setState(164);
					match(CDC);
					}
					break;
				case S:
					{
					setState(165);
					match(S);
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
				case CLASSKEYWORD:
				case HASH:
				case COLON:
				case LCURLY:
				case LBRACKET:
				case ASTERISK:
				case IDENT:
					{
					setState(166);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(171);
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
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSKEYWORD:
			case HASH:
			case COLON:
			case LCURLY:
			case LBRACKET:
			case ASTERISK:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
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
				setState(173);
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
		enterRule(_localctx, 26, RULE_atstatement);
		int _la;
		try {
			int _alt;
			setState(343);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHARSET:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(CHARSET);
				}
				break;
			case IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(IMPORT);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(178);
					match(S);
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 106377749987328L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(185);
					match(S);
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN || _la==IDENT) {
					{
					setState(191);
					media();
					}
				}

				setState(194);
				match(SEMICOLON);
				}
				break;
			case PAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				match(PAGE);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(196);
					pseudo();
					}
				}

				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(199);
					match(S);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
				match(LCURLY);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(206);
					match(S);
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(212);
				declarations();
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MARGIN_AREA) {
					{
					{
					setState(213);
					margin_rule();
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(219);
				match(RCURLY);
				}
				break;
			case VIEWPORT:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				match(VIEWPORT);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(222);
					match(S);
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(228);
				match(LCURLY);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(229);
					match(S);
					}
					}
					setState(234);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(235);
				declarations();
				setState(236);
				match(RCURLY);
				}
				break;
			case FONTFACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(238);
				match(FONTFACE);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(239);
					match(S);
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(245);
				match(LCURLY);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(246);
					match(S);
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(252);
				declarations();
				setState(253);
				match(RCURLY);
				}
				break;
			case MEDIA:
				enterOuterAlt(_localctx, 6);
				{
				setState(255);
				match(MEDIA);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(256);
					match(S);
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN || _la==IDENT) {
					{
					setState(262);
					media();
					}
				}

				setState(265);
				match(LCURLY);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(266);
					match(S);
					}
					}
					setState(271);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 70403682735071L) != 0)) {
					{
					{
					setState(272);
					media_rule();
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==S) {
						{
						{
						setState(273);
						match(S);
						}
						}
						setState(278);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(284);
				match(RCURLY);
				}
				break;
			case KEYFRAMES:
				enterOuterAlt(_localctx, 7);
				{
				setState(285);
				match(KEYFRAMES);
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(286);
					match(S);
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(292);
				match(IDENT);
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(293);
					match(S);
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(299);
				match(LCURLY);
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(300);
					match(S);
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PERCENTAGE || _la==IDENT) {
					{
					{
					setState(306);
					keyframe_block();
					setState(310);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==S) {
						{
						{
						setState(307);
						match(S);
						}
						}
						setState(312);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(318);
				match(RCURLY);
				}
				break;
			case ATKEYWORD:
				enterOuterAlt(_localctx, 8);
				{
				setState(319);
				match(ATKEYWORD);
				setState(323);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(320);
						match(S);
						}
						} 
					}
					setState(325);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(326);
						any();
						}
						} 
					}
					setState(331);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				setState(341);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LCURLY:
					{
					setState(332);
					match(LCURLY);
					setState(336);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(333);
							any();
							}
							} 
						}
						setState(338);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
					}
					setState(339);
					match(RCURLY);
					}
					break;
				case SEMICOLON:
					{
					setState(340);
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
		enterRule(_localctx, 28, RULE_media);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			media_query();
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(346);
				match(COMMA);
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(347);
					match(S);
					}
					}
					setState(352);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(353);
				media_query();
				}
				}
				setState(358);
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
		enterRule(_localctx, 30, RULE_media_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(359);
				media_term();
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(360);
					match(S);
					}
					}
					setState(365);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(368); 
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
		enterRule(_localctx, 32, RULE_media_term);
		int _la;
		try {
			setState(396);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				match(IDENT);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				match(LPAREN);
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(372);
					match(S);
					}
					}
					setState(377);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(378);
				match(IDENT);
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(379);
					match(S);
					}
					}
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(385);
					match(COLON);
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==S) {
						{
						{
						setState(386);
						match(S);
						}
						}
						setState(391);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(392);
					terms();
					}
				}

				setState(395);
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
		enterRule(_localctx, 34, RULE_media_rule);
		try {
			setState(400);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASSKEYWORD:
			case HASH:
			case COLON:
			case LCURLY:
			case LBRACKET:
			case ASTERISK:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
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
				setState(399);
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
		enterRule(_localctx, 36, RULE_keyframe_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			keyframe_selector();
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(403);
				match(COMMA);
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(404);
					match(S);
					}
					}
					setState(409);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(410);
				keyframe_selector();
				}
				}
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(416);
			match(LCURLY);
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(417);
				match(S);
				}
				}
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(423);
			declarations();
			setState(424);
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
		enterRule(_localctx, 38, RULE_keyframe_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
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
		enterRule(_localctx, 40, RULE_ruleset);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & 137507127305L) != 0)) {
				{
				setState(428);
				combined_selector();
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(429);
					match(COMMA);
					setState(433);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==S) {
						{
						{
						setState(430);
						match(S);
						}
						}
						setState(435);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(436);
					combined_selector();
					}
					}
					setState(441);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(444);
			match(LCURLY);
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(445);
				match(S);
				}
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(451);
			declarations();
			setState(452);
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
		enterRule(_localctx, 42, RULE_combined_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			selector();
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & 36869L) != 0)) {
				{
				{
				setState(455);
				combinator();
				setState(456);
				selector();
				}
				}
				setState(462);
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
		enterRule(_localctx, 44, RULE_combinator);
		int _la;
		try {
			setState(489);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GREATER:
				enterOuterAlt(_localctx, 1);
				{
				setState(463);
				match(GREATER);
				setState(467);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(464);
					match(S);
					}
					}
					setState(469);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				match(PLUS);
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(471);
					match(S);
					}
					}
					setState(476);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 3);
				{
				setState(477);
				match(TILDE);
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(478);
					match(S);
					}
					}
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case S:
				enterOuterAlt(_localctx, 4);
				{
				setState(485); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(484);
					match(S);
					}
					}
					setState(487); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==S );
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
		public TerminalNode ASTERISK() { return getToken(HTMLWithCSSParser.ASTERISK, 0); }
		public List<SelpartContext> selpart() {
			return getRuleContexts(SelpartContext.class);
		}
		public SelpartContext selpart(int i) {
			return getRuleContext(SelpartContext.class,i);
		}
		public List<TerminalNode> S() { return getTokens(HTMLWithCSSParser.S); }
		public TerminalNode S(int i) {
			return getToken(HTMLWithCSSParser.S, i);
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
		enterRule(_localctx, 46, RULE_selector);
		int _la;
		try {
			int _alt;
			setState(515);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				_la = _input.LA(1);
				if ( !(_la==ASTERISK || _la==IDENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 146368224840122368L) != 0)) {
					{
					{
					setState(492);
					selpart();
					}
					}
					setState(497);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(501);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(498);
						match(S);
						}
						} 
					}
					setState(503);
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
				setState(505); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(504);
					selpart();
					}
					}
					setState(507); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 146368224840122368L) != 0) );
				setState(512);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(509);
						match(S);
						}
						} 
					}
					setState(514);
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
		enterRule(_localctx, 48, RULE_selpart);
		int _la;
		try {
			setState(530);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				match(HASH);
				}
				break;
			case CLASSKEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
				match(CLASSKEYWORD);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(519);
				match(LBRACKET);
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(520);
					match(S);
					}
					}
					setState(525);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(526);
				attribute();
				setState(527);
				match(RBRACKET);
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 4);
				{
				setState(529);
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
		enterRule(_localctx, 50, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(IDENT);
			setState(536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(533);
				match(S);
				}
				}
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 63L) != 0)) {
				{
				setState(539);
				_la = _input.LA(1);
				if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 63L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(540);
					match(S);
					}
					}
					setState(545);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(546);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==IDENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(547);
					match(S);
					}
					}
					setState(552);
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
		enterRule(_localctx, 52, RULE_pseudo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			match(COLON);
			setState(557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(556);
				match(COLON);
				}
			}

			setState(605);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case IDENT:
				{
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(559);
					match(MINUS);
					}
				}

				setState(562);
				match(IDENT);
				}
				break;
			case FUNCTION:
				{
				setState(563);
				match(FUNCTION);
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(564);
					match(S);
					}
					}
					setState(569);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(596);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(571);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(570);
						match(MINUS);
						}
					}

					setState(573);
					match(IDENT);
					}
					break;
				case 2:
					{
					setState(575);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(574);
						match(MINUS);
						}
					}

					setState(577);
					match(NUMBER);
					}
					break;
				case 3:
					{
					setState(579);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MINUS) {
						{
						setState(578);
						match(MINUS);
						}
					}

					setState(581);
					match(INDEX);
					}
					break;
				case 4:
					{
					setState(582);
					selector();
					setState(593);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(583);
						match(COMMA);
						setState(587);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==S) {
							{
							{
							setState(584);
							match(S);
							}
							}
							setState(589);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(590);
						selector();
						}
						}
						setState(595);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(601);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(598);
					match(S);
					}
					}
					setState(603);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(604);
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
		enterRule(_localctx, 54, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(607);
				declaration();
				}
			}

			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(610);
				match(SEMICOLON);
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==S) {
					{
					{
					setState(611);
					match(S);
					}
					}
					setState(616);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENT) {
					{
					setState(617);
					declaration();
					}
				}

				}
				}
				setState(624);
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
		enterRule(_localctx, 56, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(IDENT);
			setState(626);
			match(COLON);
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(627);
				match(S);
				}
				}
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(634);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & 111694332919L) != 0)) {
				{
				setState(633);
				terms();
				}
			}

			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTANT) {
				{
				setState(636);
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
		enterRule(_localctx, 58, RULE_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(639);
				term();
				}
				}
				setState(642); 
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
		enterRule(_localctx, 60, RULE_term);
		try {
			setState(659);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(644);
				match(IDENT);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(645);
				match(NUMBER);
				}
				break;
			case PERCENTAGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(646);
				match(PERCENTAGE);
				}
				break;
			case DIMENSION:
				enterOuterAlt(_localctx, 4);
				{
				setState(647);
				match(DIMENSION);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(648);
				match(STRING);
				}
				break;
			case UNCLOSED_STRING:
				enterOuterAlt(_localctx, 6);
				{
				setState(649);
				match(UNCLOSED_STRING);
				}
				break;
			case URI:
				enterOuterAlt(_localctx, 7);
				{
				setState(650);
				match(URI);
				}
				break;
			case UNCLOSED_URI:
				enterOuterAlt(_localctx, 8);
				{
				setState(651);
				match(UNCLOSED_URI);
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 9);
				{
				setState(652);
				match(HASH);
				}
				break;
			case UNIRANGE:
				enterOuterAlt(_localctx, 10);
				{
				setState(653);
				match(UNIRANGE);
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 11);
				{
				setState(654);
				funct();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 12);
				{
				setState(655);
				match(MINUS);
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 13);
				{
				setState(656);
				match(PLUS);
				}
				break;
			case COMMA:
				enterOuterAlt(_localctx, 14);
				{
				setState(657);
				match(COMMA);
				}
				break;
			case SLASH:
				enterOuterAlt(_localctx, 15);
				{
				setState(658);
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
		enterRule(_localctx, 62, RULE_funct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			match(FUNCTION);
			setState(665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(662);
				match(S);
				}
				}
				setState(667);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & 111694332919L) != 0)) {
				{
				setState(668);
				terms();
				}
			}

			setState(671);
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
		enterRule(_localctx, 64, RULE_any);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
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
		enterRule(_localctx, 66, RULE_margin_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(MARGIN_AREA);
			setState(679);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(676);
				match(S);
				}
				}
				setState(681);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(682);
			match(LCURLY);
			setState(686);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==S) {
				{
				{
				setState(683);
				match(S);
				}
				}
				setState(688);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(689);
			declarations();
			setState(690);
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
		"\u0004\u0001W\u02b5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0005"+
		"\u0000F\b\u0000\n\u0000\f\u0000I\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001W\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\\\b\u0002\n\u0002\f\u0002_"+
		"\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002c\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002l\b\u0002\n\u0002\f\u0002o\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002v\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u0086\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0094\b\u0007\n\u0007\f\u0007"+
		"\u0097\t\u0007\u0001\b\u0001\b\u0003\b\u009b\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00a0\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00a8\b\u000b\n\u000b\f\u000b\u00ab\t\u000b\u0001"+
		"\f\u0001\f\u0003\f\u00af\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00b4\b\r"+
		"\n\r\f\r\u00b7\t\r\u0001\r\u0001\r\u0005\r\u00bb\b\r\n\r\f\r\u00be\t\r"+
		"\u0001\r\u0003\r\u00c1\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c6\b\r\u0001"+
		"\r\u0005\r\u00c9\b\r\n\r\f\r\u00cc\t\r\u0001\r\u0001\r\u0005\r\u00d0\b"+
		"\r\n\r\f\r\u00d3\t\r\u0001\r\u0001\r\u0005\r\u00d7\b\r\n\r\f\r\u00da\t"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00e0\b\r\n\r\f\r\u00e3\t\r"+
		"\u0001\r\u0001\r\u0005\r\u00e7\b\r\n\r\f\r\u00ea\t\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u00f1\b\r\n\r\f\r\u00f4\t\r\u0001\r\u0001\r"+
		"\u0005\r\u00f8\b\r\n\r\f\r\u00fb\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0102\b\r\n\r\f\r\u0105\t\r\u0001\r\u0003\r\u0108\b\r\u0001"+
		"\r\u0001\r\u0005\r\u010c\b\r\n\r\f\r\u010f\t\r\u0001\r\u0001\r\u0005\r"+
		"\u0113\b\r\n\r\f\r\u0116\t\r\u0005\r\u0118\b\r\n\r\f\r\u011b\t\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u0120\b\r\n\r\f\r\u0123\t\r\u0001\r\u0001\r"+
		"\u0005\r\u0127\b\r\n\r\f\r\u012a\t\r\u0001\r\u0001\r\u0005\r\u012e\b\r"+
		"\n\r\f\r\u0131\t\r\u0001\r\u0001\r\u0005\r\u0135\b\r\n\r\f\r\u0138\t\r"+
		"\u0005\r\u013a\b\r\n\r\f\r\u013d\t\r\u0001\r\u0001\r\u0001\r\u0005\r\u0142"+
		"\b\r\n\r\f\r\u0145\t\r\u0001\r\u0005\r\u0148\b\r\n\r\f\r\u014b\t\r\u0001"+
		"\r\u0001\r\u0005\r\u014f\b\r\n\r\f\r\u0152\t\r\u0001\r\u0001\r\u0003\r"+
		"\u0156\b\r\u0003\r\u0158\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u015d\b\u000e\n\u000e\f\u000e\u0160\t\u000e\u0001\u000e\u0005\u000e"+
		"\u0163\b\u000e\n\u000e\f\u000e\u0166\t\u000e\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u016a\b\u000f\n\u000f\f\u000f\u016d\t\u000f\u0004\u000f\u016f\b"+
		"\u000f\u000b\u000f\f\u000f\u0170\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0176\b\u0010\n\u0010\f\u0010\u0179\t\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u017d\b\u0010\n\u0010\f\u0010\u0180\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u0184\b\u0010\n\u0010\f\u0010\u0187\t\u0010\u0001\u0010"+
		"\u0003\u0010\u018a\b\u0010\u0001\u0010\u0003\u0010\u018d\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u0191\b\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u0196\b\u0012\n\u0012\f\u0012\u0199\t\u0012\u0001\u0012"+
		"\u0005\u0012\u019c\b\u0012\n\u0012\f\u0012\u019f\t\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u01a3\b\u0012\n\u0012\f\u0012\u01a6\t\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u01b0\b\u0014\n\u0014\f\u0014\u01b3\t\u0014\u0001"+
		"\u0014\u0005\u0014\u01b6\b\u0014\n\u0014\f\u0014\u01b9\t\u0014\u0003\u0014"+
		"\u01bb\b\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u01bf\b\u0014\n\u0014"+
		"\f\u0014\u01c2\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u01cb\b\u0015\n\u0015"+
		"\f\u0015\u01ce\t\u0015\u0001\u0016\u0001\u0016\u0005\u0016\u01d2\b\u0016"+
		"\n\u0016\f\u0016\u01d5\t\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u01d9"+
		"\b\u0016\n\u0016\f\u0016\u01dc\t\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u01e0\b\u0016\n\u0016\f\u0016\u01e3\t\u0016\u0001\u0016\u0004\u0016\u01e6"+
		"\b\u0016\u000b\u0016\f\u0016\u01e7\u0003\u0016\u01ea\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0005\u0017\u01ee\b\u0017\n\u0017\f\u0017\u01f1\t\u0017\u0001"+
		"\u0017\u0005\u0017\u01f4\b\u0017\n\u0017\f\u0017\u01f7\t\u0017\u0001\u0017"+
		"\u0004\u0017\u01fa\b\u0017\u000b\u0017\f\u0017\u01fb\u0001\u0017\u0005"+
		"\u0017\u01ff\b\u0017\n\u0017\f\u0017\u0202\t\u0017\u0003\u0017\u0204\b"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u020a"+
		"\b\u0018\n\u0018\f\u0018\u020d\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u0213\b\u0018\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u0217\b\u0019\n\u0019\f\u0019\u021a\t\u0019\u0001\u0019\u0001\u0019\u0005"+
		"\u0019\u021e\b\u0019\n\u0019\f\u0019\u0221\t\u0019\u0001\u0019\u0001\u0019"+
		"\u0005\u0019\u0225\b\u0019\n\u0019\f\u0019\u0228\t\u0019\u0003\u0019\u022a"+
		"\b\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u022e\b\u001a\u0001\u001a"+
		"\u0003\u001a\u0231\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a"+
		"\u0236\b\u001a\n\u001a\f\u001a\u0239\t\u001a\u0001\u001a\u0003\u001a\u023c"+
		"\b\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0240\b\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u0244\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0005\u001a\u024a\b\u001a\n\u001a\f\u001a\u024d\t\u001a\u0001"+
		"\u001a\u0005\u001a\u0250\b\u001a\n\u001a\f\u001a\u0253\t\u001a\u0003\u001a"+
		"\u0255\b\u001a\u0001\u001a\u0005\u001a\u0258\b\u001a\n\u001a\f\u001a\u025b"+
		"\t\u001a\u0001\u001a\u0003\u001a\u025e\b\u001a\u0001\u001b\u0003\u001b"+
		"\u0261\b\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0265\b\u001b\n\u001b"+
		"\f\u001b\u0268\t\u001b\u0001\u001b\u0003\u001b\u026b\b\u001b\u0005\u001b"+
		"\u026d\b\u001b\n\u001b\f\u001b\u0270\t\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u0275\b\u001c\n\u001c\f\u001c\u0278\t\u001c\u0001\u001c"+
		"\u0003\u001c\u027b\b\u001c\u0001\u001c\u0003\u001c\u027e\b\u001c\u0001"+
		"\u001d\u0004\u001d\u0281\b\u001d\u000b\u001d\f\u001d\u0282\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0294\b\u001e\u0001\u001f\u0001\u001f"+
		"\u0005\u001f\u0298\b\u001f\n\u001f\f\u001f\u029b\t\u001f\u0001\u001f\u0003"+
		"\u001f\u029e\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001"+
		"!\u0005!\u02a6\b!\n!\f!\u02a9\t!\u0001!\u0001!\u0005!\u02ad\b!\n!\f!\u02b0"+
		"\t!\u0001!\u0001!\u0001!\u0001!\u0000\u0000\"\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@B\u0000\u0007\u0001\u0000\u0019\u001a\u0002\u0000\t\n\u000f\u000f"+
		"\u0002\u0000&\'-.\u0002\u0000++JJ\u0002\u0000??JJ\u0001\u0000AF\u0002"+
		"\u0000&&JJ\u0320\u0000G\u0001\u0000\u0000\u0000\u0002V\u0001\u0000\u0000"+
		"\u0000\u0004u\u0001\u0000\u0000\u0000\u0006w\u0001\u0000\u0000\u0000\b"+
		"{\u0001\u0000\u0000\u0000\n\u0085\u0001\u0000\u0000\u0000\f\u0087\u0001"+
		"\u0000\u0000\u0000\u000e\u0095\u0001\u0000\u0000\u0000\u0010\u009a\u0001"+
		"\u0000\u0000\u0000\u0012\u009c\u0001\u0000\u0000\u0000\u0014\u00a1\u0001"+
		"\u0000\u0000\u0000\u0016\u00a9\u0001\u0000\u0000\u0000\u0018\u00ae\u0001"+
		"\u0000\u0000\u0000\u001a\u0157\u0001\u0000\u0000\u0000\u001c\u0159\u0001"+
		"\u0000\u0000\u0000\u001e\u016e\u0001\u0000\u0000\u0000 \u018c\u0001\u0000"+
		"\u0000\u0000\"\u0190\u0001\u0000\u0000\u0000$\u0192\u0001\u0000\u0000"+
		"\u0000&\u01aa\u0001\u0000\u0000\u0000(\u01ba\u0001\u0000\u0000\u0000*"+
		"\u01c6\u0001\u0000\u0000\u0000,\u01e9\u0001\u0000\u0000\u0000.\u0203\u0001"+
		"\u0000\u0000\u00000\u0212\u0001\u0000\u0000\u00002\u0214\u0001\u0000\u0000"+
		"\u00004\u022b\u0001\u0000\u0000\u00006\u0260\u0001\u0000\u0000\u00008"+
		"\u0271\u0001\u0000\u0000\u0000:\u0280\u0001\u0000\u0000\u0000<\u0293\u0001"+
		"\u0000\u0000\u0000>\u0295\u0001\u0000\u0000\u0000@\u02a1\u0001\u0000\u0000"+
		"\u0000B\u02a3\u0001\u0000\u0000\u0000DF\u0003\u0002\u0001\u0000ED\u0001"+
		"\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000"+
		"\u0000JK\u0005\u0000\u0000\u0001K\u0001\u0001\u0000\u0000\u0000LW\u0005"+
		"\u000f\u0000\u0000MW\u0005\u000e\u0000\u0000NW\u0005\u000b\u0000\u0000"+
		"OW\u0005\r\u0000\u0000PW\u0005\t\u0000\u0000QW\u0005\n\u0000\u0000RW\u0003"+
		"\b\u0004\u0000SW\u0003\n\u0005\u0000TW\u0003\f\u0006\u0000UW\u0003\u0004"+
		"\u0002\u0000VL\u0001\u0000\u0000\u0000VM\u0001\u0000\u0000\u0000VN\u0001"+
		"\u0000\u0000\u0000VO\u0001\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000"+
		"VQ\u0001\u0000\u0000\u0000VR\u0001\u0000\u0000\u0000VS\u0001\u0000\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000VU\u0001\u0000\u0000\u0000W\u0003\u0001"+
		"\u0000\u0000\u0000XY\u0005\u0006\u0000\u0000Y]\u0005\u0015\u0000\u0000"+
		"Z\\\u0003\u0012\t\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000`b\u0005\u0011\u0000\u0000ac\u0003"+
		"\u000e\u0007\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000de\u0005\u0006\u0000\u0000ef\u0005\u0013\u0000"+
		"\u0000fg\u0005\u0015\u0000\u0000gv\u0005\u0011\u0000\u0000hi\u0005\u0006"+
		"\u0000\u0000im\u0005\u0015\u0000\u0000jl\u0003\u0012\t\u0000kj\u0001\u0000"+
		"\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000np\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"pv\u0005\u0012\u0000\u0000qv\u0005\u000e\u0000\u0000rs\u0005\u0007\u0000"+
		"\u0000sv\u0007\u0000\u0000\u0000tv\u0003\u0006\u0003\u0000uX\u0001\u0000"+
		"\u0000\u0000uh\u0001\u0000\u0000\u0000uq\u0001\u0000\u0000\u0000ur\u0001"+
		"\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000v\u0005\u0001\u0000\u0000"+
		"\u0000wx\u0005\b\u0000\u0000xy\u0003\u0016\u000b\u0000yz\u0005\u001b\u0000"+
		"\u0000z\u0007\u0001\u0000\u0000\u0000{|\u0005\u0002\u0000\u0000|}\u0005"+
		"S\u0000\u0000}~\u0005R\u0000\u0000~\t\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0005\u0001\u0000\u0000\u0080\u0081\u0005Q\u0000\u0000\u0081\u0086\u0005"+
		"P\u0000\u0000\u0082\u0083\u0005\u0004\u0000\u0000\u0083\u0084\u0005W\u0000"+
		"\u0000\u0084\u0086\u0005V\u0000\u0000\u0085\u007f\u0001\u0000\u0000\u0000"+
		"\u0085\u0082\u0001\u0000\u0000\u0000\u0086\u000b\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0005\u0003\u0000\u0000\u0088\u0089\u0005U\u0000\u0000\u0089"+
		"\u008a\u0005T\u0000\u0000\u008a\r\u0001\u0000\u0000\u0000\u008b\u0094"+
		"\u0003\u0010\b\u0000\u008c\u0094\u0003\u0004\u0002\u0000\u008d\u0094\u0005"+
		"\f\u0000\u0000\u008e\u0094\u0005\t\u0000\u0000\u008f\u0094\u0005\n\u0000"+
		"\u0000\u0090\u0094\u0003\b\u0004\u0000\u0091\u0094\u0003\n\u0005\u0000"+
		"\u0092\u0094\u0003\f\u0006\u0000\u0093\u008b\u0001\u0000\u0000\u0000\u0093"+
		"\u008c\u0001\u0000\u0000\u0000\u0093\u008d\u0001\u0000\u0000\u0000\u0093"+
		"\u008e\u0001\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0093"+
		"\u0090\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"\u000f\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098"+
		"\u009b\u0005\u0010\u0000\u0000\u0099\u009b\u0005\u000f\u0000\u0000\u009a"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u0011\u0001\u0000\u0000\u0000\u009c\u009f\u0005\u0015\u0000\u0000\u009d"+
		"\u009e\u0005\u0014\u0000\u0000\u009e\u00a0\u0005\u0017\u0000\u0000\u009f"+
		"\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0"+
		"\u0013\u0001\u0000\u0000\u0000\u00a1\u00a2\u0007\u0001\u0000\u0000\u00a2"+
		"\u0015\u0001\u0000\u0000\u0000\u00a3\u00a8\u00050\u0000\u0000\u00a4\u00a8"+
		"\u00051\u0000\u0000\u00a5\u00a8\u0005K\u0000\u0000\u00a6\u00a8\u0003\u0018"+
		"\f\u0000\u00a7\u00a3\u0001\u0000\u0000\u0000\u00a7\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u0017\u0001\u0000\u0000"+
		"\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00af\u0003(\u0014\u0000"+
		"\u00ad\u00af\u0003\u001a\r\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u0019\u0001\u0000\u0000\u0000\u00b0"+
		"\u0158\u0005\u001c\u0000\u0000\u00b1\u00b5\u0005\u001d\u0000\u0000\u00b2"+
		"\u00b4\u0005K\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b8\u00bc\u0007\u0002\u0000\u0000\u00b9\u00bb"+
		"\u0005K\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00be\u0001"+
		"\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000\u0000\u00be\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c1\u0003\u001c\u000e\u0000\u00c0\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c2\u0158\u00052\u0000\u0000\u00c3\u00c5\u0005 \u0000"+
		"\u0000\u00c4\u00c6\u00034\u001a\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00ca\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c9\u0005K\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cd\u00d1\u00055\u0000\u0000\u00ce\u00d0"+
		"\u0005K\u0000\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d4\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d8\u00036\u001b\u0000\u00d5\u00d7\u0003B!"+
		"\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000"+
		"\u0000\u00db\u00dc\u00056\u0000\u0000\u00dc\u0158\u0001\u0000\u0000\u0000"+
		"\u00dd\u00e1\u0005\"\u0000\u0000\u00de\u00e0\u0005K\u0000\u0000\u00df"+
		"\u00de\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e8\u00055\u0000\u0000\u00e5\u00e7\u0005K\u0000\u0000\u00e6\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e7\u00ea\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00eb\u0001"+
		"\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ec\u0003"+
		"6\u001b\u0000\u00ec\u00ed\u00056\u0000\u0000\u00ed\u0158\u0001\u0000\u0000"+
		"\u0000\u00ee\u00f2\u0005#\u0000\u0000\u00ef\u00f1\u0005K\u0000\u0000\u00f0"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f9\u00055\u0000\u0000\u00f6\u00f8\u0005K\u0000\u0000\u00f7\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00fd\u0003"+
		"6\u001b\u0000\u00fd\u00fe\u00056\u0000\u0000\u00fe\u0158\u0001\u0000\u0000"+
		"\u0000\u00ff\u0103\u0005\u001f\u0000\u0000\u0100\u0102\u0005K\u0000\u0000"+
		"\u0101\u0100\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000"+
		"\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000"+
		"\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0106\u0108\u0003\u001c\u000e\u0000\u0107\u0106\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000"+
		"\u0109\u010d\u00055\u0000\u0000\u010a\u010c\u0005K\u0000\u0000\u010b\u010a"+
		"\u0001\u0000\u0000\u0000\u010c\u010f\u0001\u0000\u0000\u0000\u010d\u010b"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u0119"+
		"\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u0110\u0114"+
		"\u0003\"\u0011\u0000\u0111\u0113\u0005K\u0000\u0000\u0112\u0111\u0001"+
		"\u0000\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000\u0114\u0112\u0001"+
		"\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0118\u0001"+
		"\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0117\u0110\u0001"+
		"\u0000\u0000\u0000\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011c\u0001"+
		"\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u0158\u0005"+
		"6\u0000\u0000\u011d\u0121\u0005\u001e\u0000\u0000\u011e\u0120\u0005K\u0000"+
		"\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000\u0000"+
		"\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000"+
		"\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000"+
		"\u0000\u0124\u0128\u0005J\u0000\u0000\u0125\u0127\u0005K\u0000\u0000\u0126"+
		"\u0125\u0001\u0000\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128"+
		"\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129"+
		"\u012b\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b"+
		"\u012f\u00055\u0000\u0000\u012c\u012e\u0005K\u0000\u0000\u012d\u012c\u0001"+
		"\u0000\u0000\u0000\u012e\u0131\u0001\u0000\u0000\u0000\u012f\u012d\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u013b\u0001"+
		"\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0132\u0136\u0003"+
		"$\u0012\u0000\u0133\u0135\u0005K\u0000\u0000\u0134\u0133\u0001\u0000\u0000"+
		"\u0000\u0135\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000"+
		"\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000"+
		"\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0139\u0132\u0001\u0000\u0000"+
		"\u0000\u013a\u013d\u0001\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000"+
		"\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013e\u0001\u0000\u0000"+
		"\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013e\u0158\u00056\u0000\u0000"+
		"\u013f\u0143\u0005$\u0000\u0000\u0140\u0142\u0005K\u0000\u0000\u0141\u0140"+
		"\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143\u0141"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0149"+
		"\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u0148"+
		"\u0003@ \u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0148\u014b\u0001\u0000"+
		"\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000"+
		"\u0000\u0000\u014a\u0155\u0001\u0000\u0000\u0000\u014b\u0149\u0001\u0000"+
		"\u0000\u0000\u014c\u0150\u00055\u0000\u0000\u014d\u014f\u0003@ \u0000"+
		"\u014e\u014d\u0001\u0000\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000"+
		"\u0150\u014e\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000"+
		"\u0151\u0153\u0001\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000"+
		"\u0153\u0156\u00056\u0000\u0000\u0154\u0156\u00052\u0000\u0000\u0155\u014c"+
		"\u0001\u0000\u0000\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0156\u0158"+
		"\u0001\u0000\u0000\u0000\u0157\u00b0\u0001\u0000\u0000\u0000\u0157\u00b1"+
		"\u0001\u0000\u0000\u0000\u0157\u00c3\u0001\u0000\u0000\u0000\u0157\u00dd"+
		"\u0001\u0000\u0000\u0000\u0157\u00ee\u0001\u0000\u0000\u0000\u0157\u00ff"+
		"\u0001\u0000\u0000\u0000\u0157\u011d\u0001\u0000\u0000\u0000\u0157\u013f"+
		"\u0001\u0000\u0000\u0000\u0158\u001b\u0001\u0000\u0000\u0000\u0159\u0164"+
		"\u0003\u001e\u000f\u0000\u015a\u015e\u00054\u0000\u0000\u015b\u015d\u0005"+
		"K\u0000\u0000\u015c\u015b\u0001\u0000\u0000\u0000\u015d\u0160\u0001\u0000"+
		"\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000"+
		"\u0000\u0000\u015f\u0161\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000"+
		"\u0000\u0000\u0161\u0163\u0003\u001e\u000f\u0000\u0162\u015a\u0001\u0000"+
		"\u0000\u0000\u0163\u0166\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000"+
		"\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u001d\u0001\u0000"+
		"\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0167\u016b\u0003 \u0010"+
		"\u0000\u0168\u016a\u0005K\u0000\u0000\u0169\u0168\u0001\u0000\u0000\u0000"+
		"\u016a\u016d\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000"+
		"\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016f\u0001\u0000\u0000\u0000"+
		"\u016d\u016b\u0001\u0000\u0000\u0000\u016e\u0167\u0001\u0000\u0000\u0000"+
		"\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000"+
		"\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u001f\u0001\u0000\u0000\u0000"+
		"\u0172\u018d\u0005J\u0000\u0000\u0173\u0177\u00057\u0000\u0000\u0174\u0176"+
		"\u0005K\u0000\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0176\u0179\u0001"+
		"\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001"+
		"\u0000\u0000\u0000\u0178\u017a\u0001\u0000\u0000\u0000\u0179\u0177\u0001"+
		"\u0000\u0000\u0000\u017a\u017e\u0005J\u0000\u0000\u017b\u017d\u0005K\u0000"+
		"\u0000\u017c\u017b\u0001\u0000\u0000\u0000\u017d\u0180\u0001\u0000\u0000"+
		"\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000"+
		"\u0000\u017f\u0189\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000\u0000"+
		"\u0000\u0181\u0185\u00053\u0000\u0000\u0182\u0184\u0005K\u0000\u0000\u0183"+
		"\u0182\u0001\u0000\u0000\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185"+
		"\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186"+
		"\u0188\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188"+
		"\u018a\u0003:\u001d\u0000\u0189\u0181\u0001\u0000\u0000\u0000\u0189\u018a"+
		"\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018d"+
		"\u00058\u0000\u0000\u018c\u0172\u0001\u0000\u0000\u0000\u018c\u0173\u0001"+
		"\u0000\u0000\u0000\u018d!\u0001\u0000\u0000\u0000\u018e\u0191\u0003(\u0014"+
		"\u0000\u018f\u0191\u0003\u001a\r\u0000\u0190\u018e\u0001\u0000\u0000\u0000"+
		"\u0190\u018f\u0001\u0000\u0000\u0000\u0191#\u0001\u0000\u0000\u0000\u0192"+
		"\u019d\u0003&\u0013\u0000\u0193\u0197\u00054\u0000\u0000\u0194\u0196\u0005"+
		"K\u0000\u0000\u0195\u0194\u0001\u0000\u0000\u0000\u0196\u0199\u0001\u0000"+
		"\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000"+
		"\u0000\u0000\u0198\u019a\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000"+
		"\u0000\u0000\u019a\u019c\u0003&\u0013\u0000\u019b\u0193\u0001\u0000\u0000"+
		"\u0000\u019c\u019f\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000"+
		"\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u01a0\u0001\u0000\u0000"+
		"\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u01a4\u00055\u0000\u0000"+
		"\u01a1\u01a3\u0005K\u0000\u0000\u01a2\u01a1\u0001\u0000\u0000\u0000\u01a3"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a5\u0001\u0000\u0000\u0000\u01a5\u01a7\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a4\u0001\u0000\u0000\u0000\u01a7\u01a8\u00036\u001b\u0000\u01a8\u01a9"+
		"\u00056\u0000\u0000\u01a9%\u0001\u0000\u0000\u0000\u01aa\u01ab\u0007\u0003"+
		"\u0000\u0000\u01ab\'\u0001\u0000\u0000\u0000\u01ac\u01b7\u0003*\u0015"+
		"\u0000\u01ad\u01b1\u00054\u0000\u0000\u01ae\u01b0\u0005K\u0000\u0000\u01af"+
		"\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000\u0000\u01b1"+
		"\u01af\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b4\u0001\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4"+
		"\u01b6\u0003*\u0015\u0000\u01b5\u01ad\u0001\u0000\u0000\u0000\u01b6\u01b9"+
		"\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b8"+
		"\u0001\u0000\u0000\u0000\u01b8\u01bb\u0001\u0000\u0000\u0000\u01b9\u01b7"+
		"\u0001\u0000\u0000\u0000\u01ba\u01ac\u0001\u0000\u0000\u0000\u01ba\u01bb"+
		"\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc\u01c0"+
		"\u00055\u0000\u0000\u01bd\u01bf\u0005K\u0000\u0000\u01be\u01bd\u0001\u0000"+
		"\u0000\u0000\u01bf\u01c2\u0001\u0000\u0000\u0000\u01c0\u01be\u0001\u0000"+
		"\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c3\u0001\u0000"+
		"\u0000\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c3\u01c4\u00036\u001b"+
		"\u0000\u01c4\u01c5\u00056\u0000\u0000\u01c5)\u0001\u0000\u0000\u0000\u01c6"+
		"\u01cc\u0003.\u0017\u0000\u01c7\u01c8\u0003,\u0016\u0000\u01c8\u01c9\u0003"+
		".\u0017\u0000\u01c9\u01cb\u0001\u0000\u0000\u0000\u01ca\u01c7\u0001\u0000"+
		"\u0000\u0000\u01cb\u01ce\u0001\u0000\u0000\u0000\u01cc\u01ca\u0001\u0000"+
		"\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000\u0000\u01cd+\u0001\u0000\u0000"+
		"\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01cf\u01d3\u0005H\u0000\u0000"+
		"\u01d0\u01d2\u0005K\u0000\u0000\u01d1\u01d0\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d5\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3"+
		"\u01d4\u0001\u0000\u0000\u0000\u01d4\u01ea\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d6\u01da\u0005>\u0000\u0000\u01d7\u01d9"+
		"\u0005K\u0000\u0000\u01d8\u01d7\u0001\u0000\u0000\u0000\u01d9\u01dc\u0001"+
		"\u0000\u0000\u0000\u01da\u01d8\u0001\u0000\u0000\u0000\u01da\u01db\u0001"+
		"\u0000\u0000\u0000\u01db\u01ea\u0001\u0000\u0000\u0000\u01dc\u01da\u0001"+
		"\u0000\u0000\u0000\u01dd\u01e1\u0005<\u0000\u0000\u01de\u01e0\u0005K\u0000"+
		"\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01e0\u01e3\u0001\u0000\u0000"+
		"\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000"+
		"\u0000\u01e2\u01ea\u0001\u0000\u0000\u0000\u01e3\u01e1\u0001\u0000\u0000"+
		"\u0000\u01e4\u01e6\u0005K\u0000\u0000\u01e5\u01e4\u0001\u0000\u0000\u0000"+
		"\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000"+
		"\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01ea\u0001\u0000\u0000\u0000"+
		"\u01e9\u01cf\u0001\u0000\u0000\u0000\u01e9\u01d6\u0001\u0000\u0000\u0000"+
		"\u01e9\u01dd\u0001\u0000\u0000\u0000\u01e9\u01e5\u0001\u0000\u0000\u0000"+
		"\u01ea-\u0001\u0000\u0000\u0000\u01eb\u01ef\u0007\u0004\u0000\u0000\u01ec"+
		"\u01ee\u00030\u0018\u0000\u01ed\u01ec\u0001\u0000\u0000\u0000\u01ee\u01f1"+
		"\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000\u0000\u01ef\u01f0"+
		"\u0001\u0000\u0000\u0000\u01f0\u01f5\u0001\u0000\u0000\u0000\u01f1\u01ef"+
		"\u0001\u0000\u0000\u0000\u01f2\u01f4\u0005K\u0000\u0000\u01f3\u01f2\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f7\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001"+
		"\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f6\u0204\u0001"+
		"\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000\u01f8\u01fa\u0003"+
		"0\u0018\u0000\u01f9\u01f8\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001\u0000"+
		"\u0000\u0000\u01fc\u0200\u0001\u0000\u0000\u0000\u01fd\u01ff\u0005K\u0000"+
		"\u0000\u01fe\u01fd\u0001\u0000\u0000\u0000\u01ff\u0202\u0001\u0000\u0000"+
		"\u0000\u0200\u01fe\u0001\u0000\u0000\u0000\u0200\u0201\u0001\u0000\u0000"+
		"\u0000\u0201\u0204\u0001\u0000\u0000\u0000\u0202\u0200\u0001\u0000\u0000"+
		"\u0000\u0203\u01eb\u0001\u0000\u0000\u0000\u0203\u01f9\u0001\u0000\u0000"+
		"\u0000\u0204/\u0001\u0000\u0000\u0000\u0205\u0213\u0005(\u0000\u0000\u0206"+
		"\u0213\u0005%\u0000\u0000\u0207\u020b\u00059\u0000\u0000\u0208\u020a\u0005"+
		"K\u0000\u0000\u0209\u0208\u0001\u0000\u0000\u0000\u020a\u020d\u0001\u0000"+
		"\u0000\u0000\u020b\u0209\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000"+
		"\u0000\u0000\u020c\u020e\u0001\u0000\u0000\u0000\u020d\u020b\u0001\u0000"+
		"\u0000\u0000\u020e\u020f\u00032\u0019\u0000\u020f\u0210\u0005:\u0000\u0000"+
		"\u0210\u0213\u0001\u0000\u0000\u0000\u0211\u0213\u00034\u001a\u0000\u0212"+
		"\u0205\u0001\u0000\u0000\u0000\u0212\u0206\u0001\u0000\u0000\u0000\u0212"+
		"\u0207\u0001\u0000\u0000\u0000\u0212\u0211\u0001\u0000\u0000\u0000\u0213"+
		"1\u0001\u0000\u0000\u0000\u0214\u0218\u0005J\u0000\u0000\u0215\u0217\u0005"+
		"K\u0000\u0000\u0216\u0215\u0001\u0000\u0000\u0000\u0217\u021a\u0001\u0000"+
		"\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000\u0218\u0219\u0001\u0000"+
		"\u0000\u0000\u0219\u0229\u0001\u0000\u0000\u0000\u021a\u0218\u0001\u0000"+
		"\u0000\u0000\u021b\u021f\u0007\u0005\u0000\u0000\u021c\u021e\u0005K\u0000"+
		"\u0000\u021d\u021c\u0001\u0000\u0000\u0000\u021e\u0221\u0001\u0000\u0000"+
		"\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u021f\u0220\u0001\u0000\u0000"+
		"\u0000\u0220\u0222\u0001\u0000\u0000\u0000\u0221\u021f\u0001\u0000\u0000"+
		"\u0000\u0222\u0226\u0007\u0006\u0000\u0000\u0223\u0225\u0005K\u0000\u0000"+
		"\u0224\u0223\u0001\u0000\u0000\u0000\u0225\u0228\u0001\u0000\u0000\u0000"+
		"\u0226\u0224\u0001\u0000\u0000\u0000\u0226\u0227\u0001\u0000\u0000\u0000"+
		"\u0227\u022a\u0001\u0000\u0000\u0000\u0228\u0226\u0001\u0000\u0000\u0000"+
		"\u0229\u021b\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000\u0000\u0000"+
		"\u022a3\u0001\u0000\u0000\u0000\u022b\u022d\u00053\u0000\u0000\u022c\u022e"+
		"\u00053\u0000\u0000\u022d\u022c\u0001\u0000\u0000\u0000\u022d\u022e\u0001"+
		"\u0000\u0000\u0000\u022e\u025d\u0001\u0000\u0000\u0000\u022f\u0231\u0005"+
		"=\u0000\u0000\u0230\u022f\u0001\u0000\u0000\u0000\u0230\u0231\u0001\u0000"+
		"\u0000\u0000\u0231\u0232\u0001\u0000\u0000\u0000\u0232\u025e\u0005J\u0000"+
		"\u0000\u0233\u0237\u0005I\u0000\u0000\u0234\u0236\u0005K\u0000\u0000\u0235"+
		"\u0234\u0001\u0000\u0000\u0000\u0236\u0239\u0001\u0000\u0000\u0000\u0237"+
		"\u0235\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238"+
		"\u0254\u0001\u0000\u0000\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u023a"+
		"\u023c\u0005=\u0000\u0000\u023b\u023a\u0001\u0000\u0000\u0000\u023b\u023c"+
		"\u0001\u0000\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000\u023d\u0255"+
		"\u0005J\u0000\u0000\u023e\u0240\u0005=\u0000\u0000\u023f\u023e\u0001\u0000"+
		"\u0000\u0000\u023f\u0240\u0001\u0000\u0000\u0000\u0240\u0241\u0001\u0000"+
		"\u0000\u0000\u0241\u0255\u0005*\u0000\u0000\u0242\u0244\u0005=\u0000\u0000"+
		"\u0243\u0242\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000\u0000"+
		"\u0244\u0245\u0001\u0000\u0000\u0000\u0245\u0255\u0005)\u0000\u0000\u0246"+
		"\u0251\u0003.\u0017\u0000\u0247\u024b\u00054\u0000\u0000\u0248\u024a\u0005"+
		"K\u0000\u0000\u0249\u0248\u0001\u0000\u0000\u0000\u024a\u024d\u0001\u0000"+
		"\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024b\u024c\u0001\u0000"+
		"\u0000\u0000\u024c\u024e\u0001\u0000\u0000\u0000\u024d\u024b\u0001\u0000"+
		"\u0000\u0000\u024e\u0250\u0003.\u0017\u0000\u024f\u0247\u0001\u0000\u0000"+
		"\u0000\u0250\u0253\u0001\u0000\u0000\u0000\u0251\u024f\u0001\u0000\u0000"+
		"\u0000\u0251\u0252\u0001\u0000\u0000\u0000\u0252\u0255\u0001\u0000\u0000"+
		"\u0000\u0253\u0251\u0001\u0000\u0000\u0000\u0254\u023b\u0001\u0000\u0000"+
		"\u0000\u0254\u023f\u0001\u0000\u0000\u0000\u0254\u0243\u0001\u0000\u0000"+
		"\u0000\u0254\u0246\u0001\u0000\u0000\u0000\u0255\u0259\u0001\u0000\u0000"+
		"\u0000\u0256\u0258\u0005K\u0000\u0000\u0257\u0256\u0001\u0000\u0000\u0000"+
		"\u0258\u025b\u0001\u0000\u0000\u0000\u0259\u0257\u0001\u0000\u0000\u0000"+
		"\u0259\u025a\u0001\u0000\u0000\u0000\u025a\u025c\u0001\u0000\u0000\u0000"+
		"\u025b\u0259\u0001\u0000\u0000\u0000\u025c\u025e\u00058\u0000\u0000\u025d"+
		"\u0230\u0001\u0000\u0000\u0000\u025d\u0233\u0001\u0000\u0000\u0000\u025e"+
		"5\u0001\u0000\u0000\u0000\u025f\u0261\u00038\u001c\u0000\u0260\u025f\u0001"+
		"\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261\u026e\u0001"+
		"\u0000\u0000\u0000\u0262\u0266\u00052\u0000\u0000\u0263\u0265\u0005K\u0000"+
		"\u0000\u0264\u0263\u0001\u0000\u0000\u0000\u0265\u0268\u0001\u0000\u0000"+
		"\u0000\u0266\u0264\u0001\u0000\u0000\u0000\u0266\u0267\u0001\u0000\u0000"+
		"\u0000\u0267\u026a\u0001\u0000\u0000\u0000\u0268\u0266\u0001\u0000\u0000"+
		"\u0000\u0269\u026b\u00038\u001c\u0000\u026a\u0269\u0001\u0000\u0000\u0000"+
		"\u026a\u026b\u0001\u0000\u0000\u0000\u026b\u026d\u0001\u0000\u0000\u0000"+
		"\u026c\u0262\u0001\u0000\u0000\u0000\u026d\u0270\u0001\u0000\u0000\u0000"+
		"\u026e\u026c\u0001\u0000\u0000\u0000\u026e\u026f\u0001\u0000\u0000\u0000"+
		"\u026f7\u0001\u0000\u0000\u0000\u0270\u026e\u0001\u0000\u0000\u0000\u0271"+
		"\u0272\u0005J\u0000\u0000\u0272\u0276\u00053\u0000\u0000\u0273\u0275\u0005"+
		"K\u0000\u0000\u0274\u0273\u0001\u0000\u0000\u0000\u0275\u0278\u0001\u0000"+
		"\u0000\u0000\u0276\u0274\u0001\u0000\u0000\u0000\u0276\u0277\u0001\u0000"+
		"\u0000\u0000\u0277\u027a\u0001\u0000\u0000\u0000\u0278\u0276\u0001\u0000"+
		"\u0000\u0000\u0279\u027b\u0003:\u001d\u0000\u027a\u0279\u0001\u0000\u0000"+
		"\u0000\u027a\u027b\u0001\u0000\u0000\u0000\u027b\u027d\u0001\u0000\u0000"+
		"\u0000\u027c\u027e\u0005N\u0000\u0000\u027d\u027c\u0001\u0000\u0000\u0000"+
		"\u027d\u027e\u0001\u0000\u0000\u0000\u027e9\u0001\u0000\u0000\u0000\u027f"+
		"\u0281\u0003<\u001e\u0000\u0280\u027f\u0001\u0000\u0000\u0000\u0281\u0282"+
		"\u0001\u0000\u0000\u0000\u0282\u0280\u0001\u0000\u0000\u0000\u0282\u0283"+
		"\u0001\u0000\u0000\u0000\u0283;\u0001\u0000\u0000\u0000\u0284\u0294\u0005"+
		"J\u0000\u0000\u0285\u0294\u0005*\u0000\u0000\u0286\u0294\u0005+\u0000"+
		"\u0000\u0287\u0294\u0005,\u0000\u0000\u0288\u0294\u0005&\u0000\u0000\u0289"+
		"\u0294\u0005\'\u0000\u0000\u028a\u0294\u0005-\u0000\u0000\u028b\u0294"+
		"\u0005.\u0000\u0000\u028c\u0294\u0005(\u0000\u0000\u028d\u0294\u0005/"+
		"\u0000\u0000\u028e\u0294\u0003>\u001f\u0000\u028f\u0294\u0005=\u0000\u0000"+
		"\u0290\u0294\u0005>\u0000\u0000\u0291\u0294\u00054\u0000\u0000\u0292\u0294"+
		"\u0005G\u0000\u0000\u0293\u0284\u0001\u0000\u0000\u0000\u0293\u0285\u0001"+
		"\u0000\u0000\u0000\u0293\u0286\u0001\u0000\u0000\u0000\u0293\u0287\u0001"+
		"\u0000\u0000\u0000\u0293\u0288\u0001\u0000\u0000\u0000\u0293\u0289\u0001"+
		"\u0000\u0000\u0000\u0293\u028a\u0001\u0000\u0000\u0000\u0293\u028b\u0001"+
		"\u0000\u0000\u0000\u0293\u028c\u0001\u0000\u0000\u0000\u0293\u028d\u0001"+
		"\u0000\u0000\u0000\u0293\u028e\u0001\u0000\u0000\u0000\u0293\u028f\u0001"+
		"\u0000\u0000\u0000\u0293\u0290\u0001\u0000\u0000\u0000\u0293\u0291\u0001"+
		"\u0000\u0000\u0000\u0293\u0292\u0001\u0000\u0000\u0000\u0294=\u0001\u0000"+
		"\u0000\u0000\u0295\u0299\u0005I\u0000\u0000\u0296\u0298\u0005K\u0000\u0000"+
		"\u0297\u0296\u0001\u0000\u0000\u0000\u0298\u029b\u0001\u0000\u0000\u0000"+
		"\u0299\u0297\u0001\u0000\u0000\u0000\u0299\u029a\u0001\u0000\u0000\u0000"+
		"\u029a\u029d\u0001\u0000\u0000\u0000\u029b\u0299\u0001\u0000\u0000\u0000"+
		"\u029c\u029e\u0003:\u001d\u0000\u029d\u029c\u0001\u0000\u0000\u0000\u029d"+
		"\u029e\u0001\u0000\u0000\u0000\u029e\u029f\u0001\u0000\u0000\u0000\u029f"+
		"\u02a0\u00058\u0000\u0000\u02a0?\u0001\u0000\u0000\u0000\u02a1\u02a2\t"+
		"\u0000\u0000\u0000\u02a2A\u0001\u0000\u0000\u0000\u02a3\u02a7\u0005!\u0000"+
		"\u0000\u02a4\u02a6\u0005K\u0000\u0000\u02a5\u02a4\u0001\u0000\u0000\u0000"+
		"\u02a6\u02a9\u0001\u0000\u0000\u0000\u02a7\u02a5\u0001\u0000\u0000\u0000"+
		"\u02a7\u02a8\u0001\u0000\u0000\u0000\u02a8\u02aa\u0001\u0000\u0000\u0000"+
		"\u02a9\u02a7\u0001\u0000\u0000\u0000\u02aa\u02ae\u00055\u0000\u0000\u02ab"+
		"\u02ad\u0005K\u0000\u0000\u02ac\u02ab\u0001\u0000\u0000\u0000\u02ad\u02b0"+
		"\u0001\u0000\u0000\u0000\u02ae\u02ac\u0001\u0000\u0000\u0000\u02ae\u02af"+
		"\u0001\u0000\u0000\u0000\u02af\u02b1\u0001\u0000\u0000\u0000\u02b0\u02ae"+
		"\u0001\u0000\u0000\u0000\u02b1\u02b2\u00036\u001b\u0000\u02b2\u02b3\u0005"+
		"6\u0000\u0000\u02b3C\u0001\u0000\u0000\u0000bGV]bmu\u0085\u0093\u0095"+
		"\u009a\u009f\u00a7\u00a9\u00ae\u00b5\u00bc\u00c0\u00c5\u00ca\u00d1\u00d8"+
		"\u00e1\u00e8\u00f2\u00f9\u0103\u0107\u010d\u0114\u0119\u0121\u0128\u012f"+
		"\u0136\u013b\u0143\u0149\u0150\u0155\u0157\u015e\u0164\u016b\u0170\u0177"+
		"\u017e\u0185\u0189\u018c\u0190\u0197\u019d\u01a4\u01b1\u01b7\u01ba\u01c0"+
		"\u01cc\u01d3\u01da\u01e1\u01e7\u01e9\u01ef\u01f5\u01fb\u0200\u0203\u020b"+
		"\u0212\u0218\u021f\u0226\u0229\u022d\u0230\u0237\u023b\u023f\u0243\u024b"+
		"\u0251\u0254\u0259\u025d\u0260\u0266\u026a\u026e\u0276\u027a\u027d\u0282"+
		"\u0293\u0299\u029d\u02a7\u02ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}