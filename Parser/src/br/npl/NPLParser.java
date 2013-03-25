// Generated from C:\Users\MRE004\Google Drive\Unicamp\mc011\Parser\src\br\npl\NPLParser.g4 by ANTLR 4.0

    package br.npl;
    
    import java.util.HashMap;
    import java.lang.StringBuffer;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NPLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=3, AUTHOR=16, NEWSPAPER=8, ITEM=21, FECHA_BRACKET=23, DOIS_PONTOS=24, 
		SOURCE=17, PONTO=25, ABSTRACT=13, CONTENT=9, TEXT_TOKEN=15, TEXT=1, STRUCTURE=10, 
		BORDER=20, OPEN_BRACKET=22, WS=2, NOME_NOTICIA=26, FECHA_CHAVE=5, IMAGE=14, 
		OPEN_CHAVE=4, BEGIN=6, COL=19, FORMAT=18, COMMENT=27, DATE=11, END=7, 
		TITLE=12;
	public static final String[] tokenNames = {
		"<INVALID>", "TEXT", "WS", "INTEGER", "'{'", "'}'", "'begin'", "'end'", 
		"'newspaper'", "'content'", "'structure'", "'date'", "'title'", "'abstract'", 
		"'image'", "'text'", "'author'", "'source'", "'format'", "'col:'", "'border:'", 
		"'item'", "'['", "']'", "':'", "'.'", "NOME_NOTICIA", "COMMENT"
	};
	public static final int
		RULE_run = 0, RULE_begin = 1, RULE_content = 2, RULE_newspaper = 3, RULE_noticia = 4, 
		RULE_structure = 5, RULE_format = 6, RULE_item = 7;
	public static final String[] ruleNames = {
		"run", "begin", "content", "newspaper", "noticia", "structure", "format", 
		"item"
	};

	@Override
	public String getGrammarFileName() { return "NPLParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	          class Noticia { 
	                         public String nome;
	                         public String titulo;
	                         public String resumo;
	                         public String texto;
	                         public String imagem;
	                         public String fonte;
	                         public String autor;
	                         }
		/** Map variable name to Integer object holding value */
		HashMap<String,Noticia> noticias = new HashMap<String,Noticia>();
	        
	        StringBuffer html = new StringBuffer();

	public NPLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RunContext extends ParserRuleContext {
		public String result;
		public List<TerminalNode> WS() { return getTokens(NPLParser.WS); }
		public List<TerminalNode> COMMENT() { return getTokens(NPLParser.COMMENT); }
		public TerminalNode END() { return getToken(NPLParser.END, 0); }
		public TerminalNode WS(int i) {
			return getToken(NPLParser.WS, i);
		}
		public TerminalNode COMMENT(int i) {
			return getToken(NPLParser.COMMENT, i);
		}
		public BeginContext begin() {
			return getRuleContext(BeginContext.class,0);
		}
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_run);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS || _la==COMMENT) {
				{
				{
				setState(16);
				_la = _input.LA(1);
				if ( !(_la==WS || _la==COMMENT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22); begin();
			setState(23); match(END);

			                                        html.append("</body>\n"); 
			                                        html.append("</html>\n");
			                                        ((RunContext)_localctx).result =  html.toString(); 
			                                        
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

	public static class BeginContext extends ParserRuleContext {
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(NPLParser.BEGIN, 0); }
		public BeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin; }
	}

	public final BeginContext begin() throws RecognitionException {
		BeginContext _localctx = new BeginContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_begin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); match(BEGIN);
			 html.append("<html>\n"); 
			setState(28); content();
			setState(29); structure();
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

	public static class ContentContext extends ParserRuleContext {
		public NewspaperContext newspaper;
		public NoticiaContext noticia(int i) {
			return getRuleContext(NoticiaContext.class,i);
		}
		public List<NoticiaContext> noticia() {
			return getRuleContexts(NoticiaContext.class);
		}
		public TerminalNode CONTENT() { return getToken(NPLParser.CONTENT, 0); }
		public TerminalNode FECHA_CHAVE() { return getToken(NPLParser.FECHA_CHAVE, 0); }
		public TerminalNode OPEN_CHAVE() { return getToken(NPLParser.OPEN_CHAVE, 0); }
		public NewspaperContext newspaper() {
			return getRuleContext(NewspaperContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(CONTENT);
			setState(32); match(OPEN_CHAVE);
			setState(33); ((ContentContext)_localctx).newspaper = newspaper();
			 
			                                        html.append("<body>\n");
			                                        html.append("<div id=\"container\">\n");
			                                        html.append("<div id=\"header\">\n");
			                                        html.append("<h1>" + ((ContentContext)_localctx).newspaper.titulo + "</h1>\n");
			                                        html.append("<h2>" + ((ContentContext)_localctx).newspaper.data + "</h2>\n");
			                                        html.append("</div>\n");
			                                        html.append("<div id=\"linkbar\"></div>");
			                                        
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOME_NOTICIA) {
				{
				{
				setState(35); noticia();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41); match(FECHA_CHAVE);
			 
			                                        html.append("</div>\n"); 
			                                        html.append("</div>\n");
			                                        
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

	public static class NewspaperContext extends ParserRuleContext {
		public String titulo;
		public String data;
		public Token TEXT;
		public TerminalNode NEWSPAPER() { return getToken(NPLParser.NEWSPAPER, 0); }
		public TerminalNode TEXT(int i) {
			return getToken(NPLParser.TEXT, i);
		}
		public TerminalNode DOIS_PONTOS(int i) {
			return getToken(NPLParser.DOIS_PONTOS, i);
		}
		public TerminalNode FECHA_CHAVE() { return getToken(NPLParser.FECHA_CHAVE, 0); }
		public List<TerminalNode> TEXT() { return getTokens(NPLParser.TEXT); }
		public TerminalNode DATE() { return getToken(NPLParser.DATE, 0); }
		public TerminalNode OPEN_CHAVE() { return getToken(NPLParser.OPEN_CHAVE, 0); }
		public List<TerminalNode> DOIS_PONTOS() { return getTokens(NPLParser.DOIS_PONTOS); }
		public TerminalNode TITLE() { return getToken(NPLParser.TITLE, 0); }
		public NewspaperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newspaper; }
	}

	public final NewspaperContext newspaper() throws RecognitionException {
		NewspaperContext _localctx = new NewspaperContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_newspaper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(NEWSPAPER);
			setState(45); match(OPEN_CHAVE);

			                                         html.append("<head>\n" + "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" /> \n"); 
			                                         html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/> \n");
			                                         
			setState(47); match(TITLE);
			setState(48); match(DOIS_PONTOS);
			setState(49); ((NewspaperContext)_localctx).TEXT = match(TEXT);
			((NewspaperContext)_localctx).titulo =  (((NewspaperContext)_localctx).TEXT!=null?((NewspaperContext)_localctx).TEXT.getText():null); html.append("<title>" + _localctx.titulo + "</title>"); 
			setState(54);
			_la = _input.LA(1);
			if (_la==DATE) {
				{
				setState(51); match(DATE);
				setState(52); match(DOIS_PONTOS);
				setState(53); ((NewspaperContext)_localctx).TEXT = match(TEXT);
				}
			}

			((NewspaperContext)_localctx).data =  (((NewspaperContext)_localctx).TEXT!=null?((NewspaperContext)_localctx).TEXT.getText():null); 
			setState(57); match(FECHA_CHAVE);
			html.append("</head>\n"); 
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

	public static class NoticiaContext extends ParserRuleContext {
		public Noticia instance;
		public Token nomeT;
		public Token tituloT;
		public Token resumoT;
		public Token imagemT;
		public Token fonteT;
		public Token autorT;
		public Token textoT;
		public List<TerminalNode> AUTHOR() { return getTokens(NPLParser.AUTHOR); }
		public TerminalNode ABSTRACT(int i) {
			return getToken(NPLParser.ABSTRACT, i);
		}
		public TerminalNode TEXT(int i) {
			return getToken(NPLParser.TEXT, i);
		}
		public TerminalNode NOME_NOTICIA() { return getToken(NPLParser.NOME_NOTICIA, 0); }
		public TerminalNode FECHA_CHAVE() { return getToken(NPLParser.FECHA_CHAVE, 0); }
		public TerminalNode IMAGE(int i) {
			return getToken(NPLParser.IMAGE, i);
		}
		public List<TerminalNode> IMAGE() { return getTokens(NPLParser.IMAGE); }
		public TerminalNode OPEN_CHAVE() { return getToken(NPLParser.OPEN_CHAVE, 0); }
		public List<TerminalNode> DOIS_PONTOS() { return getTokens(NPLParser.DOIS_PONTOS); }
		public TerminalNode TITLE(int i) {
			return getToken(NPLParser.TITLE, i);
		}
		public TerminalNode SOURCE(int i) {
			return getToken(NPLParser.SOURCE, i);
		}
		public TerminalNode TEXT_TOKEN(int i) {
			return getToken(NPLParser.TEXT_TOKEN, i);
		}
		public List<TerminalNode> SOURCE() { return getTokens(NPLParser.SOURCE); }
		public TerminalNode AUTHOR(int i) {
			return getToken(NPLParser.AUTHOR, i);
		}
		public TerminalNode DOIS_PONTOS(int i) {
			return getToken(NPLParser.DOIS_PONTOS, i);
		}
		public List<TerminalNode> ABSTRACT() { return getTokens(NPLParser.ABSTRACT); }
		public List<TerminalNode> TEXT_TOKEN() { return getTokens(NPLParser.TEXT_TOKEN); }
		public List<TerminalNode> TEXT() { return getTokens(NPLParser.TEXT); }
		public List<TerminalNode> TITLE() { return getTokens(NPLParser.TITLE); }
		public NoticiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noticia; }
	}

	public final NoticiaContext noticia() throws RecognitionException {
		NoticiaContext _localctx = new NoticiaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_noticia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			Noticia item = new Noticia(); 
			setState(61); ((NoticiaContext)_localctx).nomeT = match(NOME_NOTICIA);
			setState(62); match(OPEN_CHAVE);
			item.nome = (((NoticiaContext)_localctx).nomeT!=null?((NoticiaContext)_localctx).nomeT.getText():null);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TITLE) | (1L << ABSTRACT) | (1L << IMAGE) | (1L << TEXT_TOKEN) | (1L << AUTHOR) | (1L << SOURCE))) != 0)) {
				{
				setState(89);
				switch (_input.LA(1)) {
				case TITLE:
					{
					{
					setState(64); match(TITLE);
					setState(65); match(DOIS_PONTOS);
					setState(66); ((NoticiaContext)_localctx).tituloT = match(TEXT);
					}
					}
					break;
				case ABSTRACT:
					{
					item.titulo = (((NoticiaContext)_localctx).tituloT!=null?((NoticiaContext)_localctx).tituloT.getText():null);
					{
					setState(68); match(ABSTRACT);
					setState(69); match(DOIS_PONTOS);
					setState(70); ((NoticiaContext)_localctx).resumoT = match(TEXT);
					}
					}
					break;
				case IMAGE:
					{
					item.resumo = (((NoticiaContext)_localctx).resumoT!=null?((NoticiaContext)_localctx).resumoT.getText():null);
					{
					setState(72); match(IMAGE);
					setState(73); match(DOIS_PONTOS);
					setState(74); ((NoticiaContext)_localctx).imagemT = match(TEXT);
					}
					}
					break;
				case SOURCE:
					{
					item.imagem = (((NoticiaContext)_localctx).imagemT!=null?((NoticiaContext)_localctx).imagemT.getText():null);
					{
					setState(76); match(SOURCE);
					setState(77); match(DOIS_PONTOS);
					setState(78); ((NoticiaContext)_localctx).fonteT = match(TEXT);
					}
					}
					break;
				case AUTHOR:
					{
					item.fonte = (((NoticiaContext)_localctx).fonteT!=null?((NoticiaContext)_localctx).fonteT.getText():null);
					{
					setState(80); match(AUTHOR);
					setState(81); match(DOIS_PONTOS);
					setState(82); ((NoticiaContext)_localctx).autorT = match(TEXT);
					}
					}
					break;
				case TEXT_TOKEN:
					{
					item.autor = (((NoticiaContext)_localctx).autorT!=null?((NoticiaContext)_localctx).autorT.getText():null);
					{
					setState(84); match(TEXT_TOKEN);
					setState(85); match(DOIS_PONTOS);
					setState(86); ((NoticiaContext)_localctx).textoT = match(TEXT);
					}
					item.texto = (((NoticiaContext)_localctx).textoT!=null?((NoticiaContext)_localctx).textoT.getText():null);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94); match(FECHA_CHAVE);

			                                                                noticias.put(item.nome, item); 
			                                                                ((NoticiaContext)_localctx).instance =  item;
			                                                                
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

	public static class StructureContext extends ParserRuleContext {
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public TerminalNode FECHA_CHAVE() { return getToken(NPLParser.FECHA_CHAVE, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public TerminalNode OPEN_CHAVE() { return getToken(NPLParser.OPEN_CHAVE, 0); }
		public TerminalNode STRUCTURE() { return getToken(NPLParser.STRUCTURE, 0); }
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(STRUCTURE);
			setState(98); match(OPEN_CHAVE);
			setState(99); format();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITEM) {
				{
				{
				setState(100); item();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106); match(FECHA_CHAVE);
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

	public static class FormatContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(NPLParser.INTEGER); }
		public TerminalNode FECHA_CHAVE() { return getToken(NPLParser.FECHA_CHAVE, 0); }
		public TerminalNode FORMAT() { return getToken(NPLParser.FORMAT, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(NPLParser.INTEGER, i);
		}
		public TerminalNode OPEN_CHAVE() { return getToken(NPLParser.OPEN_CHAVE, 0); }
		public TerminalNode COL() { return getToken(NPLParser.COL, 0); }
		public TerminalNode BORDER() { return getToken(NPLParser.BORDER, 0); }
		public FormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format; }
	}

	public final FormatContext format() throws RecognitionException {
		FormatContext _localctx = new FormatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_format);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(FORMAT);
			setState(109); match(OPEN_CHAVE);
			setState(110); match(COL);
			setState(111); match(INTEGER);
			setState(112); match(BORDER);
			setState(113); match(INTEGER);
			setState(114); match(FECHA_CHAVE);
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

	public static class ItemContext extends ParserRuleContext {
		public Token key;
		public List<TerminalNode> AUTHOR() { return getTokens(NPLParser.AUTHOR); }
		public TerminalNode ABSTRACT(int i) {
			return getToken(NPLParser.ABSTRACT, i);
		}
		public List<TerminalNode> INTEGER() { return getTokens(NPLParser.INTEGER); }
		public TerminalNode OPEN_BRACKET() { return getToken(NPLParser.OPEN_BRACKET, 0); }
		public TerminalNode NOME_NOTICIA(int i) {
			return getToken(NPLParser.NOME_NOTICIA, i);
		}
		public List<TerminalNode> NOME_NOTICIA() { return getTokens(NPLParser.NOME_NOTICIA); }
		public TerminalNode FECHA_CHAVE() { return getToken(NPLParser.FECHA_CHAVE, 0); }
		public TerminalNode IMAGE(int i) {
			return getToken(NPLParser.IMAGE, i);
		}
		public TerminalNode ITEM() { return getToken(NPLParser.ITEM, 0); }
		public List<TerminalNode> IMAGE() { return getTokens(NPLParser.IMAGE); }
		public TerminalNode FECHA_BRACKET() { return getToken(NPLParser.FECHA_BRACKET, 0); }
		public TerminalNode OPEN_CHAVE() { return getToken(NPLParser.OPEN_CHAVE, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(NPLParser.DOIS_PONTOS, 0); }
		public TerminalNode TITLE(int i) {
			return getToken(NPLParser.TITLE, i);
		}
		public TerminalNode SOURCE(int i) {
			return getToken(NPLParser.SOURCE, i);
		}
		public TerminalNode TEXT_TOKEN(int i) {
			return getToken(NPLParser.TEXT_TOKEN, i);
		}
		public List<TerminalNode> SOURCE() { return getTokens(NPLParser.SOURCE); }
		public List<TerminalNode> PONTO() { return getTokens(NPLParser.PONTO); }
		public TerminalNode AUTHOR(int i) {
			return getToken(NPLParser.AUTHOR, i);
		}
		public List<TerminalNode> ABSTRACT() { return getTokens(NPLParser.ABSTRACT); }
		public List<TerminalNode> TEXT_TOKEN() { return getTokens(NPLParser.TEXT_TOKEN); }
		public TerminalNode PONTO(int i) {
			return getToken(NPLParser.PONTO, i);
		}
		public TerminalNode INTEGER(int i) {
			return getToken(NPLParser.INTEGER, i);
		}
		public List<TerminalNode> TITLE() { return getTokens(NPLParser.TITLE); }
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(ITEM);
			setState(117); match(OPEN_BRACKET);
			setState(118); match(INTEGER);
			setState(121);
			_la = _input.LA(1);
			if (_la==DOIS_PONTOS) {
				{
				setState(119); match(DOIS_PONTOS);
				setState(120); match(INTEGER);
				}
			}

			setState(123); match(FECHA_BRACKET);
			setState(124); match(OPEN_CHAVE);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOME_NOTICIA) {
				{
				{
				setState(125); ((ItemContext)_localctx).key = match(NOME_NOTICIA);
				 Noticia noticia = noticias.get((((ItemContext)_localctx).key!=null?((ItemContext)_localctx).key.getText():null)); 
				setState(127); match(PONTO);
				setState(134);
				switch (_input.LA(1)) {
				case TITLE:
					{
					{
					setState(128); match(TITLE);
					}
					}
					break;
				case ABSTRACT:
					{
					{
					setState(129); match(ABSTRACT);
					}
					}
					break;
				case IMAGE:
					{
					{
					setState(130); match(IMAGE);
					}
					}
					break;
				case SOURCE:
					{
					{
					setState(131); match(SOURCE);
					}
					}
					break;
				case AUTHOR:
					{
					{
					setState(132); match(AUTHOR);
					}
					}
					break;
				case TEXT_TOKEN:
					{
					{
					setState(133); match(TEXT_TOKEN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141); match(FECHA_CHAVE);
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

	public static final String _serializedATN =
		"\2\3\35\u0092\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\3\2\7\2\24\n\2\f\2\16\2\27\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\59\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\7\7h\n\7\f\7\16\7k\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t|\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u0089\n\t\7\t\u008b\n\t\f\t\16\t\u008e\13\t\3\t"+
		"\3\t\3\t\2\n\2\4\6\b\n\f\16\20\2\3\4\4\4\35\35\u009a\2\25\3\2\2\2\4\34"+
		"\3\2\2\2\6!\3\2\2\2\b.\3\2\2\2\n>\3\2\2\2\fc\3\2\2\2\16n\3\2\2\2\20v\3"+
		"\2\2\2\22\24\t\2\2\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3"+
		"\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\5\4\3\2\31\32\7\t\2\2\32\33\b"+
		"\2\1\2\33\3\3\2\2\2\34\35\7\b\2\2\35\36\b\3\1\2\36\37\5\6\4\2\37 \5\f"+
		"\7\2 \5\3\2\2\2!\"\7\13\2\2\"#\7\6\2\2#$\5\b\5\2$(\b\4\1\2%\'\5\n\6\2"+
		"&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\7\2"+
		"\2,-\b\4\1\2-\7\3\2\2\2./\7\n\2\2/\60\7\6\2\2\60\61\b\5\1\2\61\62\7\16"+
		"\2\2\62\63\7\32\2\2\63\64\7\3\2\2\648\b\5\1\2\65\66\7\r\2\2\66\67\7\32"+
		"\2\2\679\7\3\2\28\65\3\2\2\289\3\2\2\29:\3\2\2\2:;\b\5\1\2;<\7\7\2\2<"+
		"=\b\5\1\2=\t\3\2\2\2>?\b\6\1\2?@\7\34\2\2@A\7\6\2\2A]\b\6\1\2BC\7\16\2"+
		"\2CD\7\32\2\2D\\\7\3\2\2EF\b\6\1\2FG\7\17\2\2GH\7\32\2\2H\\\7\3\2\2IJ"+
		"\b\6\1\2JK\7\20\2\2KL\7\32\2\2L\\\7\3\2\2MN\b\6\1\2NO\7\23\2\2OP\7\32"+
		"\2\2P\\\7\3\2\2QR\b\6\1\2RS\7\22\2\2ST\7\32\2\2T\\\7\3\2\2UV\b\6\1\2V"+
		"W\7\21\2\2WX\7\32\2\2XY\7\3\2\2YZ\3\2\2\2Z\\\b\6\1\2[B\3\2\2\2[E\3\2\2"+
		"\2[I\3\2\2\2[M\3\2\2\2[Q\3\2\2\2[U\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2"+
		"\2\2^`\3\2\2\2_]\3\2\2\2`a\7\7\2\2ab\b\6\1\2b\13\3\2\2\2cd\7\f\2\2de\7"+
		"\6\2\2ei\5\16\b\2fh\5\20\t\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j"+
		"l\3\2\2\2ki\3\2\2\2lm\7\7\2\2m\r\3\2\2\2no\7\24\2\2op\7\6\2\2pq\7\25\2"+
		"\2qr\7\5\2\2rs\7\26\2\2st\7\5\2\2tu\7\7\2\2u\17\3\2\2\2vw\7\27\2\2wx\7"+
		"\30\2\2x{\7\5\2\2yz\7\32\2\2z|\7\5\2\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}"+
		"~\7\31\2\2~\u008c\7\6\2\2\177\u0080\7\34\2\2\u0080\u0081\b\t\1\2\u0081"+
		"\u0088\7\33\2\2\u0082\u0089\7\16\2\2\u0083\u0089\7\17\2\2\u0084\u0089"+
		"\7\20\2\2\u0085\u0089\7\23\2\2\u0086\u0089\7\22\2\2\u0087\u0089\7\21\2"+
		"\2\u0088\u0082\3\2\2\2\u0088\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0088\u0085"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008b\3\2\2\2\u008a"+
		"\177\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2"+
		"\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\7\2\2\u0090\21"+
		"\3\2\2\2\13\25(8[]i{\u0088\u008c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}