// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/sap/hadoop/windowing/parser/Windowing.g 2012-03-02 15:01:04

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "TBLFUNCTION", "FROM", "WITH", "ID", "GROOVYEXPRESSION", "LPAREN", "RPAREN", "COMMA", "TABLEINPUT", "STRING", "EQ", "ORDER", "BY", "ASC", "DESC", "PARTITION", "AS", "LBRACKET", "RBRACKET", "NUMBER", "OVER", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "RANGE", "LESS", "MORE", "SELECT", "WHERE", "INTO", "PATH", "SERDE", "SERDEPROPERTIES", "RECORDWRITER", "FORMAT", "PLUS", "MINUS", "ASTERISK", "SOLIDUS", "DOT", "QUOTE", "COLON", "SEMICOLON", "GE", "GT", "LBRACE", "LE", "LT", "NE", "RBRACE", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "B", "I", "N", "P", "U", "D", "Y", "G", "V", "NOT", "OR", "X", "XOR", "GroovyEscapeSequence", "EscapeSequence", "WS", "J", "K", "Q", "Z", "'E'"
    };
    public static final int EOF=-1;
    public static final int T__104=104;
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
    public static final int FROM=18;
    public static final int WITH=19;
    public static final int ID=20;
    public static final int GROOVYEXPRESSION=21;
    public static final int LPAREN=22;
    public static final int RPAREN=23;
    public static final int COMMA=24;
    public static final int TABLEINPUT=25;
    public static final int STRING=26;
    public static final int EQ=27;
    public static final int ORDER=28;
    public static final int BY=29;
    public static final int ASC=30;
    public static final int DESC=31;
    public static final int PARTITION=32;
    public static final int AS=33;
    public static final int LBRACKET=34;
    public static final int RBRACKET=35;
    public static final int NUMBER=36;
    public static final int OVER=37;
    public static final int ROWS=38;
    public static final int BETWEEN=39;
    public static final int AND=40;
    public static final int UNBOUNDED=41;
    public static final int PRECEDING=42;
    public static final int FOLLOWING=43;
    public static final int CURRENT=44;
    public static final int ROW=45;
    public static final int RANGE=46;
    public static final int LESS=47;
    public static final int MORE=48;
    public static final int SELECT=49;
    public static final int WHERE=50;
    public static final int INTO=51;
    public static final int PATH=52;
    public static final int SERDE=53;
    public static final int SERDEPROPERTIES=54;
    public static final int RECORDWRITER=55;
    public static final int FORMAT=56;
    public static final int PLUS=57;
    public static final int MINUS=58;
    public static final int ASTERISK=59;
    public static final int SOLIDUS=60;
    public static final int DOT=61;
    public static final int QUOTE=62;
    public static final int COLON=63;
    public static final int SEMICOLON=64;
    public static final int GE=65;
    public static final int GT=66;
    public static final int LBRACE=67;
    public static final int LE=68;
    public static final int LT=69;
    public static final int NE=70;
    public static final int RBRACE=71;
    public static final int S=72;
    public static final int E=73;
    public static final int L=74;
    public static final int C=75;
    public static final int T=76;
    public static final int F=77;
    public static final int R=78;
    public static final int O=79;
    public static final int M=80;
    public static final int W=81;
    public static final int H=82;
    public static final int A=83;
    public static final int B=84;
    public static final int I=85;
    public static final int N=86;
    public static final int P=87;
    public static final int U=88;
    public static final int D=89;
    public static final int Y=90;
    public static final int G=91;
    public static final int V=92;
    public static final int NOT=93;
    public static final int OR=94;
    public static final int X=95;
    public static final int XOR=96;
    public static final int GroovyEscapeSequence=97;
    public static final int EscapeSequence=98;
    public static final int WS=99;
    public static final int J=100;
    public static final int K=101;
    public static final int Q=102;
    public static final int Z=103;

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
    public String getGrammarFileName() { return "com/sap/hadoop/windowing/parser/Windowing.g"; }


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
    // com/sap/hadoop/windowing/parser/Windowing.g:58:1: query : FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec select ( funclist )? ( where )? ( outputClause )? ) ;
    public final WindowingParser.query_return query() throws RecognitionException {
        WindowingParser.query_return retval = new WindowingParser.query_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FROM1=null;
        Token WITH3=null;
        Token EOF8=null;
        WindowingParser.tableSpec_return tableSpec2 = null;

        WindowingParser.funclist_return funclist4 = null;

        WindowingParser.select_return select5 = null;

        WindowingParser.where_return where6 = null;

        WindowingParser.outputClause_return outputClause7 = null;


        Object FROM1_tree=null;
        Object WITH3_tree=null;
        Object EOF8_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_funclist=new RewriteRuleSubtreeStream(adaptor,"rule funclist");
        RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        RewriteRuleSubtreeStream stream_where=new RewriteRuleSubtreeStream(adaptor,"rule where");
        RewriteRuleSubtreeStream stream_outputClause=new RewriteRuleSubtreeStream(adaptor,"rule outputClause");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:58:7: ( FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec select ( funclist )? ( where )? ( outputClause )? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:59:2: FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF
            {
            FROM1=(Token)match(input,FROM,FOLLOW_FROM_in_query142); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM1);

            pushFollow(FOLLOW_tableSpec_in_query144);
            tableSpec2=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec2.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:60:2: ( WITH funclist )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:60:3: WITH funclist
                    {
                    WITH3=(Token)match(input,WITH,FOLLOW_WITH_in_query148); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WITH.add(WITH3);

                    pushFollow(FOLLOW_funclist_in_query150);
                    funclist4=funclist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_funclist.add(funclist4.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_select_in_query155);
            select5=select();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select.add(select5.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:62:2: ( where )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:62:2: where
                    {
                    pushFollow(FOLLOW_where_in_query158);
                    where6=where();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_where.add(where6.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:63:2: ( outputClause )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:63:2: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_query163);
                    outputClause7=outputClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputClause.add(outputClause7.getTree());

                    }
                    break;

            }

            EOF8=(Token)match(input,EOF,FOLLOW_EOF_in_query168); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF8);



            // AST REWRITE
            // elements: outputClause, tableSpec, where, funclist, select
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 64:6: -> ^( QUERY tableSpec select ( funclist )? ( where )? ( outputClause )? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:64:9: ^( QUERY tableSpec select ( funclist )? ( where )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                adaptor.addChild(root_1, stream_select.nextTree());
                // com/sap/hadoop/windowing/parser/Windowing.g:64:34: ( funclist )?
                if ( stream_funclist.hasNext() ) {
                    adaptor.addChild(root_1, stream_funclist.nextTree());

                }
                stream_funclist.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:64:44: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.nextTree());

                }
                stream_where.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:64:51: ( outputClause )?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:67:1: tableSpec : ( hivetable | ID p= partitionby o= orderby -> ^( TABLEINPUT ID $p $o) | h= GROOVYEXPRESSION p= partitionby o= orderby -> ^( TABLEINPUT $h $p $o) | LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN -> ^( TABLEINPUT $h $p $o) | tblfunc );
    public final WindowingParser.tableSpec_return tableSpec() throws RecognitionException {
        WindowingParser.tableSpec_return retval = new WindowingParser.tableSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token h=null;
        Token ID10=null;
        Token LPAREN11=null;
        Token RPAREN12=null;
        WindowingParser.partitionby_return p = null;

        WindowingParser.orderby_return o = null;

        WindowingParser.hivetable_return hivetable9 = null;

        WindowingParser.tblfunc_return tblfunc13 = null;


        Object h_tree=null;
        Object ID10_tree=null;
        Object LPAREN11_tree=null;
        Object RPAREN12_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:67:11: ( hivetable | ID p= partitionby o= orderby -> ^( TABLEINPUT ID $p $o) | h= GROOVYEXPRESSION p= partitionby o= orderby -> ^( TABLEINPUT $h $p $o) | LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN -> ^( TABLEINPUT $h $p $o) | tblfunc )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:68:2: hivetable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hivetable_in_tableSpec197);
                    hivetable9=hivetable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hivetable9.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:69:2: ID p= partitionby o= orderby
                    {
                    ID10=(Token)match(input,ID,FOLLOW_ID_in_tableSpec202); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID10);

                    pushFollow(FOLLOW_partitionby_in_tableSpec206);
                    p=partitionby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_tableSpec210);
                    o=orderby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderby.add(o.getTree());


                    // AST REWRITE
                    // elements: p, o, ID
                    // token labels: 
                    // rule labels: retval, p, o
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 69:29: -> ^( TABLEINPUT ID $p $o)
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:69:32: ^( TABLEINPUT ID $p $o)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_p.nextTree());
                        adaptor.addChild(root_1, stream_o.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:70:2: h= GROOVYEXPRESSION p= partitionby o= orderby
                    {
                    h=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_tableSpec231); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(h);

                    pushFollow(FOLLOW_partitionby_in_tableSpec235);
                    p=partitionby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_tableSpec239);
                    o=orderby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderby.add(o.getTree());


                    // AST REWRITE
                    // elements: o, p, h
                    // token labels: h
                    // rule labels: retval, p, o
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_h=new RewriteRuleTokenStream(adaptor,"token h",h);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 70:45: -> ^( TABLEINPUT $h $p $o)
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:70:48: ^( TABLEINPUT $h $p $o)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                        adaptor.addChild(root_1, stream_h.nextNode());
                        adaptor.addChild(root_1, stream_p.nextTree());
                        adaptor.addChild(root_1, stream_o.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:71:2: LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN
                    {
                    LPAREN11=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tableSpec259); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN11);

                    h=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_tableSpec263); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(h);

                    pushFollow(FOLLOW_partitionby_in_tableSpec267);
                    p=partitionby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_tableSpec271);
                    o=orderby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderby.add(o.getTree());
                    RPAREN12=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tableSpec273); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN12);



                    // AST REWRITE
                    // elements: o, h, p
                    // token labels: h
                    // rule labels: retval, p, o
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_h=new RewriteRuleTokenStream(adaptor,"token h",h);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 71:59: -> ^( TABLEINPUT $h $p $o)
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:71:62: ^( TABLEINPUT $h $p $o)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                        adaptor.addChild(root_1, stream_h.nextNode());
                        adaptor.addChild(root_1, stream_p.nextTree());
                        adaptor.addChild(root_1, stream_o.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:72:2: tblfunc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tblfunc_in_tableSpec294);
                    tblfunc13=tblfunc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tblfunc13.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:75:1: tblfunc : name= ID LPAREN tableSpec ( window_expression )? ( COMMA functionparam )* RPAREN -> ^( TBLFUNCTION $name tableSpec ( functionparam )* ( window_expression )? ) ;
    public final WindowingParser.tblfunc_return tblfunc() throws RecognitionException {
        WindowingParser.tblfunc_return retval = new WindowingParser.tblfunc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token LPAREN14=null;
        Token COMMA17=null;
        Token RPAREN19=null;
        WindowingParser.tableSpec_return tableSpec15 = null;

        WindowingParser.window_expression_return window_expression16 = null;

        WindowingParser.functionparam_return functionparam18 = null;


        Object name_tree=null;
        Object LPAREN14_tree=null;
        Object COMMA17_tree=null;
        Object RPAREN19_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_window_expression=new RewriteRuleSubtreeStream(adaptor,"rule window_expression");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        RewriteRuleSubtreeStream stream_functionparam=new RewriteRuleSubtreeStream(adaptor,"rule functionparam");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:75:9: (name= ID LPAREN tableSpec ( window_expression )? ( COMMA functionparam )* RPAREN -> ^( TBLFUNCTION $name tableSpec ( functionparam )* ( window_expression )? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:76:3: name= ID LPAREN tableSpec ( window_expression )? ( COMMA functionparam )* RPAREN
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_tblfunc307); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN14=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tblfunc309); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN14);

            pushFollow(FOLLOW_tableSpec_in_tblfunc311);
            tableSpec15=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec15.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:76:28: ( window_expression )?
            int alt5=2;
            switch ( input.LA(1) ) {
                case OVER:
                    {
                    alt5=1;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:76:29: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_tblfunc314);
                    window_expression16=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression16.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:76:49: ( COMMA functionparam )*
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:76:50: COMMA functionparam
            	    {
            	    COMMA17=(Token)match(input,COMMA,FOLLOW_COMMA_in_tblfunc319); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA17);

            	    pushFollow(FOLLOW_functionparam_in_tblfunc321);
            	    functionparam18=functionparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_functionparam.add(functionparam18.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            RPAREN19=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tblfunc325); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN19);



            // AST REWRITE
            // elements: functionparam, name, window_expression, tableSpec
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
            // 77:5: -> ^( TBLFUNCTION $name tableSpec ( functionparam )* ( window_expression )? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:77:8: ^( TBLFUNCTION $name tableSpec ( functionparam )* ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TBLFUNCTION, "TBLFUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                // com/sap/hadoop/windowing/parser/Windowing.g:77:38: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.nextTree());

                }
                stream_functionparam.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:77:53: ( window_expression )?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:80:1: hivetable : TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby -> ^( TABLEINPUT ( namevalue )* $p $o) ;
    public final WindowingParser.hivetable_return hivetable() throws RecognitionException {
        WindowingParser.hivetable_return retval = new WindowingParser.hivetable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TABLEINPUT20=null;
        Token LPAREN21=null;
        Token COMMA23=null;
        Token RPAREN25=null;
        WindowingParser.partitionby_return p = null;

        WindowingParser.orderby_return o = null;

        WindowingParser.namevalue_return namevalue22 = null;

        WindowingParser.namevalue_return namevalue24 = null;


        Object TABLEINPUT20_tree=null;
        Object LPAREN21_tree=null;
        Object COMMA23_tree=null;
        Object RPAREN25_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_TABLEINPUT=new RewriteRuleTokenStream(adaptor,"token TABLEINPUT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:80:11: ( TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby -> ^( TABLEINPUT ( namevalue )* $p $o) )
            // com/sap/hadoop/windowing/parser/Windowing.g:81:2: TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby
            {
            TABLEINPUT20=(Token)match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hivetable357); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TABLEINPUT.add(TABLEINPUT20);

            LPAREN21=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_hivetable359); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN21);

            // com/sap/hadoop/windowing/parser/Windowing.g:81:20: ( namevalue )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:81:21: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hivetable362);
                    namevalue22=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue22.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:81:33: ( COMMA namevalue )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:81:34: COMMA namevalue
            	    {
            	    COMMA23=(Token)match(input,COMMA,FOLLOW_COMMA_in_hivetable367); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA23);

            	    pushFollow(FOLLOW_namevalue_in_hivetable369);
            	    namevalue24=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue24.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            RPAREN25=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_hivetable373); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN25);

            pushFollow(FOLLOW_partitionby_in_hivetable378);
            p=partitionby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionby.add(p.getTree());
            pushFollow(FOLLOW_orderby_in_hivetable382);
            o=orderby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orderby.add(o.getTree());


            // AST REWRITE
            // elements: TABLEINPUT, namevalue, o, p
            // token labels: 
            // rule labels: retval, p, o
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
            RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"rule o",o!=null?o.tree:null);

            root_0 = (Object)adaptor.nil();
            // 81:84: -> ^( TABLEINPUT ( namevalue )* $p $o)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:81:87: ^( TABLEINPUT ( namevalue )* $p $o)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_TABLEINPUT.nextNode(), root_1);

                // com/sap/hadoop/windowing/parser/Windowing.g:81:100: ( namevalue )*
                while ( stream_namevalue.hasNext() ) {
                    adaptor.addChild(root_1, stream_namevalue.nextTree());

                }
                stream_namevalue.reset();
                adaptor.addChild(root_1, stream_p.nextTree());
                adaptor.addChild(root_1, stream_o.nextTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:84:1: namevalue : (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) ;
    public final WindowingParser.namevalue_return namevalue() throws RecognitionException {
        WindowingParser.namevalue_return retval = new WindowingParser.namevalue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token v=null;
        Token EQ26=null;

        Object i_tree=null;
        Object v_tree=null;
        Object EQ26_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:84:11: ( (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) )
            // com/sap/hadoop/windowing/parser/Windowing.g:85:2: (i= ID | i= STRING ) EQ v= STRING
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:85:2: (i= ID | i= STRING )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:85:3: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_namevalue410); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:85:8: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue414); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ26=(Token)match(input,EQ,FOLLOW_EQ_in_namevalue417); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ26);

            v=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue421); if (state.failed) return retval; 
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
            // 85:30: -> ^( PARAM $i $v)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:85:33: ^( PARAM $i $v)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:88:1: orderby : ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
    public final WindowingParser.orderby_return orderby() throws RecognitionException {
        WindowingParser.orderby_return retval = new WindowingParser.orderby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER27=null;
        Token BY28=null;
        Token COMMA30=null;
        WindowingParser.ordercolumn_return ordercolumn29 = null;

        WindowingParser.ordercolumn_return ordercolumn31 = null;


        Object ORDER27_tree=null;
        Object BY28_tree=null;
        Object COMMA30_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_ordercolumn=new RewriteRuleSubtreeStream(adaptor,"rule ordercolumn");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:88:9: ( ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:89:2: ORDER BY ordercolumn ( COMMA ordercolumn )*
            {
            ORDER27=(Token)match(input,ORDER,FOLLOW_ORDER_in_orderby443); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ORDER.add(ORDER27);

            BY28=(Token)match(input,BY,FOLLOW_BY_in_orderby445); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY28);

            pushFollow(FOLLOW_ordercolumn_in_orderby447);
            ordercolumn29=ordercolumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn29.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:89:23: ( COMMA ordercolumn )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    switch ( input.LA(2) ) {
                    case ID:
                        {
                        alt10=1;
                        }
                        break;

                    }

                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:89:24: COMMA ordercolumn
            	    {
            	    COMMA30=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderby450); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA30);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby452);
            	    ordercolumn31=ordercolumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn31.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);



            // AST REWRITE
            // elements: ORDER, ordercolumn
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 89:44: -> ^( ORDER ( ordercolumn )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:89:47: ^( ORDER ( ordercolumn )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:92:1: ordercolumn : ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) ;
    public final WindowingParser.ordercolumn_return ordercolumn() throws RecognitionException {
        WindowingParser.ordercolumn_return retval = new WindowingParser.ordercolumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token o=null;
        Token ID32=null;

        Object o_tree=null;
        Object ID32_tree=null;
        RewriteRuleTokenStream stream_ASC=new RewriteRuleTokenStream(adaptor,"token ASC");
        RewriteRuleTokenStream stream_DESC=new RewriteRuleTokenStream(adaptor,"token DESC");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:92:13: ( ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:93:2: ID (o= ASC | o= DESC )?
            {
            ID32=(Token)match(input,ID,FOLLOW_ID_in_ordercolumn473); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID32);

            // com/sap/hadoop/windowing/parser/Windowing.g:93:5: (o= ASC | o= DESC )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:93:6: o= ASC
                    {
                    o=(Token)match(input,ASC,FOLLOW_ASC_in_ordercolumn478); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:93:14: o= DESC
                    {
                    o=(Token)match(input,DESC,FOLLOW_DESC_in_ordercolumn484); if (state.failed) return retval; 
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
            // 93:23: -> ^( ORDERCOLUMN ID ( $o)? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:93:26: ^( ORDERCOLUMN ID ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:93:43: ( $o)?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:96:1: partitionby : PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) ;
    public final WindowingParser.partitionby_return partitionby() throws RecognitionException {
        WindowingParser.partitionby_return retval = new WindowingParser.partitionby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PARTITION33=null;
        Token BY34=null;
        Token ID35=null;
        Token COMMA36=null;
        Token ID37=null;

        Object PARTITION33_tree=null;
        Object BY34_tree=null;
        Object ID35_tree=null;
        Object COMMA36_tree=null;
        Object ID37_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:96:13: ( PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:97:2: PARTITION BY ID ( COMMA ID )*
            {
            PARTITION33=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_partitionby509); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARTITION.add(PARTITION33);

            BY34=(Token)match(input,BY,FOLLOW_BY_in_partitionby511); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY34);

            ID35=(Token)match(input,ID,FOLLOW_ID_in_partitionby513); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID35);

            // com/sap/hadoop/windowing/parser/Windowing.g:97:18: ( COMMA ID )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:97:19: COMMA ID
            	    {
            	    COMMA36=(Token)match(input,COMMA,FOLLOW_COMMA_in_partitionby516); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA36);

            	    ID37=(Token)match(input,ID,FOLLOW_ID_in_partitionby518); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID37);


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
            // 97:30: -> ^( PARTITION ( ID )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:97:33: ^( PARTITION ( ID )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:100:1: funclist : function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) ;
    public final WindowingParser.funclist_return funclist() throws RecognitionException {
        WindowingParser.funclist_return retval = new WindowingParser.funclist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA39=null;
        WindowingParser.function_return function38 = null;

        WindowingParser.function_return function40 = null;


        Object COMMA39_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:100:10: ( function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:101:2: function ( COMMA function )*
            {
            pushFollow(FOLLOW_function_in_funclist540);
            function38=function();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function.add(function38.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:101:11: ( COMMA function )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:101:12: COMMA function
            	    {
            	    COMMA39=(Token)match(input,COMMA,FOLLOW_COMMA_in_funclist543); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA39);

            	    pushFollow(FOLLOW_function_in_funclist545);
            	    function40=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function.add(function40.getTree());

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
            // 101:29: -> ^( FUNCTIONS ( function )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:101:32: ^( FUNCTIONS ( function )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:104:1: function : name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) ;
    public final WindowingParser.function_return function() throws RecognitionException {
        WindowingParser.function_return retval = new WindowingParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token alias=null;
        Token typeNm=null;
        Token LPAREN41=null;
        Token COMMA43=null;
        Token RPAREN45=null;
        Token AS47=null;
        Token LBRACKET48=null;
        Token RBRACKET49=null;
        WindowingParser.functionparam_return functionparam42 = null;

        WindowingParser.functionparam_return functionparam44 = null;

        WindowingParser.window_expression_return window_expression46 = null;


        Object name_tree=null;
        Object alias_tree=null;
        Object typeNm_tree=null;
        Object LPAREN41_tree=null;
        Object COMMA43_tree=null;
        Object RPAREN45_tree=null;
        Object AS47_tree=null;
        Object LBRACKET48_tree=null;
        Object RBRACKET49_tree=null;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:104:10: (name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:105:2: name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )?
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_function569); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN41=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function571); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN41);

            // com/sap/hadoop/windowing/parser/Windowing.g:105:17: ( functionparam )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:105:18: functionparam
                    {
                    pushFollow(FOLLOW_functionparam_in_function574);
                    functionparam42=functionparam();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionparam.add(functionparam42.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:105:34: ( COMMA functionparam )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:105:35: COMMA functionparam
            	    {
            	    COMMA43=(Token)match(input,COMMA,FOLLOW_COMMA_in_function579); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA43);

            	    pushFollow(FOLLOW_functionparam_in_function581);
            	    functionparam44=functionparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_functionparam.add(functionparam44.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            RPAREN45=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function585); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN45);

            // com/sap/hadoop/windowing/parser/Windowing.g:105:64: ( window_expression )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:105:65: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function588);
                    window_expression46=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression46.getTree());

                    }
                    break;

            }

            AS47=(Token)match(input,AS,FOLLOW_AS_in_function592); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AS.add(AS47);

            alias=(Token)match(input,ID,FOLLOW_ID_in_function596); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(alias);

            // com/sap/hadoop/windowing/parser/Windowing.g:105:97: ( LBRACKET typeNm= ID RBRACKET )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:105:98: LBRACKET typeNm= ID RBRACKET
                    {
                    LBRACKET48=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_function599); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET48);

                    typeNm=(Token)match(input,ID,FOLLOW_ID_in_function603); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(typeNm);

                    RBRACKET49=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_function605); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET49);


                    }
                    break;

            }



            // AST REWRITE
            // elements: name, functionparam, window_expression, alias, typeNm
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
            // 105:128: -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:106:7: ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_alias.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:106:31: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.nextTree());

                }
                stream_functionparam.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:106:46: ( ^( TYPENAME $typeNm) )?
                if ( stream_typeNm.hasNext() ) {
                    // com/sap/hadoop/windowing/parser/Windowing.g:106:46: ^( TYPENAME $typeNm)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                    adaptor.addChild(root_2, stream_typeNm.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_typeNm.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:106:67: ( window_expression )?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:109:1: functionparam : ( GROOVYEXPRESSION | STRING | ID | NUMBER );
    public final WindowingParser.functionparam_return functionparam() throws RecognitionException {
        WindowingParser.functionparam_return retval = new WindowingParser.functionparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set50=null;

        Object set50_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:109:16: ( GROOVYEXPRESSION | STRING | ID | NUMBER )
            // com/sap/hadoop/windowing/parser/Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set50=(Token)input.LT(1);
            if ( (input.LA(1)>=ID && input.LA(1)<=GROOVYEXPRESSION)||input.LA(1)==STRING||input.LA(1)==NUMBER ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set50));
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

    public static class window_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "window_expression"
    // com/sap/hadoop/windowing/parser/Windowing.g:113:1: window_expression : OVER ( window_range_expression | window_value_expression ) ;
    public final WindowingParser.window_expression_return window_expression() throws RecognitionException {
        WindowingParser.window_expression_return retval = new WindowingParser.window_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OVER51=null;
        WindowingParser.window_range_expression_return window_range_expression52 = null;

        WindowingParser.window_value_expression_return window_value_expression53 = null;


        Object OVER51_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:113:19: ( OVER ( window_range_expression | window_value_expression ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:114:2: OVER ( window_range_expression | window_value_expression )
            {
            root_0 = (Object)adaptor.nil();

            OVER51=(Token)match(input,OVER,FOLLOW_OVER_in_window_expression674); if (state.failed) return retval;
            // com/sap/hadoop/windowing/parser/Windowing.g:115:2: ( window_range_expression | window_value_expression )
            int alt18=2;
            switch ( input.LA(1) ) {
            case ROWS:
                {
                alt18=1;
                }
                break;
            case RANGE:
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:115:3: window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression680);
                    window_range_expression52=window_range_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_range_expression52.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:116:2: window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression685);
                    window_value_expression53=window_value_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_value_expression53.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:120:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final WindowingParser.window_range_expression_return window_range_expression() throws RecognitionException {
        WindowingParser.window_range_expression_return retval = new WindowingParser.window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS54=null;
        Token BETWEEN55=null;
        Token AND56=null;
        WindowingParser.rowsboundary_return s = null;

        WindowingParser.rowsboundary_return e = null;


        Object ROWS54_tree=null;
        Object BETWEEN55_tree=null;
        Object AND56_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:120:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // com/sap/hadoop/windowing/parser/Windowing.g:121:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS54=(Token)match(input,ROWS,FOLLOW_ROWS_in_window_range_expression699); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ROWS.add(ROWS54);

            BETWEEN55=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression701); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN55);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression705);
            s=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(s.getTree());
            AND56=(Token)match(input,AND,FOLLOW_AND_in_window_range_expression707); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND56);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression711);
            e=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(e.getTree());


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
            // 121:49: -> ^( WINDOWRANGE $s $e)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:121:52: ^( WINDOWRANGE $s $e)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:124:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );
    public final WindowingParser.rowsboundary_return rowsboundary() throws RecognitionException {
        WindowingParser.rowsboundary_return retval = new WindowingParser.rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED57=null;
        Token CURRENT58=null;
        Token ROW59=null;
        Token NUMBER60=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED57_tree=null;
        Object CURRENT58_tree=null;
        Object ROW59_tree=null;
        Object NUMBER60_tree=null;
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:124:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt21=1;
                }
                break;
            case CURRENT:
                {
                alt21=2;
                }
                break;
            case NUMBER:
                {
                alt21=3;
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:125:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED57=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary734); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED57);

                    // com/sap/hadoop/windowing/parser/Windowing.g:125:13: (r= PRECEDING | r= FOLLOWING )
                    int alt19=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt19=1;
                        }
                        break;
                    case FOLLOWING:
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:125:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary739); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:125:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary743); if (state.failed) return retval; 
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
                    // 125:40: -> ^( $r UNBOUNDED )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:125:43: ^( $r UNBOUNDED )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:126:3: CURRENT ROW
                    {
                    CURRENT58=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary761); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT58);

                    ROW59=(Token)match(input,ROW,FOLLOW_ROW_in_rowsboundary763); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW59);



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
                    // 126:16: -> ^( CURRENT )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:126:19: ^( CURRENT )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:127:3: NUMBER (d= PRECEDING | d= FOLLOWING )
                    {
                    NUMBER60=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary776); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER60);

                    // com/sap/hadoop/windowing/parser/Windowing.g:127:10: (d= PRECEDING | d= FOLLOWING )
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:127:11: d= PRECEDING
                            {
                            d=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary781); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:127:25: d= FOLLOWING
                            {
                            d=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary787); if (state.failed) return retval; 
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
                    // 127:39: -> ^( $d NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:127:42: ^( $d NUMBER )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:130:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final WindowingParser.window_value_expression_return window_value_expression() throws RecognitionException {
        WindowingParser.window_value_expression_return retval = new WindowingParser.window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE61=null;
        Token BETWEEN62=null;
        Token AND63=null;
        WindowingParser.valuesboundary_return s = null;

        WindowingParser.valuesboundary_return e = null;


        Object RANGE61_tree=null;
        Object BETWEEN62_tree=null;
        Object AND63_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:130:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // com/sap/hadoop/windowing/parser/Windowing.g:131:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE61=(Token)match(input,RANGE,FOLLOW_RANGE_in_window_value_expression808); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE61);

            BETWEEN62=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression810); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN62);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression814);
            s=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(s.getTree());
            AND63=(Token)match(input,AND,FOLLOW_AND_in_window_value_expression816); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND63);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression820);
            e=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(e.getTree());


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
            // 131:54: -> ^( WINDOWVALUES $s $e)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:131:57: ^( WINDOWVALUES $s $e)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:134:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );
    public final WindowingParser.valuesboundary_return valuesboundary() throws RecognitionException {
        WindowingParser.valuesboundary_return retval = new WindowingParser.valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED64=null;
        Token CURRENT65=null;
        Token ROW66=null;
        Token GROOVYEXPRESSION67=null;
        Token NUMBER68=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED64_tree=null;
        Object CURRENT65_tree=null;
        Object ROW66_tree=null;
        Object GROOVYEXPRESSION67_tree=null;
        Object NUMBER68_tree=null;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:134:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt24=1;
                }
                break;
            case CURRENT:
                {
                alt24=2;
                }
                break;
            case GROOVYEXPRESSION:
                {
                alt24=3;
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:135:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED64=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary843); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED64);

                    // com/sap/hadoop/windowing/parser/Windowing.g:135:13: (r= PRECEDING | r= FOLLOWING )
                    int alt22=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt22=1;
                        }
                        break;
                    case FOLLOWING:
                        {
                        alt22=2;
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:135:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary848); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:135:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary852); if (state.failed) return retval; 
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
                    // 135:40: -> ^( $r UNBOUNDED )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:135:43: ^( $r UNBOUNDED )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:136:3: CURRENT ROW
                    {
                    CURRENT65=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary870); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT65);

                    ROW66=(Token)match(input,ROW,FOLLOW_ROW_in_valuesboundary872); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW66);



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
                    // 136:16: -> ^( CURRENT )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:136:19: ^( CURRENT )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:137:3: GROOVYEXPRESSION NUMBER (d= LESS | d= MORE )
                    {
                    GROOVYEXPRESSION67=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary885); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION67);

                    NUMBER68=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary887); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER68);

                    // com/sap/hadoop/windowing/parser/Windowing.g:137:27: (d= LESS | d= MORE )
                    int alt23=2;
                    switch ( input.LA(1) ) {
                    case LESS:
                        {
                        alt23=1;
                        }
                        break;
                    case MORE:
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:137:28: d= LESS
                            {
                            d=(Token)match(input,LESS,FOLLOW_LESS_in_valuesboundary892); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:137:37: d= MORE
                            {
                            d=(Token)match(input,MORE,FOLLOW_MORE_in_valuesboundary898); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MORE.add(d);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: d, GROOVYEXPRESSION, NUMBER
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
                    // 137:46: -> ^( $d GROOVYEXPRESSION NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:137:49: ^( $d GROOVYEXPRESSION NUMBER )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:140:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final WindowingParser.select_return select() throws RecognitionException {
        WindowingParser.select_return retval = new WindowingParser.select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT69=null;
        Token COMMA71=null;
        WindowingParser.selectColumn_return selectColumn70 = null;

        WindowingParser.selectColumn_return selectColumn72 = null;


        Object SELECT69_tree=null;
        Object COMMA71_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:140:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:141:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT69=(Token)match(input,SELECT,FOLLOW_SELECT_in_select923); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT69);

            pushFollow(FOLLOW_selectColumn_in_select925);
            selectColumn70=selectColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn70.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:141:23: ( COMMA selectColumn )*
            loop25:
            do {
                int alt25=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt25=1;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:141:24: COMMA selectColumn
            	    {
            	    COMMA71=(Token)match(input,COMMA,FOLLOW_COMMA_in_select928); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA71);

            	    pushFollow(FOLLOW_selectColumn_in_select930);
            	    selectColumn72=selectColumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn72.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);



            // AST REWRITE
            // elements: SELECT, selectColumn
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 141:46: -> ^( SELECT ( selectColumn )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:141:49: ^( SELECT ( selectColumn )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:144:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= typeName RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );
    public final WindowingParser.selectColumn_return selectColumn() throws RecognitionException {
        WindowingParser.selectColumn_return retval = new WindowingParser.selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token GROOVYEXPRESSION73=null;
        Token AS74=null;
        Token ID75=null;
        Token LBRACKET76=null;
        Token RBRACKET77=null;
        Token ID78=null;
        WindowingParser.typeName_return typeNm = null;


        Object GROOVYEXPRESSION73_tree=null;
        Object AS74_tree=null;
        Object ID75_tree=null;
        Object LBRACKET76_tree=null;
        Object RBRACKET77_tree=null;
        Object ID78_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:144:13: ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= typeName RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) )
            int alt27=2;
            switch ( input.LA(1) ) {
            case GROOVYEXPRESSION:
                {
                alt27=1;
                }
                break;
            case ID:
                {
                alt27=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:145:3: GROOVYEXPRESSION AS ID ( LBRACKET typeNm= typeName RBRACKET )?
                    {
                    GROOVYEXPRESSION73=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn952); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION73);

                    AS74=(Token)match(input,AS,FOLLOW_AS_in_selectColumn954); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS74);

                    ID75=(Token)match(input,ID,FOLLOW_ID_in_selectColumn956); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID75);

                    // com/sap/hadoop/windowing/parser/Windowing.g:145:26: ( LBRACKET typeNm= typeName RBRACKET )?
                    int alt26=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            alt26=1;
                            }
                            break;
                    }

                    switch (alt26) {
                        case 1 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:145:27: LBRACKET typeNm= typeName RBRACKET
                            {
                            LBRACKET76=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_selectColumn959); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET76);

                            pushFollow(FOLLOW_typeName_in_selectColumn963);
                            typeNm=typeName();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_typeName.add(typeNm.getTree());
                            RBRACKET77=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_selectColumn965); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET77);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: GROOVYEXPRESSION, ID, typeNm
                    // token labels: 
                    // rule labels: typeNm, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_typeNm=new RewriteRuleSubtreeStream(adaptor,"rule typeNm",typeNm!=null?typeNm.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 145:63: -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:145:66: ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());
                        // com/sap/hadoop/windowing/parser/Windowing.g:145:101: ( ^( TYPENAME $typeNm) )?
                        if ( stream_typeNm.hasNext() ) {
                            // com/sap/hadoop/windowing/parser/Windowing.g:145:101: ^( TYPENAME $typeNm)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                            adaptor.addChild(root_2, stream_typeNm.nextTree());

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
                    // com/sap/hadoop/windowing/parser/Windowing.g:146:3: ID
                    {
                    ID78=(Token)match(input,ID,FOLLOW_ID_in_selectColumn991); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID78);



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
                    // 146:6: -> ^( SELECTCOLUMN ID )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:146:9: ^( SELECTCOLUMN ID )
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

    public static class typeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeName"
    // com/sap/hadoop/windowing/parser/Windowing.g:149:1: typeName : ( ID | STRING );
    public final WindowingParser.typeName_return typeName() throws RecognitionException {
        WindowingParser.typeName_return retval = new WindowingParser.typeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set79=null;

        Object set79_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:149:9: ( ID | STRING )
            // com/sap/hadoop/windowing/parser/Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set79=(Token)input.LT(1);
            if ( input.LA(1)==ID||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set79));
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
    // $ANTLR end "typeName"

    public static class where_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where"
    // com/sap/hadoop/windowing/parser/Windowing.g:153:1: where : ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) ;
    public final WindowingParser.where_return where() throws RecognitionException {
        WindowingParser.where_return retval = new WindowingParser.where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE80=null;
        Token GROOVYEXPRESSION81=null;

        Object WHERE80_tree=null;
        Object GROOVYEXPRESSION81_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:153:7: ( ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:154:2: ( WHERE GROOVYEXPRESSION )
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:154:2: ( WHERE GROOVYEXPRESSION )
            // com/sap/hadoop/windowing/parser/Windowing.g:154:3: WHERE GROOVYEXPRESSION
            {
            WHERE80=(Token)match(input,WHERE,FOLLOW_WHERE_in_where1025); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHERE.add(WHERE80);

            GROOVYEXPRESSION81=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where1027); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION81);


            }



            // AST REWRITE
            // elements: GROOVYEXPRESSION, WHERE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 154:27: -> ^( WHERE GROOVYEXPRESSION )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:154:30: ^( WHERE GROOVYEXPRESSION )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:157:1: outputClause : INTO PATH EQ p= STRING (s= outputSerDe )? -> ^( OUTPUTSPEC $p ( $s)? ) ;
    public final WindowingParser.outputClause_return outputClause() throws RecognitionException {
        WindowingParser.outputClause_return retval = new WindowingParser.outputClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token p=null;
        Token INTO82=null;
        Token PATH83=null;
        Token EQ84=null;
        WindowingParser.outputSerDe_return s = null;


        Object p_tree=null;
        Object INTO82_tree=null;
        Object PATH83_tree=null;
        Object EQ84_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_PATH=new RewriteRuleTokenStream(adaptor,"token PATH");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_outputSerDe=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDe");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:157:14: ( INTO PATH EQ p= STRING (s= outputSerDe )? -> ^( OUTPUTSPEC $p ( $s)? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:158:2: INTO PATH EQ p= STRING (s= outputSerDe )?
            {
            INTO82=(Token)match(input,INTO,FOLLOW_INTO_in_outputClause1046); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTO.add(INTO82);

            PATH83=(Token)match(input,PATH,FOLLOW_PATH_in_outputClause1048); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PATH.add(PATH83);

            EQ84=(Token)match(input,EQ,FOLLOW_EQ_in_outputClause1050); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ84);

            p=(Token)match(input,STRING,FOLLOW_STRING_in_outputClause1054); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(p);

            // com/sap/hadoop/windowing/parser/Windowing.g:158:25: (s= outputSerDe )?
            int alt28=2;
            switch ( input.LA(1) ) {
                case SERDE:
                    {
                    alt28=1;
                    }
                    break;
            }

            switch (alt28) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:158:25: s= outputSerDe
                    {
                    pushFollow(FOLLOW_outputSerDe_in_outputClause1058);
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
            // 158:39: -> ^( OUTPUTSPEC $p ( $s)? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:158:42: ^( OUTPUTSPEC $p ( $s)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUTSPEC, "OUTPUTSPEC"), root_1);

                adaptor.addChild(root_1, stream_p.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:158:58: ( $s)?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:161:1: outputSerDe : SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) ;
    public final WindowingParser.outputSerDe_return outputSerDe() throws RecognitionException {
        WindowingParser.outputSerDe_return retval = new WindowingParser.outputSerDe_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token SERDE85=null;
        WindowingParser.outputSerDePropeties_return p = null;

        WindowingParser.outputFormatOrWriter_return o = null;


        Object s_tree=null;
        Object SERDE85_tree=null;
        RewriteRuleTokenStream stream_SERDE=new RewriteRuleTokenStream(adaptor,"token SERDE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_outputFormatOrWriter=new RewriteRuleSubtreeStream(adaptor,"rule outputFormatOrWriter");
        RewriteRuleSubtreeStream stream_outputSerDePropeties=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDePropeties");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:161:13: ( SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:162:3: SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter
            {
            SERDE85=(Token)match(input,SERDE,FOLLOW_SERDE_in_outputSerDe1083); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SERDE.add(SERDE85);

            s=(Token)match(input,STRING,FOLLOW_STRING_in_outputSerDe1087); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(s);

            // com/sap/hadoop/windowing/parser/Windowing.g:162:19: (p= outputSerDePropeties )?
            int alt29=2;
            switch ( input.LA(1) ) {
                case WITH:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:162:19: p= outputSerDePropeties
                    {
                    pushFollow(FOLLOW_outputSerDePropeties_in_outputSerDe1091);
                    p=outputSerDePropeties();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputSerDePropeties.add(p.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe1096);
            o=outputFormatOrWriter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_outputFormatOrWriter.add(o.getTree());


            // AST REWRITE
            // elements: p, s, o, SERDE
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
            // 162:65: -> ^( SERDE $s $o ( $p)? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:162:68: ^( SERDE $s $o ( $p)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_s.nextNode());
                adaptor.addChild(root_1, stream_o.nextTree());
                // com/sap/hadoop/windowing/parser/Windowing.g:162:82: ( $p)?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:165:1: outputSerDePropeties : WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) ;
    public final WindowingParser.outputSerDePropeties_return outputSerDePropeties() throws RecognitionException {
        WindowingParser.outputSerDePropeties_return retval = new WindowingParser.outputSerDePropeties_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WITH86=null;
        Token SERDEPROPERTIES87=null;
        Token LPAREN88=null;
        Token COMMA90=null;
        Token RPAREN92=null;
        WindowingParser.namevalue_return namevalue89 = null;

        WindowingParser.namevalue_return namevalue91 = null;


        Object WITH86_tree=null;
        Object SERDEPROPERTIES87_tree=null;
        Object LPAREN88_tree=null;
        Object COMMA90_tree=null;
        Object RPAREN92_tree=null;
        RewriteRuleTokenStream stream_SERDEPROPERTIES=new RewriteRuleTokenStream(adaptor,"token SERDEPROPERTIES");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:165:21: ( WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:166:3: WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            WITH86=(Token)match(input,WITH,FOLLOW_WITH_in_outputSerDePropeties1122); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WITH.add(WITH86);

            SERDEPROPERTIES87=(Token)match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1124); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SERDEPROPERTIES.add(SERDEPROPERTIES87);

            LPAREN88=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_outputSerDePropeties1126); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN88);

            // com/sap/hadoop/windowing/parser/Windowing.g:166:31: ( namevalue )?
            int alt30=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                    {
                    alt30=1;
                    }
                    break;
            }

            switch (alt30) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:166:32: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1129);
                    namevalue89=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue89.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:166:44: ( COMMA namevalue )*
            loop31:
            do {
                int alt31=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt31=1;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:166:45: COMMA namevalue
            	    {
            	    COMMA90=(Token)match(input,COMMA,FOLLOW_COMMA_in_outputSerDePropeties1134); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA90);

            	    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1136);
            	    namevalue91=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue91.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            RPAREN92=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_outputSerDePropeties1140); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN92);



            // AST REWRITE
            // elements: SERDEPROPERTIES, namevalue
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 167:6: -> ^( SERDEPROPERTIES ( namevalue )* )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:167:9: ^( SERDEPROPERTIES ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDEPROPERTIES.nextNode(), root_1);

                // com/sap/hadoop/windowing/parser/Windowing.g:167:27: ( namevalue )*
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
    // com/sap/hadoop/windowing/parser/Windowing.g:170:1: outputFormatOrWriter : ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) );
    public final WindowingParser.outputFormatOrWriter_return outputFormatOrWriter() throws RecognitionException {
        WindowingParser.outputFormatOrWriter_return retval = new WindowingParser.outputFormatOrWriter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RECORDWRITER93=null;
        Token STRING94=null;
        Token FORMAT95=null;
        Token STRING96=null;

        Object RECORDWRITER93_tree=null;
        Object STRING94_tree=null;
        Object FORMAT95_tree=null;
        Object STRING96_tree=null;
        RewriteRuleTokenStream stream_RECORDWRITER=new RewriteRuleTokenStream(adaptor,"token RECORDWRITER");
        RewriteRuleTokenStream stream_FORMAT=new RewriteRuleTokenStream(adaptor,"token FORMAT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:170:22: ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) )
            int alt32=2;
            switch ( input.LA(1) ) {
            case RECORDWRITER:
                {
                alt32=1;
                }
                break;
            case FORMAT:
                {
                alt32=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:171:3: RECORDWRITER STRING
                    {
                    RECORDWRITER93=(Token)match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter1166); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RECORDWRITER.add(RECORDWRITER93);

                    STRING94=(Token)match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1168); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING94);



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
                    // 171:23: -> ^( RECORDWRITER STRING )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:171:26: ^( RECORDWRITER STRING )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:172:3: FORMAT STRING
                    {
                    FORMAT95=(Token)match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter1182); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FORMAT.add(FORMAT95);

                    STRING96=(Token)match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1184); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING96);



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
                    // 172:17: -> ^( FORMAT STRING )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:172:20: ^( FORMAT STRING )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:174:1: value_expression : ( numeric_expression | STRING );
    public final WindowingParser.value_expression_return value_expression() throws RecognitionException {
        WindowingParser.value_expression_return retval = new WindowingParser.value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING98=null;
        WindowingParser.numeric_expression_return numeric_expression97 = null;


        Object STRING98_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:174:18: ( numeric_expression | STRING )
            int alt33=2;
            switch ( input.LA(1) ) {
            case ID:
            case LPAREN:
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt33=1;
                }
                break;
            case STRING:
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:175:3: numeric_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_expression_in_value_expression1202);
                    numeric_expression97=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression97.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:176:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING98=(Token)match(input,STRING,FOLLOW_STRING_in_value_expression1208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING98_tree = (Object)adaptor.create(STRING98);
                    adaptor.addChild(root_0, STRING98_tree);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:179:1: numeric_expression : term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* ;
    public final WindowingParser.numeric_expression_return numeric_expression() throws RecognitionException {
        WindowingParser.numeric_expression_return retval = new WindowingParser.numeric_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS100=null;
        Token MINUS101=null;
        WindowingParser.term_return term99 = null;

        WindowingParser.term_return term102 = null;


        Object PLUS100_tree=null;
        Object MINUS101_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:179:20: ( term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* )
            // com/sap/hadoop/windowing/parser/Windowing.g:180:3: term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_numeric_expression1220);
            term99=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term99.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:180:8: ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==PLUS) && (synpred1_Windowing())) {
                    alt35=1;
                }
                else if ( (LA35_0==MINUS) && (synpred1_Windowing())) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:180:9: ( PLUS | MINUS )=> ( PLUS | MINUS ) term
            	    {
            	    // com/sap/hadoop/windowing/parser/Windowing.g:180:26: ( PLUS | MINUS )
            	    int alt34=2;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt34=1;
            	        }
            	        break;
            	    case MINUS:
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
            	            // com/sap/hadoop/windowing/parser/Windowing.g:180:27: PLUS
            	            {
            	            PLUS100=(Token)match(input,PLUS,FOLLOW_PLUS_in_numeric_expression1233); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS100_tree = (Object)adaptor.create(PLUS100);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS100_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/sap/hadoop/windowing/parser/Windowing.g:180:35: MINUS
            	            {
            	            MINUS101=(Token)match(input,MINUS,FOLLOW_MINUS_in_numeric_expression1238); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS101_tree = (Object)adaptor.create(MINUS101);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS101_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_numeric_expression1242);
            	    term102=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term102.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // com/sap/hadoop/windowing/parser/Windowing.g:183:1: term : numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* ;
    public final WindowingParser.term_return term() throws RecognitionException {
        WindowingParser.term_return retval = new WindowingParser.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASTERISK104=null;
        Token SOLIDUS105=null;
        WindowingParser.numeric_primary_expression_return numeric_primary_expression103 = null;

        WindowingParser.numeric_primary_expression_return numeric_primary_expression106 = null;


        Object ASTERISK104_tree=null;
        Object SOLIDUS105_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:183:7: ( numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* )
            // com/sap/hadoop/windowing/parser/Windowing.g:184:3: numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_numeric_primary_expression_in_term1260);
            numeric_primary_expression103=numeric_primary_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression103.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:184:30: ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==ASTERISK) && (synpred2_Windowing())) {
                    alt37=1;
                }
                else if ( (LA37_0==SOLIDUS) && (synpred2_Windowing())) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:184:31: ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression
            	    {
            	    // com/sap/hadoop/windowing/parser/Windowing.g:184:54: ( ASTERISK | SOLIDUS )
            	    int alt36=2;
            	    switch ( input.LA(1) ) {
            	    case ASTERISK:
            	        {
            	        alt36=1;
            	        }
            	        break;
            	    case SOLIDUS:
            	        {
            	        alt36=2;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt36) {
            	        case 1 :
            	            // com/sap/hadoop/windowing/parser/Windowing.g:184:55: ASTERISK
            	            {
            	            ASTERISK104=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_term1273); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ASTERISK104_tree = (Object)adaptor.create(ASTERISK104);
            	            root_0 = (Object)adaptor.becomeRoot(ASTERISK104_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/sap/hadoop/windowing/parser/Windowing.g:184:67: SOLIDUS
            	            {
            	            SOLIDUS105=(Token)match(input,SOLIDUS,FOLLOW_SOLIDUS_in_term1278); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SOLIDUS105_tree = (Object)adaptor.create(SOLIDUS105);
            	            root_0 = (Object)adaptor.becomeRoot(SOLIDUS105_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_numeric_primary_expression_in_term1282);
            	    numeric_primary_expression106=numeric_primary_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression106.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // com/sap/hadoop/windowing/parser/Windowing.g:187:1: numeric_primary_expression : ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN );
    public final WindowingParser.numeric_primary_expression_return numeric_primary_expression() throws RecognitionException {
        WindowingParser.numeric_primary_expression_return retval = new WindowingParser.numeric_primary_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN109=null;
        Token RPAREN111=null;
        WindowingParser.identifier_return identifier107 = null;

        WindowingParser.signed_numeric_literal_return signed_numeric_literal108 = null;

        WindowingParser.numeric_expression_return numeric_expression110 = null;


        Object LPAREN109_tree=null;
        Object RPAREN111_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:187:28: ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN )
            int alt38=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt38=1;
                }
                break;
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt38=2;
                }
                break;
            case LPAREN:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:188:3: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_numeric_primary_expression1296);
                    identifier107=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier107.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:189:3: signed_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signed_numeric_literal_in_numeric_primary_expression1303);
                    signed_numeric_literal108=signed_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_numeric_literal108.getTree());

                    }
                    break;
                case 3 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:190:3: LPAREN numeric_expression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN109=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numeric_primary_expression1310); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN109_tree = (Object)adaptor.create(LPAREN109);
                    adaptor.addChild(root_0, LPAREN109_tree);
                    }
                    pushFollow(FOLLOW_numeric_expression_in_numeric_primary_expression1312);
                    numeric_expression110=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression110.getTree());
                    RPAREN111=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numeric_primary_expression1314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN111_tree = (Object)adaptor.create(RPAREN111);
                    adaptor.addChild(root_0, RPAREN111_tree);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:193:1: signed_numeric_literal : ( PLUS | MINUS )? unsigned_numeric_literal ;
    public final WindowingParser.signed_numeric_literal_return signed_numeric_literal() throws RecognitionException {
        WindowingParser.signed_numeric_literal_return retval = new WindowingParser.signed_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set112=null;
        WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal113 = null;


        Object set112_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:193:24: ( ( PLUS | MINUS )? unsigned_numeric_literal )
            // com/sap/hadoop/windowing/parser/Windowing.g:194:3: ( PLUS | MINUS )? unsigned_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            // com/sap/hadoop/windowing/parser/Windowing.g:194:3: ( PLUS | MINUS )?
            int alt39=2;
            switch ( input.LA(1) ) {
                case PLUS:
                case MINUS:
                    {
                    alt39=1;
                    }
                    break;
            }

            switch (alt39) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:
                    {
                    set112=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set112));
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

            pushFollow(FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1333);
            unsigned_numeric_literal113=unsigned_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unsigned_numeric_literal113.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:200:1: unsigned_numeric_literal : ( exact_numeric_literal | approximate_numeric_literal );
    public final WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal() throws RecognitionException {
        WindowingParser.unsigned_numeric_literal_return retval = new WindowingParser.unsigned_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal114 = null;

        WindowingParser.approximate_numeric_literal_return approximate_numeric_literal115 = null;



        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:200:26: ( exact_numeric_literal | approximate_numeric_literal )
            int alt40=2;
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
                            alt40=1;
                            }
                            break;
                        case 104:
                            {
                            alt40=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 40, 7, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 3, input);

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
                    alt40=1;
                    }
                    break;
                case 104:
                    {
                    alt40=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

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
                        alt40=1;
                        }
                        break;
                    case 104:
                        {
                        alt40=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 6, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:201:3: exact_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1346);
                    exact_numeric_literal114=exact_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal114.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:202:3: approximate_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1352);
                    approximate_numeric_literal115=approximate_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, approximate_numeric_literal115.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:205:1: approximate_numeric_literal : mantissa 'E' exponent ;
    public final WindowingParser.approximate_numeric_literal_return approximate_numeric_literal() throws RecognitionException {
        WindowingParser.approximate_numeric_literal_return retval = new WindowingParser.approximate_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal117=null;
        WindowingParser.mantissa_return mantissa116 = null;

        WindowingParser.exponent_return exponent118 = null;


        Object char_literal117_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:205:29: ( mantissa 'E' exponent )
            // com/sap/hadoop/windowing/parser/Windowing.g:206:3: mantissa 'E' exponent
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mantissa_in_approximate_numeric_literal1363);
            mantissa116=mantissa();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mantissa116.getTree());
            char_literal117=(Token)match(input,104,FOLLOW_104_in_approximate_numeric_literal1365); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal117_tree = (Object)adaptor.create(char_literal117);
            adaptor.addChild(root_0, char_literal117_tree);
            }
            pushFollow(FOLLOW_exponent_in_approximate_numeric_literal1367);
            exponent118=exponent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exponent118.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:209:1: exponent : ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER );
    public final WindowingParser.exponent_return exponent() throws RecognitionException {
        WindowingParser.exponent_return retval = new WindowingParser.exponent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS119=null;
        Token NUMBER120=null;
        Token MINUS121=null;
        Token NUMBER122=null;
        Token NUMBER123=null;

        Object PLUS119_tree=null;
        Object NUMBER120_tree=null;
        Object MINUS121_tree=null;
        Object NUMBER122_tree=null;
        Object NUMBER123_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:209:10: ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER )
            int alt41=3;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt41=1;
                }
                break;
            case MINUS:
                {
                alt41=2;
                }
                break;
            case NUMBER:
                {
                alt41=3;
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:210:3: PLUS NUMBER
                    {
                    PLUS119=(Token)match(input,PLUS,FOLLOW_PLUS_in_exponent1378); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS119);

                    NUMBER120=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1380); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER120);



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
                    // 210:15: -> NUMBER
                    {
                        adaptor.addChild(root_0, stream_NUMBER.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:211:3: MINUS NUMBER
                    {
                    MINUS121=(Token)match(input,MINUS,FOLLOW_MINUS_in_exponent1390); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS121);

                    NUMBER122=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1392); if (state.failed) return retval; 
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
                    // 211:16: -> ^( UMINUS NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:211:19: ^( UMINUS NUMBER )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:212:3: NUMBER
                    {
                    NUMBER123=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1406); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER123);



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
                    // 212:10: -> NUMBER
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
    // com/sap/hadoop/windowing/parser/Windowing.g:215:1: mantissa : exact_numeric_literal ;
    public final WindowingParser.mantissa_return mantissa() throws RecognitionException {
        WindowingParser.mantissa_return retval = new WindowingParser.mantissa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal124 = null;



        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:215:10: ( exact_numeric_literal )
            // com/sap/hadoop/windowing/parser/Windowing.g:216:3: exact_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_exact_numeric_literal_in_mantissa1422);
            exact_numeric_literal124=exact_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal124.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:219:1: exact_numeric_literal : (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->);
    public final WindowingParser.exact_numeric_literal_return exact_numeric_literal() throws RecognitionException {
        WindowingParser.exact_numeric_literal_return retval = new WindowingParser.exact_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token n2=null;
        Token DOT125=null;
        Token DOT126=null;

        Object n1_tree=null;
        Object n2_tree=null;
        Object DOT125_tree=null;
        Object DOT126_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:219:23: (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->)
            int alt43=2;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt43=1;
                }
                break;
            case DOT:
                {
                alt43=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:221:3: n1= NUMBER ( DOT n2= NUMBER )?
                    {
                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1438); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(n1);

                    // com/sap/hadoop/windowing/parser/Windowing.g:221:13: ( DOT n2= NUMBER )?
                    int alt42=2;
                    switch ( input.LA(1) ) {
                        case DOT:
                            {
                            alt42=1;
                            }
                            break;
                    }

                    switch (alt42) {
                        case 1 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:221:14: DOT n2= NUMBER
                            {
                            DOT125=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1441); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT125);

                            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1445); if (state.failed) return retval; 
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
                    // 221:31: ->
                    {
                        adaptor.addChild(root_0, 
                        	      ( n2 != null ? adaptor.create(NUMERIC, (n1!=null?n1.getText():null) + '.' + (n2!=null?n2.getText():null)) :  adaptor.create(INTEGER, (n1!=null?n1.getText():null)) )
                              );

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:225:3: DOT n1= NUMBER
                    {
                    DOT126=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1466); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT126);

                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1470); if (state.failed) return retval; 
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
                    // 225:17: ->
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
    // com/sap/hadoop/windowing/parser/Windowing.g:228:1: identifier : ID ;
    public final WindowingParser.identifier_return identifier() throws RecognitionException {
        WindowingParser.identifier_return retval = new WindowingParser.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID127=null;

        Object ID127_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:228:12: ( ID )
            // com/sap/hadoop/windowing/parser/Windowing.g:229:3: ID
            {
            root_0 = (Object)adaptor.nil();

            ID127=(Token)match(input,ID,FOLLOW_ID_in_identifier1486); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID127_tree = (Object)adaptor.create(ID127);
            adaptor.addChild(root_0, ID127_tree);
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
        // com/sap/hadoop/windowing/parser/Windowing.g:180:9: ( PLUS | MINUS )
        // com/sap/hadoop/windowing/parser/Windowing.g:
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
        // com/sap/hadoop/windowing/parser/Windowing.g:184:31: ( ASTERISK | SOLIDUS )
        // com/sap/hadoop/windowing/parser/Windowing.g:
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


 

    public static final BitSet FOLLOW_FROM_in_query142 = new BitSet(new long[]{0x0000000002700000L});
    public static final BitSet FOLLOW_tableSpec_in_query144 = new BitSet(new long[]{0x0002000000080000L});
    public static final BitSet FOLLOW_WITH_in_query148 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_funclist_in_query150 = new BitSet(new long[]{0x0002000000080000L});
    public static final BitSet FOLLOW_select_in_query155 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_where_in_query158 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_outputClause_in_query163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hivetable_in_tableSpec197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tableSpec202 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_partitionby_in_tableSpec206 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_orderby_in_tableSpec210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_tableSpec231 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_partitionby_in_tableSpec235 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_orderby_in_tableSpec239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tableSpec259 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_tableSpec263 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_partitionby_in_tableSpec267 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_orderby_in_tableSpec271 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_tableSpec273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tblfunc_in_tableSpec294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tblfunc307 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_tblfunc309 = new BitSet(new long[]{0x0000000002700000L});
    public static final BitSet FOLLOW_tableSpec_in_tblfunc311 = new BitSet(new long[]{0x0000002001800000L});
    public static final BitSet FOLLOW_window_expression_in_tblfunc314 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_COMMA_in_tblfunc319 = new BitSet(new long[]{0x0000001004300000L});
    public static final BitSet FOLLOW_functionparam_in_tblfunc321 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_RPAREN_in_tblfunc325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hivetable357 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_hivetable359 = new BitSet(new long[]{0x0000000005900000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable362 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_COMMA_in_hivetable367 = new BitSet(new long[]{0x0000000004100000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable369 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_RPAREN_in_hivetable373 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_partitionby_in_hivetable378 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_orderby_in_hivetable382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namevalue410 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue414 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EQ_in_namevalue417 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby443 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_BY_in_orderby445 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby447 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_orderby450 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby452 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ID_in_ordercolumn473 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby509 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_BY_in_partitionby511 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_partitionby513 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby516 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_partitionby518 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_function_in_funclist540 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_funclist543 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_function_in_funclist545 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ID_in_function569 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_function571 = new BitSet(new long[]{0x0000001005B00000L});
    public static final BitSet FOLLOW_functionparam_in_function574 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_COMMA_in_function579 = new BitSet(new long[]{0x0000001004300000L});
    public static final BitSet FOLLOW_functionparam_in_function581 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_RPAREN_in_function585 = new BitSet(new long[]{0x0000002200000000L});
    public static final BitSet FOLLOW_window_expression_in_function588 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_AS_in_function592 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_function596 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_LBRACKET_in_function599 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_function603 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RBRACKET_in_function605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionparam0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_expression674 = new BitSet(new long[]{0x0000404000000000L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression699 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression701 = new BitSet(new long[]{0x0000121000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression705 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_AND_in_window_range_expression707 = new BitSet(new long[]{0x0000121000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary734 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary761 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary776 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression808 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression810 = new BitSet(new long[]{0x0000120000200000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression814 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_AND_in_window_value_expression816 = new BitSet(new long[]{0x0000120000200000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary843 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary870 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary885 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary887 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select923 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_selectColumn_in_select925 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_select928 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_selectColumn_in_select930 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn952 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn954 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ID_in_selectColumn956 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selectColumn959 = new BitSet(new long[]{0x0000000004100000L});
    public static final BitSet FOLLOW_typeName_in_selectColumn963 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selectColumn965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selectColumn991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where1025 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_outputClause1046 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_PATH_in_outputClause1048 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause1050 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause1054 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_outputSerDe_in_outputClause1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERDE_in_outputSerDe1083 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRING_in_outputSerDe1087 = new BitSet(new long[]{0x0180000000080000L});
    public static final BitSet FOLLOW_outputSerDePropeties_in_outputSerDe1091 = new BitSet(new long[]{0x0180000000080000L});
    public static final BitSet FOLLOW_outputFormatOrWriter_in_outputSerDe1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_outputSerDePropeties1122 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1124 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_outputSerDePropeties1126 = new BitSet(new long[]{0x0000000005900000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1129 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_COMMA_in_outputSerDePropeties1134 = new BitSet(new long[]{0x0000000004100000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1136 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_RPAREN_in_outputSerDePropeties1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORDWRITER_in_outputFormatOrWriter1166 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAT_in_outputFormatOrWriter1182 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_expression_in_value_expression1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_value_expression1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_numeric_expression1220 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_PLUS_in_numeric_expression1233 = new BitSet(new long[]{0x2600001000500000L});
    public static final BitSet FOLLOW_MINUS_in_numeric_expression1238 = new BitSet(new long[]{0x2600001000500000L});
    public static final BitSet FOLLOW_term_in_numeric_expression1242 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1260 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_ASTERISK_in_term1273 = new BitSet(new long[]{0x2600001000500000L});
    public static final BitSet FOLLOW_SOLIDUS_in_term1278 = new BitSet(new long[]{0x2600001000500000L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1282 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_identifier_in_numeric_primary_expression1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signed_numeric_literal_in_numeric_primary_expression1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_primary_expression1310 = new BitSet(new long[]{0x2600001000500000L});
    public static final BitSet FOLLOW_numeric_expression_in_numeric_primary_expression1312 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_primary_expression1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_signed_numeric_literal1326 = new BitSet(new long[]{0x2600001000000000L});
    public static final BitSet FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mantissa_in_approximate_numeric_literal1363 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_approximate_numeric_literal1365 = new BitSet(new long[]{0x0600001000000000L});
    public static final BitSet FOLLOW_exponent_in_approximate_numeric_literal1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_exponent1378 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_exponent1390 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_mantissa1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1438 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1441 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1466 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1_Windowing1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred2_Windowing1263 = new BitSet(new long[]{0x0000000000000002L});

}