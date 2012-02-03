package com.sap.hadoop.windowing.functions

import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.query.OrderColumn;
import com.sap.hadoop.windowing.runtime.InputObj;
import com.sap.hadoop.windowing.runtime.Partition;


@FunctionDef(
	name = "rownumber",
	description="""The ROW_NUMBER function assigns a unique number (sequentially, 
starting from 1, as defined by ORDER BY) to each row within the partition.
""",
	typeName = "int",
	supportsWindow = false
	)
class RowNumber extends IWindowFunction
{
	def processPartition(Partition p)
	{
		def rownum = 1..p.size()
		return rownum
		
	}
}

static def compare(InputObj o1, InputObj o2, OrderColumn[] orderColumns)
{
	for(OrderColumn col in orderColumns)
	{
		int c = o1[col.name] <=> o2[col.name]
		if (c != 0) return c
	}
	return 0
}

abstract class BaseRank extends IWindowFunction
{
	def processPartition(Partition p)
	{
		def res = []
		int currRank = 1
		int count = 1
		InputObj currVal = new InputObj(p: p, idx:0)
		res << currRank
		InputObj nextVal = new InputObj(p: p, idx:0)
		for(i in 1..<p.size())
		{
			nextVal.idx = i
			count++
			int c = Ranking.compare(currVal, nextVal, orderColumns)
			if ( c != 0)
			{
				currRank = nextRank(currRank, count)
				currVal.idx = i
			}
			res << currRank
		}
		return res
	}
	
	abstract int nextRank(int currRank, int rowIdx)
}

@FunctionDef(
	name = "rank",
	typeName = "int",
	supportsWindow = false
	)
class Rank extends BaseRank
{
	
	int nextRank(int currRank, int rowIdx)
	{
		return rowIdx
	}
}

@FunctionDef(
	name = "denserank",
	description="""The difference between RANK and DENSE_RANK is that DENSE_RANK leaves no
gaps in ranking sequence when there are ties. That is, if you were 
ranking a competition using DENSE_RANK and had three people tie for 
second place, you would say that all three were in second place and 
that the next person came in third.""",
	typeName = "int",
	supportsWindow = false
	)
class DenseRank extends BaseRank
{
	
	int nextRank(int currRank, int rowIdx)
	{
		return currRank + 1
	}
}

@FunctionDef(
	name = "cumedist",
	description="""The CUME_DIST function (defined as the inverse of percentile in some 
statistical books) computes the position of a specified value relative to a set of values.
To compute the CUME_DIST of a value x in a set S of size N, you use the formula:

CUME_DIST(x) =  number of values in S coming before 
   and including x in the specified order/ N

""",
	typeName = "double",
	supportsWindow = false
	)
class CumeDist extends IWindowFunction
{
	def processPartition(Partition p)
	{
		def res = []
		def sz = p.size()
		double denom = sz // force output to be a double
		for(i in 0..<sz)
		{
			res << (i + 1) / denom
		}
		return res
	}
}

@FunctionDef(
	name = "percentrank",
	description="""PERCENT_RANK is similar to CUME_DIST, but it uses rank values rather 
than row counts in its numerator. PERCENT_RANK of a row is calculated as:

(rank of row in its partition - 1) / (number of rows in the partition - 1)

""",
	typeName = "double",
	supportsWindow = false
	)
class PercentRank extends Rank
{
	def processPartition(Partition p)
	{
		def res = super.processPartition(p)
		def sz = res.size()
		double denom = sz > 1 ? sz - 1 : sz
		for(i in 0..<sz)
		{
			res[i] = (res[i] - 1)/denom
		}
		return res
	}
}

@FunctionDef(
	name = "ntile",
	description="""NTILE allows easy calculation of tertiles, quartiles, deciles and other 
common summary statistics. This function divides an ordered partition into a specified 
number of groups called buckets and assigns a bucket number to each row in the partition.
""",
	typeName = "int",
	supportsWindow = false,
	args =
	[
		@ArgDef(name="nbuckets", typeName="int", argTypes = [ArgType.SCRIPT, ArgType.NUMBER])
	]
)
class NTile extends IWindowFunction
{
	int nbuckets
	
	def processPartition(Partition p)
	{
		def bucketsz = p.size() / nbuckets
		def rem = p.size() % nbuckets
		int start = 0
		int bucket = 1
		def res = []
		while ( start < p.size())
		{
			int end = start + bucketsz
			if (rem > 0)
			{
				end++; rem--
			}
			end = Math.min(p.size(), end)
			for(i in start..<end)
			{
				res << bucket
			}
			start = end
			bucket++
		}
		
		return res
	}
}