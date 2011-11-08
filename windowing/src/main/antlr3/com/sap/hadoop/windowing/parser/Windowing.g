grammar Windowing;

options {
  language = Java;
  output = AST;
}

tokens {
  NUMERIC;
  INTEGER;
  UMINUS;
  PARAM;
  ORDERCOLUMN;
  FUNCTION;
  FUNCTIONS;
  QUERY;
  WINDOWRANGE;
  WINDOWVALUES;
  TYPENAME;
  SELECTCOLUMN;
}

@header {
package com.sap.hadoop.windowing.parser;
}

@lexer::header {
package com.sap.hadoop.windowing.parser;
}

@init {
}

@members {
	protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException
	{
		throw new MismatchedTokenException(ttype, input);
	}
	public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException
	{
		throw e;
	}
}

@rulecatch {
catch (RecognitionException rex) {
throw rex;
}
}


query :
 FROM tableSpec
 partitionby
 orderby
 WITH funclist
 select
 where? -> ^(QUERY tableSpec partitionby orderby funclist select where?)
;

tableSpec :
 hivetable
;

hivetable :
 TABLEINPUT LPAREN (namevalue)? (COMMA namevalue)* RPAREN  -> ^(TABLEINPUT namevalue*)
;

namevalue :
 (i=ID|i=STRING) EQ v=STRING -> ^(PARAM $i $v)
;

orderby :
 ORDER BY ordercolumn (COMMA ordercolumn)* -> ^(ORDER ordercolumn+)
;

ordercolumn :
 ID (o=ASC | o=DESC)? -> ^(ORDERCOLUMN ID $o?)
;

partitionby :	
 PARTITION BY ID (COMMA ID)* -> ^(PARTITION ID+)
;

funclist :	
 function (COMMA function)* -> ^(FUNCTIONS function+)
;

function :	
 name=ID LPAREN (functionparam)? (COMMA functionparam)* RPAREN (window_expression)? AS alias=ID (LBRACKET typeNm=ID RBRACKET)? -> 
      ^(FUNCTION $name $alias functionparam* ^(TYPENAME $typeNm)? window_expression?)
;

functionparam  :	
 GROOVYEXPRESSION | STRING | ID | NUMBER
;

window_expression :
 OVER!	
 (window_range_expression |
 window_value_expression
 )
;
	
window_range_expression :
 ROWS BETWEEN s=rowsboundary AND e=rowsboundary -> ^(WINDOWRANGE $s $e)
;

rowsboundary :
  UNBOUNDED (r=PRECEDING|r=FOLLOWING)  -> ^($r UNBOUNDED) | 
  CURRENT ROW  -> ^(CURRENT) |
  NUMBER (d=PRECEDING | d=FOLLOWING ) -> ^($d NUMBER)
;

window_value_expression :
 RANGE BETWEEN s=valuesboundary AND e=valuesboundary -> ^(WINDOWVALUES $s $e)
;

valuesboundary :
  UNBOUNDED (r=PRECEDING|r=FOLLOWING)  -> ^($r UNBOUNDED) | 
  CURRENT ROW  -> ^(CURRENT) |
  GROOVYEXPRESSION NUMBER (d=LESS | d=MORE ) -> ^($d GROOVYEXPRESSION NUMBER)
;

select 	:
  SELECT selectColumn (COMMA selectColumn)*  -> ^(SELECT selectColumn+)
;

selectColumn:
  GROOVYEXPRESSION AS ID (LBRACKET typeNm=ID RBRACKET)? -> ^(SELECTCOLUMN ID GROOVYEXPRESSION ^(TYPENAME $typeNm)?) |
  ID -> ^(SELECTCOLUMN ID)
;

where :	
 (WHERE GROOVYEXPRESSION) -> ^(WHERE GROOVYEXPRESSION)
;

value_expression :
  numeric_expression |
  STRING
;

numeric_expression :	
  term ((PLUS | MINUS)=> (PLUS^ | MINUS^) term )*	
;
	
term 	:	
  numeric_primary_expression ((ASTERISK | SOLIDUS)=> (ASTERISK^ | SOLIDUS^) numeric_primary_expression)*
;

numeric_primary_expression :	
  identifier | 
  signed_numeric_literal | 
  LPAREN numeric_expression RPAREN
	;

signed_numeric_literal :
  (PLUS|MINUS)? unsigned_numeric_literal
;

/*
  numbers
*/
unsigned_numeric_literal :
  exact_numeric_literal |
  approximate_numeric_literal
;

approximate_numeric_literal :
  mantissa 'E' exponent
;

exponent :
  PLUS NUMBER -> NUMBER |
  MINUS NUMBER -> ^(UMINUS NUMBER) |
  NUMBER -> NUMBER
;

mantissa : 
  exact_numeric_literal
;  

exact_numeric_literal :

  n1=NUMBER (DOT n2=NUMBER)?  -> 
      {
	      ( $n2 != null ? adaptor.create(NUMERIC, $n1.text + '.' + $n2.text) :  adaptor.create(INTEGER, $n1.text) )
      }  |
  DOT n1=NUMBER -> { adaptor.create(NUMERIC, '.' + $n1.text)} 
;

identifier :
  ID
;

/*
  Lexer Rules
*/

QUOTE             : '\'';
ASTERISK          : '*';
COLON             : ':';
SEMICOLON         : ';';
COMMA             : ',';
DOT               : '.';
EQ                : '=';
GE                : '>=';
GT                : '>';
LBRACKET          : '[';
LBRACE            : '{';
LE                : '<=';
LPAREN            : '(';
LT                : '<';
MINUS             : '-';
NE                : '<>';
PLUS              : '+';
RBRACE            : '}';
RBRACKET          : ']';
RPAREN            : ')';
SOLIDUS           : '/';

SELECT            : S E L E C T;
FROM              : F R O M;
WHERE             : W H E R E;
TABLEINPUT        : T A B L E I N P U T;
ORDER             : O R D E R;
BY                : B Y;
PARTITION         : P A R T I T I O N;
WITH              : W I T H;
ROWS              : R O W S;
RANGE 	          : R A N G E;
BETWEEN 	  : B E T W E E N;
CURRENT		  : C U R R E N T;
ROW		  : R O W;
UNBOUNDED   	  : U N B O U N D E D;
PRECEDING         : P R E C E D I N G;
FOLLOWING         : F O L L O W I N G;
LESS		  : L E S S;
MORE		  : M O R E;
AS		  : A S;
OVER		  : O V E R;
/*
/*
  boolean operators
*/
AND               : A N D;
NOT               : N O T;
OR                : O R;
XOR               : X O R;

ASC               : A S C;
DESC              : D E S C;

NUMBER    : ('0'..'9')+
    ;
ID    :  ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
    ;

GROOVYEXPRESSION : '<' 
		(GroovyEscapeSequence | ~('>'))*
		'>' {setText(getText().substring(1, getText().length()-1));}
;

fragment
GroovyEscapeSequence :	
  '\\' '>'
;    

STRING
    :   '\'' 
        (   EscapeSequence
        |   ~( '\\' | '\'' | '\r' | '\n' )        
        )* 
        '\''  {setText(getText().substring(1, getText().length()-1));}
    ;

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
    
WS  :   (   ' '
        |   '\t'
        |   '\r'
        |   '\f'
        |   '\n'
        )+
        { $channel=HIDDEN; }
    ;
    
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');
  

