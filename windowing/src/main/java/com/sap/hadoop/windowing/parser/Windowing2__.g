lexer grammar Windowing2;
options {
  language=Java;

}
@header {
package com.sap.hadoop.windowing.parser;
}

// $ANTLR src "Windowing2.g" 431
SELECT            : S E L E C T;
// $ANTLR src "Windowing2.g" 432
FROM              : F R O M;
// $ANTLR src "Windowing2.g" 433
WHERE             : W H E R E;
// $ANTLR src "Windowing2.g" 434
FILEINPUT        : F I L E I N P U T;
// $ANTLR src "Windowing2.g" 435
ORDER             : O R D E R;
// $ANTLR src "Windowing2.g" 436
BY                : B Y;
// $ANTLR src "Windowing2.g" 437
PARTITION         : P A R T I T I O N;
// $ANTLR src "Windowing2.g" 438
WITH              : W I T H;
// $ANTLR src "Windowing2.g" 439
ROWS              : R O W S;
// $ANTLR src "Windowing2.g" 440
RANGE             : R A N G E;
// $ANTLR src "Windowing2.g" 441
BETWEEN           : B E T W E E N;
// $ANTLR src "Windowing2.g" 442
CURRENT           : C U R R E N T;
// $ANTLR src "Windowing2.g" 443
ROW               : R O W;
// $ANTLR src "Windowing2.g" 444
UNBOUNDED         : U N B O U N D E D;
// $ANTLR src "Windowing2.g" 445
PRECEDING         : P R E C E D I N G;
// $ANTLR src "Windowing2.g" 446
FOLLOWING         : F O L L O W I N G;
// $ANTLR src "Windowing2.g" 447
LESS              : L E S S;
// $ANTLR src "Windowing2.g" 448
MORE              : M O R E;
// $ANTLR src "Windowing2.g" 449
AS                : A S;
// $ANTLR src "Windowing2.g" 450
OVER              : O V E R;
// $ANTLR src "Windowing2.g" 451
INTO              : I N T O;
// $ANTLR src "Windowing2.g" 452
PATH              : P A T H;
// $ANTLR src "Windowing2.g" 453
FORMAT            : F O R M A T;
// $ANTLR src "Windowing2.g" 454
SERDE             : S E R D E;
// $ANTLR src "Windowing2.g" 455
SERDEPROPERTIES   : S E R D E P R O P E R T I E S;
// $ANTLR src "Windowing2.g" 456
RECORDWRITER      : R E C O R D W R I T E R;
// $ANTLR src "Windowing2.g" 457
LOAD              : L O A D;
// $ANTLR src "Windowing2.g" 458
TABLE             : T A B L E;
// $ANTLR src "Windowing2.g" 459
OVERWRITE         : O V E R W R I T E;
// $ANTLR src "Windowing2.g" 460
TRUE              : T R U E;
// $ANTLR src "Windowing2.g" 461
FALSE             : F A L S E;
// $ANTLR src "Windowing2.g" 462
LIKE              : L I K E;
// $ANTLR src "Windowing2.g" 463
RLIKE             : R L I K E;
// $ANTLR src "Windowing2.g" 464
REGEXP            : R E G E X P;
// $ANTLR src "Windowing2.g" 465
IN                : I N;
// $ANTLR src "Windowing2.g" 466
THEN           : T H E N;
// $ANTLR src "Windowing2.g" 467
IS                : I S;
// $ANTLR src "Windowing2.g" 468
NULL              : N U L L;
// $ANTLR src "Windowing2.g" 469
CASE              : C A S E;
// $ANTLR src "Windowing2.g" 470
WHEN              : W H E N;
// $ANTLR src "Windowing2.g" 471
ELSE              : E L S E;
// $ANTLR src "Windowing2.g" 472
END               : E N D;
// $ANTLR src "Windowing2.g" 473
CAST             : C A S T;
// $ANTLR src "Windowing2.g" 474
TINYINT    
	:	T I N Y I N T;   
// $ANTLR src "Windowing2.g" 476
SMALLINT 
	:	S M A L L I N T;	
// $ANTLR src "Windowing2.g" 478
INT 	:	 I N T;
// $ANTLR src "Windowing2.g" 479
BIGINT : B I G I N T;
// $ANTLR src "Windowing2.g" 480
BOOLEAN :	B O O L E A N;
// $ANTLR src "Windowing2.g" 481
FLOAT : F L O A T;
// $ANTLR src "Windowing2.g" 482
DOUBLE 	:	D O U B L E;
// $ANTLR src "Windowing2.g" 483
DATE 	:	D A T E;
// $ANTLR src "Windowing2.g" 484
DATETIME : D A T E T I M E;
// $ANTLR src "Windowing2.g" 485
TIMESTAMP 
	:	 T I M E S T A M P;
