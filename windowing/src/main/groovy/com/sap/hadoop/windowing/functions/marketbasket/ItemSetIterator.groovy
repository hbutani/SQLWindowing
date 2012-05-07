package com.sap.hadoop.windowing.functions.marketbasket

import com.sap.hadoop.ds.sortedmap.ByteBasedSortedMap;
import com.sap.hadoop.windowing.runtime.IPartition;

class ItemSetIterator implements Iterator<ItemSet>
{
	Basket basket
	
	/*
	 * starting index in Input Partition 
	 */
	int currentIdx
	
	ByteBasedSortedMap candidateItemSets
	
	byte itemSetSz
	
	ItemSet iSet
	
	ItemSetIterator prefixIterator
	ItemSetIterator suffixIterator
	
	ItemSet prefix
	byte suffixSz
	boolean nextChecked
	
	public ItemSetIterator(Basket basket, byte itemSetSz, ByteBasedSortedMap candidateItemSets)
	{
		this(basket, 0, itemSetSz, candidateItemSets)
	}
	
	protected ItemSetIterator(Basket basket, int currentIdx, byte itemSetSz, ByteBasedSortedMap candidateItemSets)
	{
		this.basket = basket
		this.currentIdx = currentIdx
		this.itemSetSz = itemSetSz
		this.candidateItemSets = candidateItemSets
		this.nextChecked = false
		this.iSet = new ItemSet(itemSetSz)
		
		if (itemSetSz > 1)
		{
			byte prefixSz = itemSetSz / (byte) 2;
			suffixSz = itemSetSz - prefixSz
			
			prefixIterator = new ItemSetIterator(basket, currentIdx, prefixSz, candidateItemSets)
			prefix = prefixIterator.next()
			
			if ( prefix != null )
			{
				suffixIterator = createSuffixIterator()
			}
		}
	}

	@Override
	public boolean hasNext()
	{
		if ( nextChecked )
		{
			return iSet != null
		}
		try
		{
			if ( itemSetSz == 1)
			{
				while (currentIdx < basket.size() )
				{
					iSet.reset(basket.get(currentIdx));
					currentIdx++;
					if ( candidateItemSets.getIndex(iSet) != -1)
					{
						return true;
					}
				}
				iSet = null;
				return false;
			}
			else
			{
				if ( prefix == null )
				{
					iSet = null
					return false
				}
				
				ItemSet suffix = suffixIterator.next() 
				while (suffix == null && prefix != null)
				{
					prefix = prefixIterator.next()
					if ( prefix != null )
					{
						suffixIterator = createSuffixIterator()
						suffix = suffixIterator.next()
					}
				}
				
				if ( prefix == null )
				{
					iSet = null
					return false
				}
				
				iSet.reset(prefixIterator.iSet, suffixIterator.iSet)
				return true;
			}
		}
		finally
		{
			nextChecked = true
		}
	}
	
	@Override
	public ItemSet next()
	{
		try
		{
			hasNext()
			return iSet;
		}
		finally
		{
			nextChecked = false
		}
		
	}
	@Override
	public void remove()
	{
		throw new UnsupportedOperationException()
		
	}	
	
	private ItemSetIterator createSuffixIterator()
	{
		return new ItemSetIterator(basket, prefixIterator.currentIdx + prefixIterator.itemSetSz - 1, suffixSz, candidateItemSets)
	}
}
