grammar Windowing2;

options {
  language = Java;
  output = AST;
  k=3;
}

tokens {
  NUMERIC;
  INTEGER;
  UMINUS;
  PARAM;
  ORDERCOLUMN;
  FUNCTION;
  WDW_FUNCTION;
  FUNCTIONS;
  QUERY;
  WINDOWRANGE;
  WINDOWVALUES;
  TYPENAME;
  SELECTCOLUMN;
  OUTPUTSPEC;
  TBLFUNCTION;
  LOADSPEC;
  STRINGLITERALSEQUENCE;
  CHARSETLITERAL;
  NOTNULL;
  FUNCTIONSTAR;
  FUNCTIONDIST;
  WDW_FUNCTIONSTAR;
  WDW_FUNCTIONDIST;
  TABLEORCOL;
  COLUMNREF;
  WINDOWSPEC;
  WINDOWDEF;
  INPUT;
  HDFSLOCATION;
  HIVEQ;
  HIVETBL;
  UPLUS;
  UMINUS;
}

@header {
package com.sap.hadoop.windowing.parser;

import com.sap.hadoop.windowing.functions2.FunctionRegistry;
}

@lexer::header {
package com.sap.hadoop.windowing.parser;
}

@init {
}

@members {
  protected StringBuilder buf = new StringBuilder();
  
  /*protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException
  {
    throw new MismatchedTokenException(ttype, input);
  }
  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException
  {
    throw e;
  }
  protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
    throws RecognitionException
  {
  throw new MismatchedTokenException(ttype, input);
  }
  */
  public void emitErrorMessage(String msg) {
    buf.append(msg).append("\n");
  }
  
  public String getWindowingParseErrors()
  {
    String b = buf.toString().trim();
    if (b.equals("") ) return null;
    return b;
  }
  
  public boolean isWindowFunction(Token t)
  {
     return FunctionRegistry.isWindowFunction(t.getText());
  }
  
}

query :
  (queryForm1 | queryForm2) EOF!
;

queryForm1 :
 select
 FROM tableSpec
 where? 
 window_clause?
 outputClause? 
 -> ^(QUERY tableSpec select where? window_clause? outputClause?)
;

queryForm2 :
 FROM tableSpec
 select
 where? 
 window_clause?
 outputClause? 
 -> ^(QUERY tableSpec select where? window_clause? outputClause?)
;

select  :
  SELECT selectColumn (COMMA selectColumn)*  -> ^(SELECT selectColumn+)
;

selectColumn:
  expression (AS Identifier)? -> ^(SELECTCOLUMN expression Identifier?) |
  window_function AS Identifier -> ^(SELECTCOLUMN window_function Identifier)
;

tableSpec :
 (tf=tblfunc |
  hq=hiveQuery |
  hdf=hdfsFile |
  hvT=hiveTable
 ) (p=partitionby (o=orderby)? )? 
 -> {tf != null}? ^(INPUT $tf $p? $o?)
 -> {hq != null}? ^(INPUT $hq $p? $o?)
 -> {hdf != null}? ^(INPUT $hdf $p? $o?)
 ->  ^(INPUT $hvT $p? $o?)
;

hiveQuery :	
 HIVEQUERY
; 

hiveTable :
  i1=Identifier (DOT i2=Identifier)?
  -> {$i2 != null}? ^(HIVETBL $i1 $i2)
  ->                ^(HIVETBL $i1)
;

tblfunc :
  name=Identifier LPAREN tableSpec (COMMA expression)* RPAREN
    -> ^(TBLFUNCTION $name tableSpec expression*)
;

hdfsFile :
 FILEINPUT LPAREN (namevalue)? (COMMA namevalue)* RPAREN  -> ^(HDFSLOCATION namevalue*)
;

where : 
 (WHERE expression) -> ^(WHERE expression)
;

outputClause :
 INTO PATH EQUAL p=StringLiteral s=outputSerDe? lc=loadClause? -> ^(OUTPUTSPEC $p $s? $lc?)
;

outputSerDe :
  SERDE s=StringLiteral p=outputSerDePropeties? o=outputFormatOrWriter -> ^(SERDE $s $o $p?)
;

outputSerDePropeties:
  WITH SERDEPROPERTIES LPAREN (namevalue)? (COMMA namevalue)* RPAREN 
     -> ^(SERDEPROPERTIES namevalue*)
