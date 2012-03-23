package com.sap.hadoop.windowing.query

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.parser.QSpecBuilder.typeName_return;
import com.sap.hadoop.windowing.runtime.HiveQueryExecutor;

/**
 * Responsible for converting the input {@link Query} into a list of component {@link QuerySpec}.
 * The Function Chain is split at the following positions:
 * <ul>
 * <li> If the {@link TableFuncSpec} has a partition specification.
 * <li> If the {@link TableFuncSpec} has a Map Phase.
 * </ul>
 * 
 * The splitting is done in the following way:
 * <ul>
 * <li> The current QuerySpec is cloned into 2 QSpecs: current, rest.
 * <li> For the 'current' QSpec:
 * <ul>
 * <li> The function chain is set from the input function up to the function previous to the split position.
 * <li> The whereExpr is cleared.
 * <li> The selectList is set to Columns based on the previous function's OutputShape.
 * <li> The QuerySpec's tableOutput is changed so that the outputPath is a jobWorking directory; the output
 * SerDe and properties are LazyBinarySerDe. A Temporary table is created based on the OutputShape of the previous
 * function. The QuerySpec's output tableName is set to this Table.
 * </ul>
 * <li> For the 'rest' QSpec:
 * <ul>
 * <li> The function chain is set from the split position upto to the end.
 * <li> The QuerySpec's tableInput is changed to point the table created above. Hive Query is set to a non null String to trigger 
 * deletion of the table at the end of this job. QuerySpec's inputSerDe, format is set based on ColumnarSerDe.
 * <li> set Query's partition & order clause based on function's partition & order spec.
 * <li>  The split algorithm is recursively applied on the 'rest' QuerySpec.
 * </ul>
 * </ul>
 * @author harish.butani
 *
 */
class QueryComponentizer
{
	Query qry
	QuerySpec qSpec
	AbstractTableFunction startFunc
	HiveQueryExecutor hiveQryExec
	
	QueryComponentizer(Query qry, HiveQueryExecutor hiveQryExec)
	{
		this.qry = qry
		qSpec = qry.qSpec
		startFunc = qry.tableFunction
		this.hiveQryExec = hiveQryExec
		
		/*
		* skip over final Windowing Table Function.
		*/
	   if ( ! qry?.wnFns.empty )
	   {
		   startFunc = startFunc.input
	   }
	}
	
	ArrayList<QuerySpec> componentize()
	{
		ArrayList<QuerySpec> componentQSpecs = []
		
		ArrayList<Integer> splitPositions = computeSplitPositions();
		QuerySpec currentQSpec = qry.qSpec
		
		for(int splitPos : splitPositions)
		{
			ArrayList<QuerySpec> qSpecs = split(currentQSpec, splitPos);
			componentQSpecs << qSpecs[0]
			currentQSpec = qSpecs[1]
		}
		
		return componentQSpecs;
	}
	
	/*
	 * walk function chain, record positions where function execution requires a separate Job.
	 * reverse list before returning
	 */
	ArrayList<Integer> computeSplitPositions()
	{
		ArrayList<Integer> positions = []
		
		AbstractTableFunction tFunc = qry.tableFunction
		TableFuncSpec tFuncSpec = qry.qSpec.tblFuncSpec;
		
		
		
		//int idx = qry.qSpec.getFunctionChainLength() - 1
		int idx = 0
		
		while( tFunc != null )
		{
			/*
			 * the or condition was wrong
			 * - the contract of a MapPhae is that the function gets a chance to reshape the data before it is
			 * partitioned & ordered.
			 * - when no partition, order is specified the partition is first run through the mapPhase function and 
			 * then the regular execute function. All this happens in the Reduce Phase of the previous function(s) Job.
			 */
			if ( tFuncSpec.hasParitionSpec() /*|| (tFunc.hasMapPhase() && idx > 0)*/ )
			{
				positions << idx
			}
			tFunc = tFunc.input
			tFuncSpec = tFuncSpec.inputFuncSpec
			idx++;
		}
		
		positions = positions.reverse()
		
		return positions;
	}
	
