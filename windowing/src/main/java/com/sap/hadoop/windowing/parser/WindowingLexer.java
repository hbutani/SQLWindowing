// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/sap/hadoop/windowing/parser/Windowing.g 2012-03-02 17:03:52

package com.sap.hadoop.windowing.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class WindowingLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__108=108;
    public static final int NUMERIC=4;
    public static final int INTEGER=5;
    public static final int UMINUS=6;
    public static final int PARAM=7;
    public static final int ORDERCOLUMN=8;
    public static final int FUNCTION=9;
    public static final int FUNCTIONS=10;
    public static final int QUERY=11;
    public static final int WINDOWRANGE=12;
    public static final int WINDOWVALUES=13;
    public static final int TYPENAME=14;
    public static final int SELECTCOLUMN=15;
    public static final int OUTPUTSPEC=16;
    public static final int TBLFUNCTION=17;
    public static final int LOADSPEC=18;
    public static final int FROM=19;
    public static final int WITH=20;
    public static final int ID=21;
    public static final int GROOVYEXPRESSION=22;
    public static final int LPAREN=23;
    public static final int RPAREN=24;
    public static final int COMMA=25;
    public static final int TABLEINPUT=26;
    public static final int STRING=27;
    public static final int EQ=28;
    public static final int ORDER=29;
    public static final int BY=30;
    public static final int ASC=31;
    public static final int DESC=32;
    public static final int PARTITION=33;
    public static final int AS=34;
    public static final int LBRACKET=35;
    public static final int RBRACKET=36;
    public static final int NUMBER=37;
    public static final int OVER=38;
    public static final int ROWS=39;
    public static final int BETWEEN=40;
    public static final int AND=41;
    public static final int UNBOUNDED=42;
    public static final int PRECEDING=43;
    public static final int FOLLOWING=44;
    public static final int CURRENT=45;
    public static final int ROW=46;
    public static final int RANGE=47;
    public static final int LESS=48;
    public static final int MORE=49;
    public static final int SELECT=50;
    public static final int WHERE=51;
    public static final int INTO=52;
    public static final int PATH=53;
    public static final int SERDE=54;
    public static final int SERDEPROPERTIES=55;
    public static final int RECORDWRITER=56;
    public static final int FORMAT=57;
    public static final int LOAD=58;
    public static final int OVERWRITE=59;
    public static final int TABLE=60;
    public static final int PLUS=61;
    public static final int MINUS=62;
    public static final int ASTERISK=63;
    public static final int SOLIDUS=64;
    public static final int DOT=65;
    public static final int QUOTE=66;
    public static final int COLON=67;
    public static final int SEMICOLON=68;
    public static final int GE=69;
    public static final int GT=70;
    public static final int LBRACE=71;
    public static final int LE=72;
    public static final int LT=73;
    public static final int NE=74;
    public static final int RBRACE=75;
    public static final int S=76;
    public static final int E=77;
    public static final int L=78;
    public static final int C=79;
    public static final int T=80;
    public static final int F=81;
    public static final int R=82;
    public static final int O=83;
    public static final int M=84;
    public static final int W=85;
    public static final int H=86;
    public static final int A=87;
    public static final int B=88;
    public static final int I=89;
    public static final int N=90;
    public static final int P=91;
    public static final int U=92;
    public static final int D=93;
    public static final int Y=94;
    public static final int G=95;
    public static final int V=96;
    public static final int NOT=97;
    public static final int OR=98;
    public static final int X=99;
    public static final int XOR=100;
    public static final int GroovyEscapeSequence=101;
    public static final int EscapeSequence=102;
    public static final int WS=103;
    public static final int J=104;
    public static final int K=105;
    public static final int Q=106;
    public static final int Z=107;

    // delegates
    // delegators

    public WindowingLexer() {;} 
    public WindowingLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public WindowingLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "com/sap/hadoop/windowing/parser/Windowing.g"; }

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:11:8: ( 'E' )
            // com/sap/hadoop/windowing/parser/Windowing.g:11:10: 'E'
            {
            match('E'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "QUOTE"
    public final void mQUOTE() throws RecognitionException {
        try {
            int _type = QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:242:19: ( '\\'' )
            // com/sap/hadoop/windowing/parser/Windowing.g:242:21: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTE"

    // $ANTLR start "ASTERISK"
    public final void mASTERISK() throws RecognitionException {
        try {
            int _type = ASTERISK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:243:19: ( '*' )
            // com/sap/hadoop/windowing/parser/Windowing.g:243:21: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASTERISK"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:244:19: ( ':' )
            // com/sap/hadoop/windowing/parser/Windowing.g:244:21: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:245:19: ( ';' )
            // com/sap/hadoop/windowing/parser/Windowing.g:245:21: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:246:19: ( ',' )
            // com/sap/hadoop/windowing/parser/Windowing.g:246:21: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:247:19: ( '.' )
            // com/sap/hadoop/windowing/parser/Windowing.g:247:21: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:248:19: ( '=' )
            // com/sap/hadoop/windowing/parser/Windowing.g:248:21: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:249:19: ( '>=' )
            // com/sap/hadoop/windowing/parser/Windowing.g:249:21: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:250:19: ( '>' )
            // com/sap/hadoop/windowing/parser/Windowing.g:250:21: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:251:19: ( '[' )
            // com/sap/hadoop/windowing/parser/Windowing.g:251:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:252:19: ( '{' )
            // com/sap/hadoop/windowing/parser/Windowing.g:252:21: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:253:19: ( '<=' )
            // com/sap/hadoop/windowing/parser/Windowing.g:253:21: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:254:19: ( '(' )
            // com/sap/hadoop/windowing/parser/Windowing.g:254:21: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:255:19: ( '<' )
            // com/sap/hadoop/windowing/parser/Windowing.g:255:21: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:256:19: ( '-' )
            // com/sap/hadoop/windowing/parser/Windowing.g:256:21: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:257:19: ( '<>' )
            // com/sap/hadoop/windowing/parser/Windowing.g:257:21: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NE"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:258:19: ( '+' )
            // com/sap/hadoop/windowing/parser/Windowing.g:258:21: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:259:19: ( '}' )
            // com/sap/hadoop/windowing/parser/Windowing.g:259:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:260:19: ( ']' )
            // com/sap/hadoop/windowing/parser/Windowing.g:260:21: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:261:19: ( ')' )
            // com/sap/hadoop/windowing/parser/Windowing.g:261:21: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "SOLIDUS"
    public final void mSOLIDUS() throws RecognitionException {
        try {
            int _type = SOLIDUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:262:19: ( '/' )
            // com/sap/hadoop/windowing/parser/Windowing.g:262:21: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SOLIDUS"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:264:19: ( S E L E C T )
            // com/sap/hadoop/windowing/parser/Windowing.g:264:21: S E L E C T
            {
            mS(); 
            mE(); 
            mL(); 
            mE(); 
            mC(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:265:19: ( F R O M )
            // com/sap/hadoop/windowing/parser/Windowing.g:265:21: F R O M
            {
            mF(); 
            mR(); 
            mO(); 
            mM(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:266:19: ( W H E R E )
            // com/sap/hadoop/windowing/parser/Windowing.g:266:21: W H E R E
            {
            mW(); 
            mH(); 
            mE(); 
            mR(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "TABLEINPUT"
    public final void mTABLEINPUT() throws RecognitionException {
        try {
            int _type = TABLEINPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:267:19: ( T A B L E I N P U T )
            // com/sap/hadoop/windowing/parser/Windowing.g:267:21: T A B L E I N P U T
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TABLEINPUT"

    // $ANTLR start "ORDER"
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:268:19: ( O R D E R )
            // com/sap/hadoop/windowing/parser/Windowing.g:268:21: O R D E R
            {
            mO(); 
            mR(); 
            mD(); 
            mE(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ORDER"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:269:19: ( B Y )
            // com/sap/hadoop/windowing/parser/Windowing.g:269:21: B Y
            {
            mB(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "PARTITION"
    public final void mPARTITION() throws RecognitionException {
        try {
            int _type = PARTITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:270:19: ( P A R T I T I O N )
            // com/sap/hadoop/windowing/parser/Windowing.g:270:21: P A R T I T I O N
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARTITION"

    // $ANTLR start "WITH"
    public final void mWITH() throws RecognitionException {
        try {
            int _type = WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:271:19: ( W I T H )
            // com/sap/hadoop/windowing/parser/Windowing.g:271:21: W I T H
            {
            mW(); 
            mI(); 
            mT(); 
            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WITH"

    // $ANTLR start "ROWS"
    public final void mROWS() throws RecognitionException {
        try {
            int _type = ROWS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:272:19: ( R O W S )
            // com/sap/hadoop/windowing/parser/Windowing.g:272:21: R O W S
            {
            mR(); 
            mO(); 
            mW(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROWS"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:273:18: ( R A N G E )
            // com/sap/hadoop/windowing/parser/Windowing.g:273:20: R A N G E
            {
            mR(); 
            mA(); 
            mN(); 
            mG(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "BETWEEN"
    public final void mBETWEEN() throws RecognitionException {
        try {
            int _type = BETWEEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:274:12: ( B E T W E E N )
            // com/sap/hadoop/windowing/parser/Windowing.g:274:14: B E T W E E N
            {
            mB(); 
            mE(); 
            mT(); 
            mW(); 
            mE(); 
            mE(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BETWEEN"

    // $ANTLR start "CURRENT"
    public final void mCURRENT() throws RecognitionException {
        try {
            int _type = CURRENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:275:12: ( C U R R E N T )
            // com/sap/hadoop/windowing/parser/Windowing.g:275:14: C U R R E N T
            {
            mC(); 
            mU(); 
            mR(); 
            mR(); 
            mE(); 
            mN(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CURRENT"

    // $ANTLR start "ROW"
    public final void mROW() throws RecognitionException {
        try {
            int _type = ROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:276:8: ( R O W )
            // com/sap/hadoop/windowing/parser/Windowing.g:276:10: R O W
            {
            mR(); 
            mO(); 
            mW(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROW"

    // $ANTLR start "UNBOUNDED"
    public final void mUNBOUNDED() throws RecognitionException {
        try {
            int _type = UNBOUNDED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:277:16: ( U N B O U N D E D )
            // com/sap/hadoop/windowing/parser/Windowing.g:277:18: U N B O U N D E D
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNBOUNDED"

    // $ANTLR start "PRECEDING"
    public final void mPRECEDING() throws RecognitionException {
        try {
            int _type = PRECEDING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:278:19: ( P R E C E D I N G )
            // com/sap/hadoop/windowing/parser/Windowing.g:278:21: P R E C E D I N G
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRECEDING"

    // $ANTLR start "FOLLOWING"
    public final void mFOLLOWING() throws RecognitionException {
        try {
            int _type = FOLLOWING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:279:19: ( F O L L O W I N G )
            // com/sap/hadoop/windowing/parser/Windowing.g:279:21: F O L L O W I N G
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOLLOWING"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:280:9: ( L E S S )
            // com/sap/hadoop/windowing/parser/Windowing.g:280:11: L E S S
            {
            mL(); 
            mE(); 
            mS(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "MORE"
    public final void mMORE() throws RecognitionException {
        try {
            int _type = MORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:281:9: ( M O R E )
            // com/sap/hadoop/windowing/parser/Windowing.g:281:11: M O R E
            {
            mM(); 
            mO(); 
            mR(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MORE"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:282:7: ( A S )
            // com/sap/hadoop/windowing/parser/Windowing.g:282:9: A S
            {
            mA(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "OVER"
    public final void mOVER() throws RecognitionException {
        try {
            int _type = OVER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:283:9: ( O V E R )
            // com/sap/hadoop/windowing/parser/Windowing.g:283:11: O V E R
            {
            mO(); 
            mV(); 
            mE(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OVER"

    // $ANTLR start "INTO"
    public final void mINTO() throws RecognitionException {
        try {
            int _type = INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:284:9: ( I N T O )
            // com/sap/hadoop/windowing/parser/Windowing.g:284:11: I N T O
            {
            mI(); 
            mN(); 
            mT(); 
            mO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTO"

    // $ANTLR start "PATH"
    public final void mPATH() throws RecognitionException {
        try {
            int _type = PATH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:285:9: ( P A T H )
            // com/sap/hadoop/windowing/parser/Windowing.g:285:11: P A T H
            {
            mP(); 
            mA(); 
            mT(); 
            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PATH"

    // $ANTLR start "FORMAT"
    public final void mFORMAT() throws RecognitionException {
        try {
            int _type = FORMAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:286:9: ( F O R M A T )
            // com/sap/hadoop/windowing/parser/Windowing.g:286:11: F O R M A T
            {
            mF(); 
            mO(); 
            mR(); 
            mM(); 
            mA(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FORMAT"

    // $ANTLR start "SERDE"
    public final void mSERDE() throws RecognitionException {
        try {
            int _type = SERDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:287:9: ( S E R D E )
            // com/sap/hadoop/windowing/parser/Windowing.g:287:11: S E R D E
            {
            mS(); 
            mE(); 
            mR(); 
            mD(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SERDE"

    // $ANTLR start "SERDEPROPERTIES"
    public final void mSERDEPROPERTIES() throws RecognitionException {
        try {
            int _type = SERDEPROPERTIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:288:17: ( S E R D E P R O P E R T I E S )
            // com/sap/hadoop/windowing/parser/Windowing.g:288:19: S E R D E P R O P E R T I E S
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SERDEPROPERTIES"

    // $ANTLR start "RECORDWRITER"
    public final void mRECORDWRITER() throws RecognitionException {
        try {
            int _type = RECORDWRITER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:289:14: ( R E C O R D W R I T E R )
            // com/sap/hadoop/windowing/parser/Windowing.g:289:16: R E C O R D W R I T E R
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RECORDWRITER"

    // $ANTLR start "LOAD"
    public final void mLOAD() throws RecognitionException {
        try {
            int _type = LOAD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:290:14: ( L O A D )
            // com/sap/hadoop/windowing/parser/Windowing.g:290:16: L O A D
            {
            mL(); 
            mO(); 
            mA(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOAD"

    // $ANTLR start "TABLE"
    public final void mTABLE() throws RecognitionException {
        try {
            int _type = TABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:291:14: ( T A B L E )
            // com/sap/hadoop/windowing/parser/Windowing.g:291:16: T A B L E
            {
            mT(); 
            mA(); 
            mB(); 
            mL(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TABLE"

    // $ANTLR start "OVERWRITE"
    public final void mOVERWRITE() throws RecognitionException {
        try {
            int _type = OVERWRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:292:18: ( O V E R W R I T E )
            // com/sap/hadoop/windowing/parser/Windowing.g:292:20: O V E R W R I T E
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OVERWRITE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:298:19: ( A N D )
            // com/sap/hadoop/windowing/parser/Windowing.g:298:21: A N D
            {
            mA(); 
            mN(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:299:19: ( N O T )
            // com/sap/hadoop/windowing/parser/Windowing.g:299:21: N O T
            {
            mN(); 
            mO(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:300:19: ( O R )
            // com/sap/hadoop/windowing/parser/Windowing.g:300:21: O R
            {
            mO(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "XOR"
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:301:19: ( X O R )
            // com/sap/hadoop/windowing/parser/Windowing.g:301:21: X O R
            {
            mX(); 
            mO(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "XOR"

    // $ANTLR start "ASC"
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:303:19: ( A S C )
            // com/sap/hadoop/windowing/parser/Windowing.g:303:21: A S C
            {
            mA(); 
            mS(); 
            mC(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASC"

    // $ANTLR start "DESC"
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:304:19: ( D E S C )
            // com/sap/hadoop/windowing/parser/Windowing.g:304:21: D E S C
            {
            mD(); 
            mE(); 
            mS(); 
            mC(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DESC"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:306:11: ( ( '0' .. '9' )+ )
            // com/sap/hadoop/windowing/parser/Windowing.g:306:13: ( '0' .. '9' )+
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:306:13: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
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
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:306:14: '0' .. '9'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:308:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // com/sap/hadoop/windowing/parser/Windowing.g:308:10: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // com/sap/hadoop/windowing/parser/Windowing.g:308:34: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
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
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "GROOVYEXPRESSION"
    public final void mGROOVYEXPRESSION() throws RecognitionException {
        try {
            int _type = GROOVYEXPRESSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:311:18: ( '<' ( GroovyEscapeSequence | ~ ( '>' ) )* '>' )
            // com/sap/hadoop/windowing/parser/Windowing.g:311:20: '<' ( GroovyEscapeSequence | ~ ( '>' ) )* '>'
            {
            match('<'); 
            // com/sap/hadoop/windowing/parser/Windowing.g:312:3: ( GroovyEscapeSequence | ~ ( '>' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2=='>') ) {
                        int LA3_4 = input.LA(3);

                        if ( ((LA3_4>='\u0000' && LA3_4<='\uFFFF')) ) {
                            alt3=1;
                        }

                        else {
                            alt3=2;
                        }

                    }
                    else if ( ((LA3_2>='\u0000' && LA3_2<='=')||(LA3_2>='?' && LA3_2<='\uFFFF')) ) {
                        alt3=2;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='=')||(LA3_0>='?' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:312:4: GroovyEscapeSequence
            	    {
            	    mGroovyEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:312:27: ~ ( '>' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('>'); 
            setText(getText().substring(1, getText().length()-1).replaceAll("\\\\>", ">"));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GROOVYEXPRESSION"

    // $ANTLR start "GroovyEscapeSequence"
    public final void mGroovyEscapeSequence() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:317:22: ( '\\\\' '>' )
            // com/sap/hadoop/windowing/parser/Windowing.g:318:3: '\\\\' '>'
            {
            match('\\'); 
            match('>'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "GroovyEscapeSequence"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:322:5: ( '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )* '\\'' )
            // com/sap/hadoop/windowing/parser/Windowing.g:322:9: '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )* '\\''
            {
            match('\''); 
            // com/sap/hadoop/windowing/parser/Windowing.g:323:9: ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:323:13: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:324:13: ~ ( '\\\\' | '\\'' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\''); 
            setText(getText().substring(1, getText().length()-1));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:331:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:331:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            {
            match('\\'); 
            // com/sap/hadoop/windowing/parser/Windowing.g:331:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            int alt5=11;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:332:18: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:333:18: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:334:18: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 4 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:335:18: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:336:18: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 6 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:337:18: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:338:18: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:339:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:341:18: ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // com/sap/hadoop/windowing/parser/Windowing.g:341:18: ( '0' .. '3' )
                    // com/sap/hadoop/windowing/parser/Windowing.g:341:19: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // com/sap/hadoop/windowing/parser/Windowing.g:341:29: ( '0' .. '7' )
                    // com/sap/hadoop/windowing/parser/Windowing.g:341:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // com/sap/hadoop/windowing/parser/Windowing.g:341:40: ( '0' .. '7' )
                    // com/sap/hadoop/windowing/parser/Windowing.g:341:41: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 10 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:343:18: ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // com/sap/hadoop/windowing/parser/Windowing.g:343:18: ( '0' .. '7' )
                    // com/sap/hadoop/windowing/parser/Windowing.g:343:19: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // com/sap/hadoop/windowing/parser/Windowing.g:343:29: ( '0' .. '7' )
                    // com/sap/hadoop/windowing/parser/Windowing.g:343:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 11 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:345:18: ( '0' .. '7' )
                    {
                    // com/sap/hadoop/windowing/parser/Windowing.g:345:18: ( '0' .. '7' )
                    // com/sap/hadoop/windowing/parser/Windowing.g:345:19: '0' .. '7'
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
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/sap/hadoop/windowing/parser/Windowing.g:349:5: ( ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+ )
            // com/sap/hadoop/windowing/parser/Windowing.g:349:9: ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:349:9: ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:358:11: ( ( 'a' | 'A' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:358:12: ( 'a' | 'A' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "A"

    // $ANTLR start "B"
    public final void mB() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:359:11: ( ( 'b' | 'B' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:359:12: ( 'b' | 'B' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "B"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:360:11: ( ( 'c' | 'C' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:360:12: ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "C"

    // $ANTLR start "D"
    public final void mD() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:361:11: ( ( 'd' | 'D' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:361:12: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "D"

    // $ANTLR start "E"
    public final void mE() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:362:11: ( ( 'e' | 'E' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:362:12: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "E"

    // $ANTLR start "F"
    public final void mF() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:363:11: ( ( 'f' | 'F' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:363:12: ( 'f' | 'F' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "F"

    // $ANTLR start "G"
    public final void mG() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:364:11: ( ( 'g' | 'G' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:364:12: ( 'g' | 'G' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "G"

    // $ANTLR start "H"
    public final void mH() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:365:11: ( ( 'h' | 'H' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:365:12: ( 'h' | 'H' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "H"

    // $ANTLR start "I"
    public final void mI() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:366:11: ( ( 'i' | 'I' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:366:12: ( 'i' | 'I' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "I"

    // $ANTLR start "J"
    public final void mJ() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:367:11: ( ( 'j' | 'J' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:367:12: ( 'j' | 'J' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "J"

    // $ANTLR start "K"
    public final void mK() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:368:11: ( ( 'k' | 'K' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:368:12: ( 'k' | 'K' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "K"

    // $ANTLR start "L"
    public final void mL() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:369:11: ( ( 'l' | 'L' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:369:12: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "L"

    // $ANTLR start "M"
    public final void mM() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:370:11: ( ( 'm' | 'M' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:370:12: ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "M"

    // $ANTLR start "N"
    public final void mN() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:371:11: ( ( 'n' | 'N' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:371:12: ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "N"

    // $ANTLR start "O"
    public final void mO() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:372:11: ( ( 'o' | 'O' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:372:12: ( 'o' | 'O' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "O"

    // $ANTLR start "P"
    public final void mP() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:373:11: ( ( 'p' | 'P' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:373:12: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "P"

    // $ANTLR start "Q"
    public final void mQ() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:374:11: ( ( 'q' | 'Q' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:374:12: ( 'q' | 'Q' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Q"

    // $ANTLR start "R"
    public final void mR() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:375:11: ( ( 'r' | 'R' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:375:12: ( 'r' | 'R' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "R"

    // $ANTLR start "S"
    public final void mS() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:376:11: ( ( 's' | 'S' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:376:12: ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "S"

    // $ANTLR start "T"
    public final void mT() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:377:11: ( ( 't' | 'T' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:377:12: ( 't' | 'T' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "T"

    // $ANTLR start "U"
    public final void mU() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:378:11: ( ( 'u' | 'U' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:378:12: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "U"

    // $ANTLR start "V"
    public final void mV() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:379:11: ( ( 'v' | 'V' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:379:12: ( 'v' | 'V' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "V"

    // $ANTLR start "W"
    public final void mW() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:380:11: ( ( 'w' | 'W' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:380:12: ( 'w' | 'W' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "W"

    // $ANTLR start "X"
    public final void mX() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:381:11: ( ( 'x' | 'X' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:381:12: ( 'x' | 'X' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "X"

    // $ANTLR start "Y"
    public final void mY() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:382:11: ( ( 'y' | 'Y' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:382:12: ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Y"

    // $ANTLR start "Z"
    public final void mZ() throws RecognitionException {
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:383:11: ( ( 'z' | 'Z' ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:383:12: ( 'z' | 'Z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Z"

    public void mTokens() throws RecognitionException {
        // com/sap/hadoop/windowing/parser/Windowing.g:1:8: ( T__108 | QUOTE | ASTERISK | COLON | SEMICOLON | COMMA | DOT | EQ | GE | GT | LBRACKET | LBRACE | LE | LPAREN | LT | MINUS | NE | PLUS | RBRACE | RBRACKET | RPAREN | SOLIDUS | SELECT | FROM | WHERE | TABLEINPUT | ORDER | BY | PARTITION | WITH | ROWS | RANGE | BETWEEN | CURRENT | ROW | UNBOUNDED | PRECEDING | FOLLOWING | LESS | MORE | AS | OVER | INTO | PATH | FORMAT | SERDE | SERDEPROPERTIES | RECORDWRITER | LOAD | TABLE | OVERWRITE | AND | NOT | OR | XOR | ASC | DESC | NUMBER | ID | GROOVYEXPRESSION | STRING | WS )
        int alt7=62;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:10: T__108
                {
                mT__108(); 

                }
                break;
            case 2 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:17: QUOTE
                {
                mQUOTE(); 

                }
                break;
            case 3 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:23: ASTERISK
                {
                mASTERISK(); 

                }
                break;
            case 4 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:32: COLON
                {
                mCOLON(); 

                }
                break;
            case 5 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:38: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 6 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:48: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 7 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:54: DOT
                {
                mDOT(); 

                }
                break;
            case 8 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:58: EQ
                {
                mEQ(); 

                }
                break;
            case 9 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:61: GE
                {
                mGE(); 

                }
                break;
            case 10 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:64: GT
                {
                mGT(); 

                }
                break;
            case 11 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:67: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 12 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:76: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 13 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:83: LE
                {
                mLE(); 

                }
                break;
            case 14 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:86: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 15 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:93: LT
                {
                mLT(); 

                }
                break;
            case 16 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:96: MINUS
                {
                mMINUS(); 

                }
                break;
            case 17 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:102: NE
                {
                mNE(); 

                }
                break;
            case 18 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:105: PLUS
                {
                mPLUS(); 

                }
                break;
            case 19 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:110: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 20 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:117: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 21 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:126: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 22 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:133: SOLIDUS
                {
                mSOLIDUS(); 

                }
                break;
            case 23 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:141: SELECT
                {
                mSELECT(); 

                }
                break;
            case 24 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:148: FROM
                {
                mFROM(); 

                }
                break;
            case 25 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:153: WHERE
                {
                mWHERE(); 

                }
                break;
            case 26 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:159: TABLEINPUT
                {
                mTABLEINPUT(); 

                }
                break;
            case 27 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:170: ORDER
                {
                mORDER(); 

                }
                break;
            case 28 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:176: BY
                {
                mBY(); 

                }
                break;
            case 29 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:179: PARTITION
                {
                mPARTITION(); 

                }
                break;
            case 30 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:189: WITH
                {
                mWITH(); 

                }
                break;
            case 31 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:194: ROWS
                {
                mROWS(); 

                }
                break;
            case 32 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:199: RANGE
                {
                mRANGE(); 

                }
                break;
            case 33 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:205: BETWEEN
                {
                mBETWEEN(); 

                }
                break;
            case 34 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:213: CURRENT
                {
                mCURRENT(); 

                }
                break;
            case 35 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:221: ROW
                {
                mROW(); 

                }
                break;
            case 36 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:225: UNBOUNDED
                {
                mUNBOUNDED(); 

                }
                break;
            case 37 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:235: PRECEDING
                {
                mPRECEDING(); 

                }
                break;
            case 38 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:245: FOLLOWING
                {
                mFOLLOWING(); 

                }
                break;
            case 39 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:255: LESS
                {
                mLESS(); 

                }
                break;
            case 40 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:260: MORE
                {
                mMORE(); 

                }
                break;
            case 41 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:265: AS
                {
                mAS(); 

                }
                break;
            case 42 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:268: OVER
                {
                mOVER(); 

                }
                break;
            case 43 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:273: INTO
                {
                mINTO(); 

                }
                break;
            case 44 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:278: PATH
                {
                mPATH(); 

                }
                break;
            case 45 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:283: FORMAT
                {
                mFORMAT(); 

                }
                break;
            case 46 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:290: SERDE
                {
                mSERDE(); 

                }
                break;
            case 47 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:296: SERDEPROPERTIES
                {
                mSERDEPROPERTIES(); 

                }
                break;
            case 48 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:312: RECORDWRITER
                {
                mRECORDWRITER(); 

                }
                break;
            case 49 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:325: LOAD
                {
                mLOAD(); 

                }
                break;
            case 50 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:330: TABLE
                {
                mTABLE(); 

                }
                break;
            case 51 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:336: OVERWRITE
                {
                mOVERWRITE(); 

                }
                break;
            case 52 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:346: AND
                {
                mAND(); 

                }
                break;
            case 53 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:350: NOT
                {
                mNOT(); 

                }
                break;
            case 54 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:354: OR
                {
                mOR(); 

                }
                break;
            case 55 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:357: XOR
                {
                mXOR(); 

                }
                break;
            case 56 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:361: ASC
                {
                mASC(); 

                }
                break;
            case 57 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:365: DESC
                {
                mDESC(); 

                }
                break;
            case 58 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:370: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 59 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:377: ID
                {
                mID(); 

                }
                break;
            case 60 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:380: GROOVYEXPRESSION
                {
                mGROOVYEXPRESSION(); 

                }
                break;
            case 61 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:397: STRING
                {
                mSTRING(); 

                }
                break;
            case 62 :
                // com/sap/hadoop/windowing/parser/Windowing.g:1:404: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA5_eotS =
        "\11\uffff\2\14\1\15\3\uffff";
    static final String DFA5_eofS =
        "\17\uffff";
    static final String DFA5_minS =
        "\1\42\10\uffff\3\60\3\uffff";
    static final String DFA5_maxS =
        "\1\164\10\uffff\3\67\3\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\3\uffff\1\13\1\12\1\11";
    static final String DFA5_specialS =
        "\17\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\6\4\uffff\1\7\10\uffff\4\11\4\12\44\uffff\1\10\5\uffff\1"+
            "\1\3\uffff\1\4\7\uffff\1\3\3\uffff\1\5\1\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\10\13",
            "\10\15",
            "\10\16",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "331:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )";
        }
    }
    static final String DFA7_eotS =
        "\1\uffff\1\50\1\51\6\uffff\1\54\2\uffff\1\57\7\uffff\21\46\10\uffff"+
        "\1\113\3\uffff\6\46\1\125\1\46\1\130\13\46\1\145\5\46\2\uffff\10"+
        "\46\1\uffff\2\46\1\uffff\4\46\1\172\7\46\1\uffff\1\u0083\1\u0084"+
        "\1\46\1\u0086\1\u0087\3\46\1\u008b\3\46\1\u008f\2\46\1\u0092\2\46"+
        "\1\u0096\1\46\1\uffff\1\u0098\4\46\1\u009d\1\u009e\1\u009f\2\uffff"+
        "\1\u00a0\2\uffff\1\u00a1\1\46\1\u00a3\1\uffff\2\46\1\u00a7\1\uffff"+
        "\1\u00a8\1\u00aa\1\uffff\3\46\1\uffff\1\46\1\uffff\1\u00af\3\46"+
        "\5\uffff\1\u00b3\1\uffff\2\46\1\u00b6\2\uffff\1\46\1\uffff\4\46"+
        "\1\uffff\3\46\1\uffff\2\46\1\uffff\2\46\1\u00c3\3\46\1\u00c7\5\46"+
        "\1\uffff\3\46\1\uffff\2\46\1\u00d2\1\46\1\u00d4\1\u00d5\1\u00d6"+
        "\1\46\1\u00d8\1\46\1\uffff\1\u00da\3\uffff\1\46\1\uffff\1\46\1\uffff"+
        "\2\46\1\u00df\1\46\1\uffff\1\46\1\u00e2\1\uffff";
    static final String DFA7_eofS =
        "\u00e3\uffff";
    static final String DFA7_minS =
        "\1\11\1\60\1\0\6\uffff\1\75\2\uffff\1\0\7\uffff\1\105\1\117\1\110"+
        "\1\101\1\122\1\105\2\101\1\125\1\116\1\105\1\117\2\116\2\117\1\105"+
        "\10\uffff\1\0\3\uffff\1\114\1\117\1\114\1\105\1\124\1\102\1\60\1"+
        "\105\1\60\1\124\1\122\1\105\1\127\1\116\1\103\1\122\1\102\1\123"+
        "\1\101\1\122\1\60\1\104\2\124\1\122\1\123\2\uffff\1\105\1\104\1"+
        "\115\1\114\1\115\1\122\1\110\1\114\1\uffff\1\105\1\122\1\uffff\1"+
        "\127\1\124\1\110\1\103\1\60\1\107\1\117\1\122\1\117\1\123\1\104"+
        "\1\105\1\uffff\2\60\1\117\2\60\2\103\1\105\1\60\1\117\1\101\1\105"+
        "\1\60\1\105\1\122\1\60\1\105\1\111\1\60\1\105\1\uffff\1\60\1\105"+
        "\1\122\1\105\1\125\3\60\2\uffff\1\60\2\uffff\1\60\1\124\1\60\1\uffff"+
        "\1\127\1\124\1\60\1\uffff\2\60\1\uffff\1\122\1\105\1\124\1\uffff"+
        "\1\104\1\uffff\1\60\1\104\2\116\5\uffff\1\60\1\uffff\1\122\1\111"+
        "\1\60\2\uffff\1\116\1\uffff\1\111\1\116\2\111\1\uffff\1\127\1\124"+
        "\1\104\1\uffff\1\117\1\116\1\uffff\1\120\1\124\1\60\1\117\1\116"+
        "\1\122\1\60\1\105\1\120\1\107\1\125\1\105\1\uffff\1\116\1\107\1"+
        "\111\1\uffff\1\104\1\105\1\60\1\124\3\60\1\124\1\60\1\122\1\uffff"+
        "\1\60\3\uffff\1\105\1\uffff\1\124\1\uffff\1\122\1\111\1\60\1\105"+
        "\1\uffff\1\123\1\60\1\uffff";
    static final String DFA7_maxS =
        "\1\175\1\172\1\uffff\6\uffff\1\75\2\uffff\1\uffff\7\uffff\1\145"+
        "\1\162\1\151\1\141\1\166\1\171\1\162\1\157\1\165\1\156\2\157\1\163"+
        "\1\156\2\157\1\145\10\uffff\1\uffff\3\uffff\1\162\1\157\1\162\1"+
        "\145\1\164\1\142\1\172\1\145\1\172\2\164\1\145\1\167\1\156\1\143"+
        "\1\162\1\142\1\163\1\141\1\162\1\172\1\144\2\164\1\162\1\163\2\uffff"+
        "\1\145\1\144\1\155\1\154\1\155\1\162\1\150\1\154\1\uffff\1\145\1"+
        "\162\1\uffff\1\167\1\164\1\150\1\143\1\172\1\147\1\157\1\162\1\157"+
        "\1\163\1\144\1\145\1\uffff\2\172\1\157\2\172\2\143\1\145\1\172\1"+
        "\157\1\141\1\145\1\172\1\145\1\162\1\172\1\145\1\151\1\172\1\145"+
        "\1\uffff\1\172\1\145\1\162\1\145\1\165\3\172\2\uffff\1\172\2\uffff"+
        "\1\172\1\164\1\172\1\uffff\1\167\1\164\1\172\1\uffff\2\172\1\uffff"+
        "\1\162\1\145\1\164\1\uffff\1\144\1\uffff\1\172\1\144\2\156\5\uffff"+
        "\1\172\1\uffff\1\162\1\151\1\172\2\uffff\1\156\1\uffff\1\151\1\156"+
        "\2\151\1\uffff\1\167\1\164\1\144\1\uffff\1\157\1\156\1\uffff\1\160"+
        "\1\164\1\172\1\157\1\156\1\162\1\172\1\145\1\160\1\147\1\165\1\145"+
        "\1\uffff\1\156\1\147\1\151\1\uffff\1\144\1\145\1\172\1\164\3\172"+
        "\1\164\1\172\1\162\1\uffff\1\172\3\uffff\1\145\1\uffff\1\164\1\uffff"+
        "\1\162\1\151\1\172\1\145\1\uffff\1\163\1\172\1\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\14\1\uffff\1\16"+
        "\1\20\1\22\1\23\1\24\1\25\1\26\21\uffff\1\72\1\73\1\76\1\1\1\2\1"+
        "\75\1\11\1\12\1\uffff\1\21\1\17\1\74\32\uffff\1\15\1\21\10\uffff"+
        "\1\66\2\uffff\1\34\14\uffff\1\51\24\uffff\1\43\10\uffff\1\70\1\64"+
        "\1\uffff\1\65\1\67\3\uffff\1\30\3\uffff\1\36\2\uffff\1\52\3\uffff"+
        "\1\54\1\uffff\1\37\4\uffff\1\47\1\61\1\50\1\53\1\71\1\uffff\1\56"+
        "\3\uffff\1\31\1\62\1\uffff\1\33\4\uffff\1\40\3\uffff\1\27\2\uffff"+
        "\1\55\14\uffff\1\41\3\uffff\1\42\12\uffff\1\46\1\uffff\1\63\1\35"+
        "\1\45\1\uffff\1\44\1\uffff\1\32\4\uffff\1\60\2\uffff\1\57";
    static final String DFA7_specialS =
        "\2\uffff\1\0\11\uffff\1\2\40\uffff\1\1\u00b5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\47\1\uffff\2\47\22\uffff\1\47\6\uffff\1\2\1\15\1\22\1\3\1"+
            "\17\1\6\1\16\1\7\1\23\12\45\1\4\1\5\1\14\1\10\1\11\2\uffff\1"+
            "\40\1\31\1\34\1\44\1\1\1\25\2\46\1\41\2\46\1\36\1\37\1\42\1"+
            "\30\1\32\1\46\1\33\1\24\1\27\1\35\1\46\1\26\1\43\2\46\1\12\1"+
            "\uffff\1\21\1\uffff\1\46\1\uffff\1\40\1\31\1\34\1\44\1\46\1"+
            "\25\2\46\1\41\2\46\1\36\1\37\1\42\1\30\1\32\1\46\1\33\1\24\1"+
            "\27\1\35\1\46\1\26\1\43\2\46\1\13\1\uffff\1\20",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\52\1\uffff\2\52\1\uffff\ufff2\52",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\53",
            "",
            "",
            "\75\60\1\55\1\56\uffc1\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\61\37\uffff\1\61",
            "\1\63\2\uffff\1\62\34\uffff\1\63\2\uffff\1\62",
            "\1\64\1\65\36\uffff\1\64\1\65",
            "\1\66\37\uffff\1\66",
            "\1\67\3\uffff\1\70\33\uffff\1\67\3\uffff\1\70",
            "\1\72\23\uffff\1\71\13\uffff\1\72\23\uffff\1\71",
            "\1\73\20\uffff\1\74\16\uffff\1\73\20\uffff\1\74",
            "\1\76\3\uffff\1\77\11\uffff\1\75\21\uffff\1\76\3\uffff\1\77"+
            "\11\uffff\1\75",
            "\1\100\37\uffff\1\100",
            "\1\101\37\uffff\1\101",
            "\1\102\11\uffff\1\103\25\uffff\1\102\11\uffff\1\103",
            "\1\104\37\uffff\1\104",
            "\1\106\4\uffff\1\105\32\uffff\1\106\4\uffff\1\105",
            "\1\107\37\uffff\1\107",
            "\1\110\37\uffff\1\110",
            "\1\111\37\uffff\1\111",
            "\1\112\37\uffff\1\112",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\0\60",
            "",
            "",
            "",
            "\1\115\5\uffff\1\116\31\uffff\1\115\5\uffff\1\116",
            "\1\117\37\uffff\1\117",
            "\1\120\5\uffff\1\121\31\uffff\1\120\5\uffff\1\121",
            "\1\122\37\uffff\1\122",
            "\1\123\37\uffff\1\123",
            "\1\124\37\uffff\1\124",
            "\12\46\7\uffff\3\46\1\126\26\46\4\uffff\1\46\1\uffff\3\46\1"+
            "\126\26\46",
            "\1\127\37\uffff\1\127",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\131\37\uffff\1\131",
            "\1\132\1\uffff\1\133\35\uffff\1\132\1\uffff\1\133",
            "\1\134\37\uffff\1\134",
            "\1\135\37\uffff\1\135",
            "\1\136\37\uffff\1\136",
            "\1\137\37\uffff\1\137",
            "\1\140\37\uffff\1\140",
            "\1\141\37\uffff\1\141",
            "\1\142\37\uffff\1\142",
            "\1\143\37\uffff\1\143",
            "\1\144\37\uffff\1\144",
            "\12\46\7\uffff\2\46\1\146\27\46\4\uffff\1\46\1\uffff\2\46\1"+
            "\146\27\46",
            "\1\147\37\uffff\1\147",
            "\1\150\37\uffff\1\150",
            "\1\151\37\uffff\1\151",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "",
            "",
            "\1\154\37\uffff\1\154",
            "\1\155\37\uffff\1\155",
            "\1\156\37\uffff\1\156",
            "\1\157\37\uffff\1\157",
            "\1\160\37\uffff\1\160",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "\1\163\37\uffff\1\163",
            "",
            "\1\164\37\uffff\1\164",
            "\1\165\37\uffff\1\165",
            "",
            "\1\166\37\uffff\1\166",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "\12\46\7\uffff\22\46\1\173\7\46\4\uffff\1\46\1\uffff\22\46"+
            "\1\173\7\46",
            "\1\174\37\uffff\1\174",
            "\1\175\37\uffff\1\175",
            "\1\176\37\uffff\1\176",
            "\1\177\37\uffff\1\177",
            "\1\u0080\37\uffff\1\u0080",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0082\37\uffff\1\u0082",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0085\37\uffff\1\u0085",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0088\37\uffff\1\u0088",
            "\1\u0089\37\uffff\1\u0089",
            "\1\u008a\37\uffff\1\u008a",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u008c\37\uffff\1\u008c",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008e\37\uffff\1\u008e",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\37\uffff\1\u0091",
            "\12\46\7\uffff\26\46\1\u0093\3\46\4\uffff\1\46\1\uffff\26\46"+
            "\1\u0093\3\46",
            "\1\u0094\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0095",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0097\37\uffff\1\u0097",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009c\37\uffff\1\u009c",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00a2\37\uffff\1\u00a2",
            "\12\46\7\uffff\17\46\1\u00a4\12\46\4\uffff\1\46\1\uffff\17"+
            "\46\1\u00a4\12\46",
            "",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\12\46\7\uffff\10\46\1\u00a9\21\46\4\uffff\1\46\1\uffff\10"+
            "\46\1\u00a9\21\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u00ab\37\uffff\1\u00ab",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\u00ad\37\uffff\1\u00ad",
            "",
            "\1\u00ae\37\uffff\1\u00ae",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00b0\37\uffff\1\u00b0",
            "\1\u00b1\37\uffff\1\u00b1",
            "\1\u00b2\37\uffff\1\u00b2",
            "",
            "",
            "",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b5",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "\1\u00b7\37\uffff\1\u00b7",
            "",
            "\1\u00b8\37\uffff\1\u00b8",
            "\1\u00b9\37\uffff\1\u00b9",
            "\1\u00ba\37\uffff\1\u00ba",
            "\1\u00bb\37\uffff\1\u00bb",
            "",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00be",
            "",
            "\1\u00bf\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c2",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00c4\37\uffff\1\u00c4",
            "\1\u00c5\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c6",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cc",
            "",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00cf\37\uffff\1\u00cf",
            "",
            "\1\u00d0\37\uffff\1\u00d0",
            "\1\u00d1\37\uffff\1\u00d1",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00d3\37\uffff\1\u00d3",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00d7\37\uffff\1\u00d7",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00d9\37\uffff\1\u00d9",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "",
            "\1\u00db\37\uffff\1\u00db",
            "",
            "\1\u00dc\37\uffff\1\u00dc",
            "",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00e0\37\uffff\1\u00e0",
            "",
            "\1\u00e1\37\uffff\1\u00e1",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__108 | QUOTE | ASTERISK | COLON | SEMICOLON | COMMA | DOT | EQ | GE | GT | LBRACKET | LBRACE | LE | LPAREN | LT | MINUS | NE | PLUS | RBRACE | RBRACKET | RPAREN | SOLIDUS | SELECT | FROM | WHERE | TABLEINPUT | ORDER | BY | PARTITION | WITH | ROWS | RANGE | BETWEEN | CURRENT | ROW | UNBOUNDED | PRECEDING | FOLLOWING | LESS | MORE | AS | OVER | INTO | PATH | FORMAT | SERDE | SERDEPROPERTIES | RECORDWRITER | LOAD | TABLE | OVERWRITE | AND | NOT | OR | XOR | ASC | DESC | NUMBER | ID | GROOVYEXPRESSION | STRING | WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_2 = input.LA(1);

                        s = -1;
                        if ( ((LA7_2>='\u0000' && LA7_2<='\t')||(LA7_2>='\u000B' && LA7_2<='\f')||(LA7_2>='\u000E' && LA7_2<='\uFFFF')) ) {s = 42;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_45 = input.LA(1);

                        s = -1;
                        if ( ((LA7_45>='\u0000' && LA7_45<='\uFFFF')) ) {s = 48;}

                        else s = 75;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_12 = input.LA(1);

                        s = -1;
                        if ( (LA7_12=='=') ) {s = 45;}

                        else if ( (LA7_12=='>') ) {s = 46;}

                        else if ( ((LA7_12>='\u0000' && LA7_12<='<')||(LA7_12>='?' && LA7_12<='\uFFFF')) ) {s = 48;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}