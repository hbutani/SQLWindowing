package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.conf.Configuration;
import org.junit.Test;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.io.WindowingInput;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.hive.conf.HiveConf;

import org.apache.hadoop.hive.ql.exec.ColumnInfo;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.exec.FilterOperator.Counter;
import org.apache.hadoop.hive.ql.io.IOContext;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.BaseSemanticAnalyzer;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.TypeCheckProcFactory;
import org.apache.hadoop.hive.ql.plan.ExprNodeColumnDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeConstantDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.ql.plan.SelectDesc

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
	
	static SelectDesc select1(RowResolver rr)
	{
		ArrayList<ExprNodeDesc> cols = [];
		ArrayList<String> aliases = ["p_name", "p_size"]
		
		aliases.each { name ->
			cols << column(name, rr)
		}
		
		cols << function("struct", cols[0], cols[1])
		aliases << "s1"
		
		cols << function("substr", column("p_mfgr", rr), constant(1), constant(7))
		aliases << "s2"
		
		//cols << function("map_keys", function("struct", column("p_name", rr), column("p_size", rr)))
		//aliases << "m"
		
		return new SelectDesc(cols, aliases, false)
	}
	

	static ExprNodeDesc filter1(RowResolver rr)
	{
		ExprNodeColumnDesc pSize = column("p_size", rr)
		ExprNodeConstantDesc fifty = constant(45)
		ExprNodeDesc gt = function(">", pSize, fifty)
		
		ExprNodeDesc like = function("like", column("p_name", rr), constant('%indian%'))
		ExprNodeDesc and = function("and", gt, like)
		
		
		return and
	}
	
	
	static ExprNodeColumnDesc column(String name, RowResolver rr)
	{
		String cname = BaseSemanticAnalyzer.unescapeIdentifier(name);
		ColumnInfo colInfo = rr.get(null, cname);
		return new ExprNodeColumnDesc(colInfo.getType(), 
				colInfo.getInternalName(), 
				colInfo.getTabAlias(), 
				colInfo.getIsVirtualCol());
	}
	
	static ExprNodeConstantDesc constant(Object value)
	{
		return new ExprNodeConstantDesc(value)
	}
	
	static ExprNodeDesc function(String name, ExprNodeDesc... args)
	{
		return TypeCheckProcFactory.DefaultExprProcessor.getFuncExprNodeDesc(name, args)
	}
	
	static class SelectOp
	{
		ObjectInspector inOI
		protected transient ExprNodeEvaluator[] eval;
		transient Object[] output;
		ObjectInspector outOI
		
		protected void initialize(SelectDesc conf, ObjectInspector inOI) throws HiveException
		{
			this.inOI = inOI
			ArrayList<ExprNodeDesc> colList = conf.getColList();
			eval = new ExprNodeEvaluator[colList.size()];
			for (int i = 0; i < colList.size(); i++) {
			  assert (colList.get(i) != null);
			  eval[i] = ExprNodeEvaluatorFactory.get(colList.get(i));
			}
		
			output = new Object[eval.length];
			
			outOI = initEvaluatorsAndReturnStruct(eval, conf
				.getOutputColumnNames(), inOI);
		}
		
		protected static StructObjectInspector initEvaluatorsAndReturnStruct(
			ExprNodeEvaluator[] evals, List<String> outputColName,
			ObjectInspector rowInspector) throws HiveException {
		  ObjectInspector[] fieldObjectInspectors = initEvaluators(evals,
			  rowInspector);
		  return ObjectInspectorFactory.getStandardStructObjectInspector(
			  outputColName, Arrays.asList(fieldObjectInspectors));
		}
			
		protected static ObjectInspector[] initEvaluators(ExprNodeEvaluator[] evals,
			ObjectInspector rowInspector) throws HiveException {
		  ObjectInspector[] result = new ObjectInspector[evals.length];
		  for (int i = 0; i < evals.length; i++) {
			result[i] = evals[i].initialize(rowInspector);
		  }
		  return result;
		}
			
		public void process(Object row) throws HiveException
		{
			for (int i = 0; i < eval.length; i++) {
				try 
				{
				  output[i] = eval[i].evaluate(row);
				} 
				catch (HiveException e) {
				  throw e;
				} 
				catch (RuntimeException e) {
				  throw new HiveException("Error evaluating "
					  + conf.getColList().get(i).getExprString(), e);
				}
			}
		}
	}
	
	static class FilterOp
	{
		ExprNodeEvaluator conditionEvaluator;
		PrimitiveObjectInspector outOI
		Boolean output
		
		protected void initialize(ExprNodeDesc predicate, ObjectInspector inOI) throws HiveException
		{
			try
			{
			  conditionEvaluator = ExprNodeEvaluatorFactory.get(predicate);
			  outOI = (PrimitiveObjectInspector) conditionEvaluator.initialize(inOI);
			}
			catch (Throwable e)
			{
			  throw new HiveException(e);
			}
		}
		
		public void process(Object row) throws HiveException
		{
			Object condition = conditionEvaluator.evaluate(row);
			output = (Boolean) outOI.getPrimitiveJavaObject(condition);
		}
	}

	
}