;

outputFormatOrWriter :
  RECORDWRITER StringLiteral -> ^(RECORDWRITER StringLiteral) |
  FORMAT StringLiteral -> ^(FORMAT StringLiteral)
;

loadClause:
  LOAD ov=OVERWRITE? INTO TABLE t=Identifier (PARTITION l=StringLiteral)? -> ^(LOADSPEC $t $l? $ov?)
;

window_function 
  : 
  {isWindowFunction(input.LT(1))}? functionName 
    LPAREN 
    (
      (star=STAR)
      | (dist=DISTINCT)? (expression (COMMA expression)*)?
    ) 
    RPAREN (OVER ws=window_specification)? 
      -> {$star != null}? ^(WDW_FUNCTIONSTAR functionName $ws?)
      -> {$dist == null}? ^(WDW_FUNCTION functionName (expression+)? $ws?)
      ->                  ^(WDW_FUNCTIONDIST functionName (expression+)? $ws?)
;  

window_clause :
  WINDOW window_defn (COMMA window_defn)* -> ^(WINDOW window_defn+)
;  

window_defn :
  Identifier AS window_specification -> ^(WINDOWDEF Identifier window_specification)
;  

window_specification :
  Identifier? partitionby? orderby? window_frame? -> ^(WINDOWSPEC Identifier? partitionby? orderby? window_frame?)
;

orderby :
 ORDER BY ordercolumn ((COMMA ordercolumn)=> COMMA ordercolumn)* -> ^(ORDER ordercolumn+)
;

ordercolumn :
 columnReference (o=ASC | o=DESC)? -> ^(ORDERCOLUMN columnReference $o?)
;

partitionby : 
 PARTITION BY columnReference ((COMMA columnReference)=> COMMA columnReference)* -> ^(PARTITION columnReference+)
;

window_frame :
 window_range_expression |
 window_value_expression
;

window_range_expression :
 ROWS BETWEEN s=rowsboundary AND e=rowsboundary -> ^(WINDOWRANGE $s $e)
;

rowsboundary :
  UNBOUNDED (r=PRECEDING|r=FOLLOWING)  -> ^($r UNBOUNDED) | 
  CURRENT ROW  -> ^(CURRENT) |
  Number (d=PRECEDING | d=FOLLOWING ) -> ^($d Number)
;

window_value_expression :
 RANGE BETWEEN s=valuesboundary AND e=valuesboundary -> ^(WINDOWVALUES $s $e)
;

valuesboundary :
  UNBOUNDED (r=PRECEDING|r=FOLLOWING)  -> ^($r UNBOUNDED) | 
  CURRENT ROW  -> ^(CURRENT) |
  rowExp=expression rngExp=Number (d=LESS | d=MORE ) -> ^($d $rowExp $rngExp)
;

columnReference :
  i1=Identifier (DOT i2=Identifier)?
  -> {$i2 != null}? ^(COLUMNREF $i1 $i2)
  ->                ^(COLUMNREF $i1)
;  

tableOrColumn 
	:	
  Identifier -> ^(TABLEORCOL Identifier)
  ;	

function 
	:	
  functionName 
    LPAREN 
    (
      (star=STAR)
      | (dist=DISTINCT)? (expression (COMMA expression)*)?
    )
    RPAREN -> {$star != null}? ^(FUNCTIONSTAR functionName)
                  -> {$dist == null}? ^(FUNCTION functionName (expression+)?)
                  ->                           ^(FUNCTIONDIST functionName (expression+)?)
	;                  

functionName 
	:	
  Identifier | IF | ARRAY | MAP | STRUCT | UNION
	;  	

castExpr :	
  CAST LPAREN expression AS primitiveType RPAREN -> ^(FUNCTION primitiveType expression)
;

caseExpr :
  CASE expression
  (WHEN expression THEN expression)+
  (ELSE expression)?
  END -> ^(FUNCTION CASE expression*)
 ;

whenExpr  :
  CASE 
  (WHEN expression THEN expression)+
  (ELSE expression)?
  END -> ^(FUNCTION WHEN expression*)
;

constant :
  Number
  | StringLiteral
  | stringLiteralSequence
  | BigintLiteral
  | SmallintLiteral
  | TinyintLiteral
  | charSetStringLiteral
  | booleanValue
