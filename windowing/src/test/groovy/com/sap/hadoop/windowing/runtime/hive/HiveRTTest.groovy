package com.sap.hadoop.windowing.runtime.hive

import org.apache.hadoop.conf.Configuration;
import org.junit.Test;


import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.SelectDesc
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.io.WindowingInput;

import static com.sap.hadoop.windowing.runtime.hive.ExprNodeBuilder.*;

class HiveRTTest extends MRBaseTest
{

	@Test
	void test1()
	{
		WindowingInput wIn = IOUtils.createTableWindowingInput(null, "part", wshell.cfg)
		Deserializer deS = wIn.getDeserializer()
		ObjectInspector inoI = deS.getObjectInspector()
		
		Writable w = wIn.createRow();
		
		RowResolver rr = HiveUtils.getRowResolver(null, "part", "part", wshell.cfg)
		
//		ExprNodeColumnDesc pNameExpr = column("p_name", rr);
//		ExprNodeEvaluator pNameEval = ExprNodeEvaluatorFactory.get(pNameExpr);
		
		SelectDesc selectDesc = select1(rr)
		SelectOp select = new SelectOp()
//		ObjectInspector outoI = pNameEval.initialize(inoI);
		select.initialize(selectDesc, inoI)
		
		ExprNodeDesc filterDesc = filter1(rr)
		FilterOp filter = new FilterOp()
		filter.initialize(filterDesc, inoI)
		
		
		while( wIn.next(w) != -1)
		{
			Object r = deS.deserialize(w)
//			println pNameEval.evaluate(r)
			filter.process(r)
			if ( filter.output)
			{
				select.process(r)
				println select.output
			}
		}
	}
	
}
