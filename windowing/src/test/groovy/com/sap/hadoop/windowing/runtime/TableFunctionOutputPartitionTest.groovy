package com.sap.hadoop.windowing.runtime;

import static org.junit.Assert.*;

import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.junit.Test;
import com.sap.hadoop.windowing.BaseTest;


class TableFunctionOutputPartitionTest extends BaseTest
{

	@Test
	void test1()
	{
		TableFunctionOutputPartition p = new TableFunctionOutputPartition()
		Map<String, TypeInfo> typeMap = [:]
		typeMap['itemset'] = TypeInfoFactory.getListTypeInfo(TypeInfoFactory.stringTypeInfo)
		
		p.initialize(wshell.cfg, typeMap)
		
		def l = (0..<10000).toList()
		
		def itemsets = l.collect { i ->
			["abc-" + i, "def-" + i]
		}
		
		itemsets.each { is ->
			p << [is]
		}
		
		l.each { i ->
			assert p[i].itemset == ["abc-$i", "def-$i"]
		}
	}
}
