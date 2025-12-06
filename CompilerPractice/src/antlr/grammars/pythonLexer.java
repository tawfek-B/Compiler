// Generated from C:/Users/DELL/IdeaProjects/CompilerPractice/src/grammars/pythonLexer.g4 by ANTLR 4.13.2
package grammars;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class pythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, IF=3, ELIF=4, ELSE=5, FOR=6, IN=7, DEF=8, TRUE=9, 
		FALSE=10, RETURN=11, ROUTE=12, ASSIGN=13, PLUS=14, MINUS=15, MULTIPLY=16, 
		DIVIDE=17, MODIFY=18, EQUAL=19, NOT_EQUAL=20, GREATER_THAN=21, LESS_THAN=22, 
		GREATER_EQUAL=23, LESS_EQUAL=24, LP=25, RP=26, LSB=27, RSB=28, LCB=29, 
		RCB=30, COMMA=31, COLON=32, SEMICOLON=33, DOT=34, DOUBLE_COT=35, HASHTAG=36, 
		NUMBER=37, STRING=38, ID=39, COMMENT=40, MULTILINE_COMMENT=41, NEWLINE=42, 
		WS=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "ELIF", "ELSE", "FOR", "IN", "DEF", "TRUE", "FALSE", "RETURN", 
			"ROUTE", "ASSIGN", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "MODIFY", "EQUAL", 
			"NOT_EQUAL", "GREATER_THAN", "LESS_THAN", "GREATER_EQUAL", "LESS_EQUAL", 
			"LP", "RP", "LSB", "RSB", "LCB", "RCB", "COMMA", "COLON", "SEMICOLON", 
			"DOT", "DOUBLE_COT", "HASHTAG", "NUMBER", "STRING", "ID", "COMMENT", 
			"MULTILINE_COMMENT", "NEWLINE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'if'", "'elif'", "'else'", "'for'", "'in'", "'def'", 
			"'true'", "'false'", "'return'", "'@route'", "'='", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "','", "':'", "';'", "'.'", "'\"'", "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "IF", "ELIF", "ELSE", "FOR", "IN", "DEF", "TRUE", 
			"FALSE", "RETURN", "ROUTE", "ASSIGN", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", 
			"MODIFY", "EQUAL", "NOT_EQUAL", "GREATER_THAN", "LESS_THAN", "GREATER_EQUAL", 
			"LESS_EQUAL", "LP", "RP", "LSB", "RSB", "LCB", "RCB", "COMMA", "COLON", 
			"SEMICOLON", "DOT", "DOUBLE_COT", "HASHTAG", "NUMBER", "STRING", "ID", 
			"COMMENT", "MULTILINE_COMMENT", "NEWLINE", "WS"
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



	    // Count indentation levels
	    private java.util.Stack<Integer> indents = new java.util.Stack<>();

	    // Needed to ignore indentation inside parentheses/brackets
	    private int opened = 0;

	    // Buffer to emit INDENT/DEDENT properly
	    private java.util.LinkedList<Token> pending = new java.util.LinkedList<>();

	    @Override
	    public void emit(Token token) {
	        pending.add(token);
	        super.setToken(token);
	    }

	    @Override
	    public Token nextToken() {

	        // If any buffered tokens exist → return them first
	        if (!pending.isEmpty()) {
	            return pending.poll();
	        }

	        Token next = super.nextToken();

	        // Close all open indents on the end of file
	        if (next.getType() == EOF) {
	            while (!indents.isEmpty()) {
	                indents.pop();
	                emit(new CommonToken(DEDENT, ""));
	            }
	        }

	        return next;
	    }

	    // Helper: emit INDENT token
	    private void emitIndent(int wsCount) {
	        indents.push(wsCount);
	        emit(new CommonToken(INDENT, "<INDENT>"));
	    }

	    // Helper: emit DEDENT tokens
	    private void emitDedent(int wsCount) {
	        while (!indents.isEmpty() && indents.peek() > wsCount) {
	            indents.pop();
	            emit(new CommonToken(DEDENT, "<DEDENT>"));
	        }
	    }


	public pythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "pythonLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 22:
			LP_action((RuleContext)_localctx, actionIndex);
			break;
		case 23:
			RP_action((RuleContext)_localctx, actionIndex);
			break;
		case 24:
			LSB_action((RuleContext)_localctx, actionIndex);
			break;
		case 25:
			RSB_action((RuleContext)_localctx, actionIndex);
			break;
		case 26:
			LCB_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			RCB_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void LP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 opened++; 
			break;
		}
	}
	private void RP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 opened--; 
			break;
		}
	}
	private void LSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 opened++; 
			break;
		}
	}
	private void RSB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 opened--; 
			break;
		}
	}
	private void LCB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 opened++; 
			break;
		}
	}
	private void RCB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 opened--; 
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:


			            // Count spaces after the newline
			            int spaces = 0;
			            int la = _input.LA(1);

			            // skip pure newline inside (),[],{}
			            if (opened > 0) {
			                skip();
			            }
			            else {

			                // accumulate indentation
			                while (la == ' ' || la == '\t') {
			                    if (la == ' ') spaces++;
			                    if (la == '\t') spaces += 4; // tabs = 4 spaces
			                    _input.consume();
			                    la = _input.LA(1);
			                }

			                emit(new CommonToken(NEWLINE, "\n"));

			                int currentIndent = indents.isEmpty() ? 0 : indents.peek();

			                if (spaces > currentIndent) {
			                    emitIndent(spaces);
			                } else if (spaces < currentIndent) {
			                    emitDedent(spaces);
			                }
			            }
			        
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000+\u0105\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"\"\u0004\"\u00c0\b\"\u000b\"\f\"\u00c1\u0001\"\u0001\"\u0004\"\u00c6\b"+
		"\"\u000b\"\f\"\u00c7\u0003\"\u00ca\b\"\u0001#\u0001#\u0005#\u00ce\b#\n"+
		"#\f#\u00d1\t#\u0001#\u0001#\u0001$\u0001$\u0005$\u00d7\b$\n$\f$\u00da"+
		"\t$\u0001%\u0001%\u0005%\u00de\b%\n%\f%\u00e1\t%\u0001%\u0001%\u0001&"+
		"\u0001&\u0001&\u0001&\u0001&\u0005&\u00ea\b&\n&\f&\u00ed\t&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0003\'\u00f6\b\'\u0001\'\u0004"+
		"\'\u00f9\b\'\u000b\'\f\'\u00fa\u0001\'\u0001\'\u0001(\u0004(\u0100\b("+
		"\u000b(\f(\u0101\u0001(\u0001(\u0001\u00eb\u0000)\u0001\u0003\u0003\u0004"+
		"\u0005\u0005\u0007\u0006\t\u0007\u000b\b\r\t\u000f\n\u0011\u000b\u0013"+
		"\f\u0015\r\u0017\u000e\u0019\u000f\u001b\u0010\u001d\u0011\u001f\u0012"+
		"!\u0013#\u0014%\u0015\'\u0016)\u0017+\u0018-\u0019/\u001a1\u001b3\u001c"+
		"5\u001d7\u001e9\u001f; =!?\"A#C$E%G&I\'K(M)O*Q+\u0001\u0000\u0006\u0001"+
		"\u000009\u0003\u0000\n\n\r\r\"\"\u0003\u0000AZ__az\u0004\u000009AZ__a"+
		"z\u0002\u0000\n\n\r\r\u0002\u0000\t\t  \u010e\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000"+
		"?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001"+
		"\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000"+
		"\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000"+
		"M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001"+
		"\u0000\u0000\u0000\u0001S\u0001\u0000\u0000\u0000\u0003V\u0001\u0000\u0000"+
		"\u0000\u0005[\u0001\u0000\u0000\u0000\u0007`\u0001\u0000\u0000\u0000\t"+
		"d\u0001\u0000\u0000\u0000\u000bg\u0001\u0000\u0000\u0000\rk\u0001\u0000"+
		"\u0000\u0000\u000fp\u0001\u0000\u0000\u0000\u0011v\u0001\u0000\u0000\u0000"+
		"\u0013}\u0001\u0000\u0000\u0000\u0015\u0084\u0001\u0000\u0000\u0000\u0017"+
		"\u0086\u0001\u0000\u0000\u0000\u0019\u0088\u0001\u0000\u0000\u0000\u001b"+
		"\u008a\u0001\u0000\u0000\u0000\u001d\u008c\u0001\u0000\u0000\u0000\u001f"+
		"\u008e\u0001\u0000\u0000\u0000!\u0090\u0001\u0000\u0000\u0000#\u0093\u0001"+
		"\u0000\u0000\u0000%\u0096\u0001\u0000\u0000\u0000\'\u0098\u0001\u0000"+
		"\u0000\u0000)\u009a\u0001\u0000\u0000\u0000+\u009d\u0001\u0000\u0000\u0000"+
		"-\u00a0\u0001\u0000\u0000\u0000/\u00a3\u0001\u0000\u0000\u00001\u00a6"+
		"\u0001\u0000\u0000\u00003\u00a9\u0001\u0000\u0000\u00005\u00ac\u0001\u0000"+
		"\u0000\u00007\u00af\u0001\u0000\u0000\u00009\u00b2\u0001\u0000\u0000\u0000"+
		";\u00b4\u0001\u0000\u0000\u0000=\u00b6\u0001\u0000\u0000\u0000?\u00b8"+
		"\u0001\u0000\u0000\u0000A\u00ba\u0001\u0000\u0000\u0000C\u00bc\u0001\u0000"+
		"\u0000\u0000E\u00bf\u0001\u0000\u0000\u0000G\u00cb\u0001\u0000\u0000\u0000"+
		"I\u00d4\u0001\u0000\u0000\u0000K\u00db\u0001\u0000\u0000\u0000M\u00e4"+
		"\u0001\u0000\u0000\u0000O\u00f8\u0001\u0000\u0000\u0000Q\u00ff\u0001\u0000"+
		"\u0000\u0000ST\u0005i\u0000\u0000TU\u0005f\u0000\u0000U\u0002\u0001\u0000"+
		"\u0000\u0000VW\u0005e\u0000\u0000WX\u0005l\u0000\u0000XY\u0005i\u0000"+
		"\u0000YZ\u0005f\u0000\u0000Z\u0004\u0001\u0000\u0000\u0000[\\\u0005e\u0000"+
		"\u0000\\]\u0005l\u0000\u0000]^\u0005s\u0000\u0000^_\u0005e\u0000\u0000"+
		"_\u0006\u0001\u0000\u0000\u0000`a\u0005f\u0000\u0000ab\u0005o\u0000\u0000"+
		"bc\u0005r\u0000\u0000c\b\u0001\u0000\u0000\u0000de\u0005i\u0000\u0000"+
		"ef\u0005n\u0000\u0000f\n\u0001\u0000\u0000\u0000gh\u0005d\u0000\u0000"+
		"hi\u0005e\u0000\u0000ij\u0005f\u0000\u0000j\f\u0001\u0000\u0000\u0000"+
		"kl\u0005t\u0000\u0000lm\u0005r\u0000\u0000mn\u0005u\u0000\u0000no\u0005"+
		"e\u0000\u0000o\u000e\u0001\u0000\u0000\u0000pq\u0005f\u0000\u0000qr\u0005"+
		"a\u0000\u0000rs\u0005l\u0000\u0000st\u0005s\u0000\u0000tu\u0005e\u0000"+
		"\u0000u\u0010\u0001\u0000\u0000\u0000vw\u0005r\u0000\u0000wx\u0005e\u0000"+
		"\u0000xy\u0005t\u0000\u0000yz\u0005u\u0000\u0000z{\u0005r\u0000\u0000"+
		"{|\u0005n\u0000\u0000|\u0012\u0001\u0000\u0000\u0000}~\u0005@\u0000\u0000"+
		"~\u007f\u0005r\u0000\u0000\u007f\u0080\u0005o\u0000\u0000\u0080\u0081"+
		"\u0005u\u0000\u0000\u0081\u0082\u0005t\u0000\u0000\u0082\u0083\u0005e"+
		"\u0000\u0000\u0083\u0014\u0001\u0000\u0000\u0000\u0084\u0085\u0005=\u0000"+
		"\u0000\u0085\u0016\u0001\u0000\u0000\u0000\u0086\u0087\u0005+\u0000\u0000"+
		"\u0087\u0018\u0001\u0000\u0000\u0000\u0088\u0089\u0005-\u0000\u0000\u0089"+
		"\u001a\u0001\u0000\u0000\u0000\u008a\u008b\u0005*\u0000\u0000\u008b\u001c"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0005/\u0000\u0000\u008d\u001e\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0005%\u0000\u0000\u008f \u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005=\u0000\u0000\u0091\u0092\u0005=\u0000\u0000\u0092"+
		"\"\u0001\u0000\u0000\u0000\u0093\u0094\u0005!\u0000\u0000\u0094\u0095"+
		"\u0005=\u0000\u0000\u0095$\u0001\u0000\u0000\u0000\u0096\u0097\u0005>"+
		"\u0000\u0000\u0097&\u0001\u0000\u0000\u0000\u0098\u0099\u0005<\u0000\u0000"+
		"\u0099(\u0001\u0000\u0000\u0000\u009a\u009b\u0005>\u0000\u0000\u009b\u009c"+
		"\u0005=\u0000\u0000\u009c*\u0001\u0000\u0000\u0000\u009d\u009e\u0005<"+
		"\u0000\u0000\u009e\u009f\u0005=\u0000\u0000\u009f,\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005(\u0000\u0000\u00a1\u00a2\u0006\u0016\u0000\u0000\u00a2"+
		".\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005)\u0000\u0000\u00a4\u00a5\u0006"+
		"\u0017\u0001\u0000\u00a50\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005[\u0000"+
		"\u0000\u00a7\u00a8\u0006\u0018\u0002\u0000\u00a82\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0005]\u0000\u0000\u00aa\u00ab\u0006\u0019\u0003\u0000\u00ab"+
		"4\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005{\u0000\u0000\u00ad\u00ae\u0006"+
		"\u001a\u0004\u0000\u00ae6\u0001\u0000\u0000\u0000\u00af\u00b0\u0005}\u0000"+
		"\u0000\u00b0\u00b1\u0006\u001b\u0005\u0000\u00b18\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005,\u0000\u0000\u00b3:\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0005:\u0000\u0000\u00b5<\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005;"+
		"\u0000\u0000\u00b7>\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005.\u0000\u0000"+
		"\u00b9@\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\"\u0000\u0000\u00bb"+
		"B\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005#\u0000\u0000\u00bdD\u0001"+
		"\u0000\u0000\u0000\u00be\u00c0\u0007\u0000\u0000\u0000\u00bf\u00be\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c5\u0005.\u0000\u0000\u00c4\u00c6\u0007\u0000"+
		"\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00caF\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cf\u0003A \u0000\u00cc\u00ce\b\u0001\u0000\u0000\u00cd"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0003A \u0000\u00d3H\u0001\u0000\u0000\u0000\u00d4\u00d8\u0007"+
		"\u0002\u0000\u0000\u00d5\u00d7\u0007\u0003\u0000\u0000\u00d6\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9J\u0001\u0000"+
		"\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00df\u0003C!\u0000"+
		"\u00dc\u00de\b\u0004\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e2\u00e3\u0006%\u0006\u0000\u00e3L\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0005\"\u0000\u0000\u00e5\u00e6\u0005\""+
		"\u0000\u0000\u00e6\u00e7\u0005\"\u0000\u0000\u00e7\u00eb\u0001\u0000\u0000"+
		"\u0000\u00e8\u00ea\t\u0000\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\"\u0000\u0000\u00ef"+
		"\u00f0\u0005\"\u0000\u0000\u00f0\u00f1\u0005\"\u0000\u0000\u00f1\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f3\u0006&\u0006\u0000\u00f3N\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f6\u0005\r\u0000\u0000\u00f5\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f9\u0005\n\u0000\u0000\u00f8\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0006\'\u0007\u0000\u00fdP\u0001\u0000\u0000\u0000\u00fe"+
		"\u0100\u0007\u0005\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0006(\u0006\u0000\u0104R\u0001\u0000\u0000\u0000\u000b\u0000\u00c1"+
		"\u00c7\u00c9\u00cf\u00d8\u00df\u00eb\u00f5\u00fa\u0101\b\u0001\u0016\u0000"+
		"\u0001\u0017\u0001\u0001\u0018\u0002\u0001\u0019\u0003\u0001\u001a\u0004"+
		"\u0001\u001b\u0005\u0006\u0000\u0000\u0001\'\u0006";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}