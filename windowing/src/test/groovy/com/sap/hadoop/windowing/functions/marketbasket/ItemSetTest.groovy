package com.sap.hadoop.windowing.functions.marketbasket;

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
			range(i+1).each { j ->
				iSet2.reset(i, j)
				candidateItemSets.put(iSet2)
			}
		}
		
		iSet3 = new ItemSet((byte)3)
		range().each { i ->
			range(i+1).each { j ->
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
	void test1() 
	{
		ItemSetIterator it = new ItemSetIterator(b, (byte) 2, candidateItemSets)
		
		range().each { i ->
			range(i+1).each { j ->
				iSet2.reset(i, j)
				assert iSet2.compareTo(it.next()) == 0
			}
		}
		
		ItemSetIterator it1 = new ItemSetIterator(b, (byte) 3, candidateItemSets)
		
		range().each { i ->
			range(i+1).each { j ->
				range(j+1).each { k ->
					iSet3.reset(i, j, k)
					assert iSet3.compareTo(it1.next()) == 0
				}
			}
		}
		
	}

}