// $ANTLR src "Windowing2.g" 487
STRING : S T R I N G;
// $ANTLR src "Windowing2.g" 488
BINARY 	:	 B I N A R Y;		
// $ANTLR src "Windowing2.g" 489
IF 	:	 I F;
// $ANTLR src "Windowing2.g" 490
ARRAY 	:	A R R A Y;
// $ANTLR src "Windowing2.g" 491
MAP 	:	M A P;
// $ANTLR src "Windowing2.g" 492
STRUCT 	:	S T R U C T;
// $ANTLR src "Windowing2.g" 493
UNION 	:	U N I O N;
// $ANTLR src "Windowing2.g" 494
DISTINCT  
	:	D I S T I N C T;
// $ANTLR src "Windowing2.g" 496
WINDOW : W I N D O W;	
// $ANTLR src "Windowing2.g" 497
ASC               : A S C;
// $ANTLR src "Windowing2.g" 498
DESC              : D E S C;
/*
 Operators
*/
// $ANTLR src "Windowing2.g" 502
DOT : '.'; 
// $ANTLR src "Windowing2.g" 503
COLON : ':' ;
// $ANTLR src "Windowing2.g" 504
COMMA : ',' ;
// $ANTLR src "Windowing2.g" 505
SEMICOLON : ';' ;

// $ANTLR src "Windowing2.g" 507
LPAREN : '(' ;
// $ANTLR src "Windowing2.g" 508
RPAREN : ')' ;
// $ANTLR src "Windowing2.g" 509
LSQUARE : '[' ;
// $ANTLR src "Windowing2.g" 510
RSQUARE : ']' ;
// $ANTLR src "Windowing2.g" 511
LCURLY : '{';
// $ANTLR src "Windowing2.g" 512
RCURLY : '}';

// $ANTLR src "Windowing2.g" 514
EQUAL : '=' | '==';
// $ANTLR src "Windowing2.g" 515
EQUAL_NS : '<=>';
// $ANTLR src "Windowing2.g" 516
NOTEQUAL : '<>' | '!=';
// $ANTLR src "Windowing2.g" 517
LESSTHANOREQUALTO : '<=';
// $ANTLR src "Windowing2.g" 518
LESSTHAN : '<';
// $ANTLR src "Windowing2.g" 519
GREATERTHANOREQUALTO : '>=';
// $ANTLR src "Windowing2.g" 520
GREATERTHAN : '>';
// $ANTLR src "Windowing2.g" 521
AND               : A N D;
// $ANTLR src "Windowing2.g" 522
NOT               : N O T;
// $ANTLR src "Windowing2.g" 523
OR                : O R;
// $ANTLR src "Windowing2.g" 524
XOR               : X O R;


// $ANTLR src "Windowing2.g" 527
DIVIDE : '/';
// $ANTLR src "Windowing2.g" 528
PLUS : '+';
// $ANTLR src "Windowing2.g" 529
MINUS : '-';
// $ANTLR src "Windowing2.g" 530
STAR : '*';
// $ANTLR src "Windowing2.g" 531
MOD : '%';
// $ANTLR src "Windowing2.g" 532
DIV : 'DIV';

// $ANTLR src "Windowing2.g" 534
AMPERSAND : '&';
// $ANTLR src "Windowing2.g" 535
TILDE : '~';
// $ANTLR src "Windowing2.g" 536
BITWISEOR : '|';
// $ANTLR src "Windowing2.g" 537
BITWISEXOR : '^';
// $ANTLR src "Windowing2.g" 538
QUESTION : '?';
// $ANTLR src "Windowing2.g" 539
DOLLAR : '$';

// $ANTLR src "Windowing2.g" 541
HIVEQUERY : '<' 
		(HiveQueryEscapeSequence | ~('>'))*
		'>' {setText(getText().substring(1, getText().length()-1).replaceAll("\\\\>", ">"));}
;

// $ANTLR src "Windowing2.g" 546
fragment
HiveQueryEscapeSequence :	
  '\\' '>'
; 
// $ANTLR src "Windowing2.g" 550
StringLiteral
    :
    ( '\'' ( ~('\''|'\\') | EscapeSequence )* '\''
    | '\"' ( ~('\"'|'\\') | EscapeSequence )* '\"'
    )+
