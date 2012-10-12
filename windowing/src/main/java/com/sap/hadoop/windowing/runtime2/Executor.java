package com.sap.hadoop.windowing.runtime2;

import java.util.ArrayList;
import java.util.Stack;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters.Converter;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WhereDef;

public abstract class Executor
{
	public abstract void execute(QueryDef query, WindowingShell wShell)
			throws WindowingException;

	public static Partition executeChain(QueryDef qDef, Partition part)
			throws WindowingException
	{
		Stack<TableFuncDef> fnDefs = new Stack<TableFuncDef>();
		QueryInputDef iDef = qDef.getInput();
		while (true)
		{
			if (iDef instanceof TableFuncDef)
			{
				fnDefs.push((TableFuncDef) iDef);
				iDef = ((TableFuncDef) iDef).getInput();
			}
			else
			{
				break;
			}
		}

		TableFuncDef currFnDef;
		while (!fnDefs.isEmpty())
		{
			currFnDef = fnDefs.pop();
			part = currFnDef.getFunction().execute(part);
		}
		return part;
	}

	@SuppressWarnings(
	{ "rawtypes", "unchecked" })
	public static void executeSelectList(QueryDef qDef, Partition oPart, ForwardSink rS)
			throws WindowingException
	{
		ArrayList<ColumnDef> cols = qDef.getSelectList().getColumns();
		ObjectInspector selectOI = qDef.getSelectList().getOI();
		SerDe oSerDe = qDef.getOutput().getSerDe();
		Object[] output = new Object[cols.size()];

		WhereDef whDef = qDef.getWhere();
		boolean applyWhere = whDef != null;
		Converter whConverter = !applyWhere ? null
				: ObjectInspectorConverters
						.getConverter(
								whDef.getOI(),
								PrimitiveObjectInspectorFactory.javaBooleanObjectInspector);
		ExprNodeEvaluator whCondEval = !applyWhere ? null : whDef
				.getExprEvaluator();

		Writable value = null;
		PartitionIterator<Object> pItr = oPart.iterator();
		RuntimeUtils.connectLeadLagFunctionsToPartition(qDef, pItr);
		while (pItr.hasNext())
		{
			int colCnt = 0;
			ArrayList selectList = new ArrayList();
			Object oRow = pItr.next();

			if (applyWhere)
			{
				Object whCond = null;
				try
				{
					whCond = whCondEval.evaluate(oRow);
					whCond = whConverter.convert(whCond);
				}
				catch (HiveException he)
				{
					throw new WindowingException(he);
				}
				if (whCond == null || !((Boolean) whCond).booleanValue())
				{
					continue;
				}
			}

			for (ColumnDef cDef : cols)
			{
				try
				{
					Object newCol = cDef.getExprEvaluator().evaluate(oRow);
					output[colCnt++] = newCol;
					selectList.add(newCol);
				}
				catch (HiveException he)
				{
					throw new WindowingException(he);
				}
			}
			
			if(rS.acceptObject()){
				rS.collectOutput(output, selectOI);
			}else{
				try
				{
					value = oSerDe.serialize(selectList, selectOI);
				}
				catch (SerDeException se)
				{
					throw new WindowingException(se);
				}
				rS.collectOutput(NullWritable.get(), value);
			}
		}
	}

	public static interface ForwardSink
	{
		void collectOutput(Writable key, Writable value);
		void collectOutput(Object[] output, ObjectInspector oi);
		boolean acceptObject();
	}
}
