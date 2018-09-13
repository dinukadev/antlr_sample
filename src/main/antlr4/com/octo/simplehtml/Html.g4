grammar Html;


doctype: DOCTYPE head ;
head: '<head>' title '</head>';
title: '<title>' TEXT '</title>';

fragment OPEN_BRACKET :  '<' ;
fragment EXCLAMATION : '!' ;
fragment CLOSE_BRACKET : '>' ;
DOCTYPE : OPEN_BRACKET EXCLAMATION 'DOCTYPE' ' ' HTML CLOSE_BRACKET ;
fragment HTML : 'html' ;
fragment CHARACTERS : ([a-zA-Z])+ ;
TEXT : CHARACTERS+;

WS : [ \t\r\n] -> skip ;

