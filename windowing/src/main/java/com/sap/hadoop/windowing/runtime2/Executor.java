package com.sap.hadoop.windowing.runtime2;

import java.util.ArrayList;
import java.util.Stack;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;

public abstract class Executor
{
	public abstract void execute(QueryDef query, WindowingShell wShell) throws WindowingException;

	
	public Partition executeChain(QueryDef qDef, Partition part) throws WindowingException
	{
		Stack<TableFuncDef> fnDefs = new Stack<TableFuncDef>();
		QueryInputDef iDef = qDef.getInput();
		while(true)
		{
			if (iDef instanceof TableFuncDef )
			{
				fnDefs.push((TableFuncDef)iDef);
				iDef = ((TableFuncDef) iDef).getInput();
			}
			else
			{
				break;
			}
		}
		
		TableFuncDef currFnDef;
		while( !fnDefs.isEmpty() )
		{
			currFnDef = fnDefs.pop();
			part = currFnDef.getFunction().execute(part);
		}
		return part;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void executeSelectList(QueryDef qDef, Partition oPart, ReduceSink rS) throws WindowingException
	{
		ArrayList<ColumnDef> cols = qDef.getSelectList().getColumns();
		ObjectInspector selectOI = qDef.getSelectList().getOI();
		SerDe oSerDe = qDef.getOutput().getSerDe();
		Writable value = null;
		for(int i=0; i < oPart.size(); i++)
		{
			ArrayList selectList = new ArrayList();
			Object oRow = oPart.getAt(i);
			for(ColumnDef cDef : cols)
			{
				try
				{
					selectList.add(cDef.getExprEvaluator().evaluate(oRow));
				}
				catch(HiveException he)
				{
					throw new WindowingException(he);
				}
			}
			
			try
			{
				value = oSerDe.serialize(selectList, selectOI);
			}
			catch(SerDeException se)
			{
				throw new WindowingException(se);
			}
			rS.collectOutput(NullWritable.get(), value);
		}
	}
	
	
	public static interface ReduceSink
	{
		void collectOutput(Writable key, Writable value);
	}
}
