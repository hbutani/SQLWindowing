tree grammar QSpecBuilder2;

options {
  tokenVocab = Windowing2;
  ASTLabelType = CommonTree;
  language = Java;
}

scope PartOrderScope {
  ArrayList<String> partitionColumns;
  ArrayList<OrderColumnSpec> orderColumns;
}

@header {
package com.sap.hadoop.windowing.parser;

import com.sap.hadoop.query2.specification.*;
import com.sap.hadoop.query2.specification.WindowFrameSpec.Direction;
import com.sap.hadoop.query2.specification.WindowFrameSpec.BoundarySpec;
import com.sap.hadoop.query2.specification.WindowFrameSpec.RangeBoundarySpec;
import com.sap.hadoop.query2.specification.WindowFrameSpec.CurrentRowSpec;
import com.sap.hadoop.query2.specification.WindowFrameSpec.ValueBoundarySpec;
import com.sap.hadoop.metadata.Order;

import com.sap.hadoop.windowing.Constants;

import com.sap.hadoop.Utils;
import com.sap.hadoop.windowing.WindowingException;
}

@members {
  protected QuerySpec qSpec = new QuerySpec();  

  
  public QuerySpec getQuerySpec() { return qSpec; }
  
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
 ^(QUERY ts=tableSpec ss=select where[qSpec]? window_clause[qSpec]? oc=outputClause?) { qSpec.setInput(ts); qSpec.setSelectList(ss); qSpec.setOutput(oc);}
;

select  returns [SelectSpec ss]
@init
{
  $ss = new SelectSpec();
}
 :
  ^(SELECT selectColumn[ss]+)
;

selectColumn[SelectSpec ss]:
  ^(SELECTCOLUMN e=expression i=Identifier?) {ss.addExpression(e, i!=null ? $i.text : null);} |
  ^(SELECTCOLUMN w=window_function i=Identifier) {ss.addWindowFunc(w, $i.text);}
;

tableSpec returns [QueryInputSpec qIn] :
 ^(INPUT (t=tblfunc|t=hiveQuery|t=hdfsFile|t=hiveTable) (p=partitionby {t.setPartition(p);})? (o=orderby {t.setOrder(o);})?) {$qIn = t;}
;

hiveQuery returns [QueryInputSpec hQSpec]: 
 hq=HIVEQUERY {$hQSpec = new HiveQuerySpec($hq.text);}
; 

hiveTable returns [QueryInputSpec hTSpec]:
  ^(HIVETBL d=Identifier t=Identifier) {$hTSpec = new HiveTableSpec($d.text, $t.text);} |
  ^(HIVETBL t=Identifier) {$hTSpec = new HiveTableSpec(null, $t.text);}
;

tblfunc returns [QueryInputSpec qIn]
@init
{
  TableFuncSpec tblFn = new TableFuncSpec();
}
 :
  ^(TBLFUNCTION i=Identifier t=tableSpec (e=expression {tblFn.addArg(e);})*) {tblFn.setName($i.text); tblFn.setInput(t); $qIn = tblFn; }
;

hdfsFile returns [HdfsLocationSpec hLoc]
@init {
  $hLoc = new HdfsLocationSpec();
}
:
 ^(HDFSLOCATION namevalue[hLoc]*)
;

where[QuerySpec qs] : 
 ^(WHERE e=expression) {$qs.setWhereExpr(e);}
;

outputClause returns [QueryOutputSpec qOut]
@init {
  $qOut = new QueryOutputSpec();
}:
  ^(OUTPUTSPEC p=StringLiteral outputSerDe[qOut]? loadClause[qOut]?) {$qOut.setPath($p.text);}
;

outputSerDe[QueryOutputSpec qOut] :
  ^(SERDE sd=StringLiteral outputFormatOrWriter[qOut] outputSerDePropeties[qOut]?) {$qOut.setSerDeClass($sd.text);}
;

outputSerDePropeties[INameValueList properties]:
  ^(SERDEPROPERTIES namevalue[properties]*)
;

outputFormatOrWriter[QueryOutputSpec qOut] :
  ^(RECORDWRITER rw=StringLiteral) {$qOut.setRecordWriterClass($rw.text);} |
  ^(FORMAT of=StringLiteral) {$qOut.setOutputFormatClass($of.text);}
;

loadClause[QueryOutputSpec qOut]:
  ^(LOADSPEC ht=Identifier hp=StringLiteral? ow=OVERWRITE?) {
    $qOut.setHiveTable($ht.text);
    $qOut.setPartitionClause($hp.text);
    $qOut.setOverwriteHiveTable(true);
  }
;

window_function returns [WindowFunctionSpec wFn]
@init {
  $wFn = new WindowFunctionSpec();
}
  : 
  ^(WDW_FUNCTIONSTAR functionName ws=window_specification?) {$wFn.setName($functionName.text); $wFn.setWindowSpec(ws); $wFn.setStar(true);} |
  ^(WDW_FUNCTION functionName ((e=expression{$wFn.addArg(e);})+)? ws=window_specification?) {$wFn.setName($functionName.text); $wFn.setWindowSpec(ws); } |
  ^(WDW_FUNCTIONDIST functionName ((e=expression{$wFn.addArg(e);})+)? ws=window_specification?) {$wFn.setName($functionName.text); $wFn.setWindowSpec(ws); $wFn.setDistinct(true); }
;  

window_clause[QuerySpec qs] :
  ^(WINDOW window_defn[qs]+)
;  

window_defn[QuerySpec qs] :
  ^(WINDOWDEF i=Identifier ws=window_specification) { $qs.addWindowSpec($i.text, ws);}
;  

window_specification returns [WindowSpec ws]:
  ^(WINDOWSPEC i=Identifier? p=partitionby? o=orderby? wf=window_frame?) { $ws = new WindowSpec(i != null ? $i.text : null, p, o, wf);}
;

orderby returns [OrderSpec os]
@init {
  $os = new OrderSpec();
}
 :
 ^(ORDER (o=ordercolumn {$os.addColumn(o);})+)
;

ordercolumn returns [OrderColumnSpec ocs] :
 ^(ORDERCOLUMN cr=columnReference o=ASC) {$ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.ASC); }|
 ^(ORDERCOLUMN cr=columnReference DESC) {$ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.DESC); }|
 ^(ORDERCOLUMN cr=columnReference) {$ocs = new OrderColumnSpec(cr.getTableName(), cr.getColumnName(), Order.ASC); }
