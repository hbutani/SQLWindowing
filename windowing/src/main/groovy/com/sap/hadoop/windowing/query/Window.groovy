package com.sap.hadoop.windowing.query

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.runtime.Partition;

class Window implements Writable
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
	
	static def BOUNDARYTOTYPEMAP = [(RangeBoundary.class): 0,(CurrentRow.class):1,(ValueBoundary.class):2]
	static def BOUNDARYTYPES = [RangeBoundary.class,CurrentRow.class,ValueBoundary.class]
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		int nullFlags = 0
		if ( start )      nullFlags |= 0x01
		if ( end )        nullFlags |= 0x02
		out.writeInt(nullFlags)
		if ( (nullFlags & 0x01) )
		{
			out.writeInt(BOUNDARYTOTYPEMAP[start.class])
			start.write(out)
		}
		if ( (nullFlags & 0x02) )
		{
			out.writeInt(BOUNDARYTOTYPEMAP[end.class])
			end.write(out)
		}
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		int nullFlags = din.readInt();
		if ( (nullFlags & 0x01) )
		{
			Class<?> stype = BOUNDARYTYPES[din.readInt()]
			start = stype.newInstance()
			start.readFields(din)
		}
		if ( (nullFlags & 0x02) )
		{
			Class<?> etype = BOUNDARYTYPES[din.readInt()]
			end = etype.newInstance()
			end.readFields(din)
		}
	}
}

abstract class Boundary implements Writable
{
	public static def UNBOUNDED_AMOUNT = new Object()
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
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		org.apache.hadoop.io.Text.writeString(out, direction.name());
		boolean isUnBounded = amt == UNBOUNDED_AMOUNT
		out.writeBoolean(isUnBounded)
		if ( !isUnBounded )
			out.writeInt((int) amt);
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		direction = Enum.valueOf(Direction, org.apache.hadoop.io.Text.readString(din))
		boolean isUnBounded = din.readBoolean()
		if ( !isUnBounded )
			amt = din.readInt()
		else
			amt = UNBOUNDED_AMOUNT
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
	
	@Override
	public void write(DataOutput out) throws IOException
	{
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
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
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		org.apache.hadoop.io.Text.writeString(out, direction.name());
		org.apache.hadoop.io.Text.writeString(out, exprString);
		// todo: handle non ints
		boolean isUnBounded = amt == UNBOUNDED_AMOUNT
		out.writeBoolean(isUnBounded)
		if ( !isUnBounded )
			out.writeInt((int) amt);
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		direction = Enum.valueOf(Direction, org.apache.hadoop.io.Text.readString(din))
		exprString = org.apache.hadoop.io.Text.readString(din)
		// todo: handle non ints
		boolean isUnBounded = din.readBoolean()
		if ( !isUnBounded )
			amt = din.readInt()
		else
			amt = UNBOUNDED_AMOUNT
	}
}