package com.sap.hadoop.query2.specification;

import static com.sap.hadoop.Utils.sprintf;

import org.antlr.runtime.tree.CommonTree;

import com.sap.hadoop.windowing.query.Boundary;

public class WindowFrameSpec
{
	Boundary start;
	Boundary end;
	
	public Boundary getStart()
	{
		return start;
	}

	public void setStart(Boundary start)
	{
		this.start = start;
	}

	public Boundary getEnd()
	{
		return end;
	}

	public void setEnd(Boundary end)
	{
		this.end = end;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WindowFrameSpec other = (WindowFrameSpec) obj;
		if (end == null)
		{
			if (other.end != null)
				return false;
		}
		else if (!end.equals(other.end))
			return false;
		if (start == null)
		{
			if (other.start != null)
				return false;
		}
		else if (!start.equals(other.start))
			return false;
		return true;
	}

	public String toString()
	{
		return sprintf( "window(start=%s, end=%s)", start, end);
	}
	
	public static enum Direction
	{
		PRECEDING,
		CURRENT,
		FOLLOWING
	};

	public abstract static class BoundarySpec implements Comparable<BoundarySpec>
	{
		public static int UNBOUNDED_AMOUNT = Integer.MAX_VALUE;
		
		abstract Direction getDirection();
		
	}
	
	public static class RangeBoundarySpec extends BoundarySpec
	{
		
		Direction direction;
		int amt;
		
		public Direction getDirection()
		{
			return direction;
		}

		public void setDirection(Direction direction)
		{
			this.direction = direction;
		}

		public int getAmt()
		{
			return amt;
		}

		public void setAmt(int amt)
		{
			this.amt = amt;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + amt;
			result = prime * result
					+ ((direction == null) ? 0 : direction.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RangeBoundarySpec other = (RangeBoundarySpec) obj;
			if (amt != other.amt)
				return false;
			if (direction != other.direction)
				return false;
			return true;
		}

		public String toString()
		{
			return sprintf( "range(%s %s)", (amt == UNBOUNDED_AMOUNT ? "Unbounded" : amt), direction);
		}
		
		public int compareTo(BoundarySpec other)
		{
			int c = direction.compareTo(other.getDirection());
			if ( c != 0) return c;
			RangeBoundarySpec rb = (RangeBoundarySpec) other;
			return amt - rb.amt;
		}
		
	}
	
	public static class CurrentRowSpec extends BoundarySpec
	{
		public String toString()
		{
			return sprintf( "currentRow");
		}
		
		Direction getDirection() { return Direction.CURRENT; }
		
		public int compareTo(BoundarySpec other)
		{
			return getDirection().compareTo(other.getDirection());
		}
		
	}
	
	public static class ValueBoundarySpec extends BoundarySpec
	{
		Direction direction;
		CommonTree expression;
		int amt;
		
		public Direction getDirection()
		{
			return direction;
		}

		public void setDirection(Direction direction)
		{
			this.direction = direction;
		}

		public CommonTree getExpression()
		{
			return expression;
		}

		public void setExpression(CommonTree expression)
		{
			this.expression = expression;
		}

		public int getAmt()
		{
			return amt;
		}

		public void setAmt(int amt)
		{
			this.amt = amt;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + amt;
			result = prime * result
					+ ((direction == null) ? 0 : direction.hashCode());
			result = prime * result
					+ ((expression == null) ? 0 : expression.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ValueBoundarySpec other = (ValueBoundarySpec) obj;
			if (amt != other.amt)
				return false;
			if (direction != other.direction)
				return false;
			if (expression == null)
			{
				if (other.expression != null)
					return false;
			}
			else if (!expression.equals(other.expression))
				return false;
			return true;
		}

		public String toString()
		{
			return sprintf( "value(%s %s %s)", expression.toStringTree(), amt, direction);
		}

		public int compareTo(BoundarySpec other)
		{
			int c = direction.compareTo(other.getDirection());
			if ( c != 0) return c;
			ValueBoundarySpec vb = (ValueBoundarySpec) other;
			return amt - vb.amt;
		}

	}

}
