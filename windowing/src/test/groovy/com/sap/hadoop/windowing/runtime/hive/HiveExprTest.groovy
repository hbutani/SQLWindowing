package com.sap.hadoop.windowing.runtime.hive

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.query2.WindowingTypeCheckProcFactory;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.io.WindowingInput;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.hive.conf.HiveConf;

import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.ql.lib.DefaultGraphWalker;
import org.apache.hadoop.hive.ql.lib.DefaultRuleDispatcher;
import org.apache.hadoop.hive.ql.lib.Dispatcher;
import org.apache.hadoop.hive.ql.lib.GraphWalker;
import org.apache.hadoop.hive.ql.lib.Node;
import org.apache.hadoop.hive.ql.lib.NodeProcessor;
import org.apache.hadoop.hive.ql.lib.Rule;
import org.apache.hadoop.hive.ql.lib.RuleRegExp;
import org.apache.hadoop.hive.ql.parse.RowResolver;

import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.WindowingException;

import com.sap.hadoop.windowing.parser.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.Token;

import org.apache.hadoop.hive.ql.parse.ASTNode;

import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.parse.TypeCheckProcFactory;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.ql.parse.UnparseTranslator;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;

import org.apache.hadoop.hive.ql.plan.SelectDesc

class HiveExprTest extends MRBaseTest
{

	static EvalContext eCtx;
	
	@BeforeClass
	public static void setupClass()
	{
		MRBaseTest.setupClass();
		eCtx = new EvalContext(wshell.cfg)
	}
	
	@Before
	public void setup()
	{
		eCtx.wIn = IOUtils.createTableWindowingInput(null, "lineitem", wshell.cfg)
	}
	
	@Test
	void test1()
	{
		ArrayList<ASTNode> exprs = [
			build("L_COMMENT")
		]
		select("test1", exprs)
	}
	
	@Test
	void testStringExprs()
	{
		ArrayList<ASTNode> exprs = [
			build("substr(L_COMMENT, 1,5)"),
			build("concat(substr(L_COMMENT, 1,5), '--')"),
			build("lpad(concat(substr(L_COMMENT, 1,5), '--'),10, ' ')"),
			build("lpad(concat(substr(L_COMMENT, 1,5), '--'),10, ' ') like '%e%')"),
			build("upper(lpad(concat(substr(L_COMMENT, 1,5), '--'),10, ' '))")
		]
		
		select("testStringExprs", exprs)
	}
	
	@Test
	void testCompareExprs()
	{
		ArrayList<ASTNode> exprs = [
			build("L_COMMENT"),
			build("lpad(concat(substr(L_COMMENT, 1,5), '--'),10, ' ') like '%e%')"),
			build("L_EXTENDEDPRICE"),
			build("L_EXTENDEDPRICE > 10000"),
			build("not L_EXTENDEDPRICE > 10000"),
			build("L_EXTENDEDPRICE between 10000 and 30000"),
			build("regexp_replace(l_comment,'e','+')"),
			build("if(l_comment regexp '.*e.*', regexp_replace(l_comment,'e','+'), l_comment)")
		]
		
		select("testCompareExprs", exprs)
	}
	
	@Test
	void testDateExprs()
	{
		ArrayList<ASTNode> exprs = [
			build("l_shipdate"),
			build("day(l_shipdate)"),
			build("month(l_shipdate)"),
			build("year(l_shipdate)"),
			build("weekofyear(l_shipdate)"),
			build("unix_timestamp()"),
			build("date_add(l_shipdate, 2)")
		]
		
		select("testDateExprs", exprs)
	}
	
	@Test
	void testLogicalExprs()
	{
		ArrayList<ASTNode> exprs = [
			build("L_COMMENT"),
			build("L_EXTENDEDPRICE"),
			build("L_EXTENDEDPRICE > 10000 and L_EXTENDEDPRICE < 30000"),
//			build("L_EXTENDEDPRICE between 10000 and 30000"),
			build("l_comment regexp '.*y.*'"),
			build("(L_EXTENDEDPRICE > 10000 and L_EXTENDEDPRICE < 30000) or (l_comment regexp '.*y.*')")
		]
		println exprs[2].toStringTree()
		
		select("testDateExprs", exprs)
	}
	
	@Test
	void testArithmeticExprs()
	{
		ArrayList<ASTNode> exprs = [
			build("L_COMMENT"),
			build("l_quantity"),
			build("l_quantity + 5 - 10 - 5 + 10.0"),
			build("(l_quantity + 5 - 10 - 5 + 10.0)*2 - l_quantity")
		]
		println exprs[2].toStringTree()
		
		select("testDateExprs", exprs)
	}
	
	public void select(String testName, ArrayList<ASTNode> exprs)
	{
		EvalUtils.select(testName, eCtx, exprs);
	}
	
	public static ASTNode build(String expr) throws WindowingException
	{
		return ParseUtils.buildExpression(expr);
	}
	
}
