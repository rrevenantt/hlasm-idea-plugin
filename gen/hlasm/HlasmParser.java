// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\HlasmParser.g4 by ANTLR 4.7
package hlasm;

import org.antlr.jetbrains.adaptor.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HlasmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROLOG_MACRO=1, ENDLINE=2, COMMENT=3, ENDLINE_COMM=4, OLD_TOKEN=5, STRING_ERROR=6, 
		LABEL_DEF=7, SPACES1=8, EQU=9, CSECT=10, DSECT=11, RSECT=12, DS=13, DC=14, 
		COPY=15, SPACE=16, USING=17, DROP=18, ALIAS=19, AMODE=20, EJECT=21, END=22, 
		ENTRY=23, LOCTR=24, LTORG=25, OPSYN=26, ORG=27, CCW=28, AGO=29, MACRO=30, 
		MEND=31, ANOP=32, LCLA=33, LCLB=34, LCLC=35, GBLC=36, GBLA=37, GBLB=38, 
		AIF=39, SETB=40, SETA=41, SETC=42, COMMAND=43, FIELD_INFO=44, ENDLINE_COMMENT=45, 
		LEFT_ROUND_PAR=46, RIGHT_ROUND_PAR=47, DOT=48, COMMA=49, PLUS=50, MINUS=51, 
		EQUALS=52, MUL=53, DIVIDE=54, LEN_TYPE=55, NUMBER=56, LABEL=57, UNKNOWN_CHAR=58, 
		STRING=59, COMMENT_CONT1=60, ARG_SEPARATOR=61, ERROR=62, ERROR2=63, ERROR4=64, 
		COMMENT_CONT=65, ESCAPE=66;
	public static final int
		RULE_lines2 = 0, RULE_lines = 1, RULE_statement = 2, RULE_macro = 3, RULE_macro_def_wr = 4, 
		RULE_line_wrapper = 5, RULE_line = 6, RULE_complex_condition = 7, RULE_condition = 8, 
		RULE_arguments = 9, RULE_argument = 10, RULE_named_argument = 11, RULE_expression = 12, 
		RULE_simple_expr = 13;
	public static final String[] ruleNames = {
		"lines2", "lines", "statement", "macro", "macro_def_wr", "line_wrapper", 
		"line", "complex_condition", "condition", "arguments", "argument", "named_argument", 
		"expression", "simple_expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'EQU'", "'CSECT'", 
		"'DSECT'", "'RSECT'", "'DS'", "'DC'", "'COPY'", "'SPACE'", "'USING'", 
		"'DROP'", "'ALIAS'", "'AMODE'", "'EJECT'", "'END'", "'ENTRY'", "'LOCTR'", 
		"'LTORG'", "'OPSYN'", "'ORG'", "'CCW'", "'AGO'", "'MACRO'", "'MEND'", 
		"'ANOP'", "'LCLA'", "'LCLB'", "'LCLC'", "'GBLC'", "'GBLA'", "'GBLB'", 
		"'AIF'", "'SETB'", "'SETA'", "'SETC'", null, null, null, "'('", "')'", 
		"'.'", "','", "'+'", "'-'", "'='", "'*'", null, null, null, null, null, 
		"'''", null, "'               '", null, null, null, null, "''''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PROLOG_MACRO", "ENDLINE", "COMMENT", "ENDLINE_COMM", "OLD_TOKEN", 
		"STRING_ERROR", "LABEL_DEF", "SPACES1", "EQU", "CSECT", "DSECT", "RSECT", 
		"DS", "DC", "COPY", "SPACE", "USING", "DROP", "ALIAS", "AMODE", "EJECT", 
		"END", "ENTRY", "LOCTR", "LTORG", "OPSYN", "ORG", "CCW", "AGO", "MACRO", 
		"MEND", "ANOP", "LCLA", "LCLB", "LCLC", "GBLC", "GBLA", "GBLB", "AIF", 
		"SETB", "SETA", "SETC", "COMMAND", "FIELD_INFO", "ENDLINE_COMMENT", "LEFT_ROUND_PAR", 
		"RIGHT_ROUND_PAR", "DOT", "COMMA", "PLUS", "MINUS", "EQUALS", "MUL", "DIVIDE", 
		"LEN_TYPE", "NUMBER", "LABEL", "UNKNOWN_CHAR", "STRING", "COMMENT_CONT1", 
		"ARG_SEPARATOR", "ERROR", "ERROR2", "ERROR4", "COMMENT_CONT", "ESCAPE"
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
	public String getGrammarFileName() { return "HlasmParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	 public boolean isJcl = false;  
	public HlasmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Lines2Context extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HlasmParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> OLD_TOKEN() { return getTokens(HlasmParser.OLD_TOKEN); }
		public TerminalNode OLD_TOKEN(int i) {
			return getToken(HlasmParser.OLD_TOKEN, i);
		}
		public Lines2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lines2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterLines2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitLines2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitLines2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lines2Context lines2() throws RecognitionException {
		Lines2Context _localctx = new Lines2Context(_ctx, getState());
		enterRule(_localctx, 0, RULE_lines2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENDLINE) | (1L << OLD_TOKEN) | (1L << LABEL_DEF) | (1L << EQU) | (1L << CSECT) | (1L << DSECT) | (1L << RSECT) | (1L << DS) | (1L << DC) | (1L << COPY) | (1L << SPACE) | (1L << USING) | (1L << DROP) | (1L << ALIAS) | (1L << AMODE) | (1L << EJECT) | (1L << END) | (1L << ENTRY) | (1L << LOCTR) | (1L << LTORG) | (1L << OPSYN) | (1L << ORG) | (1L << CCW) | (1L << AGO) | (1L << MACRO) | (1L << ANOP) | (1L << LCLA) | (1L << LCLB) | (1L << LCLC) | (1L << GBLC) | (1L << GBLA) | (1L << GBLB) | (1L << AIF) | (1L << SETB) | (1L << SETA) | (1L << SETC) | (1L << COMMAND))) != 0)) {
				{
				setState(30);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ENDLINE:
				case LABEL_DEF:
				case EQU:
				case CSECT:
				case DSECT:
				case RSECT:
				case DS:
				case DC:
				case COPY:
				case SPACE:
				case USING:
				case DROP:
				case ALIAS:
				case AMODE:
				case EJECT:
				case END:
				case ENTRY:
				case LOCTR:
				case LTORG:
				case OPSYN:
				case ORG:
				case CCW:
				case AGO:
				case MACRO:
				case ANOP:
				case LCLA:
				case LCLB:
				case LCLC:
				case GBLC:
				case GBLA:
				case GBLB:
				case AIF:
				case SETB:
				case SETA:
				case SETC:
				case COMMAND:
					{
					setState(28);
					statement();
					}
					break;
				case OLD_TOKEN:
					{
					setState(29);
					match(OLD_TOKEN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
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

	public static class LinesContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> OLD_TOKEN() { return getTokens(HlasmParser.OLD_TOKEN); }
		public TerminalNode OLD_TOKEN(int i) {
			return getToken(HlasmParser.OLD_TOKEN, i);
		}
		public LinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterLines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitLines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitLines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinesContext lines() throws RecognitionException {
		LinesContext _localctx = new LinesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_lines);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(39);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ENDLINE:
					case LABEL_DEF:
					case EQU:
					case CSECT:
					case DSECT:
					case RSECT:
					case DS:
					case DC:
					case COPY:
					case SPACE:
					case USING:
					case DROP:
					case ALIAS:
					case AMODE:
					case EJECT:
					case END:
					case ENTRY:
					case LOCTR:
					case LTORG:
					case OPSYN:
					case ORG:
					case CCW:
					case AGO:
					case MACRO:
					case ANOP:
					case LCLA:
					case LCLB:
					case LCLC:
					case GBLC:
					case GBLA:
					case GBLB:
					case AIF:
					case SETB:
					case SETA:
					case SETC:
					case COMMAND:
						{
						setState(37);
						statement();
						}
						break;
					case OLD_TOKEN:
						{
						setState(38);
						match(OLD_TOKEN);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public Line_wrapperContext line_wrapper() {
			return getRuleContext(Line_wrapperContext.class,0);
		}
		public MacroContext macro() {
			return getRuleContext(MacroContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENDLINE:
			case LABEL_DEF:
			case EQU:
			case CSECT:
			case DSECT:
			case RSECT:
			case DS:
			case DC:
			case COPY:
			case SPACE:
			case USING:
			case DROP:
			case ALIAS:
			case AMODE:
			case EJECT:
			case END:
			case ENTRY:
			case LOCTR:
			case LTORG:
			case OPSYN:
			case ORG:
			case CCW:
			case AGO:
			case ANOP:
			case LCLA:
			case LCLB:
			case LCLC:
			case GBLC:
			case GBLA:
			case GBLB:
			case AIF:
			case SETB:
			case SETA:
			case SETC:
			case COMMAND:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				line_wrapper();
				}
				break;
			case MACRO:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				macro();
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

	public static class MacroContext extends ParserRuleContext {
		public TerminalNode MACRO() { return getToken(HlasmParser.MACRO, 0); }
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public Macro_def_wrContext macro_def_wr() {
			return getRuleContext(Macro_def_wrContext.class,0);
		}
		public LinesContext lines() {
			return getRuleContext(LinesContext.class,0);
		}
		public TerminalNode MEND() { return getToken(HlasmParser.MEND, 0); }
		public List<TerminalNode> ENDLINE() { return getTokens(HlasmParser.ENDLINE); }
		public TerminalNode ENDLINE(int i) {
			return getToken(HlasmParser.ENDLINE, i);
		}
		public TerminalNode LABEL_DEF() { return getToken(HlasmParser.LABEL_DEF, 0); }
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitMacro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitMacro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_macro);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(MACRO);
			setState(49);
			arguments();
			setState(51); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(50);
					match(ENDLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(53); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(55);
			macro_def_wr();
			setState(56);
			lines();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL_DEF) {
				{
				setState(57);
				match(LABEL_DEF);
				}
			}

			setState(60);
			match(MEND);
			setState(61);
			arguments();
			setState(62);
			match(ENDLINE);
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

	public static class Macro_def_wrContext extends ParserRuleContext {
		public Line_wrapperContext line_wrapper() {
			return getRuleContext(Line_wrapperContext.class,0);
		}
		public Macro_def_wrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_def_wr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterMacro_def_wr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitMacro_def_wr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitMacro_def_wr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macro_def_wrContext macro_def_wr() throws RecognitionException {
		Macro_def_wrContext _localctx = new Macro_def_wrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_macro_def_wr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			line_wrapper();
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

	public static class Line_wrapperContext extends ParserRuleContext {
		public TerminalNode ENDLINE() { return getToken(HlasmParser.ENDLINE, 0); }
		public TerminalNode LABEL_DEF() { return getToken(HlasmParser.LABEL_DEF, 0); }
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public Line_wrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line_wrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterLine_wrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitLine_wrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitLine_wrapper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Line_wrapperContext line_wrapper() throws RecognitionException {
		Line_wrapperContext _localctx = new Line_wrapperContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line_wrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL_DEF) {
				{
				setState(66);
				match(LABEL_DEF);
				}
			}

			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQU) | (1L << CSECT) | (1L << DSECT) | (1L << RSECT) | (1L << DS) | (1L << DC) | (1L << COPY) | (1L << SPACE) | (1L << USING) | (1L << DROP) | (1L << ALIAS) | (1L << AMODE) | (1L << EJECT) | (1L << END) | (1L << ENTRY) | (1L << LOCTR) | (1L << LTORG) | (1L << OPSYN) | (1L << ORG) | (1L << CCW) | (1L << AGO) | (1L << ANOP) | (1L << LCLA) | (1L << LCLB) | (1L << LCLC) | (1L << GBLC) | (1L << GBLA) | (1L << GBLB) | (1L << AIF) | (1L << SETB) | (1L << SETA) | (1L << SETC) | (1L << COMMAND))) != 0)) {
				{
				setState(69);
				line();
				}
			}

			setState(72);
			match(ENDLINE);
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
		public TerminalNode AMODE() { return getToken(HlasmParser.AMODE, 0); }
		public TerminalNode NUMBER() { return getToken(HlasmParser.NUMBER, 0); }
		public List<TerminalNode> LABEL() { return getTokens(HlasmParser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(HlasmParser.LABEL, i);
		}
		public TerminalNode COPY() { return getToken(HlasmParser.COPY, 0); }
		public TerminalNode EJECT() { return getToken(HlasmParser.EJECT, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode END() { return getToken(HlasmParser.END, 0); }
		public List<TerminalNode> COMMA() { return getTokens(HlasmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HlasmParser.COMMA, i);
		}
		public TerminalNode ENTRY() { return getToken(HlasmParser.ENTRY, 0); }
		public TerminalNode LOCTR() { return getToken(HlasmParser.LOCTR, 0); }
		public TerminalNode LTORG() { return getToken(HlasmParser.LTORG, 0); }
		public TerminalNode OPSYN() { return getToken(HlasmParser.OPSYN, 0); }
		public TerminalNode CCW() { return getToken(HlasmParser.CCW, 0); }
		public TerminalNode ORG() { return getToken(HlasmParser.ORG, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<Complex_conditionContext> complex_condition() {
			return getRuleContexts(Complex_conditionContext.class);
		}
		public Complex_conditionContext complex_condition(int i) {
			return getRuleContext(Complex_conditionContext.class,i);
		}
		public TerminalNode SETB() { return getToken(HlasmParser.SETB, 0); }
		public TerminalNode SETA() { return getToken(HlasmParser.SETA, 0); }
		public TerminalNode SETC() { return getToken(HlasmParser.SETC, 0); }
		public TerminalNode AIF() { return getToken(HlasmParser.AIF, 0); }
		public TerminalNode USING() { return getToken(HlasmParser.USING, 0); }
		public TerminalNode DC() { return getToken(HlasmParser.DC, 0); }
		public TerminalNode DS() { return getToken(HlasmParser.DS, 0); }
		public TerminalNode ALIAS() { return getToken(HlasmParser.ALIAS, 0); }
		public TerminalNode EQU() { return getToken(HlasmParser.EQU, 0); }
		public TerminalNode DSECT() { return getToken(HlasmParser.DSECT, 0); }
		public TerminalNode RSECT() { return getToken(HlasmParser.RSECT, 0); }
		public TerminalNode CSECT() { return getToken(HlasmParser.CSECT, 0); }
		public TerminalNode DROP() { return getToken(HlasmParser.DROP, 0); }
		public TerminalNode SPACE() { return getToken(HlasmParser.SPACE, 0); }
		public TerminalNode COMMAND() { return getToken(HlasmParser.COMMAND, 0); }
		public TerminalNode ANOP() { return getToken(HlasmParser.ANOP, 0); }
		public TerminalNode LCLA() { return getToken(HlasmParser.LCLA, 0); }
		public TerminalNode LCLB() { return getToken(HlasmParser.LCLB, 0); }
		public TerminalNode LCLC() { return getToken(HlasmParser.LCLC, 0); }
		public TerminalNode GBLC() { return getToken(HlasmParser.GBLC, 0); }
		public TerminalNode GBLB() { return getToken(HlasmParser.GBLB, 0); }
		public TerminalNode GBLA() { return getToken(HlasmParser.GBLA, 0); }
		public TerminalNode AGO() { return getToken(HlasmParser.AGO, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_line);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(AMODE);
				setState(75);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==LABEL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(COPY);
				setState(77);
				match(LABEL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(EJECT);
				setState(79);
				arguments();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(END);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==LABEL) {
					{
					setState(81);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==LABEL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				match(ENTRY);
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85);
					match(LABEL);
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LABEL );
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(90);
				_la = _input.LA(1);
				if ( !(_la==LOCTR || _la==LTORG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(91);
				arguments();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(92);
				match(OPSYN);
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LABEL) {
					{
					setState(93);
					match(LABEL);
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(96);
				match(CCW);
				setState(97);
				arguments();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(98);
				match(ORG);
				setState(103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(99);
					expression(0);
					}
					break;
				case 2:
					{
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(100);
						match(COMMA);
						}
					}

					}
					break;
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(105);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SETB) | (1L << SETA) | (1L << SETC))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(106);
				complex_condition();
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LABEL) {
					{
					setState(107);
					match(LABEL);
					}
				}

				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(110);
				match(AIF);
				}
				setState(111);
				complex_condition();
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LABEL) {
					{
					setState(112);
					match(LABEL);
					}
				}

				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(115);
					match(COMMA);
					setState(116);
					complex_condition();
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LABEL) {
						{
						setState(117);
						match(LABEL);
						}
					}

					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(125);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SETB) | (1L << SETA) | (1L << SETC))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				{
				setState(126);
				expression(0);
				}
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(127);
				match(USING);
				setState(128);
				expression(0);
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(129);
					match(COMMA);
					setState(130);
					expression(0);
					}
					}
					setState(133); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(135);
				_la = _input.LA(1);
				if ( !(_la==DS || _la==DC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(136);
				arguments();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(137);
				match(ALIAS);
				setState(138);
				match(LABEL);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(139);
				match(EQU);
				setState(140);
				arguments();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(141);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CSECT) | (1L << DSECT) | (1L << RSECT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(146);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(142);
					expression(0);
					}
					break;
				case 2:
					{
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(143);
						match(COMMA);
						}
					}

					}
					break;
				}
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(148);
				match(DROP);
				setState(149);
				arguments();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(150);
				match(SPACE);
				setState(151);
				arguments();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(152);
				match(COMMAND);
				setState(153);
				arguments();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(154);
				match(ANOP);
				setState(155);
				arguments();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(156);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LCLA) | (1L << LCLB) | (1L << LCLC) | (1L << GBLC) | (1L << GBLA) | (1L << GBLB))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(157);
				arguments();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(158);
				match(AGO);
				setState(159);
				match(LABEL);
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

	public static class Complex_conditionContext extends ParserRuleContext {
		public TerminalNode LEFT_ROUND_PAR() { return getToken(HlasmParser.LEFT_ROUND_PAR, 0); }
		public Complex_conditionContext complex_condition() {
			return getRuleContext(Complex_conditionContext.class,0);
		}
		public TerminalNode RIGHT_ROUND_PAR() { return getToken(HlasmParser.RIGHT_ROUND_PAR, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode LABEL() { return getToken(HlasmParser.LABEL, 0); }
		public Complex_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterComplex_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitComplex_condition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitComplex_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Complex_conditionContext complex_condition() throws RecognitionException {
		Complex_conditionContext _localctx = new Complex_conditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_complex_condition);
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(LEFT_ROUND_PAR);
				setState(163);
				complex_condition();
				setState(164);
				match(RIGHT_ROUND_PAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				condition();
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(167);
					match(LABEL);
					setState(168);
					complex_condition();
					}
					break;
				}
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LABEL() { return getToken(HlasmParser.LABEL, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(174);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(173);
					expression(0);
					}
					break;
				}
				setState(176);
				match(LABEL);
				}
				break;
			}
			setState(179);
			expression(0);
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
		public List<TerminalNode> COMMA() { return getTokens(HlasmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HlasmParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arguments);
		int _la;
		try {
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				argument();
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(182);
					match(COMMA);
					setState(183);
					argument();
					}
					}
					setState(186); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
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
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_argument);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				named_argument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
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
		public TerminalNode LABEL() { return getToken(HlasmParser.LABEL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Named_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterNamed_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitNamed_argument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitNamed_argument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Named_argumentContext named_argument() throws RecognitionException {
		Named_argumentContext _localctx = new Named_argumentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_named_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(LABEL);
			setState(196);
			match(EQUALS);
			setState(197);
			expression(0);
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
		public TerminalNode LEFT_ROUND_PAR() { return getToken(HlasmParser.LEFT_ROUND_PAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RIGHT_ROUND_PAR() { return getToken(HlasmParser.RIGHT_ROUND_PAR, 0); }
		public TerminalNode LABEL() { return getToken(HlasmParser.LABEL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(HlasmParser.PLUS, 0); }
		public TerminalNode MUL() { return getToken(HlasmParser.MUL, 0); }
		public TerminalNode DIVIDE() { return getToken(HlasmParser.DIVIDE, 0); }
		public TerminalNode MINUS() { return getToken(HlasmParser.MINUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(200);
						simple_expr();
						}
						} 
					}
					setState(205);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(207);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(206);
					simple_expr();
					}
					break;
				}
				setState(209);
				match(LEFT_ROUND_PAR);
				setState(210);
				arguments();
				setState(211);
				match(RIGHT_ROUND_PAR);
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(212);
					match(LABEL);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(218);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MUL) | (1L << DIVIDE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(219);
						expression(3);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(221);
						match(MINUS);
						setState(222);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		public TerminalNode LABEL() { return getToken(HlasmParser.LABEL, 0); }
		public TerminalNode FIELD_INFO() { return getToken(HlasmParser.FIELD_INFO, 0); }
		public TerminalNode NUMBER() { return getToken(HlasmParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(HlasmParser.STRING, 0); }
		public TerminalNode LEN_TYPE() { return getToken(HlasmParser.LEN_TYPE, 0); }
		public TerminalNode LEFT_ROUND_PAR() { return getToken(HlasmParser.LEFT_ROUND_PAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RIGHT_ROUND_PAR() { return getToken(HlasmParser.RIGHT_ROUND_PAR, 0); }
		public TerminalNode DOT() { return getToken(HlasmParser.DOT, 0); }
		public Simple_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).enterSimple_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HlasmParserListener ) ((HlasmParserListener)listener).exitSimple_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HlasmParserVisitor ) return ((HlasmParserVisitor<? extends T>)visitor).visitSimple_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_exprContext simple_expr() throws RecognitionException {
		Simple_exprContext _localctx = new Simple_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_simple_expr);
		int _la;
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(LABEL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(FIELD_INFO);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUALS) {
					{
					setState(230);
					match(EQUALS);
					}
				}

				setState(233);
				match(LABEL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				match(NUMBER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				match(MUL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUALS) {
					{
					setState(236);
					match(EQUALS);
					}
				}

				setState(239);
				_la = _input.LA(1);
				if ( !(_la==LEN_TYPE || _la==LABEL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				match(STRING);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUALS) {
					{
					setState(241);
					match(EQUALS);
					}
				}

				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LABEL) {
					{
					setState(244);
					match(LABEL);
					}
				}

				setState(247);
				match(LEFT_ROUND_PAR);
				setState(248);
				arguments();
				setState(249);
				match(RIGHT_ROUND_PAR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(251);
				match(STRING);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(252);
				match(LEN_TYPE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(253);
				match(EQUALS);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(254);
				match(DOT);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3D\u0104\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\7\2!\n\2\f\2\16\2$\13"+
		"\2\3\2\3\2\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\5\4\61\n\4\3\5\3\5"+
		"\3\5\6\5\66\n\5\r\5\16\5\67\3\5\3\5\3\5\5\5=\n\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\7\5\7F\n\7\3\7\5\7I\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\bU\n\b\3\b\3\b\6\bY\n\b\r\b\16\bZ\3\b\3\b\3\b\3\b\5\ba\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\bh\n\b\5\bj\n\b\3\b\3\b\3\b\5\bo\n\b\3\b\3\b\3\b\5\bt\n\b"+
		"\3\b\3\b\3\b\5\by\n\b\7\b{\n\b\f\b\16\b~\13\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\6\b\u0086\n\b\r\b\16\b\u0087\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"\u0093\n\b\5\b\u0095\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00a3\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ac\n\t\5\t\u00ae\n"+
		"\t\3\n\5\n\u00b1\n\n\3\n\5\n\u00b4\n\n\3\n\3\n\3\13\3\13\3\13\6\13\u00bb"+
		"\n\13\r\13\16\13\u00bc\3\13\5\13\u00c0\n\13\3\f\3\f\5\f\u00c4\n\f\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\7\16\u00cc\n\16\f\16\16\16\u00cf\13\16\3\16\5\16"+
		"\u00d2\n\16\3\16\3\16\3\16\3\16\5\16\u00d8\n\16\5\16\u00da\n\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u00e2\n\16\f\16\16\16\u00e5\13\16\3\17\3"+
		"\17\3\17\5\17\u00ea\n\17\3\17\3\17\3\17\3\17\5\17\u00f0\n\17\3\17\3\17"+
		"\3\17\5\17\u00f5\n\17\3\17\5\17\u00f8\n\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u0102\n\17\3\17\2\3\32\20\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\2\13\3\2:;\4\2\63\63;;\3\2\32\33\3\2*,\3\2\17\20\3\2\f\16\3"+
		"\2#(\4\2\64\64\678\4\299;;\2\u013a\2\"\3\2\2\2\4+\3\2\2\2\6\60\3\2\2\2"+
		"\b\62\3\2\2\2\nB\3\2\2\2\fE\3\2\2\2\16\u00a2\3\2\2\2\20\u00ad\3\2\2\2"+
		"\22\u00b3\3\2\2\2\24\u00bf\3\2\2\2\26\u00c3\3\2\2\2\30\u00c5\3\2\2\2\32"+
		"\u00d9\3\2\2\2\34\u0101\3\2\2\2\36!\5\6\4\2\37!\7\7\2\2 \36\3\2\2\2 \37"+
		"\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7\2\2"+
		"\3&\3\3\2\2\2\'*\5\6\4\2(*\7\7\2\2)\'\3\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3"+
		"\2\2\2+,\3\2\2\2,\5\3\2\2\2-+\3\2\2\2.\61\5\f\7\2/\61\5\b\5\2\60.\3\2"+
		"\2\2\60/\3\2\2\2\61\7\3\2\2\2\62\63\7 \2\2\63\65\5\24\13\2\64\66\7\4\2"+
		"\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\289\3\2\2\29:\5"+
		"\n\6\2:<\5\4\3\2;=\7\t\2\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7!\2\2?@\5"+
		"\24\13\2@A\7\4\2\2A\t\3\2\2\2BC\5\f\7\2C\13\3\2\2\2DF\7\t\2\2ED\3\2\2"+
		"\2EF\3\2\2\2FH\3\2\2\2GI\5\16\b\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7\4"+
		"\2\2K\r\3\2\2\2LM\7\26\2\2M\u00a3\t\2\2\2NO\7\21\2\2O\u00a3\7;\2\2PQ\7"+
		"\27\2\2Q\u00a3\5\24\13\2RT\7\30\2\2SU\t\3\2\2TS\3\2\2\2TU\3\2\2\2U\u00a3"+
		"\3\2\2\2VX\7\31\2\2WY\7;\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2["+
		"\u00a3\3\2\2\2\\]\t\4\2\2]\u00a3\5\24\13\2^`\7\34\2\2_a\7;\2\2`_\3\2\2"+
		"\2`a\3\2\2\2a\u00a3\3\2\2\2bc\7\36\2\2c\u00a3\5\24\13\2di\7\35\2\2ej\5"+
		"\32\16\2fh\7\63\2\2gf\3\2\2\2gh\3\2\2\2hj\3\2\2\2ie\3\2\2\2ig\3\2\2\2"+
		"j\u00a3\3\2\2\2kl\t\5\2\2ln\5\20\t\2mo\7;\2\2nm\3\2\2\2no\3\2\2\2o\u00a3"+
		"\3\2\2\2pq\7)\2\2qs\5\20\t\2rt\7;\2\2sr\3\2\2\2st\3\2\2\2t|\3\2\2\2uv"+
		"\7\63\2\2vx\5\20\t\2wy\7;\2\2xw\3\2\2\2xy\3\2\2\2y{\3\2\2\2zu\3\2\2\2"+
		"{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u00a3\3\2\2\2~|\3\2\2\2\177\u0080\t\5"+
		"\2\2\u0080\u00a3\5\32\16\2\u0081\u0082\7\23\2\2\u0082\u0085\5\32\16\2"+
		"\u0083\u0084\7\63\2\2\u0084\u0086\5\32\16\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u00a3\3\2"+
		"\2\2\u0089\u008a\t\6\2\2\u008a\u00a3\5\24\13\2\u008b\u008c\7\25\2\2\u008c"+
		"\u00a3\7;\2\2\u008d\u008e\7\13\2\2\u008e\u00a3\5\24\13\2\u008f\u0094\t"+
		"\7\2\2\u0090\u0095\5\32\16\2\u0091\u0093\7\63\2\2\u0092\u0091\3\2\2\2"+
		"\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0090\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0095\u00a3\3\2\2\2\u0096\u0097\7\24\2\2\u0097\u00a3\5\24\13"+
		"\2\u0098\u0099\7\22\2\2\u0099\u00a3\5\24\13\2\u009a\u009b\7-\2\2\u009b"+
		"\u00a3\5\24\13\2\u009c\u009d\7\"\2\2\u009d\u00a3\5\24\13\2\u009e\u009f"+
		"\t\b\2\2\u009f\u00a3\5\24\13\2\u00a0\u00a1\7\37\2\2\u00a1\u00a3\7;\2\2"+
		"\u00a2L\3\2\2\2\u00a2N\3\2\2\2\u00a2P\3\2\2\2\u00a2R\3\2\2\2\u00a2V\3"+
		"\2\2\2\u00a2\\\3\2\2\2\u00a2^\3\2\2\2\u00a2b\3\2\2\2\u00a2d\3\2\2\2\u00a2"+
		"k\3\2\2\2\u00a2p\3\2\2\2\u00a2\177\3\2\2\2\u00a2\u0081\3\2\2\2\u00a2\u0089"+
		"\3\2\2\2\u00a2\u008b\3\2\2\2\u00a2\u008d\3\2\2\2\u00a2\u008f\3\2\2\2\u00a2"+
		"\u0096\3\2\2\2\u00a2\u0098\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2\u009c\3\2"+
		"\2\2\u00a2\u009e\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\17\3\2\2\2\u00a4\u00a5"+
		"\7\60\2\2\u00a5\u00a6\5\20\t\2\u00a6\u00a7\7\61\2\2\u00a7\u00ae\3\2\2"+
		"\2\u00a8\u00ab\5\22\n\2\u00a9\u00aa\7;\2\2\u00aa\u00ac\5\20\t\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a4\3\2"+
		"\2\2\u00ad\u00a8\3\2\2\2\u00ae\21\3\2\2\2\u00af\u00b1\5\32\16\2\u00b0"+
		"\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\7;"+
		"\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b6\5\32\16\2\u00b6\23\3\2\2\2\u00b7\u00ba\5\26\f\2\u00b8\u00b9\7\63"+
		"\2\2\u00b9\u00bb\5\26\f\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00c0\5\26"+
		"\f\2\u00bf\u00b7\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\25\3\2\2\2\u00c1\u00c4"+
		"\5\30\r\2\u00c2\u00c4\5\32\16\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2"+
		"\2\u00c4\27\3\2\2\2\u00c5\u00c6\7;\2\2\u00c6\u00c7\7\66\2\2\u00c7\u00c8"+
		"\5\32\16\2\u00c8\31\3\2\2\2\u00c9\u00cd\b\16\1\2\u00ca\u00cc\5\34\17\2"+
		"\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00da\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d2\5\34\17\2"+
		"\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4"+
		"\7\60\2\2\u00d4\u00d5\5\24\13\2\u00d5\u00d7\7\61\2\2\u00d6\u00d8\7;\2"+
		"\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00c9"+
		"\3\2\2\2\u00d9\u00d1\3\2\2\2\u00da\u00e3\3\2\2\2\u00db\u00dc\f\4\2\2\u00dc"+
		"\u00dd\t\t\2\2\u00dd\u00e2\5\32\16\5\u00de\u00df\f\3\2\2\u00df\u00e0\7"+
		"\65\2\2\u00e0\u00e2\5\32\16\4\u00e1\u00db\3\2\2\2\u00e1\u00de\3\2\2\2"+
		"\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\33"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u0102\7;\2\2\u00e7\u00e9\7.\2\2\u00e8"+
		"\u00ea\7\66\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3"+
		"\2\2\2\u00eb\u0102\7;\2\2\u00ec\u0102\7:\2\2\u00ed\u0102\7\67\2\2\u00ee"+
		"\u00f0\7\66\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3"+
		"\2\2\2\u00f1\u00f2\t\n\2\2\u00f2\u0102\7=\2\2\u00f3\u00f5\7\66\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f8\7;"+
		"\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fa\7\60\2\2\u00fa\u00fb\5\24\13\2\u00fb\u00fc\7\61\2\2\u00fc\u0102"+
		"\3\2\2\2\u00fd\u0102\7=\2\2\u00fe\u0102\79\2\2\u00ff\u0102\7\66\2\2\u0100"+
		"\u0102\7\62\2\2\u0101\u00e6\3\2\2\2\u0101\u00e7\3\2\2\2\u0101\u00ec\3"+
		"\2\2\2\u0101\u00ed\3\2\2\2\u0101\u00ef\3\2\2\2\u0101\u00f4\3\2\2\2\u0101"+
		"\u00fd\3\2\2\2\u0101\u00fe\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2"+
		"\2\2\u0102\35\3\2\2\2* \")+\60\67<EHTZ`ginsx|\u0087\u0092\u0094\u00a2"+
		"\u00ab\u00ad\u00b0\u00b3\u00bc\u00bf\u00c3\u00cd\u00d1\u00d7\u00d9\u00e1"+
		"\u00e3\u00e9\u00ef\u00f4\u00f7\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}