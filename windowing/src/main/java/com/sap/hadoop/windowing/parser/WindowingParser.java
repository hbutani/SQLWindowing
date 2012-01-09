// $ANTLR 3.3 Nov 30, 2010 12:46:29 com\\sap\\hadoop\\windowing\\parser\\Windowing.g 2012-01-09 14:16:12

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "FROM", "WITH", "ID", "LPAREN", "GROOVYEXPRESSION", "RPAREN", "TABLEINPUT", "COMMA", "STRING", "EQ", "ORDER", "BY", "ASC", "DESC", "PARTITION", "AS", "LBRACKET", "RBRACKET", "NUMBER", "OVER", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "RANGE", "LESS", "MORE", "SELECT", "WHERE", "INTO", "PATH", "FORMAT", "PLUS", "MINUS", "ASTERISK", "SOLIDUS", "DOT", "QUOTE", "COLON", "SEMICOLON", "GE", "GT", "LBRACE", "LE", "LT", "NE", "RBRACE", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "B", "I", "N", "P", "U", "D", "Y", "G", "V", "NOT", "OR", "X", "XOR", "GroovyEscapeSequence", "EscapeSequence", "WS", "J", "K", "Q", "Z", "'E'"
    };
    public static final int EOF=-1;
    public static final int T__100=100;
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
    public static final int FROM=17;
    public static final int WITH=18;
    public static final int ID=19;
    public static final int LPAREN=20;
    public static final int GROOVYEXPRESSION=21;
    public static final int RPAREN=22;
    public static final int TABLEINPUT=23;
    public static final int COMMA=24;
    public static final int STRING=25;
    public static final int EQ=26;
    public static final int ORDER=27;
    public static final int BY=28;
    public static final int ASC=29;
    public static final int DESC=30;
    public static final int PARTITION=31;
    public static final int AS=32;
    public static final int LBRACKET=33;
    public static final int RBRACKET=34;
    public static final int NUMBER=35;
    public static final int OVER=36;
    public static final int ROWS=37;
    public static final int BETWEEN=38;
    public static final int AND=39;
    public static final int UNBOUNDED=40;
    public static final int PRECEDING=41;
    public static final int FOLLOWING=42;
    public static final int CURRENT=43;
    public static final int ROW=44;
    public static final int RANGE=45;
    public static final int LESS=46;
    public static final int MORE=47;
    public static final int SELECT=48;
    public static final int WHERE=49;
    public static final int INTO=50;
    public static final int PATH=51;
    public static final int FORMAT=52;
    public static final int PLUS=53;
    public static final int MINUS=54;
    public static final int ASTERISK=55;
    public static final int SOLIDUS=56;
    public static final int DOT=57;
    public static final int QUOTE=58;
    public static final int COLON=59;
    public static final int SEMICOLON=60;
    public static final int GE=61;
    public static final int GT=62;
    public static final int LBRACE=63;
    public static final int LE=64;
    public static final int LT=65;
    public static final int NE=66;
    public static final int RBRACE=67;
    public static final int S=68;
    public static final int E=69;
    public static final int L=70;
    public static final int C=71;
    public static final int T=72;
    public static final int F=73;
    public static final int R=74;
    public static final int O=75;
    public static final int M=76;
    public static final int W=77;
    public static final int H=78;
    public static final int A=79;
    public static final int B=80;
    public static final int I=81;
    public static final int N=82;
    public static final int P=83;
    public static final int U=84;
    public static final int D=85;
    public static final int Y=86;
    public static final int G=87;
    public static final int V=88;
    public static final int NOT=89;
    public static final int OR=90;
    public static final int X=91;
    public static final int XOR=92;
    public static final int GroovyEscapeSequence=93;
    public static final int EscapeSequence=94;
    public static final int WS=95;
    public static final int J=96;
    public static final int K=97;
    public static final int Q=98;
    public static final int Z=99;

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


    public static class query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:53:1: query : FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )? -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? ) ;
    public final WindowingParser.query_return query() throws RecognitionException {
        WindowingParser.query_return retval = new WindowingParser.query_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FROM1=null;
        Token WITH5=null;
        WindowingParser.tableSpec_return tableSpec2 = null;

        WindowingParser.partitionby_return partitionby3 = null;

        WindowingParser.orderby_return orderby4 = null;

        WindowingParser.funclist_return funclist6 = null;

        WindowingParser.select_return select7 = null;

        WindowingParser.where_return where8 = null;

        WindowingParser.outputClause_return outputClause9 = null;


        Object FROM1_tree=null;
        Object WITH5_tree=null;
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_funclist=new RewriteRuleSubtreeStream(adaptor,"rule funclist");
        RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        RewriteRuleSubtreeStream stream_where=new RewriteRuleSubtreeStream(adaptor,"rule where");
        RewriteRuleSubtreeStream stream_outputClause=new RewriteRuleSubtreeStream(adaptor,"rule outputClause");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:53:7: ( FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )? -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:54:2: FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )?
            {
            FROM1=(Token)match(input,FROM,FOLLOW_FROM_in_query138); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM1);

            pushFollow(FOLLOW_tableSpec_in_query140);
            tableSpec2=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec2.getTree());
            pushFollow(FOLLOW_partitionby_in_query143);
            partitionby3=partitionby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionby.add(partitionby3.getTree());
            pushFollow(FOLLOW_orderby_in_query146);
            orderby4=orderby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orderby.add(orderby4.getTree());
            WITH5=(Token)match(input,WITH,FOLLOW_WITH_in_query149); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WITH.add(WITH5);

            pushFollow(FOLLOW_funclist_in_query151);
            funclist6=funclist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_funclist.add(funclist6.getTree());
            pushFollow(FOLLOW_select_in_query154);
            select7=select();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select.add(select7.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:59:2: ( where )?
            int alt1=2;
            switch ( input.LA(1) ) {
                case WHERE:
                    {
                    alt1=1;
                    }
                    break;
            }

            switch (alt1) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:59:2: where
                    {
                    pushFollow(FOLLOW_where_in_query157);
                    where8=where();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_where.add(where8.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:60:2: ( outputClause )?
            int alt2=2;
            switch ( input.LA(1) ) {
                case INTO:
                    {
                    alt2=1;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:60:2: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_query162);
                    outputClause9=outputClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputClause.add(outputClause9.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: funclist, tableSpec, where, select, orderby, partitionby, outputClause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 60:16: -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:60:19: ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                adaptor.addChild(root_1, stream_partitionby.nextTree());
                adaptor.addChild(root_1, stream_orderby.nextTree());
                adaptor.addChild(root_1, stream_funclist.nextTree());
                adaptor.addChild(root_1, stream_select.nextTree());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:60:73: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.nextTree());

                }
                stream_where.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:60:80: ( outputClause )?
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:63:1: tableSpec : ( hivetable | ID -> ^( TABLEINPUT ID ) | ( LPAREN )? h= GROOVYEXPRESSION ( RPAREN )? -> ^( TABLEINPUT $h) );
    public final WindowingParser.tableSpec_return tableSpec() throws RecognitionException {
        WindowingParser.tableSpec_return retval = new WindowingParser.tableSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token h=null;
        Token ID11=null;
        Token LPAREN12=null;
        Token RPAREN13=null;
        WindowingParser.hivetable_return hivetable10 = null;


        Object h_tree=null;
        Object ID11_tree=null;
        Object LPAREN12_tree=null;
        Object RPAREN13_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:63:11: ( hivetable | ID -> ^( TABLEINPUT ID ) | ( LPAREN )? h= GROOVYEXPRESSION ( RPAREN )? -> ^( TABLEINPUT $h) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case TABLEINPUT:
                {
                alt5=1;
                }
                break;
            case ID:
                {
                alt5=2;
                }
                break;
            case LPAREN:
            case GROOVYEXPRESSION:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:64:2: hivetable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hivetable_in_tableSpec195);
                    hivetable10=hivetable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hivetable10.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:65:2: ID
                    {
                    ID11=(Token)match(input,ID,FOLLOW_ID_in_tableSpec200); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID11);



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
                    // 65:5: -> ^( TABLEINPUT ID )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:65:8: ^( TABLEINPUT ID )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:66:2: ( LPAREN )? h= GROOVYEXPRESSION ( RPAREN )?
                    {
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:66:2: ( LPAREN )?
                    int alt3=2;
                    switch ( input.LA(1) ) {
                        case LPAREN:
                            {
                            alt3=1;
                            }
                            break;
                    }

                    switch (alt3) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:66:2: LPAREN
                            {
                            LPAREN12=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tableSpec213); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN12);


                            }
                            break;

                    }

                    h=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_tableSpec218); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(h);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:66:29: ( RPAREN )?
                    int alt4=2;
                    switch ( input.LA(1) ) {
                        case RPAREN:
                            {
                            alt4=1;
                            }
                            break;
                    }

                    switch (alt4) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:66:29: RPAREN
                            {
                            RPAREN13=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tableSpec220); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN13);


                            }
                            break;

                    }



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
                    // 66:37: -> ^( TABLEINPUT $h)
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:66:40: ^( TABLEINPUT $h)
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

    public static class hivetable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hivetable"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:69:1: hivetable : TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) ;
    public final WindowingParser.hivetable_return hivetable() throws RecognitionException {
        WindowingParser.hivetable_return retval = new WindowingParser.hivetable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TABLEINPUT14=null;
        Token LPAREN15=null;
        Token COMMA17=null;
        Token RPAREN19=null;
        WindowingParser.namevalue_return namevalue16 = null;

        WindowingParser.namevalue_return namevalue18 = null;


        Object TABLEINPUT14_tree=null;
        Object LPAREN15_tree=null;
        Object COMMA17_tree=null;
        Object RPAREN19_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_TABLEINPUT=new RewriteRuleTokenStream(adaptor,"token TABLEINPUT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:69:11: ( TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:2: TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            TABLEINPUT14=(Token)match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hivetable240); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TABLEINPUT.add(TABLEINPUT14);

            LPAREN15=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_hivetable242); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN15);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:20: ( namevalue )?
            int alt6=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                    {
                    alt6=1;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:21: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hivetable245);
                    namevalue16=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue16.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:33: ( COMMA namevalue )*
            loop7:
            do {
                int alt7=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt7=1;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:34: COMMA namevalue
            	    {
            	    COMMA17=(Token)match(input,COMMA,FOLLOW_COMMA_in_hivetable250); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA17);

            	    pushFollow(FOLLOW_namevalue_in_hivetable252);
            	    namevalue18=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue18.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            RPAREN19=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_hivetable256); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN19);



            // AST REWRITE
            // elements: namevalue, TABLEINPUT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 70:60: -> ^( TABLEINPUT ( namevalue )* )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:63: ^( TABLEINPUT ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_TABLEINPUT.nextNode(), root_1);

                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:76: ( namevalue )*
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:73:1: namevalue : (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) ;
    public final WindowingParser.namevalue_return namevalue() throws RecognitionException {
        WindowingParser.namevalue_return retval = new WindowingParser.namevalue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token v=null;
        Token EQ20=null;

        Object i_tree=null;
        Object v_tree=null;
        Object EQ20_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:73:11: ( (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:2: (i= ID | i= STRING ) EQ v= STRING
            {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:2: (i= ID | i= STRING )
            int alt8=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt8=1;
                }
                break;
            case STRING:
                {
                alt8=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:3: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_namevalue279); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:8: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue283); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ20=(Token)match(input,EQ,FOLLOW_EQ_in_namevalue286); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ20);

            v=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue290); if (state.failed) return retval; 
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
            // 74:30: -> ^( PARAM $i $v)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:33: ^( PARAM $i $v)
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:77:1: orderby : ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
    public final WindowingParser.orderby_return orderby() throws RecognitionException {
        WindowingParser.orderby_return retval = new WindowingParser.orderby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER21=null;
        Token BY22=null;
        Token COMMA24=null;
        WindowingParser.ordercolumn_return ordercolumn23 = null;

        WindowingParser.ordercolumn_return ordercolumn25 = null;


        Object ORDER21_tree=null;
        Object BY22_tree=null;
        Object COMMA24_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_ordercolumn=new RewriteRuleSubtreeStream(adaptor,"rule ordercolumn");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:77:9: ( ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:78:2: ORDER BY ordercolumn ( COMMA ordercolumn )*
            {
            ORDER21=(Token)match(input,ORDER,FOLLOW_ORDER_in_orderby312); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ORDER.add(ORDER21);

            BY22=(Token)match(input,BY,FOLLOW_BY_in_orderby314); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY22);

            pushFollow(FOLLOW_ordercolumn_in_orderby316);
            ordercolumn23=ordercolumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn23.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:78:23: ( COMMA ordercolumn )*
            loop9:
            do {
                int alt9=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt9=1;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:78:24: COMMA ordercolumn
            	    {
            	    COMMA24=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderby319); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA24);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby321);
            	    ordercolumn25=ordercolumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn25.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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
            // 78:44: -> ^( ORDER ( ordercolumn )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:78:47: ^( ORDER ( ordercolumn )+ )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:81:1: ordercolumn : ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) ;
    public final WindowingParser.ordercolumn_return ordercolumn() throws RecognitionException {
        WindowingParser.ordercolumn_return retval = new WindowingParser.ordercolumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token o=null;
        Token ID26=null;

        Object o_tree=null;
        Object ID26_tree=null;
        RewriteRuleTokenStream stream_ASC=new RewriteRuleTokenStream(adaptor,"token ASC");
        RewriteRuleTokenStream stream_DESC=new RewriteRuleTokenStream(adaptor,"token DESC");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:81:13: ( ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:82:2: ID (o= ASC | o= DESC )?
            {
            ID26=(Token)match(input,ID,FOLLOW_ID_in_ordercolumn342); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID26);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:82:5: (o= ASC | o= DESC )?
            int alt10=3;
            switch ( input.LA(1) ) {
                case ASC:
                    {
                    alt10=1;
                    }
                    break;
                case DESC:
                    {
                    alt10=2;
                    }
                    break;
            }

            switch (alt10) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:82:6: o= ASC
                    {
                    o=(Token)match(input,ASC,FOLLOW_ASC_in_ordercolumn347); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:82:14: o= DESC
                    {
                    o=(Token)match(input,DESC,FOLLOW_DESC_in_ordercolumn353); if (state.failed) return retval; 
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
            // 82:23: -> ^( ORDERCOLUMN ID ( $o)? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:82:26: ^( ORDERCOLUMN ID ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:82:43: ( $o)?
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:85:1: partitionby : PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) ;
    public final WindowingParser.partitionby_return partitionby() throws RecognitionException {
        WindowingParser.partitionby_return retval = new WindowingParser.partitionby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PARTITION27=null;
        Token BY28=null;
        Token ID29=null;
        Token COMMA30=null;
        Token ID31=null;

        Object PARTITION27_tree=null;
        Object BY28_tree=null;
        Object ID29_tree=null;
        Object COMMA30_tree=null;
        Object ID31_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:85:13: ( PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:86:2: PARTITION BY ID ( COMMA ID )*
            {
            PARTITION27=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_partitionby378); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARTITION.add(PARTITION27);

            BY28=(Token)match(input,BY,FOLLOW_BY_in_partitionby380); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY28);

            ID29=(Token)match(input,ID,FOLLOW_ID_in_partitionby382); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID29);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:86:18: ( COMMA ID )*
            loop11:
            do {
                int alt11=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt11=1;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:86:19: COMMA ID
            	    {
            	    COMMA30=(Token)match(input,COMMA,FOLLOW_COMMA_in_partitionby385); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA30);

            	    ID31=(Token)match(input,ID,FOLLOW_ID_in_partitionby387); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID31);


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);



            // AST REWRITE
            // elements: ID, PARTITION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 86:30: -> ^( PARTITION ( ID )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:86:33: ^( PARTITION ( ID )+ )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:89:1: funclist : function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) ;
    public final WindowingParser.funclist_return funclist() throws RecognitionException {
        WindowingParser.funclist_return retval = new WindowingParser.funclist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA33=null;
        WindowingParser.function_return function32 = null;

        WindowingParser.function_return function34 = null;


        Object COMMA33_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:89:10: ( function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:90:2: function ( COMMA function )*
            {
            pushFollow(FOLLOW_function_in_funclist409);
            function32=function();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function.add(function32.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:90:11: ( COMMA function )*
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
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:90:12: COMMA function
            	    {
            	    COMMA33=(Token)match(input,COMMA,FOLLOW_COMMA_in_funclist412); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA33);

            	    pushFollow(FOLLOW_function_in_funclist414);
            	    function34=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function.add(function34.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
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
            // 90:29: -> ^( FUNCTIONS ( function )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:90:32: ^( FUNCTIONS ( function )+ )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:93:1: function : name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) ;
    public final WindowingParser.function_return function() throws RecognitionException {
        WindowingParser.function_return retval = new WindowingParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token alias=null;
        Token typeNm=null;
        Token LPAREN35=null;
        Token COMMA37=null;
        Token RPAREN39=null;
        Token AS41=null;
        Token LBRACKET42=null;
        Token RBRACKET43=null;
        WindowingParser.functionparam_return functionparam36 = null;

        WindowingParser.functionparam_return functionparam38 = null;

        WindowingParser.window_expression_return window_expression40 = null;


        Object name_tree=null;
        Object alias_tree=null;
        Object typeNm_tree=null;
        Object LPAREN35_tree=null;
        Object COMMA37_tree=null;
        Object RPAREN39_tree=null;
        Object AS41_tree=null;
        Object LBRACKET42_tree=null;
        Object RBRACKET43_tree=null;
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
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:93:10: (name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:2: name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )?
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_function438); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN35=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function440); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN35);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:17: ( functionparam )?
            int alt13=2;
            switch ( input.LA(1) ) {
                case ID:
                case GROOVYEXPRESSION:
                case STRING:
                case NUMBER:
                    {
                    alt13=1;
                    }
                    break;
            }

            switch (alt13) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:18: functionparam
                    {
                    pushFollow(FOLLOW_functionparam_in_function443);
                    functionparam36=functionparam();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionparam.add(functionparam36.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:34: ( COMMA functionparam )*
            loop14:
            do {
                int alt14=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt14=1;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:35: COMMA functionparam
            	    {
            	    COMMA37=(Token)match(input,COMMA,FOLLOW_COMMA_in_function448); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA37);

            	    pushFollow(FOLLOW_functionparam_in_function450);
            	    functionparam38=functionparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_functionparam.add(functionparam38.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            RPAREN39=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function454); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN39);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:64: ( window_expression )?
            int alt15=2;
            switch ( input.LA(1) ) {
                case OVER:
                    {
                    alt15=1;
                    }
                    break;
            }

            switch (alt15) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:65: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function457);
                    window_expression40=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression40.getTree());

                    }
                    break;

            }

            AS41=(Token)match(input,AS,FOLLOW_AS_in_function461); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AS.add(AS41);

            alias=(Token)match(input,ID,FOLLOW_ID_in_function465); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(alias);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:97: ( LBRACKET typeNm= ID RBRACKET )?
            int alt16=2;
            switch ( input.LA(1) ) {
                case LBRACKET:
                    {
                    alt16=1;
                    }
                    break;
            }

            switch (alt16) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:98: LBRACKET typeNm= ID RBRACKET
                    {
                    LBRACKET42=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_function468); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET42);

                    typeNm=(Token)match(input,ID,FOLLOW_ID_in_function472); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(typeNm);

                    RBRACKET43=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_function474); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET43);


                    }
                    break;

            }



            // AST REWRITE
            // elements: functionparam, name, window_expression, alias, typeNm
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
            // 94:128: -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:7: ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_alias.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:31: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.nextTree());

                }
                stream_functionparam.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:46: ( ^( TYPENAME $typeNm) )?
                if ( stream_typeNm.hasNext() ) {
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:46: ^( TYPENAME $typeNm)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                    adaptor.addChild(root_2, stream_typeNm.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_typeNm.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:67: ( window_expression )?
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:98:1: functionparam : ( GROOVYEXPRESSION | STRING | ID | NUMBER );
    public final WindowingParser.functionparam_return functionparam() throws RecognitionException {
        WindowingParser.functionparam_return retval = new WindowingParser.functionparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set44=null;

        Object set44_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:98:16: ( GROOVYEXPRESSION | STRING | ID | NUMBER )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set44=(Token)input.LT(1);
            if ( input.LA(1)==ID||input.LA(1)==GROOVYEXPRESSION||input.LA(1)==STRING||input.LA(1)==NUMBER ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set44));
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:102:1: window_expression : OVER ( window_range_expression | window_value_expression ) ;
    public final WindowingParser.window_expression_return window_expression() throws RecognitionException {
        WindowingParser.window_expression_return retval = new WindowingParser.window_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OVER45=null;
        WindowingParser.window_range_expression_return window_range_expression46 = null;

        WindowingParser.window_value_expression_return window_value_expression47 = null;


        Object OVER45_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:102:19: ( OVER ( window_range_expression | window_value_expression ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:103:2: OVER ( window_range_expression | window_value_expression )
            {
            root_0 = (Object)adaptor.nil();

            OVER45=(Token)match(input,OVER,FOLLOW_OVER_in_window_expression543); if (state.failed) return retval;
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:104:2: ( window_range_expression | window_value_expression )
            int alt17=2;
            switch ( input.LA(1) ) {
            case ROWS:
                {
                alt17=1;
                }
                break;
            case RANGE:
                {
                alt17=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:104:3: window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression549);
                    window_range_expression46=window_range_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_range_expression46.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:105:2: window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression554);
                    window_value_expression47=window_value_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_value_expression47.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final WindowingParser.window_range_expression_return window_range_expression() throws RecognitionException {
        WindowingParser.window_range_expression_return retval = new WindowingParser.window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS48=null;
        Token BETWEEN49=null;
        Token AND50=null;
        WindowingParser.rowsboundary_return s = null;

        WindowingParser.rowsboundary_return e = null;


        Object ROWS48_tree=null;
        Object BETWEEN49_tree=null;
        Object AND50_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:110:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS48=(Token)match(input,ROWS,FOLLOW_ROWS_in_window_range_expression568); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ROWS.add(ROWS48);

            BETWEEN49=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression570); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN49);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression574);
            s=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(s.getTree());
            AND50=(Token)match(input,AND,FOLLOW_AND_in_window_range_expression576); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND50);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression580);
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
            // 110:49: -> ^( WINDOWRANGE $s $e)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:110:52: ^( WINDOWRANGE $s $e)
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:113:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );
    public final WindowingParser.rowsboundary_return rowsboundary() throws RecognitionException {
        WindowingParser.rowsboundary_return retval = new WindowingParser.rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED51=null;
        Token CURRENT52=null;
        Token ROW53=null;
        Token NUMBER54=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED51_tree=null;
        Object CURRENT52_tree=null;
        Object ROW53_tree=null;
        Object NUMBER54_tree=null;
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:113:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt20=1;
                }
                break;
            case CURRENT:
                {
                alt20=2;
                }
                break;
            case NUMBER:
                {
                alt20=3;
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:114:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED51=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary603); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED51);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:114:13: (r= PRECEDING | r= FOLLOWING )
                    int alt18=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt18=1;
                        }
                        break;
                    case FOLLOWING:
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:114:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary608); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:114:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary612); if (state.failed) return retval; 
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
                    // 114:40: -> ^( $r UNBOUNDED )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:114:43: ^( $r UNBOUNDED )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:115:3: CURRENT ROW
                    {
                    CURRENT52=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary630); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT52);

                    ROW53=(Token)match(input,ROW,FOLLOW_ROW_in_rowsboundary632); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW53);



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
                    // 115:16: -> ^( CURRENT )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:115:19: ^( CURRENT )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:116:3: NUMBER (d= PRECEDING | d= FOLLOWING )
                    {
                    NUMBER54=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary645); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER54);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:116:10: (d= PRECEDING | d= FOLLOWING )
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:116:11: d= PRECEDING
                            {
                            d=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary650); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:116:25: d= FOLLOWING
                            {
                            d=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary656); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_FOLLOWING.add(d);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: NUMBER, d
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
                    // 116:39: -> ^( $d NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:116:42: ^( $d NUMBER )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:119:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final WindowingParser.window_value_expression_return window_value_expression() throws RecognitionException {
        WindowingParser.window_value_expression_return retval = new WindowingParser.window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE55=null;
        Token BETWEEN56=null;
        Token AND57=null;
        WindowingParser.valuesboundary_return s = null;

        WindowingParser.valuesboundary_return e = null;


        Object RANGE55_tree=null;
        Object BETWEEN56_tree=null;
        Object AND57_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:119:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:120:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE55=(Token)match(input,RANGE,FOLLOW_RANGE_in_window_value_expression677); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE55);

            BETWEEN56=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression679); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN56);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression683);
            s=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(s.getTree());
            AND57=(Token)match(input,AND,FOLLOW_AND_in_window_value_expression685); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND57);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression689);
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
            // 120:54: -> ^( WINDOWVALUES $s $e)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:120:57: ^( WINDOWVALUES $s $e)
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:123:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );
    public final WindowingParser.valuesboundary_return valuesboundary() throws RecognitionException {
        WindowingParser.valuesboundary_return retval = new WindowingParser.valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED58=null;
        Token CURRENT59=null;
        Token ROW60=null;
        Token GROOVYEXPRESSION61=null;
        Token NUMBER62=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED58_tree=null;
        Object CURRENT59_tree=null;
        Object ROW60_tree=null;
        Object GROOVYEXPRESSION61_tree=null;
        Object NUMBER62_tree=null;
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
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:123:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt23=1;
                }
                break;
            case CURRENT:
                {
                alt23=2;
                }
                break;
            case GROOVYEXPRESSION:
                {
                alt23=3;
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:124:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED58=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary712); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED58);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:124:13: (r= PRECEDING | r= FOLLOWING )
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:124:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary717); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:124:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary721); if (state.failed) return retval; 
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
                    // 124:40: -> ^( $r UNBOUNDED )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:124:43: ^( $r UNBOUNDED )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:125:3: CURRENT ROW
                    {
                    CURRENT59=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary739); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT59);

                    ROW60=(Token)match(input,ROW,FOLLOW_ROW_in_valuesboundary741); if (state.failed) return retval; 
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
                    // 125:16: -> ^( CURRENT )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:125:19: ^( CURRENT )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:126:3: GROOVYEXPRESSION NUMBER (d= LESS | d= MORE )
                    {
                    GROOVYEXPRESSION61=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary754); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION61);

                    NUMBER62=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary756); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER62);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:126:27: (d= LESS | d= MORE )
                    int alt22=2;
                    switch ( input.LA(1) ) {
                    case LESS:
                        {
                        alt22=1;
                        }
                        break;
                    case MORE:
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:126:28: d= LESS
                            {
                            d=(Token)match(input,LESS,FOLLOW_LESS_in_valuesboundary761); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:126:37: d= MORE
                            {
                            d=(Token)match(input,MORE,FOLLOW_MORE_in_valuesboundary767); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MORE.add(d);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: NUMBER, GROOVYEXPRESSION, d
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
                    // 126:46: -> ^( $d GROOVYEXPRESSION NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:126:49: ^( $d GROOVYEXPRESSION NUMBER )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:129:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final WindowingParser.select_return select() throws RecognitionException {
        WindowingParser.select_return retval = new WindowingParser.select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT63=null;
        Token COMMA65=null;
        WindowingParser.selectColumn_return selectColumn64 = null;

        WindowingParser.selectColumn_return selectColumn66 = null;


        Object SELECT63_tree=null;
        Object COMMA65_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:129:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:130:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT63=(Token)match(input,SELECT,FOLLOW_SELECT_in_select792); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT63);

            pushFollow(FOLLOW_selectColumn_in_select794);
            selectColumn64=selectColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn64.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:130:23: ( COMMA selectColumn )*
            loop24:
            do {
                int alt24=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt24=1;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:130:24: COMMA selectColumn
            	    {
            	    COMMA65=(Token)match(input,COMMA,FOLLOW_COMMA_in_select797); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA65);

            	    pushFollow(FOLLOW_selectColumn_in_select799);
            	    selectColumn66=selectColumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn66.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
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
            // 130:46: -> ^( SELECT ( selectColumn )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:130:49: ^( SELECT ( selectColumn )+ )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:133:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );
    public final WindowingParser.selectColumn_return selectColumn() throws RecognitionException {
        WindowingParser.selectColumn_return retval = new WindowingParser.selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token typeNm=null;
        Token GROOVYEXPRESSION67=null;
        Token AS68=null;
        Token ID69=null;
        Token LBRACKET70=null;
        Token RBRACKET71=null;
        Token ID72=null;

        Object typeNm_tree=null;
        Object GROOVYEXPRESSION67_tree=null;
        Object AS68_tree=null;
        Object ID69_tree=null;
        Object LBRACKET70_tree=null;
        Object RBRACKET71_tree=null;
        Object ID72_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:133:13: ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) )
            int alt26=2;
            switch ( input.LA(1) ) {
            case GROOVYEXPRESSION:
                {
                alt26=1;
                }
                break;
            case ID:
                {
                alt26=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:3: GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )?
                    {
                    GROOVYEXPRESSION67=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn821); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION67);

                    AS68=(Token)match(input,AS,FOLLOW_AS_in_selectColumn823); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS68);

                    ID69=(Token)match(input,ID,FOLLOW_ID_in_selectColumn825); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID69);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:26: ( LBRACKET typeNm= ID RBRACKET )?
                    int alt25=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            alt25=1;
                            }
                            break;
                    }

                    switch (alt25) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:27: LBRACKET typeNm= ID RBRACKET
                            {
                            LBRACKET70=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_selectColumn828); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET70);

                            typeNm=(Token)match(input,ID,FOLLOW_ID_in_selectColumn832); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ID.add(typeNm);

                            RBRACKET71=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_selectColumn834); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET71);


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
                    // 134:57: -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:60: ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:95: ( ^( TYPENAME $typeNm) )?
                        if ( stream_typeNm.hasNext() ) {
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:95: ^( TYPENAME $typeNm)
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:135:3: ID
                    {
                    ID72=(Token)match(input,ID,FOLLOW_ID_in_selectColumn860); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID72);



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
                    // 135:6: -> ^( SELECTCOLUMN ID )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:135:9: ^( SELECTCOLUMN ID )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:138:1: where : ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) ;
    public final WindowingParser.where_return where() throws RecognitionException {
        WindowingParser.where_return retval = new WindowingParser.where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE73=null;
        Token GROOVYEXPRESSION74=null;

        Object WHERE73_tree=null;
        Object GROOVYEXPRESSION74_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:138:7: ( ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:2: ( WHERE GROOVYEXPRESSION )
            {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:2: ( WHERE GROOVYEXPRESSION )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:3: WHERE GROOVYEXPRESSION
            {
            WHERE73=(Token)match(input,WHERE,FOLLOW_WHERE_in_where880); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHERE.add(WHERE73);

            GROOVYEXPRESSION74=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where882); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION74);


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
            // 139:27: -> ^( WHERE GROOVYEXPRESSION )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:30: ^( WHERE GROOVYEXPRESSION )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:142:1: outputClause : ( INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )? ) -> ^( OUTPUTSPEC $p ( $f)? ) ;
    public final WindowingParser.outputClause_return outputClause() throws RecognitionException {
        WindowingParser.outputClause_return retval = new WindowingParser.outputClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token p=null;
        Token f=null;
        Token INTO75=null;
        Token PATH76=null;
        Token EQ77=null;
        Token FORMAT78=null;
        Token EQ79=null;

        Object p_tree=null;
        Object f_tree=null;
        Object INTO75_tree=null;
        Object PATH76_tree=null;
        Object EQ77_tree=null;
        Object FORMAT78_tree=null;
        Object EQ79_tree=null;
        RewriteRuleTokenStream stream_FORMAT=new RewriteRuleTokenStream(adaptor,"token FORMAT");
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_PATH=new RewriteRuleTokenStream(adaptor,"token PATH");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:142:14: ( ( INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )? ) -> ^( OUTPUTSPEC $p ( $f)? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:2: ( INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )? )
            {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:2: ( INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )? )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:3: INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )?
            {
            INTO75=(Token)match(input,INTO,FOLLOW_INTO_in_outputClause902); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTO.add(INTO75);

            PATH76=(Token)match(input,PATH,FOLLOW_PATH_in_outputClause904); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PATH.add(PATH76);

            EQ77=(Token)match(input,EQ,FOLLOW_EQ_in_outputClause906); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ77);

            p=(Token)match(input,STRING,FOLLOW_STRING_in_outputClause910); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(p);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:25: ( FORMAT EQ f= STRING )?
            int alt27=2;
            switch ( input.LA(1) ) {
                case FORMAT:
                    {
                    alt27=1;
                    }
                    break;
            }

            switch (alt27) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:26: FORMAT EQ f= STRING
                    {
                    FORMAT78=(Token)match(input,FORMAT,FOLLOW_FORMAT_in_outputClause913); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FORMAT.add(FORMAT78);

                    EQ79=(Token)match(input,EQ,FOLLOW_EQ_in_outputClause915); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ79);

                    f=(Token)match(input,STRING,FOLLOW_STRING_in_outputClause919); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(f);


                    }
                    break;

            }


            }



            // AST REWRITE
            // elements: f, p
            // token labels: f, p
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_f=new RewriteRuleTokenStream(adaptor,"token f",f);
            RewriteRuleTokenStream stream_p=new RewriteRuleTokenStream(adaptor,"token p",p);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 143:48: -> ^( OUTPUTSPEC $p ( $f)? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:51: ^( OUTPUTSPEC $p ( $f)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUTSPEC, "OUTPUTSPEC"), root_1);

                adaptor.addChild(root_1, stream_p.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:67: ( $f)?
                if ( stream_f.hasNext() ) {
                    adaptor.addChild(root_1, stream_f.nextNode());

                }
                stream_f.reset();

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

    public static class value_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value_expression"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:146:1: value_expression : ( numeric_expression | STRING );
    public final WindowingParser.value_expression_return value_expression() throws RecognitionException {
        WindowingParser.value_expression_return retval = new WindowingParser.value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING81=null;
        WindowingParser.numeric_expression_return numeric_expression80 = null;


        Object STRING81_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:146:18: ( numeric_expression | STRING )
            int alt28=2;
            switch ( input.LA(1) ) {
            case ID:
            case LPAREN:
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt28=1;
                }
                break;
            case STRING:
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:147:3: numeric_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_expression_in_value_expression946);
                    numeric_expression80=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression80.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING81=(Token)match(input,STRING,FOLLOW_STRING_in_value_expression952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING81_tree = (Object)adaptor.create(STRING81);
                    adaptor.addChild(root_0, STRING81_tree);
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:151:1: numeric_expression : term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* ;
    public final WindowingParser.numeric_expression_return numeric_expression() throws RecognitionException {
        WindowingParser.numeric_expression_return retval = new WindowingParser.numeric_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS83=null;
        Token MINUS84=null;
        WindowingParser.term_return term82 = null;

        WindowingParser.term_return term85 = null;


        Object PLUS83_tree=null;
        Object MINUS84_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:151:20: ( term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:3: term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_numeric_expression964);
            term82=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term82.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:8: ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==PLUS) && (synpred1_Windowing())) {
                    alt30=1;
                }
                else if ( (LA30_0==MINUS) && (synpred1_Windowing())) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:9: ( PLUS | MINUS )=> ( PLUS | MINUS ) term
            	    {
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:26: ( PLUS | MINUS )
            	    int alt29=2;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt29=1;
            	        }
            	        break;
            	    case MINUS:
            	        {
            	        alt29=2;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt29) {
            	        case 1 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:27: PLUS
            	            {
            	            PLUS83=(Token)match(input,PLUS,FOLLOW_PLUS_in_numeric_expression977); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS83_tree = (Object)adaptor.create(PLUS83);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS83_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:35: MINUS
            	            {
            	            MINUS84=(Token)match(input,MINUS,FOLLOW_MINUS_in_numeric_expression982); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS84_tree = (Object)adaptor.create(MINUS84);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS84_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_numeric_expression986);
            	    term85=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term85.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:155:1: term : numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* ;
    public final WindowingParser.term_return term() throws RecognitionException {
        WindowingParser.term_return retval = new WindowingParser.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASTERISK87=null;
        Token SOLIDUS88=null;
        WindowingParser.numeric_primary_expression_return numeric_primary_expression86 = null;

        WindowingParser.numeric_primary_expression_return numeric_primary_expression89 = null;


        Object ASTERISK87_tree=null;
        Object SOLIDUS88_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:155:7: ( numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:3: numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_numeric_primary_expression_in_term1004);
            numeric_primary_expression86=numeric_primary_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression86.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:30: ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==ASTERISK) && (synpred2_Windowing())) {
                    alt32=1;
                }
                else if ( (LA32_0==SOLIDUS) && (synpred2_Windowing())) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:31: ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression
            	    {
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:54: ( ASTERISK | SOLIDUS )
            	    int alt31=2;
            	    switch ( input.LA(1) ) {
            	    case ASTERISK:
            	        {
            	        alt31=1;
            	        }
            	        break;
            	    case SOLIDUS:
            	        {
            	        alt31=2;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt31) {
            	        case 1 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:55: ASTERISK
            	            {
            	            ASTERISK87=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_term1017); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ASTERISK87_tree = (Object)adaptor.create(ASTERISK87);
            	            root_0 = (Object)adaptor.becomeRoot(ASTERISK87_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:67: SOLIDUS
            	            {
            	            SOLIDUS88=(Token)match(input,SOLIDUS,FOLLOW_SOLIDUS_in_term1022); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SOLIDUS88_tree = (Object)adaptor.create(SOLIDUS88);
            	            root_0 = (Object)adaptor.becomeRoot(SOLIDUS88_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_numeric_primary_expression_in_term1026);
            	    numeric_primary_expression89=numeric_primary_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression89.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:159:1: numeric_primary_expression : ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN );
    public final WindowingParser.numeric_primary_expression_return numeric_primary_expression() throws RecognitionException {
        WindowingParser.numeric_primary_expression_return retval = new WindowingParser.numeric_primary_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN92=null;
        Token RPAREN94=null;
        WindowingParser.identifier_return identifier90 = null;

        WindowingParser.signed_numeric_literal_return signed_numeric_literal91 = null;

        WindowingParser.numeric_expression_return numeric_expression93 = null;


        Object LPAREN92_tree=null;
        Object RPAREN94_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:159:28: ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN )
            int alt33=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt33=1;
                }
                break;
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt33=2;
                }
                break;
            case LPAREN:
                {
                alt33=3;
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:160:3: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_numeric_primary_expression1040);
                    identifier90=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier90.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:161:3: signed_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signed_numeric_literal_in_numeric_primary_expression1047);
                    signed_numeric_literal91=signed_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_numeric_literal91.getTree());

                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:162:3: LPAREN numeric_expression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN92=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numeric_primary_expression1054); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN92_tree = (Object)adaptor.create(LPAREN92);
                    adaptor.addChild(root_0, LPAREN92_tree);
                    }
                    pushFollow(FOLLOW_numeric_expression_in_numeric_primary_expression1056);
                    numeric_expression93=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression93.getTree());
                    RPAREN94=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numeric_primary_expression1058); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN94_tree = (Object)adaptor.create(RPAREN94);
                    adaptor.addChild(root_0, RPAREN94_tree);
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:165:1: signed_numeric_literal : ( PLUS | MINUS )? unsigned_numeric_literal ;
    public final WindowingParser.signed_numeric_literal_return signed_numeric_literal() throws RecognitionException {
        WindowingParser.signed_numeric_literal_return retval = new WindowingParser.signed_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set95=null;
        WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal96 = null;


        Object set95_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:165:24: ( ( PLUS | MINUS )? unsigned_numeric_literal )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:166:3: ( PLUS | MINUS )? unsigned_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:166:3: ( PLUS | MINUS )?
            int alt34=2;
            switch ( input.LA(1) ) {
                case PLUS:
                case MINUS:
                    {
                    alt34=1;
                    }
                    break;
            }

            switch (alt34) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:
                    {
                    set95=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set95));
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

            pushFollow(FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1077);
            unsigned_numeric_literal96=unsigned_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unsigned_numeric_literal96.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:172:1: unsigned_numeric_literal : ( exact_numeric_literal | approximate_numeric_literal );
    public final WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal() throws RecognitionException {
        WindowingParser.unsigned_numeric_literal_return retval = new WindowingParser.unsigned_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal97 = null;

        WindowingParser.approximate_numeric_literal_return approximate_numeric_literal98 = null;



        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:172:26: ( exact_numeric_literal | approximate_numeric_literal )
            int alt35=2;
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
                            alt35=1;
                            }
                            break;
                        case 100:
                            {
                            alt35=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 35, 7, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 3, input);

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
                    alt35=1;
                    }
                    break;
                case 100:
                    {
                    alt35=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

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
                        alt35=1;
                        }
                        break;
                    case 100:
                        {
                        alt35=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 6, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 2, input);

                    throw nvae;
                }

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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:173:3: exact_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1090);
                    exact_numeric_literal97=exact_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal97.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:3: approximate_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1096);
                    approximate_numeric_literal98=approximate_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, approximate_numeric_literal98.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:177:1: approximate_numeric_literal : mantissa 'E' exponent ;
    public final WindowingParser.approximate_numeric_literal_return approximate_numeric_literal() throws RecognitionException {
        WindowingParser.approximate_numeric_literal_return retval = new WindowingParser.approximate_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal100=null;
        WindowingParser.mantissa_return mantissa99 = null;

        WindowingParser.exponent_return exponent101 = null;


        Object char_literal100_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:177:29: ( mantissa 'E' exponent )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:178:3: mantissa 'E' exponent
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mantissa_in_approximate_numeric_literal1107);
            mantissa99=mantissa();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mantissa99.getTree());
            char_literal100=(Token)match(input,100,FOLLOW_100_in_approximate_numeric_literal1109); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal100_tree = (Object)adaptor.create(char_literal100);
            adaptor.addChild(root_0, char_literal100_tree);
            }
            pushFollow(FOLLOW_exponent_in_approximate_numeric_literal1111);
            exponent101=exponent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exponent101.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:181:1: exponent : ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER );
    public final WindowingParser.exponent_return exponent() throws RecognitionException {
        WindowingParser.exponent_return retval = new WindowingParser.exponent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS102=null;
        Token NUMBER103=null;
        Token MINUS104=null;
        Token NUMBER105=null;
        Token NUMBER106=null;

        Object PLUS102_tree=null;
        Object NUMBER103_tree=null;
        Object MINUS104_tree=null;
        Object NUMBER105_tree=null;
        Object NUMBER106_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:181:10: ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER )
            int alt36=3;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt36=1;
                }
                break;
            case MINUS:
                {
                alt36=2;
                }
                break;
            case NUMBER:
                {
                alt36=3;
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:182:3: PLUS NUMBER
                    {
                    PLUS102=(Token)match(input,PLUS,FOLLOW_PLUS_in_exponent1122); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS102);

                    NUMBER103=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1124); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER103);



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
                    // 182:15: -> NUMBER
                    {
                        adaptor.addChild(root_0, stream_NUMBER.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:3: MINUS NUMBER
                    {
                    MINUS104=(Token)match(input,MINUS,FOLLOW_MINUS_in_exponent1134); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS104);

                    NUMBER105=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1136); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER105);



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
                    // 183:16: -> ^( UMINUS NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:19: ^( UMINUS NUMBER )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:184:3: NUMBER
                    {
                    NUMBER106=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1150); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER106);



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
                    // 184:10: -> NUMBER
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:1: mantissa : exact_numeric_literal ;
    public final WindowingParser.mantissa_return mantissa() throws RecognitionException {
        WindowingParser.mantissa_return retval = new WindowingParser.mantissa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal107 = null;



        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:187:10: ( exact_numeric_literal )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:188:3: exact_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_exact_numeric_literal_in_mantissa1166);
            exact_numeric_literal107=exact_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal107.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:191:1: exact_numeric_literal : (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->);
    public final WindowingParser.exact_numeric_literal_return exact_numeric_literal() throws RecognitionException {
        WindowingParser.exact_numeric_literal_return retval = new WindowingParser.exact_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token n2=null;
        Token DOT108=null;
        Token DOT109=null;

        Object n1_tree=null;
        Object n2_tree=null;
        Object DOT108_tree=null;
        Object DOT109_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:191:23: (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->)
            int alt38=2;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt38=1;
                }
                break;
            case DOT:
                {
                alt38=2;
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:193:3: n1= NUMBER ( DOT n2= NUMBER )?
                    {
                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1182); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(n1);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:193:13: ( DOT n2= NUMBER )?
                    int alt37=2;
                    switch ( input.LA(1) ) {
                        case DOT:
                            {
                            alt37=1;
                            }
                            break;
                    }

                    switch (alt37) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:193:14: DOT n2= NUMBER
                            {
                            DOT108=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1185); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT108);

                            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1189); if (state.failed) return retval; 
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
                    // 193:31: ->
                    {
                        adaptor.addChild(root_0, 
                        	      ( n2 != null ? adaptor.create(NUMERIC, (n1!=null?n1.getText():null) + '.' + (n2!=null?n2.getText():null)) :  adaptor.create(INTEGER, (n1!=null?n1.getText():null)) )
                              );

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:197:3: DOT n1= NUMBER
                    {
                    DOT109=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1210); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT109);

                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1214); if (state.failed) return retval; 
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
                    // 197:17: ->
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:200:1: identifier : ID ;
    public final WindowingParser.identifier_return identifier() throws RecognitionException {
        WindowingParser.identifier_return retval = new WindowingParser.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID110=null;

        Object ID110_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:200:12: ( ID )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:201:3: ID
            {
            root_0 = (Object)adaptor.nil();

            ID110=(Token)match(input,ID,FOLLOW_ID_in_identifier1230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID110_tree = (Object)adaptor.create(ID110);
            adaptor.addChild(root_0, ID110_tree);
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
        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:9: ( PLUS | MINUS )
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
        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:31: ( ASTERISK | SOLIDUS )
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


 

    public static final BitSet FOLLOW_FROM_in_query138 = new BitSet(new long[]{0x0000000000B80000L});
    public static final BitSet FOLLOW_tableSpec_in_query140 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_partitionby_in_query143 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_orderby_in_query146 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_WITH_in_query149 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_funclist_in_query151 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_select_in_query154 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_where_in_query157 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_outputClause_in_query162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hivetable_in_tableSpec195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tableSpec200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tableSpec213 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_tableSpec218 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_RPAREN_in_tableSpec220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hivetable240 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_hivetable242 = new BitSet(new long[]{0x0000000003480000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable245 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_COMMA_in_hivetable250 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable252 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_RPAREN_in_hivetable256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namevalue279 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue283 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_namevalue286 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby312 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_BY_in_orderby314 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby316 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_orderby319 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby321 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ID_in_ordercolumn342 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby378 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_BY_in_partitionby380 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_partitionby382 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby385 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_partitionby387 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_function_in_funclist409 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_funclist412 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_function_in_funclist414 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ID_in_function438 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_function440 = new BitSet(new long[]{0x0000000803680000L});
    public static final BitSet FOLLOW_functionparam_in_function443 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_COMMA_in_function448 = new BitSet(new long[]{0x0000000802280000L});
    public static final BitSet FOLLOW_functionparam_in_function450 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_RPAREN_in_function454 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_window_expression_in_function457 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_AS_in_function461 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_function465 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_LBRACKET_in_function468 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_function472 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_RBRACKET_in_function474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionparam0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_expression543 = new BitSet(new long[]{0x0000202000000000L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression568 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression570 = new BitSet(new long[]{0x0000090800000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression574 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AND_in_window_range_expression576 = new BitSet(new long[]{0x0000090800000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary603 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary630 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary645 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression677 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression679 = new BitSet(new long[]{0x0000090000200000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression683 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AND_in_window_value_expression685 = new BitSet(new long[]{0x0000090000200000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary712 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary739 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary754 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary756 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select792 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_selectColumn_in_select794 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_select797 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_selectColumn_in_select799 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn821 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn823 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_selectColumn825 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selectColumn828 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_selectColumn832 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selectColumn834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selectColumn860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where880 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_outputClause902 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_PATH_in_outputClause904 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause906 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause910 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_FORMAT_in_outputClause913 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause915 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_expression_in_value_expression946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_value_expression952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_numeric_expression964 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_PLUS_in_numeric_expression977 = new BitSet(new long[]{0x0260000800180000L});
    public static final BitSet FOLLOW_MINUS_in_numeric_expression982 = new BitSet(new long[]{0x0260000800180000L});
    public static final BitSet FOLLOW_term_in_numeric_expression986 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1004 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_ASTERISK_in_term1017 = new BitSet(new long[]{0x0260000800180000L});
    public static final BitSet FOLLOW_SOLIDUS_in_term1022 = new BitSet(new long[]{0x0260000800180000L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1026 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_identifier_in_numeric_primary_expression1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signed_numeric_literal_in_numeric_primary_expression1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_primary_expression1054 = new BitSet(new long[]{0x0260000800180000L});
    public static final BitSet FOLLOW_numeric_expression_in_numeric_primary_expression1056 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_primary_expression1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_signed_numeric_literal1070 = new BitSet(new long[]{0x0260000800000000L});
    public static final BitSet FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mantissa_in_approximate_numeric_literal1107 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_approximate_numeric_literal1109 = new BitSet(new long[]{0x0060000800000000L});
    public static final BitSet FOLLOW_exponent_in_approximate_numeric_literal1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_exponent1122 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_exponent1134 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_mantissa1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1182 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1185 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1210 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1_Windowing967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred2_Windowing1007 = new BitSet(new long[]{0x0000000000000002L});

}