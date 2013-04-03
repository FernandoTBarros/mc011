// Generated from C:\Users\MRE004\git\mc011\Parser\src\NPLLexer.g4 by ANTLR 4.0

         //package br.npl;
 
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
		TEXT_FORMATADO=1, TEXT=2, WS=3, INTEGER=4, OPEN_CHAVE=5, FECHA_CHAVE=6, 
		BEGIN=7, END=8, NEWSPAPER=9, CONTENT=10, STRUCTURE=11, DATE=12, TITLE=13, 
		ABSTRACT=14, IMAGE=15, TEXT_TOKEN=16, AUTHOR=17, SOURCE=18, FORMAT=19, 
		COL=20, BORDER=21, ITEM=22, TITLE_SLIDE=23, OPEN_BRACKET=24, FECHA_BRACKET=25, 
		DOIS_PONTOS=26, PONTO=27, NOME_NOTICIA=28, COMMENT=29, ESCAPE=30, ENDTEXT=31, 
		SECAO_H2=32, SECAO_H3=33, STRING=34;
	public static final int FORMAT_TEXT = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "FORMAT_TEXT"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\"'", "TEXT", "WS", "INTEGER", "'{'", "'}'", "'begin'", "'end'", "'newspaper'", 
		"'content'", "'structure'", "'date'", "'title'", "'abstract'", "'image'", 
		"'text'", "'author'", "'source'", "'format'", "'col:'", "'border:'", "'item'", 
		"'titleslide'", "'['", "']'", "':'", "'.'", "NOME_NOTICIA", "COMMENT", 
		"'\\\"'", "'\"'", "SECAO_H2", "SECAO_H3", "STRING"
	};
	public static final String[] ruleNames = {
		"TEXT_FORMATADO", "TEXT", "EscapeSequence", "WS", "INTEGER", "LETTER", 
		"OPEN_CHAVE", "FECHA_CHAVE", "BEGIN", "END", "NEWSPAPER", "CONTENT", "STRUCTURE", 
		"DATE", "TITLE", "ABSTRACT", "IMAGE", "TEXT_TOKEN", "AUTHOR", "SOURCE", 
		"FORMAT", "COL", "BORDER", "ITEM", "TITLE_SLIDE", "OPEN_BRACKET", "FECHA_BRACKET", 
		"DOIS_PONTOS", "PONTO", "NOME_NOTICIA", "COMMENT", "ESCAPE", "ENDTEXT", 
		"SECAO_H2", "SECAO_H3", "STRING"
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
		case 0: TEXT_FORMATADO_action((RuleContext)_localctx, actionIndex); break;

		case 1: TEXT_action((RuleContext)_localctx, actionIndex); break;

		case 3: WS_action((RuleContext)_localctx, actionIndex); break;

		case 30: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 31: ESCAPE_action((RuleContext)_localctx, actionIndex); break;

		case 32: ENDTEXT_action((RuleContext)_localctx, actionIndex); break;

		case 33: SECAO_H2_action((RuleContext)_localctx, actionIndex); break;

		case 34: SECAO_H3_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: skip();  break;
		}
	}
	private void ESCAPE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: setText("\""); break;
		}
	}
	private void TEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: setText(getText().substring(1, getText().length()-1).replace("\\", "")); break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: skip();  break;
		}
	}
	private void SECAO_H3_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: setText("<h3>" + getText() + "</h3>"); break;
		}
	}
	private void TEXT_FORMATADO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: pushMode(FORMAT_TEXT);  break;
		}
	}
	private void SECAO_H2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: setText("<h2>" + getText() + "</h2>"); break;
		}
	}
	private void ENDTEXT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: popMode();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4$\u013f\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4"+
		"\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4"+
		"\20\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4"+
		"\27\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4"+
		"\36\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\7\3T\n\3\f\3\16\3W\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\6\5"+
		"`\n\5\r\5\16\5a\3\5\3\5\3\6\6\6g\n\6\r\6\16\6h\3\7\6\7l\n\7\r\7\16\7m"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\7\37\u00f7\n\37\f\37\16\37\u00fa\13\37\3 \3 \3 \3 "+
		"\7 \u0100\n \f \16 \u0103\13 \3 \3 \3 \3 \3 \3 \7 \u010b\n \f \16 \u010e"+
		"\13 \5 \u0110\n \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u0121"+
		"\n#\f#\16#\u0124\13#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\7$\u0130\n$\f$\16$"+
		"\u0133\13$\3$\3$\3$\3$\3$\3$\3%\6%\u013c\n%\r%\16%\u013d\4\u0101\u013d"+
		"&\4\3\6\6\4\2\b\2\1\n\5\7\f\6\1\16\2\1\20\7\1\22\b\1\24\t\1\26\n\1\30"+
		"\13\1\32\f\1\34\r\1\36\16\1 \17\1\"\20\1$\21\1&\22\1(\23\1*\24\1,\25\1"+
		".\26\1\60\27\1\62\30\1\64\31\1\66\32\18\33\1:\34\1<\35\1>\36\1@\37\bB"+
		" \3D!\tF\"\4H#\5J$\1\4\2\3\t\4$$^^\5\13\f\16\17\"\"\3\62;\4C\\c|\4\f\f"+
		"\17\17\3??\3??\u0149\2\4\3\2\2\2\2\6\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2"+
		"\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3"+
		"\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&"+
		"\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62"+
		"\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2"+
		">\3\2\2\2\2@\3\2\2\2\3B\3\2\2\2\3D\3\2\2\2\3F\3\2\2\2\3H\3\2\2\2\3J\3"+
		"\2\2\2\4L\3\2\2\2\6P\3\2\2\2\b[\3\2\2\2\n_\3\2\2\2\ff\3\2\2\2\16k\3\2"+
		"\2\2\20o\3\2\2\2\22q\3\2\2\2\24s\3\2\2\2\26y\3\2\2\2\30}\3\2\2\2\32\u0087"+
		"\3\2\2\2\34\u008f\3\2\2\2\36\u0099\3\2\2\2 \u009e\3\2\2\2\"\u00a4\3\2"+
		"\2\2$\u00ad\3\2\2\2&\u00b3\3\2\2\2(\u00b8\3\2\2\2*\u00bf\3\2\2\2,\u00c6"+
		"\3\2\2\2.\u00cd\3\2\2\2\60\u00d2\3\2\2\2\62\u00da\3\2\2\2\64\u00df\3\2"+
		"\2\2\66\u00ea\3\2\2\28\u00ec\3\2\2\2:\u00ee\3\2\2\2<\u00f0\3\2\2\2>\u00f2"+
		"\3\2\2\2@\u010f\3\2\2\2B\u0113\3\2\2\2D\u0118\3\2\2\2F\u011c\3\2\2\2H"+
		"\u012a\3\2\2\2J\u013b\3\2\2\2LM\7$\2\2MN\3\2\2\2NO\b\2\6\2O\5\3\2\2\2"+
		"PU\7$\2\2QT\5\b\4\2RT\n\2\2\2SQ\3\2\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2"+
		"UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7$\2\2YZ\b\3\2\2Z\7\3\2\2\2[\\\7^\2\2"+
		"\\]\7$\2\2]\t\3\2\2\2^`\t\3\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2"+
		"\2bc\3\2\2\2cd\b\5\7\2d\13\3\2\2\2eg\t\4\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2"+
		"\2\2hi\3\2\2\2i\r\3\2\2\2jl\t\5\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3"+
		"\2\2\2n\17\3\2\2\2op\7}\2\2p\21\3\2\2\2qr\7\177\2\2r\23\3\2\2\2st\7d\2"+
		"\2tu\7g\2\2uv\7i\2\2vw\7k\2\2wx\7p\2\2x\25\3\2\2\2yz\7g\2\2z{\7p\2\2{"+
		"|\7f\2\2|\27\3\2\2\2}~\7p\2\2~\177\7g\2\2\177\u0080\7y\2\2\u0080\u0081"+
		"\7u\2\2\u0081\u0082\7r\2\2\u0082\u0083\7c\2\2\u0083\u0084\7r\2\2\u0084"+
		"\u0085\7g\2\2\u0085\u0086\7t\2\2\u0086\31\3\2\2\2\u0087\u0088\7e\2\2\u0088"+
		"\u0089\7q\2\2\u0089\u008a\7p\2\2\u008a\u008b\7v\2\2\u008b\u008c\7g\2\2"+
		"\u008c\u008d\7p\2\2\u008d\u008e\7v\2\2\u008e\33\3\2\2\2\u008f\u0090\7"+
		"u\2\2\u0090\u0091\7v\2\2\u0091\u0092\7t\2\2\u0092\u0093\7w\2\2\u0093\u0094"+
		"\7e\2\2\u0094\u0095\7v\2\2\u0095\u0096\7w\2\2\u0096\u0097\7t\2\2\u0097"+
		"\u0098\7g\2\2\u0098\35\3\2\2\2\u0099\u009a\7f\2\2\u009a\u009b\7c\2\2\u009b"+
		"\u009c\7v\2\2\u009c\u009d\7g\2\2\u009d\37\3\2\2\2\u009e\u009f\7v\2\2\u009f"+
		"\u00a0\7k\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7g\2\2"+
		"\u00a3!\3\2\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7d\2\2\u00a6\u00a7\7u\2"+
		"\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab"+
		"\7e\2\2\u00ab\u00ac\7v\2\2\u00ac#\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af"+
		"\7o\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7i\2\2\u00b1\u00b2\7g\2\2\u00b2"+
		"%\3\2\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7z\2\2\u00b6"+
		"\u00b7\7v\2\2\u00b7\'\3\2\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7w\2\2\u00ba"+
		"\u00bb\7v\2\2\u00bb\u00bc\7j\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7t\2\2"+
		"\u00be)\3\2\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7w\2"+
		"\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5\7g\2\2\u00c5+\3\2"+
		"\2\2\u00c6\u00c7\7h\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca"+
		"\7o\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7v\2\2\u00cc-\3\2\2\2\u00cd\u00ce"+
		"\7e\2\2\u00ce\u00cf\7q\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7<\2\2\u00d1"+
		"/\3\2\2\2\u00d2\u00d3\7d\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7t\2\2\u00d5"+
		"\u00d6\7f\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7<\2\2"+
		"\u00d9\61\3\2\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7"+
		"g\2\2\u00dd\u00de\7o\2\2\u00de\63\3\2\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1"+
		"\7k\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7g\2\2\u00e4"+
		"\u00e5\7u\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7f\2\2"+
		"\u00e8\u00e9\7g\2\2\u00e9\65\3\2\2\2\u00ea\u00eb\7]\2\2\u00eb\67\3\2\2"+
		"\2\u00ec\u00ed\7_\2\2\u00ed9\3\2\2\2\u00ee\u00ef\7<\2\2\u00ef;\3\2\2\2"+
		"\u00f0\u00f1\7\60\2\2\u00f1=\3\2\2\2\u00f2\u00f8\5\16\7\2\u00f3\u00f7"+
		"\5\16\7\2\u00f4\u00f7\5\f\6\2\u00f5\u00f7\7a\2\2\u00f6\u00f3\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9?\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc"+
		"\7\61\2\2\u00fc\u00fd\7,\2\2\u00fd\u0101\3\2\2\2\u00fe\u0100\13\2\2\2"+
		"\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u0102\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7,\2\2\u0105"+
		"\u0110\7\61\2\2\u0106\u0107\7\61\2\2\u0107\u0108\7\61\2\2\u0108\u010c"+
		"\3\2\2\2\u0109\u010b\n\6\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2"+
		"\2\2\u010f\u00fb\3\2\2\2\u010f\u0106\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\b \b\2\u0112A\3\2\2\2\u0113\u0114\7^\2\2\u0114\u0115\7$\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\b!\3\2\u0117C\3\2\2\2\u0118\u0119\7$\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011b\b\"\t\2\u011bE\3\2\2\2\u011c\u011d\7?\2\2\u011d"+
		"\u011e\7?\2\2\u011e\u0122\3\2\2\2\u011f\u0121\n\7\2\2\u0120\u011f\3\2"+
		"\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7?\2\2\u0126\u0127\7?\2"+
		"\2\u0127\u0128\3\2\2\2\u0128\u0129\b#\4\2\u0129G\3\2\2\2\u012a\u012b\7"+
		"?\2\2\u012b\u012c\7?\2\2\u012c\u012d\7?\2\2\u012d\u0131\3\2\2\2\u012e"+
		"\u0130\n\b\2\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134"+
		"\u0135\7?\2\2\u0135\u0136\7?\2\2\u0136\u0137\7?\2\2\u0137\u0138\3\2\2"+
		"\2\u0138\u0139\b$\5\2\u0139I\3\2\2\2\u013a\u013c\13\2\2\2\u013b\u013a"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e"+
		"K\3\2\2\2\21\2\3SUahm\u00f6\u00f8\u0101\u010c\u010f\u0122\u0131\u013d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}