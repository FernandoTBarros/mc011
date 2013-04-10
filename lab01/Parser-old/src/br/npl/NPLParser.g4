//Compilador NPL para HTML
//@author Fernando Teixeira Barros - 085858

parser grammar NPLParser;

options {
  tokenVocab = NPLLexer;
  language = Java;
}

@header {
    package br.npl;
    
    import java.util.HashMap;
    import java.lang.StringBuffer;
}

@members {
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
}

run returns [String result]
	:	(COMMENT | WS)*
	  begin
		END                     {
                                        html.append(dialogs.toString());
                                        if(titleSlideBuffer.length()>0)
                                        {
                                            html.append("<div id=\"titulos\">\n");
                                            html.append(titleSlideBuffer.toString());
                                            html.append("</div>\n");
                                        }
                                        html.append("</body>\n"); 
                                        html.append("</html>\n");
                                        $result = html.toString(); 
                                        }
	;

begin
	:	BEGIN			{ html.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"pt-br\" xml:lang=\"pt-br\">\n"); }
		content
		structure
	;

content
	:	CONTENT OPEN_CHAVE
		newspaper               { 
                                        html.append("<body>\n");
                                        html.append("<div id=\"container\">\n");
                                        html.append("<div id=\"header\">\n");
                                        html.append("<h1>" + $newspaper.titulo + "</h1>\n");
                                        html.append("<h2>" + $newspaper.data + "</h2>\n");
                                        html.append("</div>\n");
                                        html.append("<div id=\"linkbar\"></div>");
                                        }
                noticia*                        
		FECHA_CHAVE             { html.append("</div>\n"); }
	;

newspaper returns [String titulo, String data]
	:	NEWSPAPER OPEN_CHAVE
                                         {
                                         html.append("<head>\n" + "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" /> \n"); 
                                         html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/> \n");
                                         html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/> \n");
                                         html.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"jqueryui/css/custom-theme/jquery-ui-1.10.2.custom.min.css\"/>\n"); 
                                         html.append("<script src=\"jquery.min.js\"></script>\n");
                                         html.append("<script src=\"jqueryui/js/jquery-ui-1.10.2.custom.min.js\"></script>\n");
                                         html.append("<script src=\"main.js\"></script>\n");
                                         }
		TITLE DOIS_PONTOS TEXT		{$titulo = $TEXT.text; html.append("<title>" + $titulo + "</title>\n"); }
		(DATE DOIS_PONTOS TEXT)?	{$data = $TEXT.text; }
		FECHA_CHAVE                     {html.append("</head>\n"); }
	;
   
noticia returns [Noticia instance]
	:                                                       {Noticia item = new Noticia(); }
                nomeT=NOME_NOTICIA OPEN_CHAVE			{item.nome = $nomeT.text;}
        	(
                (TITLE DOIS_PONTOS tituloT=TEXT)           	{item.titulo = $tituloT.text;}
        |       (ABSTRACT DOIS_PONTOS resumoT=TEXT)        	{item.resumo = $resumoT.text;}
        |       (IMAGE DOIS_PONTOS imagemT=TEXT)        	{item.imagem = $imagemT.text;}
        |	(SOURCE DOIS_PONTOS fonteT=TEXT)      		{item.fonte = $fonteT.text;}
        |	(AUTHOR DOIS_PONTOS autorT=TEXT)      		{item.autor = $autorT.text;}
        |	(TEXT_TOKEN DOIS_PONTOS textoT=TEXT)  {item.texto = $textoT.text;}
                )*
		FECHA_CHAVE                                     
                                                                {
                                                                noticias.put(item.nome, item); 
                                                                $instance = item;
                                                                }
	;
	
structure
	:	STRUCTURE OPEN_CHAVE                { html.append("<div id=\"conteudo\">\n"); }
	 	format
                titleslide?
	 	item*
	 	FECHA_CHAVE                         { 
                                                        int contemNoticia = 0;
                                                        for(int i=1; i < estruturaNoticias.length; i++) { if(estruturaNoticias[i].size()>0) contemNoticia++; }
                                                        if(contemNoticia>0) { html.append("<table cellSpacing=0 cellPadding=8 width=\"1024\" border=" + $format.borda + ">\n"); }
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
	;

titleslide
        :       TITLE_SLIDE OPEN_CHAVE
        (        key=NOME_NOTICIA                 { 
                                                     Noticia noticia = noticias.get($key.text);                          
                                                     String linkNoticia = "";
                                                     if(noticia.texto!=null) { linkNoticia = "class=\"dialog\" name=\"" + noticia.nome + "\""; }
                                                     titleSlideBuffer.append("<h1 " + linkNoticia + "> " + noticia.titulo + " </h1>\n"); 
                                                    }
        )*
                FECHA_CHAVE
        ;

format returns [Integer borda]
	:	FORMAT OPEN_CHAVE
		COL coluna=INTEGER
		BORDER bordaT=INTEGER               { $borda = Integer.parseInt($bordaT.text); }
		FECHA_CHAVE                         
                                                    { 
                                                        int tamColuna = Integer.parseInt($coluna.text);
                                                        estruturaNoticias = new List[tamColuna+1];
                                                        for(int i=1; i <= tamColuna; i++)
                                                        {
                                                            estruturaNoticias[i] = new ArrayList();
                                                        }
                                                    }
	;

item
	:	ITEM OPEN_BRACKET
		rangeInicial=INTEGER
		(DOIS_PONTOS rangeFinal=INTEGER)?
		FECHA_BRACKET                       
		OPEN_CHAVE                   { 
                                                Noticia noticiaEstrutura = null; 
                                                Noticia noticia = null;
                                             }
	(
                key=NOME_NOTICIA                    { 
                                                        if(noticiaEstrutura==null)
                                                        {
                                                            noticia = noticias.get($key.text); 
                                                            noticiaEstrutura = new Noticia(); 
                                                            noticiaEstrutura.nome = $key.text;                           
                                                            if(noticia.texto!=null) { noticiaEstrutura.texto = noticia.texto; }
                                                            if($rangeFinal!=null) { noticiaEstrutura.colunaFinal = Integer.parseInt($rangeFinal.text); }
                                                            estruturaNoticias[Integer.parseInt($rangeInicial.text)].add(noticiaEstrutura);
                                                        }
                                                    }
                PONTO
                (
                (TITLE)                            { noticiaEstrutura.titulo = noticia.titulo; }
        |       (ABSTRACT)                         { noticiaEstrutura.resumo = noticia.resumo; }
        |       (IMAGE)                            { noticiaEstrutura.imagem = noticia.imagem; }
        |	(SOURCE)                           { noticiaEstrutura.fonte = noticia.fonte; }
        |	(AUTHOR)                           { noticiaEstrutura.autor = noticia.autor; }
                )
        )*                                         
		FECHA_CHAVE
	;