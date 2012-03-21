package com.sap.hadoop.windowing.functions.marketbasket

import java.util.Map;

import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.IPartition;

class CandidateFrequentItemSets
{
	
}

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
	]
)
class CandidateFrequentItemSetsPhase1 extends AbstractTableFunction
{

	@Override
	protected IPartition execute(IPartition inpPart) throws WindowingException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, TypeInfo> getOutputShape()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