;

stringLiteralSequence :
    StringLiteral StringLiteral+ -> ^(STRINGLITERALSEQUENCE StringLiteral StringLiteral+)
;

charSetStringLiteral :
    csName=CharSetName csLiteral=CharSetLiteral -> ^(CHARSETLITERAL $csName $csLiteral)
;

expressions :
  LPAREN expression (COMMA expression)* RPAREN -> expression*
;

expression :
  orExpr
;

orExpr :
  andExpr (OR^ andExpr)*
;

andExpr :
  notExpr (AND^ notExpr)*
;

notExpr :
  (NOT^)* compareExpr
;

negatableOperator :
  LIKE | RLIKE | REGEXP
;

compareOperator :
  negatableOperator  | EQUAL | EQUAL_NS | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | 
  GREATERTHANOREQUALTO | GREATERTHAN
;

compareExpr :
  (l=bitOrExpr -> $l)
  (
    (   NOT nO=negatableOperator r=bitOrExpr -> ^(NOT  ^($nO $compareExpr $r))   )  |
    (   cO=compareOperator r=bitOrExpr ->  ^($cO $compareExpr $r)             )  |
    (   NOT IN el=expressions -> ^(NOT  ^(FUNCTION IN  $compareExpr $el) )         )   |
    (   IN expressions -> ^(FUNCTION IN  $compareExpr $el)                        )   |
    (   NOT BETWEEN min=bitOrExpr AND max=bitOrExpr -> ^(FUNCTION BETWEEN TRUE $compareExpr $min $max)    )   |
    (   BETWEEN  min=bitOrExpr AND  max=bitOrExpr ->  ^(FUNCTION BETWEEN FALSE $compareExpr $min $max) )
  )*
;

bitOrExpr :
  bitAndExpr (BITWISEOR^ bitAndExpr)*
;

bitAndExpr :
  plusExpr (AMPERSAND^ plusExpr)*
;

plusExpr :
  starExpr ((PLUS^ | MINUS^ ) starExpr)*
; 

starExpr :
  xorExpr ((STAR^ | DIVIDE^ | MOD^ | DIV^) xorExpr)*
;

xorExpr :
  nullExpr (BITWISEXOR nullExpr)*
;

nullCondition :
  NULL |
  NOT NULL -> ^(NOTNULL)
;

nullExpr :
  unaryExpr (i=IS nullCondition)?
  -> {$i != null}? ^(FUNCTION nullCondition unaryExpr)
  -> unaryExpr
;

unaryExpr :
  (PLUS^ | 
   MINUS^ | 
   TILDE^
   )* 
  fieldExpr
;

fieldExpr :
  atomExpr ((LSQUARE^ expression RSQUARE!) | (DOT^ Identifier))*
;

atomExpr :
  NULL 
  | constant
  | function
  | castExpr
  | caseExpr
  | whenExpr
  | tableOrColumn
  | LPAREN! expression RPAREN!
;

booleanValue
    :
    TRUE^ | FALSE^
;

primitiveType : 
      TINYINT       
    | SMALLINT
    | INT
    | BIGINT
    | BOOLEAN
    | FLOAT
    | DOUBLE
    | DATE
    | DATETIME
    | TIMESTAMP
    | STRING
    | BINARY
;

namevalue :
 (i=Identifier|i=StringLiteral) EQUAL v=StringLiteral -> ^(PARAM $i $v)
;



SELECT            : S E L E C T;
FROM              : F R O M;
WHERE             : W H E R E;
FILEINPUT        : F I L E I N P U T;
ORDER             : O R D E R;
BY                : B Y;
PARTITION         : P A R T I T I O N;
WITH              : W I T H;
ROWS              : R O W S;
RANGE             : R A N G E;
BETWEEN           : B E T W E E N;
CURRENT           : C U R R E N T;
ROW               : R O W;
UNBOUNDED         : U N B O U N D E D;
PRECEDING         : P R E C E D I N G;
FOLLOWING         : F O L L O W I N G;
LESS              : L E S S;
MORE              : M O R E;
AS                : A S;
OVER              : O V E R;
INTO              : I N T O;
PATH              : P A T H;
FORMAT            : F O R M A T;
SERDE             : S E R D E;
SERDEPROPERTIES   : S E R D E P R O P E R T I E S;
RECORDWRITER      : R E C O R D W R I T E R;
LOAD              : L O A D;
TABLE             : T A B L E;
OVERWRITE         : O V E R W R I T E;
TRUE              : T R U E;
FALSE             : F A L S E;
LIKE              : L I K E;
RLIKE             : R L I K E;
REGEXP            : R E G E X P;
IN                : I N;
THEN           : T H E N;
IS                : I S;
NULL              : N U L L;
CASE              : C A S E;
WHEN              : W H E N;
ELSE              : E L S E;
END               : E N D;
CAST             : C A S T;
TINYINT    
	:	T I N Y I N T;   
