package com.sap.hadoop.windowing.runtime.hive

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

class HiveWindowFuncTests  extends MRBaseTest
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
		eCtx.wIn = IOUtils.createTableWindowingInput(null, "sorted_lineitem", wshell.cfg)
	}
	
	@Test
	void testRank()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("rank(l_extendedprice)")
		]
		AggOp agg = aggregate("testRank", exprs, false)
		def out = agg.output[0].collect { it.get() }
//		println out
		assert out == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
	}
	
	@Test
	void testDenseRank()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("denserank(l_extendedprice)")
		]
		AggOp agg = aggregate("testDenseRank", exprs, false)
		def out = agg.output[0].collect { it.get() }
//		println out
		assert out == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
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
