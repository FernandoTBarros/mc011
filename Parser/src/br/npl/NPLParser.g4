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
	//Guarda a estrutura das noticias, um vetor de listas
        List[] estruturaNoticias;
        
        StringBuffer html = new StringBuffer();
}

run returns [String result]
	:	(COMMENT | WS)*
	  begin
		END                     {
                                        html.append("</body>\n"); 
                                        html.append("</html>\n");
                                        $result = html.toString(); 
                                        }
	;

begin
	:	BEGIN			{ html.append("<html>\n"); }
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
                                         }
		TITLE DOIS_PONTOS TEXT		{$titulo = $TEXT.text; html.append("<title>" + $titulo + "</title>\n"); }
		(DATE DOIS_PONTOS TEXT)?	{$data = $TEXT.text; }
		FECHA_CHAVE                     {html.append("</head>\n"); }
	;
   
noticia returns [Noticia instance]
	:                                                       {Noticia item = new Noticia(); }
                nomeT=NOME_NOTICIA OPEN_CHAVE			{item.nome = $nomeT.text;}
        	(
                (TITLE DOIS_PONTOS tituloT=TEXT)    |   	{item.titulo = $tituloT.text;}
                (ABSTRACT DOIS_PONTOS resumoT=TEXT) |   	{item.resumo = $resumoT.text;}
                (IMAGE DOIS_PONTOS imagemT=TEXT)    |   	{item.imagem = $imagemT.text;}
        	(SOURCE DOIS_PONTOS fonteT=TEXT)   |   		{item.fonte = $fonteT.text;}
        	(AUTHOR DOIS_PONTOS autorT=TEXT)   |   		{item.autor = $autorT.text;}
        	(TEXT_TOKEN DOIS_PONTOS textoT=TEXT)   		{item.texto = $textoT.text;}
                )*
		FECHA_CHAVE                                     
                                                                {
                                                                noticias.put(item.nome, item); 
                                                                $instance = item;
                                                                }
	;
	
structure
	:	STRUCTURE OPEN_CHAVE                { html.append("<div id=\"left\">\n"); }
	 	format
	 	item*
	 	FECHA_CHAVE                         { 
                                                        if(estruturaNoticias[1].size()>0)
                                                        {
                                                            html.append("<div id=\"sub_left\"> \n");
                                                        
                                                        for (Noticia n : (ArrayList<Noticia>)estruturaNoticias[1])
                                                        {
                                                         if(n.titulo!=null) { html.append("<h3> " + n.titulo + " </h3>\n"); }
                                                         if(n.resumo!=null) { html.append("<p> " + n.resumo + " </p>\n"); }
                                                         if(n.imagem!=null) { html.append("<img src=\"" + n.imagem + "\"/>\n"); }
                                                         if(n.fonte!=null) { html.append("<h6> " + n.fonte + " </h6>\n"); }
                                                         if(n.autor!=null) { html.append("<h5> " + n.autor + " </h5>\n"); }
                                                         if(n.texto!=null) { html.append("<p> " + n.texto + " </p>\n"); }
                                                         }
                                                         html.append("</div> \n");
                                                        }
                                                          if(estruturaNoticias[2].size()>0)
                                                        {
                                                            html.append("<div id=\"sub_content\"> \n");
                                                        
                                                        for (Noticia n : (ArrayList<Noticia>)estruturaNoticias[2])
                                                        {
                                                         if(n.titulo!=null) { html.append("<h3> " + n.titulo + " </h3>\n"); }
                                                         if(n.resumo!=null) { html.append("<p> " + n.resumo + " </p>\n"); }
                                                         if(n.imagem!=null) { html.append("<img src=\"" + n.imagem + "\"/>\n"); }
                                                         if(n.fonte!=null) { html.append("<h6> " + n.fonte + " </h6>\n"); }
                                                         if(n.autor!=null) { html.append("<h5> " + n.autor + " </h5>\n"); }
                                                         if(n.texto!=null) { html.append("<p> " + n.texto + " </p>\n"); }
                                                         }
                                                         html.append("</div> \n");
                                                        }
                                                    }
                                         
	;

format
	:	FORMAT OPEN_CHAVE
		COL coluna=INTEGER
		BORDER borda=INTEGER
		FECHA_CHAVE                         
                                                    { 
                                                     int tamColuna = Integer.parseInt($coluna.text);
                                                    estruturaNoticias = new List[tamColuna];
                                                        for(int i=0; i < tamColuna; i++)
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
		OPEN_CHAVE
	(
                key=NOME_NOTICIA                    { 
                                                     Noticia noticia = noticias.get($key.text); 
                                                     Noticia noticiaEstrutura = new Noticia(); 
                                                     estruturaNoticias[Integer.parseInt($rangeInicial.text)].add(noticiaEstrutura);
                                                     }
                PONTO
                (
                (TITLE)                            { noticiaEstrutura.titulo = noticia.titulo; }
        |       (ABSTRACT)                         { noticiaEstrutura.resumo = noticia.resumo; }
        |       (IMAGE)                            { noticiaEstrutura.imagem = noticia.imagem; }
        |	(SOURCE)                           { noticiaEstrutura.fonte = noticia.fonte; }
        |	(AUTHOR)                           { noticiaEstrutura.autor = noticia.autor; }
        |	(TEXT_TOKEN)                       { noticiaEstrutura.texto = noticia.texto; }
                )
        )*                                         
		FECHA_CHAVE
	;