// $ANTLR 3.3 Nov 30, 2010 12:46:29 com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g 2011-11-07 11:55:37

package com.sap.hadoop.windowing.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class WindowingLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__96=96;
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
    public static final int FROM=16;
    public static final int WITH=17;
    public static final int TABLEINPUT=18;
    public static final int LPAREN=19;
    public static final int COMMA=20;
    public static final int RPAREN=21;
    public static final int ID=22;
    public static final int STRING=23;
    public static final int EQ=24;
    public static final int ORDER=25;
    public static final int BY=26;
    public static final int ASC=27;
    public static final int DESC=28;
    public static final int PARTITION=29;
    public static final int AS=30;
    public static final int LBRACKET=31;
    public static final int RBRACKET=32;
    public static final int GROOVYEXPRESSION=33;
    public static final int NUMBER=34;
    public static final int OVER=35;
    public static final int ROWS=36;
    public static final int BETWEEN=37;
    public static final int AND=38;
    public static final int UNBOUNDED=39;
    public static final int PRECEDING=40;
    public static final int FOLLOWING=41;
    public static final int CURRENT=42;
    public static final int ROW=43;
    public static final int RANGE=44;
    public static final int LESS=45;
    public static final int MORE=46;
    public static final int SELECT=47;
    public static final int WHERE=48;
    public static final int PLUS=49;
    public static final int MINUS=50;
    public static final int ASTERISK=51;
    public static final int SOLIDUS=52;
    public static final int DOT=53;
    public static final int QUOTE=54;
    public static final int COLON=55;
    public static final int SEMICOLON=56;
    public static final int GE=57;
    public static final int GT=58;
    public static final int LBRACE=59;
    public static final int LE=60;
    public static final int LT=61;
    public static final int NE=62;
    public static final int RBRACE=63;
    public static final int S=64;
    public static final int E=65;
    public static final int L=66;
    public static final int C=67;
    public static final int T=68;
    public static final int F=69;
    public static final int R=70;
    public static final int O=71;
    public static final int M=72;
    public static final int W=73;
    public static final int H=74;
    public static final int A=75;
    public static final int B=76;
    public static final int I=77;
    public static final int N=78;
    public static final int P=79;
    public static final int U=80;
    public static final int D=81;
    public static final int Y=82;
    public static final int G=83;
    public static final int V=84;
    public static final int NOT=85;
    public static final int OR=86;
    public static final int X=87;
    public static final int XOR=88;
    public static final int GroovyEscapeSequence=89;
    public static final int EscapeSequence=90;
    public static final int WS=91;
    public static final int J=92;
    public static final int K=93;
    public static final int Q=94;
    public static final int Z=95;

    // delegates
    // delegators

    public WindowingLexer() {;} 
    public WindowingLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public WindowingLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g"; }

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:11:7: ( 'E' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:11:9: 'E'
            {
            match('E'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "QUOTE"
    public final void mQUOTE() throws RecognitionException {
        try {
            int _type = QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:200:19: ( '\\'' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:200:21: '\\''
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:201:19: ( '*' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:201:21: '*'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:202:19: ( ':' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:202:21: ':'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:203:19: ( ';' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:203:21: ';'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:204:19: ( ',' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:204:21: ','
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:205:19: ( '.' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:205:21: '.'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:206:19: ( '=' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:206:21: '='
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:207:19: ( '>=' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:207:21: '>='
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:208:19: ( '>' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:208:21: '>'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:209:19: ( '[' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:209:21: '['
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:210:19: ( '{' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:210:21: '{'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:211:19: ( '<=' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:211:21: '<='
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:212:19: ( '(' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:212:21: '('
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:213:19: ( '<' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:213:21: '<'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:214:19: ( '-' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:214:21: '-'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:215:19: ( '<>' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:215:21: '<>'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:216:19: ( '+' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:216:21: '+'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:217:19: ( '}' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:217:21: '}'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:218:19: ( ']' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:218:21: ']'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:219:19: ( ')' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:219:21: ')'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:220:19: ( '/' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:220:21: '/'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:222:19: ( S E L E C T )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:222:21: S E L E C T
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:223:19: ( F R O M )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:223:21: F R O M
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:224:19: ( W H E R E )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:224:21: W H E R E
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:225:19: ( T A B L E I N P U T )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:225:21: T A B L E I N P U T
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:226:19: ( O R D E R )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:226:21: O R D E R
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:227:19: ( B Y )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:227:21: B Y
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:228:19: ( P A R T I T I O N )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:228:21: P A R T I T I O N
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:229:19: ( W I T H )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:229:21: W I T H
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:230:19: ( R O W S )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:230:21: R O W S
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:231:18: ( R A N G E )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:231:20: R A N G E
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:232:12: ( B E T W E E N )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:232:14: B E T W E E N
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:233:12: ( C U R R E N T )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:233:14: C U R R E N T
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:234:8: ( R O W )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:234:10: R O W
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:235:16: ( U N B O U N D E D )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:235:18: U N B O U N D E D
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:236:19: ( P R E C E D I N G )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:236:21: P R E C E D I N G
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:237:19: ( F O L L O W I N G )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:237:21: F O L L O W I N G
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:238:9: ( L E S S )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:238:11: L E S S
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:239:9: ( M O R E )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:239:11: M O R E
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:240:7: ( A S )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:240:9: A S
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:241:9: ( O V E R )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:241:11: O V E R
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

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:246:19: ( A N D )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:246:21: A N D
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:247:19: ( N O T )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:247:21: N O T
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:248:19: ( O R )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:248:21: O R
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:249:19: ( X O R )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:249:21: X O R
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:251:19: ( A S C )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:251:21: A S C
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:252:19: ( D E S C )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:252:21: D E S C
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:254:11: ( ( '0' .. '9' )+ )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:254:13: ( '0' .. '9' )+
            {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:254:13: ( '0' .. '9' )+
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:254:14: '0' .. '9'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:256:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:256:10: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:256:34: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:259:18: ( '<' ( GroovyEscapeSequence | ~ ( '>' ) )* '>' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:259:20: '<' ( GroovyEscapeSequence | ~ ( '>' ) )* '>'
            {
            match('<'); 
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:260:3: ( GroovyEscapeSequence | ~ ( '>' ) )*
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:260:4: GroovyEscapeSequence
            	    {
            	    mGroovyEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:260:27: ~ ( '>' )
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
            setText(getText().substring(1, getText().length()-1));

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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:265:22: ( '\\\\' '>' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:266:3: '\\\\' '>'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:270:5: ( '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )* '\\'' )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:270:9: '\\'' ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )* '\\''
            {
            match('\''); 
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:271:9: ( EscapeSequence | ~ ( '\\\\' | '\\'' | '\\r' | '\\n' ) )*
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:271:13: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:272:13: ~ ( '\\\\' | '\\'' | '\\r' | '\\n' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:279:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:279:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            {
            match('\\'); 
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:279:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            int alt5=11;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:280:18: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:281:18: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:282:18: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 4 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:283:18: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:284:18: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 6 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:285:18: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:286:18: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:287:18: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:289:18: ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:289:18: ( '0' .. '3' )
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:289:19: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:289:29: ( '0' .. '7' )
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:289:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:289:40: ( '0' .. '7' )
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:289:41: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 10 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:291:18: ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:291:18: ( '0' .. '7' )
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:291:19: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:291:29: ( '0' .. '7' )
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:291:30: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 11 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:293:18: ( '0' .. '7' )
                    {
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:293:18: ( '0' .. '7' )
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:293:19: '0' .. '7'
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:297:5: ( ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+ )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:297:9: ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+
            {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:297:9: ( ' ' | '\\t' | '\\r' | '\\f' | '\\n' )+
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:306:11: ( ( 'a' | 'A' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:306:12: ( 'a' | 'A' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:307:11: ( ( 'b' | 'B' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:307:12: ( 'b' | 'B' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:308:11: ( ( 'c' | 'C' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:308:12: ( 'c' | 'C' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:309:11: ( ( 'd' | 'D' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:309:12: ( 'd' | 'D' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:310:11: ( ( 'e' | 'E' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:310:12: ( 'e' | 'E' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:311:11: ( ( 'f' | 'F' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:311:12: ( 'f' | 'F' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:312:11: ( ( 'g' | 'G' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:312:12: ( 'g' | 'G' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:313:11: ( ( 'h' | 'H' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:313:12: ( 'h' | 'H' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:314:11: ( ( 'i' | 'I' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:314:12: ( 'i' | 'I' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:315:11: ( ( 'j' | 'J' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:315:12: ( 'j' | 'J' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:316:11: ( ( 'k' | 'K' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:316:12: ( 'k' | 'K' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:317:11: ( ( 'l' | 'L' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:317:12: ( 'l' | 'L' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:318:11: ( ( 'm' | 'M' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:318:12: ( 'm' | 'M' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:319:11: ( ( 'n' | 'N' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:319:12: ( 'n' | 'N' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:320:11: ( ( 'o' | 'O' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:320:12: ( 'o' | 'O' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:321:11: ( ( 'p' | 'P' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:321:12: ( 'p' | 'P' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:322:11: ( ( 'q' | 'Q' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:322:12: ( 'q' | 'Q' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:323:11: ( ( 'r' | 'R' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:323:12: ( 'r' | 'R' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:324:11: ( ( 's' | 'S' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:324:12: ( 's' | 'S' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:325:11: ( ( 't' | 'T' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:325:12: ( 't' | 'T' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:326:11: ( ( 'u' | 'U' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:326:12: ( 'u' | 'U' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:327:11: ( ( 'v' | 'V' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:327:12: ( 'v' | 'V' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:328:11: ( ( 'w' | 'W' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:328:12: ( 'w' | 'W' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:329:11: ( ( 'x' | 'X' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:329:12: ( 'x' | 'X' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:330:11: ( ( 'y' | 'Y' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:330:12: ( 'y' | 'Y' )
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:331:11: ( ( 'z' | 'Z' ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:331:12: ( 'z' | 'Z' )
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
        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:8: ( T__96 | QUOTE | ASTERISK | COLON | SEMICOLON | COMMA | DOT | EQ | GE | GT | LBRACKET | LBRACE | LE | LPAREN | LT | MINUS | NE | PLUS | RBRACE | RBRACKET | RPAREN | SOLIDUS | SELECT | FROM | WHERE | TABLEINPUT | ORDER | BY | PARTITION | WITH | ROWS | RANGE | BETWEEN | CURRENT | ROW | UNBOUNDED | PRECEDING | FOLLOWING | LESS | MORE | AS | OVER | AND | NOT | OR | XOR | ASC | DESC | NUMBER | ID | GROOVYEXPRESSION | STRING | WS )
        int alt7=53;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:10: T__96
                {
                mT__96(); 

                }
                break;
            case 2 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:16: QUOTE
                {
                mQUOTE(); 

                }
                break;
            case 3 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:22: ASTERISK
                {
                mASTERISK(); 

                }
                break;
            case 4 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:31: COLON
                {
                mCOLON(); 

                }
                break;
            case 5 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:37: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 6 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:47: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 7 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:53: DOT
                {
                mDOT(); 

                }
                break;
            case 8 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:57: EQ
                {
                mEQ(); 

                }
                break;
            case 9 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:60: GE
                {
                mGE(); 

                }
                break;
            case 10 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:63: GT
                {
                mGT(); 

                }
                break;
            case 11 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:66: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 12 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:75: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 13 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:82: LE
                {
                mLE(); 

                }
                break;
            case 14 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:85: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 15 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:92: LT
                {
                mLT(); 

                }
                break;
            case 16 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:95: MINUS
                {
                mMINUS(); 

                }
                break;
            case 17 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:101: NE
                {
                mNE(); 

                }
                break;
            case 18 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:104: PLUS
                {
                mPLUS(); 

                }
                break;
            case 19 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:109: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 20 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:116: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 21 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:125: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 22 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:132: SOLIDUS
                {
                mSOLIDUS(); 

                }
                break;
            case 23 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:140: SELECT
                {
                mSELECT(); 

                }
                break;
            case 24 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:147: FROM
                {
                mFROM(); 

                }
                break;
            case 25 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:152: WHERE
                {
                mWHERE(); 

                }
                break;
            case 26 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:158: TABLEINPUT
                {
                mTABLEINPUT(); 

                }
                break;
            case 27 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:169: ORDER
                {
                mORDER(); 

                }
                break;
            case 28 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:175: BY
                {
                mBY(); 

                }
                break;
            case 29 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:178: PARTITION
                {
                mPARTITION(); 

                }
                break;
            case 30 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:188: WITH
                {
                mWITH(); 

                }
                break;
            case 31 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:193: ROWS
                {
                mROWS(); 

                }
                break;
            case 32 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:198: RANGE
                {
                mRANGE(); 

                }
                break;
            case 33 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:204: BETWEEN
                {
                mBETWEEN(); 

                }
                break;
            case 34 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:212: CURRENT
                {
                mCURRENT(); 

                }
                break;
            case 35 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:220: ROW
                {
                mROW(); 

                }
                break;
            case 36 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:224: UNBOUNDED
                {
                mUNBOUNDED(); 

                }
                break;
            case 37 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:234: PRECEDING
                {
                mPRECEDING(); 

                }
                break;
            case 38 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:244: FOLLOWING
                {
                mFOLLOWING(); 

                }
                break;
            case 39 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:254: LESS
                {
                mLESS(); 

                }
                break;
            case 40 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:259: MORE
                {
                mMORE(); 

                }
                break;
            case 41 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:264: AS
                {
                mAS(); 

                }
                break;
            case 42 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:267: OVER
                {
                mOVER(); 

                }
                break;
            case 43 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:272: AND
                {
                mAND(); 

                }
                break;
            case 44 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:276: NOT
                {
                mNOT(); 

                }
                break;
            case 45 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:280: OR
                {
                mOR(); 

                }
                break;
            case 46 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:283: XOR
                {
                mXOR(); 

                }
                break;
            case 47 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:287: ASC
                {
                mASC(); 

                }
                break;
            case 48 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:291: DESC
                {
                mDESC(); 

                }
                break;
            case 49 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:296: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 50 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:303: ID
                {
                mID(); 

                }
                break;
            case 51 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:306: GROOVYEXPRESSION
                {
                mGROOVYEXPRESSION(); 

                }
                break;
            case 52 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:323: STRING
                {
                mSTRING(); 

                }
                break;
            case 53 :
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:1:330: WS
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
            return "279:14: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )";
        }
    }
    static final String DFA7_eotS =
        "\1\uffff\1\47\1\50\6\uffff\1\53\2\uffff\1\56\7\uffff\20\45\10\uffff"+
        "\1\107\3\uffff\6\45\1\117\1\45\1\122\11\45\1\134\4\45\2\uffff\6"+
        "\45\1\uffff\2\45\1\uffff\3\45\1\155\5\45\1\uffff\1\164\1\165\1\166"+
        "\1\167\2\45\1\172\2\45\1\175\2\45\1\u0080\3\45\1\uffff\1\u0084\3"+
        "\45\1\u0088\1\u0089\4\uffff\1\u008a\1\45\1\uffff\1\45\1\u008d\1"+
        "\uffff\1\45\1\u008f\1\uffff\3\45\1\uffff\1\u0093\2\45\3\uffff\1"+
        "\u0096\1\45\1\uffff\1\45\1\uffff\3\45\1\uffff\2\45\1\uffff\2\45"+
        "\1\u00a0\2\45\1\u00a3\3\45\1\uffff\2\45\1\uffff\1\45\1\u00aa\1\45"+
        "\1\u00ac\1\u00ad\1\u00ae\1\uffff\1\u00af\4\uffff";
    static final String DFA7_eofS =
        "\u00b0\uffff";
    static final String DFA7_minS =
        "\1\11\1\60\1\0\6\uffff\1\75\2\uffff\1\0\7\uffff\1\105\1\117\1\110"+
        "\1\101\1\122\1\105\2\101\1\125\1\116\1\105\1\117\1\116\2\117\1\105"+
        "\10\uffff\1\0\3\uffff\1\114\1\117\1\114\1\105\1\124\1\102\1\60\1"+
        "\105\1\60\1\124\1\122\1\105\1\127\1\116\1\122\1\102\1\123\1\122"+
        "\1\60\1\104\1\124\1\122\1\123\2\uffff\1\105\1\115\1\114\1\122\1"+
        "\110\1\114\1\uffff\1\105\1\122\1\uffff\1\127\1\124\1\103\1\60\1"+
        "\107\1\122\1\117\1\123\1\105\1\uffff\4\60\2\103\1\60\1\117\1\105"+
        "\1\60\1\105\1\122\1\60\1\105\1\111\1\105\1\uffff\1\60\2\105\1\125"+
        "\2\60\4\uffff\1\60\1\124\1\uffff\1\127\1\60\1\uffff\1\111\1\60\1"+
        "\uffff\1\105\1\124\1\104\1\uffff\1\60\2\116\3\uffff\1\60\1\111\1"+
        "\uffff\1\116\1\uffff\1\116\2\111\1\uffff\1\124\1\104\1\uffff\1\116"+
        "\1\120\1\60\1\117\1\116\1\60\1\105\1\107\1\125\1\uffff\1\116\1\107"+
        "\1\uffff\1\104\1\60\1\124\3\60\1\uffff\1\60\4\uffff";
    static final String DFA7_maxS =
        "\1\175\1\172\1\uffff\6\uffff\1\75\2\uffff\1\uffff\7\uffff\1\145"+
        "\1\162\1\151\1\141\1\166\1\171\1\162\1\157\1\165\1\156\1\145\1\157"+
        "\1\163\2\157\1\145\10\uffff\1\uffff\3\uffff\1\154\1\157\1\154\1"+
        "\145\1\164\1\142\1\172\1\145\1\172\1\164\1\162\1\145\1\167\1\156"+
        "\1\162\1\142\1\163\1\162\1\172\1\144\1\164\1\162\1\163\2\uffff\1"+
        "\145\1\155\1\154\1\162\1\150\1\154\1\uffff\1\145\1\162\1\uffff\1"+
        "\167\1\164\1\143\1\172\1\147\1\162\1\157\1\163\1\145\1\uffff\4\172"+
        "\2\143\1\172\1\157\1\145\1\172\1\145\1\162\1\172\1\145\1\151\1\145"+
        "\1\uffff\1\172\2\145\1\165\2\172\4\uffff\1\172\1\164\1\uffff\1\167"+
        "\1\172\1\uffff\1\151\1\172\1\uffff\1\145\1\164\1\144\1\uffff\1\172"+
        "\2\156\3\uffff\1\172\1\151\1\uffff\1\156\1\uffff\1\156\2\151\1\uffff"+
        "\1\164\1\144\1\uffff\1\156\1\160\1\172\1\157\1\156\1\172\1\145\1"+
        "\147\1\165\1\uffff\1\156\1\147\1\uffff\1\144\1\172\1\164\3\172\1"+
        "\uffff\1\172\4\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\14\1\uffff\1\16"+
        "\1\20\1\22\1\23\1\24\1\25\1\26\20\uffff\1\61\1\62\1\65\1\1\1\2\1"+
        "\64\1\11\1\12\1\uffff\1\21\1\17\1\63\27\uffff\1\15\1\21\6\uffff"+
        "\1\55\2\uffff\1\34\11\uffff\1\51\20\uffff\1\43\6\uffff\1\57\1\53"+
        "\1\54\1\56\2\uffff\1\30\2\uffff\1\36\2\uffff\1\52\3\uffff\1\37\3"+
        "\uffff\1\47\1\50\1\60\2\uffff\1\31\1\uffff\1\33\3\uffff\1\40\2\uffff"+
        "\1\27\11\uffff\1\41\2\uffff\1\42\6\uffff\1\46\1\uffff\1\35\1\45"+
        "\1\44\1\32";
    static final String DFA7_specialS =
        "\2\uffff\1\0\11\uffff\1\2\37\uffff\1\1\u0083\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\46\1\uffff\2\46\22\uffff\1\46\6\uffff\1\2\1\15\1\22\1\3"+
            "\1\17\1\6\1\16\1\7\1\23\12\44\1\4\1\5\1\14\1\10\1\11\2\uffff"+
            "\1\40\1\31\1\34\1\43\1\1\1\25\5\45\1\36\1\37\1\41\1\30\1\32"+
            "\1\45\1\33\1\24\1\27\1\35\1\45\1\26\1\42\2\45\1\12\1\uffff\1"+
            "\21\1\uffff\1\45\1\uffff\1\40\1\31\1\34\1\43\1\45\1\25\5\45"+
            "\1\36\1\37\1\41\1\30\1\32\1\45\1\33\1\24\1\27\1\35\1\45\1\26"+
            "\1\42\2\45\1\13\1\uffff\1\20",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\51\1\uffff\2\51\1\uffff\ufff2\51",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\52",
            "",
            "",
            "\75\57\1\54\1\55\uffc1\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60\37\uffff\1\60",
            "\1\62\2\uffff\1\61\34\uffff\1\62\2\uffff\1\61",
            "\1\63\1\64\36\uffff\1\63\1\64",
            "\1\65\37\uffff\1\65",
            "\1\66\3\uffff\1\67\33\uffff\1\66\3\uffff\1\67",
            "\1\71\23\uffff\1\70\13\uffff\1\71\23\uffff\1\70",
            "\1\72\20\uffff\1\73\16\uffff\1\72\20\uffff\1\73",
            "\1\75\15\uffff\1\74\21\uffff\1\75\15\uffff\1\74",
            "\1\76\37\uffff\1\76",
            "\1\77\37\uffff\1\77",
            "\1\100\37\uffff\1\100",
            "\1\101\37\uffff\1\101",
            "\1\103\4\uffff\1\102\32\uffff\1\103\4\uffff\1\102",
            "\1\104\37\uffff\1\104",
            "\1\105\37\uffff\1\105",
            "\1\106\37\uffff\1\106",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\0\57",
            "",
            "",
            "",
            "\1\111\37\uffff\1\111",
            "\1\112\37\uffff\1\112",
            "\1\113\37\uffff\1\113",
            "\1\114\37\uffff\1\114",
            "\1\115\37\uffff\1\115",
            "\1\116\37\uffff\1\116",
            "\12\45\7\uffff\3\45\1\120\26\45\4\uffff\1\45\1\uffff\3\45"+
            "\1\120\26\45",
            "\1\121\37\uffff\1\121",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\123\37\uffff\1\123",
            "\1\124\37\uffff\1\124",
            "\1\125\37\uffff\1\125",
            "\1\126\37\uffff\1\126",
            "\1\127\37\uffff\1\127",
            "\1\130\37\uffff\1\130",
            "\1\131\37\uffff\1\131",
            "\1\132\37\uffff\1\132",
            "\1\133\37\uffff\1\133",
            "\12\45\7\uffff\2\45\1\135\27\45\4\uffff\1\45\1\uffff\2\45"+
            "\1\135\27\45",
            "\1\136\37\uffff\1\136",
            "\1\137\37\uffff\1\137",
            "\1\140\37\uffff\1\140",
            "\1\141\37\uffff\1\141",
            "",
            "",
            "\1\142\37\uffff\1\142",
            "\1\143\37\uffff\1\143",
            "\1\144\37\uffff\1\144",
            "\1\145\37\uffff\1\145",
            "\1\146\37\uffff\1\146",
            "\1\147\37\uffff\1\147",
            "",
            "\1\150\37\uffff\1\150",
            "\1\151\37\uffff\1\151",
            "",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "\1\154\37\uffff\1\154",
            "\12\45\7\uffff\22\45\1\156\7\45\4\uffff\1\45\1\uffff\22\45"+
            "\1\156\7\45",
            "\1\157\37\uffff\1\157",
            "\1\160\37\uffff\1\160",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "\1\163\37\uffff\1\163",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\170\37\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\173\37\uffff\1\173",
            "\1\174\37\uffff\1\174",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\176\37\uffff\1\176",
            "\1\177\37\uffff\1\177",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0082\37\uffff\1\u0082",
            "\1\u0083\37\uffff\1\u0083",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0085\37\uffff\1\u0085",
            "\1\u0086\37\uffff\1\u0086",
            "\1\u0087\37\uffff\1\u0087",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u008b\37\uffff\1\u008b",
            "",
            "\1\u008c\37\uffff\1\u008c",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u008e\37\uffff\1\u008e",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0092\37\uffff\1\u0092",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0094\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0095",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u0097\37\uffff\1\u0097",
            "",
            "\1\u0098\37\uffff\1\u0098",
            "",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\1\u009b\37\uffff\1\u009b",
            "",
            "\1\u009c\37\uffff\1\u009c",
            "\1\u009d\37\uffff\1\u009d",
            "",
            "\1\u009e\37\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a2",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "",
            "\1\u00a7\37\uffff\1\u00a7",
            "\1\u00a8\37\uffff\1\u00a8",
            "",
            "\1\u00a9\37\uffff\1\u00a9",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\1\u00ab\37\uffff\1\u00ab",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( T__96 | QUOTE | ASTERISK | COLON | SEMICOLON | COMMA | DOT | EQ | GE | GT | LBRACKET | LBRACE | LE | LPAREN | LT | MINUS | NE | PLUS | RBRACE | RBRACKET | RPAREN | SOLIDUS | SELECT | FROM | WHERE | TABLEINPUT | ORDER | BY | PARTITION | WITH | ROWS | RANGE | BETWEEN | CURRENT | ROW | UNBOUNDED | PRECEDING | FOLLOWING | LESS | MORE | AS | OVER | AND | NOT | OR | XOR | ASC | DESC | NUMBER | ID | GROOVYEXPRESSION | STRING | WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_2 = input.LA(1);

                        s = -1;
                        if ( ((LA7_2>='\u0000' && LA7_2<='\t')||(LA7_2>='\u000B' && LA7_2<='\f')||(LA7_2>='\u000E' && LA7_2<='\uFFFF')) ) {s = 41;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_44 = input.LA(1);

                        s = -1;
                        if ( ((LA7_44>='\u0000' && LA7_44<='\uFFFF')) ) {s = 47;}

                        else s = 71;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_12 = input.LA(1);

                        s = -1;
                        if ( (LA7_12=='=') ) {s = 44;}

                        else if ( (LA7_12=='>') ) {s = 45;}

                        else if ( ((LA7_12>='\u0000' && LA7_12<='<')||(LA7_12>='?' && LA7_12<='\uFFFF')) ) {s = 47;}

                        else s = 46;

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