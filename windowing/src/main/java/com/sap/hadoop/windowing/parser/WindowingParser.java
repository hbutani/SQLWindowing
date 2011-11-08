// $ANTLR 3.3 Nov 30, 2010 12:46:29 com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g 2011-11-07 11:55:36

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "FROM", "WITH", "TABLEINPUT", "LPAREN", "COMMA", "RPAREN", "ID", "STRING", "EQ", "ORDER", "BY", "ASC", "DESC", "PARTITION", "AS", "LBRACKET", "RBRACKET", "GROOVYEXPRESSION", "NUMBER", "OVER", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "RANGE", "LESS", "MORE", "SELECT", "WHERE", "PLUS", "MINUS", "ASTERISK", "SOLIDUS", "DOT", "QUOTE", "COLON", "SEMICOLON", "GE", "GT", "LBRACE", "LE", "LT", "NE", "RBRACE", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "B", "I", "N", "P", "U", "D", "Y", "G", "V", "NOT", "OR", "X", "XOR", "GroovyEscapeSequence", "EscapeSequence", "WS", "J", "K", "Q", "Z", "'E'"
    };
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
    public String getGrammarFileName() { return "com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g"; }


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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:52:1: query : FROM tableSpec partitionby orderby WITH funclist select ( where )? -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ) ;
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
        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:52:7: ( FROM tableSpec partitionby orderby WITH funclist select ( where )? -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:53:2: FROM tableSpec partitionby orderby WITH funclist select ( where )?
            {
            FROM1=(Token)match(input,FROM,FOLLOW_FROM_in_query133); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM1);

            pushFollow(FOLLOW_tableSpec_in_query135);
            tableSpec2=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec2.getTree());
            pushFollow(FOLLOW_partitionby_in_query138);
            partitionby3=partitionby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionby.add(partitionby3.getTree());
            pushFollow(FOLLOW_orderby_in_query141);
            orderby4=orderby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orderby.add(orderby4.getTree());
            WITH5=(Token)match(input,WITH,FOLLOW_WITH_in_query144); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WITH.add(WITH5);

            pushFollow(FOLLOW_funclist_in_query146);
            funclist6=funclist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_funclist.add(funclist6.getTree());
            pushFollow(FOLLOW_select_in_query149);
            select7=select();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select.add(select7.getTree());
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:58:2: ( where )?
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:58:2: where
                    {
                    pushFollow(FOLLOW_where_in_query152);
                    where8=where();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_where.add(where8.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: select, orderby, tableSpec, funclist, where, partitionby
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 58:9: -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:58:12: ^( QUERY tableSpec partitionby orderby funclist select ( where )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                adaptor.addChild(root_1, stream_partitionby.nextTree());
                adaptor.addChild(root_1, stream_orderby.nextTree());
                adaptor.addChild(root_1, stream_funclist.nextTree());
                adaptor.addChild(root_1, stream_select.nextTree());
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:58:66: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.nextTree());

                }
                stream_where.reset();

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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:61:1: tableSpec : hivetable ;
    public final WindowingParser.tableSpec_return tableSpec() throws RecognitionException {
        WindowingParser.tableSpec_return retval = new WindowingParser.tableSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.hivetable_return hivetable9 = null;



        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:61:11: ( hivetable )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:62:2: hivetable
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_hivetable_in_tableSpec182);
            hivetable9=hivetable();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, hivetable9.getTree());

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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:65:1: hivetable : TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) ;
    public final WindowingParser.hivetable_return hivetable() throws RecognitionException {
        WindowingParser.hivetable_return retval = new WindowingParser.hivetable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TABLEINPUT10=null;
        Token LPAREN11=null;
        Token COMMA13=null;
        Token RPAREN15=null;
        WindowingParser.namevalue_return namevalue12 = null;

        WindowingParser.namevalue_return namevalue14 = null;


        Object TABLEINPUT10_tree=null;
        Object LPAREN11_tree=null;
        Object COMMA13_tree=null;
        Object RPAREN15_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_TABLEINPUT=new RewriteRuleTokenStream(adaptor,"token TABLEINPUT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:65:11: ( TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:66:2: TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            TABLEINPUT10=(Token)match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hivetable192); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TABLEINPUT.add(TABLEINPUT10);

            LPAREN11=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_hivetable194); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN11);

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:66:20: ( namevalue )?
            int alt2=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                    {
                    alt2=1;
                    }
                    break;
            }

            switch (alt2) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:66:21: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hivetable197);
                    namevalue12=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue12.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:66:33: ( COMMA namevalue )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:66:34: COMMA namevalue
            	    {
            	    COMMA13=(Token)match(input,COMMA,FOLLOW_COMMA_in_hivetable202); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA13);

            	    pushFollow(FOLLOW_namevalue_in_hivetable204);
            	    namevalue14=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue14.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            RPAREN15=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_hivetable208); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN15);



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
            // 66:60: -> ^( TABLEINPUT ( namevalue )* )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:66:63: ^( TABLEINPUT ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_TABLEINPUT.nextNode(), root_1);

                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:66:76: ( namevalue )*
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:69:1: namevalue : (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) ;
    public final WindowingParser.namevalue_return namevalue() throws RecognitionException {
        WindowingParser.namevalue_return retval = new WindowingParser.namevalue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token v=null;
        Token EQ16=null;

        Object i_tree=null;
        Object v_tree=null;
        Object EQ16_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:69:11: ( (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:70:2: (i= ID | i= STRING ) EQ v= STRING
            {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:70:2: (i= ID | i= STRING )
            int alt4=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt4=1;
                }
                break;
            case STRING:
                {
                alt4=2;
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:70:3: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_namevalue231); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:70:8: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue235); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ16=(Token)match(input,EQ,FOLLOW_EQ_in_namevalue238); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ16);

            v=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue242); if (state.failed) return retval; 
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
            // 70:30: -> ^( PARAM $i $v)
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:70:33: ^( PARAM $i $v)
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:73:1: orderby : ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
    public final WindowingParser.orderby_return orderby() throws RecognitionException {
        WindowingParser.orderby_return retval = new WindowingParser.orderby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER17=null;
        Token BY18=null;
        Token COMMA20=null;
        WindowingParser.ordercolumn_return ordercolumn19 = null;

        WindowingParser.ordercolumn_return ordercolumn21 = null;


        Object ORDER17_tree=null;
        Object BY18_tree=null;
        Object COMMA20_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_ordercolumn=new RewriteRuleSubtreeStream(adaptor,"rule ordercolumn");
        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:73:9: ( ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:74:2: ORDER BY ordercolumn ( COMMA ordercolumn )*
            {
            ORDER17=(Token)match(input,ORDER,FOLLOW_ORDER_in_orderby264); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ORDER.add(ORDER17);

            BY18=(Token)match(input,BY,FOLLOW_BY_in_orderby266); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY18);

            pushFollow(FOLLOW_ordercolumn_in_orderby268);
            ordercolumn19=ordercolumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn19.getTree());
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:74:23: ( COMMA ordercolumn )*
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:74:24: COMMA ordercolumn
            	    {
            	    COMMA20=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderby271); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA20);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby273);
            	    ordercolumn21=ordercolumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn21.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
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
            // 74:44: -> ^( ORDER ( ordercolumn )+ )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:74:47: ^( ORDER ( ordercolumn )+ )
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:77:1: ordercolumn : ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) ;
    public final WindowingParser.ordercolumn_return ordercolumn() throws RecognitionException {
        WindowingParser.ordercolumn_return retval = new WindowingParser.ordercolumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token o=null;
        Token ID22=null;

        Object o_tree=null;
        Object ID22_tree=null;
        RewriteRuleTokenStream stream_ASC=new RewriteRuleTokenStream(adaptor,"token ASC");
        RewriteRuleTokenStream stream_DESC=new RewriteRuleTokenStream(adaptor,"token DESC");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:77:13: ( ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:78:2: ID (o= ASC | o= DESC )?
            {
            ID22=(Token)match(input,ID,FOLLOW_ID_in_ordercolumn294); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID22);

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:78:5: (o= ASC | o= DESC )?
            int alt6=3;
            switch ( input.LA(1) ) {
                case ASC:
                    {
                    alt6=1;
                    }
                    break;
                case DESC:
                    {
                    alt6=2;
                    }
                    break;
            }

            switch (alt6) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:78:6: o= ASC
                    {
                    o=(Token)match(input,ASC,FOLLOW_ASC_in_ordercolumn299); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:78:14: o= DESC
                    {
                    o=(Token)match(input,DESC,FOLLOW_DESC_in_ordercolumn305); if (state.failed) return retval; 
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
            // 78:23: -> ^( ORDERCOLUMN ID ( $o)? )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:78:26: ^( ORDERCOLUMN ID ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:78:43: ( $o)?
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:81:1: partitionby : PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) ;
    public final WindowingParser.partitionby_return partitionby() throws RecognitionException {
        WindowingParser.partitionby_return retval = new WindowingParser.partitionby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PARTITION23=null;
        Token BY24=null;
        Token ID25=null;
        Token COMMA26=null;
        Token ID27=null;

        Object PARTITION23_tree=null;
        Object BY24_tree=null;
        Object ID25_tree=null;
        Object COMMA26_tree=null;
        Object ID27_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:81:13: ( PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:82:2: PARTITION BY ID ( COMMA ID )*
            {
            PARTITION23=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_partitionby330); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARTITION.add(PARTITION23);

            BY24=(Token)match(input,BY,FOLLOW_BY_in_partitionby332); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY24);

            ID25=(Token)match(input,ID,FOLLOW_ID_in_partitionby334); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID25);

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:82:18: ( COMMA ID )*
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:82:19: COMMA ID
            	    {
            	    COMMA26=(Token)match(input,COMMA,FOLLOW_COMMA_in_partitionby337); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA26);

            	    ID27=(Token)match(input,ID,FOLLOW_ID_in_partitionby339); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID27);


            	    }
            	    break;

            	default :
            	    break loop7;
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
            // 82:30: -> ^( PARTITION ( ID )+ )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:82:33: ^( PARTITION ( ID )+ )
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:85:1: funclist : function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) ;
    public final WindowingParser.funclist_return funclist() throws RecognitionException {
        WindowingParser.funclist_return retval = new WindowingParser.funclist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA29=null;
        WindowingParser.function_return function28 = null;

        WindowingParser.function_return function30 = null;


        Object COMMA29_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:85:10: ( function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:86:2: function ( COMMA function )*
            {
            pushFollow(FOLLOW_function_in_funclist361);
            function28=function();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function.add(function28.getTree());
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:86:11: ( COMMA function )*
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:86:12: COMMA function
            	    {
            	    COMMA29=(Token)match(input,COMMA,FOLLOW_COMMA_in_funclist364); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA29);

            	    pushFollow(FOLLOW_function_in_funclist366);
            	    function30=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function.add(function30.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
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
            // 86:29: -> ^( FUNCTIONS ( function )+ )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:86:32: ^( FUNCTIONS ( function )+ )
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:89:1: function : name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) ;
    public final WindowingParser.function_return function() throws RecognitionException {
        WindowingParser.function_return retval = new WindowingParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token alias=null;
        Token typeNm=null;
        Token LPAREN31=null;
        Token COMMA33=null;
        Token RPAREN35=null;
        Token AS37=null;
        Token LBRACKET38=null;
        Token RBRACKET39=null;
        WindowingParser.functionparam_return functionparam32 = null;

        WindowingParser.functionparam_return functionparam34 = null;

        WindowingParser.window_expression_return window_expression36 = null;


        Object name_tree=null;
        Object alias_tree=null;
        Object typeNm_tree=null;
        Object LPAREN31_tree=null;
        Object COMMA33_tree=null;
        Object RPAREN35_tree=null;
        Object AS37_tree=null;
        Object LBRACKET38_tree=null;
        Object RBRACKET39_tree=null;
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:89:10: (name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:2: name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )?
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_function390); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN31=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function392); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN31);

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:17: ( functionparam )?
            int alt9=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                case GROOVYEXPRESSION:
                case NUMBER:
                    {
                    alt9=1;
                    }
                    break;
            }

            switch (alt9) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:18: functionparam
                    {
                    pushFollow(FOLLOW_functionparam_in_function395);
                    functionparam32=functionparam();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionparam.add(functionparam32.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:34: ( COMMA functionparam )*
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
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:35: COMMA functionparam
            	    {
            	    COMMA33=(Token)match(input,COMMA,FOLLOW_COMMA_in_function400); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA33);

            	    pushFollow(FOLLOW_functionparam_in_function402);
            	    functionparam34=functionparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_functionparam.add(functionparam34.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            RPAREN35=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function406); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN35);

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:64: ( window_expression )?
            int alt11=2;
            switch ( input.LA(1) ) {
                case OVER:
                    {
                    alt11=1;
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:65: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function409);
                    window_expression36=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression36.getTree());

                    }
                    break;

            }

            AS37=(Token)match(input,AS,FOLLOW_AS_in_function413); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AS.add(AS37);

            alias=(Token)match(input,ID,FOLLOW_ID_in_function417); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(alias);

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:97: ( LBRACKET typeNm= ID RBRACKET )?
            int alt12=2;
            switch ( input.LA(1) ) {
                case LBRACKET:
                    {
                    alt12=1;
                    }
                    break;
            }

            switch (alt12) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:90:98: LBRACKET typeNm= ID RBRACKET
                    {
                    LBRACKET38=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_function420); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET38);

                    typeNm=(Token)match(input,ID,FOLLOW_ID_in_function424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(typeNm);

                    RBRACKET39=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_function426); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET39);


                    }
                    break;

            }



            // AST REWRITE
            // elements: window_expression, functionparam, typeNm, name, alias
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
            // 90:128: -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:91:7: ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_alias.nextNode());
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:91:31: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.nextTree());

                }
                stream_functionparam.reset();
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:91:46: ( ^( TYPENAME $typeNm) )?
                if ( stream_typeNm.hasNext() ) {
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:91:46: ^( TYPENAME $typeNm)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                    adaptor.addChild(root_2, stream_typeNm.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_typeNm.reset();
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:91:67: ( window_expression )?
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:94:1: functionparam : ( GROOVYEXPRESSION | STRING | ID | NUMBER );
    public final WindowingParser.functionparam_return functionparam() throws RecognitionException {
        WindowingParser.functionparam_return retval = new WindowingParser.functionparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set40=null;

        Object set40_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:94:16: ( GROOVYEXPRESSION | STRING | ID | NUMBER )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set40=(Token)input.LT(1);
            if ( (input.LA(1)>=ID && input.LA(1)<=STRING)||(input.LA(1)>=GROOVYEXPRESSION && input.LA(1)<=NUMBER) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set40));
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:98:1: window_expression : OVER ( window_range_expression | window_value_expression ) ;
    public final WindowingParser.window_expression_return window_expression() throws RecognitionException {
        WindowingParser.window_expression_return retval = new WindowingParser.window_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OVER41=null;
        WindowingParser.window_range_expression_return window_range_expression42 = null;

        WindowingParser.window_value_expression_return window_value_expression43 = null;


        Object OVER41_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:98:19: ( OVER ( window_range_expression | window_value_expression ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:99:2: OVER ( window_range_expression | window_value_expression )
            {
            root_0 = (Object)adaptor.nil();

            OVER41=(Token)match(input,OVER,FOLLOW_OVER_in_window_expression495); if (state.failed) return retval;
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:100:2: ( window_range_expression | window_value_expression )
            int alt13=2;
            switch ( input.LA(1) ) {
            case ROWS:
                {
                alt13=1;
                }
                break;
            case RANGE:
                {
                alt13=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:100:3: window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression501);
                    window_range_expression42=window_range_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_range_expression42.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:101:2: window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression506);
                    window_value_expression43=window_value_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_value_expression43.getTree());

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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:105:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final WindowingParser.window_range_expression_return window_range_expression() throws RecognitionException {
        WindowingParser.window_range_expression_return retval = new WindowingParser.window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS44=null;
        Token BETWEEN45=null;
        Token AND46=null;
        WindowingParser.rowsboundary_return s = null;

        WindowingParser.rowsboundary_return e = null;


        Object ROWS44_tree=null;
        Object BETWEEN45_tree=null;
        Object AND46_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:105:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:106:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS44=(Token)match(input,ROWS,FOLLOW_ROWS_in_window_range_expression520); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ROWS.add(ROWS44);

            BETWEEN45=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression522); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN45);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression526);
            s=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(s.getTree());
            AND46=(Token)match(input,AND,FOLLOW_AND_in_window_range_expression528); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND46);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression532);
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
            // 106:49: -> ^( WINDOWRANGE $s $e)
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:106:52: ^( WINDOWRANGE $s $e)
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:109:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );
    public final WindowingParser.rowsboundary_return rowsboundary() throws RecognitionException {
        WindowingParser.rowsboundary_return retval = new WindowingParser.rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED47=null;
        Token CURRENT48=null;
        Token ROW49=null;
        Token NUMBER50=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED47_tree=null;
        Object CURRENT48_tree=null;
        Object ROW49_tree=null;
        Object NUMBER50_tree=null;
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:109:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt16=1;
                }
                break;
            case CURRENT:
                {
                alt16=2;
                }
                break;
            case NUMBER:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:110:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED47=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary555); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED47);

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:110:13: (r= PRECEDING | r= FOLLOWING )
                    int alt14=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt14=1;
                        }
                        break;
                    case FOLLOWING:
                        {
                        alt14=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }

                    switch (alt14) {
                        case 1 :
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:110:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary560); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:110:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary564); if (state.failed) return retval; 
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
                    // 110:40: -> ^( $r UNBOUNDED )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:110:43: ^( $r UNBOUNDED )
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:111:3: CURRENT ROW
                    {
                    CURRENT48=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary582); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT48);

                    ROW49=(Token)match(input,ROW,FOLLOW_ROW_in_rowsboundary584); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW49);



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
                    // 111:16: -> ^( CURRENT )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:111:19: ^( CURRENT )
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:112:3: NUMBER (d= PRECEDING | d= FOLLOWING )
                    {
                    NUMBER50=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary597); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER50);

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:112:10: (d= PRECEDING | d= FOLLOWING )
                    int alt15=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt15=1;
                        }
                        break;
                    case FOLLOWING:
                        {
                        alt15=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }

                    switch (alt15) {
                        case 1 :
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:112:11: d= PRECEDING
                            {
                            d=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary602); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:112:25: d= FOLLOWING
                            {
                            d=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary608); if (state.failed) return retval; 
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
                    // 112:39: -> ^( $d NUMBER )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:112:42: ^( $d NUMBER )
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:115:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final WindowingParser.window_value_expression_return window_value_expression() throws RecognitionException {
        WindowingParser.window_value_expression_return retval = new WindowingParser.window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE51=null;
        Token BETWEEN52=null;
        Token AND53=null;
        WindowingParser.valuesboundary_return s = null;

        WindowingParser.valuesboundary_return e = null;


        Object RANGE51_tree=null;
        Object BETWEEN52_tree=null;
        Object AND53_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:115:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:116:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE51=(Token)match(input,RANGE,FOLLOW_RANGE_in_window_value_expression629); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE51);

            BETWEEN52=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression631); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN52);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression635);
            s=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(s.getTree());
            AND53=(Token)match(input,AND,FOLLOW_AND_in_window_value_expression637); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND53);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression641);
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
            // 116:54: -> ^( WINDOWVALUES $s $e)
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:116:57: ^( WINDOWVALUES $s $e)
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:119:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );
    public final WindowingParser.valuesboundary_return valuesboundary() throws RecognitionException {
        WindowingParser.valuesboundary_return retval = new WindowingParser.valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED54=null;
        Token CURRENT55=null;
        Token ROW56=null;
        Token GROOVYEXPRESSION57=null;
        Token NUMBER58=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED54_tree=null;
        Object CURRENT55_tree=null;
        Object ROW56_tree=null;
        Object GROOVYEXPRESSION57_tree=null;
        Object NUMBER58_tree=null;
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
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:119:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt19=1;
                }
                break;
            case CURRENT:
                {
                alt19=2;
                }
                break;
            case GROOVYEXPRESSION:
                {
                alt19=3;
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:120:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED54=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary664); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED54);

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:120:13: (r= PRECEDING | r= FOLLOWING )
                    int alt17=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt17=1;
                        }
                        break;
                    case FOLLOWING:
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
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:120:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary669); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:120:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary673); if (state.failed) return retval; 
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
                    // 120:40: -> ^( $r UNBOUNDED )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:120:43: ^( $r UNBOUNDED )
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:121:3: CURRENT ROW
                    {
                    CURRENT55=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary691); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT55);

                    ROW56=(Token)match(input,ROW,FOLLOW_ROW_in_valuesboundary693); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW56);



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
                    // 121:16: -> ^( CURRENT )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:121:19: ^( CURRENT )
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:122:3: GROOVYEXPRESSION NUMBER (d= LESS | d= MORE )
                    {
                    GROOVYEXPRESSION57=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary706); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION57);

                    NUMBER58=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary708); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER58);

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:122:27: (d= LESS | d= MORE )
                    int alt18=2;
                    switch ( input.LA(1) ) {
                    case LESS:
                        {
                        alt18=1;
                        }
                        break;
                    case MORE:
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
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:122:28: d= LESS
                            {
                            d=(Token)match(input,LESS,FOLLOW_LESS_in_valuesboundary713); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:122:37: d= MORE
                            {
                            d=(Token)match(input,MORE,FOLLOW_MORE_in_valuesboundary719); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MORE.add(d);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: NUMBER, d, GROOVYEXPRESSION
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
                    // 122:46: -> ^( $d GROOVYEXPRESSION NUMBER )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:122:49: ^( $d GROOVYEXPRESSION NUMBER )
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:125:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final WindowingParser.select_return select() throws RecognitionException {
        WindowingParser.select_return retval = new WindowingParser.select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT59=null;
        Token COMMA61=null;
        WindowingParser.selectColumn_return selectColumn60 = null;

        WindowingParser.selectColumn_return selectColumn62 = null;


        Object SELECT59_tree=null;
        Object COMMA61_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:125:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:126:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT59=(Token)match(input,SELECT,FOLLOW_SELECT_in_select744); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT59);

            pushFollow(FOLLOW_selectColumn_in_select746);
            selectColumn60=selectColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn60.getTree());
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:126:23: ( COMMA selectColumn )*
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt20=1;
                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:126:24: COMMA selectColumn
            	    {
            	    COMMA61=(Token)match(input,COMMA,FOLLOW_COMMA_in_select749); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA61);

            	    pushFollow(FOLLOW_selectColumn_in_select751);
            	    selectColumn62=selectColumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn62.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
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
            // 126:46: -> ^( SELECT ( selectColumn )+ )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:126:49: ^( SELECT ( selectColumn )+ )
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:129:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );
    public final WindowingParser.selectColumn_return selectColumn() throws RecognitionException {
        WindowingParser.selectColumn_return retval = new WindowingParser.selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token typeNm=null;
        Token GROOVYEXPRESSION63=null;
        Token AS64=null;
        Token ID65=null;
        Token LBRACKET66=null;
        Token RBRACKET67=null;
        Token ID68=null;

        Object typeNm_tree=null;
        Object GROOVYEXPRESSION63_tree=null;
        Object AS64_tree=null;
        Object ID65_tree=null;
        Object LBRACKET66_tree=null;
        Object RBRACKET67_tree=null;
        Object ID68_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:129:13: ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) )
            int alt22=2;
            switch ( input.LA(1) ) {
            case GROOVYEXPRESSION:
                {
                alt22=1;
                }
                break;
            case ID:
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:130:3: GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )?
                    {
                    GROOVYEXPRESSION63=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn773); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION63);

                    AS64=(Token)match(input,AS,FOLLOW_AS_in_selectColumn775); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS64);

                    ID65=(Token)match(input,ID,FOLLOW_ID_in_selectColumn777); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID65);

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:130:26: ( LBRACKET typeNm= ID RBRACKET )?
                    int alt21=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            alt21=1;
                            }
                            break;
                    }

                    switch (alt21) {
                        case 1 :
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:130:27: LBRACKET typeNm= ID RBRACKET
                            {
                            LBRACKET66=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_selectColumn780); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET66);

                            typeNm=(Token)match(input,ID,FOLLOW_ID_in_selectColumn784); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ID.add(typeNm);

                            RBRACKET67=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_selectColumn786); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET67);


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
                    // 130:57: -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:130:60: ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:130:95: ( ^( TYPENAME $typeNm) )?
                        if ( stream_typeNm.hasNext() ) {
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:130:95: ^( TYPENAME $typeNm)
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:131:3: ID
                    {
                    ID68=(Token)match(input,ID,FOLLOW_ID_in_selectColumn812); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID68);



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
                    // 131:6: -> ^( SELECTCOLUMN ID )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:131:9: ^( SELECTCOLUMN ID )
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:134:1: where : ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) ;
    public final WindowingParser.where_return where() throws RecognitionException {
        WindowingParser.where_return retval = new WindowingParser.where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE69=null;
        Token GROOVYEXPRESSION70=null;

        Object WHERE69_tree=null;
        Object GROOVYEXPRESSION70_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:134:7: ( ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:135:2: ( WHERE GROOVYEXPRESSION )
            {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:135:2: ( WHERE GROOVYEXPRESSION )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:135:3: WHERE GROOVYEXPRESSION
            {
            WHERE69=(Token)match(input,WHERE,FOLLOW_WHERE_in_where832); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHERE.add(WHERE69);

            GROOVYEXPRESSION70=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where834); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION70);


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
            // 135:27: -> ^( WHERE GROOVYEXPRESSION )
            {
                // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:135:30: ^( WHERE GROOVYEXPRESSION )
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

    public static class value_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value_expression"
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:138:1: value_expression : ( numeric_expression | STRING );
    public final WindowingParser.value_expression_return value_expression() throws RecognitionException {
        WindowingParser.value_expression_return retval = new WindowingParser.value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING72=null;
        WindowingParser.numeric_expression_return numeric_expression71 = null;


        Object STRING72_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:138:18: ( numeric_expression | STRING )
            int alt23=2;
            switch ( input.LA(1) ) {
            case LPAREN:
            case ID:
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt23=1;
                }
                break;
            case STRING:
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:139:3: numeric_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_expression_in_value_expression854);
                    numeric_expression71=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression71.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:140:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING72=(Token)match(input,STRING,FOLLOW_STRING_in_value_expression860); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING72_tree = (Object)adaptor.create(STRING72);
                    adaptor.addChild(root_0, STRING72_tree);
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:143:1: numeric_expression : term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* ;
    public final WindowingParser.numeric_expression_return numeric_expression() throws RecognitionException {
        WindowingParser.numeric_expression_return retval = new WindowingParser.numeric_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS74=null;
        Token MINUS75=null;
        WindowingParser.term_return term73 = null;

        WindowingParser.term_return term76 = null;


        Object PLUS74_tree=null;
        Object MINUS75_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:143:20: ( term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:144:3: term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_numeric_expression872);
            term73=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term73.getTree());
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:144:8: ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==PLUS) && (synpred1_Windowing())) {
                    alt25=1;
                }
                else if ( (LA25_0==MINUS) && (synpred1_Windowing())) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:144:9: ( PLUS | MINUS )=> ( PLUS | MINUS ) term
            	    {
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:144:26: ( PLUS | MINUS )
            	    int alt24=2;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt24=1;
            	        }
            	        break;
            	    case MINUS:
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
            	            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:144:27: PLUS
            	            {
            	            PLUS74=(Token)match(input,PLUS,FOLLOW_PLUS_in_numeric_expression885); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS74_tree = (Object)adaptor.create(PLUS74);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS74_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:144:35: MINUS
            	            {
            	            MINUS75=(Token)match(input,MINUS,FOLLOW_MINUS_in_numeric_expression890); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS75_tree = (Object)adaptor.create(MINUS75);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS75_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_numeric_expression894);
            	    term76=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term76.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:147:1: term : numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* ;
    public final WindowingParser.term_return term() throws RecognitionException {
        WindowingParser.term_return retval = new WindowingParser.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASTERISK78=null;
        Token SOLIDUS79=null;
        WindowingParser.numeric_primary_expression_return numeric_primary_expression77 = null;

        WindowingParser.numeric_primary_expression_return numeric_primary_expression80 = null;


        Object ASTERISK78_tree=null;
        Object SOLIDUS79_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:147:7: ( numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:148:3: numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_numeric_primary_expression_in_term912);
            numeric_primary_expression77=numeric_primary_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression77.getTree());
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:148:30: ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==ASTERISK) && (synpred2_Windowing())) {
                    alt27=1;
                }
                else if ( (LA27_0==SOLIDUS) && (synpred2_Windowing())) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:148:31: ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression
            	    {
            	    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:148:54: ( ASTERISK | SOLIDUS )
            	    int alt26=2;
            	    switch ( input.LA(1) ) {
            	    case ASTERISK:
            	        {
            	        alt26=1;
            	        }
            	        break;
            	    case SOLIDUS:
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
            	            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:148:55: ASTERISK
            	            {
            	            ASTERISK78=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_term925); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ASTERISK78_tree = (Object)adaptor.create(ASTERISK78);
            	            root_0 = (Object)adaptor.becomeRoot(ASTERISK78_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:148:67: SOLIDUS
            	            {
            	            SOLIDUS79=(Token)match(input,SOLIDUS,FOLLOW_SOLIDUS_in_term930); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SOLIDUS79_tree = (Object)adaptor.create(SOLIDUS79);
            	            root_0 = (Object)adaptor.becomeRoot(SOLIDUS79_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_numeric_primary_expression_in_term934);
            	    numeric_primary_expression80=numeric_primary_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression80.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:151:1: numeric_primary_expression : ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN );
    public final WindowingParser.numeric_primary_expression_return numeric_primary_expression() throws RecognitionException {
        WindowingParser.numeric_primary_expression_return retval = new WindowingParser.numeric_primary_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN83=null;
        Token RPAREN85=null;
        WindowingParser.identifier_return identifier81 = null;

        WindowingParser.signed_numeric_literal_return signed_numeric_literal82 = null;

        WindowingParser.numeric_expression_return numeric_expression84 = null;


        Object LPAREN83_tree=null;
        Object RPAREN85_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:151:28: ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN )
            int alt28=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt28=1;
                }
                break;
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt28=2;
                }
                break;
            case LPAREN:
                {
                alt28=3;
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:152:3: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_numeric_primary_expression948);
                    identifier81=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier81.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:153:3: signed_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signed_numeric_literal_in_numeric_primary_expression955);
                    signed_numeric_literal82=signed_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_numeric_literal82.getTree());

                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:154:3: LPAREN numeric_expression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN83=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numeric_primary_expression962); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN83_tree = (Object)adaptor.create(LPAREN83);
                    adaptor.addChild(root_0, LPAREN83_tree);
                    }
                    pushFollow(FOLLOW_numeric_expression_in_numeric_primary_expression964);
                    numeric_expression84=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression84.getTree());
                    RPAREN85=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numeric_primary_expression966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN85_tree = (Object)adaptor.create(RPAREN85);
                    adaptor.addChild(root_0, RPAREN85_tree);
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:157:1: signed_numeric_literal : ( PLUS | MINUS )? unsigned_numeric_literal ;
    public final WindowingParser.signed_numeric_literal_return signed_numeric_literal() throws RecognitionException {
        WindowingParser.signed_numeric_literal_return retval = new WindowingParser.signed_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set86=null;
        WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal87 = null;


        Object set86_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:157:24: ( ( PLUS | MINUS )? unsigned_numeric_literal )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:158:3: ( PLUS | MINUS )? unsigned_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:158:3: ( PLUS | MINUS )?
            int alt29=2;
            switch ( input.LA(1) ) {
                case PLUS:
                case MINUS:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:
                    {
                    set86=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set86));
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

            pushFollow(FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal985);
            unsigned_numeric_literal87=unsigned_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unsigned_numeric_literal87.getTree());

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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:164:1: unsigned_numeric_literal : ( exact_numeric_literal | approximate_numeric_literal );
    public final WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal() throws RecognitionException {
        WindowingParser.unsigned_numeric_literal_return retval = new WindowingParser.unsigned_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal88 = null;

        WindowingParser.approximate_numeric_literal_return approximate_numeric_literal89 = null;



        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:164:26: ( exact_numeric_literal | approximate_numeric_literal )
            int alt30=2;
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
                            alt30=1;
                            }
                            break;
                        case 96:
                            {
                            alt30=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 30, 7, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 3, input);

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
                    alt30=1;
                    }
                    break;
                case 96:
                    {
                    alt30=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

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
                        alt30=1;
                        }
                        break;
                    case 96:
                        {
                        alt30=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 6, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 2, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:165:3: exact_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal998);
                    exact_numeric_literal88=exact_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal88.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:166:3: approximate_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1004);
                    approximate_numeric_literal89=approximate_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, approximate_numeric_literal89.getTree());

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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:169:1: approximate_numeric_literal : mantissa 'E' exponent ;
    public final WindowingParser.approximate_numeric_literal_return approximate_numeric_literal() throws RecognitionException {
        WindowingParser.approximate_numeric_literal_return retval = new WindowingParser.approximate_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal91=null;
        WindowingParser.mantissa_return mantissa90 = null;

        WindowingParser.exponent_return exponent92 = null;


        Object char_literal91_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:169:29: ( mantissa 'E' exponent )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:170:3: mantissa 'E' exponent
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mantissa_in_approximate_numeric_literal1015);
            mantissa90=mantissa();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mantissa90.getTree());
            char_literal91=(Token)match(input,96,FOLLOW_96_in_approximate_numeric_literal1017); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal91_tree = (Object)adaptor.create(char_literal91);
            adaptor.addChild(root_0, char_literal91_tree);
            }
            pushFollow(FOLLOW_exponent_in_approximate_numeric_literal1019);
            exponent92=exponent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exponent92.getTree());

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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:173:1: exponent : ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER );
    public final WindowingParser.exponent_return exponent() throws RecognitionException {
        WindowingParser.exponent_return retval = new WindowingParser.exponent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS93=null;
        Token NUMBER94=null;
        Token MINUS95=null;
        Token NUMBER96=null;
        Token NUMBER97=null;

        Object PLUS93_tree=null;
        Object NUMBER94_tree=null;
        Object MINUS95_tree=null;
        Object NUMBER96_tree=null;
        Object NUMBER97_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:173:10: ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER )
            int alt31=3;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt31=1;
                }
                break;
            case MINUS:
                {
                alt31=2;
                }
                break;
            case NUMBER:
                {
                alt31=3;
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:174:3: PLUS NUMBER
                    {
                    PLUS93=(Token)match(input,PLUS,FOLLOW_PLUS_in_exponent1030); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS93);

                    NUMBER94=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1032); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER94);



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
                    // 174:15: -> NUMBER
                    {
                        adaptor.addChild(root_0, stream_NUMBER.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:175:3: MINUS NUMBER
                    {
                    MINUS95=(Token)match(input,MINUS,FOLLOW_MINUS_in_exponent1042); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS95);

                    NUMBER96=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1044); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER96);



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
                    // 175:16: -> ^( UMINUS NUMBER )
                    {
                        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:175:19: ^( UMINUS NUMBER )
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:176:3: NUMBER
                    {
                    NUMBER97=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1058); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER97);



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
                    // 176:10: -> NUMBER
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:179:1: mantissa : exact_numeric_literal ;
    public final WindowingParser.mantissa_return mantissa() throws RecognitionException {
        WindowingParser.mantissa_return retval = new WindowingParser.mantissa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal98 = null;



        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:179:10: ( exact_numeric_literal )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:180:3: exact_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_exact_numeric_literal_in_mantissa1074);
            exact_numeric_literal98=exact_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal98.getTree());

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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:183:1: exact_numeric_literal : (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->);
    public final WindowingParser.exact_numeric_literal_return exact_numeric_literal() throws RecognitionException {
        WindowingParser.exact_numeric_literal_return retval = new WindowingParser.exact_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token n2=null;
        Token DOT99=null;
        Token DOT100=null;

        Object n1_tree=null;
        Object n2_tree=null;
        Object DOT99_tree=null;
        Object DOT100_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:183:23: (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->)
            int alt33=2;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt33=1;
                }
                break;
            case DOT:
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
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:185:3: n1= NUMBER ( DOT n2= NUMBER )?
                    {
                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1090); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(n1);

                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:185:13: ( DOT n2= NUMBER )?
                    int alt32=2;
                    switch ( input.LA(1) ) {
                        case DOT:
                            {
                            alt32=1;
                            }
                            break;
                    }

                    switch (alt32) {
                        case 1 :
                            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:185:14: DOT n2= NUMBER
                            {
                            DOT99=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1093); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT99);

                            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1097); if (state.failed) return retval; 
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
                    // 185:31: ->
                    {
                        adaptor.addChild(root_0, 
                        	      ( n2 != null ? adaptor.create(NUMERIC, (n1!=null?n1.getText():null) + '.' + (n2!=null?n2.getText():null)) :  adaptor.create(INTEGER, (n1!=null?n1.getText():null)) )
                              );

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:189:3: DOT n1= NUMBER
                    {
                    DOT100=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1118); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT100);

                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1122); if (state.failed) return retval; 
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
                    // 189:17: ->
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
    // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:192:1: identifier : ID ;
    public final WindowingParser.identifier_return identifier() throws RecognitionException {
        WindowingParser.identifier_return retval = new WindowingParser.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID101=null;

        Object ID101_tree=null;

        try {
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:192:12: ( ID )
            // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:193:3: ID
            {
            root_0 = (Object)adaptor.nil();

            ID101=(Token)match(input,ID,FOLLOW_ID_in_identifier1138); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID101_tree = (Object)adaptor.create(ID101);
            adaptor.addChild(root_0, ID101_tree);
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
        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:144:9: ( PLUS | MINUS )
        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:
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
        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:148:31: ( ASTERISK | SOLIDUS )
        // com\\sap\\hadoop\\com.sap.hadoop.windowing\\parser\\Windowing.g:
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


 

    public static final BitSet FOLLOW_FROM_in_query133 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_tableSpec_in_query135 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_partitionby_in_query138 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_orderby_in_query141 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_WITH_in_query144 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_funclist_in_query146 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_select_in_query149 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_where_in_query152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hivetable_in_tableSpec182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hivetable192 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_hivetable194 = new BitSet(new long[]{0x0000000000F00000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable197 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_COMMA_in_hivetable202 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable204 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_RPAREN_in_hivetable208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namevalue231 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue235 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_EQ_in_namevalue238 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_STRING_in_namevalue242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby264 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_BY_in_orderby266 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby268 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_COMMA_in_orderby271 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby273 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ID_in_ordercolumn294 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby330 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_BY_in_partitionby332 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_partitionby334 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby337 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_partitionby339 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_function_in_funclist361 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_COMMA_in_funclist364 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_function_in_funclist366 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ID_in_function390 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_function392 = new BitSet(new long[]{0x0000000600F00000L});
    public static final BitSet FOLLOW_functionparam_in_function395 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_COMMA_in_function400 = new BitSet(new long[]{0x0000000600C00000L});
    public static final BitSet FOLLOW_functionparam_in_function402 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_RPAREN_in_function406 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_window_expression_in_function409 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_AS_in_function413 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_function417 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_LBRACKET_in_function420 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_function424 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_RBRACKET_in_function426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionparam0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_expression495 = new BitSet(new long[]{0x0000101000000000L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression520 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression522 = new BitSet(new long[]{0x0000048400000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression526 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_AND_in_window_range_expression528 = new BitSet(new long[]{0x0000048400000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary555 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary582 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary597 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression629 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression631 = new BitSet(new long[]{0x0000048200000000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression635 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_AND_in_window_value_expression637 = new BitSet(new long[]{0x0000048200000000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary664 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary691 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary706 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary708 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select744 = new BitSet(new long[]{0x0000000200400000L});
    public static final BitSet FOLLOW_selectColumn_in_select746 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_COMMA_in_select749 = new BitSet(new long[]{0x0000000200400000L});
    public static final BitSet FOLLOW_selectColumn_in_select751 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn773 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn775 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_selectColumn777 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selectColumn780 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ID_in_selectColumn784 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selectColumn786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selectColumn812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where832 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_expression_in_value_expression854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_value_expression860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_numeric_expression872 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_PLUS_in_numeric_expression885 = new BitSet(new long[]{0x0026000400480000L});
    public static final BitSet FOLLOW_MINUS_in_numeric_expression890 = new BitSet(new long[]{0x0026000400480000L});
    public static final BitSet FOLLOW_term_in_numeric_expression894 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term912 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_ASTERISK_in_term925 = new BitSet(new long[]{0x0026000400480000L});
    public static final BitSet FOLLOW_SOLIDUS_in_term930 = new BitSet(new long[]{0x0026000400480000L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term934 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_identifier_in_numeric_primary_expression948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signed_numeric_literal_in_numeric_primary_expression955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_primary_expression962 = new BitSet(new long[]{0x0026000400480000L});
    public static final BitSet FOLLOW_numeric_expression_in_numeric_primary_expression964 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_primary_expression966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_signed_numeric_literal978 = new BitSet(new long[]{0x0026000400000000L});
    public static final BitSet FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mantissa_in_approximate_numeric_literal1015 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_approximate_numeric_literal1017 = new BitSet(new long[]{0x0006000400000000L});
    public static final BitSet FOLLOW_exponent_in_approximate_numeric_literal1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_exponent1030 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_exponent1042 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_mantissa1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1090 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1093 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1118 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1_Windowing875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred2_Windowing915 = new BitSet(new long[]{0x0000000000000002L});

}