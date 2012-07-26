// $ANTLR 3.0.1 Windowing2.g 2012-07-13 18:13:50

package com.sap.hadoop.windowing.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Windowing2Lexer extends Lexer {
    public static final int CAST=85;
    public static final int FUNCTION=9;
    public static final int STAR=60;
    public static final int LSQUARE=119;
    public static final int ORDERCOLUMN=8;
    public static final int OVERWRITE=57;
    public static final int FUNCTIONS=11;
    public static final int ROW=75;
    public static final int MOD=113;
    public static final int OUTPUTSPEC=17;
    public static final int HDFSLOCATION=32;
    public static final int CASE=86;
    public static final int BITWISEXOR=115;
    public static final int PARAM=7;
    public static final int NOT=97;
    public static final int EOF=-1;
    public static final int TinyintLiteral=93;
    public static final int Identifier=40;
    public static final int NOTEQUAL=102;
    public static final int EQUAL_NS=101;
    public static final int RPAREN=44;
    public static final int RegexComponent=171;
    public static final int RECORDWRITER=54;
    public static final int PATH=48;
    public static final int WDW_FUNCTIONDIST=26;
    public static final int WINDOWRANGE=13;
    public static final int PRECEDING=72;
    public static final int CHARSETLITERAL=21;
    public static final int LESS=78;
    public static final int SERDEPROPERTIES=53;
    public static final int REGEXP=100;
    public static final int TINYINT=123;
    public static final int DOUBLE=129;
    public static final int STRINGLITERALSEQUENCE=20;
    public static final int COMMENT=173;
    public static final int SELECT=37;
    public static final int INTO=47;
    public static final int ARRAY=81;
    public static final int WINDOWSPEC=29;
    public static final int DIVIDE=112;
    public static final int GREATERTHAN=106;
    public static final int D=150;
    public static final int E=136;
    public static final int TYPENAME=15;
    public static final int F=140;
    public static final int G=154;
    public static final int A=153;
    public static final int B=151;
    public static final int C=138;
    public static final int ASC=66;
    public static final int L=137;
    public static final int M=143;
    public static final int WDW_FUNCTIONSTAR=25;
    public static final int WINDOWVALUES=14;
    public static final int N=147;
    public static final int O=142;
    public static final int HiveQueryEscapeSequence=165;
    public static final int H=145;
    public static final int I=146;
    public static final int NULL=116;
    public static final int J=174;
    public static final int ELSE=89;
    public static final int K=156;
    public static final int LOAD=56;
    public static final int U=149;
    public static final int T=139;
    public static final int W=144;
    public static final int LCURLY=160;
    public static final int V=155;
    public static final int Q=175;
    public static final int SEMICOLON=159;
    public static final int INT=125;
    public static final int P=148;
    public static final int RLIKE=99;
    public static final int S=135;
    public static final int R=141;
    public static final int NUMERIC=4;
    public static final int Y=152;
    public static final int HIVEQUERY=41;
    public static final int X=157;
    public static final int Z=176;
    public static final int WS=172;
    public static final int MORE=79;
    public static final int HIVETBL=34;
    public static final int OR=96;
    public static final int QUERY=12;
    public static final int SERDE=51;
    public static final int LESSTHANOREQUALTO=103;
    public static final int END=90;
    public static final int FROM=36;
    public static final int UNBOUNDED=71;
    public static final int FALSE=122;
    public static final int DISTINCT=61;
    public static final int EscapeSequence=166;
    public static final int Letter=169;
    public static final int TIMESTAMP=132;
    public static final int TBLFUNCTION=18;
    public static final int OVER=62;
    public static final int DOLLAR=164;
    public static final int WHERE=46;
    public static final int FILEINPUT=45;
    public static final int SELECTCOLUMN=16;
    public static final int ORDER=64;
    public static final int CharSetName=94;
    public static final int INPUT=31;
    public static final int TABLE=58;
    public static final int Exponent=170;
    public static final int LOADSPEC=19;
    public static final int WINDOWDEF=30;
    public static final int FLOAT=128;
    public static final int FOLLOWING=73;
    public static final int AND=70;
    public static final int NOTNULL=22;
    public static final int HexDigit=167;
    public static final int LPAREN=43;
    public static final int IF=80;
    public static final int AS=39;
    public static final int GREATERTHANOREQUALTO=105;
    public static final int BOOLEAN=127;
    public static final int THEN=88;
    public static final int IN=107;
    public static final int Number=76;
    public static final int COLUMNREF=28;
    public static final int COMMA=38;
    public static final int PARTITION=59;
    public static final int IS=117;
    public static final int EQUAL=49;
    public static final int WDW_FUNCTION=10;
    public static final int TILDE=118;
    public static final int PLUS=110;
    public static final int DOT=42;
    public static final int FUNCTIONDIST=24;
    public static final int WITH=52;
    public static final int LIKE=98;
    public static final int INTEGER=5;
    public static final int FUNCTIONSTAR=23;
    public static final int BY=65;
    public static final int LESSTHAN=104;
    public static final int XOR=162;
    public static final int UPLUS=35;
    public static final int DATETIME=131;
    public static final int AMPERSAND=109;
    public static final int RANGE=77;
    public static final int UMINUS=6;
    public static final int STRUCT=83;
    public static final int MINUS=111;
    public static final int RSQUARE=120;
    public static final int TABLEORCOL=27;
    public static final int Digit=168;
    public static final int Tokens=177;
    public static final int TRUE=121;
    public static final int BITWISEOR=108;
    public static final int UNION=84;
    public static final int CURRENT=74;
    public static final int StringLiteral=50;
    public static final int COLON=158;
    public static final int BigintLiteral=91;
    public static final int SmallintLiteral=92;
    public static final int CharSetLiteral=95;
    public static final int QUESTION=163;
    public static final int BIGINT=126;
    public static final int WHEN=87;
    public static final int HIVEQ=33;
    public static final int MAP=82;
    public static final int RCURLY=161;
    public static final int ROWS=68;
    public static final int WINDOW=63;
    public static final int FORMAT=55;
    public static final int DESC=67;
    public static final int DIV=114;
    public static final int BINARY=134;
    public static final int DATE=130;
    public static final int BETWEEN=69;
    public static final int STRING=133;
    public static final int SMALLINT=124;
    public Windowing2Lexer() {;} 
    public Windowing2Lexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "Windowing2.g"; }

    // $ANTLR start SELECT
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            // Windowing2.g:447:19: ( S E L E C T )
            // Windowing2.g:447:21: S E L E C T
            {
            mS(); 
            mE(); 
            mL(); 
            mE(); 
            mC(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SELECT

    // $ANTLR start FROM
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            // Windowing2.g:448:19: ( F R O M )
            // Windowing2.g:448:21: F R O M
            {
            mF(); 
            mR(); 
            mO(); 
            mM(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FROM

    // $ANTLR start WHERE
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            // Windowing2.g:449:19: ( W H E R E )
            // Windowing2.g:449:21: W H E R E
            {
            mW(); 
            mH(); 
            mE(); 
            mR(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WHERE

    // $ANTLR start FILEINPUT
    public final void mFILEINPUT() throws RecognitionException {
        try {
            int _type = FILEINPUT;
            // Windowing2.g:450:18: ( F I L E I N P U T )
            // Windowing2.g:450:20: F I L E I N P U T
            {
            mF(); 
            mI(); 
            mL(); 
            mE(); 
            mI(); 
            mN(); 
            mP(); 
            mU(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FILEINPUT

    // $ANTLR start ORDER
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            // Windowing2.g:451:19: ( O R D E R )
            // Windowing2.g:451:21: O R D E R
            {
            mO(); 
            mR(); 
            mD(); 
            mE(); 
            mR(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ORDER

    // $ANTLR start BY
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            // Windowing2.g:452:19: ( B Y )
            // Windowing2.g:452:21: B Y
            {
            mB(); 
            mY(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BY

    // $ANTLR start PARTITION
    public final void mPARTITION() throws RecognitionException {
        try {
            int _type = PARTITION;
            // Windowing2.g:453:19: ( P A R T I T I O N )
            // Windowing2.g:453:21: P A R T I T I O N
            {
            mP(); 
            mA(); 
            mR(); 
            mT(); 
            mI(); 
            mT(); 
            mI(); 
            mO(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PARTITION

    // $ANTLR start WITH
    public final void mWITH() throws RecognitionException {
        try {
            int _type = WITH;
            // Windowing2.g:454:19: ( W I T H )
            // Windowing2.g:454:21: W I T H
            {
            mW(); 
            mI(); 
            mT(); 
            mH(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WITH

    // $ANTLR start ROWS
    public final void mROWS() throws RecognitionException {
        try {
            int _type = ROWS;
            // Windowing2.g:455:19: ( R O W S )
            // Windowing2.g:455:21: R O W S
            {
            mR(); 
            mO(); 
            mW(); 
            mS(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ROWS

    // $ANTLR start RANGE
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            // Windowing2.g:456:19: ( R A N G E )
            // Windowing2.g:456:21: R A N G E
            {
            mR(); 
            mA(); 
            mN(); 
            mG(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RANGE

    // $ANTLR start BETWEEN
    public final void mBETWEEN() throws RecognitionException {
        try {
            int _type = BETWEEN;
            // Windowing2.g:457:19: ( B E T W E E N )
            // Windowing2.g:457:21: B E T W E E N
            {
            mB(); 
            mE(); 
            mT(); 
            mW(); 
            mE(); 
            mE(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BETWEEN

    // $ANTLR start CURRENT
    public final void mCURRENT() throws RecognitionException {
        try {
            int _type = CURRENT;
            // Windowing2.g:458:19: ( C U R R E N T )
            // Windowing2.g:458:21: C U R R E N T
            {
            mC(); 
            mU(); 
            mR(); 
            mR(); 
            mE(); 
            mN(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CURRENT

    // $ANTLR start ROW
    public final void mROW() throws RecognitionException {
        try {
            int _type = ROW;
            // Windowing2.g:459:19: ( R O W )
            // Windowing2.g:459:21: R O W
            {
            mR(); 
            mO(); 
            mW(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ROW

    // $ANTLR start UNBOUNDED
    public final void mUNBOUNDED() throws RecognitionException {
        try {
            int _type = UNBOUNDED;
            // Windowing2.g:460:19: ( U N B O U N D E D )
            // Windowing2.g:460:21: U N B O U N D E D
            {
            mU(); 
            mN(); 
            mB(); 
            mO(); 
            mU(); 
            mN(); 
            mD(); 
            mE(); 
            mD(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UNBOUNDED

    // $ANTLR start PRECEDING
    public final void mPRECEDING() throws RecognitionException {
        try {
            int _type = PRECEDING;
            // Windowing2.g:461:19: ( P R E C E D I N G )
            // Windowing2.g:461:21: P R E C E D I N G
            {
            mP(); 
            mR(); 
            mE(); 
            mC(); 
            mE(); 
            mD(); 
            mI(); 
            mN(); 
            mG(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PRECEDING

    // $ANTLR start FOLLOWING
    public final void mFOLLOWING() throws RecognitionException {
        try {
            int _type = FOLLOWING;
            // Windowing2.g:462:19: ( F O L L O W I N G )
            // Windowing2.g:462:21: F O L L O W I N G
            {
            mF(); 
            mO(); 
            mL(); 
            mL(); 
            mO(); 
            mW(); 
            mI(); 
            mN(); 
            mG(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FOLLOWING

    // $ANTLR start LESS
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            // Windowing2.g:463:19: ( L E S S )
            // Windowing2.g:463:21: L E S S
            {
            mL(); 
            mE(); 
            mS(); 
            mS(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LESS

    // $ANTLR start MORE
    public final void mMORE() throws RecognitionException {
        try {
            int _type = MORE;
            // Windowing2.g:464:19: ( M O R E )
            // Windowing2.g:464:21: M O R E
            {
            mM(); 
            mO(); 
            mR(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MORE

    // $ANTLR start AS
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            // Windowing2.g:465:19: ( A S )
            // Windowing2.g:465:21: A S
            {
            mA(); 
            mS(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AS

    // $ANTLR start OVER
    public final void mOVER() throws RecognitionException {
        try {
            int _type = OVER;
            // Windowing2.g:466:19: ( O V E R )
            // Windowing2.g:466:21: O V E R
            {
            mO(); 
            mV(); 
            mE(); 
            mR(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OVER

    // $ANTLR start INTO
    public final void mINTO() throws RecognitionException {
        try {
            int _type = INTO;
            // Windowing2.g:467:19: ( I N T O )
            // Windowing2.g:467:21: I N T O
            {
            mI(); 
            mN(); 
            mT(); 
            mO(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INTO

    // $ANTLR start PATH
    public final void mPATH() throws RecognitionException {
        try {
            int _type = PATH;
            // Windowing2.g:468:19: ( P A T H )
            // Windowing2.g:468:21: P A T H
            {
            mP(); 
            mA(); 
            mT(); 
            mH(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PATH

    // $ANTLR start FORMAT
    public final void mFORMAT() throws RecognitionException {
        try {
            int _type = FORMAT;
            // Windowing2.g:469:19: ( F O R M A T )
            // Windowing2.g:469:21: F O R M A T
            {
            mF(); 
            mO(); 
            mR(); 
            mM(); 
            mA(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FORMAT

    // $ANTLR start SERDE
    public final void mSERDE() throws RecognitionException {
        try {
            int _type = SERDE;
            // Windowing2.g:470:19: ( S E R D E )
            // Windowing2.g:470:21: S E R D E
            {
            mS(); 
            mE(); 
            mR(); 
            mD(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SERDE

    // $ANTLR start SERDEPROPERTIES
    public final void mSERDEPROPERTIES() throws RecognitionException {
        try {
            int _type = SERDEPROPERTIES;
            // Windowing2.g:471:19: ( S E R D E P R O P E R T I E S )
            // Windowing2.g:471:21: S E R D E P R O P E R T I E S
            {
            mS(); 
            mE(); 
            mR(); 
            mD(); 
            mE(); 
            mP(); 
            mR(); 
            mO(); 
            mP(); 
            mE(); 
            mR(); 
            mT(); 
            mI(); 
            mE(); 
            mS(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SERDEPROPERTIES

    // $ANTLR start RECORDWRITER
    public final void mRECORDWRITER() throws RecognitionException {
        try {
            int _type = RECORDWRITER;
            // Windowing2.g:472:19: ( R E C O R D W R I T E R )
            // Windowing2.g:472:21: R E C O R D W R I T E R
            {
            mR(); 
            mE(); 
            mC(); 
            mO(); 
            mR(); 
            mD(); 
            mW(); 
            mR(); 
            mI(); 
            mT(); 
            mE(); 
            mR(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RECORDWRITER

    // $ANTLR start LOAD
    public final void mLOAD() throws RecognitionException {
        try {
            int _type = LOAD;
            // Windowing2.g:473:19: ( L O A D )
            // Windowing2.g:473:21: L O A D
            {
            mL(); 
            mO(); 
            mA(); 
            mD(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LOAD

    // $ANTLR start TABLE
    public final void mTABLE() throws RecognitionException {
        try {
            int _type = TABLE;
            // Windowing2.g:474:19: ( T A B L E )
            // Windowing2.g:474:21: T A B L E
            {
            mT(); 
            mA(); 
            mB(); 
            mL(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TABLE

    // $ANTLR start OVERWRITE
    public final void mOVERWRITE() throws RecognitionException {
        try {
            int _type = OVERWRITE;
            // Windowing2.g:475:19: ( O V E R W R I T E )
            // Windowing2.g:475:21: O V E R W R I T E
            {
            mO(); 
            mV(); 
            mE(); 
            mR(); 
            mW(); 
            mR(); 
            mI(); 
            mT(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OVERWRITE

    // $ANTLR start TRUE
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            // Windowing2.g:476:19: ( T R U E )
            // Windowing2.g:476:21: T R U E
            {
            mT(); 
            mR(); 
            mU(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRUE

    // $ANTLR start FALSE
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            // Windowing2.g:477:19: ( F A L S E )
            // Windowing2.g:477:21: F A L S E
            {
            mF(); 
            mA(); 
            mL(); 
            mS(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FALSE

    // $ANTLR start LIKE
    public final void mLIKE() throws RecognitionException {
        try {
            int _type = LIKE;
            // Windowing2.g:478:19: ( L I K E )
            // Windowing2.g:478:21: L I K E
            {
            mL(); 
            mI(); 
            mK(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LIKE

    // $ANTLR start RLIKE
    public final void mRLIKE() throws RecognitionException {
        try {
            int _type = RLIKE;
            // Windowing2.g:479:19: ( R L I K E )
            // Windowing2.g:479:21: R L I K E
            {
            mR(); 
            mL(); 
            mI(); 
            mK(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RLIKE

    // $ANTLR start REGEXP
    public final void mREGEXP() throws RecognitionException {
        try {
            int _type = REGEXP;
            // Windowing2.g:480:19: ( R E G E X P )
            // Windowing2.g:480:21: R E G E X P
            {
            mR(); 
            mE(); 
            mG(); 
            mE(); 
            mX(); 
            mP(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end REGEXP

    // $ANTLR start IN
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            // Windowing2.g:481:19: ( I N )
            // Windowing2.g:481:21: I N
            {
            mI(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IN

    // $ANTLR start THEN
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            // Windowing2.g:482:16: ( T H E N )
            // Windowing2.g:482:18: T H E N
            {
            mT(); 
            mH(); 
            mE(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end THEN

    // $ANTLR start IS
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            // Windowing2.g:483:19: ( I S )
            // Windowing2.g:483:21: I S
            {
            mI(); 
            mS(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IS

    // $ANTLR start NULL
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            // Windowing2.g:484:19: ( N U L L )
            // Windowing2.g:484:21: N U L L
            {
            mN(); 
            mU(); 
            mL(); 
            mL(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NULL

    // $ANTLR start CASE
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            // Windowing2.g:485:19: ( C A S E )
            // Windowing2.g:485:21: C A S E
            {
            mC(); 
            mA(); 
            mS(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CASE

    // $ANTLR start WHEN
    public final void mWHEN() throws RecognitionException {
        try {
            int _type = WHEN;
            // Windowing2.g:486:19: ( W H E N )
            // Windowing2.g:486:21: W H E N
            {
            mW(); 
            mH(); 
            mE(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WHEN

    // $ANTLR start ELSE
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            // Windowing2.g:487:19: ( E L S E )
            // Windowing2.g:487:21: E L S E
            {
            mE(); 
            mL(); 
            mS(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ELSE

    // $ANTLR start END
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            // Windowing2.g:488:19: ( E N D )
            // Windowing2.g:488:21: E N D
            {
            mE(); 
            mN(); 
            mD(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end END

    // $ANTLR start CAST
    public final void mCAST() throws RecognitionException {
        try {
            int _type = CAST;
            // Windowing2.g:489:18: ( C A S T )
            // Windowing2.g:489:20: C A S T
            {
            mC(); 
            mA(); 
            mS(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CAST

    // $ANTLR start TINYINT
    public final void mTINYINT() throws RecognitionException {
        try {
            int _type = TINYINT;
            // Windowing2.g:491:2: ( T I N Y I N T )
            // Windowing2.g:491:4: T I N Y I N T
            {
            mT(); 
            mI(); 
            mN(); 
            mY(); 
            mI(); 
            mN(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TINYINT

    // $ANTLR start SMALLINT
    public final void mSMALLINT() throws RecognitionException {
        try {
            int _type = SMALLINT;
            // Windowing2.g:493:2: ( S M A L L I N T )
            // Windowing2.g:493:4: S M A L L I N T
            {
            mS(); 
            mM(); 
            mA(); 
            mL(); 
            mL(); 
            mI(); 
            mN(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SMALLINT

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            // Windowing2.g:494:6: ( I N T )
            // Windowing2.g:494:9: I N T
            {
            mI(); 
            mN(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INT

    // $ANTLR start BIGINT
    public final void mBIGINT() throws RecognitionException {
        try {
            int _type = BIGINT;
            // Windowing2.g:495:8: ( B I G I N T )
            // Windowing2.g:495:10: B I G I N T
            {
            mB(); 
            mI(); 
            mG(); 
            mI(); 
            mN(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BIGINT

    // $ANTLR start BOOLEAN
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            // Windowing2.g:496:9: ( B O O L E A N )
            // Windowing2.g:496:11: B O O L E A N
            {
            mB(); 
            mO(); 
            mO(); 
            mL(); 
            mE(); 
            mA(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BOOLEAN

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // Windowing2.g:497:7: ( F L O A T )
            // Windowing2.g:497:9: F L O A T
            {
            mF(); 
            mL(); 
            mO(); 
            mA(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start DOUBLE
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            // Windowing2.g:498:9: ( D O U B L E )
            // Windowing2.g:498:11: D O U B L E
            {
            mD(); 
            mO(); 
            mU(); 
            mB(); 
            mL(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLE

    // $ANTLR start DATE
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            // Windowing2.g:499:7: ( D A T E )
            // Windowing2.g:499:9: D A T E
            {
            mD(); 
            mA(); 
            mT(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DATE

    // $ANTLR start DATETIME
    public final void mDATETIME() throws RecognitionException {
        try {
            int _type = DATETIME;
            // Windowing2.g:500:10: ( D A T E T I M E )
            // Windowing2.g:500:12: D A T E T I M E
            {
            mD(); 
            mA(); 
            mT(); 
            mE(); 
            mT(); 
            mI(); 
            mM(); 
            mE(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DATETIME

    // $ANTLR start TIMESTAMP
    public final void mTIMESTAMP() throws RecognitionException {
        try {
            int _type = TIMESTAMP;
            // Windowing2.g:502:2: ( T I M E S T A M P )
            // Windowing2.g:502:5: T I M E S T A M P
            {
            mT(); 
            mI(); 
            mM(); 
            mE(); 
            mS(); 
            mT(); 
            mA(); 
            mM(); 
            mP(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TIMESTAMP

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // Windowing2.g:503:8: ( S T R I N G )
            // Windowing2.g:503:10: S T R I N G
            {
            mS(); 
            mT(); 
            mR(); 
            mI(); 
            mN(); 
            mG(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start BINARY
    public final void mBINARY() throws RecognitionException {
        try {
            int _type = BINARY;
            // Windowing2.g:504:9: ( B I N A R Y )
            // Windowing2.g:504:12: B I N A R Y
            {
            mB(); 
            mI(); 
            mN(); 
            mA(); 
            mR(); 
            mY(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BINARY

    // $ANTLR start IF
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            // Windowing2.g:505:5: ( I F )
            // Windowing2.g:505:8: I F
            {
            mI(); 
            mF(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IF

    // $ANTLR start ARRAY
    public final void mARRAY() throws RecognitionException {
        try {
            int _type = ARRAY;
            // Windowing2.g:506:8: ( A R R A Y )
            // Windowing2.g:506:10: A R R A Y
            {
            mA(); 
            mR(); 
            mR(); 
            mA(); 
            mY(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ARRAY

    // $ANTLR start MAP
    public final void mMAP() throws RecognitionException {
        try {
            int _type = MAP;
            // Windowing2.g:507:6: ( M A P )
            // Windowing2.g:507:8: M A P
            {
            mM(); 
            mA(); 
            mP(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MAP

    // $ANTLR start STRUCT
    public final void mSTRUCT() throws RecognitionException {
        try {
            int _type = STRUCT;
            // Windowing2.g:508:9: ( S T R U C T )
            // Windowing2.g:508:11: S T R U C T
            {
            mS(); 
            mT(); 
            mR(); 
            mU(); 
            mC(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRUCT

    // $ANTLR start UNION
    public final void mUNION() throws RecognitionException {
        try {
            int _type = UNION;
            // Windowing2.g:509:8: ( U N I O N )
            // Windowing2.g:509:10: U N I O N
            {
            mU(); 
            mN(); 
            mI(); 
            mO(); 
            mN(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UNION

    // $ANTLR start DISTINCT
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            // Windowing2.g:511:2: ( D I S T I N C T )
            // Windowing2.g:511:4: D I S T I N C T
            {
            mD(); 
            mI(); 
            mS(); 
            mT(); 
            mI(); 
            mN(); 
            mC(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DISTINCT

    // $ANTLR start WINDOW
    public final void mWINDOW() throws RecognitionException {
        try {
            int _type = WINDOW;
            // Windowing2.g:512:8: ( W I N D O W )
            // Windowing2.g:512:10: W I N D O W
            {
            mW(); 
            mI(); 
            mN(); 
            mD(); 
            mO(); 
            mW(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WINDOW

    // $ANTLR start ASC
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            // Windowing2.g:513:19: ( A S C )
            // Windowing2.g:513:21: A S C
            {
            mA(); 
            mS(); 
            mC(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ASC

    // $ANTLR start DESC
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            // Windowing2.g:514:19: ( D E S C )
            // Windowing2.g:514:21: D E S C
            {
            mD(); 
            mE(); 
            mS(); 
            mC(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DESC

    // $ANTLR start DOT
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            // Windowing2.g:518:5: ( '.' )
            // Windowing2.g:518:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOT

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // Windowing2.g:519:7: ( ':' )
            // Windowing2.g:519:9: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // Windowing2.g:520:7: ( ',' )
            // Windowing2.g:520:9: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start SEMICOLON
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            // Windowing2.g:521:11: ( ';' )
            // Windowing2.g:521:13: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMICOLON

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            // Windowing2.g:523:8: ( '(' )
            // Windowing2.g:523:10: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            // Windowing2.g:524:8: ( ')' )
            // Windowing2.g:524:10: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start LSQUARE
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            // Windowing2.g:525:9: ( '[' )
            // Windowing2.g:525:11: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LSQUARE

    // $ANTLR start RSQUARE
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            // Windowing2.g:526:9: ( ']' )
            // Windowing2.g:526:11: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RSQUARE

    // $ANTLR start LCURLY
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            // Windowing2.g:527:8: ( '{' )
            // Windowing2.g:527:10: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LCURLY

    // $ANTLR start RCURLY
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            // Windowing2.g:528:8: ( '}' )
            // Windowing2.g:528:10: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RCURLY

    // $ANTLR start EQUAL
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            // Windowing2.g:530:7: ( '=' | '==' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='=') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='=') ) {
                    alt1=2;
                }
                else {
                    alt1=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("530:1: EQUAL : ( '=' | '==' );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // Windowing2.g:530:9: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // Windowing2.g:530:15: '=='
                    {
                    match("=="); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQUAL

    // $ANTLR start EQUAL_NS
    public final void mEQUAL_NS() throws RecognitionException {
        try {
            int _type = EQUAL_NS;
            // Windowing2.g:531:10: ( '<=>' )
            // Windowing2.g:531:12: '<=>'
            {
            match("<=>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQUAL_NS

    // $ANTLR start NOTEQUAL
    public final void mNOTEQUAL() throws RecognitionException {
        try {
            int _type = NOTEQUAL;
            // Windowing2.g:532:10: ( '<>' | '!=' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='<') ) {
                alt2=1;
            }
            else if ( (LA2_0=='!') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("532:1: NOTEQUAL : ( '<>' | '!=' );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // Windowing2.g:532:12: '<>'
                    {
                    match("<>"); 


                    }
                    break;
                case 2 :
                    // Windowing2.g:532:19: '!='
                    {
                    match("!="); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOTEQUAL

    // $ANTLR start LESSTHANOREQUALTO
    public final void mLESSTHANOREQUALTO() throws RecognitionException {
        try {
            int _type = LESSTHANOREQUALTO;
            // Windowing2.g:533:19: ( '<=' )
            // Windowing2.g:533:21: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LESSTHANOREQUALTO

    // $ANTLR start LESSTHAN
    public final void mLESSTHAN() throws RecognitionException {
        try {
            int _type = LESSTHAN;
            // Windowing2.g:534:10: ( '<' )
            // Windowing2.g:534:12: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LESSTHAN

    // $ANTLR start GREATERTHANOREQUALTO
    public final void mGREATERTHANOREQUALTO() throws RecognitionException {
        try {
            int _type = GREATERTHANOREQUALTO;
            // Windowing2.g:535:22: ( '>=' )
            // Windowing2.g:535:24: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GREATERTHANOREQUALTO

    // $ANTLR start GREATERTHAN
    public final void mGREATERTHAN() throws RecognitionException {
        try {
            int _type = GREATERTHAN;
            // Windowing2.g:536:13: ( '>' )
            // Windowing2.g:536:15: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GREATERTHAN

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // Windowing2.g:537:19: ( A N D )
            // Windowing2.g:537:21: A N D
            {
            mA(); 
            mN(); 
            mD(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start NOT
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            // Windowing2.g:538:19: ( N O T )
            // Windowing2.g:538:21: N O T
            {
            mN(); 
            mO(); 
            mT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOT

    // $ANTLR start OR
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            // Windowing2.g:539:19: ( O R )
            // Windowing2.g:539:21: O R
            {
            mO(); 
            mR(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OR

    // $ANTLR start XOR
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            // Windowing2.g:540:19: ( X O R )
            // Windowing2.g:540:21: X O R
            {
            mX(); 
            mO(); 
            mR(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end XOR

    // $ANTLR start DIVIDE
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            // Windowing2.g:543:8: ( '/' )
            // Windowing2.g:543:10: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIVIDE

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // Windowing2.g:544:6: ( '+' )
            // Windowing2.g:544:8: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            // Windowing2.g:545:7: ( '-' )
            // Windowing2.g:545:9: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start STAR
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            // Windowing2.g:546:6: ( '*' )
            // Windowing2.g:546:8: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start MOD
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            // Windowing2.g:547:5: ( '%' )
            // Windowing2.g:547:7: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MOD

    // $ANTLR start DIV
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            // Windowing2.g:548:5: ( 'DIV' )
            // Windowing2.g:548:7: 'DIV'
            {
            match("DIV"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIV

    // $ANTLR start AMPERSAND
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            // Windowing2.g:550:11: ( '&' )
            // Windowing2.g:550:13: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AMPERSAND

    // $ANTLR start TILDE
    public final void mTILDE() throws RecognitionException {
        try {
            int _type = TILDE;
            // Windowing2.g:551:7: ( '~' )
            // Windowing2.g:551:9: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TILDE

    // $ANTLR start BITWISEOR
    public final void mBITWISEOR() throws RecognitionException {
        try {
            int _type = BITWISEOR;
            // Windowing2.g:552:11: ( '|' )
            // Windowing2.g:552:13: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BITWISEOR

    // $ANTLR start BITWISEXOR
    public final void mBITWISEXOR() throws RecognitionException {
        try {
            int _type = BITWISEXOR;
            // Windowing2.g:553:12: ( '^' )
            // Windowing2.g:553:14: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BITWISEXOR

    // $ANTLR start QUESTION
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            // Windowing2.g:554:10: ( '?' )
            // Windowing2.g:554:12: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUESTION

    // $ANTLR start DOLLAR
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            // Windowing2.g:555:8: ( '$' )
            // Windowing2.g:555:10: '$'
            {
            match('$'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOLLAR

    // $ANTLR start HIVEQUERY
    public final void mHIVEQUERY() throws RecognitionException {
        try {
            int _type = HIVEQUERY;
            // Windowing2.g:557:11: ( '<' ( HiveQueryEscapeSequence | ~ ( '>' ) )* '>' )
            // Windowing2.g:557:13: '<' ( HiveQueryEscapeSequence | ~ ( '>' ) )* '>'
            {
            match('<'); 
            // Windowing2.g:558:3: ( HiveQueryEscapeSequence | ~ ( '>' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2=='>') ) {
                        int LA3_4 = input.LA(3);

                        if ( ((LA3_4>='\u0000' && LA3_4<='\uFFFE')) ) {
                            alt3=1;
                        }

                        else {
                            alt3=2;
                        }

                    }
                    else if ( ((LA3_2>='\u0000' && LA3_2<='=')||(LA3_2>='?' && LA3_2<='\uFFFE')) ) {
                        alt3=2;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='=')||(LA3_0>='?' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFE')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // Windowing2.g:558:4: HiveQueryEscapeSequence
            	    {
            	    mHiveQueryEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // Windowing2.g:558:30: ~ ( '>' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('>'); 
            setText(getText().substring(1, getText().length()-1).replaceAll("\\\\>", ">"));

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end HIVEQUERY

    // $ANTLR start HiveQueryEscapeSequence
    public final void mHiveQueryEscapeSequence() throws RecognitionException {
        try {
            // Windowing2.g:563:25: ( '\\\\' '>' )
            // Windowing2.g:564:3: '\\\\' '>'
            {
            match('\\'); 
            match('>'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end HiveQueryEscapeSequence

    // $ANTLR start StringLiteral
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            // Windowing2.g:567:5: ( ( '\\'' (~ ( '\\'' | '\\\\' ) | EscapeSequence )* '\\'' | '\\\"' (~ ( '\\\"' | '\\\\' ) | EscapeSequence )* '\\\"' )+ )
            // Windowing2.g:568:5: ( '\\'' (~ ( '\\'' | '\\\\' ) | EscapeSequence )* '\\'' | '\\\"' (~ ( '\\\"' | '\\\\' ) | EscapeSequence )* '\\\"' )+
            {
            // Windowing2.g:568:5: ( '\\'' (~ ( '\\'' | '\\\\' ) | EscapeSequence )* '\\'' | '\\\"' (~ ( '\\\"' | '\\\\' ) | EscapeSequence )* '\\\"' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\'') ) {
                    alt6=1;
                }
                else if ( (LA6_0=='\"') ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // Windowing2.g:568:7: '\\'' (~ ( '\\'' | '\\\\' ) | EscapeSequence )* '\\''
            	    {
            	    match('\''); 
            	    // Windowing2.g:568:12: (~ ( '\\'' | '\\\\' ) | EscapeSequence )*
            	    loop4:
            	    do {
            	        int alt4=3;
            	        int LA4_0 = input.LA(1);

            	        if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
            	            alt4=1;
            	        }
            	        else if ( (LA4_0=='\\') ) {
            	            alt4=2;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // Windowing2.g:568:14: ~ ( '\\'' | '\\\\' )
            	    	    {
            	    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse =
            	    	            new MismatchedSetException(null,input);
            	    	        recover(mse);    throw mse;
            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // Windowing2.g:568:29: EscapeSequence
            	    	    {
            	    	    mEscapeSequence(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    match('\''); 

            	    }
            	    break;
            	case 2 :
            	    // Windowing2.g:569:7: '\\\"' (~ ( '\\\"' | '\\\\' ) | EscapeSequence )* '\\\"'
            	    {
            	    match('\"'); 
            	    // Windowing2.g:569:12: (~ ( '\\\"' | '\\\\' ) | EscapeSequence )*
            	    loop5:
            	    do {
            	        int alt5=3;
            	        int LA5_0 = input.LA(1);

            	        if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
            	            alt5=1;
            	        }
            	        else if ( (LA5_0=='\\') ) {
            	            alt5=2;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // Windowing2.g:569:14: ~ ( '\\\"' | '\\\\' )
            	    	    {
            	    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse =
            	    	            new MismatchedSetException(null,input);
            	    	        recover(mse);    throw mse;
            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // Windowing2.g:569:29: EscapeSequence
            	    	    {
            	    	    mEscapeSequence(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);

            	    match('\"'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end StringLiteral

    // $ANTLR start CharSetLiteral
    public final void mCharSetLiteral() throws RecognitionException {
        try {
            int _type = CharSetLiteral;
            // Windowing2.g:574:5: ( StringLiteral | '0' 'X' ( HexDigit | Digit )+ )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"'||LA8_0=='\'') ) {
                alt8=1;
            }
            else if ( (LA8_0=='0') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("573:1: CharSetLiteral : ( StringLiteral | '0' 'X' ( HexDigit | Digit )+ );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // Windowing2.g:575:5: StringLiteral
                    {
                    mStringLiteral(); 

                    }
                    break;
                case 2 :
                    // Windowing2.g:576:7: '0' 'X' ( HexDigit | Digit )+
                    {
                    match('0'); 
                    match('X'); 
                    // Windowing2.g:576:15: ( HexDigit | Digit )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='F')||(LA7_0>='a' && LA7_0<='f')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Windowing2.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CharSetLiteral

    // $ANTLR start CharSetName
    public final void mCharSetName() throws RecognitionException {
        try {
            int _type = CharSetName;
            // Windowing2.g:580:5: ( '_' ( Letter | Digit | '_' | '-' | '.' | ':' )+ )
            // Windowing2.g:581:5: '_' ( Letter | Digit | '_' | '-' | '.' | ':' )+
            {
            match('_'); 
            // Windowing2.g:581:9: ( Letter | Digit | '_' | '-' | '.' | ':' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='-' && LA9_0<='.')||(LA9_0>='0' && LA9_0<=':')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Windowing2.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<=':')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CharSetName

    // $ANTLR start BigintLiteral
    public final void mBigintLiteral() throws RecognitionException {
        try {
            int _type = BigintLiteral;
            // Windowing2.g:585:5: ( ( Digit )+ 'L' )
            // Windowing2.g:586:5: ( Digit )+ 'L'
            {
            // Windowing2.g:586:5: ( Digit )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Windowing2.g:586:6: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            match('L'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BigintLiteral

    // $ANTLR start SmallintLiteral
    public final void mSmallintLiteral() throws RecognitionException {
        try {
            int _type = SmallintLiteral;
            // Windowing2.g:590:5: ( ( Digit )+ 'S' )
            // Windowing2.g:591:5: ( Digit )+ 'S'
            {
            // Windowing2.g:591:5: ( Digit )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Windowing2.g:591:6: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            match('S'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SmallintLiteral

    // $ANTLR start TinyintLiteral
    public final void mTinyintLiteral() throws RecognitionException {
        try {
            int _type = TinyintLiteral;
            // Windowing2.g:595:5: ( ( Digit )+ 'Y' )
            // Windowing2.g:596:5: ( Digit )+ 'Y'
            {
            // Windowing2.g:596:5: ( Digit )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Windowing2.g:596:6: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            match('Y'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TinyintLiteral

    // $ANTLR start Number
    public final void mNumber() throws RecognitionException {
        try {
            int _type = Number;
            // Windowing2.g:600:5: ( ( Digit )+ ( DOT ( Digit )* ( Exponent )? | Exponent )? )
            // Windowing2.g:601:5: ( Digit )+ ( DOT ( Digit )* ( Exponent )? | Exponent )?
            {
            // Windowing2.g:601:5: ( Digit )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Windowing2.g:601:6: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // Windowing2.g:601:14: ( DOT ( Digit )* ( Exponent )? | Exponent )?
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='.') ) {
                alt16=1;
            }
            else if ( (LA16_0=='E'||LA16_0=='e') ) {
                alt16=2;
            }
            switch (alt16) {
                case 1 :
                    // Windowing2.g:601:16: DOT ( Digit )* ( Exponent )?
                    {
                    mDOT(); 
                    // Windowing2.g:601:20: ( Digit )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // Windowing2.g:601:21: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // Windowing2.g:601:29: ( Exponent )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // Windowing2.g:601:30: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // Windowing2.g:601:43: Exponent
                    {
                    mExponent(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Number

    // $ANTLR start Identifier
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            // Windowing2.g:605:5: ( ( Letter | Digit ) ( Letter | Digit | '_' )* | '`' ( RegexComponent )+ '`' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>='0' && LA19_0<='9')||(LA19_0>='A' && LA19_0<='Z')||(LA19_0>='a' && LA19_0<='z')) ) {
                alt19=1;
            }
            else if ( (LA19_0=='`') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("604:1: Identifier : ( ( Letter | Digit ) ( Letter | Digit | '_' )* | '`' ( RegexComponent )+ '`' );", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // Windowing2.g:606:5: ( Letter | Digit ) ( Letter | Digit | '_' )*
                    {
                    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }

                    // Windowing2.g:606:22: ( Letter | Digit | '_' )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='0' && LA17_0<='9')||(LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // Windowing2.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Windowing2.g:607:7: '`' ( RegexComponent )+ '`'
                    {
                    match('`'); 
                    // Windowing2.g:607:11: ( RegexComponent )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='$'||(LA18_0>='(' && LA18_0<='+')||(LA18_0>='-' && LA18_0<='.')||(LA18_0>='0' && LA18_0<='9')||LA18_0=='?'||(LA18_0>='A' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='_')||(LA18_0>='a' && LA18_0<='}')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // Windowing2.g:607:11: RegexComponent
                    	    {
                    	    mRegexComponent(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    match('`'); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Identifier

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // Windowing2.g:611:5: ( ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+ )
            // Windowing2.g:611:9: ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+
            {
            // Windowing2.g:611:9: ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\t' && LA20_0<='\n')||(LA20_0>='\f' && LA20_0<='\r')||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Windowing2.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // Windowing2.g:621:3: ( '--' (~ ( '\\n' | '\\r' ) )* )
            // Windowing2.g:621:5: '--' (~ ( '\\n' | '\\r' ) )*
            {
            match("--"); 

            // Windowing2.g:621:10: (~ ( '\\n' | '\\r' ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFE')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Windowing2.g:621:11: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    // $ANTLR start EscapeSequence
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // Windowing2.g:627:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ) )
            // Windowing2.g:627:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            {
            match('\\'); 
            // Windowing2.g:627:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            int alt22=11;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt22=1;
                }
                break;
            case 't':
                {
                alt22=2;
                }
                break;
            case 'n':
                {
                alt22=3;
                }
                break;
            case 'f':
                {
                alt22=4;
                }
                break;
            case 'r':
                {
                alt22=5;
                }
                break;
            case '\"':
                {
                alt22=6;
                }
                break;
            case '\'':
                {
                alt22=7;
                }
                break;
            case '\\':
                {
                alt22=8;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
                {
                int LA22_9 = input.LA(2);

                if ( ((LA22_9>='0' && LA22_9<='7')) ) {
                    int LA22_11 = input.LA(3);

                    if ( ((LA22_11>='0' && LA22_11<='7')) ) {
                        alt22=9;
                    }
                    else {
                        alt22=10;}
                }
                else {
                    alt22=11;}
                }
                break;
            case '4':
            case '5':
            case '6':
            case '7':
                {
                int LA22_10 = input.LA(2);

                if ( ((LA22_10>='0' && LA22_10<='7')) ) {
                    alt22=10;
                }
                else {
                    alt22=11;}
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("627:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // Windowing2.g:628:18: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // Windowing2.g:629:18: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // Windowing2.g:630:18: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 4 :
                    // Windowing2.g:631:18: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // Windowing2.g:632:18: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 6 :
                    // Windowing2.g:633:18: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // Windowing2.g:634:18: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // Windowing2.g:635:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // Windowing2.g:637:18: ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // Windowing2.g:637:18: ( '0' .. '3' )
                    // Windowing2.g:637:19: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // Windowing2.g:637:29: ( '0' .. '7' )
                    // Windowing2.g:637:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // Windowing2.g:637:40: ( '0' .. '7' )
                    // Windowing2.g:637:41: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 10 :
                    // Windowing2.g:639:18: ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // Windowing2.g:639:18: ( '0' .. '7' )
                    // Windowing2.g:639:19: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // Windowing2.g:639:29: ( '0' .. '7' )
                    // Windowing2.g:639:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 11 :
                    // Windowing2.g:641:18: ( '0' .. '7' )
                    {
                    // Windowing2.g:641:18: ( '0' .. '7' )
                    // Windowing2.g:641:19: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end EscapeSequence

    // $ANTLR start Letter
    public final void mLetter() throws RecognitionException {
        try {
            // Windowing2.g:647:5: ( 'a' .. 'z' | 'A' .. 'Z' )
            // Windowing2.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Letter

    // $ANTLR start HexDigit
    public final void mHexDigit() throws RecognitionException {
        try {
            // Windowing2.g:652:5: ( 'a' .. 'f' | 'A' .. 'F' )
            // Windowing2.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end HexDigit

    // $ANTLR start Digit
    public final void mDigit() throws RecognitionException {
        try {
            // Windowing2.g:657:5: ( '0' .. '9' )
            // Windowing2.g:658:5: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end Digit

    // $ANTLR start Exponent
    public final void mExponent() throws RecognitionException {
        try {
            // Windowing2.g:663:5: ( ( 'e' | 'E' ) ( PLUS | MINUS )? ( Digit )+ )
            // Windowing2.g:664:5: ( 'e' | 'E' ) ( PLUS | MINUS )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // Windowing2.g:664:17: ( PLUS | MINUS )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='+'||LA23_0=='-') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // Windowing2.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // Windowing2.g:664:33: ( Digit )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // Windowing2.g:664:34: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end Exponent

    // $ANTLR start RegexComponent
    public final void mRegexComponent() throws RecognitionException {
        try {
            // Windowing2.g:669:5: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | PLUS | STAR | QUESTION | MINUS | DOT | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY | BITWISEXOR | BITWISEOR | DOLLAR )
            // Windowing2.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='(' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='_')||(input.LA(1)>='a' && input.LA(1)<='}') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end RegexComponent

    // $ANTLR start A
    public final void mA() throws RecognitionException {
        try {
            // Windowing2.g:676:11: ( ( 'a' | 'A' ) )
            // Windowing2.g:676:12: ( 'a' | 'A' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end A

    // $ANTLR start B
    public final void mB() throws RecognitionException {
        try {
            // Windowing2.g:677:11: ( ( 'b' | 'B' ) )
            // Windowing2.g:677:12: ( 'b' | 'B' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end B

    // $ANTLR start C
    public final void mC() throws RecognitionException {
        try {
            // Windowing2.g:678:11: ( ( 'c' | 'C' ) )
            // Windowing2.g:678:12: ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end C

    // $ANTLR start D
    public final void mD() throws RecognitionException {
        try {
            // Windowing2.g:679:11: ( ( 'd' | 'D' ) )
            // Windowing2.g:679:12: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end D

    // $ANTLR start E
    public final void mE() throws RecognitionException {
        try {
            // Windowing2.g:680:11: ( ( 'e' | 'E' ) )
            // Windowing2.g:680:12: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end E

    // $ANTLR start F
    public final void mF() throws RecognitionException {
        try {
            // Windowing2.g:681:11: ( ( 'f' | 'F' ) )
            // Windowing2.g:681:12: ( 'f' | 'F' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end F

    // $ANTLR start G
    public final void mG() throws RecognitionException {
        try {
            // Windowing2.g:682:11: ( ( 'g' | 'G' ) )
            // Windowing2.g:682:12: ( 'g' | 'G' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end G

    // $ANTLR start H
    public final void mH() throws RecognitionException {
        try {
            // Windowing2.g:683:11: ( ( 'h' | 'H' ) )
            // Windowing2.g:683:12: ( 'h' | 'H' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end H

    // $ANTLR start I
    public final void mI() throws RecognitionException {
        try {
            // Windowing2.g:684:11: ( ( 'i' | 'I' ) )
            // Windowing2.g:684:12: ( 'i' | 'I' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end I

    // $ANTLR start J
    public final void mJ() throws RecognitionException {
        try {
            // Windowing2.g:685:11: ( ( 'j' | 'J' ) )
            // Windowing2.g:685:12: ( 'j' | 'J' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end J

    // $ANTLR start K
    public final void mK() throws RecognitionException {
        try {
            // Windowing2.g:686:11: ( ( 'k' | 'K' ) )
            // Windowing2.g:686:12: ( 'k' | 'K' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end K

    // $ANTLR start L
    public final void mL() throws RecognitionException {
        try {
            // Windowing2.g:687:11: ( ( 'l' | 'L' ) )
            // Windowing2.g:687:12: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end L

    // $ANTLR start M
    public final void mM() throws RecognitionException {
        try {
            // Windowing2.g:688:11: ( ( 'm' | 'M' ) )
            // Windowing2.g:688:12: ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end M

    // $ANTLR start N
    public final void mN() throws RecognitionException {
        try {
            // Windowing2.g:689:11: ( ( 'n' | 'N' ) )
            // Windowing2.g:689:12: ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end N

    // $ANTLR start O
    public final void mO() throws RecognitionException {
        try {
            // Windowing2.g:690:11: ( ( 'o' | 'O' ) )
            // Windowing2.g:690:12: ( 'o' | 'O' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end O

    // $ANTLR start P
    public final void mP() throws RecognitionException {
        try {
            // Windowing2.g:691:11: ( ( 'p' | 'P' ) )
            // Windowing2.g:691:12: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end P

    // $ANTLR start Q
    public final void mQ() throws RecognitionException {
        try {
            // Windowing2.g:692:11: ( ( 'q' | 'Q' ) )
            // Windowing2.g:692:12: ( 'q' | 'Q' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Q

    // $ANTLR start R
    public final void mR() throws RecognitionException {
        try {
            // Windowing2.g:693:11: ( ( 'r' | 'R' ) )
            // Windowing2.g:693:12: ( 'r' | 'R' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end R

    // $ANTLR start S
    public final void mS() throws RecognitionException {
        try {
            // Windowing2.g:694:11: ( ( 's' | 'S' ) )
            // Windowing2.g:694:12: ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end S

    // $ANTLR start T
    public final void mT() throws RecognitionException {
        try {
            // Windowing2.g:695:11: ( ( 't' | 'T' ) )
            // Windowing2.g:695:12: ( 't' | 'T' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end T

    // $ANTLR start U
    public final void mU() throws RecognitionException {
        try {
            // Windowing2.g:696:11: ( ( 'u' | 'U' ) )
            // Windowing2.g:696:12: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end U

    // $ANTLR start V
    public final void mV() throws RecognitionException {
        try {
            // Windowing2.g:697:11: ( ( 'v' | 'V' ) )
            // Windowing2.g:697:12: ( 'v' | 'V' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end V

    // $ANTLR start W
    public final void mW() throws RecognitionException {
        try {
            // Windowing2.g:698:11: ( ( 'w' | 'W' ) )
            // Windowing2.g:698:12: ( 'w' | 'W' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end W

    // $ANTLR start X
    public final void mX() throws RecognitionException {
        try {
            // Windowing2.g:699:11: ( ( 'x' | 'X' ) )
            // Windowing2.g:699:12: ( 'x' | 'X' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end X

    // $ANTLR start Y
    public final void mY() throws RecognitionException {
        try {
            // Windowing2.g:700:11: ( ( 'y' | 'Y' ) )
            // Windowing2.g:700:12: ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Y

    // $ANTLR start Z
    public final void mZ() throws RecognitionException {
        try {
            // Windowing2.g:701:11: ( ( 'z' | 'Z' ) )
            // Windowing2.g:701:12: ( 'z' | 'Z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Z

    public void mTokens() throws RecognitionException {
        // Windowing2.g:1:8: ( SELECT | FROM | WHERE | FILEINPUT | ORDER | BY | PARTITION | WITH | ROWS | RANGE | BETWEEN | CURRENT | ROW | UNBOUNDED | PRECEDING | FOLLOWING | LESS | MORE | AS | OVER | INTO | PATH | FORMAT | SERDE | SERDEPROPERTIES | RECORDWRITER | LOAD | TABLE | OVERWRITE | TRUE | FALSE | LIKE | RLIKE | REGEXP | IN | THEN | IS | NULL | CASE | WHEN | ELSE | END | CAST | TINYINT | SMALLINT | INT | BIGINT | BOOLEAN | FLOAT | DOUBLE | DATE | DATETIME | TIMESTAMP | STRING | BINARY | IF | ARRAY | MAP | STRUCT | UNION | DISTINCT | WINDOW | ASC | DESC | DOT | COLON | COMMA | SEMICOLON | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY | EQUAL | EQUAL_NS | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN | AND | NOT | OR | XOR | DIVIDE | PLUS | MINUS | STAR | MOD | DIV | AMPERSAND | TILDE | BITWISEOR | BITWISEXOR | QUESTION | DOLLAR | HIVEQUERY | StringLiteral | CharSetLiteral | CharSetName | BigintLiteral | SmallintLiteral | TinyintLiteral | Number | Identifier | WS | COMMENT )
        int alt25=108;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // Windowing2.g:1:10: SELECT
                {
                mSELECT(); 

                }
                break;
            case 2 :
                // Windowing2.g:1:17: FROM
                {
                mFROM(); 

                }
                break;
            case 3 :
                // Windowing2.g:1:22: WHERE
                {
                mWHERE(); 

                }
                break;
            case 4 :
                // Windowing2.g:1:28: FILEINPUT
                {
                mFILEINPUT(); 

                }
                break;
            case 5 :
                // Windowing2.g:1:38: ORDER
                {
                mORDER(); 

                }
                break;
            case 6 :
                // Windowing2.g:1:44: BY
                {
                mBY(); 

                }
                break;
            case 7 :
                // Windowing2.g:1:47: PARTITION
                {
                mPARTITION(); 

                }
                break;
            case 8 :
                // Windowing2.g:1:57: WITH
                {
                mWITH(); 

                }
                break;
            case 9 :
                // Windowing2.g:1:62: ROWS
                {
                mROWS(); 

                }
                break;
            case 10 :
                // Windowing2.g:1:67: RANGE
                {
                mRANGE(); 

                }
                break;
            case 11 :
                // Windowing2.g:1:73: BETWEEN
                {
                mBETWEEN(); 

                }
                break;
            case 12 :
                // Windowing2.g:1:81: CURRENT
                {
                mCURRENT(); 

                }
                break;
            case 13 :
                // Windowing2.g:1:89: ROW
                {
                mROW(); 

                }
                break;
            case 14 :
                // Windowing2.g:1:93: UNBOUNDED
                {
                mUNBOUNDED(); 

                }
                break;
            case 15 :
                // Windowing2.g:1:103: PRECEDING
                {
                mPRECEDING(); 

                }
                break;
            case 16 :
                // Windowing2.g:1:113: FOLLOWING
                {
                mFOLLOWING(); 

                }
                break;
            case 17 :
                // Windowing2.g:1:123: LESS
                {
                mLESS(); 

                }
                break;
            case 18 :
                // Windowing2.g:1:128: MORE
                {
                mMORE(); 

                }
                break;
            case 19 :
                // Windowing2.g:1:133: AS
                {
                mAS(); 

                }
                break;
            case 20 :
                // Windowing2.g:1:136: OVER
                {
                mOVER(); 

                }
                break;
            case 21 :
                // Windowing2.g:1:141: INTO
                {
                mINTO(); 

                }
                break;
            case 22 :
                // Windowing2.g:1:146: PATH
                {
                mPATH(); 

                }
                break;
            case 23 :
                // Windowing2.g:1:151: FORMAT
                {
                mFORMAT(); 

                }
                break;
            case 24 :
                // Windowing2.g:1:158: SERDE
                {
                mSERDE(); 

                }
                break;
            case 25 :
                // Windowing2.g:1:164: SERDEPROPERTIES
                {
                mSERDEPROPERTIES(); 

                }
                break;
            case 26 :
                // Windowing2.g:1:180: RECORDWRITER
                {
                mRECORDWRITER(); 

                }
                break;
            case 27 :
                // Windowing2.g:1:193: LOAD
                {
                mLOAD(); 

                }
                break;
            case 28 :
                // Windowing2.g:1:198: TABLE
                {
                mTABLE(); 

                }
                break;
            case 29 :
                // Windowing2.g:1:204: OVERWRITE
                {
                mOVERWRITE(); 

                }
                break;
            case 30 :
                // Windowing2.g:1:214: TRUE
                {
                mTRUE(); 

                }
                break;
            case 31 :
                // Windowing2.g:1:219: FALSE
                {
                mFALSE(); 

                }
                break;
            case 32 :
                // Windowing2.g:1:225: LIKE
                {
                mLIKE(); 

                }
                break;
            case 33 :
                // Windowing2.g:1:230: RLIKE
                {
                mRLIKE(); 

                }
                break;
            case 34 :
                // Windowing2.g:1:236: REGEXP
                {
                mREGEXP(); 

                }
                break;
            case 35 :
                // Windowing2.g:1:243: IN
                {
                mIN(); 

                }
                break;
            case 36 :
                // Windowing2.g:1:246: THEN
                {
                mTHEN(); 

                }
                break;
            case 37 :
                // Windowing2.g:1:251: IS
                {
                mIS(); 

                }
                break;
            case 38 :
                // Windowing2.g:1:254: NULL
                {
                mNULL(); 

                }
                break;
            case 39 :
                // Windowing2.g:1:259: CASE
                {
                mCASE(); 

                }
                break;
            case 40 :
                // Windowing2.g:1:264: WHEN
                {
                mWHEN(); 

                }
                break;
            case 41 :
                // Windowing2.g:1:269: ELSE
                {
                mELSE(); 

                }
                break;
            case 42 :
                // Windowing2.g:1:274: END
                {
                mEND(); 

                }
                break;
            case 43 :
                // Windowing2.g:1:278: CAST
                {
                mCAST(); 

                }
                break;
            case 44 :
                // Windowing2.g:1:283: TINYINT
                {
                mTINYINT(); 

                }
                break;
            case 45 :
                // Windowing2.g:1:291: SMALLINT
                {
                mSMALLINT(); 

                }
                break;
            case 46 :
                // Windowing2.g:1:300: INT
                {
                mINT(); 

                }
                break;
            case 47 :
                // Windowing2.g:1:304: BIGINT
                {
                mBIGINT(); 

                }
                break;
            case 48 :
                // Windowing2.g:1:311: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 49 :
                // Windowing2.g:1:319: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 50 :
                // Windowing2.g:1:325: DOUBLE
                {
                mDOUBLE(); 

                }
                break;
            case 51 :
                // Windowing2.g:1:332: DATE
                {
                mDATE(); 

                }
                break;
            case 52 :
                // Windowing2.g:1:337: DATETIME
                {
                mDATETIME(); 

                }
                break;
            case 53 :
                // Windowing2.g:1:346: TIMESTAMP
                {
                mTIMESTAMP(); 

                }
                break;
            case 54 :
                // Windowing2.g:1:356: STRING
                {
                mSTRING(); 

                }
                break;
            case 55 :
                // Windowing2.g:1:363: BINARY
                {
                mBINARY(); 

                }
                break;
            case 56 :
                // Windowing2.g:1:370: IF
                {
                mIF(); 

                }
                break;
            case 57 :
                // Windowing2.g:1:373: ARRAY
                {
                mARRAY(); 

                }
                break;
            case 58 :
                // Windowing2.g:1:379: MAP
                {
                mMAP(); 

                }
                break;
            case 59 :
                // Windowing2.g:1:383: STRUCT
                {
                mSTRUCT(); 

                }
                break;
            case 60 :
                // Windowing2.g:1:390: UNION
                {
                mUNION(); 

                }
                break;
            case 61 :
                // Windowing2.g:1:396: DISTINCT
                {
                mDISTINCT(); 

                }
                break;
            case 62 :
                // Windowing2.g:1:405: WINDOW
                {
                mWINDOW(); 

                }
                break;
            case 63 :
                // Windowing2.g:1:412: ASC
                {
                mASC(); 

                }
                break;
            case 64 :
                // Windowing2.g:1:416: DESC
                {
                mDESC(); 

                }
                break;
            case 65 :
                // Windowing2.g:1:421: DOT
                {
                mDOT(); 

                }
                break;
            case 66 :
                // Windowing2.g:1:425: COLON
                {
                mCOLON(); 

                }
                break;
            case 67 :
                // Windowing2.g:1:431: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 68 :
                // Windowing2.g:1:437: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 69 :
                // Windowing2.g:1:447: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 70 :
                // Windowing2.g:1:454: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 71 :
                // Windowing2.g:1:461: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 72 :
                // Windowing2.g:1:469: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 73 :
                // Windowing2.g:1:477: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 74 :
                // Windowing2.g:1:484: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 75 :
                // Windowing2.g:1:491: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 76 :
                // Windowing2.g:1:497: EQUAL_NS
                {
                mEQUAL_NS(); 

                }
                break;
            case 77 :
                // Windowing2.g:1:506: NOTEQUAL
                {
                mNOTEQUAL(); 

                }
                break;
            case 78 :
                // Windowing2.g:1:515: LESSTHANOREQUALTO
                {
                mLESSTHANOREQUALTO(); 

                }
                break;
            case 79 :
                // Windowing2.g:1:533: LESSTHAN
                {
                mLESSTHAN(); 

                }
                break;
            case 80 :
                // Windowing2.g:1:542: GREATERTHANOREQUALTO
                {
                mGREATERTHANOREQUALTO(); 

                }
                break;
            case 81 :
                // Windowing2.g:1:563: GREATERTHAN
                {
                mGREATERTHAN(); 

                }
                break;
            case 82 :
                // Windowing2.g:1:575: AND
                {
                mAND(); 

                }
                break;
            case 83 :
                // Windowing2.g:1:579: NOT
                {
                mNOT(); 

                }
                break;
            case 84 :
                // Windowing2.g:1:583: OR
                {
                mOR(); 

                }
                break;
            case 85 :
                // Windowing2.g:1:586: XOR
                {
                mXOR(); 

                }
                break;
            case 86 :
                // Windowing2.g:1:590: DIVIDE
                {
                mDIVIDE(); 

                }
                break;
            case 87 :
                // Windowing2.g:1:597: PLUS
                {
                mPLUS(); 

                }
                break;
            case 88 :
                // Windowing2.g:1:602: MINUS
                {
                mMINUS(); 

                }
                break;
            case 89 :
                // Windowing2.g:1:608: STAR
                {
                mSTAR(); 

                }
                break;
            case 90 :
                // Windowing2.g:1:613: MOD
                {
                mMOD(); 

                }
                break;
            case 91 :
                // Windowing2.g:1:617: DIV
                {
                mDIV(); 

                }
                break;
            case 92 :
                // Windowing2.g:1:621: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 93 :
                // Windowing2.g:1:631: TILDE
                {
                mTILDE(); 

                }
                break;
            case 94 :
                // Windowing2.g:1:637: BITWISEOR
                {
                mBITWISEOR(); 

                }
                break;
            case 95 :
                // Windowing2.g:1:647: BITWISEXOR
                {
                mBITWISEXOR(); 

                }
                break;
            case 96 :
                // Windowing2.g:1:658: QUESTION
                {
                mQUESTION(); 

                }
                break;
            case 97 :
                // Windowing2.g:1:667: DOLLAR
                {
                mDOLLAR(); 

                }
                break;
            case 98 :
                // Windowing2.g:1:674: HIVEQUERY
                {
                mHIVEQUERY(); 

                }
                break;
            case 99 :
                // Windowing2.g:1:684: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 100 :
                // Windowing2.g:1:698: CharSetLiteral
                {
                mCharSetLiteral(); 

                }
                break;
            case 101 :
                // Windowing2.g:1:713: CharSetName
                {
                mCharSetName(); 

                }
                break;
            case 102 :
                // Windowing2.g:1:725: BigintLiteral
                {
                mBigintLiteral(); 

                }
                break;
            case 103 :
                // Windowing2.g:1:739: SmallintLiteral
                {
                mSmallintLiteral(); 

                }
                break;
            case 104 :
                // Windowing2.g:1:755: TinyintLiteral
                {
                mTinyintLiteral(); 

                }
                break;
            case 105 :
                // Windowing2.g:1:770: Number
                {
                mNumber(); 

                }
                break;
            case 106 :
                // Windowing2.g:1:777: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 107 :
                // Windowing2.g:1:788: WS
                {
                mWS(); 

                }
                break;
            case 108 :
                // Windowing2.g:1:791: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\1\uffff\21\62\13\uffff\1\150\1\uffff\1\152\1\62\2\uffff\1\155\2"+
        "\uffff\1\62\10\uffff\1\165\1\uffff\1\165\2\uffff\13\62\1\u0089\3"+
        "\62\1\u008f\17\62\1\u00a2\1\62\1\u00a5\1\u00a6\1\u00a8\15\62\1\uffff"+
        "\1\u00b8\4\uffff\1\62\4\uffff\1\u00c4\2\uffff\1\u00c4\1\62\1\uffff"+
        "\1\u00d0\1\165\1\u00d1\1\62\1\u00d3\16\62\1\uffff\5\62\1\uffff\7"+
        "\62\1\u00f0\7\62\1\u00fa\2\62\1\uffff\1\u00fd\1\u00fe\2\uffff\1"+
        "\u00ff\1\uffff\6\62\1\u0107\1\u0108\1\62\1\u010a\4\62\2\uffff\1"+
        "\u0110\25\uffff\1\u0115\2\uffff\1\165\1\uffff\11\62\1\u011f\2\62"+
        "\1\u0122\1\u0123\1\62\1\u0125\7\62\1\u012e\4\62\1\uffff\1\u0133"+
        "\1\u0134\1\u0135\3\62\1\u0139\1\u013a\1\u013b\1\uffff\1\u013c\1"+
        "\62\3\uffff\1\u013e\1\u013f\1\u0140\3\62\1\u0144\2\uffff\1\u0145"+
        "\1\uffff\2\62\1\u0148\1\u014a\7\uffff\1\62\1\u014e\6\62\1\u0156"+
        "\1\uffff\1\u0157\1\62\2\uffff\1\u0159\1\uffff\1\62\1\u015b\6\62"+
        "\1\uffff\1\u0162\2\62\1\u0165\3\uffff\1\62\1\u0167\1\62\4\uffff"+
        "\1\u0169\3\uffff\2\62\1\u016c\2\uffff\2\62\1\uffff\1\62\3\uffff"+
        "\1\u0170\1\uffff\2\62\1\u0173\1\u0174\2\62\1\u0177\2\uffff\1\u0178"+
        "\1\uffff\1\62\1\uffff\2\62\1\u017c\1\u017d\2\62\1\uffff\1\62\1\u0181"+
        "\1\uffff\1\62\1\uffff\1\62\1\uffff\2\62\1\uffff\1\62\1\u0187\1\62"+
        "\1\uffff\2\62\2\uffff\2\62\2\uffff\1\62\1\u018e\1\u018f\2\uffff"+
        "\3\62\1\uffff\1\u0193\1\62\1\u0195\2\62\1\uffff\2\62\1\u019a\3\62"+
        "\2\uffff\3\62\1\uffff\1\62\1\uffff\1\62\1\u01a3\1\u01a4\1\62\1\uffff"+
        "\1\u01a6\1\u01a7\1\u01a8\1\u01a9\1\u01aa\1\62\1\u01ac\1\u01ad\2"+
        "\uffff\1\62\5\uffff\1\62\2\uffff\3\62\1\u01b3\1\62\1\uffff\1\62"+
        "\1\u01b6\1\uffff";
    static final String DFA25_eofS =
        "\u01b7\uffff";
    static final String DFA25_minS =
        "\1\11\1\105\1\101\1\110\1\122\1\105\3\101\1\116\1\105\1\101\1\116"+
        "\1\106\1\101\1\117\1\114\1\101\13\uffff\1\0\1\uffff\1\75\1\117\2"+
        "\uffff\1\55\2\uffff\1\101\6\uffff\2\0\1\60\1\uffff\1\60\2\uffff"+
        "\1\114\1\101\1\122\2\114\2\117\1\114\1\116\2\105\1\60\1\124\1\117"+
        "\1\107\1\60\1\105\1\122\1\111\1\103\1\116\1\127\1\123\1\122\1\102"+
        "\1\113\1\101\1\123\1\120\2\122\1\60\1\104\3\60\1\125\1\105\1\115"+
        "\1\102\1\114\1\124\1\104\2\123\1\125\1\124\2\123\1\uffff\1\0\4\uffff"+
        "\1\122\2\uffff\1\0\2\42\1\0\2\42\1\60\1\uffff\3\60\1\53\1\60\1\105"+
        "\1\104\1\114\1\111\1\105\1\114\1\115\1\101\1\115\1\123\1\104\1\110"+
        "\1\116\1\122\1\uffff\1\105\1\127\1\114\1\101\1\111\1\uffff\1\103"+
        "\1\124\1\110\1\113\1\117\1\105\1\107\1\60\1\105\1\122\2\117\1\105"+
        "\1\104\1\123\1\60\1\105\1\101\1\uffff\2\60\2\uffff\1\60\1\uffff"+
        "\1\105\1\116\1\131\1\105\2\114\2\60\1\105\1\60\1\124\1\102\1\105"+
        "\1\103\2\uffff\1\60\12\0\1\uffff\12\0\1\60\2\uffff\1\60\1\uffff"+
        "\1\103\1\105\1\114\1\116\1\103\1\111\1\117\1\101\1\124\1\60\1\105"+
        "\1\117\2\60\1\105\1\60\1\122\2\105\1\122\1\116\1\105\1\111\1\60"+
        "\1\105\1\122\1\130\1\105\1\uffff\3\60\1\105\1\116\1\125\3\60\1\uffff"+
        "\1\60\1\131\3\uffff\3\60\1\111\1\123\1\105\1\60\2\uffff\1\60\1\uffff"+
        "\1\111\1\114\2\60\2\uffff\4\0\1\uffff\1\124\1\60\1\111\1\107\1\124"+
        "\1\116\1\127\1\124\1\60\1\uffff\1\60\1\127\2\uffff\1\60\1\uffff"+
        "\1\122\1\60\1\105\1\101\1\131\1\124\1\104\1\124\1\uffff\1\60\1\104"+
        "\1\120\1\60\3\uffff\1\116\1\60\1\116\4\uffff\1\60\3\uffff\1\116"+
        "\1\124\1\60\2\uffff\1\116\1\105\1\uffff\1\111\1\uffff\2\0\1\60\1"+
        "\uffff\1\122\1\116\2\60\1\120\1\111\1\60\2\uffff\1\60\1\uffff\1"+
        "\111\1\uffff\2\116\2\60\2\111\1\uffff\1\127\1\60\1\uffff\1\124\1"+
        "\uffff\1\104\1\uffff\1\124\1\101\1\uffff\1\103\1\60\1\115\1\uffff"+
        "\1\117\1\124\2\uffff\1\125\1\116\2\uffff\1\124\2\60\2\uffff\1\116"+
        "\1\117\1\122\1\uffff\1\60\1\105\1\60\1\115\1\124\1\uffff\1\105\1"+
        "\120\1\60\1\124\1\107\1\105\2\uffff\1\107\1\116\1\111\1\uffff\1"+
        "\104\1\uffff\1\120\2\60\1\105\1\uffff\5\60\1\124\2\60\2\uffff\1"+
        "\122\5\uffff\1\105\2\uffff\1\124\1\122\1\111\1\60\1\105\1\uffff"+
        "\1\123\1\60\1\uffff";
    static final String DFA25_maxS =
        "\1\176\1\164\1\162\1\151\1\166\1\171\1\162\1\157\1\165\1\156\2\157"+
        "\2\163\1\162\1\165\1\156\1\157\13\uffff\1\ufffe\1\uffff\1\75\1\157"+
        "\2\uffff\1\55\2\uffff\1\157\6\uffff\2\ufffe\1\172\1\uffff\1\172"+
        "\2\uffff\1\162\1\141\1\162\1\154\1\162\2\157\1\154\1\164\2\145\1"+
        "\172\1\164\1\157\1\156\1\172\1\145\1\164\1\151\1\147\1\156\1\167"+
        "\1\163\1\162\1\151\1\153\1\141\1\163\1\160\2\162\1\172\1\144\3\172"+
        "\1\165\1\145\1\156\1\142\1\154\1\164\1\144\2\163\1\165\1\164\2\163"+
        "\1\uffff\1\ufffe\4\uffff\1\162\2\uffff\1\ufffe\1\164\1\47\1\ufffe"+
        "\1\164\1\47\1\146\1\uffff\3\172\1\71\1\172\1\145\1\144\1\154\1\165"+
        "\1\145\1\154\1\155\1\141\1\155\1\163\1\144\1\150\2\162\1\uffff\1"+
        "\145\1\167\1\154\1\141\1\151\1\uffff\1\143\1\164\1\150\1\153\1\157"+
        "\1\145\1\147\1\172\1\164\1\162\2\157\1\145\1\144\1\163\1\172\1\145"+
        "\1\141\1\uffff\2\172\2\uffff\1\172\1\uffff\1\145\1\156\1\171\1\145"+
        "\2\154\2\172\1\145\1\172\1\164\1\142\1\145\1\143\2\uffff\1\172\12"+
        "\ufffe\1\uffff\12\ufffe\1\172\2\uffff\1\172\1\uffff\1\143\1\145"+
        "\1\154\1\156\1\143\1\151\1\157\1\141\1\164\1\172\1\145\1\157\2\172"+
        "\1\145\1\172\1\162\2\145\1\162\1\156\1\145\1\151\1\172\1\145\1\162"+
        "\1\170\1\145\1\uffff\3\172\1\145\1\156\1\165\3\172\1\uffff\1\172"+
        "\1\171\3\uffff\3\172\1\151\1\163\1\145\1\172\2\uffff\1\172\1\uffff"+
        "\1\151\1\154\2\172\2\uffff\4\ufffe\1\uffff\1\164\1\172\1\151\1\147"+
        "\1\164\1\156\1\167\1\164\1\172\1\uffff\1\172\1\167\2\uffff\1\172"+
        "\1\uffff\1\162\1\172\1\145\1\141\1\171\1\164\1\144\1\164\1\uffff"+
        "\1\172\1\144\1\160\1\172\3\uffff\1\156\1\172\1\156\4\uffff\1\172"+
        "\3\uffff\1\156\1\164\1\172\2\uffff\1\156\1\145\1\uffff\1\151\1\uffff"+
        "\2\ufffe\1\172\1\uffff\1\162\1\156\2\172\1\160\1\151\1\172\2\uffff"+
        "\1\172\1\uffff\1\151\1\uffff\2\156\2\172\2\151\1\uffff\1\167\1\172"+
        "\1\uffff\1\164\1\uffff\1\144\1\uffff\1\164\1\141\1\uffff\1\143\1"+
        "\172\1\155\1\uffff\1\157\1\164\2\uffff\1\165\1\156\2\uffff\1\164"+
        "\2\172\2\uffff\1\156\1\157\1\162\1\uffff\1\172\1\145\1\172\1\155"+
        "\1\164\1\uffff\1\145\1\160\1\172\1\164\1\147\1\145\2\uffff\1\147"+
        "\1\156\1\151\1\uffff\1\144\1\uffff\1\160\2\172\1\145\1\uffff\5\172"+
        "\1\164\2\172\2\uffff\1\162\5\uffff\1\145\2\uffff\1\164\1\162\1\151"+
        "\1\172\1\145\1\uffff\1\163\1\172\1\uffff";
    static final String DFA25_acceptS =
        "\22\uffff\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111"+
        "\1\112\1\113\1\uffff\1\115\2\uffff\1\126\1\127\1\uffff\1\131\1\132"+
        "\1\uffff\1\134\1\135\1\136\1\137\1\140\1\141\3\uffff\1\145\1\uffff"+
        "\1\152\1\153\61\uffff\1\115\1\uffff\1\142\1\117\1\120\1\121\1\uffff"+
        "\1\154\1\130\7\uffff\1\151\23\uffff\1\124\5\uffff\1\6\22\uffff\1"+
        "\23\2\uffff\1\70\1\43\1\uffff\1\45\16\uffff\1\114\1\116\13\uffff"+
        "\1\143\13\uffff\1\150\1\146\1\uffff\1\147\34\uffff\1\15\11\uffff"+
        "\1\72\2\uffff\1\77\1\122\1\56\7\uffff\1\123\1\52\1\uffff\1\133\4"+
        "\uffff\1\114\1\125\4\uffff\1\144\11\uffff\1\2\2\uffff\1\10\1\50"+
        "\1\uffff\1\24\10\uffff\1\26\4\uffff\1\11\1\53\1\47\3\uffff\1\40"+
        "\1\33\1\21\1\22\1\uffff\1\25\1\36\1\44\3\uffff\1\46\1\51\2\uffff"+
        "\1\63\1\uffff\1\100\3\uffff\1\30\7\uffff\1\61\1\37\1\uffff\1\3\1"+
        "\uffff\1\5\6\uffff\1\41\2\uffff\1\12\1\uffff\1\74\1\uffff\1\71\2"+
        "\uffff\1\34\3\uffff\1\1\2\uffff\1\66\1\73\2\uffff\1\27\1\76\3\uffff"+
        "\1\67\1\57\3\uffff\1\42\5\uffff\1\62\6\uffff\1\13\1\60\3\uffff\1"+
        "\14\1\uffff\1\54\4\uffff\1\55\10\uffff\1\75\1\64\1\uffff\1\4\1\20"+
        "\1\35\1\17\1\7\1\uffff\1\16\1\65\5\uffff\1\32\2\uffff\1\31";
    static final String DFA25_specialS =
        "\u01b7\uffff}>";
    static final String[] DFA25_transitionS = {
            "\2\63\1\uffff\2\63\22\uffff\1\63\1\36\1\56\1\uffff\1\54\1\45"+
            "\1\47\1\55\1\26\1\27\1\44\1\42\1\24\1\43\1\22\1\41\1\57\11\61"+
            "\1\23\1\25\1\35\1\34\1\37\1\53\1\uffff\1\14\1\5\1\10\1\21\1"+
            "\20\1\2\2\62\1\15\2\62\1\12\1\13\1\17\1\4\1\6\1\62\1\7\1\1\1"+
            "\16\1\11\1\62\1\3\1\40\2\62\1\30\1\uffff\1\31\1\52\1\60\1\62"+
            "\1\14\1\5\1\10\1\46\1\20\1\2\2\62\1\15\2\62\1\12\1\13\1\17\1"+
            "\4\1\6\1\62\1\7\1\1\1\16\1\11\1\62\1\3\1\40\2\62\1\32\1\51\1"+
            "\33\1\50",
            "\1\64\7\uffff\1\65\6\uffff\1\66\20\uffff\1\64\7\uffff\1\65\6"+
            "\uffff\1\66",
            "\1\73\7\uffff\1\67\2\uffff\1\71\2\uffff\1\70\2\uffff\1\72\16"+
            "\uffff\1\73\7\uffff\1\67\2\uffff\1\71\2\uffff\1\70\2\uffff\1"+
            "\72",
            "\1\75\1\74\36\uffff\1\75\1\74",
            "\1\77\3\uffff\1\76\33\uffff\1\77\3\uffff\1\76",
            "\1\100\3\uffff\1\102\5\uffff\1\101\11\uffff\1\103\13\uffff\1"+
            "\100\3\uffff\1\102\5\uffff\1\101\11\uffff\1\103",
            "\1\105\20\uffff\1\104\16\uffff\1\105\20\uffff\1\104",
            "\1\110\3\uffff\1\107\6\uffff\1\106\2\uffff\1\111\21\uffff\1"+
            "\110\3\uffff\1\107\6\uffff\1\106\2\uffff\1\111",
            "\1\112\23\uffff\1\113\13\uffff\1\112\23\uffff\1\113",
            "\1\114\37\uffff\1\114",
            "\1\117\3\uffff\1\115\5\uffff\1\116\25\uffff\1\117\3\uffff\1"+
            "\115\5\uffff\1\116",
            "\1\120\15\uffff\1\121\21\uffff\1\120\15\uffff\1\121",
            "\1\124\3\uffff\1\122\1\123\32\uffff\1\124\3\uffff\1\122\1\123",
            "\1\125\7\uffff\1\126\4\uffff\1\127\22\uffff\1\125\7\uffff\1"+
            "\126\4\uffff\1\127",
            "\1\133\6\uffff\1\131\1\132\10\uffff\1\130\16\uffff\1\133\6\uffff"+
            "\1\131\1\132\10\uffff\1\130",
            "\1\135\5\uffff\1\134\31\uffff\1\135\5\uffff\1\134",
            "\1\137\1\uffff\1\136\35\uffff\1\137\1\uffff\1\136",
            "\1\142\3\uffff\1\143\3\uffff\1\140\5\uffff\1\141\21\uffff\1"+
            "\142\3\uffff\1\143\3\uffff\1\144\5\uffff\1\141",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\75\147\1\146\1\145\uffc0\147",
            "",
            "\1\151",
            "\1\153\37\uffff\1\153",
            "",
            "",
            "\1\154",
            "",
            "",
            "\1\142\3\uffff\1\143\3\uffff\1\144\5\uffff\1\141\21\uffff\1"+
            "\142\3\uffff\1\143\3\uffff\1\144\5\uffff\1\141",
            "",
            "",
            "",
            "",
            "",
            "",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\12\167\7\uffff\4\62\1\171\6\62\1\170\6\62\1\172\4\62\1\164"+
            "\1\166\1\62\4\uffff\1\62\1\uffff\4\62\1\171\25\62",
            "",
            "\12\167\7\uffff\4\62\1\171\6\62\1\170\6\62\1\172\5\62\1\166"+
            "\1\62\4\uffff\1\62\1\uffff\4\62\1\171\25\62",
            "",
            "",
            "\1\173\5\uffff\1\174\31\uffff\1\173\5\uffff\1\174",
            "\1\175\37\uffff\1\175",
            "\1\176\37\uffff\1\176",
            "\1\177\37\uffff\1\177",
            "\1\u0080\5\uffff\1\u0081\31\uffff\1\u0080\5\uffff\1\u0081",
            "\1\u0082\37\uffff\1\u0082",
            "\1\u0083\37\uffff\1\u0083",
            "\1\u0084\37\uffff\1\u0084",
            "\1\u0085\5\uffff\1\u0086\31\uffff\1\u0085\5\uffff\1\u0086",
            "\1\u0087\37\uffff\1\u0087",
            "\1\u0088\37\uffff\1\u0088",
            "\12\62\7\uffff\3\62\1\u008a\26\62\4\uffff\1\62\1\uffff\3\62"+
            "\1\u008a\26\62",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\37\uffff\1\u008c",
            "\1\u008e\6\uffff\1\u008d\30\uffff\1\u008e\6\uffff\1\u008d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\1\uffff\1\u0092\35\uffff\1\u0091\1\uffff\1\u0092",
            "\1\u0093\37\uffff\1\u0093",
            "\1\u0094\3\uffff\1\u0095\33\uffff\1\u0094\3\uffff\1\u0095",
            "\1\u0096\37\uffff\1\u0096",
            "\1\u0097\37\uffff\1\u0097",
            "\1\u0098\37\uffff\1\u0098",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009b\6\uffff\1\u009a\30\uffff\1\u009b\6\uffff\1\u009a",
            "\1\u009c\37\uffff\1\u009c",
            "\1\u009d\37\uffff\1\u009d",
            "\1\u009e\37\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\u00a1\37\uffff\1\u00a1",
            "\12\62\7\uffff\2\62\1\u00a3\27\62\4\uffff\1\62\1\uffff\2\62"+
            "\1\u00a3\27\62",
            "\1\u00a4\37\uffff\1\u00a4",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\23\62\1\u00a7\6\62\4\uffff\1\62\1\uffff\23\62"+
            "\1\u00a7\6\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\u00ac\1\u00ab\36\uffff\1\u00ac\1\u00ab",
            "\1\u00ad\37\uffff\1\u00ad",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00b0",
            "\1\u00b1\37\uffff\1\u00b1",
            "\1\u00b3\2\uffff\1\u00b2\34\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b5",
            "\1\u00b6\37\uffff\1\u00b6",
            "\1\u00b3\37\uffff\1\u00b3",
            "",
            "\76\147\1\u00b7\uffc0\147",
            "",
            "",
            "",
            "",
            "\1\u00b9\37\uffff\1\u00b9",
            "",
            "",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\1\u00bf\4\uffff\1\u00c0\10\uffff\4\u00c2\4\u00c3\44\uffff\1"+
            "\u00c1\5\uffff\1\u00ba\3\uffff\1\u00bd\7\uffff\1\u00bc\3\uffff"+
            "\1\u00be\1\uffff\1\u00bb",
            "\1\56\4\uffff\1\55",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\1\u00ca\4\uffff\1\u00cb\10\uffff\4\u00cd\4\u00ce\44\uffff\1"+
            "\u00cc\5\uffff\1\u00c5\3\uffff\1\u00c8\7\uffff\1\u00c7\3\uffff"+
            "\1\u00c9\1\uffff\1\u00c6",
            "\1\56\4\uffff\1\55",
            "\12\u00cf\7\uffff\6\u00cf\32\uffff\6\u00cf",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\167\7\uffff\4\62\1\171\6\62\1\170\6\62\1\172\5\62\1\166"+
            "\1\62\4\uffff\1\62\1\uffff\4\62\1\171\25\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\165\1\uffff\1\165\2\uffff\12\u00d2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00d4\37\uffff\1\u00d4",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\u00d7\13\uffff\1\u00d8\23\uffff\1\u00d7\13\uffff\1\u00d8",
            "\1\u00d9\37\uffff\1\u00d9",
            "\1\u00da\37\uffff\1\u00da",
            "\1\u00db\37\uffff\1\u00db",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\1\u00df\37\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00e0",
            "\1\u00e1\3\uffff\1\u00e2\33\uffff\1\u00e1\3\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e3",
            "",
            "\1\u00e4\37\uffff\1\u00e4",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\u00e8\37\uffff\1\u00e8",
            "",
            "\1\u00e9\37\uffff\1\u00e9",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\u00ed\37\uffff\1\u00ed",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\u00ef\37\uffff\1\u00ef",
            "\12\62\7\uffff\22\62\1\u00f1\7\62\4\uffff\1\62\1\uffff\22\62"+
            "\1\u00f1\7\62",
            "\1\u00f3\16\uffff\1\u00f2\20\uffff\1\u00f3\16\uffff\1\u00f2",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\u00f5\37\uffff\1\u00f5",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f7",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\u00f9\37\uffff\1\u00f9",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fc",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\16\62\1\u0100\13\62\4\uffff\1\62\1\uffff\16\62"+
            "\1\u0100\13\62",
            "",
            "\1\u0101\37\uffff\1\u0101",
            "\1\u0102\37\uffff\1\u0102",
            "\1\u0103\37\uffff\1\u0103",
            "\1\u0104\37\uffff\1\u0104",
            "\1\u0105\37\uffff\1\u0105",
            "\1\u0106\37\uffff\1\u0106",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0109\37\uffff\1\u0109",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u010b\37\uffff\1\u010b",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d\37\uffff\1\u010d",
            "\1\u010e\37\uffff\1\u010e",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\47\156\1\160\10\156\10\u0111\44\156\1\157\uffa2\156",
            "\47\156\1\160\10\156\10\u0112\44\156\1\157\uffa2\156",
            "",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\42\161\1\163\15\161\10\u0113\44\161\1\162\uffa2\161",
            "\42\161\1\163\15\161\10\u0114\44\161\1\162\uffa2\161",
            "\12\u00cf\7\uffff\6\u00cf\24\62\4\uffff\1\62\1\uffff\6\u00cf"+
            "\24\62",
            "",
            "",
            "\12\u00d2\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0116\37\uffff\1\u0116",
            "\1\u0117\37\uffff\1\u0117",
            "\1\u0118\37\uffff\1\u0118",
            "\1\u0119\37\uffff\1\u0119",
            "\1\u011a\37\uffff\1\u011a",
            "\1\u011b\37\uffff\1\u011b",
            "\1\u011c\37\uffff\1\u011c",
            "\1\u011d\37\uffff\1\u011d",
            "\1\u011e\37\uffff\1\u011e",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0120\37\uffff\1\u0120",
            "\1\u0121\37\uffff\1\u0121",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0124\37\uffff\1\u0124",
            "\12\62\7\uffff\26\62\1\u0126\3\62\4\uffff\1\62\1\uffff\26\62"+
            "\1\u0126\3\62",
            "\1\u0127\37\uffff\1\u0127",
            "\1\u0128\37\uffff\1\u0128",
            "\1\u0129\37\uffff\1\u0129",
            "\1\u012a\37\uffff\1\u012a",
            "\1\u012b\37\uffff\1\u012b",
            "\1\u012c\37\uffff\1\u012c",
            "\1\u012d\37\uffff\1\u012d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u012f\37\uffff\1\u012f",
            "\1\u0130\37\uffff\1\u0130",
            "\1\u0131\37\uffff\1\u0131",
            "\1\u0132\37\uffff\1\u0132",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0136\37\uffff\1\u0136",
            "\1\u0137\37\uffff\1\u0137",
            "\1\u0138\37\uffff\1\u0138",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u013d\37\uffff\1\u013d",
            "",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0141\37\uffff\1\u0141",
            "\1\u0142\37\uffff\1\u0142",
            "\1\u0143\37\uffff\1\u0143",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0146\37\uffff\1\u0146",
            "\1\u0147\37\uffff\1\u0147",
            "\12\62\7\uffff\23\62\1\u0149\6\62\4\uffff\1\62\1\uffff\23\62"+
            "\1\u0149\6\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\47\156\1\160\10\156\10\u014b\44\156\1\157\uffa2\156",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\42\161\1\163\15\161\10\u014c\44\161\1\162\uffa2\161",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "",
            "\1\u014d\37\uffff\1\u014d",
            "\12\62\7\uffff\17\62\1\u014f\12\62\4\uffff\1\62\1\uffff\17\62"+
            "\1\u014f\12\62",
            "\1\u0150\37\uffff\1\u0150",
            "\1\u0151\37\uffff\1\u0151",
            "\1\u0152\37\uffff\1\u0152",
            "\1\u0153\37\uffff\1\u0153",
            "\1\u0154\37\uffff\1\u0154",
            "\1\u0155\37\uffff\1\u0155",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0158\37\uffff\1\u0158",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u015a\37\uffff\1\u015a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u015c\37\uffff\1\u015c",
            "\1\u015d\37\uffff\1\u015d",
            "\1\u015e\37\uffff\1\u015e",
            "\1\u015f\37\uffff\1\u015f",
            "\1\u0160\37\uffff\1\u0160",
            "\1\u0161\37\uffff\1\u0161",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0163\37\uffff\1\u0163",
            "\1\u0164\37\uffff\1\u0164",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "\1\u0166\37\uffff\1\u0166",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0168\37\uffff\1\u0168",
            "",
            "",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "\1\u016a\37\uffff\1\u016a",
            "\1\u016b\37\uffff\1\u016b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\u016d\37\uffff\1\u016d",
            "\1\u016e\37\uffff\1\u016e",
            "",
            "\1\u016f\37\uffff\1\u016f",
            "",
            "\47\156\1\160\64\156\1\157\uffa2\156",
            "\42\161\1\163\71\161\1\162\uffa2\161",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0171\37\uffff\1\u0171",
            "\1\u0172\37\uffff\1\u0172",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0175\37\uffff\1\u0175",
            "\1\u0176\37\uffff\1\u0176",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0179\37\uffff\1\u0179",
            "",
            "\1\u017a\37\uffff\1\u017a",
            "\1\u017b\37\uffff\1\u017b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u017e\37\uffff\1\u017e",
            "\1\u017f\37\uffff\1\u017f",
            "",
            "\1\u0180\37\uffff\1\u0180",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0182\37\uffff\1\u0182",
            "",
            "\1\u0183\37\uffff\1\u0183",
            "",
            "\1\u0184\37\uffff\1\u0184",
            "\1\u0185\37\uffff\1\u0185",
            "",
            "\1\u0186\37\uffff\1\u0186",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0188\37\uffff\1\u0188",
            "",
            "\1\u0189\37\uffff\1\u0189",
            "\1\u018a\37\uffff\1\u018a",
            "",
            "",
            "\1\u018b\37\uffff\1\u018b",
            "\1\u018c\37\uffff\1\u018c",
            "",
            "",
            "\1\u018d\37\uffff\1\u018d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\u0190\37\uffff\1\u0190",
            "\1\u0191\37\uffff\1\u0191",
            "\1\u0192\37\uffff\1\u0192",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0194\37\uffff\1\u0194",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0196\37\uffff\1\u0196",
            "\1\u0197\37\uffff\1\u0197",
            "",
            "\1\u0198\37\uffff\1\u0198",
            "\1\u0199\37\uffff\1\u0199",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u019b\37\uffff\1\u019b",
            "\1\u019c\37\uffff\1\u019c",
            "\1\u019d\37\uffff\1\u019d",
            "",
            "",
            "\1\u019e\37\uffff\1\u019e",
            "\1\u019f\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a0",
            "",
            "\1\u01a1\37\uffff\1\u01a1",
            "",
            "\1\u01a2\37\uffff\1\u01a2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01a5\37\uffff\1\u01a5",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01ab\37\uffff\1\u01ab",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\u01ae\37\uffff\1\u01ae",
            "",
            "",
            "",
            "",
            "",
            "\1\u01af\37\uffff\1\u01af",
            "",
            "",
            "\1\u01b0\37\uffff\1\u01b0",
            "\1\u01b1\37\uffff\1\u01b1",
            "\1\u01b2\37\uffff\1\u01b2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01b4\37\uffff\1\u01b4",
            "",
            "\1\u01b5\37\uffff\1\u01b5",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SELECT | FROM | WHERE | FILEINPUT | ORDER | BY | PARTITION | WITH | ROWS | RANGE | BETWEEN | CURRENT | ROW | UNBOUNDED | PRECEDING | FOLLOWING | LESS | MORE | AS | OVER | INTO | PATH | FORMAT | SERDE | SERDEPROPERTIES | RECORDWRITER | LOAD | TABLE | OVERWRITE | TRUE | FALSE | LIKE | RLIKE | REGEXP | IN | THEN | IS | NULL | CASE | WHEN | ELSE | END | CAST | TINYINT | SMALLINT | INT | BIGINT | BOOLEAN | FLOAT | DOUBLE | DATE | DATETIME | TIMESTAMP | STRING | BINARY | IF | ARRAY | MAP | STRUCT | UNION | DISTINCT | WINDOW | ASC | DESC | DOT | COLON | COMMA | SEMICOLON | LPAREN | RPAREN | LSQUARE | RSQUARE | LCURLY | RCURLY | EQUAL | EQUAL_NS | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN | AND | NOT | OR | XOR | DIVIDE | PLUS | MINUS | STAR | MOD | DIV | AMPERSAND | TILDE | BITWISEOR | BITWISEXOR | QUESTION | DOLLAR | HIVEQUERY | StringLiteral | CharSetLiteral | CharSetName | BigintLiteral | SmallintLiteral | TinyintLiteral | Number | Identifier | WS | COMMENT );";
        }
    }
 

}