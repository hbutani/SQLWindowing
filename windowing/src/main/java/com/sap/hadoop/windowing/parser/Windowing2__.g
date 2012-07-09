lexer grammar Windowing2;
options {
  language=Java;

}
@header {
package com.sap.hadoop.windowing.parser;
}

// $ANTLR src "Windowing2.g" 447
SELECT            : S E L E C T;
// $ANTLR src "Windowing2.g" 448
FROM              : F R O M;
// $ANTLR src "Windowing2.g" 449
WHERE             : W H E R E;
// $ANTLR src "Windowing2.g" 450
FILEINPUT        : F I L E I N P U T;
// $ANTLR src "Windowing2.g" 451
ORDER             : O R D E R;
// $ANTLR src "Windowing2.g" 452
BY                : B Y;
// $ANTLR src "Windowing2.g" 453
PARTITION         : P A R T I T I O N;
// $ANTLR src "Windowing2.g" 454
WITH              : W I T H;
// $ANTLR src "Windowing2.g" 455
ROWS              : R O W S;
// $ANTLR src "Windowing2.g" 456
RANGE             : R A N G E;
// $ANTLR src "Windowing2.g" 457
BETWEEN           : B E T W E E N;
// $ANTLR src "Windowing2.g" 458
CURRENT           : C U R R E N T;
// $ANTLR src "Windowing2.g" 459
ROW               : R O W;
// $ANTLR src "Windowing2.g" 460
UNBOUNDED         : U N B O U N D E D;
// $ANTLR src "Windowing2.g" 461
PRECEDING         : P R E C E D I N G;
// $ANTLR src "Windowing2.g" 462
FOLLOWING         : F O L L O W I N G;
// $ANTLR src "Windowing2.g" 463
LESS              : L E S S;
// $ANTLR src "Windowing2.g" 464
MORE              : M O R E;
// $ANTLR src "Windowing2.g" 465
AS                : A S;
// $ANTLR src "Windowing2.g" 466
OVER              : O V E R;
// $ANTLR src "Windowing2.g" 467
INTO              : I N T O;
// $ANTLR src "Windowing2.g" 468
PATH              : P A T H;
// $ANTLR src "Windowing2.g" 469
FORMAT            : F O R M A T;
// $ANTLR src "Windowing2.g" 470
SERDE             : S E R D E;
// $ANTLR src "Windowing2.g" 471
SERDEPROPERTIES   : S E R D E P R O P E R T I E S;
// $ANTLR src "Windowing2.g" 472
RECORDWRITER      : R E C O R D W R I T E R;
// $ANTLR src "Windowing2.g" 473
LOAD              : L O A D;
// $ANTLR src "Windowing2.g" 474
TABLE             : T A B L E;
// $ANTLR src "Windowing2.g" 475
OVERWRITE         : O V E R W R I T E;
// $ANTLR src "Windowing2.g" 476
TRUE              : T R U E;
// $ANTLR src "Windowing2.g" 477
FALSE             : F A L S E;
// $ANTLR src "Windowing2.g" 478
LIKE              : L I K E;
// $ANTLR src "Windowing2.g" 479
RLIKE             : R L I K E;
// $ANTLR src "Windowing2.g" 480
REGEXP            : R E G E X P;
// $ANTLR src "Windowing2.g" 481
IN                : I N;
// $ANTLR src "Windowing2.g" 482
THEN           : T H E N;
// $ANTLR src "Windowing2.g" 483
IS                : I S;
// $ANTLR src "Windowing2.g" 484
NULL              : N U L L;
// $ANTLR src "Windowing2.g" 485
CASE              : C A S E;
// $ANTLR src "Windowing2.g" 486
WHEN              : W H E N;
// $ANTLR src "Windowing2.g" 487
ELSE              : E L S E;
// $ANTLR src "Windowing2.g" 488
END               : E N D;
// $ANTLR src "Windowing2.g" 489
CAST             : C A S T;
// $ANTLR src "Windowing2.g" 490
TINYINT    
	:	T I N Y I N T;   
// $ANTLR src "Windowing2.g" 492
SMALLINT 
	:	S M A L L I N T;	
// $ANTLR src "Windowing2.g" 494
INT 	:	 I N T;
// $ANTLR src "Windowing2.g" 495
BIGINT : B I G I N T;
// $ANTLR src "Windowing2.g" 496
BOOLEAN :	B O O L E A N;
// $ANTLR src "Windowing2.g" 497
FLOAT : F L O A T;
// $ANTLR src "Windowing2.g" 498
DOUBLE 	:	D O U B L E;
// $ANTLR src "Windowing2.g" 499
DATE 	:	D A T E;
// $ANTLR src "Windowing2.g" 500
DATETIME : D A T E T I M E;
// $ANTLR src "Windowing2.g" 501
TIMESTAMP 
	:	 T I M E S T A M P;
