package com.sap.hadoop.windowing.functions.marketbasket

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Comparator;

import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector.PrimitiveCategory;
import org.apache.hadoop.hive.serde2.typeinfo.PrimitiveTypeInfo;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;
import org.codehaus.groovy.antlr.treewalker.TraversalHelper;

import com.sap.hadoop.ds.PrimitiveComparator;
import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.ds.list.ListFactory;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.marketbasket.ItemValue.ValueComparator;
import com.sap.hadoop.windowing.runtime.IPartition;
import com.sap.hadoop.windowing.runtime.Row;

/*
 * Based on the Algorithm by Sergey Brin et. al; see http://www-db.stanford.edu/~sergey/dic.ps
 */
class DynamicItemCounting
{
	private static final int BASKET_PARTITION_SZ = 1000;
	
	CandidateFrequentItemSets candidateFreqItemSetsRequest
	
	/*
	 * the root of the ItemNode Trei.
	 */
	ItemNode rootNode
	
	/*
	 * starting index of each Basket Batch
	 */
	int[] basketBatches
	
	/*
	 * sorted on itemValue.id
	 */
	ArrayList<ItemValue> itemList;
	
	int numItems
	int numBaskets
	
	/*
	 * holds the list of Baskets.
	 */
	ByteBasedList baskets
	
	int supportThreshold
	
	int currentTraversalRound
	int currentBatchIndex
	
	/* used during trei traversal */
	int[] itemIdArray
	
	/*
	 * - convert input Partition into a list of Baskets
	 * - maintain itemValMap for the duration of initialization
	 * - at the end of scanning input Partition create itemList 
	 * - setup basketBatches
	 * - setup itemIdArray
	 * - initialize Trei:
	 *   - add root node for empty ItemSet
	 *   - add a child node for each ItemId
	 */
	void initialize(IPartition inpPart) throws WindowingException 
	{
		/*
		 * setup TreeSet for item values, based datatype of item value column.
		 */
		PrimitiveCategory itemColTypeCategory =
				((PrimitiveTypeInfo)candidateFreqItemSetsRequest.itemColType).getPrimitiveCategory()

		PrimitiveComparator<?> itemValueComparator = PrimitiveComparator.getComparator(itemColTypeCategory)
		TreeSet<?> itemValuesSet = new TreeSet(itemValueComparator)

		/*
		 * scan input partition and populate itemValue TreeSet
		 */
		for(row in inpPart) 
		{
			itemValuesSet.add(row[candidateFreqItemSetsRequest.itemColumn])
		}
		numItems = itemValuesSet.size()

		/*
		 * assign ids to itemValues based on value order.
		 */
		HashMap<ItemValue, Integer> itemValToIdMap = new HashMap<ItemValue, Integer>()
		int idx = 0
		for(value in itemValuesSet) {
			itemValToIdMap[value] = idx++
		}
		itemValuesSet = null
		
		/* Scan input partition again and setup baskets ByteBasedList */
		itemIdArray = new int[numItems]
		baskets = ListFactory.createList(Constants.DEFAULT_WINDOW_PARTITION_CLASS, ByteBasedList.MEDIUM_SIZE);
		ISet iSet = new ISet(sz : 0, itemIds : itemIdArray)
		Object currBasket = null
		
		for(row in inpPart)
		{
			Object basket = row[candidateFreqItemSetsRequest.txnColumn]
			Object itemValue = row[candidateFreqItemSetsRequest.itemColumn]
			int itemId = itemValToIdMap[itemValue]
			if ( basket != currBasket )
			{
				if ( iSet.sz > 0 )
				{
					baskets.append(iSet)
				}
				iSet.sz = 0
				currBasket = basket
			}
			iSet[iSet.sz++] = itemId
		}
		
		/*
		 *  setup basketBatches
		*/
		numBaskets = baskets.size()
		int numBatches = numBaskets / BASKET_PARTITION_SZ + 1
		if ( numBaskets % BASKET_PARTITION_SZ  < (BASKET_PARTITION_SZ/2) )
		{
			numBatches--
		}
		basketBatches = new int[numBatches]
		int b = 0;
		for(int i=0; i < numBatches; i++)
		{
			basketBatches[i] = BASKET_PARTITION_SZ * i
		}
		
		/*
		 * initialize Trei
		 */
		rootNode = new ItemNode(itemId : ItemNode.NULL_ID, 
								state : ItemSetState.SOLID_SQUARE, 
								roundIntroduced : -1,
								basketBatchIndexIntroduced : -1)

	}
	
	/*
	 * increment the nodes in the trei that represent the subsets of the given itemSet.
	 * Based on the Item Reordering section in the Paper. 
	 */
	void incrementTrei(ItemNode itemNode, ISet itemSet)
	{
		itemNode.support++
		for(int i=0; i < itemSet.size(); i++)
		{
			ItemNode child = itemNode.children ? itemNode.children[itemSet[i]] : null
			if ( child )
			{
				incrementTrei(child, new SuffixISet(itemSet))
			}	
		}
	}
	
