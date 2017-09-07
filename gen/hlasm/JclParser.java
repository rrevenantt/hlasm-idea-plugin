// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\JclParser.g4 by ANTLR 4.7
package hlasm;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JclParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, JOB_OPTION=2, LINE_START=3, SYSIN=4, LABEL_DEF=5, SPACES1=6, 
		ENDLINE=7, DD=8, EXEC=9, JOB=10, SET=11, ANY_COMMAND=12, LEFT_ROUND_PAR=13, 
		RIGHT_ROUND_PAR=14, EQUALS=15, EQUAL_FOR_TAPE=16, MUL=17, COMMA=18, PLUS=19, 
		MINUS=20, STRING=21, NUMBER=22, LABEL=23, ENDLINE1=24, SPACES=25, UNCKNOWN_SYMBOL=26, 
		LINE_START1=27;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_command = 2, RULE_arguments = 3, RULE_argument = 4, 
		RULE_named_argument = 5, RULE_expression = 6, RULE_simple_expr = 7, RULE_keyword = 8;
	public static final String[] ruleNames = {
		"file", "line", "command", "arguments", "argument", "named_argument", 
		"expression", "simple_expr", "keyword"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'//'", null, null, null, null, "'DD'", "'EXEC'", "'JOB'", 
		"'SET'", null, "'('", "')'", "'='", "'=/'", "'*'", "','", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LINE_COMMENT", "JOB_OPTION", "LINE_START", "SYSIN", "LABEL_DEF", 
		"SPACES1", "ENDLINE", "DD", "EXEC", "JOB", "SET", "ANY_COMMAND", "LEFT_ROUND_PAR", 
		"RIGHT_ROUND_PAR", "EQUALS", "EQUAL_FOR_TAPE", "MUL", "COMMA", "PLUS", 
		"MINUS", "STRING", "NUMBER", "LABEL", "ENDLINE1", "SPACES", "UNCKNOWN_SYMBOL", 
		"LINE_START1"
	};
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
	public String getGrammarFileName() { return "JclParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JclParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JclParser.EOF, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				line();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LINE_COMMENT) | (1L << JOB_OPTION) | (1L << LINE_START) | (1L << SYSIN))) != 0) );
			setState(23);
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

	public static class LineContext extends ParserRuleContext {
		public TerminalNode LINE_COMMENT() { return getToken(JclParser.LINE_COMMENT, 0); }
		public TerminalNode JOB_OPTION() { return getToken(JclParser.JOB_OPTION, 0); }
		public TerminalNode LINE_START() { return getToken(JclParser.LINE_START, 0); }
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public TerminalNode ENDLINE() { return getToken(JclParser.ENDLINE, 0); }
		public TerminalNode SYSIN() { return getToken(JclParser.SYSIN, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LINE_COMMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				match(LINE_COMMENT);
				}
				break;
			case JOB_OPTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				match(JOB_OPTION);
				}
				break;
			case LINE_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				match(LINE_START);
				setState(30);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LABEL_DEF:
				case DD:
				case EXEC:
				case JOB:
				case SET:
				case ANY_COMMAND:
					{
					setState(28);
					command();
					}
					break;
				case ENDLINE:
					{
					setState(29);
					match(ENDLINE);
					}
					break;
				case EOF:
				case LINE_COMMENT:
				case JOB_OPTION:
				case LINE_START:
				case SYSIN:
					break;
				default:
					break;
				}
				}
				break;
			case SYSIN:
				enterOuterAlt(_localctx, 4);
				{
				setState(32);
				match(SYSIN);
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

	public static class CommandContext extends ParserRuleContext {
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode LABEL_DEF() { return getToken(JclParser.LABEL_DEF, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_command);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL_DEF) {
				{
				setState(35);
				match(LABEL_DEF);
				}
			}

			setState(38);
			keyword();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_ROUND_PAR) | (1L << MUL) | (1L << STRING) | (1L << NUMBER) | (1L << LABEL))) != 0)) {
				{
				setState(39);
				arguments();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JclParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JclParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			argument();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(43);
				match(COMMA);
				setState(44);
				argument();
				}
				}
				setState(49);
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

	public static class ArgumentContext extends ParserRuleContext {
		public Named_argumentContext named_argument() {
			return getRuleContext(Named_argumentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_argument);
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				named_argument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				expression(0);
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

	public static class Named_argumentContext extends ParserRuleContext {
		public TerminalNode LABEL() { return getToken(JclParser.LABEL, 0); }
		public TerminalNode EQUALS() { return getToken(JclParser.EQUALS, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode EQUAL_FOR_TAPE() { return getToken(JclParser.EQUAL_FOR_TAPE, 0); }
		public Named_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterNamed_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitNamed_argument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitNamed_argument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Named_argumentContext named_argument() throws RecognitionException {
		Named_argumentContext _localctx = new Named_argumentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_named_argument);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(LABEL);
				setState(55);
				match(EQUALS);
				setState(56);
				argument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(LABEL);
				setState(58);
				match(EQUAL_FOR_TAPE);
				setState(59);
				argument();
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<Simple_exprContext> simple_expr() {
			return getRuleContexts(Simple_exprContext.class);
		}
		public Simple_exprContext simple_expr(int i) {
			return getRuleContext(Simple_exprContext.class,i);
		}
		public TerminalNode LEFT_ROUND_PAR() { return getToken(JclParser.LEFT_ROUND_PAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RIGHT_ROUND_PAR() { return getToken(JclParser.RIGHT_ROUND_PAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(JclParser.PLUS, 0); }
		public TerminalNode MUL() { return getToken(JclParser.MUL, 0); }
		public TerminalNode MINUS() { return getToken(JclParser.MINUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(64); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(63);
						simple_expr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(66); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << STRING) | (1L << NUMBER) | (1L << LABEL))) != 0)) {
					{
					setState(68);
					simple_expr();
					}
				}

				setState(71);
				match(LEFT_ROUND_PAR);
				setState(72);
				arguments();
				setState(73);
				match(RIGHT_ROUND_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(77);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(78);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==PLUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						expression(3);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(80);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(81);
						match(MINUS);
						setState(82);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Simple_exprContext extends ParserRuleContext {
		public TerminalNode LABEL() { return getToken(JclParser.LABEL, 0); }
		public TerminalNode NUMBER() { return getToken(JclParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(JclParser.STRING, 0); }
		public Simple_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterSimple_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitSimple_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitSimple_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_exprContext simple_expr() throws RecognitionException {
		Simple_exprContext _localctx = new Simple_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_simple_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << STRING) | (1L << NUMBER) | (1L << LABEL))) != 0)) ) {
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

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode DD() { return getToken(JclParser.DD, 0); }
		public TerminalNode EXEC() { return getToken(JclParser.EXEC, 0); }
		public TerminalNode JOB() { return getToken(JclParser.JOB, 0); }
		public TerminalNode SET() { return getToken(JclParser.SET, 0); }
		public TerminalNode ANY_COMMAND() { return getToken(JclParser.ANY_COMMAND, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JclParserListener ) ((JclParserListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JclParserVisitor ) return ((JclParserVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DD) | (1L << EXEC) | (1L << JOB) | (1L << SET) | (1L << ANY_COMMAND))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35_\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\6\2\26"+
		"\n\2\r\2\16\2\27\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\5\3$\n\3\3\4"+
		"\5\4\'\n\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13\5\3"+
		"\6\3\6\5\6\67\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7?\n\7\3\b\3\b\6\bC\n\b\r"+
		"\b\16\bD\3\b\5\bH\n\b\3\b\3\b\3\b\3\b\5\bN\n\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\bV\n\b\f\b\16\bY\13\b\3\t\3\t\3\n\3\n\3\n\2\3\16\13\2\4\6\b\n\f\16"+
		"\20\22\2\5\4\2\23\23\25\25\4\2\23\23\27\31\3\2\n\16\2e\2\25\3\2\2\2\4"+
		"#\3\2\2\2\6&\3\2\2\2\b,\3\2\2\2\n\66\3\2\2\2\f>\3\2\2\2\16M\3\2\2\2\20"+
		"Z\3\2\2\2\22\\\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25"+
		"\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\32\7\2\2\3\32\3\3\2\2\2\33$\7"+
		"\3\2\2\34$\7\4\2\2\35 \7\5\2\2\36!\5\6\4\2\37!\7\t\2\2 \36\3\2\2\2 \37"+
		"\3\2\2\2 !\3\2\2\2!$\3\2\2\2\"$\7\6\2\2#\33\3\2\2\2#\34\3\2\2\2#\35\3"+
		"\2\2\2#\"\3\2\2\2$\5\3\2\2\2%\'\7\7\2\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2"+
		"\2(*\5\22\n\2)+\5\b\5\2*)\3\2\2\2*+\3\2\2\2+\7\3\2\2\2,\61\5\n\6\2-.\7"+
		"\24\2\2.\60\5\n\6\2/-\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2"+
		"\62\t\3\2\2\2\63\61\3\2\2\2\64\67\5\f\7\2\65\67\5\16\b\2\66\64\3\2\2\2"+
		"\66\65\3\2\2\2\67\13\3\2\2\289\7\31\2\29:\7\21\2\2:?\5\n\6\2;<\7\31\2"+
		"\2<=\7\22\2\2=?\5\n\6\2>8\3\2\2\2>;\3\2\2\2?\r\3\2\2\2@B\b\b\1\2AC\5\20"+
		"\t\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EN\3\2\2\2FH\5\20\t\2GF\3"+
		"\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\17\2\2JK\5\b\5\2KL\7\20\2\2LN\3\2\2\2M"+
		"@\3\2\2\2MG\3\2\2\2NW\3\2\2\2OP\f\4\2\2PQ\t\2\2\2QV\5\16\b\5RS\f\3\2\2"+
		"ST\7\26\2\2TV\5\16\b\4UO\3\2\2\2UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2"+
		"\2X\17\3\2\2\2YW\3\2\2\2Z[\t\3\2\2[\21\3\2\2\2\\]\t\4\2\2]\23\3\2\2\2"+
		"\17\27 #&*\61\66>DGMUW";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}