// $ANTLR src "Windowing2.g" 503
STRING : S T R I N G;
// $ANTLR src "Windowing2.g" 504
BINARY 	:	 B I N A R Y;		
// $ANTLR src "Windowing2.g" 505
IF 	:	 I F;
// $ANTLR src "Windowing2.g" 506
ARRAY 	:	A R R A Y;
// $ANTLR src "Windowing2.g" 507
MAP 	:	M A P;
// $ANTLR src "Windowing2.g" 508
STRUCT 	:	S T R U C T;
// $ANTLR src "Windowing2.g" 509
UNION 	:	U N I O N;
// $ANTLR src "Windowing2.g" 510
DISTINCT  
	:	D I S T I N C T;
// $ANTLR src "Windowing2.g" 512
WINDOW : W I N D O W;	
// $ANTLR src "Windowing2.g" 513
ASC               : A S C;
// $ANTLR src "Windowing2.g" 514
DESC              : D E S C;
/*
 Operators
*/
// $ANTLR src "Windowing2.g" 518
DOT : '.'; 
// $ANTLR src "Windowing2.g" 519
COLON : ':' ;
// $ANTLR src "Windowing2.g" 520
COMMA : ',' ;
// $ANTLR src "Windowing2.g" 521
SEMICOLON : ';' ;

// $ANTLR src "Windowing2.g" 523
LPAREN : '(' ;
// $ANTLR src "Windowing2.g" 524
RPAREN : ')' ;
// $ANTLR src "Windowing2.g" 525
LSQUARE : '[' ;
// $ANTLR src "Windowing2.g" 526
RSQUARE : ']' ;
// $ANTLR src "Windowing2.g" 527
LCURLY : '{';
// $ANTLR src "Windowing2.g" 528
RCURLY : '}';

// $ANTLR src "Windowing2.g" 530
EQUAL : '=' | '==';
// $ANTLR src "Windowing2.g" 531
EQUAL_NS : '<=>';
// $ANTLR src "Windowing2.g" 532
NOTEQUAL : '<>' | '!=';
// $ANTLR src "Windowing2.g" 533
LESSTHANOREQUALTO : '<=';
// $ANTLR src "Windowing2.g" 534
LESSTHAN : '<';
// $ANTLR src "Windowing2.g" 535
GREATERTHANOREQUALTO : '>=';
// $ANTLR src "Windowing2.g" 536
GREATERTHAN : '>';
// $ANTLR src "Windowing2.g" 537
AND               : A N D;
// $ANTLR src "Windowing2.g" 538
NOT               : N O T;
// $ANTLR src "Windowing2.g" 539
OR                : O R;
// $ANTLR src "Windowing2.g" 540
XOR               : X O R;


// $ANTLR src "Windowing2.g" 543
DIVIDE : '/';
// $ANTLR src "Windowing2.g" 544
PLUS : '+';
// $ANTLR src "Windowing2.g" 545
MINUS : '-';
// $ANTLR src "Windowing2.g" 546
STAR : '*';
// $ANTLR src "Windowing2.g" 547
MOD : '%';
// $ANTLR src "Windowing2.g" 548
DIV : 'DIV';

// $ANTLR src "Windowing2.g" 550
AMPERSAND : '&';
// $ANTLR src "Windowing2.g" 551
TILDE : '~';
// $ANTLR src "Windowing2.g" 552
BITWISEOR : '|';
// $ANTLR src "Windowing2.g" 553
BITWISEXOR : '^';
// $ANTLR src "Windowing2.g" 554
QUESTION : '?';
// $ANTLR src "Windowing2.g" 555
DOLLAR : '$';

// $ANTLR src "Windowing2.g" 557
HIVEQUERY : '<' 
		(HiveQueryEscapeSequence | ~('>'))*
		'>' {setText(getText().substring(1, getText().length()-1).replaceAll("\\\\>", ">"));}
;

// $ANTLR src "Windowing2.g" 562
fragment
HiveQueryEscapeSequence :	
  '\\' '>'
; 
// $ANTLR src "Windowing2.g" 566
StringLiteral
    :
    ( '\'' ( ~('\''|'\\') | EscapeSequence )* '\''
    | '\"' ( ~('\"'|'\\') | EscapeSequence )* '\"'
    )+
