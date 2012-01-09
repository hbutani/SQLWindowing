// $ANTLR 3.3 Nov 30, 2010 12:46:29 com/sap/hadoop/windowing/parser/Windowing.g 2012-01-07 18:33:47

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "FROM", "WITH", "ID", "TABLEINPUT", "LPAREN", "COMMA", "RPAREN", "STRING", "EQ", "ORDER", "BY", "ASC", "DESC", "PARTITION", "AS", "LBRACKET", "RBRACKET", "GROOVYEXPRESSION", "NUMBER", "OVER", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "RANGE", "LESS", "MORE", "SELECT", "WHERE", "INTO", "PATH", "FORMAT", "PLUS", "MINUS", "ASTERISK", "SOLIDUS", "DOT", "QUOTE", "COLON", "SEMICOLON", "GE", "GT", "LBRACE", "LE", "LT", "NE", "RBRACE", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "B", "I", "N", "P", "U", "D", "Y", "G", "V", "NOT", "OR", "X", "XOR", "GroovyEscapeSequence", "EscapeSequence", "WS", "J", "K", "Q", "Z", "'E'"
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
    public static final int TABLEINPUT=20;
    public static final int LPAREN=21;
    public static final int COMMA=22;
    public static final int RPAREN=23;
    public static final int STRING=24;
    public static final int EQ=25;
    public static final int ORDER=26;
    public static final int BY=27;
    public static final int ASC=28;
    public static final int DESC=29;
    public static final int PARTITION=30;
    public static final int AS=31;
    public static final int LBRACKET=32;
    public static final int RBRACKET=33;
    public static final int GROOVYEXPRESSION=34;
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
    public String getGrammarFileName() { return "com/sap/hadoop/windowing/parser/Windowing.g"; }


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
    // com/sap/hadoop/windowing/parser/Windowing.g:53:1: query : FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )? -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? ) ;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:53:7: ( FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )? -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:54:2: FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )?
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
            // com/sap/hadoop/windowing/parser/Windowing.g:59:2: ( where )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:59:2: where
                    {
                    pushFollow(FOLLOW_where_in_query157);
                    where8=where();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_where.add(where8.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:60:2: ( outputClause )?
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:60:2: outputClause
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
            // elements: where, select, partitionby, tableSpec, orderby, funclist, outputClause
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
                // com/sap/hadoop/windowing/parser/Windowing.g:60:19: ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                adaptor.addChild(root_1, stream_partitionby.nextTree());
                adaptor.addChild(root_1, stream_orderby.nextTree());
                adaptor.addChild(root_1, stream_funclist.nextTree());
                adaptor.addChild(root_1, stream_select.nextTree());
                // com/sap/hadoop/windowing/parser/Windowing.g:60:73: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.nextTree());

                }
                stream_where.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:60:80: ( outputClause )?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:63:1: tableSpec : ( hivetable | ID -> ^( TABLEINPUT ID ) );
    public final WindowingParser.tableSpec_return tableSpec() throws RecognitionException {
        WindowingParser.tableSpec_return retval = new WindowingParser.tableSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID11=null;
        WindowingParser.hivetable_return hivetable10 = null;


        Object ID11_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:63:11: ( hivetable | ID -> ^( TABLEINPUT ID ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case TABLEINPUT:
                {
                alt3=1;
                }
                break;
            case ID:
                {
                alt3=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:64:2: hivetable
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:65:2: ID
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
                        // com/sap/hadoop/windowing/parser/Windowing.g:65:8: ^( TABLEINPUT ID )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:68:1: hivetable : TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) ;
    public final WindowingParser.hivetable_return hivetable() throws RecognitionException {
        WindowingParser.hivetable_return retval = new WindowingParser.hivetable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TABLEINPUT12=null;
        Token LPAREN13=null;
        Token COMMA15=null;
        Token RPAREN17=null;
        WindowingParser.namevalue_return namevalue14 = null;

        WindowingParser.namevalue_return namevalue16 = null;


        Object TABLEINPUT12_tree=null;
        Object LPAREN13_tree=null;
        Object COMMA15_tree=null;
        Object RPAREN17_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_TABLEINPUT=new RewriteRuleTokenStream(adaptor,"token TABLEINPUT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:68:11: ( TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:69:2: TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            TABLEINPUT12=(Token)match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hivetable218); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TABLEINPUT.add(TABLEINPUT12);

            LPAREN13=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_hivetable220); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN13);

            // com/sap/hadoop/windowing/parser/Windowing.g:69:20: ( namevalue )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                    {
                    alt4=1;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:69:21: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hivetable223);
                    namevalue14=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue14.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:69:33: ( COMMA namevalue )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:69:34: COMMA namevalue
            	    {
            	    COMMA15=(Token)match(input,COMMA,FOLLOW_COMMA_in_hivetable228); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA15);

            	    pushFollow(FOLLOW_namevalue_in_hivetable230);
            	    namevalue16=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue16.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            RPAREN17=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_hivetable234); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN17);



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
            // 69:60: -> ^( TABLEINPUT ( namevalue )* )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:69:63: ^( TABLEINPUT ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_TABLEINPUT.nextNode(), root_1);

                // com/sap/hadoop/windowing/parser/Windowing.g:69:76: ( namevalue )*
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
    // com/sap/hadoop/windowing/parser/Windowing.g:72:1: namevalue : (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) ;
    public final WindowingParser.namevalue_return namevalue() throws RecognitionException {
        WindowingParser.namevalue_return retval = new WindowingParser.namevalue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token v=null;
        Token EQ18=null;

        Object i_tree=null;
        Object v_tree=null;
        Object EQ18_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:72:11: ( (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) )
            // com/sap/hadoop/windowing/parser/Windowing.g:73:2: (i= ID | i= STRING ) EQ v= STRING
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:73:2: (i= ID | i= STRING )
            int alt6=2;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt6=1;
                }
                break;
            case STRING:
                {
                alt6=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:73:3: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_namevalue257); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:73:8: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue261); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ18=(Token)match(input,EQ,FOLLOW_EQ_in_namevalue264); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ18);

            v=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue268); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(v);



            // AST REWRITE
            // elements: v, i
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
            // 73:30: -> ^( PARAM $i $v)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:73:33: ^( PARAM $i $v)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:76:1: orderby : ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
    public final WindowingParser.orderby_return orderby() throws RecognitionException {
        WindowingParser.orderby_return retval = new WindowingParser.orderby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER19=null;
        Token BY20=null;
        Token COMMA22=null;
        WindowingParser.ordercolumn_return ordercolumn21 = null;

        WindowingParser.ordercolumn_return ordercolumn23 = null;


        Object ORDER19_tree=null;
        Object BY20_tree=null;
        Object COMMA22_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_ordercolumn=new RewriteRuleSubtreeStream(adaptor,"rule ordercolumn");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:76:9: ( ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:77:2: ORDER BY ordercolumn ( COMMA ordercolumn )*
            {
            ORDER19=(Token)match(input,ORDER,FOLLOW_ORDER_in_orderby290); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ORDER.add(ORDER19);

            BY20=(Token)match(input,BY,FOLLOW_BY_in_orderby292); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY20);

            pushFollow(FOLLOW_ordercolumn_in_orderby294);
            ordercolumn21=ordercolumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn21.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:77:23: ( COMMA ordercolumn )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:77:24: COMMA ordercolumn
            	    {
            	    COMMA22=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderby297); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA22);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby299);
            	    ordercolumn23=ordercolumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn23.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // 77:44: -> ^( ORDER ( ordercolumn )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:77:47: ^( ORDER ( ordercolumn )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:80:1: ordercolumn : ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) ;
    public final WindowingParser.ordercolumn_return ordercolumn() throws RecognitionException {
        WindowingParser.ordercolumn_return retval = new WindowingParser.ordercolumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token o=null;
        Token ID24=null;

        Object o_tree=null;
        Object ID24_tree=null;
        RewriteRuleTokenStream stream_ASC=new RewriteRuleTokenStream(adaptor,"token ASC");
        RewriteRuleTokenStream stream_DESC=new RewriteRuleTokenStream(adaptor,"token DESC");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:80:13: ( ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:81:2: ID (o= ASC | o= DESC )?
            {
            ID24=(Token)match(input,ID,FOLLOW_ID_in_ordercolumn320); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID24);

            // com/sap/hadoop/windowing/parser/Windowing.g:81:5: (o= ASC | o= DESC )?
            int alt8=3;
            switch ( input.LA(1) ) {
                case ASC:
                    {
                    alt8=1;
                    }
                    break;
                case DESC:
                    {
                    alt8=2;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:81:6: o= ASC
                    {
                    o=(Token)match(input,ASC,FOLLOW_ASC_in_ordercolumn325); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:81:14: o= DESC
                    {
                    o=(Token)match(input,DESC,FOLLOW_DESC_in_ordercolumn331); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESC.add(o);


                    }
                    break;

            }



            // AST REWRITE
            // elements: ID, o
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
            // 81:23: -> ^( ORDERCOLUMN ID ( $o)? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:81:26: ^( ORDERCOLUMN ID ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:81:43: ( $o)?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:84:1: partitionby : PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) ;
    public final WindowingParser.partitionby_return partitionby() throws RecognitionException {
        WindowingParser.partitionby_return retval = new WindowingParser.partitionby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PARTITION25=null;
        Token BY26=null;
        Token ID27=null;
        Token COMMA28=null;
        Token ID29=null;

        Object PARTITION25_tree=null;
        Object BY26_tree=null;
        Object ID27_tree=null;
        Object COMMA28_tree=null;
        Object ID29_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:84:13: ( PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:85:2: PARTITION BY ID ( COMMA ID )*
            {
            PARTITION25=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_partitionby356); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARTITION.add(PARTITION25);

            BY26=(Token)match(input,BY,FOLLOW_BY_in_partitionby358); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY26);

            ID27=(Token)match(input,ID,FOLLOW_ID_in_partitionby360); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID27);

            // com/sap/hadoop/windowing/parser/Windowing.g:85:18: ( COMMA ID )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:85:19: COMMA ID
            	    {
            	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_partitionby363); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA28);

            	    ID29=(Token)match(input,ID,FOLLOW_ID_in_partitionby365); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID29);


            	    }
            	    break;

            	default :
            	    break loop9;
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
            // 85:30: -> ^( PARTITION ( ID )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:85:33: ^( PARTITION ( ID )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:88:1: funclist : function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) ;
    public final WindowingParser.funclist_return funclist() throws RecognitionException {
        WindowingParser.funclist_return retval = new WindowingParser.funclist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA31=null;
        WindowingParser.function_return function30 = null;

        WindowingParser.function_return function32 = null;


        Object COMMA31_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:88:10: ( function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:89:2: function ( COMMA function )*
            {
            pushFollow(FOLLOW_function_in_funclist387);
            function30=function();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function.add(function30.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:89:11: ( COMMA function )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:89:12: COMMA function
            	    {
            	    COMMA31=(Token)match(input,COMMA,FOLLOW_COMMA_in_funclist390); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA31);

            	    pushFollow(FOLLOW_function_in_funclist392);
            	    function32=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function.add(function32.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
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
            // 89:29: -> ^( FUNCTIONS ( function )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:89:32: ^( FUNCTIONS ( function )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:92:1: function : name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) ;
    public final WindowingParser.function_return function() throws RecognitionException {
        WindowingParser.function_return retval = new WindowingParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token alias=null;
        Token typeNm=null;
        Token LPAREN33=null;
        Token COMMA35=null;
        Token RPAREN37=null;
        Token AS39=null;
        Token LBRACKET40=null;
        Token RBRACKET41=null;
        WindowingParser.functionparam_return functionparam34 = null;

        WindowingParser.functionparam_return functionparam36 = null;

        WindowingParser.window_expression_return window_expression38 = null;


        Object name_tree=null;
        Object alias_tree=null;
        Object typeNm_tree=null;
        Object LPAREN33_tree=null;
        Object COMMA35_tree=null;
        Object RPAREN37_tree=null;
        Object AS39_tree=null;
        Object LBRACKET40_tree=null;
        Object RBRACKET41_tree=null;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:92:10: (name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:93:2: name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )?
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_function416); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN33=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function418); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN33);

            // com/sap/hadoop/windowing/parser/Windowing.g:93:17: ( functionparam )?
            int alt11=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                case GROOVYEXPRESSION:
                case NUMBER:
                    {
                    alt11=1;
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:93:18: functionparam
                    {
                    pushFollow(FOLLOW_functionparam_in_function421);
                    functionparam34=functionparam();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionparam.add(functionparam34.getTree());

                    }
                    break;

            }

            // com/sap/hadoop/windowing/parser/Windowing.g:93:34: ( COMMA functionparam )*
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
            	    // com/sap/hadoop/windowing/parser/Windowing.g:93:35: COMMA functionparam
            	    {
            	    COMMA35=(Token)match(input,COMMA,FOLLOW_COMMA_in_function426); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA35);

            	    pushFollow(FOLLOW_functionparam_in_function428);
            	    functionparam36=functionparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_functionparam.add(functionparam36.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            RPAREN37=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function432); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN37);

            // com/sap/hadoop/windowing/parser/Windowing.g:93:64: ( window_expression )?
            int alt13=2;
            switch ( input.LA(1) ) {
                case OVER:
                    {
                    alt13=1;
                    }
                    break;
            }

            switch (alt13) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:93:65: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function435);
                    window_expression38=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression38.getTree());

                    }
                    break;

            }

            AS39=(Token)match(input,AS,FOLLOW_AS_in_function439); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AS.add(AS39);

            alias=(Token)match(input,ID,FOLLOW_ID_in_function443); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(alias);

            // com/sap/hadoop/windowing/parser/Windowing.g:93:97: ( LBRACKET typeNm= ID RBRACKET )?
            int alt14=2;
            switch ( input.LA(1) ) {
                case LBRACKET:
                    {
                    alt14=1;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:93:98: LBRACKET typeNm= ID RBRACKET
                    {
                    LBRACKET40=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_function446); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET40);

                    typeNm=(Token)match(input,ID,FOLLOW_ID_in_function450); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(typeNm);

                    RBRACKET41=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_function452); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET41);


                    }
                    break;

            }



            // AST REWRITE
            // elements: window_expression, typeNm, name, functionparam, alias
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
            // 93:128: -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:94:7: ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_alias.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:94:31: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.nextTree());

                }
                stream_functionparam.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:94:46: ( ^( TYPENAME $typeNm) )?
                if ( stream_typeNm.hasNext() ) {
                    // com/sap/hadoop/windowing/parser/Windowing.g:94:46: ^( TYPENAME $typeNm)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                    adaptor.addChild(root_2, stream_typeNm.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_typeNm.reset();
                // com/sap/hadoop/windowing/parser/Windowing.g:94:67: ( window_expression )?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:97:1: functionparam : ( GROOVYEXPRESSION | STRING | ID | NUMBER );
    public final WindowingParser.functionparam_return functionparam() throws RecognitionException {
        WindowingParser.functionparam_return retval = new WindowingParser.functionparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set42=null;

        Object set42_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:97:16: ( GROOVYEXPRESSION | STRING | ID | NUMBER )
            // com/sap/hadoop/windowing/parser/Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set42=(Token)input.LT(1);
            if ( input.LA(1)==ID||input.LA(1)==STRING||(input.LA(1)>=GROOVYEXPRESSION && input.LA(1)<=NUMBER) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set42));
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
    // com/sap/hadoop/windowing/parser/Windowing.g:101:1: window_expression : OVER ( window_range_expression | window_value_expression ) ;
    public final WindowingParser.window_expression_return window_expression() throws RecognitionException {
        WindowingParser.window_expression_return retval = new WindowingParser.window_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OVER43=null;
        WindowingParser.window_range_expression_return window_range_expression44 = null;

        WindowingParser.window_value_expression_return window_value_expression45 = null;


        Object OVER43_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:101:19: ( OVER ( window_range_expression | window_value_expression ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:102:2: OVER ( window_range_expression | window_value_expression )
            {
            root_0 = (Object)adaptor.nil();

            OVER43=(Token)match(input,OVER,FOLLOW_OVER_in_window_expression521); if (state.failed) return retval;
            // com/sap/hadoop/windowing/parser/Windowing.g:103:2: ( window_range_expression | window_value_expression )
            int alt15=2;
            switch ( input.LA(1) ) {
            case ROWS:
                {
                alt15=1;
                }
                break;
            case RANGE:
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:103:3: window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression527);
                    window_range_expression44=window_range_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_range_expression44.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:104:2: window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression532);
                    window_value_expression45=window_value_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_value_expression45.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:108:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final WindowingParser.window_range_expression_return window_range_expression() throws RecognitionException {
        WindowingParser.window_range_expression_return retval = new WindowingParser.window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS46=null;
        Token BETWEEN47=null;
        Token AND48=null;
        WindowingParser.rowsboundary_return s = null;

        WindowingParser.rowsboundary_return e = null;


        Object ROWS46_tree=null;
        Object BETWEEN47_tree=null;
        Object AND48_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:108:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // com/sap/hadoop/windowing/parser/Windowing.g:109:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS46=(Token)match(input,ROWS,FOLLOW_ROWS_in_window_range_expression546); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ROWS.add(ROWS46);

            BETWEEN47=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression548); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN47);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression552);
            s=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(s.getTree());
            AND48=(Token)match(input,AND,FOLLOW_AND_in_window_range_expression554); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND48);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression558);
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
            // 109:49: -> ^( WINDOWRANGE $s $e)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:109:52: ^( WINDOWRANGE $s $e)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:112:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );
    public final WindowingParser.rowsboundary_return rowsboundary() throws RecognitionException {
        WindowingParser.rowsboundary_return retval = new WindowingParser.rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED49=null;
        Token CURRENT50=null;
        Token ROW51=null;
        Token NUMBER52=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED49_tree=null;
        Object CURRENT50_tree=null;
        Object ROW51_tree=null;
        Object NUMBER52_tree=null;
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:112:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt18=1;
                }
                break;
            case CURRENT:
                {
                alt18=2;
                }
                break;
            case NUMBER:
                {
                alt18=3;
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:113:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED49=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary581); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED49);

                    // com/sap/hadoop/windowing/parser/Windowing.g:113:13: (r= PRECEDING | r= FOLLOWING )
                    int alt16=2;
                    switch ( input.LA(1) ) {
                    case PRECEDING:
                        {
                        alt16=1;
                        }
                        break;
                    case FOLLOWING:
                        {
                        alt16=2;
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:113:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary586); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:113:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary590); if (state.failed) return retval; 
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
                    // 113:40: -> ^( $r UNBOUNDED )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:113:43: ^( $r UNBOUNDED )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:114:3: CURRENT ROW
                    {
                    CURRENT50=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary608); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT50);

                    ROW51=(Token)match(input,ROW,FOLLOW_ROW_in_rowsboundary610); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW51);



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
                    // 114:16: -> ^( CURRENT )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:114:19: ^( CURRENT )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:115:3: NUMBER (d= PRECEDING | d= FOLLOWING )
                    {
                    NUMBER52=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary623); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER52);

                    // com/sap/hadoop/windowing/parser/Windowing.g:115:10: (d= PRECEDING | d= FOLLOWING )
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:115:11: d= PRECEDING
                            {
                            d=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary628); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:115:25: d= FOLLOWING
                            {
                            d=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary634); if (state.failed) return retval; 
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
                    // 115:39: -> ^( $d NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:115:42: ^( $d NUMBER )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:118:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final WindowingParser.window_value_expression_return window_value_expression() throws RecognitionException {
        WindowingParser.window_value_expression_return retval = new WindowingParser.window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE53=null;
        Token BETWEEN54=null;
        Token AND55=null;
        WindowingParser.valuesboundary_return s = null;

        WindowingParser.valuesboundary_return e = null;


        Object RANGE53_tree=null;
        Object BETWEEN54_tree=null;
        Object AND55_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:118:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // com/sap/hadoop/windowing/parser/Windowing.g:119:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE53=(Token)match(input,RANGE,FOLLOW_RANGE_in_window_value_expression655); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE53);

            BETWEEN54=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression657); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN54);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression661);
            s=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(s.getTree());
            AND55=(Token)match(input,AND,FOLLOW_AND_in_window_value_expression663); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND55);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression667);
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
            // 119:54: -> ^( WINDOWVALUES $s $e)
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:119:57: ^( WINDOWVALUES $s $e)
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
    // com/sap/hadoop/windowing/parser/Windowing.g:122:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );
    public final WindowingParser.valuesboundary_return valuesboundary() throws RecognitionException {
        WindowingParser.valuesboundary_return retval = new WindowingParser.valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED56=null;
        Token CURRENT57=null;
        Token ROW58=null;
        Token GROOVYEXPRESSION59=null;
        Token NUMBER60=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED56_tree=null;
        Object CURRENT57_tree=null;
        Object ROW58_tree=null;
        Object GROOVYEXPRESSION59_tree=null;
        Object NUMBER60_tree=null;
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
            // com/sap/hadoop/windowing/parser/Windowing.g:122:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) )
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
            case GROOVYEXPRESSION:
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:123:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED56=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary690); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED56);

                    // com/sap/hadoop/windowing/parser/Windowing.g:123:13: (r= PRECEDING | r= FOLLOWING )
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:123:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary695); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:123:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary699); if (state.failed) return retval; 
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
                    // 123:40: -> ^( $r UNBOUNDED )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:123:43: ^( $r UNBOUNDED )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:124:3: CURRENT ROW
                    {
                    CURRENT57=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary717); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT57);

                    ROW58=(Token)match(input,ROW,FOLLOW_ROW_in_valuesboundary719); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW58);



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
                    // 124:16: -> ^( CURRENT )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:124:19: ^( CURRENT )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:125:3: GROOVYEXPRESSION NUMBER (d= LESS | d= MORE )
                    {
                    GROOVYEXPRESSION59=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary732); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION59);

                    NUMBER60=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary734); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER60);

                    // com/sap/hadoop/windowing/parser/Windowing.g:125:27: (d= LESS | d= MORE )
                    int alt20=2;
                    switch ( input.LA(1) ) {
                    case LESS:
                        {
                        alt20=1;
                        }
                        break;
                    case MORE:
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
                            // com/sap/hadoop/windowing/parser/Windowing.g:125:28: d= LESS
                            {
                            d=(Token)match(input,LESS,FOLLOW_LESS_in_valuesboundary739); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:125:37: d= MORE
                            {
                            d=(Token)match(input,MORE,FOLLOW_MORE_in_valuesboundary745); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_MORE.add(d);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: d, NUMBER, GROOVYEXPRESSION
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
                    // 125:46: -> ^( $d GROOVYEXPRESSION NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:125:49: ^( $d GROOVYEXPRESSION NUMBER )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:128:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final WindowingParser.select_return select() throws RecognitionException {
        WindowingParser.select_return retval = new WindowingParser.select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT61=null;
        Token COMMA63=null;
        WindowingParser.selectColumn_return selectColumn62 = null;

        WindowingParser.selectColumn_return selectColumn64 = null;


        Object SELECT61_tree=null;
        Object COMMA63_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:128:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:129:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT61=(Token)match(input,SELECT,FOLLOW_SELECT_in_select770); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT61);

            pushFollow(FOLLOW_selectColumn_in_select772);
            selectColumn62=selectColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn62.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:129:23: ( COMMA selectColumn )*
            loop22:
            do {
                int alt22=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt22=1;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:129:24: COMMA selectColumn
            	    {
            	    COMMA63=(Token)match(input,COMMA,FOLLOW_COMMA_in_select775); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA63);

            	    pushFollow(FOLLOW_selectColumn_in_select777);
            	    selectColumn64=selectColumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn64.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
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
            // 129:46: -> ^( SELECT ( selectColumn )+ )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:129:49: ^( SELECT ( selectColumn )+ )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:132:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );
    public final WindowingParser.selectColumn_return selectColumn() throws RecognitionException {
        WindowingParser.selectColumn_return retval = new WindowingParser.selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token typeNm=null;
        Token GROOVYEXPRESSION65=null;
        Token AS66=null;
        Token ID67=null;
        Token LBRACKET68=null;
        Token RBRACKET69=null;
        Token ID70=null;

        Object typeNm_tree=null;
        Object GROOVYEXPRESSION65_tree=null;
        Object AS66_tree=null;
        Object ID67_tree=null;
        Object LBRACKET68_tree=null;
        Object RBRACKET69_tree=null;
        Object ID70_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:132:13: ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) )
            int alt24=2;
            switch ( input.LA(1) ) {
            case GROOVYEXPRESSION:
                {
                alt24=1;
                }
                break;
            case ID:
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:133:3: GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )?
                    {
                    GROOVYEXPRESSION65=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn799); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION65);

                    AS66=(Token)match(input,AS,FOLLOW_AS_in_selectColumn801); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS66);

                    ID67=(Token)match(input,ID,FOLLOW_ID_in_selectColumn803); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID67);

                    // com/sap/hadoop/windowing/parser/Windowing.g:133:26: ( LBRACKET typeNm= ID RBRACKET )?
                    int alt23=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            alt23=1;
                            }
                            break;
                    }

                    switch (alt23) {
                        case 1 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:133:27: LBRACKET typeNm= ID RBRACKET
                            {
                            LBRACKET68=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_selectColumn806); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET68);

                            typeNm=(Token)match(input,ID,FOLLOW_ID_in_selectColumn810); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ID.add(typeNm);

                            RBRACKET69=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_selectColumn812); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET69);


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
                    // 133:57: -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:133:60: ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());
                        // com/sap/hadoop/windowing/parser/Windowing.g:133:95: ( ^( TYPENAME $typeNm) )?
                        if ( stream_typeNm.hasNext() ) {
                            // com/sap/hadoop/windowing/parser/Windowing.g:133:95: ^( TYPENAME $typeNm)
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:134:3: ID
                    {
                    ID70=(Token)match(input,ID,FOLLOW_ID_in_selectColumn838); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID70);



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
                    // 134:6: -> ^( SELECTCOLUMN ID )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:134:9: ^( SELECTCOLUMN ID )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:137:1: where : ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) ;
    public final WindowingParser.where_return where() throws RecognitionException {
        WindowingParser.where_return retval = new WindowingParser.where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE71=null;
        Token GROOVYEXPRESSION72=null;

        Object WHERE71_tree=null;
        Object GROOVYEXPRESSION72_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:137:7: ( ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:138:2: ( WHERE GROOVYEXPRESSION )
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:138:2: ( WHERE GROOVYEXPRESSION )
            // com/sap/hadoop/windowing/parser/Windowing.g:138:3: WHERE GROOVYEXPRESSION
            {
            WHERE71=(Token)match(input,WHERE,FOLLOW_WHERE_in_where858); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHERE.add(WHERE71);

            GROOVYEXPRESSION72=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where860); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION72);


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
            // 138:27: -> ^( WHERE GROOVYEXPRESSION )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:138:30: ^( WHERE GROOVYEXPRESSION )
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
    // com/sap/hadoop/windowing/parser/Windowing.g:141:1: outputClause : ( INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )? ) -> ^( OUTPUTSPEC $p ( $f)? ) ;
    public final WindowingParser.outputClause_return outputClause() throws RecognitionException {
        WindowingParser.outputClause_return retval = new WindowingParser.outputClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token p=null;
        Token f=null;
        Token INTO73=null;
        Token PATH74=null;
        Token EQ75=null;
        Token FORMAT76=null;
        Token EQ77=null;

        Object p_tree=null;
        Object f_tree=null;
        Object INTO73_tree=null;
        Object PATH74_tree=null;
        Object EQ75_tree=null;
        Object FORMAT76_tree=null;
        Object EQ77_tree=null;
        RewriteRuleTokenStream stream_FORMAT=new RewriteRuleTokenStream(adaptor,"token FORMAT");
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_PATH=new RewriteRuleTokenStream(adaptor,"token PATH");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:141:14: ( ( INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )? ) -> ^( OUTPUTSPEC $p ( $f)? ) )
            // com/sap/hadoop/windowing/parser/Windowing.g:142:2: ( INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )? )
            {
            // com/sap/hadoop/windowing/parser/Windowing.g:142:2: ( INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )? )
            // com/sap/hadoop/windowing/parser/Windowing.g:142:3: INTO PATH EQ p= STRING ( FORMAT EQ f= STRING )?
            {
            INTO73=(Token)match(input,INTO,FOLLOW_INTO_in_outputClause880); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTO.add(INTO73);

            PATH74=(Token)match(input,PATH,FOLLOW_PATH_in_outputClause882); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PATH.add(PATH74);

            EQ75=(Token)match(input,EQ,FOLLOW_EQ_in_outputClause884); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ75);

            p=(Token)match(input,STRING,FOLLOW_STRING_in_outputClause888); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(p);

            // com/sap/hadoop/windowing/parser/Windowing.g:142:25: ( FORMAT EQ f= STRING )?
            int alt25=2;
            switch ( input.LA(1) ) {
                case FORMAT:
                    {
                    alt25=1;
                    }
                    break;
            }

            switch (alt25) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:142:26: FORMAT EQ f= STRING
                    {
                    FORMAT76=(Token)match(input,FORMAT,FOLLOW_FORMAT_in_outputClause891); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FORMAT.add(FORMAT76);

                    EQ77=(Token)match(input,EQ,FOLLOW_EQ_in_outputClause893); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQ.add(EQ77);

                    f=(Token)match(input,STRING,FOLLOW_STRING_in_outputClause897); if (state.failed) return retval; 
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
            // 142:48: -> ^( OUTPUTSPEC $p ( $f)? )
            {
                // com/sap/hadoop/windowing/parser/Windowing.g:142:51: ^( OUTPUTSPEC $p ( $f)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUTSPEC, "OUTPUTSPEC"), root_1);

                adaptor.addChild(root_1, stream_p.nextNode());
                // com/sap/hadoop/windowing/parser/Windowing.g:142:67: ( $f)?
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
    // com/sap/hadoop/windowing/parser/Windowing.g:145:1: value_expression : ( numeric_expression | STRING );
    public final WindowingParser.value_expression_return value_expression() throws RecognitionException {
        WindowingParser.value_expression_return retval = new WindowingParser.value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING79=null;
        WindowingParser.numeric_expression_return numeric_expression78 = null;


        Object STRING79_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:145:18: ( numeric_expression | STRING )
            int alt26=2;
            switch ( input.LA(1) ) {
            case ID:
            case LPAREN:
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt26=1;
                }
                break;
            case STRING:
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:146:3: numeric_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_expression_in_value_expression924);
                    numeric_expression78=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression78.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:147:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING79=(Token)match(input,STRING,FOLLOW_STRING_in_value_expression930); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING79_tree = (Object)adaptor.create(STRING79);
                    adaptor.addChild(root_0, STRING79_tree);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:150:1: numeric_expression : term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* ;
    public final WindowingParser.numeric_expression_return numeric_expression() throws RecognitionException {
        WindowingParser.numeric_expression_return retval = new WindowingParser.numeric_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS81=null;
        Token MINUS82=null;
        WindowingParser.term_return term80 = null;

        WindowingParser.term_return term83 = null;


        Object PLUS81_tree=null;
        Object MINUS82_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:150:20: ( term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* )
            // com/sap/hadoop/windowing/parser/Windowing.g:151:3: term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_numeric_expression942);
            term80=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term80.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:151:8: ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==PLUS) && (synpred1_Windowing())) {
                    alt28=1;
                }
                else if ( (LA28_0==MINUS) && (synpred1_Windowing())) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:151:9: ( PLUS | MINUS )=> ( PLUS | MINUS ) term
            	    {
            	    // com/sap/hadoop/windowing/parser/Windowing.g:151:26: ( PLUS | MINUS )
            	    int alt27=2;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt27=1;
            	        }
            	        break;
            	    case MINUS:
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
            	            // com/sap/hadoop/windowing/parser/Windowing.g:151:27: PLUS
            	            {
            	            PLUS81=(Token)match(input,PLUS,FOLLOW_PLUS_in_numeric_expression955); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS81_tree = (Object)adaptor.create(PLUS81);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS81_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/sap/hadoop/windowing/parser/Windowing.g:151:35: MINUS
            	            {
            	            MINUS82=(Token)match(input,MINUS,FOLLOW_MINUS_in_numeric_expression960); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS82_tree = (Object)adaptor.create(MINUS82);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS82_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_numeric_expression964);
            	    term83=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term83.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // com/sap/hadoop/windowing/parser/Windowing.g:154:1: term : numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* ;
    public final WindowingParser.term_return term() throws RecognitionException {
        WindowingParser.term_return retval = new WindowingParser.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASTERISK85=null;
        Token SOLIDUS86=null;
        WindowingParser.numeric_primary_expression_return numeric_primary_expression84 = null;

        WindowingParser.numeric_primary_expression_return numeric_primary_expression87 = null;


        Object ASTERISK85_tree=null;
        Object SOLIDUS86_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:154:7: ( numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* )
            // com/sap/hadoop/windowing/parser/Windowing.g:155:3: numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_numeric_primary_expression_in_term982);
            numeric_primary_expression84=numeric_primary_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression84.getTree());
            // com/sap/hadoop/windowing/parser/Windowing.g:155:30: ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==ASTERISK) && (synpred2_Windowing())) {
                    alt30=1;
                }
                else if ( (LA30_0==SOLIDUS) && (synpred2_Windowing())) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // com/sap/hadoop/windowing/parser/Windowing.g:155:31: ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression
            	    {
            	    // com/sap/hadoop/windowing/parser/Windowing.g:155:54: ( ASTERISK | SOLIDUS )
            	    int alt29=2;
            	    switch ( input.LA(1) ) {
            	    case ASTERISK:
            	        {
            	        alt29=1;
            	        }
            	        break;
            	    case SOLIDUS:
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
            	            // com/sap/hadoop/windowing/parser/Windowing.g:155:55: ASTERISK
            	            {
            	            ASTERISK85=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_term995); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ASTERISK85_tree = (Object)adaptor.create(ASTERISK85);
            	            root_0 = (Object)adaptor.becomeRoot(ASTERISK85_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com/sap/hadoop/windowing/parser/Windowing.g:155:67: SOLIDUS
            	            {
            	            SOLIDUS86=(Token)match(input,SOLIDUS,FOLLOW_SOLIDUS_in_term1000); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SOLIDUS86_tree = (Object)adaptor.create(SOLIDUS86);
            	            root_0 = (Object)adaptor.becomeRoot(SOLIDUS86_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_numeric_primary_expression_in_term1004);
            	    numeric_primary_expression87=numeric_primary_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression87.getTree());

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
    // $ANTLR end "term"

    public static class numeric_primary_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numeric_primary_expression"
    // com/sap/hadoop/windowing/parser/Windowing.g:158:1: numeric_primary_expression : ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN );
    public final WindowingParser.numeric_primary_expression_return numeric_primary_expression() throws RecognitionException {
        WindowingParser.numeric_primary_expression_return retval = new WindowingParser.numeric_primary_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN90=null;
        Token RPAREN92=null;
        WindowingParser.identifier_return identifier88 = null;

        WindowingParser.signed_numeric_literal_return signed_numeric_literal89 = null;

        WindowingParser.numeric_expression_return numeric_expression91 = null;


        Object LPAREN90_tree=null;
        Object RPAREN92_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:158:28: ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN )
            int alt31=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt31=1;
                }
                break;
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt31=2;
                }
                break;
            case LPAREN:
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:159:3: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_numeric_primary_expression1018);
                    identifier88=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier88.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:160:3: signed_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signed_numeric_literal_in_numeric_primary_expression1025);
                    signed_numeric_literal89=signed_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_numeric_literal89.getTree());

                    }
                    break;
                case 3 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:161:3: LPAREN numeric_expression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN90=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numeric_primary_expression1032); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN90_tree = (Object)adaptor.create(LPAREN90);
                    adaptor.addChild(root_0, LPAREN90_tree);
                    }
                    pushFollow(FOLLOW_numeric_expression_in_numeric_primary_expression1034);
                    numeric_expression91=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression91.getTree());
                    RPAREN92=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numeric_primary_expression1036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN92_tree = (Object)adaptor.create(RPAREN92);
                    adaptor.addChild(root_0, RPAREN92_tree);
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
    // com/sap/hadoop/windowing/parser/Windowing.g:164:1: signed_numeric_literal : ( PLUS | MINUS )? unsigned_numeric_literal ;
    public final WindowingParser.signed_numeric_literal_return signed_numeric_literal() throws RecognitionException {
        WindowingParser.signed_numeric_literal_return retval = new WindowingParser.signed_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set93=null;
        WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal94 = null;


        Object set93_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:164:24: ( ( PLUS | MINUS )? unsigned_numeric_literal )
            // com/sap/hadoop/windowing/parser/Windowing.g:165:3: ( PLUS | MINUS )? unsigned_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            // com/sap/hadoop/windowing/parser/Windowing.g:165:3: ( PLUS | MINUS )?
            int alt32=2;
            switch ( input.LA(1) ) {
                case PLUS:
                case MINUS:
                    {
                    alt32=1;
                    }
                    break;
            }

            switch (alt32) {
                case 1 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:
                    {
                    set93=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set93));
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

            pushFollow(FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1055);
            unsigned_numeric_literal94=unsigned_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unsigned_numeric_literal94.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:171:1: unsigned_numeric_literal : ( exact_numeric_literal | approximate_numeric_literal );
    public final WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal() throws RecognitionException {
        WindowingParser.unsigned_numeric_literal_return retval = new WindowingParser.unsigned_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal95 = null;

        WindowingParser.approximate_numeric_literal_return approximate_numeric_literal96 = null;



        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:171:26: ( exact_numeric_literal | approximate_numeric_literal )
            int alt33=2;
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
                            alt33=1;
                            }
                            break;
                        case 100:
                            {
                            alt33=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 33, 7, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 3, input);

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
                    alt33=1;
                    }
                    break;
                case 100:
                    {
                    alt33=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

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
                        alt33=1;
                        }
                        break;
                    case 100:
                        {
                        alt33=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 6, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }

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
                    // com/sap/hadoop/windowing/parser/Windowing.g:172:3: exact_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1068);
                    exact_numeric_literal95=exact_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal95.getTree());

                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:173:3: approximate_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1074);
                    approximate_numeric_literal96=approximate_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, approximate_numeric_literal96.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:176:1: approximate_numeric_literal : mantissa 'E' exponent ;
    public final WindowingParser.approximate_numeric_literal_return approximate_numeric_literal() throws RecognitionException {
        WindowingParser.approximate_numeric_literal_return retval = new WindowingParser.approximate_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal98=null;
        WindowingParser.mantissa_return mantissa97 = null;

        WindowingParser.exponent_return exponent99 = null;


        Object char_literal98_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:176:29: ( mantissa 'E' exponent )
            // com/sap/hadoop/windowing/parser/Windowing.g:177:3: mantissa 'E' exponent
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mantissa_in_approximate_numeric_literal1085);
            mantissa97=mantissa();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mantissa97.getTree());
            char_literal98=(Token)match(input,100,FOLLOW_100_in_approximate_numeric_literal1087); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal98_tree = (Object)adaptor.create(char_literal98);
            adaptor.addChild(root_0, char_literal98_tree);
            }
            pushFollow(FOLLOW_exponent_in_approximate_numeric_literal1089);
            exponent99=exponent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exponent99.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:180:1: exponent : ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER );
    public final WindowingParser.exponent_return exponent() throws RecognitionException {
        WindowingParser.exponent_return retval = new WindowingParser.exponent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS100=null;
        Token NUMBER101=null;
        Token MINUS102=null;
        Token NUMBER103=null;
        Token NUMBER104=null;

        Object PLUS100_tree=null;
        Object NUMBER101_tree=null;
        Object MINUS102_tree=null;
        Object NUMBER103_tree=null;
        Object NUMBER104_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:180:10: ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER )
            int alt34=3;
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
            case NUMBER:
                {
                alt34=3;
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:181:3: PLUS NUMBER
                    {
                    PLUS100=(Token)match(input,PLUS,FOLLOW_PLUS_in_exponent1100); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS100);

                    NUMBER101=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1102); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER101);



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
                    // 181:15: -> NUMBER
                    {
                        adaptor.addChild(root_0, stream_NUMBER.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:182:3: MINUS NUMBER
                    {
                    MINUS102=(Token)match(input,MINUS,FOLLOW_MINUS_in_exponent1112); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS102);

                    NUMBER103=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1114); if (state.failed) return retval; 
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
                    // 182:16: -> ^( UMINUS NUMBER )
                    {
                        // com/sap/hadoop/windowing/parser/Windowing.g:182:19: ^( UMINUS NUMBER )
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:183:3: NUMBER
                    {
                    NUMBER104=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1128); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER104);



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
                    // 183:10: -> NUMBER
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
    // com/sap/hadoop/windowing/parser/Windowing.g:186:1: mantissa : exact_numeric_literal ;
    public final WindowingParser.mantissa_return mantissa() throws RecognitionException {
        WindowingParser.mantissa_return retval = new WindowingParser.mantissa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal105 = null;



        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:186:10: ( exact_numeric_literal )
            // com/sap/hadoop/windowing/parser/Windowing.g:187:3: exact_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_exact_numeric_literal_in_mantissa1144);
            exact_numeric_literal105=exact_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal105.getTree());

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
    // com/sap/hadoop/windowing/parser/Windowing.g:190:1: exact_numeric_literal : (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->);
    public final WindowingParser.exact_numeric_literal_return exact_numeric_literal() throws RecognitionException {
        WindowingParser.exact_numeric_literal_return retval = new WindowingParser.exact_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token n2=null;
        Token DOT106=null;
        Token DOT107=null;

        Object n1_tree=null;
        Object n2_tree=null;
        Object DOT106_tree=null;
        Object DOT107_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:190:23: (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->)
            int alt36=2;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt36=1;
                }
                break;
            case DOT:
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
                    // com/sap/hadoop/windowing/parser/Windowing.g:192:3: n1= NUMBER ( DOT n2= NUMBER )?
                    {
                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1160); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(n1);

                    // com/sap/hadoop/windowing/parser/Windowing.g:192:13: ( DOT n2= NUMBER )?
                    int alt35=2;
                    switch ( input.LA(1) ) {
                        case DOT:
                            {
                            alt35=1;
                            }
                            break;
                    }

                    switch (alt35) {
                        case 1 :
                            // com/sap/hadoop/windowing/parser/Windowing.g:192:14: DOT n2= NUMBER
                            {
                            DOT106=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1163); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT106);

                            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1167); if (state.failed) return retval; 
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
                    // 192:31: ->
                    {
                        adaptor.addChild(root_0, 
                        	      ( n2 != null ? adaptor.create(NUMERIC, (n1!=null?n1.getText():null) + '.' + (n2!=null?n2.getText():null)) :  adaptor.create(INTEGER, (n1!=null?n1.getText():null)) )
                              );

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com/sap/hadoop/windowing/parser/Windowing.g:196:3: DOT n1= NUMBER
                    {
                    DOT107=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1188); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT107);

                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1192); if (state.failed) return retval; 
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
                    // 196:17: ->
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
    // com/sap/hadoop/windowing/parser/Windowing.g:199:1: identifier : ID ;
    public final WindowingParser.identifier_return identifier() throws RecognitionException {
        WindowingParser.identifier_return retval = new WindowingParser.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID108=null;

        Object ID108_tree=null;

        try {
            // com/sap/hadoop/windowing/parser/Windowing.g:199:12: ( ID )
            // com/sap/hadoop/windowing/parser/Windowing.g:200:3: ID
            {
            root_0 = (Object)adaptor.nil();

            ID108=(Token)match(input,ID,FOLLOW_ID_in_identifier1208); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID108_tree = (Object)adaptor.create(ID108);
            adaptor.addChild(root_0, ID108_tree);
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
        // com/sap/hadoop/windowing/parser/Windowing.g:151:9: ( PLUS | MINUS )
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
        // com/sap/hadoop/windowing/parser/Windowing.g:155:31: ( ASTERISK | SOLIDUS )
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


 

    public static final BitSet FOLLOW_FROM_in_query138 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_tableSpec_in_query140 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_partitionby_in_query143 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_orderby_in_query146 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_WITH_in_query149 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_funclist_in_query151 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_select_in_query154 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_where_in_query157 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_outputClause_in_query162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hivetable_in_tableSpec195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tableSpec200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hivetable218 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LPAREN_in_hivetable220 = new BitSet(new long[]{0x0000000001C80000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable223 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_COMMA_in_hivetable228 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable230 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RPAREN_in_hivetable234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namevalue257 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue261 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_EQ_in_namevalue264 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby290 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_BY_in_orderby292 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby294 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_orderby297 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby299 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ID_in_ordercolumn320 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby356 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_BY_in_partitionby358 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_partitionby360 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby363 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_partitionby365 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_function_in_funclist387 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_funclist390 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_function_in_funclist392 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ID_in_function416 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LPAREN_in_function418 = new BitSet(new long[]{0x0000000C01C80000L});
    public static final BitSet FOLLOW_functionparam_in_function421 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_COMMA_in_function426 = new BitSet(new long[]{0x0000000C01080000L});
    public static final BitSet FOLLOW_functionparam_in_function428 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RPAREN_in_function432 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_window_expression_in_function435 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_AS_in_function439 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_function443 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_LBRACKET_in_function446 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_function450 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACKET_in_function452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionparam0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_expression521 = new BitSet(new long[]{0x0000202000000000L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression546 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression548 = new BitSet(new long[]{0x0000090800000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression552 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AND_in_window_range_expression554 = new BitSet(new long[]{0x0000090800000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary581 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary608 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary623 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression655 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression657 = new BitSet(new long[]{0x0000090400000000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression661 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AND_in_window_value_expression663 = new BitSet(new long[]{0x0000090400000000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary690 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary717 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary732 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary734 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select770 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_selectColumn_in_select772 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_select775 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_selectColumn_in_select777 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn799 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn801 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_selectColumn803 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selectColumn806 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_selectColumn810 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selectColumn812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selectColumn838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where858 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_outputClause880 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_PATH_in_outputClause882 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause884 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause888 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_FORMAT_in_outputClause891 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause893 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_expression_in_value_expression924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_value_expression930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_numeric_expression942 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_PLUS_in_numeric_expression955 = new BitSet(new long[]{0x0260000800280000L});
    public static final BitSet FOLLOW_MINUS_in_numeric_expression960 = new BitSet(new long[]{0x0260000800280000L});
    public static final BitSet FOLLOW_term_in_numeric_expression964 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term982 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_ASTERISK_in_term995 = new BitSet(new long[]{0x0260000800280000L});
    public static final BitSet FOLLOW_SOLIDUS_in_term1000 = new BitSet(new long[]{0x0260000800280000L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1004 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_identifier_in_numeric_primary_expression1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signed_numeric_literal_in_numeric_primary_expression1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_primary_expression1032 = new BitSet(new long[]{0x0260000800280000L});
    public static final BitSet FOLLOW_numeric_expression_in_numeric_primary_expression1034 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_primary_expression1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_signed_numeric_literal1048 = new BitSet(new long[]{0x0260000800000000L});
    public static final BitSet FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mantissa_in_approximate_numeric_literal1085 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_approximate_numeric_literal1087 = new BitSet(new long[]{0x0060000800000000L});
    public static final BitSet FOLLOW_exponent_in_approximate_numeric_literal1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_exponent1100 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_exponent1112 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_mantissa1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1160 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1163 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1188 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1_Windowing945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred2_Windowing985 = new BitSet(new long[]{0x0000000000000002L});

}