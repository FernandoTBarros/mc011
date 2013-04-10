lexer grammar NPLLexer;
@header {
         //package br.npl;
 }

TEXT_FORMATADO: '"' -> pushMode(FORMAT_TEXT);
TEXT:  '"' ( EscapeSequence | ~('\\'|'"') )* '"' {setText(getText().substring(1, getText().length()-1).replace("\\", ""));} ;
fragment EscapeSequence: '\\' ('\"');
WS: [ \r\t\u000C\n]+ -> skip;
INTEGER:    [0-9]+;
fragment LETTER: [a-zA-Z]+;
OPEN_CHAVE: '{';
FECHA_CHAVE: '}';
BEGIN: 'begin';
END: 'end';
NEWSPAPER: 'newspaper';
CONTENT: 'content';
STRUCTURE: 'structure';
DATE: 'date';
TITLE: 'title';
ABSTRACT: 'abstract';
IMAGE: 'image';
TEXT_TOKEN: 'text';
AUTHOR: 'author';
SOURCE: 'source';
FORMAT: 'format';
COL: 'col:';
BORDER: 'border:';
ITEM: 'item';
TITLE_SLIDE: 'titleslide';
OPEN_BRACKET: '[';
FECHA_BRACKET: ']';
DOIS_PONTOS: ':';
PONTO: '.';
NOME_NOTICIA:	(LETTER)(LETTER | INTEGER | '_')*;
COMMENT
    :   ( '/*' .*? '*/'
        | '//' ~[\r\n]*
        ) -> skip
    ;

mode FORMAT_TEXT;
ESCAPE: '\\\"' {setText("\"");};
ENDTEXT: '\"' -> popMode;
SECAO_H2: '==' ~[=]* '==' {setText("<h2>" + getText() + "</h2>");};
SECAO_H3: '===' ~[=]* '===' {setText("<h3>" + getText() + "</h3>");};
STRING: .+?;
               