;

// $ANTLR src "Windowing2.g" 573
CharSetLiteral
    :
    StringLiteral
    | '0' 'X' (HexDigit|Digit)+
;

// $ANTLR src "Windowing2.g" 579
CharSetName
    :
    '_' (Letter | Digit | '_' | '-' | '.' | ':' )+
;

// $ANTLR src "Windowing2.g" 584
BigintLiteral
    :
    (Digit)+ 'L'
;

// $ANTLR src "Windowing2.g" 589
SmallintLiteral
    :
    (Digit)+ 'S'
;

// $ANTLR src "Windowing2.g" 594
TinyintLiteral
    :
    (Digit)+ 'Y'
;

// $ANTLR src "Windowing2.g" 599
Number
    :
    (Digit)+ ( DOT (Digit)* (Exponent)? | Exponent)?
;

// $ANTLR src "Windowing2.g" 604
Identifier
    :
    (Letter | Digit) (Letter | Digit | '_')*
    | '`' RegexComponent+ '`'
;
    

// $ANTLR src "Windowing2.g" 611
WS  :   (   ' '
        |   '\t'
        |   '\r'
        |   '\f'
        |   '\n'
        )+
        { $channel=HIDDEN; }
;

// $ANTLR src "Windowing2.g" 620
COMMENT
  : '--' (~('\n'|'\r'))*
    { $channel=HIDDEN; }
  ;

// $ANTLR src "Windowing2.g" 625
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

// $ANTLR src "Windowing2.g" 645
fragment
Letter
    : 'a'..'z' | 'A'..'Z'
;

// $ANTLR src "Windowing2.g" 650
fragment
HexDigit
    : 'a'..'f' | 'A'..'F'
;

// $ANTLR src "Windowing2.g" 655
fragment
Digit
    :
    '0'..'9'
;

// $ANTLR src "Windowing2.g" 661
fragment
Exponent
    :
    ('e' | 'E') ( PLUS|MINUS )? (Digit)+
;

// $ANTLR src "Windowing2.g" 667
fragment
RegexComponent
    : 'a'..'z' | 'A'..'Z' | '0'..'9' | '_'
    | PLUS | STAR | QUESTION | MINUS | DOT
    | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY
    | BITWISEXOR | BITWISEOR | DOLLAR
;


// $ANTLR src "Windowing2.g" 676
fragment A:('a'|'A');
// $ANTLR src "Windowing2.g" 677
fragment B:('b'|'B');
// $ANTLR src "Windowing2.g" 678
fragment C:('c'|'C');
// $ANTLR src "Windowing2.g" 679
fragment D:('d'|'D');
// $ANTLR src "Windowing2.g" 680
fragment E:('e'|'E');
// $ANTLR src "Windowing2.g" 681
fragment F:('f'|'F');
// $ANTLR src "Windowing2.g" 682
fragment G:('g'|'G');
// $ANTLR src "Windowing2.g" 683
fragment H:('h'|'H');
// $ANTLR src "Windowing2.g" 684
fragment I:('i'|'I');
// $ANTLR src "Windowing2.g" 685
fragment J:('j'|'J');
// $ANTLR src "Windowing2.g" 686
fragment K:('k'|'K');
// $ANTLR src "Windowing2.g" 687
fragment L:('l'|'L');
// $ANTLR src "Windowing2.g" 688
fragment M:('m'|'M');
// $ANTLR src "Windowing2.g" 689
fragment N:('n'|'N');
// $ANTLR src "Windowing2.g" 690
fragment O:('o'|'O');
// $ANTLR src "Windowing2.g" 691
fragment P:('p'|'P');
// $ANTLR src "Windowing2.g" 692
fragment Q:('q'|'Q');
// $ANTLR src "Windowing2.g" 693
fragment R:('r'|'R');
// $ANTLR src "Windowing2.g" 694
fragment S:('s'|'S');
// $ANTLR src "Windowing2.g" 695
fragment T:('t'|'T');
// $ANTLR src "Windowing2.g" 696
fragment U:('u'|'U');
// $ANTLR src "Windowing2.g" 697
fragment V:('v'|'V');
// $ANTLR src "Windowing2.g" 698
fragment W:('w'|'W');
// $ANTLR src "Windowing2.g" 699
fragment X:('x'|'X');
// $ANTLR src "Windowing2.g" 700
fragment Y:('y'|'Y');
// $ANTLR src "Windowing2.g" 701
fragment Z:('z'|'Z');