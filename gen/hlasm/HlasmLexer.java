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
		"LONG_COMMENT", "LABEL_DEF", "SPACES1", "ENDLINE", "UNKNOWN_CHAR1", "EQU", 
		"CSECT", "DSECT", "RSECT", "DS", "DC", "COPY", "SPACE", "USING", "DROP", 
		"ALIAS", "AMODE", "EJECT", "END", "ENTRY", "LOCTR", "LTORG", "OPSYN", 
		"ORG", "CCW", "AGO", "MACRO", "MEND", "ANOP", "LCLA", "LCLB", "LCLC", 
		"GBLC", "GBLA", "GBLB", "AIF", "SETB", "SETA", "SETC", "COMMAND", "ENDLINE2", 
		"SPACES2", "UNKNOWN_CHAR2", "D0", "FIELD_INFO", "STRING_QUOTE", "ENDLINE1", 
		"ENDLINE_EMPTY", "ONYL_CONT", "ENDLINE_COMMENT", "LEFT_ROUND_PAR", "RIGHT_ROUND_PAR", 
		"DOT", "COMMA", "PLUS", "MINUS", "EQUALS", "MUL", "DIVIDE", "LEN_TYPE", 
		"NUMBER", "DIGIT", "LABEL", "ID_START_ONLY", "ID_START", "ID_CONTINUE", 
		"SPACES", "UNKNOWN_CHAR", "ESCAPE", "STRING", "BAD_STRING", "SPACES_COMM1", 
		"COMMENT_CONT1", "ARG_SEPARATOR", "ERROR", "ERROR2", "LABEL_SEP", "ERROR3", 
		"ERROR4", "COMMENT_ENDLINE3", "COMMENT_CONT"
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
		case 35:
			AIF_action((RuleContext)_localctx, actionIndex);
			break;
		case 36:
			SETB_action((RuleContext)_localctx, actionIndex);
			break;
		case 37:
			SETA_action((RuleContext)_localctx, actionIndex);
			break;
		case 38:
			SETC_action((RuleContext)_localctx, actionIndex);
			break;
		case 40:
			ENDLINE2_action((RuleContext)_localctx, actionIndex);
			break;
		case 46:
			ENDLINE1_action((RuleContext)_localctx, actionIndex);
			break;
		case 49:
			ENDLINE_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 50:
			LEFT_ROUND_PAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 51:
			RIGHT_ROUND_PAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 62:
			LABEL_action((RuleContext)_localctx, actionIndex);
			break;
		case 72:
			COMMENT_CONT1_action((RuleContext)_localctx, actionIndex);
			break;
		case 74:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 75:
			ERROR2_action((RuleContext)_localctx, actionIndex);
			break;
		case 78:
			ERROR4_action((RuleContext)_localctx, actionIndex);
			break;
		case 80:
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
	private void ENDLINE1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			spaces = 0; parenth = 0; inAIF=0;_modeStack.clear();
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
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:

			    _modeStack.clear();
			    mode(DEFAULT_MODE);
			    if (getCharPositionInLine() < 15)
			        setType(ENDLINE);
			    
			break;
		}
	}
	private void ERROR2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:

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
		case 14:

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
		case 15:


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
		case 48:
			return ONYL_CONT_sempred((RuleContext)_localctx, predIndex);
		case 49:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u028f\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4"+
		":\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\t"+
		"E\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4"+
		"Q\tQ\4R\tR\3\2\5\2\u00ad\n\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\u00b7"+
		"\n\3\f\3\16\3\u00ba\13\3\3\4\6\4\u00bd\n\4\r\4\16\4\u00be\3\4\3\4\3\4"+
		"\3\5\5\5\u00c5\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3"+
		")\7)\u0186\n)\f)\16)\u0189\13)\3*\5*\u018c\n*\3*\3*\3*\3*\3*\3*\3*\3+"+
		"\6+\u0196\n+\r+\16+\u0197\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\6-\u01a5\n"+
		"-\r-\16-\u01a6\3-\3-\3-\3-\3.\3.\3.\3/\5/\u01b1\n/\3/\3/\5/\u01b5\n/\3"+
		"/\3/\6/\u01b9\n/\r/\16/\u01ba\5/\u01bd\n/\5/\u01bf\n/\3/\3/\3/\3/\3/\3"+
		"\60\5\60\u01c7\n\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\5\61\u01d1"+
		"\n\61\3\61\5\61\u01d4\n\61\3\61\3\61\3\62\3\62\5\62\u01da\n\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\7\63\u01e5\n\63\f\63\16\63\u01e8"+
		"\13\63\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3=\3>\6>\u0205\n>\r>\16>\u0206\3"+
		"?\3?\3@\3@\7@\u020d\n@\f@\16@\u0210\13@\3@\5@\u0213\n@\3@\3@\3A\3A\5A"+
		"\u0219\nA\3B\5B\u021c\nB\3C\3C\3C\5C\u0221\nC\3D\6D\u0224\nD\rD\16D\u0225"+
		"\3D\3D\3D\3E\3E\3F\3F\3F\3F\3F\3G\3G\3G\3G\3H\5H\u0237\nH\3H\3H\3H\3H"+
		"\3H\3I\3I\3I\3I\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K"+
		"\3K\3K\3K\3K\3L\5L\u0259\nL\3L\3L\3L\3M\3M\3M\3N\3N\3N\3N\3N\3N\3N\3N"+
		"\3N\3N\3N\3N\3N\3N\3N\3N\3N\7N\u0272\nN\fN\16N\u0275\13N\3N\3N\3N\3O\5"+
		"O\u027b\nO\3O\3O\3O\3O\3O\3P\3P\3P\3Q\5Q\u0286\nQ\3Q\3Q\3Q\3Q\3Q\3R\3"+
		"R\3R\2\2S\t\2\13\t\r\n\17\4\21\2\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[\2]\2_\2a.c\2e\2g\2i\2k/m\60o\61q\62"+
		"s\63u\64w\65y\66{\67}8\1779\u0081:\u0083\2\u0085;\u0087\2\u0089\2\u008b"+
		"\2\u008d\2\u008f<\u0091D\u0093=\u0095\2\u0097\2\u0099>\u009b?\u009d@\u009f"+
		"A\u00a1\2\u00a3\2\u00a5B\u00a7\2\u00a9C\t\2\3\4\5\6\7\b\21\5\2((*+\60"+
		"\60\4\2\13\13\"\"\4\2FFNN\b\2\f\f\17\17\"\"*+--//\7\2FFKKMNPQUV\b\2CJ"+
		"LLNNRUXXZ\\\b\2CDFGJJSSWW[[\5\2\f\f\17\17\"\"\4\2\f\f\17\17\3\2\61\61"+
		"\3\2\62;\4\2>>}}\4\2((\60\60\7\2%&((B\\aac|\4\2\'\'\60\60\2\u02a2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2"+
		"\2\3\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\3\33\3\2\2\2\3\35\3\2\2\2\3"+
		"\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2\2\2\3)\3\2\2\2\3"+
		"+\3\2\2\2\3-\3\2\2\2\3/\3\2\2\2\3\61\3\2\2\2\3\63\3\2\2\2\3\65\3\2\2\2"+
		"\3\67\3\2\2\2\39\3\2\2\2\3;\3\2\2\2\3=\3\2\2\2\3?\3\2\2\2\3A\3\2\2\2\3"+
		"C\3\2\2\2\3E\3\2\2\2\3G\3\2\2\2\3I\3\2\2\2\3K\3\2\2\2\3M\3\2\2\2\3O\3"+
		"\2\2\2\3Q\3\2\2\2\3S\3\2\2\2\3U\3\2\2\2\3W\3\2\2\2\3Y\3\2\2\2\3[\3\2\2"+
		"\2\3]\3\2\2\2\4_\3\2\2\2\4a\3\2\2\2\4c\3\2\2\2\4e\3\2\2\2\4i\3\2\2\2\4"+
		"k\3\2\2\2\4m\3\2\2\2\4o\3\2\2\2\4q\3\2\2\2\4s\3\2\2\2\4u\3\2\2\2\4w\3"+
		"\2\2\2\4y\3\2\2\2\4{\3\2\2\2\4}\3\2\2\2\4\177\3\2\2\2\4\u0081\3\2\2\2"+
		"\4\u0085\3\2\2\2\4\u008d\3\2\2\2\4\u008f\3\2\2\2\5\u0091\3\2\2\2\5\u0093"+
		"\3\2\2\2\5\u0095\3\2\2\2\5\u0097\3\2\2\2\5\u0099\3\2\2\2\6\u009b\3\2\2"+
		"\2\6\u009d\3\2\2\2\6\u009f\3\2\2\2\7\u00a1\3\2\2\2\7\u00a3\3\2\2\2\7\u00a5"+
		"\3\2\2\2\b\u00a7\3\2\2\2\b\u00a9\3\2\2\2\t\u00ac\3\2\2\2\13\u00b3\3\2"+
		"\2\2\r\u00bc\3\2\2\2\17\u00c4\3\2\2\2\21\u00ca\3\2\2\2\23\u00ce\3\2\2"+
		"\2\25\u00d2\3\2\2\2\27\u00d8\3\2\2\2\31\u00de\3\2\2\2\33\u00e4\3\2\2\2"+
		"\35\u00e7\3\2\2\2\37\u00ea\3\2\2\2!\u00ef\3\2\2\2#\u00f5\3\2\2\2%\u00fb"+
		"\3\2\2\2\'\u0100\3\2\2\2)\u0106\3\2\2\2+\u010c\3\2\2\2-\u0112\3\2\2\2"+
		"/\u0116\3\2\2\2\61\u011c\3\2\2\2\63\u0122\3\2\2\2\65\u0128\3\2\2\2\67"+
		"\u012e\3\2\2\29\u0132\3\2\2\2;\u0136\3\2\2\2=\u013a\3\2\2\2?\u0140\3\2"+
		"\2\2A\u0145\3\2\2\2C\u014a\3\2\2\2E\u014f\3\2\2\2G\u0154\3\2\2\2I\u0159"+
		"\3\2\2\2K\u015e\3\2\2\2M\u0163\3\2\2\2O\u0168\3\2\2\2Q\u016e\3\2\2\2S"+
		"\u0175\3\2\2\2U\u017c\3\2\2\2W\u0183\3\2\2\2Y\u018b\3\2\2\2[\u0195\3\2"+
		"\2\2]\u019d\3\2\2\2_\u01a1\3\2\2\2a\u01ac\3\2\2\2c\u01b0\3\2\2\2e\u01c6"+
		"\3\2\2\2g\u01d0\3\2\2\2i\u01d7\3\2\2\2k\u01e2\3\2\2\2m\u01ec\3\2\2\2o"+
		"\u01ef\3\2\2\2q\u01f2\3\2\2\2s\u01f4\3\2\2\2u\u01f6\3\2\2\2w\u01f8\3\2"+
		"\2\2y\u01fa\3\2\2\2{\u01fc\3\2\2\2}\u01fe\3\2\2\2\177\u0200\3\2\2\2\u0081"+
		"\u0204\3\2\2\2\u0083\u0208\3\2\2\2\u0085\u0212\3\2\2\2\u0087\u0218\3\2"+
		"\2\2\u0089\u021b\3\2\2\2\u008b\u0220\3\2\2\2\u008d\u0223\3\2\2\2\u008f"+
		"\u022a\3\2\2\2\u0091\u022c\3\2\2\2\u0093\u0231\3\2\2\2\u0095\u0236\3\2"+
		"\2\2\u0097\u023d\3\2\2\2\u0099\u0241\3\2\2\2\u009b\u0244\3\2\2\2\u009d"+
		"\u0258\3\2\2\2\u009f\u025d\3\2\2\2\u00a1\u0260\3\2\2\2\u00a3\u027a\3\2"+
		"\2\2\u00a5\u0281\3\2\2\2\u00a7\u0285\3\2\2\2\u00a9\u028c\3\2\2\2\u00ab"+
		"\u00ad\7\60\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3"+
		"\2\2\2\u00ae\u00af\7,\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\b\2\2\2\u00b1"+
		"\u00b2\b\2\3\2\u00b2\n\3\2\2\2\u00b3\u00b8\5\u0087A\2\u00b4\u00b7\5\u008b"+
		"C\2\u00b5\u00b7\t\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\f\3\2\2\2"+
		"\u00ba\u00b8\3\2\2\2\u00bb\u00bd\t\3\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\b\4\4\2\u00c1\u00c2\b\4\5\2\u00c2\16\3\2\2\2\u00c3\u00c5\7\17\2"+
		"\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7"+
		"\7\f\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b\5\6\2\u00c9\20\3\2\2\2\u00ca"+
		"\u00cb\13\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b\6\7\2\u00cd\22\3\2\2"+
		"\2\u00ce\u00cf\7G\2\2\u00cf\u00d0\7S\2\2\u00d0\u00d1\7W\2\2\u00d1\24\3"+
		"\2\2\2\u00d2\u00d3\7E\2\2\u00d3\u00d4\7U\2\2\u00d4\u00d5\7G\2\2\u00d5"+
		"\u00d6\7E\2\2\u00d6\u00d7\7V\2\2\u00d7\26\3\2\2\2\u00d8\u00d9\7F\2\2\u00d9"+
		"\u00da\7U\2\2\u00da\u00db\7G\2\2\u00db\u00dc\7E\2\2\u00dc\u00dd\7V\2\2"+
		"\u00dd\30\3\2\2\2\u00de\u00df\7T\2\2\u00df\u00e0\7U\2\2\u00e0\u00e1\7"+
		"G\2\2\u00e1\u00e2\7E\2\2\u00e2\u00e3\7V\2\2\u00e3\32\3\2\2\2\u00e4\u00e5"+
		"\7F\2\2\u00e5\u00e6\7U\2\2\u00e6\34\3\2\2\2\u00e7\u00e8\7F\2\2\u00e8\u00e9"+
		"\7E\2\2\u00e9\36\3\2\2\2\u00ea\u00eb\7E\2\2\u00eb\u00ec\7Q\2\2\u00ec\u00ed"+
		"\7R\2\2\u00ed\u00ee\7[\2\2\u00ee \3\2\2\2\u00ef\u00f0\7U\2\2\u00f0\u00f1"+
		"\7R\2\2\u00f1\u00f2\7C\2\2\u00f2\u00f3\7E\2\2\u00f3\u00f4\7G\2\2\u00f4"+
		"\"\3\2\2\2\u00f5\u00f6\7W\2\2\u00f6\u00f7\7U\2\2\u00f7\u00f8\7K\2\2\u00f8"+
		"\u00f9\7P\2\2\u00f9\u00fa\7I\2\2\u00fa$\3\2\2\2\u00fb\u00fc\7F\2\2\u00fc"+
		"\u00fd\7T\2\2\u00fd\u00fe\7Q\2\2\u00fe\u00ff\7R\2\2\u00ff&\3\2\2\2\u0100"+
		"\u0101\7C\2\2\u0101\u0102\7N\2\2\u0102\u0103\7K\2\2\u0103\u0104\7C\2\2"+
		"\u0104\u0105\7U\2\2\u0105(\3\2\2\2\u0106\u0107\7C\2\2\u0107\u0108\7O\2"+
		"\2\u0108\u0109\7Q\2\2\u0109\u010a\7F\2\2\u010a\u010b\7G\2\2\u010b*\3\2"+
		"\2\2\u010c\u010d\7G\2\2\u010d\u010e\7L\2\2\u010e\u010f\7G\2\2\u010f\u0110"+
		"\7E\2\2\u0110\u0111\7V\2\2\u0111,\3\2\2\2\u0112\u0113\7G\2\2\u0113\u0114"+
		"\7P\2\2\u0114\u0115\7F\2\2\u0115.\3\2\2\2\u0116\u0117\7G\2\2\u0117\u0118"+
		"\7P\2\2\u0118\u0119\7V\2\2\u0119\u011a\7T\2\2\u011a\u011b\7[\2\2\u011b"+
		"\60\3\2\2\2\u011c\u011d\7N\2\2\u011d\u011e\7Q\2\2\u011e\u011f\7E\2\2\u011f"+
		"\u0120\7V\2\2\u0120\u0121\7T\2\2\u0121\62\3\2\2\2\u0122\u0123\7N\2\2\u0123"+
		"\u0124\7V\2\2\u0124\u0125\7Q\2\2\u0125\u0126\7T\2\2\u0126\u0127\7I\2\2"+
		"\u0127\64\3\2\2\2\u0128\u0129\7Q\2\2\u0129\u012a\7R\2\2\u012a\u012b\7"+
		"U\2\2\u012b\u012c\7[\2\2\u012c\u012d\7P\2\2\u012d\66\3\2\2\2\u012e\u012f"+
		"\7Q\2\2\u012f\u0130\7T\2\2\u0130\u0131\7I\2\2\u01318\3\2\2\2\u0132\u0133"+
		"\7E\2\2\u0133\u0134\7E\2\2\u0134\u0135\7Y\2\2\u0135:\3\2\2\2\u0136\u0137"+
		"\7C\2\2\u0137\u0138\7I\2\2\u0138\u0139\7Q\2\2\u0139<\3\2\2\2\u013a\u013b"+
		"\7O\2\2\u013b\u013c\7C\2\2\u013c\u013d\7E\2\2\u013d\u013e\7T\2\2\u013e"+
		"\u013f\7Q\2\2\u013f>\3\2\2\2\u0140\u0141\7O\2\2\u0141\u0142\7G\2\2\u0142"+
		"\u0143\7P\2\2\u0143\u0144\7F\2\2\u0144@\3\2\2\2\u0145\u0146\7C\2\2\u0146"+
		"\u0147\7P\2\2\u0147\u0148\7Q\2\2\u0148\u0149\7R\2\2\u0149B\3\2\2\2\u014a"+
		"\u014b\7N\2\2\u014b\u014c\7E\2\2\u014c\u014d\7N\2\2\u014d\u014e\7C\2\2"+
		"\u014eD\3\2\2\2\u014f\u0150\7N\2\2\u0150\u0151\7E\2\2\u0151\u0152\7N\2"+
		"\2\u0152\u0153\7D\2\2\u0153F\3\2\2\2\u0154\u0155\7N\2\2\u0155\u0156\7"+
		"E\2\2\u0156\u0157\7N\2\2\u0157\u0158\7E\2\2\u0158H\3\2\2\2\u0159\u015a"+
		"\7I\2\2\u015a\u015b\7D\2\2\u015b\u015c\7N\2\2\u015c\u015d\7E\2\2\u015d"+
		"J\3\2\2\2\u015e\u015f\7I\2\2\u015f\u0160\7D\2\2\u0160\u0161\7N\2\2\u0161"+
		"\u0162\7C\2\2\u0162L\3\2\2\2\u0163\u0164\7I\2\2\u0164\u0165\7D\2\2\u0165"+
		"\u0166\7N\2\2\u0166\u0167\7D\2\2\u0167N\3\2\2\2\u0168\u0169\7C\2\2\u0169"+
		"\u016a\7K\2\2\u016a\u016b\7H\2\2\u016b\u016c\3\2\2\2\u016c\u016d\b%\b"+
		"\2\u016dP\3\2\2\2\u016e\u016f\7U\2\2\u016f\u0170\7G\2\2\u0170\u0171\7"+
		"V\2\2\u0171\u0172\7D\2\2\u0172\u0173\3\2\2\2\u0173\u0174\b&\t\2\u0174"+
		"R\3\2\2\2\u0175\u0176\7U\2\2\u0176\u0177\7G\2\2\u0177\u0178\7V\2\2\u0178"+
		"\u0179\7C\2\2\u0179\u017a\3\2\2\2\u017a\u017b\b\'\n\2\u017bT\3\2\2\2\u017c"+
		"\u017d\7U\2\2\u017d\u017e\7G\2\2\u017e\u017f\7V\2\2\u017f\u0180\7E\2\2"+
		"\u0180\u0181\3\2\2\2\u0181\u0182\b(\13\2\u0182V\3\2\2\2\u0183\u0187\5"+
		"\u0089B\2\u0184\u0186\5\u008bC\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2"+
		"\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188X\3\2\2\2\u0189\u0187"+
		"\3\2\2\2\u018a\u018c\7\17\2\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2"+
		"\u018c\u018d\3\2\2\2\u018d\u018e\7\f\2\2\u018e\u018f\3\2\2\2\u018f\u0190"+
		"\b*\f\2\u0190\u0191\3\2\2\2\u0191\u0192\b*\r\2\u0192\u0193\b*\16\2\u0193"+
		"Z\3\2\2\2\u0194\u0196\t\3\2\2\u0195\u0194\3\2\2\2\u0196\u0197\3\2\2\2"+
		"\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a"+
		"\b+\17\2\u019a\u019b\b+\5\2\u019b\u019c\b+\20\2\u019c\\\3\2\2\2\u019d"+
		"\u019e\13\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\b,\7\2\u01a0^\3\2\2\2"+
		"\u01a1\u01a2\t\4\2\2\u01a2\u01a4\7)\2\2\u01a3\u01a5\n\5\2\2\u01a4\u01a3"+
		"\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a9\7)\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\b-\21"+
		"\2\u01ab`\3\2\2\2\u01ac\u01ad\t\6\2\2\u01ad\u01ae\7)\2\2\u01aeb\3\2\2"+
		"\2\u01af\u01b1\5\u0081>\2\u01b0\u01af\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1"+
		"\u01be\3\2\2\2\u01b2\u01b4\t\7\2\2\u01b3\u01b5\t\b\2\2\u01b4\u01b3\3\2"+
		"\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01bc\3\2\2\2\u01b6\u01b8\7N\2\2\u01b7"+
		"\u01b9\5\u0081>\2\u01b8\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01b8"+
		"\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01b6\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be\u01b2\3\2\2\2\u01be\u01bf\3\2"+
		"\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\7)\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c3\b/\2\2\u01c3\u01c4\b/\22\2\u01c4d\3\2\2\2\u01c5\u01c7\7\17\2\2"+
		"\u01c6\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9"+
		"\7\f\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\b\60\23\2\u01cb\u01cc\3\2\2\2"+
		"\u01cc\u01cd\b\60\16\2\u01cd\u01ce\b\60\r\2\u01cef\3\2\2\2\u01cf\u01d1"+
		"\5\u008dD\2\u01d0\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d3\3\2\2"+
		"\2\u01d2\u01d4\7\17\2\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4"+
		"\u01d5\3\2\2\2\u01d5\u01d6\7\f\2\2\u01d6h\3\2\2\2\u01d7\u01d9\n\t\2\2"+
		"\u01d8\u01da\7\17\2\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db"+
		"\3\2\2\2\u01db\u01dc\7\f\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\6\62\2\2"+
		"\u01de\u01df\3\2\2\2\u01df\u01e0\b\62\24\2\u01e0\u01e1\b\62\2\2\u01e1"+
		"j\3\2\2\2\u01e2\u01e6\5\u008dD\2\u01e3\u01e5\n\n\2\2\u01e4\u01e3\3\2\2"+
		"\2\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9"+
		"\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ea\b\63\25\2\u01ea\u01eb\6\63\3"+
		"\2\u01ebl\3\2\2\2\u01ec\u01ed\7*\2\2\u01ed\u01ee\b\64\26\2\u01een\3\2"+
		"\2\2\u01ef\u01f0\7+\2\2\u01f0\u01f1\b\65\27\2\u01f1p\3\2\2\2\u01f2\u01f3"+
		"\7\60\2\2\u01f3r\3\2\2\2\u01f4\u01f5\7.\2\2\u01f5t\3\2\2\2\u01f6\u01f7"+
		"\7-\2\2\u01f7v\3\2\2\2\u01f8\u01f9\7/\2\2\u01f9x\3\2\2\2\u01fa\u01fb\7"+
		"?\2\2\u01fbz\3\2\2\2\u01fc\u01fd\7,\2\2\u01fd|\3\2\2\2\u01fe\u01ff\t\13"+
		"\2\2\u01ff~\3\2\2\2\u0200\u0201\5\u0081>\2\u0201\u0202\5\u0085@\2\u0202"+
		"\u0080\3\2\2\2\u0203\u0205\5\u0083?\2\u0204\u0203\3\2\2\2\u0205\u0206"+
		"\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0082\3\2\2\2\u0208"+
		"\u0209\t\f\2\2\u0209\u0084\3\2\2\2\u020a\u020e\5\u0087A\2\u020b\u020d"+
		"\5\u008bC\2\u020c\u020b\3\2\2\2\u020d\u0210\3\2\2\2\u020e\u020c\3\2\2"+
		"\2\u020e\u020f\3\2\2\2\u020f\u0213\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0213"+
		"\t\r\2\2\u0212\u020a\3\2\2\2\u0212\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214"+
		"\u0215\b@\30\2\u0215\u0086\3\2\2\2\u0216\u0219\5\u0089B\2\u0217\u0219"+
		"\t\16\2\2\u0218\u0216\3\2\2\2\u0218\u0217\3\2\2\2\u0219\u0088\3\2\2\2"+
		"\u021a\u021c\t\17\2\2\u021b\u021a\3\2\2\2\u021c\u008a\3\2\2\2\u021d\u0221"+
		"\5\u0089B\2\u021e\u0221\5\u0083?\2\u021f\u0221\t\20\2\2\u0220\u021d\3"+
		"\2\2\2\u0220\u021e\3\2\2\2\u0220\u021f\3\2\2\2\u0221\u008c\3\2\2\2\u0222"+
		"\u0224\t\3\2\2\u0223\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0223\3\2"+
		"\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\bD\5\2\u0228"+
		"\u0229\bD\20\2\u0229\u008e\3\2\2\2\u022a\u022b\13\2\2\2\u022b\u0090\3"+
		"\2\2\2\u022c\u022d\7)\2\2\u022d\u022e\7)\2\2\u022e\u022f\3\2\2\2\u022f"+
		"\u0230\bF\2\2\u0230\u0092\3\2\2\2\u0231\u0232\7)\2\2\u0232\u0233\3\2\2"+
		"\2\u0233\u0234\bG\31\2\u0234\u0094\3\2\2\2\u0235\u0237\7\17\2\2\u0236"+
		"\u0235\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0239\7\f"+
		"\2\2\u0239\u023a\3\2\2\2\u023a\u023b\bH\32\2\u023b\u023c\bH\16\2\u023c"+
		"\u0096\3\2\2\2\u023d\u023e\5\u008dD\2\u023e\u023f\3\2\2\2\u023f\u0240"+
		"\bI\2\2\u0240\u0098\3\2\2\2\u0241\u0242\n\t\2\2\u0242\u0243\bJ\33\2\u0243"+
		"\u009a\3\2\2\2\u0244\u0245\7\"\2\2\u0245\u0246\7\"\2\2\u0246\u0247\7\""+
		"\2\2\u0247\u0248\7\"\2\2\u0248\u0249\7\"\2\2\u0249\u024a\7\"\2\2\u024a"+
		"\u024b\7\"\2\2\u024b\u024c\7\"\2\2\u024c\u024d\7\"\2\2\u024d\u024e\7\""+
		"\2\2\u024e\u024f\7\"\2\2\u024f\u0250\7\"\2\2\u0250\u0251\7\"\2\2\u0251"+
		"\u0252\7\"\2\2\u0252\u0253\7\"\2\2\u0253\u0254\3\2\2\2\u0254\u0255\bK"+
		"\31\2\u0255\u0256\bK\5\2\u0256\u009c\3\2\2\2\u0257\u0259\7\17\2\2\u0258"+
		"\u0257\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025b\7\f"+
		"\2\2\u025b\u025c\bL\34\2\u025c\u009e\3\2\2\2\u025d\u025e\13\2\2\2\u025e"+
		"\u025f\bM\35\2\u025f\u00a0\3\2\2\2\u0260\u0261\7\"\2\2\u0261\u0262\7\""+
		"\2\2\u0262\u0263\7\"\2\2\u0263\u0264\7\"\2\2\u0264\u0265\7\"\2\2\u0265"+
		"\u0266\7\"\2\2\u0266\u0267\7\"\2\2\u0267\u0268\7\"\2\2\u0268\u0269\7\""+
		"\2\2\u0269\u026a\7\"\2\2\u026a\u026b\7\"\2\2\u026b\u026c\7\"\2\2\u026c"+
		"\u026d\7\"\2\2\u026d\u026e\7\"\2\2\u026e\u026f\7\"\2\2\u026f\u0273\3\2"+
		"\2\2\u0270\u0272\5\u008bC\2\u0271\u0270\3\2\2\2\u0272\u0275\3\2\2\2\u0273"+
		"\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274\u0276\3\2\2\2\u0275\u0273\3\2"+
		"\2\2\u0276\u0277\bN\31\2\u0277\u0278\bN\36\2\u0278\u00a2\3\2\2\2\u0279"+
		"\u027b\7\17\2\2\u027a\u0279\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027c\3"+
		"\2\2\2\u027c\u027d\7\f\2\2\u027d\u027e\3\2\2\2\u027e\u027f\bO\31\2\u027f"+
		"\u0280\bO\37\2\u0280\u00a4\3\2\2\2\u0281\u0282\13\2\2\2\u0282\u0283\b"+
		"P \2\u0283\u00a6\3\2\2\2\u0284\u0286\7\17\2\2\u0285\u0284\3\2\2\2\u0285"+
		"\u0286\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\7\f\2\2\u0288\u0289\3\2"+
		"\2\2\u0289\u028a\bQ\31\2\u028a\u028b\bQ\r\2\u028b\u00a8\3\2\2\2\u028c"+
		"\u028d\n\n\2\2\u028d\u028e\bR!\2\u028e\u00aa\3\2\2\2(\2\3\4\5\6\7\b\u00ac"+
		"\u00b6\u00b8\u00be\u00c4\u0187\u018b\u0197\u01a6\u01b0\u01b4\u01ba\u01bc"+
		"\u01be\u01c6\u01d0\u01d3\u01d9\u01e6\u0206\u020e\u0212\u0218\u021b\u0220"+
		"\u0225\u0236\u0258\u0273\u027a\u0285\"\5\2\2\7\b\2\4\3\2\2\3\2\3\5\2\t"+
		"<\2\3%\3\3&\4\3\'\5\3(\6\3*\7\t\4\2\4\2\2\4\4\2\t\n\2\t=\2\7\5\2\3\60"+
		"\b\7\6\2\3\63\t\3\64\n\3\65\13\3@\f\6\2\2\t\b\2\3J\r\3L\16\3M\17\t;\2"+
		"\t@\2\3P\20\3R\21";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}