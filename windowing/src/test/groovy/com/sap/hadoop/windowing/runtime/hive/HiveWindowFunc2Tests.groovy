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
	
	@Test
	void testPercentRank()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("percentrank(l_quantity)")
		]
		AggOp agg = aggregate("testPercentRank", exprs, false)
		def out = agg.output[0].collect { it.get() }
//		println out
		assert out == [0.0, 0.0, 0.020202020202020204, 0.020202020202020204, 0.04040404040404041, 0.04040404040404041, 0.04040404040404041, 0.0707070707070707, 0.0707070707070707, 0.09090909090909091, 0.09090909090909091, 0.09090909090909091, 0.12121212121212122, 0.12121212121212122, 0.1414141414141414, 0.15151515151515152, 0.15151515151515152, 0.1717171717171717, 0.18181818181818182, 0.1919191919191919, 0.1919191919191919, 0.21212121212121213, 0.21212121212121213, 0.21212121212121213, 0.24242424242424243, 0.25252525252525254, 0.26262626262626265, 0.26262626262626265, 0.2828282828282828, 0.2828282828282828, 0.30303030303030304, 0.31313131313131315, 0.31313131313131315, 0.3333333333333333, 0.3333333333333333, 0.35353535353535354, 0.35353535353535354, 0.35353535353535354, 0.3838383838383838, 0.3838383838383838, 0.40404040404040403, 0.40404040404040403, 0.42424242424242425, 0.42424242424242425, 0.42424242424242425, 0.42424242424242425, 0.46464646464646464, 0.46464646464646464, 0.48484848484848486, 0.48484848484848486, 0.48484848484848486, 0.48484848484848486, 0.48484848484848486, 0.48484848484848486, 0.5454545454545454, 0.5555555555555556, 0.5555555555555556, 0.5555555555555556, 0.5858585858585859, 0.5858585858585859, 0.6060606060606061, 0.6060606060606061, 0.6060606060606061, 0.6060606060606061, 0.6060606060606061, 0.6565656565656566, 0.6666666666666666, 0.6666666666666666, 0.6666666666666666, 0.696969696969697, 0.7070707070707071, 0.7171717171717171, 0.7171717171717171, 0.7171717171717171, 0.7474747474747475, 0.7474747474747475, 0.7676767676767676, 0.7676767676767676, 0.7878787878787878, 0.7878787878787878, 0.8080808080808081, 0.8080808080808081, 0.8080808080808081, 0.8383838383838383, 0.8383838383838383, 0.8585858585858586, 0.8585858585858586, 0.8787878787878788, 0.8787878787878788, 0.8787878787878788, 0.8787878787878788, 0.9191919191919192, 0.9191919191919192, 0.9393939393939394, 0.9393939393939394, 0.9393939393939394, 0.9393939393939394, 0.9797979797979798, 0.98989898989899, 1.0]
	}
	
	@Test
	void testCumeDist()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("cumedist(l_quantity)")
		]
		AggOp agg = aggregate("testCumeDist", exprs, false)
		def out = agg.output[0].collect { it.get() }
//		println out
		assert out == [0.01, 0.01, 0.03, 0.03, 0.05, 0.05, 0.05, 0.08, 0.08, 0.1, 0.1, 0.1, 0.13, 0.13, 0.15, 0.16, 0.16, 0.18, 0.19, 0.2, 0.2, 0.22, 0.22, 0.22, 0.25, 0.26, 0.27, 0.27, 0.29, 0.29, 0.31, 0.32, 0.32, 0.34, 0.34, 0.36, 0.36, 0.36, 0.39, 0.39, 0.41, 0.41, 0.43, 0.43, 0.43, 0.43, 0.47, 0.47, 0.49, 0.49, 0.49, 0.49, 0.49, 0.49, 0.55, 0.56, 0.56, 0.56, 0.59, 0.59, 0.61, 0.61, 0.61, 0.61, 0.61, 0.66, 0.67, 0.67, 0.67, 0.7, 0.71, 0.72, 0.72, 0.72, 0.75, 0.75, 0.77, 0.77, 0.79, 0.79, 0.81, 0.81, 0.81, 0.84, 0.84, 0.86, 0.86, 0.88, 0.88, 0.88, 0.88, 0.92, 0.92, 0.94, 0.94, 0.94, 0.94, 0.98, 0.99, 1.0]
	}

	@Test
	void testNTile5()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("ntile(5)")
		]
		AggOp agg = aggregate("testNTile", exprs, false)
		def out = agg.output[0].collect { it.get() }
//		println out
		assert out == [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
	}

	@Test
	void testNTile3()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("ntile(3)")
		]
		AggOp agg = aggregate("testNTile", exprs, false)
		def out = agg.output[0].collect { it.get() }
//		println out
		assert out == [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]
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
