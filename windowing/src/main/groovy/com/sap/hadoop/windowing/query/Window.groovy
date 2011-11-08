package com.sap.hadoop.windowing.query

import com.sap.hadoop.windowing.runtime.Partition;

class Window
{
	Boundary start
	Boundary end
	
	def getRange(Partition p, int row)
	{
		int s = start.getIndex(p, row)
		int e = end.getIndex(p, row)
		return s..e
	}
	
	public String toString()
	{
		return sprintf( 'window(start=%s, end=%s)', start, end)
	}
	
	void parse(GroovyShell wshell)
	{
		start.parse(wshell)
		end.parse(wshell)
	}
}

abstract class Boundary
{
	static def UNBOUNDED_AMOUNT = new Object()
	abstract int getIndex(Partition p, int row)
	
	abstract int compare(Boundary other);
	abstract Direction getDirection();
	
	void parse(GroovyShell wshell)
	{
	}
}

enum Direction
{
	PRECEDING,
	CURRENT,
	FOLLOWING
}

class RangeBoundary extends Boundary
{
	Direction direction
	def amt
	
	int getIndex(Partition p, int row)
	{
		switch(direction)
		{
			case Direction.PRECEDING:
				if ( amt == UNBOUNDED_AMOUNT) return 0;
				return Math.max(0, row-amt)
			case Direction.FOLLOWING:
			if ( amt == UNBOUNDED_AMOUNT) return p.size() - 1;
			return Math.min(p.size() - 1, row+amt)
		}
	}
	
	public String toString()
	{
		return sprintf( 'range(%s %s)', (amt == UNBOUNDED_AMOUNT ? "Unbounded" : amt), direction)
	}
	
	int compare(Boundary other)
	{
		int c = direction <=> other.direction;
		if ( c != 0) return c;
		return amt <=> other.amt;
	}
}

class CurrentRow extends Boundary
{
	int getIndex(Partition p, int row)
	{
		return row
	}
	public String toString()
	{
		return sprintf( 'currentRow')
	}
	
	Direction getDirection() { return Direction.CURRENT; }
	
	int compare(Boundary other)
	{
		return direction <=> other.direction;
	}
}

class ValueBoundary extends Boundary
{
	Direction direction
	Script expression
	String exprString
	def amt
	
	void parse(GroovyShell wshell)
	{
		expression = wshell.parse(exprString)
	}
	int getIndex(Partition p, int row)
	{
		switch(direction)
		{
			case Direction.PRECEDING:
				expression.binding = p[row]
				def rowval = expression.run()
				rowval = rowval - amt
				row--
				while(row >= 0)
				{
					expression.binding = p[row]
					def curr = expression.run()
					if ( curr < rowval )
					{
						return row + 1
					}
					row--
				}
				return 0
			case Direction.FOLLOWING:
				expression.binding = p[row]
				def rowval = expression.run()
				rowval = rowval + amt
				row++
				while(row < p.size())
				{
					expression.binding = p[row]
					def curr = expression.run()
					if ( curr > rowval )
					{
						return row + 1
					}
					row--
				}
				return p.size() - 1
		}
	}
	public String toString()
	{
		return sprintf( 'value(%s %s %s)', exprString, amt, direction)
	}

	int compare(Boundary other)
	{
		int c = direction <=> other.direction;
		if ( c != 0) return c;
		return amt <=> other.amt;
	}
}