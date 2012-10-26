package com.sap.hadoop.windowing.functions2.table.npath;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.StandardListObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.runtime2.PartitionIterator;

public class NPathUtils
{
	public static final String PATHATTR_NAME = "tpath";
	/*
	 * add array<struct> to the list of columns
	 */
	public static ObjectInspector createSelectListInputOI(StructObjectInspector inputOI)
	{
		List<? extends StructField> fields = inputOI.getAllStructFieldRefs();
		ArrayList<ObjectInspector> selectListFieldOIs = new ArrayList<ObjectInspector>();
		ArrayList<String> selectListFieldNames = new ArrayList<String>();
		StandardListObjectInspector pathAttrOI = ObjectInspectorFactory.getStandardListObjectInspector(
				ObjectInspectorUtils.getStandardObjectInspector(inputOI));
		for(StructField f : fields)
		{
			selectListFieldOIs.add(ObjectInspectorUtils.getStandardObjectInspector(f.getFieldObjectInspector()));
			selectListFieldNames.add(f.getFieldName());
		}
		selectListFieldOIs.add(pathAttrOI);
		selectListFieldNames.add(PATHATTR_NAME);
		return ObjectInspectorFactory.getStandardStructObjectInspector(selectListFieldNames, selectListFieldOIs);
	}
	
	public static Object getSelectListInput(Object currRow, ObjectInspector rowOI, PartitionIterator<Object> pItr, int sz)
	{
		ArrayList<Object> oRow = new ArrayList<Object>();
		List<?> currRowAsStdObject = (List<?>) ObjectInspectorUtils.copyToStandardObject(currRow, rowOI);
		oRow.addAll(currRowAsStdObject);
		oRow.add(getPath(currRow, rowOI, pItr, sz));
		return oRow;
	}
	
	public static ArrayList<Object> getPath(Object currRow, ObjectInspector rowOI, PartitionIterator<Object> pItr, int sz)
	{
		int idx = pItr.getIndex() - 1;
		ArrayList<Object> path = new ArrayList<Object>();
		path.add(ObjectInspectorUtils.copyToStandardObject(currRow, rowOI));
		int pSz = 1;
		
		while(pSz < sz && pItr.hasNext())
		{
			currRow = pItr.next();
			path.add(ObjectInspectorUtils.copyToStandardObject(currRow, rowOI));
			pSz++;
		}
		pItr.resetToIndex(idx);
		return path;
	}
}
