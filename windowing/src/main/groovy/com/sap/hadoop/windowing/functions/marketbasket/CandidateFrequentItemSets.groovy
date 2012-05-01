package com.sap.hadoop.windowing.functions.marketbasket

import groovy.lang.GroovyShell;

import java.util.Map;

import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.query.FuncSpec;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.TypeUtils;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.IPartition;
import com.sap.hadoop.windowing.runtime.Row;
import com.sap.hadoop.windowing.runtime.TableFunctionOutputPartition;

import org.apache.hadoop.conf.Configuration

@FunctionDef(
	name = "candidateFrequentItemSets",
	description="""Implements the first step of the SON Algorithm. Output is the list of Candidate Items as a json String along with Counts.
""",
	supportsWindow = false,
	args = [
		@ArgDef(name="txnColumn", typeName="string", argTypes = [ArgType.STRING],
			description="""The column that represents the txn Id.
"""
		),
		@ArgDef(name="itemColumn", typeName="string", argTypes = [ArgType.STRING],
			description="""The column that represents the item name/id.
"""),
		@ArgDef(name="minCount", typeName="int", argTypes = [ArgType.NUMBER],
			description="""minimum number of items in the candidate itemsets output
"""),
	@ArgDef(name="maxCount", typeName="int", argTypes = [ArgType.NUMBER],
	description="""maximum number of items in the candidate itemsets output
"""),
@ArgDef(name="includeList", typeName="expression", argTypes = [ArgType.SCRIPT], optional=true,
	description="""an expression used to check inclusion criteria. At least one item from the list must appear in 
candidate itemsets that will be returned. 
"""),
@ArgDef(name="excludeList", typeName="expression", argTypes = [ArgType.SCRIPT], optional=true,
	description="""an expression used to check exclusion criteria. No item from the list must appear in
candidate itemsets that will be returned.
""")
	],
	hasMapPhase = true
)
class CandidateFrequentItemSets extends AbstractTableFunction
{
	String txnColumn
	String itemColumn
	int minCount
	int maxCount
	Script includeList
	Script excludeList
	TypeInfo txnColType
	TypeInfo itemColType
	Map<String, TypeInfo> typeMap
	Configuration cfg
	SerDe mapOutputSerDe

	protected void completeTranslation(GroovyShell wshell, Query qry, FuncSpec funcSpec) throws WindowingException
	{
		Map<String, TypeInfo> iTypeMap = getInputTypeMap(wshell, qry, funcSpec)
		
		/* validate txn & item column names */
		Map.Entry tEntry = iTypeMap.find { String n, t -> n.toLowerCase() == txnColumn.toLowerCase()}
		if (!tEntry)
		{
			throw new WindowingException(sprintf("Unknown column '%s' set as txn Column", txnColumn))
		}
		txnColType = tEntry.value
		
		Map.Entry iEntry = iTypeMap.find { String n, t -> n.toLowerCase() == itemColumn.toLowerCase()}
		if (!tEntry)
		{
			throw new WindowingException(sprintf("Unknown column '%s' set as item Column", itemColumn))
		}
		itemColType = tEntry.value
		
		/* item type must be primitive */
		if (itemColType.getCategory() != Category.PRIMITIVE )
		{
			throw new WindowingException(sprintf("Item Column '%s' type must be primitive", itemColumn))
		}
		
		/* set typeMap to (Array<type of item column>) */
		typeMap = ['itemset' : TypeInfoFactory.getListTypeInfo(itemColType)]
		
		cfg = qry.cfg
		
		
		mapOutputSerDe = TypeUtils.createLazyBinarySerDe(qry.cfg, typeMap)
	}

	@Override
	public Map<String, TypeInfo> getOutputShape()
	{
		return typeMap
	}
	
	public Map<String, TypeInfo> getMapPhaseOutputShape()
	{
		return typeMap
	}
	
	public SerDe getMapOutputPartitionSerDe()
	{
		return mapOutputSerDe
	}
	
	protected IPartition mapExecute(IPartition inpPart) throws WindowingException
	{
		/*
		 * - Create an OutputPartition based on the typeMap
		 * - for now write each Item as a list to the partition
		 *   - Struct is [[itemlist]] outer list is for the record, inner list is for the itemset column.
		 * - return the output partition.
		 */
		
		TableFunctionOutputPartition oPartition = new TableFunctionOutputPartition(tableFunction: this, mapSide : true, serDe : mapOutputSerDe)
		oPartition.initialize(cfg)
		
		for(Row r : inpPart)
		{
			def oRow = [[r[itemColumn]]]
			oPartition << oRow
		}
		
		return oPartition
	}
	
	@Override
	protected IPartition execute(IPartition inpPart) throws WindowingException
	{
		/*
		 * Create an OutputPartition based on the typeMap
		 * Output the first row only to the output.
		 */
		TableFunctionOutputPartition oPartition = new TableFunctionOutputPartition(tableFunction: true, mapSide : false)
		oPartition.initialize(cfg)
		
		if ( inpPart.size() > 0 )
		{
			Row r = inpPart[0]
			def oRow = [[r[itemColumn]]]
			oPartition << oRow
		}
		return oPartition
	}
	


}
