package com.sap.hadoop.windowing.functions

import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.runtime.ArgType;

class LinearRegression
{

}

class LinearRegSlopeResult
{
	double sumxy = 0
	double sumx = 0
	double sumy = 0
	int sumx2 = 0
	int cnt = 0
	
	LinearRegSlopeResult(double x, double y)
	{
		add(x, y)
	}
	
	double result()
	{
		double num = (cnt * sumxy) - (sumx * sumy)
		double den = (cnt * sumx2) - (sumx * sumx)
		return num / den
	}
	
	void add(double x, double y)
	{
		sumxy += x * y
		sumx += x
		sumy += y
		sumx2 += (x * x)
		cnt += 1
	}
}

@FunctionDef(
	name = "linearRegSlope",
	typeName="double",
	supportsWindow = true,
	description="""computes the slope of the regression line fitted to non-null (x, y) pairs.""",
	args =
	[
		@ArgDef(name="expr1", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="expr2", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class LinearRegSlope extends TwoVarFunctions
{
	def nextValue(val1, val2, State s)
	{
		if ( val1 && val2 )
		{
			if (!s.res)
			{
				s.res = new LinearRegSlopeResult(val1, val2)
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

class LinearRegInterceptResult extends LinearRegSlopeResult
{
	LinearRegInterceptResult(double x, double y)
	{
		super(x, y)
	}
	
	double result()
	{
		double num = (sumy * sumx2) - (sumx * sumxy)
		double den = (cnt * sumx2) - (sumx * sumx)
		return num / den
	}
}

@FunctionDef(
	name = "linearRegIntercept",
	typeName="double",
	supportsWindow = true,
	description="""computes the intercept of the regression line fitted to non-null (x, y) pairs.""",
	args =
	[
		@ArgDef(name="expr1", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="expr2", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class LinearRegIntercept extends TwoVarFunctions
{
	def nextValue(val1, val2, State s)
	{
		if ( val1 && val2 )
		{
			if (!s.res)
			{
				s.res = new LinearRegInterceptResult(val1, val2)
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

class RegCountResult
{
	int cnt = 0
	
	RegCountResult(double x, double y)
	{
		add(x, y)
	}
	
	int result()
	{
		return cnt
	}
	
	void add(double x, double y)
	{
		cnt += 1
	}
}

@FunctionDef(
	name = "regCount",
	typeName="int",
	supportsWindow = true,
	description="""returns the number of non-null (x, y) pairs.""",
	args =
	[
		@ArgDef(name="expr1", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID]),
		@ArgDef(name="expr2", typeName="script", argTypes = [ArgType.STRING, ArgType.SCRIPT, ArgType.ID])
	]
)
class RegCount extends TwoVarFunctions
{
	def nextValue(val1, val2, State s)
	{
		if ( val1 && val2 )
		{
			if (!s.res)
			{
				s.res = new RegCountResult(val1, val2)
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

