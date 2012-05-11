package com.sap.hadoop.windowing.functions.marketbasket;

import groovy.json.JsonBuilder;
import groovy.json.JsonSlurper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparator;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.ds.sortedmap.ByteBasedSortedMap;
import com.sap.hadoop.windowing.BaseTest;
import static org.junit.Assert.*;

class ItemSetTest extends BaseTest 
{
	static ByteBasedSortedMap candidateItemSets
	static ItemSet iSet1
	static ItemSet iSet2
	static ItemSet iSet3
	static Basket b
	static int BASKET_SZ = 100
	
	@BeforeClass
	public static void setupClass()
	{
		BaseTest.setupClass()

		candidateItemSets = new ByteBasedSortedMap(WritableComparator.get(ItemSet.class));
		
		iSet1 = new ItemSet((byte)1)
		
		range().each { i ->
			iSet1.reset(i)
			candidateItemSets.put(iSet1)
		}
		
		iSet2 = new ItemSet((byte)2)
		range().each { i ->
			range(i+1).step(2) { j ->
				iSet2.reset(i, j)
				candidateItemSets.put(iSet2)
			}
		}
		
		iSet3 = new ItemSet((byte)3)
		range().each { i ->
			range(i+1).step(2) { j ->
				range(j+1).each { k ->
					iSet3.reset(i, j, k)
					candidateItemSets.put(iSet3)
				}
			}
		}
		
		b = new Basket()
		range().each { i -> b.addItem(i) }
	}
	
	static Range range(int startIdx = 0)
	{
		return startIdx >= BASKET_SZ ? new EmptyRange(startIdx ) : new IntRange(startIdx, BASKET_SZ - 1)
	}
	
	@Test
	void test0()
	{
		ItemSet iSet = new ItemSet()
		Iterator<Writable> it = candidateItemSets.keyIterator(iSet)
		it.each { ItemSet is ->
		   //println is
	   }
	}
	
	@Test
	void test1() 
	{
		ItemSetIterator it = new ItemSetIterator(b, (byte) 2, candidateItemSets)
		
		/*range().each { i ->
			range(i+1).each { j ->
				iSet2.reset(i, j)
				assert iSet2.compareTo(it.next()) == 0
			}
		}*/
		
		ItemSetIterator it1 = new ItemSetIterator(b, (byte) 3, candidateItemSets)
		
		def itemSets = [
			[0, 1, 2], [0, 1, 4], [0, 1, 6], [0, 1, 8], [0, 3, 4], [0, 3, 6],
			[0, 3, 8], [0, 5, 6], [0, 5, 8], [0, 7, 8], [1, 2, 3], [1, 2, 5],
			[1, 2, 7], [1, 2, 9], [1, 4, 5], [1, 4, 7], [1, 4, 9], [1, 6, 7],
			[1, 6, 9], [1, 8, 9], [2, 3, 4], [2, 3, 6], [2, 3, 8], [2, 5, 6],
			[2, 5, 8], [2, 7, 8], [3, 4, 5], [3, 4, 7], [3, 4, 9], [3, 6, 7],
			[3, 6, 9], [3, 8, 9], [4, 5, 6], [4, 5, 8], [4, 7, 8], [5, 6, 7],
			[5, 6, 9], [5, 8, 9], [6, 7, 8], [7, 8, 9]
	    ]
		
		itemSets.each { items ->
			iSet3.reset(*items)
			assert iSet3.compareTo(it1.next()) == 0
		}
		
	}
	
	@Test
	void testJson()
	{
		def json = new JsonBuilder()
		def jsonS = new JsonSlurper()
		ArrayList<Text> jsonList = []
		ItemSet iSet = new ItemSet()
		//println candidateItemSets.size()
		Iterator<Writable> it = candidateItemSets.keyIterator(iSet)
		it.each { ItemSet is ->
			 Text t = new Text()
			 is.writeJson(json, t)
			 iSet.readJson(jsonS, t)
			 //assert iSet == is
		}
	}

}
