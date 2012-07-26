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
 ^(QUERY tableSpec select where? window_clause? outputClause?)
;

select  :
  ^(SELECT selectColumn+)
;

selectColumn:
  ^(SELECTCOLUMN expression Identifier?) |
  ^(SELECTCOLUMN window_function Identifier)
;

tableSpec :
 ^(INPUT tblfunc partitionby? orderby?) |
 ^(INPUT hiveQuery partitionby? orderby?) |
 ^(INPUT hdfsFile partitionby? orderby?) |
 ^(INPUT hiveTable partitionby? orderby?)
;

hiveQuery : 
 HIVEQUERY
; 

hiveTable :
  ^(HIVETBL Identifier Identifier) |
  ^(HIVETBL Identifier)
;

tblfunc :
  ^(TBLFUNCTION Identifier tableSpec expression*)
;

hdfsFile returns [HdfsLocationSpec hLoc]
@init {
  $hLoc = new HdfsLocationSpec();
}
:
 ^(HDFSLOCATION namevalue[hLoc]*)
;

where : 
 ^(WHERE expression)
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
  ^(WDW_FUNCTIONSTAR functionName window_specification?) {$wFn.setName($functionName.text); } |
  ^(WDW_FUNCTION functionName (expression+)? window_specification?) {$wFn.setName($functionName.text); } |
  ^(WDW_FUNCTIONDIST functionName ((expression{$wFn.addArg(expression);})+)? window_specification?) {$wFn.setName($functionName.text); }
;  

window_clause :
  ^(WINDOW window_defn+)
;  

window_defn :
  ^(WINDOWDEF Identifier window_specification)
;  

window_specification :
  ^(WINDOWSPEC Identifier? partitionby? orderby? window_frame?)
;

orderby :
 ^(ORDER ordercolumn+)
;

ordercolumn :
 ^(ORDERCOLUMN columnReference ASC) |
 ^(ORDERCOLUMN columnReference DESC) |
 ^(ORDERCOLUMN columnReference)
;

partitionby : 
 ^(PARTITION columnReference+)
;

window_frame :
 window_range_expression |
 window_value_expression
;

window_range_expression :
 ^(WINDOWRANGE rowsboundary rowsboundary)
;

rowsboundary :
  ^(PRECEDING UNBOUNDED) | 
  ^(FOLLOWING UNBOUNDED)
  CURRENT |
  ^(PRECEDING Number) |
  ^(FOLLOWING Number)
;

window_value_expression :
 ^(WINDOWVALUES valuesboundary valuesboundary)
;

valuesboundary :
  ^(PRECEDING UNBOUNDED) | 
  ^(FOLLOWING UNBOUNDED)
  CURRENT |
  ^(LESS expression Number) |
  ^(MORE expression Number)
;

columnReference :
  ^(COLUMNREF Identifier Identifier)
  ^(COLUMNREF Identifier)
;  


tableOrColumn 
: 
  ^(TABLEORCOL Identifier)
; 


function 
: 
  ^(FUNCTIONSTAR functionName)  |
  ^(FUNCTION functionName functionName (expression+)?) |
  ^(FUNCTIONDIST functionName (expression+)?)
;                  

functionName 
  : 
  Identifier | IF | ARRAY | MAP | STRUCT | UNION
  ;   

castExpr :  
  ^(FUNCTION primitiveType expression)
;

caseExpr :
  ^(FUNCTION CASE expression*)
 ;

whenExpr  :
  ^(FUNCTION WHEN expression*)
;

constant :
  Number
  | StringLiteral
  | stringLiteralSequence
  | BigintLiteral
  | SmallintLiteral
  | TinyintLiteral
  | charSetStringLiteral
  | booleanValue
;

stringLiteralSequence :
    ^(STRINGLITERALSEQUENCE StringLiteral StringLiteral+)
;

charSetStringLiteral :
    ^(CHARSETLITERAL CharSetName CharSetLiteral)
;

expressions :
  expression*
;

negatableOperator :
  LIKE | RLIKE | REGEXP
;

compareOperator :
  negatableOperator  | EQUAL | EQUAL_NS | NOTEQUAL | LESSTHANOREQUALTO | LESSTHAN | 
  GREATERTHANOREQUALTO | GREATERTHAN
;

nullCondition :
  NULL |
  NOTNULL
;

expression :
  ^(OR expression expression) |
  ^(AND expression expression) |
  ^(NOT expression) |
  ^(negatableOperator FALSE expression  expression ) |
  ^(compareOperator TRUE expression expression) |
  ^(FUNCTION IN FALSE expression expressions)|
  ^(FUNCTION IN TRUE expression expressions) |
  ^(FUNCTION BETWEEN FALSE expression expression expression) |
  ^(FUNCTION BETWEEN TRUE expression expression expression) |
  ^(BITWISEOR expression expression) |
  ^(AMPERSAND expression expression) |
  ^(PLUS expression expression?) |
  ^(MINUS expression expression?) |
  ^(STAR expression expression) |
  ^(DIVIDE expression expression) |
  ^(MOD expression expression) |
  ^(DIV expression expression ) |
  ^(BITWISEXOR expression expression) |
  ^(FUNCTION nullCondition expression) |
/*  ^(PLUS expression ) |
  ^(MINUS expression ) |*/
  ^(TILDE expression ) |
  ^(LSQUARE expression expression) |
  ^(DOT expression Identifier ) |
  NULL | 
  constant | 
  function | 
  castExpr | 
  caseExpr | 
  whenExpr | 
  tableOrColumn
;

booleanValue
    :
    TRUE | FALSE
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