// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\Test.g4 by ANTLR 4.7
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
public class TestLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LABEL=1, LEFT_PARN=2, RIGHT_PARN=3, COMMA=4, SEMIC=5, GET=6, PUT=7, NOP=8, 
		NANANA=9, ID=10, SPACE=11, ERROR=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LABEL", "LEFT_PARN", "RIGHT_PARN", "COMMA", "SEMIC", "GET", "PUT", "NOP", 
		"NANANA", "ID", "SPACE", "ERROR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'LABEL'", "'('", "')'", "','", "';'", "'GET'", "'PUT'", "'NOP'", 
		"'NANANA'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LABEL", "LEFT_PARN", "RIGHT_PARN", "COMMA", "SEMIC", "GET", "PUT", 
		"NOP", "NANANA", "ID", "SPACE", "ERROR"
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


	public TestLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Test.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16J\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\6\13>\n\13\r\13\16\13?\3\f\6\fC\n\f\r\f\16\fD\3\f\3"+
		"\f\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\3\2\4\5\2\62;C\\c|\5\2\13\f\17\17\"\"\2K\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2"+
		"\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17-\3\2\2\2"+
		"\21\61\3\2\2\2\23\65\3\2\2\2\25=\3\2\2\2\27B\3\2\2\2\31H\3\2\2\2\33\34"+
		"\7N\2\2\34\35\7C\2\2\35\36\7D\2\2\36\37\7G\2\2\37 \7N\2\2 \4\3\2\2\2!"+
		"\"\7*\2\2\"\6\3\2\2\2#$\7+\2\2$\b\3\2\2\2%&\7.\2\2&\n\3\2\2\2\'(\7=\2"+
		"\2(\f\3\2\2\2)*\7I\2\2*+\7G\2\2+,\7V\2\2,\16\3\2\2\2-.\7R\2\2./\7W\2\2"+
		"/\60\7V\2\2\60\20\3\2\2\2\61\62\7P\2\2\62\63\7Q\2\2\63\64\7R\2\2\64\22"+
		"\3\2\2\2\65\66\7P\2\2\66\67\7C\2\2\678\7P\2\289\7C\2\29:\7P\2\2:;\7C\2"+
		"\2;\24\3\2\2\2<>\t\2\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\26\3"+
		"\2\2\2AC\t\3\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\b"+
		"\f\2\2G\30\3\2\2\2HI\13\2\2\2I\32\3\2\2\2\5\2?D\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}