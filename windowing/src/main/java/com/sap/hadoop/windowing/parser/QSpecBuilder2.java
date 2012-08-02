// $ANTLR 3.0.1 QSpecBuilder2.g 2012-08-02 09:53:51

package com.sap.hadoop.windowing.parser;

import com.sap.hadoop.query2.specification.*;
import com.sap.hadoop.query2.specification.WindowFrameSpec.Direction;
import com.sap.hadoop.query2.specification.WindowFrameSpec.BoundarySpec;
import com.sap.hadoop.query2.specification.WindowFrameSpec.RangeBoundarySpec;
import com.sap.hadoop.query2.specification.WindowFrameSpec.CurrentRowSpec;
import com.sap.hadoop.query2.specification.WindowFrameSpec.ValueBoundarySpec;
import com.sap.hadoop.metadata.Order;

import com.sap.hadoop.windowing.Constants;

import com.sap.hadoop.Utils;
import com.sap.hadoop.windowing.WindowingException;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QSpecBuilder2 extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "WDW_FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "TBLFUNCTION", "LOADSPEC", "STRINGLITERALSEQUENCE", "CHARSETLITERAL", "NOTNULL", "FUNCTIONSTAR", "FUNCTIONDIST", "WDW_FUNCTIONSTAR", "WDW_FUNCTIONDIST", "TABLEORCOL", "COLUMNREF", "WINDOWSPEC", "WINDOWDEF", "INPUT", "HDFSLOCATION", "HIVEQ", "HIVETBL", "UPLUS", "FROM", "SELECT", "COMMA", "AS", "Identifier", "HIVEQUERY", "DOT", "LPAREN", "RPAREN", "FILEINPUT", "WHERE", "INTO", "PATH", "EQUAL", "StringLiteral", "SERDE", "WITH", "SERDEPROPERTIES", "RECORDWRITER", "FORMAT", "LOAD", "OVERWRITE", "TABLE", "PARTITION", "STAR", "DISTINCT", "OVER", "WINDOW", "ORDER", "BY", "ASC", "DESC", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "Number", "RANGE", "LESS", "MORE", "IF", "ARRAY", "MAP", "STRUCT", "UNION", "CAST", "CASE", "WHEN", "THEN", "ELSE", "END", "BigintLiteral", "SmallintLiteral", "TinyintLiteral", "CharSetName", "CharSetLiteral", "OR", "NOT", "LIKE", "RLIKE", "REGEXP", "EQUAL_NS", "NOTEQUAL", "LESSTHANOREQUALTO", "LESSTHAN", "GREATERTHANOREQUALTO", "GREATERTHAN", "IN", "BITWISEOR", "AMPERSAND", "PLUS", "MINUS", "DIVIDE", "MOD", "DIV", "BITWISEXOR", "NULL", "IS", "TILDE", "LSQUARE", "RSQUARE", "TRUE", "FALSE", "TINYINT", "SMALLINT", "INT", "BIGINT", "BOOLEAN", "FLOAT", "DOUBLE", "DATE", "DATETIME", "TIMESTAMP", "STRING", "BINARY", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "I", "N", "P", "U", "D", "B", "Y", "A", "G", "V", "K", "X", "COLON", "SEMICOLON", "LCURLY", "RCURLY", "XOR", "QUESTION", "DOLLAR", "HiveQueryEscapeSequence", "EscapeSequence", "HexDigit", "Digit", "Letter", "Exponent", "RegexComponent", "WS", "COMMENT", "J", "Q", "Z"
    };
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
    protected static class PartOrderScope_scope {
        ArrayList<String> partitionColumns;
        ArrayList<OrderColumnSpec> orderColumns;
    }
    protected Stack PartOrderScope_stack = new Stack();


        public QSpecBuilder2(TreeNodeStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "QSpecBuilder2.g"; }


      protected QuerySpec qSpec = new QuerySpec();  

      
      public QuerySpec getQuerySpec() { return qSpec; }
      
      protected StringBuilder buf = new StringBuilder();
      
      public void emitErrorMessage(String msg) {
        buf.append(msg).append("\n");
      }
      
      public String getWindowingParseErrors()
      {
        String b = buf.toString().trim();
        if (b.equals("") ) return null;
        return b;
      }
      



    // $ANTLR start query
    // QSpecBuilder2.g:53:1: query : ^( QUERY ts= tableSpec ss= select ( where[qSpec] )? ( window_clause[qSpec] )? (oc= outputClause )? ) ;
    public final void query() throws RecognitionException {
        QueryInputSpec ts = null;

        SelectSpec ss = null;

        QueryOutputSpec oc = null;


        try {
            // QSpecBuilder2.g:53:7: ( ^( QUERY ts= tableSpec ss= select ( where[qSpec] )? ( window_clause[qSpec] )? (oc= outputClause )? ) )
            // QSpecBuilder2.g:54:2: ^( QUERY ts= tableSpec ss= select ( where[qSpec] )? ( window_clause[qSpec] )? (oc= outputClause )? )
            {
            match(input,QUERY,FOLLOW_QUERY_in_query66); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_tableSpec_in_query70);
            ts=tableSpec();
            _fsp--;

            pushFollow(FOLLOW_select_in_query74);
            ss=select();
            _fsp--;

            // QSpecBuilder2.g:54:33: ( where[qSpec] )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==WHERE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // QSpecBuilder2.g:54:33: where[qSpec]
                    {
                    pushFollow(FOLLOW_where_in_query76);
                    where(qSpec);
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder2.g:54:47: ( window_clause[qSpec] )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==WINDOW) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // QSpecBuilder2.g:54:47: window_clause[qSpec]
                    {
                    pushFollow(FOLLOW_window_clause_in_query80);
                    window_clause(qSpec);
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder2.g:54:71: (oc= outputClause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==OUTPUTSPEC) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // QSpecBuilder2.g:54:71: oc= outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_query86);
                    oc=outputClause();
                    _fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
             qSpec.setInput(ts); qSpec.setSelectList(ss); qSpec.setOutput(oc);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end query


    // $ANTLR start select
    // QSpecBuilder2.g:57:1: select returns [SelectSpec ss] : ^( SELECT ( selectColumn[ss] )+ ) ;
    public final SelectSpec select() throws RecognitionException {
        SelectSpec ss = null;


          ss = new SelectSpec();

        try {
            // QSpecBuilder2.g:62:2: ( ^( SELECT ( selectColumn[ss] )+ ) )
            // QSpecBuilder2.g:63:3: ^( SELECT ( selectColumn[ss] )+ )
            {
            match(input,SELECT,FOLLOW_SELECT_in_select113); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder2.g:63:12: ( selectColumn[ss] )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==SELECTCOLUMN) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // QSpecBuilder2.g:63:12: selectColumn[ss]
            	    {
            	    pushFollow(FOLLOW_selectColumn_in_select115);
            	    selectColumn(ss);
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ss;
    }
    // $ANTLR end select


    // $ANTLR start selectColumn
    // QSpecBuilder2.g:66:1: selectColumn[SelectSpec ss] : ( ^( SELECTCOLUMN e= expression (i= Identifier )? ) | ^( SELECTCOLUMN w= window_function i= Identifier ) );
    public final void selectColumn(SelectSpec ss) throws RecognitionException {
        CommonTree i=null;
        CommonTree e = null;

        WindowFunctionSpec w = null;


        try {
            // QSpecBuilder2.g:66:28: ( ^( SELECTCOLUMN e= expression (i= Identifier )? ) | ^( SELECTCOLUMN w= window_function i= Identifier ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==SELECTCOLUMN) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==WDW_FUNCTION||(LA6_2>=WDW_FUNCTIONSTAR && LA6_2<=WDW_FUNCTIONDIST)) ) {
                        alt6=2;
                    }
                    else if ( (LA6_2==FUNCTION||(LA6_2>=STRINGLITERALSEQUENCE && LA6_2<=CHARSETLITERAL)||(LA6_2>=FUNCTIONSTAR && LA6_2<=FUNCTIONDIST)||LA6_2==TABLEORCOL||LA6_2==DOT||(LA6_2>=EQUAL && LA6_2<=StringLiteral)||LA6_2==STAR||LA6_2==AND||LA6_2==Number||(LA6_2>=BigintLiteral && LA6_2<=TinyintLiteral)||(LA6_2>=OR && LA6_2<=GREATERTHAN)||(LA6_2>=BITWISEOR && LA6_2<=NULL)||(LA6_2>=TILDE && LA6_2<=LSQUARE)||(LA6_2>=TRUE && LA6_2<=FALSE)) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("66:1: selectColumn[SelectSpec ss] : ( ^( SELECTCOLUMN e= expression (i= Identifier )? ) | ^( SELECTCOLUMN w= window_function i= Identifier ) );", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("66:1: selectColumn[SelectSpec ss] : ( ^( SELECTCOLUMN e= expression (i= Identifier )? ) | ^( SELECTCOLUMN w= window_function i= Identifier ) );", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("66:1: selectColumn[SelectSpec ss] : ( ^( SELECTCOLUMN e= expression (i= Identifier )? ) | ^( SELECTCOLUMN w= window_function i= Identifier ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // QSpecBuilder2.g:67:3: ^( SELECTCOLUMN e= expression (i= Identifier )? )
                    {
                    match(input,SELECTCOLUMN,FOLLOW_SELECTCOLUMN_in_selectColumn130); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_selectColumn134);
                    e=expression();
                    _fsp--;

                    // QSpecBuilder2.g:67:32: (i= Identifier )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==Identifier) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // QSpecBuilder2.g:67:32: i= Identifier
                            {
                            i=(CommonTree)input.LT(1);
                            match(input,Identifier,FOLLOW_Identifier_in_selectColumn138); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    ss.addExpression(e, i!=null ? i.getText() : null);

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:68:3: ^( SELECTCOLUMN w= window_function i= Identifier )
                    {
                    match(input,SELECTCOLUMN,FOLLOW_SELECTCOLUMN_in_selectColumn149); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_window_function_in_selectColumn153);
                    w=window_function();
                    _fsp--;

                    i=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_selectColumn157); 

                    match(input, Token.UP, null); 
                    ss.addWindowFunc(w, i.getText());

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end selectColumn


    // $ANTLR start tableSpec
    // QSpecBuilder2.g:71:1: tableSpec returns [QueryInputSpec qIn] : ^( INPUT (t= tblfunc | t= hiveQuery | t= hdfsFile | t= hiveTable ) (p= partitionby )? (o= orderby )? ) ;
    public final QueryInputSpec tableSpec() throws RecognitionException {
        QueryInputSpec qIn = null;

        QueryInputSpec t = null;

        PartitionSpec p = null;

        OrderSpec o = null;


        try {
            // QSpecBuilder2.g:71:40: ( ^( INPUT (t= tblfunc | t= hiveQuery | t= hdfsFile | t= hiveTable ) (p= partitionby )? (o= orderby )? ) )
            // QSpecBuilder2.g:72:2: ^( INPUT (t= tblfunc | t= hiveQuery | t= hdfsFile | t= hiveTable ) (p= partitionby )? (o= orderby )? )
            {
            match(input,INPUT,FOLLOW_INPUT_in_tableSpec175); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder2.g:72:10: (t= tblfunc | t= hiveQuery | t= hdfsFile | t= hiveTable )
            int alt7=4;
            switch ( input.LA(1) ) {
            case TBLFUNCTION:
                {
                alt7=1;
                }
                break;
            case HIVEQUERY:
                {
                alt7=2;
                }
                break;
            case HDFSLOCATION:
                {
                alt7=3;
                }
                break;
            case HIVETBL:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("72:10: (t= tblfunc | t= hiveQuery | t= hdfsFile | t= hiveTable )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // QSpecBuilder2.g:72:11: t= tblfunc
                    {
                    pushFollow(FOLLOW_tblfunc_in_tableSpec180);
                    t=tblfunc();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:72:21: t= hiveQuery
                    {
                    pushFollow(FOLLOW_hiveQuery_in_tableSpec184);
                    t=hiveQuery();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:72:33: t= hdfsFile
                    {
                    pushFollow(FOLLOW_hdfsFile_in_tableSpec188);
                    t=hdfsFile();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:72:44: t= hiveTable
                    {
                    pushFollow(FOLLOW_hiveTable_in_tableSpec192);
                    t=hiveTable();
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder2.g:72:57: (p= partitionby )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==PARTITION) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // QSpecBuilder2.g:72:58: p= partitionby
                    {
                    pushFollow(FOLLOW_partitionby_in_tableSpec198);
                    p=partitionby();
                    _fsp--;

                    t.setPartition(p);

                    }
                    break;

            }

            // QSpecBuilder2.g:72:95: (o= orderby )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ORDER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // QSpecBuilder2.g:72:96: o= orderby
                    {
                    pushFollow(FOLLOW_orderby_in_tableSpec207);
                    o=orderby();
                    _fsp--;

                    t.setOrder(o);

                    }
                    break;

            }


            match(input, Token.UP, null); 
            qIn = t;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return qIn;
    }
    // $ANTLR end tableSpec


    // $ANTLR start hiveQuery
    // QSpecBuilder2.g:75:1: hiveQuery returns [QueryInputSpec hQSpec] : hq= HIVEQUERY ;
    public final QueryInputSpec hiveQuery() throws RecognitionException {
        QueryInputSpec hQSpec = null;

        CommonTree hq=null;

        try {
            // QSpecBuilder2.g:75:42: (hq= HIVEQUERY )
            // QSpecBuilder2.g:76:2: hq= HIVEQUERY
            {
            hq=(CommonTree)input.LT(1);
            match(input,HIVEQUERY,FOLLOW_HIVEQUERY_in_hiveQuery230); 
            hQSpec = new HiveQuerySpec(hq.getText());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return hQSpec;
    }
    // $ANTLR end hiveQuery


    // $ANTLR start hiveTable
    // QSpecBuilder2.g:79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );
    public final QueryInputSpec hiveTable() throws RecognitionException {
        QueryInputSpec hTSpec = null;

        CommonTree d=null;
        CommonTree t=null;

        try {
            // QSpecBuilder2.g:79:42: ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==HIVETBL) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==DOWN) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==Identifier) ) {
                        int LA10_3 = input.LA(4);

                        if ( (LA10_3==UP) ) {
                            alt10=2;
                        }
                        else if ( (LA10_3==Identifier) ) {
                            alt10=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );", 10, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // QSpecBuilder2.g:80:3: ^( HIVETBL d= Identifier t= Identifier )
                    {
                    match(input,HIVETBL,FOLLOW_HIVETBL_in_hiveTable248); 

                    match(input, Token.DOWN, null); 
                    d=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_hiveTable252); 
                    t=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_hiveTable256); 

                    match(input, Token.UP, null); 
                    hTSpec = new HiveTableSpec(d.getText(), t.getText());

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:81:3: ^( HIVETBL t= Identifier )
                    {
                    match(input,HIVETBL,FOLLOW_HIVETBL_in_hiveTable266); 

                    match(input, Token.DOWN, null); 
                    t=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_hiveTable270); 

                    match(input, Token.UP, null); 
                    hTSpec = new HiveTableSpec(null, t.getText());

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return hTSpec;
    }
    // $ANTLR end hiveTable


    // $ANTLR start tblfunc
    // QSpecBuilder2.g:84:1: tblfunc returns [QueryInputSpec qIn] : ^( TBLFUNCTION i= Identifier t= tableSpec (e= expression )* ) ;
    public final QueryInputSpec tblfunc() throws RecognitionException {
        QueryInputSpec qIn = null;

        CommonTree i=null;
        QueryInputSpec t = null;

        CommonTree e = null;



          TableFuncSpec tblFn = new TableFuncSpec();

        try {
            // QSpecBuilder2.g:89:2: ( ^( TBLFUNCTION i= Identifier t= tableSpec (e= expression )* ) )
            // QSpecBuilder2.g:90:3: ^( TBLFUNCTION i= Identifier t= tableSpec (e= expression )* )
            {
            match(input,TBLFUNCTION,FOLLOW_TBLFUNCTION_in_tblfunc295); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_tblfunc299); 
            pushFollow(FOLLOW_tableSpec_in_tblfunc303);
            t=tableSpec();
            _fsp--;

            // QSpecBuilder2.g:90:42: (e= expression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==FUNCTION||(LA11_0>=STRINGLITERALSEQUENCE && LA11_0<=CHARSETLITERAL)||(LA11_0>=FUNCTIONSTAR && LA11_0<=FUNCTIONDIST)||LA11_0==TABLEORCOL||LA11_0==DOT||(LA11_0>=EQUAL && LA11_0<=StringLiteral)||LA11_0==STAR||LA11_0==AND||LA11_0==Number||(LA11_0>=BigintLiteral && LA11_0<=TinyintLiteral)||(LA11_0>=OR && LA11_0<=GREATERTHAN)||(LA11_0>=BITWISEOR && LA11_0<=NULL)||(LA11_0>=TILDE && LA11_0<=LSQUARE)||(LA11_0>=TRUE && LA11_0<=FALSE)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // QSpecBuilder2.g:90:43: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_tblfunc308);
            	    e=expression();
            	    _fsp--;

            	    tblFn.addArg(e);

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match(input, Token.UP, null); 
            tblFn.setName(i.getText()); tblFn.setInput(t); qIn = tblFn; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return qIn;
    }
    // $ANTLR end tblfunc


    // $ANTLR start hdfsFile
    // QSpecBuilder2.g:93:1: hdfsFile returns [HdfsLocationSpec hLoc] : ^( HDFSLOCATION ( namevalue[hLoc] )* ) ;
    public final HdfsLocationSpec hdfsFile() throws RecognitionException {
        HdfsLocationSpec hLoc = null;


          hLoc = new HdfsLocationSpec();

        try {
            // QSpecBuilder2.g:97:1: ( ^( HDFSLOCATION ( namevalue[hLoc] )* ) )
            // QSpecBuilder2.g:98:2: ^( HDFSLOCATION ( namevalue[hLoc] )* )
            {
            match(input,HDFSLOCATION,FOLLOW_HDFSLOCATION_in_hdfsFile335); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // QSpecBuilder2.g:98:17: ( namevalue[hLoc] )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==PARAM) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // QSpecBuilder2.g:98:17: namevalue[hLoc]
                	    {
                	    pushFollow(FOLLOW_namevalue_in_hdfsFile337);
                	    namevalue(hLoc);
                	    _fsp--;


                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return hLoc;
    }
    // $ANTLR end hdfsFile


    // $ANTLR start where
    // QSpecBuilder2.g:101:1: where[QuerySpec qs] : ^( WHERE e= expression ) ;
    public final void where(QuerySpec qs) throws RecognitionException {
        CommonTree e = null;


        try {
            // QSpecBuilder2.g:101:21: ( ^( WHERE e= expression ) )
            // QSpecBuilder2.g:102:2: ^( WHERE e= expression )
            {
            match(input,WHERE,FOLLOW_WHERE_in_where353); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_where357);
            e=expression();
            _fsp--;


            match(input, Token.UP, null); 
            qs.setWhereExpr(e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end where


    // $ANTLR start outputClause
    // QSpecBuilder2.g:105:1: outputClause returns [QueryOutputSpec qOut] : ^( OUTPUTSPEC p= StringLiteral ( outputSerDe[qOut] )? ( loadClause[qOut] )? ) ;
    public final QueryOutputSpec outputClause() throws RecognitionException {
        QueryOutputSpec qOut = null;

        CommonTree p=null;


          qOut = new QueryOutputSpec();

        try {
            // QSpecBuilder2.g:108:2: ( ^( OUTPUTSPEC p= StringLiteral ( outputSerDe[qOut] )? ( loadClause[qOut] )? ) )
            // QSpecBuilder2.g:109:3: ^( OUTPUTSPEC p= StringLiteral ( outputSerDe[qOut] )? ( loadClause[qOut] )? )
            {
            match(input,OUTPUTSPEC,FOLLOW_OUTPUTSPEC_in_outputClause380); 

            match(input, Token.DOWN, null); 
            p=(CommonTree)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_outputClause384); 
            // QSpecBuilder2.g:109:32: ( outputSerDe[qOut] )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==SERDE) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // QSpecBuilder2.g:109:32: outputSerDe[qOut]
                    {
                    pushFollow(FOLLOW_outputSerDe_in_outputClause386);
                    outputSerDe(qOut);
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder2.g:109:51: ( loadClause[qOut] )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LOADSPEC) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // QSpecBuilder2.g:109:51: loadClause[qOut]
                    {
                    pushFollow(FOLLOW_loadClause_in_outputClause390);
                    loadClause(qOut);
                    _fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            qOut.setPath(p.getText());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return qOut;
    }
    // $ANTLR end outputClause


    // $ANTLR start outputSerDe
    // QSpecBuilder2.g:112:1: outputSerDe[QueryOutputSpec qOut] : ^( SERDE sd= StringLiteral outputFormatOrWriter[qOut] ( outputSerDePropeties[qOut] )? ) ;
    public final void outputSerDe(QueryOutputSpec qOut) throws RecognitionException {
        CommonTree sd=null;

        try {
            // QSpecBuilder2.g:112:35: ( ^( SERDE sd= StringLiteral outputFormatOrWriter[qOut] ( outputSerDePropeties[qOut] )? ) )
            // QSpecBuilder2.g:113:3: ^( SERDE sd= StringLiteral outputFormatOrWriter[qOut] ( outputSerDePropeties[qOut] )? )
            {
            match(input,SERDE,FOLLOW_SERDE_in_outputSerDe408); 

            match(input, Token.DOWN, null); 
            sd=(CommonTree)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_outputSerDe412); 
            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe414);
            outputFormatOrWriter(qOut);
            _fsp--;

            // QSpecBuilder2.g:113:55: ( outputSerDePropeties[qOut] )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==SERDEPROPERTIES) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // QSpecBuilder2.g:113:55: outputSerDePropeties[qOut]
                    {
                    pushFollow(FOLLOW_outputSerDePropeties_in_outputSerDe417);
                    outputSerDePropeties(qOut);
                    _fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            qOut.setSerDeClass(sd.getText());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end outputSerDe


    // $ANTLR start outputSerDePropeties
    // QSpecBuilder2.g:116:1: outputSerDePropeties[INameValueList properties] : ^( SERDEPROPERTIES ( namevalue[properties] )* ) ;
    public final void outputSerDePropeties(INameValueList properties) throws RecognitionException {
        try {
            // QSpecBuilder2.g:116:48: ( ^( SERDEPROPERTIES ( namevalue[properties] )* ) )
            // QSpecBuilder2.g:117:3: ^( SERDEPROPERTIES ( namevalue[properties] )* )
            {
            match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties434); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // QSpecBuilder2.g:117:21: ( namevalue[properties] )*
                loop16:
                do {
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==PARAM) ) {
                        alt16=1;
                    }


                    switch (alt16) {
                	case 1 :
                	    // QSpecBuilder2.g:117:21: namevalue[properties]
                	    {
                	    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties436);
                	    namevalue(properties);
                	    _fsp--;


                	    }
                	    break;

                	default :
                	    break loop16;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end outputSerDePropeties


    // $ANTLR start outputFormatOrWriter
    // QSpecBuilder2.g:120:1: outputFormatOrWriter[QueryOutputSpec qOut] : ( ^( RECORDWRITER rw= StringLiteral ) | ^( FORMAT of= StringLiteral ) );
    public final void outputFormatOrWriter(QueryOutputSpec qOut) throws RecognitionException {
        CommonTree rw=null;
        CommonTree of=null;

        try {
            // QSpecBuilder2.g:120:44: ( ^( RECORDWRITER rw= StringLiteral ) | ^( FORMAT of= StringLiteral ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RECORDWRITER) ) {
                alt17=1;
            }
            else if ( (LA17_0==FORMAT) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("120:1: outputFormatOrWriter[QueryOutputSpec qOut] : ( ^( RECORDWRITER rw= StringLiteral ) | ^( FORMAT of= StringLiteral ) );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // QSpecBuilder2.g:121:3: ^( RECORDWRITER rw= StringLiteral )
                    {
                    match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter452); 

                    match(input, Token.DOWN, null); 
                    rw=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_outputFormatOrWriter456); 

                    match(input, Token.UP, null); 
                    qOut.setRecordWriterClass(rw.getText());

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:122:3: ^( FORMAT of= StringLiteral )
                    {
                    match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter466); 

                    match(input, Token.DOWN, null); 
                    of=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_outputFormatOrWriter470); 

                    match(input, Token.UP, null); 
                    qOut.setOutputFormatClass(of.getText());

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end outputFormatOrWriter


    // $ANTLR start loadClause
    // QSpecBuilder2.g:125:1: loadClause[QueryOutputSpec qOut] : ^( LOADSPEC ht= Identifier (hp= StringLiteral )? (ow= OVERWRITE )? ) ;
    public final void loadClause(QueryOutputSpec qOut) throws RecognitionException {
        CommonTree ht=null;
        CommonTree hp=null;
        CommonTree ow=null;

        try {
            // QSpecBuilder2.g:125:33: ( ^( LOADSPEC ht= Identifier (hp= StringLiteral )? (ow= OVERWRITE )? ) )
            // QSpecBuilder2.g:126:3: ^( LOADSPEC ht= Identifier (hp= StringLiteral )? (ow= OVERWRITE )? )
            {
            match(input,LOADSPEC,FOLLOW_LOADSPEC_in_loadClause485); 

            match(input, Token.DOWN, null); 
            ht=(CommonTree)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_loadClause489); 
            // QSpecBuilder2.g:126:30: (hp= StringLiteral )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==StringLiteral) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // QSpecBuilder2.g:126:30: hp= StringLiteral
                    {
                    hp=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_loadClause493); 

                    }
                    break;

            }

            // QSpecBuilder2.g:126:48: (ow= OVERWRITE )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==OVERWRITE) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // QSpecBuilder2.g:126:48: ow= OVERWRITE
                    {
                    ow=(CommonTree)input.LT(1);
                    match(input,OVERWRITE,FOLLOW_OVERWRITE_in_loadClause498); 

                    }
                    break;

            }


            match(input, Token.UP, null); 

                qOut.setHiveTable(ht.getText());
                qOut.setPartitionClause(hp.getText());
                qOut.setOverwriteHiveTable(true);
              

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end loadClause


    // $ANTLR start window_function
    // QSpecBuilder2.g:133:1: window_function returns [WindowFunctionSpec wFn] : ( ^( WDW_FUNCTIONSTAR functionName (ws= window_specification )? ) | ^( WDW_FUNCTION functionName ( (e= expression )+ )? (ws= window_specification )? ) | ^( WDW_FUNCTIONDIST functionName ( (e= expression )+ )? (ws= window_specification )? ) );
    public final WindowFunctionSpec window_function() throws RecognitionException {
        WindowFunctionSpec wFn = null;

        WindowSpec ws = null;

        CommonTree e = null;

        functionName_return functionName1 = null;

        functionName_return functionName2 = null;

        functionName_return functionName3 = null;



          wFn = new WindowFunctionSpec();

        try {
            // QSpecBuilder2.g:137:3: ( ^( WDW_FUNCTIONSTAR functionName (ws= window_specification )? ) | ^( WDW_FUNCTION functionName ( (e= expression )+ )? (ws= window_specification )? ) | ^( WDW_FUNCTIONDIST functionName ( (e= expression )+ )? (ws= window_specification )? ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case WDW_FUNCTIONSTAR:
                {
                alt27=1;
                }
                break;
            case WDW_FUNCTION:
                {
                alt27=2;
                }
                break;
            case WDW_FUNCTIONDIST:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("133:1: window_function returns [WindowFunctionSpec wFn] : ( ^( WDW_FUNCTIONSTAR functionName (ws= window_specification )? ) | ^( WDW_FUNCTION functionName ( (e= expression )+ )? (ws= window_specification )? ) | ^( WDW_FUNCTIONDIST functionName ( (e= expression )+ )? (ws= window_specification )? ) );", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // QSpecBuilder2.g:138:3: ^( WDW_FUNCTIONSTAR functionName (ws= window_specification )? )
                    {
                    match(input,WDW_FUNCTIONSTAR,FOLLOW_WDW_FUNCTIONSTAR_in_window_function526); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_functionName_in_window_function528);
                    functionName1=functionName();
                    _fsp--;

                    // QSpecBuilder2.g:138:37: (ws= window_specification )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==WINDOWSPEC) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // QSpecBuilder2.g:138:37: ws= window_specification
                            {
                            pushFollow(FOLLOW_window_specification_in_window_function532);
                            ws=window_specification();
                            _fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    wFn.setName(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(functionName1.start),
                      input.getTreeAdaptor().getTokenStopIndex(functionName1.start))); wFn.setWindowSpec(ws); wFn.setStar(true);

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:139:3: ^( WDW_FUNCTION functionName ( (e= expression )+ )? (ws= window_specification )? )
                    {
                    match(input,WDW_FUNCTION,FOLLOW_WDW_FUNCTION_in_window_function543); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_functionName_in_window_function545);
                    functionName2=functionName();
                    _fsp--;

                    // QSpecBuilder2.g:139:31: ( (e= expression )+ )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==FUNCTION||(LA22_0>=STRINGLITERALSEQUENCE && LA22_0<=CHARSETLITERAL)||(LA22_0>=FUNCTIONSTAR && LA22_0<=FUNCTIONDIST)||LA22_0==TABLEORCOL||LA22_0==DOT||(LA22_0>=EQUAL && LA22_0<=StringLiteral)||LA22_0==STAR||LA22_0==AND||LA22_0==Number||(LA22_0>=BigintLiteral && LA22_0<=TinyintLiteral)||(LA22_0>=OR && LA22_0<=GREATERTHAN)||(LA22_0>=BITWISEOR && LA22_0<=NULL)||(LA22_0>=TILDE && LA22_0<=LSQUARE)||(LA22_0>=TRUE && LA22_0<=FALSE)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // QSpecBuilder2.g:139:32: (e= expression )+
                            {
                            // QSpecBuilder2.g:139:32: (e= expression )+
                            int cnt21=0;
                            loop21:
                            do {
                                int alt21=2;
                                int LA21_0 = input.LA(1);

                                if ( (LA21_0==FUNCTION||(LA21_0>=STRINGLITERALSEQUENCE && LA21_0<=CHARSETLITERAL)||(LA21_0>=FUNCTIONSTAR && LA21_0<=FUNCTIONDIST)||LA21_0==TABLEORCOL||LA21_0==DOT||(LA21_0>=EQUAL && LA21_0<=StringLiteral)||LA21_0==STAR||LA21_0==AND||LA21_0==Number||(LA21_0>=BigintLiteral && LA21_0<=TinyintLiteral)||(LA21_0>=OR && LA21_0<=GREATERTHAN)||(LA21_0>=BITWISEOR && LA21_0<=NULL)||(LA21_0>=TILDE && LA21_0<=LSQUARE)||(LA21_0>=TRUE && LA21_0<=FALSE)) ) {
                                    alt21=1;
                                }


                                switch (alt21) {
                            	case 1 :
                            	    // QSpecBuilder2.g:139:33: e= expression
                            	    {
                            	    pushFollow(FOLLOW_expression_in_window_function551);
                            	    e=expression();
                            	    _fsp--;

                            	    wFn.addArg(e);

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt21 >= 1 ) break loop21;
                                        EarlyExitException eee =
                                            new EarlyExitException(21, input);
                                        throw eee;
                                }
                                cnt21++;
                            } while (true);


                            }
                            break;

                    }

                    // QSpecBuilder2.g:139:69: (ws= window_specification )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==WINDOWSPEC) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // QSpecBuilder2.g:139:69: ws= window_specification
                            {
                            pushFollow(FOLLOW_window_specification_in_window_function560);
                            ws=window_specification();
                            _fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    wFn.setName(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(functionName2.start),
                      input.getTreeAdaptor().getTokenStopIndex(functionName2.start))); wFn.setWindowSpec(ws); 

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:140:3: ^( WDW_FUNCTIONDIST functionName ( (e= expression )+ )? (ws= window_specification )? )
                    {
                    match(input,WDW_FUNCTIONDIST,FOLLOW_WDW_FUNCTIONDIST_in_window_function571); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_functionName_in_window_function573);
                    functionName3=functionName();
                    _fsp--;

                    // QSpecBuilder2.g:140:35: ( (e= expression )+ )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==FUNCTION||(LA25_0>=STRINGLITERALSEQUENCE && LA25_0<=CHARSETLITERAL)||(LA25_0>=FUNCTIONSTAR && LA25_0<=FUNCTIONDIST)||LA25_0==TABLEORCOL||LA25_0==DOT||(LA25_0>=EQUAL && LA25_0<=StringLiteral)||LA25_0==STAR||LA25_0==AND||LA25_0==Number||(LA25_0>=BigintLiteral && LA25_0<=TinyintLiteral)||(LA25_0>=OR && LA25_0<=GREATERTHAN)||(LA25_0>=BITWISEOR && LA25_0<=NULL)||(LA25_0>=TILDE && LA25_0<=LSQUARE)||(LA25_0>=TRUE && LA25_0<=FALSE)) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // QSpecBuilder2.g:140:36: (e= expression )+
                            {
                            // QSpecBuilder2.g:140:36: (e= expression )+
                            int cnt24=0;
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==FUNCTION||(LA24_0>=STRINGLITERALSEQUENCE && LA24_0<=CHARSETLITERAL)||(LA24_0>=FUNCTIONSTAR && LA24_0<=FUNCTIONDIST)||LA24_0==TABLEORCOL||LA24_0==DOT||(LA24_0>=EQUAL && LA24_0<=StringLiteral)||LA24_0==STAR||LA24_0==AND||LA24_0==Number||(LA24_0>=BigintLiteral && LA24_0<=TinyintLiteral)||(LA24_0>=OR && LA24_0<=GREATERTHAN)||(LA24_0>=BITWISEOR && LA24_0<=NULL)||(LA24_0>=TILDE && LA24_0<=LSQUARE)||(LA24_0>=TRUE && LA24_0<=FALSE)) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // QSpecBuilder2.g:140:37: e= expression
                            	    {
                            	    pushFollow(FOLLOW_expression_in_window_function579);
                            	    e=expression();
                            	    _fsp--;

                            	    wFn.addArg(e);

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
                            break;

                    }

                    // QSpecBuilder2.g:140:73: (ws= window_specification )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==WINDOWSPEC) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // QSpecBuilder2.g:140:73: ws= window_specification
                            {
                            pushFollow(FOLLOW_window_specification_in_window_function588);
                            ws=window_specification();
                            _fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    wFn.setName(input.getTokenStream().toString(
                      input.getTreeAdaptor().getTokenStartIndex(functionName3.start),
                      input.getTreeAdaptor().getTokenStopIndex(functionName3.start))); wFn.setWindowSpec(ws); wFn.setDistinct(true); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return wFn;
    }
    // $ANTLR end window_function


    // $ANTLR start window_clause
    // QSpecBuilder2.g:143:1: window_clause[QuerySpec qs] : ^( WINDOW ( window_defn[qs] )+ ) ;
    public final void window_clause(QuerySpec qs) throws RecognitionException {
        try {
            // QSpecBuilder2.g:143:29: ( ^( WINDOW ( window_defn[qs] )+ ) )
            // QSpecBuilder2.g:144:3: ^( WINDOW ( window_defn[qs] )+ )
            {
            match(input,WINDOW,FOLLOW_WINDOW_in_window_clause607); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder2.g:144:12: ( window_defn[qs] )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==WINDOWDEF) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // QSpecBuilder2.g:144:12: window_defn[qs]
            	    {
            	    pushFollow(FOLLOW_window_defn_in_window_clause609);
            	    window_defn(qs);
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end window_clause


    // $ANTLR start window_defn
    // QSpecBuilder2.g:147:1: window_defn[QuerySpec qs] : ^( WINDOWDEF i= Identifier ws= window_specification ) ;
    public final void window_defn(QuerySpec qs) throws RecognitionException {
        CommonTree i=null;
        WindowSpec ws = null;


        try {
            // QSpecBuilder2.g:147:27: ( ^( WINDOWDEF i= Identifier ws= window_specification ) )
            // QSpecBuilder2.g:148:3: ^( WINDOWDEF i= Identifier ws= window_specification )
            {
            match(input,WINDOWDEF,FOLLOW_WINDOWDEF_in_window_defn627); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_window_defn631); 
            pushFollow(FOLLOW_window_specification_in_window_defn635);
            ws=window_specification();
            _fsp--;


            match(input, Token.UP, null); 
             qs.addWindowSpec(i.getText(), ws);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end window_defn


    // $ANTLR start window_specification
    // QSpecBuilder2.g:151:1: window_specification returns [WindowSpec ws] : ^( WINDOWSPEC (i= Identifier )? (p= partitionby )? (o= orderby )? (wf= window_frame )? ) ;
    public final WindowSpec window_specification() throws RecognitionException {
        WindowSpec ws = null;

        CommonTree i=null;
        PartitionSpec p = null;

        OrderSpec o = null;

        WindowFrameSpec wf = null;


        try {
            // QSpecBuilder2.g:151:45: ( ^( WINDOWSPEC (i= Identifier )? (p= partitionby )? (o= orderby )? (wf= window_frame )? ) )
            // QSpecBuilder2.g:152:3: ^( WINDOWSPEC (i= Identifier )? (p= partitionby )? (o= orderby )? (wf= window_frame )? )
            {
            match(input,WINDOWSPEC,FOLLOW_WINDOWSPEC_in_window_specification655); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // QSpecBuilder2.g:152:17: (i= Identifier )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==Identifier) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // QSpecBuilder2.g:152:17: i= Identifier
                        {
                        i=(CommonTree)input.LT(1);
                        match(input,Identifier,FOLLOW_Identifier_in_window_specification659); 

                        }
                        break;

                }

                // QSpecBuilder2.g:152:31: (p= partitionby )?
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==PARTITION) ) {
                    alt30=1;
                }
                switch (alt30) {
                    case 1 :
                        // QSpecBuilder2.g:152:31: p= partitionby
                        {
                        pushFollow(FOLLOW_partitionby_in_window_specification664);
                        p=partitionby();
                        _fsp--;


                        }
                        break;

                }

                // QSpecBuilder2.g:152:46: (o= orderby )?
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==ORDER) ) {
                    alt31=1;
                }
                switch (alt31) {
                    case 1 :
                        // QSpecBuilder2.g:152:46: o= orderby
                        {
                        pushFollow(FOLLOW_orderby_in_window_specification669);
                        o=orderby();
                        _fsp--;


                        }
                        break;

                }

                // QSpecBuilder2.g:152:58: (wf= window_frame )?
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=WINDOWRANGE && LA32_0<=WINDOWVALUES)) ) {
                    alt32=1;
                }
                switch (alt32) {
                    case 1 :
                        // QSpecBuilder2.g:152:58: wf= window_frame
                        {
                        pushFollow(FOLLOW_window_frame_in_window_specification674);
                        wf=window_frame();
                        _fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }
             ws = new WindowSpec(i != null ? i.getText() : null, p, o, wf);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ws;
    }
    // $ANTLR end window_specification


    // $ANTLR start orderby
    // QSpecBuilder2.g:155:1: orderby returns [OrderSpec os] : ^( ORDER (o= ordercolumn )+ ) ;
    public final OrderSpec orderby() throws RecognitionException {
        OrderSpec os = null;

        OrderColumnSpec o = null;



          os = new OrderSpec();

        try {
            // QSpecBuilder2.g:159:2: ( ^( ORDER (o= ordercolumn )+ ) )
            // QSpecBuilder2.g:160:2: ^( ORDER (o= ordercolumn )+ )
            {
            match(input,ORDER,FOLLOW_ORDER_in_orderby699); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder2.g:160:10: (o= ordercolumn )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==ORDERCOLUMN) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // QSpecBuilder2.g:160:11: o= ordercolumn
            	    {
            	    pushFollow(FOLLOW_ordercolumn_in_orderby704);
            	    o=ordercolumn();
            	    _fsp--;

            	    os.addColumn(o);

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return os;
    }
    // $ANTLR end orderby


    // $ANTLR start ordercolumn
    // QSpecBuilder2.g:163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );
    public final OrderColumnSpec ordercolumn() throws RecognitionException {
        OrderColumnSpec ocs = null;

        CommonTree o=null;
        ColumnSpec cr = null;


        try {
            // QSpecBuilder2.g:163:43: ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) )
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ORDERCOLUMN) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==DOWN) ) {
                    int LA34_2 = input.LA(3);

                    if ( (LA34_2==COLUMNREF) ) {
                        int LA34_3 = input.LA(4);

                        if ( (LA34_3==DOWN) ) {
                            int LA34_4 = input.LA(5);

                            if ( (LA34_4==Identifier) ) {
                                int LA34_5 = input.LA(6);

                                if ( (LA34_5==UP) ) {
                                    switch ( input.LA(7) ) {
                                    case ASC:
                                        {
                                        alt34=1;
                                        }
                                        break;
                                    case DESC:
                                        {
                                        alt34=2;
                                        }
                                        break;
                                    case UP:
                                        {
                                        alt34=3;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 6, input);

                                        throw nvae;
                                    }

                                }
                                else if ( (LA34_5==Identifier) ) {
                                    int LA34_7 = input.LA(7);

                                    if ( (LA34_7==UP) ) {
                                        switch ( input.LA(8) ) {
                                        case DESC:
                                            {
                                            alt34=2;
                                            }
                                            break;
                                        case UP:
                                            {
                                            alt34=3;
                                            }
                                            break;
                                        case ASC:
                                            {
                                            alt34=1;
                                            }
                                            break;
                                        default:
                                            NoViableAltException nvae =
                                                new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 11, input);

                                            throw nvae;
                                        }

                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 7, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // QSpecBuilder2.g:164:2: ^( ORDERCOLUMN cr= columnReference o= ASC )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn724); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_columnReference_in_ordercolumn728);
                    cr=columnReference();
                    _fsp--;

                    o=(CommonTree)input.LT(1);
                    match(input,ASC,FOLLOW_ASC_in_ordercolumn732); 

                    match(input, Token.UP, null); 
                    ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.ASC); 

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:165:2: ^( ORDERCOLUMN cr= columnReference DESC )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn740); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_columnReference_in_ordercolumn744);
                    cr=columnReference();
                    _fsp--;

                    match(input,DESC,FOLLOW_DESC_in_ordercolumn746); 

                    match(input, Token.UP, null); 
                    ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.DESC); 

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:166:2: ^( ORDERCOLUMN cr= columnReference )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn754); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_columnReference_in_ordercolumn758);
                    cr=columnReference();
                    _fsp--;


                    match(input, Token.UP, null); 
                    ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.ASC); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ocs;
    }
    // $ANTLR end ordercolumn


    // $ANTLR start partitionby
    // QSpecBuilder2.g:169:1: partitionby returns [PartitionSpec ps] : ^( PARTITION (cr= columnReference )+ ) ;
    public final PartitionSpec partitionby() throws RecognitionException {
        PartitionSpec ps = null;

        ColumnSpec cr = null;



          ps = new PartitionSpec();

        try {
            // QSpecBuilder2.g:173:3: ( ^( PARTITION (cr= columnReference )+ ) )
            // QSpecBuilder2.g:174:2: ^( PARTITION (cr= columnReference )+ )
            {
            match(input,PARTITION,FOLLOW_PARTITION_in_partitionby784); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder2.g:174:14: (cr= columnReference )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==COLUMNREF) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // QSpecBuilder2.g:174:15: cr= columnReference
            	    {
            	    pushFollow(FOLLOW_columnReference_in_partitionby789);
            	    cr=columnReference();
            	    _fsp--;

            	    ps.addColumn(cr);

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ps;
    }
    // $ANTLR end partitionby


    // $ANTLR start window_frame
    // QSpecBuilder2.g:177:1: window_frame returns [WindowFrameSpec wf] : (w= window_range_expression | w= window_value_expression );
    public final WindowFrameSpec window_frame() throws RecognitionException {
        WindowFrameSpec wf = null;

        WindowFrameSpec w = null;


        try {
            // QSpecBuilder2.g:177:42: (w= window_range_expression | w= window_value_expression )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==WINDOWRANGE) ) {
                alt36=1;
            }
            else if ( (LA36_0==WINDOWVALUES) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("177:1: window_frame returns [WindowFrameSpec wf] : (w= window_range_expression | w= window_value_expression );", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // QSpecBuilder2.g:178:2: w= window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_frame809);
                    w=window_range_expression();
                    _fsp--;

                    wf = w;

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:179:2: w= window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_frame818);
                    w=window_value_expression();
                    _fsp--;

                    wf = w;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return wf;
    }
    // $ANTLR end window_frame


    // $ANTLR start window_range_expression
    // QSpecBuilder2.g:182:1: window_range_expression returns [WindowFrameSpec wf] : ^( WINDOWRANGE s= rowsboundary e= rowsboundary ) ;
    public final WindowFrameSpec window_range_expression() throws RecognitionException {
        WindowFrameSpec wf = null;

        BoundarySpec s = null;

        BoundarySpec e = null;


        try {
            // QSpecBuilder2.g:182:54: ( ^( WINDOWRANGE s= rowsboundary e= rowsboundary ) )
            // QSpecBuilder2.g:183:2: ^( WINDOWRANGE s= rowsboundary e= rowsboundary )
            {
            match(input,WINDOWRANGE,FOLLOW_WINDOWRANGE_in_window_range_expression835); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_rowsboundary_in_window_range_expression839);
            s=rowsboundary();
            _fsp--;

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression843);
            e=rowsboundary();
            _fsp--;


            match(input, Token.UP, null); 
            wf = new WindowFrameSpec(s,e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return wf;
    }
    // $ANTLR end window_range_expression


    // $ANTLR start rowsboundary
    // QSpecBuilder2.g:186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );
    public final BoundarySpec rowsboundary() throws RecognitionException {
        BoundarySpec bs = null;

        CommonTree n=null;


          RangeBoundarySpec rbs = new RangeBoundarySpec();
          bs = rbs;

        try {
            // QSpecBuilder2.g:191:3: ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) )
            int alt37=5;
            switch ( input.LA(1) ) {
            case PRECEDING:
                {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==DOWN) ) {
                    int LA37_4 = input.LA(3);

                    if ( (LA37_4==UNBOUNDED) ) {
                        alt37=1;
                    }
                    else if ( (LA37_4==Number) ) {
                        alt37=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );", 37, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );", 37, 1, input);

                    throw nvae;
                }
                }
                break;
            case FOLLOWING:
                {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==DOWN) ) {
                    int LA37_5 = input.LA(3);

                    if ( (LA37_5==Number) ) {
                        alt37=5;
                    }
                    else if ( (LA37_5==UNBOUNDED) ) {
                        alt37=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );", 37, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );", 37, 2, input);

                    throw nvae;
                }
                }
                break;
            case CURRENT:
                {
                alt37=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // QSpecBuilder2.g:192:3: ^( PRECEDING UNBOUNDED )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary870); 

                    match(input, Token.DOWN, null); 
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary872); 

                    match(input, Token.UP, null); 
                    rbs.setDirection(Direction.PRECEDING); rbs.setAmt(BoundarySpec.UNBOUNDED_AMOUNT);

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:193:3: ^( FOLLOWING UNBOUNDED )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary883); 

                    match(input, Token.DOWN, null); 
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary885); 

                    match(input, Token.UP, null); 
                    rbs.setDirection(Direction.FOLLOWING); rbs.setAmt(BoundarySpec.UNBOUNDED_AMOUNT);

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:194:3: CURRENT
                    {
                    match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary894); 
                    bs = new CurrentRowSpec();

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:195:3: ^( PRECEDING n= Number )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary903); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_rowsboundary907); 

                    match(input, Token.UP, null); 
                    rbs.setDirection(Direction.PRECEDING); rbs.setAmt(Integer.parseInt(n.getText()));

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:196:3: ^( FOLLOWING n= Number )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary917); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_rowsboundary921); 

                    match(input, Token.UP, null); 
                    rbs.setDirection(Direction.FOLLOWING); rbs.setAmt(Integer.parseInt(n.getText()));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return bs;
    }
    // $ANTLR end rowsboundary


    // $ANTLR start window_value_expression
    // QSpecBuilder2.g:199:1: window_value_expression returns [WindowFrameSpec wf] : ^( WINDOWVALUES s= valuesboundary e= valuesboundary ) ;
    public final WindowFrameSpec window_value_expression() throws RecognitionException {
        WindowFrameSpec wf = null;

        BoundarySpec s = null;

        BoundarySpec e = null;


        try {
            // QSpecBuilder2.g:199:54: ( ^( WINDOWVALUES s= valuesboundary e= valuesboundary ) )
            // QSpecBuilder2.g:200:2: ^( WINDOWVALUES s= valuesboundary e= valuesboundary )
            {
            match(input,WINDOWVALUES,FOLLOW_WINDOWVALUES_in_window_value_expression939); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_valuesboundary_in_window_value_expression943);
            s=valuesboundary();
            _fsp--;

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression947);
            e=valuesboundary();
            _fsp--;


            match(input, Token.UP, null); 
            wf = new WindowFrameSpec(s,e);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return wf;
    }
    // $ANTLR end window_value_expression


    // $ANTLR start valuesboundary
    // QSpecBuilder2.g:203:1: valuesboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( LESS e= expression n= Number ) | ^( MORE e= expression n= Number ) );
    public final BoundarySpec valuesboundary() throws RecognitionException {
        BoundarySpec bs = null;

        CommonTree n=null;
        CommonTree e = null;


        try {
            // QSpecBuilder2.g:203:42: ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( LESS e= expression n= Number ) | ^( MORE e= expression n= Number ) )
            int alt38=5;
            switch ( input.LA(1) ) {
            case PRECEDING:
                {
                alt38=1;
                }
                break;
            case FOLLOWING:
                {
                alt38=2;
                }
                break;
            case CURRENT:
                {
                alt38=3;
                }
                break;
            case LESS:
                {
                alt38=4;
                }
                break;
            case MORE:
                {
                alt38=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("203:1: valuesboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( LESS e= expression n= Number ) | ^( MORE e= expression n= Number ) );", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // QSpecBuilder2.g:204:3: ^( PRECEDING UNBOUNDED )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary966); 

                    match(input, Token.DOWN, null); 
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary968); 

                    match(input, Token.UP, null); 
                    bs = new ValueBoundarySpec(Direction.PRECEDING, null, BoundarySpec.UNBOUNDED_AMOUNT);

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:205:3: ^( FOLLOWING UNBOUNDED )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary979); 

                    match(input, Token.DOWN, null); 
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary981); 

                    match(input, Token.UP, null); 
                    bs = new ValueBoundarySpec(Direction.FOLLOWING, null, BoundarySpec.UNBOUNDED_AMOUNT);

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:206:3: CURRENT
                    {
                    match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary990); 
                    bs = new CurrentRowSpec();

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:207:3: ^( LESS e= expression n= Number )
                    {
                    match(input,LESS,FOLLOW_LESS_in_valuesboundary999); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_valuesboundary1003);
                    e=expression();
                    _fsp--;

                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_valuesboundary1007); 

                    match(input, Token.UP, null); 
                    bs = new ValueBoundarySpec(Direction.PRECEDING, e, Integer.parseInt(n.getText()));

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:208:3: ^( MORE e= expression n= Number )
                    {
                    match(input,MORE,FOLLOW_MORE_in_valuesboundary1017); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_valuesboundary1021);
                    e=expression();
                    _fsp--;

                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_valuesboundary1025); 

                    match(input, Token.UP, null); 
                    bs = new ValueBoundarySpec(Direction.PRECEDING, e, Integer.parseInt(n.getText()));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return bs;
    }
    // $ANTLR end valuesboundary


    // $ANTLR start columnReference
    // QSpecBuilder2.g:211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );
    public final ColumnSpec columnReference() throws RecognitionException {
        ColumnSpec cs = null;

        CommonTree t=null;
        CommonTree c=null;

        try {
            // QSpecBuilder2.g:211:40: ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==COLUMNREF) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==DOWN) ) {
                    int LA39_2 = input.LA(3);

                    if ( (LA39_2==Identifier) ) {
                        int LA39_3 = input.LA(4);

                        if ( (LA39_3==UP) ) {
                            alt39=2;
                        }
                        else if ( (LA39_3==Identifier) ) {
                            alt39=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );", 39, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );", 39, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );", 39, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // QSpecBuilder2.g:212:3: ^( COLUMNREF t= Identifier c= Identifier )
                    {
                    match(input,COLUMNREF,FOLLOW_COLUMNREF_in_columnReference1043); 

                    match(input, Token.DOWN, null); 
                    t=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_columnReference1047); 
                    c=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_columnReference1051); 

                    match(input, Token.UP, null); 
                    cs = new ColumnSpec(t.getText(),c.getText());

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:213:3: ^( COLUMNREF t= Identifier )
                    {
                    match(input,COLUMNREF,FOLLOW_COLUMNREF_in_columnReference1061); 

                    match(input, Token.DOWN, null); 
                    t=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_columnReference1065); 

                    match(input, Token.UP, null); 
                    cs = new ColumnSpec(null,t.getText());

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cs;
    }
    // $ANTLR end columnReference


    // $ANTLR start tableOrColumn
    // QSpecBuilder2.g:217:1: tableOrColumn returns [CommonTree tr] : ^(tc= TABLEORCOL Identifier ) ;
    public final CommonTree tableOrColumn() throws RecognitionException {
        CommonTree tr = null;

        CommonTree tc=null;

        try {
            // QSpecBuilder2.g:218:1: ( ^(tc= TABLEORCOL Identifier ) )
            // QSpecBuilder2.g:219:3: ^(tc= TABLEORCOL Identifier )
            {
            tc=(CommonTree)input.LT(1);
            match(input,TABLEORCOL,FOLLOW_TABLEORCOL_in_tableOrColumn1090); 

            match(input, Token.DOWN, null); 
            match(input,Identifier,FOLLOW_Identifier_in_tableOrColumn1092); 

            match(input, Token.UP, null); 
            tr =tc;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end tableOrColumn


    // $ANTLR start function
    // QSpecBuilder2.g:223:1: function returns [CommonTree tr] : ( ^(fs= FUNCTIONSTAR functionName ) | ^(f= FUNCTION functionName ( ( expression )+ )? ) | ^(fd= FUNCTIONDIST functionName ( ( expression )+ )? ) );
    public final CommonTree function() throws RecognitionException {
        CommonTree tr = null;

        CommonTree fs=null;
        CommonTree f=null;
        CommonTree fd=null;

        try {
            // QSpecBuilder2.g:224:1: ( ^(fs= FUNCTIONSTAR functionName ) | ^(f= FUNCTION functionName ( ( expression )+ )? ) | ^(fd= FUNCTIONDIST functionName ( ( expression )+ )? ) )
            int alt44=3;
            switch ( input.LA(1) ) {
            case FUNCTIONSTAR:
                {
                alt44=1;
                }
                break;
            case FUNCTION:
                {
                alt44=2;
                }
                break;
            case FUNCTIONDIST:
                {
                alt44=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("223:1: function returns [CommonTree tr] : ( ^(fs= FUNCTIONSTAR functionName ) | ^(f= FUNCTION functionName ( ( expression )+ )? ) | ^(fd= FUNCTIONDIST functionName ( ( expression )+ )? ) );", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // QSpecBuilder2.g:225:3: ^(fs= FUNCTIONSTAR functionName )
                    {
                    fs=(CommonTree)input.LT(1);
                    match(input,FUNCTIONSTAR,FOLLOW_FUNCTIONSTAR_in_function1116); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_functionName_in_function1118);
                    functionName();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =fs;

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:226:3: ^(f= FUNCTION functionName ( ( expression )+ )? )
                    {
                    f=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_function1131); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_functionName_in_function1133);
                    functionName();
                    _fsp--;

                    // QSpecBuilder2.g:226:29: ( ( expression )+ )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==FUNCTION||(LA41_0>=STRINGLITERALSEQUENCE && LA41_0<=CHARSETLITERAL)||(LA41_0>=FUNCTIONSTAR && LA41_0<=FUNCTIONDIST)||LA41_0==TABLEORCOL||LA41_0==DOT||(LA41_0>=EQUAL && LA41_0<=StringLiteral)||LA41_0==STAR||LA41_0==AND||LA41_0==Number||(LA41_0>=BigintLiteral && LA41_0<=TinyintLiteral)||(LA41_0>=OR && LA41_0<=GREATERTHAN)||(LA41_0>=BITWISEOR && LA41_0<=NULL)||(LA41_0>=TILDE && LA41_0<=LSQUARE)||(LA41_0>=TRUE && LA41_0<=FALSE)) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // QSpecBuilder2.g:226:30: ( expression )+
                            {
                            // QSpecBuilder2.g:226:30: ( expression )+
                            int cnt40=0;
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( (LA40_0==FUNCTION||(LA40_0>=STRINGLITERALSEQUENCE && LA40_0<=CHARSETLITERAL)||(LA40_0>=FUNCTIONSTAR && LA40_0<=FUNCTIONDIST)||LA40_0==TABLEORCOL||LA40_0==DOT||(LA40_0>=EQUAL && LA40_0<=StringLiteral)||LA40_0==STAR||LA40_0==AND||LA40_0==Number||(LA40_0>=BigintLiteral && LA40_0<=TinyintLiteral)||(LA40_0>=OR && LA40_0<=GREATERTHAN)||(LA40_0>=BITWISEOR && LA40_0<=NULL)||(LA40_0>=TILDE && LA40_0<=LSQUARE)||(LA40_0>=TRUE && LA40_0<=FALSE)) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // QSpecBuilder2.g:226:30: expression
                            	    {
                            	    pushFollow(FOLLOW_expression_in_function1136);
                            	    expression();
                            	    _fsp--;


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt40 >= 1 ) break loop40;
                                        EarlyExitException eee =
                                            new EarlyExitException(40, input);
                                        throw eee;
                                }
                                cnt40++;
                            } while (true);


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    tr =f;

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:227:3: ^(fd= FUNCTIONDIST functionName ( ( expression )+ )? )
                    {
                    fd=(CommonTree)input.LT(1);
                    match(input,FUNCTIONDIST,FOLLOW_FUNCTIONDIST_in_function1151); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_functionName_in_function1153);
                    functionName();
                    _fsp--;

                    // QSpecBuilder2.g:227:34: ( ( expression )+ )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==FUNCTION||(LA43_0>=STRINGLITERALSEQUENCE && LA43_0<=CHARSETLITERAL)||(LA43_0>=FUNCTIONSTAR && LA43_0<=FUNCTIONDIST)||LA43_0==TABLEORCOL||LA43_0==DOT||(LA43_0>=EQUAL && LA43_0<=StringLiteral)||LA43_0==STAR||LA43_0==AND||LA43_0==Number||(LA43_0>=BigintLiteral && LA43_0<=TinyintLiteral)||(LA43_0>=OR && LA43_0<=GREATERTHAN)||(LA43_0>=BITWISEOR && LA43_0<=NULL)||(LA43_0>=TILDE && LA43_0<=LSQUARE)||(LA43_0>=TRUE && LA43_0<=FALSE)) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // QSpecBuilder2.g:227:35: ( expression )+
                            {
                            // QSpecBuilder2.g:227:35: ( expression )+
                            int cnt42=0;
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==FUNCTION||(LA42_0>=STRINGLITERALSEQUENCE && LA42_0<=CHARSETLITERAL)||(LA42_0>=FUNCTIONSTAR && LA42_0<=FUNCTIONDIST)||LA42_0==TABLEORCOL||LA42_0==DOT||(LA42_0>=EQUAL && LA42_0<=StringLiteral)||LA42_0==STAR||LA42_0==AND||LA42_0==Number||(LA42_0>=BigintLiteral && LA42_0<=TinyintLiteral)||(LA42_0>=OR && LA42_0<=GREATERTHAN)||(LA42_0>=BITWISEOR && LA42_0<=NULL)||(LA42_0>=TILDE && LA42_0<=LSQUARE)||(LA42_0>=TRUE && LA42_0<=FALSE)) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // QSpecBuilder2.g:227:35: expression
                            	    {
                            	    pushFollow(FOLLOW_expression_in_function1156);
                            	    expression();
                            	    _fsp--;


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt42 >= 1 ) break loop42;
                                        EarlyExitException eee =
                                            new EarlyExitException(42, input);
                                        throw eee;
                                }
                                cnt42++;
                            } while (true);


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    tr =fd;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end function

    public static class functionName_return extends TreeRuleReturnScope {
    };

    // $ANTLR start functionName
    // QSpecBuilder2.g:230:1: functionName : ( Identifier | IF | ARRAY | MAP | STRUCT | UNION );
    public final functionName_return functionName() throws RecognitionException {
        functionName_return retval = new functionName_return();
        retval.start = input.LT(1);

        try {
            // QSpecBuilder2.g:231:3: ( Identifier | IF | ARRAY | MAP | STRUCT | UNION )
            // QSpecBuilder2.g:
            {
            if ( input.LA(1)==Identifier||(input.LA(1)>=IF && input.LA(1)<=UNION) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_functionName0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end functionName


    // $ANTLR start castExpr
    // QSpecBuilder2.g:235:1: castExpr returns [CommonTree tr] : ^(f= FUNCTION primitiveType expression ) ;
    public final CommonTree castExpr() throws RecognitionException {
        CommonTree tr = null;

        CommonTree f=null;

        try {
            // QSpecBuilder2.g:235:34: ( ^(f= FUNCTION primitiveType expression ) )
            // QSpecBuilder2.g:236:3: ^(f= FUNCTION primitiveType expression )
            {
            f=(CommonTree)input.LT(1);
            match(input,FUNCTION,FOLLOW_FUNCTION_in_castExpr1240); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_primitiveType_in_castExpr1242);
            primitiveType();
            _fsp--;

            pushFollow(FOLLOW_expression_in_castExpr1244);
            expression();
            _fsp--;


            match(input, Token.UP, null); 
            tr = f;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end castExpr


    // $ANTLR start caseExpr
    // QSpecBuilder2.g:239:1: caseExpr returns [CommonTree tr] : ^(f= FUNCTION CASE ( expression )* ) ;
    public final CommonTree caseExpr() throws RecognitionException {
        CommonTree tr = null;

        CommonTree f=null;

        try {
            // QSpecBuilder2.g:239:34: ( ^(f= FUNCTION CASE ( expression )* ) )
            // QSpecBuilder2.g:240:3: ^(f= FUNCTION CASE ( expression )* )
            {
            f=(CommonTree)input.LT(1);
            match(input,FUNCTION,FOLLOW_FUNCTION_in_caseExpr1265); 

            match(input, Token.DOWN, null); 
            match(input,CASE,FOLLOW_CASE_in_caseExpr1267); 
            // QSpecBuilder2.g:240:21: ( expression )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==FUNCTION||(LA45_0>=STRINGLITERALSEQUENCE && LA45_0<=CHARSETLITERAL)||(LA45_0>=FUNCTIONSTAR && LA45_0<=FUNCTIONDIST)||LA45_0==TABLEORCOL||LA45_0==DOT||(LA45_0>=EQUAL && LA45_0<=StringLiteral)||LA45_0==STAR||LA45_0==AND||LA45_0==Number||(LA45_0>=BigintLiteral && LA45_0<=TinyintLiteral)||(LA45_0>=OR && LA45_0<=GREATERTHAN)||(LA45_0>=BITWISEOR && LA45_0<=NULL)||(LA45_0>=TILDE && LA45_0<=LSQUARE)||(LA45_0>=TRUE && LA45_0<=FALSE)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // QSpecBuilder2.g:240:21: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_caseExpr1269);
            	    expression();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            match(input, Token.UP, null); 
            tr = f;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end caseExpr


    // $ANTLR start whenExpr
    // QSpecBuilder2.g:243:1: whenExpr returns [CommonTree tr] : ^(f= FUNCTION WHEN ( expression )* ) ;
    public final CommonTree whenExpr() throws RecognitionException {
        CommonTree tr = null;

        CommonTree f=null;

        try {
            // QSpecBuilder2.g:243:35: ( ^(f= FUNCTION WHEN ( expression )* ) )
            // QSpecBuilder2.g:244:3: ^(f= FUNCTION WHEN ( expression )* )
            {
            f=(CommonTree)input.LT(1);
            match(input,FUNCTION,FOLLOW_FUNCTION_in_whenExpr1293); 

            match(input, Token.DOWN, null); 
            match(input,WHEN,FOLLOW_WHEN_in_whenExpr1295); 
            // QSpecBuilder2.g:244:21: ( expression )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==FUNCTION||(LA46_0>=STRINGLITERALSEQUENCE && LA46_0<=CHARSETLITERAL)||(LA46_0>=FUNCTIONSTAR && LA46_0<=FUNCTIONDIST)||LA46_0==TABLEORCOL||LA46_0==DOT||(LA46_0>=EQUAL && LA46_0<=StringLiteral)||LA46_0==STAR||LA46_0==AND||LA46_0==Number||(LA46_0>=BigintLiteral && LA46_0<=TinyintLiteral)||(LA46_0>=OR && LA46_0<=GREATERTHAN)||(LA46_0>=BITWISEOR && LA46_0<=NULL)||(LA46_0>=TILDE && LA46_0<=LSQUARE)||(LA46_0>=TRUE && LA46_0<=FALSE)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // QSpecBuilder2.g:244:21: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_whenExpr1297);
            	    expression();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            match(input, Token.UP, null); 
            tr = f;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end whenExpr


    // $ANTLR start constant
    // QSpecBuilder2.g:247:1: constant returns [CommonTree tr] : (n= Number | s= StringLiteral | sls= stringLiteralSequence | bl= BigintLiteral | sl= SmallintLiteral | tl= TinyintLiteral | csl= charSetStringLiteral | bv= booleanValue );
    public final CommonTree constant() throws RecognitionException {
        CommonTree tr = null;

        CommonTree n=null;
        CommonTree s=null;
        CommonTree bl=null;
        CommonTree sl=null;
        CommonTree tl=null;
        CommonTree sls = null;

        CommonTree csl = null;

        CommonTree bv = null;


        try {
            // QSpecBuilder2.g:247:34: (n= Number | s= StringLiteral | sls= stringLiteralSequence | bl= BigintLiteral | sl= SmallintLiteral | tl= TinyintLiteral | csl= charSetStringLiteral | bv= booleanValue )
            int alt47=8;
            switch ( input.LA(1) ) {
            case Number:
                {
                alt47=1;
                }
                break;
            case StringLiteral:
                {
                alt47=2;
                }
                break;
            case STRINGLITERALSEQUENCE:
                {
                alt47=3;
                }
                break;
            case BigintLiteral:
                {
                alt47=4;
                }
                break;
            case SmallintLiteral:
                {
                alt47=5;
                }
                break;
            case TinyintLiteral:
                {
                alt47=6;
                }
                break;
            case CHARSETLITERAL:
                {
                alt47=7;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt47=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("247:1: constant returns [CommonTree tr] : (n= Number | s= StringLiteral | sls= stringLiteralSequence | bl= BigintLiteral | sl= SmallintLiteral | tl= TinyintLiteral | csl= charSetStringLiteral | bv= booleanValue );", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // QSpecBuilder2.g:248:3: n= Number
                    {
                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_constant1318); 
                     tr = n; 

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:249:5: s= StringLiteral
                    {
                    s=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_constant1328); 
                     tr = s; 

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:250:5: sls= stringLiteralSequence
                    {
                    pushFollow(FOLLOW_stringLiteralSequence_in_constant1338);
                    sls=stringLiteralSequence();
                    _fsp--;

                     tr = sls; 

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:251:5: bl= BigintLiteral
                    {
                    bl=(CommonTree)input.LT(1);
                    match(input,BigintLiteral,FOLLOW_BigintLiteral_in_constant1348); 
                     tr = bl; 

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:252:5: sl= SmallintLiteral
                    {
                    sl=(CommonTree)input.LT(1);
                    match(input,SmallintLiteral,FOLLOW_SmallintLiteral_in_constant1358); 
                     tr = sl; 

                    }
                    break;
                case 6 :
                    // QSpecBuilder2.g:253:5: tl= TinyintLiteral
                    {
                    tl=(CommonTree)input.LT(1);
                    match(input,TinyintLiteral,FOLLOW_TinyintLiteral_in_constant1368); 
                     tr = tl; 

                    }
                    break;
                case 7 :
                    // QSpecBuilder2.g:254:5: csl= charSetStringLiteral
                    {
                    pushFollow(FOLLOW_charSetStringLiteral_in_constant1378);
                    csl=charSetStringLiteral();
                    _fsp--;

                     tr = csl; 

                    }
                    break;
                case 8 :
                    // QSpecBuilder2.g:255:5: bv= booleanValue
                    {
                    pushFollow(FOLLOW_booleanValue_in_constant1388);
                    bv=booleanValue();
                    _fsp--;

                     tr = bv; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end constant


    // $ANTLR start stringLiteralSequence
    // QSpecBuilder2.g:258:1: stringLiteralSequence returns [CommonTree tr] : ^(s= STRINGLITERALSEQUENCE StringLiteral ( StringLiteral )+ ) ;
    public final CommonTree stringLiteralSequence() throws RecognitionException {
        CommonTree tr = null;

        CommonTree s=null;

        try {
            // QSpecBuilder2.g:258:47: ( ^(s= STRINGLITERALSEQUENCE StringLiteral ( StringLiteral )+ ) )
            // QSpecBuilder2.g:259:5: ^(s= STRINGLITERALSEQUENCE StringLiteral ( StringLiteral )+ )
            {
            s=(CommonTree)input.LT(1);
            match(input,STRINGLITERALSEQUENCE,FOLLOW_STRINGLITERALSEQUENCE_in_stringLiteralSequence1410); 

            match(input, Token.DOWN, null); 
            match(input,StringLiteral,FOLLOW_StringLiteral_in_stringLiteralSequence1412); 
            // QSpecBuilder2.g:259:45: ( StringLiteral )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==StringLiteral) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // QSpecBuilder2.g:259:45: StringLiteral
            	    {
            	    match(input,StringLiteral,FOLLOW_StringLiteral_in_stringLiteralSequence1414); 

            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);


            match(input, Token.UP, null); 
             tr = s; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end stringLiteralSequence


    // $ANTLR start charSetStringLiteral
    // QSpecBuilder2.g:262:1: charSetStringLiteral returns [CommonTree tr] : ^(c= CHARSETLITERAL CharSetName CharSetLiteral ) ;
    public final CommonTree charSetStringLiteral() throws RecognitionException {
        CommonTree tr = null;

        CommonTree c=null;

        try {
            // QSpecBuilder2.g:262:46: ( ^(c= CHARSETLITERAL CharSetName CharSetLiteral ) )
            // QSpecBuilder2.g:263:5: ^(c= CHARSETLITERAL CharSetName CharSetLiteral )
            {
            c=(CommonTree)input.LT(1);
            match(input,CHARSETLITERAL,FOLLOW_CHARSETLITERAL_in_charSetStringLiteral1438); 

            match(input, Token.DOWN, null); 
            match(input,CharSetName,FOLLOW_CharSetName_in_charSetStringLiteral1440); 
            match(input,CharSetLiteral,FOLLOW_CharSetLiteral_in_charSetStringLiteral1442); 

            match(input, Token.UP, null); 
             tr = c; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end charSetStringLiteral


    // $ANTLR start expressions
    // QSpecBuilder2.g:266:1: expressions : ( expression )* ;
    public final void expressions() throws RecognitionException {
        try {
            // QSpecBuilder2.g:266:13: ( ( expression )* )
            // QSpecBuilder2.g:267:3: ( expression )*
            {
            // QSpecBuilder2.g:267:3: ( expression )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==FUNCTION||(LA49_0>=STRINGLITERALSEQUENCE && LA49_0<=CHARSETLITERAL)||(LA49_0>=FUNCTIONSTAR && LA49_0<=FUNCTIONDIST)||LA49_0==TABLEORCOL||LA49_0==DOT||(LA49_0>=EQUAL && LA49_0<=StringLiteral)||LA49_0==STAR||LA49_0==AND||LA49_0==Number||(LA49_0>=BigintLiteral && LA49_0<=TinyintLiteral)||(LA49_0>=OR && LA49_0<=GREATERTHAN)||(LA49_0>=BITWISEOR && LA49_0<=NULL)||(LA49_0>=TILDE && LA49_0<=LSQUARE)||(LA49_0>=TRUE && LA49_0<=FALSE)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // QSpecBuilder2.g:267:3: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_expressions1456);
            	    expression();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end expressions


    // $ANTLR start negatableOperator
    // QSpecBuilder2.g:270:1: negatableOperator returns [CommonTree tr] : (l= LIKE | rl= RLIKE | rexp= REGEXP );
    public final CommonTree negatableOperator() throws RecognitionException {
        CommonTree tr = null;

        CommonTree l=null;
        CommonTree rl=null;
        CommonTree rexp=null;

        try {
            // QSpecBuilder2.g:270:43: (l= LIKE | rl= RLIKE | rexp= REGEXP )
            int alt50=3;
            switch ( input.LA(1) ) {
            case LIKE:
                {
                alt50=1;
                }
                break;
            case RLIKE:
                {
                alt50=2;
                }
                break;
            case REGEXP:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("270:1: negatableOperator returns [CommonTree tr] : (l= LIKE | rl= RLIKE | rexp= REGEXP );", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // QSpecBuilder2.g:271:3: l= LIKE
                    {
                    l=(CommonTree)input.LT(1);
                    match(input,LIKE,FOLLOW_LIKE_in_negatableOperator1474); 
                    tr =l;

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:272:3: rl= RLIKE
                    {
                    rl=(CommonTree)input.LT(1);
                    match(input,RLIKE,FOLLOW_RLIKE_in_negatableOperator1485); 
                    tr =rl;

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:273:3: rexp= REGEXP
                    {
                    rexp=(CommonTree)input.LT(1);
                    match(input,REGEXP,FOLLOW_REGEXP_in_negatableOperator1496); 
                    tr =rexp;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end negatableOperator


    // $ANTLR start compareOperator
    // QSpecBuilder2.g:276:1: compareOperator returns [CommonTree tr] : (n= negatableOperator | e= EQUAL | en= EQUAL_NS | nte= NOTEQUAL | lte= LESSTHANOREQUALTO | lt= LESSTHAN | gte= GREATERTHANOREQUALTO | gt= GREATERTHAN );
    public final CommonTree compareOperator() throws RecognitionException {
        CommonTree tr = null;

        CommonTree e=null;
        CommonTree en=null;
        CommonTree nte=null;
        CommonTree lte=null;
        CommonTree lt=null;
        CommonTree gte=null;
        CommonTree gt=null;
        CommonTree n = null;


        try {
            // QSpecBuilder2.g:276:41: (n= negatableOperator | e= EQUAL | en= EQUAL_NS | nte= NOTEQUAL | lte= LESSTHANOREQUALTO | lt= LESSTHAN | gte= GREATERTHANOREQUALTO | gt= GREATERTHAN )
            int alt51=8;
            switch ( input.LA(1) ) {
            case LIKE:
            case RLIKE:
            case REGEXP:
                {
                alt51=1;
                }
                break;
            case EQUAL:
                {
                alt51=2;
                }
                break;
            case EQUAL_NS:
                {
                alt51=3;
                }
                break;
            case NOTEQUAL:
                {
                alt51=4;
                }
                break;
            case LESSTHANOREQUALTO:
                {
                alt51=5;
                }
                break;
            case LESSTHAN:
                {
                alt51=6;
                }
                break;
            case GREATERTHANOREQUALTO:
                {
                alt51=7;
                }
                break;
            case GREATERTHAN:
                {
                alt51=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("276:1: compareOperator returns [CommonTree tr] : (n= negatableOperator | e= EQUAL | en= EQUAL_NS | nte= NOTEQUAL | lte= LESSTHANOREQUALTO | lt= LESSTHAN | gte= GREATERTHANOREQUALTO | gt= GREATERTHAN );", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // QSpecBuilder2.g:277:3: n= negatableOperator
                    {
                    pushFollow(FOLLOW_negatableOperator_in_compareOperator1516);
                    n=negatableOperator();
                    _fsp--;

                    tr =n;

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:278:3: e= EQUAL
                    {
                    e=(CommonTree)input.LT(1);
                    match(input,EQUAL,FOLLOW_EQUAL_in_compareOperator1527); 
                    tr =e;

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:279:3: en= EQUAL_NS
                    {
                    en=(CommonTree)input.LT(1);
                    match(input,EQUAL_NS,FOLLOW_EQUAL_NS_in_compareOperator1538); 
                    tr =en;

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:280:3: nte= NOTEQUAL
                    {
                    nte=(CommonTree)input.LT(1);
                    match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareOperator1549); 
                    tr =nte;

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:281:3: lte= LESSTHANOREQUALTO
                    {
                    lte=(CommonTree)input.LT(1);
                    match(input,LESSTHANOREQUALTO,FOLLOW_LESSTHANOREQUALTO_in_compareOperator1560); 
                    tr =lte;

                    }
                    break;
                case 6 :
                    // QSpecBuilder2.g:282:3: lt= LESSTHAN
                    {
                    lt=(CommonTree)input.LT(1);
                    match(input,LESSTHAN,FOLLOW_LESSTHAN_in_compareOperator1571); 
                    tr =lt;

                    }
                    break;
                case 7 :
                    // QSpecBuilder2.g:283:3: gte= GREATERTHANOREQUALTO
                    {
                    gte=(CommonTree)input.LT(1);
                    match(input,GREATERTHANOREQUALTO,FOLLOW_GREATERTHANOREQUALTO_in_compareOperator1582); 
                    tr =gte;

                    }
                    break;
                case 8 :
                    // QSpecBuilder2.g:284:3: gt= GREATERTHAN
                    {
                    gt=(CommonTree)input.LT(1);
                    match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_compareOperator1593); 
                    tr =gt;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end compareOperator


    // $ANTLR start nullCondition
    // QSpecBuilder2.g:287:1: nullCondition : ( NULL | NOTNULL );
    public final void nullCondition() throws RecognitionException {
        try {
            // QSpecBuilder2.g:287:15: ( NULL | NOTNULL )
            // QSpecBuilder2.g:
            {
            if ( input.LA(1)==NOTNULL||input.LA(1)==NULL ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_nullCondition0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end nullCondition


    // $ANTLR start expression
    // QSpecBuilder2.g:292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );
    public final CommonTree expression() throws RecognitionException {
        CommonTree tr = null;

        CommonTree or=null;
        CommonTree ad=null;
        CommonTree nt=null;
        CommonTree fInF=null;
        CommonTree fInT=null;
        CommonTree fBtF=null;
        CommonTree fBtT=null;
        CommonTree bitOr=null;
        CommonTree amp=null;
        CommonTree plus=null;
        CommonTree minus=null;
        CommonTree star=null;
        CommonTree divide=null;
        CommonTree mod=null;
        CommonTree div=null;
        CommonTree bitxor=null;
        CommonTree fnNull=null;
        CommonTree tilde=null;
        CommonTree arry=null;
        CommonTree dot=null;
        CommonTree nl=null;
        CommonTree nOp = null;

        CommonTree cOp = null;

        CommonTree c = null;

        CommonTree f = null;

        CommonTree cs = null;

        CommonTree cse = null;

        CommonTree whn = null;

        CommonTree tc = null;


        try {
            // QSpecBuilder2.g:292:36: ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn )
            int alt54=29;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt54=1;
                }
                break;
            case AND:
                {
                alt54=2;
                }
                break;
            case NOT:
                {
                alt54=3;
                }
                break;
            case LIKE:
                {
                int LA54_4 = input.LA(2);

                if ( (LA54_4==DOWN) ) {
                    int LA54_25 = input.LA(3);

                    if ( (LA54_25==TRUE) ) {
                        alt54=5;
                    }
                    else if ( (LA54_25==FALSE) ) {
                        alt54=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 25, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 4, input);

                    throw nvae;
                }
                }
                break;
            case RLIKE:
                {
                int LA54_5 = input.LA(2);

                if ( (LA54_5==DOWN) ) {
                    int LA54_25 = input.LA(3);

                    if ( (LA54_25==TRUE) ) {
                        alt54=5;
                    }
                    else if ( (LA54_25==FALSE) ) {
                        alt54=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 25, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 5, input);

                    throw nvae;
                }
                }
                break;
            case REGEXP:
                {
                int LA54_6 = input.LA(2);

                if ( (LA54_6==DOWN) ) {
                    int LA54_25 = input.LA(3);

                    if ( (LA54_25==TRUE) ) {
                        alt54=5;
                    }
                    else if ( (LA54_25==FALSE) ) {
                        alt54=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 25, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 6, input);

                    throw nvae;
                }
                }
                break;
            case EQUAL:
            case EQUAL_NS:
            case NOTEQUAL:
            case LESSTHANOREQUALTO:
            case LESSTHAN:
            case GREATERTHANOREQUALTO:
            case GREATERTHAN:
                {
                alt54=5;
                }
                break;
            case FUNCTION:
                {
                int LA54_8 = input.LA(2);

                if ( (LA54_8==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case CASE:
                        {
                        alt54=27;
                        }
                        break;
                    case WHEN:
                        {
                        alt54=28;
                        }
                        break;
                    case IN:
                        {
                        int LA54_30 = input.LA(4);

                        if ( (LA54_30==FALSE) ) {
                            alt54=6;
                        }
                        else if ( (LA54_30==TRUE) ) {
                            alt54=7;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 30, input);

                            throw nvae;
                        }
                        }
                        break;
                    case BETWEEN:
                        {
                        int LA54_31 = input.LA(4);

                        if ( (LA54_31==FALSE) ) {
                            alt54=8;
                        }
                        else if ( (LA54_31==TRUE) ) {
                            alt54=9;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 31, input);

                            throw nvae;
                        }
                        }
                        break;
                    case Identifier:
                    case IF:
                    case ARRAY:
                    case MAP:
                    case STRUCT:
                    case UNION:
                        {
                        alt54=25;
                        }
                        break;
                    case NOTNULL:
                    case NULL:
                        {
                        alt54=19;
                        }
                        break;
                    case TINYINT:
                    case SMALLINT:
                    case INT:
                    case BIGINT:
                    case BOOLEAN:
                    case FLOAT:
                    case DOUBLE:
                    case DATE:
                    case DATETIME:
                    case TIMESTAMP:
                    case STRING:
                    case BINARY:
                        {
                        alt54=26;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 26, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 8, input);

                    throw nvae;
                }
                }
                break;
            case BITWISEOR:
                {
                alt54=10;
                }
                break;
            case AMPERSAND:
                {
                alt54=11;
                }
                break;
            case PLUS:
                {
                alt54=12;
                }
                break;
            case MINUS:
                {
                alt54=13;
                }
                break;
            case STAR:
                {
                alt54=14;
                }
                break;
            case DIVIDE:
                {
                alt54=15;
                }
                break;
            case MOD:
                {
                alt54=16;
                }
                break;
            case DIV:
                {
                alt54=17;
                }
                break;
            case BITWISEXOR:
                {
                alt54=18;
                }
                break;
            case TILDE:
                {
                alt54=20;
                }
                break;
            case LSQUARE:
                {
                alt54=21;
                }
                break;
            case DOT:
                {
                alt54=22;
                }
                break;
            case NULL:
                {
                alt54=23;
                }
                break;
            case STRINGLITERALSEQUENCE:
            case CHARSETLITERAL:
            case StringLiteral:
            case Number:
            case BigintLiteral:
            case SmallintLiteral:
            case TinyintLiteral:
            case TRUE:
            case FALSE:
                {
                alt54=24;
                }
                break;
            case FUNCTIONSTAR:
            case FUNCTIONDIST:
                {
                alt54=25;
                }
                break;
            case TABLEORCOL:
                {
                alt54=29;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ^(nt= NOT expression ) | ^(nOp= negatableOperator FALSE expression expression ) | ^(cOp= compareOperator TRUE expression expression ) | ^(fInF= FUNCTION IN FALSE expression expressions ) | ^(fInT= FUNCTION IN TRUE expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // QSpecBuilder2.g:293:3: ^(or= OR expression expression )
                    {
                    or=(CommonTree)input.LT(1);
                    match(input,OR,FOLLOW_OR_in_expression1631); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1633);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1635);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =or;

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:294:3: ^(ad= AND expression expression )
                    {
                    ad=(CommonTree)input.LT(1);
                    match(input,AND,FOLLOW_AND_in_expression1646); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1648);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1650);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =ad;

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:295:3: ^(nt= NOT expression )
                    {
                    nt=(CommonTree)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_expression1661); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1663);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =nt;

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:296:3: ^(nOp= negatableOperator FALSE expression expression )
                    {
                    pushFollow(FOLLOW_negatableOperator_in_expression1674);
                    nOp=negatableOperator();
                    _fsp--;


                    match(input, Token.DOWN, null); 
                    match(input,FALSE,FOLLOW_FALSE_in_expression1676); 
                    pushFollow(FOLLOW_expression_in_expression1678);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1681);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =nOp;

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:297:3: ^(cOp= compareOperator TRUE expression expression )
                    {
                    pushFollow(FOLLOW_compareOperator_in_expression1694);
                    cOp=compareOperator();
                    _fsp--;


                    match(input, Token.DOWN, null); 
                    match(input,TRUE,FOLLOW_TRUE_in_expression1696); 
                    pushFollow(FOLLOW_expression_in_expression1698);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1700);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =cOp;

                    }
                    break;
                case 6 :
                    // QSpecBuilder2.g:298:3: ^(fInF= FUNCTION IN FALSE expression expressions )
                    {
                    fInF=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1712); 

                    match(input, Token.DOWN, null); 
                    match(input,IN,FOLLOW_IN_in_expression1714); 
                    match(input,FALSE,FOLLOW_FALSE_in_expression1716); 
                    pushFollow(FOLLOW_expression_in_expression1718);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expressions_in_expression1720);
                    expressions();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =fInF;

                    }
                    break;
                case 7 :
                    // QSpecBuilder2.g:299:3: ^(fInT= FUNCTION IN TRUE expression expressions )
                    {
                    fInT=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1732); 

                    match(input, Token.DOWN, null); 
                    match(input,IN,FOLLOW_IN_in_expression1734); 
                    match(input,TRUE,FOLLOW_TRUE_in_expression1736); 
                    pushFollow(FOLLOW_expression_in_expression1738);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expressions_in_expression1740);
                    expressions();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =fInT;

                    }
                    break;
                case 8 :
                    // QSpecBuilder2.g:300:3: ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression )
                    {
                    fBtF=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1752); 

                    match(input, Token.DOWN, null); 
                    match(input,BETWEEN,FOLLOW_BETWEEN_in_expression1754); 
                    match(input,FALSE,FOLLOW_FALSE_in_expression1756); 
                    pushFollow(FOLLOW_expression_in_expression1758);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1760);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1762);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =fBtF;

                    }
                    break;
                case 9 :
                    // QSpecBuilder2.g:301:3: ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression )
                    {
                    fBtT=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1774); 

                    match(input, Token.DOWN, null); 
                    match(input,BETWEEN,FOLLOW_BETWEEN_in_expression1776); 
                    match(input,TRUE,FOLLOW_TRUE_in_expression1778); 
                    pushFollow(FOLLOW_expression_in_expression1780);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1782);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1784);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =fBtT;

                    }
                    break;
                case 10 :
                    // QSpecBuilder2.g:302:3: ^(bitOr= BITWISEOR expression expression )
                    {
                    bitOr=(CommonTree)input.LT(1);
                    match(input,BITWISEOR,FOLLOW_BITWISEOR_in_expression1796); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1798);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1800);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =bitOr;

                    }
                    break;
                case 11 :
                    // QSpecBuilder2.g:303:3: ^(amp= AMPERSAND expression expression )
                    {
                    amp=(CommonTree)input.LT(1);
                    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_expression1812); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1814);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1816);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =amp;

                    }
                    break;
                case 12 :
                    // QSpecBuilder2.g:304:3: ^(plus= PLUS expression ( expression )? )
                    {
                    plus=(CommonTree)input.LT(1);
                    match(input,PLUS,FOLLOW_PLUS_in_expression1828); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1830);
                    expression();
                    _fsp--;

                    // QSpecBuilder2.g:304:26: ( expression )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==FUNCTION||(LA52_0>=STRINGLITERALSEQUENCE && LA52_0<=CHARSETLITERAL)||(LA52_0>=FUNCTIONSTAR && LA52_0<=FUNCTIONDIST)||LA52_0==TABLEORCOL||LA52_0==DOT||(LA52_0>=EQUAL && LA52_0<=StringLiteral)||LA52_0==STAR||LA52_0==AND||LA52_0==Number||(LA52_0>=BigintLiteral && LA52_0<=TinyintLiteral)||(LA52_0>=OR && LA52_0<=GREATERTHAN)||(LA52_0>=BITWISEOR && LA52_0<=NULL)||(LA52_0>=TILDE && LA52_0<=LSQUARE)||(LA52_0>=TRUE && LA52_0<=FALSE)) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // QSpecBuilder2.g:304:26: expression
                            {
                            pushFollow(FOLLOW_expression_in_expression1832);
                            expression();
                            _fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    tr =plus;

                    }
                    break;
                case 13 :
                    // QSpecBuilder2.g:305:3: ^(minus= MINUS expression ( expression )? )
                    {
                    minus=(CommonTree)input.LT(1);
                    match(input,MINUS,FOLLOW_MINUS_in_expression1845); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1847);
                    expression();
                    _fsp--;

                    // QSpecBuilder2.g:305:28: ( expression )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==FUNCTION||(LA53_0>=STRINGLITERALSEQUENCE && LA53_0<=CHARSETLITERAL)||(LA53_0>=FUNCTIONSTAR && LA53_0<=FUNCTIONDIST)||LA53_0==TABLEORCOL||LA53_0==DOT||(LA53_0>=EQUAL && LA53_0<=StringLiteral)||LA53_0==STAR||LA53_0==AND||LA53_0==Number||(LA53_0>=BigintLiteral && LA53_0<=TinyintLiteral)||(LA53_0>=OR && LA53_0<=GREATERTHAN)||(LA53_0>=BITWISEOR && LA53_0<=NULL)||(LA53_0>=TILDE && LA53_0<=LSQUARE)||(LA53_0>=TRUE && LA53_0<=FALSE)) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // QSpecBuilder2.g:305:28: expression
                            {
                            pushFollow(FOLLOW_expression_in_expression1849);
                            expression();
                            _fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 
                    tr =minus;

                    }
                    break;
                case 14 :
                    // QSpecBuilder2.g:306:3: ^(star= STAR expression expression )
                    {
                    star=(CommonTree)input.LT(1);
                    match(input,STAR,FOLLOW_STAR_in_expression1862); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1864);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1866);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =star;

                    }
                    break;
                case 15 :
                    // QSpecBuilder2.g:307:3: ^(divide= DIVIDE expression expression )
                    {
                    divide=(CommonTree)input.LT(1);
                    match(input,DIVIDE,FOLLOW_DIVIDE_in_expression1878); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1880);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1882);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =divide;

                    }
                    break;
                case 16 :
                    // QSpecBuilder2.g:308:3: ^(mod= MOD expression expression )
                    {
                    mod=(CommonTree)input.LT(1);
                    match(input,MOD,FOLLOW_MOD_in_expression1894); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1896);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1898);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =mod;

                    }
                    break;
                case 17 :
                    // QSpecBuilder2.g:309:3: ^(div= DIV expression expression )
                    {
                    div=(CommonTree)input.LT(1);
                    match(input,DIV,FOLLOW_DIV_in_expression1910); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1912);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1914);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =div;

                    }
                    break;
                case 18 :
                    // QSpecBuilder2.g:310:3: ^(bitxor= BITWISEXOR expression expression )
                    {
                    bitxor=(CommonTree)input.LT(1);
                    match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_expression1927); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1929);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1931);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =bitxor;

                    }
                    break;
                case 19 :
                    // QSpecBuilder2.g:311:3: ^(fnNull= FUNCTION nullCondition expression )
                    {
                    fnNull=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1943); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_nullCondition_in_expression1945);
                    nullCondition();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1947);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =fnNull;

                    }
                    break;
                case 20 :
                    // QSpecBuilder2.g:314:3: ^(tilde= TILDE expression )
                    {
                    tilde=(CommonTree)input.LT(1);
                    match(input,TILDE,FOLLOW_TILDE_in_expression1961); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1963);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =tilde;

                    }
                    break;
                case 21 :
                    // QSpecBuilder2.g:315:3: ^(arry= LSQUARE expression expression )
                    {
                    arry=(CommonTree)input.LT(1);
                    match(input,LSQUARE,FOLLOW_LSQUARE_in_expression1976); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1978);
                    expression();
                    _fsp--;

                    pushFollow(FOLLOW_expression_in_expression1980);
                    expression();
                    _fsp--;


                    match(input, Token.UP, null); 
                    tr =arry;

                    }
                    break;
                case 22 :
                    // QSpecBuilder2.g:316:3: ^(dot= DOT expression Identifier )
                    {
                    dot=(CommonTree)input.LT(1);
                    match(input,DOT,FOLLOW_DOT_in_expression1992); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1994);
                    expression();
                    _fsp--;

                    match(input,Identifier,FOLLOW_Identifier_in_expression1996); 

                    match(input, Token.UP, null); 
                    tr =dot;

                    }
                    break;
                case 23 :
                    // QSpecBuilder2.g:317:3: nl= NULL
                    {
                    nl=(CommonTree)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_expression2008); 
                    tr =nl;

                    }
                    break;
                case 24 :
                    // QSpecBuilder2.g:318:3: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_expression2018);
                    c=constant();
                    _fsp--;

                    tr = c;

                    }
                    break;
                case 25 :
                    // QSpecBuilder2.g:319:3: f= function
                    {
                    pushFollow(FOLLOW_function_in_expression2029);
                    f=function();
                    _fsp--;

                    tr = f;

                    }
                    break;
                case 26 :
                    // QSpecBuilder2.g:320:3: cs= castExpr
                    {
                    pushFollow(FOLLOW_castExpr_in_expression2040);
                    cs=castExpr();
                    _fsp--;

                    tr = cs;

                    }
                    break;
                case 27 :
                    // QSpecBuilder2.g:321:3: cse= caseExpr
                    {
                    pushFollow(FOLLOW_caseExpr_in_expression2051);
                    cse=caseExpr();
                    _fsp--;

                    tr = cse;

                    }
                    break;
                case 28 :
                    // QSpecBuilder2.g:322:3: whn= whenExpr
                    {
                    pushFollow(FOLLOW_whenExpr_in_expression2062);
                    whn=whenExpr();
                    _fsp--;

                    tr = whn;

                    }
                    break;
                case 29 :
                    // QSpecBuilder2.g:323:3: tc= tableOrColumn
                    {
                    pushFollow(FOLLOW_tableOrColumn_in_expression2073);
                    tc=tableOrColumn();
                    _fsp--;

                    tr =tc;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end expression


    // $ANTLR start booleanValue
    // QSpecBuilder2.g:326:1: booleanValue returns [CommonTree tr] : (t= TRUE | f= FALSE );
    public final CommonTree booleanValue() throws RecognitionException {
        CommonTree tr = null;

        CommonTree t=null;
        CommonTree f=null;

        try {
            // QSpecBuilder2.g:327:5: (t= TRUE | f= FALSE )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==TRUE) ) {
                alt55=1;
            }
            else if ( (LA55_0==FALSE) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("326:1: booleanValue returns [CommonTree tr] : (t= TRUE | f= FALSE );", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // QSpecBuilder2.g:328:5: t= TRUE
                    {
                    t=(CommonTree)input.LT(1);
                    match(input,TRUE,FOLLOW_TRUE_in_booleanValue2098); 
                     tr = t; 

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:329:5: f= FALSE
                    {
                    f=(CommonTree)input.LT(1);
                    match(input,FALSE,FOLLOW_FALSE_in_booleanValue2111); 
                     tr = f; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tr;
    }
    // $ANTLR end booleanValue


    // $ANTLR start primitiveType
    // QSpecBuilder2.g:332:1: primitiveType : ( TINYINT | SMALLINT | INT | BIGINT | BOOLEAN | FLOAT | DOUBLE | DATE | DATETIME | TIMESTAMP | STRING | BINARY );
    public final void primitiveType() throws RecognitionException {
        try {
            // QSpecBuilder2.g:332:15: ( TINYINT | SMALLINT | INT | BIGINT | BOOLEAN | FLOAT | DOUBLE | DATE | DATETIME | TIMESTAMP | STRING | BINARY )
            // QSpecBuilder2.g:
            {
            if ( (input.LA(1)>=TINYINT && input.LA(1)<=BINARY) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_primitiveType0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end primitiveType


    // $ANTLR start namevalue
    // QSpecBuilder2.g:347:1: namevalue[INameValueList properties] : ( ^( PARAM n= Identifier v= StringLiteral ) | ^( PARAM n= StringLiteral v= StringLiteral ) );
    public final void namevalue(INameValueList properties) throws RecognitionException {
        CommonTree n=null;
        CommonTree v=null;

        try {
            // QSpecBuilder2.g:347:38: ( ^( PARAM n= Identifier v= StringLiteral ) | ^( PARAM n= StringLiteral v= StringLiteral ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==PARAM) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==DOWN) ) {
                    int LA56_2 = input.LA(3);

                    if ( (LA56_2==StringLiteral) ) {
                        alt56=2;
                    }
                    else if ( (LA56_2==Identifier) ) {
                        alt56=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("347:1: namevalue[INameValueList properties] : ( ^( PARAM n= Identifier v= StringLiteral ) | ^( PARAM n= StringLiteral v= StringLiteral ) );", 56, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("347:1: namevalue[INameValueList properties] : ( ^( PARAM n= Identifier v= StringLiteral ) | ^( PARAM n= StringLiteral v= StringLiteral ) );", 56, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("347:1: namevalue[INameValueList properties] : ( ^( PARAM n= Identifier v= StringLiteral ) | ^( PARAM n= StringLiteral v= StringLiteral ) );", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // QSpecBuilder2.g:348:2: ^( PARAM n= Identifier v= StringLiteral )
                    {
                    match(input,PARAM,FOLLOW_PARAM_in_namevalue2236); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_namevalue2240); 
                    v=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_namevalue2244); 

                    match(input, Token.UP, null); 
                    properties.add(n.getText(), v.getText());

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:349:2: ^( PARAM n= StringLiteral v= StringLiteral )
                    {
                    match(input,PARAM,FOLLOW_PARAM_in_namevalue2253); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_namevalue2257); 
                    v=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_namevalue2261); 

                    match(input, Token.UP, null); 
                    properties.add(n.getText(), v.getText());

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end namevalue


 

    public static final BitSet FOLLOW_QUERY_in_query66 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tableSpec_in_query70 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_select_in_query74 = new BitSet(new long[]{0x8000400000020008L});
    public static final BitSet FOLLOW_where_in_query76 = new BitSet(new long[]{0x8000000000020008L});
    public static final BitSet FOLLOW_window_clause_in_query80 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_outputClause_in_query86 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SELECT_in_select113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_selectColumn_in_select115 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_SELECTCOLUMN_in_selectColumn130 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_selectColumn134 = new BitSet(new long[]{0x0000010000000008L});
    public static final BitSet FOLLOW_Identifier_in_selectColumn138 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SELECTCOLUMN_in_selectColumn149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_window_function_in_selectColumn153 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_selectColumn157 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_tableSpec175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tblfunc_in_tableSpec180 = new BitSet(new long[]{0x0800000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_hiveQuery_in_tableSpec184 = new BitSet(new long[]{0x0800000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_hdfsFile_in_tableSpec188 = new BitSet(new long[]{0x0800000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_hiveTable_in_tableSpec192 = new BitSet(new long[]{0x0800000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_partitionby_in_tableSpec198 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_orderby_in_tableSpec207 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_HIVEQUERY_in_hiveQuery230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HIVETBL_in_hiveTable248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_hiveTable252 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_hiveTable256 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_HIVETBL_in_hiveTable266 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_hiveTable270 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TBLFUNCTION_in_tblfunc295 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_tblfunc299 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_tableSpec_in_tblfunc303 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_tblfunc308 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_HDFSLOCATION_in_hdfsFile335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_namevalue_in_hdfsFile337 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_WHERE_in_where353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_where357 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUTSPEC_in_outputClause380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_outputClause384 = new BitSet(new long[]{0x0008000000080008L});
    public static final BitSet FOLLOW_outputSerDe_in_outputClause386 = new BitSet(new long[]{0x0000000000080008L});
    public static final BitSet FOLLOW_loadClause_in_outputClause390 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SERDE_in_outputSerDe408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_outputSerDe412 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_outputFormatOrWriter_in_outputSerDe414 = new BitSet(new long[]{0x0020000000000008L});
    public static final BitSet FOLLOW_outputSerDePropeties_in_outputSerDe417 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties434 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties436 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_RECORDWRITER_in_outputFormatOrWriter452 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_outputFormatOrWriter456 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORMAT_in_outputFormatOrWriter466 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_outputFormatOrWriter470 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOADSPEC_in_loadClause485 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_loadClause489 = new BitSet(new long[]{0x0204000000000008L});
    public static final BitSet FOLLOW_StringLiteral_in_loadClause493 = new BitSet(new long[]{0x0200000000000008L});
    public static final BitSet FOLLOW_OVERWRITE_in_loadClause498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WDW_FUNCTIONSTAR_in_window_function526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionName_in_window_function528 = new BitSet(new long[]{0x0000000020000008L});
    public static final BitSet FOLLOW_window_specification_in_window_function532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WDW_FUNCTION_in_window_function543 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionName_in_window_function545 = new BitSet(new long[]{0x1006040029B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_window_function551 = new BitSet(new long[]{0x1006040029B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_window_specification_in_window_function560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WDW_FUNCTIONDIST_in_window_function571 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionName_in_window_function573 = new BitSet(new long[]{0x1006040029B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_window_function579 = new BitSet(new long[]{0x1006040029B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_window_specification_in_window_function588 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WINDOW_in_window_clause607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_window_defn_in_window_clause609 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_WINDOWDEF_in_window_defn627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_window_defn631 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_window_specification_in_window_defn635 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WINDOWSPEC_in_window_specification655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_window_specification659 = new BitSet(new long[]{0x0800000000006008L,0x0000000000000001L});
    public static final BitSet FOLLOW_partitionby_in_window_specification664 = new BitSet(new long[]{0x0000000000006008L,0x0000000000000001L});
    public static final BitSet FOLLOW_orderby_in_window_specification669 = new BitSet(new long[]{0x0000000000006008L});
    public static final BitSet FOLLOW_window_frame_in_window_specification674 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_orderby699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby704 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_ORDERCOLUMN_in_ordercolumn724 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_columnReference_in_ordercolumn728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn732 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDERCOLUMN_in_ordercolumn740 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_columnReference_in_ordercolumn744 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn746 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDERCOLUMN_in_ordercolumn754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_columnReference_in_ordercolumn758 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby784 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_columnReference_in_partitionby789 = new BitSet(new long[]{0x0000000010000008L});
    public static final BitSet FOLLOW_window_range_expression_in_window_frame809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_frame818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WINDOWRANGE_in_window_range_expression835 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000700L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression843 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary870 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary872 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary883 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary885 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary903 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Number_in_rowsboundary907 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary917 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Number_in_rowsboundary921 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WINDOWVALUES_in_window_value_expression939 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression943 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C700L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression947 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary966 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary979 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary981 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary999 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_valuesboundary1003 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_Number_in_valuesboundary1007 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary1017 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_valuesboundary1021 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_Number_in_valuesboundary1025 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COLUMNREF_in_columnReference1043 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_columnReference1047 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_columnReference1051 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COLUMNREF_in_columnReference1061 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_columnReference1065 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TABLEORCOL_in_tableOrColumn1090 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_tableOrColumn1092 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTIONSTAR_in_function1116 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionName_in_function1118 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_function1131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionName_in_function1133 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_function1136 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_FUNCTIONDIST_in_function1151 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_functionName_in_function1153 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_function1156 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_set_in_functionName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_castExpr1240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_primitiveType_in_castExpr1242 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_castExpr1244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_caseExpr1265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_in_caseExpr1267 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_caseExpr1269 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_FUNCTION_in_whenExpr1293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_whenExpr1295 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_whenExpr1297 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_Number_in_constant1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_constant1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringLiteralSequence_in_constant1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BigintLiteral_in_constant1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SmallintLiteral_in_constant1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TinyintLiteral_in_constant1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charSetStringLiteral_in_constant1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValue_in_constant1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGLITERALSEQUENCE_in_stringLiteralSequence1410 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_stringLiteralSequence1412 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_stringLiteralSequence1414 = new BitSet(new long[]{0x0004000000000008L});
    public static final BitSet FOLLOW_CHARSETLITERAL_in_charSetStringLiteral1438 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CharSetName_in_charSetStringLiteral1440 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_CharSetLiteral_in_charSetStringLiteral1442 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_expressions1456 = new BitSet(new long[]{0x1006040009B00202L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_LIKE_in_negatableOperator1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RLIKE_in_negatableOperator1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGEXP_in_negatableOperator1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negatableOperator_in_compareOperator1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_compareOperator1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_NS_in_compareOperator1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareOperator1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESSTHANOREQUALTO_in_compareOperator1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESSTHAN_in_compareOperator1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATERTHANOREQUALTO_in_compareOperator1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATERTHAN_in_compareOperator1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nullCondition0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_expression1631 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1633 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1635 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expression1646 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1648 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression1661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_negatableOperator_in_expression1674 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FALSE_in_expression1676 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1678 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1681 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_compareOperator_in_expression1694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TRUE_in_expression1696 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1698 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1712 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_in_expression1714 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_FALSE_in_expression1716 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1718 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expressions_in_expression1720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1732 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_in_expression1734 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_TRUE_in_expression1736 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1738 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expressions_in_expression1740 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1752 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BETWEEN_in_expression1754 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_FALSE_in_expression1756 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1758 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1760 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1762 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1774 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BETWEEN_in_expression1776 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_TRUE_in_expression1778 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1780 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1782 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1784 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISEOR_in_expression1796 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1798 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1800 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AMPERSAND_in_expression1812 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1814 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1816 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expression1828 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1830 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1832 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expression1845 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1847 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expression1862 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1864 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1866 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDE_in_expression1878 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1880 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1882 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expression1894 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1896 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1898 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expression1910 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1912 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1914 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISEXOR_in_expression1927 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1929 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1931 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1943 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nullCondition_in_expression1945 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1947 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TILDE_in_expression1961 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1963 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LSQUARE_in_expression1976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1978 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1980 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_expression1992 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1994 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_expression1996 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_expression2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_expression2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_expression2029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpr_in_expression2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseExpr_in_expression2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whenExpr_in_expression2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tableOrColumn_in_expression2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_booleanValue2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_booleanValue2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARAM_in_namevalue2236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_namevalue2240 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_namevalue2244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAM_in_namevalue2253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_namevalue2257 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_namevalue2261 = new BitSet(new long[]{0x0000000000000008L});

}