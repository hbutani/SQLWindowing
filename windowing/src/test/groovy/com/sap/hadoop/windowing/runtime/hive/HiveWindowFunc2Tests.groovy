package com.sap.hadoop.windowing.runtime.hive

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

class HiveWindowFunc2Tests extends MRBaseTest
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
		eCtx.wIn = IOUtils.createTableWindowingInput(null, "sorted_lineitem2", wshell.cfg)
	}
	
	@Test
	void testRank()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("rank(l_quantity)")
		]
		AggOp agg = aggregate("testRank", exprs, false)
		def out = agg.output[0].collect { it.get() }
		assert out == [1, 1, 3, 3, 5, 5, 5, 8, 8, 10, 10, 10, 13, 13, 15, 16, 16, 18, 19, 20, 20, 22, 22, 22, 25, 26, 27, 27, 29, 29, 31, 32, 32, 34, 34, 36, 36, 36, 39, 39, 41, 41, 43, 43, 43, 43, 47, 47, 49, 49, 49, 49, 49, 49, 55, 56, 56, 56, 59, 59, 61, 61, 61, 61, 61, 66, 67, 67, 67, 70, 71, 72, 72, 72, 75, 75, 77, 77, 79, 79, 81, 81, 81, 84, 84, 86, 86, 88, 88, 88, 88, 92, 92, 94, 94, 94, 94, 98, 99, 100]
	}
	
	@Test
	void testDenseRank()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("denserank(l_quantity)")
		]
		AggOp agg = aggregate("testDenseRank", exprs, false)
		def out = agg.output[0].collect { it.get() }
		assert out == [1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 8, 8, 9, 10, 11, 11, 12, 12, 12, 13, 14, 15, 15, 16, 16, 17, 18, 18, 19, 19, 20, 20, 20, 21, 21, 22, 22, 23, 23, 23, 23, 24, 24, 25, 25, 25, 25, 25, 25, 26, 27, 27, 27, 28, 28, 29, 29, 29, 29, 29, 30, 31, 31, 31, 32, 33, 34, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41, 41, 41, 41, 42, 42, 43, 43, 43, 43, 44, 45, 46]
	}
	
	public static AggOp aggregate(String testName, ArrayList<WindowFunctionSpec> funcSpecs, boolean printRes)
	{
		return EvalUtils.aggregate(testName, eCtx, funcSpecs, printRes)
	}
	
	public void select(String testName, ArrayList<ASTNode> exprs)
	{
		EvalUtils.select(testName, eCtx, exprs);
	}

}
