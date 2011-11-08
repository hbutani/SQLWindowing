package com.sap.hadoop.windowing.functions

import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.Partition;

@FunctionDef(
	name = "first_value",
	supportsWindow = true,
	args =
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="skipNulls", typeName="boolean", optional=true, argTypes = [ArgType.STRING])
	]
)
abstract class FirstLastValue  extends IWindowFunction
{
	Script aggExpr
	boolean skipNulls
	
	abstract IntRange getPartitionRange(Partition p);
	abstract IntRange getWindowRange(Partition p, int r);
	
	def processPartition(Partition p)
	{
		if (!window)
		{
			IntRange pRng = getPartitionRange(p)
			def val = null
			def i = pRng.find {r -> 
				aggExpr.binding = p[r]
				val = aggExpr.run()
				return skipNulls || val != null
				}
			return new SameValueList( value: val, sz: p.size())
		}
		else
		{
			def exprArr = []
			for(r in 0..<p.size())
			{
				aggExpr.binding = p[r]
				exprArr << aggExpr.run()
			}
			def res = []
			for(r in 0..<p.size())
			{
				IntRange wrng = getWindowRange(p, r)
				def val = null
				def i = wrng.find {wr -> 
					val = exprArr[wr]
					return skipNulls || exprArr[wr] != null
				}
				res << val
			}
			return res
		}
	}

}

@FunctionDef(
	name = "first_value",
	supportsWindow = true,
	args =
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="skipNulls", typeName="boolean", optional=true, argTypes = [ArgType.STRING])
	]
)
class FirstValue  extends FirstLastValue
{
	IntRange getPartitionRange(Partition p) { return 0..<p.size() }
	IntRange getWindowRange(Partition p, int r) { return window.getRange(p, r) }

}

@FunctionDef(
	name = "last_value",
	supportsWindow = true,
	args =
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="skipNulls", typeName="boolean", optional=true, argTypes = [ArgType.STRING])
	]
)
class LastValue  extends FirstLastValue
{
	IntRange getPartitionRange(Partition p) 
	{ 
		IntRange r = 0..<p.size() 
		r.reverse = true
		return r
	}
	IntRange getWindowRange(Partition p, int r) 
	{ 
		IntRange wr = window.getRange(p, r) 
		wr.reverse = true
		return wr
	}

}
