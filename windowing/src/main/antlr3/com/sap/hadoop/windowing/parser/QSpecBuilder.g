tree grammar QSpecBuilder;

options {
  tokenVocab = Windowing;
  ASTLabelType = CommonTree;
  language = Java;
}

scope PartOrderScope {
  ArrayList<String> partitionColumns;
  ArrayList<OrderColumn> orderColumns;
}

@header {
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
}

@members {
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
  
}


query :
   ^(QUERY tf=tableSpec select funclist? where? outputClause?) {qSpec.setTblFuncSpec(tf);}
;

tableSpec returns [TableFuncSpec tf]
scope PartOrderScope;
@init {
  $PartOrderScope::partitionColumns = qSpec.getTableIn().getPartitionColumns();
  $PartOrderScope::orderColumns = qSpec.getTableIn().getOrderColumns();
}
:
 hdfsFile |
 hiveTable |
 hiveQuery |
 tf1=tblfunc {$tf = tf1; }
;

tblfunc returns [TableFuncSpec tf]
scope PartOrderScope;
@init {
  $tf = new TableFuncSpec();
  $PartOrderScope::partitionColumns = $tf.getPartitionColumns();
  $PartOrderScope::orderColumns = $tf.getOrderColumns();
}
@after {
  if ( $tf.getPartitionColumns().size() == 0 ) $tf.setPartitionColumns(null); 
  if ( $tf.getOrderColumns().size() == 0 ) $tf.setOrderColumns(null); 
  
  if ( $tf.getPartitionColumns() != null && $tf.getInputFuncSpec() == null )
    {
      throw new RuntimeException(Utils.sprintf("Function '" + $tf.getName() + "' cannot have a partition clause, its input is a 'tableinput'"));
    }  
}
:
  ^(TBLFUNCTION 
     name=ID {$tf.setName($name.text.toLowerCase());}
     tf1=tableSpec {$tf.setInputFuncSpec(tf1);}
     (p=functionparam {$tf.getParams().add(p);})*  
     partitionby? orderby? 
     (w=window_expression {$tf.setWindow(w);})?
   )
;

hdfsFile :
 ^(TABLEINPUT namevalue* partitionby orderby)
;

hiveTable :
  ^(TABLEINPUT i=ID partitionby orderby) {qSpec.getTableIn().setTableName($i.text); }
;

hiveQuery :
  ^(TABLEINPUT ge=GROOVYEXPRESSION partitionby orderby ) {qSpec.getTableIn().setHiveQuery($ge.text); }
;

namevalue :
 ^(PARAM (n=ID|n=STRING) v=STRING) {setParameter($n.text,$v.text);}
;

orderby :
 ^(ORDER (oc=ordercolumn {$PartOrderScope::orderColumns.add(oc);})+)
;

ordercolumn returns [OrderColumn oc]
@init
{
  $oc = new OrderColumn();
  $oc.setOrder(Order.ASC);
}
:
 ^(ORDERCOLUMN i=ID ASC) {$oc.setName($i.text);} |
 ^(ORDERCOLUMN i=ID DESC) {$oc.setName($i.text); $oc.setOrder(Order.DESC); } |
 ^(ORDERCOLUMN i=ID) {$oc.setName($i.text);}
;

partitionby : 
 ^(PARTITION (i=ID {$PartOrderScope::partitionColumns.add($i.text);})+)
;

funclist :  
 ^(FUNCTIONS (f=function {qSpec.getFuncSpecs().add(f);})+)
;

function returns [FuncSpec f]
@init
{
  $f = new FuncSpec();
}
:  
 ^(FUNCTION 
      name=ID {$f.setName($name.text.toLowerCase());}
      alias=ID {$f.setAlias($alias.text);}
      (p=functionparam {$f.getParams().add(p);})* 
      (^(TYPENAME t=ID) {$f.setTypeName($t.text);})? 
      (w=window_expression {$f.setWindow(w);})?
   )
;

functionparam  returns [FuncArg arg]
@init
{
  $arg = new FuncArg();
}
:  
 ge=GROOVYEXPRESSION {$arg.setExpr($ge.text);} |  
 s=STRING {$arg.setStr($s.text);}| 
 i=ID {$arg.setId($i.text);} | 
 n=NUMBER {$arg.setiVal(Integer.parseInt($n.text));}
;

window_expression returns [ Window w ] 
:
 (w1=window_range_expression |
 w1=window_value_expression
 ) {$w = w1;}