	/**
	 * 
	 * @param originalQuery
	 * @param qSpec
	 * @param splitPos position in function chain where QuerySpec needs to be split.
	 * @return
	 */
	protected ArrayList<QuerySpec> split(QuerySpec qSpec, int splitPos)
	{
		QuerySpec current = (QuerySpec) qSpec.clone();
		QuerySpec rest = (QuerySpec) qSpec.clone();
				
		AbstractTableFunction boundaryFunc = getBoundaryFunction(splitPos)
		
		/* Setup current 
		*/
		
		/*
		 * The function chain is set from the input function up to the function previous to the split position.
		 */
		setupChainForCurrent(current, splitPos)
		
		/* 
		* The whereExpr is cleared.
		*/
		current.whereExpr = null
		
		/*
		 * The selectList is set to Columns based on the previous function's OutputShape.
		 */
		Map<String, TypeInfo> currentShape = boundaryFunc.getOutputShape()
		current.selectColumns.clear()
		currentShape.each { String cn, TypeInfo ctype ->
			current.selectColumns << new SelectColumn(alias : cn, typeName : ctype.typeName)
		}
		
		/*
		 * The QuerySpec's tableOutput is changed so that the outputPath is a jobWorking directory; the output
		 * SerDe and properties are ColumnarSerDe. A Temporary table is created based on the OutputShape of the previous
		 * function. The QuerySpec's output tableName is set to this Table.
		 */
		String jobDir = qry.cfg.get(Constants.WINDOWING_JOB_WORKING_DIR);
		String currentOutputPath = sprintf("%s/componentquery-%d/", jobDir, splitPos)

		String currrentQueryTableName = createComponentQueryOutputTable(current, splitPos)
		current.tableOut.outputPath = currentOutputPath
		current.tableOut.serDeClass = 'org.apache.hadoop.hive.serde2.columnar.ColumnarSerDe'
		current.tableOut.outputFormat = 'org.apache.hadoop.hive.ql.io.RCFileOutputFormat'
		current.tableOut.tableName = currrentQueryTableName
		
		/* end Setup current
		*/
		
		/*
		 * Setup rest
		 */
		
		/*
		* The function chain is set from the split position upto to the end.
		*/
		setupChainForRest(rest, splitPos)
		
		/*
		* The QuerySpec's tableInput is changed to point the table created above. Hive Query is set to a non null String to trigger
		* deletion of the table at the end of this job. QuerySpec's inputSerDe, format is set based on ColumnarSerDe.
		*/
		
		/*
		* set Query's partition & order clause based on function's partition & order spec.
		*/
		
		/*
		* end Setup rest
		*/
		
		ArrayList<QuerySpec> ret = [current, rest]
		
		return ret
	}
	
	private void setupChainForCurrent(QuerySpec qSpec, int splitPos)
	{
		int i = 0;
		TableFuncSpec tFuncSpec = qSpec.tblFuncSpec;
		while(i < splitPos)
		{
			tFuncSpec = tFuncSpec.inputFuncSpec
			i++
		}
		qSpec.tblFuncSpec = tFuncSpec.inputFuncSpec
	}
	
	private void setupChainForRest(QuerySpec qSpec, int splitPos)
	{
		int i = 0;
		TableFuncSpec tFuncSpec = qSpec.tblFuncSpec;
		while(i < splitPos)
		{
			tFuncSpec = tFuncSpec.inputFuncSpec
			i++
		}
		tFuncSpec.inputFuncSpec = null
	}
	
	private AbstractTableFunction getBoundaryFunction(int splitPos)
	{
		int i = 0;
		AbstractTableFunction tFunc = startFunc
		while(i < splitPos)
		{
			tFunc = tFunc.input
			i++
		}
		return tFunc.input
	}
	
	private String createComponentQueryOutputTable(QuerySpec componentQrySpec, int splitPos) throws WindowingException
	{		
		String tableName = "WdwQryCompTempTable_${splitPos}_${System.currentTimeMillis()}"
		
		String hql = "create table ${tableName} ("
		hql += componentQrySpec.selectColumns.collect { sc -> "${sc.alias} ${sc.typeName}"}.join(", ")
		hql += ") ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.columnar.ColumnarSerDe' STORED AS RCFILE "
		
		hiveQryExec.executeHiveQuery(hql);
		return tableName
	}

}
