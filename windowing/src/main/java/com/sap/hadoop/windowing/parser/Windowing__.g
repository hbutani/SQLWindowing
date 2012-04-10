lexer grammar Windowing;
options {
  language=Java;

}
@header {
package com.sap.hadoop.windowing.parser;
}

// $ANTLR src "Windowing.g" 207
QUOTE             : '\'';
// $ANTLR src "Windowing.g" 208
ASTERISK          : '*';
// $ANTLR src "Windowing.g" 209
COLON             : ':';
// $ANTLR src "Windowing.g" 210
SEMICOLON         : ';';
// $ANTLR src "Windowing.g" 211
COMMA             : ',';
// $ANTLR src "Windowing.g" 212
DOT               : '.';
// $ANTLR src "Windowing.g" 213
EQ                : '=';
// $ANTLR src "Windowing.g" 214
GE                : '>=';
// $ANTLR src "Windowing.g" 215
GT                : '>';
// $ANTLR src "Windowing.g" 216
LBRACKET          : '[';
// $ANTLR src "Windowing.g" 217
LBRACE            : '{';
// $ANTLR src "Windowing.g" 218
LE                : '<=';
// $ANTLR src "Windowing.g" 219
LPAREN            : '(';
// $ANTLR src "Windowing.g" 220
LT                : '<';
// $ANTLR src "Windowing.g" 221
MINUS             : '-';
// $ANTLR src "Windowing.g" 222
NE                : '<>';
// $ANTLR src "Windowing.g" 223
PLUS              : '+';
// $ANTLR src "Windowing.g" 224
RBRACE            : '}';
// $ANTLR src "Windowing.g" 225
RBRACKET          : ']';
// $ANTLR src "Windowing.g" 226
RPAREN            : ')';
// $ANTLR src "Windowing.g" 227
SOLIDUS           : '/';

// $ANTLR src "Windowing.g" 229
SELECT            : S E L E C T;
// $ANTLR src "Windowing.g" 230
FROM              : F R O M;
// $ANTLR src "Windowing.g" 231
WHERE             : W H E R E;
// $ANTLR src "Windowing.g" 232
TABLEINPUT        : T A B L E I N P U T;
// $ANTLR src "Windowing.g" 233
ORDER             : O R D E R;
// $ANTLR src "Windowing.g" 234
BY                : B Y;
// $ANTLR src "Windowing.g" 235
PARTITION         : P A R T I T I O N;
// $ANTLR src "Windowing.g" 236
WITH              : W I T H;
// $ANTLR src "Windowing.g" 237
ROWS              : R O W S;
// $ANTLR src "Windowing.g" 238
RANGE 	          : R A N G E;
// $ANTLR src "Windowing.g" 239
BETWEEN 	  : B E T W E E N;
// $ANTLR src "Windowing.g" 240
CURRENT		  : C U R R E N T;
// $ANTLR src "Windowing.g" 241
ROW		  : R O W;
// $ANTLR src "Windowing.g" 242
UNBOUNDED   	  : U N B O U N D E D;
// $ANTLR src "Windowing.g" 243
PRECEDING         : P R E C E D I N G;
// $ANTLR src "Windowing.g" 244
FOLLOWING         : F O L L O W I N G;
// $ANTLR src "Windowing.g" 245
LESS		  : L E S S;
// $ANTLR src "Windowing.g" 246
MORE		  : M O R E;
// $ANTLR src "Windowing.g" 247
AS		  : A S;
// $ANTLR src "Windowing.g" 248
OVER		  : O V E R;
// $ANTLR src "Windowing.g" 249
INTO    : I N T O;
// $ANTLR src "Windowing.g" 250
PATH    : P A T H;
// $ANTLR src "Windowing.g" 251
FORMAT  : F O R M A T;
// $ANTLR src "Windowing.g" 252
SERDE   : S E R D E;
// $ANTLR src "Windowing.g" 253
SERDEPROPERTIES : S E R D E P R O P E R T I E S;
// $ANTLR src "Windowing.g" 254
RECORDWRITER : R E C O R D W R I T E R;
// $ANTLR src "Windowing.g" 255
LOAD         : L O A D;
// $ANTLR src "Windowing.g" 256
TABLE        : T A B L E;
// $ANTLR src "Windowing.g" 257
OVERWRITE        : O V E R W R I T E;

