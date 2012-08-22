package com.sap.hadoop.windowing.runtime.hive

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.SelectDesc;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.exec.FunctionRegistry;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.ql.parse.UnparseTranslator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.Writable;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.parser.ParserTest2;
import com.sap.hadoop.windowing.parser.QSpecBuilder2;
import com.sap.hadoop.windowing.parser.Windowing2Lexer;
import com.sap.hadoop.windowing.parser.Windowing2Parser;
import com.sap.hadoop.windowing.query2.WindowingTypeCheckProcFactory;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

class HiveAggTest  extends MRBaseTest
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
		ArrayList<WindowFunctionSpec> exprs = [
			build("sum(L_EXTENDEDPRICE)"),
			build("min(L_EXTENDEDPRICE)"),
			build("max(L_EXTENDEDPRICE)"),
			build("avg(L_EXTENDEDPRICE)"),
		]
		aggregate("test1", exprs)
	}
	
	@Test
	void testCount()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("count(*)"),
			build("count(distinct l_extendedprice)"),
			build("count(distinct l_extendedprice, l_shipdate)"),
			build("count(l_shipdate)")
		]
		aggregate("testcount", exprs)
	}
	
	@Test
	void testStat()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("stddev(l_extendedprice)"),
			build("variance(l_extendedprice)"),
			build("corr(l_discount, l_extendedprice)"),
			build("covar_pop(l_discount, l_extendedprice)")
		]
		aggregate("testStat", exprs)
	}
	
	@Test
	void testDistribution()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("histogram_numeric(l_extendedprice, 5)"),
			build("percentile(l_linenumber, 0.5)")
		]
		aggregate("testDistribution", exprs)
	}
	
	@Test
	void testRank()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("rownumber()")
		]
		aggregate("testDistribution", exprs)
	}

	public static void aggregate(String testName, ArrayList<WindowFunctionSpec> funcSpecs)
	{
		EvalUtils.aggregate(testName, eCtx, funcSpecs)
	}

	public static WindowFunctionSpec build(String expr) throws WindowingException
	{
		return ParseUtils.buildWindowFunction(expr);
	}

}

