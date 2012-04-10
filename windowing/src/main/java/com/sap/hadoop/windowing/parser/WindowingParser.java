// $ANTLR 3.0.1 Windowing.g 2012-04-09 15:32:09

package com.sap.hadoop.windowing.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class WindowingParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "TBLFUNCTION", "LOADSPEC", "FROM", "WITH", "ID", "LPAREN", "COMMA", "RPAREN", "TABLEINPUT", "GROOVYEXPRESSION", "STRING", "EQ", "ORDER", "BY", "ASC", "DESC", "PARTITION", "AS", "LBRACKET", "RBRACKET", "NUMBER", "OVER", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "RANGE", "LESS", "MORE", "SELECT", "WHERE", "INTO", "PATH", "SERDE", "SERDEPROPERTIES", "RECORDWRITER", "FORMAT", "LOAD", "OVERWRITE", "TABLE", "QUOTE", "ASTERISK", "COLON", "SEMICOLON", "DOT", "GE", "GT", "LBRACE", "LE", "LT", "MINUS", "NE", "PLUS", "RBRACE", "SOLIDUS", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "B", "I", "N", "P", "U", "D", "Y", "G", "V", "NOT", "OR", "X", "XOR", "GroovyEscapeSequence", "EscapeSequence", "WS", "J", "K", "Q", "Z"
    };
    public static final int FUNCTION=9;
    public static final int LT=70;
    public static final int ORDERCOLUMN=8;
    public static final int OVERWRITE=59;
    public static final int FUNCTIONS=10;
    public static final int ROW=46;
    public static final int OUTPUTSPEC=16;
    public static final int PARAM=7;
    public static final int NOT=97;
    public static final int EOF=-1;
    public static final int GROOVYEXPRESSION=26;
    public static final int LBRACKET=35;
    public static final int RPAREN=24;
    public static final int QUOTE=61;
    public static final int RECORDWRITER=56;
    public static final int PATH=53;
    public static final int WINDOWRANGE=12;
    public static final int PRECEDING=43;
    public static final int GroovyEscapeSequence=101;
    public static final int LESS=48;
    public static final int SERDEPROPERTIES=55;
    public static final int EQ=28;
    public static final int SELECT=50;
    public static final int INTO=52;
    public static final int NE=72;
    public static final int D=93;
    public static final int TYPENAME=14;
    public static final int E=77;
    public static final int GE=66;
    public static final int F=81;
    public static final int G=95;
    public static final int A=87;
    public static final int RBRACE=74;
    public static final int B=88;
    public static final int ASC=31;
    public static final int C=79;
    public static final int L=78;
    public static final int WINDOWVALUES=13;
    public static final int M=84;
    public static final int N=90;
    public static final int O=83;
    public static final int H=86;
    public static final int I=89;
    public static final int J=104;
    public static final int K=105;
    public static final int NUMBER=37;
    public static final int LOAD=58;
    public static final int U=92;
    public static final int T=80;
    public static final int W=85;
    public static final int V=96;
    public static final int Q=106;
    public static final int SEMICOLON=64;
    public static final int P=91;
    public static final int S=76;
    public static final int NUMERIC=4;
    public static final int R=82;
    public static final int Y=94;
    public static final int X=99;
    public static final int Z=107;
    public static final int WS=103;
    public static final int MORE=49;
    public static final int OR=98;
    public static final int QUERY=11;
    public static final int GT=67;
    public static final int SERDE=54;
    public static final int FROM=19;
    public static final int UNBOUNDED=42;
    public static final int EscapeSequence=102;
    public static final int TBLFUNCTION=17;
    public static final int OVER=38;
    public static final int WHERE=51;
    public static final int SELECTCOLUMN=15;
    public static final int ORDER=29;
    public static final int LBRACE=68;
    public static final int TABLE=60;
    public static final int TABLEINPUT=25;
    public static final int LOADSPEC=18;
    public static final int AND=41;
    public static final int ID=21;
    public static final int FOLLOWING=44;
    public static final int LPAREN=22;
    public static final int ASTERISK=62;
    public static final int AS=34;
    public static final int COMMA=23;
    public static final int PARTITION=33;
    public static final int PLUS=73;
    public static final int RBRACKET=36;
    public static final int DOT=65;
    public static final int WITH=20;
    public static final int INTEGER=5;
    public static final int BY=30;
    public static final int XOR=100;
    public static final int UMINUS=6;
    public static final int RANGE=47;
    public static final int MINUS=71;
    public static final int SOLIDUS=75;
    public static final int CURRENT=45;
    public static final int COLON=63;
    public static final int ROWS=39;
    public static final int FORMAT=57;
    public static final int DESC=32;
    public static final int BETWEEN=40;
    public static final int LE=69;
    public static final int STRING=27;

        public WindowingParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "Windowing.g"; }


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
      


    public static class query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start query
    // Windowing.g:74:1: query : FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec select ( funclist )? ( where )? ( outputClause )? ) ;
    public final query_return query() throws RecognitionException {
        query_return retval = new query_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FROM1=null;
        Token WITH3=null;
        Token EOF8=null;
        tableSpec_return tableSpec2 = null;

        funclist_return funclist4 = null;

        select_return select5 = null;

        where_return where6 = null;

        outputClause_return outputClause7 = null;


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
            // Windowing.g:74:7: ( FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF -> ^( QUERY tableSpec select ( funclist )? ( where )? ( outputClause )? ) )
            // Windowing.g:75:2: FROM tableSpec ( WITH funclist )? select ( where )? ( outputClause )? EOF
            {
            FROM1=(Token)input.LT(1);
            match(input,FROM,FOLLOW_FROM_in_query143); 
            stream_FROM.add(FROM1);

            pushFollow(FOLLOW_tableSpec_in_query145);
            tableSpec2=tableSpec();
            _fsp--;

            stream_tableSpec.add(tableSpec2.getTree());
            // Windowing.g:76:2: ( WITH funclist )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==WITH) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // Windowing.g:76:3: WITH funclist
                    {
                    WITH3=(Token)input.LT(1);
                    match(input,WITH,FOLLOW_WITH_in_query149); 
                    stream_WITH.add(WITH3);

                    pushFollow(FOLLOW_funclist_in_query151);
                    funclist4=funclist();
                    _fsp--;

                    stream_funclist.add(funclist4.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_select_in_query156);
            select5=select();
            _fsp--;

            stream_select.add(select5.getTree());
            // Windowing.g:78:2: ( where )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==WHERE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Windowing.g:78:2: where
                    {
                    pushFollow(FOLLOW_where_in_query159);
                    where6=where();
                    _fsp--;

                    stream_where.add(where6.getTree());

                    }
                    break;

            }

            // Windowing.g:79:2: ( outputClause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==INTO) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Windowing.g:79:2: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_query164);
                    outputClause7=outputClause();
                    _fsp--;

                    stream_outputClause.add(outputClause7.getTree());

                    }
                    break;

            }

            EOF8=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_query169); 
            stream_EOF.add(EOF8);


            // AST REWRITE
            // elements: where, funclist, select, tableSpec, outputClause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 80:6: -> ^( QUERY tableSpec select ( funclist )? ( where )? ( outputClause )? )
            {
                // Windowing.g:80:9: ^( QUERY tableSpec select ( funclist )? ( where )? ( outputClause )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_tableSpec.next());
                adaptor.addChild(root_1, stream_select.next());
                // Windowing.g:80:34: ( funclist )?
                if ( stream_funclist.hasNext() ) {
                    adaptor.addChild(root_1, stream_funclist.next());

                }
                stream_funclist.reset();
                // Windowing.g:80:44: ( where )?
                if ( stream_where.hasNext() ) {
                    adaptor.addChild(root_1, stream_where.next());

                }
                stream_where.reset();
                // Windowing.g:80:51: ( outputClause )?
                if ( stream_outputClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_outputClause.next());

                }
                stream_outputClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class tableSpec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start tableSpec
    // Windowing.g:83:1: tableSpec : ( hdfsFile | hiveTable | hiveQuery | tblfunc );
    public final tableSpec_return tableSpec() throws RecognitionException {
        tableSpec_return retval = new tableSpec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        hdfsFile_return hdfsFile9 = null;

        hiveTable_return hiveTable10 = null;

        hiveQuery_return hiveQuery11 = null;

        tblfunc_return tblfunc12 = null;



        try {
            // Windowing.g:83:11: ( hdfsFile | hiveTable | hiveQuery | tblfunc )
            int alt4=4;
            switch ( input.LA(1) ) {
            case TABLEINPUT:
                {
                alt4=1;
                }
                break;
            case ID:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==LPAREN) ) {
                    alt4=4;
                }
                else if ( (LA4_2==PARTITION) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("83:1: tableSpec : ( hdfsFile | hiveTable | hiveQuery | tblfunc );", 4, 2, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
            case GROOVYEXPRESSION:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("83:1: tableSpec : ( hdfsFile | hiveTable | hiveQuery | tblfunc );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // Windowing.g:84:2: hdfsFile
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hdfsFile_in_tableSpec198);
                    hdfsFile9=hdfsFile();
                    _fsp--;

                    adaptor.addChild(root_0, hdfsFile9.getTree());

                    }
                    break;
                case 2 :
                    // Windowing.g:85:2: hiveTable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hiveTable_in_tableSpec203);
                    hiveTable10=hiveTable();
                    _fsp--;

                    adaptor.addChild(root_0, hiveTable10.getTree());

                    }
                    break;
                case 3 :
                    // Windowing.g:86:2: hiveQuery
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_hiveQuery_in_tableSpec208);
                    hiveQuery11=hiveQuery();
                    _fsp--;

                    adaptor.addChild(root_0, hiveQuery11.getTree());

                    }
                    break;
                case 4 :
                    // Windowing.g:87:2: tblfunc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tblfunc_in_tableSpec213);
                    tblfunc12=tblfunc();
                    _fsp--;

                    adaptor.addChild(root_0, tblfunc12.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class tblfunc_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start tblfunc
    // Windowing.g:90:1: tblfunc : name= ID LPAREN tableSpec ( COMMA functionparam )* RPAREN (p= partitionby o= orderby )? ( window_expression )? -> ^( TBLFUNCTION $name tableSpec ( functionparam )* ( $p)? ( $o)? ( window_expression )? ) ;
    public final tblfunc_return tblfunc() throws RecognitionException {
        tblfunc_return retval = new tblfunc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token LPAREN13=null;
        Token COMMA15=null;
        Token RPAREN17=null;
        partitionby_return p = null;

        orderby_return o = null;

        tableSpec_return tableSpec14 = null;

        functionparam_return functionparam16 = null;

        window_expression_return window_expression18 = null;


        Object name_tree=null;
        Object LPAREN13_tree=null;
        Object COMMA15_tree=null;
        Object RPAREN17_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_window_expression=new RewriteRuleSubtreeStream(adaptor,"rule window_expression");
        RewriteRuleSubtreeStream stream_tableSpec=new RewriteRuleSubtreeStream(adaptor,"rule tableSpec");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        RewriteRuleSubtreeStream stream_functionparam=new RewriteRuleSubtreeStream(adaptor,"rule functionparam");
        try {
            // Windowing.g:90:9: (name= ID LPAREN tableSpec ( COMMA functionparam )* RPAREN (p= partitionby o= orderby )? ( window_expression )? -> ^( TBLFUNCTION $name tableSpec ( functionparam )* ( $p)? ( $o)? ( window_expression )? ) )
            // Windowing.g:91:3: name= ID LPAREN tableSpec ( COMMA functionparam )* RPAREN (p= partitionby o= orderby )? ( window_expression )?
            {
            name=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_tblfunc226); 
            stream_ID.add(name);

            LPAREN13=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_tblfunc228); 
            stream_LPAREN.add(LPAREN13);

            pushFollow(FOLLOW_tableSpec_in_tblfunc230);
            tableSpec14=tableSpec();
            _fsp--;

            stream_tableSpec.add(tableSpec14.getTree());
            // Windowing.g:91:28: ( COMMA functionparam )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Windowing.g:91:29: COMMA functionparam
            	    {
            	    COMMA15=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_tblfunc233); 
            	    stream_COMMA.add(COMMA15);

            	    pushFollow(FOLLOW_functionparam_in_tblfunc235);
            	    functionparam16=functionparam();
            	    _fsp--;

            	    stream_functionparam.add(functionparam16.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            RPAREN17=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_tblfunc239); 
            stream_RPAREN.add(RPAREN17);

            // Windowing.g:91:58: (p= partitionby o= orderby )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==PARTITION) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Windowing.g:91:59: p= partitionby o= orderby
                    {
                    pushFollow(FOLLOW_partitionby_in_tblfunc244);
                    p=partitionby();
                    _fsp--;

                    stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_tblfunc248);
                    o=orderby();
                    _fsp--;

                    stream_orderby.add(o.getTree());

                    }
                    break;

            }

            // Windowing.g:91:85: ( window_expression )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==OVER) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Windowing.g:91:86: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_tblfunc253);
                    window_expression18=window_expression();
                    _fsp--;

                    stream_window_expression.add(window_expression18.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: o, window_expression, tableSpec, p, name, functionparam
            // token labels: name
            // rule labels: retval, p, o
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"token p",p!=null?p.tree:null);
            RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"token o",o!=null?o.tree:null);

            root_0 = (Object)adaptor.nil();
            // 92:5: -> ^( TBLFUNCTION $name tableSpec ( functionparam )* ( $p)? ( $o)? ( window_expression )? )
            {
                // Windowing.g:92:8: ^( TBLFUNCTION $name tableSpec ( functionparam )* ( $p)? ( $o)? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(TBLFUNCTION, "TBLFUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.next());
                adaptor.addChild(root_1, stream_tableSpec.next());
                // Windowing.g:92:38: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.next());

                }
                stream_functionparam.reset();
                // Windowing.g:92:53: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.next());

                }
                stream_p.reset();
                // Windowing.g:92:57: ( $o)?
                if ( stream_o.hasNext() ) {
                    adaptor.addChild(root_1, stream_o.next());

                }
                stream_o.reset();
                // Windowing.g:92:61: ( window_expression )?
                if ( stream_window_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_expression.next());

                }
                stream_window_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:95:1: hdfsFile : TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby -> ^( TABLEINPUT ( namevalue )* $p $o) ;
    public final hdfsFile_return hdfsFile() throws RecognitionException {
        hdfsFile_return retval = new hdfsFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TABLEINPUT19=null;
        Token LPAREN20=null;
        Token COMMA22=null;
        Token RPAREN24=null;
        partitionby_return p = null;

        orderby_return o = null;

        namevalue_return namevalue21 = null;

        namevalue_return namevalue23 = null;


        Object TABLEINPUT19_tree=null;
        Object LPAREN20_tree=null;
        Object COMMA22_tree=null;
        Object RPAREN24_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_TABLEINPUT=new RewriteRuleTokenStream(adaptor,"token TABLEINPUT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        RewriteRuleSubtreeStream stream_namevalue=new RewriteRuleSubtreeStream(adaptor,"rule namevalue");
        try {
            // Windowing.g:95:10: ( TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby -> ^( TABLEINPUT ( namevalue )* $p $o) )
            // Windowing.g:96:2: TABLEINPUT LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN p= partitionby o= orderby
            {
            TABLEINPUT19=(Token)input.LT(1);
            match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hdfsFile294); 
            stream_TABLEINPUT.add(TABLEINPUT19);

            LPAREN20=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_hdfsFile296); 
            stream_LPAREN.add(LPAREN20);

            // Windowing.g:96:20: ( namevalue )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID||LA8_0==STRING) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Windowing.g:96:21: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_hdfsFile299);
                    namevalue21=namevalue();
                    _fsp--;

                    stream_namevalue.add(namevalue21.getTree());

                    }
                    break;

            }

            // Windowing.g:96:33: ( COMMA namevalue )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Windowing.g:96:34: COMMA namevalue
            	    {
            	    COMMA22=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_hdfsFile304); 
            	    stream_COMMA.add(COMMA22);

            	    pushFollow(FOLLOW_namevalue_in_hdfsFile306);
            	    namevalue23=namevalue();
            	    _fsp--;

            	    stream_namevalue.add(namevalue23.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            RPAREN24=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_hdfsFile310); 
            stream_RPAREN.add(RPAREN24);

            pushFollow(FOLLOW_partitionby_in_hdfsFile315);
            p=partitionby();
            _fsp--;

            stream_partitionby.add(p.getTree());
            pushFollow(FOLLOW_orderby_in_hdfsFile319);
            o=orderby();
            _fsp--;

            stream_orderby.add(o.getTree());

            // AST REWRITE
            // elements: p, o, TABLEINPUT, namevalue
            // token labels: 
            // rule labels: retval, p, o
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"token p",p!=null?p.tree:null);
            RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"token o",o!=null?o.tree:null);

            root_0 = (Object)adaptor.nil();
            // 96:84: -> ^( TABLEINPUT ( namevalue )* $p $o)
            {
                // Windowing.g:96:87: ^( TABLEINPUT ( namevalue )* $p $o)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_TABLEINPUT.next(), root_1);

                // Windowing.g:96:100: ( namevalue )*
                while ( stream_namevalue.hasNext() ) {
                    adaptor.addChild(root_1, stream_namevalue.next());

                }
                stream_namevalue.reset();
                adaptor.addChild(root_1, stream_p.next());
                adaptor.addChild(root_1, stream_o.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class hiveTable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start hiveTable
    // Windowing.g:99:1: hiveTable : ID p= partitionby o= orderby -> ^( TABLEINPUT ID $p $o) ;
    public final hiveTable_return hiveTable() throws RecognitionException {
        hiveTable_return retval = new hiveTable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID25=null;
        partitionby_return p = null;

        orderby_return o = null;


        Object ID25_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        try {
            // Windowing.g:99:11: ( ID p= partitionby o= orderby -> ^( TABLEINPUT ID $p $o) )
            // Windowing.g:100:3: ID p= partitionby o= orderby
            {
            ID25=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_hiveTable345); 
            stream_ID.add(ID25);

            pushFollow(FOLLOW_partitionby_in_hiveTable349);
            p=partitionby();
            _fsp--;

            stream_partitionby.add(p.getTree());
            pushFollow(FOLLOW_orderby_in_hiveTable353);
            o=orderby();
            _fsp--;

            stream_orderby.add(o.getTree());

            // AST REWRITE
            // elements: o, ID, p
            // token labels: 
            // rule labels: retval, p, o
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"token p",p!=null?p.tree:null);
            RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"token o",o!=null?o.tree:null);

            root_0 = (Object)adaptor.nil();
            // 100:30: -> ^( TABLEINPUT ID $p $o)
            {
                // Windowing.g:100:33: ^( TABLEINPUT ID $p $o)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                adaptor.addChild(root_1, stream_ID.next());
                adaptor.addChild(root_1, stream_p.next());
                adaptor.addChild(root_1, stream_o.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class hiveQuery_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start hiveQuery
    // Windowing.g:103:1: hiveQuery : (h= GROOVYEXPRESSION p= partitionby o= orderby -> ^( TABLEINPUT $h $p $o) | LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN -> ^( TABLEINPUT $h $p $o) );
    public final hiveQuery_return hiveQuery() throws RecognitionException {
        hiveQuery_return retval = new hiveQuery_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token h=null;
        Token LPAREN26=null;
        Token RPAREN27=null;
        partitionby_return p = null;

        orderby_return o = null;


        Object h_tree=null;
        Object LPAREN26_tree=null;
        Object RPAREN27_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_partitionby=new RewriteRuleSubtreeStream(adaptor,"rule partitionby");
        RewriteRuleSubtreeStream stream_orderby=new RewriteRuleSubtreeStream(adaptor,"rule orderby");
        try {
            // Windowing.g:103:11: (h= GROOVYEXPRESSION p= partitionby o= orderby -> ^( TABLEINPUT $h $p $o) | LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN -> ^( TABLEINPUT $h $p $o) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==GROOVYEXPRESSION) ) {
                alt10=1;
            }
            else if ( (LA10_0==LPAREN) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("103:1: hiveQuery : (h= GROOVYEXPRESSION p= partitionby o= orderby -> ^( TABLEINPUT $h $p $o) | LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN -> ^( TABLEINPUT $h $p $o) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // Windowing.g:104:3: h= GROOVYEXPRESSION p= partitionby o= orderby
                    {
                    h=(Token)input.LT(1);
                    match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_hiveQuery381); 
                    stream_GROOVYEXPRESSION.add(h);

                    pushFollow(FOLLOW_partitionby_in_hiveQuery385);
                    p=partitionby();
                    _fsp--;

                    stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_hiveQuery389);
                    o=orderby();
                    _fsp--;

                    stream_orderby.add(o.getTree());

                    // AST REWRITE
                    // elements: o, p, h
                    // token labels: h
                    // rule labels: retval, p, o
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_h=new RewriteRuleTokenStream(adaptor,"token h",h);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"token p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"token o",o!=null?o.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 104:46: -> ^( TABLEINPUT $h $p $o)
                    {
                        // Windowing.g:104:49: ^( TABLEINPUT $h $p $o)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                        adaptor.addChild(root_1, stream_h.next());
                        adaptor.addChild(root_1, stream_p.next());
                        adaptor.addChild(root_1, stream_o.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // Windowing.g:105:2: LPAREN h= GROOVYEXPRESSION p= partitionby o= orderby RPAREN
                    {
                    LPAREN26=(Token)input.LT(1);
                    match(input,LPAREN,FOLLOW_LPAREN_in_hiveQuery409); 
                    stream_LPAREN.add(LPAREN26);

                    h=(Token)input.LT(1);
                    match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_hiveQuery413); 
                    stream_GROOVYEXPRESSION.add(h);

                    pushFollow(FOLLOW_partitionby_in_hiveQuery417);
                    p=partitionby();
                    _fsp--;

                    stream_partitionby.add(p.getTree());
                    pushFollow(FOLLOW_orderby_in_hiveQuery421);
                    o=orderby();
                    _fsp--;

                    stream_orderby.add(o.getTree());
                    RPAREN27=(Token)input.LT(1);
                    match(input,RPAREN,FOLLOW_RPAREN_in_hiveQuery423); 
                    stream_RPAREN.add(RPAREN27);


                    // AST REWRITE
                    // elements: h, o, p
                    // token labels: h
                    // rule labels: retval, p, o
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_h=new RewriteRuleTokenStream(adaptor,"token h",h);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"token p",p!=null?p.tree:null);
                    RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"token o",o!=null?o.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 105:59: -> ^( TABLEINPUT $h $p $o)
                    {
                        // Windowing.g:105:62: ^( TABLEINPUT $h $p $o)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(TABLEINPUT, "TABLEINPUT"), root_1);

                        adaptor.addChild(root_1, stream_h.next());
                        adaptor.addChild(root_1, stream_p.next());
                        adaptor.addChild(root_1, stream_o.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class namevalue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start namevalue
    // Windowing.g:108:1: namevalue : (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) ;
    public final namevalue_return namevalue() throws RecognitionException {
        namevalue_return retval = new namevalue_return();
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
            // Windowing.g:108:11: ( (i= ID | i= STRING ) EQ v= STRING -> ^( PARAM $i $v) )
            // Windowing.g:109:2: (i= ID | i= STRING ) EQ v= STRING
            {
            // Windowing.g:109:2: (i= ID | i= STRING )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==STRING) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("109:2: (i= ID | i= STRING )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // Windowing.g:109:3: i= ID
                    {
                    i=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_namevalue453); 
                    stream_ID.add(i);


                    }
                    break;
                case 2 :
                    // Windowing.g:109:8: i= STRING
                    {
                    i=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_namevalue457); 
                    stream_STRING.add(i);


                    }
                    break;

            }

            EQ28=(Token)input.LT(1);
            match(input,EQ,FOLLOW_EQ_in_namevalue460); 
            stream_EQ.add(EQ28);

            v=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_namevalue464); 
            stream_STRING.add(v);


            // AST REWRITE
            // elements: v, i
            // token labels: v, i
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
            RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 109:30: -> ^( PARAM $i $v)
            {
                // Windowing.g:109:33: ^( PARAM $i $v)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(PARAM, "PARAM"), root_1);

                adaptor.addChild(root_1, stream_i.next());
                adaptor.addChild(root_1, stream_v.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class orderby_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start orderby
    // Windowing.g:112:1: orderby : ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) ;
    public final orderby_return orderby() throws RecognitionException {
        orderby_return retval = new orderby_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ORDER29=null;
        Token BY30=null;
        Token COMMA32=null;
        ordercolumn_return ordercolumn31 = null;

        ordercolumn_return ordercolumn33 = null;


        Object ORDER29_tree=null;
        Object BY30_tree=null;
        Object COMMA32_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_ordercolumn=new RewriteRuleSubtreeStream(adaptor,"rule ordercolumn");
        try {
            // Windowing.g:112:9: ( ORDER BY ordercolumn ( COMMA ordercolumn )* -> ^( ORDER ( ordercolumn )+ ) )
            // Windowing.g:113:2: ORDER BY ordercolumn ( COMMA ordercolumn )*
            {
            ORDER29=(Token)input.LT(1);
            match(input,ORDER,FOLLOW_ORDER_in_orderby486); 
            stream_ORDER.add(ORDER29);

            BY30=(Token)input.LT(1);
            match(input,BY,FOLLOW_BY_in_orderby488); 
            stream_BY.add(BY30);

            pushFollow(FOLLOW_ordercolumn_in_orderby490);
            ordercolumn31=ordercolumn();
            _fsp--;

            stream_ordercolumn.add(ordercolumn31.getTree());
            // Windowing.g:113:23: ( COMMA ordercolumn )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    int LA12_2 = input.LA(2);

                    if ( (LA12_2==ID) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // Windowing.g:113:24: COMMA ordercolumn
            	    {
            	    COMMA32=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_orderby493); 
            	    stream_COMMA.add(COMMA32);

            	    pushFollow(FOLLOW_ordercolumn_in_orderby495);
            	    ordercolumn33=ordercolumn();
            	    _fsp--;

            	    stream_ordercolumn.add(ordercolumn33.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            // AST REWRITE
            // elements: ordercolumn, ORDER
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 113:44: -> ^( ORDER ( ordercolumn )+ )
            {
                // Windowing.g:113:47: ^( ORDER ( ordercolumn )+ )
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

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:116:1: ordercolumn : ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) ;
    public final ordercolumn_return ordercolumn() throws RecognitionException {
        ordercolumn_return retval = new ordercolumn_return();
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
            // Windowing.g:116:13: ( ID (o= ASC | o= DESC )? -> ^( ORDERCOLUMN ID ( $o)? ) )
            // Windowing.g:117:2: ID (o= ASC | o= DESC )?
            {
            ID34=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_ordercolumn516); 
            stream_ID.add(ID34);

            // Windowing.g:117:5: (o= ASC | o= DESC )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ASC) ) {
                alt13=1;
            }
            else if ( (LA13_0==DESC) ) {
                alt13=2;
            }
            switch (alt13) {
                case 1 :
                    // Windowing.g:117:6: o= ASC
                    {
                    o=(Token)input.LT(1);
                    match(input,ASC,FOLLOW_ASC_in_ordercolumn521); 
                    stream_ASC.add(o);


                    }
                    break;
                case 2 :
                    // Windowing.g:117:14: o= DESC
                    {
                    o=(Token)input.LT(1);
                    match(input,DESC,FOLLOW_DESC_in_ordercolumn527); 
                    stream_DESC.add(o);


                    }
                    break;

            }


            // AST REWRITE
            // elements: ID, o
            // token labels: o
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_o=new RewriteRuleTokenStream(adaptor,"token o",o);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 117:23: -> ^( ORDERCOLUMN ID ( $o)? )
            {
                // Windowing.g:117:26: ^( ORDERCOLUMN ID ( $o)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(ORDERCOLUMN, "ORDERCOLUMN"), root_1);

                adaptor.addChild(root_1, stream_ID.next());
                // Windowing.g:117:43: ( $o)?
                if ( stream_o.hasNext() ) {
                    adaptor.addChild(root_1, stream_o.next());

                }
                stream_o.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:120:1: partitionby : PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) ;
    public final partitionby_return partitionby() throws RecognitionException {
        partitionby_return retval = new partitionby_return();
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
            // Windowing.g:120:13: ( PARTITION BY ID ( COMMA ID )* -> ^( PARTITION ( ID )+ ) )
            // Windowing.g:121:2: PARTITION BY ID ( COMMA ID )*
            {
            PARTITION35=(Token)input.LT(1);
            match(input,PARTITION,FOLLOW_PARTITION_in_partitionby552); 
            stream_PARTITION.add(PARTITION35);

            BY36=(Token)input.LT(1);
            match(input,BY,FOLLOW_BY_in_partitionby554); 
            stream_BY.add(BY36);

            ID37=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_partitionby556); 
            stream_ID.add(ID37);

            // Windowing.g:121:18: ( COMMA ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Windowing.g:121:19: COMMA ID
            	    {
            	    COMMA38=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_partitionby559); 
            	    stream_COMMA.add(COMMA38);

            	    ID39=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_partitionby561); 
            	    stream_ID.add(ID39);


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            // AST REWRITE
            // elements: PARTITION, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 121:30: -> ^( PARTITION ( ID )+ )
            {
                // Windowing.g:121:33: ^( PARTITION ( ID )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_PARTITION.next(), root_1);

                if ( !(stream_ID.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ID.hasNext() ) {
                    adaptor.addChild(root_1, stream_ID.next());

                }
                stream_ID.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class funclist_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start funclist
    // Windowing.g:124:1: funclist : function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) ;
    public final funclist_return funclist() throws RecognitionException {
        funclist_return retval = new funclist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA41=null;
        function_return function40 = null;

        function_return function42 = null;


        Object COMMA41_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
        try {
            // Windowing.g:124:10: ( function ( COMMA function )* -> ^( FUNCTIONS ( function )+ ) )
            // Windowing.g:125:2: function ( COMMA function )*
            {
            pushFollow(FOLLOW_function_in_funclist583);
            function40=function();
            _fsp--;

            stream_function.add(function40.getTree());
            // Windowing.g:125:11: ( COMMA function )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Windowing.g:125:12: COMMA function
            	    {
            	    COMMA41=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_funclist586); 
            	    stream_COMMA.add(COMMA41);

            	    pushFollow(FOLLOW_function_in_funclist588);
            	    function42=function();
            	    _fsp--;

            	    stream_function.add(function42.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            // AST REWRITE
            // elements: function
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 125:29: -> ^( FUNCTIONS ( function )+ )
            {
                // Windowing.g:125:32: ^( FUNCTIONS ( function )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTIONS, "FUNCTIONS"), root_1);

                if ( !(stream_function.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_function.hasNext() ) {
                    adaptor.addChild(root_1, stream_function.next());

                }
                stream_function.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end funclist

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start function
    // Windowing.g:128:1: function : name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) ;
    public final function_return function() throws RecognitionException {
        function_return retval = new function_return();
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
        functionparam_return functionparam44 = null;

        functionparam_return functionparam46 = null;

        window_expression_return window_expression48 = null;


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
            // Windowing.g:128:10: (name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )? -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? ) )
            // Windowing.g:129:2: name= ID LPAREN ( functionparam )? ( COMMA functionparam )* RPAREN ( window_expression )? AS alias= ID ( LBRACKET typeNm= ID RBRACKET )?
            {
            name=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_function612); 
            stream_ID.add(name);

            LPAREN43=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_function614); 
            stream_LPAREN.add(LPAREN43);

            // Windowing.g:129:17: ( functionparam )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ID||(LA16_0>=GROOVYEXPRESSION && LA16_0<=STRING)||LA16_0==NUMBER) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Windowing.g:129:18: functionparam
                    {
                    pushFollow(FOLLOW_functionparam_in_function617);
                    functionparam44=functionparam();
                    _fsp--;

                    stream_functionparam.add(functionparam44.getTree());

                    }
                    break;

            }

            // Windowing.g:129:34: ( COMMA functionparam )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Windowing.g:129:35: COMMA functionparam
            	    {
            	    COMMA45=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_function622); 
            	    stream_COMMA.add(COMMA45);

            	    pushFollow(FOLLOW_functionparam_in_function624);
            	    functionparam46=functionparam();
            	    _fsp--;

            	    stream_functionparam.add(functionparam46.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            RPAREN47=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_function628); 
            stream_RPAREN.add(RPAREN47);

            // Windowing.g:129:64: ( window_expression )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==OVER) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Windowing.g:129:65: window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function631);
                    window_expression48=window_expression();
                    _fsp--;

                    stream_window_expression.add(window_expression48.getTree());

                    }
                    break;

            }

            AS49=(Token)input.LT(1);
            match(input,AS,FOLLOW_AS_in_function635); 
            stream_AS.add(AS49);

            alias=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_function639); 
            stream_ID.add(alias);

            // Windowing.g:129:97: ( LBRACKET typeNm= ID RBRACKET )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LBRACKET) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Windowing.g:129:98: LBRACKET typeNm= ID RBRACKET
                    {
                    LBRACKET50=(Token)input.LT(1);
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_function642); 
                    stream_LBRACKET.add(LBRACKET50);

                    typeNm=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_function646); 
                    stream_ID.add(typeNm);

                    RBRACKET51=(Token)input.LT(1);
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_function648); 
                    stream_RBRACKET.add(RBRACKET51);


                    }
                    break;

            }


            // AST REWRITE
            // elements: typeNm, alias, name, window_expression, functionparam
            // token labels: typeNm, alias, name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_typeNm=new RewriteRuleTokenStream(adaptor,"token typeNm",typeNm);
            RewriteRuleTokenStream stream_alias=new RewriteRuleTokenStream(adaptor,"token alias",alias);
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 129:128: -> ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
            {
                // Windowing.g:130:7: ^( FUNCTION $name $alias ( functionparam )* ( ^( TYPENAME $typeNm) )? ( window_expression )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.next());
                adaptor.addChild(root_1, stream_alias.next());
                // Windowing.g:130:31: ( functionparam )*
                while ( stream_functionparam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionparam.next());

                }
                stream_functionparam.reset();
                // Windowing.g:130:46: ( ^( TYPENAME $typeNm) )?
                if ( stream_typeNm.hasNext() ) {
                    // Windowing.g:130:46: ^( TYPENAME $typeNm)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(adaptor.create(TYPENAME, "TYPENAME"), root_2);

                    adaptor.addChild(root_2, stream_typeNm.next());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_typeNm.reset();
                // Windowing.g:130:67: ( window_expression )?
                if ( stream_window_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_window_expression.next());

                }
                stream_window_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class functionparam_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start functionparam
    // Windowing.g:133:1: functionparam : ( GROOVYEXPRESSION | STRING | ID | NUMBER );
    public final functionparam_return functionparam() throws RecognitionException {
        functionparam_return retval = new functionparam_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set52=null;

        Object set52_tree=null;

        try {
            // Windowing.g:133:16: ( GROOVYEXPRESSION | STRING | ID | NUMBER )
            // Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set52=(Token)input.LT(1);
            if ( input.LA(1)==ID||(input.LA(1)>=GROOVYEXPRESSION && input.LA(1)<=STRING)||input.LA(1)==NUMBER ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set52));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_functionparam0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end functionparam

    public static class window_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_expression
    // Windowing.g:137:1: window_expression : OVER ( window_range_expression | window_value_expression ) ;
    public final window_expression_return window_expression() throws RecognitionException {
        window_expression_return retval = new window_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OVER53=null;
        window_range_expression_return window_range_expression54 = null;

        window_value_expression_return window_value_expression55 = null;


        Object OVER53_tree=null;

        try {
            // Windowing.g:137:19: ( OVER ( window_range_expression | window_value_expression ) )
            // Windowing.g:138:2: OVER ( window_range_expression | window_value_expression )
            {
            root_0 = (Object)adaptor.nil();

            OVER53=(Token)input.LT(1);
            match(input,OVER,FOLLOW_OVER_in_window_expression717); 
            // Windowing.g:139:2: ( window_range_expression | window_value_expression )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==ROWS) ) {
                alt20=1;
            }
            else if ( (LA20_0==RANGE) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("139:2: ( window_range_expression | window_value_expression )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // Windowing.g:139:3: window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression723);
                    window_range_expression54=window_range_expression();
                    _fsp--;

                    adaptor.addChild(root_0, window_range_expression54.getTree());

                    }
                    break;
                case 2 :
                    // Windowing.g:140:2: window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression728);
                    window_value_expression55=window_value_expression();
                    _fsp--;

                    adaptor.addChild(root_0, window_value_expression55.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end window_expression

    public static class window_range_expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start window_range_expression
    // Windowing.g:144:1: window_range_expression : ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) ;
    public final window_range_expression_return window_range_expression() throws RecognitionException {
        window_range_expression_return retval = new window_range_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ROWS56=null;
        Token BETWEEN57=null;
        Token AND58=null;
        rowsboundary_return s = null;

        rowsboundary_return e = null;


        Object ROWS56_tree=null;
        Object BETWEEN57_tree=null;
        Object AND58_tree=null;
        RewriteRuleTokenStream stream_ROWS=new RewriteRuleTokenStream(adaptor,"token ROWS");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_rowsboundary=new RewriteRuleSubtreeStream(adaptor,"rule rowsboundary");
        try {
            // Windowing.g:144:25: ( ROWS BETWEEN s= rowsboundary AND e= rowsboundary -> ^( WINDOWRANGE $s $e) )
            // Windowing.g:145:2: ROWS BETWEEN s= rowsboundary AND e= rowsboundary
            {
            ROWS56=(Token)input.LT(1);
            match(input,ROWS,FOLLOW_ROWS_in_window_range_expression742); 
            stream_ROWS.add(ROWS56);

            BETWEEN57=(Token)input.LT(1);
            match(input,BETWEEN,FOLLOW_BETWEEN_in_window_range_expression744); 
            stream_BETWEEN.add(BETWEEN57);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression748);
            s=rowsboundary();
            _fsp--;

            stream_rowsboundary.add(s.getTree());
            AND58=(Token)input.LT(1);
            match(input,AND,FOLLOW_AND_in_window_range_expression750); 
            stream_AND.add(AND58);

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression754);
            e=rowsboundary();
            _fsp--;

            stream_rowsboundary.add(e.getTree());

            // AST REWRITE
            // elements: s, e
            // token labels: 
            // rule labels: retval, e, s
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",e!=null?e.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);

            root_0 = (Object)adaptor.nil();
            // 145:49: -> ^( WINDOWRANGE $s $e)
            {
                // Windowing.g:145:52: ^( WINDOWRANGE $s $e)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WINDOWRANGE, "WINDOWRANGE"), root_1);

                adaptor.addChild(root_1, stream_s.next());
                adaptor.addChild(root_1, stream_e.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:148:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );
    public final rowsboundary_return rowsboundary() throws RecognitionException {
        rowsboundary_return retval = new rowsboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED59=null;
        Token CURRENT60=null;
        Token ROW61=null;
        Token NUMBER62=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED59_tree=null;
        Object CURRENT60_tree=null;
        Object ROW61_tree=null;
        Object NUMBER62_tree=null;
        RewriteRuleTokenStream stream_ROW=new RewriteRuleTokenStream(adaptor,"token ROW");
        RewriteRuleTokenStream stream_FOLLOWING=new RewriteRuleTokenStream(adaptor,"token FOLLOWING");
        RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
        RewriteRuleTokenStream stream_CURRENT=new RewriteRuleTokenStream(adaptor,"token CURRENT");
        RewriteRuleTokenStream stream_PRECEDING=new RewriteRuleTokenStream(adaptor,"token PRECEDING");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");

        try {
            // Windowing.g:148:14: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) )
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
            case NUMBER:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("148:1: rowsboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | NUMBER (d= PRECEDING | d= FOLLOWING ) -> ^( $d NUMBER ) );", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // Windowing.g:149:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED59=(Token)input.LT(1);
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary777); 
                    stream_UNBOUNDED.add(UNBOUNDED59);

                    // Windowing.g:149:13: (r= PRECEDING | r= FOLLOWING )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==PRECEDING) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==FOLLOWING) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("149:13: (r= PRECEDING | r= FOLLOWING )", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // Windowing.g:149:14: r= PRECEDING
                            {
                            r=(Token)input.LT(1);
                            match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary782); 
                            stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // Windowing.g:149:26: r= FOLLOWING
                            {
                            r=(Token)input.LT(1);
                            match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary786); 
                            stream_FOLLOWING.add(r);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: r, UNBOUNDED
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 149:40: -> ^( $r UNBOUNDED )
                    {
                        // Windowing.g:149:43: ^( $r UNBOUNDED )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_r.next(), root_1);

                        adaptor.addChild(root_1, stream_UNBOUNDED.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // Windowing.g:150:3: CURRENT ROW
                    {
                    CURRENT60=(Token)input.LT(1);
                    match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary804); 
                    stream_CURRENT.add(CURRENT60);

                    ROW61=(Token)input.LT(1);
                    match(input,ROW,FOLLOW_ROW_in_rowsboundary806); 
                    stream_ROW.add(ROW61);


                    // AST REWRITE
                    // elements: CURRENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 150:16: -> ^( CURRENT )
                    {
                        // Windowing.g:150:19: ^( CURRENT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CURRENT.next(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 3 :
                    // Windowing.g:151:3: NUMBER (d= PRECEDING | d= FOLLOWING )
                    {
                    NUMBER62=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary819); 
                    stream_NUMBER.add(NUMBER62);

                    // Windowing.g:151:10: (d= PRECEDING | d= FOLLOWING )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==PRECEDING) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==FOLLOWING) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("151:10: (d= PRECEDING | d= FOLLOWING )", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // Windowing.g:151:11: d= PRECEDING
                            {
                            d=(Token)input.LT(1);
                            match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary824); 
                            stream_PRECEDING.add(d);


                            }
                            break;
                        case 2 :
                            // Windowing.g:151:25: d= FOLLOWING
                            {
                            d=(Token)input.LT(1);
                            match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary830); 
                            stream_FOLLOWING.add(d);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: NUMBER, d
                    // token labels: d
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 151:39: -> ^( $d NUMBER )
                    {
                        // Windowing.g:151:42: ^( $d NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_d.next(), root_1);

                        adaptor.addChild(root_1, stream_NUMBER.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:154:1: window_value_expression : RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) ;
    public final window_value_expression_return window_value_expression() throws RecognitionException {
        window_value_expression_return retval = new window_value_expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RANGE63=null;
        Token BETWEEN64=null;
        Token AND65=null;
        valuesboundary_return s = null;

        valuesboundary_return e = null;


        Object RANGE63_tree=null;
        Object BETWEEN64_tree=null;
        Object AND65_tree=null;
        RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_BETWEEN=new RewriteRuleTokenStream(adaptor,"token BETWEEN");
        RewriteRuleSubtreeStream stream_valuesboundary=new RewriteRuleSubtreeStream(adaptor,"rule valuesboundary");
        try {
            // Windowing.g:154:25: ( RANGE BETWEEN s= valuesboundary AND e= valuesboundary -> ^( WINDOWVALUES $s $e) )
            // Windowing.g:155:2: RANGE BETWEEN s= valuesboundary AND e= valuesboundary
            {
            RANGE63=(Token)input.LT(1);
            match(input,RANGE,FOLLOW_RANGE_in_window_value_expression851); 
            stream_RANGE.add(RANGE63);

            BETWEEN64=(Token)input.LT(1);
            match(input,BETWEEN,FOLLOW_BETWEEN_in_window_value_expression853); 
            stream_BETWEEN.add(BETWEEN64);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression857);
            s=valuesboundary();
            _fsp--;

            stream_valuesboundary.add(s.getTree());
            AND65=(Token)input.LT(1);
            match(input,AND,FOLLOW_AND_in_window_value_expression859); 
            stream_AND.add(AND65);

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression863);
            e=valuesboundary();
            _fsp--;

            stream_valuesboundary.add(e.getTree());

            // AST REWRITE
            // elements: e, s
            // token labels: 
            // rule labels: retval, e, s
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",e!=null?e.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);

            root_0 = (Object)adaptor.nil();
            // 155:54: -> ^( WINDOWVALUES $s $e)
            {
                // Windowing.g:155:57: ^( WINDOWVALUES $s $e)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(WINDOWVALUES, "WINDOWVALUES"), root_1);

                adaptor.addChild(root_1, stream_s.next());
                adaptor.addChild(root_1, stream_e.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:158:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );
    public final valuesboundary_return valuesboundary() throws RecognitionException {
        valuesboundary_return retval = new valuesboundary_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token d=null;
        Token UNBOUNDED66=null;
        Token CURRENT67=null;
        Token ROW68=null;
        Token GROOVYEXPRESSION69=null;
        Token NUMBER70=null;

        Object r_tree=null;
        Object d_tree=null;
        Object UNBOUNDED66_tree=null;
        Object CURRENT67_tree=null;
        Object ROW68_tree=null;
        Object GROOVYEXPRESSION69_tree=null;
        Object NUMBER70_tree=null;
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
            // Windowing.g:158:16: ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case UNBOUNDED:
                {
                alt26=1;
                }
                break;
            case CURRENT:
                {
                alt26=2;
                }
                break;
            case GROOVYEXPRESSION:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("158:1: valuesboundary : ( UNBOUNDED (r= PRECEDING | r= FOLLOWING ) -> ^( $r UNBOUNDED ) | CURRENT ROW -> ^( CURRENT ) | GROOVYEXPRESSION NUMBER (d= LESS | d= MORE ) -> ^( $d GROOVYEXPRESSION NUMBER ) );", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // Windowing.g:159:3: UNBOUNDED (r= PRECEDING | r= FOLLOWING )
                    {
                    UNBOUNDED66=(Token)input.LT(1);
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary886); 
                    stream_UNBOUNDED.add(UNBOUNDED66);

                    // Windowing.g:159:13: (r= PRECEDING | r= FOLLOWING )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==PRECEDING) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==FOLLOWING) ) {
                        alt24=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("159:13: (r= PRECEDING | r= FOLLOWING )", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // Windowing.g:159:14: r= PRECEDING
                            {
                            r=(Token)input.LT(1);
                            match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary891); 
                            stream_PRECEDING.add(r);


                            }
                            break;
                        case 2 :
                            // Windowing.g:159:26: r= FOLLOWING
                            {
                            r=(Token)input.LT(1);
                            match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary895); 
                            stream_FOLLOWING.add(r);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: UNBOUNDED, r
                    // token labels: r
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_r=new RewriteRuleTokenStream(adaptor,"token r",r);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 159:40: -> ^( $r UNBOUNDED )
                    {
                        // Windowing.g:159:43: ^( $r UNBOUNDED )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_r.next(), root_1);

                        adaptor.addChild(root_1, stream_UNBOUNDED.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // Windowing.g:160:3: CURRENT ROW
                    {
                    CURRENT67=(Token)input.LT(1);
                    match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary913); 
                    stream_CURRENT.add(CURRENT67);

                    ROW68=(Token)input.LT(1);
                    match(input,ROW,FOLLOW_ROW_in_valuesboundary915); 
                    stream_ROW.add(ROW68);


                    // AST REWRITE
                    // elements: CURRENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 160:16: -> ^( CURRENT )
                    {
                        // Windowing.g:160:19: ^( CURRENT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CURRENT.next(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 3 :
                    // Windowing.g:161:3: GROOVYEXPRESSION NUMBER (d= LESS | d= MORE )
                    {
                    GROOVYEXPRESSION69=(Token)input.LT(1);
                    match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary928); 
                    stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION69);

                    NUMBER70=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary930); 
                    stream_NUMBER.add(NUMBER70);

                    // Windowing.g:161:27: (d= LESS | d= MORE )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==LESS) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==MORE) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("161:27: (d= LESS | d= MORE )", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // Windowing.g:161:28: d= LESS
                            {
                            d=(Token)input.LT(1);
                            match(input,LESS,FOLLOW_LESS_in_valuesboundary935); 
                            stream_LESS.add(d);


                            }
                            break;
                        case 2 :
                            // Windowing.g:161:37: d= MORE
                            {
                            d=(Token)input.LT(1);
                            match(input,MORE,FOLLOW_MORE_in_valuesboundary941); 
                            stream_MORE.add(d);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: GROOVYEXPRESSION, d, NUMBER
                    // token labels: d
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_d=new RewriteRuleTokenStream(adaptor,"token d",d);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 161:46: -> ^( $d GROOVYEXPRESSION NUMBER )
                    {
                        // Windowing.g:161:49: ^( $d GROOVYEXPRESSION NUMBER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_d.next(), root_1);

                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.next());
                        adaptor.addChild(root_1, stream_NUMBER.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class select_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start select
    // Windowing.g:164:1: select : SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) ;
    public final select_return select() throws RecognitionException {
        select_return retval = new select_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT71=null;
        Token COMMA73=null;
        selectColumn_return selectColumn72 = null;

        selectColumn_return selectColumn74 = null;


        Object SELECT71_tree=null;
        Object COMMA73_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
        RewriteRuleSubtreeStream stream_selectColumn=new RewriteRuleSubtreeStream(adaptor,"rule selectColumn");
        try {
            // Windowing.g:164:9: ( SELECT selectColumn ( COMMA selectColumn )* -> ^( SELECT ( selectColumn )+ ) )
            // Windowing.g:165:3: SELECT selectColumn ( COMMA selectColumn )*
            {
            SELECT71=(Token)input.LT(1);
            match(input,SELECT,FOLLOW_SELECT_in_select966); 
            stream_SELECT.add(SELECT71);

            pushFollow(FOLLOW_selectColumn_in_select968);
            selectColumn72=selectColumn();
            _fsp--;

            stream_selectColumn.add(selectColumn72.getTree());
            // Windowing.g:165:23: ( COMMA selectColumn )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==COMMA) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Windowing.g:165:24: COMMA selectColumn
            	    {
            	    COMMA73=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_select971); 
            	    stream_COMMA.add(COMMA73);

            	    pushFollow(FOLLOW_selectColumn_in_select973);
            	    selectColumn74=selectColumn();
            	    _fsp--;

            	    stream_selectColumn.add(selectColumn74.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            // AST REWRITE
            // elements: selectColumn, SELECT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 165:46: -> ^( SELECT ( selectColumn )+ )
            {
                // Windowing.g:165:49: ^( SELECT ( selectColumn )+ )
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

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:168:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= typeName RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );
    public final selectColumn_return selectColumn() throws RecognitionException {
        selectColumn_return retval = new selectColumn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token GROOVYEXPRESSION75=null;
        Token AS76=null;
        Token ID77=null;
        Token LBRACKET78=null;
        Token RBRACKET79=null;
        Token ID80=null;
        typeName_return typeNm = null;


        Object GROOVYEXPRESSION75_tree=null;
        Object AS76_tree=null;
        Object ID77_tree=null;
        Object LBRACKET78_tree=null;
        Object RBRACKET79_tree=null;
        Object ID80_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");
        RewriteRuleSubtreeStream stream_typeName=new RewriteRuleSubtreeStream(adaptor,"rule typeName");
        try {
            // Windowing.g:168:13: ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= typeName RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==GROOVYEXPRESSION) ) {
                alt29=1;
            }
            else if ( (LA29_0==ID) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("168:1: selectColumn : ( GROOVYEXPRESSION AS ID ( LBRACKET typeNm= typeName RBRACKET )? -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? ) | ID -> ^( SELECTCOLUMN ID ) );", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // Windowing.g:169:3: GROOVYEXPRESSION AS ID ( LBRACKET typeNm= typeName RBRACKET )?
                    {
                    GROOVYEXPRESSION75=(Token)input.LT(1);
                    match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn995); 
                    stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION75);

                    AS76=(Token)input.LT(1);
                    match(input,AS,FOLLOW_AS_in_selectColumn997); 
                    stream_AS.add(AS76);

                    ID77=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_selectColumn999); 
                    stream_ID.add(ID77);

                    // Windowing.g:169:26: ( LBRACKET typeNm= typeName RBRACKET )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==LBRACKET) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // Windowing.g:169:27: LBRACKET typeNm= typeName RBRACKET
                            {
                            LBRACKET78=(Token)input.LT(1);
                            match(input,LBRACKET,FOLLOW_LBRACKET_in_selectColumn1002); 
                            stream_LBRACKET.add(LBRACKET78);

                            pushFollow(FOLLOW_typeName_in_selectColumn1006);
                            typeNm=typeName();
                            _fsp--;

                            stream_typeName.add(typeNm.getTree());
                            RBRACKET79=(Token)input.LT(1);
                            match(input,RBRACKET,FOLLOW_RBRACKET_in_selectColumn1008); 
                            stream_RBRACKET.add(RBRACKET79);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: typeNm, GROOVYEXPRESSION, ID
                    // token labels: 
                    // rule labels: typeNm, retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_typeNm=new RewriteRuleSubtreeStream(adaptor,"token typeNm",typeNm!=null?typeNm.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 169:63: -> ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                    {
                        // Windowing.g:169:66: ^( SELECTCOLUMN ID GROOVYEXPRESSION ( ^( TYPENAME $typeNm) )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.next());
                        adaptor.addChild(root_1, stream_GROOVYEXPRESSION.next());
                        // Windowing.g:169:101: ( ^( TYPENAME $typeNm) )?
                        if ( stream_typeNm.hasNext() ) {
                            // Windowing.g:169:101: ^( TYPENAME $typeNm)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(adaptor.create(TYPENAME, "TYPENAME"), root_2);

                            adaptor.addChild(root_2, stream_typeNm.next());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_typeNm.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // Windowing.g:170:3: ID
                    {
                    ID80=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_selectColumn1034); 
                    stream_ID.add(ID80);


                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 170:6: -> ^( SELECTCOLUMN ID )
                    {
                        // Windowing.g:170:9: ^( SELECTCOLUMN ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(adaptor.create(SELECTCOLUMN, "SELECTCOLUMN"), root_1);

                        adaptor.addChild(root_1, stream_ID.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class typeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typeName
    // Windowing.g:173:1: typeName : ( ID | STRING );
    public final typeName_return typeName() throws RecognitionException {
        typeName_return retval = new typeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set81=null;

        Object set81_tree=null;

        try {
            // Windowing.g:173:9: ( ID | STRING )
            // Windowing.g:
            {
            root_0 = (Object)adaptor.nil();

            set81=(Token)input.LT(1);
            if ( input.LA(1)==ID||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set81));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_typeName0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end typeName

    public static class where_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start where
    // Windowing.g:177:1: where : ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) ;
    public final where_return where() throws RecognitionException {
        where_return retval = new where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHERE82=null;
        Token GROOVYEXPRESSION83=null;

        Object WHERE82_tree=null;
        Object GROOVYEXPRESSION83_tree=null;
        RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
        RewriteRuleTokenStream stream_GROOVYEXPRESSION=new RewriteRuleTokenStream(adaptor,"token GROOVYEXPRESSION");

        try {
            // Windowing.g:177:7: ( ( WHERE GROOVYEXPRESSION ) -> ^( WHERE GROOVYEXPRESSION ) )
            // Windowing.g:178:2: ( WHERE GROOVYEXPRESSION )
            {
            // Windowing.g:178:2: ( WHERE GROOVYEXPRESSION )
            // Windowing.g:178:3: WHERE GROOVYEXPRESSION
            {
            WHERE82=(Token)input.LT(1);
            match(input,WHERE,FOLLOW_WHERE_in_where1068); 
            stream_WHERE.add(WHERE82);

            GROOVYEXPRESSION83=(Token)input.LT(1);
            match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where1070); 
            stream_GROOVYEXPRESSION.add(GROOVYEXPRESSION83);


            }


            // AST REWRITE
            // elements: WHERE, GROOVYEXPRESSION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 178:27: -> ^( WHERE GROOVYEXPRESSION )
            {
                // Windowing.g:178:30: ^( WHERE GROOVYEXPRESSION )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_WHERE.next(), root_1);

                adaptor.addChild(root_1, stream_GROOVYEXPRESSION.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:181:1: outputClause : INTO PATH EQ p= STRING (s= outputSerDe )? (lc= loadClause )? -> ^( OUTPUTSPEC $p ( $s)? ( $lc)? ) ;
    public final outputClause_return outputClause() throws RecognitionException {
        outputClause_return retval = new outputClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token p=null;
        Token INTO84=null;
        Token PATH85=null;
        Token EQ86=null;
        outputSerDe_return s = null;

        loadClause_return lc = null;


        Object p_tree=null;
        Object INTO84_tree=null;
        Object PATH85_tree=null;
        Object EQ86_tree=null;
        RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
        RewriteRuleTokenStream stream_PATH=new RewriteRuleTokenStream(adaptor,"token PATH");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_loadClause=new RewriteRuleSubtreeStream(adaptor,"rule loadClause");
        RewriteRuleSubtreeStream stream_outputSerDe=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDe");
        try {
            // Windowing.g:181:14: ( INTO PATH EQ p= STRING (s= outputSerDe )? (lc= loadClause )? -> ^( OUTPUTSPEC $p ( $s)? ( $lc)? ) )
            // Windowing.g:182:2: INTO PATH EQ p= STRING (s= outputSerDe )? (lc= loadClause )?
            {
            INTO84=(Token)input.LT(1);
            match(input,INTO,FOLLOW_INTO_in_outputClause1089); 
            stream_INTO.add(INTO84);

            PATH85=(Token)input.LT(1);
            match(input,PATH,FOLLOW_PATH_in_outputClause1091); 
            stream_PATH.add(PATH85);

            EQ86=(Token)input.LT(1);
            match(input,EQ,FOLLOW_EQ_in_outputClause1093); 
            stream_EQ.add(EQ86);

            p=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_outputClause1097); 
            stream_STRING.add(p);

            // Windowing.g:182:25: (s= outputSerDe )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==SERDE) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // Windowing.g:182:25: s= outputSerDe
                    {
                    pushFollow(FOLLOW_outputSerDe_in_outputClause1101);
                    s=outputSerDe();
                    _fsp--;

                    stream_outputSerDe.add(s.getTree());

                    }
                    break;

            }

            // Windowing.g:182:41: (lc= loadClause )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==LOAD) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // Windowing.g:182:41: lc= loadClause
                    {
                    pushFollow(FOLLOW_loadClause_in_outputClause1106);
                    lc=loadClause();
                    _fsp--;

                    stream_loadClause.add(lc.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: s, lc, p
            // token labels: p
            // rule labels: retval, s, lc
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_p=new RewriteRuleTokenStream(adaptor,"token p",p);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"token s",s!=null?s.tree:null);
            RewriteRuleSubtreeStream stream_lc=new RewriteRuleSubtreeStream(adaptor,"token lc",lc!=null?lc.tree:null);

            root_0 = (Object)adaptor.nil();
            // 182:54: -> ^( OUTPUTSPEC $p ( $s)? ( $lc)? )
            {
                // Windowing.g:182:57: ^( OUTPUTSPEC $p ( $s)? ( $lc)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(OUTPUTSPEC, "OUTPUTSPEC"), root_1);

                adaptor.addChild(root_1, stream_p.next());
                // Windowing.g:182:73: ( $s)?
                if ( stream_s.hasNext() ) {
                    adaptor.addChild(root_1, stream_s.next());

                }
                stream_s.reset();
                // Windowing.g:182:77: ( $lc)?
                if ( stream_lc.hasNext() ) {
                    adaptor.addChild(root_1, stream_lc.next());

                }
                stream_lc.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:185:1: outputSerDe : SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) ;
    public final outputSerDe_return outputSerDe() throws RecognitionException {
        outputSerDe_return retval = new outputSerDe_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token SERDE87=null;
        outputSerDePropeties_return p = null;

        outputFormatOrWriter_return o = null;


        Object s_tree=null;
        Object SERDE87_tree=null;
        RewriteRuleTokenStream stream_SERDE=new RewriteRuleTokenStream(adaptor,"token SERDE");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_outputFormatOrWriter=new RewriteRuleSubtreeStream(adaptor,"rule outputFormatOrWriter");
        RewriteRuleSubtreeStream stream_outputSerDePropeties=new RewriteRuleSubtreeStream(adaptor,"rule outputSerDePropeties");
        try {
            // Windowing.g:185:13: ( SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter -> ^( SERDE $s $o ( $p)? ) )
            // Windowing.g:186:3: SERDE s= STRING (p= outputSerDePropeties )? o= outputFormatOrWriter
            {
            SERDE87=(Token)input.LT(1);
            match(input,SERDE,FOLLOW_SERDE_in_outputSerDe1135); 
            stream_SERDE.add(SERDE87);

            s=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_outputSerDe1139); 
            stream_STRING.add(s);

            // Windowing.g:186:19: (p= outputSerDePropeties )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==WITH) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Windowing.g:186:19: p= outputSerDePropeties
                    {
                    pushFollow(FOLLOW_outputSerDePropeties_in_outputSerDe1143);
                    p=outputSerDePropeties();
                    _fsp--;

                    stream_outputSerDePropeties.add(p.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe1148);
            o=outputFormatOrWriter();
            _fsp--;

            stream_outputFormatOrWriter.add(o.getTree());

            // AST REWRITE
            // elements: s, p, o, SERDE
            // token labels: s
            // rule labels: retval, p, o
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"token p",p!=null?p.tree:null);
            RewriteRuleSubtreeStream stream_o=new RewriteRuleSubtreeStream(adaptor,"token o",o!=null?o.tree:null);

            root_0 = (Object)adaptor.nil();
            // 186:65: -> ^( SERDE $s $o ( $p)? )
            {
                // Windowing.g:186:68: ^( SERDE $s $o ( $p)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDE.next(), root_1);

                adaptor.addChild(root_1, stream_s.next());
                adaptor.addChild(root_1, stream_o.next());
                // Windowing.g:186:82: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.next());

                }
                stream_p.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:189:1: outputSerDePropeties : WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) ;
    public final outputSerDePropeties_return outputSerDePropeties() throws RecognitionException {
        outputSerDePropeties_return retval = new outputSerDePropeties_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WITH88=null;
        Token SERDEPROPERTIES89=null;
        Token LPAREN90=null;
        Token COMMA92=null;
        Token RPAREN94=null;
        namevalue_return namevalue91 = null;

        namevalue_return namevalue93 = null;


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
            // Windowing.g:189:21: ( WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN -> ^( SERDEPROPERTIES ( namevalue )* ) )
            // Windowing.g:190:3: WITH SERDEPROPERTIES LPAREN ( namevalue )? ( COMMA namevalue )* RPAREN
            {
            WITH88=(Token)input.LT(1);
            match(input,WITH,FOLLOW_WITH_in_outputSerDePropeties1174); 
            stream_WITH.add(WITH88);

            SERDEPROPERTIES89=(Token)input.LT(1);
            match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1176); 
            stream_SERDEPROPERTIES.add(SERDEPROPERTIES89);

            LPAREN90=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_outputSerDePropeties1178); 
            stream_LPAREN.add(LPAREN90);

            // Windowing.g:190:31: ( namevalue )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==ID||LA33_0==STRING) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // Windowing.g:190:32: namevalue
                    {
                    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1181);
                    namevalue91=namevalue();
                    _fsp--;

                    stream_namevalue.add(namevalue91.getTree());

                    }
                    break;

            }

            // Windowing.g:190:44: ( COMMA namevalue )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==COMMA) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Windowing.g:190:45: COMMA namevalue
            	    {
            	    COMMA92=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_outputSerDePropeties1186); 
            	    stream_COMMA.add(COMMA92);

            	    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1188);
            	    namevalue93=namevalue();
            	    _fsp--;

            	    stream_namevalue.add(namevalue93.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            RPAREN94=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_outputSerDePropeties1192); 
            stream_RPAREN.add(RPAREN94);


            // AST REWRITE
            // elements: namevalue, SERDEPROPERTIES
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 191:6: -> ^( SERDEPROPERTIES ( namevalue )* )
            {
                // Windowing.g:191:9: ^( SERDEPROPERTIES ( namevalue )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SERDEPROPERTIES.next(), root_1);

                // Windowing.g:191:27: ( namevalue )*
                while ( stream_namevalue.hasNext() ) {
                    adaptor.addChild(root_1, stream_namevalue.next());

                }
                stream_namevalue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:194:1: outputFormatOrWriter : ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) );
    public final outputFormatOrWriter_return outputFormatOrWriter() throws RecognitionException {
        outputFormatOrWriter_return retval = new outputFormatOrWriter_return();
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
            // Windowing.g:194:22: ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RECORDWRITER) ) {
                alt35=1;
            }
            else if ( (LA35_0==FORMAT) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("194:1: outputFormatOrWriter : ( RECORDWRITER STRING -> ^( RECORDWRITER STRING ) | FORMAT STRING -> ^( FORMAT STRING ) );", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // Windowing.g:195:3: RECORDWRITER STRING
                    {
                    RECORDWRITER95=(Token)input.LT(1);
                    match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter1218); 
                    stream_RECORDWRITER.add(RECORDWRITER95);

                    STRING96=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1220); 
                    stream_STRING.add(STRING96);


                    // AST REWRITE
                    // elements: STRING, RECORDWRITER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 195:23: -> ^( RECORDWRITER STRING )
                    {
                        // Windowing.g:195:26: ^( RECORDWRITER STRING )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_RECORDWRITER.next(), root_1);

                        adaptor.addChild(root_1, stream_STRING.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // Windowing.g:196:3: FORMAT STRING
                    {
                    FORMAT97=(Token)input.LT(1);
                    match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter1234); 
                    stream_FORMAT.add(FORMAT97);

                    STRING98=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1236); 
                    stream_STRING.add(STRING98);


                    // AST REWRITE
                    // elements: STRING, FORMAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 196:17: -> ^( FORMAT STRING )
                    {
                        // Windowing.g:196:20: ^( FORMAT STRING )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_FORMAT.next(), root_1);

                        adaptor.addChild(root_1, stream_STRING.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Windowing.g:199:1: loadClause : LOAD (ov= OVERWRITE )? INTO TABLE t= ID ( PARTITION l= STRING )? -> ^( LOADSPEC $t ( $l)? ( $ov)? ) ;
    public final loadClause_return loadClause() throws RecognitionException {
        loadClause_return retval = new loadClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ov=null;
        Token t=null;
        Token l=null;
        Token LOAD99=null;
        Token INTO100=null;
        Token TABLE101=null;
        Token PARTITION102=null;

        Object ov_tree=null;
        Object t_tree=null;
        Object l_tree=null;
        Object LOAD99_tree=null;
        Object INTO100_tree=null;
        Object TABLE101_tree=null;
        Object PARTITION102_tree=null;
        RewriteRuleTokenStream stream_TABLE=new RewriteRuleTokenStream(adaptor,"token TABLE");
        RewriteRuleTokenStream stream_OVERWRITE=new RewriteRuleTokenStream(adaptor,"token OVERWRITE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_PARTITION=new RewriteRuleTokenStream(adaptor,"token PARTITION");
        RewriteRuleTokenStream stream_INTO=new RewriteRuleTokenStream(adaptor,"token INTO");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleTokenStream stream_LOAD=new RewriteRuleTokenStream(adaptor,"token LOAD");

        try {
            // Windowing.g:199:11: ( LOAD (ov= OVERWRITE )? INTO TABLE t= ID ( PARTITION l= STRING )? -> ^( LOADSPEC $t ( $l)? ( $ov)? ) )
            // Windowing.g:200:3: LOAD (ov= OVERWRITE )? INTO TABLE t= ID ( PARTITION l= STRING )?
            {
            LOAD99=(Token)input.LT(1);
            match(input,LOAD,FOLLOW_LOAD_in_loadClause1254); 
            stream_LOAD.add(LOAD99);

            // Windowing.g:200:10: (ov= OVERWRITE )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==OVERWRITE) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // Windowing.g:200:10: ov= OVERWRITE
                    {
                    ov=(Token)input.LT(1);
                    match(input,OVERWRITE,FOLLOW_OVERWRITE_in_loadClause1258); 
                    stream_OVERWRITE.add(ov);


                    }
                    break;

            }

            INTO100=(Token)input.LT(1);
            match(input,INTO,FOLLOW_INTO_in_loadClause1261); 
            stream_INTO.add(INTO100);

            TABLE101=(Token)input.LT(1);
            match(input,TABLE,FOLLOW_TABLE_in_loadClause1263); 
            stream_TABLE.add(TABLE101);

            t=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_loadClause1267); 
            stream_ID.add(t);

            // Windowing.g:200:38: ( PARTITION l= STRING )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==PARTITION) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // Windowing.g:200:39: PARTITION l= STRING
                    {
                    PARTITION102=(Token)input.LT(1);
                    match(input,PARTITION,FOLLOW_PARTITION_in_loadClause1270); 
                    stream_PARTITION.add(PARTITION102);

                    l=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_loadClause1274); 
                    stream_STRING.add(l);


                    }
                    break;

            }


            // AST REWRITE
            // elements: l, t, ov
            // token labels: ov, t, l
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_ov=new RewriteRuleTokenStream(adaptor,"token ov",ov);
            RewriteRuleTokenStream stream_t=new RewriteRuleTokenStream(adaptor,"token t",t);
            RewriteRuleTokenStream stream_l=new RewriteRuleTokenStream(adaptor,"token l",l);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 200:60: -> ^( LOADSPEC $t ( $l)? ( $ov)? )
            {
                // Windowing.g:200:63: ^( LOADSPEC $t ( $l)? ( $ov)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(LOADSPEC, "LOADSPEC"), root_1);

                adaptor.addChild(root_1, stream_t.next());
                // Windowing.g:200:77: ( $l)?
                if ( stream_l.hasNext() ) {
                    adaptor.addChild(root_1, stream_l.next());

                }
                stream_l.reset();
                // Windowing.g:200:81: ( $ov)?
                if ( stream_ov.hasNext() ) {
                    adaptor.addChild(root_1, stream_ov.next());

                }
                stream_ov.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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


 

    public static final BitSet FOLLOW_FROM_in_query143 = new BitSet(new long[]{0x0000000006600000L});
    public static final BitSet FOLLOW_tableSpec_in_query145 = new BitSet(new long[]{0x0004000000100000L});
    public static final BitSet FOLLOW_WITH_in_query149 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_funclist_in_query151 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_select_in_query156 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_where_in_query159 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_outputClause_in_query164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hdfsFile_in_tableSpec198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hiveTable_in_tableSpec203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hiveQuery_in_tableSpec208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tblfunc_in_tableSpec213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_tblfunc226 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_tblfunc228 = new BitSet(new long[]{0x0000000006600000L});
    public static final BitSet FOLLOW_tableSpec_in_tblfunc230 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_COMMA_in_tblfunc233 = new BitSet(new long[]{0x000000200C200000L});
    public static final BitSet FOLLOW_functionparam_in_tblfunc235 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_RPAREN_in_tblfunc239 = new BitSet(new long[]{0x0000004200000002L});
    public static final BitSet FOLLOW_partitionby_in_tblfunc244 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_tblfunc248 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_window_expression_in_tblfunc253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hdfsFile294 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_hdfsFile296 = new BitSet(new long[]{0x0000000009A00000L});
    public static final BitSet FOLLOW_namevalue_in_hdfsFile299 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_COMMA_in_hdfsFile304 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_namevalue_in_hdfsFile306 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_RPAREN_in_hdfsFile310 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_hdfsFile315 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_hdfsFile319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_hiveTable345 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_hiveTable349 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_hiveTable353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_hiveQuery381 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_hiveQuery385 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_hiveQuery389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_hiveQuery409 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_hiveQuery413 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_hiveQuery417 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_hiveQuery421 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_hiveQuery423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namevalue453 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue457 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EQ_in_namevalue460 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_orderby486 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_BY_in_orderby488 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby490 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_COMMA_in_orderby493 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby495 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ID_in_ordercolumn516 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby552 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_BY_in_partitionby554 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_partitionby556 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_COMMA_in_partitionby559 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_partitionby561 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_function_in_funclist583 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_COMMA_in_funclist586 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_function_in_funclist588 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ID_in_function612 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_function614 = new BitSet(new long[]{0x000000200DA00000L});
    public static final BitSet FOLLOW_functionparam_in_function617 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_COMMA_in_function622 = new BitSet(new long[]{0x000000200C200000L});
    public static final BitSet FOLLOW_functionparam_in_function624 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_RPAREN_in_function628 = new BitSet(new long[]{0x0000004400000000L});
    public static final BitSet FOLLOW_window_expression_in_function631 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_AS_in_function635 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_function639 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_LBRACKET_in_function642 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_function646 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_function648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionparam0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OVER_in_window_expression717 = new BitSet(new long[]{0x0000808000000000L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROWS_in_window_range_expression742 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_range_expression744 = new BitSet(new long[]{0x0000242000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression748 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_AND_in_window_range_expression750 = new BitSet(new long[]{0x0000242000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary777 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary804 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ROW_in_rowsboundary806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary819 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_window_value_expression851 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_BETWEEN_in_window_value_expression853 = new BitSet(new long[]{0x0000240004000000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression857 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_AND_in_window_value_expression859 = new BitSet(new long[]{0x0000240004000000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary886 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary913 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ROW_in_valuesboundary915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary928 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary930 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select966 = new BitSet(new long[]{0x0000000004200000L});
    public static final BitSet FOLLOW_selectColumn_in_select968 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_COMMA_in_select971 = new BitSet(new long[]{0x0000000004200000L});
    public static final BitSet FOLLOW_selectColumn_in_select973 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn995 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_AS_in_selectColumn997 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_selectColumn999 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selectColumn1002 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_typeName_in_selectColumn1006 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selectColumn1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selectColumn1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where1068 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_outputClause1089 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_PATH_in_outputClause1091 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_EQ_in_outputClause1093 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputClause1097 = new BitSet(new long[]{0x0440000000000002L});
    public static final BitSet FOLLOW_outputSerDe_in_outputClause1101 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_loadClause_in_outputClause1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERDE_in_outputSerDe1135 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputSerDe1139 = new BitSet(new long[]{0x0300000000100000L});
    public static final BitSet FOLLOW_outputSerDePropeties_in_outputSerDe1143 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_outputFormatOrWriter_in_outputSerDe1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_outputSerDePropeties1174 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1176 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_outputSerDePropeties1178 = new BitSet(new long[]{0x0000000009A00000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1181 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_COMMA_in_outputSerDePropeties1186 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1188 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_RPAREN_in_outputSerDePropeties1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORDWRITER_in_outputFormatOrWriter1218 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORMAT_in_outputFormatOrWriter1234 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_loadClause1254 = new BitSet(new long[]{0x0810000000000000L});
    public static final BitSet FOLLOW_OVERWRITE_in_loadClause1258 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_INTO_in_loadClause1261 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_TABLE_in_loadClause1263 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_loadClause1267 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_PARTITION_in_loadClause1270 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_loadClause1274 = new BitSet(new long[]{0x0000000000000002L});

}