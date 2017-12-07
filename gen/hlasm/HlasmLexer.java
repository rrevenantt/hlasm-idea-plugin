// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\HlasmLexer.g4 by ANTLR 4.7
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
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROLOG_MACRO=1, ENDLINE=2, COMMENT=3, ENDLINE_COMM=4, OLD_TOKEN=5, STRING_ERROR=6, 
		LABEL_DEF=7, SPACES1=8, PUSH=9, POP=10, PRINT=11, EQU=12, CSECT=13, DSECT=14, 
		RSECT=15, DS=16, DC=17, COPY=18, SPACE=19, USING=20, DROP=21, ALIAS=22, 
		AMODE=23, EJECT=24, END=25, ENTRY=26, LOCTR=27, LTORG=28, OPSYN=29, ORG=30, 
		CCW=31, AGO=32, MACRO=33, MEND=34, ANOP=35, LCLA=36, LCLB=37, LCLC=38, 
		GBLC=39, GBLA=40, GBLB=41, AIF=42, SETB=43, SETA=44, SETC=45, COMMAND=46, 
		FIELD_INFO=47, STRING_QUOTE=48, ENDLINE_COMMENT=49, LEFT_ROUND_PAR=50, 
		RIGHT_ROUND_PAR=51, DOT=52, COMMA=53, PLUS=54, MINUS=55, EQUALS=56, MUL=57, 
		DIVIDE=58, LEN_TYPE=59, NUMBER=60, LABEL=61, UNKNOWN_CHAR=62, STRING=63, 
		COMMENT_CONT1=64, ARG_SEPARATOR=65, ERROR=66, ERROR2=67, ERROR4=68, COMMENT_CONT=69, 
		ESCAPE=70;
	public static final int
		CMD=1, EVERYTHING=2, IN_STRING=3, LINE_CONTINUATION=4, LABEL_CONTINUATION=5, 
		COMMENT_MODE=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "CMD", "EVERYTHING", "IN_STRING", "LINE_CONTINUATION", 
		"LABEL_CONTINUATION", "COMMENT_MODE"
	};

	public static final String[] ruleNames = {
		"LONG_COMMENT", "LABEL_DEF", "SPACES1", "ENDLINE", "UNKNOWN_CHAR1", "PUSH", 
		"POP", "PRINT", "EQU", "CSECT", "DSECT", "RSECT", "DS", "DC", "COPY", 
		"SPACE", "USING", "DROP", "ALIAS", "AMODE", "EJECT", "END", "ENTRY", "LOCTR", 
		"LTORG", "OPSYN", "ORG", "CCW", "AGO", "MACRO", "MEND", "ANOP", "LCLA", 
		"LCLB", "LCLC", "GBLC", "GBLA", "GBLB", "AIF", "SETB", "SETA", "SETC", 
		"COMMAND", "ENDLINE2", "SPACES2", "UNKNOWN_CHAR2", "STRING_DS", "FIELD_INFO", 
		"STRING_QUOTE", "ENDLINE1", "ENDLINE_EMPTY", "ONYL_CONT", "ENDLINE_COMMENT", 
		"LEFT_ROUND_PAR", "RIGHT_ROUND_PAR", "DOT", "COMMA", "PLUS", "MINUS", 
		"EQUALS", "MUL", "DIVIDE", "LEN_TYPE", "NUMBER", "DIGIT", "LABEL", "ID_START_ONLY", 
		"ID_START", "ID_CONTINUE", "SPACES", "UNKNOWN_CHAR", "ESCAPE", "STRING", 
		"BAD_STRING", "SPACES_COMM1", "COMMENT_CONT1", "ARG_SEPARATOR", "ERROR", 
		"ERROR2", "LABEL_SEP", "ERROR3", "ERROR4", "COMMENT_ENDLINE3", "COMMENT_CONT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'PUSH'", "'POP'", 
		"'PRINT'", "'EQU'", "'CSECT'", "'DSECT'", "'RSECT'", "'DS'", "'DC'", "'COPY'", 
		"'SPACE'", "'USING'", "'DROP'", "'ALIAS'", "'AMODE'", "'EJECT'", "'END'", 
		"'ENTRY'", "'LOCTR'", "'LTORG'", "'OPSYN'", "'ORG'", "'CCW'", "'AGO'", 
		"'MACRO'", "'MEND'", "'ANOP'", "'LCLA'", "'LCLB'", "'LCLC'", "'GBLC'", 
		"'GBLA'", "'GBLB'", "'AIF'", "'SETB'", "'SETA'", "'SETC'", null, null, 
		null, null, "'('", "')'", "'.'", "','", "'+'", "'-'", "'='", "'*'", null, 
		null, null, null, null, "'''", null, "'               '", null, null, 
		null, null, "''''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PROLOG_MACRO", "ENDLINE", "COMMENT", "ENDLINE_COMM", "OLD_TOKEN", 
		"STRING_ERROR", "LABEL_DEF", "SPACES1", "PUSH", "POP", "PRINT", "EQU", 
		"CSECT", "DSECT", "RSECT", "DS", "DC", "COPY", "SPACE", "USING", "DROP", 
		"ALIAS", "AMODE", "EJECT", "END", "ENTRY", "LOCTR", "LTORG", "OPSYN", 
		"ORG", "CCW", "AGO", "MACRO", "MEND", "ANOP", "LCLA", "LCLB", "LCLC", 
		"GBLC", "GBLA", "GBLB", "AIF", "SETB", "SETA", "SETC", "COMMAND", "FIELD_INFO", 
		"STRING_QUOTE", "ENDLINE_COMMENT", "LEFT_ROUND_PAR", "RIGHT_ROUND_PAR", 
		"DOT", "COMMA", "PLUS", "MINUS", "EQUALS", "MUL", "DIVIDE", "LEN_TYPE", 
		"NUMBER", "LABEL", "UNKNOWN_CHAR", "STRING", "COMMENT_CONT1", "ARG_SEPARATOR", 
		"ERROR", "ERROR2", "ERROR4", "COMMENT_CONT", "ESCAPE"
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
	    StringBuilder lineEnd = new StringBuilder();


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
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 3:
			ENDLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 38:
			AIF_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			SETB_action((RuleContext)_localctx, actionIndex);
			break;
		case 40:
			SETA_action((RuleContext)_localctx, actionIndex);
			break;
		case 41:
			SETC_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
			ENDLINE2_action((RuleContext)_localctx, actionIndex);
			break;
		case 48:
			STRING_QUOTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 49:
			ENDLINE1_action((RuleContext)_localctx, actionIndex);
			break;
		case 52:
			ENDLINE_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 53:
			LEFT_ROUND_PAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 54:
			RIGHT_ROUND_PAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 65:
			LABEL_action((RuleContext)_localctx, actionIndex);
			break;
		case 75:
			COMMENT_CONT1_action((RuleContext)_localctx, actionIndex);
			break;
		case 77:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 78:
			ERROR2_action((RuleContext)_localctx, actionIndex);
			break;
		case 81:
			ERROR4_action((RuleContext)_localctx, actionIndex);
			break;
		case 83:
			COMMENT_CONT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ENDLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			spaces = 0; parenth = 0; inAIF=0;_modeStack.clear();
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
	private void SETC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			inAIF = 1;
			break;
		}
	}
	private void ENDLINE2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			spaces = 0; parenth = 0; inAIF=0;_modeStack.clear();
			break;
		}
	}
	private void STRING_QUOTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:

			//        if (_input.LA(1) == '\n'){
			//                setType(STRING_ERROR);
			//            }
			//            else {
			                more();
			                pushMode(IN_STRING);
			//            }
			    
			break;
		}
	}
	private void ENDLINE1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			spaces = 0; parenth = 0; inAIF=0;_modeStack.clear();
			break;
		}
	}
	private void ENDLINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:

			//	    int lineEnd = getText().indexOf("\n");
			//        if (_tokenStartCharPositionInLine + getText().length() > 72)
			//	        System.out.println(_tokenStartCharPositionInLine+" "+getText().length() + " |" + getText()+"|||" + getText().charAt(72-_tokenStartCharPositionInLine-1));

				    if(_tokenStartCharPositionInLine < 72 && _tokenStartCharPositionInLine + getText().length() >= 72
				            && getText().charAt(72-_tokenStartCharPositionInLine-1) != ' '){
			//	            more();
			                setType(ENDLINE_COMM);
			                setChannel(HIDDEN);
				            pushMode(LINE_CONTINUATION);
				            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
				    }
				    else{
				        setType(ENDLINE_COMM);
				        setChannel(HIDDEN);
			//	        mode(DEFAULT_MODE);
			//	        spaces = 0; parenth = 0; inAIF=0;
				    }

				
			break;
		}
	}
	private void LEFT_ROUND_PAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			parenth++;
			break;
		}
	}
	private void RIGHT_ROUND_PAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			parenth--;
			break;
		}
	}
	private void LABEL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:

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
		case 12:

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

			//        if (_input.LA(1) == '\n'){
			//            setType(ERROR);
			//        }
			//        else {
			            more();
			//        }

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
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:

			    _modeStack.clear();
			    mode(DEFAULT_MODE);
			    if (getCharPositionInLine() < 15)
			        setType(ENDLINE);
			    
			break;
		}
	}
	private void ERROR2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14:

			        if (getCharPositionInLine() < 15 && _input.LA(1) != -1){
			            if ( _input.LA(1) != '\n')
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
		case 15:

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
		case 16:


			//        if(_input.LA(1) == '\n'){
			//            System.out.println(getCharPositionInLine());
			//        }
			 	    if(getCharPositionInLine()==71)
			 	    {
			 	        setType(COMMENT);
			 	        setChannel(HIDDEN);
			 	        boolean shouldCancelMore = true;
			 	        if(_input.LA(1) != ' ' && _input.LA(1) != '\n' && _input.LA(1) != -1){
			 	            shouldCancelMore = false;
			 	        }
			// 	        else{
			//				//popMode();
							if (_input.LA(1) == '\n')
							    break;
			//			}

			 	        while (_input.LA(1) != '\n' && _input.LA(1) != -1){
			 	            //if (_input.LA(1) != ' ') shouldCancelMore = true;
			 	            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			 	        }
			 	        if (!shouldCancelMore) {
			 	            more();
			 	            if (_input.LA(1) != -1)
			 	                ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			 	        }
			 	        break;
			        }
			// 	    if (getCharPositionInLine()>=72 ){
			// 	        setType(ERROR);
			// 	        while (_input.LA(1) != '\n'){
			// 	            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
			// 	        }
			// 	        more();
			// 	        break;
			// 	    }

			 	    if (_input.LA(1) == '\n'){
			 	        setType(COMMENT);
			            break;
			        }
			        else {
			            if (_input.LA(1) == '\n')
			        	    break;
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
		case 51:
			return ONYL_CONT_sempred((RuleContext)_localctx, predIndex);
		case 52:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2H\u02a3\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4"+
		"Q\tQ\4R\tR\4S\tS\4T\tT\4U\tU\3\2\5\2\u00b3\n\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\7\3\u00bd\n\3\f\3\16\3\u00c0\13\3\3\4\6\4\u00c3\n\4\r\4\16\4"+
		"\u00c4\3\4\3\4\3\4\3\5\5\5\u00cb\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		"!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\7,\u019b"+
		"\n,\f,\16,\u019e\13,\3-\5-\u01a1\n-\3-\3-\3-\3-\3-\3-\3-\3.\6.\u01ab\n"+
		".\r.\16.\u01ac\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\7\60\u01ba\n\60"+
		"\f\60\16\60\u01bd\13\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\5\62\u01c7"+
		"\n\62\3\62\3\62\5\62\u01cb\n\62\3\62\3\62\6\62\u01cf\n\62\r\62\16\62\u01d0"+
		"\5\62\u01d3\n\62\5\62\u01d5\n\62\3\62\3\62\3\62\3\63\5\63\u01db\n\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\5\64\u01e5\n\64\3\64\5\64\u01e8"+
		"\n\64\3\64\3\64\3\65\3\65\5\65\u01ee\n\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\66\3\66\7\66\u01f9\n\66\f\66\16\66\u01fc\13\66\3\66\3\66\3\66"+
		"\3\67\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@"+
		"\3@\3@\3A\6A\u0219\nA\rA\16A\u021a\3B\3B\3C\3C\7C\u0221\nC\fC\16C\u0224"+
		"\13C\3C\5C\u0227\nC\3C\3C\3D\3D\5D\u022d\nD\3E\5E\u0230\nE\3F\3F\3F\5"+
		"F\u0235\nF\3G\6G\u0238\nG\rG\16G\u0239\3G\3G\3G\3H\3H\3I\3I\3I\3I\3I\3"+
		"J\3J\3J\3J\3K\5K\u024b\nK\3K\3K\3K\3K\3K\3L\3L\3L\3L\3M\3M\3M\3N\3N\3"+
		"N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3O\5O\u026d\nO\3O\3"+
		"O\3O\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\7Q\u0286"+
		"\nQ\fQ\16Q\u0289\13Q\3Q\3Q\3Q\3R\5R\u028f\nR\3R\3R\3R\3R\3R\3S\3S\3S\3"+
		"T\5T\u029a\nT\3T\3T\3T\3T\3T\3U\3U\3U\3\u01bb\2V\t\2\13\t\r\n\17\4\21"+
		"\2\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\2a\2c\2e\2g\61i\62k\2m\2o\2q\63s\64u\65w\66y\67{8}9\177:\u0081"+
		";\u0083<\u0085=\u0087>\u0089\2\u008b?\u008d\2\u008f\2\u0091\2\u0093\2"+
		"\u0095@\u0097H\u0099A\u009b\2\u009d\2\u009fB\u00a1C\u00a3D\u00a5E\u00a7"+
		"\2\u00a9\2\u00abF\u00ad\2\u00afG\t\2\3\4\5\6\7\b\21\5\2((*+\60\60\4\2"+
		"\13\13\"\"\4\2FFUU\5\2\f\f\17\17))\7\2FFKKMNPQUV\b\2CJLLNNRUXXZ\\\b\2"+
		"CDFGJJSSWW[[\5\2\f\f\17\17\"\"\4\2\f\f\17\17\3\2\61\61\3\2\62;\4\2>>}"+
		"}\4\2((\60\60\7\2%&((B\\aac|\4\2\'\'\60\60\2\u02b6\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2"+
		"\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3"+
		"\2\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2\2\2\3)\3\2\2\2\3+\3\2\2\2\3-\3\2"+
		"\2\2\3/\3\2\2\2\3\61\3\2\2\2\3\63\3\2\2\2\3\65\3\2\2\2\3\67\3\2\2\2\3"+
		"9\3\2\2\2\3;\3\2\2\2\3=\3\2\2\2\3?\3\2\2\2\3A\3\2\2\2\3C\3\2\2\2\3E\3"+
		"\2\2\2\3G\3\2\2\2\3I\3\2\2\2\3K\3\2\2\2\3M\3\2\2\2\3O\3\2\2\2\3Q\3\2\2"+
		"\2\3S\3\2\2\2\3U\3\2\2\2\3W\3\2\2\2\3Y\3\2\2\2\3[\3\2\2\2\3]\3\2\2\2\3"+
		"_\3\2\2\2\3a\3\2\2\2\3c\3\2\2\2\4e\3\2\2\2\4g\3\2\2\2\4i\3\2\2\2\4k\3"+
		"\2\2\2\4o\3\2\2\2\4q\3\2\2\2\4s\3\2\2\2\4u\3\2\2\2\4w\3\2\2\2\4y\3\2\2"+
		"\2\4{\3\2\2\2\4}\3\2\2\2\4\177\3\2\2\2\4\u0081\3\2\2\2\4\u0083\3\2\2\2"+
		"\4\u0085\3\2\2\2\4\u0087\3\2\2\2\4\u008b\3\2\2\2\4\u0093\3\2\2\2\4\u0095"+
		"\3\2\2\2\5\u0097\3\2\2\2\5\u0099\3\2\2\2\5\u009b\3\2\2\2\5\u009d\3\2\2"+
		"\2\5\u009f\3\2\2\2\6\u00a1\3\2\2\2\6\u00a3\3\2\2\2\6\u00a5\3\2\2\2\7\u00a7"+
		"\3\2\2\2\7\u00a9\3\2\2\2\7\u00ab\3\2\2\2\b\u00ad\3\2\2\2\b\u00af\3\2\2"+
		"\2\t\u00b2\3\2\2\2\13\u00b9\3\2\2\2\r\u00c2\3\2\2\2\17\u00ca\3\2\2\2\21"+
		"\u00d0\3\2\2\2\23\u00d4\3\2\2\2\25\u00d9\3\2\2\2\27\u00dd\3\2\2\2\31\u00e3"+
		"\3\2\2\2\33\u00e7\3\2\2\2\35\u00ed\3\2\2\2\37\u00f3\3\2\2\2!\u00f9\3\2"+
		"\2\2#\u00fc\3\2\2\2%\u00ff\3\2\2\2\'\u0104\3\2\2\2)\u010a\3\2\2\2+\u0110"+
		"\3\2\2\2-\u0115\3\2\2\2/\u011b\3\2\2\2\61\u0121\3\2\2\2\63\u0127\3\2\2"+
		"\2\65\u012b\3\2\2\2\67\u0131\3\2\2\29\u0137\3\2\2\2;\u013d\3\2\2\2=\u0143"+
		"\3\2\2\2?\u0147\3\2\2\2A\u014b\3\2\2\2C\u014f\3\2\2\2E\u0155\3\2\2\2G"+
		"\u015a\3\2\2\2I\u015f\3\2\2\2K\u0164\3\2\2\2M\u0169\3\2\2\2O\u016e\3\2"+
		"\2\2Q\u0173\3\2\2\2S\u0178\3\2\2\2U\u017d\3\2\2\2W\u0183\3\2\2\2Y\u018a"+
		"\3\2\2\2[\u0191\3\2\2\2]\u0198\3\2\2\2_\u01a0\3\2\2\2a\u01aa\3\2\2\2c"+
		"\u01b2\3\2\2\2e\u01b6\3\2\2\2g\u01c2\3\2\2\2i\u01c6\3\2\2\2k\u01da\3\2"+
		"\2\2m\u01e4\3\2\2\2o\u01eb\3\2\2\2q\u01f6\3\2\2\2s\u0200\3\2\2\2u\u0203"+
		"\3\2\2\2w\u0206\3\2\2\2y\u0208\3\2\2\2{\u020a\3\2\2\2}\u020c\3\2\2\2\177"+
		"\u020e\3\2\2\2\u0081\u0210\3\2\2\2\u0083\u0212\3\2\2\2\u0085\u0214\3\2"+
		"\2\2\u0087\u0218\3\2\2\2\u0089\u021c\3\2\2\2\u008b\u0226\3\2\2\2\u008d"+
		"\u022c\3\2\2\2\u008f\u022f\3\2\2\2\u0091\u0234\3\2\2\2\u0093\u0237\3\2"+
		"\2\2\u0095\u023e\3\2\2\2\u0097\u0240\3\2\2\2\u0099\u0245\3\2\2\2\u009b"+
		"\u024a\3\2\2\2\u009d\u0251\3\2\2\2\u009f\u0255\3\2\2\2\u00a1\u0258\3\2"+
		"\2\2\u00a3\u026c\3\2\2\2\u00a5\u0271\3\2\2\2\u00a7\u0274\3\2\2\2\u00a9"+
		"\u028e\3\2\2\2\u00ab\u0295\3\2\2\2\u00ad\u0299\3\2\2\2\u00af\u02a0\3\2"+
		"\2\2\u00b1\u00b3\7\60\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\7,\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\2"+
		"\2\2\u00b7\u00b8\b\2\3\2\u00b8\n\3\2\2\2\u00b9\u00be\5\u008dD\2\u00ba"+
		"\u00bd\5\u0091F\2\u00bb\u00bd\t\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\f\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\t\3\2\2\u00c2\u00c1\3\2\2\2"+
		"\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6"+
		"\3\2\2\2\u00c6\u00c7\b\4\4\2\u00c7\u00c8\b\4\5\2\u00c8\16\3\2\2\2\u00c9"+
		"\u00cb\7\17\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3"+
		"\2\2\2\u00cc\u00cd\7\f\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\b\5\6\2\u00cf"+
		"\20\3\2\2\2\u00d0\u00d1\13\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\6\7"+
		"\2\u00d3\22\3\2\2\2\u00d4\u00d5\7R\2\2\u00d5\u00d6\7W\2\2\u00d6\u00d7"+
		"\7U\2\2\u00d7\u00d8\7J\2\2\u00d8\24\3\2\2\2\u00d9\u00da\7R\2\2\u00da\u00db"+
		"\7Q\2\2\u00db\u00dc\7R\2\2\u00dc\26\3\2\2\2\u00dd\u00de\7R\2\2\u00de\u00df"+
		"\7T\2\2\u00df\u00e0\7K\2\2\u00e0\u00e1\7P\2\2\u00e1\u00e2\7V\2\2\u00e2"+
		"\30\3\2\2\2\u00e3\u00e4\7G\2\2\u00e4\u00e5\7S\2\2\u00e5\u00e6\7W\2\2\u00e6"+
		"\32\3\2\2\2\u00e7\u00e8\7E\2\2\u00e8\u00e9\7U\2\2\u00e9\u00ea\7G\2\2\u00ea"+
		"\u00eb\7E\2\2\u00eb\u00ec\7V\2\2\u00ec\34\3\2\2\2\u00ed\u00ee\7F\2\2\u00ee"+
		"\u00ef\7U\2\2\u00ef\u00f0\7G\2\2\u00f0\u00f1\7E\2\2\u00f1\u00f2\7V\2\2"+
		"\u00f2\36\3\2\2\2\u00f3\u00f4\7T\2\2\u00f4\u00f5\7U\2\2\u00f5\u00f6\7"+
		"G\2\2\u00f6\u00f7\7E\2\2\u00f7\u00f8\7V\2\2\u00f8 \3\2\2\2\u00f9\u00fa"+
		"\7F\2\2\u00fa\u00fb\7U\2\2\u00fb\"\3\2\2\2\u00fc\u00fd\7F\2\2\u00fd\u00fe"+
		"\7E\2\2\u00fe$\3\2\2\2\u00ff\u0100\7E\2\2\u0100\u0101\7Q\2\2\u0101\u0102"+
		"\7R\2\2\u0102\u0103\7[\2\2\u0103&\3\2\2\2\u0104\u0105\7U\2\2\u0105\u0106"+
		"\7R\2\2\u0106\u0107\7C\2\2\u0107\u0108\7E\2\2\u0108\u0109\7G\2\2\u0109"+
		"(\3\2\2\2\u010a\u010b\7W\2\2\u010b\u010c\7U\2\2\u010c\u010d\7K\2\2\u010d"+
		"\u010e\7P\2\2\u010e\u010f\7I\2\2\u010f*\3\2\2\2\u0110\u0111\7F\2\2\u0111"+
		"\u0112\7T\2\2\u0112\u0113\7Q\2\2\u0113\u0114\7R\2\2\u0114,\3\2\2\2\u0115"+
		"\u0116\7C\2\2\u0116\u0117\7N\2\2\u0117\u0118\7K\2\2\u0118\u0119\7C\2\2"+
		"\u0119\u011a\7U\2\2\u011a.\3\2\2\2\u011b\u011c\7C\2\2\u011c\u011d\7O\2"+
		"\2\u011d\u011e\7Q\2\2\u011e\u011f\7F\2\2\u011f\u0120\7G\2\2\u0120\60\3"+
		"\2\2\2\u0121\u0122\7G\2\2\u0122\u0123\7L\2\2\u0123\u0124\7G\2\2\u0124"+
		"\u0125\7E\2\2\u0125\u0126\7V\2\2\u0126\62\3\2\2\2\u0127\u0128\7G\2\2\u0128"+
		"\u0129\7P\2\2\u0129\u012a\7F\2\2\u012a\64\3\2\2\2\u012b\u012c\7G\2\2\u012c"+
		"\u012d\7P\2\2\u012d\u012e\7V\2\2\u012e\u012f\7T\2\2\u012f\u0130\7[\2\2"+
		"\u0130\66\3\2\2\2\u0131\u0132\7N\2\2\u0132\u0133\7Q\2\2\u0133\u0134\7"+
		"E\2\2\u0134\u0135\7V\2\2\u0135\u0136\7T\2\2\u01368\3\2\2\2\u0137\u0138"+
		"\7N\2\2\u0138\u0139\7V\2\2\u0139\u013a\7Q\2\2\u013a\u013b\7T\2\2\u013b"+
		"\u013c\7I\2\2\u013c:\3\2\2\2\u013d\u013e\7Q\2\2\u013e\u013f\7R\2\2\u013f"+
		"\u0140\7U\2\2\u0140\u0141\7[\2\2\u0141\u0142\7P\2\2\u0142<\3\2\2\2\u0143"+
		"\u0144\7Q\2\2\u0144\u0145\7T\2\2\u0145\u0146\7I\2\2\u0146>\3\2\2\2\u0147"+
		"\u0148\7E\2\2\u0148\u0149\7E\2\2\u0149\u014a\7Y\2\2\u014a@\3\2\2\2\u014b"+
		"\u014c\7C\2\2\u014c\u014d\7I\2\2\u014d\u014e\7Q\2\2\u014eB\3\2\2\2\u014f"+
		"\u0150\7O\2\2\u0150\u0151\7C\2\2\u0151\u0152\7E\2\2\u0152\u0153\7T\2\2"+
		"\u0153\u0154\7Q\2\2\u0154D\3\2\2\2\u0155\u0156\7O\2\2\u0156\u0157\7G\2"+
		"\2\u0157\u0158\7P\2\2\u0158\u0159\7F\2\2\u0159F\3\2\2\2\u015a\u015b\7"+
		"C\2\2\u015b\u015c\7P\2\2\u015c\u015d\7Q\2\2\u015d\u015e\7R\2\2\u015eH"+
		"\3\2\2\2\u015f\u0160\7N\2\2\u0160\u0161\7E\2\2\u0161\u0162\7N\2\2\u0162"+
		"\u0163\7C\2\2\u0163J\3\2\2\2\u0164\u0165\7N\2\2\u0165\u0166\7E\2\2\u0166"+
		"\u0167\7N\2\2\u0167\u0168\7D\2\2\u0168L\3\2\2\2\u0169\u016a\7N\2\2\u016a"+
		"\u016b\7E\2\2\u016b\u016c\7N\2\2\u016c\u016d\7E\2\2\u016dN\3\2\2\2\u016e"+
		"\u016f\7I\2\2\u016f\u0170\7D\2\2\u0170\u0171\7N\2\2\u0171\u0172\7E\2\2"+
		"\u0172P\3\2\2\2\u0173\u0174\7I\2\2\u0174\u0175\7D\2\2\u0175\u0176\7N\2"+
		"\2\u0176\u0177\7C\2\2\u0177R\3\2\2\2\u0178\u0179\7I\2\2\u0179\u017a\7"+
		"D\2\2\u017a\u017b\7N\2\2\u017b\u017c\7D\2\2\u017cT\3\2\2\2\u017d\u017e"+
		"\7C\2\2\u017e\u017f\7K\2\2\u017f\u0180\7H\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u0182\b(\b\2\u0182V\3\2\2\2\u0183\u0184\7U\2\2\u0184\u0185\7G\2\2\u0185"+
		"\u0186\7V\2\2\u0186\u0187\7D\2\2\u0187\u0188\3\2\2\2\u0188\u0189\b)\t"+
		"\2\u0189X\3\2\2\2\u018a\u018b\7U\2\2\u018b\u018c\7G\2\2\u018c\u018d\7"+
		"V\2\2\u018d\u018e\7C\2\2\u018e\u018f\3\2\2\2\u018f\u0190\b*\n\2\u0190"+
		"Z\3\2\2\2\u0191\u0192\7U\2\2\u0192\u0193\7G\2\2\u0193\u0194\7V\2\2\u0194"+
		"\u0195\7E\2\2\u0195\u0196\3\2\2\2\u0196\u0197\b+\13\2\u0197\\\3\2\2\2"+
		"\u0198\u019c\5\u008fE\2\u0199\u019b\5\u0091F\2\u019a\u0199\3\2\2\2\u019b"+
		"\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d^\3\2\2\2"+
		"\u019e\u019c\3\2\2\2\u019f\u01a1\7\17\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1"+
		"\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7\f\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01a5\b-\f\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\b-\r\2\u01a7\u01a8\b-\16"+
		"\2\u01a8`\3\2\2\2\u01a9\u01ab\t\3\2\2\u01aa\u01a9\3\2\2\2\u01ab\u01ac"+
		"\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\u01af\b.\17\2\u01af\u01b0\b.\5\2\u01b0\u01b1\b.\20\2\u01b1b\3\2\2\2\u01b2"+
		"\u01b3\13\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\b/\7\2\u01b5d\3\2\2\2"+
		"\u01b6\u01b7\t\4\2\2\u01b7\u01bb\7)\2\2\u01b8\u01ba\n\5\2\2\u01b9\u01b8"+
		"\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc"+
		"\u01be\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01bf\7)\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0\u01c1\b\60\21\2\u01c1f\3\2\2\2\u01c2\u01c3\t\6\2\2\u01c3\u01c4"+
		"\7)\2\2\u01c4h\3\2\2\2\u01c5\u01c7\5\u0087A\2\u01c6\u01c5\3\2\2\2\u01c6"+
		"\u01c7\3\2\2\2\u01c7\u01d4\3\2\2\2\u01c8\u01ca\t\7\2\2\u01c9\u01cb\t\b"+
		"\2\2\u01ca\u01c9\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01d2\3\2\2\2\u01cc"+
		"\u01ce\7N\2\2\u01cd\u01cf\5\u0087A\2\u01ce\u01cd\3\2\2\2\u01cf\u01d0\3"+
		"\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2"+
		"\u01cc\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01c8\3\2"+
		"\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\7)\2\2\u01d7"+
		"\u01d8\b\62\22\2\u01d8j\3\2\2\2\u01d9\u01db\7\17\2\2\u01da\u01d9\3\2\2"+
		"\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\7\f\2\2\u01dd\u01de"+
		"\3\2\2\2\u01de\u01df\b\63\23\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\b\63\16"+
		"\2\u01e1\u01e2\b\63\r\2\u01e2l\3\2\2\2\u01e3\u01e5\5\u0093G\2\u01e4\u01e3"+
		"\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e7\3\2\2\2\u01e6\u01e8\7\17\2\2"+
		"\u01e7\u01e6\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea"+
		"\7\f\2\2\u01ean\3\2\2\2\u01eb\u01ed\n\t\2\2\u01ec\u01ee\7\17\2\2\u01ed"+
		"\u01ec\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\7\f"+
		"\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f2\6\65\2\2\u01f2\u01f3\3\2\2\2\u01f3"+
		"\u01f4\b\65\24\2\u01f4\u01f5\b\65\2\2\u01f5p\3\2\2\2\u01f6\u01fa\5\u0093"+
		"G\2\u01f7\u01f9\n\n\2\2\u01f8\u01f7\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa"+
		"\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01fa\3\2"+
		"\2\2\u01fd\u01fe\b\66\25\2\u01fe\u01ff\6\66\3\2\u01ffr\3\2\2\2\u0200\u0201"+
		"\7*\2\2\u0201\u0202\b\67\26\2\u0202t\3\2\2\2\u0203\u0204\7+\2\2\u0204"+
		"\u0205\b8\27\2\u0205v\3\2\2\2\u0206\u0207\7\60\2\2\u0207x\3\2\2\2\u0208"+
		"\u0209\7.\2\2\u0209z\3\2\2\2\u020a\u020b\7-\2\2\u020b|\3\2\2\2\u020c\u020d"+
		"\7/\2\2\u020d~\3\2\2\2\u020e\u020f\7?\2\2\u020f\u0080\3\2\2\2\u0210\u0211"+
		"\7,\2\2\u0211\u0082\3\2\2\2\u0212\u0213\t\13\2\2\u0213\u0084\3\2\2\2\u0214"+
		"\u0215\5\u0087A\2\u0215\u0216\5\u008bC\2\u0216\u0086\3\2\2\2\u0217\u0219"+
		"\5\u0089B\2\u0218\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u0218\3\2\2"+
		"\2\u021a\u021b\3\2\2\2\u021b\u0088\3\2\2\2\u021c\u021d\t\f\2\2\u021d\u008a"+
		"\3\2\2\2\u021e\u0222\5\u008dD\2\u021f\u0221\5\u0091F\2\u0220\u021f\3\2"+
		"\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0227\3\2\2\2\u0224\u0222\3\2\2\2\u0225\u0227\t\r\2\2\u0226\u021e\3\2"+
		"\2\2\u0226\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u0229\bC\30\2\u0229"+
		"\u008c\3\2\2\2\u022a\u022d\5\u008fE\2\u022b\u022d\t\16\2\2\u022c\u022a"+
		"\3\2\2\2\u022c\u022b\3\2\2\2\u022d\u008e\3\2\2\2\u022e\u0230\t\17\2\2"+
		"\u022f\u022e\3\2\2\2\u0230\u0090\3\2\2\2\u0231\u0235\5\u008fE\2\u0232"+
		"\u0235\5\u0089B\2\u0233\u0235\t\20\2\2\u0234\u0231\3\2\2\2\u0234\u0232"+
		"\3\2\2\2\u0234\u0233\3\2\2\2\u0235\u0092\3\2\2\2\u0236\u0238\t\3\2\2\u0237"+
		"\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2"+
		"\2\2\u023a\u023b\3\2\2\2\u023b\u023c\bG\5\2\u023c\u023d\bG\20\2\u023d"+
		"\u0094\3\2\2\2\u023e\u023f\13\2\2\2\u023f\u0096\3\2\2\2\u0240\u0241\7"+
		")\2\2\u0241\u0242\7)\2\2\u0242\u0243\3\2\2\2\u0243\u0244\bI\2\2\u0244"+
		"\u0098\3\2\2\2\u0245\u0246\7)\2\2\u0246\u0247\3\2\2\2\u0247\u0248\bJ\31"+
		"\2\u0248\u009a\3\2\2\2\u0249\u024b\7\17\2\2\u024a\u0249\3\2\2\2\u024a"+
		"\u024b\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024d\7\f\2\2\u024d\u024e\3\2"+
		"\2\2\u024e\u024f\bK\32\2\u024f\u0250\bK\16\2\u0250\u009c\3\2\2\2\u0251"+
		"\u0252\5\u0093G\2\u0252\u0253\3\2\2\2\u0253\u0254\bL\2\2\u0254\u009e\3"+
		"\2\2\2\u0255\u0256\n\t\2\2\u0256\u0257\bM\33\2\u0257\u00a0\3\2\2\2\u0258"+
		"\u0259\7\"\2\2\u0259\u025a\7\"\2\2\u025a\u025b\7\"\2\2\u025b\u025c\7\""+
		"\2\2\u025c\u025d\7\"\2\2\u025d\u025e\7\"\2\2\u025e\u025f\7\"\2\2\u025f"+
		"\u0260\7\"\2\2\u0260\u0261\7\"\2\2\u0261\u0262\7\"\2\2\u0262\u0263\7\""+
		"\2\2\u0263\u0264\7\"\2\2\u0264\u0265\7\"\2\2\u0265\u0266\7\"\2\2\u0266"+
		"\u0267\7\"\2\2\u0267\u0268\3\2\2\2\u0268\u0269\bN\31\2\u0269\u026a\bN"+
		"\5\2\u026a\u00a2\3\2\2\2\u026b\u026d\7\17\2\2\u026c\u026b\3\2\2\2\u026c"+
		"\u026d\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u026f\7\f\2\2\u026f\u0270\bO"+
		"\34\2\u0270\u00a4\3\2\2\2\u0271\u0272\13\2\2\2\u0272\u0273\bP\35\2\u0273"+
		"\u00a6\3\2\2\2\u0274\u0275\7\"\2\2\u0275\u0276\7\"\2\2\u0276\u0277\7\""+
		"\2\2\u0277\u0278\7\"\2\2\u0278\u0279\7\"\2\2\u0279\u027a\7\"\2\2\u027a"+
		"\u027b\7\"\2\2\u027b\u027c\7\"\2\2\u027c\u027d\7\"\2\2\u027d\u027e\7\""+
		"\2\2\u027e\u027f\7\"\2\2\u027f\u0280\7\"\2\2\u0280\u0281\7\"\2\2\u0281"+
		"\u0282\7\"\2\2\u0282\u0283\7\"\2\2\u0283\u0287\3\2\2\2\u0284\u0286\5\u0091"+
		"F\2\u0285\u0284\3\2\2\2\u0286\u0289\3\2\2\2\u0287\u0285\3\2\2\2\u0287"+
		"\u0288\3\2\2\2\u0288\u028a\3\2\2\2\u0289\u0287\3\2\2\2\u028a\u028b\bQ"+
		"\31\2\u028b\u028c\bQ\36\2\u028c\u00a8\3\2\2\2\u028d\u028f\7\17\2\2\u028e"+
		"\u028d\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0291\7\f"+
		"\2\2\u0291\u0292\3\2\2\2\u0292\u0293\bR\31\2\u0293\u0294\bR\37\2\u0294"+
		"\u00aa\3\2\2\2\u0295\u0296\13\2\2\2\u0296\u0297\bS \2\u0297\u00ac\3\2"+
		"\2\2\u0298\u029a\7\17\2\2\u0299\u0298\3\2\2\2\u0299\u029a\3\2\2\2\u029a"+
		"\u029b\3\2\2\2\u029b\u029c\7\f\2\2\u029c\u029d\3\2\2\2\u029d\u029e\bT"+
		"\31\2\u029e\u029f\bT\r\2\u029f\u00ae\3\2\2\2\u02a0\u02a1\n\n\2\2\u02a1"+
		"\u02a2\bU!\2\u02a2\u00b0\3\2\2\2(\2\3\4\5\6\7\b\u00b2\u00bc\u00be\u00c4"+
		"\u00ca\u019c\u01a0\u01ac\u01bb\u01c6\u01ca\u01d0\u01d2\u01d4\u01da\u01e4"+
		"\u01e7\u01ed\u01fa\u021a\u0222\u0226\u022c\u022f\u0234\u0239\u024a\u026c"+
		"\u0287\u028e\u0299\"\5\2\2\7\b\2\4\3\2\2\3\2\3\5\2\t@\2\3(\3\3)\4\3*\5"+
		"\3+\6\3-\7\t\4\2\4\2\2\4\4\2\t\n\2\tA\2\3\62\b\3\63\t\7\6\2\3\66\n\3\67"+
		"\13\38\f\3C\r\6\2\2\t\b\2\3M\16\3O\17\3P\20\t?\2\tD\2\3S\21\3U\22";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}