	void traverse()
	{
		ItemNode currNode = rootNode
		ISet currentItemSet = new ISet(sz : 0, itemIds : itemIdArray)
		Stack<ItemNode> traversalStack
		
		currNode.traversalState = ItemNodeTraversal.UP
		traversalStack.push(currNode)
		
		while(!traversalStack.empty())
		{
			currNode = traversalStack.pop()
			
			if ( currNode.traversalState == ItemNodeTraversal.DOWN)
			{
				if ( currNode.state == ItemSetState.DASHED_CIRCLE && currNode.support >= supportThreshold )
				{
					currNode.state == ItemSetState.DASHED_SQUARE
					
					/*
					 * for each immediate superset ItemSet
					 *   check that all its subsets are a SQUARE (ie frequent)
					 *   if yes add it to Trei as a DOTTED_CIRCLE
					 */
					ImmediateSuperSetsIterator superSets = new ImmediateSuperSetsIterator(currentItemSet, this)
					while(superSets.hasNext()) 
					{ 
						ISet superSet = superSets.next()
						ImmediateSubSetsIterator subSets = new ImmediateSubSetsIterator(superSet, this)
						boolean reject = false
						while(!reject && subSets.hasNext())
						{
							ImmedSubSetISet subset = subSets.next()
							reject = !isSquare(subset)
						}
						
						if ( !reject )
						{
							int newId = superSet[superSet.size() - 1]
							ItemNode newNode = new ItemNode(itemId : newId, 
								state : ItemSetState.DASHED_CIRCLE, 
								roundIntroduced : currentTraversalRound,
								basketBatchIndexIntroduced : currentBatchIndex)
							currNode.children = currNode.children == null ? new TreeMap<Integer, ItemNode>() : currNode.children
							currNode.children[newId] = newNode
						}
					}
				}
				
				/*
				 * If a DOTTED item has been counted through all baskets then make it solid.
				 */
				if ( (currNode.roundIntroduced < currentTraversalRound)  &&
					(currNode.basketBatchIndexIntroduced < currentBatchIndex) &&
					(currNode.state == ItemSetState.DASHED_CIRCLE || currNode.state == ItemSetState.DASHED_SQUARE) 
					)
				{
					if (currNode.state == ItemSetState.DASHED_CIRCLE )
					{
						currNode.state = ItemSetState.SOLID_CIRCLE
						// this is a dead node, so set children to null, let GC reclaim space
						currNode.children = null
					}
					else
					{
						currNode.state = ItemSetState.SOLID_SQUARE
					}
				}
				
				/*
				 * If node is a SQUARE then add children to traversal stack.
				 * Why are we filtering out CIRCLE nodes:
				 * - a SOLID_CIRCLE is a dead node. Any superSet ItemSet is also not frequent
				 * - a DASHED_CRICLE should have no children; children are added when it transitions to a DASHED_SQUARE
				 */
				if ( (currNode.state == ItemSetState.SOLID_SQUARE || currNode.state == ItemSetState.DASHED_SQUARE) &&
					currNode.children 
					)
				{
					currNode.traversalState = ItemNodeTraversal.UP
					if ( !currNode.isRoot())
					{
						currentItemSet.itemIds[currentItemSet.sz++] = currNode.itemId
					}
					traversalStack.push(currNode)
					currNode.children.each { int id, ItemNode node ->
						node.traversalState = ItemNodeTraversal.DOWN
						traversalStack.push(node)
					}
				}
			}
			else
			{
				if ( !currNode.isRoot())
				{
					currentItemSet.sz--
				}
			}
		}
	}
	
	boolean isSquare(ISet itemSet)
	{
		ItemNode current = rootNode
		
		for(int i=0; i < itemSet.size(); i++)
		{
			ItemNode child = current.children ? current.children[itemSet[i]] : null
			if ( !child || child.state == ItemSetState.SOLID_CIRCLE || child.state == ItemSetState.DASHED_CIRCLE )
				return  false
			current = child
		}
		return true
	}
}

/*
 * DASHED => ItemSet is still being counted
 * SOLID => ItemSet has been fully counted
 * CIRCLE => ItemSet's support is less than the threshold
 * SQUARE => ItemSet's support is more than the threshold.
 */
enum ItemSetState
{
	DASHED_CIRCLE,
	DASHED_SQUARE,
	SOLID_CIRCLE,
	SOLID_SQUARE;
}

enum ItemNodeTraversal
{
	DOWN,
	UP
}

/*
 * Represents a Node in the Trei.
 */
class ItemNode
{
	private static final NULL_ID = -1
	int itemId
	TreeMap<Integer, ItemNode> children
	/*
	 * id of basket batch when this node was added to Trei
	 */
	int basketBatchIndexIntroduced
	
	/*
	 * round in which this node was added to Trei.
	 */
	int roundIntroduced
	
