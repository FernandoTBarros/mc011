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
		FECHA_CHAVE             { 
                                        html.append("</div>\n"); 
                                        html.append("</div>\n");
                                        }
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
	:	STRUCTURE OPEN_CHAVE
	 	format
	 	item*
	 	FECHA_CHAVE
	;

format
	:	FORMAT OPEN_CHAVE
		COL INTEGER
		BORDER INTEGER
		FECHA_CHAVE
	;

item
	:	ITEM OPEN_BRACKET
		INTEGER
		(DOIS_PONTOS INTEGER)?
		FECHA_BRACKET
		OPEN_CHAVE
	(
                key=NOME_NOTICIA		{ Noticia noticia = noticias.get($key.text); }
                PONTO
                (
                (TITLE)    |                    
                (ABSTRACT) |                    
                (IMAGE)    |
        	(SOURCE)   |
        	(AUTHOR)   |
        	(TEXT_TOKEN)
                )
        )*
		FECHA_CHAVE
	;