/*
/*
  boolean operators
*/
// $ANTLR src "Windowing.g" 263
AND               : A N D;
// $ANTLR src "Windowing.g" 264
NOT               : N O T;
// $ANTLR src "Windowing.g" 265
OR                : O R;
// $ANTLR src "Windowing.g" 266
XOR               : X O R;

// $ANTLR src "Windowing.g" 268
ASC               : A S C;
// $ANTLR src "Windowing.g" 269
DESC              : D E S C;

// $ANTLR src "Windowing.g" 271
NUMBER    : ('0'..'9')+
    ;
// $ANTLR src "Windowing.g" 273
ID    :  ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
    ;

// $ANTLR src "Windowing.g" 276
GROOVYEXPRESSION : '<' 
		(GroovyEscapeSequence | ~('>'))*
		'>' {setText(getText().substring(1, getText().length()-1).replaceAll("\\\\>", ">"));}
;

// $ANTLR src "Windowing.g" 281
fragment
GroovyEscapeSequence :	
  '\\' '>'
;    

// $ANTLR src "Windowing.g" 286
STRING
    :   '\'' 
        (   EscapeSequence
        |   ~( '\\' | '\'' | '\r' | '\n' )        
        )* 
        '\''  {setText(getText().substring(1, getText().length()-1));}
    ;

// $ANTLR src "Windowing.g" 294
fragment
EscapeSequence 
    :   '\\' (
                 'b' 
             |   't' 
             |   'n' 
             |   'f' 
             |   'r' 
             |   '\"' 
             |   '\'' 
             |   '\\' 
             |       
                 ('0'..'3') ('0'..'7') ('0'..'7')
             |       
                 ('0'..'7') ('0'..'7') 
             |       
                 ('0'..'7')
             )          
;
    
// $ANTLR src "Windowing.g" 314
WS  :   (   ' '
        |   '\t'
        |   '\r'
        |   '\f'
        |   '\n'
        )+
        { $channel=HIDDEN; }
    ;
    
// $ANTLR src "Windowing.g" 323
fragment A:('a'|'A');
// $ANTLR src "Windowing.g" 324
fragment B:('b'|'B');
// $ANTLR src "Windowing.g" 325
fragment C:('c'|'C');
// $ANTLR src "Windowing.g" 326
fragment D:('d'|'D');
// $ANTLR src "Windowing.g" 327
fragment E:('e'|'E');
// $ANTLR src "Windowing.g" 328
fragment F:('f'|'F');
// $ANTLR src "Windowing.g" 329
fragment G:('g'|'G');
// $ANTLR src "Windowing.g" 330
fragment H:('h'|'H');
// $ANTLR src "Windowing.g" 331
fragment I:('i'|'I');
// $ANTLR src "Windowing.g" 332
fragment J:('j'|'J');
// $ANTLR src "Windowing.g" 333
fragment K:('k'|'K');
// $ANTLR src "Windowing.g" 334
fragment L:('l'|'L');
// $ANTLR src "Windowing.g" 335
fragment M:('m'|'M');
// $ANTLR src "Windowing.g" 336
fragment N:('n'|'N');
// $ANTLR src "Windowing.g" 337
fragment O:('o'|'O');
// $ANTLR src "Windowing.g" 338
fragment P:('p'|'P');
// $ANTLR src "Windowing.g" 339
fragment Q:('q'|'Q');
// $ANTLR src "Windowing.g" 340
fragment R:('r'|'R');
// $ANTLR src "Windowing.g" 341
fragment S:('s'|'S');
// $ANTLR src "Windowing.g" 342
fragment T:('t'|'T');
// $ANTLR src "Windowing.g" 343
fragment U:('u'|'U');
// $ANTLR src "Windowing.g" 344
fragment V:('v'|'V');
// $ANTLR src "Windowing.g" 345
fragment W:('w'|'W');
// $ANTLR src "Windowing.g" 346
fragment X:('x'|'X');
// $ANTLR src "Windowing.g" 347
fragment Y:('y'|'Y');
// $ANTLR src "Windowing.g" 348
fragment Z:('z'|'Z');
  

