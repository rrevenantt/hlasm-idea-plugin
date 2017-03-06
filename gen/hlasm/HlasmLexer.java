// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\HlasmLexer.g4 by ANTLR 4.5.3
package hlasm;

import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HlasmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROLOG_MACRO=1, ENDLINE=2, COMMENT=3, ENDLINE_COMM=4, COMMENT_sasdf=5, 
		LABEL_DEF=6, SPACES1=7, EQU=8, CSECT=9, DSECT=10, RSECT=11, DS=12, DC=13, 
		COPY=14, SPACE=15, USING=16, DROP=17, ALIAS=18, AMODE=19, EJECT=20, END=21, 
		ENTRY=22, LOCTR=23, LTORG=24, OPSYN=25, ORG=26, CCW=27, MACRO=28, MEND=29, 
		AIF=30, SETB=31, SETA=32, COMMAND=33, D0=34, FIELD_INFO=35, ENDLINE_COMMENT=36, 
		LEFT_ROUND_PAR=37, RIGHT_ROUND_PAR=38, DOT=39, COMMA=40, PLUS=41, MINUS=42, 
		EQUALS=43, MUL=44, DIVIDE=45, LEN_TYPE=46, NUMBER=47, LABEL=48, SPACES=49, 
		UNKNOWN_CHAR=50, STRING=51, COMMENT_CONT1=52, ARG_SEPARATOR=53, ERROR=54, 
		ERROR2=55, ERROR4=56, COMMENT_CONT=57, STRING_QUOTE=58, ESCAPE=59;
	public static final int CMD = 1;
	public static final int EVERYTHING = 2;
	public static final int IN_STRING = 3;
	public static final int LINE_CONTINUATION = 4;
	public static final int LABEL_CONTINUATION = 5;
	public static final int COMMENT_MODE = 6;
	public static String[] modeNames = {
		"DEFAULT_MODE", "CMD", "EVERYTHING", "IN_STRING", "LINE_CONTINUATION", 
		"LABEL_CONTINUATION", "COMMENT_MODE"
	};

	public static final String[] ruleNames = {
		"COMMENT_sasdf", "LONG_COMMENT", "LABEL_DEF", "SPACES1", "ENDLINE", "UNKNOWN_CHAR1", 
		"EQU", "CSECT", "DSECT", "RSECT", "DS", "DC", "COPY", "SPACE", "USING", 
		"DROP", "ALIAS", "AMODE", "EJECT", "END", "ENTRY", "LOCTR", "LTORG", "OPSYN", 
		"ORG", "CCW", "MACRO", "MEND", "AIF", "SETB", "SETA", "COMMAND", "ENDLINE2", 
		"SPACES2", "UNKNOWN_CHAR2", "D0", "FIELD_INFO", "STRING_QUOTE", "ENDLINE1", 
		"ENDLINE_EMPTY", "ONYL_CONT", "ENDLINE_COMMENT", "LEFT_ROUND_PAR", "RIGHT_ROUND_PAR", 
		"DOT", "COMMA", "PLUS", "MINUS", "EQUALS", "MUL", "DIVIDE", "LEN_TYPE", 
		"NUMBER", "DIGIT", "LABEL", "ID_START_ONLY", "ID_START", "ID_CONTINUE", 
		"SPACES", "UNKNOWN_CHAR", "ESCAPE", "STRING", "BAD_STRING", "SPACES_COMM1", 
		"COMMENT_CONT1", "ARG_SEPARATOR", "ERROR", "ERROR2", "LABEL_SEP", "ERROR3", 
		"ERROR4", "COMMENT_ENDLINE3", "COMMENT_CONT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'ASDFASDFASDFASDFSTRING THAT NEVER EXISTSASDFASDFASDFASDFASDFASDFASDF'", 
		null, null, "'EQU'", "'CSECT'", "'DSECT'", "'RSECT'", "'DS'", "'DC'", 
		"'COPY'", "'SPACE'", "'USING'", "'DROP'", "'ALIAS'", "'AMODE'", "'EJECT'", 
		"'END'", "'ENTRY'", "'LOCTR'", "'LTORG'", "'OPSYN'", "'ORG'", "'CCW'", 
		"'MACRO'", "'MEND'", "'AIF'", "'SETB'", "'SETA'", null, "'D'0''", null, 
		null, "'('", "')'", "'.'", "','", "'+'", "'-'", "'='", "'*'", null, null, 
		null, null, null, null, null, null, "'               '", null, null, null, 
		null, null, "''''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PROLOG_MACRO", "ENDLINE", "COMMENT", "ENDLINE_COMM", "COMMENT_sasdf", 
		"LABEL_DEF", "SPACES1", "EQU", "CSECT", "DSECT", "RSECT", "DS", "DC", 
		"COPY", "SPACE", "USING", "DROP", "ALIAS", "AMODE", "EJECT", "END", "ENTRY", 
		"LOCTR", "LTORG", "OPSYN", "ORG", "CCW", "MACRO", "MEND", "AIF", "SETB", 
		"SETA", "COMMAND", "D0", "FIELD_INFO", "ENDLINE_COMMENT", "LEFT_ROUND_PAR", 
		"RIGHT_ROUND_PAR", "DOT", "COMMA", "PLUS", "MINUS", "EQUALS", "MUL", "DIVIDE", 
		"LEN_TYPE", "NUMBER", "LABEL", "SPACES", "UNKNOWN_CHAR", "STRING", "COMMENT_CONT1", 
		"ARG_SEPARATOR", "ERROR", "ERROR2", "ERROR4", "COMMENT_CONT", "STRING_QUOTE", 
		"ESCAPE"
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


	    public boolean isJcl = false;
	    public HashSet<String> prologs = new HashSet(10);
	    int spaces  = 0;
	    int parenth = 0;
	    int inAIF   = 0;


	public HlasmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HlasmLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 4:
			ENDLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 28:
			AIF_action((RuleContext)_localctx, actionIndex);
			break;
		case 29:
			SETB_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
			SETA_action((RuleContext)_localctx, actionIndex);
			break;
		case 31:
			COMMAND_action((RuleContext)_localctx, actionIndex);
			break;
		case 32:
			ENDLINE2_action((RuleContext)_localctx, actionIndex);
			break;
		case 38:
			ENDLINE1_action((RuleContext)_localctx, actionIndex);
			break;
		case 41:
			ENDLINE_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 42:
			LEFT_ROUND_PAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
			RIGHT_ROUND_PAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 54:
			LABEL_action((RuleContext)_localctx, actionIndex);
			break;
		case 64:
			COMMENT_CONT1_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
			ERROR2_action((RuleContext)_localctx, actionIndex);
			break;
		case 70:
			ERROR4_action((RuleContext)_localctx, actionIndex);
			break;
		case 72:
			COMMENT_CONT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ENDLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			spaces = 0; parenth = 0; inAIF=0;
			break;
		}
	}
	private void AIF_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			inAIF = 1;
			break;
		}
	}
	private void SETB_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			inAIF = 1;
			break;
		}
	}
	private void SETA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			inAIF = 1;
			break;
		}
	}
	private void COMMAND_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:

			        if (prologs.contains(getText()))
			            setType(PROLOG_MACRO);
			    
			break;
		}
	}
	private void ENDLINE2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			spaces = 0; parenth = 0; inAIF=0;
			break;
		}
	}
	private void ENDLINE1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			spaces = 0; parenth = 0; inAIF=0;
			break;
		}
	}
	private void ENDLINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:

			//	    int lineEnd = getText().indexOf("\n");
			//        if (_tokenStartCharPositionInLine + getText().length() > 72)
			//	        System.out.println(_tokenStartCharPositionInLine+" "+getText().length() + " |" + getText()+"|||" + getText().charAt(72-_tokenStartCharPositionInLine-1));

				    if(_tokenStartCharPositionInLine < 72 && _tokenStartCharPositionInLine + getText().length() >= 72
				            && getText().charAt(72-_tokenStartCharPositionInLine-1) != ' '){
				            more();
				            pushMode(LINE_CONTINUATION);
				            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
				    }
				    else{
				        setType(ENDLINE_COMM);
			//	        mode(DEFAULT_MODE);
			//	        spaces = 0; parenth = 0; inAIF=0;
				    }

				
			break;
		}
	}
	private void LEFT_ROUND_PAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			parenth++;
			break;
		}
	}
	private void RIGHT_ROUND_PAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			parenth--;
			break;
		}
	}
	private void LABEL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:

			//	    if(getCharPositionInLine()==71 && _input.LA(1) != ' '){
			//	        ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			//	    }
				    if(getCharPositionInLine()==72 && _input.LA(1) == '\n'){
				        ((LexerATNSimulator)this.getInterpreter()).consume(_input);
				        more();
				        pushMode(LABEL_CONTINUATION);
				    }
				    else if (getCharPositionInLine()>=72){
				        setType(ERROR);
				    }
				
			break;
		}
	}
	private void COMMENT_CONT1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:

			// 	    if(getCharPositionInLine()==71 && _input.LA(1) != ' '){
			// 	        ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			// 	    }
			 	    if(getCharPositionInLine()==72 && _input.LA(1) == '\n'){
			 	        ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			 	        more();
			 	        //pushMode(LABEL_CONTINUATION);
			 	    }
			 	    else if (getCharPositionInLine()>=72){
			 	        setType(ERROR);
			 	    }

			        if (_input.LA(1) == '\n'){
			            setType(ERROR);
			        }
			        else {
			            more();
			        }

			//        if (getCharPositionInLine() < 15){
			//            more();
			//        }
			//        else{
			//            setType(ERROR);
			//            popMode();
			//        }

			 	
			break;
		}
	}
	private void ERROR2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:

			        if (getCharPositionInLine() < 15){
			            more();
			        }
			        else{
			            setType(ERROR);
			            popMode();
			        }
			    
			break;
		}
	}
	private void ERROR4_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:

			        if (getCharPositionInLine() < 15){
			            more();
			        }
			        else{
			            setType(ERROR);
			            popMode();
			        }
			    
			break;
		}
	}
	private void COMMENT_CONT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14:

			 	    if(getCharPositionInLine()==71)
			 	    {
			 	        if(_input.LA(1) == ' '){
			 	            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			 	            if(getCharPositionInLine()==72 && _input.LA(1) == '\n'){
			// 	                ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			 	                setType(COMMENT);
			 	                break;
			 	                //pushMode(LABEL_CONTINUATION);
			 	            }
			 	            if (_input.LA(1) == ' '){
			 	                more();
			 	                break;
			 	            }
			 	            setType(ERROR);
			// 	            popMode();
			 	            break;
			            }
			 	        else if(_input.LA(1) == '\n'){
			 	            setType(COMMENT);
			 	            break;
			 	        }
			 	        else{
			 	            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			                if(getCharPositionInLine()==72 && _input.LA(1) == '\n'){
			 	                ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			 	                more();
			// 	                break;
			 	                //pushMode(LABEL_CONTINUATION);
			 	            }
			 	            else{
			 	                setType(ERROR);
			 	            }

			 	        }
			            break;
			        }
			// 	    if (getCharPositionInLine()>=72 && getText().charAt(getText().length()-1) != ' '){
			// 	        setType(ERROR);
			// 	        more();
			// 	    }

			 	    if (_input.LA(1) == '\n'){
			 	        setType(COMMENT);
			        }
			        else {
			            more();
			        }
			//        if (getCharPositionInLine() < 15){
			//            more();
			//        }
			//        else{
			//            setType(ERROR);
			//            popMode();
			//        }

			 	
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 40:
			return ONYL_CONT_sempred((RuleContext)_localctx, predIndex);
		case 41:
			return ENDLINE_COMMENT_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean ONYL_CONT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return _tokenStartCharPositionInLine >=71;
		}
		return true;
	}
	private boolean ENDLINE_COMMENT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return inAIF==0 || parenth == 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u0281\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\5\3\u00e2\n\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\7\4\u00ec\n\4\f\4\16\4\u00ef\13\4\3\5\6\5\u00f2\n\5\r\5\16\5"+
		"\u00f3\3\5\3\5\3\5\3\6\5\6\u00fa\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \3 \3 \3 \3!\3!\7!\u018d\n!\f!\16!\u0190\13!\3!\3!\3\"\5\"\u0195\n\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\6#\u019f\n#\r#\16#\u01a0\3#\3#\3#\3#\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\5(\u01b9\n("+
		"\3(\3(\3(\3(\3(\3(\3(\3)\5)\u01c3\n)\3)\5)\u01c6\n)\3)\3)\3*\3*\5*\u01cc"+
		"\n*\3*\3*\3*\3*\3*\3*\3*\3+\3+\7+\u01d7\n+\f+\16+\u01da\13+\3+\3+\3+\3"+
		",\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\64\3\64\3\65\3\65\3\65\3\66\6\66\u01f7\n\66\r\66\16\66\u01f8\3\67\3\67"+
		"\38\38\78\u01ff\n8\f8\168\u0202\138\38\58\u0205\n8\38\58\u0208\n8\38\3"+
		"8\39\39\59\u020e\n9\3:\5:\u0211\n:\3;\3;\3;\5;\u0216\n;\3<\6<\u0219\n"+
		"<\r<\16<\u021a\3=\3=\3>\3>\3>\3>\3>\3?\3?\3?\3?\3@\5@\u0229\n@\3@\3@\3"+
		"@\3@\3@\3A\3A\3A\3A\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3"+
		"C\3C\3C\3C\3C\3D\5D\u024a\nD\3D\3D\3D\3D\3E\3E\3E\3F\3F\3F\3F\3F\3F\3"+
		"F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\7F\u0264\nF\fF\16F\u0267\13F\3F\3F\3F"+
		"\3G\5G\u026d\nG\3G\3G\3G\3G\3G\3H\3H\3H\3I\5I\u0278\nI\3I\3I\3I\3I\3I"+
		"\3J\3J\3J\2\2K\t\7\13\2\r\b\17\t\21\4\23\2\25\n\27\13\31\f\33\r\35\16"+
		"\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35"+
		"=\36?\37A C!E\"G#I\2K\2M\2O$Q%S<U\2W\2Y\2[&]\'_(a)c*e+g,i-k.m/o\60q\61"+
		"s\2u\62w\2y\2{\2}\63\177\64\u0081=\u0083\65\u0085\2\u0087\2\u0089\66\u008b"+
		"\67\u008d8\u008f9\u0091\2\u0093\2\u0095:\u0097\2\u0099;\t\2\3\4\5\6\7"+
		"\b\f\5\2((*+\60\60\4\2\13\13\"\"\7\2FFKKMNPQUV\5\2\f\f\17\17\"\"\4\2\f"+
		"\f\17\17\3\2\61\61\3\2\62;\4\2>>}}\4\2((\60\60\7\2%&((B\\aac|\u028f\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\3\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2"+
		"\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2\2\2\3)\3\2\2\2"+
		"\3+\3\2\2\2\3-\3\2\2\2\3/\3\2\2\2\3\61\3\2\2\2\3\63\3\2\2\2\3\65\3\2\2"+
		"\2\3\67\3\2\2\2\39\3\2\2\2\3;\3\2\2\2\3=\3\2\2\2\3?\3\2\2\2\3A\3\2\2\2"+
		"\3C\3\2\2\2\3E\3\2\2\2\3G\3\2\2\2\3I\3\2\2\2\3K\3\2\2\2\3M\3\2\2\2\4O"+
		"\3\2\2\2\4Q\3\2\2\2\4S\3\2\2\2\4U\3\2\2\2\4Y\3\2\2\2\4[\3\2\2\2\4]\3\2"+
		"\2\2\4_\3\2\2\2\4a\3\2\2\2\4c\3\2\2\2\4e\3\2\2\2\4g\3\2\2\2\4i\3\2\2\2"+
		"\4k\3\2\2\2\4m\3\2\2\2\4o\3\2\2\2\4q\3\2\2\2\4u\3\2\2\2\4}\3\2\2\2\4\177"+
		"\3\2\2\2\5\u0081\3\2\2\2\5\u0083\3\2\2\2\5\u0085\3\2\2\2\5\u0087\3\2\2"+
		"\2\5\u0089\3\2\2\2\6\u008b\3\2\2\2\6\u008d\3\2\2\2\6\u008f\3\2\2\2\7\u0091"+
		"\3\2\2\2\7\u0093\3\2\2\2\7\u0095\3\2\2\2\b\u0097\3\2\2\2\b\u0099\3\2\2"+
		"\2\t\u009b\3\2\2\2\13\u00e1\3\2\2\2\r\u00e8\3\2\2\2\17\u00f1\3\2\2\2\21"+
		"\u00f9\3\2\2\2\23\u00ff\3\2\2\2\25\u0103\3\2\2\2\27\u0107\3\2\2\2\31\u010d"+
		"\3\2\2\2\33\u0113\3\2\2\2\35\u0119\3\2\2\2\37\u011c\3\2\2\2!\u011f\3\2"+
		"\2\2#\u0124\3\2\2\2%\u012a\3\2\2\2\'\u0130\3\2\2\2)\u0135\3\2\2\2+\u013b"+
		"\3\2\2\2-\u0141\3\2\2\2/\u0147\3\2\2\2\61\u014b\3\2\2\2\63\u0151\3\2\2"+
		"\2\65\u0157\3\2\2\2\67\u015d\3\2\2\29\u0163\3\2\2\2;\u0167\3\2\2\2=\u016b"+
		"\3\2\2\2?\u0171\3\2\2\2A\u0176\3\2\2\2C\u017c\3\2\2\2E\u0183\3\2\2\2G"+
		"\u018a\3\2\2\2I\u0194\3\2\2\2K\u019e\3\2\2\2M\u01a6\3\2\2\2O\u01aa\3\2"+
		"\2\2Q\u01af\3\2\2\2S\u01b2\3\2\2\2U\u01b8\3\2\2\2W\u01c2\3\2\2\2Y\u01c9"+
		"\3\2\2\2[\u01d4\3\2\2\2]\u01de\3\2\2\2_\u01e1\3\2\2\2a\u01e4\3\2\2\2c"+
		"\u01e6\3\2\2\2e\u01e8\3\2\2\2g\u01ea\3\2\2\2i\u01ec\3\2\2\2k\u01ee\3\2"+
		"\2\2m\u01f0\3\2\2\2o\u01f2\3\2\2\2q\u01f6\3\2\2\2s\u01fa\3\2\2\2u\u0207"+
		"\3\2\2\2w\u020d\3\2\2\2y\u0210\3\2\2\2{\u0215\3\2\2\2}\u0218\3\2\2\2\177"+
		"\u021c\3\2\2\2\u0081\u021e\3\2\2\2\u0083\u0223\3\2\2\2\u0085\u0228\3\2"+
		"\2\2\u0087\u022f\3\2\2\2\u0089\u0233\3\2\2\2\u008b\u0236\3\2\2\2\u008d"+
		"\u0249\3\2\2\2\u008f\u024f\3\2\2\2\u0091\u0252\3\2\2\2\u0093\u026c\3\2"+
		"\2\2\u0095\u0273\3\2\2\2\u0097\u0277\3\2\2\2\u0099\u027e\3\2\2\2\u009b"+
		"\u009c\7C\2\2\u009c\u009d\7U\2\2\u009d\u009e\7F\2\2\u009e\u009f\7H\2\2"+
		"\u009f\u00a0\7C\2\2\u00a0\u00a1\7U\2\2\u00a1\u00a2\7F\2\2\u00a2\u00a3"+
		"\7H\2\2\u00a3\u00a4\7C\2\2\u00a4\u00a5\7U\2\2\u00a5\u00a6\7F\2\2\u00a6"+
		"\u00a7\7H\2\2\u00a7\u00a8\7C\2\2\u00a8\u00a9\7U\2\2\u00a9\u00aa\7F\2\2"+
		"\u00aa\u00ab\7H\2\2\u00ab\u00ac\7U\2\2\u00ac\u00ad\7V\2\2\u00ad\u00ae"+
		"\7T\2\2\u00ae\u00af\7K\2\2\u00af\u00b0\7P\2\2\u00b0\u00b1\7I\2\2\u00b1"+
		"\u00b2\7\"\2\2\u00b2\u00b3\7V\2\2\u00b3\u00b4\7J\2\2\u00b4\u00b5\7C\2"+
		"\2\u00b5\u00b6\7V\2\2\u00b6\u00b7\7\"\2\2\u00b7\u00b8\7P\2\2\u00b8\u00b9"+
		"\7G\2\2\u00b9\u00ba\7X\2\2\u00ba\u00bb\7G\2\2\u00bb\u00bc\7T\2\2\u00bc"+
		"\u00bd\7\"\2\2\u00bd\u00be\7G\2\2\u00be\u00bf\7Z\2\2\u00bf\u00c0\7K\2"+
		"\2\u00c0\u00c1\7U\2\2\u00c1\u00c2\7V\2\2\u00c2\u00c3\7U\2\2\u00c3\u00c4"+
		"\7C\2\2\u00c4\u00c5\7U\2\2\u00c5\u00c6\7F\2\2\u00c6\u00c7\7H\2\2\u00c7"+
		"\u00c8\7C\2\2\u00c8\u00c9\7U\2\2\u00c9\u00ca\7F\2\2\u00ca\u00cb\7H\2\2"+
		"\u00cb\u00cc\7C\2\2\u00cc\u00cd\7U\2\2\u00cd\u00ce\7F\2\2\u00ce\u00cf"+
		"\7H\2\2\u00cf\u00d0\7C\2\2\u00d0\u00d1\7U\2\2\u00d1\u00d2\7F\2\2\u00d2"+
		"\u00d3\7H\2\2\u00d3\u00d4\7C\2\2\u00d4\u00d5\7U\2\2\u00d5\u00d6\7F\2\2"+
		"\u00d6\u00d7\7H\2\2\u00d7\u00d8\7C\2\2\u00d8\u00d9\7U\2\2\u00d9\u00da"+
		"\7F\2\2\u00da\u00db\7H\2\2\u00db\u00dc\7C\2\2\u00dc\u00dd\7U\2\2\u00dd"+
		"\u00de\7F\2\2\u00de\u00df\7H\2\2\u00df\n\3\2\2\2\u00e0\u00e2\7\60\2\2"+
		"\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4"+
		"\7,\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\b\3\2\2\u00e6\u00e7\b\3\3\2\u00e7"+
		"\f\3\2\2\2\u00e8\u00ed\5w9\2\u00e9\u00ec\5{;\2\u00ea\u00ec\t\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\16\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2"+
		"\t\3\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\b\5\4\2\u00f6\u00f7\b\5"+
		"\5\2\u00f7\20\3\2\2\2\u00f8\u00fa\7\17\2\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7\f\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\b\6\6\2\u00fe\22\3\2\2\2\u00ff\u0100\13\2\2\2\u0100\u0101\3\2\2"+
		"\2\u0101\u0102\b\7\7\2\u0102\24\3\2\2\2\u0103\u0104\7G\2\2\u0104\u0105"+
		"\7S\2\2\u0105\u0106\7W\2\2\u0106\26\3\2\2\2\u0107\u0108\7E\2\2\u0108\u0109"+
		"\7U\2\2\u0109\u010a\7G\2\2\u010a\u010b\7E\2\2\u010b\u010c\7V\2\2\u010c"+
		"\30\3\2\2\2\u010d\u010e\7F\2\2\u010e\u010f\7U\2\2\u010f\u0110\7G\2\2\u0110"+
		"\u0111\7E\2\2\u0111\u0112\7V\2\2\u0112\32\3\2\2\2\u0113\u0114\7T\2\2\u0114"+
		"\u0115\7U\2\2\u0115\u0116\7G\2\2\u0116\u0117\7E\2\2\u0117\u0118\7V\2\2"+
		"\u0118\34\3\2\2\2\u0119\u011a\7F\2\2\u011a\u011b\7U\2\2\u011b\36\3\2\2"+
		"\2\u011c\u011d\7F\2\2\u011d\u011e\7E\2\2\u011e \3\2\2\2\u011f\u0120\7"+
		"E\2\2\u0120\u0121\7Q\2\2\u0121\u0122\7R\2\2\u0122\u0123\7[\2\2\u0123\""+
		"\3\2\2\2\u0124\u0125\7U\2\2\u0125\u0126\7R\2\2\u0126\u0127\7C\2\2\u0127"+
		"\u0128\7E\2\2\u0128\u0129\7G\2\2\u0129$\3\2\2\2\u012a\u012b\7W\2\2\u012b"+
		"\u012c\7U\2\2\u012c\u012d\7K\2\2\u012d\u012e\7P\2\2\u012e\u012f\7I\2\2"+
		"\u012f&\3\2\2\2\u0130\u0131\7F\2\2\u0131\u0132\7T\2\2\u0132\u0133\7Q\2"+
		"\2\u0133\u0134\7R\2\2\u0134(\3\2\2\2\u0135\u0136\7C\2\2\u0136\u0137\7"+
		"N\2\2\u0137\u0138\7K\2\2\u0138\u0139\7C\2\2\u0139\u013a\7U\2\2\u013a*"+
		"\3\2\2\2\u013b\u013c\7C\2\2\u013c\u013d\7O\2\2\u013d\u013e\7Q\2\2\u013e"+
		"\u013f\7F\2\2\u013f\u0140\7G\2\2\u0140,\3\2\2\2\u0141\u0142\7G\2\2\u0142"+
		"\u0143\7L\2\2\u0143\u0144\7G\2\2\u0144\u0145\7E\2\2\u0145\u0146\7V\2\2"+
		"\u0146.\3\2\2\2\u0147\u0148\7G\2\2\u0148\u0149\7P\2\2\u0149\u014a\7F\2"+
		"\2\u014a\60\3\2\2\2\u014b\u014c\7G\2\2\u014c\u014d\7P\2\2\u014d\u014e"+
		"\7V\2\2\u014e\u014f\7T\2\2\u014f\u0150\7[\2\2\u0150\62\3\2\2\2\u0151\u0152"+
		"\7N\2\2\u0152\u0153\7Q\2\2\u0153\u0154\7E\2\2\u0154\u0155\7V\2\2\u0155"+
		"\u0156\7T\2\2\u0156\64\3\2\2\2\u0157\u0158\7N\2\2\u0158\u0159\7V\2\2\u0159"+
		"\u015a\7Q\2\2\u015a\u015b\7T\2\2\u015b\u015c\7I\2\2\u015c\66\3\2\2\2\u015d"+
		"\u015e\7Q\2\2\u015e\u015f\7R\2\2\u015f\u0160\7U\2\2\u0160\u0161\7[\2\2"+
		"\u0161\u0162\7P\2\2\u01628\3\2\2\2\u0163\u0164\7Q\2\2\u0164\u0165\7T\2"+
		"\2\u0165\u0166\7I\2\2\u0166:\3\2\2\2\u0167\u0168\7E\2\2\u0168\u0169\7"+
		"E\2\2\u0169\u016a\7Y\2\2\u016a<\3\2\2\2\u016b\u016c\7O\2\2\u016c\u016d"+
		"\7C\2\2\u016d\u016e\7E\2\2\u016e\u016f\7T\2\2\u016f\u0170\7Q\2\2\u0170"+
		">\3\2\2\2\u0171\u0172\7O\2\2\u0172\u0173\7G\2\2\u0173\u0174\7P\2\2\u0174"+
		"\u0175\7F\2\2\u0175@\3\2\2\2\u0176\u0177\7C\2\2\u0177\u0178\7K\2\2\u0178"+
		"\u0179\7H\2\2\u0179\u017a\3\2\2\2\u017a\u017b\b\36\b\2\u017bB\3\2\2\2"+
		"\u017c\u017d\7U\2\2\u017d\u017e\7G\2\2\u017e\u017f\7V\2\2\u017f\u0180"+
		"\7D\2\2\u0180\u0181\3\2\2\2\u0181\u0182\b\37\t\2\u0182D\3\2\2\2\u0183"+
		"\u0184\7U\2\2\u0184\u0185\7G\2\2\u0185\u0186\7V\2\2\u0186\u0187\7C\2\2"+
		"\u0187\u0188\3\2\2\2\u0188\u0189\b \n\2\u0189F\3\2\2\2\u018a\u018e\5y"+
		":\2\u018b\u018d\5{;\2\u018c\u018b\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c"+
		"\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191"+
		"\u0192\b!\13\2\u0192H\3\2\2\2\u0193\u0195\7\17\2\2\u0194\u0193\3\2\2\2"+
		"\u0194\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\7\f\2\2\u0197\u0198"+
		"\3\2\2\2\u0198\u0199\b\"\f\2\u0199\u019a\3\2\2\2\u019a\u019b\b\"\r\2\u019b"+
		"\u019c\b\"\16\2\u019cJ\3\2\2\2\u019d\u019f\t\3\2\2\u019e\u019d\3\2\2\2"+
		"\u019f\u01a0\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2"+
		"\3\2\2\2\u01a2\u01a3\b#\17\2\u01a3\u01a4\b#\5\2\u01a4\u01a5\b#\20\2\u01a5"+
		"L\3\2\2\2\u01a6\u01a7\13\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\b$\7\2"+
		"\u01a9N\3\2\2\2\u01aa\u01ab\7F\2\2\u01ab\u01ac\7)\2\2\u01ac\u01ad\7\62"+
		"\2\2\u01ad\u01ae\7)\2\2\u01aeP\3\2\2\2\u01af\u01b0\t\4\2\2\u01b0\u01b1"+
		"\7)\2\2\u01b1R\3\2\2\2\u01b2\u01b3\7)\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5"+
		"\b\'\2\2\u01b5\u01b6\b\'\21\2\u01b6T\3\2\2\2\u01b7\u01b9\7\17\2\2\u01b8"+
		"\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\7\f"+
		"\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\b(\22\2\u01bd\u01be\3\2\2\2\u01be"+
		"\u01bf\b(\16\2\u01bf\u01c0\b(\r\2\u01c0V\3\2\2\2\u01c1\u01c3\5}<\2\u01c2"+
		"\u01c1\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c6\7\17"+
		"\2\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"\u01c8\7\f\2\2\u01c8X\3\2\2\2\u01c9\u01cb\n\5\2\2\u01ca\u01cc\7\17\2\2"+
		"\u01cb\u01ca\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce"+
		"\7\f\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\6*\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"\u01d2\b*\23\2\u01d2\u01d3\b*\2\2\u01d3Z\3\2\2\2\u01d4\u01d8\5}<\2\u01d5"+
		"\u01d7\n\6\2\2\u01d6\u01d5\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2"+
		"\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01d8\3\2\2\2\u01db"+
		"\u01dc\b+\24\2\u01dc\u01dd\6+\3\2\u01dd\\\3\2\2\2\u01de\u01df\7*\2\2\u01df"+
		"\u01e0\b,\25\2\u01e0^\3\2\2\2\u01e1\u01e2\7+\2\2\u01e2\u01e3\b-\26\2\u01e3"+
		"`\3\2\2\2\u01e4\u01e5\7\60\2\2\u01e5b\3\2\2\2\u01e6\u01e7\7.\2\2\u01e7"+
		"d\3\2\2\2\u01e8\u01e9\7-\2\2\u01e9f\3\2\2\2\u01ea\u01eb\7/\2\2\u01ebh"+
		"\3\2\2\2\u01ec\u01ed\7?\2\2\u01edj\3\2\2\2\u01ee\u01ef\7,\2\2\u01efl\3"+
		"\2\2\2\u01f0\u01f1\t\7\2\2\u01f1n\3\2\2\2\u01f2\u01f3\5q\66\2\u01f3\u01f4"+
		"\5u8\2\u01f4p\3\2\2\2\u01f5\u01f7\5s\67\2\u01f6\u01f5\3\2\2\2\u01f7\u01f8"+
		"\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9r\3\2\2\2\u01fa"+
		"\u01fb\t\b\2\2\u01fbt\3\2\2\2\u01fc\u0200\5w9\2\u01fd\u01ff\5{;\2\u01fe"+
		"\u01fd\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2"+
		"\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0203\u0205\7\60\2\2\u0204"+
		"\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0208\t\t"+
		"\2\2\u0207\u01fc\3\2\2\2\u0207\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209"+
		"\u020a\b8\27\2\u020av\3\2\2\2\u020b\u020e\5y:\2\u020c\u020e\t\n\2\2\u020d"+
		"\u020b\3\2\2\2\u020d\u020c\3\2\2\2\u020ex\3\2\2\2\u020f\u0211\t\13\2\2"+
		"\u0210\u020f\3\2\2\2\u0211z\3\2\2\2\u0212\u0216\5y:\2\u0213\u0216\5s\67"+
		"\2\u0214\u0216\7\'\2\2\u0215\u0212\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0214"+
		"\3\2\2\2\u0216|\3\2\2\2\u0217\u0219\t\3\2\2\u0218\u0217\3\2\2\2\u0219"+
		"\u021a\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b~\3\2\2\2"+
		"\u021c\u021d\13\2\2\2\u021d\u0080\3\2\2\2\u021e\u021f\7)\2\2\u021f\u0220"+
		"\7)\2\2\u0220\u0221\3\2\2\2\u0221\u0222\b>\2\2\u0222\u0082\3\2\2\2\u0223"+
		"\u0224\7)\2\2\u0224\u0225\3\2\2\2\u0225\u0226\b?\30\2\u0226\u0084\3\2"+
		"\2\2\u0227\u0229\7\17\2\2\u0228\u0227\3\2\2\2\u0228\u0229\3\2\2\2\u0229"+
		"\u022a\3\2\2\2\u022a\u022b\7\f\2\2\u022b\u022c\3\2\2\2\u022c\u022d\b@"+
		"\7\2\u022d\u022e\b@\16\2\u022e\u0086\3\2\2\2\u022f\u0230\5}<\2\u0230\u0231"+
		"\3\2\2\2\u0231\u0232\bA\2\2\u0232\u0088\3\2\2\2\u0233\u0234\n\5\2\2\u0234"+
		"\u0235\bB\31\2\u0235\u008a\3\2\2\2\u0236\u0237\7\"\2\2\u0237\u0238\7\""+
		"\2\2\u0238\u0239\7\"\2\2\u0239\u023a\7\"\2\2\u023a\u023b\7\"\2\2\u023b"+
		"\u023c\7\"\2\2\u023c\u023d\7\"\2\2\u023d\u023e\7\"\2\2\u023e\u023f\7\""+
		"\2\2\u023f\u0240\7\"\2\2\u0240\u0241\7\"\2\2\u0241\u0242\7\"\2\2\u0242"+
		"\u0243\7\"\2\2\u0243\u0244\7\"\2\2\u0244\u0245\7\"\2\2\u0245\u0246\3\2"+
		"\2\2\u0246\u0247\bC\30\2\u0247\u008c\3\2\2\2\u0248\u024a\7\17\2\2\u0249"+
		"\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u024c\7\f"+
		"\2\2\u024c\u024d\3\2\2\2\u024d\u024e\bD\30\2\u024e\u008e\3\2\2\2\u024f"+
		"\u0250\13\2\2\2\u0250\u0251\bE\32\2\u0251\u0090\3\2\2\2\u0252\u0253\7"+
		"\"\2\2\u0253\u0254\7\"\2\2\u0254\u0255\7\"\2\2\u0255\u0256\7\"\2\2\u0256"+
		"\u0257\7\"\2\2\u0257\u0258\7\"\2\2\u0258\u0259\7\"\2\2\u0259\u025a\7\""+
		"\2\2\u025a\u025b\7\"\2\2\u025b\u025c\7\"\2\2\u025c\u025d\7\"\2\2\u025d"+
		"\u025e\7\"\2\2\u025e\u025f\7\"\2\2\u025f\u0260\7\"\2\2\u0260\u0261\7\""+
		"\2\2\u0261\u0265\3\2\2\2\u0262\u0264\5{;\2\u0263\u0262\3\2\2\2\u0264\u0267"+
		"\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0268\3\2\2\2\u0267"+
		"\u0265\3\2\2\2\u0268\u0269\bF\30\2\u0269\u026a\bF\33\2\u026a\u0092\3\2"+
		"\2\2\u026b\u026d\7\17\2\2\u026c\u026b\3\2\2\2\u026c\u026d\3\2\2\2\u026d"+
		"\u026e\3\2\2\2\u026e\u026f\7\f\2\2\u026f\u0270\3\2\2\2\u0270\u0271\bG"+
		"\30\2\u0271\u0272\bG\34\2\u0272\u0094\3\2\2\2\u0273\u0274\13\2\2\2\u0274"+
		"\u0275\bH\35\2\u0275\u0096\3\2\2\2\u0276\u0278\7\17\2\2\u0277\u0276\3"+
		"\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\7\f\2\2\u027a"+
		"\u027b\3\2\2\2\u027b\u027c\bI\30\2\u027c\u027d\bI\r\2\u027d\u0098\3\2"+
		"\2\2\u027e\u027f\n\6\2\2\u027f\u0280\bJ\36\2\u0280\u009a\3\2\2\2#\2\3"+
		"\4\5\6\7\b\u00e1\u00eb\u00ed\u00f3\u00f9\u018e\u0194\u01a0\u01b8\u01c2"+
		"\u01c5\u01cb\u01d8\u01f8\u0200\u0204\u0207\u020d\u0210\u0215\u021a\u0228"+
		"\u0249\u0265\u026c\u0277\37\5\2\2\7\b\2\4\3\2\2\3\2\3\6\2\t\64\2\3\36"+
		"\3\3\37\4\3 \5\3!\6\3\"\7\t\4\2\4\2\2\4\4\2\t\t\2\7\5\2\3(\b\7\6\2\3+"+
		"\t\3,\n\3-\13\38\f\6\2\2\3B\r\3E\16\t\62\2\t8\2\3H\17\3J\20";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}