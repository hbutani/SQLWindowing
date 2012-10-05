package com.sap.hadoop.windowing.runtime2;

import java.util.List;

import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;

import com.sap.hadoop.windowing.functions2.GenericUDFLeadLag;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo;

import com.sap.hadoop.windowing.WindowingException;

public class RuntimeUtils
{
	public static int compare(Object[] o1, ObjectInspector[] oi1, Object[] o2, ObjectInspector[] oi2)
	{
		int c = 0;
		for(int i=0; i<oi1.length; i++)
		{
			c = ObjectInspectorUtils.compare(o1[i], oi1[i], o2[i], oi2[i]);
			if ( c!= 0) return c;
		}
		return c;
	}
	
	public static Object[] copyToStandardObject(Object[] o, ObjectInspector[] oi, ObjectInspectorCopyOption objectInspectorOption)
	{
		Object[] out = new Object[o.length];
		for(int i=0; i<oi.length; i++)
		{
			out[i] = ObjectInspectorUtils.copyToStandardObject(o[i], oi[i], objectInspectorOption);
		}
		return out;
	}
	
	public static void connectLeadLagFunctionsToPartition(QueryDef qDef, PartitionIterator<Object> pItr) 
		throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		List<GenericUDFLeadLag> llFns = tInfo.getLeadLagFns();
		if ( llFns == null ) return;
		for(GenericUDFLeadLag llFn : llFns)
		{
			llFn.setpItr(pItr);
		}
	}
}
