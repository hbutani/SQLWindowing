package com.sap.hadoop.query2.specification;

import java.util.ArrayList;
import java.util.Iterator;

import org.antlr.runtime.tree.CommonTree;

public class SelectSpec implements Iterable<Object>
{
	ArrayList<CommonTree> expressions;
	ArrayList<WindowFunctionSpec> windowFuncs;
	ArrayList<Boolean> isWindowFn;
	
	public ArrayList<CommonTree> getExpressions()
	{
		return expressions;
	}
	
	public void setExpressions(ArrayList<CommonTree> expressions)
	{
		this.expressions = expressions;
	}
	
	public void addExpression(CommonTree expr)
	{
		isWindowFn = isWindowFn == null ? new ArrayList<Boolean>() : isWindowFn;
		expressions = expressions == null ? new ArrayList<CommonTree>() : expressions;
		isWindowFn.add(false);
		expressions.add(expr);
	}
	
	public ArrayList<WindowFunctionSpec> getWindowFuncs()
	{
		return windowFuncs;
	}
	
	public void setWindowFuncs(ArrayList<WindowFunctionSpec> windowFuncs)
	{
		this.windowFuncs = windowFuncs;
	}
	
	public void addWindowFuncn(WindowFunctionSpec wFn)
	{
		isWindowFn = isWindowFn == null ? new ArrayList<Boolean>() : isWindowFn;
		windowFuncs = windowFuncs == null ? new ArrayList<WindowFunctionSpec>() : windowFuncs;
		isWindowFn.add(true);
		windowFuncs.add(wFn);
	}
	
	public ArrayList<Boolean> getIsWindowFn()
	{
		return isWindowFn;
	}
	
	public void setIsWindowFn(ArrayList<Boolean> isWindowFn)
	{
		this.isWindowFn = isWindowFn;
	}
	
	public class It implements Iterator<Object>
	{
		Iterator<CommonTree> exprIt;
		Iterator<WindowFunctionSpec> wnFnIt;
		Iterator<Boolean> isWnfnIt;
		
		It()
		{
			if (SelectSpec.this.isWindowFn != null)
			{
				isWnfnIt = SelectSpec.this.isWindowFn.iterator();
				if ( SelectSpec.this.windowFuncs != null ) wnFnIt = SelectSpec.this.windowFuncs.iterator();
				if ( SelectSpec.this.expressions != null ) exprIt = SelectSpec.this.expressions.iterator();
			}
		}

		@Override
		public boolean hasNext()
		{
			return isWnfnIt != null && isWnfnIt.hasNext();
		}

		@Override
		public Object next()
		{
			if ( hasNext() )
			{
				boolean isWFn = isWnfnIt.next();
				if ( isWFn ) return wnFnIt.next(); else return exprIt.next();
			}
			return null;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	public Iterator<Object> iterator()
	{
		return new It();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expressions == null) ? 0 : expressions.hashCode());
		result = prime * result
				+ ((isWindowFn == null) ? 0 : isWindowFn.hashCode());
		result = prime * result
				+ ((windowFuncs == null) ? 0 : windowFuncs.hashCode());
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
		SelectSpec other = (SelectSpec) obj;
		if (expressions == null)
		{
			if (other.expressions != null)
				return false;
		}
		else if (!expressions.equals(other.expressions))
			return false;
		if (isWindowFn == null)
		{
			if (other.isWindowFn != null)
				return false;
		}
		else if (!isWindowFn.equals(other.isWindowFn))
			return false;
		if (windowFuncs == null)
		{
			if (other.windowFuncs != null)
				return false;
		}
		else if (!windowFuncs.equals(other.windowFuncs))
			return false;
		return true;
	}
	
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		buf.append("select ");
		boolean first = true;
		for(Object o : this)
		{
			if ( first ) first = false; else buf.append(", ");
			buf.append(o.toString());
		}
		return buf.toString();
	}
	
}
