package com.sap.hadoop.windowing.query2.definition;

import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;

import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query2.QueryTranslationInfo;

public class QueryDef
{
	QuerySpec qSpec;
	transient QueryTranslationInfo qTranslationInfo;
	SelectDef selectList;
	QueryInputDef input;
	ExprNodeDesc whereExprNode;
}
