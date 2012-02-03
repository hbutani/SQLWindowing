package com.sap.hadoop.windowing.functions

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.query.Window;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.Partition;
import com.sap.hadoop.windowing.functions.annotations.ArgDef;

abstract class Aggregate extends IWindowFunction
{
	Script aggExpr
	
	def processPartition(Partition p)
	{
		if (!window)
		{
			def state = initializeState(p)
			for(r in 0..<p.size())
			{
				aggExpr.binding = p[r]
				def val = aggExpr.run()
				state = nextValue(val, state)
			}
			return new SameValueList( value: getResult(state), sz: p.size())
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
				def rng = window.getRange(p, r)
				def state = initializeState(p, rng)
				for(i in rng)
				{
					state = nextValue(exprArr[i], state)
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
	abstract def nextValue(val, state)
	def getResult(s) { return s.res; }
}

class State
{
	Partition p
	def rng
	def res
}

@FunctionDef(
	name = "sum",
	supportsWindow = true,
	args = 
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class Sum extends Aggregate
{
	def nextValue(val, s)
	{
		if (!s.res) s.res = val else s.res += val
		return s
	}
}

@FunctionDef(
	name = "min",
	supportsWindow = true,
	args =
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class Min extends Aggregate
{
	def nextValue(val, s)
	{
		if (!s.res) s.res = val
		else
		{
				int c = s.res.compareTo(val)
				if ( c > 0 ) s.res = val
		}
		return s
	}
}

@FunctionDef(
	name = "max",
	supportsWindow = true,
	args =
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class Max extends Aggregate
{
	def nextValue(val, s)
	{
		if (!s.res) s.res = val
		else
		{
				int c = s.res.compareTo(val)
				if ( c < 0 ) s.res = val
		}
		return s
	}
}

@FunctionDef(
	name = "avg",
	typeName="double",
	supportsWindow = true,
	args =
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class Avg extends Aggregate
{
	def nextValue(val, s)
	{
		if ( val )
		{
			if (!s.res) 
			{
				s.res = [1, val] 
			}
			else 
			{
				s.res[0]++
				s.res[1] += val
			}
		}
		return s
	}
	
	def getResult(s) 
	{ 
		return s.res ? s.res[1]/ ((double)s.res[0]) : null;
	}
}

@FunctionDef(
	name = "stddev",
	typeName="double",
	supportsWindow = true,
	args =
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class StdDev extends Aggregate
{
	def nextValue(val, s)
	{
		if ( val )
		{
			if (!s.res)
			{
				s.res = [1, val, [val]]
			}
			else
			{
				s.res[0]++
				s.res[1] += val
				s.res[2] << val
			}
		}
		return s
	}
	
	def getResult(State s)
	{
		if ( !s.res) {
			return null
		}
		
		double mean = s.res[1]/ ((double)s.res[0])
		def sumDiff = (double) 0
		for(e in s.res[2])
		{
			def d = (e - mean)
			def t =  d * d
			sumDiff  += t
		}
		return Math.sqrt(sumDiff/s.res[2].size())
	}
}

@FunctionDef(
	name = "count",
	supportsWindow = true,
	typeName = "int",
	args =
	[
		@ArgDef(name="aggExpr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="countType", typeName="string", optional=true, argTypes = [ArgType.STRING])
	]
)
class Count extends Aggregate
{
	String countType;
	Closure _nextValue = this.&defaultnextValue;
	Closure _getResult = this.&defaultgetResult;
	
	public void setCountType(String t) throws WindowingException
	{
		countType = t.toLowerCase();
		switch(countType)
		{
			case "all":
				_nextValue = this.&allnextValue;
				break;
			case "distinct" : 
				_nextValue = this.&distinctnextValue;
				_getResult = this.&distinctgetResult;
				break;
			default:
				throw new WindowingException(sprintf("Unknown Count Flag %s", t))
		}
	}

	def nextValue(val, s) { return _nextValue(val, s) }
	def getResult(s) { return _getResult(s) }
	
	def defaultnextValue(val, s)
	{
		if ( val )
		{
			if (!s.res) { s.res = (int) 0 }
			s.res++
		}
		return s
	}
	
	def defaultgetResult(s) { return s.res; }
	
	def allnextValue(val, s)
	{
		if (!s.res) { s.res = (int) 0 }
		s.res++
		return s
	}

		def distinctnextValue(val, s)
	{
		if(val)
		{
			if (!s.res) { s.res = new HashSet() }
			s.res.add(val);
		}
		return s
	}
	
	def distinctgetResult(s)
	{
		return s.res ? s.res.size() : null;
	}
}

class VPopResult
{
	double exprsquare
	double exp
	int cnt 
	
	VPopResult(double val)
	{
		exprsquare = val * val
		exp = val
		cnt = 1
	}
	
	//(SUM(expr2) - SUM(expr)2 / COUNT(expr)) / COUNT(expr)
	double result()
	{
		return (exprsquare - (Math.pow(exp, 2.0)/cnt))/cnt
	}
	
	void add(double val)
	{
		exprsquare += val * val
		exp += val
		cnt += 1
	}
}
@FunctionDef(
	name = "varpop",
	typeName="double",
	supportsWindow = true,
	description="returns the population variance of a set of numbers after discarding the nulls in this set.",
	args =
	[
		@ArgDef(name="expr", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class VarPop extends Aggregate
{
	def nextValue(val, s)
	{
		if ( val )
		{
			if (!s.res)
			{
				s.res = new VPopResult(val)
			}
			else
			{
				s.res.add(val)
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

class CoVarPopResult
{
	double product
	double expr1
	double expr2
	int cnt
	
	CoVarPopResult(double e1, double e2)
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
	name = "covarpop",
	typeName="double",
	supportsWindow = true,
	description="""applies the function to the set of (expr1, expr2) pairs after eliminating all pairs for which either expr1 or expr2 is null.
Then computes: (SUM(expr1 * expr2) - SUM(expr2) * SUM(expr1) / n) / n
	where n is the number of (expr1, expr2) pairs where neither expr1 nor expr2 is null.
	The function returns a double. returns null for an empty set.""",
	args =
	[
		@ArgDef(name="expr1", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="expr2", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class CoVarPop extends Aggregate
{
	def nextValue(val, s)
	{
		if ( val )
		{
			if (!s.res)
			{
				s.res = new VPopResult(val)
			}
			else
			{
				s.res.add(val)
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

class SameValueList
{
	def value
	int sz
	
	def getAt(i) 
	{ 
		return value;
	}
	
	def size() { return sz }
}