;

// $ANTLR src "Windowing2.g" 557
CharSetLiteral
    :
    StringLiteral
    | '0' 'X' (HexDigit|Digit)+
;

// $ANTLR src "Windowing2.g" 563
CharSetName
    :
    '_' (Letter | Digit | '_' | '-' | '.' | ':' )+
;

// $ANTLR src "Windowing2.g" 568
BigintLiteral
    :
    (Digit)+ 'L'
;

// $ANTLR src "Windowing2.g" 573
SmallintLiteral
    :
    (Digit)+ 'S'
;

// $ANTLR src "Windowing2.g" 578
TinyintLiteral
    :
    (Digit)+ 'Y'
;

// $ANTLR src "Windowing2.g" 583
Number
    :
    (Digit)+ ( DOT (Digit)* (Exponent)? | Exponent)?
;

// $ANTLR src "Windowing2.g" 588
Identifier
    :
    (Letter | Digit) (Letter | Digit | '_')*
    | '`' RegexComponent+ '`'
;
    

// $ANTLR src "Windowing2.g" 595
WS  :   (   ' '
        |   '\t'
        |   '\r'
        |   '\f'
        |   '\n'
        )+
        { $channel=HIDDEN; }
;

// $ANTLR src "Windowing2.g" 604
COMMENT
  : '--' (~('\n'|'\r'))*
    { $channel=HIDDEN; }
  ;

// $ANTLR src "Windowing2.g" 609
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

// $ANTLR src "Windowing2.g" 629
fragment
Letter
    : 'a'..'z' | 'A'..'Z'
;

// $ANTLR src "Windowing2.g" 634
fragment
HexDigit
    : 'a'..'f' | 'A'..'F'
;

// $ANTLR src "Windowing2.g" 639
fragment
Digit
    :
    '0'..'9'
;

// $ANTLR src "Windowing2.g" 645
fragment
Exponent
    :
    ('e' | 'E') ( PLUS|MINUS )? (Digit)+
;

// $ANTLR src "Windowing2.g" 651
fragment
RegexComponent
    : 'a'..'z' | 'A'..'Z' | '0'..'9' | '_'
    | PLUS | STAR | QUESTION | MINUS | DOT
    | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY
    | BITWISEXOR | BITWISEOR | DOLLAR
;


// $ANTLR src "Windowing2.g" 660
fragment A:('a'|'A');
// $ANTLR src "Windowing2.g" 661
fragment B:('b'|'B');
// $ANTLR src "Windowing2.g" 662
fragment C:('c'|'C');
// $ANTLR src "Windowing2.g" 663
fragment D:('d'|'D');
// $ANTLR src "Windowing2.g" 664
fragment E:('e'|'E');
// $ANTLR src "Windowing2.g" 665
fragment F:('f'|'F');
// $ANTLR src "Windowing2.g" 666
fragment G:('g'|'G');
// $ANTLR src "Windowing2.g" 667
fragment H:('h'|'H');
// $ANTLR src "Windowing2.g" 668
fragment I:('i'|'I');
// $ANTLR src "Windowing2.g" 669
fragment J:('j'|'J');
// $ANTLR src "Windowing2.g" 670
fragment K:('k'|'K');
// $ANTLR src "Windowing2.g" 671
fragment L:('l'|'L');
// $ANTLR src "Windowing2.g" 672
fragment M:('m'|'M');
// $ANTLR src "Windowing2.g" 673
fragment N:('n'|'N');
// $ANTLR src "Windowing2.g" 674
fragment O:('o'|'O');
// $ANTLR src "Windowing2.g" 675
fragment P:('p'|'P');
// $ANTLR src "Windowing2.g" 676
fragment Q:('q'|'Q');
// $ANTLR src "Windowing2.g" 677
fragment R:('r'|'R');
// $ANTLR src "Windowing2.g" 678
fragment S:('s'|'S');
// $ANTLR src "Windowing2.g" 679
fragment T:('t'|'T');
// $ANTLR src "Windowing2.g" 680
fragment U:('u'|'U');
// $ANTLR src "Windowing2.g" 681
fragment V:('v'|'V');
// $ANTLR src "Windowing2.g" 682
fragment W:('w'|'W');
// $ANTLR src "Windowing2.g" 683
fragment X:('x'|'X');
// $ANTLR src "Windowing2.g" 684
fragment Y:('y'|'Y');
// $ANTLR src "Windowing2.g" 685
fragment Z:('z'|'Z');