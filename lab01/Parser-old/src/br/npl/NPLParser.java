// Generated from NPLParser.g4 by ANTLR 4.0

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
		INTEGER=4, AUTHOR=17, NEWSPAPER=9, ITEM=22, FECHA_BRACKET=25, TEXT_FORMATADO=1, 
		DOIS_PONTOS=26, SOURCE=18, PONTO=27, CONTENT=10, ABSTRACT=14, TEXT_TOKEN=16, 
		TEXT=2, SECAO_H3=33, STRUCTURE=11, SECAO_H2=32, BORDER=21, ENDTEXT=31, 
		OPEN_BRACKET=24, WS=3, NOME_NOTICIA=28, ESCAPE=30, FECHA_CHAVE=6, IMAGE=15, 
		OPEN_CHAVE=5, BEGIN=7, COL=20, FORMAT=19, COMMENT=29, DATE=12, END=8, 
		TITLE_SLIDE=23, STRING=34, TITLE=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'\"'", "TEXT", "WS", "INTEGER", "'{'", "'}'", "'begin'", 
		"'end'", "'newspaper'", "'content'", "'structure'", "'date'", "'title'", 
		"'abstract'", "'image'", "'text'", "'author'", "'source'", "'format'", 
		"'col:'", "'border:'", "'item'", "'titleslide'", "'['", "']'", "':'", 
		"'.'", "NOME_NOTICIA", "COMMENT", "'\\\"'", "'\"'", "SECAO_H2", "SECAO_H3", 
		"STRING"
	};
	public static final int
		RULE_run = 0, RULE_begin = 1, RULE_content = 2, RULE_newspaper = 3, RULE_noticia = 4, 
		RULE_structure = 5, RULE_titleslide = 6, RULE_format = 7, RULE_item = 8;
	public static final String[] ruleNames = {
		"run", "begin", "content", "newspaper", "noticia", "structure", "titleslide", 
		"format", "item"
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
	        StringBuffer dialogs = new StringBuffer();
	        StringBuffer titleSlideBuffer = new StringBuffer();
	        
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS || _la==COMMENT) {
				{
				{
				setState(18);
				_la = _input.LA(1);
				if ( !(_la==WS || _la==COMMENT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24); begin();
			setState(25); match(END);

			                                        html.append(dialogs.toString());
			                                        if(titleSlideBuffer.length()>0)
			                                        {
			                                            html.append("<div id=\"titulos\">\n");
			                                            html.append(titleSlideBuffer.toString());
			                                            html.append("</div>\n");
			                                        }
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
			setState(28); match(BEGIN);
			 html.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"pt-br\" xml:lang=\"pt-br\">\n"); 
			setState(30); content();
			setState(31); structure();
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
			setState(33); match(CONTENT);
			setState(34); match(OPEN_CHAVE);
			setState(35); ((ContentContext)_localctx).newspaper = newspaper();
			 
			                                        html.append("<body>\n");
			                                        html.append("<div id=\"container\">\n");
			                                        html.append("<div id=\"header\">\n");
			                                        html.append("<h1>" + ((ContentContext)_localctx).newspaper.titulo + "</h1>\n");
			                                        html.append("<h2>" + ((ContentContext)_localctx).newspaper.data + "</h2>\n");
			                                        html.append("</div>\n");
			                                        html.append("<div id=\"linkbar\"></div>");
			                                        
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOME_NOTICIA) {
				{
				{
				setState(37); noticia();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43); match(FECHA_CHAVE);
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
			setState(46); match(NEWSPAPER);
			setState(47); match(OPEN_CHAVE);

			                                         html.append("<head>\n" + "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" /> \n"); 
			                                         html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/> \n");
			                                         html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/> \n");
			                                         html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqueryui/css/custom-theme/jquery-ui-1.10.2.custom.min.css\"/>\n"); 
			                                         html.append("<script src=\"jquery.min.js\"></script>\n");
			                                         html.append("<script src=\"jqueryui/js/jquery-ui-1.10.2.custom.min.js\"></script>\n");
			                                         html.append("<script src=\"main.js\"></script>\n");
			                                         
			setState(49); match(TITLE);
			setState(50); match(DOIS_PONTOS);
			setState(51); ((NewspaperContext)_localctx).TEXT = match(TEXT);
			((NewspaperContext)_localctx).titulo =  (((NewspaperContext)_localctx).TEXT!=null?((NewspaperContext)_localctx).TEXT.getText():null); html.append("<title>" + _localctx.titulo + "</title>\n"); 
			setState(56);
			_la = _input.LA(1);
			if (_la==DATE) {
				{
				setState(53); match(DATE);
				setState(54); match(DOIS_PONTOS);
				setState(55); ((NewspaperContext)_localctx).TEXT = match(TEXT);
				}
			}

			((NewspaperContext)_localctx).data =  (((NewspaperContext)_localctx).TEXT!=null?((NewspaperContext)_localctx).TEXT.getText():null); 
			setState(59); match(FECHA_CHAVE);
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
			setState(63); ((NoticiaContext)_localctx).nomeT = match(NOME_NOTICIA);
			setState(64); match(OPEN_CHAVE);
			item.nome = (((NoticiaContext)_localctx).nomeT!=null?((NoticiaContext)_localctx).nomeT.getText():null);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TITLE) | (1L << ABSTRACT) | (1L << IMAGE) | (1L << TEXT_TOKEN) | (1L << AUTHOR) | (1L << SOURCE))) != 0)) {
				{
				setState(96);
				switch (_input.LA(1)) {
				case TITLE:
					{
					{
					setState(66); match(TITLE);
					setState(67); match(DOIS_PONTOS);
					setState(68); ((NoticiaContext)_localctx).tituloT = match(TEXT);
					}
					item.titulo = (((NoticiaContext)_localctx).tituloT!=null?((NoticiaContext)_localctx).tituloT.getText():null);
					}
					break;
				case ABSTRACT:
					{
					{
					setState(71); match(ABSTRACT);
					setState(72); match(DOIS_PONTOS);
					setState(73); ((NoticiaContext)_localctx).resumoT = match(TEXT);
					}
					item.resumo = (((NoticiaContext)_localctx).resumoT!=null?((NoticiaContext)_localctx).resumoT.getText():null);
					}
					break;
				case IMAGE:
					{
					{
					setState(76); match(IMAGE);
					setState(77); match(DOIS_PONTOS);
					setState(78); ((NoticiaContext)_localctx).imagemT = match(TEXT);
					}
					item.imagem = (((NoticiaContext)_localctx).imagemT!=null?((NoticiaContext)_localctx).imagemT.getText():null);
					}
					break;
				case SOURCE:
					{
					{
					setState(81); match(SOURCE);
					setState(82); match(DOIS_PONTOS);
					setState(83); ((NoticiaContext)_localctx).fonteT = match(TEXT);
					}
					item.fonte = (((NoticiaContext)_localctx).fonteT!=null?((NoticiaContext)_localctx).fonteT.getText():null);
					}
					break;
				case AUTHOR:
					{
					{
					setState(86); match(AUTHOR);
					setState(87); match(DOIS_PONTOS);
					setState(88); ((NoticiaContext)_localctx).autorT = match(TEXT);
					}
					item.autor = (((NoticiaContext)_localctx).autorT!=null?((NoticiaContext)_localctx).autorT.getText():null);
					}
					break;
				case TEXT_TOKEN:
					{
					{
					setState(91); match(TEXT_TOKEN);
					setState(92); match(DOIS_PONTOS);
					setState(93); ((NoticiaContext)_localctx).textoT = match(TEXT);
					}
					item.texto = (((NoticiaContext)_localctx).textoT!=null?((NoticiaContext)_localctx).textoT.getText():null);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101); match(FECHA_CHAVE);

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
		public TitleslideContext titleslide() {
			return getRuleContext(TitleslideContext.class,0);
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
			setState(104); match(STRUCTURE);
			setState(105); match(OPEN_CHAVE);
			 html.append("<div id=\"conteudo\">\n"); 
			setState(107); ((StructureContext)_localctx).format = format();
			setState(109);
			_la = _input.LA(1);
			if (_la==TITLE_SLIDE) {
				{
				setState(108); titleslide();
				}
			}

			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITEM) {
				{
				{
				setState(111); item();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117); match(FECHA_CHAVE);
			 
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
			                                                                    html.append("<td align=justify width=\"" + width + "%\" vAlign=\"top\" ");
			                                                                    if(n.colunaFinal!=null) 
			                                                                    {
			                                                                        colspan = n.colunaFinal; 
			                                                                        html.append("colspan=" + (colspan-i+1) + ">\n");
			                                                                    }                                                                   
			                                                                    else { html.append(">\n");}
			                                                                    String linkNoticia = "";
			                                                                    if(n.texto!=null) 
			                                                                    {
			                                                                        linkNoticia = "class=\"dialog\" name=\"" + n.nome + "\"";
			                                                                        dialogs.append("<div id=\"" + n.nome + "\" style=\"display:none;\">\n");
			                                                                        dialogs.append("<h3> " + n.titulo + " </h3>\n");
			                                                                        dialogs.append(n.texto);
			                                                                        dialogs.append("</div>");
			                                                                    }
			                                                                    if(n.titulo!=null) { html.append("<h3 " + linkNoticia + "> " + n.titulo + " </h3>\n"); }
			                                                                    if(n.imagem!=null) 
			                                                                    { 
			                                                                        html.append("<div id=\"figura\"><p>\n");
			                                                                        html.append("<img class=\"escala\" src=\"" + n.imagem + "\"/>\n"); 
			                                                                        html.append("</p></div>");
			                                                                    }
			                                                                    if(n.resumo!=null) { html.append("<p> " + n.resumo + " </p>\n"); }
			                                                                    if(n.fonte!=null) { html.append("<br><h5> <B>Fonte:</B> " + n.fonte + " </h5>\n"); }
			                                                                    if(n.autor!=null) { html.append("<br><h5> <B>Autor:</B> " + n.autor + " </h5>\n"); }
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

	public static class TitleslideContext extends ParserRuleContext {
		public Token key;
		public TerminalNode NOME_NOTICIA(int i) {
			return getToken(NPLParser.NOME_NOTICIA, i);
		}
		public List<TerminalNode> NOME_NOTICIA() { return getTokens(NPLParser.NOME_NOTICIA); }
		public TerminalNode FECHA_CHAVE() { return getToken(NPLParser.FECHA_CHAVE, 0); }
		public TerminalNode TITLE_SLIDE() { return getToken(NPLParser.TITLE_SLIDE, 0); }
		public TerminalNode OPEN_CHAVE() { return getToken(NPLParser.OPEN_CHAVE, 0); }
		public TitleslideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_titleslide; }
	}

	public final TitleslideContext titleslide() throws RecognitionException {
		TitleslideContext _localctx = new TitleslideContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_titleslide);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(TITLE_SLIDE);
			setState(121); match(OPEN_CHAVE);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOME_NOTICIA) {
				{
				{
				setState(122); ((TitleslideContext)_localctx).key = match(NOME_NOTICIA);
				 
				                                                     Noticia noticia = noticias.get((((TitleslideContext)_localctx).key!=null?((TitleslideContext)_localctx).key.getText():null));                          
				                                                     String linkNoticia = "";
				                                                     if(noticia.texto!=null) { linkNoticia = "class=\"dialog\" name=\"" + noticia.nome + "\""; }
				                                                     titleSlideBuffer.append("<h1 " + linkNoticia + "> " + noticia.titulo + " </h1>\n"); 
				                                                    
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129); match(FECHA_CHAVE);
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
		enterRule(_localctx, 14, RULE_format);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(FORMAT);
			setState(132); match(OPEN_CHAVE);
			setState(133); match(COL);
			setState(134); ((FormatContext)_localctx).coluna = match(INTEGER);
			setState(135); match(BORDER);
			setState(136); ((FormatContext)_localctx).bordaT = match(INTEGER);
			 ((FormatContext)_localctx).borda =  Integer.parseInt((((FormatContext)_localctx).bordaT!=null?((FormatContext)_localctx).bordaT.getText():null)); 
			setState(138); match(FECHA_CHAVE);
			 
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
		public List<TerminalNode> SOURCE() { return getTokens(NPLParser.SOURCE); }
		public List<TerminalNode> PONTO() { return getTokens(NPLParser.PONTO); }
		public TerminalNode AUTHOR(int i) {
			return getToken(NPLParser.AUTHOR, i);
		}
		public List<TerminalNode> ABSTRACT() { return getTokens(NPLParser.ABSTRACT); }
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
		enterRule(_localctx, 16, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(ITEM);
			setState(142); match(OPEN_BRACKET);
			setState(143); ((ItemContext)_localctx).rangeInicial = match(INTEGER);
			setState(146);
			_la = _input.LA(1);
			if (_la==DOIS_PONTOS) {
				{
				setState(144); match(DOIS_PONTOS);
				setState(145); ((ItemContext)_localctx).rangeFinal = match(INTEGER);
				}
			}

			setState(148); match(FECHA_BRACKET);
			setState(149); match(OPEN_CHAVE);
			 
			                                                Noticia noticiaEstrutura = null; 
			                                                Noticia noticia = null;
			                                             
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOME_NOTICIA) {
				{
				{
				setState(151); ((ItemContext)_localctx).key = match(NOME_NOTICIA);
				 
				                                                        if(noticiaEstrutura==null)
				                                                        {
				                                                            noticia = noticias.get((((ItemContext)_localctx).key!=null?((ItemContext)_localctx).key.getText():null)); 
				                                                            noticiaEstrutura = new Noticia(); 
				                                                            noticiaEstrutura.nome = (((ItemContext)_localctx).key!=null?((ItemContext)_localctx).key.getText():null);                           
				                                                            if(noticia.texto!=null) { noticiaEstrutura.texto = noticia.texto; }
				                                                            if(((ItemContext)_localctx).rangeFinal!=null) { noticiaEstrutura.colunaFinal = Integer.parseInt((((ItemContext)_localctx).rangeFinal!=null?((ItemContext)_localctx).rangeFinal.getText():null)); }
				                                                            estruturaNoticias[Integer.parseInt((((ItemContext)_localctx).rangeInicial!=null?((ItemContext)_localctx).rangeInicial.getText():null))].add(noticiaEstrutura);
				                                                        }
				                                                    
				setState(153); match(PONTO);
				setState(164);
				switch (_input.LA(1)) {
				case TITLE:
					{
					{
					setState(154); match(TITLE);
					}
					 noticiaEstrutura.titulo = noticia.titulo; 
					}
					break;
				case ABSTRACT:
					{
					{
					setState(156); match(ABSTRACT);
					}
					 noticiaEstrutura.resumo = noticia.resumo; 
					}
					break;
				case IMAGE:
					{
					{
					setState(158); match(IMAGE);
					}
					 noticiaEstrutura.imagem = noticia.imagem; 
					}
					break;
				case SOURCE:
					{
					{
					setState(160); match(SOURCE);
					}
					 noticiaEstrutura.fonte = noticia.fonte; 
					}
					break;
				case AUTHOR:
					{
					{
					setState(162); match(AUTHOR);
					}
					 noticiaEstrutura.autor = noticia.autor; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171); match(FECHA_CHAVE);
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
		"\2\3$\u00b0\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\3\2\7\2\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5;\n\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6c\n\6"+
		"\f\6\16\6f\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7p\n\7\3\7\7\7s\n\7"+
		"\f\7\16\7v\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082"+
		"\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u0095\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u00a7\n\n\7\n\u00a9\n\n\f\n\16\n\u00ac\13\n\3\n\3\n\3"+
		"\n\2\13\2\4\6\b\n\f\16\20\22\2\3\4\5\5\37\37\u00b8\2\27\3\2\2\2\4\36\3"+
		"\2\2\2\6#\3\2\2\2\b\60\3\2\2\2\n@\3\2\2\2\fj\3\2\2\2\16z\3\2\2\2\20\u0085"+
		"\3\2\2\2\22\u008f\3\2\2\2\24\26\t\2\2\2\25\24\3\2\2\2\26\31\3\2\2\2\27"+
		"\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\5\4\3\2\33"+
		"\34\7\n\2\2\34\35\b\2\1\2\35\3\3\2\2\2\36\37\7\t\2\2\37 \b\3\1\2 !\5\6"+
		"\4\2!\"\5\f\7\2\"\5\3\2\2\2#$\7\f\2\2$%\7\7\2\2%&\5\b\5\2&*\b\4\1\2\'"+
		")\5\n\6\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2"+
		"-.\7\b\2\2./\b\4\1\2/\7\3\2\2\2\60\61\7\13\2\2\61\62\7\7\2\2\62\63\b\5"+
		"\1\2\63\64\7\17\2\2\64\65\7\34\2\2\65\66\7\4\2\2\66:\b\5\1\2\678\7\16"+
		"\2\289\7\34\2\29;\7\4\2\2:\67\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\b\5\1\2=>"+
		"\7\b\2\2>?\b\5\1\2?\t\3\2\2\2@A\b\6\1\2AB\7\36\2\2BC\7\7\2\2Cd\b\6\1\2"+
		"DE\7\17\2\2EF\7\34\2\2FG\7\4\2\2GH\3\2\2\2Hc\b\6\1\2IJ\7\20\2\2JK\7\34"+
		"\2\2KL\7\4\2\2LM\3\2\2\2Mc\b\6\1\2NO\7\21\2\2OP\7\34\2\2PQ\7\4\2\2QR\3"+
		"\2\2\2Rc\b\6\1\2ST\7\24\2\2TU\7\34\2\2UV\7\4\2\2VW\3\2\2\2Wc\b\6\1\2X"+
		"Y\7\23\2\2YZ\7\34\2\2Z[\7\4\2\2[\\\3\2\2\2\\c\b\6\1\2]^\7\22\2\2^_\7\34"+
		"\2\2_`\7\4\2\2`a\3\2\2\2ac\b\6\1\2bD\3\2\2\2bI\3\2\2\2bN\3\2\2\2bS\3\2"+
		"\2\2bX\3\2\2\2b]\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2"+
		"\2\2gh\7\b\2\2hi\b\6\1\2i\13\3\2\2\2jk\7\r\2\2kl\7\7\2\2lm\b\7\1\2mo\5"+
		"\20\t\2np\5\16\b\2on\3\2\2\2op\3\2\2\2pt\3\2\2\2qs\5\22\n\2rq\3\2\2\2"+
		"sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7\b\2\2xy\b\7\1\2"+
		"y\r\3\2\2\2z{\7\31\2\2{\u0080\7\7\2\2|}\7\36\2\2}\177\b\b\1\2~|\3\2\2"+
		"\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\b\2\2\u0084\17\3\2\2\2\u0085"+
		"\u0086\7\25\2\2\u0086\u0087\7\7\2\2\u0087\u0088\7\26\2\2\u0088\u0089\7"+
		"\6\2\2\u0089\u008a\7\27\2\2\u008a\u008b\7\6\2\2\u008b\u008c\b\t\1\2\u008c"+
		"\u008d\7\b\2\2\u008d\u008e\b\t\1\2\u008e\21\3\2\2\2\u008f\u0090\7\30\2"+
		"\2\u0090\u0091\7\32\2\2\u0091\u0094\7\6\2\2\u0092\u0093\7\34\2\2\u0093"+
		"\u0095\7\6\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0097\7\33\2\2\u0097\u0098\7\7\2\2\u0098\u00aa\b\n\1\2\u0099"+
		"\u009a\7\36\2\2\u009a\u009b\b\n\1\2\u009b\u00a6\7\35\2\2\u009c\u009d\7"+
		"\17\2\2\u009d\u00a7\b\n\1\2\u009e\u009f\7\20\2\2\u009f\u00a7\b\n\1\2\u00a0"+
		"\u00a1\7\21\2\2\u00a1\u00a7\b\n\1\2\u00a2\u00a3\7\24\2\2\u00a3\u00a7\b"+
		"\n\1\2\u00a4\u00a5\7\23\2\2\u00a5\u00a7\b\n\1\2\u00a6\u009c\3\2\2\2\u00a6"+
		"\u009e\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a7\u00a9\3\2\2\2\u00a8\u0099\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ad\u00ae\7\b\2\2\u00ae\23\3\2\2\2\r\27*:bdot\u0080\u0094\u00a6"+
		"\u00aa";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}