// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/sap/hadoop/windowing/parser/Windowing.g 2012-02-03 12:39:13

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
    // com/sap/hadoop/windowing/parser/Windowing.g:59:1: query : FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec partitionby orderby select ( funclist )? ( where )? ( outputClause )? ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:59:7: ( FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec partitionby orderby select ( funclist )? ( where )? ( outputClause )? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:60:2: FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF
            {
            FROM1=(Token)match(input,FROM,FOLLOW_FROM_in_query147); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM1);

            pushFollow(FOLLOW_tableSpec_in_query149);
            tableSpec2=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec2.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:61:2: ( WITH funclist )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:61:3: WITH funclist
                    {
                    WITH3=(Token)match(input,WITH,FOLLOW_WITH_in_query153); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WITH.add(WITH3);

                    pushFollow(FOLLOW_funclist_in_query155);
                    funclist4=funclist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_funclist.add(funclist4.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_select_in_query160);
            select5=select();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select.add(select5.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:63:2: ( where )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:63:2: where
                    {
                    pushFollow(FOLLOW_where_in_query163);
                    where6=where();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_where.add(where6.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:64:2: ( outputClause )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:64:2: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_query168);
                    outputClause7=outputClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputClause.add(outputClause7.getTree());

                    }
                    break;

            }

            EOF8=(Token)match(input,EOF,FOLLOW_EOF_in_query173); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF8);



            // AST REWRITE
            // elements: partitionby, funclist, select, where, outputClause, tableSpec, orderby
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 65:6: -> ^( QUERY tableSpec partitionby orderby select ( funclist )? ( where )? ( outputClause )? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:65:9: ^( QUERY tableSpec partitionby orderby select ( funclist )? ( where )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                adaptor.addChild(root_1, stream_select.nextTree());
                // com/sap/hadoop/windowing/parser/Windowing.g:65:54: ( funclist )?
                if ( stream_funclist.hasNext() ) {
                    adaptor.addChild(root_1, stream_funclist.nextTree());

                }
                stream_funclist.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:65:64: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.nextTree());

                }
                stream_where.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:65:71: ( outputClause )?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:68:1: tableSpec : ( hivetable | ID p= partitionby o= orderby -> ^( TABLEINPUT ID $p $o) | h= GROOVYEXPRESSION p= partitionby o= orderby -> ^( TABLEINPUT $h $p $o) | LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN -> ^( TABLEINPUT $h $p $o) | tblfunc );
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
            // com/sap/hadoop/windowing/parser/Windowing.g:68:11: ( hivetable | ID p= partitionby o= orderby -> ^( TABLEINPUT ID $p $o) | h= GROOVYEXPRESSION p= partitionby o= orderby -> ^( TABLEINPUT $h $p $o) | LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN -> ^( TABLEINPUT $h $p $o) | tblfunc )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:69:2: hivetable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hivetable_in_tableSpec206);
                    hivetable9=hivetable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hivetable9.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:70:2: ID p= partitionby o= orderby
                    {
                    ID10=(Token)match(input,ID,FOLLOW_ID_in_tableSpec211); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID10);

                    pushFollow(FOLLOW_partitionby_in_tableSpec215);
                    p=partitionby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_tableSpec219);
                    o=orderby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderby.add(o.getTree());


                    // AST REWRITE
                    // elements: ID, o, p
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
                    // 70:29: -> ^( TABLEINPUT ID $p $o)
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:70:32: ^( TABLEINPUT ID $p $o)
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:71:2: h= GROOVYEXPRESSION p= partitionby o= orderby
                    {
                    h=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_tableSpec240); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(h);

                    pushFollow(FOLLOW_partitionby_in_tableSpec244);
                    p=partitionby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_tableSpec248);
                    o=orderby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderby.add(o.getTree());


                    // AST REWRITE
                    // elements: h, p, o
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
                    // 71:45: -> ^( TABLEINPUT $h $p $o)
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:71:48: ^( TABLEINPUT $h $p $o)
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:72:2: LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN
                    {
                    LPAREN11=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tableSpec268); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN11);

                    h=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_tableSpec272); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(h);

                    pushFollow(FOLLOW_partitionby_in_tableSpec276);
                    p=partitionby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_tableSpec280);
                    o=orderby();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_orderby.add(o.getTree());
                    RPAREN12=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tableSpec282); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN12);



                    // AST REWRITE
                    // elements: p, o, h
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
                    // 72:59: -> ^( TABLEINPUT $h $p $o)
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:72:62: ^( TABLEINPUT $h $p $o)
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:73:2: tblfunc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tblfunc_in_tableSpec303);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:76:1: tblfunc : name= ID LPAREN tableSpec ( window_expression )? ( COMMA tblfuncparam )* RPAREN -> ^( TBLFUNCTION $name tableSpec ( window_expression )? ( tblfuncparam )* ) ;
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

        WindowingParser.tblfuncparam_return tblfuncparam18 = null;


        Object name_tree=null;
        Object LPAREN14_tree=null;
        Object COMMA17_tree=null;
        Object RPAREN19_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_tblfuncparam=new RewriteRuleSubtreeStream(adaptor,"rule tblfuncparam");
        RewriteRuleSubtreeStream stream_window_expression=new RewriteRuleSubtreeStream(adaptor,"rule window_expression");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:76:9: (name= ID LPAREN tableSpec ( window_expression )? ( COMMA tblfuncparam )* RPAREN -> ^( TBLFUNCTION $name tableSpec ( window_expression )? ( tblfuncparam )* ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:77:3: name= ID LPAREN tableSpec ( window_expression )? ( COMMA tblfuncparam )* RPAREN
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_tblfunc316); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN14=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tblfunc318); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN14);

            pushFollow(FOLLOW_tableSpec_in_tblfunc320);
            tableSpec15=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec15.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:77:28: ( window_expression )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:77:29: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_tblfunc323);
                    window_expression16=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression16.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:77:49: ( COMMA tblfuncparam )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:77:50: COMMA tblfuncparam
            	    {
            	    COMMA17=(Token)match(input,COMMA,FOLLOW_COMMA_in_tblfunc328); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA17);

            	    pushFollow(FOLLOW_tblfuncparam_in_tblfunc330);
            	    tblfuncparam18=tblfuncparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_tblfuncparam.add(tblfuncparam18.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            RPAREN19=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tblfunc334); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN19);



            // AST REWRITE
            // elements: tableSpec, name, tblfuncparam, window_expression
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
            // 78:5: -> ^( TBLFUNCTION $name tableSpec ( window_expression )? ( tblfuncparam )* )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:78:8: ^( TBLFUNCTION $name tableSpec ( window_expression )? ( tblfuncparam )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TBLFUNCTION, "TBLFUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                // com/sap/hadoop/windowing/parser/Windowing.g:78:38: ( window_expression )?
                if ( stream_window_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_expression.nextTree());

                }
                stream_window_expression.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:78:57: ( tblfuncparam )*
                while ( stream_tblfuncparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_tblfuncparam.nextTree());

                }
                stream_tblfuncparam.reset();

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
    // com/sap/hadoop/windowing/parser/Windowing.g:81:1: hivetable : TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby -> ^( TABLEINPUT ( namevalue )* $p $o) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:81:11: ( TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby -> ^( TABLEINPUT ( namevalue )* $p $o) )
            // com/sap/hadoop/windowing/parser/Windowing.g:82:2: TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby
            {
            TABLEINPUT20=(Token)match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hivetable367); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TABLEINPUT.add(TABLEINPUT20);

            LPAREN21=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_hivetable369); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN21);

            // com/sap/hadoop/windowing/parser/Windowing.g:82:20: ( namevalue )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:82:21: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hivetable372);
                    namevalue22=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue22.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:82:33: ( COMMA namevalue )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:82:34: COMMA namevalue
            	    {
            	    COMMA23=(Token)match(input,COMMA,FOLLOW_COMMA_in_hivetable377); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA23);

            	    pushFollow(FOLLOW_namevalue_in_hivetable379);
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

            RPAREN25=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_hivetable383); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN25);

            pushFollow(FOLLOW_partitionby_in_hivetable388);
            p=partitionby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionby.add(p.getTree());
            pushFollow(FOLLOW_orderby_in_hivetable392);
            o=orderby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orderby.add(o.getTree());


            // AST REWRITE
            // elements: p, namevalue, TABLEINPUT, o
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
            // 82:84: -> ^( TABLEINPUT ( namevalue )* $p $o)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:82:87: ^( TABLEINPUT ( namevalue )* $p $o)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_TABLEINPUT.nextNode(), root_1);

                // com/sap/hadoop/windowing/parser/Windowing.g:82:100: ( namevalue )*
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
    // com/sap/hadoop/windowing/parser/Windowing.g:85:1: namevalue : (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:85:11: ( (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) )
            // com/sap/hadoop/windowing/parser/Windowing.g:86:2: (i= ID | i= STRING ) EQ v= STRING
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:86:2: (i= ID | i= STRING )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:86:3: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_namevalue420); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:86:8: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ26=(Token)match(input,EQ,FOLLOW_EQ_in_namevalue427); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ26);

            v=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue431); if (state.failed) return retval; 
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
            // 86:30: -> ^( PARAM $i $v)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:86:33: ^( PARAM $i $v)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:89:1: orderby : ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:89:9: ( ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:90:2: ORDER BY ordercolumn ( COMMA ordercolumn )*
            {
            ORDER27=(Token)match(input,ORDER,FOLLOW_ORDER_in_orderby453); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ORDER.add(ORDER27);

            BY28=(Token)match(input,BY,FOLLOW_BY_in_orderby455); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY28);

            pushFollow(FOLLOW_ordercolumn_in_orderby457);
            ordercolumn29=ordercolumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn29.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:90:23: ( COMMA ordercolumn )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    switch ( input.LA(2) ) {
                    case ID:
                        {
                        switch ( input.LA(3) ) {
                        case WITH:
                        case RPAREN:
                        case COMMA:
                        case ASC:
                        case DESC:
                        case OVER:
                        case SELECT:
                            {
                            alt10=1;
                            }
                            break;

                        }

                        }
                        break;

                    }

                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:90:24: COMMA ordercolumn
            	    {
            	    COMMA30=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderby460); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA30);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby462);
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
            // 90:44: -> ^( ORDER ( ordercolumn )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:90:47: ^( ORDER ( ordercolumn )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:93:1: ordercolumn : ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:93:13: ( ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:94:2: ID (o= ASC | o= DESC )?
            {
            ID32=(Token)match(input,ID,FOLLOW_ID_in_ordercolumn483); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID32);

            // com/sap/hadoop/windowing/parser/Windowing.g:94:5: (o= ASC | o= DESC )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:94:6: o= ASC
                    {
                    o=(Token)match(input,ASC,FOLLOW_ASC_in_ordercolumn488); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:94:14: o= DESC
                    {
                    o=(Token)match(input,DESC,FOLLOW_DESC_in_ordercolumn494); if (state.failed) return retval; 
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
            // 94:23: -> ^( ORDERCOLUMN ID ( $o)? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:94:26: ^( ORDERCOLUMN ID ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:94:43: ( $o)?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:97:1: partitionby : PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:97:13: ( PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:98:2: PARTITION BY ID ( COMMA ID )*
            {
            PARTITION33=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_partitionby519); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARTITION.add(PARTITION33);

            BY34=(Token)match(input,BY,FOLLOW_BY_in_partitionby521); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY34);

            ID35=(Token)match(input,ID,FOLLOW_ID_in_partitionby523); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID35);

            // com/sap/hadoop/windowing/parser/Windowing.g:98:18: ( COMMA ID )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:98:19: COMMA ID
            	    {
            	    COMMA36=(Token)match(input,COMMA,FOLLOW_COMMA_in_partitionby526); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA36);

            	    ID37=(Token)match(input,ID,FOLLOW_ID_in_partitionby528); if (state.failed) return retval; 
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
            // 98:30: -> ^( PARTITION ( ID )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:98:33: ^( PARTITION ( ID )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:101:1: funclist : function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:101:10: ( function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:102:2: function ( COMMA function )*
            {
            pushFollow(FOLLOW_function_in_funclist550);
            function38=function();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function.add(function38.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:102:11: ( COMMA function )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:102:12: COMMA function
            	    {
            	    COMMA39=(Token)match(input,COMMA,FOLLOW_COMMA_in_funclist553); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA39);

            	    pushFollow(FOLLOW_function_in_funclist555);
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
            // 102:29: -> ^( FUNCTIONS ( function )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:102:32: ^( FUNCTIONS ( function )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:105:1: function : name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:105:10: (name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:106:2: name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )?
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_function579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN41=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function581); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN41);

            // com/sap/hadoop/windowing/parser/Windowing.g:106:17: ( functionparam )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:106:18: functionparam
                    {
                    pushFollow(FOLLOW_functionparam_in_function584);
                    functionparam42=functionparam();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionparam.add(functionparam42.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:106:34: ( COMMA functionparam )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:106:35: COMMA functionparam
            	    {
            	    COMMA43=(Token)match(input,COMMA,FOLLOW_COMMA_in_function589); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA43);

            	    pushFollow(FOLLOW_functionparam_in_function591);
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

            RPAREN45=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function595); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN45);

            // com/sap/hadoop/windowing/parser/Windowing.g:106:64: ( window_expression )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:106:65: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function598);
                    window_expression46=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression46.getTree());

                    }
                    break;

            }

            AS47=(Token)match(input,AS,FOLLOW_AS_in_function602); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AS.add(AS47);

            alias=(Token)match(input,ID,FOLLOW_ID_in_function606); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(alias);

            // com/sap/hadoop/windowing/parser/Windowing.g:106:97: ( LBRACKET typeNm= ID RBRACKET )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:106:98: LBRACKET typeNm= ID RBRACKET
                    {
                    LBRACKET48=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_function609); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET48);

                    typeNm=(Token)match(input,ID,FOLLOW_ID_in_function613); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(typeNm);

                    RBRACKET49=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_function615); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET49);


                    }
                    break;

            }



            // AST REWRITE
            // elements: typeNm, functionparam, name, window_expression, alias
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
            // 106:128: -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:107:7: ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_alias.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:107:31: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.nextTree());

                }
                stream_functionparam.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:107:46: ( ^( TYPENAME $typeNm) )?
                if ( stream_typeNm.hasNext() ) {
                    // com/sap/hadoop/windowing/parser/Windowing.g:107:46: ^( TYPENAME $typeNm)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                    adaptor.addChild(root_2, stream_typeNm.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_typeNm.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:107:67: ( window_expression )?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:110:1: functionparam : ( GROOVYEXPRESSION | STRING | ID | NUMBER );
    public final WindowingParser.functionparam_return functionparam() throws RecognitionException {
        WindowingParser.functionparam_return retval = new WindowingParser.functionparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set50=null;

        Object set50_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:110:16: ( GROOVYEXPRESSION | STRING | ID | NUMBER )
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

    public static class tblfuncparam_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tblfuncparam"
    // com/sap/hadoop/windowing/parser/Windowing.g:114:1: tblfuncparam : (i= ID | i= STRING ) EQ v= functionparam -> ^( TBLFUNCPARAM $i $v) ;
    public final WindowingParser.tblfuncparam_return tblfuncparam() throws RecognitionException {
        WindowingParser.tblfuncparam_return retval = new WindowingParser.tblfuncparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token EQ51=null;
        WindowingParser.functionparam_return v = null;


        Object i_tree=null;
        Object EQ51_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_functionparam=new RewriteRuleSubtreeStream(adaptor,"rule functionparam");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:114:14: ( (i= ID | i= STRING ) EQ v= functionparam -> ^( TBLFUNCPARAM $i $v) )
            // com/sap/hadoop/windowing/parser/Windowing.g:115:3: (i= ID | i= STRING ) EQ v= functionparam
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:115:3: (i= ID | i= STRING )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:115:4: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_tblfuncparam688); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:115:9: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_tblfuncparam692); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ51=(Token)match(input,EQ,FOLLOW_EQ_in_tblfuncparam695); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ51);

            pushFollow(FOLLOW_functionparam_in_tblfuncparam699);
            v=functionparam();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionparam.add(v.getTree());


            // AST REWRITE
            // elements: v, i
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
            // 115:38: -> ^( TBLFUNCPARAM $i $v)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:115:41: ^( TBLFUNCPARAM $i $v)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:118:1: window_expression : OVER ( window_range_expression | window_value_expression ) ;
    public final WindowingParser.window_expression_return window_expression() throws RecognitionException {
        WindowingParser.window_expression_return retval = new WindowingParser.window_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OVER52=null;
        WindowingParser.window_range_expression_return window_range_expression53 = null;

        WindowingParser.window_value_expression_return window_value_expression54 = null;


        Object OVER52_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:118:19: ( OVER ( window_range_expression | window_value_expression ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:119:2: OVER ( window_range_expression | window_value_expression )
            {
            root_0 = (Object)adaptor.nil();

            OVER52=(Token)match(input,OVER,FOLLOW_OVER_in_window_expression721); if (state.failed) return retval;
            // com/sap/hadoop/windowing/parser/Windowing.g:120:2: ( window_range_expression | window_value_expression )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:120:3: window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression727);
                    window_range_expression53=window_range_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_range_expression53.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:121:2: window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression732);
                    window_value_expression54=window_value_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_value_expression54.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:125:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final WindowingParser.window_range_expression_return window_range_expression() throws RecognitionException {
        WindowingParser.window_range_expression_return retval = new WindowingParser.window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS55=null;
        Token BETWEEN56=null;
        Token AND57=null;
        WindowingParser.rowsboundary_return s = null;

        WindowingParser.rowsboundary_return e = null;


        Object ROWS55_tree=null;
        Object BETWEEN56_tree=null;
        Object AND57_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:125:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // com/sap/hadoop/windowing/parser/Windowing.g:126:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS55=(Token)match(input,ROWS,FOLLOW_ROWS_in_window_range_expression746); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ROWS.add(ROWS55);

            BETWEEN56=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression748); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN56);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression752);
            s=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(s.getTree());
            AND57=(Token)match(input,AND,FOLLOW_AND_in_window_range_expression754); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND57);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression758);
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
            // 126:49: -> ^( WINDOWRANGE $s $e)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:126:52: ^( WINDOWRANGE $s $e)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:129:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );
    public final WindowingParser.rowsboundary_return rowsboundary() throws RecognitionException {
        WindowingParser.rowsboundary_return retval = new WindowingParser.rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED58=null;
        Token CURRENT59=null;
        Token ROW60=null;
        Token NUMBER61=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED58_tree=null;
        Object CURRENT59_tree=null;
        Object ROW60_tree=null;
        Object NUMBER61_tree=null;
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:129:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:130:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED58=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary781); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED58);

                    // com/sap/hadoop/windowing/parser/Windowing.g:130:13: (r= PRECEDING | r= FOLLOWING )
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:130:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary786); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:130:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary790); if (state.failed) return retval; 
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
                    // 130:40: -> ^( $r UNBOUNDED )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:130:43: ^( $r UNBOUNDED )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:131:3: CURRENT ROW
                    {
                    CURRENT59=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary808); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT59);

                    ROW60=(Token)match(input,ROW,FOLLOW_ROW_in_rowsboundary810); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW60);



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
                    // 131:16: -> ^( CURRENT )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:131:19: ^( CURRENT )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:132:3: NUMBER (d= PRECEDING | d= FOLLOWING )
                    {
                    NUMBER61=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary823); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER61);

                    // com/sap/hadoop/windowing/parser/Windowing.g:132:10: (d= PRECEDING | d= FOLLOWING )
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:132:11: d= PRECEDING
                            {
                            d=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary828); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:132:25: d= FOLLOWING
                            {
                            d=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary834); if (state.failed) return retval; 
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
                    // 132:39: -> ^( $d NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:132:42: ^( $d NUMBER )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:135:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final WindowingParser.window_value_expression_return window_value_expression() throws RecognitionException {
        WindowingParser.window_value_expression_return retval = new WindowingParser.window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE62=null;
        Token BETWEEN63=null;
        Token AND64=null;
        WindowingParser.valuesboundary_return s = null;

        WindowingParser.valuesboundary_return e = null;


        Object RANGE62_tree=null;
        Object BETWEEN63_tree=null;
        Object AND64_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:135:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // com/sap/hadoop/windowing/parser/Windowing.g:136:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE62=(Token)match(input,RANGE,FOLLOW_RANGE_in_window_value_expression855); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE62);

            BETWEEN63=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression857); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN63);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression861);
            s=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(s.getTree());
            AND64=(Token)match(input,AND,FOLLOW_AND_in_window_value_expression863); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND64);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression867);
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
            // 136:54: -> ^( WINDOWVALUES $s $e)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:136:57: ^( WINDOWVALUES $s $e)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:139:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );
    public final WindowingParser.valuesboundary_return valuesboundary() throws RecognitionException {
        WindowingParser.valuesboundary_return retval = new WindowingParser.valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED65=null;
        Token CURRENT66=null;
        Token ROW67=null;
        Token GROOVYEXPRESSION68=null;
        Token NUMBER69=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED65_tree=null;
        Object CURRENT66_tree=null;
        Object ROW67_tree=null;
        Object GROOVYEXPRESSION68_tree=null;
        Object NUMBER69_tree=null;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:139:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:140:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED65=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary890); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED65);

                    // com/sap/hadoop/windowing/parser/Windowing.g:140:13: (r= PRECEDING | r= FOLLOWING )
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:140:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary895); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:140:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary899); if (state.failed) return retval; 
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
                    // 140:40: -> ^( $r UNBOUNDED )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:140:43: ^( $r UNBOUNDED )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:141:3: CURRENT ROW
                    {
                    CURRENT66=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary917); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT66);

                    ROW67=(Token)match(input,ROW,FOLLOW_ROW_in_valuesboundary919); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW67);



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
                    // 141:16: -> ^( CURRENT )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:141:19: ^( CURRENT )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:142:3: GROOVYEXPRESSION NUMBER (d= LESS | d= MORE )
                    {
                    GROOVYEXPRESSION68=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary932); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION68);

                    NUMBER69=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary934); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER69);

                    // com/sap/hadoop/windowing/parser/Windowing.g:142:27: (d= LESS | d= MORE )
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:142:28: d= LESS
                            {
                            d=(Token)match(input,LESS,FOLLOW_LESS_in_valuesboundary939); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:142:37: d= MORE
                            {
                            d=(Token)match(input,MORE,FOLLOW_MORE_in_valuesboundary945); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MORE.add(d);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: GROOVYEXPRESSION, d, NUMBER
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
                    // 142:46: -> ^( $d GROOVYEXPRESSION NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:142:49: ^( $d GROOVYEXPRESSION NUMBER )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:145:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final WindowingParser.select_return select() throws RecognitionException {
        WindowingParser.select_return retval = new WindowingParser.select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT70=null;
        Token COMMA72=null;
        WindowingParser.selectColumn_return selectColumn71 = null;

        WindowingParser.selectColumn_return selectColumn73 = null;


        Object SELECT70_tree=null;
        Object COMMA72_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:145:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:146:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT70=(Token)match(input,SELECT,FOLLOW_SELECT_in_select970); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT70);

            pushFollow(FOLLOW_selectColumn_in_select972);
            selectColumn71=selectColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn71.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:146:23: ( COMMA selectColumn )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:146:24: COMMA selectColumn
            	    {
            	    COMMA72=(Token)match(input,COMMA,FOLLOW_COMMA_in_select975); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA72);

            	    pushFollow(FOLLOW_selectColumn_in_select977);
            	    selectColumn73=selectColumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn73.getTree());

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
            // 146:46: -> ^( SELECT ( selectColumn )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:146:49: ^( SELECT ( selectColumn )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:149:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );
    public final WindowingParser.selectColumn_return selectColumn() throws RecognitionException {
        WindowingParser.selectColumn_return retval = new WindowingParser.selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token typeNm=null;
        Token GROOVYEXPRESSION74=null;
        Token AS75=null;
        Token ID76=null;
        Token LBRACKET77=null;
        Token RBRACKET78=null;
        Token ID79=null;

        Object typeNm_tree=null;
        Object GROOVYEXPRESSION74_tree=null;
        Object AS75_tree=null;
        Object ID76_tree=null;
        Object LBRACKET77_tree=null;
        Object RBRACKET78_tree=null;
        Object ID79_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:149:13: ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:150:3: GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )?
                    {
                    GROOVYEXPRESSION74=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn999); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION74);

                    AS75=(Token)match(input,AS,FOLLOW_AS_in_selectColumn1001); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS75);

                    ID76=(Token)match(input,ID,FOLLOW_ID_in_selectColumn1003); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID76);

                    // com/sap/hadoop/windowing/parser/Windowing.g:150:26: ( LBRACKET typeNm= ID RBRACKET )?
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:150:27: LBRACKET typeNm= ID RBRACKET
                            {
                            LBRACKET77=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_selectColumn1006); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET77);

                            typeNm=(Token)match(input,ID,FOLLOW_ID_in_selectColumn1010); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ID.add(typeNm);

                            RBRACKET78=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_selectColumn1012); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET78);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: typeNm, GROOVYEXPRESSION, ID
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
                    // 150:57: -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:150:60: ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());
                        // com/sap/hadoop/windowing/parser/Windowing.g:150:95: ( ^( TYPENAME $typeNm) )?
                        if ( stream_typeNm.hasNext() ) {
                            // com/sap/hadoop/windowing/parser/Windowing.g:150:95: ^( TYPENAME $typeNm)
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:151:3: ID
                    {
                    ID79=(Token)match(input,ID,FOLLOW_ID_in_selectColumn1038); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID79);



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
                    // 151:6: -> ^( SELECTCOLUMN ID )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:151:9: ^( SELECTCOLUMN ID )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:154:1: where : ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:154:7: ( ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:155:2: ( WHERE GROOVYEXPRESSION )
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:155:2: ( WHERE GROOVYEXPRESSION )
            // com/sap/hadoop/windowing/parser/Windowing.g:155:3: WHERE GROOVYEXPRESSION
            {
            WHERE80=(Token)match(input,WHERE,FOLLOW_WHERE_in_where1058); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHERE.add(WHERE80);

            GROOVYEXPRESSION81=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where1060); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION81);


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
            // 155:27: -> ^( WHERE GROOVYEXPRESSION )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:155:30: ^( WHERE GROOVYEXPRESSION )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:158:1: outputClause : INTO PATH EQ p= STRING (s= outputSerDe )? -> ^( OUTPUTSPEC $p ( $s)? ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:158:14: ( INTO PATH EQ p= STRING (s= outputSerDe )? -> ^( OUTPUTSPEC $p ( $s)? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:159:2: INTO PATH EQ p= STRING (s= outputSerDe )?
            {
            INTO82=(Token)match(input,INTO,FOLLOW_INTO_in_outputClause1079); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTO.add(INTO82);

            PATH83=(Token)match(input,PATH,FOLLOW_PATH_in_outputClause1081); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PATH.add(PATH83);

            EQ84=(Token)match(input,EQ,FOLLOW_EQ_in_outputClause1083); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ84);

            p=(Token)match(input,STRING,FOLLOW_STRING_in_outputClause1087); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(p);

            // com/sap/hadoop/windowing/parser/Windowing.g:159:25: (s= outputSerDe )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:159:25: s= outputSerDe
                    {
                    pushFollow(FOLLOW_outputSerDe_in_outputClause1091);
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
            // 159:39: -> ^( OUTPUTSPEC $p ( $s)? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:159:42: ^( OUTPUTSPEC $p ( $s)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUTSPEC, "OUTPUTSPEC"), root_1);

                adaptor.addChild(root_1, stream_p.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:159:58: ( $s)?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:162:1: outputSerDe : SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:162:13: ( SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:163:3: SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter
            {
            SERDE85=(Token)match(input,SERDE,FOLLOW_SERDE_in_outputSerDe1116); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SERDE.add(SERDE85);

            s=(Token)match(input,STRING,FOLLOW_STRING_in_outputSerDe1120); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(s);

            // com/sap/hadoop/windowing/parser/Windowing.g:163:19: (p= outputSerDePropeties )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:163:19: p= outputSerDePropeties
                    {
                    pushFollow(FOLLOW_outputSerDePropeties_in_outputSerDe1124);
                    p=outputSerDePropeties();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputSerDePropeties.add(p.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe1129);
            o=outputFormatOrWriter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_outputFormatOrWriter.add(o.getTree());


            // AST REWRITE
            // elements: SERDE, s, p, o
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
            // 163:65: -> ^( SERDE $s $o ( $p)? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:163:68: ^( SERDE $s $o ( $p)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_s.nextNode());
                adaptor.addChild(root_1, stream_o.nextTree());
                // com/sap/hadoop/windowing/parser/Windowing.g:163:82: ( $p)?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:166:1: outputSerDePropeties : WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:166:21: ( WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:167:3: WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            WITH86=(Token)match(input,WITH,FOLLOW_WITH_in_outputSerDePropeties1155); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WITH.add(WITH86);

            SERDEPROPERTIES87=(Token)match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1157); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SERDEPROPERTIES.add(SERDEPROPERTIES87);

            LPAREN88=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_outputSerDePropeties1159); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN88);

            // com/sap/hadoop/windowing/parser/Windowing.g:167:31: ( namevalue )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:167:32: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1162);
                    namevalue89=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue89.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:167:44: ( COMMA namevalue )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:167:45: COMMA namevalue
            	    {
            	    COMMA90=(Token)match(input,COMMA,FOLLOW_COMMA_in_outputSerDePropeties1167); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA90);

            	    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1169);
            	    namevalue91=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue91.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            RPAREN92=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_outputSerDePropeties1173); if (state.failed) return retval; 
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
            // 168:6: -> ^( SERDEPROPERTIES ( namevalue )* )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:168:9: ^( SERDEPROPERTIES ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDEPROPERTIES.nextNode(), root_1);

                // com/sap/hadoop/windowing/parser/Windowing.g:168:27: ( namevalue )*
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
    // com/sap/hadoop/windowing/parser/Windowing.g:171:1: outputFormatOrWriter : ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) );
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
            // com/sap/hadoop/windowing/parser/Windowing.g:171:22: ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:172:3: RECORDWRITER STRING
                    {
                    RECORDWRITER93=(Token)match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter1199); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RECORDWRITER.add(RECORDWRITER93);

                    STRING94=(Token)match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1201); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING94);



                    // AST REWRITE
                    // elements: STRING, RECORDWRITER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 172:23: -> ^( RECORDWRITER STRING )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:172:26: ^( RECORDWRITER STRING )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:173:3: FORMAT STRING
                    {
                    FORMAT95=(Token)match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter1215); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FORMAT.add(FORMAT95);

                    STRING96=(Token)match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1217); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING96);



                    // AST REWRITE
                    // elements: STRING, FORMAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 173:17: -> ^( FORMAT STRING )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:173:20: ^( FORMAT STRING )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:175:1: value_expression : ( numeric_expression | STRING );
    public final WindowingParser.value_expression_return value_expression() throws RecognitionException {
        WindowingParser.value_expression_return retval = new WindowingParser.value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING98=null;
        WindowingParser.numeric_expression_return numeric_expression97 = null;


        Object STRING98_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:175:18: ( numeric_expression | STRING )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:176:3: numeric_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_expression_in_value_expression1235);
                    numeric_expression97=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression97.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:177:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING98=(Token)match(input,STRING,FOLLOW_STRING_in_value_expression1241); if (state.failed) return retval;
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
    // com/sap/hadoop/windowing/parser/Windowing.g:180:1: numeric_expression : term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:180:20: ( term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* )
            // com/sap/hadoop/windowing/parser/Windowing.g:181:3: term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_numeric_expression1253);
            term99=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term99.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:181:8: ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:181:9: ( PLUS | MINUS )=> ( PLUS | MINUS ) term
            	    {
            	    // com/sap/hadoop/windowing/parser/Windowing.g:181:26: ( PLUS | MINUS )
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
            	            // com/sap/hadoop/windowing/parser/Windowing.g:181:27: PLUS
            	            {
            	            PLUS100=(Token)match(input,PLUS,FOLLOW_PLUS_in_numeric_expression1266); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS100_tree = (Object)adaptor.create(PLUS100);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS100_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/sap/hadoop/windowing/parser/Windowing.g:181:35: MINUS
            	            {
            	            MINUS101=(Token)match(input,MINUS,FOLLOW_MINUS_in_numeric_expression1271); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS101_tree = (Object)adaptor.create(MINUS101);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS101_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_numeric_expression1275);
            	    term102=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term102.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:184:1: term : numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:184:7: ( numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* )
            // com/sap/hadoop/windowing/parser/Windowing.g:185:3: numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_numeric_primary_expression_in_term1293);
            numeric_primary_expression103=numeric_primary_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression103.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:185:30: ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:185:31: ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression
            	    {
            	    // com/sap/hadoop/windowing/parser/Windowing.g:185:54: ( ASTERISK | SOLIDUS )
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
            	            // com/sap/hadoop/windowing/parser/Windowing.g:185:55: ASTERISK
            	            {
            	            ASTERISK104=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_term1306); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ASTERISK104_tree = (Object)adaptor.create(ASTERISK104);
            	            root_0 = (Object)adaptor.becomeRoot(ASTERISK104_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/sap/hadoop/windowing/parser/Windowing.g:185:67: SOLIDUS
            	            {
            	            SOLIDUS105=(Token)match(input,SOLIDUS,FOLLOW_SOLIDUS_in_term1311); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SOLIDUS105_tree = (Object)adaptor.create(SOLIDUS105);
            	            root_0 = (Object)adaptor.becomeRoot(SOLIDUS105_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_numeric_primary_expression_in_term1315);
            	    numeric_primary_expression106=numeric_primary_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression106.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:188:1: numeric_primary_expression : ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN );
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
            // com/sap/hadoop/windowing/parser/Windowing.g:188:28: ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:189:3: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_numeric_primary_expression1329);
                    identifier107=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier107.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:190:3: signed_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signed_numeric_literal_in_numeric_primary_expression1336);
                    signed_numeric_literal108=signed_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_numeric_literal108.getTree());

                    }
                    break;
                case 3 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:191:3: LPAREN numeric_expression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN109=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numeric_primary_expression1343); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN109_tree = (Object)adaptor.create(LPAREN109);
                    adaptor.addChild(root_0, LPAREN109_tree);
                    }
                    pushFollow(FOLLOW_numeric_expression_in_numeric_primary_expression1345);
                    numeric_expression110=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression110.getTree());
                    RPAREN111=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numeric_primary_expression1347); if (state.failed) return retval;
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
    // com/sap/hadoop/windowing/parser/Windowing.g:194:1: signed_numeric_literal : ( PLUS | MINUS )? unsigned_numeric_literal ;
    public final WindowingParser.signed_numeric_literal_return signed_numeric_literal() throws RecognitionException {
        WindowingParser.signed_numeric_literal_return retval = new WindowingParser.signed_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set112=null;
        WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal113 = null;


        Object set112_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:194:24: ( ( PLUS | MINUS )? unsigned_numeric_literal )
            // com/sap/hadoop/windowing/parser/Windowing.g:195:3: ( PLUS | MINUS )? unsigned_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            // com/sap/hadoop/windowing/parser/Windowing.g:195:3: ( PLUS | MINUS )?
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

            pushFollow(FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1366);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:201:1: unsigned_numeric_literal : ( exact_numeric_literal | approximate_numeric_literal );
    public final WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal() throws RecognitionException {
        WindowingParser.unsigned_numeric_literal_return retval = new WindowingParser.unsigned_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal114 = null;

        WindowingParser.approximate_numeric_literal_return approximate_numeric_literal115 = null;



        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:201:26: ( exact_numeric_literal | approximate_numeric_literal )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:202:3: exact_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1379);
                    exact_numeric_literal114=exact_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal114.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:203:3: approximate_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1385);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:206:1: approximate_numeric_literal : mantissa 'E' exponent ;
    public final WindowingParser.approximate_numeric_literal_return approximate_numeric_literal() throws RecognitionException {
        WindowingParser.approximate_numeric_literal_return retval = new WindowingParser.approximate_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal117=null;
        WindowingParser.mantissa_return mantissa116 = null;

        WindowingParser.exponent_return exponent118 = null;


        Object char_literal117_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:206:29: ( mantissa 'E' exponent )
            // com/sap/hadoop/windowing/parser/Windowing.g:207:3: mantissa 'E' exponent
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mantissa_in_approximate_numeric_literal1396);
            mantissa116=mantissa();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mantissa116.getTree());
            char_literal117=(Token)match(input,105,FOLLOW_105_in_approximate_numeric_literal1398); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal117_tree = (Object)adaptor.create(char_literal117);
            adaptor.addChild(root_0, char_literal117_tree);
            }
            pushFollow(FOLLOW_exponent_in_approximate_numeric_literal1400);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:210:1: exponent : ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER );
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
            // com/sap/hadoop/windowing/parser/Windowing.g:210:10: ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:211:3: PLUS NUMBER
                    {
                    PLUS119=(Token)match(input,PLUS,FOLLOW_PLUS_in_exponent1411); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS119);

                    NUMBER120=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1413); if (state.failed) return retval; 
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
                    // 211:15: -> NUMBER
                    {
                        adaptor.addChild(root_0, stream_NUMBER.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:212:3: MINUS NUMBER
                    {
                    MINUS121=(Token)match(input,MINUS,FOLLOW_MINUS_in_exponent1423); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS121);

                    NUMBER122=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1425); if (state.failed) return retval; 
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
                    // 212:16: -> ^( UMINUS NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:212:19: ^( UMINUS NUMBER )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:213:3: NUMBER
                    {
                    NUMBER123=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1439); if (state.failed) return retval; 
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
                    // 213:10: -> NUMBER
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
    // com/sap/hadoop/windowing/parser/Windowing.g:216:1: mantissa : exact_numeric_literal ;
    public final WindowingParser.mantissa_return mantissa() throws RecognitionException {
        WindowingParser.mantissa_return retval = new WindowingParser.mantissa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal124 = null;



        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:216:10: ( exact_numeric_literal )
            // com/sap/hadoop/windowing/parser/Windowing.g:217:3: exact_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_exact_numeric_literal_in_mantissa1455);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:220:1: exact_numeric_literal : (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->);
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
            // com/sap/hadoop/windowing/parser/Windowing.g:220:23: (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->)
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:222:3: n1= NUMBER ( DOT n2= NUMBER )?
                    {
                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1471); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(n1);

                    // com/sap/hadoop/windowing/parser/Windowing.g:222:13: ( DOT n2= NUMBER )?
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:222:14: DOT n2= NUMBER
                            {
                            DOT125=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1474); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT125);

                            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1478); if (state.failed) return retval; 
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
                    // 222:31: ->
                    {
                        adaptor.addChild(root_0, 
                        	      ( n2 != null ? adaptor.create(NUMERIC, (n1!=null?n1.getText():null) + '.' + (n2!=null?n2.getText():null)) :  adaptor.create(INTEGER, (n1!=null?n1.getText():null)) )
                              );

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:226:3: DOT n1= NUMBER
                    {
                    DOT126=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1499); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT126);

                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1503); if (state.failed) return retval; 
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
                    // 226:17: ->
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
    // com/sap/hadoop/windowing/parser/Windowing.g:229:1: identifier : ID ;
    public final WindowingParser.identifier_return identifier() throws RecognitionException {
        WindowingParser.identifier_return retval = new WindowingParser.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID127=null;

        Object ID127_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:229:12: ( ID )
            // com/sap/hadoop/windowing/parser/Windowing.g:230:3: ID
            {
            root_0 = (Object)adaptor.nil();

            ID127=(Token)match(input,ID,FOLLOW_ID_in_identifier1519); if (state.failed) return retval;
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
        // com/sap/hadoop/windowing/parser/Windowing.g:181:9: ( PLUS | MINUS )
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
        // com/sap/hadoop/windowing/parser/Windowing.g:185:31: ( ASTERISK | SOLIDUS )
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


 

    public static final BitSet FOLLOW_FROM_in_query147 = new BitSet(new long[]{0x0000000004E00000L});
    public static final BitSet FOLLOW_tableSpec_in_query149 = new BitSet(new long[]{0x0004000000100000L});
    public static final BitSet FOLLOW_WITH_in_query153 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_funclist_in_query155 = new BitSet(new long[]{0x0004000000100000L});
    public static final BitSet FOLLOW_select_in_query160 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_where_in_query163 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_outputClause_in_query168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hivetable_in_tableSpec206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tableSpec211 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_tableSpec215 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_tableSpec219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_tableSpec240 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_tableSpec244 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_tableSpec248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tableSpec268 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_tableSpec272 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_tableSpec276 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_tableSpec280 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_tableSpec282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tblfunc_in_tableSpec303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tblfunc316 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LPAREN_in_tblfunc318 = new BitSet(new long[]{0x0000000004E00000L});
    public static final BitSet FOLLOW_tableSpec_in_tblfunc320 = new BitSet(new long[]{0x0000004003000000L});
    public static final BitSet FOLLOW_window_expression_in_tblfunc323 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_COMMA_in_tblfunc328 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_tblfuncparam_in_tblfunc330 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RPAREN_in_tblfunc334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hivetable367 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LPAREN_in_hivetable369 = new BitSet(new long[]{0x000000000B200000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable372 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_COMMA_in_hivetable377 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable379 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RPAREN_in_hivetable383 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_hivetable388 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_hivetable392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namevalue420 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue424 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EQ_in_namevalue427 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby453 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_BY_in_orderby455 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby457 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_orderby460 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby462 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ID_in_ordercolumn483 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby519 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_BY_in_partitionby521 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_partitionby523 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby526 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_partitionby528 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_function_in_funclist550 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_funclist553 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_function_in_funclist555 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ID_in_function579 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LPAREN_in_function581 = new BitSet(new long[]{0x000000200B600000L});
    public static final BitSet FOLLOW_functionparam_in_function584 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_COMMA_in_function589 = new BitSet(new long[]{0x0000002008600000L});
    public static final BitSet FOLLOW_functionparam_in_function591 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RPAREN_in_function595 = new BitSet(new long[]{0x0000004400000000L});
    public static final BitSet FOLLOW_window_expression_in_function598 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_AS_in_function602 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_function606 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_LBRACKET_in_function609 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_function613 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_function615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionparam0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tblfuncparam688 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_STRING_in_tblfuncparam692 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EQ_in_tblfuncparam695 = new BitSet(new long[]{0x0000002008600000L});
    public static final BitSet FOLLOW_functionparam_in_tblfuncparam699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_expression721 = new BitSet(new long[]{0x0000808000000000L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression746 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression748 = new BitSet(new long[]{0x0000242000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression752 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_AND_in_window_range_expression754 = new BitSet(new long[]{0x0000242000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary781 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary808 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary823 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression855 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression857 = new BitSet(new long[]{0x0000240000400000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression861 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_AND_in_window_value_expression863 = new BitSet(new long[]{0x0000240000400000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary890 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary917 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary932 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary934 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select970 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_selectColumn_in_select972 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_select975 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_selectColumn_in_select977 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn999 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn1001 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_selectColumn1003 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selectColumn1006 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_selectColumn1010 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selectColumn1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selectColumn1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where1058 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_outputClause1079 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_PATH_in_outputClause1081 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause1083 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause1087 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_outputSerDe_in_outputClause1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERDE_in_outputSerDe1116 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputSerDe1120 = new BitSet(new long[]{0x0300000000100000L});
    public static final BitSet FOLLOW_outputSerDePropeties_in_outputSerDe1124 = new BitSet(new long[]{0x0300000000100000L});
    public static final BitSet FOLLOW_outputFormatOrWriter_in_outputSerDe1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_outputSerDePropeties1155 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1157 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LPAREN_in_outputSerDePropeties1159 = new BitSet(new long[]{0x000000000B200000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1162 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_COMMA_in_outputSerDePropeties1167 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1169 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_RPAREN_in_outputSerDePropeties1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORDWRITER_in_outputFormatOrWriter1199 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAT_in_outputFormatOrWriter1215 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_expression_in_value_expression1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_value_expression1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_numeric_expression1253 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_PLUS_in_numeric_expression1266 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_MINUS_in_numeric_expression1271 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_term_in_numeric_expression1275 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1293 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_ASTERISK_in_term1306 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_SOLIDUS_in_term1311 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1315 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_identifier_in_numeric_primary_expression1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signed_numeric_literal_in_numeric_primary_expression1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_primary_expression1343 = new BitSet(new long[]{0x4C00002000A00000L});
    public static final BitSet FOLLOW_numeric_expression_in_numeric_primary_expression1345 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_primary_expression1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_signed_numeric_literal1359 = new BitSet(new long[]{0x4C00002000000000L});
    public static final BitSet FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mantissa_in_approximate_numeric_literal1396 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_approximate_numeric_literal1398 = new BitSet(new long[]{0x0C00002000000000L});
    public static final BitSet FOLLOW_exponent_in_approximate_numeric_literal1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_exponent1411 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_exponent1423 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_mantissa1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1471 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1474 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1499 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier1519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1_Windowing1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred2_Windowing1296 = new BitSet(new long[]{0x0000000000000002L});

}