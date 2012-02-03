package com.sap.hadoop.windowing.functions

import groovy.lang.Script;

import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.Partition;
import com.sap.hadoop.windowing.runtime.Row;


abstract class TwoVarFunctions extends IWindowFunction
{
	Script expr1
	Script expr2
	
	def processPartition(Partition p)
	{
		if (!window)
		{
			def state = initializeState(p)
			Row row = p.getRowObject()
			row.bind(expr1)
			row.bind(expr2)
			for(r in 0..<p.size())
			{
				row = p[r]
				def val1 = expr1.run()
				def val2 = expr2.run()
				state = nextValue(val1, val2, state)
			}
			return new SameValueList( value: getResult(state), sz: p.size())
		}
		else
		{
			def expr1Arr = []
			def expr2Arr = []
			Row row = p.getRowObject()
			row.bind(expr1)
			row.bind(expr2)
			for(r in 0..<p.size())
			{
				row = p[r]
				expr1Arr << expr1.run()
				expr2Arr << expr2.run()
			}
			def res = []
			for(r in 0..<p.size())
			{
				def rng = window.getRange(p, r)
				def state = initializeState(p, rng)
				for(i in rng)
				{
					state = nextValue(expr1Arr[i], expr2Arr[i], state)
				}
				res << getResult(state)
			}
			return res
		}
	}
	
	def initializeState(Partition p, def windowrng=null)
	{
		State s = new State(p : p)
		s.rng = windowrng
		s.res = null
		return s
	}
	abstract def nextValue(val1, val2, State state)
	def getResult(State s) { return s.res; }
}

class CoVarianceResult
{
	double product
	double expr1
	double expr2
	int cnt
	
	CoVarianceResult(double e1, double e2)
	{
		product = e1 * e2
		expr1 = e1
		expr2 = e2
		cnt = 1
	}
	
	//(SUM(expr1 * expr2) - SUM(expr2) * SUM(expr1) / n) / n
	double result()
	{
		return (product - (expr1 * expr2/cnt))/cnt
	}
	
	void add(double e1, double e2)
	{
		product += e1 * e2
		expr1 += e1
		expr2 += e2
		cnt += 1
	}
}

@FunctionDef(
	name = "covariance",
	typeName="double",
	supportsWindow = true,
	description="""applies the function to the set of (expr1, expr2) pairs after eliminating all pairs for which either expr1 or expr2 is null.
	Then computes: E[XY] - E[X]E[Y]
	The function returns a double. returns null for an empty set.""",
	args =
	[
		@ArgDef(name="expr1", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="expr2", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class CoVariance extends TwoVarFunctions
{
	def nextValue(val1, val2, State s)
	{
		if ( val1 && val2 )
		{
			if (!s.res)
			{
				s.res = new CoVarianceResult(val1, val2)
			}
			else
			{
				s.res.add(val1, val2)
			}
		}
		return s
	}
	
	def getResult(State s)
	{
		if ( !s.res) {
			return null
		}
		return s.res.result();
	}
}

