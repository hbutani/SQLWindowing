package com.sap.hadoop.windowing.functions.marketbasket;
import groovy.json.JsonBuilder;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.ds.sortedmap.ByteBasedSortedMap;
import com.sap.hadoop.windowing.BaseTest;
import org.apache.hadoop.io.Text;

import static org.junit.Assert.*;

class DynamicItemCountingTest extends BaseTest 
{
	static int numItems
	static ISet[] oneElemSets
	static DynamicItemCounting dic
	static JsonBuilder json
	static Text iSetText

	
	@BeforeClass
	public static void setupClass()
	{
		BaseTest.setupClass()
		/*
		 * initial dic
		 */
		dic = new DynamicItemCounting()
		dic.candidateFreqItemSetsRequest = null
		dic.rootNode = null
		dic.basketBatches = null
		dic.itemValueList = null
		dic.numItems = 20
		dic.numBaskets = 1008
		dic.baskets = null
		dic.supportThreshold = 50
		dic.currentTraversalRound = 0
		dic.currentBatchIndex = 0
		dic.itemIdArray = new int[numItems]

		json = new JsonBuilder()
		iSetText = new Text()
		
		numItems = 20
		oneElemSets = new ISet[numItems]
		
		(0..<20).each { i ->
			oneElemSets[i] = new ISet(sz : 1, itemIds : [i])
		}
	}
	
	@Test
	public void testSuperSet()
	{
		ImmediateSuperSetsIterator superIt = new ImmediateSuperSetsIterator(oneElemSets[15], dic)
		while(superIt.hasNext())
		{
			ISet is = superIt.next()
			is.writeJson(json, iSetText)
			println "superSet: $iSetText"
			
			ImmediateSubSetsIterator subIt = new ImmediateSubSetsIterator(is, dic)
			while(subIt.hasNext())
			{
				ISet is2 = subIt.next()
				is2.writeJson(json, iSetText)
				println "\tsubset : $iSetText"
			}
		}
	}
}
