package com.sap.hadoop.windowing.runtime.hive

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.SelectDesc;

import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;
import com.sap.hadoop.windowing.query2.translate.WindowingTypeCheckProcFactory;

class EvalUtils
{
	public static void select(String testName, EvalContext eCtx, ArrayList<ASTNode> exprs)
	{
		println "$testName:\n"
		HashMap<Node, Object> map;
		ArrayList<ExprNodeDesc> cols = []
		exprs.each { e ->
			map = WindowingTypeCheckProcFactory.genExprNode(e, eCtx.typeChkCtx)
			cols << map.get(e)
		}
		
		
		ArrayList<String> aliases = []
		0..<exprs.size().each { i ->
			aliases << "c${i}".toString()
		}
		
		SelectDesc selectDesc = new SelectDesc(cols, aliases, false)
		SelectOp select = new SelectOp()
		select.initialize(selectDesc, eCtx.inoI)
				
		while( eCtx.wIn.next(eCtx.w) != -1)
		{
			Object r = eCtx.deS.deserialize(eCtx.w)
			select.process(r)
			println select.output
		}

	}
	
	public static AggOp aggregate(String testName, EvalContext eCtx, ArrayList<WindowFunctionSpec> funcSpecs, boolean printRes = true)
	{
		println "$testName:\n"
		
		ArrayList<String> aliases = []
		0..<funcSpecs.size().each { i ->
			aliases << "c${i}".toString()
		}
		AggDesc aggDesc = new AggDesc(funcSpecs : funcSpecs, columnNames : aliases)
		AggOp agg = new AggOp(eCtx : eCtx)
		agg.initialize(aggDesc, eCtx.inoI)
				
		agg.startAggregation()
		while( eCtx.wIn.next(eCtx.w) != -1)
		{
			Object r = eCtx.deS.deserialize(eCtx.w)
			agg.process(r)
		}
		agg.finishAggregation()
		if (printRes) println agg.output
		return agg;
	}

}