;

partitionby returns [PartitionSpec ps] 
@init {
  $ps = new PartitionSpec();
}
  :
 ^(PARTITION (cr=columnReference {$ps.addColumn(cr);})+)
;

window_frame returns [WindowFrameSpec wf]:
 w=window_range_expression {$wf = w;} |
 w=window_value_expression {$wf = w;}
;

window_range_expression returns [WindowFrameSpec wf] :
 ^(WINDOWRANGE s=rowsboundary e=rowsboundary) {$wf = new WindowFrameSpec(s,e);}
;

rowsboundary returns [BoundarySpec bs] 
@init {
  RangeBoundarySpec rbs = new RangeBoundarySpec();
  $bs = rbs;
}
  :
  ^(PRECEDING UNBOUNDED) {rbs.setDirection(Direction.PRECEDING); rbs.setAmt(BoundarySpec.UNBOUNDED_AMOUNT);} | 
  ^(FOLLOWING UNBOUNDED) {rbs.setDirection(Direction.FOLLOWING); rbs.setAmt(BoundarySpec.UNBOUNDED_AMOUNT);} |
  CURRENT {$bs = new CurrentRowSpec();} |
  ^(PRECEDING n=Number) {rbs.setDirection(Direction.PRECEDING); rbs.setAmt(Integer.parseInt($n.text));} |
  ^(FOLLOWING n=Number) {rbs.setDirection(Direction.FOLLOWING); rbs.setAmt(Integer.parseInt($n.text));}
;

window_value_expression returns [WindowFrameSpec wf] :
 ^(WINDOWVALUES s=valuesboundary e=valuesboundary) {$wf = new WindowFrameSpec(s,e);}
;

valuesboundary returns [BoundarySpec bs] :
  ^(PRECEDING UNBOUNDED) {$bs = new ValueBoundarySpec(Direction.PRECEDING, null, BoundarySpec.UNBOUNDED_AMOUNT);} | 
  ^(FOLLOWING UNBOUNDED) {$bs = new ValueBoundarySpec(Direction.FOLLOWING, null, BoundarySpec.UNBOUNDED_AMOUNT);} |
  CURRENT {$bs = new CurrentRowSpec();} |
  ^(LESS e=expression n=Number) {$bs = new ValueBoundarySpec(Direction.PRECEDING, e, Integer.parseInt($n.text));} |
  ^(MORE e=expression n=Number) {$bs = new ValueBoundarySpec(Direction.PRECEDING, e, Integer.parseInt($n.text));}
;

columnReference returns [ColumnSpec cs]:
  ^(COLUMNREF t=Identifier c=Identifier) {$cs = new ColumnSpec($t.text,$c.text);} |
  ^(COLUMNREF t=Identifier) {$cs = new ColumnSpec(null,$t.text);}
;  


tableOrColumn returns [CommonTree tr]
: 
  ^(tc=TABLEORCOL Identifier) {$tr=$tc;}
; 


function returns [CommonTree tr]
: 
  ^(fs=FUNCTIONSTAR functionName)  {$tr=$fs;} |
  ^(f=FUNCTION functionName (expression+)?) {$tr=$f;} |
  ^(fd=FUNCTIONDIST functionName (expression+)?) {$tr=$fd;}
;                  

functionName 
  : 
  Identifier | IF | ARRAY | MAP | STRUCT | UNION
  ;   

