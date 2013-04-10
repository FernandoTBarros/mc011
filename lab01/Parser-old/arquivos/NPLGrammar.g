//Compilador NPL para HTML
//@author Fernando Teixeira Barros - 085858

grammar NPLGrammar;

options {
  language = Java;
}

@header {
    package br.npl;
    
    import java.util.HashMap;
}

@lexer::header {
    package br.npl;
}

@members {
	/** Map variable name to Integer object holding value */
	HashMap noticias = new HashMap();
}

run returns [String result]
	:	(comentarios | WS)*
	  begin
		'end'
	;

begin returns [String result]
	:	'begin'							{$result = "<html>";}
		content
		structure
	;

content returns [String result]
	:	'content' '{'
		newspaper						{$result = $result + $newspaper.result;}
		noticia*
		'}'
	;

newspaper returns [String result]
	:	'newspaper' '{'					{$result = $result + "<head>" + "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />";}
		title							{$result = $result + "<title>" + $title.result + "</title>";}
		('date:'  '\"' TEXT* '\"')?		//Ignora a data
		'}'								{$result = $result + "</head>";}
	;

title returns [String result]
	:    'title:' '\"' TEXT* '\"'       {$result = $TEXT.text;}
    ;
   
noticia returns [String nome, String titulo, String resumo, String imagem, String fonte, String data, String autor, String texto]
	:	NOME_NOTICIA '{'				{$nome = $NOME_NOTICIA.text;}
//		'title:' '\"' $titulo=TEXT* '\"'
//		'abstract:' '\"' $resumo=TEXT* '\"'
//		('image:' '\"' $imagem=TEXT* '\"')?
//		('source:' '\"' $fonte=TEXT* '\"')?
//		('date:' '\"' $data=TEXT* '\"')?
//		('author:' '\"' $autor=TEXT* '\"')?
//		('text:' '\"' $texto=TEXT* '\"')?
//		{ noticias.put($nome, retval); }
		'}'
	;
	
structure returns [String result]
	:	'structure' '{'
	 	format
	 	item*
	 	'}'
	;

format returns [String result]
	:	'format' '{'
		'col:' INTEGER
		'border:' INTEGER
		'}'
	;

item returns [String result]
	:	'item' '['
		INTEGER
		(:INTEGER)?
		']'
		'{'
		key=NOME_NOTICIA				{ noticias.get($key);}
		'}'
	;
comentarios
  :  '//' (ACCENT|~'\n')* '\n'
  ;
  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

WS:        (' ' | '\t' | '\f' | '\r' | '\n')+ {$channel = HIDDEN;};
INTEGER:    ('0'..'9')+;
SIGNAL:     (',' | '.' | ':' | ';');
NOME_NOTICIA:	('a'..'z' | 'A'..'Z' )('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;
TEXT:         ('a'..'z' | 'A'..'Z' | '0'..'9' | WS | '-' | '_' | '('|')' | SIGNAL)*;
fragment ACCENT     :   '\u00C0'..'\u00D6' | '\u00D9'..'\u00DD' | '\u00E0'..'\u00F6' |'\u00F9'..'\u00FD';