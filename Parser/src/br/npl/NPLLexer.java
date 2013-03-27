// Generated from C:\Users\MRE004\git\mc011\Parser\src\br\npl\NPLLexer.g4 by ANTLR 4.0

         package br.npl;
 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NPLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TEXT=1, WS=2, INTEGER=3, OPEN_CHAVE=4, FECHA_CHAVE=5, BEGIN=6, END=7, 
		NEWSPAPER=8, CONTENT=9, STRUCTURE=10, DATE=11, TITLE=12, ABSTRACT=13, 
		IMAGE=14, TEXT_TOKEN=15, AUTHOR=16, SOURCE=17, FORMAT=18, COL=19, BORDER=20, 
		ITEM=21, OPEN_BRACKET=22, FECHA_BRACKET=23, DOIS_PONTOS=24, PONTO=25, 
		NOME_NOTICIA=26, COMMENT=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"TEXT", "WS", "INTEGER", "'{'", "'}'", "'begin'", "'end'", "'newspaper'", 
		"'content'", "'structure'", "'date'", "'title'", "'abstract'", "'image'", 
		"'text'", "'author'", "'source'", "'format'", "'col:'", "'border:'", "'item'", 
		"'['", "']'", "':'", "'.'", "NOME_NOTICIA", "COMMENT"
	};
	public static final String[] ruleNames = {
		"TEXT", "EscapeSequence", "WS", "INTEGER", "LETTER", "OPEN_CHAVE", "FECHA_CHAVE", 
		"BEGIN", "END", "NEWSPAPER", "CONTENT", "STRUCTURE", "DATE", "TITLE", 
		"ABSTRACT", "IMAGE", "TEXT_TOKEN", "AUTHOR", "SOURCE", "FORMAT", "COL", 
		"BORDER", "ITEM", "OPEN_BRACKET", "FECHA_BRACKET", "DOIS_PONTOS", "PONTO", 
		"NOME_NOTICIA", "COMMENT"
	};


	public NPLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NPLLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: TEXT_action((RuleContext)_localctx, actionIndex); break;

		case 2: WS_action((RuleContext)_localctx, actionIndex); break;

		case 28: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: setText(getText().substring(1, getText().length()-1)); break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\35\u00f5\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\3\2\3\2\3\2\7\2A\n\2\f\2\16\2D\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\6\4M\n\4\r\4\16\4N\3\4\3\4\3\5\6\5T\n\5\r\5\16\5U\3\6\6\6Y\n\6\r\6\16"+
		"\6Z\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00d9\n\35\f\35\16\35\u00dc\13"+
		"\35\3\36\3\36\3\36\3\36\7\36\u00e2\n\36\f\36\16\36\u00e5\13\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\7\36\u00ed\n\36\f\36\16\36\u00f0\13\36\5\36\u00f2"+
		"\n\36\3\36\3\36\3\u00e3\37\3\3\2\5\2\1\7\4\3\t\5\1\13\2\1\r\6\1\17\7\1"+
		"\21\b\1\23\t\1\25\n\1\27\13\1\31\f\1\33\r\1\35\16\1\37\17\1!\20\1#\21"+
		"\1%\22\1\'\23\1)\24\1+\25\1-\26\1/\27\1\61\30\1\63\31\1\65\32\1\67\33"+
		"\19\34\1;\35\4\3\2\7\4$$^^\5\13\f\16\17\"\"\3\62;\4C\\c|\4\f\f\17\17\u00fd"+
		"\2\3\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5H\3\2\2"+
		"\2\7L\3\2\2\2\tS\3\2\2\2\13X\3\2\2\2\r\\\3\2\2\2\17^\3\2\2\2\21`\3\2\2"+
		"\2\23f\3\2\2\2\25j\3\2\2\2\27t\3\2\2\2\31|\3\2\2\2\33\u0086\3\2\2\2\35"+
		"\u008b\3\2\2\2\37\u0091\3\2\2\2!\u009a\3\2\2\2#\u00a0\3\2\2\2%\u00a5\3"+
		"\2\2\2\'\u00ac\3\2\2\2)\u00b3\3\2\2\2+\u00ba\3\2\2\2-\u00bf\3\2\2\2/\u00c7"+
		"\3\2\2\2\61\u00cc\3\2\2\2\63\u00ce\3\2\2\2\65\u00d0\3\2\2\2\67\u00d2\3"+
		"\2\2\29\u00d4\3\2\2\2;\u00f1\3\2\2\2=B\7$\2\2>A\5\5\3\2?A\n\2\2\2@>\3"+
		"\2\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7"+
		"$\2\2FG\b\2\2\2G\4\3\2\2\2HI\7^\2\2IJ\7$\2\2J\6\3\2\2\2KM\t\3\2\2LK\3"+
		"\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2\2\2PQ\b\4\3\2Q\b\3\2\2\2RT"+
		"\t\4\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\n\3\2\2\2WY\t\5\2\2"+
		"XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\f\3\2\2\2\\]\7}\2\2]\16\3\2"+
		"\2\2^_\7\177\2\2_\20\3\2\2\2`a\7d\2\2ab\7g\2\2bc\7i\2\2cd\7k\2\2de\7p"+
		"\2\2e\22\3\2\2\2fg\7g\2\2gh\7p\2\2hi\7f\2\2i\24\3\2\2\2jk\7p\2\2kl\7g"+
		"\2\2lm\7y\2\2mn\7u\2\2no\7r\2\2op\7c\2\2pq\7r\2\2qr\7g\2\2rs\7t\2\2s\26"+
		"\3\2\2\2tu\7e\2\2uv\7q\2\2vw\7p\2\2wx\7v\2\2xy\7g\2\2yz\7p\2\2z{\7v\2"+
		"\2{\30\3\2\2\2|}\7u\2\2}~\7v\2\2~\177\7t\2\2\177\u0080\7w\2\2\u0080\u0081"+
		"\7e\2\2\u0081\u0082\7v\2\2\u0082\u0083\7w\2\2\u0083\u0084\7t\2\2\u0084"+
		"\u0085\7g\2\2\u0085\32\3\2\2\2\u0086\u0087\7f\2\2\u0087\u0088\7c\2\2\u0088"+
		"\u0089\7v\2\2\u0089\u008a\7g\2\2\u008a\34\3\2\2\2\u008b\u008c\7v\2\2\u008c"+
		"\u008d\7k\2\2\u008d\u008e\7v\2\2\u008e\u008f\7n\2\2\u008f\u0090\7g\2\2"+
		"\u0090\36\3\2\2\2\u0091\u0092\7c\2\2\u0092\u0093\7d\2\2\u0093\u0094\7"+
		"u\2\2\u0094\u0095\7v\2\2\u0095\u0096\7t\2\2\u0096\u0097\7c\2\2\u0097\u0098"+
		"\7e\2\2\u0098\u0099\7v\2\2\u0099 \3\2\2\2\u009a\u009b\7k\2\2\u009b\u009c"+
		"\7o\2\2\u009c\u009d\7c\2\2\u009d\u009e\7i\2\2\u009e\u009f\7g\2\2\u009f"+
		"\"\3\2\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7z\2\2\u00a3"+
		"\u00a4\7v\2\2\u00a4$\3\2\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7w\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7t\2\2"+
		"\u00ab&\3\2\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7w\2"+
		"\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7e\2\2\u00b1\u00b2\7g\2\2\u00b2(\3\2"+
		"\2\2\u00b3\u00b4\7h\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7"+
		"\7o\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7v\2\2\u00b9*\3\2\2\2\u00ba\u00bb"+
		"\7e\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7<\2\2\u00be"+
		",\3\2\2\2\u00bf\u00c0\7d\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7t\2\2\u00c2"+
		"\u00c3\7f\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7<\2\2"+
		"\u00c6.\3\2\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca\7g\2"+
		"\2\u00ca\u00cb\7o\2\2\u00cb\60\3\2\2\2\u00cc\u00cd\7]\2\2\u00cd\62\3\2"+
		"\2\2\u00ce\u00cf\7_\2\2\u00cf\64\3\2\2\2\u00d0\u00d1\7<\2\2\u00d1\66\3"+
		"\2\2\2\u00d2\u00d3\7\60\2\2\u00d38\3\2\2\2\u00d4\u00da\5\13\6\2\u00d5"+
		"\u00d9\5\13\6\2\u00d6\u00d9\5\t\5\2\u00d7\u00d9\7a\2\2\u00d8\u00d5\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db:\3\2\2\2\u00dc\u00da\3\2\2\2"+
		"\u00dd\u00de\7\61\2\2\u00de\u00df\7,\2\2\u00df\u00e3\3\2\2\2\u00e0\u00e2"+
		"\13\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e4\3\2\2\2"+
		"\u00e3\u00e1\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7"+
		"\7,\2\2\u00e7\u00f2\7\61\2\2\u00e8\u00e9\7\61\2\2\u00e9\u00ea\7\61\2\2"+
		"\u00ea\u00ee\3\2\2\2\u00eb\u00ed\n\6\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00dd\3\2\2\2\u00f1\u00e8\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00f4\b\36\4\2\u00f4<\3\2\2\2\r\2@BNUZ\u00d8\u00da\u00e3\u00ee"+
		"\u00f1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}