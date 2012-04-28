package com.sap.hadoop.windowing.query

import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.lazybinary.LazyBinarySerDe;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import com.sap.hadoop.windowing.WindowingException;

import org.apache.hadoop.hive.serde.Constants as HiveConstants
import org.apache.hadoop.conf.Configuration;

class TypeUtils
{
	public static SerDe createLazyBinarySerDe(Configuration cfg, Map<String, TypeInfo> typeMap) throws WindowingException
	{
	
		ArrayList<String> columnNames = []
		ArrayList<String> columnTypes = []
		typeMap.collect { k, v ->
			columnNames << k
			columnTypes << v
		}
		String cNames = columnNames.join(",")
		String cTypes = columnTypes.join(",")
		
		SerDe serDe = new LazyBinarySerDe()
		Properties p = new Properties()
		p.setProperty(HiveConstants.LIST_COLUMNS, cNames)
		p.setProperty(HiveConstants.LIST_COLUMN_TYPES, cTypes)
		try
		{
			serDe.initialize(cfg, p)
		}
		catch(SerDeException se)
		{
			throw new WindowingException(se)
		}
		return serDe
	}
}
