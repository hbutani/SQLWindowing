// $ANTLR 3.0.1 Windowing.g 2012-04-09 15:32:10

package com.sap.hadoop.windowing.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class WindowingLexer extends Lexer {
    public static final int FUNCTION=9;
    public static final int LT=70;
    public static final int OVERWRITE=59;
    public static final int ORDERCOLUMN=8;
    public static final int FUNCTIONS=10;
    public static final int ROW=46;
    public static final int OUTPUTSPEC=16;
    public static final int PARAM=7;
    public static final int NOT=97;
    public static final int EOF=-1;
    public static final int GROOVYEXPRESSION=26;
    public static final int LBRACKET=35;
    public static final int RPAREN=24;
    public static final int QUOTE=61;
    public static final int RECORDWRITER=56;
    public static final int PATH=53;
    public static final int WINDOWRANGE=12;
    public static final int PRECEDING=43;
    public static final int GroovyEscapeSequence=101;
    public static final int LESS=48;
    public static final int SERDEPROPERTIES=55;
    public static final int EQ=28;
    public static final int SELECT=50;
    public static final int INTO=52;
    public static final int NE=72;
    public static final int D=93;
    public static final int E=77;
    public static final int TYPENAME=14;
    public static final int F=81;
    public static final int GE=66;
    public static final int G=95;
    public static final int A=87;
    public static final int B=88;
    public static final int RBRACE=74;
    public static final int C=79;
    public static final int ASC=31;
    public static final int L=78;
    public static final int M=84;
    public static final int WINDOWVALUES=13;
    public static final int N=90;
    public static final int O=83;
    public static final int H=86;
    public static final int I=89;
    public static final int J=104;
    public static final int K=105;
    public static final int NUMBER=37;
    public static final int LOAD=58;
    public static final int U=92;
    public static final int T=80;
    public static final int W=85;
    public static final int V=96;
    public static final int Q=106;
    public static final int SEMICOLON=64;
    public static final int P=91;
    public static final int S=76;
    public static final int NUMERIC=4;
    public static final int R=82;
    public static final int Y=94;
    public static final int X=99;
    public static final int Z=107;
    public static final int WS=103;
    public static final int MORE=49;
    public static final int OR=98;
    public static final int QUERY=11;
    public static final int GT=67;
    public static final int SERDE=54;
    public static final int FROM=19;
    public static final int UNBOUNDED=42;
    public static final int EscapeSequence=102;
    public static final int TBLFUNCTION=17;
    public static final int OVER=38;
    public static final int WHERE=51;
    public static final int SELECTCOLUMN=15;
    public static final int ORDER=29;
    public static final int LBRACE=68;
    public static final int TABLE=60;
    public static final int TABLEINPUT=25;
    public static final int LOADSPEC=18;
    public static final int AND=41;
    public static final int ID=21;
    public static final int FOLLOWING=44;
    public static final int LPAREN=22;
    public static final int ASTERISK=62;
    public static final int AS=34;
    public static final int COMMA=23;
    public static final int PARTITION=33;
    public static final int PLUS=73;
    public static final int RBRACKET=36;
    public static final int DOT=65;
    public static final int WITH=20;
    public static final int INTEGER=5;
    public static final int BY=30;
    public static final int XOR=100;
    public static final int RANGE=47;
    public static final int UMINUS=6;
    public static final int MINUS=71;
    public static final int Tokens=108;
    public static final int SOLIDUS=75;
    public static final int CURRENT=45;
    public static final int COLON=63;
    public static final int ROWS=39;
    public static final int FORMAT=57;
    public static final int DESC=32;
    public static final int BETWEEN=40;
    public static final int LE=69;
    public static final int STRING=27;
    public WindowingLexer() {;} 
    public WindowingLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "Windowing.g"; }

    // $ANTLR start QUOTE
    public final void mQUOTE() throws RecognitionException {
        try {
            int _type = QUOTE;
            // Windowing.g:207:19: ( '\\'' )
            // Windowing.g:207:21: '\\''
            {
            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTE

    // $ANTLR start ASTERISK
    public final void mASTERISK() throws RecognitionException {
        try {
            int _type = ASTERISK;
            // Windowing.g:208:19: ( '*' )
            // Windowing.g:208:21: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ASTERISK

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // Windowing.g:209:19: ( ':' )
            // Windowing.g:209:21: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start SEMICOLON
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            // Windowing.g:210:19: ( ';' )
            // Windowing.g:210:21: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMICOLON

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // Windowing.g:211:19: ( ',' )
            // Windowing.g:211:21: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start DOT
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            // Windowing.g:212:19: ( '.' )
            // Windowing.g:212:21: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOT

    // $ANTLR start EQ
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            // Windowing.g:213:19: ( '=' )
            // Windowing.g:213:21: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQ

    // $ANTLR start GE
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            // Windowing.g:214:19: ( '>=' )
            // Windowing.g:214:21: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GE

    // $ANTLR start GT
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            // Windowing.g:215:19: ( '>' )
            // Windowing.g:215:21: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GT

    // $ANTLR start LBRACKET
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            // Windowing.g:216:19: ( '[' )
            // Windowing.g:216:21: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LBRACKET

    // $ANTLR start LBRACE
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            // Windowing.g:217:19: ( '{' )
            // Windowing.g:217:21: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LBRACE

    // $ANTLR start LE
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            // Windowing.g:218:19: ( '<=' )
            // Windowing.g:218:21: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LE

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            // Windowing.g:219:19: ( '(' )
            // Windowing.g:219:21: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start LT
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            // Windowing.g:220:19: ( '<' )
            // Windowing.g:220:21: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LT

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            // Windowing.g:221:19: ( '-' )
            // Windowing.g:221:21: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start NE
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            // Windowing.g:222:19: ( '<>' )
            // Windowing.g:222:21: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NE

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // Windowing.g:223:19: ( '+' )
            // Windowing.g:223:21: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start RBRACE
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            // Windowing.g:224:19: ( '}' )
            // Windowing.g:224:21: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RBRACE

    // $ANTLR start RBRACKET
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            // Windowing.g:225:19: ( ']' )
            // Windowing.g:225:21: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RBRACKET

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            // Windowing.g:226:19: ( ')' )
            // Windowing.g:226:21: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start SOLIDUS
    public final void mSOLIDUS() throws RecognitionException {
        try {
            int _type = SOLIDUS;
            // Windowing.g:227:19: ( '/' )
            // Windowing.g:227:21: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SOLIDUS

    // $ANTLR start SELECT
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            // Windowing.g:229:19: ( S E L E C T )
            // Windowing.g:229:21: S E L E C T
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
            // Windowing.g:230:19: ( F R O M )
            // Windowing.g:230:21: F R O M
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
            // Windowing.g:231:19: ( W H E R E )
            // Windowing.g:231:21: W H E R E
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

    // $ANTLR start TABLEINPUT
    public final void mTABLEINPUT() throws RecognitionException {
        try {
            int _type = TABLEINPUT;
            // Windowing.g:232:19: ( T A B L E I N P U T )
            // Windowing.g:232:21: T A B L E I N P U T
            {
            mT(); 
            mA(); 
            mB(); 
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
    // $ANTLR end TABLEINPUT

    // $ANTLR start ORDER
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            // Windowing.g:233:19: ( O R D E R )
            // Windowing.g:233:21: O R D E R
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
            // Windowing.g:234:19: ( B Y )
            // Windowing.g:234:21: B Y
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
            // Windowing.g:235:19: ( P A R T I T I O N )
            // Windowing.g:235:21: P A R T I T I O N
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
            // Windowing.g:236:19: ( W I T H )
            // Windowing.g:236:21: W I T H
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
            // Windowing.g:237:19: ( R O W S )
            // Windowing.g:237:21: R O W S
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
            // Windowing.g:238:18: ( R A N G E )
            // Windowing.g:238:20: R A N G E
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
            // Windowing.g:239:12: ( B E T W E E N )
            // Windowing.g:239:14: B E T W E E N
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
            // Windowing.g:240:12: ( C U R R E N T )
            // Windowing.g:240:14: C U R R E N T
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
            // Windowing.g:241:8: ( R O W )
            // Windowing.g:241:10: R O W
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
            // Windowing.g:242:16: ( U N B O U N D E D )
            // Windowing.g:242:18: U N B O U N D E D
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
            // Windowing.g:243:19: ( P R E C E D I N G )
            // Windowing.g:243:21: P R E C E D I N G
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
            // Windowing.g:244:19: ( F O L L O W I N G )
            // Windowing.g:244:21: F O L L O W I N G
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
            // Windowing.g:245:9: ( L E S S )
            // Windowing.g:245:11: L E S S
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
            // Windowing.g:246:9: ( M O R E )
            // Windowing.g:246:11: M O R E
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
            // Windowing.g:247:7: ( A S )
            // Windowing.g:247:9: A S
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
            // Windowing.g:248:9: ( O V E R )
            // Windowing.g:248:11: O V E R
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
            // Windowing.g:249:9: ( I N T O )
            // Windowing.g:249:11: I N T O
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
            // Windowing.g:250:9: ( P A T H )
            // Windowing.g:250:11: P A T H
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
            // Windowing.g:251:9: ( F O R M A T )
            // Windowing.g:251:11: F O R M A T
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
            // Windowing.g:252:9: ( S E R D E )
            // Windowing.g:252:11: S E R D E
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
            // Windowing.g:253:17: ( S E R D E P R O P E R T I E S )
            // Windowing.g:253:19: S E R D E P R O P E R T I E S
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
            // Windowing.g:254:14: ( R E C O R D W R I T E R )
            // Windowing.g:254:16: R E C O R D W R I T E R
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
            // Windowing.g:255:14: ( L O A D )
            // Windowing.g:255:16: L O A D
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
            // Windowing.g:256:14: ( T A B L E )
            // Windowing.g:256:16: T A B L E
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
            // Windowing.g:257:18: ( O V E R W R I T E )
            // Windowing.g:257:20: O V E R W R I T E
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

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // Windowing.g:263:19: ( A N D )
            // Windowing.g:263:21: A N D
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
            // Windowing.g:264:19: ( N O T )
            // Windowing.g:264:21: N O T
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
            // Windowing.g:265:19: ( O R )
            // Windowing.g:265:21: O R
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
            // Windowing.g:266:19: ( X O R )
            // Windowing.g:266:21: X O R
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

    // $ANTLR start ASC
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            // Windowing.g:268:19: ( A S C )
            // Windowing.g:268:21: A S C
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
            // Windowing.g:269:19: ( D E S C )
            // Windowing.g:269:21: D E S C
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

    // $ANTLR start NUMBER
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            // Windowing.g:271:11: ( ( '0' .. '9' )+ )
            // Windowing.g:271:13: ( '0' .. '9' )+
            {
            // Windowing.g:271:13: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Windowing.g:271:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUMBER

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // Windowing.g:273:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // Windowing.g:273:10: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // Windowing.g:273:34: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Windowing.g:
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
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start GROOVYEXPRESSION
    public final void mGROOVYEXPRESSION() throws RecognitionException {
        try {
            int _type = GROOVYEXPRESSION;
            // Windowing.g:276:18: ( '<' ( GroovyEscapeSequence | ~ ( '>' ) )* '>' )
            // Windowing.g:276:20: '<' ( GroovyEscapeSequence | ~ ( '>' ) )* '>'
            {
            match('<'); 
            // Windowing.g:277:3: ( GroovyEscapeSequence | ~ ( '>' ) )*
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
            	    // Windowing.g:277:4: GroovyEscapeSequence
            	    {
            	    mGroovyEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // Windowing.g:277:27: ~ ( '>' )
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
    // $ANTLR end GROOVYEXPRESSION

    // $ANTLR start GroovyEscapeSequence
    public final void mGroovyEscapeSequence() throws RecognitionException {
        try {
            // Windowing.g:282:22: ( '\\\\' '>' )
            // Windowing.g:283:3: '\\\\' '>'
            {
            match('\\'); 
            match('>'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end GroovyEscapeSequence

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // Windowing.g:287:5: ( '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )* '\\'' )
            // Windowing.g:287:9: '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )* '\\''
            {
            match('\''); 
            // Windowing.g:288:9: ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // Windowing.g:288:13: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // Windowing.g:289:13: ~ ( '\\\\' | '\\'' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
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
            	    break loop4;
                }
            } while (true);

            match('\''); 
            setText(getText().substring(1, getText().length()-1));

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start EscapeSequence
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // Windowing.g:296:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ) )
            // Windowing.g:296:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            {
            match('\\'); 
            // Windowing.g:296:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            int alt5=11;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt5=1;
                }
                break;
            case 't':
                {
                alt5=2;
                }
                break;
            case 'n':
                {
                alt5=3;
                }
                break;
            case 'f':
                {
                alt5=4;
                }
                break;
            case 'r':
                {
                alt5=5;
                }
                break;
            case '\"':
                {
                alt5=6;
                }
                break;
            case '\'':
                {
                alt5=7;
                }
                break;
            case '\\':
                {
                alt5=8;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
                {
                int LA5_9 = input.LA(2);

                if ( ((LA5_9>='0' && LA5_9<='7')) ) {
                    int LA5_11 = input.LA(3);

                    if ( ((LA5_11>='0' && LA5_11<='7')) ) {
                        alt5=9;
                    }
                    else {
                        alt5=10;}
                }
                else {
                    alt5=11;}
                }
                break;
            case '4':
            case '5':
            case '6':
            case '7':
                {
                int LA5_10 = input.LA(2);

                if ( ((LA5_10>='0' && LA5_10<='7')) ) {
                    alt5=10;
                }
                else {
                    alt5=11;}
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("296:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // Windowing.g:297:18: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // Windowing.g:298:18: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // Windowing.g:299:18: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 4 :
                    // Windowing.g:300:18: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // Windowing.g:301:18: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 6 :
                    // Windowing.g:302:18: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // Windowing.g:303:18: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // Windowing.g:304:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // Windowing.g:306:18: ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // Windowing.g:306:18: ( '0' .. '3' )
                    // Windowing.g:306:19: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // Windowing.g:306:29: ( '0' .. '7' )
                    // Windowing.g:306:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // Windowing.g:306:40: ( '0' .. '7' )
                    // Windowing.g:306:41: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 10 :
                    // Windowing.g:308:18: ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // Windowing.g:308:18: ( '0' .. '7' )
                    // Windowing.g:308:19: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // Windowing.g:308:29: ( '0' .. '7' )
                    // Windowing.g:308:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 11 :
                    // Windowing.g:310:18: ( '0' .. '7' )
                    {
                    // Windowing.g:310:18: ( '0' .. '7' )
                    // Windowing.g:310:19: '0' .. '7'
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

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // Windowing.g:314:5: ( ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+ )
            // Windowing.g:314:9: ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+
            {
            // Windowing.g:314:9: ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||(LA6_0>='\f' && LA6_0<='\r')||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Windowing.g:
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start A
    public final void mA() throws RecognitionException {
        try {
            // Windowing.g:323:11: ( ( 'a' | 'A' ) )
            // Windowing.g:323:12: ( 'a' | 'A' )
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
            // Windowing.g:324:11: ( ( 'b' | 'B' ) )
            // Windowing.g:324:12: ( 'b' | 'B' )
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
            // Windowing.g:325:11: ( ( 'c' | 'C' ) )
            // Windowing.g:325:12: ( 'c' | 'C' )
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
            // Windowing.g:326:11: ( ( 'd' | 'D' ) )
            // Windowing.g:326:12: ( 'd' | 'D' )
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
            // Windowing.g:327:11: ( ( 'e' | 'E' ) )
            // Windowing.g:327:12: ( 'e' | 'E' )
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
            // Windowing.g:328:11: ( ( 'f' | 'F' ) )
            // Windowing.g:328:12: ( 'f' | 'F' )
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
            // Windowing.g:329:11: ( ( 'g' | 'G' ) )
            // Windowing.g:329:12: ( 'g' | 'G' )
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
            // Windowing.g:330:11: ( ( 'h' | 'H' ) )
            // Windowing.g:330:12: ( 'h' | 'H' )
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
            // Windowing.g:331:11: ( ( 'i' | 'I' ) )
            // Windowing.g:331:12: ( 'i' | 'I' )
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
            // Windowing.g:332:11: ( ( 'j' | 'J' ) )
            // Windowing.g:332:12: ( 'j' | 'J' )
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
            // Windowing.g:333:11: ( ( 'k' | 'K' ) )
            // Windowing.g:333:12: ( 'k' | 'K' )
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
            // Windowing.g:334:11: ( ( 'l' | 'L' ) )
            // Windowing.g:334:12: ( 'l' | 'L' )
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
            // Windowing.g:335:11: ( ( 'm' | 'M' ) )
            // Windowing.g:335:12: ( 'm' | 'M' )
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
            // Windowing.g:336:11: ( ( 'n' | 'N' ) )
            // Windowing.g:336:12: ( 'n' | 'N' )
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
            // Windowing.g:337:11: ( ( 'o' | 'O' ) )
            // Windowing.g:337:12: ( 'o' | 'O' )
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
            // Windowing.g:338:11: ( ( 'p' | 'P' ) )
            // Windowing.g:338:12: ( 'p' | 'P' )
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
            // Windowing.g:339:11: ( ( 'q' | 'Q' ) )
            // Windowing.g:339:12: ( 'q' | 'Q' )
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
            // Windowing.g:340:11: ( ( 'r' | 'R' ) )
            // Windowing.g:340:12: ( 'r' | 'R' )
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
            // Windowing.g:341:11: ( ( 's' | 'S' ) )
            // Windowing.g:341:12: ( 's' | 'S' )
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
            // Windowing.g:342:11: ( ( 't' | 'T' ) )
            // Windowing.g:342:12: ( 't' | 'T' )
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
            // Windowing.g:343:11: ( ( 'u' | 'U' ) )
            // Windowing.g:343:12: ( 'u' | 'U' )
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
            // Windowing.g:344:11: ( ( 'v' | 'V' ) )
            // Windowing.g:344:12: ( 'v' | 'V' )
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
            // Windowing.g:345:11: ( ( 'w' | 'W' ) )
            // Windowing.g:345:12: ( 'w' | 'W' )
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
            // Windowing.g:346:11: ( ( 'x' | 'X' ) )
            // Windowing.g:346:12: ( 'x' | 'X' )
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
            // Windowing.g:347:11: ( ( 'y' | 'Y' ) )
            // Windowing.g:347:12: ( 'y' | 'Y' )
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
            // Windowing.g:348:11: ( ( 'z' | 'Z' ) )
            // Windowing.g:348:12: ( 'z' | 'Z' )
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
        // Windowing.g:1:8: ( QUOTE | ASTERISK | COLON | SEMICOLON | COMMA | DOT | EQ | GE | GT | LBRACKET | LBRACE | LE | LPAREN | LT | MINUS | NE | PLUS | RBRACE | RBRACKET | RPAREN | SOLIDUS | SELECT | FROM | WHERE | TABLEINPUT | ORDER | BY | PARTITION | WITH | ROWS | RANGE | BETWEEN | CURRENT | ROW | UNBOUNDED | PRECEDING | FOLLOWING | LESS | MORE | AS | OVER | INTO | PATH | FORMAT | SERDE | SERDEPROPERTIES | RECORDWRITER | LOAD | TABLE | OVERWRITE | AND | NOT | OR | XOR | ASC | DESC | NUMBER | ID | GROOVYEXPRESSION | STRING | WS )
        int alt7=61;
        switch ( input.LA(1) ) {
        case '\'':
            {
            int LA7_1 = input.LA(2);

            if ( ((LA7_1>='\u0000' && LA7_1<='\t')||(LA7_1>='\u000B' && LA7_1<='\f')||(LA7_1>='\u000E' && LA7_1<='\uFFFE')) ) {
                alt7=60;
            }
            else {
                alt7=1;}
            }
            break;
        case '*':
            {
            alt7=2;
            }
            break;
        case ':':
            {
            alt7=3;
            }
            break;
        case ';':
            {
            alt7=4;
            }
            break;
        case ',':
            {
            alt7=5;
            }
            break;
        case '.':
            {
            alt7=6;
            }
            break;
        case '=':
            {
            alt7=7;
            }
            break;
        case '>':
            {
            int LA7_8 = input.LA(2);

            if ( (LA7_8=='=') ) {
                alt7=8;
            }
            else {
                alt7=9;}
            }
            break;
        case '[':
            {
            alt7=10;
            }
            break;
        case '{':
            {
            alt7=11;
            }
            break;
        case '<':
            {
            int LA7_11 = input.LA(2);

            if ( (LA7_11=='=') ) {
                int LA7_43 = input.LA(3);

                if ( ((LA7_43>='\u0000' && LA7_43<='\uFFFE')) ) {
                    alt7=59;
                }
                else {
                    alt7=12;}
            }
            else if ( (LA7_11=='>') ) {
                alt7=16;
            }
            else if ( ((LA7_11>='\u0000' && LA7_11<='<')||(LA7_11>='?' && LA7_11<='\uFFFE')) ) {
                alt7=59;
            }
            else {
                alt7=14;}
            }
            break;
        case '(':
            {
            alt7=13;
            }
            break;
        case '-':
            {
            alt7=15;
            }
            break;
        case '+':
            {
            alt7=17;
            }
            break;
        case '}':
            {
            alt7=18;
            }
            break;
        case ']':
            {
            alt7=19;
            }
            break;
        case ')':
            {
            alt7=20;
            }
            break;
        case '/':
            {
            alt7=21;
            }
            break;
        case 'S':
        case 's':
            {
            int LA7_19 = input.LA(2);

            if ( (LA7_19=='E'||LA7_19=='e') ) {
                switch ( input.LA(3) ) {
                case 'R':
                case 'r':
                    {
                    int LA7_75 = input.LA(4);

                    if ( (LA7_75=='D'||LA7_75=='d') ) {
                        int LA7_106 = input.LA(5);

                        if ( (LA7_106=='E'||LA7_106=='e') ) {
                            switch ( input.LA(6) ) {
                            case 'P':
                            case 'p':
                                {
                                int LA7_161 = input.LA(7);

                                if ( (LA7_161=='R'||LA7_161=='r') ) {
                                    int LA7_177 = input.LA(8);

                                    if ( (LA7_177=='O'||LA7_177=='o') ) {
                                        int LA7_189 = input.LA(9);

                                        if ( (LA7_189=='P'||LA7_189=='p') ) {
                                            int LA7_199 = input.LA(10);

                                            if ( (LA7_199=='E'||LA7_199=='e') ) {
                                                int LA7_207 = input.LA(11);

                                                if ( (LA7_207=='R'||LA7_207=='r') ) {
                                                    int LA7_215 = input.LA(12);

                                                    if ( (LA7_215=='T'||LA7_215=='t') ) {
                                                        int LA7_218 = input.LA(13);

                                                        if ( (LA7_218=='I'||LA7_218=='i') ) {
                                                            int LA7_220 = input.LA(14);

                                                            if ( (LA7_220=='E'||LA7_220=='e') ) {
                                                                int LA7_222 = input.LA(15);

                                                                if ( (LA7_222=='S'||LA7_222=='s') ) {
                                                                    int LA7_223 = input.LA(16);

                                                                    if ( ((LA7_223>='0' && LA7_223<='9')||(LA7_223>='A' && LA7_223<='Z')||LA7_223=='_'||(LA7_223>='a' && LA7_223<='z')) ) {
                                                                        alt7=58;
                                                                    }
                                                                    else {
                                                                        alt7=46;}
                                                                }
                                                                else {
                                                                    alt7=58;}
                                                            }
                                                            else {
                                                                alt7=58;}
                                                        }
                                                        else {
                                                            alt7=58;}
                                                    }
                                                    else {
                                                        alt7=58;}
                                                }
                                                else {
                                                    alt7=58;}
                                            }
                                            else {
                                                alt7=58;}
                                        }
                                        else {
                                            alt7=58;}
                                    }
                                    else {
                                        alt7=58;}
                                }
                                else {
                                    alt7=58;}
                                }
                                break;
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                            case 'G':
                            case 'H':
                            case 'I':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'O':
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                            case '_':
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                            case 'g':
                            case 'h':
                            case 'i':
                            case 'j':
                            case 'k':
                            case 'l':
                            case 'm':
                            case 'n':
                            case 'o':
                            case 'q':
                            case 'r':
                            case 's':
                            case 't':
                            case 'u':
                            case 'v':
                            case 'w':
                            case 'x':
                            case 'y':
                            case 'z':
                                {
                                alt7=58;
                                }
                                break;
                            default:
                                alt7=45;}

                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                    }
                    break;
                case 'L':
                case 'l':
                    {
                    int LA7_76 = input.LA(4);

                    if ( (LA7_76=='E'||LA7_76=='e') ) {
                        int LA7_107 = input.LA(5);

                        if ( (LA7_107=='C'||LA7_107=='c') ) {
                            int LA7_136 = input.LA(6);

                            if ( (LA7_136=='T'||LA7_136=='t') ) {
                                int LA7_162 = input.LA(7);

                                if ( ((LA7_162>='0' && LA7_162<='9')||(LA7_162>='A' && LA7_162<='Z')||LA7_162=='_'||(LA7_162>='a' && LA7_162<='z')) ) {
                                    alt7=58;
                                }
                                else {
                                    alt7=22;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                    }
                    break;
                default:
                    alt7=58;}

            }
            else {
                alt7=58;}
            }
            break;
        case 'F':
        case 'f':
            {
            switch ( input.LA(2) ) {
            case 'R':
            case 'r':
                {
                int LA7_48 = input.LA(3);

                if ( (LA7_48=='O'||LA7_48=='o') ) {
                    int LA7_77 = input.LA(4);

                    if ( (LA7_77=='M'||LA7_77=='m') ) {
                        int LA7_108 = input.LA(5);

                        if ( ((LA7_108>='0' && LA7_108<='9')||(LA7_108>='A' && LA7_108<='Z')||LA7_108=='_'||(LA7_108>='a' && LA7_108<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=23;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            case 'O':
            case 'o':
                {
                switch ( input.LA(3) ) {
                case 'L':
                case 'l':
                    {
                    int LA7_78 = input.LA(4);

                    if ( (LA7_78=='L'||LA7_78=='l') ) {
                        int LA7_109 = input.LA(5);

                        if ( (LA7_109=='O'||LA7_109=='o') ) {
                            int LA7_138 = input.LA(6);

                            if ( (LA7_138=='W'||LA7_138=='w') ) {
                                int LA7_163 = input.LA(7);

                                if ( (LA7_163=='I'||LA7_163=='i') ) {
                                    int LA7_179 = input.LA(8);

                                    if ( (LA7_179=='N'||LA7_179=='n') ) {
                                        int LA7_190 = input.LA(9);

                                        if ( (LA7_190=='G'||LA7_190=='g') ) {
                                            int LA7_200 = input.LA(10);

                                            if ( ((LA7_200>='0' && LA7_200<='9')||(LA7_200>='A' && LA7_200<='Z')||LA7_200=='_'||(LA7_200>='a' && LA7_200<='z')) ) {
                                                alt7=58;
                                            }
                                            else {
                                                alt7=37;}
                                        }
                                        else {
                                            alt7=58;}
                                    }
                                    else {
                                        alt7=58;}
                                }
                                else {
                                    alt7=58;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                    }
                    break;
                case 'R':
                case 'r':
                    {
                    int LA7_79 = input.LA(4);

                    if ( (LA7_79=='M'||LA7_79=='m') ) {
                        int LA7_110 = input.LA(5);

                        if ( (LA7_110=='A'||LA7_110=='a') ) {
                            int LA7_139 = input.LA(6);

                            if ( (LA7_139=='T'||LA7_139=='t') ) {
                                int LA7_164 = input.LA(7);

                                if ( ((LA7_164>='0' && LA7_164<='9')||(LA7_164>='A' && LA7_164<='Z')||LA7_164=='_'||(LA7_164>='a' && LA7_164<='z')) ) {
                                    alt7=58;
                                }
                                else {
                                    alt7=44;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                    }
                    break;
                default:
                    alt7=58;}

                }
                break;
            default:
                alt7=58;}

            }
            break;
        case 'W':
        case 'w':
            {
            switch ( input.LA(2) ) {
            case 'H':
            case 'h':
                {
                int LA7_50 = input.LA(3);

                if ( (LA7_50=='E'||LA7_50=='e') ) {
                    int LA7_80 = input.LA(4);

                    if ( (LA7_80=='R'||LA7_80=='r') ) {
                        int LA7_111 = input.LA(5);

                        if ( (LA7_111=='E'||LA7_111=='e') ) {
                            int LA7_140 = input.LA(6);

                            if ( ((LA7_140>='0' && LA7_140<='9')||(LA7_140>='A' && LA7_140<='Z')||LA7_140=='_'||(LA7_140>='a' && LA7_140<='z')) ) {
                                alt7=58;
                            }
                            else {
                                alt7=24;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            case 'I':
            case 'i':
                {
                int LA7_51 = input.LA(3);

                if ( (LA7_51=='T'||LA7_51=='t') ) {
                    int LA7_81 = input.LA(4);

                    if ( (LA7_81=='H'||LA7_81=='h') ) {
                        int LA7_112 = input.LA(5);

                        if ( ((LA7_112>='0' && LA7_112<='9')||(LA7_112>='A' && LA7_112<='Z')||LA7_112=='_'||(LA7_112>='a' && LA7_112<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=29;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            default:
                alt7=58;}

            }
            break;
        case 'T':
        case 't':
            {
            int LA7_22 = input.LA(2);

            if ( (LA7_22=='A'||LA7_22=='a') ) {
                int LA7_52 = input.LA(3);

                if ( (LA7_52=='B'||LA7_52=='b') ) {
                    int LA7_82 = input.LA(4);

                    if ( (LA7_82=='L'||LA7_82=='l') ) {
                        int LA7_113 = input.LA(5);

                        if ( (LA7_113=='E'||LA7_113=='e') ) {
                            switch ( input.LA(6) ) {
                            case 'I':
                            case 'i':
                                {
                                int LA7_167 = input.LA(7);

                                if ( (LA7_167=='N'||LA7_167=='n') ) {
                                    int LA7_181 = input.LA(8);

                                    if ( (LA7_181=='P'||LA7_181=='p') ) {
                                        int LA7_191 = input.LA(9);

                                        if ( (LA7_191=='U'||LA7_191=='u') ) {
                                            int LA7_201 = input.LA(10);

                                            if ( (LA7_201=='T'||LA7_201=='t') ) {
                                                int LA7_209 = input.LA(11);

                                                if ( ((LA7_209>='0' && LA7_209<='9')||(LA7_209>='A' && LA7_209<='Z')||LA7_209=='_'||(LA7_209>='a' && LA7_209<='z')) ) {
                                                    alt7=58;
                                                }
                                                else {
                                                    alt7=25;}
                                            }
                                            else {
                                                alt7=58;}
                                        }
                                        else {
                                            alt7=58;}
                                    }
                                    else {
                                        alt7=58;}
                                }
                                else {
                                    alt7=58;}
                                }
                                break;
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                            case 'G':
                            case 'H':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'O':
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                            case '_':
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                            case 'g':
                            case 'h':
                            case 'j':
                            case 'k':
                            case 'l':
                            case 'm':
                            case 'n':
                            case 'o':
                            case 'p':
                            case 'q':
                            case 'r':
                            case 's':
                            case 't':
                            case 'u':
                            case 'v':
                            case 'w':
                            case 'x':
                            case 'y':
                            case 'z':
                                {
                                alt7=58;
                                }
                                break;
                            default:
                                alt7=49;}

                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
            }
            else {
                alt7=58;}
            }
            break;
        case 'O':
        case 'o':
            {
            switch ( input.LA(2) ) {
            case 'R':
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'D':
                case 'd':
                    {
                    int LA7_84 = input.LA(4);

                    if ( (LA7_84=='E'||LA7_84=='e') ) {
                        int LA7_114 = input.LA(5);

                        if ( (LA7_114=='R'||LA7_114=='r') ) {
                            int LA7_143 = input.LA(6);

                            if ( ((LA7_143>='0' && LA7_143<='9')||(LA7_143>='A' && LA7_143<='Z')||LA7_143=='_'||(LA7_143>='a' && LA7_143<='z')) ) {
                                alt7=58;
                            }
                            else {
                                alt7=26;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt7=58;
                    }
                    break;
                default:
                    alt7=53;}

                }
                break;
            case 'V':
            case 'v':
                {
                int LA7_54 = input.LA(3);

                if ( (LA7_54=='E'||LA7_54=='e') ) {
                    int LA7_85 = input.LA(4);

                    if ( (LA7_85=='R'||LA7_85=='r') ) {
                        switch ( input.LA(5) ) {
                        case 'W':
                        case 'w':
                            {
                            int LA7_145 = input.LA(6);

                            if ( (LA7_145=='R'||LA7_145=='r') ) {
                                int LA7_169 = input.LA(7);

                                if ( (LA7_169=='I'||LA7_169=='i') ) {
                                    int LA7_182 = input.LA(8);

                                    if ( (LA7_182=='T'||LA7_182=='t') ) {
                                        int LA7_192 = input.LA(9);

                                        if ( (LA7_192=='E'||LA7_192=='e') ) {
                                            int LA7_202 = input.LA(10);

                                            if ( ((LA7_202>='0' && LA7_202<='9')||(LA7_202>='A' && LA7_202<='Z')||LA7_202=='_'||(LA7_202>='a' && LA7_202<='z')) ) {
                                                alt7=58;
                                            }
                                            else {
                                                alt7=50;}
                                        }
                                        else {
                                            alt7=58;}
                                    }
                                    else {
                                        alt7=58;}
                                }
                                else {
                                    alt7=58;}
                            }
                            else {
                                alt7=58;}
                            }
                            break;
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '_':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'x':
                        case 'y':
                        case 'z':
                            {
                            alt7=58;
                            }
                            break;
                        default:
                            alt7=41;}

                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            default:
                alt7=58;}

            }
            break;
        case 'B':
        case 'b':
            {
            switch ( input.LA(2) ) {
            case 'E':
            case 'e':
                {
                int LA7_55 = input.LA(3);

                if ( (LA7_55=='T'||LA7_55=='t') ) {
                    int LA7_86 = input.LA(4);

                    if ( (LA7_86=='W'||LA7_86=='w') ) {
                        int LA7_116 = input.LA(5);

                        if ( (LA7_116=='E'||LA7_116=='e') ) {
                            int LA7_146 = input.LA(6);

                            if ( (LA7_146=='E'||LA7_146=='e') ) {
                                int LA7_170 = input.LA(7);

                                if ( (LA7_170=='N'||LA7_170=='n') ) {
                                    int LA7_183 = input.LA(8);

                                    if ( ((LA7_183>='0' && LA7_183<='9')||(LA7_183>='A' && LA7_183<='Z')||LA7_183=='_'||(LA7_183>='a' && LA7_183<='z')) ) {
                                        alt7=58;
                                    }
                                    else {
                                        alt7=32;}
                                }
                                else {
                                    alt7=58;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            case 'Y':
            case 'y':
                {
                int LA7_56 = input.LA(3);

                if ( ((LA7_56>='0' && LA7_56<='9')||(LA7_56>='A' && LA7_56<='Z')||LA7_56=='_'||(LA7_56>='a' && LA7_56<='z')) ) {
                    alt7=58;
                }
                else {
                    alt7=27;}
                }
                break;
            default:
                alt7=58;}

            }
            break;
        case 'P':
        case 'p':
            {
            switch ( input.LA(2) ) {
            case 'A':
            case 'a':
                {
                switch ( input.LA(3) ) {
                case 'R':
                case 'r':
                    {
                    int LA7_88 = input.LA(4);

                    if ( (LA7_88=='T'||LA7_88=='t') ) {
                        int LA7_117 = input.LA(5);

                        if ( (LA7_117=='I'||LA7_117=='i') ) {
                            int LA7_147 = input.LA(6);

                            if ( (LA7_147=='T'||LA7_147=='t') ) {
                                int LA7_171 = input.LA(7);

                                if ( (LA7_171=='I'||LA7_171=='i') ) {
                                    int LA7_184 = input.LA(8);

                                    if ( (LA7_184=='O'||LA7_184=='o') ) {
                                        int LA7_194 = input.LA(9);

                                        if ( (LA7_194=='N'||LA7_194=='n') ) {
                                            int LA7_203 = input.LA(10);

                                            if ( ((LA7_203>='0' && LA7_203<='9')||(LA7_203>='A' && LA7_203<='Z')||LA7_203=='_'||(LA7_203>='a' && LA7_203<='z')) ) {
                                                alt7=58;
                                            }
                                            else {
                                                alt7=28;}
                                        }
                                        else {
                                            alt7=58;}
                                    }
                                    else {
                                        alt7=58;}
                                }
                                else {
                                    alt7=58;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                    }
                    break;
                case 'T':
                case 't':
                    {
                    int LA7_89 = input.LA(4);

                    if ( (LA7_89=='H'||LA7_89=='h') ) {
                        int LA7_118 = input.LA(5);

                        if ( ((LA7_118>='0' && LA7_118<='9')||(LA7_118>='A' && LA7_118<='Z')||LA7_118=='_'||(LA7_118>='a' && LA7_118<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=43;}
                    }
                    else {
                        alt7=58;}
                    }
                    break;
                default:
                    alt7=58;}

                }
                break;
            case 'R':
            case 'r':
                {
                int LA7_58 = input.LA(3);

                if ( (LA7_58=='E'||LA7_58=='e') ) {
                    int LA7_90 = input.LA(4);

                    if ( (LA7_90=='C'||LA7_90=='c') ) {
                        int LA7_119 = input.LA(5);

                        if ( (LA7_119=='E'||LA7_119=='e') ) {
                            int LA7_149 = input.LA(6);

                            if ( (LA7_149=='D'||LA7_149=='d') ) {
                                int LA7_172 = input.LA(7);

                                if ( (LA7_172=='I'||LA7_172=='i') ) {
                                    int LA7_185 = input.LA(8);

                                    if ( (LA7_185=='N'||LA7_185=='n') ) {
                                        int LA7_195 = input.LA(9);

                                        if ( (LA7_195=='G'||LA7_195=='g') ) {
                                            int LA7_204 = input.LA(10);

                                            if ( ((LA7_204>='0' && LA7_204<='9')||(LA7_204>='A' && LA7_204<='Z')||LA7_204=='_'||(LA7_204>='a' && LA7_204<='z')) ) {
                                                alt7=58;
                                            }
                                            else {
                                                alt7=36;}
                                        }
                                        else {
                                            alt7=58;}
                                    }
                                    else {
                                        alt7=58;}
                                }
                                else {
                                    alt7=58;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            default:
                alt7=58;}

            }
            break;
        case 'R':
        case 'r':
            {
            switch ( input.LA(2) ) {
            case 'O':
            case 'o':
                {
                int LA7_59 = input.LA(3);

                if ( (LA7_59=='W'||LA7_59=='w') ) {
                    switch ( input.LA(4) ) {
                    case 'S':
                    case 's':
                        {
                        int LA7_121 = input.LA(5);

                        if ( ((LA7_121>='0' && LA7_121<='9')||(LA7_121>='A' && LA7_121<='Z')||LA7_121=='_'||(LA7_121>='a' && LA7_121<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=30;}
                        }
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'I':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'O':
                    case 'P':
                    case 'Q':
                    case 'R':
                    case 'T':
                    case 'U':
                    case 'V':
                    case 'W':
                    case 'X':
                    case 'Y':
                    case 'Z':
                    case '_':
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'i':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'm':
                    case 'n':
                    case 'o':
                    case 'p':
                    case 'q':
                    case 'r':
                    case 't':
                    case 'u':
                    case 'v':
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                        {
                        alt7=58;
                        }
                        break;
                    default:
                        alt7=34;}

                }
                else {
                    alt7=58;}
                }
                break;
            case 'E':
            case 'e':
                {
                int LA7_60 = input.LA(3);

                if ( (LA7_60=='C'||LA7_60=='c') ) {
                    int LA7_92 = input.LA(4);

                    if ( (LA7_92=='O'||LA7_92=='o') ) {
                        int LA7_122 = input.LA(5);

                        if ( (LA7_122=='R'||LA7_122=='r') ) {
                            int LA7_151 = input.LA(6);

                            if ( (LA7_151=='D'||LA7_151=='d') ) {
                                int LA7_173 = input.LA(7);

                                if ( (LA7_173=='W'||LA7_173=='w') ) {
                                    int LA7_186 = input.LA(8);

                                    if ( (LA7_186=='R'||LA7_186=='r') ) {
                                        int LA7_196 = input.LA(9);

                                        if ( (LA7_196=='I'||LA7_196=='i') ) {
                                            int LA7_205 = input.LA(10);

                                            if ( (LA7_205=='T'||LA7_205=='t') ) {
                                                int LA7_213 = input.LA(11);

                                                if ( (LA7_213=='E'||LA7_213=='e') ) {
                                                    int LA7_217 = input.LA(12);

                                                    if ( (LA7_217=='R'||LA7_217=='r') ) {
                                                        int LA7_219 = input.LA(13);

                                                        if ( ((LA7_219>='0' && LA7_219<='9')||(LA7_219>='A' && LA7_219<='Z')||LA7_219=='_'||(LA7_219>='a' && LA7_219<='z')) ) {
                                                            alt7=58;
                                                        }
                                                        else {
                                                            alt7=47;}
                                                    }
                                                    else {
                                                        alt7=58;}
                                                }
                                                else {
                                                    alt7=58;}
                                            }
                                            else {
                                                alt7=58;}
                                        }
                                        else {
                                            alt7=58;}
                                    }
                                    else {
                                        alt7=58;}
                                }
                                else {
                                    alt7=58;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            case 'A':
            case 'a':
                {
                int LA7_61 = input.LA(3);

                if ( (LA7_61=='N'||LA7_61=='n') ) {
                    int LA7_93 = input.LA(4);

                    if ( (LA7_93=='G'||LA7_93=='g') ) {
                        int LA7_123 = input.LA(5);

                        if ( (LA7_123=='E'||LA7_123=='e') ) {
                            int LA7_152 = input.LA(6);

                            if ( ((LA7_152>='0' && LA7_152<='9')||(LA7_152>='A' && LA7_152<='Z')||LA7_152=='_'||(LA7_152>='a' && LA7_152<='z')) ) {
                                alt7=58;
                            }
                            else {
                                alt7=31;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            default:
                alt7=58;}

            }
            break;
        case 'C':
        case 'c':
            {
            int LA7_27 = input.LA(2);

            if ( (LA7_27=='U'||LA7_27=='u') ) {
                int LA7_62 = input.LA(3);

                if ( (LA7_62=='R'||LA7_62=='r') ) {
                    int LA7_94 = input.LA(4);

                    if ( (LA7_94=='R'||LA7_94=='r') ) {
                        int LA7_124 = input.LA(5);

                        if ( (LA7_124=='E'||LA7_124=='e') ) {
                            int LA7_153 = input.LA(6);

                            if ( (LA7_153=='N'||LA7_153=='n') ) {
                                int LA7_175 = input.LA(7);

                                if ( (LA7_175=='T'||LA7_175=='t') ) {
                                    int LA7_187 = input.LA(8);

                                    if ( ((LA7_187>='0' && LA7_187<='9')||(LA7_187>='A' && LA7_187<='Z')||LA7_187=='_'||(LA7_187>='a' && LA7_187<='z')) ) {
                                        alt7=58;
                                    }
                                    else {
                                        alt7=33;}
                                }
                                else {
                                    alt7=58;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
            }
            else {
                alt7=58;}
            }
            break;
        case 'U':
        case 'u':
            {
            int LA7_28 = input.LA(2);

            if ( (LA7_28=='N'||LA7_28=='n') ) {
                int LA7_63 = input.LA(3);

                if ( (LA7_63=='B'||LA7_63=='b') ) {
                    int LA7_95 = input.LA(4);

                    if ( (LA7_95=='O'||LA7_95=='o') ) {
                        int LA7_125 = input.LA(5);

                        if ( (LA7_125=='U'||LA7_125=='u') ) {
                            int LA7_154 = input.LA(6);

                            if ( (LA7_154=='N'||LA7_154=='n') ) {
                                int LA7_176 = input.LA(7);

                                if ( (LA7_176=='D'||LA7_176=='d') ) {
                                    int LA7_188 = input.LA(8);

                                    if ( (LA7_188=='E'||LA7_188=='e') ) {
                                        int LA7_198 = input.LA(9);

                                        if ( (LA7_198=='D'||LA7_198=='d') ) {
                                            int LA7_206 = input.LA(10);

                                            if ( ((LA7_206>='0' && LA7_206<='9')||(LA7_206>='A' && LA7_206<='Z')||LA7_206=='_'||(LA7_206>='a' && LA7_206<='z')) ) {
                                                alt7=58;
                                            }
                                            else {
                                                alt7=35;}
                                        }
                                        else {
                                            alt7=58;}
                                    }
                                    else {
                                        alt7=58;}
                                }
                                else {
                                    alt7=58;}
                            }
                            else {
                                alt7=58;}
                        }
                        else {
                            alt7=58;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
            }
            else {
                alt7=58;}
            }
            break;
        case 'L':
        case 'l':
            {
            switch ( input.LA(2) ) {
            case 'E':
            case 'e':
                {
                int LA7_64 = input.LA(3);

                if ( (LA7_64=='S'||LA7_64=='s') ) {
                    int LA7_96 = input.LA(4);

                    if ( (LA7_96=='S'||LA7_96=='s') ) {
                        int LA7_126 = input.LA(5);

                        if ( ((LA7_126>='0' && LA7_126<='9')||(LA7_126>='A' && LA7_126<='Z')||LA7_126=='_'||(LA7_126>='a' && LA7_126<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=38;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            case 'O':
            case 'o':
                {
                int LA7_65 = input.LA(3);

                if ( (LA7_65=='A'||LA7_65=='a') ) {
                    int LA7_97 = input.LA(4);

                    if ( (LA7_97=='D'||LA7_97=='d') ) {
                        int LA7_127 = input.LA(5);

                        if ( ((LA7_127>='0' && LA7_127<='9')||(LA7_127>='A' && LA7_127<='Z')||LA7_127=='_'||(LA7_127>='a' && LA7_127<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=48;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
                }
                break;
            default:
                alt7=58;}

            }
            break;
        case 'M':
        case 'm':
            {
            int LA7_30 = input.LA(2);

            if ( (LA7_30=='O'||LA7_30=='o') ) {
                int LA7_66 = input.LA(3);

                if ( (LA7_66=='R'||LA7_66=='r') ) {
                    int LA7_98 = input.LA(4);

                    if ( (LA7_98=='E'||LA7_98=='e') ) {
                        int LA7_128 = input.LA(5);

                        if ( ((LA7_128>='0' && LA7_128<='9')||(LA7_128>='A' && LA7_128<='Z')||LA7_128=='_'||(LA7_128>='a' && LA7_128<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=39;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
            }
            else {
                alt7=58;}
            }
            break;
        case 'A':
        case 'a':
            {
            switch ( input.LA(2) ) {
            case 'S':
            case 's':
                {
                switch ( input.LA(3) ) {
                case 'C':
                case 'c':
                    {
                    int LA7_100 = input.LA(4);

                    if ( ((LA7_100>='0' && LA7_100<='9')||(LA7_100>='A' && LA7_100<='Z')||LA7_100=='_'||(LA7_100>='a' && LA7_100<='z')) ) {
                        alt7=58;
                    }
                    else {
                        alt7=55;}
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt7=58;
                    }
                    break;
                default:
                    alt7=40;}

                }
                break;
            case 'N':
            case 'n':
                {
                int LA7_68 = input.LA(3);

                if ( (LA7_68=='D'||LA7_68=='d') ) {
                    int LA7_101 = input.LA(4);

                    if ( ((LA7_101>='0' && LA7_101<='9')||(LA7_101>='A' && LA7_101<='Z')||LA7_101=='_'||(LA7_101>='a' && LA7_101<='z')) ) {
                        alt7=58;
                    }
                    else {
                        alt7=51;}
                }
                else {
                    alt7=58;}
                }
                break;
            default:
                alt7=58;}

            }
            break;
        case 'I':
        case 'i':
            {
            int LA7_32 = input.LA(2);

            if ( (LA7_32=='N'||LA7_32=='n') ) {
                int LA7_69 = input.LA(3);

                if ( (LA7_69=='T'||LA7_69=='t') ) {
                    int LA7_102 = input.LA(4);

                    if ( (LA7_102=='O'||LA7_102=='o') ) {
                        int LA7_131 = input.LA(5);

                        if ( ((LA7_131>='0' && LA7_131<='9')||(LA7_131>='A' && LA7_131<='Z')||LA7_131=='_'||(LA7_131>='a' && LA7_131<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=42;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
            }
            else {
                alt7=58;}
            }
            break;
        case 'N':
        case 'n':
            {
            int LA7_33 = input.LA(2);

            if ( (LA7_33=='O'||LA7_33=='o') ) {
                int LA7_70 = input.LA(3);

                if ( (LA7_70=='T'||LA7_70=='t') ) {
                    int LA7_103 = input.LA(4);

                    if ( ((LA7_103>='0' && LA7_103<='9')||(LA7_103>='A' && LA7_103<='Z')||LA7_103=='_'||(LA7_103>='a' && LA7_103<='z')) ) {
                        alt7=58;
                    }
                    else {
                        alt7=52;}
                }
                else {
                    alt7=58;}
            }
            else {
                alt7=58;}
            }
            break;
        case 'X':
        case 'x':
            {
            int LA7_34 = input.LA(2);

            if ( (LA7_34=='O'||LA7_34=='o') ) {
                int LA7_71 = input.LA(3);

                if ( (LA7_71=='R'||LA7_71=='r') ) {
                    int LA7_104 = input.LA(4);

                    if ( ((LA7_104>='0' && LA7_104<='9')||(LA7_104>='A' && LA7_104<='Z')||LA7_104=='_'||(LA7_104>='a' && LA7_104<='z')) ) {
                        alt7=58;
                    }
                    else {
                        alt7=54;}
                }
                else {
                    alt7=58;}
            }
            else {
                alt7=58;}
            }
            break;
        case 'D':
        case 'd':
            {
            int LA7_35 = input.LA(2);

            if ( (LA7_35=='E'||LA7_35=='e') ) {
                int LA7_72 = input.LA(3);

                if ( (LA7_72=='S'||LA7_72=='s') ) {
                    int LA7_105 = input.LA(4);

                    if ( (LA7_105=='C'||LA7_105=='c') ) {
                        int LA7_134 = input.LA(5);

                        if ( ((LA7_134>='0' && LA7_134<='9')||(LA7_134>='A' && LA7_134<='Z')||LA7_134=='_'||(LA7_134>='a' && LA7_134<='z')) ) {
                            alt7=58;
                        }
                        else {
                            alt7=56;}
                    }
                    else {
                        alt7=58;}
                }
                else {
                    alt7=58;}
            }
            else {
                alt7=58;}
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt7=57;
            }
            break;
        case 'E':
        case 'G':
        case 'H':
        case 'J':
        case 'K':
        case 'Q':
        case 'V':
        case 'Y':
        case 'Z':
        case '_':
        case 'e':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'q':
        case 'v':
        case 'y':
        case 'z':
            {
            alt7=58;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt7=61;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( QUOTE | ASTERISK | COLON | SEMICOLON | COMMA | DOT | EQ | GE | GT | LBRACKET | LBRACE | LE | LPAREN | LT | MINUS | NE | PLUS | RBRACE | RBRACKET | RPAREN | SOLIDUS | SELECT | FROM | WHERE | TABLEINPUT | ORDER | BY | PARTITION | WITH | ROWS | RANGE | BETWEEN | CURRENT | ROW | UNBOUNDED | PRECEDING | FOLLOWING | LESS | MORE | AS | OVER | INTO | PATH | FORMAT | SERDE | SERDEPROPERTIES | RECORDWRITER | LOAD | TABLE | OVERWRITE | AND | NOT | OR | XOR | ASC | DESC | NUMBER | ID | GROOVYEXPRESSION | STRING | WS );", 7, 0, input);

            throw nvae;
        }

        switch (alt7) {
            case 1 :
                // Windowing.g:1:10: QUOTE
                {
                mQUOTE(); 

                }
                break;
            case 2 :
                // Windowing.g:1:16: ASTERISK
                {
                mASTERISK(); 

                }
                break;
            case 3 :
                // Windowing.g:1:25: COLON
                {
                mCOLON(); 

                }
                break;
            case 4 :
                // Windowing.g:1:31: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 5 :
                // Windowing.g:1:41: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 6 :
                // Windowing.g:1:47: DOT
                {
                mDOT(); 

                }
                break;
            case 7 :
                // Windowing.g:1:51: EQ
                {
                mEQ(); 

                }
                break;
            case 8 :
                // Windowing.g:1:54: GE
                {
                mGE(); 

                }
                break;
            case 9 :
                // Windowing.g:1:57: GT
                {
                mGT(); 

                }
                break;
            case 10 :
                // Windowing.g:1:60: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 11 :
                // Windowing.g:1:69: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 12 :
                // Windowing.g:1:76: LE
                {
                mLE(); 

                }
                break;
            case 13 :
                // Windowing.g:1:79: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 14 :
                // Windowing.g:1:86: LT
                {
                mLT(); 

                }
                break;
            case 15 :
                // Windowing.g:1:89: MINUS
                {
                mMINUS(); 

                }
                break;
            case 16 :
                // Windowing.g:1:95: NE
                {
                mNE(); 

                }
                break;
            case 17 :
                // Windowing.g:1:98: PLUS
                {
                mPLUS(); 

                }
                break;
            case 18 :
                // Windowing.g:1:103: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 19 :
                // Windowing.g:1:110: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 20 :
                // Windowing.g:1:119: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 21 :
                // Windowing.g:1:126: SOLIDUS
                {
                mSOLIDUS(); 

                }
                break;
            case 22 :
                // Windowing.g:1:134: SELECT
                {
                mSELECT(); 

                }
                break;
            case 23 :
                // Windowing.g:1:141: FROM
                {
                mFROM(); 

                }
                break;
            case 24 :
                // Windowing.g:1:146: WHERE
                {
                mWHERE(); 

                }
                break;
            case 25 :
                // Windowing.g:1:152: TABLEINPUT
                {
                mTABLEINPUT(); 

                }
                break;
            case 26 :
                // Windowing.g:1:163: ORDER
                {
                mORDER(); 

                }
                break;
            case 27 :
                // Windowing.g:1:169: BY
                {
                mBY(); 

                }
                break;
            case 28 :
                // Windowing.g:1:172: PARTITION
                {
                mPARTITION(); 

                }
                break;
            case 29 :
                // Windowing.g:1:182: WITH
                {
                mWITH(); 

                }
                break;
            case 30 :
                // Windowing.g:1:187: ROWS
                {
                mROWS(); 

                }
                break;
            case 31 :
                // Windowing.g:1:192: RANGE
                {
                mRANGE(); 

                }
                break;
            case 32 :
                // Windowing.g:1:198: BETWEEN
                {
                mBETWEEN(); 

                }
                break;
            case 33 :
                // Windowing.g:1:206: CURRENT
                {
                mCURRENT(); 

                }
                break;
            case 34 :
                // Windowing.g:1:214: ROW
                {
                mROW(); 

                }
                break;
            case 35 :
                // Windowing.g:1:218: UNBOUNDED
                {
                mUNBOUNDED(); 

                }
                break;
            case 36 :
                // Windowing.g:1:228: PRECEDING
                {
                mPRECEDING(); 

                }
                break;
            case 37 :
                // Windowing.g:1:238: FOLLOWING
                {
                mFOLLOWING(); 

                }
                break;
            case 38 :
                // Windowing.g:1:248: LESS
                {
                mLESS(); 

                }
                break;
            case 39 :
                // Windowing.g:1:253: MORE
                {
                mMORE(); 

                }
                break;
            case 40 :
                // Windowing.g:1:258: AS
                {
                mAS(); 

                }
                break;
            case 41 :
                // Windowing.g:1:261: OVER
                {
                mOVER(); 

                }
                break;
            case 42 :
                // Windowing.g:1:266: INTO
                {
                mINTO(); 

                }
                break;
            case 43 :
                // Windowing.g:1:271: PATH
                {
                mPATH(); 

                }
                break;
            case 44 :
                // Windowing.g:1:276: FORMAT
                {
                mFORMAT(); 

                }
                break;
            case 45 :
                // Windowing.g:1:283: SERDE
                {
                mSERDE(); 

                }
                break;
            case 46 :
                // Windowing.g:1:289: SERDEPROPERTIES
                {
                mSERDEPROPERTIES(); 

                }
                break;
            case 47 :
                // Windowing.g:1:305: RECORDWRITER
                {
                mRECORDWRITER(); 

                }
                break;
            case 48 :
                // Windowing.g:1:318: LOAD
                {
                mLOAD(); 

                }
                break;
            case 49 :
                // Windowing.g:1:323: TABLE
                {
                mTABLE(); 

                }
                break;
            case 50 :
                // Windowing.g:1:329: OVERWRITE
                {
                mOVERWRITE(); 

                }
                break;
            case 51 :
                // Windowing.g:1:339: AND
                {
                mAND(); 

                }
                break;
            case 52 :
                // Windowing.g:1:343: NOT
                {
                mNOT(); 

                }
                break;
            case 53 :
                // Windowing.g:1:347: OR
                {
                mOR(); 

                }
                break;
            case 54 :
                // Windowing.g:1:350: XOR
                {
                mXOR(); 

                }
                break;
            case 55 :
                // Windowing.g:1:354: ASC
                {
                mASC(); 

                }
                break;
            case 56 :
                // Windowing.g:1:358: DESC
                {
                mDESC(); 

                }
                break;
            case 57 :
                // Windowing.g:1:363: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 58 :
                // Windowing.g:1:370: ID
                {
                mID(); 

                }
                break;
            case 59 :
                // Windowing.g:1:373: GROOVYEXPRESSION
                {
                mGROOVYEXPRESSION(); 

                }
                break;
            case 60 :
                // Windowing.g:1:390: STRING
                {
                mSTRING(); 

                }
                break;
            case 61 :
                // Windowing.g:1:397: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}