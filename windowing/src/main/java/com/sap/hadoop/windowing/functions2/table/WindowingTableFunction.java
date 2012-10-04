package com.sap.hadoop.windowing.functions2.table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer;
import org.apache.hadoop.hive.serde2.objectinspector.ListObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

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
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.CurrentRowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.RangeBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.ValueBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.BoundaryDef;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.BoundarySpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.Direction;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;
import com.sap.hadoop.windowing.query2.translate.WindowFunctionTranslation;
import com.sap.hadoop.windowing.runtime2.Partition;
import com.sap.hadoop.windowing.runtime2.PartitionIterator;
import com.sap.hadoop.windowing.runtime2.ValueBoundaryScanner;

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
		ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();
		
		WindowFunctionTranslation.addInputColumnsToList(qDef, getTableDef(), aliases, fieldOIs);
		
		for(WindowFunctionSpec wFnS : wFnSpecs)
		{
				WindowFunctionDef wFnDef = WindowFunctionTranslation.translate(qDef, getTableDef(), wFnS);
				WindowFunctionInfo wFnInfo = FunctionRegistry.getWindowFunctionInfo(wFnS.getName());
				wFnDefs.add(wFnDef);
				aliases.add(wFnS.getAlias());
				if ( wFnInfo.isPivotResult())
				{
					ListObjectInspector lOI = (ListObjectInspector) wFnDef.getOI();
					fieldOIs.add(lOI.getListElementObjectInspector());
				}
				else
				{
					fieldOIs.add(wFnDef.getOI());
				}
		}
		select.setWindowFuncs(wFnDefs);
		
		OI = ObjectInspectorFactory.getStandardStructObjectInspector(aliases, fieldOIs);
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Partition iPart, Partition outP) throws WindowingException
	{
		QueryDef qDef = getQueryDef();
		ArrayList<WindowFunctionDef> wFns = qDef.getSelectList().getWindowFuncs();
		ArrayList<List<?>> oColumns = new ArrayList<List<?>>();
		
		StructObjectInspector inputOI = iPart.getOI();
		
		try
		{
			for(WindowFunctionDef wFn : wFns)
			{
				boolean processWindow = wFn.getWindow() != null;
				
				if ( !processWindow )
				{
					GenericUDAFEvaluator fEval = wFn.getEvaluator();
					Object[] args = new Object[wFn.getArgs().size()];
					AggregationBuffer aggBuffer = fEval.getNewAggregationBuffer();
					PartitionIterator<Object> pItr = iPart.iterator();
					while(pItr.hasNext())
					{
						Object row = pItr.next();
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
				else
				{
					oColumns.add(executeFnwithWindow(wFn, iPart));
				}
			}
			
			for(int i=0; i < iPart.size(); i++)
			{
				ArrayList oRow = new ArrayList();
				Object iRow = iPart.getAt(i);
				
				for(StructField f : inputOI.getAllStructFieldRefs())
				{
					oRow.add(inputOI.getStructFieldData(iRow, f));
				}
				
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
		
	}
	
	public static class WindowingTableFunctionResolver extends TableFunctionResolver
	{

		@Override
		protected TableFunctionEvaluator createEvaluator(QueryDef qDef, TableFuncDef tDef)
		{
			
			return new WindowingTableFunction();
		}
		
	}
	
	static ArrayList<Object> executeFnwithWindow(WindowFunctionDef wFnDef, Partition iPart) 
		throws HiveException, WindowingException
	{
		ArrayList<Object> vals = new ArrayList<Object>();
		
		GenericUDAFEvaluator fEval = wFnDef.getEvaluator();
		Object[] args = new Object[wFnDef.getArgs().size()];
		for(int i=0; i < iPart.size(); i++)
		{
			AggregationBuffer aggBuffer = fEval.getNewAggregationBuffer();
			Range rng = getRange(wFnDef, i, iPart); 
			PartitionIterator<Object> rItr = rng.iterator();
			while(rItr.hasNext())
			{
				Object row = rItr.next();
				int j = 0;
				for(ArgDef arg : wFnDef.getArgs())
				{
					args[j++] = arg.getExprEvaluator().evaluate(row);
				}
				fEval.aggregate(aggBuffer, args);
			}
			Object out = fEval.evaluate(aggBuffer);
			out = ObjectInspectorUtils.copyToStandardObject(out, wFnDef.getOI(), ObjectInspectorCopyOption.WRITABLE);
			vals.add(out);
		}
		return vals;
	}
	
	static Range getRange(WindowFunctionDef wFnDef, int currRow, Partition p) throws WindowingException
	{
		BoundaryDef startB = wFnDef.getWindow().getWindow().getStart();
		BoundaryDef endB = wFnDef.getWindow().getWindow().getEnd();
		
		int start = getIndex(startB, currRow, p, false);
		int end = getIndex(endB, currRow, p, true);
		
		return new Range(start, end, p);
	}
	
	static int getIndex(BoundaryDef bDef, int currRow, Partition p, boolean end) throws WindowingException
	{
		if ( bDef instanceof CurrentRowDef)
		{
			return currRow + (end ? 1 : 0);
		}
		else if ( bDef instanceof RangeBoundaryDef)
		{
			RangeBoundaryDef rbDef = (RangeBoundaryDef) bDef;
			int amt = rbDef.getAmt();
			
			if ( amt == BoundarySpec.UNBOUNDED_AMOUNT )
			{
				return rbDef.getDirection() == Direction.PRECEDING ? 0 : p.size();
			}
			
			amt = rbDef.getDirection() == Direction.PRECEDING ?  -amt : amt;
			int idx = currRow + amt;
			idx = idx < 0 ? 0 : (idx > p.size() ? p.size() : idx);
			return idx + (end && idx < p.size() ? 1 : 0);
		}
		else
		{
			ValueBoundaryScanner vbs = ValueBoundaryScanner.getScanner((ValueBoundaryDef)bDef);
			return vbs.computeBoundaryRange(currRow, p);
		}
	}
	
	static class Range
	{
		int start;
		int end;
		Partition p;
		
		public Range(int start, int end, Partition p)
		{
			super();
			this.start = start;
			this.end = end;
			this.p = p;
		}

		public PartitionIterator<Object> iterator()
		{
			return p.range(start, end);
		}
	}

}