	ItemSetState state
	
	int support
	
	ItemNodeTraversal traversalState = ItemNodeTraversal.DOWN
	
	final boolean isRoot() { itemId == NULL_ID }
}

/*
 * represents a mapping from an Item's name to an internal Id
 */
class ItemValue
{
	Object value
	int id
	
	
	static class ValueComparator implements Comparator<ItemValue>
	{
		PrimitiveComparator<?> pC
		
		ValueComparator(PrimitiveCategory pCat) throws WindowingException
		{
			pC = PrimitiveComparator.getComparator(pCat)
		}

		@Override
		public int compare(ItemValue o1, ItemValue o2)
		{
			return pC.compare(o1?.value, o2?.value)
		}
		
	}
	
	static class IdComparator implements Comparator<ItemValue>
	{
		@Override
		public int compare(ItemValue o1, ItemValue o2)
		{
			return o1.id - o2.id
		}
		
	}
}

class ISet implements Writable
{
	protected int sz
	protected int[] itemIds
	
	int getAt(i) { return itemIds[i]; }
	int size() { return sz; }
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		out.writeByte(sz)
		itemIds.each { iId ->
			WritableUtils.writeVInt(out, iId);
		}
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		sz = din.readByte()
		if ( !itemIds || itemIds.length < sz)
		{
			itemIds = new int[sz]
		}
		(0..<sz).each { i ->
			itemIds[i] = WritableUtils.readVInt(din)
		}
	}
}

/*
 * An ISet that is an immediate subset (meaning with 1 less item) of another ISet.
 */
class ImmedSubSetISet extends ISet
{
	int idxToSkip
	
	ImmedSubSetISet(ISet iSet, idxToSkip = -1)
	{
		sz = iSet.sz
		itemIds = iSet.itemIds
		this.idxToSkip = idxToSkip
	}
	
	int getAt(i) 
	{ 
		if ( i < idxToSkip )
		{
			return itemIds[i]
		}
		else
		{
			return itemIds[i+1]
		}
	}
	
	int size() { return sz - 1; }
}

/*
* An ISet that is an immediate superset (meaning with 1 extra item) of another ISet.
*/
class ImmedSuperSetISet extends ISet
{
   int lastItemId
   
   ImmedSuperSetISet(ISet iSet, int lastItemId)
   {
	   sz = iSet.sz
	   itemIds = iSet.itemIds
	   this.lastItemId = lastItemId
   }
   
   int getAt(i)
   {
	   if ( i ==  sz )
	   {
		   return lastItemId
	   }
	   else
	   {
		   return itemIds[i]
	   }
   }
   
   int size() { return sz + 1; }
}

class SuffixISet extends ISet
{
	int startIdx
	
	SuffixISet(ISet iSet)
	{
		sz = iSet.sz
		itemIds = iSet.itemIds
		startIdx = 1
	}
	
	SuffixISet(SuffixISet iSet)
	{
		sz = iSet.sz
		itemIds = iSet.itemIds
		startIdx = iSet.startIdx + 1
	}
	
	int size() { return sz - startIdx; }
	
	int getAt(i)
	{
		return itemIds[i - startIdx]
	}
}

class ImmediateSuperSetsIterator implements Iterator<ImmedSuperSetISet>
{
	ImmedSuperSetISet itemSet
	DynamicItemCounting dic
	int nextId
	
	ImmediateSuperSetsIterator(ISet itemSet, DynamicItemCounting dic)
	{
		this.itemSet = new ImmedSuperSetISet(itemSet)
		this.dic = dic
		
		/*
		 * A n length itemSet has no superSets
		 */
		if ( itemSet.sz == dic.numItems)
		{
			nextId = dic.numItems
		}
		/*
		 * for the empty ItemSet, setup instance so that all 1 length itemsets are returned.
		 */
		else if ( itemSet.sz == 0 )
		{
			nextId = 0
		}
		else
		{
			nextId = itemSet.itemIds[itemSet.sz - 1] + 1
		}
		
	}
	
	public boolean hasNext()
	{
		return nextId < dic.numItems
	}
	
	public ImmedSuperSetISet next()
	{
		itemSet.lastItemId = nextId++
		return itemSet;
	}
	public void remove()
	{
		throw new UnsupportedOperationException()
	}
}

class ImmediateSubSetsIterator implements Iterator<ISet>
{
	ImmedSubSetISet itemSet
	DynamicItemCounting dic
	
	ImmediateSubSetsIterator(ISet itemSet, DynamicItemCounting dic)
	{
		this.itemSet = new ImmedSubSetISet(itemSet)
		this.dic = dic
		
	}

	public boolean hasNext()
	{
		return itemSet.idxToSkip < itemSet.sz
	}
	
	public ISet next()
	{
		itemSet.idxToSkip++
		return itemSet
	}
	public void remove()
	{
		throw new UnsupportedOperationException()
	}
}