;
  
window_range_expression returns [ Window w ] 
:
 ^(WINDOWRANGE s=rowsboundary e=rowsboundary) {
 $w = new Window();
 $w.setStart(s);
 $w.setEnd(e);
 }
;

rowsboundary returns[Boundary b]
@init
{
  RangeBoundary rb = new RangeBoundary();
  $b = rb;
}
:
  ^(FOLLOWING UNBOUNDED) {
    rb.setDirection(Direction.FOLLOWING);
    rb.setAmt(Boundary.UNBOUNDED_AMOUNT);
  } | 
  ^(PRECEDING UNBOUNDED) {
    rb.setDirection(Direction.PRECEDING);
    rb.setAmt(Boundary.UNBOUNDED_AMOUNT);
  } | 
  CURRENT {$b = new CurrentRow();} |
  ^(FOLLOWING n=NUMBER) {
    rb.setDirection(Direction.FOLLOWING);
    rb.setAmt(Integer.parseInt($n.text));
  } |
  ^(PRECEDING n=NUMBER) {
    rb.setDirection(Direction.PRECEDING);
    rb.setAmt(Integer.parseInt($n.text));
  }
;

window_value_expression  returns [ Window w ] 
:
 ^(WINDOWVALUES s=valuesboundary e=valuesboundary) {
 $w = new Window();
 $w.setStart(s);
 $w.setEnd(e);
 }
;

valuesboundary returns[Boundary b]
@init
{
  ValueBoundary vb = new ValueBoundary();
  $b = vb;
}
:
  ^(FOLLOWING UNBOUNDED) {
    RangeBoundary rb = new RangeBoundary();
    rb.setDirection(Direction.FOLLOWING);
    rb.setAmt(Boundary.UNBOUNDED_AMOUNT);
    $b = rb;
  } | 
  ^(PRECEDING UNBOUNDED) {
    RangeBoundary rb = new RangeBoundary();
    rb.setDirection(Direction.PRECEDING);
    rb.setAmt(Boundary.UNBOUNDED_AMOUNT);
    $b = rb;
  } |  
  CURRENT {$b = new CurrentRow();} |
  ^(LESS ge=GROOVYEXPRESSION n=NUMBER) {
    vb.setDirection(Direction.PRECEDING);
    vb.setExprString($ge.text);
    vb.setAmt(Integer.parseInt($n.text));
  } |
  ^(MORE GROOVYEXPRESSION NUMBER) {
    vb.setDirection(Direction.FOLLOWING);
    vb.setExprString($ge.text);
    vb.setAmt(Integer.parseInt($n.text));
  }
;

select  :
  ^(SELECT (sc=selectColumn {qSpec.getSelectColumns().add(sc);})+ )
;

selectColumn returns[SelectColumn sc]
@init {
  $sc = new SelectColumn();
}
:
  ^(SELECTCOLUMN id=ID {$sc.setAlias($id.text);} ge=GROOVYEXPRESSION {$sc.setExpr($ge.text);} (^(TYPENAME t=typeName {$sc.setTypeName($t.text);}))?) |
  ^(SELECTCOLUMN id= ID {$sc.setAlias($id.text);})
;

typeName:
  ID | STRING
;

where : 
 ^(WHERE ge=GROOVYEXPRESSION) {qSpec.setWhereExpr($ge.text);}
;

outputClause
@init {
  processingOutputSpec = true;
}
@after {
  processingOutputSpec = false;
} 
:
 ^(OUTPUTSPEC path=STRING outputSerDe? loadClause?) {qSpec.getTableOut().setOutputPath($path.text);}
;

outputSerDe :
  ^(SERDE sd=STRING outputFormatOrWriter outputSerDePropeties?) {qSpec.getTableOut().setSerDeClass($sd.text);}
;

outputSerDePropeties:
  ^(SERDEPROPERTIES namevalue*)
;

outputFormatOrWriter :
  ^(RECORDWRITER rw=STRING) {qSpec.getTableOut().setRecordwriterClass($rw.text);} |
  ^(FORMAT f=STRING) {qSpec.getTableOut().setOutputFormat($f.text);}
;

loadClause:
  ^(LOADSPEC 
    tN=ID {qSpec.getTableOut().setTableName($tN.text);}
    (pc=STRING {qSpec.getTableOut().setPartitionClause($pc.text);})? 
    (ow=OVERWRITE {qSpec.getTableOut().setOverwrite(true);})?
   )
;