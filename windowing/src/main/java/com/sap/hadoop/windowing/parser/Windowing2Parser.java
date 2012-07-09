// $ANTLR 3.0.1 Windowing2.g 2012-07-09 07:53:53

package com.sap.hadoop.windowing.parser;

import com.sap.hadoop.windowing.functions.FunctionRegistry;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class Windowing2Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "WDW_FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "TBLFUNCTION", "LOADSPEC", "STRINGLITERALSEQUENCE", "CHARSETLITERAL", "NOTNULL", "FUNCTIONSTAR", "FUNCTIONDIST", "WDW_FUNCTIONSTAR", "WDW_FUNCTIONDIST", "TABLEORCOL", "COLUMNREF", "WINDOWSPEC", "WINDOWDEF", "INPUT", "HDFSLOCATION", "HIVEQ", "HIVETBL", "UPLUS", "FROM", "SELECT", "COMMA", "AS", "Identifier", "HIVEQUERY", "DOT", "LPAREN", "RPAREN", "FILEINPUT", "WHERE", "INTO", "PATH", "EQUAL", "StringLiteral", "SERDE", "WITH", "SERDEPROPERTIES", "RECORDWRITER", "FORMAT", "LOAD", "OVERWRITE", "TABLE", "PARTITION", "STAR", "DISTINCT", "OVER", "WINDOW", "ORDER", "BY", "ASC", "DESC", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "Number", "RANGE", "LESS", "MORE", "IF", "ARRAY", "MAP", "STRUCT", "UNION", "CAST", "CASE", "WHEN", "THEN", "ELSE", "END", "BigintLiteral", "SmallintLiteral", "TinyintLiteral", "CharSetName", "CharSetLiteral", "OR", "NOT", "LIKE", "RLIKE", "REGEXP", "EQUAL_NS", "NOTEQUAL", "LESSTHANOREQUALTO", "LESSTHAN", "GREATERTHANOREQUALTO", "GREATERTHAN", "IN", "BITWISEOR", "AMPERSAND", "PLUS", "MINUS", "DIVIDE", "MOD", "DIV", "BITWISEXOR", "NULL", "IS", "TILDE", "LSQUARE", "RSQUARE", "TRUE", "FALSE", "TINYINT", "SMALLINT", "INT", "BIGINT", "BOOLEAN", "FLOAT", "DOUBLE", "DATE", "DATETIME", "TIMESTAMP", "STRING", "BINARY", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "I", "N", "P", "U", "D", "B", "Y", "A", "G", "V", "K", "X", "COLON", "SEMICOLON", "LCURLY", "RCURLY", "XOR", "QUESTION", "DOLLAR", "HiveQueryEscapeSequence", "EscapeSequence", "HexDigit", "Digit", "Letter", "Exponent", "RegexComponent", "WS", "COMMENT", "J", "Q", "Z"
    };
    public static final int FUNCTION=9;
    public static final int CAST=85;
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
    public static final int CHARSETLITERAL=21;
    public static final int PRECEDING=72;
    public static final int LESS=78;
    public static final int TINYINT=123;
    public static final int REGEXP=100;
    public static final int SERDEPROPERTIES=53;
    public static final int DOUBLE=129;
    public static final int STRINGLITERALSEQUENCE=20;
    public static final int COMMENT=173;
    public static final int SELECT=37;
    public static final int INTO=47;
    public static final int WINDOWSPEC=29;
    public static final int ARRAY=81;
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
    public static final int FROM=36;
    public static final int END=90;
    public static final int FALSE=122;
    public static final int UNBOUNDED=71;
    public static final int DISTINCT=61;
    public static final int Letter=169;
    public static final int EscapeSequence=166;
    public static final int TIMESTAMP=132;
    public static final int TBLFUNCTION=18;
    public static final int DOLLAR=164;
    public static final int OVER=62;
    public static final int WHERE=46;
    public static final int SELECTCOLUMN=16;
    public static final int FILEINPUT=45;
    public static final int ORDER=64;
    public static final int CharSetName=94;
    public static final int INPUT=31;
    public static final int TABLE=58;
    public static final int Exponent=170;
    public static final int WINDOWDEF=30;
    public static final int LOADSPEC=19;
    public static final int FLOAT=128;
    public static final int NOTNULL=22;
    public static final int AND=70;
    public static final int FOLLOWING=73;
    public static final int HexDigit=167;
    public static final int LPAREN=43;
    public static final int IF=80;
    public static final int AS=39;
    public static final int GREATERTHANOREQUALTO=105;
    public static final int BOOLEAN=127;
    public static final int IN=107;
    public static final int THEN=88;
    public static final int Number=76;
    public static final int COLUMNREF=28;
    public static final int COMMA=38;
    public static final int IS=117;
    public static final int PARTITION=59;
    public static final int EQUAL=49;
    public static final int WDW_FUNCTION=10;
    public static final int TILDE=118;
    public static final int PLUS=110;
    public static final int DOT=42;
    public static final int FUNCTIONDIST=24;
    public static final int LIKE=98;
    public static final int WITH=52;
    public static final int FUNCTIONSTAR=23;
    public static final int INTEGER=5;
    public static final int LESSTHAN=104;
    public static final int BY=65;
    public static final int XOR=162;
    public static final int UPLUS=35;
    public static final int DATETIME=131;
    public static final int AMPERSAND=109;
    public static final int UMINUS=6;
    public static final int RANGE=77;
    public static final int STRUCT=83;
    public static final int RSQUARE=120;
    public static final int MINUS=111;
    public static final int Digit=168;
    public static final int TABLEORCOL=27;
    public static final int TRUE=121;
    public static final int BITWISEOR=108;
    public static final int CURRENT=74;
    public static final int UNION=84;
    public static final int COLON=158;
    public static final int StringLiteral=50;
    public static final int BigintLiteral=91;
    public static final int SmallintLiteral=92;
    public static final int CharSetLiteral=95;
    public static final int QUESTION=163;
    public static final int BIGINT=126;
    public static final int WHEN=87;
    public static final int HIVEQ=33;
    public static final int RCURLY=161;
    public static final int MAP=82;
    public static final int ROWS=68;
    public static final int WINDOW=63;
    public static final int FORMAT=55;
    public static final int BINARY=134;
    public static final int DIV=114;
    public static final int DESC=67;
    public static final int DATE=130;
    public static final int BETWEEN=69;
    public static final int STRING=133;
    public static final int SMALLINT=124;

        public Windowing2Parser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[61+1];
         }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "Windowing2.g"; }


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
      
      public boolean isWindowingFunction(Token t)
      {
         return FunctionRegistry.isWindowingFunction(t.getText());
      }
      


    public static class query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start query
    // Windowing2.g:93:1: query : ( queryForm1 | queryForm2 ) EOF ;
    public final query_return query() throws RecognitionException {
        query_return retval = new query_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF3=null;
        queryForm1_return queryForm11 = null;

        queryForm2_return queryForm22 = null;


        Object EOF3_tree=null;

        try {
            // Windowing2.g:93:7: ( ( queryForm1 | queryForm2 ) EOF )
            // Windowing2.g:94:3: ( queryForm1 | queryForm2 ) EOF
            {
            root_0 = (Object)adaptor.nil();

            // Windowing2.g:94:3: ( queryForm1 | queryForm2 )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==SELECT) ) {
                alt1=1;
            }
            else if ( (LA1_0==FROM) ) {
                alt1=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("94:3: ( queryForm1 | queryForm2 )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // Windowing2.g:94:4: queryForm1
                    {
                    pushFollow(FOLLOW_queryForm1_in_query240);
                    queryForm11=queryForm1();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, queryForm11.getTree());

                    }
                    break;
                case 2 :
                    // Windowing2.g:94:17: queryForm2
                    {
                    pushFollow(FOLLOW_queryForm2_in_query244);
                    queryForm22=queryForm2();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, queryForm22.getTree());

                    }
                    break;

            }

            EOF3=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_query247); if (failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end query

    public static class queryForm1_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start queryForm1
    // Windowing2.g:97:1: queryForm1 : select FROM tableSpec ( where )? ( window_clause )? ( outputClause )? -> ^( QUERY tableSpec select ( where )? ( window_clause )? ( outputClause )? ) ;
    public final queryForm1_return queryForm1() throws RecognitionException {
        queryForm1_return retval = new queryForm1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FROM5=null;
        select_return select4 = null;

        tableSpec_return tableSpec6 = null;

        where_return where7 = null;

        window_clause_return window_clause8 = null;

        outputClause_return outputClause9 = null;


        Object FROM5_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleSubtreeStream stream_window_clause=new RewriteRuleSubtreeStream(adaptor,"rule window_clause");
        RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        RewriteRuleSubtreeStream stream_where=new RewriteRuleSubtreeStream(adaptor,"rule where");
        RewriteRuleSubtreeStream stream_outputClause=new RewriteRuleSubtreeStream(adaptor,"rule outputClause");
        try {
            // Windowing2.g:97:12: ( select FROM tableSpec ( where )? ( window_clause )? ( outputClause )? -> ^( QUERY tableSpec select ( where )? ( window_clause )? ( outputClause )? ) )
            // Windowing2.g:98:2: select FROM tableSpec ( where )? ( window_clause )? ( outputClause )?
            {
            pushFollow(FOLLOW_select_in_queryForm1258);
            select4=select();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_select.add(select4.getTree());
            FROM5=(Token)input.LT(1);
            match(input,FROM,FOLLOW_FROM_in_queryForm1261); if (failed) return retval;
            if ( backtracking==0 ) stream_FROM.add(FROM5);

            pushFollow(FOLLOW_tableSpec_in_queryForm1263);
            tableSpec6=tableSpec();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_tableSpec.add(tableSpec6.getTree());
            // Windowing2.g:100:2: ( where )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==WHERE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Windowing2.g:100:2: where
                    {
                    pushFollow(FOLLOW_where_in_queryForm1266);
                    where7=where();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_where.add(where7.getTree());

                    }
                    break;

            }

            // Windowing2.g:101:2: ( window_clause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==WINDOW) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Windowing2.g:101:2: window_clause
                    {
                    pushFollow(FOLLOW_window_clause_in_queryForm1271);
                    window_clause8=window_clause();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_window_clause.add(window_clause8.getTree());

                    }
                    break;

            }

            // Windowing2.g:102:2: ( outputClause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==INTO) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Windowing2.g:102:2: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_queryForm1275);
                    outputClause9=outputClause();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_outputClause.add(outputClause9.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: outputClause, select, window_clause, tableSpec, where
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 103:2: -> ^( QUERY tableSpec select ( where )? ( window_clause )? ( outputClause )? )
            {
                // Windowing2.g:103:5: ^( QUERY tableSpec select ( where )? ( window_clause )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.next());
                adaptor.addChild(root_1, stream_select.next());
                // Windowing2.g:103:30: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.next());

                }
                stream_where.reset();
                // Windowing2.g:103:37: ( window_clause )?
                if ( stream_window_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_clause.next());

                }
                stream_window_clause.reset();
                // Windowing2.g:103:52: ( outputClause )?
                if ( stream_outputClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_outputClause.next());

                }
                stream_outputClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end queryForm1

    public static class queryForm2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start queryForm2
    // Windowing2.g:106:1: queryForm2 : FROM tableSpec select ( where )? ( window_clause )? ( outputClause )? -> ^( QUERY tableSpec select ( where )? ( window_clause )? ( outputClause )? ) ;
    public final queryForm2_return queryForm2() throws RecognitionException {
        queryForm2_return retval = new queryForm2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FROM10=null;
        tableSpec_return tableSpec11 = null;

        select_return select12 = null;

        where_return where13 = null;

        window_clause_return window_clause14 = null;

        outputClause_return outputClause15 = null;


        Object FROM10_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleSubtreeStream stream_window_clause=new RewriteRuleSubtreeStream(adaptor,"rule window_clause");
        RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        RewriteRuleSubtreeStream stream_where=new RewriteRuleSubtreeStream(adaptor,"rule where");
        RewriteRuleSubtreeStream stream_outputClause=new RewriteRuleSubtreeStream(adaptor,"rule outputClause");
        try {
            // Windowing2.g:106:12: ( FROM tableSpec select ( where )? ( window_clause )? ( outputClause )? -> ^( QUERY tableSpec select ( where )? ( window_clause )? ( outputClause )? ) )
            // Windowing2.g:107:2: FROM tableSpec select ( where )? ( window_clause )? ( outputClause )?
            {
            FROM10=(Token)input.LT(1);
            match(input,FROM,FOLLOW_FROM_in_queryForm2307); if (failed) return retval;
            if ( backtracking==0 ) stream_FROM.add(FROM10);

            pushFollow(FOLLOW_tableSpec_in_queryForm2309);
            tableSpec11=tableSpec();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_tableSpec.add(tableSpec11.getTree());
            pushFollow(FOLLOW_select_in_queryForm2312);
            select12=select();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_select.add(select12.getTree());
            // Windowing2.g:109:2: ( where )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WHERE) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Windowing2.g:109:2: where
                    {
                    pushFollow(FOLLOW_where_in_queryForm2315);
                    where13=where();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_where.add(where13.getTree());

                    }
                    break;

            }

            // Windowing2.g:110:2: ( window_clause )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==WINDOW) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Windowing2.g:110:2: window_clause
                    {
                    pushFollow(FOLLOW_window_clause_in_queryForm2320);
                    window_clause14=window_clause();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_window_clause.add(window_clause14.getTree());

                    }
                    break;

            }

            // Windowing2.g:111:2: ( outputClause )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==INTO) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Windowing2.g:111:2: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_queryForm2324);
                    outputClause15=outputClause();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_outputClause.add(outputClause15.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: select, window_clause, where, outputClause, tableSpec
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 112:2: -> ^( QUERY tableSpec select ( where )? ( window_clause )? ( outputClause )? )
            {
                // Windowing2.g:112:5: ^( QUERY tableSpec select ( where )? ( window_clause )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.next());
                adaptor.addChild(root_1, stream_select.next());
                // Windowing2.g:112:30: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.next());

                }
                stream_where.reset();
                // Windowing2.g:112:37: ( window_clause )?
                if ( stream_window_clause.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_clause.next());

                }
                stream_window_clause.reset();
                // Windowing2.g:112:52: ( outputClause )?
                if ( stream_outputClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_outputClause.next());

                }
                stream_outputClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end queryForm2

    public static class select_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start select
    // Windowing2.g:115:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final select_return select() throws RecognitionException {
        select_return retval = new select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT16=null;
        Token COMMA18=null;
        selectColumn_return selectColumn17 = null;

        selectColumn_return selectColumn19 = null;


        Object SELECT16_tree=null;
        Object COMMA18_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // Windowing2.g:115:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // Windowing2.g:116:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT16=(Token)input.LT(1);
            match(input,SELECT,FOLLOW_SELECT_in_select358); if (failed) return retval;
            if ( backtracking==0 ) stream_SELECT.add(SELECT16);

            pushFollow(FOLLOW_selectColumn_in_select360);
            selectColumn17=selectColumn();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_selectColumn.add(selectColumn17.getTree());
            // Windowing2.g:116:23: ( COMMA selectColumn )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Windowing2.g:116:24: COMMA selectColumn
            	    {
            	    COMMA18=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_select363); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA18);

            	    pushFollow(FOLLOW_selectColumn_in_select365);
            	    selectColumn19=selectColumn();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_selectColumn.add(selectColumn19.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // AST REWRITE
            // elements: selectColumn, SELECT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 116:46: -> ^( SELECT ( selectColumn )+ )
            {
                // Windowing2.g:116:49: ^( SELECT ( selectColumn )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SELECT.next(), root_1);

                if ( !(stream_selectColumn.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_selectColumn.hasNext() ) {
                    adaptor.addChild(root_1, stream_selectColumn.next());

                }
                stream_selectColumn.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end select

    public static class selectColumn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start selectColumn
    // Windowing2.g:119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );
    public final selectColumn_return selectColumn() throws RecognitionException {
        selectColumn_return retval = new selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AS21=null;
        Token Identifier22=null;
        Token AS24=null;
        Token Identifier25=null;
        expression_return expression20 = null;

        window_function_return window_function23 = null;


        Object AS21_tree=null;
        Object Identifier22_tree=null;
        Object AS24_tree=null;
        Object Identifier25_tree=null;
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_window_function=new RewriteRuleSubtreeStream(adaptor,"rule window_function");
        try {
            // Windowing2.g:119:13: ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) )
            int alt10=2;
            switch ( input.LA(1) ) {
            case LPAREN:
            case StringLiteral:
            case Number:
            case CAST:
            case CASE:
            case BigintLiteral:
            case SmallintLiteral:
            case TinyintLiteral:
            case CharSetName:
            case NOT:
            case PLUS:
            case MINUS:
            case NULL:
            case TILDE:
            case TRUE:
            case FALSE:
                {
                alt10=1;
                }
                break;
            case Identifier:
                {
                int LA10_14 = input.LA(2);

                if ( (LA10_14==EOF||LA10_14==FROM||(LA10_14>=COMMA && LA10_14<=AS)||LA10_14==DOT||(LA10_14>=WHERE && LA10_14<=INTO)||LA10_14==EQUAL||LA10_14==STAR||LA10_14==WINDOW||(LA10_14>=BETWEEN && LA10_14<=AND)||(LA10_14>=OR && LA10_14<=BITWISEXOR)||LA10_14==IS||LA10_14==LSQUARE) ) {
                    alt10=1;
                }
                else if ( (LA10_14==LPAREN) ) {
                    switch ( input.LA(3) ) {
                    case STAR:
                        {
                        int LA10_53 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 53, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DISTINCT:
                        {
                        int LA10_54 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 54, input);

                            throw nvae;
                        }
                        }
                        break;
                    case NOT:
                        {
                        int LA10_55 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 55, input);

                            throw nvae;
                        }
                        }
                        break;
                    case PLUS:
                        {
                        int LA10_56 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 56, input);

                            throw nvae;
                        }
                        }
                        break;
                    case MINUS:
                        {
                        int LA10_57 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 57, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TILDE:
                        {
                        int LA10_58 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 58, input);

                            throw nvae;
                        }
                        }
                        break;
                    case NULL:
                        {
                        int LA10_59 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 59, input);

                            throw nvae;
                        }
                        }
                        break;
                    case Number:
                        {
                        int LA10_60 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 60, input);

                            throw nvae;
                        }
                        }
                        break;
                    case StringLiteral:
                        {
                        int LA10_61 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 61, input);

                            throw nvae;
                        }
                        }
                        break;
                    case BigintLiteral:
                        {
                        int LA10_62 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 62, input);

                            throw nvae;
                        }
                        }
                        break;
                    case SmallintLiteral:
                        {
                        int LA10_63 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 63, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TinyintLiteral:
                        {
                        int LA10_64 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 64, input);

                            throw nvae;
                        }
                        }
                        break;
                    case CharSetName:
                        {
                        int LA10_65 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 65, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TRUE:
                        {
                        int LA10_66 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 66, input);

                            throw nvae;
                        }
                        }
                        break;
                    case FALSE:
                        {
                        int LA10_67 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 67, input);

                            throw nvae;
                        }
                        }
                        break;
                    case Identifier:
                        {
                        int LA10_68 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 68, input);

                            throw nvae;
                        }
                        }
                        break;
                    case CAST:
                        {
                        int LA10_69 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 69, input);

                            throw nvae;
                        }
                        }
                        break;
                    case CASE:
                        {
                        int LA10_70 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 70, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IF:
                    case ARRAY:
                    case MAP:
                    case STRUCT:
                    case UNION:
                        {
                        int LA10_71 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 71, input);

                            throw nvae;
                        }
                        }
                        break;
                    case LPAREN:
                        {
                        int LA10_72 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 72, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RPAREN:
                        {
                        int LA10_73 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 73, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 51, input);

                        throw nvae;
                    }

                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 14, input);

                    throw nvae;
                }
                }
                break;
            case IF:
            case ARRAY:
            case MAP:
            case STRUCT:
            case UNION:
                {
                int LA10_17 = input.LA(2);

                if ( (LA10_17==LPAREN) ) {
                    switch ( input.LA(3) ) {
                    case STAR:
                        {
                        int LA10_74 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 74, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DISTINCT:
                        {
                        int LA10_75 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 75, input);

                            throw nvae;
                        }
                        }
                        break;
                    case NOT:
                        {
                        int LA10_76 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 76, input);

                            throw nvae;
                        }
                        }
                        break;
                    case PLUS:
                        {
                        int LA10_77 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 77, input);

                            throw nvae;
                        }
                        }
                        break;
                    case MINUS:
                        {
                        int LA10_78 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 78, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TILDE:
                        {
                        int LA10_79 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 79, input);

                            throw nvae;
                        }
                        }
                        break;
                    case NULL:
                        {
                        int LA10_80 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 80, input);

                            throw nvae;
                        }
                        }
                        break;
                    case Number:
                        {
                        int LA10_81 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 81, input);

                            throw nvae;
                        }
                        }
                        break;
                    case StringLiteral:
                        {
                        int LA10_82 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 82, input);

                            throw nvae;
                        }
                        }
                        break;
                    case BigintLiteral:
                        {
                        int LA10_83 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 83, input);

                            throw nvae;
                        }
                        }
                        break;
                    case SmallintLiteral:
                        {
                        int LA10_84 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 84, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TinyintLiteral:
                        {
                        int LA10_85 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 85, input);

                            throw nvae;
                        }
                        }
                        break;
                    case CharSetName:
                        {
                        int LA10_86 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 86, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TRUE:
                        {
                        int LA10_87 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 87, input);

                            throw nvae;
                        }
                        }
                        break;
                    case FALSE:
                        {
                        int LA10_88 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 88, input);

                            throw nvae;
                        }
                        }
                        break;
                    case Identifier:
                        {
                        int LA10_89 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 89, input);

                            throw nvae;
                        }
                        }
                        break;
                    case CAST:
                        {
                        int LA10_90 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 90, input);

                            throw nvae;
                        }
                        }
                        break;
                    case CASE:
                        {
                        int LA10_91 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 91, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IF:
                    case ARRAY:
                    case MAP:
                    case STRUCT:
                    case UNION:
                        {
                        int LA10_92 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 92, input);

                            throw nvae;
                        }
                        }
                        break;
                    case LPAREN:
                        {
                        int LA10_93 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 93, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RPAREN:
                        {
                        int LA10_94 = input.LA(4);

                        if ( (!(isWindowingFunction(input.LT(1)))) ) {
                            alt10=1;
                        }
                        else if ( (isWindowingFunction(input.LT(1))) ) {
                            alt10=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 94, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 52, input);

                        throw nvae;
                    }

                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 17, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("119:1: selectColumn : ( expression ( AS Identifier )? -> ^( SELECTCOLUMN expression ( Identifier )? ) | window_function AS Identifier -> ^( SELECTCOLUMN window_function Identifier ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // Windowing2.g:120:3: expression ( AS Identifier )?
                    {
                    pushFollow(FOLLOW_expression_in_selectColumn387);
                    expression20=expression();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_expression.add(expression20.getTree());
                    // Windowing2.g:120:14: ( AS Identifier )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==AS) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // Windowing2.g:120:15: AS Identifier
                            {
                            AS21=(Token)input.LT(1);
                            match(input,AS,FOLLOW_AS_in_selectColumn390); if (failed) return retval;
                            if ( backtracking==0 ) stream_AS.add(AS21);

                            Identifier22=(Token)input.LT(1);
                            match(input,Identifier,FOLLOW_Identifier_in_selectColumn392); if (failed) return retval;
                            if ( backtracking==0 ) stream_Identifier.add(Identifier22);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: Identifier, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 120:31: -> ^( SELECTCOLUMN expression ( Identifier )? )
                    {
                        // Windowing2.g:120:34: ^( SELECTCOLUMN expression ( Identifier )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_expression.next());
                        // Windowing2.g:120:60: ( Identifier )?
                        if ( stream_Identifier.hasNext() ) {
                            adaptor.addChild(root_1, stream_Identifier.next());

                        }
                        stream_Identifier.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // Windowing2.g:121:3: window_function AS Identifier
                    {
                    pushFollow(FOLLOW_window_function_in_selectColumn411);
                    window_function23=window_function();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_window_function.add(window_function23.getTree());
                    AS24=(Token)input.LT(1);
                    match(input,AS,FOLLOW_AS_in_selectColumn413); if (failed) return retval;
                    if ( backtracking==0 ) stream_AS.add(AS24);

                    Identifier25=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_selectColumn415); if (failed) return retval;
                    if ( backtracking==0 ) stream_Identifier.add(Identifier25);


                    // AST REWRITE
                    // elements: Identifier, window_function
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 121:33: -> ^( SELECTCOLUMN window_function Identifier )
                    {
                        // Windowing2.g:121:36: ^( SELECTCOLUMN window_function Identifier )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_window_function.next());
                        adaptor.addChild(root_1, stream_Identifier.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end selectColumn

    public static class tableSpec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start tableSpec
    // Windowing2.g:124:1: tableSpec : (tf= tblfunc | hq= hiveQuery | hdf= hdfsFile | hvT= hiveTable ) (p= partitionby (o= orderby )? )? -> {tf != null}? ^( INPUT $tf ( $p)? ( $o)? ) -> {hq != null}? ^( INPUT $hq ( $p)? ( $o)? ) -> {hdf != null}? ^( INPUT $hdf ( $p)? ( $o)? ) -> ^( INPUT $hvT ( $p)? ( $o)? ) ;
    public final tableSpec_return tableSpec() throws RecognitionException {
        tableSpec_return retval = new tableSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        tblfunc_return tf = null;

        hiveQuery_return hq = null;

        hdfsFile_return hdf = null;

        hiveTable_return hvT = null;

        partitionby_return p = null;

        orderby_return o = null;


        RewriteRuleSubtreeStream stream_tblfunc=new RewriteRuleSubtreeStream(adaptor,"rule tblfunc");
        RewriteRuleSubtreeStream stream_hiveTable=new RewriteRuleSubtreeStream(adaptor,"rule hiveTable");
        RewriteRuleSubtreeStream stream_hdfsFile=new RewriteRuleSubtreeStream(adaptor,"rule hdfsFile");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_hiveQuery=new RewriteRuleSubtreeStream(adaptor,"rule hiveQuery");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        try {
            // Windowing2.g:124:11: ( (tf= tblfunc | hq= hiveQuery | hdf= hdfsFile | hvT= hiveTable ) (p= partitionby (o= orderby )? )? -> {tf != null}? ^( INPUT $tf ( $p)? ( $o)? ) -> {hq != null}? ^( INPUT $hq ( $p)? ( $o)? ) -> {hdf != null}? ^( INPUT $hdf ( $p)? ( $o)? ) -> ^( INPUT $hvT ( $p)? ( $o)? ) )
            // Windowing2.g:125:2: (tf= tblfunc | hq= hiveQuery | hdf= hdfsFile | hvT= hiveTable ) (p= partitionby (o= orderby )? )?
            {
            // Windowing2.g:125:2: (tf= tblfunc | hq= hiveQuery | hdf= hdfsFile | hvT= hiveTable )
            int alt11=4;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==LPAREN) ) {
                    alt11=1;
                }
                else if ( (LA11_1==EOF||(LA11_1>=SELECT && LA11_1<=COMMA)||LA11_1==DOT||LA11_1==RPAREN||(LA11_1>=WHERE && LA11_1<=INTO)||LA11_1==PARTITION||LA11_1==WINDOW) ) {
                    alt11=4;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("125:2: (tf= tblfunc | hq= hiveQuery | hdf= hdfsFile | hvT= hiveTable )", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case HIVEQUERY:
                {
                alt11=2;
                }
                break;
            case FILEINPUT:
                {
                alt11=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("125:2: (tf= tblfunc | hq= hiveQuery | hdf= hdfsFile | hvT= hiveTable )", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // Windowing2.g:125:3: tf= tblfunc
                    {
                    pushFollow(FOLLOW_tblfunc_in_tableSpec438);
                    tf=tblfunc();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_tblfunc.add(tf.getTree());

                    }
                    break;
                case 2 :
                    // Windowing2.g:126:3: hq= hiveQuery
                    {
                    pushFollow(FOLLOW_hiveQuery_in_tableSpec446);
                    hq=hiveQuery();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_hiveQuery.add(hq.getTree());

                    }
                    break;
                case 3 :
                    // Windowing2.g:127:3: hdf= hdfsFile
                    {
                    pushFollow(FOLLOW_hdfsFile_in_tableSpec454);
                    hdf=hdfsFile();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_hdfsFile.add(hdf.getTree());

                    }
                    break;
                case 4 :
                    // Windowing2.g:128:3: hvT= hiveTable
                    {
                    pushFollow(FOLLOW_hiveTable_in_tableSpec462);
                    hvT=hiveTable();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_hiveTable.add(hvT.getTree());

                    }
                    break;

            }

            // Windowing2.g:129:4: (p= partitionby (o= orderby )? )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==PARTITION) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Windowing2.g:129:5: p= partitionby (o= orderby )?
                    {
                    pushFollow(FOLLOW_partitionby_in_tableSpec470);
                    p=partitionby();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_partitionby.add(p.getTree());
                    // Windowing2.g:129:19: (o= orderby )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==ORDER) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // Windowing2.g:129:20: o= orderby
                            {
                            pushFollow(FOLLOW_orderby_in_tableSpec475);
                            o=orderby();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) stream_orderby.add(o.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }


            // AST REWRITE
            // elements: p, p, tf, hvT, p, o, hdf, o, hq, o, o, p
            // token labels: 
            // rule labels: retval, hq, hvT, p, hdf, o, tf
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_hq=new RewriteRuleSubtreeStream(adaptor,"token hq",hq!=null?hq.tree:null);
            RewriteRuleSubtreeStream stream_hvT=new RewriteRuleSubtreeStream(adaptor,"token hvT",hvT!=null?hvT.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"token p",p!=null?p.tree:null);
            RewriteRuleSubtreeStream stream_hdf=new RewriteRuleSubtreeStream(adaptor,"token hdf",hdf!=null?hdf.tree:null);
            RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"token o",o!=null?o.tree:null);
            RewriteRuleSubtreeStream stream_tf=new RewriteRuleSubtreeStream(adaptor,"token tf",tf!=null?tf.tree:null);

            root_0 = (Object)adaptor.nil();
            // 130:2: -> {tf != null}? ^( INPUT $tf ( $p)? ( $o)? )
            if (tf != null) {
                // Windowing2.g:130:19: ^( INPUT $tf ( $p)? ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INPUT, "INPUT"), root_1);

                adaptor.addChild(root_1, stream_tf.next());
                // Windowing2.g:130:31: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.next());

                }
                stream_p.reset();
                // Windowing2.g:130:35: ( $o)?
                if ( stream_o.hasNext() ) {
                    adaptor.addChild(root_1, stream_o.next());

                }
                stream_o.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 131:2: -> {hq != null}? ^( INPUT $hq ( $p)? ( $o)? )
            if (hq != null) {
                // Windowing2.g:131:19: ^( INPUT $hq ( $p)? ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INPUT, "INPUT"), root_1);

                adaptor.addChild(root_1, stream_hq.next());
                // Windowing2.g:131:31: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.next());

                }
                stream_p.reset();
                // Windowing2.g:131:35: ( $o)?
                if ( stream_o.hasNext() ) {
                    adaptor.addChild(root_1, stream_o.next());

                }
                stream_o.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 132:2: -> {hdf != null}? ^( INPUT $hdf ( $p)? ( $o)? )
            if (hdf != null) {
                // Windowing2.g:132:20: ^( INPUT $hdf ( $p)? ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INPUT, "INPUT"), root_1);

                adaptor.addChild(root_1, stream_hdf.next());
                // Windowing2.g:132:33: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.next());

                }
                stream_p.reset();
                // Windowing2.g:132:37: ( $o)?
                if ( stream_o.hasNext() ) {
                    adaptor.addChild(root_1, stream_o.next());

                }
                stream_o.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 133:2: -> ^( INPUT $hvT ( $p)? ( $o)? )
            {
                // Windowing2.g:133:6: ^( INPUT $hvT ( $p)? ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(INPUT, "INPUT"), root_1);

                adaptor.addChild(root_1, stream_hvT.next());
                // Windowing2.g:133:19: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.next());

                }
                stream_p.reset();
                // Windowing2.g:133:23: ( $o)?
                if ( stream_o.hasNext() ) {
                    adaptor.addChild(root_1, stream_o.next());

                }
                stream_o.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end tableSpec

    public static class hiveQuery_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start hiveQuery
    // Windowing2.g:136:1: hiveQuery : HIVEQUERY ;
    public final hiveQuery_return hiveQuery() throws RecognitionException {
        hiveQuery_return retval = new hiveQuery_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token HIVEQUERY26=null;

        Object HIVEQUERY26_tree=null;

        try {
            // Windowing2.g:136:11: ( HIVEQUERY )
            // Windowing2.g:137:2: HIVEQUERY
            {
            root_0 = (Object)adaptor.nil();

            HIVEQUERY26=(Token)input.LT(1);
            match(input,HIVEQUERY,FOLLOW_HIVEQUERY_in_hiveQuery571); if (failed) return retval;
            if ( backtracking==0 ) {
            HIVEQUERY26_tree = (Object)adaptor.create(HIVEQUERY26);
            adaptor.addChild(root_0, HIVEQUERY26_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end hiveQuery

    public static class hiveTable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start hiveTable
    // Windowing2.g:140:1: hiveTable : i1= Identifier ( DOT i2= Identifier )? -> {$i2 != null}? ^( HIVETBL $i1 $i2) -> ^( HIVETBL $i1) ;
    public final hiveTable_return hiveTable() throws RecognitionException {
        hiveTable_return retval = new hiveTable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i1=null;
        Token i2=null;
        Token DOT27=null;

        Object i1_tree=null;
        Object i2_tree=null;
        Object DOT27_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try {
            // Windowing2.g:140:11: (i1= Identifier ( DOT i2= Identifier )? -> {$i2 != null}? ^( HIVETBL $i1 $i2) -> ^( HIVETBL $i1) )
            // Windowing2.g:141:3: i1= Identifier ( DOT i2= Identifier )?
            {
            i1=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_hiveTable585); if (failed) return retval;
            if ( backtracking==0 ) stream_Identifier.add(i1);

            // Windowing2.g:141:17: ( DOT i2= Identifier )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==DOT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Windowing2.g:141:18: DOT i2= Identifier
                    {
                    DOT27=(Token)input.LT(1);
                    match(input,DOT,FOLLOW_DOT_in_hiveTable588); if (failed) return retval;
                    if ( backtracking==0 ) stream_DOT.add(DOT27);

                    i2=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_hiveTable592); if (failed) return retval;
                    if ( backtracking==0 ) stream_Identifier.add(i2);


                    }
                    break;

            }


            // AST REWRITE
            // elements: i1, i1, i2
            // token labels: i2, i1
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_i2=new RewriteRuleTokenStream(adaptor,"token i2",i2);
            RewriteRuleTokenStream stream_i1=new RewriteRuleTokenStream(adaptor,"token i1",i1);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 142:3: -> {$i2 != null}? ^( HIVETBL $i1 $i2)
            if (i2 != null) {
                // Windowing2.g:142:21: ^( HIVETBL $i1 $i2)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(HIVETBL, "HIVETBL"), root_1);

                adaptor.addChild(root_1, stream_i1.next());
                adaptor.addChild(root_1, stream_i2.next());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 143:3: -> ^( HIVETBL $i1)
            {
                // Windowing2.g:143:21: ^( HIVETBL $i1)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(HIVETBL, "HIVETBL"), root_1);

                adaptor.addChild(root_1, stream_i1.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end hiveTable

    public static class tblfunc_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start tblfunc
    // Windowing2.g:146:1: tblfunc : name= Identifier LPAREN tableSpec ( COMMA expression )* RPAREN -> ^( TBLFUNCTION $name tableSpec ( expression )* ) ;
    public final tblfunc_return tblfunc() throws RecognitionException {
        tblfunc_return retval = new tblfunc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token LPAREN28=null;
        Token COMMA30=null;
        Token RPAREN32=null;
        tableSpec_return tableSpec29 = null;

        expression_return expression31 = null;


        Object name_tree=null;
        Object LPAREN28_tree=null;
        Object COMMA30_tree=null;
        Object RPAREN32_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        try {
            // Windowing2.g:146:9: (name= Identifier LPAREN tableSpec ( COMMA expression )* RPAREN -> ^( TBLFUNCTION $name tableSpec ( expression )* ) )
            // Windowing2.g:147:3: name= Identifier LPAREN tableSpec ( COMMA expression )* RPAREN
            {
            name=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_tblfunc649); if (failed) return retval;
            if ( backtracking==0 ) stream_Identifier.add(name);

            LPAREN28=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_tblfunc651); if (failed) return retval;
            if ( backtracking==0 ) stream_LPAREN.add(LPAREN28);

            pushFollow(FOLLOW_tableSpec_in_tblfunc653);
            tableSpec29=tableSpec();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_tableSpec.add(tableSpec29.getTree());
            // Windowing2.g:147:36: ( COMMA expression )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Windowing2.g:147:37: COMMA expression
            	    {
            	    COMMA30=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_tblfunc656); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA30);

            	    pushFollow(FOLLOW_expression_in_tblfunc658);
            	    expression31=expression();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_expression.add(expression31.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            RPAREN32=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_tblfunc662); if (failed) return retval;
            if ( backtracking==0 ) stream_RPAREN.add(RPAREN32);


            // AST REWRITE
            // elements: expression, tableSpec, name
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 148:5: -> ^( TBLFUNCTION $name tableSpec ( expression )* )
            {
                // Windowing2.g:148:8: ^( TBLFUNCTION $name tableSpec ( expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(TBLFUNCTION, "TBLFUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.next());
                adaptor.addChild(root_1, stream_tableSpec.next());
                // Windowing2.g:148:38: ( expression )*
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.next());

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end tblfunc

    public static class hdfsFile_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start hdfsFile
    // Windowing2.g:151:1: hdfsFile : FILEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( HDFSLOCATION ( namevalue )* ) ;
    public final hdfsFile_return hdfsFile() throws RecognitionException {
        hdfsFile_return retval = new hdfsFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FILEINPUT33=null;
        Token LPAREN34=null;
        Token COMMA36=null;
        Token RPAREN38=null;
        namevalue_return namevalue35 = null;

        namevalue_return namevalue37 = null;


        Object FILEINPUT33_tree=null;
        Object LPAREN34_tree=null;
        Object COMMA36_tree=null;
        Object RPAREN38_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_FILEINPUT=new RewriteRuleTokenStream(adaptor,"token FILEINPUT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // Windowing2.g:151:10: ( FILEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( HDFSLOCATION ( namevalue )* ) )
            // Windowing2.g:152:2: FILEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            FILEINPUT33=(Token)input.LT(1);
            match(input,FILEINPUT,FOLLOW_FILEINPUT_in_hdfsFile690); if (failed) return retval;
            if ( backtracking==0 ) stream_FILEINPUT.add(FILEINPUT33);

            LPAREN34=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_hdfsFile692); if (failed) return retval;
            if ( backtracking==0 ) stream_LPAREN.add(LPAREN34);

            // Windowing2.g:152:19: ( namevalue )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Identifier||LA16_0==StringLiteral) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Windowing2.g:152:20: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hdfsFile695);
                    namevalue35=namevalue();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_namevalue.add(namevalue35.getTree());

                    }
                    break;

            }

            // Windowing2.g:152:32: ( COMMA namevalue )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Windowing2.g:152:33: COMMA namevalue
            	    {
            	    COMMA36=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_hdfsFile700); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA36);

            	    pushFollow(FOLLOW_namevalue_in_hdfsFile702);
            	    namevalue37=namevalue();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_namevalue.add(namevalue37.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            RPAREN38=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_hdfsFile706); if (failed) return retval;
            if ( backtracking==0 ) stream_RPAREN.add(RPAREN38);


            // AST REWRITE
            // elements: namevalue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 152:59: -> ^( HDFSLOCATION ( namevalue )* )
            {
                // Windowing2.g:152:62: ^( HDFSLOCATION ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(HDFSLOCATION, "HDFSLOCATION"), root_1);

                // Windowing2.g:152:77: ( namevalue )*
                while ( stream_namevalue.hasNext() ) {
                    adaptor.addChild(root_1, stream_namevalue.next());

                }
                stream_namevalue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end hdfsFile

    public static class where_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start where
    // Windowing2.g:155:1: where : ( WHERE expression ) -> ^( WHERE expression ) ;
    public final where_return where() throws RecognitionException {
        where_return retval = new where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE39=null;
        expression_return expression40 = null;


        Object WHERE39_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Windowing2.g:155:7: ( ( WHERE expression ) -> ^( WHERE expression ) )
            // Windowing2.g:156:2: ( WHERE expression )
            {
            // Windowing2.g:156:2: ( WHERE expression )
            // Windowing2.g:156:3: WHERE expression
            {
            WHERE39=(Token)input.LT(1);
            match(input,WHERE,FOLLOW_WHERE_in_where728); if (failed) return retval;
            if ( backtracking==0 ) stream_WHERE.add(WHERE39);

            pushFollow(FOLLOW_expression_in_where730);
            expression40=expression();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_expression.add(expression40.getTree());

            }


            // AST REWRITE
            // elements: expression, WHERE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 156:21: -> ^( WHERE expression )
            {
                // Windowing2.g:156:24: ^( WHERE expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_WHERE.next(), root_1);

                adaptor.addChild(root_1, stream_expression.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end where

    public static class outputClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start outputClause
    // Windowing2.g:159:1: outputClause : INTO PATH EQUAL p= StringLiteral (s= outputSerDe )? (lc= loadClause )? -> ^( OUTPUTSPEC $p ( $s)? ( $lc)? ) ;
    public final outputClause_return outputClause() throws RecognitionException {
        outputClause_return retval = new outputClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token p=null;
        Token INTO41=null;
        Token PATH42=null;
        Token EQUAL43=null;
        outputSerDe_return s = null;

        loadClause_return lc = null;


        Object p_tree=null;
        Object INTO41_tree=null;
        Object PATH42_tree=null;
        Object EQUAL43_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_PATH=new RewriteRuleTokenStream(adaptor,"token PATH");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
        RewriteRuleSubtreeStream stream_loadClause=new RewriteRuleSubtreeStream(adaptor,"rule loadClause");
        RewriteRuleSubtreeStream stream_outputSerDe=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDe");
        try {
            // Windowing2.g:159:14: ( INTO PATH EQUAL p= StringLiteral (s= outputSerDe )? (lc= loadClause )? -> ^( OUTPUTSPEC $p ( $s)? ( $lc)? ) )
            // Windowing2.g:160:2: INTO PATH EQUAL p= StringLiteral (s= outputSerDe )? (lc= loadClause )?
            {
            INTO41=(Token)input.LT(1);
            match(input,INTO,FOLLOW_INTO_in_outputClause749); if (failed) return retval;
            if ( backtracking==0 ) stream_INTO.add(INTO41);

            PATH42=(Token)input.LT(1);
            match(input,PATH,FOLLOW_PATH_in_outputClause751); if (failed) return retval;
            if ( backtracking==0 ) stream_PATH.add(PATH42);

            EQUAL43=(Token)input.LT(1);
            match(input,EQUAL,FOLLOW_EQUAL_in_outputClause753); if (failed) return retval;
            if ( backtracking==0 ) stream_EQUAL.add(EQUAL43);

            p=(Token)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_outputClause757); if (failed) return retval;
            if ( backtracking==0 ) stream_StringLiteral.add(p);

            // Windowing2.g:160:35: (s= outputSerDe )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==SERDE) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Windowing2.g:160:35: s= outputSerDe
                    {
                    pushFollow(FOLLOW_outputSerDe_in_outputClause761);
                    s=outputSerDe();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_outputSerDe.add(s.getTree());

                    }
                    break;

            }

            // Windowing2.g:160:51: (lc= loadClause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LOAD) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Windowing2.g:160:51: lc= loadClause
                    {
                    pushFollow(FOLLOW_loadClause_in_outputClause766);
                    lc=loadClause();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_loadClause.add(lc.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: p, s, lc
            // token labels: p
            // rule labels: retval, s, lc
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_p=new RewriteRuleTokenStream(adaptor,"token p",p);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);
            RewriteRuleSubtreeStream stream_lc=new RewriteRuleSubtreeStream(adaptor,"token lc",lc!=null?lc.tree:null);

            root_0 = (Object)adaptor.nil();
            // 160:64: -> ^( OUTPUTSPEC $p ( $s)? ( $lc)? )
            {
                // Windowing2.g:160:67: ^( OUTPUTSPEC $p ( $s)? ( $lc)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(OUTPUTSPEC, "OUTPUTSPEC"), root_1);

                adaptor.addChild(root_1, stream_p.next());
                // Windowing2.g:160:83: ( $s)?
                if ( stream_s.hasNext() ) {
                    adaptor.addChild(root_1, stream_s.next());

                }
                stream_s.reset();
                // Windowing2.g:160:87: ( $lc)?
                if ( stream_lc.hasNext() ) {
                    adaptor.addChild(root_1, stream_lc.next());

                }
                stream_lc.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end outputClause

    public static class outputSerDe_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start outputSerDe
    // Windowing2.g:163:1: outputSerDe : SERDE s= StringLiteral (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) ;
    public final outputSerDe_return outputSerDe() throws RecognitionException {
        outputSerDe_return retval = new outputSerDe_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token SERDE44=null;
        outputSerDePropeties_return p = null;

        outputFormatOrWriter_return o = null;


        Object s_tree=null;
        Object SERDE44_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_SERDE=new RewriteRuleTokenStream(adaptor,"token SERDE");
        RewriteRuleSubtreeStream stream_outputFormatOrWriter=new RewriteRuleSubtreeStream(adaptor,"rule outputFormatOrWriter");
        RewriteRuleSubtreeStream stream_outputSerDePropeties=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDePropeties");
        try {
            // Windowing2.g:163:13: ( SERDE s= StringLiteral (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) )
            // Windowing2.g:164:3: SERDE s= StringLiteral (p= outputSerDePropeties )? o= outputFormatOrWriter
            {
            SERDE44=(Token)input.LT(1);
            match(input,SERDE,FOLLOW_SERDE_in_outputSerDe795); if (failed) return retval;
            if ( backtracking==0 ) stream_SERDE.add(SERDE44);

            s=(Token)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_outputSerDe799); if (failed) return retval;
            if ( backtracking==0 ) stream_StringLiteral.add(s);

            // Windowing2.g:164:26: (p= outputSerDePropeties )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==WITH) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Windowing2.g:164:26: p= outputSerDePropeties
                    {
                    pushFollow(FOLLOW_outputSerDePropeties_in_outputSerDe803);
                    p=outputSerDePropeties();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_outputSerDePropeties.add(p.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe808);
            o=outputFormatOrWriter();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_outputFormatOrWriter.add(o.getTree());

            // AST REWRITE
            // elements: p, o, SERDE, s
            // token labels: s
            // rule labels: retval, p, o
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"token p",p!=null?p.tree:null);
            RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"token o",o!=null?o.tree:null);

            root_0 = (Object)adaptor.nil();
            // 164:72: -> ^( SERDE $s $o ( $p)? )
            {
                // Windowing2.g:164:75: ^( SERDE $s $o ( $p)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDE.next(), root_1);

                adaptor.addChild(root_1, stream_s.next());
                adaptor.addChild(root_1, stream_o.next());
                // Windowing2.g:164:89: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.next());

                }
                stream_p.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end outputSerDe

    public static class outputSerDePropeties_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start outputSerDePropeties
    // Windowing2.g:167:1: outputSerDePropeties : WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) ;
    public final outputSerDePropeties_return outputSerDePropeties() throws RecognitionException {
        outputSerDePropeties_return retval = new outputSerDePropeties_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WITH45=null;
        Token SERDEPROPERTIES46=null;
        Token LPAREN47=null;
        Token COMMA49=null;
        Token RPAREN51=null;
        namevalue_return namevalue48 = null;

        namevalue_return namevalue50 = null;


        Object WITH45_tree=null;
        Object SERDEPROPERTIES46_tree=null;
        Object LPAREN47_tree=null;
        Object COMMA49_tree=null;
        Object RPAREN51_tree=null;
        RewriteRuleTokenStream stream_SERDEPROPERTIES=new RewriteRuleTokenStream(adaptor,"token SERDEPROPERTIES");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // Windowing2.g:167:21: ( WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) )
            // Windowing2.g:168:3: WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            WITH45=(Token)input.LT(1);
            match(input,WITH,FOLLOW_WITH_in_outputSerDePropeties834); if (failed) return retval;
            if ( backtracking==0 ) stream_WITH.add(WITH45);

            SERDEPROPERTIES46=(Token)input.LT(1);
            match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties836); if (failed) return retval;
            if ( backtracking==0 ) stream_SERDEPROPERTIES.add(SERDEPROPERTIES46);

            LPAREN47=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_outputSerDePropeties838); if (failed) return retval;
            if ( backtracking==0 ) stream_LPAREN.add(LPAREN47);

            // Windowing2.g:168:31: ( namevalue )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Identifier||LA21_0==StringLiteral) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // Windowing2.g:168:32: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties841);
                    namevalue48=namevalue();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_namevalue.add(namevalue48.getTree());

                    }
                    break;

            }

            // Windowing2.g:168:44: ( COMMA namevalue )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==COMMA) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // Windowing2.g:168:45: COMMA namevalue
            	    {
            	    COMMA49=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_outputSerDePropeties846); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA49);

            	    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties848);
            	    namevalue50=namevalue();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_namevalue.add(namevalue50.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            RPAREN51=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_outputSerDePropeties852); if (failed) return retval;
            if ( backtracking==0 ) stream_RPAREN.add(RPAREN51);


            // AST REWRITE
            // elements: namevalue, SERDEPROPERTIES
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 169:6: -> ^( SERDEPROPERTIES ( namevalue )* )
            {
                // Windowing2.g:169:9: ^( SERDEPROPERTIES ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDEPROPERTIES.next(), root_1);

                // Windowing2.g:169:27: ( namevalue )*
                while ( stream_namevalue.hasNext() ) {
                    adaptor.addChild(root_1, stream_namevalue.next());

                }
                stream_namevalue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end outputSerDePropeties

    public static class outputFormatOrWriter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start outputFormatOrWriter
    // Windowing2.g:172:1: outputFormatOrWriter : ( RECORDWRITER StringLiteral -> ^( RECORDWRITER StringLiteral ) | FORMAT StringLiteral -> ^( FORMAT StringLiteral ) );
    public final outputFormatOrWriter_return outputFormatOrWriter() throws RecognitionException {
        outputFormatOrWriter_return retval = new outputFormatOrWriter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RECORDWRITER52=null;
        Token StringLiteral53=null;
        Token FORMAT54=null;
        Token StringLiteral55=null;

        Object RECORDWRITER52_tree=null;
        Object StringLiteral53_tree=null;
        Object FORMAT54_tree=null;
        Object StringLiteral55_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_RECORDWRITER=new RewriteRuleTokenStream(adaptor,"token RECORDWRITER");
        RewriteRuleTokenStream stream_FORMAT=new RewriteRuleTokenStream(adaptor,"token FORMAT");

        try {
            // Windowing2.g:172:22: ( RECORDWRITER StringLiteral -> ^( RECORDWRITER StringLiteral ) | FORMAT StringLiteral -> ^( FORMAT StringLiteral ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RECORDWRITER) ) {
                alt23=1;
            }
            else if ( (LA23_0==FORMAT) ) {
                alt23=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("172:1: outputFormatOrWriter : ( RECORDWRITER StringLiteral -> ^( RECORDWRITER StringLiteral ) | FORMAT StringLiteral -> ^( FORMAT StringLiteral ) );", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // Windowing2.g:173:3: RECORDWRITER StringLiteral
                    {
                    RECORDWRITER52=(Token)input.LT(1);
                    match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter878); if (failed) return retval;
                    if ( backtracking==0 ) stream_RECORDWRITER.add(RECORDWRITER52);

                    StringLiteral53=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_outputFormatOrWriter880); if (failed) return retval;
                    if ( backtracking==0 ) stream_StringLiteral.add(StringLiteral53);


                    // AST REWRITE
                    // elements: StringLiteral, RECORDWRITER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 173:30: -> ^( RECORDWRITER StringLiteral )
                    {
                        // Windowing2.g:173:33: ^( RECORDWRITER StringLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_RECORDWRITER.next(), root_1);

                        adaptor.addChild(root_1, stream_StringLiteral.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // Windowing2.g:174:3: FORMAT StringLiteral
                    {
                    FORMAT54=(Token)input.LT(1);
                    match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter894); if (failed) return retval;
                    if ( backtracking==0 ) stream_FORMAT.add(FORMAT54);

                    StringLiteral55=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_outputFormatOrWriter896); if (failed) return retval;
                    if ( backtracking==0 ) stream_StringLiteral.add(StringLiteral55);


                    // AST REWRITE
                    // elements: StringLiteral, FORMAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 174:24: -> ^( FORMAT StringLiteral )
                    {
                        // Windowing2.g:174:27: ^( FORMAT StringLiteral )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_FORMAT.next(), root_1);

                        adaptor.addChild(root_1, stream_StringLiteral.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end outputFormatOrWriter

    public static class loadClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start loadClause
    // Windowing2.g:177:1: loadClause : LOAD (ov= OVERWRITE )? INTO TABLE t= Identifier ( PARTITION l= StringLiteral )? -> ^( LOADSPEC $t ( $l)? ( $ov)? ) ;
    public final loadClause_return loadClause() throws RecognitionException {
        loadClause_return retval = new loadClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ov=null;
        Token t=null;
        Token l=null;
        Token LOAD56=null;
        Token INTO57=null;
        Token TABLE58=null;
        Token PARTITION59=null;

        Object ov_tree=null;
        Object t_tree=null;
        Object l_tree=null;
        Object LOAD56_tree=null;
        Object INTO57_tree=null;
        Object TABLE58_tree=null;
        Object PARTITION59_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_TABLE=new RewriteRuleTokenStream(adaptor,"token TABLE");
        RewriteRuleTokenStream stream_OVERWRITE=new RewriteRuleTokenStream(adaptor,"token OVERWRITE");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_LOAD=new RewriteRuleTokenStream(adaptor,"token LOAD");

        try {
            // Windowing2.g:177:11: ( LOAD (ov= OVERWRITE )? INTO TABLE t= Identifier ( PARTITION l= StringLiteral )? -> ^( LOADSPEC $t ( $l)? ( $ov)? ) )
            // Windowing2.g:178:3: LOAD (ov= OVERWRITE )? INTO TABLE t= Identifier ( PARTITION l= StringLiteral )?
            {
            LOAD56=(Token)input.LT(1);
            match(input,LOAD,FOLLOW_LOAD_in_loadClause914); if (failed) return retval;
            if ( backtracking==0 ) stream_LOAD.add(LOAD56);

            // Windowing2.g:178:10: (ov= OVERWRITE )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==OVERWRITE) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Windowing2.g:178:10: ov= OVERWRITE
                    {
                    ov=(Token)input.LT(1);
                    match(input,OVERWRITE,FOLLOW_OVERWRITE_in_loadClause918); if (failed) return retval;
                    if ( backtracking==0 ) stream_OVERWRITE.add(ov);


                    }
                    break;

            }

            INTO57=(Token)input.LT(1);
            match(input,INTO,FOLLOW_INTO_in_loadClause921); if (failed) return retval;
            if ( backtracking==0 ) stream_INTO.add(INTO57);

            TABLE58=(Token)input.LT(1);
            match(input,TABLE,FOLLOW_TABLE_in_loadClause923); if (failed) return retval;
            if ( backtracking==0 ) stream_TABLE.add(TABLE58);

            t=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_loadClause927); if (failed) return retval;
            if ( backtracking==0 ) stream_Identifier.add(t);

            // Windowing2.g:178:46: ( PARTITION l= StringLiteral )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==PARTITION) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // Windowing2.g:178:47: PARTITION l= StringLiteral
                    {
                    PARTITION59=(Token)input.LT(1);
                    match(input,PARTITION,FOLLOW_PARTITION_in_loadClause930); if (failed) return retval;
                    if ( backtracking==0 ) stream_PARTITION.add(PARTITION59);

                    l=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_loadClause934); if (failed) return retval;
                    if ( backtracking==0 ) stream_StringLiteral.add(l);


                    }
                    break;

            }


            // AST REWRITE
            // elements: t, ov, l
            // token labels: ov, t, l
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_ov=new RewriteRuleTokenStream(adaptor,"token ov",ov);
            RewriteRuleTokenStream stream_t=new RewriteRuleTokenStream(adaptor,"token t",t);
            RewriteRuleTokenStream stream_l=new RewriteRuleTokenStream(adaptor,"token l",l);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 178:75: -> ^( LOADSPEC $t ( $l)? ( $ov)? )
            {
                // Windowing2.g:178:78: ^( LOADSPEC $t ( $l)? ( $ov)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(LOADSPEC, "LOADSPEC"), root_1);

                adaptor.addChild(root_1, stream_t.next());
                // Windowing2.g:178:92: ( $l)?
                if ( stream_l.hasNext() ) {
                    adaptor.addChild(root_1, stream_l.next());

                }
                stream_l.reset();
                // Windowing2.g:178:96: ( $ov)?
                if ( stream_ov.hasNext() ) {
                    adaptor.addChild(root_1, stream_ov.next());

                }
                stream_ov.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end loadClause

    public static class window_function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_function
    // Windowing2.g:181:1: window_function : {...}? functionName LPAREN ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? ) RPAREN ( OVER ws= window_specification )? -> {$star != null}? ^( WDW_FUNCTIONSTAR functionName ( $ws)? ) -> {$dist == null}? ^( WDW_FUNCTION functionName ( ( expression )+ )? ( $ws)? ) -> ^( WDW_FUNCTIONDIST functionName ( ( expression )+ )? ( $ws)? ) ;
    public final window_function_return window_function() throws RecognitionException {
        window_function_return retval = new window_function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token star=null;
        Token dist=null;
        Token LPAREN61=null;
        Token COMMA63=null;
        Token RPAREN65=null;
        Token OVER66=null;
        window_specification_return ws = null;

        functionName_return functionName60 = null;

        expression_return expression62 = null;

        expression_return expression64 = null;


        Object star_tree=null;
        Object dist_tree=null;
        Object LPAREN61_tree=null;
        Object COMMA63_tree=null;
        Object RPAREN65_tree=null;
        Object OVER66_tree=null;
        RewriteRuleTokenStream stream_OVER=new RewriteRuleTokenStream(adaptor,"token OVER");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_DISTINCT=new RewriteRuleTokenStream(adaptor,"token DISTINCT");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_window_specification=new RewriteRuleSubtreeStream(adaptor,"rule window_specification");
        RewriteRuleSubtreeStream stream_functionName=new RewriteRuleSubtreeStream(adaptor,"rule functionName");
        try {
            // Windowing2.g:182:3: ({...}? functionName LPAREN ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? ) RPAREN ( OVER ws= window_specification )? -> {$star != null}? ^( WDW_FUNCTIONSTAR functionName ( $ws)? ) -> {$dist == null}? ^( WDW_FUNCTION functionName ( ( expression )+ )? ( $ws)? ) -> ^( WDW_FUNCTIONDIST functionName ( ( expression )+ )? ( $ws)? ) )
            // Windowing2.g:183:3: {...}? functionName LPAREN ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? ) RPAREN ( OVER ws= window_specification )?
            {
            if ( !(isWindowingFunction(input.LT(1))) ) {
                if (backtracking>0) {failed=true; return retval;}
                throw new FailedPredicateException(input, "window_function", "isWindowingFunction(input.LT(1))");
            }
            pushFollow(FOLLOW_functionName_in_window_function970);
            functionName60=functionName();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_functionName.add(functionName60.getTree());
            LPAREN61=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_window_function977); if (failed) return retval;
            if ( backtracking==0 ) stream_LPAREN.add(LPAREN61);

            // Windowing2.g:185:5: ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==STAR) ) {
                alt29=1;
            }
            else if ( (LA29_0==Identifier||(LA29_0>=LPAREN && LA29_0<=RPAREN)||LA29_0==StringLiteral||LA29_0==DISTINCT||LA29_0==Number||(LA29_0>=IF && LA29_0<=CASE)||(LA29_0>=BigintLiteral && LA29_0<=CharSetName)||LA29_0==NOT||(LA29_0>=PLUS && LA29_0<=MINUS)||LA29_0==NULL||LA29_0==TILDE||(LA29_0>=TRUE && LA29_0<=FALSE)) ) {
                alt29=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("185:5: ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? )", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // Windowing2.g:186:7: (star= STAR )
                    {
                    // Windowing2.g:186:7: (star= STAR )
                    // Windowing2.g:186:8: star= STAR
                    {
                    star=(Token)input.LT(1);
                    match(input,STAR,FOLLOW_STAR_in_window_function995); if (failed) return retval;
                    if ( backtracking==0 ) stream_STAR.add(star);


                    }


                    }
                    break;
                case 2 :
                    // Windowing2.g:187:9: (dist= DISTINCT )? ( expression ( COMMA expression )* )?
                    {
                    // Windowing2.g:187:9: (dist= DISTINCT )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==DISTINCT) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // Windowing2.g:187:10: dist= DISTINCT
                            {
                            dist=(Token)input.LT(1);
                            match(input,DISTINCT,FOLLOW_DISTINCT_in_window_function1009); if (failed) return retval;
                            if ( backtracking==0 ) stream_DISTINCT.add(dist);


                            }
                            break;

                    }

                    // Windowing2.g:187:26: ( expression ( COMMA expression )* )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==Identifier||LA28_0==LPAREN||LA28_0==StringLiteral||LA28_0==Number||(LA28_0>=IF && LA28_0<=CASE)||(LA28_0>=BigintLiteral && LA28_0<=CharSetName)||LA28_0==NOT||(LA28_0>=PLUS && LA28_0<=MINUS)||LA28_0==NULL||LA28_0==TILDE||(LA28_0>=TRUE && LA28_0<=FALSE)) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // Windowing2.g:187:27: expression ( COMMA expression )*
                            {
                            pushFollow(FOLLOW_expression_in_window_function1014);
                            expression62=expression();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) stream_expression.add(expression62.getTree());
                            // Windowing2.g:187:38: ( COMMA expression )*
                            loop27:
                            do {
                                int alt27=2;
                                int LA27_0 = input.LA(1);

                                if ( (LA27_0==COMMA) ) {
                                    alt27=1;
                                }


                                switch (alt27) {
                            	case 1 :
                            	    // Windowing2.g:187:39: COMMA expression
                            	    {
                            	    COMMA63=(Token)input.LT(1);
                            	    match(input,COMMA,FOLLOW_COMMA_in_window_function1017); if (failed) return retval;
                            	    if ( backtracking==0 ) stream_COMMA.add(COMMA63);

                            	    pushFollow(FOLLOW_expression_in_window_function1019);
                            	    expression64=expression();
                            	    _fsp--;
                            	    if (failed) return retval;
                            	    if ( backtracking==0 ) stream_expression.add(expression64.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop27;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RPAREN65=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_window_function1036); if (failed) return retval;
            if ( backtracking==0 ) stream_RPAREN.add(RPAREN65);

            // Windowing2.g:189:12: ( OVER ws= window_specification )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==OVER) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Windowing2.g:189:13: OVER ws= window_specification
                    {
                    OVER66=(Token)input.LT(1);
                    match(input,OVER,FOLLOW_OVER_in_window_function1039); if (failed) return retval;
                    if ( backtracking==0 ) stream_OVER.add(OVER66);

                    pushFollow(FOLLOW_window_specification_in_window_function1043);
                    ws=window_specification();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_window_specification.add(ws.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: expression, ws, ws, functionName, functionName, functionName, expression, ws
            // token labels: 
            // rule labels: retval, ws
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_ws=new RewriteRuleSubtreeStream(adaptor,"token ws",ws!=null?ws.tree:null);

            root_0 = (Object)adaptor.nil();
            // 190:7: -> {$star != null}? ^( WDW_FUNCTIONSTAR functionName ( $ws)? )
            if (star != null) {
                // Windowing2.g:190:27: ^( WDW_FUNCTIONSTAR functionName ( $ws)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WDW_FUNCTIONSTAR, "WDW_FUNCTIONSTAR"), root_1);

                adaptor.addChild(root_1, stream_functionName.next());
                // Windowing2.g:190:59: ( $ws)?
                if ( stream_ws.hasNext() ) {
                    adaptor.addChild(root_1, stream_ws.next());

                }
                stream_ws.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 191:7: -> {$dist == null}? ^( WDW_FUNCTION functionName ( ( expression )+ )? ( $ws)? )
            if (dist == null) {
                // Windowing2.g:191:27: ^( WDW_FUNCTION functionName ( ( expression )+ )? ( $ws)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WDW_FUNCTION, "WDW_FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_functionName.next());
                // Windowing2.g:191:55: ( ( expression )+ )?
                if ( stream_expression.hasNext() ) {
                    if ( !(stream_expression.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_expression.hasNext() ) {
                        adaptor.addChild(root_1, stream_expression.next());

                    }
                    stream_expression.reset();

                }
                stream_expression.reset();
                // Windowing2.g:191:70: ( $ws)?
                if ( stream_ws.hasNext() ) {
                    adaptor.addChild(root_1, stream_ws.next());

                }
                stream_ws.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 192:7: -> ^( WDW_FUNCTIONDIST functionName ( ( expression )+ )? ( $ws)? )
            {
                // Windowing2.g:192:27: ^( WDW_FUNCTIONDIST functionName ( ( expression )+ )? ( $ws)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WDW_FUNCTIONDIST, "WDW_FUNCTIONDIST"), root_1);

                adaptor.addChild(root_1, stream_functionName.next());
                // Windowing2.g:192:59: ( ( expression )+ )?
                if ( stream_expression.hasNext() ) {
                    if ( !(stream_expression.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_expression.hasNext() ) {
                        adaptor.addChild(root_1, stream_expression.next());

                    }
                    stream_expression.reset();

                }
                stream_expression.reset();
                // Windowing2.g:192:74: ( $ws)?
                if ( stream_ws.hasNext() ) {
                    adaptor.addChild(root_1, stream_ws.next());

                }
                stream_ws.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end window_function

    public static class window_clause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_clause
    // Windowing2.g:195:1: window_clause : WINDOW window_defn ( COMMA window_defn )* -> ^( WINDOW ( window_defn )+ ) ;
    public final window_clause_return window_clause() throws RecognitionException {
        window_clause_return retval = new window_clause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WINDOW67=null;
        Token COMMA69=null;
        window_defn_return window_defn68 = null;

        window_defn_return window_defn70 = null;


        Object WINDOW67_tree=null;
        Object COMMA69_tree=null;
        RewriteRuleTokenStream stream_WINDOW=new RewriteRuleTokenStream(adaptor,"token WINDOW");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_window_defn=new RewriteRuleSubtreeStream(adaptor,"rule window_defn");
        try {
            // Windowing2.g:195:15: ( WINDOW window_defn ( COMMA window_defn )* -> ^( WINDOW ( window_defn )+ ) )
            // Windowing2.g:196:3: WINDOW window_defn ( COMMA window_defn )*
            {
            WINDOW67=(Token)input.LT(1);
            match(input,WINDOW,FOLLOW_WINDOW_in_window_clause1146); if (failed) return retval;
            if ( backtracking==0 ) stream_WINDOW.add(WINDOW67);

            pushFollow(FOLLOW_window_defn_in_window_clause1148);
            window_defn68=window_defn();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_window_defn.add(window_defn68.getTree());
            // Windowing2.g:196:22: ( COMMA window_defn )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==COMMA) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // Windowing2.g:196:23: COMMA window_defn
            	    {
            	    COMMA69=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_window_clause1151); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA69);

            	    pushFollow(FOLLOW_window_defn_in_window_clause1153);
            	    window_defn70=window_defn();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_window_defn.add(window_defn70.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            // AST REWRITE
            // elements: window_defn, WINDOW
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 196:43: -> ^( WINDOW ( window_defn )+ )
            {
                // Windowing2.g:196:46: ^( WINDOW ( window_defn )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_WINDOW.next(), root_1);

                if ( !(stream_window_defn.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_window_defn.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_defn.next());

                }
                stream_window_defn.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end window_clause

    public static class window_defn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_defn
    // Windowing2.g:199:1: window_defn : Identifier AS window_specification -> ^( WINDOWDEF Identifier window_specification ) ;
    public final window_defn_return window_defn() throws RecognitionException {
        window_defn_return retval = new window_defn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier71=null;
        Token AS72=null;
        window_specification_return window_specification73 = null;


        Object Identifier71_tree=null;
        Object AS72_tree=null;
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_window_specification=new RewriteRuleSubtreeStream(adaptor,"rule window_specification");
        try {
            // Windowing2.g:199:13: ( Identifier AS window_specification -> ^( WINDOWDEF Identifier window_specification ) )
            // Windowing2.g:200:3: Identifier AS window_specification
            {
            Identifier71=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_window_defn1177); if (failed) return retval;
            if ( backtracking==0 ) stream_Identifier.add(Identifier71);

            AS72=(Token)input.LT(1);
            match(input,AS,FOLLOW_AS_in_window_defn1179); if (failed) return retval;
            if ( backtracking==0 ) stream_AS.add(AS72);

            pushFollow(FOLLOW_window_specification_in_window_defn1181);
            window_specification73=window_specification();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_window_specification.add(window_specification73.getTree());

            // AST REWRITE
            // elements: Identifier, window_specification
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 200:38: -> ^( WINDOWDEF Identifier window_specification )
            {
                // Windowing2.g:200:41: ^( WINDOWDEF Identifier window_specification )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WINDOWDEF, "WINDOWDEF"), root_1);

                adaptor.addChild(root_1, stream_Identifier.next());
                adaptor.addChild(root_1, stream_window_specification.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end window_defn

    public static class window_specification_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_specification
    // Windowing2.g:203:1: window_specification : ( Identifier )? ( partitionby )? ( orderby )? ( window_frame )? -> ^( WINDOWSPEC ( Identifier )? ( partitionby )? ( orderby )? ( window_frame )? ) ;
    public final window_specification_return window_specification() throws RecognitionException {
        window_specification_return retval = new window_specification_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier74=null;
        partitionby_return partitionby75 = null;

        orderby_return orderby76 = null;

        window_frame_return window_frame77 = null;


        Object Identifier74_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_window_frame=new RewriteRuleSubtreeStream(adaptor,"rule window_frame");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        try {
            // Windowing2.g:203:22: ( ( Identifier )? ( partitionby )? ( orderby )? ( window_frame )? -> ^( WINDOWSPEC ( Identifier )? ( partitionby )? ( orderby )? ( window_frame )? ) )
            // Windowing2.g:204:3: ( Identifier )? ( partitionby )? ( orderby )? ( window_frame )?
            {
            // Windowing2.g:204:3: ( Identifier )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==Identifier) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Windowing2.g:204:3: Identifier
                    {
                    Identifier74=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_window_specification1204); if (failed) return retval;
                    if ( backtracking==0 ) stream_Identifier.add(Identifier74);


                    }
                    break;

            }

            // Windowing2.g:204:15: ( partitionby )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==PARTITION) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // Windowing2.g:204:15: partitionby
                    {
                    pushFollow(FOLLOW_partitionby_in_window_specification1207);
                    partitionby75=partitionby();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_partitionby.add(partitionby75.getTree());

                    }
                    break;

            }

            // Windowing2.g:204:28: ( orderby )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ORDER) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // Windowing2.g:204:28: orderby
                    {
                    pushFollow(FOLLOW_orderby_in_window_specification1210);
                    orderby76=orderby();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_orderby.add(orderby76.getTree());

                    }
                    break;

            }

            // Windowing2.g:204:37: ( window_frame )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ROWS||LA35_0==RANGE) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // Windowing2.g:204:37: window_frame
                    {
                    pushFollow(FOLLOW_window_frame_in_window_specification1213);
                    window_frame77=window_frame();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_window_frame.add(window_frame77.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: window_frame, partitionby, orderby, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 204:51: -> ^( WINDOWSPEC ( Identifier )? ( partitionby )? ( orderby )? ( window_frame )? )
            {
                // Windowing2.g:204:54: ^( WINDOWSPEC ( Identifier )? ( partitionby )? ( orderby )? ( window_frame )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WINDOWSPEC, "WINDOWSPEC"), root_1);

                // Windowing2.g:204:67: ( Identifier )?
                if ( stream_Identifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_Identifier.next());

                }
                stream_Identifier.reset();
                // Windowing2.g:204:79: ( partitionby )?
                if ( stream_partitionby.hasNext() ) {
                    adaptor.addChild(root_1, stream_partitionby.next());

                }
                stream_partitionby.reset();
                // Windowing2.g:204:92: ( orderby )?
                if ( stream_orderby.hasNext() ) {
                    adaptor.addChild(root_1, stream_orderby.next());

                }
                stream_orderby.reset();
                // Windowing2.g:204:101: ( window_frame )?
                if ( stream_window_frame.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_frame.next());

                }
                stream_window_frame.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end window_specification

    public static class orderby_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start orderby
    // Windowing2.g:207:1: orderby : ORDER BY ordercolumn ( ( COMMA ordercolumn )=> COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
    public final orderby_return orderby() throws RecognitionException {
        orderby_return retval = new orderby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER78=null;
        Token BY79=null;
        Token COMMA81=null;
        ordercolumn_return ordercolumn80 = null;

        ordercolumn_return ordercolumn82 = null;


        Object ORDER78_tree=null;
        Object BY79_tree=null;
        Object COMMA81_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_ordercolumn=new RewriteRuleSubtreeStream(adaptor,"rule ordercolumn");
        try {
            // Windowing2.g:207:9: ( ORDER BY ordercolumn ( ( COMMA ordercolumn )=> COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // Windowing2.g:208:2: ORDER BY ordercolumn ( ( COMMA ordercolumn )=> COMMA ordercolumn )*
            {
            ORDER78=(Token)input.LT(1);
            match(input,ORDER,FOLLOW_ORDER_in_orderby1242); if (failed) return retval;
            if ( backtracking==0 ) stream_ORDER.add(ORDER78);

            BY79=(Token)input.LT(1);
            match(input,BY,FOLLOW_BY_in_orderby1244); if (failed) return retval;
            if ( backtracking==0 ) stream_BY.add(BY79);

            pushFollow(FOLLOW_ordercolumn_in_orderby1246);
            ordercolumn80=ordercolumn();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_ordercolumn.add(ordercolumn80.getTree());
            // Windowing2.g:208:23: ( ( COMMA ordercolumn )=> COMMA ordercolumn )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==COMMA) ) {
                    int LA36_6 = input.LA(2);

                    if ( (LA36_6==Identifier) ) {
                        int LA36_24 = input.LA(3);

                        if ( (synpred1()) ) {
                            alt36=1;
                        }


                    }


                }


                switch (alt36) {
            	case 1 :
            	    // Windowing2.g:208:24: ( COMMA ordercolumn )=> COMMA ordercolumn
            	    {
            	    COMMA81=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_orderby1256); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA81);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby1258);
            	    ordercolumn82=ordercolumn();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_ordercolumn.add(ordercolumn82.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            // AST REWRITE
            // elements: ordercolumn, ORDER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 208:66: -> ^( ORDER ( ordercolumn )+ )
            {
                // Windowing2.g:208:69: ^( ORDER ( ordercolumn )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_ORDER.next(), root_1);

                if ( !(stream_ordercolumn.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ordercolumn.hasNext() ) {
                    adaptor.addChild(root_1, stream_ordercolumn.next());

                }
                stream_ordercolumn.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end orderby

    public static class ordercolumn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ordercolumn
    // Windowing2.g:211:1: ordercolumn : columnReference (o= ASC | o= DESC )? -> ^( ORDERCOLUMN columnReference ( $o)? ) ;
    public final ordercolumn_return ordercolumn() throws RecognitionException {
        ordercolumn_return retval = new ordercolumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token o=null;
        columnReference_return columnReference83 = null;


        Object o_tree=null;
        RewriteRuleTokenStream stream_ASC=new RewriteRuleTokenStream(adaptor,"token ASC");
        RewriteRuleTokenStream stream_DESC=new RewriteRuleTokenStream(adaptor,"token DESC");
        RewriteRuleSubtreeStream stream_columnReference=new RewriteRuleSubtreeStream(adaptor,"rule columnReference");
        try {
            // Windowing2.g:211:13: ( columnReference (o= ASC | o= DESC )? -> ^( ORDERCOLUMN columnReference ( $o)? ) )
            // Windowing2.g:212:2: columnReference (o= ASC | o= DESC )?
            {
            pushFollow(FOLLOW_columnReference_in_ordercolumn1279);
            columnReference83=columnReference();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_columnReference.add(columnReference83.getTree());
            // Windowing2.g:212:18: (o= ASC | o= DESC )?
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==ASC) ) {
                alt37=1;
            }
            else if ( (LA37_0==DESC) ) {
                alt37=2;
            }
            switch (alt37) {
                case 1 :
                    // Windowing2.g:212:19: o= ASC
                    {
                    o=(Token)input.LT(1);
                    match(input,ASC,FOLLOW_ASC_in_ordercolumn1284); if (failed) return retval;
                    if ( backtracking==0 ) stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // Windowing2.g:212:27: o= DESC
                    {
                    o=(Token)input.LT(1);
                    match(input,DESC,FOLLOW_DESC_in_ordercolumn1290); if (failed) return retval;
                    if ( backtracking==0 ) stream_DESC.add(o);


                    }
                    break;

            }


            // AST REWRITE
            // elements: o, columnReference
            // token labels: o
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_o=new RewriteRuleTokenStream(adaptor,"token o",o);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 212:36: -> ^( ORDERCOLUMN columnReference ( $o)? )
            {
                // Windowing2.g:212:39: ^( ORDERCOLUMN columnReference ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_columnReference.next());
                // Windowing2.g:212:69: ( $o)?
                if ( stream_o.hasNext() ) {
                    adaptor.addChild(root_1, stream_o.next());

                }
                stream_o.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end ordercolumn

    public static class partitionby_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start partitionby
    // Windowing2.g:215:1: partitionby : PARTITION BY columnReference ( ( COMMA columnReference )=> COMMA columnReference )* -> ^( PARTITION ( columnReference )+ ) ;
    public final partitionby_return partitionby() throws RecognitionException {
        partitionby_return retval = new partitionby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PARTITION84=null;
        Token BY85=null;
        Token COMMA87=null;
        columnReference_return columnReference86 = null;

        columnReference_return columnReference88 = null;


        Object PARTITION84_tree=null;
        Object BY85_tree=null;
        Object COMMA87_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");
        RewriteRuleSubtreeStream stream_columnReference=new RewriteRuleSubtreeStream(adaptor,"rule columnReference");
        try {
            // Windowing2.g:215:13: ( PARTITION BY columnReference ( ( COMMA columnReference )=> COMMA columnReference )* -> ^( PARTITION ( columnReference )+ ) )
            // Windowing2.g:216:2: PARTITION BY columnReference ( ( COMMA columnReference )=> COMMA columnReference )*
            {
            PARTITION84=(Token)input.LT(1);
            match(input,PARTITION,FOLLOW_PARTITION_in_partitionby1315); if (failed) return retval;
            if ( backtracking==0 ) stream_PARTITION.add(PARTITION84);

            BY85=(Token)input.LT(1);
            match(input,BY,FOLLOW_BY_in_partitionby1317); if (failed) return retval;
            if ( backtracking==0 ) stream_BY.add(BY85);

            pushFollow(FOLLOW_columnReference_in_partitionby1319);
            columnReference86=columnReference();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_columnReference.add(columnReference86.getTree());
            // Windowing2.g:216:31: ( ( COMMA columnReference )=> COMMA columnReference )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==COMMA) ) {
                    int LA38_7 = input.LA(2);

                    if ( (LA38_7==Identifier) ) {
                        int LA38_12 = input.LA(3);

                        if ( (synpred2()) ) {
                            alt38=1;
                        }


                    }


                }


                switch (alt38) {
            	case 1 :
            	    // Windowing2.g:216:32: ( COMMA columnReference )=> COMMA columnReference
            	    {
            	    COMMA87=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_partitionby1329); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA87);

            	    pushFollow(FOLLOW_columnReference_in_partitionby1331);
            	    columnReference88=columnReference();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_columnReference.add(columnReference88.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            // AST REWRITE
            // elements: columnReference, PARTITION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 216:82: -> ^( PARTITION ( columnReference )+ )
            {
                // Windowing2.g:216:85: ^( PARTITION ( columnReference )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_PARTITION.next(), root_1);

                if ( !(stream_columnReference.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_columnReference.hasNext() ) {
                    adaptor.addChild(root_1, stream_columnReference.next());

                }
                stream_columnReference.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end partitionby

    public static class window_frame_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_frame
    // Windowing2.g:219:1: window_frame : ( window_range_expression | window_value_expression );
    public final window_frame_return window_frame() throws RecognitionException {
        window_frame_return retval = new window_frame_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        window_range_expression_return window_range_expression89 = null;

        window_value_expression_return window_value_expression90 = null;



        try {
            // Windowing2.g:219:14: ( window_range_expression | window_value_expression )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==ROWS) ) {
                alt39=1;
            }
            else if ( (LA39_0==RANGE) ) {
                alt39=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("219:1: window_frame : ( window_range_expression | window_value_expression );", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // Windowing2.g:220:2: window_range_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_window_range_expression_in_window_frame1352);
                    window_range_expression89=window_range_expression();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, window_range_expression89.getTree());

                    }
                    break;
                case 2 :
                    // Windowing2.g:221:2: window_value_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_window_value_expression_in_window_frame1357);
                    window_value_expression90=window_value_expression();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, window_value_expression90.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end window_frame

    public static class window_range_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_range_expression
    // Windowing2.g:224:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final window_range_expression_return window_range_expression() throws RecognitionException {
        window_range_expression_return retval = new window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS91=null;
        Token BETWEEN92=null;
        Token AND93=null;
        rowsboundary_return s = null;

        rowsboundary_return e = null;


        Object ROWS91_tree=null;
        Object BETWEEN92_tree=null;
        Object AND93_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // Windowing2.g:224:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // Windowing2.g:225:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS91=(Token)input.LT(1);
            match(input,ROWS,FOLLOW_ROWS_in_window_range_expression1367); if (failed) return retval;
            if ( backtracking==0 ) stream_ROWS.add(ROWS91);

            BETWEEN92=(Token)input.LT(1);
            match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression1369); if (failed) return retval;
            if ( backtracking==0 ) stream_BETWEEN.add(BETWEEN92);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression1373);
            s=rowsboundary();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_rowsboundary.add(s.getTree());
            AND93=(Token)input.LT(1);
            match(input,AND,FOLLOW_AND_in_window_range_expression1375); if (failed) return retval;
            if ( backtracking==0 ) stream_AND.add(AND93);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression1379);
            e=rowsboundary();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_rowsboundary.add(e.getTree());

            // AST REWRITE
            // elements: e, s
            // token labels: 
            // rule labels: retval, e, s
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",e!=null?e.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);

            root_0 = (Object)adaptor.nil();
            // 225:49: -> ^( WINDOWRANGE $s $e)
            {
                // Windowing2.g:225:52: ^( WINDOWRANGE $s $e)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WINDOWRANGE, "WINDOWRANGE"), root_1);

                adaptor.addChild(root_1, stream_s.next());
                adaptor.addChild(root_1, stream_e.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end window_range_expression

    public static class rowsboundary_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start rowsboundary
    // Windowing2.g:228:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | Number (d= PRECEDING | d= FOLLOWING ) -> ^( $d Number ) );
    public final rowsboundary_return rowsboundary() throws RecognitionException {
        rowsboundary_return retval = new rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED94=null;
        Token CURRENT95=null;
        Token ROW96=null;
        Token Number97=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED94_tree=null;
        Object CURRENT95_tree=null;
        Object ROW96_tree=null;
        Object Number97_tree=null;
        RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");

        try {
            // Windowing2.g:228:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | Number (d= PRECEDING | d= FOLLOWING ) -> ^( $d Number ) )
            int alt42=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt42=1;
                }
                break;
            case CURRENT:
                {
                alt42=2;
                }
                break;
            case Number:
                {
                alt42=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("228:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | Number (d= PRECEDING | d= FOLLOWING ) -> ^( $d Number ) );", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // Windowing2.g:229:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED94=(Token)input.LT(1);
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary1402); if (failed) return retval;
                    if ( backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED94);

                    // Windowing2.g:229:13: (r= PRECEDING | r= FOLLOWING )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==PRECEDING) ) {
                        alt40=1;
                    }
                    else if ( (LA40_0==FOLLOWING) ) {
                        alt40=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("229:13: (r= PRECEDING | r= FOLLOWING )", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // Windowing2.g:229:14: r= PRECEDING
                            {
                            r=(Token)input.LT(1);
                            match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary1407); if (failed) return retval;
                            if ( backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // Windowing2.g:229:26: r= FOLLOWING
                            {
                            r=(Token)input.LT(1);
                            match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary1411); if (failed) return retval;
                            if ( backtracking==0 ) stream_FOLLOWING.add(r);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: UNBOUNDED, r
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 229:40: -> ^( $r UNBOUNDED )
                    {
                        // Windowing2.g:229:43: ^( $r UNBOUNDED )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_r.next(), root_1);

                        adaptor.addChild(root_1, stream_UNBOUNDED.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // Windowing2.g:230:3: CURRENT ROW
                    {
                    CURRENT95=(Token)input.LT(1);
                    match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary1429); if (failed) return retval;
                    if ( backtracking==0 ) stream_CURRENT.add(CURRENT95);

                    ROW96=(Token)input.LT(1);
                    match(input,ROW,FOLLOW_ROW_in_rowsboundary1431); if (failed) return retval;
                    if ( backtracking==0 ) stream_ROW.add(ROW96);


                    // AST REWRITE
                    // elements: CURRENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 230:16: -> ^( CURRENT )
                    {
                        // Windowing2.g:230:19: ^( CURRENT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CURRENT.next(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 3 :
                    // Windowing2.g:231:3: Number (d= PRECEDING | d= FOLLOWING )
                    {
                    Number97=(Token)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_rowsboundary1444); if (failed) return retval;
                    if ( backtracking==0 ) stream_Number.add(Number97);

                    // Windowing2.g:231:10: (d= PRECEDING | d= FOLLOWING )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==PRECEDING) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==FOLLOWING) ) {
                        alt41=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("231:10: (d= PRECEDING | d= FOLLOWING )", 41, 0, input);

                        throw nvae;
                    }
                    switch (alt41) {
                        case 1 :
                            // Windowing2.g:231:11: d= PRECEDING
                            {
                            d=(Token)input.LT(1);
                            match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary1449); if (failed) return retval;
                            if ( backtracking==0 ) stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // Windowing2.g:231:25: d= FOLLOWING
                            {
                            d=(Token)input.LT(1);
                            match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary1455); if (failed) return retval;
                            if ( backtracking==0 ) stream_FOLLOWING.add(d);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: d, Number
                    // token labels: d
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 231:39: -> ^( $d Number )
                    {
                        // Windowing2.g:231:42: ^( $d Number )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_d.next(), root_1);

                        adaptor.addChild(root_1, stream_Number.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end rowsboundary

    public static class window_value_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_value_expression
    // Windowing2.g:234:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final window_value_expression_return window_value_expression() throws RecognitionException {
        window_value_expression_return retval = new window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE98=null;
        Token BETWEEN99=null;
        Token AND100=null;
        valuesboundary_return s = null;

        valuesboundary_return e = null;


        Object RANGE98_tree=null;
        Object BETWEEN99_tree=null;
        Object AND100_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // Windowing2.g:234:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // Windowing2.g:235:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE98=(Token)input.LT(1);
            match(input,RANGE,FOLLOW_RANGE_in_window_value_expression1476); if (failed) return retval;
            if ( backtracking==0 ) stream_RANGE.add(RANGE98);

            BETWEEN99=(Token)input.LT(1);
            match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression1478); if (failed) return retval;
            if ( backtracking==0 ) stream_BETWEEN.add(BETWEEN99);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression1482);
            s=valuesboundary();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_valuesboundary.add(s.getTree());
            AND100=(Token)input.LT(1);
            match(input,AND,FOLLOW_AND_in_window_value_expression1484); if (failed) return retval;
            if ( backtracking==0 ) stream_AND.add(AND100);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression1488);
            e=valuesboundary();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_valuesboundary.add(e.getTree());

            // AST REWRITE
            // elements: e, s
            // token labels: 
            // rule labels: retval, e, s
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",e!=null?e.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);

            root_0 = (Object)adaptor.nil();
            // 235:54: -> ^( WINDOWVALUES $s $e)
            {
                // Windowing2.g:235:57: ^( WINDOWVALUES $s $e)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WINDOWVALUES, "WINDOWVALUES"), root_1);

                adaptor.addChild(root_1, stream_s.next());
                adaptor.addChild(root_1, stream_e.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end window_value_expression

    public static class valuesboundary_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start valuesboundary
    // Windowing2.g:238:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | rowExp= expression rngExp= Number (d= LESS | d= MORE ) -> ^( $d $rowExp $rngExp) );
    public final valuesboundary_return valuesboundary() throws RecognitionException {
        valuesboundary_return retval = new valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token rngExp=null;
        Token d=null;
        Token UNBOUNDED101=null;
        Token CURRENT102=null;
        Token ROW103=null;
        expression_return rowExp = null;


        Object r_tree=null;
        Object rngExp_tree=null;
        Object d_tree=null;
        Object UNBOUNDED101_tree=null;
        Object CURRENT102_tree=null;
        Object ROW103_tree=null;
        RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
        RewriteRuleTokenStream stream_MORE=new RewriteRuleTokenStream(adaptor,"token MORE");
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_LESS=new RewriteRuleTokenStream(adaptor,"token LESS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Windowing2.g:238:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | rowExp= expression rngExp= Number (d= LESS | d= MORE ) -> ^( $d $rowExp $rngExp) )
            int alt45=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt45=1;
                }
                break;
            case CURRENT:
                {
                alt45=2;
                }
                break;
            case Identifier:
            case LPAREN:
            case StringLiteral:
            case Number:
            case IF:
            case ARRAY:
            case MAP:
            case STRUCT:
            case UNION:
            case CAST:
            case CASE:
            case BigintLiteral:
            case SmallintLiteral:
            case TinyintLiteral:
            case CharSetName:
            case NOT:
            case PLUS:
            case MINUS:
            case NULL:
            case TILDE:
            case TRUE:
            case FALSE:
                {
                alt45=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("238:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | rowExp= expression rngExp= Number (d= LESS | d= MORE ) -> ^( $d $rowExp $rngExp) );", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // Windowing2.g:239:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED101=(Token)input.LT(1);
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary1511); if (failed) return retval;
                    if ( backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED101);

                    // Windowing2.g:239:13: (r= PRECEDING | r= FOLLOWING )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==PRECEDING) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==FOLLOWING) ) {
                        alt43=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("239:13: (r= PRECEDING | r= FOLLOWING )", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // Windowing2.g:239:14: r= PRECEDING
                            {
                            r=(Token)input.LT(1);
                            match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary1516); if (failed) return retval;
                            if ( backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // Windowing2.g:239:26: r= FOLLOWING
                            {
                            r=(Token)input.LT(1);
                            match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary1520); if (failed) return retval;
                            if ( backtracking==0 ) stream_FOLLOWING.add(r);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: r, UNBOUNDED
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 239:40: -> ^( $r UNBOUNDED )
                    {
                        // Windowing2.g:239:43: ^( $r UNBOUNDED )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_r.next(), root_1);

                        adaptor.addChild(root_1, stream_UNBOUNDED.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 2 :
                    // Windowing2.g:240:3: CURRENT ROW
                    {
                    CURRENT102=(Token)input.LT(1);
                    match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary1538); if (failed) return retval;
                    if ( backtracking==0 ) stream_CURRENT.add(CURRENT102);

                    ROW103=(Token)input.LT(1);
                    match(input,ROW,FOLLOW_ROW_in_valuesboundary1540); if (failed) return retval;
                    if ( backtracking==0 ) stream_ROW.add(ROW103);


                    // AST REWRITE
                    // elements: CURRENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 240:16: -> ^( CURRENT )
                    {
                        // Windowing2.g:240:19: ^( CURRENT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CURRENT.next(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;
                case 3 :
                    // Windowing2.g:241:3: rowExp= expression rngExp= Number (d= LESS | d= MORE )
                    {
                    pushFollow(FOLLOW_expression_in_valuesboundary1555);
                    rowExp=expression();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_expression.add(rowExp.getTree());
                    rngExp=(Token)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_valuesboundary1559); if (failed) return retval;
                    if ( backtracking==0 ) stream_Number.add(rngExp);

                    // Windowing2.g:241:35: (d= LESS | d= MORE )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==LESS) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==MORE) ) {
                        alt44=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("241:35: (d= LESS | d= MORE )", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // Windowing2.g:241:36: d= LESS
                            {
                            d=(Token)input.LT(1);
                            match(input,LESS,FOLLOW_LESS_in_valuesboundary1564); if (failed) return retval;
                            if ( backtracking==0 ) stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // Windowing2.g:241:45: d= MORE
                            {
                            d=(Token)input.LT(1);
                            match(input,MORE,FOLLOW_MORE_in_valuesboundary1570); if (failed) return retval;
                            if ( backtracking==0 ) stream_MORE.add(d);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: rngExp, rowExp, d
                    // token labels: d, rngExp
                    // rule labels: retval, rowExp
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
                    RewriteRuleTokenStream stream_rngExp=new RewriteRuleTokenStream(adaptor,"token rngExp",rngExp);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_rowExp=new RewriteRuleSubtreeStream(adaptor,"token rowExp",rowExp!=null?rowExp.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 241:54: -> ^( $d $rowExp $rngExp)
                    {
                        // Windowing2.g:241:57: ^( $d $rowExp $rngExp)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_d.next(), root_1);

                        adaptor.addChild(root_1, stream_rowExp.next());
                        adaptor.addChild(root_1, stream_rngExp.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end valuesboundary

    public static class columnReference_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start columnReference
    // Windowing2.g:244:1: columnReference : i1= Identifier ( DOT i2= Identifier )? -> {$i2 != null}? ^( COLUMNREF $i1 $i2) -> ^( COLUMNREF $i1) ;
    public final columnReference_return columnReference() throws RecognitionException {
        columnReference_return retval = new columnReference_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i1=null;
        Token i2=null;
        Token DOT104=null;

        Object i1_tree=null;
        Object i2_tree=null;
        Object DOT104_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try {
            // Windowing2.g:244:17: (i1= Identifier ( DOT i2= Identifier )? -> {$i2 != null}? ^( COLUMNREF $i1 $i2) -> ^( COLUMNREF $i1) )
            // Windowing2.g:245:3: i1= Identifier ( DOT i2= Identifier )?
            {
            i1=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_columnReference1598); if (failed) return retval;
            if ( backtracking==0 ) stream_Identifier.add(i1);

            // Windowing2.g:245:17: ( DOT i2= Identifier )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==DOT) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // Windowing2.g:245:18: DOT i2= Identifier
                    {
                    DOT104=(Token)input.LT(1);
                    match(input,DOT,FOLLOW_DOT_in_columnReference1601); if (failed) return retval;
                    if ( backtracking==0 ) stream_DOT.add(DOT104);

                    i2=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_columnReference1605); if (failed) return retval;
                    if ( backtracking==0 ) stream_Identifier.add(i2);


                    }
                    break;

            }


            // AST REWRITE
            // elements: i2, i1, i1
            // token labels: i2, i1
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_i2=new RewriteRuleTokenStream(adaptor,"token i2",i2);
            RewriteRuleTokenStream stream_i1=new RewriteRuleTokenStream(adaptor,"token i1",i1);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 246:3: -> {$i2 != null}? ^( COLUMNREF $i1 $i2)
            if (i2 != null) {
                // Windowing2.g:246:21: ^( COLUMNREF $i1 $i2)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(COLUMNREF, "COLUMNREF"), root_1);

                adaptor.addChild(root_1, stream_i1.next());
                adaptor.addChild(root_1, stream_i2.next());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 247:3: -> ^( COLUMNREF $i1)
            {
                // Windowing2.g:247:21: ^( COLUMNREF $i1)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(COLUMNREF, "COLUMNREF"), root_1);

                adaptor.addChild(root_1, stream_i1.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end columnReference

    public static class tableOrColumn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start tableOrColumn
    // Windowing2.g:250:1: tableOrColumn : Identifier -> ^( TABLEORCOL Identifier ) ;
    public final tableOrColumn_return tableOrColumn() throws RecognitionException {
        tableOrColumn_return retval = new tableOrColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier105=null;

        Object Identifier105_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try {
            // Windowing2.g:251:2: ( Identifier -> ^( TABLEORCOL Identifier ) )
            // Windowing2.g:252:3: Identifier
            {
            Identifier105=(Token)input.LT(1);
            match(input,Identifier,FOLLOW_Identifier_in_tableOrColumn1665); if (failed) return retval;
            if ( backtracking==0 ) stream_Identifier.add(Identifier105);


            // AST REWRITE
            // elements: Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 252:14: -> ^( TABLEORCOL Identifier )
            {
                // Windowing2.g:252:17: ^( TABLEORCOL Identifier )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(TABLEORCOL, "TABLEORCOL"), root_1);

                adaptor.addChild(root_1, stream_Identifier.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end tableOrColumn

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start function
    // Windowing2.g:255:1: function : functionName LPAREN ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? ) RPAREN -> {$star != null}? ^( FUNCTIONSTAR functionName ) -> {$dist == null}? ^( FUNCTION functionName ( ( expression )+ )? ) -> ^( FUNCTIONDIST functionName ( ( expression )+ )? ) ;
    public final function_return function() throws RecognitionException {
        function_return retval = new function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token star=null;
        Token dist=null;
        Token LPAREN107=null;
        Token COMMA109=null;
        Token RPAREN111=null;
        functionName_return functionName106 = null;

        expression_return expression108 = null;

        expression_return expression110 = null;


        Object star_tree=null;
        Object dist_tree=null;
        Object LPAREN107_tree=null;
        Object COMMA109_tree=null;
        Object RPAREN111_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_DISTINCT=new RewriteRuleTokenStream(adaptor,"token DISTINCT");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_functionName=new RewriteRuleSubtreeStream(adaptor,"rule functionName");
        try {
            // Windowing2.g:256:2: ( functionName LPAREN ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? ) RPAREN -> {$star != null}? ^( FUNCTIONSTAR functionName ) -> {$dist == null}? ^( FUNCTION functionName ( ( expression )+ )? ) -> ^( FUNCTIONDIST functionName ( ( expression )+ )? ) )
            // Windowing2.g:257:3: functionName LPAREN ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? ) RPAREN
            {
            pushFollow(FOLLOW_functionName_in_function1690);
            functionName106=functionName();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_functionName.add(functionName106.getTree());
            LPAREN107=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_function1697); if (failed) return retval;
            if ( backtracking==0 ) stream_LPAREN.add(LPAREN107);

            // Windowing2.g:259:5: ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==STAR) ) {
                alt50=1;
            }
            else if ( (LA50_0==Identifier||(LA50_0>=LPAREN && LA50_0<=RPAREN)||LA50_0==StringLiteral||LA50_0==DISTINCT||LA50_0==Number||(LA50_0>=IF && LA50_0<=CASE)||(LA50_0>=BigintLiteral && LA50_0<=CharSetName)||LA50_0==NOT||(LA50_0>=PLUS && LA50_0<=MINUS)||LA50_0==NULL||LA50_0==TILDE||(LA50_0>=TRUE && LA50_0<=FALSE)) ) {
                alt50=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("259:5: ( (star= STAR ) | (dist= DISTINCT )? ( expression ( COMMA expression )* )? )", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // Windowing2.g:260:7: (star= STAR )
                    {
                    // Windowing2.g:260:7: (star= STAR )
                    // Windowing2.g:260:8: star= STAR
                    {
                    star=(Token)input.LT(1);
                    match(input,STAR,FOLLOW_STAR_in_function1715); if (failed) return retval;
                    if ( backtracking==0 ) stream_STAR.add(star);


                    }


                    }
                    break;
                case 2 :
                    // Windowing2.g:261:9: (dist= DISTINCT )? ( expression ( COMMA expression )* )?
                    {
                    // Windowing2.g:261:9: (dist= DISTINCT )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==DISTINCT) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // Windowing2.g:261:10: dist= DISTINCT
                            {
                            dist=(Token)input.LT(1);
                            match(input,DISTINCT,FOLLOW_DISTINCT_in_function1729); if (failed) return retval;
                            if ( backtracking==0 ) stream_DISTINCT.add(dist);


                            }
                            break;

                    }

                    // Windowing2.g:261:26: ( expression ( COMMA expression )* )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==Identifier||LA49_0==LPAREN||LA49_0==StringLiteral||LA49_0==Number||(LA49_0>=IF && LA49_0<=CASE)||(LA49_0>=BigintLiteral && LA49_0<=CharSetName)||LA49_0==NOT||(LA49_0>=PLUS && LA49_0<=MINUS)||LA49_0==NULL||LA49_0==TILDE||(LA49_0>=TRUE && LA49_0<=FALSE)) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // Windowing2.g:261:27: expression ( COMMA expression )*
                            {
                            pushFollow(FOLLOW_expression_in_function1734);
                            expression108=expression();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) stream_expression.add(expression108.getTree());
                            // Windowing2.g:261:38: ( COMMA expression )*
                            loop48:
                            do {
                                int alt48=2;
                                int LA48_0 = input.LA(1);

                                if ( (LA48_0==COMMA) ) {
                                    alt48=1;
                                }


                                switch (alt48) {
                            	case 1 :
                            	    // Windowing2.g:261:39: COMMA expression
                            	    {
                            	    COMMA109=(Token)input.LT(1);
                            	    match(input,COMMA,FOLLOW_COMMA_in_function1737); if (failed) return retval;
                            	    if ( backtracking==0 ) stream_COMMA.add(COMMA109);

                            	    pushFollow(FOLLOW_expression_in_function1739);
                            	    expression110=expression();
                            	    _fsp--;
                            	    if (failed) return retval;
                            	    if ( backtracking==0 ) stream_expression.add(expression110.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop48;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            RPAREN111=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_function1755); if (failed) return retval;
            if ( backtracking==0 ) stream_RPAREN.add(RPAREN111);


            // AST REWRITE
            // elements: expression, functionName, expression, functionName, functionName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 263:12: -> {$star != null}? ^( FUNCTIONSTAR functionName )
            if (star != null) {
                // Windowing2.g:263:32: ^( FUNCTIONSTAR functionName )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTIONSTAR, "FUNCTIONSTAR"), root_1);

                adaptor.addChild(root_1, stream_functionName.next());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 264:19: -> {$dist == null}? ^( FUNCTION functionName ( ( expression )+ )? )
            if (dist == null) {
                // Windowing2.g:264:39: ^( FUNCTION functionName ( ( expression )+ )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_functionName.next());
                // Windowing2.g:264:63: ( ( expression )+ )?
                if ( stream_expression.hasNext() ) {
                    if ( !(stream_expression.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_expression.hasNext() ) {
                        adaptor.addChild(root_1, stream_expression.next());

                    }
                    stream_expression.reset();

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 265:19: -> ^( FUNCTIONDIST functionName ( ( expression )+ )? )
            {
                // Windowing2.g:265:48: ^( FUNCTIONDIST functionName ( ( expression )+ )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTIONDIST, "FUNCTIONDIST"), root_1);

                adaptor.addChild(root_1, stream_functionName.next());
                // Windowing2.g:265:76: ( ( expression )+ )?
                if ( stream_expression.hasNext() ) {
                    if ( !(stream_expression.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_expression.hasNext() ) {
                        adaptor.addChild(root_1, stream_expression.next());

                    }
                    stream_expression.reset();

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end function

    public static class functionName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start functionName
    // Windowing2.g:268:1: functionName : ( Identifier | IF | ARRAY | MAP | STRUCT | UNION );
    public final functionName_return functionName() throws RecognitionException {
        functionName_return retval = new functionName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set112=null;

        Object set112_tree=null;

        try {
            // Windowing2.g:269:2: ( Identifier | IF | ARRAY | MAP | STRUCT | UNION )
            // Windowing2.g:
            {
            root_0 = (Object)adaptor.nil();

            set112=(Token)input.LT(1);
            if ( input.LA(1)==Identifier||(input.LA(1)>=IF && input.LA(1)<=UNION) ) {
                input.consume();
                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set112));
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_functionName0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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

    public static class castExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start castExpr
    // Windowing2.g:273:1: castExpr : CAST LPAREN expression AS primitiveType RPAREN -> ^( FUNCTION primitiveType expression ) ;
    public final castExpr_return castExpr() throws RecognitionException {
        castExpr_return retval = new castExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CAST113=null;
        Token LPAREN114=null;
        Token AS116=null;
        Token RPAREN118=null;
        expression_return expression115 = null;

        primitiveType_return primitiveType117 = null;


        Object CAST113_tree=null;
        Object LPAREN114_tree=null;
        Object AS116_tree=null;
        Object RPAREN118_tree=null;
        RewriteRuleTokenStream stream_CAST=new RewriteRuleTokenStream(adaptor,"token CAST");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_primitiveType=new RewriteRuleSubtreeStream(adaptor,"rule primitiveType");
        try {
            // Windowing2.g:273:10: ( CAST LPAREN expression AS primitiveType RPAREN -> ^( FUNCTION primitiveType expression ) )
            // Windowing2.g:274:3: CAST LPAREN expression AS primitiveType RPAREN
            {
            CAST113=(Token)input.LT(1);
            match(input,CAST,FOLLOW_CAST_in_castExpr1926); if (failed) return retval;
            if ( backtracking==0 ) stream_CAST.add(CAST113);

            LPAREN114=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_castExpr1928); if (failed) return retval;
            if ( backtracking==0 ) stream_LPAREN.add(LPAREN114);

            pushFollow(FOLLOW_expression_in_castExpr1930);
            expression115=expression();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_expression.add(expression115.getTree());
            AS116=(Token)input.LT(1);
            match(input,AS,FOLLOW_AS_in_castExpr1932); if (failed) return retval;
            if ( backtracking==0 ) stream_AS.add(AS116);

            pushFollow(FOLLOW_primitiveType_in_castExpr1934);
            primitiveType117=primitiveType();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_primitiveType.add(primitiveType117.getTree());
            RPAREN118=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_castExpr1936); if (failed) return retval;
            if ( backtracking==0 ) stream_RPAREN.add(RPAREN118);


            // AST REWRITE
            // elements: expression, primitiveType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 274:50: -> ^( FUNCTION primitiveType expression )
            {
                // Windowing2.g:274:53: ^( FUNCTION primitiveType expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_primitiveType.next());
                adaptor.addChild(root_1, stream_expression.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end castExpr

    public static class caseExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start caseExpr
    // Windowing2.g:277:1: caseExpr : CASE expression ( WHEN expression THEN expression )+ ( ELSE expression )? END -> ^( FUNCTION CASE ( expression )* ) ;
    public final caseExpr_return caseExpr() throws RecognitionException {
        caseExpr_return retval = new caseExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CASE119=null;
        Token WHEN121=null;
        Token THEN123=null;
        Token ELSE125=null;
        Token END127=null;
        expression_return expression120 = null;

        expression_return expression122 = null;

        expression_return expression124 = null;

        expression_return expression126 = null;


        Object CASE119_tree=null;
        Object WHEN121_tree=null;
        Object THEN123_tree=null;
        Object ELSE125_tree=null;
        Object END127_tree=null;
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_WHEN=new RewriteRuleTokenStream(adaptor,"token WHEN");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Windowing2.g:277:10: ( CASE expression ( WHEN expression THEN expression )+ ( ELSE expression )? END -> ^( FUNCTION CASE ( expression )* ) )
            // Windowing2.g:278:3: CASE expression ( WHEN expression THEN expression )+ ( ELSE expression )? END
            {
            CASE119=(Token)input.LT(1);
            match(input,CASE,FOLLOW_CASE_in_caseExpr1957); if (failed) return retval;
            if ( backtracking==0 ) stream_CASE.add(CASE119);

            pushFollow(FOLLOW_expression_in_caseExpr1959);
            expression120=expression();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_expression.add(expression120.getTree());
            // Windowing2.g:279:3: ( WHEN expression THEN expression )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==WHEN) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // Windowing2.g:279:4: WHEN expression THEN expression
            	    {
            	    WHEN121=(Token)input.LT(1);
            	    match(input,WHEN,FOLLOW_WHEN_in_caseExpr1964); if (failed) return retval;
            	    if ( backtracking==0 ) stream_WHEN.add(WHEN121);

            	    pushFollow(FOLLOW_expression_in_caseExpr1966);
            	    expression122=expression();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_expression.add(expression122.getTree());
            	    THEN123=(Token)input.LT(1);
            	    match(input,THEN,FOLLOW_THEN_in_caseExpr1968); if (failed) return retval;
            	    if ( backtracking==0 ) stream_THEN.add(THEN123);

            	    pushFollow(FOLLOW_expression_in_caseExpr1970);
            	    expression124=expression();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_expression.add(expression124.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (backtracking>0) {failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);

            // Windowing2.g:280:3: ( ELSE expression )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==ELSE) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // Windowing2.g:280:4: ELSE expression
                    {
                    ELSE125=(Token)input.LT(1);
                    match(input,ELSE,FOLLOW_ELSE_in_caseExpr1977); if (failed) return retval;
                    if ( backtracking==0 ) stream_ELSE.add(ELSE125);

                    pushFollow(FOLLOW_expression_in_caseExpr1979);
                    expression126=expression();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_expression.add(expression126.getTree());

                    }
                    break;

            }

            END127=(Token)input.LT(1);
            match(input,END,FOLLOW_END_in_caseExpr1985); if (failed) return retval;
            if ( backtracking==0 ) stream_END.add(END127);


            // AST REWRITE
            // elements: expression, CASE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 281:7: -> ^( FUNCTION CASE ( expression )* )
            {
                // Windowing2.g:281:10: ^( FUNCTION CASE ( expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_CASE.next());
                // Windowing2.g:281:26: ( expression )*
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.next());

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end caseExpr

    public static class whenExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start whenExpr
    // Windowing2.g:284:1: whenExpr : CASE ( WHEN expression THEN expression )+ ( ELSE expression )? END -> ^( FUNCTION WHEN ( expression )* ) ;
    public final whenExpr_return whenExpr() throws RecognitionException {
        whenExpr_return retval = new whenExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CASE128=null;
        Token WHEN129=null;
        Token THEN131=null;
        Token ELSE133=null;
        Token END135=null;
        expression_return expression130 = null;

        expression_return expression132 = null;

        expression_return expression134 = null;


        Object CASE128_tree=null;
        Object WHEN129_tree=null;
        Object THEN131_tree=null;
        Object ELSE133_tree=null;
        Object END135_tree=null;
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_WHEN=new RewriteRuleTokenStream(adaptor,"token WHEN");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Windowing2.g:284:11: ( CASE ( WHEN expression THEN expression )+ ( ELSE expression )? END -> ^( FUNCTION WHEN ( expression )* ) )
            // Windowing2.g:285:3: CASE ( WHEN expression THEN expression )+ ( ELSE expression )? END
            {
            CASE128=(Token)input.LT(1);
            match(input,CASE,FOLLOW_CASE_in_whenExpr2009); if (failed) return retval;
            if ( backtracking==0 ) stream_CASE.add(CASE128);

            // Windowing2.g:286:3: ( WHEN expression THEN expression )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==WHEN) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // Windowing2.g:286:4: WHEN expression THEN expression
            	    {
            	    WHEN129=(Token)input.LT(1);
            	    match(input,WHEN,FOLLOW_WHEN_in_whenExpr2015); if (failed) return retval;
            	    if ( backtracking==0 ) stream_WHEN.add(WHEN129);

            	    pushFollow(FOLLOW_expression_in_whenExpr2017);
            	    expression130=expression();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_expression.add(expression130.getTree());
            	    THEN131=(Token)input.LT(1);
            	    match(input,THEN,FOLLOW_THEN_in_whenExpr2019); if (failed) return retval;
            	    if ( backtracking==0 ) stream_THEN.add(THEN131);

            	    pushFollow(FOLLOW_expression_in_whenExpr2021);
            	    expression132=expression();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_expression.add(expression132.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
            	    if (backtracking>0) {failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            // Windowing2.g:287:3: ( ELSE expression )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==ELSE) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // Windowing2.g:287:4: ELSE expression
                    {
                    ELSE133=(Token)input.LT(1);
                    match(input,ELSE,FOLLOW_ELSE_in_whenExpr2028); if (failed) return retval;
                    if ( backtracking==0 ) stream_ELSE.add(ELSE133);

                    pushFollow(FOLLOW_expression_in_whenExpr2030);
                    expression134=expression();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_expression.add(expression134.getTree());

                    }
                    break;

            }

            END135=(Token)input.LT(1);
            match(input,END,FOLLOW_END_in_whenExpr2036); if (failed) return retval;
            if ( backtracking==0 ) stream_END.add(END135);


            // AST REWRITE
            // elements: expression, WHEN
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 288:7: -> ^( FUNCTION WHEN ( expression )* )
            {
                // Windowing2.g:288:10: ^( FUNCTION WHEN ( expression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_WHEN.next());
                // Windowing2.g:288:26: ( expression )*
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.next());

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end whenExpr

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start constant
    // Windowing2.g:291:1: constant : ( Number | StringLiteral | stringLiteralSequence | BigintLiteral | SmallintLiteral | TinyintLiteral | charSetStringLiteral | booleanValue );
    public final constant_return constant() throws RecognitionException {
        constant_return retval = new constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Number136=null;
        Token StringLiteral137=null;
        Token BigintLiteral139=null;
        Token SmallintLiteral140=null;
        Token TinyintLiteral141=null;
        stringLiteralSequence_return stringLiteralSequence138 = null;

        charSetStringLiteral_return charSetStringLiteral142 = null;

        booleanValue_return booleanValue143 = null;


        Object Number136_tree=null;
        Object StringLiteral137_tree=null;
        Object BigintLiteral139_tree=null;
        Object SmallintLiteral140_tree=null;
        Object TinyintLiteral141_tree=null;

        try {
            // Windowing2.g:291:10: ( Number | StringLiteral | stringLiteralSequence | BigintLiteral | SmallintLiteral | TinyintLiteral | charSetStringLiteral | booleanValue )
            int alt55=8;
            switch ( input.LA(1) ) {
            case Number:
                {
                alt55=1;
                }
                break;
            case StringLiteral:
                {
                int LA55_2 = input.LA(2);

                if ( (LA55_2==EOF||LA55_2==FROM||(LA55_2>=COMMA && LA55_2<=AS)||LA55_2==DOT||LA55_2==RPAREN||(LA55_2>=WHERE && LA55_2<=INTO)||LA55_2==EQUAL||LA55_2==STAR||LA55_2==WINDOW||(LA55_2>=BETWEEN && LA55_2<=AND)||LA55_2==Number||(LA55_2>=WHEN && LA55_2<=END)||(LA55_2>=OR && LA55_2<=BITWISEXOR)||LA55_2==IS||(LA55_2>=LSQUARE && LA55_2<=RSQUARE)) ) {
                    alt55=2;
                }
                else if ( (LA55_2==StringLiteral) ) {
                    alt55=3;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("291:1: constant : ( Number | StringLiteral | stringLiteralSequence | BigintLiteral | SmallintLiteral | TinyintLiteral | charSetStringLiteral | booleanValue );", 55, 2, input);

                    throw nvae;
                }
                }
                break;
            case BigintLiteral:
                {
                alt55=4;
                }
                break;
            case SmallintLiteral:
                {
                alt55=5;
                }
                break;
            case TinyintLiteral:
                {
                alt55=6;
                }
                break;
            case CharSetName:
                {
                alt55=7;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt55=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("291:1: constant : ( Number | StringLiteral | stringLiteralSequence | BigintLiteral | SmallintLiteral | TinyintLiteral | charSetStringLiteral | booleanValue );", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // Windowing2.g:292:3: Number
                    {
                    root_0 = (Object)adaptor.nil();

                    Number136=(Token)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_constant2058); if (failed) return retval;
                    if ( backtracking==0 ) {
                    Number136_tree = (Object)adaptor.create(Number136);
                    adaptor.addChild(root_0, Number136_tree);
                    }

                    }
                    break;
                case 2 :
                    // Windowing2.g:293:5: StringLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    StringLiteral137=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_constant2064); if (failed) return retval;
                    if ( backtracking==0 ) {
                    StringLiteral137_tree = (Object)adaptor.create(StringLiteral137);
                    adaptor.addChild(root_0, StringLiteral137_tree);
                    }

                    }
                    break;
                case 3 :
                    // Windowing2.g:294:5: stringLiteralSequence
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_stringLiteralSequence_in_constant2070);
                    stringLiteralSequence138=stringLiteralSequence();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, stringLiteralSequence138.getTree());

                    }
                    break;
                case 4 :
                    // Windowing2.g:295:5: BigintLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    BigintLiteral139=(Token)input.LT(1);
                    match(input,BigintLiteral,FOLLOW_BigintLiteral_in_constant2076); if (failed) return retval;
                    if ( backtracking==0 ) {
                    BigintLiteral139_tree = (Object)adaptor.create(BigintLiteral139);
                    adaptor.addChild(root_0, BigintLiteral139_tree);
                    }

                    }
                    break;
                case 5 :
                    // Windowing2.g:296:5: SmallintLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    SmallintLiteral140=(Token)input.LT(1);
                    match(input,SmallintLiteral,FOLLOW_SmallintLiteral_in_constant2082); if (failed) return retval;
                    if ( backtracking==0 ) {
                    SmallintLiteral140_tree = (Object)adaptor.create(SmallintLiteral140);
                    adaptor.addChild(root_0, SmallintLiteral140_tree);
                    }

                    }
                    break;
                case 6 :
                    // Windowing2.g:297:5: TinyintLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    TinyintLiteral141=(Token)input.LT(1);
                    match(input,TinyintLiteral,FOLLOW_TinyintLiteral_in_constant2088); if (failed) return retval;
                    if ( backtracking==0 ) {
                    TinyintLiteral141_tree = (Object)adaptor.create(TinyintLiteral141);
                    adaptor.addChild(root_0, TinyintLiteral141_tree);
                    }

                    }
                    break;
                case 7 :
                    // Windowing2.g:298:5: charSetStringLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_charSetStringLiteral_in_constant2094);
                    charSetStringLiteral142=charSetStringLiteral();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, charSetStringLiteral142.getTree());

                    }
                    break;
                case 8 :
                    // Windowing2.g:299:5: booleanValue
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_booleanValue_in_constant2100);
                    booleanValue143=booleanValue();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, booleanValue143.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end constant

    public static class stringLiteralSequence_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start stringLiteralSequence
    // Windowing2.g:302:1: stringLiteralSequence : StringLiteral ( StringLiteral )+ -> ^( STRINGLITERALSEQUENCE StringLiteral ( StringLiteral )+ ) ;
    public final stringLiteralSequence_return stringLiteralSequence() throws RecognitionException {
        stringLiteralSequence_return retval = new stringLiteralSequence_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token StringLiteral144=null;
        Token StringLiteral145=null;

        Object StringLiteral144_tree=null;
        Object StringLiteral145_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");

        try {
            // Windowing2.g:302:23: ( StringLiteral ( StringLiteral )+ -> ^( STRINGLITERALSEQUENCE StringLiteral ( StringLiteral )+ ) )
            // Windowing2.g:303:5: StringLiteral ( StringLiteral )+
            {
            StringLiteral144=(Token)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_stringLiteralSequence2113); if (failed) return retval;
            if ( backtracking==0 ) stream_StringLiteral.add(StringLiteral144);

            // Windowing2.g:303:19: ( StringLiteral )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==StringLiteral) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // Windowing2.g:303:19: StringLiteral
            	    {
            	    StringLiteral145=(Token)input.LT(1);
            	    match(input,StringLiteral,FOLLOW_StringLiteral_in_stringLiteralSequence2115); if (failed) return retval;
            	    if ( backtracking==0 ) stream_StringLiteral.add(StringLiteral145);


            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
            	    if (backtracking>0) {failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);


            // AST REWRITE
            // elements: StringLiteral, StringLiteral
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 303:34: -> ^( STRINGLITERALSEQUENCE StringLiteral ( StringLiteral )+ )
            {
                // Windowing2.g:303:37: ^( STRINGLITERALSEQUENCE StringLiteral ( StringLiteral )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(STRINGLITERALSEQUENCE, "STRINGLITERALSEQUENCE"), root_1);

                adaptor.addChild(root_1, stream_StringLiteral.next());
                if ( !(stream_StringLiteral.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_StringLiteral.hasNext() ) {
                    adaptor.addChild(root_1, stream_StringLiteral.next());

                }
                stream_StringLiteral.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end stringLiteralSequence

    public static class charSetStringLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start charSetStringLiteral
    // Windowing2.g:306:1: charSetStringLiteral : csName= CharSetName csLiteral= CharSetLiteral -> ^( CHARSETLITERAL $csName $csLiteral) ;
    public final charSetStringLiteral_return charSetStringLiteral() throws RecognitionException {
        charSetStringLiteral_return retval = new charSetStringLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token csName=null;
        Token csLiteral=null;

        Object csName_tree=null;
        Object csLiteral_tree=null;
        RewriteRuleTokenStream stream_CharSetLiteral=new RewriteRuleTokenStream(adaptor,"token CharSetLiteral");
        RewriteRuleTokenStream stream_CharSetName=new RewriteRuleTokenStream(adaptor,"token CharSetName");

        try {
            // Windowing2.g:306:22: (csName= CharSetName csLiteral= CharSetLiteral -> ^( CHARSETLITERAL $csName $csLiteral) )
            // Windowing2.g:307:5: csName= CharSetName csLiteral= CharSetLiteral
            {
            csName=(Token)input.LT(1);
            match(input,CharSetName,FOLLOW_CharSetName_in_charSetStringLiteral2142); if (failed) return retval;
            if ( backtracking==0 ) stream_CharSetName.add(csName);

            csLiteral=(Token)input.LT(1);
            match(input,CharSetLiteral,FOLLOW_CharSetLiteral_in_charSetStringLiteral2146); if (failed) return retval;
            if ( backtracking==0 ) stream_CharSetLiteral.add(csLiteral);


            // AST REWRITE
            // elements: csName, csLiteral
            // token labels: csName, csLiteral
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_csName=new RewriteRuleTokenStream(adaptor,"token csName",csName);
            RewriteRuleTokenStream stream_csLiteral=new RewriteRuleTokenStream(adaptor,"token csLiteral",csLiteral);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 307:49: -> ^( CHARSETLITERAL $csName $csLiteral)
            {
                // Windowing2.g:307:52: ^( CHARSETLITERAL $csName $csLiteral)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(CHARSETLITERAL, "CHARSETLITERAL"), root_1);

                adaptor.addChild(root_1, stream_csName.next());
                adaptor.addChild(root_1, stream_csLiteral.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end charSetStringLiteral

    public static class expressions_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expressions
    // Windowing2.g:310:1: expressions : LPAREN expression ( COMMA expression )* RPAREN -> ( expression )* ;
    public final expressions_return expressions() throws RecognitionException {
        expressions_return retval = new expressions_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN146=null;
        Token COMMA148=null;
        Token RPAREN150=null;
        expression_return expression147 = null;

        expression_return expression149 = null;


        Object LPAREN146_tree=null;
        Object COMMA148_tree=null;
        Object RPAREN150_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // Windowing2.g:310:13: ( LPAREN expression ( COMMA expression )* RPAREN -> ( expression )* )
            // Windowing2.g:311:3: LPAREN expression ( COMMA expression )* RPAREN
            {
            LPAREN146=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_expressions2169); if (failed) return retval;
            if ( backtracking==0 ) stream_LPAREN.add(LPAREN146);

            pushFollow(FOLLOW_expression_in_expressions2171);
            expression147=expression();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_expression.add(expression147.getTree());
            // Windowing2.g:311:21: ( COMMA expression )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==COMMA) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // Windowing2.g:311:22: COMMA expression
            	    {
            	    COMMA148=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_expressions2174); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA148);

            	    pushFollow(FOLLOW_expression_in_expressions2176);
            	    expression149=expression();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_expression.add(expression149.getTree());

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            RPAREN150=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_expressions2180); if (failed) return retval;
            if ( backtracking==0 ) stream_RPAREN.add(RPAREN150);


            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 311:48: -> ( expression )*
            {
                // Windowing2.g:311:51: ( expression )*
                while ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_0, stream_expression.next());

                }
                stream_expression.reset();

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end expressions

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expression
    // Windowing2.g:314:1: expression : orExpr ;
    public final expression_return expression() throws RecognitionException {
        expression_return retval = new expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        orExpr_return orExpr151 = null;



        try {
            // Windowing2.g:314:12: ( orExpr )
            // Windowing2.g:315:3: orExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_orExpr_in_expression2196);
            orExpr151=orExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, orExpr151.getTree());

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end expression

    public static class orExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start orExpr
    // Windowing2.g:318:1: orExpr : andExpr ( OR andExpr )* ;
    public final orExpr_return orExpr() throws RecognitionException {
        orExpr_return retval = new orExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR153=null;
        andExpr_return andExpr152 = null;

        andExpr_return andExpr154 = null;


        Object OR153_tree=null;

        try {
            // Windowing2.g:318:8: ( andExpr ( OR andExpr )* )
            // Windowing2.g:319:3: andExpr ( OR andExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_orExpr2207);
            andExpr152=andExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, andExpr152.getTree());
            // Windowing2.g:319:11: ( OR andExpr )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==OR) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // Windowing2.g:319:12: OR andExpr
            	    {
            	    OR153=(Token)input.LT(1);
            	    match(input,OR,FOLLOW_OR_in_orExpr2210); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    OR153_tree = (Object)adaptor.create(OR153);
            	    root_0 = (Object)adaptor.becomeRoot(OR153_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_andExpr_in_orExpr2213);
            	    andExpr154=andExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, andExpr154.getTree());

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end orExpr

    public static class andExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start andExpr
    // Windowing2.g:322:1: andExpr : notExpr ( AND notExpr )* ;
    public final andExpr_return andExpr() throws RecognitionException {
        andExpr_return retval = new andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND156=null;
        notExpr_return notExpr155 = null;

        notExpr_return notExpr157 = null;


        Object AND156_tree=null;

        try {
            // Windowing2.g:322:9: ( notExpr ( AND notExpr )* )
            // Windowing2.g:323:3: notExpr ( AND notExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_notExpr_in_andExpr2226);
            notExpr155=notExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, notExpr155.getTree());
            // Windowing2.g:323:11: ( AND notExpr )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==AND) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // Windowing2.g:323:12: AND notExpr
            	    {
            	    AND156=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_andExpr2229); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    AND156_tree = (Object)adaptor.create(AND156);
            	    root_0 = (Object)adaptor.becomeRoot(AND156_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_notExpr_in_andExpr2232);
            	    notExpr157=notExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, notExpr157.getTree());

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end andExpr

    public static class notExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start notExpr
    // Windowing2.g:326:1: notExpr : ( NOT )* compareExpr ;
    public final notExpr_return notExpr() throws RecognitionException {
        notExpr_return retval = new notExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT158=null;
        compareExpr_return compareExpr159 = null;


        Object NOT158_tree=null;

        try {
            // Windowing2.g:326:9: ( ( NOT )* compareExpr )
            // Windowing2.g:327:3: ( NOT )* compareExpr
            {
            root_0 = (Object)adaptor.nil();

            // Windowing2.g:327:3: ( NOT )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==NOT) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // Windowing2.g:327:4: NOT
            	    {
            	    NOT158=(Token)input.LT(1);
            	    match(input,NOT,FOLLOW_NOT_in_notExpr2246); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    NOT158_tree = (Object)adaptor.create(NOT158);
            	    root_0 = (Object)adaptor.becomeRoot(NOT158_tree, root_0);
            	    }

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            pushFollow(FOLLOW_compareExpr_in_notExpr2251);
            compareExpr159=compareExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, compareExpr159.getTree());

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end notExpr

    public static class negatableOperator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start negatableOperator
    // Windowing2.g:330:1: negatableOperator : ( LIKE | RLIKE | REGEXP );
    public final negatableOperator_return negatableOperator() throws RecognitionException {
        negatableOperator_return retval = new negatableOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set160=null;

        Object set160_tree=null;

        try {
            // Windowing2.g:330:19: ( LIKE | RLIKE | REGEXP )
            // Windowing2.g:
            {
            root_0 = (Object)adaptor.nil();

            set160=(Token)input.LT(1);
            if ( (input.LA(1)>=LIKE && input.LA(1)<=REGEXP) ) {
                input.consume();
                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set160));
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_negatableOperator0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end negatableOperator

    public static class compareOperator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start compareOperator
    // Windowing2.g:334:1: compareOperator : ( negatableOperator | EQUAL | EQUAL_NS | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN );
    public final compareOperator_return compareOperator() throws RecognitionException {
        compareOperator_return retval = new compareOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQUAL162=null;
        Token EQUAL_NS163=null;
        Token NOTEQUAL164=null;
        Token LESSTHANOREQUALTO165=null;
        Token LESSTHAN166=null;
        Token GREATERTHANOREQUALTO167=null;
        Token GREATERTHAN168=null;
        negatableOperator_return negatableOperator161 = null;


        Object EQUAL162_tree=null;
        Object EQUAL_NS163_tree=null;
        Object NOTEQUAL164_tree=null;
        Object LESSTHANOREQUALTO165_tree=null;
        Object LESSTHAN166_tree=null;
        Object GREATERTHANOREQUALTO167_tree=null;
        Object GREATERTHAN168_tree=null;

        try {
            // Windowing2.g:334:17: ( negatableOperator | EQUAL | EQUAL_NS | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN )
            int alt61=8;
            switch ( input.LA(1) ) {
            case LIKE:
            case RLIKE:
            case REGEXP:
                {
                alt61=1;
                }
                break;
            case EQUAL:
                {
                alt61=2;
                }
                break;
            case EQUAL_NS:
                {
                alt61=3;
                }
                break;
            case NOTEQUAL:
                {
                alt61=4;
                }
                break;
            case LESSTHANOREQUALTO:
                {
                alt61=5;
                }
                break;
            case LESSTHAN:
                {
                alt61=6;
                }
                break;
            case GREATERTHANOREQUALTO:
                {
                alt61=7;
                }
                break;
            case GREATERTHAN:
                {
                alt61=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("334:1: compareOperator : ( negatableOperator | EQUAL | EQUAL_NS | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | GREATERTHANOREQUALTO | GREATERTHAN );", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // Windowing2.g:335:3: negatableOperator
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_negatableOperator_in_compareOperator2281);
                    negatableOperator161=negatableOperator();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, negatableOperator161.getTree());

                    }
                    break;
                case 2 :
                    // Windowing2.g:335:24: EQUAL
                    {
                    root_0 = (Object)adaptor.nil();

                    EQUAL162=(Token)input.LT(1);
                    match(input,EQUAL,FOLLOW_EQUAL_in_compareOperator2286); if (failed) return retval;
                    if ( backtracking==0 ) {
                    EQUAL162_tree = (Object)adaptor.create(EQUAL162);
                    adaptor.addChild(root_0, EQUAL162_tree);
                    }

                    }
                    break;
                case 3 :
                    // Windowing2.g:335:32: EQUAL_NS
                    {
                    root_0 = (Object)adaptor.nil();

                    EQUAL_NS163=(Token)input.LT(1);
                    match(input,EQUAL_NS,FOLLOW_EQUAL_NS_in_compareOperator2290); if (failed) return retval;
                    if ( backtracking==0 ) {
                    EQUAL_NS163_tree = (Object)adaptor.create(EQUAL_NS163);
                    adaptor.addChild(root_0, EQUAL_NS163_tree);
                    }

                    }
                    break;
                case 4 :
                    // Windowing2.g:335:43: NOTEQUAL
                    {
                    root_0 = (Object)adaptor.nil();

                    NOTEQUAL164=(Token)input.LT(1);
                    match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareOperator2294); if (failed) return retval;
                    if ( backtracking==0 ) {
                    NOTEQUAL164_tree = (Object)adaptor.create(NOTEQUAL164);
                    adaptor.addChild(root_0, NOTEQUAL164_tree);
                    }

                    }
                    break;
                case 5 :
                    // Windowing2.g:335:54: LESSTHANOREQUALTO
                    {
                    root_0 = (Object)adaptor.nil();

                    LESSTHANOREQUALTO165=(Token)input.LT(1);
                    match(input,LESSTHANOREQUALTO,FOLLOW_LESSTHANOREQUALTO_in_compareOperator2298); if (failed) return retval;
                    if ( backtracking==0 ) {
                    LESSTHANOREQUALTO165_tree = (Object)adaptor.create(LESSTHANOREQUALTO165);
                    adaptor.addChild(root_0, LESSTHANOREQUALTO165_tree);
                    }

                    }
                    break;
                case 6 :
                    // Windowing2.g:335:74: LESSTHAN
                    {
                    root_0 = (Object)adaptor.nil();

                    LESSTHAN166=(Token)input.LT(1);
                    match(input,LESSTHAN,FOLLOW_LESSTHAN_in_compareOperator2302); if (failed) return retval;
                    if ( backtracking==0 ) {
                    LESSTHAN166_tree = (Object)adaptor.create(LESSTHAN166);
                    adaptor.addChild(root_0, LESSTHAN166_tree);
                    }

                    }
                    break;
                case 7 :
                    // Windowing2.g:336:3: GREATERTHANOREQUALTO
                    {
                    root_0 = (Object)adaptor.nil();

                    GREATERTHANOREQUALTO167=(Token)input.LT(1);
                    match(input,GREATERTHANOREQUALTO,FOLLOW_GREATERTHANOREQUALTO_in_compareOperator2309); if (failed) return retval;
                    if ( backtracking==0 ) {
                    GREATERTHANOREQUALTO167_tree = (Object)adaptor.create(GREATERTHANOREQUALTO167);
                    adaptor.addChild(root_0, GREATERTHANOREQUALTO167_tree);
                    }

                    }
                    break;
                case 8 :
                    // Windowing2.g:336:26: GREATERTHAN
                    {
                    root_0 = (Object)adaptor.nil();

                    GREATERTHAN168=(Token)input.LT(1);
                    match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_compareOperator2313); if (failed) return retval;
                    if ( backtracking==0 ) {
                    GREATERTHAN168_tree = (Object)adaptor.create(GREATERTHAN168);
                    adaptor.addChild(root_0, GREATERTHAN168_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end compareOperator

    public static class compareExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start compareExpr
    // Windowing2.g:339:1: compareExpr : (l= bitOrExpr -> $l) ( ( NOT nO= negatableOperator r= bitOrExpr -> ^( $nO FALSE $compareExpr $r) ) | (cO= compareOperator r= bitOrExpr -> ^( $cO TRUE $compareExpr $r) ) | ( NOT IN el= expressions -> ^( FUNCTION IN FALSE $compareExpr $el) ) | ( IN expressions -> ^( FUNCTION IN TRUE $compareExpr $el) ) | ( NOT BETWEEN min= bitOrExpr AND max= bitOrExpr -> ^( FUNCTION BETWEEN FALSE $compareExpr $min $max) ) | ( BETWEEN bitOrExpr AND bitOrExpr -> ^( FUNCTION BETWEEN TRUE $compareExpr $min $max) ) )* ;
    public final compareExpr_return compareExpr() throws RecognitionException {
        compareExpr_return retval = new compareExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NOT169=null;
        Token NOT170=null;
        Token IN171=null;
        Token IN172=null;
        Token NOT174=null;
        Token BETWEEN175=null;
        Token AND176=null;
        Token BETWEEN177=null;
        Token AND179=null;
        bitOrExpr_return l = null;

        negatableOperator_return nO = null;

        bitOrExpr_return r = null;

        compareOperator_return cO = null;

        expressions_return el = null;

        bitOrExpr_return min = null;

        bitOrExpr_return max = null;

        expressions_return expressions173 = null;

        bitOrExpr_return bitOrExpr178 = null;

        bitOrExpr_return bitOrExpr180 = null;


        Object NOT169_tree=null;
        Object NOT170_tree=null;
        Object IN171_tree=null;
        Object IN172_tree=null;
        Object NOT174_tree=null;
        Object BETWEEN175_tree=null;
        Object AND176_tree=null;
        Object BETWEEN177_tree=null;
        Object AND179_tree=null;
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_negatableOperator=new RewriteRuleSubtreeStream(adaptor,"rule negatableOperator");
        RewriteRuleSubtreeStream stream_bitOrExpr=new RewriteRuleSubtreeStream(adaptor,"rule bitOrExpr");
        RewriteRuleSubtreeStream stream_compareOperator=new RewriteRuleSubtreeStream(adaptor,"rule compareOperator");
        RewriteRuleSubtreeStream stream_expressions=new RewriteRuleSubtreeStream(adaptor,"rule expressions");
        try {
            // Windowing2.g:339:13: ( (l= bitOrExpr -> $l) ( ( NOT nO= negatableOperator r= bitOrExpr -> ^( $nO FALSE $compareExpr $r) ) | (cO= compareOperator r= bitOrExpr -> ^( $cO TRUE $compareExpr $r) ) | ( NOT IN el= expressions -> ^( FUNCTION IN FALSE $compareExpr $el) ) | ( IN expressions -> ^( FUNCTION IN TRUE $compareExpr $el) ) | ( NOT BETWEEN min= bitOrExpr AND max= bitOrExpr -> ^( FUNCTION BETWEEN FALSE $compareExpr $min $max) ) | ( BETWEEN bitOrExpr AND bitOrExpr -> ^( FUNCTION BETWEEN TRUE $compareExpr $min $max) ) )* )
            // Windowing2.g:340:3: (l= bitOrExpr -> $l) ( ( NOT nO= negatableOperator r= bitOrExpr -> ^( $nO FALSE $compareExpr $r) ) | (cO= compareOperator r= bitOrExpr -> ^( $cO TRUE $compareExpr $r) ) | ( NOT IN el= expressions -> ^( FUNCTION IN FALSE $compareExpr $el) ) | ( IN expressions -> ^( FUNCTION IN TRUE $compareExpr $el) ) | ( NOT BETWEEN min= bitOrExpr AND max= bitOrExpr -> ^( FUNCTION BETWEEN FALSE $compareExpr $min $max) ) | ( BETWEEN bitOrExpr AND bitOrExpr -> ^( FUNCTION BETWEEN TRUE $compareExpr $min $max) ) )*
            {
            // Windowing2.g:340:3: (l= bitOrExpr -> $l)
            // Windowing2.g:340:4: l= bitOrExpr
            {
            pushFollow(FOLLOW_bitOrExpr_in_compareExpr2327);
            l=bitOrExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_bitOrExpr.add(l.getTree());

            // AST REWRITE
            // elements: l
            // token labels: 
            // rule labels: retval, l
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_l=new RewriteRuleSubtreeStream(adaptor,"token l",l!=null?l.tree:null);

            root_0 = (Object)adaptor.nil();
            // 340:16: -> $l
            {
                adaptor.addChild(root_0, stream_l.next());

            }

            }

            }

            // Windowing2.g:341:3: ( ( NOT nO= negatableOperator r= bitOrExpr -> ^( $nO FALSE $compareExpr $r) ) | (cO= compareOperator r= bitOrExpr -> ^( $cO TRUE $compareExpr $r) ) | ( NOT IN el= expressions -> ^( FUNCTION IN FALSE $compareExpr $el) ) | ( IN expressions -> ^( FUNCTION IN TRUE $compareExpr $el) ) | ( NOT BETWEEN min= bitOrExpr AND max= bitOrExpr -> ^( FUNCTION BETWEEN FALSE $compareExpr $min $max) ) | ( BETWEEN bitOrExpr AND bitOrExpr -> ^( FUNCTION BETWEEN TRUE $compareExpr $min $max) ) )*
            loop62:
            do {
                int alt62=7;
                switch ( input.LA(1) ) {
                case NOT:
                    {
                    switch ( input.LA(2) ) {
                    case BETWEEN:
                        {
                        alt62=5;
                        }
                        break;
                    case IN:
                        {
                        alt62=3;
                        }
                        break;
                    case LIKE:
                    case RLIKE:
                    case REGEXP:
                        {
                        alt62=1;
                        }
                        break;

                    }

                    }
                    break;
                case EQUAL:
                case LIKE:
                case RLIKE:
                case REGEXP:
                case EQUAL_NS:
                case NOTEQUAL:
                case LESSTHANOREQUALTO:
                case LESSTHAN:
                case GREATERTHANOREQUALTO:
                case GREATERTHAN:
                    {
                    alt62=2;
                    }
                    break;
                case IN:
                    {
                    alt62=4;
                    }
                    break;
                case BETWEEN:
                    {
                    alt62=6;
                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // Windowing2.g:342:5: ( NOT nO= negatableOperator r= bitOrExpr -> ^( $nO FALSE $compareExpr $r) )
            	    {
            	    // Windowing2.g:342:5: ( NOT nO= negatableOperator r= bitOrExpr -> ^( $nO FALSE $compareExpr $r) )
            	    // Windowing2.g:342:6: NOT nO= negatableOperator r= bitOrExpr
            	    {
            	    NOT169=(Token)input.LT(1);
            	    match(input,NOT,FOLLOW_NOT_in_compareExpr2344); if (failed) return retval;
            	    if ( backtracking==0 ) stream_NOT.add(NOT169);

            	    pushFollow(FOLLOW_negatableOperator_in_compareExpr2348);
            	    nO=negatableOperator();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_negatableOperator.add(nO.getTree());
            	    pushFollow(FOLLOW_bitOrExpr_in_compareExpr2352);
            	    r=bitOrExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_bitOrExpr.add(r.getTree());

            	    // AST REWRITE
            	    // elements: compareExpr, r, nO
            	    // token labels: 
            	    // rule labels: nO, retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_nO=new RewriteRuleSubtreeStream(adaptor,"token nO",nO!=null?nO.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"token r",r!=null?r.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 342:43: -> ^( $nO FALSE $compareExpr $r)
            	    {
            	        // Windowing2.g:343:40: ^( $nO FALSE $compareExpr $r)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_nO.nextNode(), root_1);

            	        adaptor.addChild(root_1, adaptor.create(FALSE, "FALSE"));
            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_r.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Windowing2.g:346:5: (cO= compareOperator r= bitOrExpr -> ^( $cO TRUE $compareExpr $r) )
            	    {
            	    // Windowing2.g:346:5: (cO= compareOperator r= bitOrExpr -> ^( $cO TRUE $compareExpr $r) )
            	    // Windowing2.g:346:6: cO= compareOperator r= bitOrExpr
            	    {
            	    pushFollow(FOLLOW_compareOperator_in_compareExpr2430);
            	    cO=compareOperator();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_compareOperator.add(cO.getTree());
            	    pushFollow(FOLLOW_bitOrExpr_in_compareExpr2434);
            	    r=bitOrExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_bitOrExpr.add(r.getTree());

            	    // AST REWRITE
            	    // elements: cO, r, compareExpr
            	    // token labels: 
            	    // rule labels: cO, retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_cO=new RewriteRuleSubtreeStream(adaptor,"token cO",cO!=null?cO.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"token r",r!=null?r.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 346:37: -> ^( $cO TRUE $compareExpr $r)
            	    {
            	        // Windowing2.g:347:38: ^( $cO TRUE $compareExpr $r)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_cO.nextNode(), root_1);

            	        adaptor.addChild(root_1, adaptor.create(TRUE, "TRUE"));
            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_r.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // Windowing2.g:350:5: ( NOT IN el= expressions -> ^( FUNCTION IN FALSE $compareExpr $el) )
            	    {
            	    // Windowing2.g:350:5: ( NOT IN el= expressions -> ^( FUNCTION IN FALSE $compareExpr $el) )
            	    // Windowing2.g:350:6: NOT IN el= expressions
            	    {
            	    NOT170=(Token)input.LT(1);
            	    match(input,NOT,FOLLOW_NOT_in_compareExpr2506); if (failed) return retval;
            	    if ( backtracking==0 ) stream_NOT.add(NOT170);

            	    IN171=(Token)input.LT(1);
            	    match(input,IN,FOLLOW_IN_in_compareExpr2508); if (failed) return retval;
            	    if ( backtracking==0 ) stream_IN.add(IN171);

            	    pushFollow(FOLLOW_expressions_in_compareExpr2512);
            	    el=expressions();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_expressions.add(el.getTree());

            	    // AST REWRITE
            	    // elements: el, compareExpr, IN
            	    // token labels: 
            	    // rule labels: retval, el
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_el=new RewriteRuleSubtreeStream(adaptor,"token el",el!=null?el.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 350:28: -> ^( FUNCTION IN FALSE $compareExpr $el)
            	    {
            	        // Windowing2.g:351:26: ^( FUNCTION IN FALSE $compareExpr $el)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

            	        adaptor.addChild(root_1, stream_IN.next());
            	        adaptor.addChild(root_1, adaptor.create(FALSE, "FALSE"));
            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_el.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }


            	    }
            	    break;
            	case 4 :
            	    // Windowing2.g:354:5: ( IN expressions -> ^( FUNCTION IN TRUE $compareExpr $el) )
            	    {
            	    // Windowing2.g:354:5: ( IN expressions -> ^( FUNCTION IN TRUE $compareExpr $el) )
            	    // Windowing2.g:354:6: IN expressions
            	    {
            	    IN172=(Token)input.LT(1);
            	    match(input,IN,FOLLOW_IN_in_compareExpr2573); if (failed) return retval;
            	    if ( backtracking==0 ) stream_IN.add(IN172);

            	    pushFollow(FOLLOW_expressions_in_compareExpr2575);
            	    expressions173=expressions();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_expressions.add(expressions173.getTree());

            	    // AST REWRITE
            	    // elements: compareExpr, el, IN
            	    // token labels: 
            	    // rule labels: retval, el
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_el=new RewriteRuleSubtreeStream(adaptor,"token el",el!=null?el.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 354:21: -> ^( FUNCTION IN TRUE $compareExpr $el)
            	    {
            	        // Windowing2.g:355:21: ^( FUNCTION IN TRUE $compareExpr $el)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

            	        adaptor.addChild(root_1, stream_IN.next());
            	        adaptor.addChild(root_1, adaptor.create(TRUE, "TRUE"));
            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_el.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }


            	    }
            	    break;
            	case 5 :
            	    // Windowing2.g:358:5: ( NOT BETWEEN min= bitOrExpr AND max= bitOrExpr -> ^( FUNCTION BETWEEN FALSE $compareExpr $min $max) )
            	    {
            	    // Windowing2.g:358:5: ( NOT BETWEEN min= bitOrExpr AND max= bitOrExpr -> ^( FUNCTION BETWEEN FALSE $compareExpr $min $max) )
            	    // Windowing2.g:358:6: NOT BETWEEN min= bitOrExpr AND max= bitOrExpr
            	    {
            	    NOT174=(Token)input.LT(1);
            	    match(input,NOT,FOLLOW_NOT_in_compareExpr2631); if (failed) return retval;
            	    if ( backtracking==0 ) stream_NOT.add(NOT174);

            	    BETWEEN175=(Token)input.LT(1);
            	    match(input,BETWEEN,FOLLOW_BETWEEN_in_compareExpr2633); if (failed) return retval;
            	    if ( backtracking==0 ) stream_BETWEEN.add(BETWEEN175);

            	    pushFollow(FOLLOW_bitOrExpr_in_compareExpr2637);
            	    min=bitOrExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_bitOrExpr.add(min.getTree());
            	    AND176=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_compareExpr2639); if (failed) return retval;
            	    if ( backtracking==0 ) stream_AND.add(AND176);

            	    pushFollow(FOLLOW_bitOrExpr_in_compareExpr2643);
            	    max=bitOrExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_bitOrExpr.add(max.getTree());

            	    // AST REWRITE
            	    // elements: BETWEEN, compareExpr, max, min
            	    // token labels: 
            	    // rule labels: min, retval, max
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_min=new RewriteRuleSubtreeStream(adaptor,"token min",min!=null?min.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_max=new RewriteRuleSubtreeStream(adaptor,"token max",max!=null?max.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 358:50: -> ^( FUNCTION BETWEEN FALSE $compareExpr $min $max)
            	    {
            	        // Windowing2.g:359:38: ^( FUNCTION BETWEEN FALSE $compareExpr $min $max)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

            	        adaptor.addChild(root_1, stream_BETWEEN.next());
            	        adaptor.addChild(root_1, adaptor.create(FALSE, "FALSE"));
            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_min.next());
            	        adaptor.addChild(root_1, stream_max.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }


            	    }
            	    break;
            	case 6 :
            	    // Windowing2.g:361:5: ( BETWEEN bitOrExpr AND bitOrExpr -> ^( FUNCTION BETWEEN TRUE $compareExpr $min $max) )
            	    {
            	    // Windowing2.g:361:5: ( BETWEEN bitOrExpr AND bitOrExpr -> ^( FUNCTION BETWEEN TRUE $compareExpr $min $max) )
            	    // Windowing2.g:361:6: BETWEEN bitOrExpr AND bitOrExpr
            	    {
            	    BETWEEN177=(Token)input.LT(1);
            	    match(input,BETWEEN,FOLLOW_BETWEEN_in_compareExpr2714); if (failed) return retval;
            	    if ( backtracking==0 ) stream_BETWEEN.add(BETWEEN177);

            	    pushFollow(FOLLOW_bitOrExpr_in_compareExpr2716);
            	    bitOrExpr178=bitOrExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_bitOrExpr.add(bitOrExpr178.getTree());
            	    AND179=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_compareExpr2718); if (failed) return retval;
            	    if ( backtracking==0 ) stream_AND.add(AND179);

            	    pushFollow(FOLLOW_bitOrExpr_in_compareExpr2720);
            	    bitOrExpr180=bitOrExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_bitOrExpr.add(bitOrExpr180.getTree());

            	    // AST REWRITE
            	    // elements: min, BETWEEN, compareExpr, max
            	    // token labels: 
            	    // rule labels: min, retval, max
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_min=new RewriteRuleSubtreeStream(adaptor,"token min",min!=null?min.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_max=new RewriteRuleSubtreeStream(adaptor,"token max",max!=null?max.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 361:38: -> ^( FUNCTION BETWEEN TRUE $compareExpr $min $max)
            	    {
            	        // Windowing2.g:362:38: ^( FUNCTION BETWEEN TRUE $compareExpr $min $max)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

            	        adaptor.addChild(root_1, stream_BETWEEN.next());
            	        adaptor.addChild(root_1, adaptor.create(TRUE, "TRUE"));
            	        adaptor.addChild(root_1, stream_retval.next());
            	        adaptor.addChild(root_1, stream_min.next());
            	        adaptor.addChild(root_1, stream_max.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end compareExpr

    public static class bitOrExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitOrExpr
    // Windowing2.g:367:1: bitOrExpr : bitAndExpr ( BITWISEOR bitAndExpr )* ;
    public final bitOrExpr_return bitOrExpr() throws RecognitionException {
        bitOrExpr_return retval = new bitOrExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BITWISEOR182=null;
        bitAndExpr_return bitAndExpr181 = null;

        bitAndExpr_return bitAndExpr183 = null;


        Object BITWISEOR182_tree=null;

        try {
            // Windowing2.g:367:11: ( bitAndExpr ( BITWISEOR bitAndExpr )* )
            // Windowing2.g:368:3: bitAndExpr ( BITWISEOR bitAndExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitAndExpr_in_bitOrExpr2798);
            bitAndExpr181=bitAndExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, bitAndExpr181.getTree());
            // Windowing2.g:368:14: ( BITWISEOR bitAndExpr )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==BITWISEOR) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // Windowing2.g:368:15: BITWISEOR bitAndExpr
            	    {
            	    BITWISEOR182=(Token)input.LT(1);
            	    match(input,BITWISEOR,FOLLOW_BITWISEOR_in_bitOrExpr2801); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    BITWISEOR182_tree = (Object)adaptor.create(BITWISEOR182);
            	    root_0 = (Object)adaptor.becomeRoot(BITWISEOR182_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_bitAndExpr_in_bitOrExpr2804);
            	    bitAndExpr183=bitAndExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, bitAndExpr183.getTree());

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end bitOrExpr

    public static class bitAndExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start bitAndExpr
    // Windowing2.g:371:1: bitAndExpr : plusExpr ( AMPERSAND plusExpr )* ;
    public final bitAndExpr_return bitAndExpr() throws RecognitionException {
        bitAndExpr_return retval = new bitAndExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AMPERSAND185=null;
        plusExpr_return plusExpr184 = null;

        plusExpr_return plusExpr186 = null;


        Object AMPERSAND185_tree=null;

        try {
            // Windowing2.g:371:12: ( plusExpr ( AMPERSAND plusExpr )* )
            // Windowing2.g:372:3: plusExpr ( AMPERSAND plusExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_plusExpr_in_bitAndExpr2817);
            plusExpr184=plusExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, plusExpr184.getTree());
            // Windowing2.g:372:12: ( AMPERSAND plusExpr )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==AMPERSAND) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // Windowing2.g:372:13: AMPERSAND plusExpr
            	    {
            	    AMPERSAND185=(Token)input.LT(1);
            	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_bitAndExpr2820); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    AMPERSAND185_tree = (Object)adaptor.create(AMPERSAND185);
            	    root_0 = (Object)adaptor.becomeRoot(AMPERSAND185_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_plusExpr_in_bitAndExpr2823);
            	    plusExpr186=plusExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, plusExpr186.getTree());

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end bitAndExpr

    public static class plusExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start plusExpr
    // Windowing2.g:375:1: plusExpr : starExpr ( ( PLUS | MINUS ) starExpr )* ;
    public final plusExpr_return plusExpr() throws RecognitionException {
        plusExpr_return retval = new plusExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS188=null;
        Token MINUS189=null;
        starExpr_return starExpr187 = null;

        starExpr_return starExpr190 = null;


        Object PLUS188_tree=null;
        Object MINUS189_tree=null;

        try {
            // Windowing2.g:375:10: ( starExpr ( ( PLUS | MINUS ) starExpr )* )
            // Windowing2.g:376:3: starExpr ( ( PLUS | MINUS ) starExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_starExpr_in_plusExpr2836);
            starExpr187=starExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, starExpr187.getTree());
            // Windowing2.g:376:12: ( ( PLUS | MINUS ) starExpr )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=PLUS && LA66_0<=MINUS)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // Windowing2.g:376:13: ( PLUS | MINUS ) starExpr
            	    {
            	    // Windowing2.g:376:13: ( PLUS | MINUS )
            	    int alt65=2;
            	    int LA65_0 = input.LA(1);

            	    if ( (LA65_0==PLUS) ) {
            	        alt65=1;
            	    }
            	    else if ( (LA65_0==MINUS) ) {
            	        alt65=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("376:13: ( PLUS | MINUS )", 65, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt65) {
            	        case 1 :
            	            // Windowing2.g:376:14: PLUS
            	            {
            	            PLUS188=(Token)input.LT(1);
            	            match(input,PLUS,FOLLOW_PLUS_in_plusExpr2840); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            PLUS188_tree = (Object)adaptor.create(PLUS188);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS188_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Windowing2.g:376:22: MINUS
            	            {
            	            MINUS189=(Token)input.LT(1);
            	            match(input,MINUS,FOLLOW_MINUS_in_plusExpr2845); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            MINUS189_tree = (Object)adaptor.create(MINUS189);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS189_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_starExpr_in_plusExpr2850);
            	    starExpr190=starExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, starExpr190.getTree());

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end plusExpr

    public static class starExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start starExpr
    // Windowing2.g:379:1: starExpr : xorExpr ( ( STAR | DIVIDE | MOD | DIV ) xorExpr )* ;
    public final starExpr_return starExpr() throws RecognitionException {
        starExpr_return retval = new starExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STAR192=null;
        Token DIVIDE193=null;
        Token MOD194=null;
        Token DIV195=null;
        xorExpr_return xorExpr191 = null;

        xorExpr_return xorExpr196 = null;


        Object STAR192_tree=null;
        Object DIVIDE193_tree=null;
        Object MOD194_tree=null;
        Object DIV195_tree=null;

        try {
            // Windowing2.g:379:10: ( xorExpr ( ( STAR | DIVIDE | MOD | DIV ) xorExpr )* )
            // Windowing2.g:380:3: xorExpr ( ( STAR | DIVIDE | MOD | DIV ) xorExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_xorExpr_in_starExpr2864);
            xorExpr191=xorExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, xorExpr191.getTree());
            // Windowing2.g:380:11: ( ( STAR | DIVIDE | MOD | DIV ) xorExpr )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==STAR||(LA68_0>=DIVIDE && LA68_0<=DIV)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // Windowing2.g:380:12: ( STAR | DIVIDE | MOD | DIV ) xorExpr
            	    {
            	    // Windowing2.g:380:12: ( STAR | DIVIDE | MOD | DIV )
            	    int alt67=4;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt67=1;
            	        }
            	        break;
            	    case DIVIDE:
            	        {
            	        alt67=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt67=3;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt67=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("380:12: ( STAR | DIVIDE | MOD | DIV )", 67, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt67) {
            	        case 1 :
            	            // Windowing2.g:380:13: STAR
            	            {
            	            STAR192=(Token)input.LT(1);
            	            match(input,STAR,FOLLOW_STAR_in_starExpr2868); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            STAR192_tree = (Object)adaptor.create(STAR192);
            	            root_0 = (Object)adaptor.becomeRoot(STAR192_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Windowing2.g:380:21: DIVIDE
            	            {
            	            DIVIDE193=(Token)input.LT(1);
            	            match(input,DIVIDE,FOLLOW_DIVIDE_in_starExpr2873); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            DIVIDE193_tree = (Object)adaptor.create(DIVIDE193);
            	            root_0 = (Object)adaptor.becomeRoot(DIVIDE193_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Windowing2.g:380:31: MOD
            	            {
            	            MOD194=(Token)input.LT(1);
            	            match(input,MOD,FOLLOW_MOD_in_starExpr2878); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            MOD194_tree = (Object)adaptor.create(MOD194);
            	            root_0 = (Object)adaptor.becomeRoot(MOD194_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // Windowing2.g:380:38: DIV
            	            {
            	            DIV195=(Token)input.LT(1);
            	            match(input,DIV,FOLLOW_DIV_in_starExpr2883); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            DIV195_tree = (Object)adaptor.create(DIV195);
            	            root_0 = (Object)adaptor.becomeRoot(DIV195_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_xorExpr_in_starExpr2887);
            	    xorExpr196=xorExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, xorExpr196.getTree());

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end starExpr

    public static class xorExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start xorExpr
    // Windowing2.g:383:1: xorExpr : nullExpr ( BITWISEXOR nullExpr )* ;
    public final xorExpr_return xorExpr() throws RecognitionException {
        xorExpr_return retval = new xorExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BITWISEXOR198=null;
        nullExpr_return nullExpr197 = null;

        nullExpr_return nullExpr199 = null;


        Object BITWISEXOR198_tree=null;

        try {
            // Windowing2.g:383:9: ( nullExpr ( BITWISEXOR nullExpr )* )
            // Windowing2.g:384:3: nullExpr ( BITWISEXOR nullExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nullExpr_in_xorExpr2900);
            nullExpr197=nullExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, nullExpr197.getTree());
            // Windowing2.g:384:12: ( BITWISEXOR nullExpr )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==BITWISEXOR) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // Windowing2.g:384:13: BITWISEXOR nullExpr
            	    {
            	    BITWISEXOR198=(Token)input.LT(1);
            	    match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_xorExpr2903); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    BITWISEXOR198_tree = (Object)adaptor.create(BITWISEXOR198);
            	    adaptor.addChild(root_0, BITWISEXOR198_tree);
            	    }
            	    pushFollow(FOLLOW_nullExpr_in_xorExpr2905);
            	    nullExpr199=nullExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, nullExpr199.getTree());

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end xorExpr

    public static class nullCondition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nullCondition
    // Windowing2.g:387:1: nullCondition : ( NULL | NOT NULL -> ^( NOTNULL ) );
    public final nullCondition_return nullCondition() throws RecognitionException {
        nullCondition_return retval = new nullCondition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NULL200=null;
        Token NOT201=null;
        Token NULL202=null;

        Object NULL200_tree=null;
        Object NOT201_tree=null;
        Object NULL202_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_NULL=new RewriteRuleTokenStream(adaptor,"token NULL");

        try {
            // Windowing2.g:387:15: ( NULL | NOT NULL -> ^( NOTNULL ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==NULL) ) {
                alt70=1;
            }
            else if ( (LA70_0==NOT) ) {
                alt70=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("387:1: nullCondition : ( NULL | NOT NULL -> ^( NOTNULL ) );", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // Windowing2.g:388:3: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL200=(Token)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_nullCondition2918); if (failed) return retval;
                    if ( backtracking==0 ) {
                    NULL200_tree = (Object)adaptor.create(NULL200);
                    adaptor.addChild(root_0, NULL200_tree);
                    }

                    }
                    break;
                case 2 :
                    // Windowing2.g:389:3: NOT NULL
                    {
                    NOT201=(Token)input.LT(1);
                    match(input,NOT,FOLLOW_NOT_in_nullCondition2924); if (failed) return retval;
                    if ( backtracking==0 ) stream_NOT.add(NOT201);

                    NULL202=(Token)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_nullCondition2926); if (failed) return retval;
                    if ( backtracking==0 ) stream_NULL.add(NULL202);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 389:12: -> ^( NOTNULL )
                    {
                        // Windowing2.g:389:15: ^( NOTNULL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(NOTNULL, "NOTNULL"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end nullCondition

    public static class nullExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start nullExpr
    // Windowing2.g:392:1: nullExpr : unaryExpr (i= IS nullCondition )? -> {$i != null}? ^( FUNCTION nullCondition unaryExpr ) -> unaryExpr ;
    public final nullExpr_return nullExpr() throws RecognitionException {
        nullExpr_return retval = new nullExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        unaryExpr_return unaryExpr203 = null;

        nullCondition_return nullCondition204 = null;


        Object i_tree=null;
        RewriteRuleTokenStream stream_IS=new RewriteRuleTokenStream(adaptor,"token IS");
        RewriteRuleSubtreeStream stream_unaryExpr=new RewriteRuleSubtreeStream(adaptor,"rule unaryExpr");
        RewriteRuleSubtreeStream stream_nullCondition=new RewriteRuleSubtreeStream(adaptor,"rule nullCondition");
        try {
            // Windowing2.g:392:10: ( unaryExpr (i= IS nullCondition )? -> {$i != null}? ^( FUNCTION nullCondition unaryExpr ) -> unaryExpr )
            // Windowing2.g:393:3: unaryExpr (i= IS nullCondition )?
            {
            pushFollow(FOLLOW_unaryExpr_in_nullExpr2943);
            unaryExpr203=unaryExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_unaryExpr.add(unaryExpr203.getTree());
            // Windowing2.g:393:13: (i= IS nullCondition )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==IS) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // Windowing2.g:393:14: i= IS nullCondition
                    {
                    i=(Token)input.LT(1);
                    match(input,IS,FOLLOW_IS_in_nullExpr2948); if (failed) return retval;
                    if ( backtracking==0 ) stream_IS.add(i);

                    pushFollow(FOLLOW_nullCondition_in_nullExpr2950);
                    nullCondition204=nullCondition();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) stream_nullCondition.add(nullCondition204.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: unaryExpr, nullCondition, unaryExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 394:3: -> {$i != null}? ^( FUNCTION nullCondition unaryExpr )
            if (i != null) {
                // Windowing2.g:394:20: ^( FUNCTION nullCondition unaryExpr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_nullCondition.next());
                adaptor.addChild(root_1, stream_unaryExpr.next());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 395:3: -> unaryExpr
            {
                adaptor.addChild(root_0, stream_unaryExpr.next());

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end nullExpr

    public static class unaryExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpr
    // Windowing2.g:398:1: unaryExpr : ( PLUS -> ^( UPLUS $unaryExpr) | MINUS -> ^( UMINUS $unaryExpr) | TILDE -> ^( TILDE $unaryExpr) )* fieldExpr ;
    public final unaryExpr_return unaryExpr() throws RecognitionException {
        unaryExpr_return retval = new unaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS205=null;
        Token MINUS206=null;
        Token TILDE207=null;
        fieldExpr_return fieldExpr208 = null;


        Object PLUS205_tree=null;
        Object MINUS206_tree=null;
        Object TILDE207_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_TILDE=new RewriteRuleTokenStream(adaptor,"token TILDE");
        RewriteRuleSubtreeStream stream_fieldExpr=new RewriteRuleSubtreeStream(adaptor,"rule fieldExpr");
        try {
            // Windowing2.g:398:11: ( ( PLUS -> ^( UPLUS $unaryExpr) | MINUS -> ^( UMINUS $unaryExpr) | TILDE -> ^( TILDE $unaryExpr) )* fieldExpr )
            // Windowing2.g:399:3: ( PLUS -> ^( UPLUS $unaryExpr) | MINUS -> ^( UMINUS $unaryExpr) | TILDE -> ^( TILDE $unaryExpr) )* fieldExpr
            {
            // Windowing2.g:399:3: ( PLUS -> ^( UPLUS $unaryExpr) | MINUS -> ^( UMINUS $unaryExpr) | TILDE -> ^( TILDE $unaryExpr) )*
            loop72:
            do {
                int alt72=4;
                switch ( input.LA(1) ) {
                case PLUS:
                    {
                    alt72=1;
                    }
                    break;
                case MINUS:
                    {
                    alt72=2;
                    }
                    break;
                case TILDE:
                    {
                    alt72=3;
                    }
                    break;

                }

                switch (alt72) {
            	case 1 :
            	    // Windowing2.g:399:4: PLUS
            	    {
            	    PLUS205=(Token)input.LT(1);
            	    match(input,PLUS,FOLLOW_PLUS_in_unaryExpr2984); if (failed) return retval;
            	    if ( backtracking==0 ) stream_PLUS.add(PLUS205);


            	    // AST REWRITE
            	    // elements: unaryExpr
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 399:9: -> ^( UPLUS $unaryExpr)
            	    {
            	        // Windowing2.g:399:12: ^( UPLUS $unaryExpr)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(UPLUS, "UPLUS"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }
            	    break;
            	case 2 :
            	    // Windowing2.g:400:4: MINUS
            	    {
            	    MINUS206=(Token)input.LT(1);
            	    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr3001); if (failed) return retval;
            	    if ( backtracking==0 ) stream_MINUS.add(MINUS206);


            	    // AST REWRITE
            	    // elements: unaryExpr
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 400:10: -> ^( UMINUS $unaryExpr)
            	    {
            	        // Windowing2.g:400:13: ^( UMINUS $unaryExpr)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(adaptor.create(UMINUS, "UMINUS"), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }
            	    break;
            	case 3 :
            	    // Windowing2.g:401:4: TILDE
            	    {
            	    TILDE207=(Token)input.LT(1);
            	    match(input,TILDE,FOLLOW_TILDE_in_unaryExpr3018); if (failed) return retval;
            	    if ( backtracking==0 ) stream_TILDE.add(TILDE207);


            	    // AST REWRITE
            	    // elements: TILDE, unaryExpr
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    if ( backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 401:10: -> ^( TILDE $unaryExpr)
            	    {
            	        // Windowing2.g:401:13: ^( TILDE $unaryExpr)
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_TILDE.next(), root_1);

            	        adaptor.addChild(root_1, stream_retval.next());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    }

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            pushFollow(FOLLOW_fieldExpr_in_unaryExpr3038);
            fieldExpr208=fieldExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_fieldExpr.add(fieldExpr208.getTree());

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end unaryExpr

    public static class fieldExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fieldExpr
    // Windowing2.g:406:1: fieldExpr : atomExpr ( ( LSQUARE expression RSQUARE ) | ( DOT Identifier ) )* ;
    public final fieldExpr_return fieldExpr() throws RecognitionException {
        fieldExpr_return retval = new fieldExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LSQUARE210=null;
        Token RSQUARE212=null;
        Token DOT213=null;
        Token Identifier214=null;
        atomExpr_return atomExpr209 = null;

        expression_return expression211 = null;


        Object LSQUARE210_tree=null;
        Object RSQUARE212_tree=null;
        Object DOT213_tree=null;
        Object Identifier214_tree=null;

        try {
            // Windowing2.g:406:11: ( atomExpr ( ( LSQUARE expression RSQUARE ) | ( DOT Identifier ) )* )
            // Windowing2.g:407:3: atomExpr ( ( LSQUARE expression RSQUARE ) | ( DOT Identifier ) )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atomExpr_in_fieldExpr3049);
            atomExpr209=atomExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, atomExpr209.getTree());
            // Windowing2.g:407:12: ( ( LSQUARE expression RSQUARE ) | ( DOT Identifier ) )*
            loop73:
            do {
                int alt73=3;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==LSQUARE) ) {
                    alt73=1;
                }
                else if ( (LA73_0==DOT) ) {
                    alt73=2;
                }


                switch (alt73) {
            	case 1 :
            	    // Windowing2.g:407:13: ( LSQUARE expression RSQUARE )
            	    {
            	    // Windowing2.g:407:13: ( LSQUARE expression RSQUARE )
            	    // Windowing2.g:407:14: LSQUARE expression RSQUARE
            	    {
            	    LSQUARE210=(Token)input.LT(1);
            	    match(input,LSQUARE,FOLLOW_LSQUARE_in_fieldExpr3053); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    LSQUARE210_tree = (Object)adaptor.create(LSQUARE210);
            	    root_0 = (Object)adaptor.becomeRoot(LSQUARE210_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_expression_in_fieldExpr3056);
            	    expression211=expression();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, expression211.getTree());
            	    RSQUARE212=(Token)input.LT(1);
            	    match(input,RSQUARE,FOLLOW_RSQUARE_in_fieldExpr3058); if (failed) return retval;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Windowing2.g:407:46: ( DOT Identifier )
            	    {
            	    // Windowing2.g:407:46: ( DOT Identifier )
            	    // Windowing2.g:407:47: DOT Identifier
            	    {
            	    DOT213=(Token)input.LT(1);
            	    match(input,DOT,FOLLOW_DOT_in_fieldExpr3065); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    DOT213_tree = (Object)adaptor.create(DOT213);
            	    root_0 = (Object)adaptor.becomeRoot(DOT213_tree, root_0);
            	    }
            	    Identifier214=(Token)input.LT(1);
            	    match(input,Identifier,FOLLOW_Identifier_in_fieldExpr3068); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    Identifier214_tree = (Object)adaptor.create(Identifier214);
            	    adaptor.addChild(root_0, Identifier214_tree);
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end fieldExpr

    public static class atomExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atomExpr
    // Windowing2.g:410:1: atomExpr : ( NULL | constant | function | castExpr | caseExpr | whenExpr | tableOrColumn | LPAREN expression RPAREN );
    public final atomExpr_return atomExpr() throws RecognitionException {
        atomExpr_return retval = new atomExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NULL215=null;
        Token LPAREN222=null;
        Token RPAREN224=null;
        constant_return constant216 = null;

        function_return function217 = null;

        castExpr_return castExpr218 = null;

        caseExpr_return caseExpr219 = null;

        whenExpr_return whenExpr220 = null;

        tableOrColumn_return tableOrColumn221 = null;

        expression_return expression223 = null;


        Object NULL215_tree=null;
        Object LPAREN222_tree=null;
        Object RPAREN224_tree=null;

        try {
            // Windowing2.g:410:10: ( NULL | constant | function | castExpr | caseExpr | whenExpr | tableOrColumn | LPAREN expression RPAREN )
            int alt74=8;
            switch ( input.LA(1) ) {
            case NULL:
                {
                alt74=1;
                }
                break;
            case StringLiteral:
            case Number:
            case BigintLiteral:
            case SmallintLiteral:
            case TinyintLiteral:
            case CharSetName:
            case TRUE:
            case FALSE:
                {
                alt74=2;
                }
                break;
            case Identifier:
                {
                int LA74_10 = input.LA(2);

                if ( (LA74_10==LPAREN) ) {
                    alt74=3;
                }
                else if ( (LA74_10==EOF||LA74_10==FROM||(LA74_10>=COMMA && LA74_10<=AS)||LA74_10==DOT||LA74_10==RPAREN||(LA74_10>=WHERE && LA74_10<=INTO)||LA74_10==EQUAL||LA74_10==STAR||LA74_10==WINDOW||(LA74_10>=BETWEEN && LA74_10<=AND)||LA74_10==Number||(LA74_10>=WHEN && LA74_10<=END)||(LA74_10>=OR && LA74_10<=BITWISEXOR)||LA74_10==IS||(LA74_10>=LSQUARE && LA74_10<=RSQUARE)) ) {
                    alt74=7;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("410:1: atomExpr : ( NULL | constant | function | castExpr | caseExpr | whenExpr | tableOrColumn | LPAREN expression RPAREN );", 74, 10, input);

                    throw nvae;
                }
                }
                break;
            case CAST:
                {
                alt74=4;
                }
                break;
            case CASE:
                {
                int LA74_12 = input.LA(2);

                if ( (LA74_12==Identifier||LA74_12==LPAREN||LA74_12==StringLiteral||LA74_12==Number||(LA74_12>=IF && LA74_12<=CASE)||(LA74_12>=BigintLiteral && LA74_12<=CharSetName)||LA74_12==NOT||(LA74_12>=PLUS && LA74_12<=MINUS)||LA74_12==NULL||LA74_12==TILDE||(LA74_12>=TRUE && LA74_12<=FALSE)) ) {
                    alt74=5;
                }
                else if ( (LA74_12==WHEN) ) {
                    alt74=6;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("410:1: atomExpr : ( NULL | constant | function | castExpr | caseExpr | whenExpr | tableOrColumn | LPAREN expression RPAREN );", 74, 12, input);

                    throw nvae;
                }
                }
                break;
            case IF:
            case ARRAY:
            case MAP:
            case STRUCT:
            case UNION:
                {
                alt74=3;
                }
                break;
            case LPAREN:
                {
                alt74=8;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("410:1: atomExpr : ( NULL | constant | function | castExpr | caseExpr | whenExpr | tableOrColumn | LPAREN expression RPAREN );", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // Windowing2.g:411:3: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL215=(Token)input.LT(1);
                    match(input,NULL,FOLLOW_NULL_in_atomExpr3082); if (failed) return retval;
                    if ( backtracking==0 ) {
                    NULL215_tree = (Object)adaptor.create(NULL215);
                    adaptor.addChild(root_0, NULL215_tree);
                    }

                    }
                    break;
                case 2 :
                    // Windowing2.g:412:5: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_atomExpr3089);
                    constant216=constant();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, constant216.getTree());

                    }
                    break;
                case 3 :
                    // Windowing2.g:413:5: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_atomExpr3095);
                    function217=function();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, function217.getTree());

                    }
                    break;
                case 4 :
                    // Windowing2.g:414:5: castExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_castExpr_in_atomExpr3101);
                    castExpr218=castExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, castExpr218.getTree());

                    }
                    break;
                case 5 :
                    // Windowing2.g:415:5: caseExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_caseExpr_in_atomExpr3107);
                    caseExpr219=caseExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, caseExpr219.getTree());

                    }
                    break;
                case 6 :
                    // Windowing2.g:416:5: whenExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_whenExpr_in_atomExpr3113);
                    whenExpr220=whenExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, whenExpr220.getTree());

                    }
                    break;
                case 7 :
                    // Windowing2.g:417:5: tableOrColumn
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tableOrColumn_in_atomExpr3119);
                    tableOrColumn221=tableOrColumn();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, tableOrColumn221.getTree());

                    }
                    break;
                case 8 :
                    // Windowing2.g:418:5: LPAREN expression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN222=(Token)input.LT(1);
                    match(input,LPAREN,FOLLOW_LPAREN_in_atomExpr3125); if (failed) return retval;
                    pushFollow(FOLLOW_expression_in_atomExpr3128);
                    expression223=expression();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, expression223.getTree());
                    RPAREN224=(Token)input.LT(1);
                    match(input,RPAREN,FOLLOW_RPAREN_in_atomExpr3130); if (failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end atomExpr

    public static class booleanValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start booleanValue
    // Windowing2.g:421:1: booleanValue : ( TRUE | FALSE );
    public final booleanValue_return booleanValue() throws RecognitionException {
        booleanValue_return retval = new booleanValue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TRUE225=null;
        Token FALSE226=null;

        Object TRUE225_tree=null;
        Object FALSE226_tree=null;

        try {
            // Windowing2.g:422:5: ( TRUE | FALSE )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==TRUE) ) {
                alt75=1;
            }
            else if ( (LA75_0==FALSE) ) {
                alt75=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("421:1: booleanValue : ( TRUE | FALSE );", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // Windowing2.g:423:5: TRUE
                    {
                    root_0 = (Object)adaptor.nil();

                    TRUE225=(Token)input.LT(1);
                    match(input,TRUE,FOLLOW_TRUE_in_booleanValue3148); if (failed) return retval;
                    if ( backtracking==0 ) {
                    TRUE225_tree = (Object)adaptor.create(TRUE225);
                    root_0 = (Object)adaptor.becomeRoot(TRUE225_tree, root_0);
                    }

                    }
                    break;
                case 2 :
                    // Windowing2.g:423:13: FALSE
                    {
                    root_0 = (Object)adaptor.nil();

                    FALSE226=(Token)input.LT(1);
                    match(input,FALSE,FOLLOW_FALSE_in_booleanValue3153); if (failed) return retval;
                    if ( backtracking==0 ) {
                    FALSE226_tree = (Object)adaptor.create(FALSE226);
                    root_0 = (Object)adaptor.becomeRoot(FALSE226_tree, root_0);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end booleanValue

    public static class primitiveType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primitiveType
    // Windowing2.g:426:1: primitiveType : ( TINYINT | SMALLINT | INT | BIGINT | BOOLEAN | FLOAT | DOUBLE | DATE | DATETIME | TIMESTAMP | STRING | BINARY );
    public final primitiveType_return primitiveType() throws RecognitionException {
        primitiveType_return retval = new primitiveType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set227=null;

        Object set227_tree=null;

        try {
            // Windowing2.g:426:15: ( TINYINT | SMALLINT | INT | BIGINT | BOOLEAN | FLOAT | DOUBLE | DATE | DATETIME | TIMESTAMP | STRING | BINARY )
            // Windowing2.g:
            {
            root_0 = (Object)adaptor.nil();

            set227=(Token)input.LT(1);
            if ( (input.LA(1)>=TINYINT && input.LA(1)<=BINARY) ) {
                input.consume();
                if ( backtracking==0 ) adaptor.addChild(root_0, adaptor.create(set227));
                errorRecovery=false;failed=false;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_primitiveType0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end primitiveType

    public static class namevalue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start namevalue
    // Windowing2.g:441:1: namevalue : (i= Identifier | i= StringLiteral ) EQUAL v= StringLiteral -> ^( PARAM $i $v) ;
    public final namevalue_return namevalue() throws RecognitionException {
        namevalue_return retval = new namevalue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token v=null;
        Token EQUAL228=null;

        Object i_tree=null;
        Object v_tree=null;
        Object EQUAL228_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");

        try {
            // Windowing2.g:441:11: ( (i= Identifier | i= StringLiteral ) EQUAL v= StringLiteral -> ^( PARAM $i $v) )
            // Windowing2.g:442:2: (i= Identifier | i= StringLiteral ) EQUAL v= StringLiteral
            {
            // Windowing2.g:442:2: (i= Identifier | i= StringLiteral )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==Identifier) ) {
                alt76=1;
            }
            else if ( (LA76_0==StringLiteral) ) {
                alt76=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("442:2: (i= Identifier | i= StringLiteral )", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // Windowing2.g:442:3: i= Identifier
                    {
                    i=(Token)input.LT(1);
                    match(input,Identifier,FOLLOW_Identifier_in_namevalue3278); if (failed) return retval;
                    if ( backtracking==0 ) stream_Identifier.add(i);


                    }
                    break;
                case 2 :
                    // Windowing2.g:442:16: i= StringLiteral
                    {
                    i=(Token)input.LT(1);
                    match(input,StringLiteral,FOLLOW_StringLiteral_in_namevalue3282); if (failed) return retval;
                    if ( backtracking==0 ) stream_StringLiteral.add(i);


                    }
                    break;

            }

            EQUAL228=(Token)input.LT(1);
            match(input,EQUAL,FOLLOW_EQUAL_in_namevalue3285); if (failed) return retval;
            if ( backtracking==0 ) stream_EQUAL.add(EQUAL228);

            v=(Token)input.LT(1);
            match(input,StringLiteral,FOLLOW_StringLiteral_in_namevalue3289); if (failed) return retval;
            if ( backtracking==0 ) stream_StringLiteral.add(v);


            // AST REWRITE
            // elements: i, v
            // token labels: v, i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 442:55: -> ^( PARAM $i $v)
            {
                // Windowing2.g:442:58: ^( PARAM $i $v)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(PARAM, "PARAM"), root_1);

                adaptor.addChild(root_1, stream_i.next());
                adaptor.addChild(root_1, stream_v.next());

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
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
    // $ANTLR end namevalue

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // Windowing2.g:208:24: ( COMMA ordercolumn )
        // Windowing2.g:208:25: COMMA ordercolumn
        {
        match(input,COMMA,FOLLOW_COMMA_in_synpred11250); if (failed) return ;
        pushFollow(FOLLOW_ordercolumn_in_synpred11252);
        ordercolumn();
        _fsp--;
        if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // Windowing2.g:216:32: ( COMMA columnReference )
        // Windowing2.g:216:33: COMMA columnReference
        {
        match(input,COMMA,FOLLOW_COMMA_in_synpred21323); if (failed) return ;
        pushFollow(FOLLOW_columnReference_in_synpred21325);
        columnReference();
        _fsp--;
        if (failed) return ;

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


 

    public static final BitSet FOLLOW_queryForm1_in_query240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_queryForm2_in_query244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_in_queryForm1258 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_FROM_in_queryForm1261 = new BitSet(new long[]{0x0000230000000000L});
    public static final BitSet FOLLOW_tableSpec_in_queryForm1263 = new BitSet(new long[]{0x8000C00000000002L});
    public static final BitSet FOLLOW_where_in_queryForm1266 = new BitSet(new long[]{0x8000800000000002L});
    public static final BitSet FOLLOW_window_clause_in_queryForm1271 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_outputClause_in_queryForm1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_queryForm2307 = new BitSet(new long[]{0x0000230000000000L});
    public static final BitSet FOLLOW_tableSpec_in_queryForm2309 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_select_in_queryForm2312 = new BitSet(new long[]{0x8000C00000000002L});
    public static final BitSet FOLLOW_where_in_queryForm2315 = new BitSet(new long[]{0x8000800000000002L});
    public static final BitSet FOLLOW_window_clause_in_queryForm2320 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_outputClause_in_queryForm2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select358 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_selectColumn_in_select360 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_COMMA_in_select363 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_selectColumn_in_select365 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_expression_in_selectColumn387 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_AS_in_selectColumn390 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_selectColumn392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_function_in_selectColumn411 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn413 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_selectColumn415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tblfunc_in_tableSpec438 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_hiveQuery_in_tableSpec446 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_hdfsFile_in_tableSpec454 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_hiveTable_in_tableSpec462 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_partitionby_in_tableSpec470 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_orderby_in_tableSpec475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HIVEQUERY_in_hiveQuery571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_hiveTable585 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_DOT_in_hiveTable588 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_hiveTable592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_tblfunc649 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPAREN_in_tblfunc651 = new BitSet(new long[]{0x0000230000000000L});
    public static final BitSet FOLLOW_tableSpec_in_tblfunc653 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_COMMA_in_tblfunc656 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_tblfunc658 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_RPAREN_in_tblfunc662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILEINPUT_in_hdfsFile690 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPAREN_in_hdfsFile692 = new BitSet(new long[]{0x0004114000000000L});
    public static final BitSet FOLLOW_namevalue_in_hdfsFile695 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_COMMA_in_hdfsFile700 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_namevalue_in_hdfsFile702 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_RPAREN_in_hdfsFile706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where728 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_where730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_outputClause749 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_PATH_in_outputClause751 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_EQUAL_in_outputClause753 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_outputClause757 = new BitSet(new long[]{0x0108000000000002L});
    public static final BitSet FOLLOW_outputSerDe_in_outputClause761 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_loadClause_in_outputClause766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERDE_in_outputSerDe795 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_outputSerDe799 = new BitSet(new long[]{0x00D0000000000000L});
    public static final BitSet FOLLOW_outputSerDePropeties_in_outputSerDe803 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_outputFormatOrWriter_in_outputSerDe808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_outputSerDePropeties834 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties836 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPAREN_in_outputSerDePropeties838 = new BitSet(new long[]{0x0004114000000000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties841 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_COMMA_in_outputSerDePropeties846 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties848 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_RPAREN_in_outputSerDePropeties852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORDWRITER_in_outputFormatOrWriter878 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_outputFormatOrWriter880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAT_in_outputFormatOrWriter894 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_outputFormatOrWriter896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_loadClause914 = new BitSet(new long[]{0x0200800000000000L});
    public static final BitSet FOLLOW_OVERWRITE_in_loadClause918 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_INTO_in_loadClause921 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_TABLE_in_loadClause923 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_loadClause927 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_loadClause930 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_loadClause934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionName_in_window_function970 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPAREN_in_window_function977 = new BitSet(new long[]{0x3004190000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_STAR_in_window_function995 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_DISTINCT_in_window_function1009 = new BitSet(new long[]{0x0004190000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_window_function1014 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_COMMA_in_window_function1017 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_window_function1019 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_RPAREN_in_window_function1036 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_function1039 = new BitSet(new long[]{0x0800010000000002L,0x0000000000002011L});
    public static final BitSet FOLLOW_window_specification_in_window_function1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WINDOW_in_window_clause1146 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_window_defn_in_window_clause1148 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_COMMA_in_window_clause1151 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_window_defn_in_window_clause1153 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_Identifier_in_window_defn1177 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AS_in_window_defn1179 = new BitSet(new long[]{0x0800010000000002L,0x0000000000002011L});
    public static final BitSet FOLLOW_window_specification_in_window_defn1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_window_specification1204 = new BitSet(new long[]{0x0800000000000002L,0x0000000000002011L});
    public static final BitSet FOLLOW_partitionby_in_window_specification1207 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002011L});
    public static final BitSet FOLLOW_orderby_in_window_specification1210 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002010L});
    public static final BitSet FOLLOW_window_frame_in_window_specification1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby1242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_orderby1244 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby1246 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_COMMA_in_orderby1256 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby1258 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_columnReference_in_ordercolumn1279 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_ASC_in_ordercolumn1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby1315 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_partitionby1317 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_columnReference_in_partitionby1319 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby1329 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_columnReference_in_partitionby1331 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_window_range_expression_in_window_frame1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_frame1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression1367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression1369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001480L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression1373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_AND_in_window_range_expression1375 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001480L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary1402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary1429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_rowsboundary1444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression1476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression1478 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1480L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression1482 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_AND_in_window_value_expression1484 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1480L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary1511 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary1538 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_valuesboundary1555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_Number_in_valuesboundary1559 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_columnReference1598 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_DOT_in_columnReference1601 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_columnReference1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_tableOrColumn1665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionName_in_function1690 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPAREN_in_function1697 = new BitSet(new long[]{0x3004190000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_STAR_in_function1715 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_DISTINCT_in_function1729 = new BitSet(new long[]{0x0004190000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_function1734 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_COMMA_in_function1737 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_function1739 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_RPAREN_in_function1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_in_castExpr1926 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPAREN_in_castExpr1928 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_castExpr1930 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AS_in_castExpr1932 = new BitSet(new long[]{0x0000000000000000L,0xF800000000000000L,0x000000000000007FL});
    public static final BitSet FOLLOW_primitiveType_in_castExpr1934 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_castExpr1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_caseExpr1957 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_caseExpr1959 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_WHEN_in_caseExpr1964 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_caseExpr1966 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_THEN_in_caseExpr1968 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_caseExpr1970 = new BitSet(new long[]{0x0000000000000000L,0x0000000006800000L});
    public static final BitSet FOLLOW_ELSE_in_caseExpr1977 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_caseExpr1979 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_END_in_caseExpr1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_whenExpr2009 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_WHEN_in_whenExpr2015 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_whenExpr2017 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_THEN_in_whenExpr2019 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_whenExpr2021 = new BitSet(new long[]{0x0000000000000000L,0x0000000006800000L});
    public static final BitSet FOLLOW_ELSE_in_whenExpr2028 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_whenExpr2030 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_END_in_whenExpr2036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_constant2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_constant2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringLiteralSequence_in_constant2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BigintLiteral_in_constant2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SmallintLiteral_in_constant2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TinyintLiteral_in_constant2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charSetStringLiteral_in_constant2094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValue_in_constant2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_stringLiteralSequence2113 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_stringLiteralSequence2115 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_CharSetName_in_charSetStringLiteral2142 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_CharSetLiteral_in_charSetStringLiteral2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_expressions2169 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_expressions2171 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_COMMA_in_expressions2174 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_expressions2176 = new BitSet(new long[]{0x0000104000000000L});
    public static final BitSet FOLLOW_RPAREN_in_expressions2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpr_in_expression2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr2207 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_OR_in_orExpr2210 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_andExpr_in_orExpr2213 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_notExpr_in_andExpr2226 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_AND_in_andExpr2229 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_notExpr_in_andExpr2232 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_NOT_in_notExpr2246 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_compareExpr_in_notExpr2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_negatableOperator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negatableOperator_in_compareOperator2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_compareOperator2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_NS_in_compareOperator2290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareOperator2294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESSTHANOREQUALTO_in_compareOperator2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESSTHAN_in_compareOperator2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATERTHANOREQUALTO_in_compareOperator2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATERTHAN_in_compareOperator2313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bitOrExpr_in_compareExpr2327 = new BitSet(new long[]{0x0002000000000002L,0x00000FFE00000020L});
    public static final BitSet FOLLOW_NOT_in_compareExpr2344 = new BitSet(new long[]{0x0000000000000000L,0x0000001C00000000L});
    public static final BitSet FOLLOW_negatableOperator_in_compareExpr2348 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_bitOrExpr_in_compareExpr2352 = new BitSet(new long[]{0x0002000000000002L,0x00000FFE00000020L});
    public static final BitSet FOLLOW_compareOperator_in_compareExpr2430 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_bitOrExpr_in_compareExpr2434 = new BitSet(new long[]{0x0002000000000002L,0x00000FFE00000020L});
    public static final BitSet FOLLOW_NOT_in_compareExpr2506 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_IN_in_compareExpr2508 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_expressions_in_compareExpr2512 = new BitSet(new long[]{0x0002000000000002L,0x00000FFE00000020L});
    public static final BitSet FOLLOW_IN_in_compareExpr2573 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_expressions_in_compareExpr2575 = new BitSet(new long[]{0x0002000000000002L,0x00000FFE00000020L});
    public static final BitSet FOLLOW_NOT_in_compareExpr2631 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_BETWEEN_in_compareExpr2633 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_bitOrExpr_in_compareExpr2637 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_AND_in_compareExpr2639 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_bitOrExpr_in_compareExpr2643 = new BitSet(new long[]{0x0002000000000002L,0x00000FFE00000020L});
    public static final BitSet FOLLOW_BETWEEN_in_compareExpr2714 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_bitOrExpr_in_compareExpr2716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_AND_in_compareExpr2718 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_bitOrExpr_in_compareExpr2720 = new BitSet(new long[]{0x0002000000000002L,0x00000FFE00000020L});
    public static final BitSet FOLLOW_bitAndExpr_in_bitOrExpr2798 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
    public static final BitSet FOLLOW_BITWISEOR_in_bitOrExpr2801 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_bitAndExpr_in_bitOrExpr2804 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
    public static final BitSet FOLLOW_plusExpr_in_bitAndExpr2817 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_AMPERSAND_in_bitAndExpr2820 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_plusExpr_in_bitAndExpr2823 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_starExpr_in_plusExpr2836 = new BitSet(new long[]{0x0000000000000002L,0x0000C00000000000L});
    public static final BitSet FOLLOW_PLUS_in_plusExpr2840 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_MINUS_in_plusExpr2845 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_starExpr_in_plusExpr2850 = new BitSet(new long[]{0x0000000000000002L,0x0000C00000000000L});
    public static final BitSet FOLLOW_xorExpr_in_starExpr2864 = new BitSet(new long[]{0x1000000000000002L,0x0007000000000000L});
    public static final BitSet FOLLOW_STAR_in_starExpr2868 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_DIVIDE_in_starExpr2873 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_MOD_in_starExpr2878 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_DIV_in_starExpr2883 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_xorExpr_in_starExpr2887 = new BitSet(new long[]{0x1000000000000002L,0x0007000000000000L});
    public static final BitSet FOLLOW_nullExpr_in_xorExpr2900 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_BITWISEXOR_in_xorExpr2903 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_nullExpr_in_xorExpr2905 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_NULL_in_nullCondition2918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_nullCondition2924 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_NULL_in_nullCondition2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_nullExpr2943 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L});
    public static final BitSet FOLLOW_IS_in_nullExpr2948 = new BitSet(new long[]{0x0000000000000000L,0x0010000200000000L});
    public static final BitSet FOLLOW_nullCondition_in_nullExpr2950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpr2984 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr3001 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpr3018 = new BitSet(new long[]{0x0004090000000000L,0x0650C000787F1000L});
    public static final BitSet FOLLOW_fieldExpr_in_unaryExpr3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atomExpr_in_fieldExpr3049 = new BitSet(new long[]{0x0000040000000002L,0x0080000000000000L});
    public static final BitSet FOLLOW_LSQUARE_in_fieldExpr3053 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_fieldExpr3056 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_RSQUARE_in_fieldExpr3058 = new BitSet(new long[]{0x0000040000000002L,0x0080000000000000L});
    public static final BitSet FOLLOW_DOT_in_fieldExpr3065 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Identifier_in_fieldExpr3068 = new BitSet(new long[]{0x0000040000000002L,0x0080000000000000L});
    public static final BitSet FOLLOW_NULL_in_atomExpr3082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_atomExpr3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_atomExpr3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpr_in_atomExpr3101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseExpr_in_atomExpr3107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whenExpr_in_atomExpr3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tableOrColumn_in_atomExpr3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atomExpr3125 = new BitSet(new long[]{0x0004090000000000L,0x0650C002787F1000L});
    public static final BitSet FOLLOW_expression_in_atomExpr3128 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_atomExpr3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_booleanValue3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_booleanValue3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_namevalue3278 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_namevalue3282 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_EQUAL_in_namevalue3285 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_StringLiteral_in_namevalue3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_synpred11250 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ordercolumn_in_synpred11252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_synpred21323 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_columnReference_in_synpred21325 = new BitSet(new long[]{0x0000000000000002L});

}