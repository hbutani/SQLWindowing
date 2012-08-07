// $ANTLR 3.0.1 QSpecBuilder2.g 2012-08-07 13:23:43

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
import java.util.Map;
import java.util.HashMap;
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
            ruleMemo = new HashMap[46+1];
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
            match(input,QUERY,FOLLOW_QUERY_in_query66); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_tableSpec_in_query70);
            ts=tableSpec();
            _fsp--;
            if (failed) return ;
            pushFollow(FOLLOW_select_in_query74);
            ss=select();
            _fsp--;
            if (failed) return ;
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
                    if (failed) return ;

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
                    if (failed) return ;

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
                    if (failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {
               qSpec.setInput(ts); qSpec.setSelectList(ss); qSpec.setOutput(oc);
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
            match(input,SELECT,FOLLOW_SELECT_in_select113); if (failed) return ss;

            match(input, Token.DOWN, null); if (failed) return ss;
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
            	    if (failed) return ss;

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (backtracking>0) {failed=true; return ss;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); if (failed) return ss;

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
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("66:1: selectColumn[SelectSpec ss] : ( ^( SELECTCOLUMN e= expression (i= Identifier )? ) | ^( SELECTCOLUMN w= window_function i= Identifier ) );", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("66:1: selectColumn[SelectSpec ss] : ( ^( SELECTCOLUMN e= expression (i= Identifier )? ) | ^( SELECTCOLUMN w= window_function i= Identifier ) );", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("66:1: selectColumn[SelectSpec ss] : ( ^( SELECTCOLUMN e= expression (i= Identifier )? ) | ^( SELECTCOLUMN w= window_function i= Identifier ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // QSpecBuilder2.g:67:3: ^( SELECTCOLUMN e= expression (i= Identifier )? )
                    {
                    match(input,SELECTCOLUMN,FOLLOW_SELECTCOLUMN_in_selectColumn130); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_expression_in_selectColumn134);
                    e=expression();
                    _fsp--;
                    if (failed) return ;
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
                            match(input,Identifier,FOLLOW_Identifier_in_selectColumn138); if (failed) return ;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (failed) return ;
                    if ( backtracking==0 ) {
                      ss.addExpression(e, i!=null ? i.getText() : null);
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:68:3: ^( SELECTCOLUMN w= window_function i= Identifier )
                    {
                    match(input,SELECTCOLUMN,FOLLOW_SELECTCOLUMN_in_selectColumn149); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    pushFollow(FOLLOW_window_function_in_selectColumn153);
                    w=window_function();
                    _fsp--;
                    if (failed) return ;
                    i=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_selectColumn157); if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;
                    if ( backtracking==0 ) {
                      ss.addWindowFunc(w, i.getText());
                    }

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
            match(input,INPUT,FOLLOW_INPUT_in_tableSpec175); if (failed) return qIn;

            match(input, Token.DOWN, null); if (failed) return qIn;
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
                if (backtracking>0) {failed=true; return qIn;}
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
                    if (failed) return qIn;

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:72:21: t= hiveQuery
                    {
                    pushFollow(FOLLOW_hiveQuery_in_tableSpec184);
                    t=hiveQuery();
                    _fsp--;
                    if (failed) return qIn;

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:72:33: t= hdfsFile
                    {
                    pushFollow(FOLLOW_hdfsFile_in_tableSpec188);
                    t=hdfsFile();
                    _fsp--;
                    if (failed) return qIn;

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:72:44: t= hiveTable
                    {
                    pushFollow(FOLLOW_hiveTable_in_tableSpec192);
                    t=hiveTable();
                    _fsp--;
                    if (failed) return qIn;

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
                    if (failed) return qIn;
                    if ( backtracking==0 ) {
                      t.setPartition(p);
                    }

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
                    if (failed) return qIn;
                    if ( backtracking==0 ) {
                      t.setOrder(o);
                    }

                    }
                    break;

            }


            match(input, Token.UP, null); if (failed) return qIn;
            if ( backtracking==0 ) {
              qIn = t;
            }

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
            match(input,HIVEQUERY,FOLLOW_HIVEQUERY_in_hiveQuery230); if (failed) return hQSpec;
            if ( backtracking==0 ) {
              hQSpec = new HiveQuerySpec(hq.getText());
            }

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
                            if (backtracking>0) {failed=true; return hTSpec;}
                            NoViableAltException nvae =
                                new NoViableAltException("79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );", 10, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return hTSpec;}
                        NoViableAltException nvae =
                            new NoViableAltException("79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return hTSpec;}
                    NoViableAltException nvae =
                        new NoViableAltException("79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return hTSpec;}
                NoViableAltException nvae =
                    new NoViableAltException("79:1: hiveTable returns [QueryInputSpec hTSpec] : ( ^( HIVETBL d= Identifier t= Identifier ) | ^( HIVETBL t= Identifier ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // QSpecBuilder2.g:80:3: ^( HIVETBL d= Identifier t= Identifier )
                    {
                    match(input,HIVETBL,FOLLOW_HIVETBL_in_hiveTable248); if (failed) return hTSpec;

                    match(input, Token.DOWN, null); if (failed) return hTSpec;
                    d=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_hiveTable252); if (failed) return hTSpec;
                    t=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_hiveTable256); if (failed) return hTSpec;

                    match(input, Token.UP, null); if (failed) return hTSpec;
                    if ( backtracking==0 ) {
                      hTSpec = new HiveTableSpec(d.getText(), t.getText());
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:81:3: ^( HIVETBL t= Identifier )
                    {
                    match(input,HIVETBL,FOLLOW_HIVETBL_in_hiveTable266); if (failed) return hTSpec;

                    match(input, Token.DOWN, null); if (failed) return hTSpec;
                    t=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_hiveTable270); if (failed) return hTSpec;

                    match(input, Token.UP, null); if (failed) return hTSpec;
                    if ( backtracking==0 ) {
                      hTSpec = new HiveTableSpec(null, t.getText());
                    }

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
            match(input,TBLFUNCTION,FOLLOW_TBLFUNCTION_in_tblfunc295); if (failed) return qIn;

            match(input, Token.DOWN, null); if (failed) return qIn;
            i=(CommonTree)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_tblfunc299); if (failed) return qIn;
            pushFollow(FOLLOW_tableSpec_in_tblfunc303);
            t=tableSpec();
            _fsp--;
            if (failed) return qIn;
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
            	    if (failed) return qIn;
            	    if ( backtracking==0 ) {
            	      tblFn.addArg(e);
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match(input, Token.UP, null); if (failed) return qIn;
            if ( backtracking==0 ) {
              tblFn.setName(i.getText()); tblFn.setInput(t); qIn = tblFn; 
            }

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
            match(input,HDFSLOCATION,FOLLOW_HDFSLOCATION_in_hdfsFile335); if (failed) return hLoc;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return hLoc;
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
                	    if (failed) return hLoc;

                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);


                match(input, Token.UP, null); if (failed) return hLoc;
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
            match(input,WHERE,FOLLOW_WHERE_in_where353); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            pushFollow(FOLLOW_expression_in_where357);
            e=expression();
            _fsp--;
            if (failed) return ;

            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {
              qs.setWhereExpr(e);
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
            match(input,OUTPUTSPEC,FOLLOW_OUTPUTSPEC_in_outputClause380); if (failed) return qOut;

            match(input, Token.DOWN, null); if (failed) return qOut;
            p=(CommonTree)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_outputClause384); if (failed) return qOut;
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
                    if (failed) return qOut;

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
                    if (failed) return qOut;

                    }
                    break;

            }


            match(input, Token.UP, null); if (failed) return qOut;
            if ( backtracking==0 ) {
              qOut.setPath(p.getText());
            }

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
            match(input,SERDE,FOLLOW_SERDE_in_outputSerDe408); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            sd=(CommonTree)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_outputSerDe412); if (failed) return ;
            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe414);
            outputFormatOrWriter(qOut);
            _fsp--;
            if (failed) return ;
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
                    if (failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {
              qOut.setSerDeClass(sd.getText());
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
    // $ANTLR end outputSerDe


    // $ANTLR start outputSerDePropeties
    // QSpecBuilder2.g:116:1: outputSerDePropeties[INameValueList properties] : ^( SERDEPROPERTIES ( namevalue[properties] )* ) ;
    public final void outputSerDePropeties(INameValueList properties) throws RecognitionException {
        try {
            // QSpecBuilder2.g:116:48: ( ^( SERDEPROPERTIES ( namevalue[properties] )* ) )
            // QSpecBuilder2.g:117:3: ^( SERDEPROPERTIES ( namevalue[properties] )* )
            {
            match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties434); if (failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ;
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
                	    if (failed) return ;

                	    }
                	    break;

                	default :
                	    break loop16;
                    }
                } while (true);


                match(input, Token.UP, null); if (failed) return ;
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
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("120:1: outputFormatOrWriter[QueryOutputSpec qOut] : ( ^( RECORDWRITER rw= StringLiteral ) | ^( FORMAT of= StringLiteral ) );", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // QSpecBuilder2.g:121:3: ^( RECORDWRITER rw= StringLiteral )
                    {
                    match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter452); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    rw=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_outputFormatOrWriter456); if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;
                    if ( backtracking==0 ) {
                      qOut.setRecordWriterClass(rw.getText());
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:122:3: ^( FORMAT of= StringLiteral )
                    {
                    match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter466); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    of=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_outputFormatOrWriter470); if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;
                    if ( backtracking==0 ) {
                      qOut.setOutputFormatClass(of.getText());
                    }

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
            match(input,LOADSPEC,FOLLOW_LOADSPEC_in_loadClause485); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            ht=(CommonTree)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_loadClause489); if (failed) return ;
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
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_loadClause493); if (failed) return ;

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
                    match(input,OVERWRITE,FOLLOW_OVERWRITE_in_loadClause498); if (failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {

                  qOut.setHiveTable(ht.getText());
                  qOut.setPartitionClause(hp.getText());
                  qOut.setOverwriteHiveTable(true);
                
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
                if (backtracking>0) {failed=true; return wFn;}
                NoViableAltException nvae =
                    new NoViableAltException("133:1: window_function returns [WindowFunctionSpec wFn] : ( ^( WDW_FUNCTIONSTAR functionName (ws= window_specification )? ) | ^( WDW_FUNCTION functionName ( (e= expression )+ )? (ws= window_specification )? ) | ^( WDW_FUNCTIONDIST functionName ( (e= expression )+ )? (ws= window_specification )? ) );", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // QSpecBuilder2.g:138:3: ^( WDW_FUNCTIONSTAR functionName (ws= window_specification )? )
                    {
                    match(input,WDW_FUNCTIONSTAR,FOLLOW_WDW_FUNCTIONSTAR_in_window_function526); if (failed) return wFn;

                    match(input, Token.DOWN, null); if (failed) return wFn;
                    pushFollow(FOLLOW_functionName_in_window_function528);
                    functionName1=functionName();
                    _fsp--;
                    if (failed) return wFn;
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
                            if (failed) return wFn;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (failed) return wFn;
                    if ( backtracking==0 ) {
                      wFn.setName(input.getTokenStream().toString(
                        input.getTreeAdaptor().getTokenStartIndex(functionName1.start),
                        input.getTreeAdaptor().getTokenStopIndex(functionName1.start))); wFn.setWindowSpec(ws); wFn.setStar(true);
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:139:3: ^( WDW_FUNCTION functionName ( (e= expression )+ )? (ws= window_specification )? )
                    {
                    match(input,WDW_FUNCTION,FOLLOW_WDW_FUNCTION_in_window_function543); if (failed) return wFn;

                    match(input, Token.DOWN, null); if (failed) return wFn;
                    pushFollow(FOLLOW_functionName_in_window_function545);
                    functionName2=functionName();
                    _fsp--;
                    if (failed) return wFn;
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
                            	    if (failed) return wFn;
                            	    if ( backtracking==0 ) {
                            	      wFn.addArg(e);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt21 >= 1 ) break loop21;
                            	    if (backtracking>0) {failed=true; return wFn;}
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
                            if (failed) return wFn;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (failed) return wFn;
                    if ( backtracking==0 ) {
                      wFn.setName(input.getTokenStream().toString(
                        input.getTreeAdaptor().getTokenStartIndex(functionName2.start),
                        input.getTreeAdaptor().getTokenStopIndex(functionName2.start))); wFn.setWindowSpec(ws); 
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:140:3: ^( WDW_FUNCTIONDIST functionName ( (e= expression )+ )? (ws= window_specification )? )
                    {
                    match(input,WDW_FUNCTIONDIST,FOLLOW_WDW_FUNCTIONDIST_in_window_function571); if (failed) return wFn;

                    match(input, Token.DOWN, null); if (failed) return wFn;
                    pushFollow(FOLLOW_functionName_in_window_function573);
                    functionName3=functionName();
                    _fsp--;
                    if (failed) return wFn;
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
                            	    if (failed) return wFn;
                            	    if ( backtracking==0 ) {
                            	      wFn.addArg(e);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt24 >= 1 ) break loop24;
                            	    if (backtracking>0) {failed=true; return wFn;}
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
                            if (failed) return wFn;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (failed) return wFn;
                    if ( backtracking==0 ) {
                      wFn.setName(input.getTokenStream().toString(
                        input.getTreeAdaptor().getTokenStartIndex(functionName3.start),
                        input.getTreeAdaptor().getTokenStopIndex(functionName3.start))); wFn.setWindowSpec(ws); wFn.setDistinct(true); 
                    }

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
            match(input,WINDOW,FOLLOW_WINDOW_in_window_clause607); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
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
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (backtracking>0) {failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            match(input, Token.UP, null); if (failed) return ;

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
            match(input,WINDOWDEF,FOLLOW_WINDOWDEF_in_window_defn627); if (failed) return ;

            match(input, Token.DOWN, null); if (failed) return ;
            i=(CommonTree)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_window_defn631); if (failed) return ;
            pushFollow(FOLLOW_window_specification_in_window_defn635);
            ws=window_specification();
            _fsp--;
            if (failed) return ;

            match(input, Token.UP, null); if (failed) return ;
            if ( backtracking==0 ) {
               qs.addWindowSpec(i.getText(), ws);
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
            match(input,WINDOWSPEC,FOLLOW_WINDOWSPEC_in_window_specification655); if (failed) return ws;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (failed) return ws;
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
                        match(input,Identifier,FOLLOW_Identifier_in_window_specification659); if (failed) return ws;

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
                        if (failed) return ws;

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
                        if (failed) return ws;

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
                        if (failed) return ws;

                        }
                        break;

                }


                match(input, Token.UP, null); if (failed) return ws;
            }
            if ( backtracking==0 ) {
               ws = new WindowSpec(i != null ? i.getText() : null, p, o, wf);
            }

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
            match(input,ORDER,FOLLOW_ORDER_in_orderby699); if (failed) return os;

            match(input, Token.DOWN, null); if (failed) return os;
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
            	    if (failed) return os;
            	    if ( backtracking==0 ) {
            	      os.addColumn(o);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (backtracking>0) {failed=true; return os;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            match(input, Token.UP, null); if (failed) return os;

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

                                if ( (LA34_5==Identifier) ) {
                                    int LA34_6 = input.LA(7);

                                    if ( (LA34_6==UP) ) {
                                        switch ( input.LA(8) ) {
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
                                            if (backtracking>0) {failed=true; return ocs;}
                                            NoViableAltException nvae =
                                                new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 8, input);

                                            throw nvae;
                                        }

                                    }
                                    else {
                                        if (backtracking>0) {failed=true; return ocs;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 6, input);

                                        throw nvae;
                                    }
                                }
                                else if ( (LA34_5==UP) ) {
                                    switch ( input.LA(7) ) {
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
                                        if (backtracking>0) {failed=true; return ocs;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 7, input);

                                        throw nvae;
                                    }

                                }
                                else {
                                    if (backtracking>0) {failed=true; return ocs;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (backtracking>0) {failed=true; return ocs;}
                                NoViableAltException nvae =
                                    new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return ocs;}
                            NoViableAltException nvae =
                                new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return ocs;}
                        NoViableAltException nvae =
                            new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ocs;}
                    NoViableAltException nvae =
                        new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ocs;}
                NoViableAltException nvae =
                    new NoViableAltException("163:1: ordercolumn returns [OrderColumnSpec ocs] : ( ^( ORDERCOLUMN cr= columnReference o= ASC ) | ^( ORDERCOLUMN cr= columnReference DESC ) | ^( ORDERCOLUMN cr= columnReference ) );", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // QSpecBuilder2.g:164:2: ^( ORDERCOLUMN cr= columnReference o= ASC )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn724); if (failed) return ocs;

                    match(input, Token.DOWN, null); if (failed) return ocs;
                    pushFollow(FOLLOW_columnReference_in_ordercolumn728);
                    cr=columnReference();
                    _fsp--;
                    if (failed) return ocs;
                    o=(CommonTree)input.LT(1);
                    match(input,ASC,FOLLOW_ASC_in_ordercolumn732); if (failed) return ocs;

                    match(input, Token.UP, null); if (failed) return ocs;
                    if ( backtracking==0 ) {
                      ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.ASC); 
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:165:2: ^( ORDERCOLUMN cr= columnReference DESC )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn740); if (failed) return ocs;

                    match(input, Token.DOWN, null); if (failed) return ocs;
                    pushFollow(FOLLOW_columnReference_in_ordercolumn744);
                    cr=columnReference();
                    _fsp--;
                    if (failed) return ocs;
                    match(input,DESC,FOLLOW_DESC_in_ordercolumn746); if (failed) return ocs;

                    match(input, Token.UP, null); if (failed) return ocs;
                    if ( backtracking==0 ) {
                      ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.DESC); 
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:166:2: ^( ORDERCOLUMN cr= columnReference )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn754); if (failed) return ocs;

                    match(input, Token.DOWN, null); if (failed) return ocs;
                    pushFollow(FOLLOW_columnReference_in_ordercolumn758);
                    cr=columnReference();
                    _fsp--;
                    if (failed) return ocs;

                    match(input, Token.UP, null); if (failed) return ocs;
                    if ( backtracking==0 ) {
                      ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.ASC); 
                    }

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
            match(input,PARTITION,FOLLOW_PARTITION_in_partitionby784); if (failed) return ps;

            match(input, Token.DOWN, null); if (failed) return ps;
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
            	    if (failed) return ps;
            	    if ( backtracking==0 ) {
            	      ps.addColumn(cr);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (backtracking>0) {failed=true; return ps;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            match(input, Token.UP, null); if (failed) return ps;

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
                if (backtracking>0) {failed=true; return wf;}
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
                    if (failed) return wf;
                    if ( backtracking==0 ) {
                      wf = w;
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:179:2: w= window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_frame818);
                    w=window_value_expression();
                    _fsp--;
                    if (failed) return wf;
                    if ( backtracking==0 ) {
                      wf = w;
                    }

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
            match(input,WINDOWRANGE,FOLLOW_WINDOWRANGE_in_window_range_expression835); if (failed) return wf;

            match(input, Token.DOWN, null); if (failed) return wf;
            pushFollow(FOLLOW_rowsboundary_in_window_range_expression839);
            s=rowsboundary();
            _fsp--;
            if (failed) return wf;
            pushFollow(FOLLOW_rowsboundary_in_window_range_expression843);
            e=rowsboundary();
            _fsp--;
            if (failed) return wf;

            match(input, Token.UP, null); if (failed) return wf;
            if ( backtracking==0 ) {
              wf = new WindowFrameSpec(s,e);
            }

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

                    if ( (LA37_4==Number) ) {
                        alt37=4;
                    }
                    else if ( (LA37_4==UNBOUNDED) ) {
                        alt37=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return bs;}
                        NoViableAltException nvae =
                            new NoViableAltException("186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );", 37, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return bs;}
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
                        if (backtracking>0) {failed=true; return bs;}
                        NoViableAltException nvae =
                            new NoViableAltException("186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );", 37, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return bs;}
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
                if (backtracking>0) {failed=true; return bs;}
                NoViableAltException nvae =
                    new NoViableAltException("186:1: rowsboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( PRECEDING n= Number ) | ^( FOLLOWING n= Number ) );", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // QSpecBuilder2.g:192:3: ^( PRECEDING UNBOUNDED )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary870); if (failed) return bs;

                    match(input, Token.DOWN, null); if (failed) return bs;
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary872); if (failed) return bs;

                    match(input, Token.UP, null); if (failed) return bs;
                    if ( backtracking==0 ) {
                      rbs.setDirection(Direction.PRECEDING); rbs.setAmt(BoundarySpec.UNBOUNDED_AMOUNT);
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:193:3: ^( FOLLOWING UNBOUNDED )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary883); if (failed) return bs;

                    match(input, Token.DOWN, null); if (failed) return bs;
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary885); if (failed) return bs;

                    match(input, Token.UP, null); if (failed) return bs;
                    if ( backtracking==0 ) {
                      rbs.setDirection(Direction.FOLLOWING); rbs.setAmt(BoundarySpec.UNBOUNDED_AMOUNT);
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:194:3: CURRENT
                    {
                    match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary894); if (failed) return bs;
                    if ( backtracking==0 ) {
                      bs = new CurrentRowSpec();
                    }

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:195:3: ^( PRECEDING n= Number )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary903); if (failed) return bs;

                    match(input, Token.DOWN, null); if (failed) return bs;
                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_rowsboundary907); if (failed) return bs;

                    match(input, Token.UP, null); if (failed) return bs;
                    if ( backtracking==0 ) {
                      rbs.setDirection(Direction.PRECEDING); rbs.setAmt(Integer.parseInt(n.getText()));
                    }

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:196:3: ^( FOLLOWING n= Number )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary917); if (failed) return bs;

                    match(input, Token.DOWN, null); if (failed) return bs;
                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_rowsboundary921); if (failed) return bs;

                    match(input, Token.UP, null); if (failed) return bs;
                    if ( backtracking==0 ) {
                      rbs.setDirection(Direction.FOLLOWING); rbs.setAmt(Integer.parseInt(n.getText()));
                    }

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
            match(input,WINDOWVALUES,FOLLOW_WINDOWVALUES_in_window_value_expression939); if (failed) return wf;

            match(input, Token.DOWN, null); if (failed) return wf;
            pushFollow(FOLLOW_valuesboundary_in_window_value_expression943);
            s=valuesboundary();
            _fsp--;
            if (failed) return wf;
            pushFollow(FOLLOW_valuesboundary_in_window_value_expression947);
            e=valuesboundary();
            _fsp--;
            if (failed) return wf;

            match(input, Token.UP, null); if (failed) return wf;
            if ( backtracking==0 ) {
              wf = new WindowFrameSpec(s,e);
            }

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
                if (backtracking>0) {failed=true; return bs;}
                NoViableAltException nvae =
                    new NoViableAltException("203:1: valuesboundary returns [BoundarySpec bs] : ( ^( PRECEDING UNBOUNDED ) | ^( FOLLOWING UNBOUNDED ) | CURRENT | ^( LESS e= expression n= Number ) | ^( MORE e= expression n= Number ) );", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // QSpecBuilder2.g:204:3: ^( PRECEDING UNBOUNDED )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary966); if (failed) return bs;

                    match(input, Token.DOWN, null); if (failed) return bs;
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary968); if (failed) return bs;

                    match(input, Token.UP, null); if (failed) return bs;
                    if ( backtracking==0 ) {
                      bs = new ValueBoundarySpec(Direction.PRECEDING, null, BoundarySpec.UNBOUNDED_AMOUNT);
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:205:3: ^( FOLLOWING UNBOUNDED )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary979); if (failed) return bs;

                    match(input, Token.DOWN, null); if (failed) return bs;
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary981); if (failed) return bs;

                    match(input, Token.UP, null); if (failed) return bs;
                    if ( backtracking==0 ) {
                      bs = new ValueBoundarySpec(Direction.FOLLOWING, null, BoundarySpec.UNBOUNDED_AMOUNT);
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:206:3: CURRENT
                    {
                    match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary990); if (failed) return bs;
                    if ( backtracking==0 ) {
                      bs = new CurrentRowSpec();
                    }

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:207:3: ^( LESS e= expression n= Number )
                    {
                    match(input,LESS,FOLLOW_LESS_in_valuesboundary999); if (failed) return bs;

                    match(input, Token.DOWN, null); if (failed) return bs;
                    pushFollow(FOLLOW_expression_in_valuesboundary1003);
                    e=expression();
                    _fsp--;
                    if (failed) return bs;
                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_valuesboundary1007); if (failed) return bs;

                    match(input, Token.UP, null); if (failed) return bs;
                    if ( backtracking==0 ) {
                      bs = new ValueBoundarySpec(Direction.PRECEDING, e, Integer.parseInt(n.getText()));
                    }

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:208:3: ^( MORE e= expression n= Number )
                    {
                    match(input,MORE,FOLLOW_MORE_in_valuesboundary1017); if (failed) return bs;

                    match(input, Token.DOWN, null); if (failed) return bs;
                    pushFollow(FOLLOW_expression_in_valuesboundary1021);
                    e=expression();
                    _fsp--;
                    if (failed) return bs;
                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_valuesboundary1025); if (failed) return bs;

                    match(input, Token.UP, null); if (failed) return bs;
                    if ( backtracking==0 ) {
                      bs = new ValueBoundarySpec(Direction.PRECEDING, e, Integer.parseInt(n.getText()));
                    }

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
                            if (backtracking>0) {failed=true; return cs;}
                            NoViableAltException nvae =
                                new NoViableAltException("211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );", 39, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (backtracking>0) {failed=true; return cs;}
                        NoViableAltException nvae =
                            new NoViableAltException("211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );", 39, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return cs;}
                    NoViableAltException nvae =
                        new NoViableAltException("211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );", 39, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return cs;}
                NoViableAltException nvae =
                    new NoViableAltException("211:1: columnReference returns [ColumnSpec cs] : ( ^( COLUMNREF t= Identifier c= Identifier ) | ^( COLUMNREF t= Identifier ) );", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // QSpecBuilder2.g:212:3: ^( COLUMNREF t= Identifier c= Identifier )
                    {
                    match(input,COLUMNREF,FOLLOW_COLUMNREF_in_columnReference1043); if (failed) return cs;

                    match(input, Token.DOWN, null); if (failed) return cs;
                    t=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_columnReference1047); if (failed) return cs;
                    c=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_columnReference1051); if (failed) return cs;

                    match(input, Token.UP, null); if (failed) return cs;
                    if ( backtracking==0 ) {
                      cs = new ColumnSpec(t.getText(),c.getText());
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:213:3: ^( COLUMNREF t= Identifier )
                    {
                    match(input,COLUMNREF,FOLLOW_COLUMNREF_in_columnReference1061); if (failed) return cs;

                    match(input, Token.DOWN, null); if (failed) return cs;
                    t=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_columnReference1065); if (failed) return cs;

                    match(input, Token.UP, null); if (failed) return cs;
                    if ( backtracking==0 ) {
                      cs = new ColumnSpec(null,t.getText());
                    }

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
            match(input,TABLEORCOL,FOLLOW_TABLEORCOL_in_tableOrColumn1090); if (failed) return tr;

            match(input, Token.DOWN, null); if (failed) return tr;
            match(input,Identifier,FOLLOW_Identifier_in_tableOrColumn1092); if (failed) return tr;

            match(input, Token.UP, null); if (failed) return tr;
            if ( backtracking==0 ) {
              tr =tc;
            }

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
                if (backtracking>0) {failed=true; return tr;}
                NoViableAltException nvae =
                    new NoViableAltException("223:1: function returns [CommonTree tr] : ( ^(fs= FUNCTIONSTAR functionName ) | ^(f= FUNCTION functionName ( ( expression )+ )? ) | ^(fd= FUNCTIONDIST functionName ( ( expression )+ )? ) );", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // QSpecBuilder2.g:225:3: ^(fs= FUNCTIONSTAR functionName )
                    {
                    fs=(CommonTree)input.LT(1);
                    match(input,FUNCTIONSTAR,FOLLOW_FUNCTIONSTAR_in_function1116); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_functionName_in_function1118);
                    functionName();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =fs;
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:226:3: ^(f= FUNCTION functionName ( ( expression )+ )? )
                    {
                    f=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_function1131); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_functionName_in_function1133);
                    functionName();
                    _fsp--;
                    if (failed) return tr;
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
                            	    if (failed) return tr;

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt40 >= 1 ) break loop40;
                            	    if (backtracking>0) {failed=true; return tr;}
                                        EarlyExitException eee =
                                            new EarlyExitException(40, input);
                                        throw eee;
                                }
                                cnt40++;
                            } while (true);


                            }
                            break;

                    }


                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =f;
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:227:3: ^(fd= FUNCTIONDIST functionName ( ( expression )+ )? )
                    {
                    fd=(CommonTree)input.LT(1);
                    match(input,FUNCTIONDIST,FOLLOW_FUNCTIONDIST_in_function1151); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_functionName_in_function1153);
                    functionName();
                    _fsp--;
                    if (failed) return tr;
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
                            	    if (failed) return tr;

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt42 >= 1 ) break loop42;
                            	    if (backtracking>0) {failed=true; return tr;}
                                        EarlyExitException eee =
                                            new EarlyExitException(42, input);
                                        throw eee;
                                }
                                cnt42++;
                            } while (true);


                            }
                            break;

                    }


                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =fd;
                    }

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
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
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
            match(input,FUNCTION,FOLLOW_FUNCTION_in_castExpr1240); if (failed) return tr;

            match(input, Token.DOWN, null); if (failed) return tr;
            pushFollow(FOLLOW_primitiveType_in_castExpr1242);
            primitiveType();
            _fsp--;
            if (failed) return tr;
            pushFollow(FOLLOW_expression_in_castExpr1244);
            expression();
            _fsp--;
            if (failed) return tr;

            match(input, Token.UP, null); if (failed) return tr;
            if ( backtracking==0 ) {
              tr = f;
            }

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
            match(input,FUNCTION,FOLLOW_FUNCTION_in_caseExpr1265); if (failed) return tr;

            match(input, Token.DOWN, null); if (failed) return tr;
            match(input,CASE,FOLLOW_CASE_in_caseExpr1267); if (failed) return tr;
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
            	    if (failed) return tr;

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            match(input, Token.UP, null); if (failed) return tr;
            if ( backtracking==0 ) {
              tr = f;
            }

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
            match(input,FUNCTION,FOLLOW_FUNCTION_in_whenExpr1293); if (failed) return tr;

            match(input, Token.DOWN, null); if (failed) return tr;
            match(input,WHEN,FOLLOW_WHEN_in_whenExpr1295); if (failed) return tr;
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
            	    if (failed) return tr;

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            match(input, Token.UP, null); if (failed) return tr;
            if ( backtracking==0 ) {
              tr = f;
            }

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
                if (backtracking>0) {failed=true; return tr;}
                NoViableAltException nvae =
                    new NoViableAltException("247:1: constant returns [CommonTree tr] : (n= Number | s= StringLiteral | sls= stringLiteralSequence | bl= BigintLiteral | sl= SmallintLiteral | tl= TinyintLiteral | csl= charSetStringLiteral | bv= booleanValue );", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // QSpecBuilder2.g:248:3: n= Number
                    {
                    n=(CommonTree)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_constant1318); if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = n; 
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:249:5: s= StringLiteral
                    {
                    s=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_constant1328); if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = s; 
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:250:5: sls= stringLiteralSequence
                    {
                    pushFollow(FOLLOW_stringLiteralSequence_in_constant1338);
                    sls=stringLiteralSequence();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = sls; 
                    }

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:251:5: bl= BigintLiteral
                    {
                    bl=(CommonTree)input.LT(1);
                    match(input,BigintLiteral,FOLLOW_BigintLiteral_in_constant1348); if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = bl; 
                    }

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:252:5: sl= SmallintLiteral
                    {
                    sl=(CommonTree)input.LT(1);
                    match(input,SmallintLiteral,FOLLOW_SmallintLiteral_in_constant1358); if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = sl; 
                    }

                    }
                    break;
                case 6 :
                    // QSpecBuilder2.g:253:5: tl= TinyintLiteral
                    {
                    tl=(CommonTree)input.LT(1);
                    match(input,TinyintLiteral,FOLLOW_TinyintLiteral_in_constant1368); if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = tl; 
                    }

                    }
                    break;
                case 7 :
                    // QSpecBuilder2.g:254:5: csl= charSetStringLiteral
                    {
                    pushFollow(FOLLOW_charSetStringLiteral_in_constant1378);
                    csl=charSetStringLiteral();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = csl; 
                    }

                    }
                    break;
                case 8 :
                    // QSpecBuilder2.g:255:5: bv= booleanValue
                    {
                    pushFollow(FOLLOW_booleanValue_in_constant1388);
                    bv=booleanValue();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = bv; 
                    }

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
            match(input,STRINGLITERALSEQUENCE,FOLLOW_STRINGLITERALSEQUENCE_in_stringLiteralSequence1410); if (failed) return tr;

            match(input, Token.DOWN, null); if (failed) return tr;
            match(input,StringLiteral,FOLLOW_StringLiteral_in_stringLiteralSequence1412); if (failed) return tr;
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
            	    match(input,StringLiteral,FOLLOW_StringLiteral_in_stringLiteralSequence1414); if (failed) return tr;

            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (backtracking>0) {failed=true; return tr;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);


            match(input, Token.UP, null); if (failed) return tr;
            if ( backtracking==0 ) {
               tr = s; 
            }

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
            match(input,CHARSETLITERAL,FOLLOW_CHARSETLITERAL_in_charSetStringLiteral1438); if (failed) return tr;

            match(input, Token.DOWN, null); if (failed) return tr;
            match(input,CharSetName,FOLLOW_CharSetName_in_charSetStringLiteral1440); if (failed) return tr;
            match(input,CharSetLiteral,FOLLOW_CharSetLiteral_in_charSetStringLiteral1442); if (failed) return tr;

            match(input, Token.UP, null); if (failed) return tr;
            if ( backtracking==0 ) {
               tr = c; 
            }

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
            	    if (failed) return ;

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
                if (backtracking>0) {failed=true; return tr;}
                NoViableAltException nvae =
                    new NoViableAltException("270:1: negatableOperator returns [CommonTree tr] : (l= LIKE | rl= RLIKE | rexp= REGEXP );", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // QSpecBuilder2.g:271:3: l= LIKE
                    {
                    l=(CommonTree)input.LT(1);
                    match(input,LIKE,FOLLOW_LIKE_in_negatableOperator1474); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =l;
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:272:3: rl= RLIKE
                    {
                    rl=(CommonTree)input.LT(1);
                    match(input,RLIKE,FOLLOW_RLIKE_in_negatableOperator1485); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =rl;
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:273:3: rexp= REGEXP
                    {
                    rexp=(CommonTree)input.LT(1);
                    match(input,REGEXP,FOLLOW_REGEXP_in_negatableOperator1496); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =rexp;
                    }

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
                if (backtracking>0) {failed=true; return tr;}
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
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =n;
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:278:3: e= EQUAL
                    {
                    e=(CommonTree)input.LT(1);
                    match(input,EQUAL,FOLLOW_EQUAL_in_compareOperator1527); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =e;
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:279:3: en= EQUAL_NS
                    {
                    en=(CommonTree)input.LT(1);
                    match(input,EQUAL_NS,FOLLOW_EQUAL_NS_in_compareOperator1538); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =en;
                    }

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:280:3: nte= NOTEQUAL
                    {
                    nte=(CommonTree)input.LT(1);
                    match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareOperator1549); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =nte;
                    }

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:281:3: lte= LESSTHANOREQUALTO
                    {
                    lte=(CommonTree)input.LT(1);
                    match(input,LESSTHANOREQUALTO,FOLLOW_LESSTHANOREQUALTO_in_compareOperator1560); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =lte;
                    }

                    }
                    break;
                case 6 :
                    // QSpecBuilder2.g:282:3: lt= LESSTHAN
                    {
                    lt=(CommonTree)input.LT(1);
                    match(input,LESSTHAN,FOLLOW_LESSTHAN_in_compareOperator1571); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =lt;
                    }

                    }
                    break;
                case 7 :
                    // QSpecBuilder2.g:283:3: gte= GREATERTHANOREQUALTO
                    {
                    gte=(CommonTree)input.LT(1);
                    match(input,GREATERTHANOREQUALTO,FOLLOW_GREATERTHANOREQUALTO_in_compareOperator1582); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =gte;
                    }

                    }
                    break;
                case 8 :
                    // QSpecBuilder2.g:284:3: gt= GREATERTHAN
                    {
                    gt=(CommonTree)input.LT(1);
                    match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_compareOperator1593); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =gt;
                    }

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
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
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
    // QSpecBuilder2.g:292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ( NOT DOWN negatableOperator )=> ^(nOp= NOT ^( negatableOperator expression expression ) ) | ( NOT DOWN FUNCTION )=> ^(fInF= NOT ^( FUNCTION IN expression expressions ) ) | ^(nt= NOT expression ) | ^(cOp= compareOperator expression expression ) | ^(fInT= FUNCTION IN expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );
    public final CommonTree expression() throws RecognitionException {
        CommonTree tr = null;

        CommonTree or=null;
        CommonTree ad=null;
        CommonTree nOp=null;
        CommonTree fInF=null;
        CommonTree nt=null;
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
        CommonTree cOp = null;

        CommonTree c = null;

        CommonTree f = null;

        CommonTree cs = null;

        CommonTree cse = null;

        CommonTree whn = null;

        CommonTree tc = null;


        try {
            // QSpecBuilder2.g:292:36: ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ( NOT DOWN negatableOperator )=> ^(nOp= NOT ^( negatableOperator expression expression ) ) | ( NOT DOWN FUNCTION )=> ^(fInF= NOT ^( FUNCTION IN expression expressions ) ) | ^(nt= NOT expression ) | ^(cOp= compareOperator expression expression ) | ^(fInT= FUNCTION IN expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn )
            int alt54=29;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // QSpecBuilder2.g:293:3: ^(or= OR expression expression )
                    {
                    or=(CommonTree)input.LT(1);
                    match(input,OR,FOLLOW_OR_in_expression1631); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1633);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1635);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =or;
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:294:3: ^(ad= AND expression expression )
                    {
                    ad=(CommonTree)input.LT(1);
                    match(input,AND,FOLLOW_AND_in_expression1646); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1648);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1650);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =ad;
                    }

                    }
                    break;
                case 3 :
                    // QSpecBuilder2.g:295:3: ( NOT DOWN negatableOperator )=> ^(nOp= NOT ^( negatableOperator expression expression ) )
                    {
                    nOp=(CommonTree)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_expression1670); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_negatableOperator_in_expression1674);
                    negatableOperator();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1676);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1679);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =nOp;
                    }

                    }
                    break;
                case 4 :
                    // QSpecBuilder2.g:296:3: ( NOT DOWN FUNCTION )=> ^(fInF= NOT ^( FUNCTION IN expression expressions ) )
                    {
                    fInF=(CommonTree)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_expression1702); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1706); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    match(input,IN,FOLLOW_IN_in_expression1708); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1711);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expressions_in_expression1713);
                    expressions();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =fInF;
                    }

                    }
                    break;
                case 5 :
                    // QSpecBuilder2.g:297:3: ^(nt= NOT expression )
                    {
                    nt=(CommonTree)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_expression1726); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1728);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =nt;
                    }

                    }
                    break;
                case 6 :
                    // QSpecBuilder2.g:298:3: ^(cOp= compareOperator expression expression )
                    {
                    pushFollow(FOLLOW_compareOperator_in_expression1741);
                    cOp=compareOperator();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1743);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1745);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =cOp;
                    }

                    }
                    break;
                case 7 :
                    // QSpecBuilder2.g:299:3: ^(fInT= FUNCTION IN expression expressions )
                    {
                    fInT=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1758); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    match(input,IN,FOLLOW_IN_in_expression1760); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1763);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expressions_in_expression1765);
                    expressions();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =fInT;
                    }

                    }
                    break;
                case 8 :
                    // QSpecBuilder2.g:300:3: ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression )
                    {
                    fBtF=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1777); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    match(input,BETWEEN,FOLLOW_BETWEEN_in_expression1779); if (failed) return tr;
                    match(input,FALSE,FOLLOW_FALSE_in_expression1781); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1783);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1785);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1787);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =fBtF;
                    }

                    }
                    break;
                case 9 :
                    // QSpecBuilder2.g:301:3: ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression )
                    {
                    fBtT=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1799); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    match(input,BETWEEN,FOLLOW_BETWEEN_in_expression1801); if (failed) return tr;
                    match(input,TRUE,FOLLOW_TRUE_in_expression1803); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1805);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1807);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1809);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =fBtT;
                    }

                    }
                    break;
                case 10 :
                    // QSpecBuilder2.g:302:3: ^(bitOr= BITWISEOR expression expression )
                    {
                    bitOr=(CommonTree)input.LT(1);
                    match(input,BITWISEOR,FOLLOW_BITWISEOR_in_expression1821); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1823);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1825);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =bitOr;
                    }

                    }
                    break;
                case 11 :
                    // QSpecBuilder2.g:303:3: ^(amp= AMPERSAND expression expression )
                    {
                    amp=(CommonTree)input.LT(1);
                    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_expression1837); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1839);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1841);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =amp;
                    }

                    }
                    break;
                case 12 :
                    // QSpecBuilder2.g:304:3: ^(plus= PLUS expression ( expression )? )
                    {
                    plus=(CommonTree)input.LT(1);
                    match(input,PLUS,FOLLOW_PLUS_in_expression1853); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1855);
                    expression();
                    _fsp--;
                    if (failed) return tr;
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
                            pushFollow(FOLLOW_expression_in_expression1857);
                            expression();
                            _fsp--;
                            if (failed) return tr;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =plus;
                    }

                    }
                    break;
                case 13 :
                    // QSpecBuilder2.g:305:3: ^(minus= MINUS expression ( expression )? )
                    {
                    minus=(CommonTree)input.LT(1);
                    match(input,MINUS,FOLLOW_MINUS_in_expression1870); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1872);
                    expression();
                    _fsp--;
                    if (failed) return tr;
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
                            pushFollow(FOLLOW_expression_in_expression1874);
                            expression();
                            _fsp--;
                            if (failed) return tr;

                            }
                            break;

                    }


                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =minus;
                    }

                    }
                    break;
                case 14 :
                    // QSpecBuilder2.g:306:3: ^(star= STAR expression expression )
                    {
                    star=(CommonTree)input.LT(1);
                    match(input,STAR,FOLLOW_STAR_in_expression1887); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1889);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1891);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =star;
                    }

                    }
                    break;
                case 15 :
                    // QSpecBuilder2.g:307:3: ^(divide= DIVIDE expression expression )
                    {
                    divide=(CommonTree)input.LT(1);
                    match(input,DIVIDE,FOLLOW_DIVIDE_in_expression1903); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1905);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1907);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =divide;
                    }

                    }
                    break;
                case 16 :
                    // QSpecBuilder2.g:308:3: ^(mod= MOD expression expression )
                    {
                    mod=(CommonTree)input.LT(1);
                    match(input,MOD,FOLLOW_MOD_in_expression1919); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1921);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1923);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =mod;
                    }

                    }
                    break;
                case 17 :
                    // QSpecBuilder2.g:309:3: ^(div= DIV expression expression )
                    {
                    div=(CommonTree)input.LT(1);
                    match(input,DIV,FOLLOW_DIV_in_expression1935); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1937);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1939);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =div;
                    }

                    }
                    break;
                case 18 :
                    // QSpecBuilder2.g:310:3: ^(bitxor= BITWISEXOR expression expression )
                    {
                    bitxor=(CommonTree)input.LT(1);
                    match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_expression1952); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1954);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1956);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =bitxor;
                    }

                    }
                    break;
                case 19 :
                    // QSpecBuilder2.g:311:3: ^(fnNull= FUNCTION nullCondition expression )
                    {
                    fnNull=(CommonTree)input.LT(1);
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_expression1968); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_nullCondition_in_expression1970);
                    nullCondition();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1972);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =fnNull;
                    }

                    }
                    break;
                case 20 :
                    // QSpecBuilder2.g:314:3: ^(tilde= TILDE expression )
                    {
                    tilde=(CommonTree)input.LT(1);
                    match(input,TILDE,FOLLOW_TILDE_in_expression1986); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression1988);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =tilde;
                    }

                    }
                    break;
                case 21 :
                    // QSpecBuilder2.g:315:3: ^(arry= LSQUARE expression expression )
                    {
                    arry=(CommonTree)input.LT(1);
                    match(input,LSQUARE,FOLLOW_LSQUARE_in_expression2001); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression2003);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression2005);
                    expression();
                    _fsp--;
                    if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =arry;
                    }

                    }
                    break;
                case 22 :
                    // QSpecBuilder2.g:316:3: ^(dot= DOT expression Identifier )
                    {
                    dot=(CommonTree)input.LT(1);
                    match(input,DOT,FOLLOW_DOT_in_expression2017); if (failed) return tr;

                    match(input, Token.DOWN, null); if (failed) return tr;
                    pushFollow(FOLLOW_expression_in_expression2019);
                    expression();
                    _fsp--;
                    if (failed) return tr;
                    match(input,Identifier,FOLLOW_Identifier_in_expression2021); if (failed) return tr;

                    match(input, Token.UP, null); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =dot;
                    }

                    }
                    break;
                case 23 :
                    // QSpecBuilder2.g:317:3: nl= NULL
                    {
                    nl=(CommonTree)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_expression2033); if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =nl;
                    }

                    }
                    break;
                case 24 :
                    // QSpecBuilder2.g:318:3: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_expression2043);
                    c=constant();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr = c;
                    }

                    }
                    break;
                case 25 :
                    // QSpecBuilder2.g:319:3: f= function
                    {
                    pushFollow(FOLLOW_function_in_expression2054);
                    f=function();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr = f;
                    }

                    }
                    break;
                case 26 :
                    // QSpecBuilder2.g:320:3: cs= castExpr
                    {
                    pushFollow(FOLLOW_castExpr_in_expression2065);
                    cs=castExpr();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr = cs;
                    }

                    }
                    break;
                case 27 :
                    // QSpecBuilder2.g:321:3: cse= caseExpr
                    {
                    pushFollow(FOLLOW_caseExpr_in_expression2076);
                    cse=caseExpr();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr = cse;
                    }

                    }
                    break;
                case 28 :
                    // QSpecBuilder2.g:322:3: whn= whenExpr
                    {
                    pushFollow(FOLLOW_whenExpr_in_expression2087);
                    whn=whenExpr();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr = whn;
                    }

                    }
                    break;
                case 29 :
                    // QSpecBuilder2.g:323:3: tc= tableOrColumn
                    {
                    pushFollow(FOLLOW_tableOrColumn_in_expression2098);
                    tc=tableOrColumn();
                    _fsp--;
                    if (failed) return tr;
                    if ( backtracking==0 ) {
                      tr =tc;
                    }

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
                if (backtracking>0) {failed=true; return tr;}
                NoViableAltException nvae =
                    new NoViableAltException("326:1: booleanValue returns [CommonTree tr] : (t= TRUE | f= FALSE );", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // QSpecBuilder2.g:328:5: t= TRUE
                    {
                    t=(CommonTree)input.LT(1);
                    match(input,TRUE,FOLLOW_TRUE_in_booleanValue2123); if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = t; 
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:329:5: f= FALSE
                    {
                    f=(CommonTree)input.LT(1);
                    match(input,FALSE,FOLLOW_FALSE_in_booleanValue2136); if (failed) return tr;
                    if ( backtracking==0 ) {
                       tr = f; 
                    }

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
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
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

                    if ( (LA56_2==Identifier) ) {
                        alt56=1;
                    }
                    else if ( (LA56_2==StringLiteral) ) {
                        alt56=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("347:1: namevalue[INameValueList properties] : ( ^( PARAM n= Identifier v= StringLiteral ) | ^( PARAM n= StringLiteral v= StringLiteral ) );", 56, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("347:1: namevalue[INameValueList properties] : ( ^( PARAM n= Identifier v= StringLiteral ) | ^( PARAM n= StringLiteral v= StringLiteral ) );", 56, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("347:1: namevalue[INameValueList properties] : ( ^( PARAM n= Identifier v= StringLiteral ) | ^( PARAM n= StringLiteral v= StringLiteral ) );", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // QSpecBuilder2.g:348:2: ^( PARAM n= Identifier v= StringLiteral )
                    {
                    match(input,PARAM,FOLLOW_PARAM_in_namevalue2261); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    n=(CommonTree)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_namevalue2265); if (failed) return ;
                    v=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_namevalue2269); if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;
                    if ( backtracking==0 ) {
                      properties.add(n.getText(), v.getText());
                    }

                    }
                    break;
                case 2 :
                    // QSpecBuilder2.g:349:2: ^( PARAM n= StringLiteral v= StringLiteral )
                    {
                    match(input,PARAM,FOLLOW_PARAM_in_namevalue2278); if (failed) return ;

                    match(input, Token.DOWN, null); if (failed) return ;
                    n=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_namevalue2282); if (failed) return ;
                    v=(CommonTree)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_namevalue2286); if (failed) return ;

                    match(input, Token.UP, null); if (failed) return ;
                    if ( backtracking==0 ) {
                      properties.add(n.getText(), v.getText());
                    }

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

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // QSpecBuilder2.g:295:3: ( NOT DOWN negatableOperator )
        // QSpecBuilder2.g:295:4: NOT DOWN negatableOperator
        {
        match(input,NOT,FOLLOW_NOT_in_synpred11659); if (failed) return ;
        match(input,DOWN,FOLLOW_DOWN_in_synpred11661); if (failed) return ;
        pushFollow(FOLLOW_negatableOperator_in_synpred11663);
        negatableOperator();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // QSpecBuilder2.g:296:3: ( NOT DOWN FUNCTION )
        // QSpecBuilder2.g:296:4: NOT DOWN FUNCTION
        {
        match(input,NOT,FOLLOW_NOT_in_synpred21691); if (failed) return ;
        match(input,DOWN,FOLLOW_DOWN_in_synpred21693); if (failed) return ;
        match(input,FUNCTION,FOLLOW_FUNCTION_in_synpred21695); if (failed) return ;

        }
    }
    // $ANTLR end synpred2

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


    protected DFA54 dfa54 = new DFA54(this);
    static final String DFA54_eotS =
        "\u061b\uffff";
    static final String DFA54_eofS =
        "\u061b\uffff";
    static final String DFA54_minS =
        "\1\11\2\uffff\1\2\1\uffff\1\2\20\uffff\1\11\1\26\4\2\1\uffff\1\171"+
        "\5\uffff\1\26\1\11\2\uffff\1\11\32\2\3\11\1\2\3\11\1\2\2\11\35\2"+
        "\3\3\1\2\3\3\1\2\2\3\3\2\4\11\1\26\14\11\32\2\3\3\1\2\3\3\1\2\2"+
        "\3\3\2\1\62\1\136\3\50\4\11\1\26\14\11\32\2\3\3\1\2\3\3\1\2\2\3"+
        "\3\2\1\3\1\62\1\136\3\50\5\2\u0525\0";
    static final String DFA54_maxS =
        "\1\172\2\uffff\1\2\1\uffff\1\2\20\uffff\1\172\1\u0086\4\2\1\uffff"+
        "\1\172\5\uffff\1\u0086\1\172\2\uffff\1\172\32\2\3\172\1\2\3\172"+
        "\1\2\2\172\35\2\3\172\1\2\3\172\1\2\2\172\3\2\4\172\1\u0086\14\172"+
        "\32\2\3\3\1\2\3\3\1\2\2\3\3\2\1\62\1\136\2\124\1\50\4\172\1\u0086"+
        "\14\172\32\2\3\172\1\2\3\172\1\2\2\172\3\2\1\3\1\62\1\136\2\124"+
        "\1\50\5\2\u0525\0";
    static final String DFA54_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\6\1\uffff\1\12\1\13\1\14\1\15\1\16\1"+
        "\17\1\20\1\21\1\22\1\24\1\25\1\26\1\27\1\30\1\31\1\35\6\uffff\1"+
        "\5\1\uffff\1\33\1\34\1\7\1\23\1\32\2\uffff\1\11\1\10\u05f4\uffff";
    static final String DFA54_specialS =
        "\u061b\uffff}>";
    static final String[] DFA54_transitionS = {
            "\1\5\12\uffff\2\23\1\uffff\2\24\2\uffff\1\25\16\uffff\1\21\6"+
            "\uffff\1\4\1\23\11\uffff\1\12\11\uffff\1\2\5\uffff\1\23\16\uffff"+
            "\3\23\2\uffff\1\1\1\3\11\4\1\uffff\1\6\1\7\1\10\1\11\1\13\1"+
            "\14\1\15\1\16\1\22\1\uffff\1\17\1\20\1\uffff\2\23",
            "",
            "",
            "\1\26",
            "",
            "\1\27",
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
            "",
            "",
            "",
            "",
            "",
            "\1\30\12\uffff\2\34\1\uffff\2\34\2\uffff\1\34\16\uffff\1\34"+
            "\6\uffff\2\34\11\uffff\1\34\11\uffff\1\34\5\uffff\1\34\16\uffff"+
            "\3\34\2\uffff\2\34\1\31\1\32\1\33\6\34\1\uffff\11\34\1\uffff"+
            "\2\34\1\uffff\2\34",
            "\1\41\21\uffff\1\24\34\uffff\1\35\12\uffff\5\24\1\uffff\1\36"+
            "\1\37\23\uffff\1\40\10\uffff\1\41\6\uffff\14\42",
            "\1\43",
            "\1\44",
            "\1\44",
            "\1\44",
            "",
            "\1\45\1\46",
            "",
            "",
            "",
            "",
            "",
            "\1\34\21\uffff\1\34\34\uffff\1\34\12\uffff\5\34\1\uffff\2\34"+
            "\23\uffff\1\47\10\uffff\1\34\6\uffff\14\34",
            "\1\65\12\uffff\1\105\1\111\1\uffff\1\114\1\115\2\uffff\1\116"+
            "\16\uffff\1\101\6\uffff\1\56\1\104\11\uffff\1\72\11\uffff\1"+
            "\51\5\uffff\1\103\16\uffff\1\106\1\107\1\110\2\uffff\1\50\1"+
            "\52\1\53\1\54\1\55\1\57\1\60\1\61\1\62\1\63\1\64\1\uffff\1\66"+
            "\1\67\1\70\1\71\1\73\1\74\1\75\1\76\1\102\1\uffff\1\77\1\100"+
            "\1\uffff\1\112\1\113",
            "",
            "",
            "\1\134\12\uffff\1\154\1\160\1\uffff\1\163\1\164\2\uffff\1\165"+
            "\16\uffff\1\150\6\uffff\1\125\1\153\11\uffff\1\141\11\uffff"+
            "\1\120\5\uffff\1\152\16\uffff\1\155\1\156\1\157\2\uffff\1\117"+
            "\1\121\1\122\1\123\1\124\1\126\1\127\1\130\1\131\1\132\1\133"+
            "\1\uffff\1\135\1\136\1\137\1\140\1\142\1\143\1\144\1\145\1\151"+
            "\1\uffff\1\146\1\147\1\uffff\1\161\1\162",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\171",
            "\1\171",
            "\1\171",
            "\1\171",
            "\1\171",
            "\1\171",
            "\1\171",
            "\1\171",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0094\12\uffff\1\u00a4\1\u00a8\1\uffff\1\u00ab\1\u00ac\2"+
            "\uffff\1\u00ad\16\uffff\1\u00a0\6\uffff\1\u008d\1\u00a3\11\uffff"+
            "\1\u0099\11\uffff\1\u0088\5\uffff\1\u00a2\16\uffff\1\u00a5\1"+
            "\u00a6\1\u00a7\2\uffff\1\u0087\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\uffff\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\u00a1"+
            "\1\uffff\1\u009e\1\u009f\1\uffff\1\u00a9\1\u00aa",
            "\1\u0094\12\uffff\1\u00a4\1\u00a8\1\uffff\1\u00ab\1\u00ac\2"+
            "\uffff\1\u00ad\16\uffff\1\u00a0\6\uffff\1\u008d\1\u00a3\11\uffff"+
            "\1\u0099\11\uffff\1\u0088\5\uffff\1\u00a2\16\uffff\1\u00a5\1"+
            "\u00a6\1\u00a7\2\uffff\1\u0087\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\uffff\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\u00a1"+
            "\1\uffff\1\u009e\1\u009f\1\uffff\1\u00a9\1\u00aa",
            "\1\u0094\12\uffff\1\u00a4\1\u00a8\1\uffff\1\u00ab\1\u00ac\2"+
            "\uffff\1\u00ad\16\uffff\1\u00a0\6\uffff\1\u008d\1\u00a3\11\uffff"+
            "\1\u0099\11\uffff\1\u0088\5\uffff\1\u00a2\16\uffff\1\u00a5\1"+
            "\u00a6\1\u00a7\2\uffff\1\u0087\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\uffff\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\u00a1"+
            "\1\uffff\1\u009e\1\u009f\1\uffff\1\u00a9\1\u00aa",
            "\1\u00ae",
            "\1\u0094\12\uffff\1\u00a4\1\u00a8\1\uffff\1\u00ab\1\u00ac\2"+
            "\uffff\1\u00ad\16\uffff\1\u00a0\6\uffff\1\u008d\1\u00a3\11\uffff"+
            "\1\u0099\11\uffff\1\u0088\5\uffff\1\u00a2\16\uffff\1\u00a5\1"+
            "\u00a6\1\u00a7\2\uffff\1\u0087\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\uffff\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\u00a1"+
            "\1\uffff\1\u009e\1\u009f\1\uffff\1\u00a9\1\u00aa",
            "\1\u0094\12\uffff\1\u00a4\1\u00a8\1\uffff\1\u00ab\1\u00ac\2"+
            "\uffff\1\u00ad\16\uffff\1\u00a0\6\uffff\1\u008d\1\u00a3\11\uffff"+
            "\1\u0099\11\uffff\1\u0088\5\uffff\1\u00a2\16\uffff\1\u00a5\1"+
            "\u00a6\1\u00a7\2\uffff\1\u0087\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\uffff\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\u00a1"+
            "\1\uffff\1\u009e\1\u009f\1\uffff\1\u00a9\1\u00aa",
            "\1\u0094\12\uffff\1\u00a4\1\u00a8\1\uffff\1\u00ab\1\u00ac\2"+
            "\uffff\1\u00ad\16\uffff\1\u00a0\6\uffff\1\u008d\1\u00a3\11\uffff"+
            "\1\u0099\11\uffff\1\u0088\5\uffff\1\u00a2\16\uffff\1\u00a5\1"+
            "\u00a6\1\u00a7\2\uffff\1\u0087\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\uffff\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\u00a1"+
            "\1\uffff\1\u009e\1\u009f\1\uffff\1\u00a9\1\u00aa",
            "\1\u00af",
            "\1\u0094\12\uffff\1\u00a4\1\u00a8\1\uffff\1\u00ab\1\u00ac\2"+
            "\uffff\1\u00ad\16\uffff\1\u00a0\6\uffff\1\u008d\1\u00a3\11\uffff"+
            "\1\u0099\11\uffff\1\u0088\5\uffff\1\u00a2\16\uffff\1\u00a5\1"+
            "\u00a6\1\u00a7\2\uffff\1\u0087\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\uffff\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\u00a1"+
            "\1\uffff\1\u009e\1\u009f\1\uffff\1\u00a9\1\u00aa",
            "\1\u0094\12\uffff\1\u00a4\1\u00a8\1\uffff\1\u00ab\1\u00ac\2"+
            "\uffff\1\u00ad\16\uffff\1\u00a0\6\uffff\1\u008d\1\u00a3\11\uffff"+
            "\1\u0099\11\uffff\1\u0088\5\uffff\1\u00a2\16\uffff\1\u00a5\1"+
            "\u00a6\1\u00a7\2\uffff\1\u0087\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\uffff\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u009a\1\u009b\1\u009c\1\u009d\1\u00a1"+
            "\1\uffff\1\u009e\1\u009f\1\uffff\1\u00a9\1\u00aa",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00ec",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00ed",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00fe\12\uffff\1\u010e\1\u0112\1\uffff\1\u0115\1\u0116\2"+
            "\uffff\1\u0117\16\uffff\1\u010a\6\uffff\1\u00f7\1\u010d\11\uffff"+
            "\1\u0103\11\uffff\1\u00f2\5\uffff\1\u010c\16\uffff\1\u010f\1"+
            "\u0110\1\u0111\2\uffff\1\u00f1\1\u00f3\1\u00f4\1\u00f5\1\u00f6"+
            "\1\u00f8\1\u00f9\1\u00fa\1\u00fb\1\u00fc\1\u00fd\1\uffff\1\u00ff"+
            "\1\u0100\1\u0101\1\u0102\1\u0104\1\u0105\1\u0106\1\u0107\1\u010b"+
            "\1\uffff\1\u0108\1\u0109\1\uffff\1\u0113\1\u0114",
            "\1\u0125\12\uffff\1\u0135\1\u0139\1\uffff\1\u013c\1\u013d\2"+
            "\uffff\1\u013e\16\uffff\1\u0131\6\uffff\1\u011e\1\u0134\11\uffff"+
            "\1\u012a\11\uffff\1\u0119\5\uffff\1\u0133\16\uffff\1\u0136\1"+
            "\u0137\1\u0138\2\uffff\1\u0118\1\u011a\1\u011b\1\u011c\1\u011d"+
            "\1\u011f\1\u0120\1\u0121\1\u0122\1\u0123\1\u0124\1\uffff\1\u0126"+
            "\1\u0127\1\u0128\1\u0129\1\u012b\1\u012c\1\u012d\1\u012e\1\u0132"+
            "\1\uffff\1\u012f\1\u0130\1\uffff\1\u013a\1\u013b",
            "\1\u013f\12\uffff\1\u015c\1\u0160\1\uffff\1\u0163\1\u0164\2"+
            "\uffff\1\u0165\16\uffff\1\u0158\6\uffff\1\u0146\1\u015b\11\uffff"+
            "\1\u0151\11\uffff\1\u0144\5\uffff\1\u015a\16\uffff\1\u015d\1"+
            "\u015e\1\u015f\2\uffff\1\u0143\1\u0145\1\u0140\1\u0141\1\u0142"+
            "\1\u0147\1\u0148\1\u0149\1\u014a\1\u014b\1\u014c\1\uffff\1\u014d"+
            "\1\u014e\1\u014f\1\u0150\1\u0152\1\u0153\1\u0154\1\u0155\1\u0159"+
            "\1\uffff\1\u0156\1\u0157\1\uffff\1\u0161\1\u0162",
            "\1\u0173\12\uffff\1\u0183\1\u0187\1\uffff\1\u018a\1\u018b\2"+
            "\uffff\1\u018c\16\uffff\1\u017f\6\uffff\1\u016c\1\u0182\11\uffff"+
            "\1\u0178\11\uffff\1\u0167\5\uffff\1\u0181\16\uffff\1\u0184\1"+
            "\u0185\1\u0186\2\uffff\1\u0166\1\u0168\1\u0169\1\u016a\1\u016b"+
            "\1\u016d\1\u016e\1\u016f\1\u0170\1\u0171\1\u0172\1\uffff\1\u0174"+
            "\1\u0175\1\u0176\1\u0177\1\u0179\1\u017a\1\u017b\1\u017c\1\u0180"+
            "\1\uffff\1\u017d\1\u017e\1\uffff\1\u0188\1\u0189",
            "\1\u0191\21\uffff\1\u0193\34\uffff\1\u018f\12\uffff\5\u0193"+
            "\1\uffff\1\u018e\1\u018d\23\uffff\1\u0190\10\uffff\1\u0191\6"+
            "\uffff\14\u0192",
            "\1\u01a1\12\uffff\1\u01b1\1\u01b5\1\uffff\1\u01b8\1\u01b9\2"+
            "\uffff\1\u01ba\16\uffff\1\u01ad\6\uffff\1\u019a\1\u01b0\11\uffff"+
            "\1\u01a6\11\uffff\1\u0195\5\uffff\1\u01af\16\uffff\1\u01b2\1"+
            "\u01b3\1\u01b4\2\uffff\1\u0194\1\u0196\1\u0197\1\u0198\1\u0199"+
            "\1\u019b\1\u019c\1\u019d\1\u019e\1\u019f\1\u01a0\1\uffff\1\u01a2"+
            "\1\u01a3\1\u01a4\1\u01a5\1\u01a7\1\u01a8\1\u01a9\1\u01aa\1\u01ae"+
            "\1\uffff\1\u01ab\1\u01ac\1\uffff\1\u01b6\1\u01b7",
            "\1\u01c8\12\uffff\1\u01d8\1\u01dc\1\uffff\1\u01df\1\u01e0\2"+
            "\uffff\1\u01e1\16\uffff\1\u01d4\6\uffff\1\u01c1\1\u01d7\11\uffff"+
            "\1\u01cd\11\uffff\1\u01bc\5\uffff\1\u01d6\16\uffff\1\u01d9\1"+
            "\u01da\1\u01db\2\uffff\1\u01bb\1\u01bd\1\u01be\1\u01bf\1\u01c0"+
            "\1\u01c2\1\u01c3\1\u01c4\1\u01c5\1\u01c6\1\u01c7\1\uffff\1\u01c9"+
            "\1\u01ca\1\u01cb\1\u01cc\1\u01ce\1\u01cf\1\u01d0\1\u01d1\1\u01d5"+
            "\1\uffff\1\u01d2\1\u01d3\1\uffff\1\u01dd\1\u01de",
            "\1\u01ef\12\uffff\1\u01ff\1\u0203\1\uffff\1\u0206\1\u0207\2"+
            "\uffff\1\u0208\16\uffff\1\u01fb\6\uffff\1\u01e8\1\u01fe\11\uffff"+
            "\1\u01f4\11\uffff\1\u01e3\5\uffff\1\u01fd\16\uffff\1\u0200\1"+
            "\u0201\1\u0202\2\uffff\1\u01e2\1\u01e4\1\u01e5\1\u01e6\1\u01e7"+
            "\1\u01e9\1\u01ea\1\u01eb\1\u01ec\1\u01ed\1\u01ee\1\uffff\1\u01f0"+
            "\1\u01f1\1\u01f2\1\u01f3\1\u01f5\1\u01f6\1\u01f7\1\u01f8\1\u01fc"+
            "\1\uffff\1\u01f9\1\u01fa\1\uffff\1\u0204\1\u0205",
            "\1\u0216\12\uffff\1\u0226\1\u022a\1\uffff\1\u022d\1\u022e\2"+
            "\uffff\1\u022f\16\uffff\1\u0222\6\uffff\1\u020f\1\u0225\11\uffff"+
            "\1\u021b\11\uffff\1\u020a\5\uffff\1\u0224\16\uffff\1\u0227\1"+
            "\u0228\1\u0229\2\uffff\1\u0209\1\u020b\1\u020c\1\u020d\1\u020e"+
            "\1\u0210\1\u0211\1\u0212\1\u0213\1\u0214\1\u0215\1\uffff\1\u0217"+
            "\1\u0218\1\u0219\1\u021a\1\u021c\1\u021d\1\u021e\1\u021f\1\u0223"+
            "\1\uffff\1\u0220\1\u0221\1\uffff\1\u022b\1\u022c",
            "\1\u023d\12\uffff\1\u024d\1\u0251\1\uffff\1\u0254\1\u0255\2"+
            "\uffff\1\u0256\16\uffff\1\u0249\6\uffff\1\u0236\1\u024c\11\uffff"+
            "\1\u0242\11\uffff\1\u0231\5\uffff\1\u024b\16\uffff\1\u024e\1"+
            "\u024f\1\u0250\2\uffff\1\u0230\1\u0232\1\u0233\1\u0234\1\u0235"+
            "\1\u0237\1\u0238\1\u0239\1\u023a\1\u023b\1\u023c\1\uffff\1\u023e"+
            "\1\u023f\1\u0240\1\u0241\1\u0243\1\u0244\1\u0245\1\u0246\1\u024a"+
            "\1\uffff\1\u0247\1\u0248\1\uffff\1\u0252\1\u0253",
            "\1\u0264\12\uffff\1\u0274\1\u0278\1\uffff\1\u027b\1\u027c\2"+
            "\uffff\1\u027d\16\uffff\1\u0270\6\uffff\1\u025d\1\u0273\11\uffff"+
            "\1\u0269\11\uffff\1\u0258\5\uffff\1\u0272\16\uffff\1\u0275\1"+
            "\u0276\1\u0277\2\uffff\1\u0257\1\u0259\1\u025a\1\u025b\1\u025c"+
            "\1\u025e\1\u025f\1\u0260\1\u0261\1\u0262\1\u0263\1\uffff\1\u0265"+
            "\1\u0266\1\u0267\1\u0268\1\u026a\1\u026b\1\u026c\1\u026d\1\u0271"+
            "\1\uffff\1\u026e\1\u026f\1\uffff\1\u0279\1\u027a",
            "\1\u028b\12\uffff\1\u029b\1\u029f\1\uffff\1\u02a2\1\u02a3\2"+
            "\uffff\1\u02a4\16\uffff\1\u0297\6\uffff\1\u0284\1\u029a\11\uffff"+
            "\1\u0290\11\uffff\1\u027f\5\uffff\1\u0299\16\uffff\1\u029c\1"+
            "\u029d\1\u029e\2\uffff\1\u027e\1\u0280\1\u0281\1\u0282\1\u0283"+
            "\1\u0285\1\u0286\1\u0287\1\u0288\1\u0289\1\u028a\1\uffff\1\u028c"+
            "\1\u028d\1\u028e\1\u028f\1\u0291\1\u0292\1\u0293\1\u0294\1\u0298"+
            "\1\uffff\1\u0295\1\u0296\1\uffff\1\u02a0\1\u02a1",
            "\1\u02b2\12\uffff\1\u02c2\1\u02c6\1\uffff\1\u02c9\1\u02ca\2"+
            "\uffff\1\u02cb\16\uffff\1\u02be\6\uffff\1\u02ab\1\u02c1\11\uffff"+
            "\1\u02b7\11\uffff\1\u02a6\5\uffff\1\u02c0\16\uffff\1\u02c3\1"+
            "\u02c4\1\u02c5\2\uffff\1\u02a5\1\u02a7\1\u02a8\1\u02a9\1\u02aa"+
            "\1\u02ac\1\u02ad\1\u02ae\1\u02af\1\u02b0\1\u02b1\1\uffff\1\u02b3"+
            "\1\u02b4\1\u02b5\1\u02b6\1\u02b8\1\u02b9\1\u02ba\1\u02bb\1\u02bf"+
            "\1\uffff\1\u02bc\1\u02bd\1\uffff\1\u02c7\1\u02c8",
            "\1\u02d9\12\uffff\1\u02e9\1\u02ed\1\uffff\1\u02f0\1\u02f1\2"+
            "\uffff\1\u02f2\16\uffff\1\u02e5\6\uffff\1\u02d2\1\u02e8\11\uffff"+
            "\1\u02de\11\uffff\1\u02cd\5\uffff\1\u02e7\16\uffff\1\u02ea\1"+
            "\u02eb\1\u02ec\2\uffff\1\u02cc\1\u02ce\1\u02cf\1\u02d0\1\u02d1"+
            "\1\u02d3\1\u02d4\1\u02d5\1\u02d6\1\u02d7\1\u02d8\1\uffff\1\u02da"+
            "\1\u02db\1\u02dc\1\u02dd\1\u02df\1\u02e0\1\u02e1\1\u02e2\1\u02e6"+
            "\1\uffff\1\u02e3\1\u02e4\1\uffff\1\u02ee\1\u02ef",
            "\1\u0300\12\uffff\1\u0310\1\u0314\1\uffff\1\u0317\1\u0318\2"+
            "\uffff\1\u0319\16\uffff\1\u030c\6\uffff\1\u02f9\1\u030f\11\uffff"+
            "\1\u0305\11\uffff\1\u02f4\5\uffff\1\u030e\16\uffff\1\u0311\1"+
            "\u0312\1\u0313\2\uffff\1\u02f3\1\u02f5\1\u02f6\1\u02f7\1\u02f8"+
            "\1\u02fa\1\u02fb\1\u02fc\1\u02fd\1\u02fe\1\u02ff\1\uffff\1\u0301"+
            "\1\u0302\1\u0303\1\u0304\1\u0306\1\u0307\1\u0308\1\u0309\1\u030d"+
            "\1\uffff\1\u030a\1\u030b\1\uffff\1\u0315\1\u0316",
            "\1\u0327\12\uffff\1\u0337\1\u033b\1\uffff\1\u033e\1\u033f\2"+
            "\uffff\1\u0340\16\uffff\1\u0333\6\uffff\1\u0320\1\u0336\11\uffff"+
            "\1\u032c\11\uffff\1\u031b\5\uffff\1\u0335\16\uffff\1\u0338\1"+
            "\u0339\1\u033a\2\uffff\1\u031a\1\u031c\1\u031d\1\u031e\1\u031f"+
            "\1\u0321\1\u0322\1\u0323\1\u0324\1\u0325\1\u0326\1\uffff\1\u0328"+
            "\1\u0329\1\u032a\1\u032b\1\u032d\1\u032e\1\u032f\1\u0330\1\u0334"+
            "\1\uffff\1\u0331\1\u0332\1\uffff\1\u033c\1\u033d",
            "\1\u034e\12\uffff\1\u035e\1\u0362\1\uffff\1\u0365\1\u0366\2"+
            "\uffff\1\u0367\16\uffff\1\u035a\6\uffff\1\u0347\1\u035d\11\uffff"+
            "\1\u0353\11\uffff\1\u0342\5\uffff\1\u035c\16\uffff\1\u035f\1"+
            "\u0360\1\u0361\2\uffff\1\u0341\1\u0343\1\u0344\1\u0345\1\u0346"+
            "\1\u0348\1\u0349\1\u034a\1\u034b\1\u034c\1\u034d\1\uffff\1\u034f"+
            "\1\u0350\1\u0351\1\u0352\1\u0354\1\u0355\1\u0356\1\u0357\1\u035b"+
            "\1\uffff\1\u0358\1\u0359\1\uffff\1\u0363\1\u0364",
            "\1\u0368",
            "\1\u0369",
            "\1\u036a",
            "\1\u036b",
            "\1\u036b",
            "\1\u036b",
            "\1\u036b",
            "\1\u036b",
            "\1\u036b",
            "\1\u036b",
            "\1\u036b",
            "\1\u036b",
            "\1\u036b",
            "\1\u036c",
            "\1\u036d",
            "\1\u036e",
            "\1\u036f",
            "\1\u0370",
            "\1\u0371",
            "\1\u0372",
            "\1\u0373",
            "\1\u0374",
            "\1\u0375",
            "\1\u0376",
            "\1\u0377",
            "\1\u0378",
            "\1\u0379",
            "\1\u0379",
            "\1\u0379",
            "\1\u037a",
            "\1\u0379",
            "\1\u0379",
            "\1\u0379",
            "\1\u037b",
            "\1\u0379",
            "\1\u0379",
            "\1\u037c",
            "\1\u037d",
            "\1\u037e",
            "\1\u037f",
            "\1\u0380",
            "\1\u0381\47\uffff\5\u0381",
            "\1\u0382\47\uffff\5\u0382",
            "\1\u0383",
            "\1\u0391\12\uffff\1\u03a1\1\u03a5\1\uffff\1\u03a8\1\u03a9\2"+
            "\uffff\1\u03aa\16\uffff\1\u039d\6\uffff\1\u038a\1\u03a0\11\uffff"+
            "\1\u0396\11\uffff\1\u0385\5\uffff\1\u039f\16\uffff\1\u03a2\1"+
            "\u03a3\1\u03a4\2\uffff\1\u0384\1\u0386\1\u0387\1\u0388\1\u0389"+
            "\1\u038b\1\u038c\1\u038d\1\u038e\1\u038f\1\u0390\1\uffff\1\u0392"+
            "\1\u0393\1\u0394\1\u0395\1\u0397\1\u0398\1\u0399\1\u039a\1\u039e"+
            "\1\uffff\1\u039b\1\u039c\1\uffff\1\u03a6\1\u03a7",
            "\1\u03b8\12\uffff\1\u03c8\1\u03cc\1\uffff\1\u03cf\1\u03d0\2"+
            "\uffff\1\u03d1\16\uffff\1\u03c4\6\uffff\1\u03b1\1\u03c7\11\uffff"+
            "\1\u03bd\11\uffff\1\u03ac\5\uffff\1\u03c6\16\uffff\1\u03c9\1"+
            "\u03ca\1\u03cb\2\uffff\1\u03ab\1\u03ad\1\u03ae\1\u03af\1\u03b0"+
            "\1\u03b2\1\u03b3\1\u03b4\1\u03b5\1\u03b6\1\u03b7\1\uffff\1\u03b9"+
            "\1\u03ba\1\u03bb\1\u03bc\1\u03be\1\u03bf\1\u03c0\1\u03c1\1\u03c5"+
            "\1\uffff\1\u03c2\1\u03c3\1\uffff\1\u03cd\1\u03ce",
            "\1\u03d2\12\uffff\1\u03ef\1\u03f3\1\uffff\1\u03f6\1\u03f7\2"+
            "\uffff\1\u03f8\16\uffff\1\u03eb\6\uffff\1\u03d9\1\u03ee\11\uffff"+
            "\1\u03e4\11\uffff\1\u03d7\5\uffff\1\u03ed\16\uffff\1\u03f0\1"+
            "\u03f1\1\u03f2\2\uffff\1\u03d6\1\u03d8\1\u03d3\1\u03d4\1\u03d5"+
            "\1\u03da\1\u03db\1\u03dc\1\u03dd\1\u03de\1\u03df\1\uffff\1\u03e0"+
            "\1\u03e1\1\u03e2\1\u03e3\1\u03e5\1\u03e6\1\u03e7\1\u03e8\1\u03ec"+
            "\1\uffff\1\u03e9\1\u03ea\1\uffff\1\u03f4\1\u03f5",
            "\1\u0406\12\uffff\1\u0416\1\u041a\1\uffff\1\u041d\1\u041e\2"+
            "\uffff\1\u041f\16\uffff\1\u0412\6\uffff\1\u03ff\1\u0415\11\uffff"+
            "\1\u040b\11\uffff\1\u03fa\5\uffff\1\u0414\16\uffff\1\u0417\1"+
            "\u0418\1\u0419\2\uffff\1\u03f9\1\u03fb\1\u03fc\1\u03fd\1\u03fe"+
            "\1\u0400\1\u0401\1\u0402\1\u0403\1\u0404\1\u0405\1\uffff\1\u0407"+
            "\1\u0408\1\u0409\1\u040a\1\u040c\1\u040d\1\u040e\1\u040f\1\u0413"+
            "\1\uffff\1\u0410\1\u0411\1\uffff\1\u041b\1\u041c",
            "\1\u0425\21\uffff\1\u0424\34\uffff\1\u0420\12\uffff\5\u0424"+
            "\1\uffff\1\u0423\1\u0421\23\uffff\1\u0422\10\uffff\1\u0425\6"+
            "\uffff\14\u0426",
            "\1\u0434\12\uffff\1\u0444\1\u0448\1\uffff\1\u044b\1\u044c\2"+
            "\uffff\1\u044d\16\uffff\1\u0440\6\uffff\1\u042d\1\u0443\11\uffff"+
            "\1\u0439\11\uffff\1\u0428\5\uffff\1\u0442\16\uffff\1\u0445\1"+
            "\u0446\1\u0447\2\uffff\1\u0427\1\u0429\1\u042a\1\u042b\1\u042c"+
            "\1\u042e\1\u042f\1\u0430\1\u0431\1\u0432\1\u0433\1\uffff\1\u0435"+
            "\1\u0436\1\u0437\1\u0438\1\u043a\1\u043b\1\u043c\1\u043d\1\u0441"+
            "\1\uffff\1\u043e\1\u043f\1\uffff\1\u0449\1\u044a",
            "\1\u045b\12\uffff\1\u046b\1\u046f\1\uffff\1\u0472\1\u0473\2"+
            "\uffff\1\u0474\16\uffff\1\u0467\6\uffff\1\u0454\1\u046a\11\uffff"+
            "\1\u0460\11\uffff\1\u044f\5\uffff\1\u0469\16\uffff\1\u046c\1"+
            "\u046d\1\u046e\2\uffff\1\u044e\1\u0450\1\u0451\1\u0452\1\u0453"+
            "\1\u0455\1\u0456\1\u0457\1\u0458\1\u0459\1\u045a\1\uffff\1\u045c"+
            "\1\u045d\1\u045e\1\u045f\1\u0461\1\u0462\1\u0463\1\u0464\1\u0468"+
            "\1\uffff\1\u0465\1\u0466\1\uffff\1\u0470\1\u0471",
            "\1\u0482\12\uffff\1\u0492\1\u0496\1\uffff\1\u0499\1\u049a\2"+
            "\uffff\1\u049b\16\uffff\1\u048e\6\uffff\1\u047b\1\u0491\11\uffff"+
            "\1\u0487\11\uffff\1\u0476\5\uffff\1\u0490\16\uffff\1\u0493\1"+
            "\u0494\1\u0495\2\uffff\1\u0475\1\u0477\1\u0478\1\u0479\1\u047a"+
            "\1\u047c\1\u047d\1\u047e\1\u047f\1\u0480\1\u0481\1\uffff\1\u0483"+
            "\1\u0484\1\u0485\1\u0486\1\u0488\1\u0489\1\u048a\1\u048b\1\u048f"+
            "\1\uffff\1\u048c\1\u048d\1\uffff\1\u0497\1\u0498",
            "\1\u04a9\12\uffff\1\u04b9\1\u04bd\1\uffff\1\u04c0\1\u04c1\2"+
            "\uffff\1\u04c2\16\uffff\1\u04b5\6\uffff\1\u04a2\1\u04b8\11\uffff"+
            "\1\u04ae\11\uffff\1\u049d\5\uffff\1\u04b7\16\uffff\1\u04ba\1"+
            "\u04bb\1\u04bc\2\uffff\1\u049c\1\u049e\1\u049f\1\u04a0\1\u04a1"+
            "\1\u04a3\1\u04a4\1\u04a5\1\u04a6\1\u04a7\1\u04a8\1\uffff\1\u04aa"+
            "\1\u04ab\1\u04ac\1\u04ad\1\u04af\1\u04b0\1\u04b1\1\u04b2\1\u04b6"+
            "\1\uffff\1\u04b3\1\u04b4\1\uffff\1\u04be\1\u04bf",
            "\1\u04d0\12\uffff\1\u04e0\1\u04e4\1\uffff\1\u04e7\1\u04e8\2"+
            "\uffff\1\u04e9\16\uffff\1\u04dc\6\uffff\1\u04c9\1\u04df\11\uffff"+
            "\1\u04d5\11\uffff\1\u04c4\5\uffff\1\u04de\16\uffff\1\u04e1\1"+
            "\u04e2\1\u04e3\2\uffff\1\u04c3\1\u04c5\1\u04c6\1\u04c7\1\u04c8"+
            "\1\u04ca\1\u04cb\1\u04cc\1\u04cd\1\u04ce\1\u04cf\1\uffff\1\u04d1"+
            "\1\u04d2\1\u04d3\1\u04d4\1\u04d6\1\u04d7\1\u04d8\1\u04d9\1\u04dd"+
            "\1\uffff\1\u04da\1\u04db\1\uffff\1\u04e5\1\u04e6",
            "\1\u04f7\12\uffff\1\u0507\1\u050b\1\uffff\1\u050e\1\u050f\2"+
            "\uffff\1\u0510\16\uffff\1\u0503\6\uffff\1\u04f0\1\u0506\11\uffff"+
            "\1\u04fc\11\uffff\1\u04eb\5\uffff\1\u0505\16\uffff\1\u0508\1"+
            "\u0509\1\u050a\2\uffff\1\u04ea\1\u04ec\1\u04ed\1\u04ee\1\u04ef"+
            "\1\u04f1\1\u04f2\1\u04f3\1\u04f4\1\u04f5\1\u04f6\1\uffff\1\u04f8"+
            "\1\u04f9\1\u04fa\1\u04fb\1\u04fd\1\u04fe\1\u04ff\1\u0500\1\u0504"+
            "\1\uffff\1\u0501\1\u0502\1\uffff\1\u050c\1\u050d",
            "\1\u051e\12\uffff\1\u052e\1\u0532\1\uffff\1\u0535\1\u0536\2"+
            "\uffff\1\u0537\16\uffff\1\u052a\6\uffff\1\u0517\1\u052d\11\uffff"+
            "\1\u0523\11\uffff\1\u0512\5\uffff\1\u052c\16\uffff\1\u052f\1"+
            "\u0530\1\u0531\2\uffff\1\u0511\1\u0513\1\u0514\1\u0515\1\u0516"+
            "\1\u0518\1\u0519\1\u051a\1\u051b\1\u051c\1\u051d\1\uffff\1\u051f"+
            "\1\u0520\1\u0521\1\u0522\1\u0524\1\u0525\1\u0526\1\u0527\1\u052b"+
            "\1\uffff\1\u0528\1\u0529\1\uffff\1\u0533\1\u0534",
            "\1\u0545\12\uffff\1\u0555\1\u0559\1\uffff\1\u055c\1\u055d\2"+
            "\uffff\1\u055e\16\uffff\1\u0551\6\uffff\1\u053e\1\u0554\11\uffff"+
            "\1\u054a\11\uffff\1\u0539\5\uffff\1\u0553\16\uffff\1\u0556\1"+
            "\u0557\1\u0558\2\uffff\1\u0538\1\u053a\1\u053b\1\u053c\1\u053d"+
            "\1\u053f\1\u0540\1\u0541\1\u0542\1\u0543\1\u0544\1\uffff\1\u0546"+
            "\1\u0547\1\u0548\1\u0549\1\u054b\1\u054c\1\u054d\1\u054e\1\u0552"+
            "\1\uffff\1\u054f\1\u0550\1\uffff\1\u055a\1\u055b",
            "\1\u056c\12\uffff\1\u057c\1\u0580\1\uffff\1\u0583\1\u0584\2"+
            "\uffff\1\u0585\16\uffff\1\u0578\6\uffff\1\u0565\1\u057b\11\uffff"+
            "\1\u0571\11\uffff\1\u0560\5\uffff\1\u057a\16\uffff\1\u057d\1"+
            "\u057e\1\u057f\2\uffff\1\u055f\1\u0561\1\u0562\1\u0563\1\u0564"+
            "\1\u0566\1\u0567\1\u0568\1\u0569\1\u056a\1\u056b\1\uffff\1\u056d"+
            "\1\u056e\1\u056f\1\u0570\1\u0572\1\u0573\1\u0574\1\u0575\1\u0579"+
            "\1\uffff\1\u0576\1\u0577\1\uffff\1\u0581\1\u0582",
            "\1\u0593\12\uffff\1\u05a3\1\u05a7\1\uffff\1\u05aa\1\u05ab\2"+
            "\uffff\1\u05ac\16\uffff\1\u059f\6\uffff\1\u058c\1\u05a2\11\uffff"+
            "\1\u0598\11\uffff\1\u0587\5\uffff\1\u05a1\16\uffff\1\u05a4\1"+
            "\u05a5\1\u05a6\2\uffff\1\u0586\1\u0588\1\u0589\1\u058a\1\u058b"+
            "\1\u058d\1\u058e\1\u058f\1\u0590\1\u0591\1\u0592\1\uffff\1\u0594"+
            "\1\u0595\1\u0596\1\u0597\1\u0599\1\u059a\1\u059b\1\u059c\1\u05a0"+
            "\1\uffff\1\u059d\1\u059e\1\uffff\1\u05a8\1\u05a9",
            "\1\u05ba\12\uffff\1\u05ca\1\u05ce\1\uffff\1\u05d1\1\u05d2\2"+
            "\uffff\1\u05d3\16\uffff\1\u05c6\6\uffff\1\u05b3\1\u05c9\11\uffff"+
            "\1\u05bf\11\uffff\1\u05ae\5\uffff\1\u05c8\16\uffff\1\u05cb\1"+
            "\u05cc\1\u05cd\2\uffff\1\u05ad\1\u05af\1\u05b0\1\u05b1\1\u05b2"+
            "\1\u05b4\1\u05b5\1\u05b6\1\u05b7\1\u05b8\1\u05b9\1\uffff\1\u05bb"+
            "\1\u05bc\1\u05bd\1\u05be\1\u05c0\1\u05c1\1\u05c2\1\u05c3\1\u05c7"+
            "\1\uffff\1\u05c4\1\u05c5\1\uffff\1\u05cf\1\u05d0",
            "\1\u05e1\12\uffff\1\u05f1\1\u05f5\1\uffff\1\u05f8\1\u05f9\2"+
            "\uffff\1\u05fa\16\uffff\1\u05ed\6\uffff\1\u05da\1\u05f0\11\uffff"+
            "\1\u05e6\11\uffff\1\u05d5\5\uffff\1\u05ef\16\uffff\1\u05f2\1"+
            "\u05f3\1\u05f4\2\uffff\1\u05d4\1\u05d6\1\u05d7\1\u05d8\1\u05d9"+
            "\1\u05db\1\u05dc\1\u05dd\1\u05de\1\u05df\1\u05e0\1\uffff\1\u05e2"+
            "\1\u05e3\1\u05e4\1\u05e5\1\u05e7\1\u05e8\1\u05e9\1\u05ea\1\u05ee"+
            "\1\uffff\1\u05eb\1\u05ec\1\uffff\1\u05f6\1\u05f7",
            "\1\u05fb",
            "\1\u05fc",
            "\1\u05fd",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05fe",
            "\1\u05ff",
            "\1\u0600",
            "\1\u0601",
            "\1\u0602",
            "\1\u0603",
            "\1\u0604",
            "\1\u0605",
            "\1\u0606",
            "\1\u0607",
            "\1\u0608",
            "\1\u0609",
            "\1\u060a",
            "\1\u060b",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u060c",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u060d",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u00eb\5\uffff\1\u00d1\12\uffff\1\u00e1\1\u00e5\1\uffff\1"+
            "\u00e8\1\u00e9\2\uffff\1\u00ea\16\uffff\1\u00dd\6\uffff\1\u00ca"+
            "\1\u00e0\11\uffff\1\u00d6\11\uffff\1\u00c5\5\uffff\1\u00df\16"+
            "\uffff\1\u00e2\1\u00e3\1\u00e4\2\uffff\1\u00c4\1\u00c6\1\u00c7"+
            "\1\u00c8\1\u00c9\1\u00cb\1\u00cc\1\u00cd\1\u00ce\1\u00cf\1\u00d0"+
            "\1\uffff\1\u00d2\1\u00d3\1\u00d4\1\u00d5\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00de\1\uffff\1\u00db\1\u00dc\1\uffff\1\u00e6\1\u00e7",
            "\1\u060e",
            "\1\u060f",
            "\1\u0610",
            "\1\u0611",
            "\1\u0612",
            "\1\u0613",
            "\1\u0614\47\uffff\5\u0614",
            "\1\u0615\47\uffff\5\u0615",
            "\1\u0616",
            "\1\u0617",
            "\1\u0618",
            "\1\u0619",
            "\1\u061a",
            "\1\u061a",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "292:1: expression returns [CommonTree tr] : ( ^(or= OR expression expression ) | ^(ad= AND expression expression ) | ( NOT DOWN negatableOperator )=> ^(nOp= NOT ^( negatableOperator expression expression ) ) | ( NOT DOWN FUNCTION )=> ^(fInF= NOT ^( FUNCTION IN expression expressions ) ) | ^(nt= NOT expression ) | ^(cOp= compareOperator expression expression ) | ^(fInT= FUNCTION IN expression expressions ) | ^(fBtF= FUNCTION BETWEEN FALSE expression expression expression ) | ^(fBtT= FUNCTION BETWEEN TRUE expression expression expression ) | ^(bitOr= BITWISEOR expression expression ) | ^(amp= AMPERSAND expression expression ) | ^(plus= PLUS expression ( expression )? ) | ^(minus= MINUS expression ( expression )? ) | ^(star= STAR expression expression ) | ^(divide= DIVIDE expression expression ) | ^(mod= MOD expression expression ) | ^(div= DIV expression expression ) | ^(bitxor= BITWISEXOR expression expression ) | ^(fnNull= FUNCTION nullCondition expression ) | ^(tilde= TILDE expression ) | ^(arry= LSQUARE expression expression ) | ^(dot= DOT expression Identifier ) | nl= NULL | c= constant | f= function | cs= castExpr | cse= caseExpr | whn= whenExpr | tc= tableOrColumn );";
        }
    }
 

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
    public static final BitSet FOLLOW_NOT_in_expression1670 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_negatableOperator_in_expression1674 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1676 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1679 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression1702 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1706 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_in_expression1708 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1711 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expressions_in_expression1713 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression1726 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_compareOperator_in_expression1741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1743 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1758 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_in_expression1760 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1763 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expressions_in_expression1765 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1777 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BETWEEN_in_expression1779 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_FALSE_in_expression1781 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1783 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1785 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1787 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BETWEEN_in_expression1801 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_TRUE_in_expression1803 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1805 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1807 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1809 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISEOR_in_expression1821 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1823 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1825 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AMPERSAND_in_expression1837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1839 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1841 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expression1853 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1855 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1857 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expression1870 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1872 = new BitSet(new long[]{0x1006040009B00208L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1874 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expression1887 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1889 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1891 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDE_in_expression1903 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1905 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1907 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expression1919 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1921 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1923 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expression1935 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1937 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1939 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BITWISEXOR_in_expression1952 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1954 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1956 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_in_expression1968 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nullCondition_in_expression1970 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression1972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TILDE_in_expression1986 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1988 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LSQUARE_in_expression2001 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2003 = new BitSet(new long[]{0x1006040009B00200L,0x06DFF7FF38001040L});
    public static final BitSet FOLLOW_expression_in_expression2005 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_expression2017 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2019 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_expression2021 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_expression2033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_expression2043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_expression2054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpr_in_expression2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseExpr_in_expression2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whenExpr_in_expression2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tableOrColumn_in_expression2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_booleanValue2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_booleanValue2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARAM_in_namevalue2261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_namevalue2265 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_namevalue2269 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAM_in_namevalue2278 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_StringLiteral_in_namevalue2282 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_namevalue2286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_synpred11659 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DOWN_in_synpred11661 = new BitSet(new long[]{0x0000000000000000L,0x0000001C00000000L});
    public static final BitSet FOLLOW_negatableOperator_in_synpred11663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_synpred21691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DOWN_in_synpred21693 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_FUNCTION_in_synpred21695 = new BitSet(new long[]{0x0000000000000002L});

}