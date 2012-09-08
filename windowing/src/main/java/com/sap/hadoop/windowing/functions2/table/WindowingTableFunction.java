package com.sap.hadoop.windowing.functions2.table;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer;
import org.apache.hadoop.hive.serde2.objectinspector.ListObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;

import com.sap.hadoop.ds.SameList;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.functions2.FunctionRegistry.WindowFunctionInfo;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.SelectDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;
import com.sap.hadoop.windowing.query2.translate.WindowFunctionTranslation;
import com.sap.hadoop.windowing.runtime2.Partition;

public class WindowingTableFunction extends TableFunctionEvaluator
{
	@Override
	public void setupOI() throws WindowingException
	{
		ArrayList<WindowFunctionDef> wFnDefs = new ArrayList<WindowFunctionDef>();
		QueryDef qDef = getQueryDef();
		SelectDef select = qDef.getSelectList();
		ArrayList<WindowFunctionSpec> wFnSpecs = qDef.getSpec().getSelectList().getWindowFuncs();
		ArrayList<String> aliases = new ArrayList<String>();
		ArrayList<ObjectInspector> fnOIs = new ArrayList<ObjectInspector>();
		
		for(WindowFunctionSpec wFnS : wFnSpecs)
		{
				WindowFunctionDef wFnDef = WindowFunctionTranslation.translate(qDef, getTableDef(), wFnS);
				WindowFunctionInfo wFnInfo = FunctionRegistry.getWindowFunctionInfo(wFnS.getName());
				wFnDefs.add(wFnDef);
				aliases.add(wFnS.getAlias());
				if ( wFnInfo.isPivotResult())
				{
					ListObjectInspector lOI = (ListObjectInspector) wFnDef.getOI();
					fnOIs.add(lOI.getListElementObjectInspector());
				}
				else
				{
					fnOIs.add(wFnDef.getOI());
				}
		}
		select.setWindowFuncs(wFnDefs);
		
		OI = ObjectInspectorFactory.getStandardStructObjectInspector(aliases, fnOIs);
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Partition execute(Partition iPart) throws WindowingException
	{
		TableFuncDef tabDef = getTableDef();
		QueryDef qDef = getQueryDef();
		Partition outP = new Partition(getPartitionClass(), getPartitionMemSize(), tabDef.getSerde(), tabDef.getOI());
		ArrayList<WindowFunctionDef> wFns = qDef.getSelectList().getWindowFuncs();
		ArrayList<List<?>> oColumns = new ArrayList<List<?>>();
		
		try
		{
			for(WindowFunctionDef wFn : wFns)
			{
				GenericUDAFEvaluator fEval = wFn.getEvaluator();
				Object[] args = new Object[wFn.getArgs().size()];
				AggregationBuffer aggBuffer = fEval.getNewAggregationBuffer();
				for(Object row: iPart)
				{
					int i =0;
					for(ArgDef arg : wFn.getArgs())
					{
						args[i++] = arg.getExprEvaluator().evaluate(row);
					}
					fEval.aggregate(aggBuffer, args);
				}
				Object out = fEval.evaluate(aggBuffer);
				WindowFunctionInfo wFnInfo = FunctionRegistry.getWindowFunctionInfo(wFn.getSpec().getName());
				if ( !wFnInfo.isPivotResult())
				{
					out = new SameList(iPart.size(), out);
				}
				oColumns.add((List<?>)out);
			}
			
			for(int i=0; i < iPart.size(); i++)
			{
				ArrayList oRow = new ArrayList();
				for(int j=0; j < oColumns.size(); j++)
				{
					oRow.add(oColumns.get(j).get(i));
				}
				outP.append(oRow);
			}
		}
		catch(HiveException he)
		{
			throw new WindowingException(he);
		}
		
		return outP;
	}
	
	public static class WindowingTableFunctionResolver extends TableFunctionResolver
	{

		@Override
		protected TableFunctionEvaluator createEvaluator(QueryDef qDef, TableFuncDef tDef)
		{
			
			return new WindowingTableFunction();
		}
		
	}

}
