package com.sap.hadoop.windowing.functions.marketbasket

import groovy.json.JsonBuilder;
import groovy.json.JsonSlurper;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Comparator;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector.PrimitiveCategory;
import org.apache.hadoop.hive.serde2.typeinfo.PrimitiveTypeInfo;
import org.apache.hadoop.io.Text;
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
	private static final Log LOG = LogFactory.getLog("com.sap.hadoop.windowing.functions.marketbasket");
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
	Object[] itemValueList;
	
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
	 * - at the end of scanning input Partition create itemValueList 
	 * - setup basketBatches
	 * - setup itemIdArray
	 * - initialize Trei:
	 *   - add root node for empty ItemSet
	 *   - add a child node for each ItemId
	 */
	void initialize(IPartition inpPart) throws WindowingException 
	{
//		JsonBuilder json = new JsonBuilder()
//		Text iSetText = new Text()
		
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
		LOG.info("DIC: itemValuesSet" + itemValuesSet);

		/*
		 * assign ids to itemValues based on value order.
		 */
		HashMap<?, Integer> itemValToIdMap = new HashMap<?, Integer>()
		int idx = 0
		for(value in itemValuesSet) {
			itemValToIdMap[value] = idx++
		}
		itemValuesSet = null
		LOG.info("DIC: itemValToIdMap" + itemValToIdMap);
		
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
//					if (true)
//					{
//						iSet.writeJson(json, iSetText)
//						LOG.info("DIC: adding basket" + iSetText);
//					}
					baskets.append(iSet)
//					LOG.info("adding basket ${currBasket}  ${iSet}");
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
		supportThreshold = numBaskets * candidateFreqItemSetsRequest.supportThresholdFraction
		int numBatches = numBaskets / BASKET_PARTITION_SZ + 1
		if ( (numBatches > 1) && numBaskets % BASKET_PARTITION_SZ  < (BASKET_PARTITION_SZ/2) )
		{
			numBatches--
		}
		basketBatches = new int[numBatches]
		int b = 0;
		for(int i=0; i < numBatches; i++)
		{
			basketBatches[i] = BASKET_PARTITION_SZ * i
		}
		LOG.info("DIC: basketBatches" + basketBatches);
		LOG.info("DIC: numBaskets " + numBaskets);
		LOG.info("DIC: numBatches " + numBatches);
		LOG.info("DIC: supportThreshold " + supportThreshold);
		
		/*
		 * setup itemValueList
		 */
		itemValueList = new Object[itemValToIdMap.size()]
		itemValToIdMap.each { val, i ->
			itemValueList[i] = val
		}
		LOG.info("DIC: sorted item List" + itemValueList);
		
		/*
		 * initialize Trei
		 */
		currentTraversalRound = 0
		currentBatchIndex = basketBatches.size() - 1
		rootNode = new ItemNode(itemId : ItemNode.NULL_ID, 
								state : ItemSetState.SOLID_SQUARE, 
								roundIntroduced : currentTraversalRound,
								basketBatchIndexIntroduced : currentBatchIndex)
		rootNode.children = new TreeMap<Integer, ItemNode>()
		for(int i=0; i < numItems; i++)
		{
			ItemNode iNode = new ItemNode(itemId : i, 
								state : ItemSetState.DASHED_CIRCLE, 
								roundIntroduced : currentTraversalRound,
								basketBatchIndexIntroduced : currentBatchIndex)
			rootNode.children[i] = iNode
		}
		currentTraversalRound = 1
		currentBatchIndex = 0
//		LOG.info("DIC: initialTrei" + dumpTrei())
	}
	
	Iterator<String> process()
	{
		
		if ( false )
		{
			supportThreshold = 1
			ISet iT = new ISet(sz : 0, itemIds : itemIdArray)
			[0,1,2,3,4].each { v -> iT.itemIds[iT.sz++] = v}
			incrementTrei(rootNode, iT)
			incrementTrei(rootNode, iT)
			processTrei()
			LOG.info("DIC: Trei" + dumpTrei())
			
			currentBatchIndex++
			incrementTrei(rootNode, iT)
			incrementTrei(rootNode, iT)
			processTrei()
			
			LOG.info("DIC: Trei" + dumpTrei())
			return null
			
		}
		
		
		while(treiHasDashedNodes())
		{
			LOG.info(sprintf("DIC: processing round %d, batch %d", currentTraversalRound, currentBatchIndex))
//			LOG.info("DIC: Trei" + dumpTrei())
			/*
			 * process next batch
			 */
			int startIdx = basketBatches[currentBatchIndex]
			int endIdx = currentBatchIndex == basketBatches.size() - 1 ? baskets.size() : basketBatches[currentBatchIndex+1]
			ISet basket = new ISet()
			for(int i=startIdx; i < endIdx; i++)
			{
				baskets.get(i, basket)
				incrementTrei(rootNode, basket)
			}
			
			processTrei()
			LOG.info("DIC: Trei" + dumpTrei())
			
			/*
			 * increment currentBatchIndex and currentTraversalRound
			 */
			currentBatchIndex++
			if ( currentBatchIndex == basketBatches.size() )
			{
				currentBatchIndex = 0
				currentTraversalRound++
			}
		}
		LOG.info("DIC: final Trei" + dumpTrei())
		return new FrequentItemSetIterator(rootNode, itemIdArray, itemValueList)
	}
	
	/*
	 * increment the nodes in the trei that represent the subsets of the given itemSet.
	 * Based on the Item Reordering section in the Paper. 
	 */
	void incrementTrei(ItemNode itemNode, ISet itemSet)
	{
		if ( itemNode.state == ItemSetState.SOLID_CIRCLE )
		{
			return;
		}
		if ( itemNode.state != ItemSetState.SOLID_SQUARE )
		{
			itemNode.support++
		}
		for(int i=0; i < itemSet.size(); i++)
		{
			ItemNode child = itemNode.children ? itemNode.children[itemSet[i]] : null
			if ( child )
			{
				incrementTrei(child, new SuffixISet(itemSet, i+1))
			}	
		}
	}
	
	/*
	 * traverse Trei:
	 * - change state for Nodes whose support is now greater than the threshold
	 * - introduce new ItemSets where possible
	 */
	void processTrei()
	{
		JsonBuilder json = new JsonBuilder()
		Text iSetText = new Text()
		ItemNode currNode = rootNode
		/*
		 * represents the ItemSet formed by the path from the root to the currNode.
		 */
		ISet currentItemSet = new ISet(sz : 0, itemIds : itemIdArray)
		Stack<ItemNode> traversalStack = new Stack<ItemNode>()
		
		currNode.traversalState = ItemNodeTraversal.DOWN
		traversalStack.push(currNode)
		
		while(!traversalStack.empty())
		{
			currNode = traversalStack.pop()
//			LOG.info("DIC: pop ${currNode.itemId}")
			
			if ( currNode.traversalState == ItemNodeTraversal.DOWN)
			{
				if ( !currNode.isRoot())
				{
					currentItemSet.itemIds[currentItemSet.sz++] = currNode.itemId
					if (true)
					{
						currentItemSet.writeJson(json, iSetText)
//						LOG.info("DIC: visit on the way down" + iSetText);
					}
					currNode.traversalState = ItemNodeTraversal.UP
					traversalStack.push(currNode)
//					LOG.info("DIC: push ${currNode.itemId}")
				}

				if ( currNode.state == ItemSetState.DASHED_CIRCLE && currNode.support >= supportThreshold )
				{
					currNode.state = ItemSetState.DASHED_SQUARE
					

					if (true)
					{
						currentItemSet.writeJson(json, iSetText)
						LOG.info("DIC: itemSet moved to DASHED SQ" + iSetText + " with support " + currNode.support);
					}
				}
				
				if ( currNode.support >= supportThreshold  )
				{
					/*
					 * for each immediate superset ItemSet
					 *   check that all its subsets are a SQUARE (ie frequent)
					 *   if yes add it to Trei as a DOTTED_CIRCLE
					 */
					ImmediateSuperSetsIterator superSets = new ImmediateSuperSetsIterator(currentItemSet, this)
					while(superSets.hasNext()) 
					{ 
						ISet superSet = superSets.next()
						int newId = superSet[superSet.size() - 1]
						if ( currNode.children != null && currNode.children[newId] != null )
						{
							continue;
						}
						if (true)
						{
							superSet.writeJson(json, iSetText)
//							LOG.info("DIC: checking superSet " + iSetText);
						}
						ImmediateSubSetsIterator subSets = new ImmediateSubSetsIterator(superSet, this)
						boolean reject = !subSets.hasNext()
						while(!reject && subSets.hasNext())
						{
							ImmedSubSetISet subset = subSets.next()
							if (true)
							{
								subset.writeJson(json, iSetText)
//								LOG.info("DIC: checking subset " + iSetText);
							}
							reject = !isSquare(subset)
						}
						
						if ( !reject )
						{
							if (true)
							{
//								LOG.info("DIC: adding subset with id" + newId);
							}
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
				int currOrdinal = (currentTraversalRound * basketBatches.size()) + currentBatchIndex
				int nodeOrdinal = (currNode.roundIntroduced * basketBatches.size()) + currNode.basketBatchIndexIntroduced
				if ( 					
					( (currOrdinal - nodeOrdinal)  == (basketBatches.size() ) )   &&
					(currNode.state == ItemSetState.DASHED_CIRCLE || currNode.state == ItemSetState.DASHED_SQUARE) 
					)
				{
					if (currNode.state == ItemSetState.DASHED_CIRCLE )
					{
						currNode.state = ItemSetState.SOLID_CIRCLE
						// this is a dead node, so set children to null, let GC reclaim space
						currNode.children = null
						
						assert currNode.support < supportThreshold
						if (true)
						{
							currentItemSet.writeJson(json, iSetText)
							LOG.info("DIC: itemSet moved to SOLID CIR" + iSetText + " with support " + currNode.support);
						}
	
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
					currNode.children.each { int id, ItemNode node ->
						node.traversalState = ItemNodeTraversal.DOWN
						traversalStack.push(node)
//						LOG.info("DIC: push ${node.itemId}")
					}
				}
			}
			else
			{
				if ( !currNode.isRoot())
				{
					if (true)
					{
						currentItemSet.writeJson(json, iSetText)
//						LOG.info("DIC: visit on the way up" + iSetText);
					}
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
	
	boolean treiHasDashedNodes()
	{
		Queue<ItemNode> queue = new LinkedBlockingQueue<ItemNode>(Integer.MAX_VALUE)
		queue.add(rootNode)
		
		while(queue.size() > 0)
		{
			ItemNode current = queue.remove()
			
			if ( current.state == ItemSetState.DASHED_CIRCLE || current.state == ItemSetState.DASHED_SQUARE )
			{
				return true
			}
			
			if ( current.children )
			{
				current.children.values().each { childIS ->
					queue.add(childIS)
				}
			}
		}
		return false
	}
	
	private String dumpTrei(StringBuilder buf = null, int tab = 0)
	{
		buf = buf == null ? new StringBuilder() : buf
		Stack<?> traversalStack = new Stack<Object>()
		traversalStack.push([rootNode, tab])
		while(!traversalStack.empty())
		{
			Object o = traversalStack.pop()
			ItemNode iNode = o[0]
			tab = o[1]
			buf.append(" " * tab).append(iNode.itemId).append(", ").
				append(iNode.state).append(", ").
				append(iNode.support).append(", ").
				append(iNode.roundIntroduced).append(", ").
				append(iNode.basketBatchIndexIntroduced).append("\n")
			if (iNode.children )
			{
				iNode.children.values().each { it ->
					traversalStack.push([it, tab + 3]) 
				}
			}
		}
		return buf.toString() 
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
	
	def getAt(Range rng) { return itemIds[rng] }
	
	void putAt(int i, int id)
	{
		itemIds[i] = id
	}
	
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
	
	public void writeJson(JsonBuilder json, Text t)
	{
		json( { "items" itemIds[0..<sz]
			"sz" sz
		})
		t.set(json.toString())
	}
	
	public void readJson(JsonSlurper json, Text t)
	{
		def o = json.parseText(t.toString())
		sz = (byte) o.sz
		if ( !itemIds || itemIds.length < sz)
		{
			itemIds = new int[sz]
		}
		(0..<sz).each { i -> itemIds[i] = o.items[i] }
	}
}

/*
 * An ISet that is an immediate subset (meaning with 1 less item) of another ISet.
 */
class ImmedSubSetISet extends ISet
{
	int idxToSkip
	ISet parentISet
	
	ImmedSubSetISet(ISet iSet, idxToSkip = -1)
	{
		parentISet = iSet
		this.idxToSkip = idxToSkip
	}
	
	int getAt(i) 
	{ 
		if ( i < idxToSkip )
		{
			return parentISet[i]
		}
		else
		{
			return parentISet[i+1]
		}
	}
	
	def getAt(Range rng) 
	{
		def r = []
		for(i in rng)
		{
			r << getAt(i)
		}
		return r
	}
	
	int size() { return parentISet.size() - 1; }
	
	public void writeJson(JsonBuilder json, Text t)
	{
		json( { "items" parentISet[0..<idxToSkip] + parentISet[(idxToSkip+1)..<(size() +1)]
			"sz" size()
		})
		t.set(json.toString())
	}
}

/*
* An ISet that is an immediate superset (meaning with 1 extra item) of another ISet.
*/
class ImmedSuperSetISet extends ISet
{
   int lastItemId
   ISet parentISet
   
   ImmedSuperSetISet(ISet iSet, int lastItemId)
   {
	   parentISet = iSet
	   this.lastItemId = lastItemId
   }
   
   int getAt(i)
   {
	   if ( i ==  parentISet.size() )
	   {
		   return lastItemId
	   }
	   else
	   {
		   return parentISet[i]
	   }
   }
   
   def getAt(Range rng)
   {
	   def r = []
	   for(i in rng)
	   {
		   r << getAt(i)
	   }
	   return r
   }
   
   int size() { return parentISet.size() + 1; }
   
   public void writeJson(JsonBuilder json, Text t)
   {
	   json( { "items" parentISet[0..<(size() -1)] + [lastItemId]
		   "sz" size()
	   })
	   t.set(json.toString())
   }
}

class SuffixISet extends ISet
{
	int startIdx
	
	SuffixISet(ISet iSet, int startIdx = 1)
	{
		sz = iSet.sz
		itemIds = iSet.itemIds
		this.startIdx = startIdx
	}
	
	SuffixISet(SuffixISet iSet, int startIdx = 1)
	{
		sz = iSet.sz
		itemIds = iSet.itemIds
		this.startIdx = iSet.startIdx + startIdx
	}
	
	int size() { return sz - startIdx; }
	
	int getAt(i)
	{
		return itemIds[i + startIdx]
	}
}

class ImmediateSuperSetsIterator implements Iterator<ImmedSuperSetISet>
{
	ImmedSuperSetISet itemSet
	DynamicItemCounting dic
	int nextId
	
	ImmediateSuperSetsIterator(ISet itemSet, DynamicItemCounting dic)
	{
		this.itemSet = new ImmedSuperSetISet(itemSet, -1)
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
	int nextIdxToSkip
	
	ImmediateSubSetsIterator(ISet itemSet, DynamicItemCounting dic)
	{
		this.itemSet = new ImmedSubSetISet(itemSet)
		nextIdxToSkip = 0
		this.dic = dic
		
	}

	public boolean hasNext()
	{
		return nextIdxToSkip < (itemSet.size() + 1)
	}
	
	public ISet next()
	{
		itemSet.idxToSkip = nextIdxToSkip++
		return itemSet
	}
	public void remove()
	{
		throw new UnsupportedOperationException()
	}
}

class FrequentItemSetIterator implements Iterator<String>
{
	private static final Log LOG = LogFactory.getLog("com.sap.hadoop.windowing.functions.marketbasket");
	
	ItemNode currNode
	ISet currentItemSet
	Stack<ItemNode> traversalStack
	JsonBuilder json
	Text iSetText
	Object[] itemValueList
	Object[] currentItemValueSet
	
	FrequentItemSetIterator(ItemNode rootNode, int[] itemIdArray, Object[] itemValueList)
	{
		currNode = rootNode
		this.itemValueList = itemValueList
		currentItemValueSet = new Object[itemValueList.length]
		currentItemSet = new ISet(sz : 0, itemIds : itemIdArray)
		traversalStack = new Stack<ItemNode>()
		currNode.traversalState = ItemNodeTraversal.DOWN
		traversalStack.push(currNode)
		json = new JsonBuilder()
		iSetText = new Text()
		moveToNextFrequentItemNode()
	}
	
	private void moveToNextFrequentItemNode()
	{
		while (!traversalStack.empty())
		{
			currNode = traversalStack.pop()
			
			if ( currNode.traversalState == ItemNodeTraversal.DOWN)
			{
				if ( currNode.state == ItemSetState.SOLID_SQUARE )
				{
					currNode.traversalState = ItemNodeTraversal.UP
					traversalStack.push(currNode)
					if ( currNode.children )
					{
						currNode.children.descendingMap().each { int id, ItemNode node ->
							node.traversalState = ItemNodeTraversal.DOWN
							traversalStack.push(node)
						}
					}
					if ( !currNode.isRoot())
					{
						currentItemSet.itemIds[currentItemSet.sz] = currNode.itemId
						currentItemValueSet[currentItemSet.sz] = itemValueList[currNode.itemId]
						currentItemSet.sz++
						return
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

	@Override
	public boolean hasNext()
	{
		return !traversalStack.empty();
	}

	@Override
	public String next()
	{
//		currentItemSet.writeJson(json, iSetText)
		writeCurrentItemJson(json, iSetText)
		LOG.info("Frequent ItemSet" + iSetText.toString())
		moveToNextFrequentItemNode()
		return iSetText.toString();
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
		
	}
	
	public void writeCurrentItemJson(JsonBuilder json, Text t)
	{
		json( { "items" currentItemValueSet[0..<(currentItemSet.sz)]
		})
		t.set(json.toString())
	}
	
}