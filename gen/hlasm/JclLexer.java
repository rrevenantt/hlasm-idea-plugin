// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\JclLexer.g4 by ANTLR 4.5.3
package hlasm;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JclLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, JOB_OPTION=2, LINE_START=3, SYSIN=4, LABEL_DEF=5, SPACES1=6, 
		ENDLINE=7, DD=8, EXEC=9, JOB=10, SET=11, ANY_COMMAND=12, LEFT_ROUND_PAR=13, 
		RIGHT_ROUND_PAR=14, EQUALS=15, EQUAL_FOR_TAPE=16, MUL=17, COMMA=18, PLUS=19, 
		MINUS=20, STRING=21, NUMBER=22, LABEL=23, ENDLINE1=24, SPACES=25, UNCKNOWN_SYMBOL=26, 
		LINE_START1=27;
	public static final int LBL = 1;
	public static final int CMD = 2;
	public static final int EVERYTHING = 3;
	public static final int CONTINUATION = 4;
	public static String[] modeNames = {
		"DEFAULT_MODE", "LBL", "CMD", "EVERYTHING", "CONTINUATION"
	};

	public static final String[] ruleNames = {
		"LINE_COMMENT", "JOB_OPTION", "LINE_START", "SYSIN", "UNKNOWN_SYMBOL4", 
		"LABEL_DEF", "SPACES1", "ENDLINE", "UNKNOWN_SYMBOL1", "DD", "EXEC", "JOB", 
		"SET", "ANY_COMMAND", "SPACES2", "ENDLINE2", "UNKNOWN_SYMBOL2", "LEFT_ROUND_PAR", 
		"RIGHT_ROUND_PAR", "EQUALS", "EQUAL_FOR_TAPE", "MUL", "COMMA_2", "COMMA_1", 
		"COMMA", "PLUS", "MINUS", "STRING", "NUMBER", "DIGIT", "LABEL", "ID_START_ONLY", 
		"ID_START", "ID_CONTINUE", "ENDLINE1", "ENDLINE_EMPTY", "ENDLINE_COMMENT", 
		"SPACES", "UNCKNOWN_SYMBOL", "LINE_START1", "ENDLINE3", "UNKNOWN_SYMBOL3"
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


	public JclLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JclLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u0163\b\1\b\1"+
		"\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\3\2\3\2\3\2\3\2\3\2\7\2a\n\2\f\2\16\2d\13\2\3\2\5\2g"+
		"\n\2\3\2\3\2\5\2k\n\2\3\3\3\3\3\3\3\3\7\3q\n\3\f\3\16\3t\13\3\3\3\5\3"+
		"w\n\3\3\3\3\3\5\3{\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5\u0084\n\5\f\5\16"+
		"\5\u0087\13\5\3\5\5\5\u008a\n\5\3\5\3\5\5\5\u008e\n\5\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\7\7\u0096\n\7\f\7\16\7\u0099\13\7\3\b\6\b\u009c\n\b\r\b\16\b"+
		"\u009d\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\7\17"+
		"\u00be\n\17\f\17\16\17\u00c1\13\17\3\20\6\20\u00c4\n\20\r\20\16\20\u00c5"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\7\35\u00f7\n\35\f\35\16\35\u00fa\13\35\3\35"+
		"\3\35\3\36\6\36\u00ff\n\36\r\36\16\36\u0100\3\37\3\37\3 \3 \7 \u0107\n"+
		" \f \16 \u010a\13 \3 \3 \3 \7 \u010f\n \f \16 \u0112\13 \3 \3 \5 \u0116"+
		"\n \3!\3!\5!\u011a\n!\3\"\5\"\u011d\n\"\3#\3#\3#\5#\u0122\n#\3$\3$\3$"+
		"\3$\5$\u0128\n$\3$\3$\3$\3%\5%\u012e\n%\3%\5%\u0131\n%\3%\3%\5%\u0135"+
		"\n%\3&\5&\u0138\n&\3&\7&\u013b\n&\f&\16&\u013e\13&\3&\5&\u0141\n&\3&\3"+
		"&\5&\u0145\n&\3\'\6\'\u0148\n\'\r\'\16\'\u0149\3(\3(\3)\3)\3)\3)\6)\u0152"+
		"\n)\r)\16)\u0153\3)\3)\3)\3*\3*\5*\u015b\n*\3*\3*\3*\3+\3+\3+\3+\5\u0085"+
		"\u00f8\u013c\2,\7\3\t\4\13\5\r\6\17\2\21\7\23\b\25\t\27\2\31\n\33\13\35"+
		"\f\37\r!\16#\2%\2\'\2)\17+\20-\21/\22\61\23\63\2\65\2\67\249\25;\26=\27"+
		"?\30A\2C\31E\2G\2I\2K\32M\2O\2Q\33S\34U\35W\2Y\2\7\2\3\4\5\6\n\4\2\f\f"+
		"\17\17\6\2\f\f\17\17\61\61^^\4\2\13\13\"\"\3\2))\3\2\62;\4\2((\60\60\7"+
		"\2%&((B\\aac|\4\2\'\'\60\60\u0179\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\3\23\3\2\2\2\3\25\3\2\2\2\3\27"+
		"\3\2\2\2\4\31\3\2\2\2\4\33\3\2\2\2\4\35\3\2\2\2\4\37\3\2\2\2\4!\3\2\2"+
		"\2\4#\3\2\2\2\4%\3\2\2\2\4\'\3\2\2\2\5)\3\2\2\2\5+\3\2\2\2\5-\3\2\2\2"+
		"\5/\3\2\2\2\5\61\3\2\2\2\5\63\3\2\2\2\5\65\3\2\2\2\5\67\3\2\2\2\59\3\2"+
		"\2\2\5;\3\2\2\2\5=\3\2\2\2\5?\3\2\2\2\5C\3\2\2\2\5K\3\2\2\2\5Q\3\2\2\2"+
		"\5S\3\2\2\2\6U\3\2\2\2\6W\3\2\2\2\6Y\3\2\2\2\7[\3\2\2\2\tl\3\2\2\2\13"+
		"|\3\2\2\2\r\u0081\3\2\2\2\17\u008f\3\2\2\2\21\u0093\3\2\2\2\23\u009b\3"+
		"\2\2\2\25\u00a2\3\2\2\2\27\u00a7\3\2\2\2\31\u00ab\3\2\2\2\33\u00ae\3\2"+
		"\2\2\35\u00b3\3\2\2\2\37\u00b7\3\2\2\2!\u00bb\3\2\2\2#\u00c3\3\2\2\2%"+
		"\u00cb\3\2\2\2\'\u00d1\3\2\2\2)\u00d5\3\2\2\2+\u00d7\3\2\2\2-\u00d9\3"+
		"\2\2\2/\u00db\3\2\2\2\61\u00de\3\2\2\2\63\u00e0\3\2\2\2\65\u00e6\3\2\2"+
		"\2\67\u00ec\3\2\2\29\u00ee\3\2\2\2;\u00f0\3\2\2\2=\u00f2\3\2\2\2?\u00fe"+
		"\3\2\2\2A\u0102\3\2\2\2C\u0115\3\2\2\2E\u0119\3\2\2\2G\u011c\3\2\2\2I"+
		"\u0121\3\2\2\2K\u0127\3\2\2\2M\u012d\3\2\2\2O\u0137\3\2\2\2Q\u0147\3\2"+
		"\2\2S\u014b\3\2\2\2U\u014d\3\2\2\2W\u015a\3\2\2\2Y\u015f\3\2\2\2[\\\7"+
		"\61\2\2\\]\7\61\2\2]^\7,\2\2^b\3\2\2\2_a\n\2\2\2`_\3\2\2\2ad\3\2\2\2b"+
		"`\3\2\2\2bc\3\2\2\2cj\3\2\2\2db\3\2\2\2eg\7\17\2\2fe\3\2\2\2fg\3\2\2\2"+
		"gh\3\2\2\2hk\7\f\2\2ik\7\2\2\3jf\3\2\2\2ji\3\2\2\2k\b\3\2\2\2lm\7\61\2"+
		"\2mn\7,\2\2nr\3\2\2\2oq\n\2\2\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2"+
		"\2sz\3\2\2\2tr\3\2\2\2uw\7\17\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2x{\7\f"+
		"\2\2y{\7\2\2\3zv\3\2\2\2zy\3\2\2\2{\n\3\2\2\2|}\7\61\2\2}~\7\61\2\2~\177"+
		"\3\2\2\2\177\u0080\b\4\2\2\u0080\f\3\2\2\2\u0081\u0085\n\3\2\2\u0082\u0084"+
		"\n\2\2\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u008d\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\7\17"+
		"\2\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008e\7\f\2\2\u008c\u008e\7\2\2\3\u008d\u0089\3\2\2\2\u008d\u008c\3\2"+
		"\2\2\u008e\16\3\2\2\2\u008f\u0090\13\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092"+
		"\b\6\3\2\u0092\20\3\2\2\2\u0093\u0097\5E!\2\u0094\u0096\5I#\2\u0095\u0094"+
		"\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\22\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c\t\4\2\2\u009b\u009a\3\2\2"+
		"\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u00a0\b\b\4\2\u00a0\u00a1\b\b\5\2\u00a1\24\3\2\2\2\u00a2"+
		"\u00a3\5M%\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\t\6\2\u00a5\u00a6\b\t\5"+
		"\2\u00a6\26\3\2\2\2\u00a7\u00a8\13\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa"+
		"\b\n\3\2\u00aa\30\3\2\2\2\u00ab\u00ac\7F\2\2\u00ac\u00ad\7F\2\2\u00ad"+
		"\32\3\2\2\2\u00ae\u00af\7G\2\2\u00af\u00b0\7Z\2\2\u00b0\u00b1\7G\2\2\u00b1"+
		"\u00b2\7E\2\2\u00b2\34\3\2\2\2\u00b3\u00b4\7L\2\2\u00b4\u00b5\7Q\2\2\u00b5"+
		"\u00b6\7D\2\2\u00b6\36\3\2\2\2\u00b7\u00b8\7U\2\2\u00b8\u00b9\7G\2\2\u00b9"+
		"\u00ba\7V\2\2\u00ba \3\2\2\2\u00bb\u00bf\5G\"\2\u00bc\u00be\5I#\2\u00bd"+
		"\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4\t\4\2\2\u00c3\u00c2"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c8\b\20\7\2\u00c8\u00c9\b\20\5\2\u00c9\u00ca\b"+
		"\20\b\2\u00ca$\3\2\2\2\u00cb\u00cc\5M%\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce"+
		"\b\21\6\2\u00ce\u00cf\b\21\t\2\u00cf\u00d0\b\21\5\2\u00d0&\3\2\2\2\u00d1"+
		"\u00d2\13\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b\22\3\2\u00d4(\3\2\2"+
		"\2\u00d5\u00d6\7*\2\2\u00d6*\3\2\2\2\u00d7\u00d8\7+\2\2\u00d8,\3\2\2\2"+
		"\u00d9\u00da\7?\2\2\u00da.\3\2\2\2\u00db\u00dc\7?\2\2\u00dc\u00dd\7\61"+
		"\2\2\u00dd\60\3\2\2\2\u00de\u00df\7,\2\2\u00df\62\3\2\2\2\u00e0\u00e1"+
		"\7.\2\2\u00e1\u00e2\5M%\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b\30\n\2\u00e4"+
		"\u00e5\b\30\13\2\u00e5\64\3\2\2\2\u00e6\u00e7\7.\2\2\u00e7\u00e8\7\"\2"+
		"\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b\31\n\2\u00ea\u00eb\b\31\13\2\u00eb"+
		"\66\3\2\2\2\u00ec\u00ed\7.\2\2\u00ed8\3\2\2\2\u00ee\u00ef\7-\2\2\u00ef"+
		":\3\2\2\2\u00f0\u00f1\7/\2\2\u00f1<\3\2\2\2\u00f2\u00f8\7)\2\2\u00f3\u00f4"+
		"\7)\2\2\u00f4\u00f7\7)\2\2\u00f5\u00f7\n\5\2\2\u00f6\u00f3\3\2\2\2\u00f6"+
		"\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7)\2\2\u00fc"+
		">\3\2\2\2\u00fd\u00ff\5A\37\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2"+
		"\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101@\3\2\2\2\u0102\u0103\t"+
		"\6\2\2\u0103B\3\2\2\2\u0104\u0108\5E!\2\u0105\u0107\5I#\2\u0106\u0105"+
		"\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u0116\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7\61\2\2\u010c\u0110\5"+
		"E!\2\u010d\u010f\5I#\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113"+
		"\u0114\7\61\2\2\u0114\u0116\3\2\2\2\u0115\u0104\3\2\2\2\u0115\u010b\3"+
		"\2\2\2\u0116D\3\2\2\2\u0117\u011a\5G\"\2\u0118\u011a\t\7\2\2\u0119\u0117"+
		"\3\2\2\2\u0119\u0118\3\2\2\2\u011aF\3\2\2\2\u011b\u011d\t\b\2\2\u011c"+
		"\u011b\3\2\2\2\u011dH\3\2\2\2\u011e\u0122\5G\"\2\u011f\u0122\5A\37\2\u0120"+
		"\u0122\t\t\2\2\u0121\u011e\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2"+
		"\2\2\u0122J\3\2\2\2\u0123\u0128\5M%\2\u0124\u0125\5Q\'\2\u0125\u0126\5"+
		"O&\2\u0126\u0128\3\2\2\2\u0127\u0123\3\2\2\2\u0127\u0124\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\b$\6\2\u012a\u012b\b$\5\2\u012bL\3\2\2\2\u012c"+
		"\u012e\5Q\'\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0134\3\2"+
		"\2\2\u012f\u0131\7\17\2\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0135\7\f\2\2\u0133\u0135\7\2\2\3\u0134\u0130\3\2"+
		"\2\2\u0134\u0133\3\2\2\2\u0135N\3\2\2\2\u0136\u0138\5Q\'\2\u0137\u0136"+
		"\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013c\3\2\2\2\u0139\u013b\n\2\2\2\u013a"+
		"\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013d\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013d\u0144\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0141\7\17\2\2\u0140"+
		"\u013f\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145\7\f"+
		"\2\2\u0143\u0145\7\2\2\3\u0144\u0140\3\2\2\2\u0144\u0143\3\2\2\2\u0145"+
		"P\3\2\2\2\u0146\u0148\t\4\2\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2"+
		"\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014aR\3\2\2\2\u014b\u014c\13"+
		"\2\2\2\u014cT\3\2\2\2\u014d\u014e\7\61\2\2\u014e\u014f\7\61\2\2\u014f"+
		"\u0151\3\2\2\2\u0150\u0152\t\4\2\2\u0151\u0150\3\2\2\2\u0152\u0153\3\2"+
		"\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0156\b)\5\2\u0156\u0157\b)\7\2\u0157V\3\2\2\2\u0158\u015b\5M%\2\u0159"+
		"\u015b\5\r\5\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\u015d\b*\5\2\u015d\u015e\b*\f\2\u015eX\3\2\2\2\u015f\u0160"+
		"\13\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\b+\3\2\u0162Z\3\2\2\2(\2\3\4"+
		"\5\6bfjrvz\u0085\u0089\u008d\u0097\u009d\u00bf\u00c5\u00f6\u00f8\u0100"+
		"\u0108\u0110\u0115\u0119\u011c\u0121\u0127\u012d\u0130\u0134\u0137\u013c"+
		"\u0140\u0144\u0149\u0153\u015a\r\4\3\2\t\34\2\4\4\2\2\3\2\4\2\2\4\5\2"+
		"\t\b\2\t\t\2\t\24\2\4\6\2\t\32\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}