// $ANTLR 3.3 Nov 30, 2010 12:46:29 com\\sap\\hadoop\\windowing\\parser\\Windowing.g 2012-02-01 17:57:16

package com.sap.hadoop.windowing.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class WindowingParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "TBLFUNCPARAM", "TBLFUNCTION", "FROM", "WITH", "ID", "GROOVYEXPRESSION", "LPAREN", "RPAREN", "COMMA", "TABLEINPUT", "STRING", "EQ", "ORDER", "BY", "ASC", "DESC", "PARTITION", "AS", "LBRACKET", "RBRACKET", "NUMBER", "OVER", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "RANGE", "LESS", "MORE", "SELECT", "WHERE", "INTO", "PATH", "SERDE", "SERDEPROPERTIES", "RECORDWRITER", "FORMAT", "PLUS", "MINUS", "ASTERISK", "SOLIDUS", "DOT", "QUOTE", "COLON", "SEMICOLON", "GE", "GT", "LBRACE", "LE", "LT", "NE", "RBRACE", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "B", "I", "N", "P", "U", "D", "Y", "G", "V", "NOT", "OR", "X", "XOR", "GroovyEscapeSequence", "EscapeSequence", "WS", "J", "K", "Q", "Z", "'E'"
    };
    public static final int EOF=-1;
    public static final int T__105=105;
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
    public static final int TBLFUNCPARAM=17;
    public static final int TBLFUNCTION=18;
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
    public static final int PLUS=58;
    public static final int MINUS=59;
    public static final int ASTERISK=60;
    public static final int SOLIDUS=61;
    public static final int DOT=62;
    public static final int QUOTE=63;
    public static final int COLON=64;
    public static final int SEMICOLON=65;
    public static final int GE=66;
    public static final int GT=67;
    public static final int LBRACE=68;
    public static final int LE=69;
    public static final int LT=70;
    public static final int NE=71;
    public static final int RBRACE=72;
    public static final int S=73;
    public static final int E=74;
    public static final int L=75;
    public static final int C=76;
    public static final int T=77;
    public static final int F=78;
    public static final int R=79;
    public static final int O=80;
    public static final int M=81;
    public static final int W=82;
    public static final int H=83;
    public static final int A=84;
    public static final int B=85;
    public static final int I=86;
    public static final int N=87;
    public static final int P=88;
    public static final int U=89;
    public static final int D=90;
    public static final int Y=91;
    public static final int G=92;
    public static final int V=93;
    public static final int NOT=94;
    public static final int OR=95;
    public static final int X=96;
    public static final int XOR=97;
    public static final int GroovyEscapeSequence=98;
    public static final int EscapeSequence=99;
    public static final int WS=100;
    public static final int J=101;
    public static final int K=102;
    public static final int Q=103;
    public static final int Z=104;

    // delegates
    // delegators


        public WindowingParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public WindowingParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return WindowingParser.tokenNames; }
    public String getGrammarFileName() { return "com\\sap\\hadoop\\windowing\\parser\\Windowing.g"; }


    	protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException
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


    public static class query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:59:1: query : FROM tableSpec partitionby orderby ( WITH funclist )? select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec partitionby orderby select ( funclist )? ( where )? ( outputClause )? ) ;
    public final WindowingParser.query_return query() throws RecognitionException {
        WindowingParser.query_return retval = new WindowingParser.query_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FROM1=null;
        Token WITH5=null;
        Token EOF10=null;
        WindowingParser.tableSpec_return tableSpec2 = null;

        WindowingParser.partitionby_return partitionby3 = null;

        WindowingParser.orderby_return orderby4 = null;

        WindowingParser.funclist_return funclist6 = null;

        WindowingParser.select_return select7 = null;

        WindowingParser.where_return where8 = null;

        WindowingParser.outputClause_return outputClause9 = null;


        Object FROM1_tree=null;
        Object WITH5_tree=null;
        Object EOF10_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_funclist=new RewriteRuleSubtreeStream(adaptor,"rule funclist");
        RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        RewriteRuleSubtreeStream stream_where=new RewriteRuleSubtreeStream(adaptor,"rule where");
        RewriteRuleSubtreeStream stream_outputClause=new RewriteRuleSubtreeStream(adaptor,"rule outputClause");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:59:7: ( FROM tableSpec partitionby orderby ( WITH funclist )? select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec partitionby orderby select ( funclist )? ( where )? ( outputClause )? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:60:2: FROM tableSpec partitionby orderby ( WITH funclist )? select ( where )? ( outputClause )? EOF
            {
            FROM1=(Token)match(input,FROM,FOLLOW_FROM_in_query147); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM1);

            pushFollow(FOLLOW_tableSpec_in_query149);
            tableSpec2=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec2.getTree());
            pushFollow(FOLLOW_partitionby_in_query152);
            partitionby3=partitionby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionby.add(partitionby3.getTree());
            pushFollow(FOLLOW_orderby_in_query155);
            orderby4=orderby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orderby.add(orderby4.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:63:2: ( WITH funclist )?
            int alt1=2;
            switch ( input.LA(1) ) {
                case WITH:
                    {
                    alt1=1;
                    }
                    break;
            }

            switch (alt1) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:63:3: WITH funclist
                    {
                    WITH5=(Token)match(input,WITH,FOLLOW_WITH_in_query159); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WITH.add(WITH5);

                    pushFollow(FOLLOW_funclist_in_query161);
                    funclist6=funclist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_funclist.add(funclist6.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_select_in_query166);
            select7=select();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select.add(select7.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:65:2: ( where )?
            int alt2=2;
            switch ( input.LA(1) ) {
                case WHERE:
                    {
                    alt2=1;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:65:2: where
                    {
                    pushFollow(FOLLOW_where_in_query169);
                    where8=where();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_where.add(where8.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:66:2: ( outputClause )?
            int alt3=2;
            switch ( input.LA(1) ) {
                case INTO:
                    {
                    alt3=1;
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:66:2: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_query174);
                    outputClause9=outputClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputClause.add(outputClause9.getTree());

                    }
                    break;

            }

            EOF10=(Token)match(input,EOF,FOLLOW_EOF_in_query179); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF10);



            // AST REWRITE
            // elements: funclist, partitionby, outputClause, orderby, where, tableSpec, select
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 67:6: -> ^( QUERY tableSpec partitionby orderby select ( funclist )? ( where )? ( outputClause )? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:67:9: ^( QUERY tableSpec partitionby orderby select ( funclist )? ( where )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                adaptor.addChild(root_1, stream_partitionby.nextTree());
                adaptor.addChild(root_1, stream_orderby.nextTree());
                adaptor.addChild(root_1, stream_select.nextTree());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:67:54: ( funclist )?
                if ( stream_funclist.hasNext() ) {
                    adaptor.addChild(root_1, stream_funclist.nextTree());

                }
                stream_funclist.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:67:64: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.nextTree());

                }
                stream_where.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:67:71: ( outputClause )?
                if ( stream_outputClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_outputClause.nextTree());

                }
                stream_outputClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "query"

    public static class tableSpec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tableSpec"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:1: tableSpec : ( hivetable | ID -> ^( TABLEINPUT ID ) | h= GROOVYEXPRESSION -> ^( TABLEINPUT $h) | LPAREN h= GROOVYEXPRESSION RPAREN -> ^( TABLEINPUT $h) | tblfunc );
    public final WindowingParser.tableSpec_return tableSpec() throws RecognitionException {
        WindowingParser.tableSpec_return retval = new WindowingParser.tableSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token h=null;
        Token ID12=null;
        Token LPAREN13=null;
        Token RPAREN14=null;
        WindowingParser.hivetable_return hivetable11 = null;

        WindowingParser.tblfunc_return tblfunc15 = null;


        Object h_tree=null;
        Object ID12_tree=null;
        Object LPAREN13_tree=null;
        Object RPAREN14_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:11: ( hivetable | ID -> ^( TABLEINPUT ID ) | h= GROOVYEXPRESSION -> ^( TABLEINPUT $h) | LPAREN h= GROOVYEXPRESSION RPAREN -> ^( TABLEINPUT $h) | tblfunc )
            int alt4=5;
            switch ( input.LA(1) ) {
            case TABLEINPUT:
                {
                alt4=1;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case LPAREN:
                    {
                    alt4=5;
                    }
                    break;
                case RPAREN:
                case COMMA:
                case PARTITION:
                    {
                    alt4=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }

                }
                break;
            case GROOVYEXPRESSION:
                {
                alt4=3;
                }
                break;
            case LPAREN:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:71:2: hivetable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hivetable_in_tableSpec212);
                    hivetable11=hivetable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hivetable11.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:72:2: ID
                    {
                    ID12=(Token)match(input,ID,FOLLOW_ID_in_tableSpec217); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID12);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 72:5: -> ^( TABLEINPUT ID )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:72:8: ^( TABLEINPUT ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:73:2: h= GROOVYEXPRESSION
                    {
                    h=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_tableSpec232); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(h);



                    // AST REWRITE
                    // elements: h
                    // token labels: h
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_h=new RewriteRuleTokenStream(adaptor,"token h",h);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 73:21: -> ^( TABLEINPUT $h)
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:73:24: ^( TABLEINPUT $h)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                        adaptor.addChild(root_1, stream_h.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:2: LPAREN h= GROOVYEXPRESSION RPAREN
                    {
                    LPAREN13=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tableSpec246); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN13);

                    h=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_tableSpec250); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(h);

                    RPAREN14=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tableSpec252); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN14);



                    // AST REWRITE
                    // elements: h
                    // token labels: h
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_h=new RewriteRuleTokenStream(adaptor,"token h",h);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 74:35: -> ^( TABLEINPUT $h)
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:38: ^( TABLEINPUT $h)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                        adaptor.addChild(root_1, stream_h.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:75:2: tblfunc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tblfunc_in_tableSpec266);
                    tblfunc15=tblfunc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tblfunc15.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tableSpec"

    public static class tblfunc_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tblfunc"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:78:1: tblfunc : name= ID LPAREN tableSpec ( COMMA tblfuncparam )* RPAREN ( window_expression )? -> ^( TBLFUNCTION $name tableSpec ( tblfuncparam )* ( window_expression )? ) ;
    public final WindowingParser.tblfunc_return tblfunc() throws RecognitionException {
        WindowingParser.tblfunc_return retval = new WindowingParser.tblfunc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token LPAREN16=null;
        Token COMMA18=null;
        Token RPAREN20=null;
        WindowingParser.tableSpec_return tableSpec17 = null;

        WindowingParser.tblfuncparam_return tblfuncparam19 = null;

        WindowingParser.window_expression_return window_expression21 = null;


        Object name_tree=null;
        Object LPAREN16_tree=null;
        Object COMMA18_tree=null;
        Object RPAREN20_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_tblfuncparam=new RewriteRuleSubtreeStream(adaptor,"rule tblfuncparam");
        RewriteRuleSubtreeStream stream_window_expression=new RewriteRuleSubtreeStream(adaptor,"rule window_expression");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:78:9: (name= ID LPAREN tableSpec ( COMMA tblfuncparam )* RPAREN ( window_expression )? -> ^( TBLFUNCTION $name tableSpec ( tblfuncparam )* ( window_expression )? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:3: name= ID LPAREN tableSpec ( COMMA tblfuncparam )* RPAREN ( window_expression )?
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_tblfunc279); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN16=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tblfunc281); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN16);

            pushFollow(FOLLOW_tableSpec_in_tblfunc283);
            tableSpec17=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec17.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:28: ( COMMA tblfuncparam )*
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:29: COMMA tblfuncparam
            	    {
            	    COMMA18=(Token)match(input,COMMA,FOLLOW_COMMA_in_tblfunc286); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA18);

            	    pushFollow(FOLLOW_tblfuncparam_in_tblfunc288);
            	    tblfuncparam19=tblfuncparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_tblfuncparam.add(tblfuncparam19.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            RPAREN20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tblfunc292); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN20);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:57: ( window_expression )?
            int alt6=2;
            switch ( input.LA(1) ) {
                case OVER:
                    {
                    alt6=1;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:58: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_tblfunc295);
                    window_expression21=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression21.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: tableSpec, tblfuncparam, window_expression, name
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 80:5: -> ^( TBLFUNCTION $name tableSpec ( tblfuncparam )* ( window_expression )? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:80:8: ^( TBLFUNCTION $name tableSpec ( tblfuncparam )* ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TBLFUNCTION, "TBLFUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:80:38: ( tblfuncparam )*
                while ( stream_tblfuncparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_tblfuncparam.nextTree());

                }
                stream_tblfuncparam.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:80:52: ( window_expression )?
                if ( stream_window_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_expression.nextTree());

                }
                stream_window_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tblfunc"

    public static class hivetable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hivetable"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:83:1: hivetable : TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) ;
    public final WindowingParser.hivetable_return hivetable() throws RecognitionException {
        WindowingParser.hivetable_return retval = new WindowingParser.hivetable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TABLEINPUT22=null;
        Token LPAREN23=null;
        Token COMMA25=null;
        Token RPAREN27=null;
        WindowingParser.namevalue_return namevalue24 = null;

        WindowingParser.namevalue_return namevalue26 = null;


        Object TABLEINPUT22_tree=null;
        Object LPAREN23_tree=null;
        Object COMMA25_tree=null;
        Object RPAREN27_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_TABLEINPUT=new RewriteRuleTokenStream(adaptor,"token TABLEINPUT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:83:11: ( TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:84:2: TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            TABLEINPUT22=(Token)match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hivetable329); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TABLEINPUT.add(TABLEINPUT22);

            LPAREN23=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_hivetable331); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN23);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:84:20: ( namevalue )?
            int alt7=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                    {
                    alt7=1;
                    }
                    break;
            }

            switch (alt7) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:84:21: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hivetable334);
                    namevalue24=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue24.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:84:33: ( COMMA namevalue )*
            loop8:
            do {
                int alt8=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt8=1;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:84:34: COMMA namevalue
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_hivetable339); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA25);

            	    pushFollow(FOLLOW_namevalue_in_hivetable341);
            	    namevalue26=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue26.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            RPAREN27=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_hivetable345); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN27);



            // AST REWRITE
            // elements: TABLEINPUT, namevalue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 84:60: -> ^( TABLEINPUT ( namevalue )* )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:84:63: ^( TABLEINPUT ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_TABLEINPUT.nextNode(), root_1);

                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:84:76: ( namevalue )*
                while ( stream_namevalue.hasNext() ) {
                    adaptor.addChild(root_1, stream_namevalue.nextTree());

                }
                stream_namevalue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "hivetable"

    public static class namevalue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "namevalue"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:87:1: namevalue : (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) ;
    public final WindowingParser.namevalue_return namevalue() throws RecognitionException {
        WindowingParser.namevalue_return retval = new WindowingParser.namevalue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token v=null;
        Token EQ28=null;

        Object i_tree=null;
        Object v_tree=null;
        Object EQ28_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:87:11: ( (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:88:2: (i= ID | i= STRING ) EQ v= STRING
            {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:88:2: (i= ID | i= STRING )
            int alt9=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt9=1;
                }
                break;
            case STRING:
                {
                alt9=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:88:3: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_namevalue368); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:88:8: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue372); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ28=(Token)match(input,EQ,FOLLOW_EQ_in_namevalue375); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ28);

            v=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue379); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(v);



            // AST REWRITE
            // elements: i, v
            // token labels: v, i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 88:30: -> ^( PARAM $i $v)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:88:33: ^( PARAM $i $v)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAM, "PARAM"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_v.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "namevalue"

    public static class orderby_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orderby"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:91:1: orderby : ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
    public final WindowingParser.orderby_return orderby() throws RecognitionException {
        WindowingParser.orderby_return retval = new WindowingParser.orderby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER29=null;
        Token BY30=null;
        Token COMMA32=null;
        WindowingParser.ordercolumn_return ordercolumn31 = null;

        WindowingParser.ordercolumn_return ordercolumn33 = null;


        Object ORDER29_tree=null;
        Object BY30_tree=null;
        Object COMMA32_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_ordercolumn=new RewriteRuleSubtreeStream(adaptor,"rule ordercolumn");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:91:9: ( ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:92:2: ORDER BY ordercolumn ( COMMA ordercolumn )*
            {
            ORDER29=(Token)match(input,ORDER,FOLLOW_ORDER_in_orderby401); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ORDER.add(ORDER29);

            BY30=(Token)match(input,BY,FOLLOW_BY_in_orderby403); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY30);

            pushFollow(FOLLOW_ordercolumn_in_orderby405);
            ordercolumn31=ordercolumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn31.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:92:23: ( COMMA ordercolumn )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt10=1;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:92:24: COMMA ordercolumn
            	    {
            	    COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderby408); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA32);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby410);
            	    ordercolumn33=ordercolumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn33.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);



            // AST REWRITE
            // elements: ordercolumn, ORDER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 92:44: -> ^( ORDER ( ordercolumn )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:92:47: ^( ORDER ( ordercolumn )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_ORDER.nextNode(), root_1);

                if ( !(stream_ordercolumn.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ordercolumn.hasNext() ) {
                    adaptor.addChild(root_1, stream_ordercolumn.nextTree());

                }
                stream_ordercolumn.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "orderby"

    public static class ordercolumn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ordercolumn"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:1: ordercolumn : ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) ;
    public final WindowingParser.ordercolumn_return ordercolumn() throws RecognitionException {
        WindowingParser.ordercolumn_return retval = new WindowingParser.ordercolumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token o=null;
        Token ID34=null;

        Object o_tree=null;
        Object ID34_tree=null;
        RewriteRuleTokenStream stream_ASC=new RewriteRuleTokenStream(adaptor,"token ASC");
        RewriteRuleTokenStream stream_DESC=new RewriteRuleTokenStream(adaptor,"token DESC");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:13: ( ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:96:2: ID (o= ASC | o= DESC )?
            {
            ID34=(Token)match(input,ID,FOLLOW_ID_in_ordercolumn431); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID34);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:96:5: (o= ASC | o= DESC )?
            int alt11=3;
            switch ( input.LA(1) ) {
                case ASC:
                    {
                    alt11=1;
                    }
                    break;
                case DESC:
                    {
                    alt11=2;
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:96:6: o= ASC
                    {
                    o=(Token)match(input,ASC,FOLLOW_ASC_in_ordercolumn436); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:96:14: o= DESC
                    {
                    o=(Token)match(input,DESC,FOLLOW_DESC_in_ordercolumn442); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESC.add(o);


                    }
                    break;

            }



            // AST REWRITE
            // elements: o, ID
            // token labels: o
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_o=new RewriteRuleTokenStream(adaptor,"token o",o);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 96:23: -> ^( ORDERCOLUMN ID ( $o)? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:96:26: ^( ORDERCOLUMN ID ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:96:43: ( $o)?
                if ( stream_o.hasNext() ) {
                    adaptor.addChild(root_1, stream_o.nextNode());

                }
                stream_o.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ordercolumn"

    public static class partitionby_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "partitionby"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:1: partitionby : PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) ;
    public final WindowingParser.partitionby_return partitionby() throws RecognitionException {
        WindowingParser.partitionby_return retval = new WindowingParser.partitionby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PARTITION35=null;
        Token BY36=null;
        Token ID37=null;
        Token COMMA38=null;
        Token ID39=null;

        Object PARTITION35_tree=null;
        Object BY36_tree=null;
        Object ID37_tree=null;
        Object COMMA38_tree=null;
        Object ID39_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:13: ( PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:2: PARTITION BY ID ( COMMA ID )*
            {
            PARTITION35=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_partitionby467); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARTITION.add(PARTITION35);

            BY36=(Token)match(input,BY,FOLLOW_BY_in_partitionby469); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY36);

            ID37=(Token)match(input,ID,FOLLOW_ID_in_partitionby471); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID37);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:18: ( COMMA ID )*
            loop12:
            do {
                int alt12=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt12=1;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:19: COMMA ID
            	    {
            	    COMMA38=(Token)match(input,COMMA,FOLLOW_COMMA_in_partitionby474); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA38);

            	    ID39=(Token)match(input,ID,FOLLOW_ID_in_partitionby476); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID39);


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);



            // AST REWRITE
            // elements: PARTITION, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 100:30: -> ^( PARTITION ( ID )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:33: ^( PARTITION ( ID )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_PARTITION.nextNode(), root_1);

                if ( !(stream_ID.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ID.hasNext() ) {
                    adaptor.addChild(root_1, stream_ID.nextNode());

                }
                stream_ID.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "partitionby"

    public static class funclist_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funclist"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:103:1: funclist : function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) ;
    public final WindowingParser.funclist_return funclist() throws RecognitionException {
        WindowingParser.funclist_return retval = new WindowingParser.funclist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA41=null;
        WindowingParser.function_return function40 = null;

        WindowingParser.function_return function42 = null;


        Object COMMA41_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:103:10: ( function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:104:2: function ( COMMA function )*
            {
            pushFollow(FOLLOW_function_in_funclist498);
            function40=function();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function.add(function40.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:104:11: ( COMMA function )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt13=1;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:104:12: COMMA function
            	    {
            	    COMMA41=(Token)match(input,COMMA,FOLLOW_COMMA_in_funclist501); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA41);

            	    pushFollow(FOLLOW_function_in_funclist503);
            	    function42=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function.add(function42.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);



            // AST REWRITE
            // elements: function
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 104:29: -> ^( FUNCTIONS ( function )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:104:32: ^( FUNCTIONS ( function )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTIONS, "FUNCTIONS"), root_1);

                if ( !(stream_function.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_function.hasNext() ) {
                    adaptor.addChild(root_1, stream_function.nextTree());

                }
                stream_function.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "funclist"

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "function"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:107:1: function : name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) ;
    public final WindowingParser.function_return function() throws RecognitionException {
        WindowingParser.function_return retval = new WindowingParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token alias=null;
        Token typeNm=null;
        Token LPAREN43=null;
        Token COMMA45=null;
        Token RPAREN47=null;
        Token AS49=null;
        Token LBRACKET50=null;
        Token RBRACKET51=null;
        WindowingParser.functionparam_return functionparam44 = null;

        WindowingParser.functionparam_return functionparam46 = null;

        WindowingParser.window_expression_return window_expression48 = null;


        Object name_tree=null;
        Object alias_tree=null;
        Object typeNm_tree=null;
        Object LPAREN43_tree=null;
        Object COMMA45_tree=null;
        Object RPAREN47_tree=null;
        Object AS49_tree=null;
        Object LBRACKET50_tree=null;
        Object RBRACKET51_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_window_expression=new RewriteRuleSubtreeStream(adaptor,"rule window_expression");
        RewriteRuleSubtreeStream stream_functionparam=new RewriteRuleSubtreeStream(adaptor,"rule functionparam");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:107:10: (name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:2: name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )?
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_function527); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN43=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function529); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN43);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:17: ( functionparam )?
            int alt14=2;
            switch ( input.LA(1) ) {
                case ID:
                case GROOVYEXPRESSION:
                case STRING:
                case NUMBER:
                    {
                    alt14=1;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:18: functionparam
                    {
                    pushFollow(FOLLOW_functionparam_in_function532);
                    functionparam44=functionparam();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionparam.add(functionparam44.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:34: ( COMMA functionparam )*
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:35: COMMA functionparam
            	    {
            	    COMMA45=(Token)match(input,COMMA,FOLLOW_COMMA_in_function537); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA45);

            	    pushFollow(FOLLOW_functionparam_in_function539);
            	    functionparam46=functionparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_functionparam.add(functionparam46.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            RPAREN47=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function543); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN47);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:64: ( window_expression )?
            int alt16=2;
            switch ( input.LA(1) ) {
                case OVER:
                    {
                    alt16=1;
                    }
                    break;
            }

            switch (alt16) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:65: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function546);
                    window_expression48=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression48.getTree());

                    }
                    break;

            }

            AS49=(Token)match(input,AS,FOLLOW_AS_in_function550); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AS.add(AS49);

            alias=(Token)match(input,ID,FOLLOW_ID_in_function554); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(alias);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:97: ( LBRACKET typeNm= ID RBRACKET )?
            int alt17=2;
            switch ( input.LA(1) ) {
                case LBRACKET:
                    {
                    alt17=1;
                    }
                    break;
            }

            switch (alt17) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:98: LBRACKET typeNm= ID RBRACKET
                    {
                    LBRACKET50=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_function557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET50);

                    typeNm=(Token)match(input,ID,FOLLOW_ID_in_function561); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(typeNm);

                    RBRACKET51=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_function563); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET51);


                    }
                    break;

            }



            // AST REWRITE
            // elements: name, typeNm, alias, functionparam, window_expression
            // token labels: typeNm, alias, name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_typeNm=new RewriteRuleTokenStream(adaptor,"token typeNm",typeNm);
            RewriteRuleTokenStream stream_alias=new RewriteRuleTokenStream(adaptor,"token alias",alias);
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 108:128: -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:7: ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_alias.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:31: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.nextTree());

                }
                stream_functionparam.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:46: ( ^( TYPENAME $typeNm) )?
                if ( stream_typeNm.hasNext() ) {
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:46: ^( TYPENAME $typeNm)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                    adaptor.addChild(root_2, stream_typeNm.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_typeNm.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:67: ( window_expression )?
                if ( stream_window_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_expression.nextTree());

                }
                stream_window_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function"

    public static class functionparam_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionparam"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:112:1: functionparam : ( GROOVYEXPRESSION | STRING | ID | NUMBER );
    public final WindowingParser.functionparam_return functionparam() throws RecognitionException {
        WindowingParser.functionparam_return retval = new WindowingParser.functionparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set52=null;

        Object set52_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:112:16: ( GROOVYEXPRESSION | STRING | ID | NUMBER )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set52=(Token)input.LT(1);
            if ( (input.LA(1)>=ID && input.LA(1)<=GROOVYEXPRESSION)||input.LA(1)==STRING||input.LA(1)==NUMBER ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set52));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionparam"

    public static class tblfuncparam_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tblfuncparam"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:116:1: tblfuncparam : (i= ID | i= STRING ) EQ v= functionparam -> ^( TBLFUNCPARAM $i $v) ;
    public final WindowingParser.tblfuncparam_return tblfuncparam() throws RecognitionException {
        WindowingParser.tblfuncparam_return retval = new WindowingParser.tblfuncparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token EQ53=null;
        WindowingParser.functionparam_return v = null;


        Object i_tree=null;
        Object EQ53_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_functionparam=new RewriteRuleSubtreeStream(adaptor,"rule functionparam");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:116:14: ( (i= ID | i= STRING ) EQ v= functionparam -> ^( TBLFUNCPARAM $i $v) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:117:3: (i= ID | i= STRING ) EQ v= functionparam
            {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:117:3: (i= ID | i= STRING )
            int alt18=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt18=1;
                }
                break;
            case STRING:
                {
                alt18=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:117:4: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_tblfuncparam636); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:117:9: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_tblfuncparam640); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ53=(Token)match(input,EQ,FOLLOW_EQ_in_tblfuncparam643); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ53);

            pushFollow(FOLLOW_functionparam_in_tblfuncparam647);
            v=functionparam();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionparam.add(v.getTree());


            // AST REWRITE
            // elements: i, v
            // token labels: i
            // rule labels: v, retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 117:38: -> ^( TBLFUNCPARAM $i $v)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:117:41: ^( TBLFUNCPARAM $i $v)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TBLFUNCPARAM, "TBLFUNCPARAM"), root_1);

                adaptor.addChild(root_1, stream_i.nextNode());
                adaptor.addChild(root_1, stream_v.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tblfuncparam"

    public static class window_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "window_expression"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:120:1: window_expression : OVER ( window_range_expression | window_value_expression ) ;
    public final WindowingParser.window_expression_return window_expression() throws RecognitionException {
        WindowingParser.window_expression_return retval = new WindowingParser.window_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OVER54=null;
        WindowingParser.window_range_expression_return window_range_expression55 = null;

        WindowingParser.window_value_expression_return window_value_expression56 = null;


        Object OVER54_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:120:19: ( OVER ( window_range_expression | window_value_expression ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:121:2: OVER ( window_range_expression | window_value_expression )
            {
            root_0 = (Object)adaptor.nil();

            OVER54=(Token)match(input,OVER,FOLLOW_OVER_in_window_expression669); if (state.failed) return retval;
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:122:2: ( window_range_expression | window_value_expression )
            int alt19=2;
            switch ( input.LA(1) ) {
            case ROWS:
                {
                alt19=1;
                }
                break;
            case RANGE:
                {
                alt19=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:122:3: window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression675);
                    window_range_expression55=window_range_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_range_expression55.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:123:2: window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression680);
                    window_value_expression56=window_value_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_value_expression56.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "window_expression"

    public static class window_range_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "window_range_expression"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:127:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final WindowingParser.window_range_expression_return window_range_expression() throws RecognitionException {
        WindowingParser.window_range_expression_return retval = new WindowingParser.window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS57=null;
        Token BETWEEN58=null;
        Token AND59=null;
        WindowingParser.rowsboundary_return s = null;

        WindowingParser.rowsboundary_return e = null;


        Object ROWS57_tree=null;
        Object BETWEEN58_tree=null;
        Object AND59_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:127:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:128:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS57=(Token)match(input,ROWS,FOLLOW_ROWS_in_window_range_expression694); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ROWS.add(ROWS57);

            BETWEEN58=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression696); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN58);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression700);
            s=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(s.getTree());
            AND59=(Token)match(input,AND,FOLLOW_AND_in_window_range_expression702); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND59);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression706);
            e=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(e.getTree());


            // AST REWRITE
            // elements: e, s
            // token labels: 
            // rule labels: retval, e, s
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);

            root_0 = (Object)adaptor.nil();
            // 128:49: -> ^( WINDOWRANGE $s $e)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:128:52: ^( WINDOWRANGE $s $e)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WINDOWRANGE, "WINDOWRANGE"), root_1);

                adaptor.addChild(root_1, stream_s.nextTree());
                adaptor.addChild(root_1, stream_e.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "window_range_expression"

    public static class rowsboundary_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rowsboundary"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:131:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );
    public final WindowingParser.rowsboundary_return rowsboundary() throws RecognitionException {
        WindowingParser.rowsboundary_return retval = new WindowingParser.rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED60=null;
        Token CURRENT61=null;
        Token ROW62=null;
        Token NUMBER63=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED60_tree=null;
        Object CURRENT61_tree=null;
        Object ROW62_tree=null;
        Object NUMBER63_tree=null;
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:131:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt22=1;
                }
                break;
            case CURRENT:
                {
                alt22=2;
                }
                break;
            case NUMBER:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:132:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED60=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary729); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED60);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:132:13: (r= PRECEDING | r= FOLLOWING )
                    int alt20=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt20=1;
                        }
                        break;
                    case FOLLOWING:
                        {
                        alt20=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }

                    switch (alt20) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:132:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary734); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:132:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary738); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FOLLOWING.add(r);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: UNBOUNDED, r
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 132:40: -> ^( $r UNBOUNDED )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:132:43: ^( $r UNBOUNDED )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_UNBOUNDED.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:133:3: CURRENT ROW
                    {
                    CURRENT61=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary756); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT61);

                    ROW62=(Token)match(input,ROW,FOLLOW_ROW_in_rowsboundary758); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW62);



                    // AST REWRITE
                    // elements: CURRENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 133:16: -> ^( CURRENT )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:133:19: ^( CURRENT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CURRENT.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:3: NUMBER (d= PRECEDING | d= FOLLOWING )
                    {
                    NUMBER63=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary771); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER63);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:10: (d= PRECEDING | d= FOLLOWING )
                    int alt21=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt21=1;
                        }
                        break;
                    case FOLLOWING:
                        {
                        alt21=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }

                    switch (alt21) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:11: d= PRECEDING
                            {
                            d=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary776); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:25: d= FOLLOWING
                            {
                            d=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary782); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FOLLOWING.add(d);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: d, NUMBER
                    // token labels: d
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 134:39: -> ^( $d NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:42: ^( $d NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_d.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rowsboundary"

    public static class window_value_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "window_value_expression"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:137:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final WindowingParser.window_value_expression_return window_value_expression() throws RecognitionException {
        WindowingParser.window_value_expression_return retval = new WindowingParser.window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE64=null;
        Token BETWEEN65=null;
        Token AND66=null;
        WindowingParser.valuesboundary_return s = null;

        WindowingParser.valuesboundary_return e = null;


        Object RANGE64_tree=null;
        Object BETWEEN65_tree=null;
        Object AND66_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:137:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:138:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE64=(Token)match(input,RANGE,FOLLOW_RANGE_in_window_value_expression803); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE64);

            BETWEEN65=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression805); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN65);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression809);
            s=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(s.getTree());
            AND66=(Token)match(input,AND,FOLLOW_AND_in_window_value_expression811); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND66);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression815);
            e=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(e.getTree());


            // AST REWRITE
            // elements: s, e
            // token labels: 
            // rule labels: retval, e, s
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);

            root_0 = (Object)adaptor.nil();
            // 138:54: -> ^( WINDOWVALUES $s $e)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:138:57: ^( WINDOWVALUES $s $e)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WINDOWVALUES, "WINDOWVALUES"), root_1);

                adaptor.addChild(root_1, stream_s.nextTree());
                adaptor.addChild(root_1, stream_e.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "window_value_expression"

    public static class valuesboundary_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "valuesboundary"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:141:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );
    public final WindowingParser.valuesboundary_return valuesboundary() throws RecognitionException {
        WindowingParser.valuesboundary_return retval = new WindowingParser.valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED67=null;
        Token CURRENT68=null;
        Token ROW69=null;
        Token GROOVYEXPRESSION70=null;
        Token NUMBER71=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED67_tree=null;
        Object CURRENT68_tree=null;
        Object ROW69_tree=null;
        Object GROOVYEXPRESSION70_tree=null;
        Object NUMBER71_tree=null;
        RewriteRuleTokenStream stream_MORE=new RewriteRuleTokenStream(adaptor,"token MORE");
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleTokenStream stream_LESS=new RewriteRuleTokenStream(adaptor,"token LESS");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:141:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt25=1;
                }
                break;
            case CURRENT:
                {
                alt25=2;
                }
                break;
            case GROOVYEXPRESSION:
                {
                alt25=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:142:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED67=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary838); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED67);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:142:13: (r= PRECEDING | r= FOLLOWING )
                    int alt23=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt23=1;
                        }
                        break;
                    case FOLLOWING:
                        {
                        alt23=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }

                    switch (alt23) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:142:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary843); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:142:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary847); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FOLLOWING.add(r);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: r, UNBOUNDED
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 142:40: -> ^( $r UNBOUNDED )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:142:43: ^( $r UNBOUNDED )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_r.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_UNBOUNDED.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:3: CURRENT ROW
                    {
                    CURRENT68=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary865); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT68);

                    ROW69=(Token)match(input,ROW,FOLLOW_ROW_in_valuesboundary867); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW69);



                    // AST REWRITE
                    // elements: CURRENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 143:16: -> ^( CURRENT )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:19: ^( CURRENT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CURRENT.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:3: GROOVYEXPRESSION NUMBER (d= LESS | d= MORE )
                    {
                    GROOVYEXPRESSION70=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary880); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION70);

                    NUMBER71=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary882); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER71);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:27: (d= LESS | d= MORE )
                    int alt24=2;
                    switch ( input.LA(1) ) {
                    case LESS:
                        {
                        alt24=1;
                        }
                        break;
                    case MORE:
                        {
                        alt24=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:28: d= LESS
                            {
                            d=(Token)match(input,LESS,FOLLOW_LESS_in_valuesboundary887); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:37: d= MORE
                            {
                            d=(Token)match(input,MORE,FOLLOW_MORE_in_valuesboundary893); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MORE.add(d);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: GROOVYEXPRESSION, NUMBER, d
                    // token labels: d
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 144:46: -> ^( $d GROOVYEXPRESSION NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:49: ^( $d GROOVYEXPRESSION NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_d.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());
                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "valuesboundary"

    public static class select_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:147:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final WindowingParser.select_return select() throws RecognitionException {
        WindowingParser.select_return retval = new WindowingParser.select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT72=null;
        Token COMMA74=null;
        WindowingParser.selectColumn_return selectColumn73 = null;

        WindowingParser.selectColumn_return selectColumn75 = null;


        Object SELECT72_tree=null;
        Object COMMA74_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:147:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT72=(Token)match(input,SELECT,FOLLOW_SELECT_in_select918); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT72);

            pushFollow(FOLLOW_selectColumn_in_select920);
            selectColumn73=selectColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn73.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:23: ( COMMA selectColumn )*
            loop26:
            do {
                int alt26=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt26=1;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:24: COMMA selectColumn
            	    {
            	    COMMA74=(Token)match(input,COMMA,FOLLOW_COMMA_in_select923); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA74);

            	    pushFollow(FOLLOW_selectColumn_in_select925);
            	    selectColumn75=selectColumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn75.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);



            // AST REWRITE
            // elements: selectColumn, SELECT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 148:46: -> ^( SELECT ( selectColumn )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:49: ^( SELECT ( selectColumn )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SELECT.nextNode(), root_1);

                if ( !(stream_selectColumn.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_selectColumn.hasNext() ) {
                    adaptor.addChild(root_1, stream_selectColumn.nextTree());

                }
                stream_selectColumn.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "select"

    public static class selectColumn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectColumn"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:151:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );
    public final WindowingParser.selectColumn_return selectColumn() throws RecognitionException {
        WindowingParser.selectColumn_return retval = new WindowingParser.selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token typeNm=null;
        Token GROOVYEXPRESSION76=null;
        Token AS77=null;
        Token ID78=null;
        Token LBRACKET79=null;
        Token RBRACKET80=null;
        Token ID81=null;

        Object typeNm_tree=null;
        Object GROOVYEXPRESSION76_tree=null;
        Object AS77_tree=null;
        Object ID78_tree=null;
        Object LBRACKET79_tree=null;
        Object RBRACKET80_tree=null;
        Object ID81_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:151:13: ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) )
            int alt28=2;
            switch ( input.LA(1) ) {
            case GROOVYEXPRESSION:
                {
                alt28=1;
                }
                break;
            case ID:
                {
                alt28=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:3: GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )?
                    {
                    GROOVYEXPRESSION76=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn947); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION76);

                    AS77=(Token)match(input,AS,FOLLOW_AS_in_selectColumn949); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS77);

                    ID78=(Token)match(input,ID,FOLLOW_ID_in_selectColumn951); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID78);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:26: ( LBRACKET typeNm= ID RBRACKET )?
                    int alt27=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            alt27=1;
                            }
                            break;
                    }

                    switch (alt27) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:27: LBRACKET typeNm= ID RBRACKET
                            {
                            LBRACKET79=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_selectColumn954); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET79);

                            typeNm=(Token)match(input,ID,FOLLOW_ID_in_selectColumn958); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ID.add(typeNm);

                            RBRACKET80=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_selectColumn960); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET80);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: GROOVYEXPRESSION, typeNm, ID
                    // token labels: typeNm
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_typeNm=new RewriteRuleTokenStream(adaptor,"token typeNm",typeNm);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 152:57: -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:60: ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:95: ( ^( TYPENAME $typeNm) )?
                        if ( stream_typeNm.hasNext() ) {
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:95: ^( TYPENAME $typeNm)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                            adaptor.addChild(root_2, stream_typeNm.nextNode());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_typeNm.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:153:3: ID
                    {
                    ID81=(Token)match(input,ID,FOLLOW_ID_in_selectColumn986); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID81);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 153:6: -> ^( SELECTCOLUMN ID )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:153:9: ^( SELECTCOLUMN ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "selectColumn"

    public static class where_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:1: where : ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) ;
    public final WindowingParser.where_return where() throws RecognitionException {
        WindowingParser.where_return retval = new WindowingParser.where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE82=null;
        Token GROOVYEXPRESSION83=null;

        Object WHERE82_tree=null;
        Object GROOVYEXPRESSION83_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:7: ( ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:157:2: ( WHERE GROOVYEXPRESSION )
            {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:157:2: ( WHERE GROOVYEXPRESSION )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:157:3: WHERE GROOVYEXPRESSION
            {
            WHERE82=(Token)match(input,WHERE,FOLLOW_WHERE_in_where1006); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHERE.add(WHERE82);

            GROOVYEXPRESSION83=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where1008); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION83);


            }



            // AST REWRITE
            // elements: WHERE, GROOVYEXPRESSION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 157:27: -> ^( WHERE GROOVYEXPRESSION )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:157:30: ^( WHERE GROOVYEXPRESSION )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_WHERE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "where"

    public static class outputClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "outputClause"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:160:1: outputClause : INTO PATH EQ p= STRING (s= outputSerDe )? -> ^( OUTPUTSPEC $p ( $s)? ) ;
    public final WindowingParser.outputClause_return outputClause() throws RecognitionException {
        WindowingParser.outputClause_return retval = new WindowingParser.outputClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token p=null;
        Token INTO84=null;
        Token PATH85=null;
        Token EQ86=null;
        WindowingParser.outputSerDe_return s = null;


        Object p_tree=null;
        Object INTO84_tree=null;
        Object PATH85_tree=null;
        Object EQ86_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_PATH=new RewriteRuleTokenStream(adaptor,"token PATH");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_outputSerDe=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDe");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:160:14: ( INTO PATH EQ p= STRING (s= outputSerDe )? -> ^( OUTPUTSPEC $p ( $s)? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:161:2: INTO PATH EQ p= STRING (s= outputSerDe )?
            {
            INTO84=(Token)match(input,INTO,FOLLOW_INTO_in_outputClause1027); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTO.add(INTO84);

            PATH85=(Token)match(input,PATH,FOLLOW_PATH_in_outputClause1029); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PATH.add(PATH85);

            EQ86=(Token)match(input,EQ,FOLLOW_EQ_in_outputClause1031); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ86);

            p=(Token)match(input,STRING,FOLLOW_STRING_in_outputClause1035); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(p);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:161:25: (s= outputSerDe )?
            int alt29=2;
            switch ( input.LA(1) ) {
                case SERDE:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:161:25: s= outputSerDe
                    {
                    pushFollow(FOLLOW_outputSerDe_in_outputClause1039);
                    s=outputSerDe();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputSerDe.add(s.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: s, p
            // token labels: p
            // rule labels: retval, s
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_p=new RewriteRuleTokenStream(adaptor,"token p",p);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);

            root_0 = (Object)adaptor.nil();
            // 161:39: -> ^( OUTPUTSPEC $p ( $s)? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:161:42: ^( OUTPUTSPEC $p ( $s)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUTSPEC, "OUTPUTSPEC"), root_1);

                adaptor.addChild(root_1, stream_p.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:161:58: ( $s)?
                if ( stream_s.hasNext() ) {
                    adaptor.addChild(root_1, stream_s.nextTree());

                }
                stream_s.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "outputClause"

    public static class outputSerDe_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "outputSerDe"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:164:1: outputSerDe : SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) ;
    public final WindowingParser.outputSerDe_return outputSerDe() throws RecognitionException {
        WindowingParser.outputSerDe_return retval = new WindowingParser.outputSerDe_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token SERDE87=null;
        WindowingParser.outputSerDePropeties_return p = null;

        WindowingParser.outputFormatOrWriter_return o = null;


        Object s_tree=null;
        Object SERDE87_tree=null;
        RewriteRuleTokenStream stream_SERDE=new RewriteRuleTokenStream(adaptor,"token SERDE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_outputFormatOrWriter=new RewriteRuleSubtreeStream(adaptor,"rule outputFormatOrWriter");
        RewriteRuleSubtreeStream stream_outputSerDePropeties=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDePropeties");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:164:13: ( SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:165:3: SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter
            {
            SERDE87=(Token)match(input,SERDE,FOLLOW_SERDE_in_outputSerDe1064); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SERDE.add(SERDE87);

            s=(Token)match(input,STRING,FOLLOW_STRING_in_outputSerDe1068); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(s);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:165:19: (p= outputSerDePropeties )?
            int alt30=2;
            switch ( input.LA(1) ) {
                case WITH:
                    {
                    alt30=1;
                    }
                    break;
            }

            switch (alt30) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:165:19: p= outputSerDePropeties
                    {
                    pushFollow(FOLLOW_outputSerDePropeties_in_outputSerDe1072);
                    p=outputSerDePropeties();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputSerDePropeties.add(p.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe1077);
            o=outputFormatOrWriter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_outputFormatOrWriter.add(o.getTree());


            // AST REWRITE
            // elements: s, SERDE, o, p
            // token labels: s
            // rule labels: retval, p, o
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
            RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.tree:null);

            root_0 = (Object)adaptor.nil();
            // 165:65: -> ^( SERDE $s $o ( $p)? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:165:68: ^( SERDE $s $o ( $p)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_s.nextNode());
                adaptor.addChild(root_1, stream_o.nextTree());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:165:82: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.nextTree());

                }
                stream_p.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "outputSerDe"

    public static class outputSerDePropeties_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "outputSerDePropeties"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:168:1: outputSerDePropeties : WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) ;
    public final WindowingParser.outputSerDePropeties_return outputSerDePropeties() throws RecognitionException {
        WindowingParser.outputSerDePropeties_return retval = new WindowingParser.outputSerDePropeties_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WITH88=null;
        Token SERDEPROPERTIES89=null;
        Token LPAREN90=null;
        Token COMMA92=null;
        Token RPAREN94=null;
        WindowingParser.namevalue_return namevalue91 = null;

        WindowingParser.namevalue_return namevalue93 = null;


        Object WITH88_tree=null;
        Object SERDEPROPERTIES89_tree=null;
        Object LPAREN90_tree=null;
        Object COMMA92_tree=null;
        Object RPAREN94_tree=null;
        RewriteRuleTokenStream stream_SERDEPROPERTIES=new RewriteRuleTokenStream(adaptor,"token SERDEPROPERTIES");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:168:21: ( WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:169:3: WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            WITH88=(Token)match(input,WITH,FOLLOW_WITH_in_outputSerDePropeties1103); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WITH.add(WITH88);

            SERDEPROPERTIES89=(Token)match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1105); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SERDEPROPERTIES.add(SERDEPROPERTIES89);

            LPAREN90=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_outputSerDePropeties1107); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN90);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:169:31: ( namevalue )?
            int alt31=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                    {
                    alt31=1;
                    }
                    break;
            }

            switch (alt31) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:169:32: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1110);
                    namevalue91=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue91.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:169:44: ( COMMA namevalue )*
            loop32:
            do {
                int alt32=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt32=1;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:169:45: COMMA namevalue
            	    {
            	    COMMA92=(Token)match(input,COMMA,FOLLOW_COMMA_in_outputSerDePropeties1115); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA92);

            	    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1117);
            	    namevalue93=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue93.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            RPAREN94=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_outputSerDePropeties1121); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN94);



            // AST REWRITE
            // elements: namevalue, SERDEPROPERTIES
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 170:6: -> ^( SERDEPROPERTIES ( namevalue )* )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:9: ^( SERDEPROPERTIES ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDEPROPERTIES.nextNode(), root_1);

                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:27: ( namevalue )*
                while ( stream_namevalue.hasNext() ) {
                    adaptor.addChild(root_1, stream_namevalue.nextTree());

                }
                stream_namevalue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "outputSerDePropeties"

    public static class outputFormatOrWriter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "outputFormatOrWriter"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:173:1: outputFormatOrWriter : ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) );
    public final WindowingParser.outputFormatOrWriter_return outputFormatOrWriter() throws RecognitionException {
        WindowingParser.outputFormatOrWriter_return retval = new WindowingParser.outputFormatOrWriter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RECORDWRITER95=null;
        Token STRING96=null;
        Token FORMAT97=null;
        Token STRING98=null;

        Object RECORDWRITER95_tree=null;
        Object STRING96_tree=null;
        Object FORMAT97_tree=null;
        Object STRING98_tree=null;
        RewriteRuleTokenStream stream_RECORDWRITER=new RewriteRuleTokenStream(adaptor,"token RECORDWRITER");
        RewriteRuleTokenStream stream_FORMAT=new RewriteRuleTokenStream(adaptor,"token FORMAT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:173:22: ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) )
            int alt33=2;
            switch ( input.LA(1) ) {
            case RECORDWRITER:
                {
                alt33=1;
                }
                break;
            case FORMAT:
                {
                alt33=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:3: RECORDWRITER STRING
                    {
                    RECORDWRITER95=(Token)match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter1147); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RECORDWRITER.add(RECORDWRITER95);

                    STRING96=(Token)match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1149); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING96);



                    // AST REWRITE
                    // elements: RECORDWRITER, STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 174:23: -> ^( RECORDWRITER STRING )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:26: ^( RECORDWRITER STRING )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_RECORDWRITER.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_STRING.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:175:3: FORMAT STRING
                    {
                    FORMAT97=(Token)match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter1163); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FORMAT.add(FORMAT97);

                    STRING98=(Token)match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1165); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING98);



                    // AST REWRITE
                    // elements: FORMAT, STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 175:17: -> ^( FORMAT STRING )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:175:20: ^( FORMAT STRING )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_FORMAT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_STRING.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "outputFormatOrWriter"

    public static class value_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value_expression"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:177:1: value_expression : ( numeric_expression | STRING );
    public final WindowingParser.value_expression_return value_expression() throws RecognitionException {
        WindowingParser.value_expression_return retval = new WindowingParser.value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING100=null;
        WindowingParser.numeric_expression_return numeric_expression99 = null;


        Object STRING100_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:177:18: ( numeric_expression | STRING )
            int alt34=2;
            switch ( input.LA(1) ) {
            case ID:
            case LPAREN:
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt34=1;
                }
                break;
            case STRING:
                {
                alt34=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:178:3: numeric_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_expression_in_value_expression1183);
                    numeric_expression99=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression99.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:179:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING100=(Token)match(input,STRING,FOLLOW_STRING_in_value_expression1189); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING100_tree = (Object)adaptor.create(STRING100);
                    adaptor.addChild(root_0, STRING100_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "value_expression"

    public static class numeric_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numeric_expression"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:182:1: numeric_expression : term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* ;
    public final WindowingParser.numeric_expression_return numeric_expression() throws RecognitionException {
        WindowingParser.numeric_expression_return retval = new WindowingParser.numeric_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS102=null;
        Token MINUS103=null;
        WindowingParser.term_return term101 = null;

        WindowingParser.term_return term104 = null;


        Object PLUS102_tree=null;
        Object MINUS103_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:182:20: ( term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:3: term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_numeric_expression1201);
            term101=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term101.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:8: ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==PLUS) && (synpred1_Windowing())) {
                    alt36=1;
                }
                else if ( (LA36_0==MINUS) && (synpred1_Windowing())) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:9: ( PLUS | MINUS )=> ( PLUS | MINUS ) term
            	    {
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:26: ( PLUS | MINUS )
            	    int alt35=2;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt35=1;
            	        }
            	        break;
            	    case MINUS:
            	        {
            	        alt35=2;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt35) {
            	        case 1 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:27: PLUS
            	            {
            	            PLUS102=(Token)match(input,PLUS,FOLLOW_PLUS_in_numeric_expression1214); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS102_tree = (Object)adaptor.create(PLUS102);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS102_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:35: MINUS
            	            {
            	            MINUS103=(Token)match(input,MINUS,FOLLOW_MINUS_in_numeric_expression1219); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS103_tree = (Object)adaptor.create(MINUS103);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS103_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_numeric_expression1223);
            	    term104=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term104.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "numeric_expression"

    public static class term_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:186:1: term : numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* ;
    public final WindowingParser.term_return term() throws RecognitionException {
        WindowingParser.term_return retval = new WindowingParser.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASTERISK106=null;
        Token SOLIDUS107=null;
        WindowingParser.numeric_primary_expression_return numeric_primary_expression105 = null;

        WindowingParser.numeric_primary_expression_return numeric_primary_expression108 = null;


        Object ASTERISK106_tree=null;
        Object SOLIDUS107_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:186:7: ( numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:3: numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_numeric_primary_expression_in_term1241);
            numeric_primary_expression105=numeric_primary_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression105.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:30: ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==ASTERISK) && (synpred2_Windowing())) {
                    alt38=1;
                }
                else if ( (LA38_0==SOLIDUS) && (synpred2_Windowing())) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:31: ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression
            	    {
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:54: ( ASTERISK | SOLIDUS )
            	    int alt37=2;
            	    switch ( input.LA(1) ) {
            	    case ASTERISK:
            	        {
            	        alt37=1;
            	        }
            	        break;
            	    case SOLIDUS:
            	        {
            	        alt37=2;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt37) {
            	        case 1 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:55: ASTERISK
            	            {
            	            ASTERISK106=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_term1254); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ASTERISK106_tree = (Object)adaptor.create(ASTERISK106);
            	            root_0 = (Object)adaptor.becomeRoot(ASTERISK106_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:67: SOLIDUS
            	            {
            	            SOLIDUS107=(Token)match(input,SOLIDUS,FOLLOW_SOLIDUS_in_term1259); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SOLIDUS107_tree = (Object)adaptor.create(SOLIDUS107);
            	            root_0 = (Object)adaptor.becomeRoot(SOLIDUS107_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_numeric_primary_expression_in_term1263);
            	    numeric_primary_expression108=numeric_primary_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression108.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class numeric_primary_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numeric_primary_expression"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:190:1: numeric_primary_expression : ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN );
    public final WindowingParser.numeric_primary_expression_return numeric_primary_expression() throws RecognitionException {
        WindowingParser.numeric_primary_expression_return retval = new WindowingParser.numeric_primary_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN111=null;
        Token RPAREN113=null;
        WindowingParser.identifier_return identifier109 = null;

        WindowingParser.signed_numeric_literal_return signed_numeric_literal110 = null;

        WindowingParser.numeric_expression_return numeric_expression112 = null;


        Object LPAREN111_tree=null;
        Object RPAREN113_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:190:28: ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN )
            int alt39=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt39=1;
                }
                break;
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt39=2;
                }
                break;
            case LPAREN:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:191:3: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_numeric_primary_expression1277);
                    identifier109=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier109.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:192:3: signed_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signed_numeric_literal_in_numeric_primary_expression1284);
                    signed_numeric_literal110=signed_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_numeric_literal110.getTree());

                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:193:3: LPAREN numeric_expression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN111=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numeric_primary_expression1291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN111_tree = (Object)adaptor.create(LPAREN111);
                    adaptor.addChild(root_0, LPAREN111_tree);
                    }
                    pushFollow(FOLLOW_numeric_expression_in_numeric_primary_expression1293);
                    numeric_expression112=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression112.getTree());
                    RPAREN113=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numeric_primary_expression1295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN113_tree = (Object)adaptor.create(RPAREN113);
                    adaptor.addChild(root_0, RPAREN113_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "numeric_primary_expression"

    public static class signed_numeric_literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "signed_numeric_literal"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:196:1: signed_numeric_literal : ( PLUS | MINUS )? unsigned_numeric_literal ;
    public final WindowingParser.signed_numeric_literal_return signed_numeric_literal() throws RecognitionException {
        WindowingParser.signed_numeric_literal_return retval = new WindowingParser.signed_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set114=null;
        WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal115 = null;


        Object set114_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:196:24: ( ( PLUS | MINUS )? unsigned_numeric_literal )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:197:3: ( PLUS | MINUS )? unsigned_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:197:3: ( PLUS | MINUS )?
            int alt40=2;
            switch ( input.LA(1) ) {
                case PLUS:
                case MINUS:
                    {
                    alt40=1;
                    }
                    break;
            }

            switch (alt40) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:
                    {
                    set114=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set114));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1314);
            unsigned_numeric_literal115=unsigned_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unsigned_numeric_literal115.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "signed_numeric_literal"

    public static class unsigned_numeric_literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unsigned_numeric_literal"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:203:1: unsigned_numeric_literal : ( exact_numeric_literal | approximate_numeric_literal );
    public final WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal() throws RecognitionException {
        WindowingParser.unsigned_numeric_literal_return retval = new WindowingParser.unsigned_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal116 = null;

        WindowingParser.approximate_numeric_literal_return approximate_numeric_literal117 = null;



        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:203:26: ( exact_numeric_literal | approximate_numeric_literal )
            int alt41=2;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                switch ( input.LA(2) ) {
                case DOT:
                    {
                    switch ( input.LA(3) ) {
                    case NUMBER:
                        {
                        switch ( input.LA(4) ) {
                        case EOF:
                        case RPAREN:
                        case PLUS:
                        case MINUS:
                        case ASTERISK:
                        case SOLIDUS:
                            {
                            alt41=1;
                            }
                            break;
                        case 105:
                            {
                            alt41=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 41, 7, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 3, input);

                        throw nvae;
                    }

                    }
                    break;
                case EOF:
                case RPAREN:
                case PLUS:
                case MINUS:
                case ASTERISK:
                case SOLIDUS:
                    {
                    alt41=1;
                    }
                    break;
                case 105:
                    {
                    alt41=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }

                }
                break;
            case DOT:
                {
                switch ( input.LA(2) ) {
                case NUMBER:
                    {
                    switch ( input.LA(3) ) {
                    case EOF:
                    case RPAREN:
                    case PLUS:
                    case MINUS:
                    case ASTERISK:
                    case SOLIDUS:
                        {
                        alt41=1;
                        }
                        break;
                    case 105:
                        {
                        alt41=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 6, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:204:3: exact_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1327);
                    exact_numeric_literal116=exact_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal116.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:205:3: approximate_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1333);
                    approximate_numeric_literal117=approximate_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, approximate_numeric_literal117.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unsigned_numeric_literal"

    public static class approximate_numeric_literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "approximate_numeric_literal"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:208:1: approximate_numeric_literal : mantissa 'E' exponent ;
    public final WindowingParser.approximate_numeric_literal_return approximate_numeric_literal() throws RecognitionException {
        WindowingParser.approximate_numeric_literal_return retval = new WindowingParser.approximate_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal119=null;
        WindowingParser.mantissa_return mantissa118 = null;

        WindowingParser.exponent_return exponent120 = null;


        Object char_literal119_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:208:29: ( mantissa 'E' exponent )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:209:3: mantissa 'E' exponent
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mantissa_in_approximate_numeric_literal1344);
            mantissa118=mantissa();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mantissa118.getTree());
            char_literal119=(Token)match(input,105,FOLLOW_105_in_approximate_numeric_literal1346); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal119_tree = (Object)adaptor.create(char_literal119);
            adaptor.addChild(root_0, char_literal119_tree);
            }
            pushFollow(FOLLOW_exponent_in_approximate_numeric_literal1348);
            exponent120=exponent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exponent120.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "approximate_numeric_literal"

    public static class exponent_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exponent"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:212:1: exponent : ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER );
    public final WindowingParser.exponent_return exponent() throws RecognitionException {
        WindowingParser.exponent_return retval = new WindowingParser.exponent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS121=null;
        Token NUMBER122=null;
        Token MINUS123=null;
        Token NUMBER124=null;
        Token NUMBER125=null;

        Object PLUS121_tree=null;
        Object NUMBER122_tree=null;
        Object MINUS123_tree=null;
        Object NUMBER124_tree=null;
        Object NUMBER125_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:212:10: ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER )
            int alt42=3;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt42=1;
                }
                break;
            case MINUS:
                {
                alt42=2;
                }
                break;
            case NUMBER:
                {
                alt42=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:213:3: PLUS NUMBER
                    {
                    PLUS121=(Token)match(input,PLUS,FOLLOW_PLUS_in_exponent1359); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS121);

                    NUMBER122=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1361); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER122);



                    // AST REWRITE
                    // elements: NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 213:15: -> NUMBER
                    {
                        adaptor.addChild(root_0, stream_NUMBER.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:214:3: MINUS NUMBER
                    {
                    MINUS123=(Token)match(input,MINUS,FOLLOW_MINUS_in_exponent1371); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS123);

                    NUMBER124=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1373); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER124);



                    // AST REWRITE
                    // elements: NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 214:16: -> ^( UMINUS NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:214:19: ^( UMINUS NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UMINUS, "UMINUS"), root_1);

                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:215:3: NUMBER
                    {
                    NUMBER125=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1387); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER125);



                    // AST REWRITE
                    // elements: NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 215:10: -> NUMBER
                    {
                        adaptor.addChild(root_0, stream_NUMBER.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exponent"

    public static class mantissa_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mantissa"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:218:1: mantissa : exact_numeric_literal ;
    public final WindowingParser.mantissa_return mantissa() throws RecognitionException {
        WindowingParser.mantissa_return retval = new WindowingParser.mantissa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal126 = null;



        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:218:10: ( exact_numeric_literal )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:219:3: exact_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_exact_numeric_literal_in_mantissa1403);
            exact_numeric_literal126=exact_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal126.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mantissa"

    public static class exact_numeric_literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exact_numeric_literal"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:222:1: exact_numeric_literal : (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->);
    public final WindowingParser.exact_numeric_literal_return exact_numeric_literal() throws RecognitionException {
        WindowingParser.exact_numeric_literal_return retval = new WindowingParser.exact_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token n2=null;
        Token DOT127=null;
        Token DOT128=null;

        Object n1_tree=null;
        Object n2_tree=null;
        Object DOT127_tree=null;
        Object DOT128_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:222:23: (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->)
            int alt44=2;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt44=1;
                }
                break;
            case DOT:
                {
                alt44=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:224:3: n1= NUMBER ( DOT n2= NUMBER )?
                    {
                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1419); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(n1);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:224:13: ( DOT n2= NUMBER )?
                    int alt43=2;
                    switch ( input.LA(1) ) {
                        case DOT:
                            {
                            alt43=1;
                            }
                            break;
                    }

                    switch (alt43) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:224:14: DOT n2= NUMBER
                            {
                            DOT127=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1422); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT127);

                            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1426); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_NUMBER.add(n2);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 224:31: ->
                    {
                        adaptor.addChild(root_0, 
                        	      ( n2 != null ? adaptor.create(NUMERIC, (n1!=null?n1.getText():null) + '.' + (n2!=null?n2.getText():null)) :  adaptor.create(INTEGER, (n1!=null?n1.getText():null)) )
                              );

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:228:3: DOT n1= NUMBER
                    {
                    DOT128=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1447); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT128);

                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1451); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(n1);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 228:17: ->
                    {
                        adaptor.addChild(root_0,  adaptor.create(NUMERIC, '.' + (n1!=null?n1.getText():null)));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exact_numeric_literal"

    public static class identifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identifier"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:231:1: identifier : ID ;
    public final WindowingParser.identifier_return identifier() throws RecognitionException {
        WindowingParser.identifier_return retval = new WindowingParser.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID129=null;

        Object ID129_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:231:12: ( ID )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:232:3: ID
            {
            root_0 = (Object)adaptor.nil();

            ID129=(Token)match(input,ID,FOLLOW_ID_in_identifier1467); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID129_tree = (Object)adaptor.create(ID129);
            adaptor.addChild(root_0, ID129_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException rex) {
        throw rex;
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"

    // $ANTLR start synpred1_Windowing
    public final void synpred1_Windowing_fragment() throws RecognitionException {   
        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:9: ( PLUS | MINUS )
        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:
        {
        if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred1_Windowing

    // $ANTLR start synpred2_Windowing
    public final void synpred2_Windowing_fragment() throws RecognitionException {   
        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:31: ( ASTERISK | SOLIDUS )
        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:
        {
        if ( (input.LA(1)>=ASTERISK && input.LA(1)<=SOLIDUS) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred2_Windowing

    // Delegated rules

    public final boolean synpred1_Windowing() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Windowing_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Windowing() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Windowing_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_FROM_in_query147 = new BitSet(new long[]{0x0000000004E00000L});
    public static final BitSet FOLLOW_tableSpec_in_query149 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_query152 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_query155 = new BitSet(new long[]{0x0004000000100000L});
    public static final BitSet FOLLOW_WITH_in_query159 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_funclist_in_query161 = new BitSet(new long[]{0x0004000000100000L});
    public static final BitSet FOLLOW_select_in_query166 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_where_in_query169 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_outputClause_in_query174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hivetable_in_tableSpec212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tableSpec217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_tableSpec232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tableSpec246 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_tableSpec250 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_tableSpec252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tblfunc_in_tableSpec266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tblfunc279 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LPAREN_in_tblfunc281 = new BitSet(new long[]{0x0000000004E00000L});
    public static final BitSet FOLLOW_tableSpec_in_tblfunc283 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_COMMA_in_tblfunc286 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_tblfuncparam_in_tblfunc288 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RPAREN_in_tblfunc292 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_window_expression_in_tblfunc295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hivetable329 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LPAREN_in_hivetable331 = new BitSet(new long[]{0x000000000B200000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable334 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_COMMA_in_hivetable339 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable341 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RPAREN_in_hivetable345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namevalue368 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue372 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EQ_in_namevalue375 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby401 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_BY_in_orderby403 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby405 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_orderby408 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby410 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ID_in_ordercolumn431 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby467 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_BY_in_partitionby469 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_partitionby471 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby474 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_partitionby476 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_function_in_funclist498 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_funclist501 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_function_in_funclist503 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ID_in_function527 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LPAREN_in_function529 = new BitSet(new long[]{0x000000200B600000L});
    public static final BitSet FOLLOW_functionparam_in_function532 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_COMMA_in_function537 = new BitSet(new long[]{0x0000002008600000L});
    public static final BitSet FOLLOW_functionparam_in_function539 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RPAREN_in_function543 = new BitSet(new long[]{0x0000004400000000L});
    public static final BitSet FOLLOW_window_expression_in_function546 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_AS_in_function550 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_function554 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_LBRACKET_in_function557 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_function561 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_function563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionparam0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tblfuncparam636 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_STRING_in_tblfuncparam640 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EQ_in_tblfuncparam643 = new BitSet(new long[]{0x0000002008600000L});
    public static final BitSet FOLLOW_functionparam_in_tblfuncparam647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_expression669 = new BitSet(new long[]{0x0000808000000000L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression694 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression696 = new BitSet(new long[]{0x0000242000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression700 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_AND_in_window_range_expression702 = new BitSet(new long[]{0x0000242000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary729 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary756 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary771 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression803 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression805 = new BitSet(new long[]{0x0000240000400000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression809 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_AND_in_window_value_expression811 = new BitSet(new long[]{0x0000240000400000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary838 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary865 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary880 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary882 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select918 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_selectColumn_in_select920 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_select923 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_selectColumn_in_select925 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn947 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn949 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_selectColumn951 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selectColumn954 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_selectColumn958 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selectColumn960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selectColumn986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where1006 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_outputClause1027 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_PATH_in_outputClause1029 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause1031 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause1035 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_outputSerDe_in_outputClause1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERDE_in_outputSerDe1064 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputSerDe1068 = new BitSet(new long[]{0x0300000000100000L});
    public static final BitSet FOLLOW_outputSerDePropeties_in_outputSerDe1072 = new BitSet(new long[]{0x0300000000100000L});
    public static final BitSet FOLLOW_outputFormatOrWriter_in_outputSerDe1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_outputSerDePropeties1103 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1105 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LPAREN_in_outputSerDePropeties1107 = new BitSet(new long[]{0x000000000B200000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1110 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_COMMA_in_outputSerDePropeties1115 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1117 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RPAREN_in_outputSerDePropeties1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORDWRITER_in_outputFormatOrWriter1147 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAT_in_outputFormatOrWriter1163 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_expression_in_value_expression1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_value_expression1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_numeric_expression1201 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_PLUS_in_numeric_expression1214 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_MINUS_in_numeric_expression1219 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_term_in_numeric_expression1223 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1241 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_ASTERISK_in_term1254 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_SOLIDUS_in_term1259 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1263 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_identifier_in_numeric_primary_expression1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signed_numeric_literal_in_numeric_primary_expression1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_primary_expression1291 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_numeric_expression_in_numeric_primary_expression1293 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_primary_expression1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_signed_numeric_literal1307 = new BitSet(new long[]{0x4C00002000000000L});
    public static final BitSet FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mantissa_in_approximate_numeric_literal1344 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_approximate_numeric_literal1346 = new BitSet(new long[]{0x0C00002000000000L});
    public static final BitSet FOLLOW_exponent_in_approximate_numeric_literal1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_exponent1359 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_exponent1371 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_mantissa1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1419 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1422 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1447 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1_Windowing1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred2_Windowing1244 = new BitSet(new long[]{0x0000000000000002L});

}