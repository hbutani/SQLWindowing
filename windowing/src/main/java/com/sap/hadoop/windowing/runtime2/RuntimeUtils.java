package com.sap.hadoop.windowing.runtime2;

import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.exec.OperatorFactory;
import org.apache.hadoop.hive.ql.plan.ExprNodeGenericFuncDesc;
import org.apache.hadoop.hive.ql.plan.OperatorDesc;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.functions2.GenericUDFLeadLag;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo;
import com.sap.hadoop.windowing.query2.translate.TranslateUtils;
import com.sap.hadoop.windowing.runtime2.mr.PTFOperator;

public class RuntimeUtils
{
	public static int compare(Object[] o1, ObjectInspector[] oi1, Object[] o2,
			ObjectInspector[] oi2)
	{
		int c = 0;
		for (int i = 0; i < oi1.length; i++)
		{
			c = ObjectInspectorUtils.compare(o1[i], oi1[i], o2[i], oi2[i]);
			if (c != 0)
				return c;
		}
		return c;
	}

	public static Object[] copyToStandardObject(Object[] o,
			ObjectInspector[] oi,
			ObjectInspectorCopyOption objectInspectorOption)
	{
		Object[] out = new Object[o.length];
		for (int i = 0; i < oi.length; i++)
		{
			out[i] = ObjectInspectorUtils.copyToStandardObject(o[i], oi[i],
					objectInspectorOption);
		}
		return out;
	}

	public static void connectLeadLagFunctionsToPartition(QueryDef qDef,
			PartitionIterator<Object> pItr) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		List<ExprNodeGenericFuncDesc> llFnDescs = tInfo.getLLInfo()
				.getLeadLagExprs();
		if (llFnDescs == null)
			return;
		for (ExprNodeGenericFuncDesc llFnDesc : llFnDescs)
		{
			GenericUDFLeadLag llFn = (GenericUDFLeadLag) llFnDesc
					.getGenericUDF();
			llFn.setpItr(pItr);
		}
	}

	/**
	 * Returns a PTF operator given the PTFDesc conf and appends the list of
	 * children operators.
	 */
	public static <T extends OperatorDesc> Operator<T> createPTFOperator(
			T conf, Operator<? extends OperatorDesc>... oplist)
			throws WindowingException
	{
		Operator<T> op;
		Class<PTFOperator> opClass = PTFOperator.class;
		try
		{
			op = (Operator<T>) opClass.newInstance();
			op.initializeCounters();
			op.setConf(conf);
			OperatorFactory.makeChild(op, oplist);
		}
		catch (Exception e)
		{
			throw new WindowingException(e);
		}
		return (op);
	}
	
	public static Partition createPartition(QueryDef qDef, ObjectInspector oi,
			HiveConf hiveConf) throws WindowingException
	{
		TableFuncDef tabDef = getFirstTableFunction(qDef);
		TableFunctionEvaluator tEval = tabDef.getFunction();
		String partClassName = tEval.getPartitionClass();
		int partMemSize = tEval.getPartitionMemSize();

		Partition part = null;
		SerDe serde;
		if (tEval.hasMapPhase())
		{
			if (tabDef.getName().equals(FunctionRegistry.NOOP_MAP_TABLE_FUNCTION))
			{
				serde = tabDef.getInput().getSerde();
			}
			else
			{
				serde = TranslateUtils.createLazyBinarySerDe(
						hiveConf, tEval.getMapOutputOI());
			}
		}else{
			serde = tabDef.getInput().getSerde();
		}

		part = new Partition(partClassName, partMemSize, serde,
				(StructObjectInspector) oi);
		return part;

	}
	
	public static TableFuncDef getFirstTableFunction(QueryDef qDef){
		TableFuncDef tabDef = null; 
		Iterator<QueryInputDef> it = TranslateUtils.iterateInputDefs(qDef, true);
		while(it.hasNext()){
			QueryInputDef qIn = it.next();
			if(qIn instanceof TableFuncDef){
				tabDef = (TableFuncDef) qIn;
				break;
			}
		}
		return tabDef;

	}

}
