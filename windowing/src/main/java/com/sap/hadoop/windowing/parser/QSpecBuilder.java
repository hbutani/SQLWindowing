// $ANTLR 3.0.1 QSpecBuilder.g 2012-04-09 15:32:15

package com.sap.hadoop.windowing.parser;

import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.SelectColumn;
import com.sap.hadoop.windowing.query.OrderColumn;
import com.sap.hadoop.windowing.query.Order;

import com.sap.hadoop.windowing.query.RangeBoundary;
import com.sap.hadoop.windowing.query.ValueBoundary;
import com.sap.hadoop.windowing.query.CurrentRow;
import com.sap.hadoop.windowing.query.Boundary;
import com.sap.hadoop.windowing.query.Window;
import com.sap.hadoop.windowing.query.Direction;

import com.sap.hadoop.windowing.query.TableFuncSpec;

import com.sap.hadoop.windowing.query.TableInput;
import com.sap.hadoop.windowing.query.TableOutput;

import com.sap.hadoop.windowing.query.FuncArg;
import com.sap.hadoop.windowing.query.FuncSpec;

import com.sap.hadoop.windowing.Constants;

import com.sap.hadoop.Utils;
import com.sap.hadoop.windowing.WindowingException;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QSpecBuilder extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMERIC", "INTEGER", "UMINUS", "PARAM", "ORDERCOLUMN", "FUNCTION", "FUNCTIONS", "QUERY", "WINDOWRANGE", "WINDOWVALUES", "TYPENAME", "SELECTCOLUMN", "OUTPUTSPEC", "TBLFUNCTION", "LOADSPEC", "FROM", "WITH", "ID", "LPAREN", "COMMA", "RPAREN", "TABLEINPUT", "GROOVYEXPRESSION", "STRING", "EQ", "ORDER", "BY", "ASC", "DESC", "PARTITION", "AS", "LBRACKET", "RBRACKET", "NUMBER", "OVER", "ROWS", "BETWEEN", "AND", "UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "ROW", "RANGE", "LESS", "MORE", "SELECT", "WHERE", "INTO", "PATH", "SERDE", "SERDEPROPERTIES", "RECORDWRITER", "FORMAT", "LOAD", "OVERWRITE", "TABLE", "QUOTE", "ASTERISK", "COLON", "SEMICOLON", "DOT", "GE", "GT", "LBRACE", "LE", "LT", "MINUS", "NE", "PLUS", "RBRACE", "SOLIDUS", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "B", "I", "N", "P", "U", "D", "Y", "G", "V", "NOT", "OR", "X", "XOR", "GroovyEscapeSequence", "EscapeSequence", "WS", "J", "K", "Q", "Z"
    };
    public static final int FUNCTION=9;
    public static final int LT=70;
    public static final int OVERWRITE=59;
    public static final int ORDERCOLUMN=8;
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
    public static final int E=77;
    public static final int TYPENAME=14;
    public static final int F=81;
    public static final int GE=66;
    public static final int G=95;
    public static final int A=87;
    public static final int B=88;
    public static final int RBRACE=74;
    public static final int C=79;
    public static final int ASC=31;
    public static final int L=78;
    public static final int M=84;
    public static final int WINDOWVALUES=13;
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
    public static final int RANGE=47;
    public static final int UMINUS=6;
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
    protected static class PartOrderScope_scope {
        ArrayList<String> partitionColumns;
        ArrayList<OrderColumn> orderColumns;
    }
    protected Stack PartOrderScope_stack = new Stack();


        public QSpecBuilder(TreeNodeStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "QSpecBuilder.g"; }


      protected QuerySpec qSpec = new QuerySpec();  
      boolean processingOutputSpec = false;
      
      public QuerySpec getQuerySpec() { return qSpec; }
      
      void setParameter(String name, String value)
      {
        if (!processingOutputSpec )
        {
    	    name = name.toLowerCase();
    	    TableInput tableInput = qSpec.getTableIn();
    	    
    	    if (name.equals(Constants.INPUT_PATH) )
              tableInput.setInputPath(value);
          else if (name.equals(Constants.INPUT_KEY_CLASS) )
            tableInput.setKeyClass(value);
          else if (name.equals(Constants.INPUT_VALUE_CLASS) )
            tableInput.setValueClass(value);
          else if (name.equals(Constants.INPUT_INPUTFORMAT_CLASS) )
            tableInput.setInputFormatClass(value);
          else if (name.equals(Constants.INPUT_SERDE_CLASS) )
            tableInput.setSerDeClass(value);
          else if (name.equals(Constants.INPUT_RECORD_READER_CLASS) )
            tableInput.setWindowingInputClass(value);
          else
            tableInput.getSerDeProps().setProperty(name, value);
        }
        else
        {
          TableOutput tableOutput = qSpec.getTableOut();
          tableOutput.getSerDeProps().setProperty(name, value);
        }
      }
      
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
    // QSpecBuilder.g:94:1: query : ^( QUERY tf= tableSpec select ( funclist )? ( where )? ( outputClause )? ) ;
    public final void query() throws RecognitionException {
        TableFuncSpec tf = null;


        try {
            // QSpecBuilder.g:94:7: ( ^( QUERY tf= tableSpec select ( funclist )? ( where )? ( outputClause )? ) )
            // QSpecBuilder.g:95:4: ^( QUERY tf= tableSpec select ( funclist )? ( where )? ( outputClause )? )
            {
            match(input,QUERY,FOLLOW_QUERY_in_query68); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_tableSpec_in_query72);
            tf=tableSpec();
            _fsp--;

            pushFollow(FOLLOW_select_in_query74);
            select();
            _fsp--;

            // QSpecBuilder.g:95:32: ( funclist )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==FUNCTIONS) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // QSpecBuilder.g:95:32: funclist
                    {
                    pushFollow(FOLLOW_funclist_in_query76);
                    funclist();
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder.g:95:42: ( where )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==WHERE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // QSpecBuilder.g:95:42: where
                    {
                    pushFollow(FOLLOW_where_in_query79);
                    where();
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder.g:95:49: ( outputClause )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==OUTPUTSPEC) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // QSpecBuilder.g:95:49: outputClause
                    {
                    pushFollow(FOLLOW_outputClause_in_query82);
                    outputClause();
                    _fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            qSpec.setTblFuncSpec(tf);

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


    // $ANTLR start tableSpec
    // QSpecBuilder.g:98:1: tableSpec returns [TableFuncSpec tf] : ( hdfsFile | hiveTable | hiveQuery | tf1= tblfunc );
    public final TableFuncSpec tableSpec() throws RecognitionException {
        PartOrderScope_stack.push(new PartOrderScope_scope());

        TableFuncSpec tf = null;

        TableFuncSpec tf1 = null;



          ((PartOrderScope_scope)PartOrderScope_stack.peek()).partitionColumns = qSpec.getTableIn().getPartitionColumns();
          ((PartOrderScope_scope)PartOrderScope_stack.peek()).orderColumns = qSpec.getTableIn().getOrderColumns();

        try {
            // QSpecBuilder.g:104:1: ( hdfsFile | hiveTable | hiveQuery | tf1= tblfunc )
            int alt4=4;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==TABLEINPUT) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case GROOVYEXPRESSION:
                        {
                        alt4=3;
                        }
                        break;
                    case ID:
                        {
                        alt4=2;
                        }
                        break;
                    case PARAM:
                    case PARTITION:
                        {
                        alt4=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("98:1: tableSpec returns [TableFuncSpec tf] : ( hdfsFile | hiveTable | hiveQuery | tf1= tblfunc );", 4, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("98:1: tableSpec returns [TableFuncSpec tf] : ( hdfsFile | hiveTable | hiveQuery | tf1= tblfunc );", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==TBLFUNCTION) ) {
                alt4=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("98:1: tableSpec returns [TableFuncSpec tf] : ( hdfsFile | hiveTable | hiveQuery | tf1= tblfunc );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // QSpecBuilder.g:105:2: hdfsFile
                    {
                    pushFollow(FOLLOW_hdfsFile_in_tableSpec110);
                    hdfsFile();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:106:2: hiveTable
                    {
                    pushFollow(FOLLOW_hiveTable_in_tableSpec115);
                    hiveTable();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // QSpecBuilder.g:107:2: hiveQuery
                    {
                    pushFollow(FOLLOW_hiveQuery_in_tableSpec120);
                    hiveQuery();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // QSpecBuilder.g:108:2: tf1= tblfunc
                    {
                    pushFollow(FOLLOW_tblfunc_in_tableSpec127);
                    tf1=tblfunc();
                    _fsp--;

                    tf = tf1; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            PartOrderScope_stack.pop();

        }
        return tf;
    }
    // $ANTLR end tableSpec


    // $ANTLR start tblfunc
    // QSpecBuilder.g:111:1: tblfunc returns [TableFuncSpec tf] : ^( TBLFUNCTION name= ID tf1= tableSpec (p= functionparam )* ( partitionby )? ( orderby )? (w= window_expression )? ) ;
    public final TableFuncSpec tblfunc() throws RecognitionException {
        PartOrderScope_stack.push(new PartOrderScope_scope());

        TableFuncSpec tf = null;

        CommonTree name=null;
        TableFuncSpec tf1 = null;

        FuncArg p = null;

        Window w = null;



          tf = new TableFuncSpec();
          ((PartOrderScope_scope)PartOrderScope_stack.peek()).partitionColumns = tf.getPartitionColumns();
          ((PartOrderScope_scope)PartOrderScope_stack.peek()).orderColumns = tf.getOrderColumns();

        try {
            // QSpecBuilder.g:127:1: ( ^( TBLFUNCTION name= ID tf1= tableSpec (p= functionparam )* ( partitionby )? ( orderby )? (w= window_expression )? ) )
            // QSpecBuilder.g:128:3: ^( TBLFUNCTION name= ID tf1= tableSpec (p= functionparam )* ( partitionby )? ( orderby )? (w= window_expression )? )
            {
            match(input,TBLFUNCTION,FOLLOW_TBLFUNCTION_in_tblfunc160); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_tblfunc170); 
            tf.setName(name.getText().toLowerCase());
            pushFollow(FOLLOW_tableSpec_in_tblfunc181);
            tf1=tableSpec();
            _fsp--;

            tf.setInputFuncSpec(tf1);
            // QSpecBuilder.g:131:6: (p= functionparam )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID||(LA5_0>=GROOVYEXPRESSION && LA5_0<=STRING)||LA5_0==NUMBER) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // QSpecBuilder.g:131:7: p= functionparam
            	    {
            	    pushFollow(FOLLOW_functionparam_in_tblfunc193);
            	    p=functionparam();
            	    _fsp--;

            	    tf.getParams().add(p);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // QSpecBuilder.g:132:6: ( partitionby )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==PARTITION) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // QSpecBuilder.g:132:6: partitionby
                    {
                    pushFollow(FOLLOW_partitionby_in_tblfunc206);
                    partitionby();
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder.g:132:19: ( orderby )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ORDER) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // QSpecBuilder.g:132:19: orderby
                    {
                    pushFollow(FOLLOW_orderby_in_tblfunc209);
                    orderby();
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder.g:133:6: (w= window_expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=WINDOWRANGE && LA8_0<=WINDOWVALUES)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // QSpecBuilder.g:133:7: w= window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_tblfunc221);
                    w=window_expression();
                    _fsp--;

                    tf.setWindow(w);

                    }
                    break;

            }


            match(input, Token.UP, null); 

            }


              if ( tf.getPartitionColumns().size() == 0 ) tf.setPartitionColumns(null); 
              if ( tf.getOrderColumns().size() == 0 ) tf.setOrderColumns(null); 
              
              if ( tf.getPartitionColumns() != null && tf.getInputFuncSpec() == null )
                {
                  throw new RuntimeException(Utils.sprintf("Function '" + tf.getName() + "' cannot have a partition clause, its input is a 'tableinput'"));
                }  

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            PartOrderScope_stack.pop();

        }
        return tf;
    }
    // $ANTLR end tblfunc


    // $ANTLR start hdfsFile
    // QSpecBuilder.g:137:1: hdfsFile : ^( TABLEINPUT ( namevalue )* partitionby orderby ) ;
    public final void hdfsFile() throws RecognitionException {
        try {
            // QSpecBuilder.g:137:10: ( ^( TABLEINPUT ( namevalue )* partitionby orderby ) )
            // QSpecBuilder.g:138:2: ^( TABLEINPUT ( namevalue )* partitionby orderby )
            {
            match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hdfsFile241); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder.g:138:15: ( namevalue )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==PARAM) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // QSpecBuilder.g:138:15: namevalue
            	    {
            	    pushFollow(FOLLOW_namevalue_in_hdfsFile243);
            	    namevalue();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            pushFollow(FOLLOW_partitionby_in_hdfsFile246);
            partitionby();
            _fsp--;

            pushFollow(FOLLOW_orderby_in_hdfsFile248);
            orderby();
            _fsp--;


            match(input, Token.UP, null); 

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
    // $ANTLR end hdfsFile


    // $ANTLR start hiveTable
    // QSpecBuilder.g:141:1: hiveTable : ^( TABLEINPUT i= ID partitionby orderby ) ;
    public final void hiveTable() throws RecognitionException {
        CommonTree i=null;

        try {
            // QSpecBuilder.g:141:11: ( ^( TABLEINPUT i= ID partitionby orderby ) )
            // QSpecBuilder.g:142:3: ^( TABLEINPUT i= ID partitionby orderby )
            {
            match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hiveTable261); 

            match(input, Token.DOWN, null); 
            i=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_hiveTable265); 
            pushFollow(FOLLOW_partitionby_in_hiveTable267);
            partitionby();
            _fsp--;

            pushFollow(FOLLOW_orderby_in_hiveTable269);
            orderby();
            _fsp--;


            match(input, Token.UP, null); 
            qSpec.getTableIn().setTableName(i.getText()); 

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
    // $ANTLR end hiveTable


    // $ANTLR start hiveQuery
    // QSpecBuilder.g:145:1: hiveQuery : ^( TABLEINPUT ge= GROOVYEXPRESSION partitionby orderby ) ;
    public final void hiveQuery() throws RecognitionException {
        CommonTree ge=null;

        try {
            // QSpecBuilder.g:145:11: ( ^( TABLEINPUT ge= GROOVYEXPRESSION partitionby orderby ) )
            // QSpecBuilder.g:146:3: ^( TABLEINPUT ge= GROOVYEXPRESSION partitionby orderby )
            {
            match(input,TABLEINPUT,FOLLOW_TABLEINPUT_in_hiveQuery284); 

            match(input, Token.DOWN, null); 
            ge=(CommonTree)input.LT(1);
            match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_hiveQuery288); 
            pushFollow(FOLLOW_partitionby_in_hiveQuery290);
            partitionby();
            _fsp--;

            pushFollow(FOLLOW_orderby_in_hiveQuery292);
            orderby();
            _fsp--;


            match(input, Token.UP, null); 
            qSpec.getTableIn().setHiveQuery(ge.getText()); 

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
    // $ANTLR end hiveQuery


    // $ANTLR start namevalue
    // QSpecBuilder.g:149:1: namevalue : ^( PARAM (n= ID | n= STRING ) v= STRING ) ;
    public final void namevalue() throws RecognitionException {
        CommonTree n=null;
        CommonTree v=null;

        try {
            // QSpecBuilder.g:149:11: ( ^( PARAM (n= ID | n= STRING ) v= STRING ) )
            // QSpecBuilder.g:150:2: ^( PARAM (n= ID | n= STRING ) v= STRING )
            {
            match(input,PARAM,FOLLOW_PARAM_in_namevalue307); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder.g:150:10: (n= ID | n= STRING )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                alt10=1;
            }
            else if ( (LA10_0==STRING) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("150:10: (n= ID | n= STRING )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // QSpecBuilder.g:150:11: n= ID
                    {
                    n=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_namevalue312); 

                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:150:16: n= STRING
                    {
                    n=(CommonTree)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_namevalue316); 

                    }
                    break;

            }

            v=(CommonTree)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_namevalue321); 

            match(input, Token.UP, null); 
            setParameter(n.getText(),v.getText());

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


    // $ANTLR start orderby
    // QSpecBuilder.g:153:1: orderby : ^( ORDER (oc= ordercolumn )+ ) ;
    public final void orderby() throws RecognitionException {
        OrderColumn oc = null;


        try {
            // QSpecBuilder.g:153:9: ( ^( ORDER (oc= ordercolumn )+ ) )
            // QSpecBuilder.g:154:2: ^( ORDER (oc= ordercolumn )+ )
            {
            match(input,ORDER,FOLLOW_ORDER_in_orderby335); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder.g:154:10: (oc= ordercolumn )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==ORDERCOLUMN) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // QSpecBuilder.g:154:11: oc= ordercolumn
            	    {
            	    pushFollow(FOLLOW_ordercolumn_in_orderby340);
            	    oc=ordercolumn();
            	    _fsp--;

            	    ((PartOrderScope_scope)PartOrderScope_stack.peek()).orderColumns.add(oc);

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            match(input, Token.UP, null); 

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
    // $ANTLR end orderby


    // $ANTLR start ordercolumn
    // QSpecBuilder.g:157:1: ordercolumn returns [OrderColumn oc] : ( ^( ORDERCOLUMN i= ID ASC ) | ^( ORDERCOLUMN i= ID DESC ) | ^( ORDERCOLUMN i= ID ) );
    public final OrderColumn ordercolumn() throws RecognitionException {
        OrderColumn oc = null;

        CommonTree i=null;


          oc = new OrderColumn();
          oc.setOrder(Order.ASC);

        try {
            // QSpecBuilder.g:163:1: ( ^( ORDERCOLUMN i= ID ASC ) | ^( ORDERCOLUMN i= ID DESC ) | ^( ORDERCOLUMN i= ID ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ORDERCOLUMN) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==DOWN) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==ID) ) {
                        switch ( input.LA(4) ) {
                        case ASC:
                            {
                            alt12=1;
                            }
                            break;
                        case DESC:
                            {
                            alt12=2;
                            }
                            break;
                        case UP:
                            {
                            alt12=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("157:1: ordercolumn returns [OrderColumn oc] : ( ^( ORDERCOLUMN i= ID ASC ) | ^( ORDERCOLUMN i= ID DESC ) | ^( ORDERCOLUMN i= ID ) );", 12, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("157:1: ordercolumn returns [OrderColumn oc] : ( ^( ORDERCOLUMN i= ID ASC ) | ^( ORDERCOLUMN i= ID DESC ) | ^( ORDERCOLUMN i= ID ) );", 12, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("157:1: ordercolumn returns [OrderColumn oc] : ( ^( ORDERCOLUMN i= ID ASC ) | ^( ORDERCOLUMN i= ID DESC ) | ^( ORDERCOLUMN i= ID ) );", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("157:1: ordercolumn returns [OrderColumn oc] : ( ^( ORDERCOLUMN i= ID ASC ) | ^( ORDERCOLUMN i= ID DESC ) | ^( ORDERCOLUMN i= ID ) );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // QSpecBuilder.g:164:2: ^( ORDERCOLUMN i= ID ASC )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn365); 

                    match(input, Token.DOWN, null); 
                    i=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_ordercolumn369); 
                    match(input,ASC,FOLLOW_ASC_in_ordercolumn371); 

                    match(input, Token.UP, null); 
                    oc.setName(i.getText());

                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:165:2: ^( ORDERCOLUMN i= ID DESC )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn380); 

                    match(input, Token.DOWN, null); 
                    i=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_ordercolumn384); 
                    match(input,DESC,FOLLOW_DESC_in_ordercolumn386); 

                    match(input, Token.UP, null); 
                    oc.setName(i.getText()); oc.setOrder(Order.DESC); 

                    }
                    break;
                case 3 :
                    // QSpecBuilder.g:166:2: ^( ORDERCOLUMN i= ID )
                    {
                    match(input,ORDERCOLUMN,FOLLOW_ORDERCOLUMN_in_ordercolumn395); 

                    match(input, Token.DOWN, null); 
                    i=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_ordercolumn399); 

                    match(input, Token.UP, null); 
                    oc.setName(i.getText());

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
        return oc;
    }
    // $ANTLR end ordercolumn


    // $ANTLR start partitionby
    // QSpecBuilder.g:169:1: partitionby : ^( PARTITION (i= ID )+ ) ;
    public final void partitionby() throws RecognitionException {
        CommonTree i=null;

        try {
            // QSpecBuilder.g:169:13: ( ^( PARTITION (i= ID )+ ) )
            // QSpecBuilder.g:170:2: ^( PARTITION (i= ID )+ )
            {
            match(input,PARTITION,FOLLOW_PARTITION_in_partitionby414); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder.g:170:14: (i= ID )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // QSpecBuilder.g:170:15: i= ID
            	    {
            	    i=(CommonTree)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_partitionby419); 
            	    ((PartOrderScope_scope)PartOrderScope_stack.peek()).partitionColumns.add(i.getText());

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            match(input, Token.UP, null); 

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
    // $ANTLR end partitionby


    // $ANTLR start funclist
    // QSpecBuilder.g:173:1: funclist : ^( FUNCTIONS (f= function )+ ) ;
    public final void funclist() throws RecognitionException {
        FuncSpec f = null;


        try {
            // QSpecBuilder.g:173:10: ( ^( FUNCTIONS (f= function )+ ) )
            // QSpecBuilder.g:174:2: ^( FUNCTIONS (f= function )+ )
            {
            match(input,FUNCTIONS,FOLLOW_FUNCTIONS_in_funclist437); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder.g:174:14: (f= function )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==FUNCTION) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // QSpecBuilder.g:174:15: f= function
            	    {
            	    pushFollow(FOLLOW_function_in_funclist442);
            	    f=function();
            	    _fsp--;

            	    qSpec.getFuncSpecs().add(f);

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            match(input, Token.UP, null); 

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
    // $ANTLR end funclist


    // $ANTLR start function
    // QSpecBuilder.g:177:1: function returns [FuncSpec f] : ^( FUNCTION name= ID alias= ID (p= functionparam )* ( ^( TYPENAME t= ID ) )? (w= window_expression )? ) ;
    public final FuncSpec function() throws RecognitionException {
        FuncSpec f = null;

        CommonTree name=null;
        CommonTree alias=null;
        CommonTree t=null;
        FuncArg p = null;

        Window w = null;



          f = new FuncSpec();

        try {
            // QSpecBuilder.g:182:1: ( ^( FUNCTION name= ID alias= ID (p= functionparam )* ( ^( TYPENAME t= ID ) )? (w= window_expression )? ) )
            // QSpecBuilder.g:183:2: ^( FUNCTION name= ID alias= ID (p= functionparam )* ( ^( TYPENAME t= ID ) )? (w= window_expression )? )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function469); 

            match(input, Token.DOWN, null); 
            name=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_function480); 
            f.setName(name.getText().toLowerCase());
            alias=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_function492); 
            f.setAlias(alias.getText());
            // QSpecBuilder.g:186:7: (p= functionparam )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==ID||(LA15_0>=GROOVYEXPRESSION && LA15_0<=STRING)||LA15_0==NUMBER) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // QSpecBuilder.g:186:8: p= functionparam
            	    {
            	    pushFollow(FOLLOW_functionparam_in_function505);
            	    p=functionparam();
            	    _fsp--;

            	    f.getParams().add(p);

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // QSpecBuilder.g:187:7: ( ^( TYPENAME t= ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==TYPENAME) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // QSpecBuilder.g:187:8: ^( TYPENAME t= ID )
                    {
                    match(input,TYPENAME,FOLLOW_TYPENAME_in_function520); 

                    match(input, Token.DOWN, null); 
                    t=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_function524); 

                    match(input, Token.UP, null); 
                    f.setTypeName(t.getText());

                    }
                    break;

            }

            // QSpecBuilder.g:188:7: (w= window_expression )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=WINDOWRANGE && LA17_0<=WINDOWVALUES)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // QSpecBuilder.g:188:8: w= window_expression
                    {
                    pushFollow(FOLLOW_window_expression_in_function541);
                    w=window_expression();
                    _fsp--;

                    f.setWindow(w);

                    }
                    break;

            }


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return f;
    }
    // $ANTLR end function


    // $ANTLR start functionparam
    // QSpecBuilder.g:192:1: functionparam returns [FuncArg arg] : (ge= GROOVYEXPRESSION | s= STRING | i= ID | n= NUMBER );
    public final FuncArg functionparam() throws RecognitionException {
        FuncArg arg = null;

        CommonTree ge=null;
        CommonTree s=null;
        CommonTree i=null;
        CommonTree n=null;


          arg = new FuncArg();

        try {
            // QSpecBuilder.g:197:1: (ge= GROOVYEXPRESSION | s= STRING | i= ID | n= NUMBER )
            int alt18=4;
            switch ( input.LA(1) ) {
            case GROOVYEXPRESSION:
                {
                alt18=1;
                }
                break;
            case STRING:
                {
                alt18=2;
                }
                break;
            case ID:
                {
                alt18=3;
                }
                break;
            case NUMBER:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("192:1: functionparam returns [FuncArg arg] : (ge= GROOVYEXPRESSION | s= STRING | i= ID | n= NUMBER );", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // QSpecBuilder.g:198:2: ge= GROOVYEXPRESSION
                    {
                    ge=(CommonTree)input.LT(1);
                    match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_functionparam574); 
                    arg.setExpr(ge.getText());

                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:199:2: s= STRING
                    {
                    s=(CommonTree)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_functionparam585); 
                    arg.setStr(s.getText());

                    }
                    break;
                case 3 :
                    // QSpecBuilder.g:200:2: i= ID
                    {
                    i=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_functionparam594); 
                    arg.setId(i.getText());

                    }
                    break;
                case 4 :
                    // QSpecBuilder.g:201:2: n= NUMBER
                    {
                    n=(CommonTree)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_functionparam604); 
                    arg.setiVal(Integer.parseInt(n.getText()));

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
        return arg;
    }
    // $ANTLR end functionparam


    // $ANTLR start window_expression
    // QSpecBuilder.g:204:1: window_expression returns [ Window w ] : (w1= window_range_expression | w1= window_value_expression ) ;
    public final Window window_expression() throws RecognitionException {
        Window w = null;

        Window w1 = null;


        try {
            // QSpecBuilder.g:205:1: ( (w1= window_range_expression | w1= window_value_expression ) )
            // QSpecBuilder.g:206:2: (w1= window_range_expression | w1= window_value_expression )
            {
            // QSpecBuilder.g:206:2: (w1= window_range_expression | w1= window_value_expression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==WINDOWRANGE) ) {
                alt19=1;
            }
            else if ( (LA19_0==WINDOWVALUES) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("206:2: (w1= window_range_expression | w1= window_value_expression )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // QSpecBuilder.g:206:3: w1= window_range_expression
                    {
                    pushFollow(FOLLOW_window_range_expression_in_window_expression624);
                    w1=window_range_expression();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:207:2: w1= window_value_expression
                    {
                    pushFollow(FOLLOW_window_value_expression_in_window_expression631);
                    w1=window_value_expression();
                    _fsp--;


                    }
                    break;

            }

            w = w1;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return w;
    }
    // $ANTLR end window_expression


    // $ANTLR start window_range_expression
    // QSpecBuilder.g:211:1: window_range_expression returns [ Window w ] : ^( WINDOWRANGE s= rowsboundary e= rowsboundary ) ;
    public final Window window_range_expression() throws RecognitionException {
        Window w = null;

        Boundary s = null;

        Boundary e = null;


        try {
            // QSpecBuilder.g:212:1: ( ^( WINDOWRANGE s= rowsboundary e= rowsboundary ) )
            // QSpecBuilder.g:213:2: ^( WINDOWRANGE s= rowsboundary e= rowsboundary )
            {
            match(input,WINDOWRANGE,FOLLOW_WINDOWRANGE_in_window_range_expression654); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_rowsboundary_in_window_range_expression658);
            s=rowsboundary();
            _fsp--;

            pushFollow(FOLLOW_rowsboundary_in_window_range_expression662);
            e=rowsboundary();
            _fsp--;


            match(input, Token.UP, null); 

             w = new Window();
             w.setStart(s);
             w.setEnd(e);
             

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return w;
    }
    // $ANTLR end window_range_expression


    // $ANTLR start rowsboundary
    // QSpecBuilder.g:220:1: rowsboundary returns [Boundary b] : ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( FOLLOWING n= NUMBER ) | ^( PRECEDING n= NUMBER ) );
    public final Boundary rowsboundary() throws RecognitionException {
        Boundary b = null;

        CommonTree n=null;


          RangeBoundary rb = new RangeBoundary();
          b = rb;

        try {
            // QSpecBuilder.g:226:1: ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( FOLLOWING n= NUMBER ) | ^( PRECEDING n= NUMBER ) )
            int alt20=5;
            switch ( input.LA(1) ) {
            case FOLLOWING:
                {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==DOWN) ) {
                    int LA20_4 = input.LA(3);

                    if ( (LA20_4==NUMBER) ) {
                        alt20=4;
                    }
                    else if ( (LA20_4==UNBOUNDED) ) {
                        alt20=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("220:1: rowsboundary returns [Boundary b] : ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( FOLLOWING n= NUMBER ) | ^( PRECEDING n= NUMBER ) );", 20, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("220:1: rowsboundary returns [Boundary b] : ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( FOLLOWING n= NUMBER ) | ^( PRECEDING n= NUMBER ) );", 20, 1, input);

                    throw nvae;
                }
                }
                break;
            case PRECEDING:
                {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==DOWN) ) {
                    int LA20_5 = input.LA(3);

                    if ( (LA20_5==NUMBER) ) {
                        alt20=5;
                    }
                    else if ( (LA20_5==UNBOUNDED) ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("220:1: rowsboundary returns [Boundary b] : ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( FOLLOWING n= NUMBER ) | ^( PRECEDING n= NUMBER ) );", 20, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("220:1: rowsboundary returns [Boundary b] : ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( FOLLOWING n= NUMBER ) | ^( PRECEDING n= NUMBER ) );", 20, 2, input);

                    throw nvae;
                }
                }
                break;
            case CURRENT:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("220:1: rowsboundary returns [Boundary b] : ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( FOLLOWING n= NUMBER ) | ^( PRECEDING n= NUMBER ) );", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // QSpecBuilder.g:227:3: ^( FOLLOWING UNBOUNDED )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary685); 

                    match(input, Token.DOWN, null); 
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary687); 

                    match(input, Token.UP, null); 

                        rb.setDirection(Direction.FOLLOWING);
                        rb.setAmt(Boundary.UNBOUNDED_AMOUNT);
                      

                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:231:3: ^( PRECEDING UNBOUNDED )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary698); 

                    match(input, Token.DOWN, null); 
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_rowsboundary700); 

                    match(input, Token.UP, null); 

                        rb.setDirection(Direction.PRECEDING);
                        rb.setAmt(Boundary.UNBOUNDED_AMOUNT);
                      

                    }
                    break;
                case 3 :
                    // QSpecBuilder.g:235:3: CURRENT
                    {
                    match(input,CURRENT,FOLLOW_CURRENT_in_rowsboundary710); 
                    b = new CurrentRow();

                    }
                    break;
                case 4 :
                    // QSpecBuilder.g:236:3: ^( FOLLOWING n= NUMBER )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_rowsboundary719); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary723); 

                    match(input, Token.UP, null); 

                        rb.setDirection(Direction.FOLLOWING);
                        rb.setAmt(Integer.parseInt(n.getText()));
                      

                    }
                    break;
                case 5 :
                    // QSpecBuilder.g:240:3: ^( PRECEDING n= NUMBER )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_rowsboundary733); 

                    match(input, Token.DOWN, null); 
                    n=(CommonTree)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_rowsboundary737); 

                    match(input, Token.UP, null); 

                        rb.setDirection(Direction.PRECEDING);
                        rb.setAmt(Integer.parseInt(n.getText()));
                      

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
        return b;
    }
    // $ANTLR end rowsboundary


    // $ANTLR start window_value_expression
    // QSpecBuilder.g:246:1: window_value_expression returns [ Window w ] : ^( WINDOWVALUES s= valuesboundary e= valuesboundary ) ;
    public final Window window_value_expression() throws RecognitionException {
        Window w = null;

        Boundary s = null;

        Boundary e = null;


        try {
            // QSpecBuilder.g:247:1: ( ^( WINDOWVALUES s= valuesboundary e= valuesboundary ) )
            // QSpecBuilder.g:248:2: ^( WINDOWVALUES s= valuesboundary e= valuesboundary )
            {
            match(input,WINDOWVALUES,FOLLOW_WINDOWVALUES_in_window_value_expression757); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_valuesboundary_in_window_value_expression761);
            s=valuesboundary();
            _fsp--;

            pushFollow(FOLLOW_valuesboundary_in_window_value_expression765);
            e=valuesboundary();
            _fsp--;


            match(input, Token.UP, null); 

             w = new Window();
             w.setStart(s);
             w.setEnd(e);
             

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return w;
    }
    // $ANTLR end window_value_expression


    // $ANTLR start valuesboundary
    // QSpecBuilder.g:255:1: valuesboundary returns [Boundary b] : ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( LESS ge= GROOVYEXPRESSION n= NUMBER ) | ^( MORE GROOVYEXPRESSION NUMBER ) );
    public final Boundary valuesboundary() throws RecognitionException {
        Boundary b = null;

        CommonTree ge=null;
        CommonTree n=null;


          ValueBoundary vb = new ValueBoundary();
          b = vb;

        try {
            // QSpecBuilder.g:261:1: ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( LESS ge= GROOVYEXPRESSION n= NUMBER ) | ^( MORE GROOVYEXPRESSION NUMBER ) )
            int alt21=5;
            switch ( input.LA(1) ) {
            case FOLLOWING:
                {
                alt21=1;
                }
                break;
            case PRECEDING:
                {
                alt21=2;
                }
                break;
            case CURRENT:
                {
                alt21=3;
                }
                break;
            case LESS:
                {
                alt21=4;
                }
                break;
            case MORE:
                {
                alt21=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("255:1: valuesboundary returns [Boundary b] : ( ^( FOLLOWING UNBOUNDED ) | ^( PRECEDING UNBOUNDED ) | CURRENT | ^( LESS ge= GROOVYEXPRESSION n= NUMBER ) | ^( MORE GROOVYEXPRESSION NUMBER ) );", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // QSpecBuilder.g:262:3: ^( FOLLOWING UNBOUNDED )
                    {
                    match(input,FOLLOWING,FOLLOW_FOLLOWING_in_valuesboundary788); 

                    match(input, Token.DOWN, null); 
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary790); 

                    match(input, Token.UP, null); 

                        RangeBoundary rb = new RangeBoundary();
                        rb.setDirection(Direction.FOLLOWING);
                        rb.setAmt(Boundary.UNBOUNDED_AMOUNT);
                        b = rb;
                      

                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:268:3: ^( PRECEDING UNBOUNDED )
                    {
                    match(input,PRECEDING,FOLLOW_PRECEDING_in_valuesboundary801); 

                    match(input, Token.DOWN, null); 
                    match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_valuesboundary803); 

                    match(input, Token.UP, null); 

                        RangeBoundary rb = new RangeBoundary();
                        rb.setDirection(Direction.PRECEDING);
                        rb.setAmt(Boundary.UNBOUNDED_AMOUNT);
                        b = rb;
                      

                    }
                    break;
                case 3 :
                    // QSpecBuilder.g:274:3: CURRENT
                    {
                    match(input,CURRENT,FOLLOW_CURRENT_in_valuesboundary814); 
                    b = new CurrentRow();

                    }
                    break;
                case 4 :
                    // QSpecBuilder.g:275:3: ^( LESS ge= GROOVYEXPRESSION n= NUMBER )
                    {
                    match(input,LESS,FOLLOW_LESS_in_valuesboundary823); 

                    match(input, Token.DOWN, null); 
                    ge=(CommonTree)input.LT(1);
                    match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary827); 
                    n=(CommonTree)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary831); 

                    match(input, Token.UP, null); 

                        vb.setDirection(Direction.PRECEDING);
                        vb.setExprString(ge.getText());
                        vb.setAmt(Integer.parseInt(n.getText()));
                      

                    }
                    break;
                case 5 :
                    // QSpecBuilder.g:280:3: ^( MORE GROOVYEXPRESSION NUMBER )
                    {
                    match(input,MORE,FOLLOW_MORE_in_valuesboundary841); 

                    match(input, Token.DOWN, null); 
                    match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_valuesboundary843); 
                    match(input,NUMBER,FOLLOW_NUMBER_in_valuesboundary845); 

                    match(input, Token.UP, null); 

                        vb.setDirection(Direction.FOLLOWING);
                        vb.setExprString(ge.getText());
                        vb.setAmt(Integer.parseInt(n.getText()));
                      

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
        return b;
    }
    // $ANTLR end valuesboundary


    // $ANTLR start select
    // QSpecBuilder.g:287:1: select : ^( SELECT (sc= selectColumn )+ ) ;
    public final void select() throws RecognitionException {
        SelectColumn sc = null;


        try {
            // QSpecBuilder.g:287:9: ( ^( SELECT (sc= selectColumn )+ ) )
            // QSpecBuilder.g:288:3: ^( SELECT (sc= selectColumn )+ )
            {
            match(input,SELECT,FOLLOW_SELECT_in_select861); 

            match(input, Token.DOWN, null); 
            // QSpecBuilder.g:288:12: (sc= selectColumn )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==SELECTCOLUMN) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // QSpecBuilder.g:288:13: sc= selectColumn
            	    {
            	    pushFollow(FOLLOW_selectColumn_in_select866);
            	    sc=selectColumn();
            	    _fsp--;

            	    qSpec.getSelectColumns().add(sc);

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            match(input, Token.UP, null); 

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
    // $ANTLR end select


    // $ANTLR start selectColumn
    // QSpecBuilder.g:291:1: selectColumn returns [SelectColumn sc] : ( ^( SELECTCOLUMN id= ID ge= GROOVYEXPRESSION ( ^( TYPENAME t= typeName ) )? ) | ^( SELECTCOLUMN id= ID ) );
    public final SelectColumn selectColumn() throws RecognitionException {
        SelectColumn sc = null;

        CommonTree id=null;
        CommonTree ge=null;
        typeName_return t = null;



          sc = new SelectColumn();

        try {
            // QSpecBuilder.g:295:1: ( ^( SELECTCOLUMN id= ID ge= GROOVYEXPRESSION ( ^( TYPENAME t= typeName ) )? ) | ^( SELECTCOLUMN id= ID ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==SELECTCOLUMN) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==DOWN) ) {
                    int LA24_2 = input.LA(3);

                    if ( (LA24_2==ID) ) {
                        int LA24_3 = input.LA(4);

                        if ( (LA24_3==UP) ) {
                            alt24=2;
                        }
                        else if ( (LA24_3==GROOVYEXPRESSION) ) {
                            alt24=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("291:1: selectColumn returns [SelectColumn sc] : ( ^( SELECTCOLUMN id= ID ge= GROOVYEXPRESSION ( ^( TYPENAME t= typeName ) )? ) | ^( SELECTCOLUMN id= ID ) );", 24, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("291:1: selectColumn returns [SelectColumn sc] : ( ^( SELECTCOLUMN id= ID ge= GROOVYEXPRESSION ( ^( TYPENAME t= typeName ) )? ) | ^( SELECTCOLUMN id= ID ) );", 24, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("291:1: selectColumn returns [SelectColumn sc] : ( ^( SELECTCOLUMN id= ID ge= GROOVYEXPRESSION ( ^( TYPENAME t= typeName ) )? ) | ^( SELECTCOLUMN id= ID ) );", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("291:1: selectColumn returns [SelectColumn sc] : ( ^( SELECTCOLUMN id= ID ge= GROOVYEXPRESSION ( ^( TYPENAME t= typeName ) )? ) | ^( SELECTCOLUMN id= ID ) );", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // QSpecBuilder.g:296:3: ^( SELECTCOLUMN id= ID ge= GROOVYEXPRESSION ( ^( TYPENAME t= typeName ) )? )
                    {
                    match(input,SELECTCOLUMN,FOLLOW_SELECTCOLUMN_in_selectColumn892); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_selectColumn896); 
                    sc.setAlias(id.getText());
                    ge=(CommonTree)input.LT(1);
                    match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_selectColumn902); 
                    sc.setExpr(ge.getText());
                    // QSpecBuilder.g:296:95: ( ^( TYPENAME t= typeName ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==TYPENAME) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // QSpecBuilder.g:296:96: ^( TYPENAME t= typeName )
                            {
                            match(input,TYPENAME,FOLLOW_TYPENAME_in_selectColumn908); 

                            match(input, Token.DOWN, null); 
                            pushFollow(FOLLOW_typeName_in_selectColumn912);
                            t=typeName();
                            _fsp--;

                            sc.setTypeName(input.getTokenStream().toString(
                              input.getTreeAdaptor().getTokenStartIndex(t.start),
                              input.getTreeAdaptor().getTokenStopIndex(t.start)));

                            match(input, Token.UP, null); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:297:3: ^( SELECTCOLUMN id= ID )
                    {
                    match(input,SELECTCOLUMN,FOLLOW_SELECTCOLUMN_in_selectColumn925); 

                    match(input, Token.DOWN, null); 
                    id=(CommonTree)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_selectColumn930); 
                    sc.setAlias(id.getText());

                    match(input, Token.UP, null); 

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
        return sc;
    }
    // $ANTLR end selectColumn

    public static class typeName_return extends TreeRuleReturnScope {
    };

    // $ANTLR start typeName
    // QSpecBuilder.g:300:1: typeName : ( ID | STRING );
    public final typeName_return typeName() throws RecognitionException {
        typeName_return retval = new typeName_return();
        retval.start = input.LT(1);

        try {
            // QSpecBuilder.g:300:9: ( ID | STRING )
            // QSpecBuilder.g:
            {
            if ( input.LA(1)==ID||input.LA(1)==STRING ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_typeName0);    throw mse;
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
    // $ANTLR end typeName


    // $ANTLR start where
    // QSpecBuilder.g:304:1: where : ^( WHERE ge= GROOVYEXPRESSION ) ;
    public final void where() throws RecognitionException {
        CommonTree ge=null;

        try {
            // QSpecBuilder.g:304:7: ( ^( WHERE ge= GROOVYEXPRESSION ) )
            // QSpecBuilder.g:305:2: ^( WHERE ge= GROOVYEXPRESSION )
            {
            match(input,WHERE,FOLLOW_WHERE_in_where959); 

            match(input, Token.DOWN, null); 
            ge=(CommonTree)input.LT(1);
            match(input,GROOVYEXPRESSION,FOLLOW_GROOVYEXPRESSION_in_where963); 

            match(input, Token.UP, null); 
            qSpec.setWhereExpr(ge.getText());

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
    // QSpecBuilder.g:308:1: outputClause : ^( OUTPUTSPEC path= STRING ( outputSerDe )? ( loadClause )? ) ;
    public final void outputClause() throws RecognitionException {
        CommonTree path=null;


          processingOutputSpec = true;

        try {
            // QSpecBuilder.g:315:1: ( ^( OUTPUTSPEC path= STRING ( outputSerDe )? ( loadClause )? ) )
            // QSpecBuilder.g:316:2: ^( OUTPUTSPEC path= STRING ( outputSerDe )? ( loadClause )? )
            {
            match(input,OUTPUTSPEC,FOLLOW_OUTPUTSPEC_in_outputClause988); 

            match(input, Token.DOWN, null); 
            path=(CommonTree)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_outputClause992); 
            // QSpecBuilder.g:316:27: ( outputSerDe )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==SERDE) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // QSpecBuilder.g:316:27: outputSerDe
                    {
                    pushFollow(FOLLOW_outputSerDe_in_outputClause994);
                    outputSerDe();
                    _fsp--;


                    }
                    break;

            }

            // QSpecBuilder.g:316:40: ( loadClause )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==LOADSPEC) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // QSpecBuilder.g:316:40: loadClause
                    {
                    pushFollow(FOLLOW_loadClause_in_outputClause997);
                    loadClause();
                    _fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            qSpec.getTableOut().setOutputPath(path.getText());

            }


              processingOutputSpec = false;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end outputClause


    // $ANTLR start outputSerDe
    // QSpecBuilder.g:319:1: outputSerDe : ^( SERDE sd= STRING outputFormatOrWriter ( outputSerDePropeties )? ) ;
    public final void outputSerDe() throws RecognitionException {
        CommonTree sd=null;

        try {
            // QSpecBuilder.g:319:13: ( ^( SERDE sd= STRING outputFormatOrWriter ( outputSerDePropeties )? ) )
            // QSpecBuilder.g:320:3: ^( SERDE sd= STRING outputFormatOrWriter ( outputSerDePropeties )? )
            {
            match(input,SERDE,FOLLOW_SERDE_in_outputSerDe1013); 

            match(input, Token.DOWN, null); 
            sd=(CommonTree)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_outputSerDe1017); 
            pushFollow(FOLLOW_outputFormatOrWriter_in_outputSerDe1019);
            outputFormatOrWriter();
            _fsp--;

            // QSpecBuilder.g:320:42: ( outputSerDePropeties )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==SERDEPROPERTIES) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // QSpecBuilder.g:320:42: outputSerDePropeties
                    {
                    pushFollow(FOLLOW_outputSerDePropeties_in_outputSerDe1021);
                    outputSerDePropeties();
                    _fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            qSpec.getTableOut().setSerDeClass(sd.getText());

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
    // QSpecBuilder.g:323:1: outputSerDePropeties : ^( SERDEPROPERTIES ( namevalue )* ) ;
    public final void outputSerDePropeties() throws RecognitionException {
        try {
            // QSpecBuilder.g:323:21: ( ^( SERDEPROPERTIES ( namevalue )* ) )
            // QSpecBuilder.g:324:3: ^( SERDEPROPERTIES ( namevalue )* )
            {
            match(input,SERDEPROPERTIES,FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1036); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // QSpecBuilder.g:324:21: ( namevalue )*
                loop28:
                do {
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==PARAM) ) {
                        alt28=1;
                    }


                    switch (alt28) {
                	case 1 :
                	    // QSpecBuilder.g:324:21: namevalue
                	    {
                	    pushFollow(FOLLOW_namevalue_in_outputSerDePropeties1038);
                	    namevalue();
                	    _fsp--;


                	    }
                	    break;

                	default :
                	    break loop28;
                    }
                } while (true);


                match(input, Token.UP, null); 
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
    // QSpecBuilder.g:327:1: outputFormatOrWriter : ( ^( RECORDWRITER rw= STRING ) | ^( FORMAT f= STRING ) );
    public final void outputFormatOrWriter() throws RecognitionException {
        CommonTree rw=null;
        CommonTree f=null;

        try {
            // QSpecBuilder.g:327:22: ( ^( RECORDWRITER rw= STRING ) | ^( FORMAT f= STRING ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RECORDWRITER) ) {
                alt29=1;
            }
            else if ( (LA29_0==FORMAT) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("327:1: outputFormatOrWriter : ( ^( RECORDWRITER rw= STRING ) | ^( FORMAT f= STRING ) );", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // QSpecBuilder.g:328:3: ^( RECORDWRITER rw= STRING )
                    {
                    match(input,RECORDWRITER,FOLLOW_RECORDWRITER_in_outputFormatOrWriter1052); 

                    match(input, Token.DOWN, null); 
                    rw=(CommonTree)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1056); 

                    match(input, Token.UP, null); 
                    qSpec.getTableOut().setRecordwriterClass(rw.getText());

                    }
                    break;
                case 2 :
                    // QSpecBuilder.g:329:3: ^( FORMAT f= STRING )
                    {
                    match(input,FORMAT,FOLLOW_FORMAT_in_outputFormatOrWriter1066); 

                    match(input, Token.DOWN, null); 
                    f=(CommonTree)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_outputFormatOrWriter1070); 

                    match(input, Token.UP, null); 
                    qSpec.getTableOut().setOutputFormat(f.getText());

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
    // QSpecBuilder.g:332:1: loadClause : ^( LOADSPEC tN= ID (pc= STRING )? (ow= OVERWRITE )? ) ;
    public final void loadClause() throws RecognitionException {
        CommonTree tN=null;
        CommonTree pc=null;
        CommonTree ow=null;

        try {
            // QSpecBuilder.g:332:11: ( ^( LOADSPEC tN= ID (pc= STRING )? (ow= OVERWRITE )? ) )
            // QSpecBuilder.g:333:3: ^( LOADSPEC tN= ID (pc= STRING )? (ow= OVERWRITE )? )
            {
            match(input,LOADSPEC,FOLLOW_LOADSPEC_in_loadClause1084); 

            match(input, Token.DOWN, null); 
            tN=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_loadClause1093); 
            qSpec.getTableOut().setTableName(tN.getText());
            // QSpecBuilder.g:335:5: (pc= STRING )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==STRING) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // QSpecBuilder.g:335:6: pc= STRING
                    {
                    pc=(CommonTree)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_loadClause1104); 
                    qSpec.getTableOut().setPartitionClause(pc.getText());

                    }
                    break;

            }

            // QSpecBuilder.g:336:5: (ow= OVERWRITE )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==OVERWRITE) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // QSpecBuilder.g:336:6: ow= OVERWRITE
                    {
                    ow=(CommonTree)input.LT(1);
                    match(input,OVERWRITE,FOLLOW_OVERWRITE_in_loadClause1118); 
                    qSpec.getTableOut().setOverwrite(true);

                    }
                    break;

            }


            match(input, Token.UP, null); 

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


 

    public static final BitSet FOLLOW_QUERY_in_query68 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tableSpec_in_query72 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_select_in_query74 = new BitSet(new long[]{0x0008000000010408L});
    public static final BitSet FOLLOW_funclist_in_query76 = new BitSet(new long[]{0x0008000000010008L});
    public static final BitSet FOLLOW_where_in_query79 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_outputClause_in_query82 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_hdfsFile_in_tableSpec110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hiveTable_in_tableSpec115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hiveQuery_in_tableSpec120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tblfunc_in_tableSpec127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TBLFUNCTION_in_tblfunc160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_tblfunc170 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_tableSpec_in_tblfunc181 = new BitSet(new long[]{0x000000222C203008L});
    public static final BitSet FOLLOW_functionparam_in_tblfunc193 = new BitSet(new long[]{0x000000222C203008L});
    public static final BitSet FOLLOW_partitionby_in_tblfunc206 = new BitSet(new long[]{0x0000000020003008L});
    public static final BitSet FOLLOW_orderby_in_tblfunc209 = new BitSet(new long[]{0x0000000000003008L});
    public static final BitSet FOLLOW_window_expression_in_tblfunc221 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hdfsFile241 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_namevalue_in_hdfsFile243 = new BitSet(new long[]{0x0000000200000080L});
    public static final BitSet FOLLOW_partitionby_in_hdfsFile246 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_hdfsFile248 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hiveTable261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_hiveTable265 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_hiveTable267 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_hiveTable269 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TABLEINPUT_in_hiveQuery284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_hiveQuery288 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_partitionby_in_hiveQuery290 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_orderby_in_hiveQuery292 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAM_in_namevalue307 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_namevalue312 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue316 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_STRING_in_namevalue321 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_orderby335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ordercolumn_in_orderby340 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_ORDERCOLUMN_in_ordercolumn365 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ordercolumn369 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ASC_in_ordercolumn371 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDERCOLUMN_in_ordercolumn380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ordercolumn384 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_DESC_in_ordercolumn386 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDERCOLUMN_in_ordercolumn395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ordercolumn399 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partitionby414 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_partitionby419 = new BitSet(new long[]{0x0000000000200008L});
    public static final BitSet FOLLOW_FUNCTIONS_in_funclist437 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_function_in_funclist442 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_FUNCTION_in_function469 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function480 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ID_in_function492 = new BitSet(new long[]{0x000000200C207008L});
    public static final BitSet FOLLOW_functionparam_in_function505 = new BitSet(new long[]{0x000000200C207008L});
    public static final BitSet FOLLOW_TYPENAME_in_function520 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function524 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_window_expression_in_function541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_functionparam574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_functionparam585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_functionparam594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_functionparam604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_range_expression_in_window_expression624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_window_value_expression_in_window_expression631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WINDOWRANGE_in_window_range_expression654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression658 = new BitSet(new long[]{0x0000380000000000L});
    public static final BitSet FOLLOW_rowsboundary_in_window_range_expression662 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary685 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary687 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_UNBOUNDED_in_rowsboundary700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CURRENT_in_rowsboundary710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOLLOWING_in_rowsboundary719 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary723 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRECEDING_in_rowsboundary733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NUMBER_in_rowsboundary737 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WINDOWVALUES_in_window_value_expression757 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression761 = new BitSet(new long[]{0x0003380000000000L});
    public static final BitSet FOLLOW_valuesboundary_in_window_value_expression765 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOLLOWING_in_valuesboundary788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PRECEDING_in_valuesboundary801 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_UNBOUNDED_in_valuesboundary803 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CURRENT_in_valuesboundary814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_valuesboundary823 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary827 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary831 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MORE_in_valuesboundary841 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_valuesboundary843 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_NUMBER_in_valuesboundary845 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SELECT_in_select861 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_selectColumn_in_select866 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_SELECTCOLUMN_in_selectColumn892 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_selectColumn896 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_selectColumn902 = new BitSet(new long[]{0x0000000000004008L});
    public static final BitSet FOLLOW_TYPENAME_in_selectColumn908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_typeName_in_selectColumn912 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SELECTCOLUMN_in_selectColumn925 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_selectColumn930 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_typeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where959 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GROOVYEXPRESSION_in_where963 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUTSPEC_in_outputClause988 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_outputClause992 = new BitSet(new long[]{0x0040000000040008L});
    public static final BitSet FOLLOW_outputSerDe_in_outputClause994 = new BitSet(new long[]{0x0000000000040008L});
    public static final BitSet FOLLOW_loadClause_in_outputClause997 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SERDE_in_outputSerDe1013 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_outputSerDe1017 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_outputFormatOrWriter_in_outputSerDe1019 = new BitSet(new long[]{0x0080000000000008L});
    public static final BitSet FOLLOW_outputSerDePropeties_in_outputSerDe1021 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SERDEPROPERTIES_in_outputSerDePropeties1036 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_namevalue_in_outputSerDePropeties1038 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_RECORDWRITER_in_outputFormatOrWriter1052 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1056 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORMAT_in_outputFormatOrWriter1066 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_outputFormatOrWriter1070 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOADSPEC_in_loadClause1084 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_loadClause1093 = new BitSet(new long[]{0x0800000008000008L});
    public static final BitSet FOLLOW_STRING_in_loadClause1104 = new BitSet(new long[]{0x0800000000000008L});
    public static final BitSet FOLLOW_OVERWRITE_in_loadClause1118 = new BitSet(new long[]{0x0000000000000008L});

}