castExpr returns [CommonTree tr] :  
  ^(f=FUNCTION primitiveType expression) {$tr = $f;}
;

caseExpr returns [CommonTree tr] :
  ^(f=FUNCTION CASE expression*) {$tr = $f;}
 ;

whenExpr  returns [CommonTree tr] :
  ^(f=FUNCTION WHEN expression*) {$tr = $f;}
;

constant returns [CommonTree tr] :
  n=Number { $tr = $n; }
  | s=StringLiteral { $tr = $s; }
  | sls=stringLiteralSequence { $tr = sls; }
  | bl=BigintLiteral { $tr = $bl; }
  | sl=SmallintLiteral { $tr = $sl; }
  | tl=TinyintLiteral { $tr = $tl; }
  | csl=charSetStringLiteral { $tr = csl; }
  | bv=booleanValue { $tr = bv; }
;

stringLiteralSequence returns [CommonTree tr] :
    ^(s=STRINGLITERALSEQUENCE StringLiteral StringLiteral+) { $tr = $s; }
;

charSetStringLiteral returns [CommonTree tr] :
    ^(c=CHARSETLITERAL CharSetName CharSetLiteral) { $tr = $c; }
;

expressions :
  expression*
;

negatableOperator returns [CommonTree tr] :
  l=LIKE {$tr=$l;} | 
  rl=RLIKE {$tr=$rl;} | 
  rexp=REGEXP {$tr=$rexp;} 
;

compareOperator returns [CommonTree tr] :
  n=negatableOperator {$tr=n;} | 
  e=EQUAL {$tr=$e;} | 
  en=EQUAL_NS {$tr=$en;} | 
  nte=NOTEQUAL {$tr=$nte;} | 
  lte=LESSTHANOREQUALTO {$tr=$lte;} | 
  lt=LESSTHAN {$tr=$lt;} | 
  gte=GREATERTHANOREQUALTO {$tr=$gte;} | 
  gt=GREATERTHAN {$tr=$gt;} 
;

nullCondition :
  NULL |
  NOTNULL
;

expression returns [CommonTree tr] :
  ^(or=OR expression expression) {$tr=$or;}|
  ^(ad=AND expression expression) {$tr=$ad;}|
  ^(nt=NOT expression) {$tr=$nt;}|
  ^(nOp=negatableOperator FALSE expression  expression ) {$tr=nOp;} |
  ^(cOp=compareOperator TRUE expression expression) {$tr=cOp;} |
  ^(fInF=FUNCTION IN FALSE expression expressions) {$tr=$fInF;} |
  ^(fInT=FUNCTION IN TRUE expression expressions) {$tr=$fInT;} |
  ^(fBtF=FUNCTION BETWEEN FALSE expression expression expression) {$tr=$fBtF;} |
  ^(fBtT=FUNCTION BETWEEN TRUE expression expression expression) {$tr=$fBtT;} |
  ^(bitOr=BITWISEOR expression expression) {$tr=$bitOr;} |
  ^(amp=AMPERSAND expression expression) {$tr=$amp;} |
  ^(plus=PLUS expression expression?) {$tr=$plus;} |
  ^(minus=MINUS expression expression?) {$tr=$minus;} |
  ^(star=STAR expression expression) {$tr=$star;} |
  ^(divide=DIVIDE expression expression) {$tr=$divide;} |
  ^(mod=MOD expression expression) {$tr=$mod;} |
  ^(div=DIV expression expression ) {$tr=$div;} |
  ^(bitxor=BITWISEXOR expression expression) {$tr=$bitxor;} |
  ^(fnNull=FUNCTION nullCondition expression) {$tr=$fnNull;} |
/*  ^(PLUS expression ) |
  ^(MINUS expression ) |*/
  ^(tilde=TILDE expression ) {$tr=$tilde;} |
  ^(arry=LSQUARE expression expression) {$tr=$arry;} |
  ^(dot=DOT expression Identifier ) {$tr=$dot;} |
  nl=NULL {$tr=$nl;}| 
  c=constant {$tr = c;} | 
  f=function {$tr = f;} | 
  cs=castExpr {$tr = cs;} | 
  cse=caseExpr {$tr = cse;} | 
  whn=whenExpr {$tr = whn;} | 
  tc=tableOrColumn {$tr=tc;}
;

booleanValue returns [CommonTree tr]
    :
    t=TRUE { $tr = $t; } | 
    f=FALSE { $tr = $f; }
;

primitiveType : 
      TINYINT       
    | SMALLINT
    | INT
    | BIGINT
    | BOOLEAN
    | FLOAT
    | DOUBLE
    | DATE
    | DATETIME
    | TIMESTAMP
    | STRING
    | BINARY
;

namevalue[INameValueList properties] :
 ^(PARAM n=Identifier v=StringLiteral)  {properties.add($n.text, $v.text);}|
 ^(PARAM n=StringLiteral v=StringLiteral) {properties.add($n.text, $v.text);}
;