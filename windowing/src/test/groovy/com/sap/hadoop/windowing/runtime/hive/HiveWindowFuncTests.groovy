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
	
	@Test
	void testPercentRank()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("percentrank(l_extendedprice)")
		]
		AggOp agg = aggregate("testPercentRank", exprs, false)
		def out = agg.output[0].collect { it.get() }
//		println out
		assert out == [0.0, 0.010101010101010102, 0.020202020202020204, 0.030303030303030304, 0.04040404040404041, 0.050505050505050504, 0.06060606060606061, 0.0707070707070707, 0.08080808080808081, 0.09090909090909091, 0.10101010101010101, 0.1111111111111111, 0.12121212121212122, 0.13131313131313133, 0.1414141414141414, 0.15151515151515152, 0.16161616161616163, 0.1717171717171717, 0.18181818181818182, 0.1919191919191919, 0.20202020202020202, 0.21212121212121213, 0.2222222222222222, 0.23232323232323232, 0.24242424242424243, 0.25252525252525254, 0.26262626262626265, 0.2727272727272727, 0.2828282828282828, 0.29292929292929293, 0.30303030303030304, 0.31313131313131315, 0.32323232323232326, 0.3333333333333333, 0.3434343434343434, 0.35353535353535354, 0.36363636363636365, 0.37373737373737376, 0.3838383838383838, 0.3939393939393939, 0.40404040404040403, 0.41414141414141414, 0.42424242424242425, 0.43434343434343436, 0.4444444444444444, 0.45454545454545453, 0.46464646464646464, 0.47474747474747475, 0.48484848484848486, 0.494949494949495, 0.5050505050505051, 0.5151515151515151, 0.5252525252525253, 0.5353535353535354, 0.5454545454545454, 0.5555555555555556, 0.5656565656565656, 0.5757575757575758, 0.5858585858585859, 0.5959595959595959, 0.6060606060606061, 0.6161616161616161, 0.6262626262626263, 0.6363636363636364, 0.6464646464646465, 0.6565656565656566, 0.6666666666666666, 0.6767676767676768, 0.6868686868686869, 0.696969696969697, 0.7070707070707071, 0.7171717171717171, 0.7272727272727273, 0.7373737373737373, 0.7474747474747475, 0.7575757575757576, 0.7676767676767676, 0.7777777777777778, 0.7878787878787878, 0.797979797979798, 0.8080808080808081, 0.8181818181818182, 0.8282828282828283, 0.8383838383838383, 0.8484848484848485, 0.8585858585858586, 0.8686868686868687, 0.8787878787878788, 0.8888888888888888, 0.898989898989899, 0.9090909090909091, 0.9191919191919192, 0.9292929292929293, 0.9393939393939394, 0.9494949494949495, 0.9595959595959596, 0.9696969696969697, 0.9797979797979798, 0.98989898989899, 1.0]
	}
	
	@Test
	void testCumeDist()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			HiveAggTest.build("cumedist(l_extendedprice)")
		]
		AggOp agg = aggregate("testCumeDist", exprs, false)
		def out = agg.output[0].collect { it.get() }
//		println out
		assert out == [0.01, 0.02, 0.03, 0.04, 0.05, 0.06, 0.07, 0.08, 0.09, 0.1, 0.11, 0.12, 0.13, 0.14, 0.15, 0.16, 0.17, 0.18, 0.19, 0.2, 0.21, 0.22, 0.23, 0.24, 0.25, 0.26, 0.27, 0.28, 0.29, 0.3, 0.31, 0.32, 0.33, 0.34, 0.35, 0.36, 0.37, 0.38, 0.39, 0.4, 0.41, 0.42, 0.43, 0.44, 0.45, 0.46, 0.47, 0.48, 0.49, 0.5, 0.51, 0.52, 0.53, 0.54, 0.55, 0.56, 0.57, 0.58, 0.59, 0.6, 0.61, 0.62, 0.63, 0.64, 0.65, 0.66, 0.67, 0.68, 0.69, 0.7, 0.71, 0.72, 0.73, 0.74, 0.75, 0.76, 0.77, 0.78, 0.79, 0.8, 0.81, 0.82, 0.83, 0.84, 0.85, 0.86, 0.87, 0.88, 0.89, 0.9, 0.91, 0.92, 0.93, 0.94, 0.95, 0.96, 0.97, 0.98, 0.99, 1.0]
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