SMALLINT 
	:	S M A L L I N T;	
INT 	:	 I N T;
BIGINT : B I G I N T;
BOOLEAN :	B O O L E A N;
FLOAT : F L O A T;
DOUBLE 	:	D O U B L E;
DATE 	:	D A T E;
DATETIME : D A T E T I M E;
TIMESTAMP 
	:	 T I M E S T A M P;
STRING : S T R I N G;
BINARY 	:	 B I N A R Y;		
IF 	:	 I F;
ARRAY 	:	A R R A Y;
MAP 	:	M A P;
STRUCT 	:	S T R U C T;
UNION 	:	U N I O N;
DISTINCT  
	:	D I S T I N C T;
WINDOW : W I N D O W;	
ASC               : A S C;
DESC              : D E S C;
/*
 Operators
*/
DOT : '.'; 
COLON : ':' ;
COMMA : ',' ;
SEMICOLON : ';' ;

LPAREN : '(' ;
RPAREN : ')' ;
LSQUARE : '[' ;
RSQUARE : ']' ;
LCURLY : '{';
RCURLY : '}';

EQUAL : '=' | '==';
EQUAL_NS : '<=>';
NOTEQUAL : '<>' | '!=';
LESSTHANOREQUALTO : '<=';
LESSTHAN : '<';
GREATERTHANOREQUALTO : '>=';
GREATERTHAN : '>';
AND               : A N D;
NOT               : N O T;
OR                : O R;
XOR               : X O R;


DIVIDE : '/';
PLUS : '+';
MINUS : '-';
STAR : '*';
MOD : '%';
DIV : 'DIV';

AMPERSAND : '&';
TILDE : '~';
BITWISEOR : '|';
BITWISEXOR : '^';
QUESTION : '?';
DOLLAR : '$';

HIVEQUERY : '<<' 
    ( options {greedy=false;} : . )*
    '>>' {setText(getText().substring(2, getText().length()-2));}
;

fragment
HiveQueryEscapeSequence :	
  '\\' '>'
; 
StringLiteral
    :
    ( '\'' ( ~('\''|'\\') | EscapeSequence )* '\''
    | '\"' ( ~('\"'|'\\') | EscapeSequence )* '\"'
    )+
;

CharSetLiteral
    :
    StringLiteral
    | '0' 'X' (HexDigit|Digit)+
;

CharSetName
    :
    '_' (Letter | Digit | '_' | '-' | '.' | ':' )+
;

BigintLiteral
    :
    (Digit)+ 'L'
;

SmallintLiteral
    :
    (Digit)+ 'S'
;

TinyintLiteral
    :
    (Digit)+ 'Y'
;

Number
    :
    (Digit)+ ( DOT (Digit)* (Exponent)? | Exponent)?
;

Identifier
    :
    (Letter | Digit) (Letter | Digit | '_')*
    | '`' RegexComponent+ '`'
;
    

WS  :   (   ' '
        |   '\t'
        |   '\r'
        |   '\f'
        |   '\n'
        )+
        { $channel=HIDDEN; }
;

COMMENT
  : '--' (~('\n'|'\r'))*
    { $channel=HIDDEN; }
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

fragment
Letter
    : 'a'..'z' | 'A'..'Z'
;

fragment
HexDigit
    : 'a'..'f' | 'A'..'F'
;

fragment
Digit
    :
    '0'..'9'
;

fragment
Exponent
    :
    ('e' | 'E') ( PLUS|MINUS )? (Digit)+
;

fragment
RegexComponent
    : 'a'..'z' | 'A'..'Z' | '0'..'9' | '_'
    | PLUS | STAR | QUESTION | MINUS | DOT
    | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY
    | BITWISEXOR | BITWISEOR | DOLLAR
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