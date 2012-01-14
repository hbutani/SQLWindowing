// $ANTLR 3.3 Nov 30, 2010 12:46:29 com\\sap\\hadoop\\windowing\\parser\\Windowing.g 2012-01-13 19:09:12

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "FROM", "WITH", "ID", "LPAREN", "GROOVYEXPRESSION", "RPAREN", "TABLEINPUT", "COMMA", "STRING", "EQ", "ORDER", "BY", "ASC", "DESC", "PARTITION", "AS", "LBRACKET", "RBRACKET", "NUMBER", "OVER", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "RANGE", "LESS", "MORE", "SELECT", "WHERE", "INTO", "PATH", "SERDE", "SERDEPROPERTIES", "RECORDWRITER", "FORMAT", "PLUS", "MINUS", "ASTERISK", "SOLIDUS", "DOT", "QUOTE", "COLON", "SEMICOLON", "GE", "GT", "LBRACE", "LE", "LT", "NE", "RBRACE", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "B", "I", "N", "P", "U", "D", "Y", "G", "V", "NOT", "OR", "X", "XOR", "GroovyEscapeSequence", "EscapeSequence", "WS", "J", "K", "Q", "Z", "'E'"
    };
    public static final int EOF=-1;
    public static final int T__103=103;
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
    public static final int SERDE=52;
    public static final int SERDEPROPERTIES=53;
    public static final int RECORDWRITER=54;
    public static final int FORMAT=55;
    public static final int PLUS=56;
    public static final int MINUS=57;
    public static final int ASTERISK=58;
    public static final int SOLIDUS=59;
    public static final int DOT=60;
    public static final int QUOTE=61;
    public static final int COLON=62;
    public static final int SEMICOLON=63;
    public static final int GE=64;
    public static final int GT=65;
    public static final int LBRACE=66;
    public static final int LE=67;
    public static final int LT=68;
    public static final int NE=69;
    public static final int RBRACE=70;
    public static final int S=71;
    public static final int E=72;
    public static final int L=73;
    public static final int C=74;
    public static final int T=75;
    public static final int F=76;
    public static final int R=77;
    public static final int O=78;
    public static final int M=79;
    public static final int W=80;
    public static final int H=81;
    public static final int A=82;
    public static final int B=83;
    public static final int I=84;
    public static final int N=85;
    public static final int P=86;
    public static final int U=87;
    public static final int D=88;
    public static final int Y=89;
    public static final int G=90;
    public static final int V=91;
    public static final int NOT=92;
    public static final int OR=93;
    public static final int X=94;
    public static final int XOR=95;
    public static final int GroovyEscapeSequence=96;
    public static final int EscapeSequence=97;
    public static final int WS=98;
    public static final int J=99;
    public static final int K=100;
    public static final int Q=101;
    public static final int Z=102;

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:57:1: query : FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? ) ;
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
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:57:7: ( FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:58:2: FROM tableSpec partitionby orderby WITH funclist select ( where )? ( outputClause )? EOF
            {
            FROM1=(Token)match(input,FROM,FOLLOW_FROM_in_query137); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM1);

            pushFollow(FOLLOW_tableSpec_in_query139);
            tableSpec2=tableSpec();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tableSpec.add(tableSpec2.getTree());
            pushFollow(FOLLOW_partitionby_in_query142);
            partitionby3=partitionby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_partitionby.add(partitionby3.getTree());
            pushFollow(FOLLOW_orderby_in_query145);
            orderby4=orderby();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orderby.add(orderby4.getTree());
            WITH5=(Token)match(input,WITH,FOLLOW_WITH_in_query148); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WITH.add(WITH5);

            pushFollow(FOLLOW_funclist_in_query150);
            funclist6=funclist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_funclist.add(funclist6.getTree());
            pushFollow(FOLLOW_select_in_query153);
            select7=select();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_select.add(select7.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:63:2: ( where )?
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:63:2: where
                    {
                    pushFollow(FOLLOW_where_in_query156);
                    where8=where();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_where.add(where8.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:64:2: ( outputClause )?
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:64:2: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_query161);
                    outputClause9=outputClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputClause.add(outputClause9.getTree());

                    }
                    break;

            }

            EOF10=(Token)match(input,EOF,FOLLOW_EOF_in_query166); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF10);



            // AST REWRITE
            // elements: funclist, partitionby, outputClause, select, where, tableSpec, orderby
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 65:6: -> ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:65:9: ^( QUERY tableSpec partitionby orderby funclist select ( where )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.nextTree());
                adaptor.addChild(root_1, stream_partitionby.nextTree());
                adaptor.addChild(root_1, stream_orderby.nextTree());
                adaptor.addChild(root_1, stream_funclist.nextTree());
                adaptor.addChild(root_1, stream_select.nextTree());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:65:63: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.nextTree());

                }
                stream_where.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:65:70: ( outputClause )?
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:68:1: tableSpec : ( hivetable | ID -> ^( TABLEINPUT ID ) | ( LPAREN )? h= GROOVYEXPRESSION ( RPAREN )? -> ^( TABLEINPUT $h) );
    public final WindowingParser.tableSpec_return tableSpec() throws RecognitionException {
        WindowingParser.tableSpec_return retval = new WindowingParser.tableSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token h=null;
        Token ID12=null;
        Token LPAREN13=null;
        Token RPAREN14=null;
        WindowingParser.hivetable_return hivetable11 = null;


        Object h_tree=null;
        Object ID12_tree=null;
        Object LPAREN13_tree=null;
        Object RPAREN14_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:68:11: ( hivetable | ID -> ^( TABLEINPUT ID ) | ( LPAREN )? h= GROOVYEXPRESSION ( RPAREN )? -> ^( TABLEINPUT $h) )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:69:2: hivetable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hivetable_in_tableSpec198);
                    hivetable11=hivetable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hivetable11.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:2: ID
                    {
                    ID12=(Token)match(input,ID,FOLLOW_ID_in_tableSpec203); if (state.failed) return retval; 
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
                    // 70:5: -> ^( TABLEINPUT ID )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:70:8: ^( TABLEINPUT ID )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:71:2: ( LPAREN )? h= GROOVYEXPRESSION ( RPAREN )?
                    {
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:71:2: ( LPAREN )?
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:71:2: LPAREN
                            {
                            LPAREN13=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tableSpec216); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN13);


                            }
                            break;

                    }

                    h=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_tableSpec221); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(h);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:71:29: ( RPAREN )?
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:71:29: RPAREN
                            {
                            RPAREN14=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tableSpec223); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN14);


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
                    // 71:37: -> ^( TABLEINPUT $h)
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:71:40: ^( TABLEINPUT $h)
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:1: hivetable : TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) ;
    public final WindowingParser.hivetable_return hivetable() throws RecognitionException {
        WindowingParser.hivetable_return retval = new WindowingParser.hivetable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TABLEINPUT15=null;
        Token LPAREN16=null;
        Token COMMA18=null;
        Token RPAREN20=null;
        WindowingParser.namevalue_return namevalue17 = null;

        WindowingParser.namevalue_return namevalue19 = null;


        Object TABLEINPUT15_tree=null;
        Object LPAREN16_tree=null;
        Object COMMA18_tree=null;
        Object RPAREN20_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_TABLEINPUT=new RewriteRuleTokenStream(adaptor,"token TABLEINPUT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:74:11: ( TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( TABLEINPUT ( namevalue )* ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:75:2: TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            TABLEINPUT15=(Token)match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hivetable243); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TABLEINPUT.add(TABLEINPUT15);

            LPAREN16=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_hivetable245); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN16);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:75:20: ( namevalue )?
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:75:21: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hivetable248);
                    namevalue17=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue17.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:75:33: ( COMMA namevalue )*
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
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:75:34: COMMA namevalue
            	    {
            	    COMMA18=(Token)match(input,COMMA,FOLLOW_COMMA_in_hivetable253); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA18);

            	    pushFollow(FOLLOW_namevalue_in_hivetable255);
            	    namevalue19=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue19.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            RPAREN20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_hivetable259); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN20);



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
            // 75:60: -> ^( TABLEINPUT ( namevalue )* )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:75:63: ^( TABLEINPUT ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_TABLEINPUT.nextNode(), root_1);

                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:75:76: ( namevalue )*
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:78:1: namevalue : (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) ;
    public final WindowingParser.namevalue_return namevalue() throws RecognitionException {
        WindowingParser.namevalue_return retval = new WindowingParser.namevalue_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token v=null;
        Token EQ21=null;

        Object i_tree=null;
        Object v_tree=null;
        Object EQ21_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:78:11: ( (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:2: (i= ID | i= STRING ) EQ v= STRING
            {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:2: (i= ID | i= STRING )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:3: i= ID
                    {
                    i=(Token)match(input,ID,FOLLOW_ID_in_namevalue282); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:8: i= STRING
                    {
                    i=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue286); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(i);


                    }
                    break;

            }

            EQ21=(Token)match(input,EQ,FOLLOW_EQ_in_namevalue289); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ21);

            v=(Token)match(input,STRING,FOLLOW_STRING_in_namevalue293); if (state.failed) return retval; 
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
            // 79:30: -> ^( PARAM $i $v)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:79:33: ^( PARAM $i $v)
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:82:1: orderby : ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
    public final WindowingParser.orderby_return orderby() throws RecognitionException {
        WindowingParser.orderby_return retval = new WindowingParser.orderby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER22=null;
        Token BY23=null;
        Token COMMA25=null;
        WindowingParser.ordercolumn_return ordercolumn24 = null;

        WindowingParser.ordercolumn_return ordercolumn26 = null;


        Object ORDER22_tree=null;
        Object BY23_tree=null;
        Object COMMA25_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_ordercolumn=new RewriteRuleSubtreeStream(adaptor,"rule ordercolumn");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:82:9: ( ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:83:2: ORDER BY ordercolumn ( COMMA ordercolumn )*
            {
            ORDER22=(Token)match(input,ORDER,FOLLOW_ORDER_in_orderby315); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ORDER.add(ORDER22);

            BY23=(Token)match(input,BY,FOLLOW_BY_in_orderby317); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY23);

            pushFollow(FOLLOW_ordercolumn_in_orderby319);
            ordercolumn24=ordercolumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn24.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:83:23: ( COMMA ordercolumn )*
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
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:83:24: COMMA ordercolumn
            	    {
            	    COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderby322); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA25);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby324);
            	    ordercolumn26=ordercolumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_ordercolumn.add(ordercolumn26.getTree());

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
            // 83:44: -> ^( ORDER ( ordercolumn )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:83:47: ^( ORDER ( ordercolumn )+ )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:86:1: ordercolumn : ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) ;
    public final WindowingParser.ordercolumn_return ordercolumn() throws RecognitionException {
        WindowingParser.ordercolumn_return retval = new WindowingParser.ordercolumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token o=null;
        Token ID27=null;

        Object o_tree=null;
        Object ID27_tree=null;
        RewriteRuleTokenStream stream_ASC=new RewriteRuleTokenStream(adaptor,"token ASC");
        RewriteRuleTokenStream stream_DESC=new RewriteRuleTokenStream(adaptor,"token DESC");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:86:13: ( ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:87:2: ID (o= ASC | o= DESC )?
            {
            ID27=(Token)match(input,ID,FOLLOW_ID_in_ordercolumn345); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID27);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:87:5: (o= ASC | o= DESC )?
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:87:6: o= ASC
                    {
                    o=(Token)match(input,ASC,FOLLOW_ASC_in_ordercolumn350); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:87:14: o= DESC
                    {
                    o=(Token)match(input,DESC,FOLLOW_DESC_in_ordercolumn356); if (state.failed) return retval; 
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
            // 87:23: -> ^( ORDERCOLUMN ID ( $o)? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:87:26: ^( ORDERCOLUMN ID ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:87:43: ( $o)?
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:90:1: partitionby : PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) ;
    public final WindowingParser.partitionby_return partitionby() throws RecognitionException {
        WindowingParser.partitionby_return retval = new WindowingParser.partitionby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PARTITION28=null;
        Token BY29=null;
        Token ID30=null;
        Token COMMA31=null;
        Token ID32=null;

        Object PARTITION28_tree=null;
        Object BY29_tree=null;
        Object ID30_tree=null;
        Object COMMA31_tree=null;
        Object ID32_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:90:13: ( PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:91:2: PARTITION BY ID ( COMMA ID )*
            {
            PARTITION28=(Token)match(input,PARTITION,FOLLOW_PARTITION_in_partitionby381); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PARTITION.add(PARTITION28);

            BY29=(Token)match(input,BY,FOLLOW_BY_in_partitionby383); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY29);

            ID30=(Token)match(input,ID,FOLLOW_ID_in_partitionby385); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID30);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:91:18: ( COMMA ID )*
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
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:91:19: COMMA ID
            	    {
            	    COMMA31=(Token)match(input,COMMA,FOLLOW_COMMA_in_partitionby388); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA31);

            	    ID32=(Token)match(input,ID,FOLLOW_ID_in_partitionby390); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID32);


            	    }
            	    break;

            	default :
            	    break loop11;
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
            // 91:30: -> ^( PARTITION ( ID )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:91:33: ^( PARTITION ( ID )+ )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:1: funclist : function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) ;
    public final WindowingParser.funclist_return funclist() throws RecognitionException {
        WindowingParser.funclist_return retval = new WindowingParser.funclist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA34=null;
        WindowingParser.function_return function33 = null;

        WindowingParser.function_return function35 = null;


        Object COMMA34_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:94:10: ( function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:2: function ( COMMA function )*
            {
            pushFollow(FOLLOW_function_in_funclist412);
            function33=function();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_function.add(function33.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:11: ( COMMA function )*
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
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:12: COMMA function
            	    {
            	    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_funclist415); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA34);

            	    pushFollow(FOLLOW_function_in_funclist417);
            	    function35=function();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_function.add(function35.getTree());

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
            // 95:29: -> ^( FUNCTIONS ( function )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:95:32: ^( FUNCTIONS ( function )+ )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:98:1: function : name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) ;
    public final WindowingParser.function_return function() throws RecognitionException {
        WindowingParser.function_return retval = new WindowingParser.function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token alias=null;
        Token typeNm=null;
        Token LPAREN36=null;
        Token COMMA38=null;
        Token RPAREN40=null;
        Token AS42=null;
        Token LBRACKET43=null;
        Token RBRACKET44=null;
        WindowingParser.functionparam_return functionparam37 = null;

        WindowingParser.functionparam_return functionparam39 = null;

        WindowingParser.window_expression_return window_expression41 = null;


        Object name_tree=null;
        Object alias_tree=null;
        Object typeNm_tree=null;
        Object LPAREN36_tree=null;
        Object COMMA38_tree=null;
        Object RPAREN40_tree=null;
        Object AS42_tree=null;
        Object LBRACKET43_tree=null;
        Object RBRACKET44_tree=null;
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
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:98:10: (name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:2: name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )?
            {
            name=(Token)match(input,ID,FOLLOW_ID_in_function441); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            LPAREN36=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function443); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN36);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:17: ( functionparam )?
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:18: functionparam
                    {
                    pushFollow(FOLLOW_functionparam_in_function446);
                    functionparam37=functionparam();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionparam.add(functionparam37.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:34: ( COMMA functionparam )*
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
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:35: COMMA functionparam
            	    {
            	    COMMA38=(Token)match(input,COMMA,FOLLOW_COMMA_in_function451); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA38);

            	    pushFollow(FOLLOW_functionparam_in_function453);
            	    functionparam39=functionparam();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_functionparam.add(functionparam39.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            RPAREN40=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function457); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN40);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:64: ( window_expression )?
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:65: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function460);
                    window_expression41=window_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_window_expression.add(window_expression41.getTree());

                    }
                    break;

            }

            AS42=(Token)match(input,AS,FOLLOW_AS_in_function464); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AS.add(AS42);

            alias=(Token)match(input,ID,FOLLOW_ID_in_function468); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(alias);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:97: ( LBRACKET typeNm= ID RBRACKET )?
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:99:98: LBRACKET typeNm= ID RBRACKET
                    {
                    LBRACKET43=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_function471); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET43);

                    typeNm=(Token)match(input,ID,FOLLOW_ID_in_function475); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(typeNm);

                    RBRACKET44=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_function477); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET44);


                    }
                    break;

            }



            // AST REWRITE
            // elements: typeNm, name, functionparam, window_expression, alias
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
            // 99:128: -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:7: ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_alias.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:31: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.nextTree());

                }
                stream_functionparam.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:46: ( ^( TYPENAME $typeNm) )?
                if ( stream_typeNm.hasNext() ) {
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:46: ^( TYPENAME $typeNm)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPENAME, "TYPENAME"), root_2);

                    adaptor.addChild(root_2, stream_typeNm.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_typeNm.reset();
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:100:67: ( window_expression )?
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:103:1: functionparam : ( GROOVYEXPRESSION | STRING | ID | NUMBER );
    public final WindowingParser.functionparam_return functionparam() throws RecognitionException {
        WindowingParser.functionparam_return retval = new WindowingParser.functionparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set45=null;

        Object set45_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:103:16: ( GROOVYEXPRESSION | STRING | ID | NUMBER )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set45=(Token)input.LT(1);
            if ( input.LA(1)==ID||input.LA(1)==GROOVYEXPRESSION||input.LA(1)==STRING||input.LA(1)==NUMBER ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set45));
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:107:1: window_expression : OVER ( window_range_expression | window_value_expression ) ;
    public final WindowingParser.window_expression_return window_expression() throws RecognitionException {
        WindowingParser.window_expression_return retval = new WindowingParser.window_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OVER46=null;
        WindowingParser.window_range_expression_return window_range_expression47 = null;

        WindowingParser.window_value_expression_return window_value_expression48 = null;


        Object OVER46_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:107:19: ( OVER ( window_range_expression | window_value_expression ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:108:2: OVER ( window_range_expression | window_value_expression )
            {
            root_0 = (Object)adaptor.nil();

            OVER46=(Token)match(input,OVER,FOLLOW_OVER_in_window_expression546); if (state.failed) return retval;
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:2: ( window_range_expression | window_value_expression )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:109:3: window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression552);
                    window_range_expression47=window_range_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_range_expression47.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:110:2: window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression557);
                    window_value_expression48=window_value_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, window_value_expression48.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:114:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final WindowingParser.window_range_expression_return window_range_expression() throws RecognitionException {
        WindowingParser.window_range_expression_return retval = new WindowingParser.window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS49=null;
        Token BETWEEN50=null;
        Token AND51=null;
        WindowingParser.rowsboundary_return s = null;

        WindowingParser.rowsboundary_return e = null;


        Object ROWS49_tree=null;
        Object BETWEEN50_tree=null;
        Object AND51_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:114:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:115:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS49=(Token)match(input,ROWS,FOLLOW_ROWS_in_window_range_expression571); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ROWS.add(ROWS49);

            BETWEEN50=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression573); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN50);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression577);
            s=rowsboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowsboundary.add(s.getTree());
            AND51=(Token)match(input,AND,FOLLOW_AND_in_window_range_expression579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND51);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression583);
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
            // 115:49: -> ^( WINDOWRANGE $s $e)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:115:52: ^( WINDOWRANGE $s $e)
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:118:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );
    public final WindowingParser.rowsboundary_return rowsboundary() throws RecognitionException {
        WindowingParser.rowsboundary_return retval = new WindowingParser.rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED52=null;
        Token CURRENT53=null;
        Token ROW54=null;
        Token NUMBER55=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED52_tree=null;
        Object CURRENT53_tree=null;
        Object ROW54_tree=null;
        Object NUMBER55_tree=null;
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:118:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:119:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED52=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary606); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED52);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:119:13: (r= PRECEDING | r= FOLLOWING )
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:119:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary611); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:119:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary615); if (state.failed) return retval; 
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
                    // 119:40: -> ^( $r UNBOUNDED )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:119:43: ^( $r UNBOUNDED )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:120:3: CURRENT ROW
                    {
                    CURRENT53=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary633); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT53);

                    ROW54=(Token)match(input,ROW,FOLLOW_ROW_in_rowsboundary635); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW54);



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
                    // 120:16: -> ^( CURRENT )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:120:19: ^( CURRENT )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:121:3: NUMBER (d= PRECEDING | d= FOLLOWING )
                    {
                    NUMBER55=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary648); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER55);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:121:10: (d= PRECEDING | d= FOLLOWING )
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:121:11: d= PRECEDING
                            {
                            d=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary653); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:121:25: d= FOLLOWING
                            {
                            d=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary659); if (state.failed) return retval; 
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
                    // 121:39: -> ^( $d NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:121:42: ^( $d NUMBER )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:124:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final WindowingParser.window_value_expression_return window_value_expression() throws RecognitionException {
        WindowingParser.window_value_expression_return retval = new WindowingParser.window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE56=null;
        Token BETWEEN57=null;
        Token AND58=null;
        WindowingParser.valuesboundary_return s = null;

        WindowingParser.valuesboundary_return e = null;


        Object RANGE56_tree=null;
        Object BETWEEN57_tree=null;
        Object AND58_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:124:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:125:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE56=(Token)match(input,RANGE,FOLLOW_RANGE_in_window_value_expression680); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RANGE.add(RANGE56);

            BETWEEN57=(Token)match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression682); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BETWEEN.add(BETWEEN57);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression686);
            s=valuesboundary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_valuesboundary.add(s.getTree());
            AND58=(Token)match(input,AND,FOLLOW_AND_in_window_value_expression688); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AND.add(AND58);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression692);
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
            // 125:54: -> ^( WINDOWVALUES $s $e)
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:125:57: ^( WINDOWVALUES $s $e)
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:128:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );
    public final WindowingParser.valuesboundary_return valuesboundary() throws RecognitionException {
        WindowingParser.valuesboundary_return retval = new WindowingParser.valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED59=null;
        Token CURRENT60=null;
        Token ROW61=null;
        Token GROOVYEXPRESSION62=null;
        Token NUMBER63=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED59_tree=null;
        Object CURRENT60_tree=null;
        Object ROW61_tree=null;
        Object GROOVYEXPRESSION62_tree=null;
        Object NUMBER63_tree=null;
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
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:128:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:129:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED59=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary715); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED59);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:129:13: (r= PRECEDING | r= FOLLOWING )
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:129:14: r= PRECEDING
                            {
                            r=(Token)match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary720); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:129:26: r= FOLLOWING
                            {
                            r=(Token)match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary724); if (state.failed) return retval; 
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
                    // 129:40: -> ^( $r UNBOUNDED )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:129:43: ^( $r UNBOUNDED )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:130:3: CURRENT ROW
                    {
                    CURRENT60=(Token)match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary742); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CURRENT.add(CURRENT60);

                    ROW61=(Token)match(input,ROW,FOLLOW_ROW_in_valuesboundary744); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ROW.add(ROW61);



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
                    // 130:16: -> ^( CURRENT )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:130:19: ^( CURRENT )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:131:3: GROOVYEXPRESSION NUMBER (d= LESS | d= MORE )
                    {
                    GROOVYEXPRESSION62=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary757); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION62);

                    NUMBER63=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary759); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER63);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:131:27: (d= LESS | d= MORE )
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:131:28: d= LESS
                            {
                            d=(Token)match(input,LESS,FOLLOW_LESS_in_valuesboundary764); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:131:37: d= MORE
                            {
                            d=(Token)match(input,MORE,FOLLOW_MORE_in_valuesboundary770); if (state.failed) return retval; 
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
                    // 131:46: -> ^( $d GROOVYEXPRESSION NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:131:49: ^( $d GROOVYEXPRESSION NUMBER )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final WindowingParser.select_return select() throws RecognitionException {
        WindowingParser.select_return retval = new WindowingParser.select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT64=null;
        Token COMMA66=null;
        WindowingParser.selectColumn_return selectColumn65 = null;

        WindowingParser.selectColumn_return selectColumn67 = null;


        Object SELECT64_tree=null;
        Object COMMA66_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:134:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:135:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT64=(Token)match(input,SELECT,FOLLOW_SELECT_in_select795); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SELECT.add(SELECT64);

            pushFollow(FOLLOW_selectColumn_in_select797);
            selectColumn65=selectColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn65.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:135:23: ( COMMA selectColumn )*
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
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:135:24: COMMA selectColumn
            	    {
            	    COMMA66=(Token)match(input,COMMA,FOLLOW_COMMA_in_select800); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA66);

            	    pushFollow(FOLLOW_selectColumn_in_select802);
            	    selectColumn67=selectColumn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_selectColumn.add(selectColumn67.getTree());

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
            // 135:46: -> ^( SELECT ( selectColumn )+ )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:135:49: ^( SELECT ( selectColumn )+ )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:138:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );
    public final WindowingParser.selectColumn_return selectColumn() throws RecognitionException {
        WindowingParser.selectColumn_return retval = new WindowingParser.selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token typeNm=null;
        Token GROOVYEXPRESSION68=null;
        Token AS69=null;
        Token ID70=null;
        Token LBRACKET71=null;
        Token RBRACKET72=null;
        Token ID73=null;

        Object typeNm_tree=null;
        Object GROOVYEXPRESSION68_tree=null;
        Object AS69_tree=null;
        Object ID70_tree=null;
        Object LBRACKET71_tree=null;
        Object RBRACKET72_tree=null;
        Object ID73_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:138:13: ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:3: GROOVYEXPRESSION AS ID ( LBRACKET typeNm= ID RBRACKET )?
                    {
                    GROOVYEXPRESSION68=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn824); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION68);

                    AS69=(Token)match(input,AS,FOLLOW_AS_in_selectColumn826); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS69);

                    ID70=(Token)match(input,ID,FOLLOW_ID_in_selectColumn828); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID70);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:26: ( LBRACKET typeNm= ID RBRACKET )?
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
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:27: LBRACKET typeNm= ID RBRACKET
                            {
                            LBRACKET71=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_selectColumn831); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET71);

                            typeNm=(Token)match(input,ID,FOLLOW_ID_in_selectColumn835); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ID.add(typeNm);

                            RBRACKET72=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_selectColumn837); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET72);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: ID, typeNm, GROOVYEXPRESSION
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
                    // 139:57: -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:60: ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.nextNode());
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:95: ( ^( TYPENAME $typeNm) )?
                        if ( stream_typeNm.hasNext() ) {
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:139:95: ^( TYPENAME $typeNm)
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:140:3: ID
                    {
                    ID73=(Token)match(input,ID,FOLLOW_ID_in_selectColumn863); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID73);



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
                    // 140:6: -> ^( SELECTCOLUMN ID )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:140:9: ^( SELECTCOLUMN ID )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:1: where : ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) ;
    public final WindowingParser.where_return where() throws RecognitionException {
        WindowingParser.where_return retval = new WindowingParser.where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE74=null;
        Token GROOVYEXPRESSION75=null;

        Object WHERE74_tree=null;
        Object GROOVYEXPRESSION75_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:143:7: ( ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:2: ( WHERE GROOVYEXPRESSION )
            {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:2: ( WHERE GROOVYEXPRESSION )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:3: WHERE GROOVYEXPRESSION
            {
            WHERE74=(Token)match(input,WHERE,FOLLOW_WHERE_in_where883); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHERE.add(WHERE74);

            GROOVYEXPRESSION75=(Token)match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where885); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION75);


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
            // 144:27: -> ^( WHERE GROOVYEXPRESSION )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:144:30: ^( WHERE GROOVYEXPRESSION )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:147:1: outputClause : INTO PATH EQ p= STRING (s= outputSerDe )? -> ^( OUTPUTSPEC $p ( $s)? ) ;
    public final WindowingParser.outputClause_return outputClause() throws RecognitionException {
        WindowingParser.outputClause_return retval = new WindowingParser.outputClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token p=null;
        Token INTO76=null;
        Token PATH77=null;
        Token EQ78=null;
        WindowingParser.outputSerDe_return s = null;


        Object p_tree=null;
        Object INTO76_tree=null;
        Object PATH77_tree=null;
        Object EQ78_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_PATH=new RewriteRuleTokenStream(adaptor,"token PATH");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_outputSerDe=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDe");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:147:14: ( INTO PATH EQ p= STRING (s= outputSerDe )? -> ^( OUTPUTSPEC $p ( $s)? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:2: INTO PATH EQ p= STRING (s= outputSerDe )?
            {
            INTO76=(Token)match(input,INTO,FOLLOW_INTO_in_outputClause904); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INTO.add(INTO76);

            PATH77=(Token)match(input,PATH,FOLLOW_PATH_in_outputClause906); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PATH.add(PATH77);

            EQ78=(Token)match(input,EQ,FOLLOW_EQ_in_outputClause908); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQ.add(EQ78);

            p=(Token)match(input,STRING,FOLLOW_STRING_in_outputClause912); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(p);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:25: (s= outputSerDe )?
            int alt27=2;
            switch ( input.LA(1) ) {
                case SERDE:
                    {
                    alt27=1;
                    }
                    break;
            }

            switch (alt27) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:25: s= outputSerDe
                    {
                    pushFollow(FOLLOW_outputSerDe_in_outputClause916);
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
            // 148:39: -> ^( OUTPUTSPEC $p ( $s)? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:42: ^( OUTPUTSPEC $p ( $s)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUTSPEC, "OUTPUTSPEC"), root_1);

                adaptor.addChild(root_1, stream_p.nextNode());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:148:58: ( $s)?
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:151:1: outputSerDe : SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) ;
    public final WindowingParser.outputSerDe_return outputSerDe() throws RecognitionException {
        WindowingParser.outputSerDe_return retval = new WindowingParser.outputSerDe_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token SERDE79=null;
        WindowingParser.outputSerDePropeties_return p = null;

        WindowingParser.outputFormatOrWriter_return o = null;


        Object s_tree=null;
        Object SERDE79_tree=null;
        RewriteRuleTokenStream stream_SERDE=new RewriteRuleTokenStream(adaptor,"token SERDE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_outputFormatOrWriter=new RewriteRuleSubtreeStream(adaptor,"rule outputFormatOrWriter");
        RewriteRuleSubtreeStream stream_outputSerDePropeties=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDePropeties");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:151:13: ( SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:3: SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter
            {
            SERDE79=(Token)match(input,SERDE,FOLLOW_SERDE_in_outputSerDe941); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SERDE.add(SERDE79);

            s=(Token)match(input,STRING,FOLLOW_STRING_in_outputSerDe945); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STRING.add(s);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:19: (p= outputSerDePropeties )?
            int alt28=2;
            switch ( input.LA(1) ) {
                case WITH:
                    {
                    alt28=1;
                    }
                    break;
            }

            switch (alt28) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:19: p= outputSerDePropeties
                    {
                    pushFollow(FOLLOW_outputSerDePropeties_in_outputSerDe949);
                    p=outputSerDePropeties();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_outputSerDePropeties.add(p.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe954);
            o=outputFormatOrWriter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_outputFormatOrWriter.add(o.getTree());


            // AST REWRITE
            // elements: SERDE, o, p, s
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
            // 152:65: -> ^( SERDE $s $o ( $p)? )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:68: ^( SERDE $s $o ( $p)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_s.nextNode());
                adaptor.addChild(root_1, stream_o.nextTree());
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:152:82: ( $p)?
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:155:1: outputSerDePropeties : WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) ;
    public final WindowingParser.outputSerDePropeties_return outputSerDePropeties() throws RecognitionException {
        WindowingParser.outputSerDePropeties_return retval = new WindowingParser.outputSerDePropeties_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WITH80=null;
        Token SERDEPROPERTIES81=null;
        Token LPAREN82=null;
        Token COMMA84=null;
        Token RPAREN86=null;
        WindowingParser.namevalue_return namevalue83 = null;

        WindowingParser.namevalue_return namevalue85 = null;


        Object WITH80_tree=null;
        Object SERDEPROPERTIES81_tree=null;
        Object LPAREN82_tree=null;
        Object COMMA84_tree=null;
        Object RPAREN86_tree=null;
        RewriteRuleTokenStream stream_SERDEPROPERTIES=new RewriteRuleTokenStream(adaptor,"token SERDEPROPERTIES");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:155:21: ( WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:3: WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            WITH80=(Token)match(input,WITH,FOLLOW_WITH_in_outputSerDePropeties980); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WITH.add(WITH80);

            SERDEPROPERTIES81=(Token)match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties982); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SERDEPROPERTIES.add(SERDEPROPERTIES81);

            LPAREN82=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_outputSerDePropeties984); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN82);

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:31: ( namevalue )?
            int alt29=2;
            switch ( input.LA(1) ) {
                case ID:
                case STRING:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:32: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties987);
                    namevalue83=namevalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namevalue.add(namevalue83.getTree());

                    }
                    break;

            }

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:44: ( COMMA namevalue )*
            loop30:
            do {
                int alt30=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt30=1;
                    }
                    break;

                }

                switch (alt30) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:156:45: COMMA namevalue
            	    {
            	    COMMA84=(Token)match(input,COMMA,FOLLOW_COMMA_in_outputSerDePropeties992); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA84);

            	    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties994);
            	    namevalue85=namevalue();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_namevalue.add(namevalue85.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            RPAREN86=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_outputSerDePropeties998); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN86);



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
            // 157:6: -> ^( SERDEPROPERTIES ( namevalue )* )
            {
                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:157:9: ^( SERDEPROPERTIES ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDEPROPERTIES.nextNode(), root_1);

                // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:157:27: ( namevalue )*
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:160:1: outputFormatOrWriter : ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) );
    public final WindowingParser.outputFormatOrWriter_return outputFormatOrWriter() throws RecognitionException {
        WindowingParser.outputFormatOrWriter_return retval = new WindowingParser.outputFormatOrWriter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RECORDWRITER87=null;
        Token STRING88=null;
        Token FORMAT89=null;
        Token STRING90=null;

        Object RECORDWRITER87_tree=null;
        Object STRING88_tree=null;
        Object FORMAT89_tree=null;
        Object STRING90_tree=null;
        RewriteRuleTokenStream stream_RECORDWRITER=new RewriteRuleTokenStream(adaptor,"token RECORDWRITER");
        RewriteRuleTokenStream stream_FORMAT=new RewriteRuleTokenStream(adaptor,"token FORMAT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:160:22: ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) )
            int alt31=2;
            switch ( input.LA(1) ) {
            case RECORDWRITER:
                {
                alt31=1;
                }
                break;
            case FORMAT:
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:161:3: RECORDWRITER STRING
                    {
                    RECORDWRITER87=(Token)match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter1024); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RECORDWRITER.add(RECORDWRITER87);

                    STRING88=(Token)match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1026); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING88);



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
                    // 161:23: -> ^( RECORDWRITER STRING )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:161:26: ^( RECORDWRITER STRING )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:162:3: FORMAT STRING
                    {
                    FORMAT89=(Token)match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter1040); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FORMAT.add(FORMAT89);

                    STRING90=(Token)match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1042); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING90);



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
                    // 162:17: -> ^( FORMAT STRING )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:162:20: ^( FORMAT STRING )
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:164:1: value_expression : ( numeric_expression | STRING );
    public final WindowingParser.value_expression_return value_expression() throws RecognitionException {
        WindowingParser.value_expression_return retval = new WindowingParser.value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STRING92=null;
        WindowingParser.numeric_expression_return numeric_expression91 = null;


        Object STRING92_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:164:18: ( numeric_expression | STRING )
            int alt32=2;
            switch ( input.LA(1) ) {
            case ID:
            case LPAREN:
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt32=1;
                }
                break;
            case STRING:
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:165:3: numeric_expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numeric_expression_in_value_expression1060);
                    numeric_expression91=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression91.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:166:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING92=(Token)match(input,STRING,FOLLOW_STRING_in_value_expression1066); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING92_tree = (Object)adaptor.create(STRING92);
                    adaptor.addChild(root_0, STRING92_tree);
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:169:1: numeric_expression : term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* ;
    public final WindowingParser.numeric_expression_return numeric_expression() throws RecognitionException {
        WindowingParser.numeric_expression_return retval = new WindowingParser.numeric_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS94=null;
        Token MINUS95=null;
        WindowingParser.term_return term93 = null;

        WindowingParser.term_return term96 = null;


        Object PLUS94_tree=null;
        Object MINUS95_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:169:20: ( term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )* )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:3: term ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_numeric_expression1078);
            term93=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, term93.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:8: ( ( PLUS | MINUS )=> ( PLUS | MINUS ) term )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==PLUS) && (synpred1_Windowing())) {
                    alt34=1;
                }
                else if ( (LA34_0==MINUS) && (synpred1_Windowing())) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:9: ( PLUS | MINUS )=> ( PLUS | MINUS ) term
            	    {
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:26: ( PLUS | MINUS )
            	    int alt33=2;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt33=1;
            	        }
            	        break;
            	    case MINUS:
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
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:27: PLUS
            	            {
            	            PLUS94=(Token)match(input,PLUS,FOLLOW_PLUS_in_numeric_expression1091); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS94_tree = (Object)adaptor.create(PLUS94);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS94_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:35: MINUS
            	            {
            	            MINUS95=(Token)match(input,MINUS,FOLLOW_MINUS_in_numeric_expression1096); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS95_tree = (Object)adaptor.create(MINUS95);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS95_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_numeric_expression1100);
            	    term96=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, term96.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:173:1: term : numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* ;
    public final WindowingParser.term_return term() throws RecognitionException {
        WindowingParser.term_return retval = new WindowingParser.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASTERISK98=null;
        Token SOLIDUS99=null;
        WindowingParser.numeric_primary_expression_return numeric_primary_expression97 = null;

        WindowingParser.numeric_primary_expression_return numeric_primary_expression100 = null;


        Object ASTERISK98_tree=null;
        Object SOLIDUS99_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:173:7: ( numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )* )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:3: numeric_primary_expression ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_numeric_primary_expression_in_term1118);
            numeric_primary_expression97=numeric_primary_expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression97.getTree());
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:30: ( ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==ASTERISK) && (synpred2_Windowing())) {
                    alt36=1;
                }
                else if ( (LA36_0==SOLIDUS) && (synpred2_Windowing())) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:31: ( ASTERISK | SOLIDUS )=> ( ASTERISK | SOLIDUS ) numeric_primary_expression
            	    {
            	    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:54: ( ASTERISK | SOLIDUS )
            	    int alt35=2;
            	    switch ( input.LA(1) ) {
            	    case ASTERISK:
            	        {
            	        alt35=1;
            	        }
            	        break;
            	    case SOLIDUS:
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
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:55: ASTERISK
            	            {
            	            ASTERISK98=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_term1131); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            ASTERISK98_tree = (Object)adaptor.create(ASTERISK98);
            	            root_0 = (Object)adaptor.becomeRoot(ASTERISK98_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:67: SOLIDUS
            	            {
            	            SOLIDUS99=(Token)match(input,SOLIDUS,FOLLOW_SOLIDUS_in_term1136); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SOLIDUS99_tree = (Object)adaptor.create(SOLIDUS99);
            	            root_0 = (Object)adaptor.becomeRoot(SOLIDUS99_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_numeric_primary_expression_in_term1140);
            	    numeric_primary_expression100=numeric_primary_expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_primary_expression100.getTree());

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
    // $ANTLR end "term"

    public static class numeric_primary_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numeric_primary_expression"
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:177:1: numeric_primary_expression : ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN );
    public final WindowingParser.numeric_primary_expression_return numeric_primary_expression() throws RecognitionException {
        WindowingParser.numeric_primary_expression_return retval = new WindowingParser.numeric_primary_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN103=null;
        Token RPAREN105=null;
        WindowingParser.identifier_return identifier101 = null;

        WindowingParser.signed_numeric_literal_return signed_numeric_literal102 = null;

        WindowingParser.numeric_expression_return numeric_expression104 = null;


        Object LPAREN103_tree=null;
        Object RPAREN105_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:177:28: ( identifier | signed_numeric_literal | LPAREN numeric_expression RPAREN )
            int alt37=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt37=1;
                }
                break;
            case NUMBER:
            case PLUS:
            case MINUS:
            case DOT:
                {
                alt37=2;
                }
                break;
            case LPAREN:
                {
                alt37=3;
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:178:3: identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_identifier_in_numeric_primary_expression1154);
                    identifier101=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier101.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:179:3: signed_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_signed_numeric_literal_in_numeric_primary_expression1161);
                    signed_numeric_literal102=signed_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, signed_numeric_literal102.getTree());

                    }
                    break;
                case 3 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:180:3: LPAREN numeric_expression RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN103=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numeric_primary_expression1168); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN103_tree = (Object)adaptor.create(LPAREN103);
                    adaptor.addChild(root_0, LPAREN103_tree);
                    }
                    pushFollow(FOLLOW_numeric_expression_in_numeric_primary_expression1170);
                    numeric_expression104=numeric_expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, numeric_expression104.getTree());
                    RPAREN105=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numeric_primary_expression1172); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN105_tree = (Object)adaptor.create(RPAREN105);
                    adaptor.addChild(root_0, RPAREN105_tree);
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:1: signed_numeric_literal : ( PLUS | MINUS )? unsigned_numeric_literal ;
    public final WindowingParser.signed_numeric_literal_return signed_numeric_literal() throws RecognitionException {
        WindowingParser.signed_numeric_literal_return retval = new WindowingParser.signed_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set106=null;
        WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal107 = null;


        Object set106_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:183:24: ( ( PLUS | MINUS )? unsigned_numeric_literal )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:184:3: ( PLUS | MINUS )? unsigned_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:184:3: ( PLUS | MINUS )?
            int alt38=2;
            switch ( input.LA(1) ) {
                case PLUS:
                case MINUS:
                    {
                    alt38=1;
                    }
                    break;
            }

            switch (alt38) {
                case 1 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:
                    {
                    set106=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set106));
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

            pushFollow(FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1191);
            unsigned_numeric_literal107=unsigned_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unsigned_numeric_literal107.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:190:1: unsigned_numeric_literal : ( exact_numeric_literal | approximate_numeric_literal );
    public final WindowingParser.unsigned_numeric_literal_return unsigned_numeric_literal() throws RecognitionException {
        WindowingParser.unsigned_numeric_literal_return retval = new WindowingParser.unsigned_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal108 = null;

        WindowingParser.approximate_numeric_literal_return approximate_numeric_literal109 = null;



        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:190:26: ( exact_numeric_literal | approximate_numeric_literal )
            int alt39=2;
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
                            alt39=1;
                            }
                            break;
                        case 103:
                            {
                            alt39=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 39, 7, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 3, input);

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
                    alt39=1;
                    }
                    break;
                case 103:
                    {
                    alt39=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

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
                        alt39=1;
                        }
                        break;
                    case 103:
                        {
                        alt39=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 6, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 2, input);

                    throw nvae;
                }

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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:191:3: exact_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1204);
                    exact_numeric_literal108=exact_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal108.getTree());

                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:192:3: approximate_numeric_literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1210);
                    approximate_numeric_literal109=approximate_numeric_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, approximate_numeric_literal109.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:195:1: approximate_numeric_literal : mantissa 'E' exponent ;
    public final WindowingParser.approximate_numeric_literal_return approximate_numeric_literal() throws RecognitionException {
        WindowingParser.approximate_numeric_literal_return retval = new WindowingParser.approximate_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal111=null;
        WindowingParser.mantissa_return mantissa110 = null;

        WindowingParser.exponent_return exponent112 = null;


        Object char_literal111_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:195:29: ( mantissa 'E' exponent )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:196:3: mantissa 'E' exponent
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mantissa_in_approximate_numeric_literal1221);
            mantissa110=mantissa();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mantissa110.getTree());
            char_literal111=(Token)match(input,103,FOLLOW_103_in_approximate_numeric_literal1223); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal111_tree = (Object)adaptor.create(char_literal111);
            adaptor.addChild(root_0, char_literal111_tree);
            }
            pushFollow(FOLLOW_exponent_in_approximate_numeric_literal1225);
            exponent112=exponent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exponent112.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:199:1: exponent : ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER );
    public final WindowingParser.exponent_return exponent() throws RecognitionException {
        WindowingParser.exponent_return retval = new WindowingParser.exponent_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS113=null;
        Token NUMBER114=null;
        Token MINUS115=null;
        Token NUMBER116=null;
        Token NUMBER117=null;

        Object PLUS113_tree=null;
        Object NUMBER114_tree=null;
        Object MINUS115_tree=null;
        Object NUMBER116_tree=null;
        Object NUMBER117_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:199:10: ( PLUS NUMBER -> NUMBER | MINUS NUMBER -> ^( UMINUS NUMBER ) | NUMBER -> NUMBER )
            int alt40=3;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt40=1;
                }
                break;
            case MINUS:
                {
                alt40=2;
                }
                break;
            case NUMBER:
                {
                alt40=3;
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:200:3: PLUS NUMBER
                    {
                    PLUS113=(Token)match(input,PLUS,FOLLOW_PLUS_in_exponent1236); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS113);

                    NUMBER114=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1238); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER114);



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
                    // 200:15: -> NUMBER
                    {
                        adaptor.addChild(root_0, stream_NUMBER.nextNode());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:201:3: MINUS NUMBER
                    {
                    MINUS115=(Token)match(input,MINUS,FOLLOW_MINUS_in_exponent1248); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS115);

                    NUMBER116=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1250); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER116);



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
                    // 201:16: -> ^( UMINUS NUMBER )
                    {
                        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:201:19: ^( UMINUS NUMBER )
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:202:3: NUMBER
                    {
                    NUMBER117=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exponent1264); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER117);



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
                    // 202:10: -> NUMBER
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:205:1: mantissa : exact_numeric_literal ;
    public final WindowingParser.mantissa_return mantissa() throws RecognitionException {
        WindowingParser.mantissa_return retval = new WindowingParser.mantissa_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        WindowingParser.exact_numeric_literal_return exact_numeric_literal118 = null;



        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:205:10: ( exact_numeric_literal )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:206:3: exact_numeric_literal
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_exact_numeric_literal_in_mantissa1280);
            exact_numeric_literal118=exact_numeric_literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exact_numeric_literal118.getTree());

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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:209:1: exact_numeric_literal : (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->);
    public final WindowingParser.exact_numeric_literal_return exact_numeric_literal() throws RecognitionException {
        WindowingParser.exact_numeric_literal_return retval = new WindowingParser.exact_numeric_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token n2=null;
        Token DOT119=null;
        Token DOT120=null;

        Object n1_tree=null;
        Object n2_tree=null;
        Object DOT119_tree=null;
        Object DOT120_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:209:23: (n1= NUMBER ( DOT n2= NUMBER )? -> | DOT n1= NUMBER ->)
            int alt42=2;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt42=1;
                }
                break;
            case DOT:
                {
                alt42=2;
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
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:211:3: n1= NUMBER ( DOT n2= NUMBER )?
                    {
                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1296); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(n1);

                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:211:13: ( DOT n2= NUMBER )?
                    int alt41=2;
                    switch ( input.LA(1) ) {
                        case DOT:
                            {
                            alt41=1;
                            }
                            break;
                    }

                    switch (alt41) {
                        case 1 :
                            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:211:14: DOT n2= NUMBER
                            {
                            DOT119=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1299); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT119);

                            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1303); if (state.failed) return retval; 
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
                    // 211:31: ->
                    {
                        adaptor.addChild(root_0, 
                        	      ( n2 != null ? adaptor.create(NUMERIC, (n1!=null?n1.getText():null) + '.' + (n2!=null?n2.getText():null)) :  adaptor.create(INTEGER, (n1!=null?n1.getText():null)) )
                              );

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:215:3: DOT n1= NUMBER
                    {
                    DOT120=(Token)match(input,DOT,FOLLOW_DOT_in_exact_numeric_literal1324); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT120);

                    n1=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_exact_numeric_literal1328); if (state.failed) return retval; 
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
                    // 215:17: ->
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
    // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:218:1: identifier : ID ;
    public final WindowingParser.identifier_return identifier() throws RecognitionException {
        WindowingParser.identifier_return retval = new WindowingParser.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID121=null;

        Object ID121_tree=null;

        try {
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:218:12: ( ID )
            // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:219:3: ID
            {
            root_0 = (Object)adaptor.nil();

            ID121=(Token)match(input,ID,FOLLOW_ID_in_identifier1344); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID121_tree = (Object)adaptor.create(ID121);
            adaptor.addChild(root_0, ID121_tree);
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
        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:170:9: ( PLUS | MINUS )
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
        // com\\sap\\hadoop\\windowing\\parser\\Windowing.g:174:31: ( ASTERISK | SOLIDUS )
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


 

    public static final BitSet FOLLOW_FROM_in_query137 = new BitSet(new long[]{0x0000000000B80000L});
    public static final BitSet FOLLOW_tableSpec_in_query139 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_partitionby_in_query142 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_orderby_in_query145 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_WITH_in_query148 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_funclist_in_query150 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_select_in_query153 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_where_in_query156 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_outputClause_in_query161 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hivetable_in_tableSpec198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tableSpec203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tableSpec216 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_tableSpec221 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_RPAREN_in_tableSpec223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hivetable243 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_hivetable245 = new BitSet(new long[]{0x0000000003480000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable248 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_COMMA_in_hivetable253 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_namevalue_in_hivetable255 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_RPAREN_in_hivetable259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namevalue282 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue286 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_namevalue289 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby315 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_BY_in_orderby317 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby319 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_orderby322 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby324 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ID_in_ordercolumn345 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby381 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_BY_in_partitionby383 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_partitionby385 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby388 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_partitionby390 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_function_in_funclist412 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_funclist415 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_function_in_funclist417 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_ID_in_function441 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_function443 = new BitSet(new long[]{0x0000000803680000L});
    public static final BitSet FOLLOW_functionparam_in_function446 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_COMMA_in_function451 = new BitSet(new long[]{0x0000000802280000L});
    public static final BitSet FOLLOW_functionparam_in_function453 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_RPAREN_in_function457 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_window_expression_in_function460 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_AS_in_function464 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_function468 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_LBRACKET_in_function471 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_function475 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_RBRACKET_in_function477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionparam0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_expression546 = new BitSet(new long[]{0x0000202000000000L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression571 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression573 = new BitSet(new long[]{0x0000090800000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression577 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AND_in_window_range_expression579 = new BitSet(new long[]{0x0000090800000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary606 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary633 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary648 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression680 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression682 = new BitSet(new long[]{0x0000090000200000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression686 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_AND_in_window_value_expression688 = new BitSet(new long[]{0x0000090000200000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary715 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary742 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary757 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary759 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select795 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_selectColumn_in_select797 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_COMMA_in_select800 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_selectColumn_in_select802 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn824 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn826 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_selectColumn828 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selectColumn831 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ID_in_selectColumn835 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selectColumn837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selectColumn863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where883 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_outputClause904 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_PATH_in_outputClause906 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause908 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause912 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_outputSerDe_in_outputClause916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERDE_in_outputSerDe941 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_outputSerDe945 = new BitSet(new long[]{0x00C0000000040000L});
    public static final BitSet FOLLOW_outputSerDePropeties_in_outputSerDe949 = new BitSet(new long[]{0x00C0000000040000L});
    public static final BitSet FOLLOW_outputFormatOrWriter_in_outputSerDe954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_outputSerDePropeties980 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties982 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_outputSerDePropeties984 = new BitSet(new long[]{0x0000000003480000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties987 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_COMMA_in_outputSerDePropeties992 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties994 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_RPAREN_in_outputSerDePropeties998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORDWRITER_in_outputFormatOrWriter1024 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAT_in_outputFormatOrWriter1040 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numeric_expression_in_value_expression1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_value_expression1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_numeric_expression1078 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_PLUS_in_numeric_expression1091 = new BitSet(new long[]{0x1300000800180000L});
    public static final BitSet FOLLOW_MINUS_in_numeric_expression1096 = new BitSet(new long[]{0x1300000800180000L});
    public static final BitSet FOLLOW_term_in_numeric_expression1100 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1118 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_ASTERISK_in_term1131 = new BitSet(new long[]{0x1300000800180000L});
    public static final BitSet FOLLOW_SOLIDUS_in_term1136 = new BitSet(new long[]{0x1300000800180000L});
    public static final BitSet FOLLOW_numeric_primary_expression_in_term1140 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_identifier_in_numeric_primary_expression1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signed_numeric_literal_in_numeric_primary_expression1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_primary_expression1168 = new BitSet(new long[]{0x1300000800180000L});
    public static final BitSet FOLLOW_numeric_expression_in_numeric_primary_expression1170 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_primary_expression1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_signed_numeric_literal1184 = new BitSet(new long[]{0x1300000800000000L});
    public static final BitSet FOLLOW_unsigned_numeric_literal_in_signed_numeric_literal1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_unsigned_numeric_literal1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_approximate_numeric_literal_in_unsigned_numeric_literal1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mantissa_in_approximate_numeric_literal1221 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_approximate_numeric_literal1223 = new BitSet(new long[]{0x0300000800000000L});
    public static final BitSet FOLLOW_exponent_in_approximate_numeric_literal1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_exponent1236 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_exponent1248 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exponent1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exact_numeric_literal_in_mantissa1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1296 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1299 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_exact_numeric_literal1324 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_NUMBER_in_exact_numeric_literal1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_identifier1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1_Windowing1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred2_Windowing1121 = new BitSet(new long[]{0x0000000000000002L});

}