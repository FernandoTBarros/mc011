// Generated from C:\Users\MRE004\git\mc011\Parser\src\br\npl\NPLParser.g4 by ANTLR 4.0

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


	          class Noticia
	          { 
	                         public String nome;
	                         public String titulo;
	                         public String resumo;
	                         public String texto;
	                         public String imagem;
	                         public String fonte;
	                         public String autor;
	                         
	                         public Integer colunaFinal;
	                                                  
	           }
		/** Map variable name to Integer object holding value */
		HashMap<String,Noticia> noticias = new HashMap<String,Noticia>();
		//Guarda a estrutura das noticias, um vetor de listas
	        List[] estruturaNoticias;
	        
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
			((NewspaperContext)_localctx).titulo =  (((NewspaperContext)_localctx).TEXT!=null?((NewspaperContext)_localctx).TEXT.getText():null); html.append("<title>" + _localctx.titulo + "</title>\n"); 
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
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TITLE) | (1L << ABSTRACT) | (1L << IMAGE) | (1L << TEXT_TOKEN) | (1L << AUTHOR) | (1L << SOURCE))) != 0)) {
				{
				setState(94);
				switch (_input.LA(1)) {
				case TITLE:
					{
					{
					setState(64); match(TITLE);
					setState(65); match(DOIS_PONTOS);
					setState(66); ((NoticiaContext)_localctx).tituloT = match(TEXT);
					}
					item.titulo = (((NoticiaContext)_localctx).tituloT!=null?((NoticiaContext)_localctx).tituloT.getText():null);
					}
					break;
				case ABSTRACT:
					{
					{
					setState(69); match(ABSTRACT);
					setState(70); match(DOIS_PONTOS);
					setState(71); ((NoticiaContext)_localctx).resumoT = match(TEXT);
					}
					item.resumo = (((NoticiaContext)_localctx).resumoT!=null?((NoticiaContext)_localctx).resumoT.getText():null);
					}
					break;
				case IMAGE:
					{
					{
					setState(74); match(IMAGE);
					setState(75); match(DOIS_PONTOS);
					setState(76); ((NoticiaContext)_localctx).imagemT = match(TEXT);
					}
					item.imagem = (((NoticiaContext)_localctx).imagemT!=null?((NoticiaContext)_localctx).imagemT.getText():null);
					}
					break;
				case SOURCE:
					{
					{
					setState(79); match(SOURCE);
					setState(80); match(DOIS_PONTOS);
					setState(81); ((NoticiaContext)_localctx).fonteT = match(TEXT);
					}
					item.fonte = (((NoticiaContext)_localctx).fonteT!=null?((NoticiaContext)_localctx).fonteT.getText():null);
					}
					break;
				case AUTHOR:
					{
					{
					setState(84); match(AUTHOR);
					setState(85); match(DOIS_PONTOS);
					setState(86); ((NoticiaContext)_localctx).autorT = match(TEXT);
					}
					item.autor = (((NoticiaContext)_localctx).autorT!=null?((NoticiaContext)_localctx).autorT.getText():null);
					}
					break;
				case TEXT_TOKEN:
					{
					{
					setState(89); match(TEXT_TOKEN);
					setState(90); match(DOIS_PONTOS);
					setState(91); ((NoticiaContext)_localctx).textoT = match(TEXT);
					}
					item.texto = (((NoticiaContext)_localctx).textoT!=null?((NoticiaContext)_localctx).textoT.getText():null);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99); match(FECHA_CHAVE);

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
		public FormatContext format;
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
			setState(102); match(STRUCTURE);
			setState(103); match(OPEN_CHAVE);
			 html.append("<div id=\"conteudo\">\n"); 
			setState(105); ((StructureContext)_localctx).format = format();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITEM) {
				{
				{
				setState(106); item();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112); match(FECHA_CHAVE);
			 
			                                                        int contemNoticia = 0;
			                                                        for(int i=1; i < estruturaNoticias.length; i++) { if(estruturaNoticias[i].size()>0) contemNoticia++; }
			                                                        if(contemNoticia>0) { html.append("<table cellSpacing=0 cellPadding=8 width=\"1024\" border=" + ((StructureContext)_localctx).format.borda + ">\n"); }
			                                                        while(contemNoticia>0)
			                                                        {
			                                                            html.append("<tr>\n");
			                                                            int colspan = 0;
			                                                            double width = 100/(estruturaNoticias.length-1);
			                                                            for(int i=1; i < estruturaNoticias.length; i++)
			                                                            { 
			                                                                if(i <= colspan) continue;
			                                                                if(estruturaNoticias[i].size()>0)
			                                                                {
			                                                                    Noticia n = ((ArrayList<Noticia>)estruturaNoticias[i]).remove(0);
			                                                                    if(estruturaNoticias[i].size()==0) { contemNoticia--; }
			                                                                    if(n.colunaFinal!=null) { colspan = n.colunaFinal; }
			                                                                    html.append("<td align=justify width=\"" + width + "%\" vAlign=\"top\" colspan=" + (colspan-i+1) + ">\n");
			                                                                    if(n.titulo!=null) { html.append("<h3> " + n.titulo + " </h3>\n"); }
			                                                                    if(n.resumo!=null) { html.append("<p> " + n.resumo + " </p>\n"); }
			                                                                    if(n.imagem!=null) { html.append("<img src=\"" + n.imagem + "\"/>\n"); }
			                                                                    if(n.fonte!=null) { html.append("<h6> <B>Fonte:</B> " + n.fonte + " </h6>\n"); }
			                                                                    if(n.autor!=null) { html.append("<h5> <B>Autor:</B> " + n.autor + " </h5>\n"); }
			                                                                    if(n.texto!=null) { html.append("<p> " + n.texto + " </p>\n"); }
			                                                                    html.append("</td>\n");
			                                                                }
			                                                                else  { html.append("<td />\n"); }//width=\"" + width + "%\"
			                                                            }
			                                                            html.append("</tr>\n");
			                                                        }
			                                                       html.append("</table>\n");
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

	public static class FormatContext extends ParserRuleContext {
		public Integer borda;
		public Token coluna;
		public Token bordaT;
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
			setState(115); match(FORMAT);
			setState(116); match(OPEN_CHAVE);
			setState(117); match(COL);
			setState(118); ((FormatContext)_localctx).coluna = match(INTEGER);
			setState(119); match(BORDER);
			setState(120); ((FormatContext)_localctx).bordaT = match(INTEGER);
			 ((FormatContext)_localctx).borda =  Integer.parseInt((((FormatContext)_localctx).bordaT!=null?((FormatContext)_localctx).bordaT.getText():null)); 
			setState(122); match(FECHA_CHAVE);
			 
			                                                        int tamColuna = Integer.parseInt((((FormatContext)_localctx).coluna!=null?((FormatContext)_localctx).coluna.getText():null));
			                                                        estruturaNoticias = new List[tamColuna+1];
			                                                        for(int i=1; i <= tamColuna; i++)
			                                                        {
			                                                            estruturaNoticias[i] = new ArrayList();
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

	public static class ItemContext extends ParserRuleContext {
		public Token rangeInicial;
		public Token rangeFinal;
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
			setState(125); match(ITEM);
			setState(126); match(OPEN_BRACKET);
			setState(127); ((ItemContext)_localctx).rangeInicial = match(INTEGER);
			setState(130);
			_la = _input.LA(1);
			if (_la==DOIS_PONTOS) {
				{
				setState(128); match(DOIS_PONTOS);
				setState(129); ((ItemContext)_localctx).rangeFinal = match(INTEGER);
				}
			}

			setState(132); match(FECHA_BRACKET);
			setState(133); match(OPEN_CHAVE);
			 
			                                                Noticia noticiaEstrutura = null; 
			                                                Noticia noticia = null;
			                                             
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOME_NOTICIA) {
				{
				{
				setState(135); ((ItemContext)_localctx).key = match(NOME_NOTICIA);
				 
				                                                        if(noticiaEstrutura==null)
				                                                        {
				                                                            noticia = noticias.get((((ItemContext)_localctx).key!=null?((ItemContext)_localctx).key.getText():null)); 
				                                                            noticiaEstrutura = new Noticia(); 
				                                                            if(((ItemContext)_localctx).rangeFinal!=null) { noticiaEstrutura.colunaFinal = Integer.parseInt((((ItemContext)_localctx).rangeFinal!=null?((ItemContext)_localctx).rangeFinal.getText():null)); }
				                                                            estruturaNoticias[Integer.parseInt((((ItemContext)_localctx).rangeInicial!=null?((ItemContext)_localctx).rangeInicial.getText():null))].add(noticiaEstrutura);
				                                                        }
				                                                    
				setState(137); match(PONTO);
				setState(150);
				switch (_input.LA(1)) {
				case TITLE:
					{
					{
					setState(138); match(TITLE);
					}
					 noticiaEstrutura.titulo = noticia.titulo; 
					}
					break;
				case ABSTRACT:
					{
					{
					setState(140); match(ABSTRACT);
					}
					 noticiaEstrutura.resumo = noticia.resumo; 
					}
					break;
				case IMAGE:
					{
					{
					setState(142); match(IMAGE);
					}
					 noticiaEstrutura.imagem = noticia.imagem; 
					}
					break;
				case SOURCE:
					{
					{
					setState(144); match(SOURCE);
					}
					 noticiaEstrutura.fonte = noticia.fonte; 
					}
					break;
				case AUTHOR:
					{
					{
					setState(146); match(AUTHOR);
					}
					 noticiaEstrutura.autor = noticia.autor; 
					}
					break;
				case TEXT_TOKEN:
					{
					{
					setState(148); match(TEXT_TOKEN);
					}
					 noticiaEstrutura.texto = noticia.texto; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157); match(FECHA_CHAVE);
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
		"\2\3\35\u00a2\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\3\2\7\2\24\n\2\f\2\16\2\27\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\59\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6a\n\6\f\6"+
		"\16\6d\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\5\t\u0085\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u0099\n\t\7\t\u009b\n\t\f\t\16\t\u009e\13\t\3\t\3"+
		"\t\3\t\2\n\2\4\6\b\n\f\16\20\2\3\4\4\4\35\35\u00aa\2\25\3\2\2\2\4\34\3"+
		"\2\2\2\6!\3\2\2\2\b.\3\2\2\2\n>\3\2\2\2\fh\3\2\2\2\16u\3\2\2\2\20\177"+
		"\3\2\2\2\22\24\t\2\2\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26"+
		"\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\5\4\3\2\31\32\7\t\2\2\32\33"+
		"\b\2\1\2\33\3\3\2\2\2\34\35\7\b\2\2\35\36\b\3\1\2\36\37\5\6\4\2\37 \5"+
		"\f\7\2 \5\3\2\2\2!\"\7\13\2\2\"#\7\6\2\2#$\5\b\5\2$(\b\4\1\2%\'\5\n\6"+
		"\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\7"+
		"\2\2,-\b\4\1\2-\7\3\2\2\2./\7\n\2\2/\60\7\6\2\2\60\61\b\5\1\2\61\62\7"+
		"\16\2\2\62\63\7\32\2\2\63\64\7\3\2\2\648\b\5\1\2\65\66\7\r\2\2\66\67\7"+
		"\32\2\2\679\7\3\2\28\65\3\2\2\289\3\2\2\29:\3\2\2\2:;\b\5\1\2;<\7\7\2"+
		"\2<=\b\5\1\2=\t\3\2\2\2>?\b\6\1\2?@\7\34\2\2@A\7\6\2\2Ab\b\6\1\2BC\7\16"+
		"\2\2CD\7\32\2\2DE\7\3\2\2EF\3\2\2\2Fa\b\6\1\2GH\7\17\2\2HI\7\32\2\2IJ"+
		"\7\3\2\2JK\3\2\2\2Ka\b\6\1\2LM\7\20\2\2MN\7\32\2\2NO\7\3\2\2OP\3\2\2\2"+
		"Pa\b\6\1\2QR\7\23\2\2RS\7\32\2\2ST\7\3\2\2TU\3\2\2\2Ua\b\6\1\2VW\7\22"+
		"\2\2WX\7\32\2\2XY\7\3\2\2YZ\3\2\2\2Za\b\6\1\2[\\\7\21\2\2\\]\7\32\2\2"+
		"]^\7\3\2\2^_\3\2\2\2_a\b\6\1\2`B\3\2\2\2`G\3\2\2\2`L\3\2\2\2`Q\3\2\2\2"+
		"`V\3\2\2\2`[\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2"+
		"ef\7\7\2\2fg\b\6\1\2g\13\3\2\2\2hi\7\f\2\2ij\7\6\2\2jk\b\7\1\2ko\5\16"+
		"\b\2ln\5\20\t\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3"+
		"\2\2\2rs\7\7\2\2st\b\7\1\2t\r\3\2\2\2uv\7\24\2\2vw\7\6\2\2wx\7\25\2\2"+
		"xy\7\5\2\2yz\7\26\2\2z{\7\5\2\2{|\b\b\1\2|}\7\7\2\2}~\b\b\1\2~\17\3\2"+
		"\2\2\177\u0080\7\27\2\2\u0080\u0081\7\30\2\2\u0081\u0084\7\5\2\2\u0082"+
		"\u0083\7\32\2\2\u0083\u0085\7\5\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\31\2\2\u0087\u0088\7\6\2\2\u0088"+
		"\u009c\b\t\1\2\u0089\u008a\7\34\2\2\u008a\u008b\b\t\1\2\u008b\u0098\7"+
		"\33\2\2\u008c\u008d\7\16\2\2\u008d\u0099\b\t\1\2\u008e\u008f\7\17\2\2"+
		"\u008f\u0099\b\t\1\2\u0090\u0091\7\20\2\2\u0091\u0099\b\t\1\2\u0092\u0093"+
		"\7\23\2\2\u0093\u0099\b\t\1\2\u0094\u0095\7\22\2\2\u0095\u0099\b\t\1\2"+
		"\u0096\u0097\7\21\2\2\u0097\u0099\b\t\1\2\u0098\u008c\3\2\2\2\u0098\u008e"+
		"\3\2\2\2\u0098\u0090\3\2\2\2\u0098\u0092\3\2\2\2\u0098\u0094\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0089\3\2\2\2\u009b\u009e\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a0\7\7\2\2\u00a0\21\3\2\2\2\13\25(8`bo\u0084\u0098"+
		"\u009c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}