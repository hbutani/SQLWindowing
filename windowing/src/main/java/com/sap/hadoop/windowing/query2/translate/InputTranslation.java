package com.sap.hadoop.windowing.query2.translate;

import java.util.Iterator;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.specification.OrderSpec;
import com.sap.hadoop.windowing.query2.specification.PartitionSpec;
import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;

import static com.sap.hadoop.Utils.sprintf;

/*
 * All the functionality dealing with translating input specifcations.
 */
public class InputTranslation
{
	
	public static void translate(QueryDef qDef) throws WindowingException
	{
		EnsureTableFunctionInQuery.execute(qDef);
		SlidePartitionAndOrderSpecs.execute(qDef);
	}

	/*
	 * If query has no table function, then add one: if query has window functions add the WindowingTableFunc; else add the Noop table function.
	 */
	static ITranslationTask EnsureTableFunctionInQuery = new ITranslationTask() {
		public void execute(QueryDef qDef) throws WindowingException
		{
			QuerySpec qSpec = qDef.getSpec();
			boolean hasTableFunction = TranslateUtils.hasTableFunctions(qSpec);
			if ( hasTableFunction)
			{
				return;
			}
			
			boolean hasWindowFunctions = TranslateUtils.hasWindowFunctions(qSpec);
			String fnName = hasWindowFunctions ? FunctionRegistry.WINDOWING_TABLE_FUNCTION : FunctionRegistry.NOOP_TABLE_FUNCTION;
			TableFuncSpec tSpec = new TableFuncSpec();
			tSpec.setName(fnName);
			tSpec.setInput(qSpec.getInput());
			qSpec.setInput(tSpec);
		}
	};
	
	/*
	 * Shift the Partition & OrderSpec in the Input Chain.
	 * During passing the Partition & Order Specs are associated with the Input that needs to be partitioned.
	 * But for Query building it is better to associate the Part & Order specs with the TableFunc that acts on the input i.e. the next one in the chain.
	 * Also make the following checks:
	 * <ol>
	 * <li> First Input in chain must have an Partition & Order specified.
	 * <li> Last Input in chain must not have a Partition & Order specified.
	 * </ol>
	 */
	static ITranslationTask SlidePartitionAndOrderSpecs =  new ITranslationTask() {
		public void execute(QueryDef qDef) throws WindowingException
		{
			QuerySpec qSpec = qDef.getSpec();
			Iterator<QueryInputSpec> it = TranslateUtils.iterateInputSpecs(qSpec, true);
			QueryInputSpec curr = it.next();
			PartitionSpec prevPSpec = curr.getPartition();
			OrderSpec prevOSpec = curr.getOrder();
			validateFirst(curr);
			while(it.hasNext())
			{
				curr = it.next();
				PartitionSpec nextPSpec = curr.getPartition();
				OrderSpec nextOSpec = curr.getOrder();
				curr.setPartition(prevPSpec);
				curr.setOrder(prevOSpec);
				prevPSpec = nextPSpec;
				prevOSpec = nextOSpec;
			}
			validateLast(curr);
		}
		
		void validateFirst(QueryInputSpec qInSpec) throws WindowingException
		{
			if ( qInSpec.getPartition() == null  )
			{
				throw new WindowingException(sprintf("Input must have a Partition specified: %s", qInSpec));
			}
		}
		
		void validateLast(QueryInputSpec qInSpec) throws WindowingException
		{
			if ( qInSpec.getPartition() != null )
			{
				throw new WindowingException(sprintf("Last Function in Chain cannot have a Partitioning specified: %s", qInSpec));
			}
		}
	};
}
