package com.sap.hadoop.windowing.query2.specification;

import java.util.ArrayList;
import java.util.Iterator;

import org.antlr.runtime.tree.CommonTree;
import org.apache.hadoop.hive.ql.parse.ASTNode;

public class SelectSpec implements Iterable<Object>
{
	ArrayList<ASTNode> expressions;
	ArrayList<WindowFunctionSpec> windowFuncs;
	ArrayList<Boolean> isWindowFn;
	ArrayList<String> aliases;
	
	public ArrayList<ASTNode> getExpressions()
	{
		return expressions;
	}
	
	public void addExpression(CommonTree expr, String alias)
	{
		isWindowFn = isWindowFn == null ? new ArrayList<Boolean>() : isWindowFn;
		expressions = expressions == null ? new ArrayList<ASTNode>() : expressions;
		aliases = aliases == null ? new ArrayList<String>() : aliases;
		isWindowFn.add(false);
		expressions.add((ASTNode) expr);
		aliases.add(alias);
	}
	
	public ArrayList<WindowFunctionSpec> getWindowFuncs()
	{
		return windowFuncs;
	}
	
	public void addWindowFunc(WindowFunctionSpec wFn, String alias)
	{
		isWindowFn = isWindowFn == null ? new ArrayList<Boolean>() : isWindowFn;
		windowFuncs = windowFuncs == null ? new ArrayList<WindowFunctionSpec>() : windowFuncs;
		aliases = aliases == null ? new ArrayList<String>() : aliases;
		isWindowFn.add(true);
		windowFuncs.add(wFn);
		wFn.setAlias(alias);
		aliases.add(alias);
	}
	
	public ArrayList<Boolean> getIsWindowFn()
	{
		return isWindowFn;
	}
	
	public class It implements Iterator<Object>
	{
		Iterator<ASTNode> exprIt;
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
		result = prime * result
				+ ((aliases == null) ? 0 : aliases.hashCode());
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
		if (aliases == null)
		{
			if (other.aliases != null)
				return false;
		}
		else if (!aliases.equals(other.aliases))
			return false;
		return true;
	}
	
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		buf.append("select ");
		boolean first = true;
		Iterator<String> aIt = aliases.iterator();
		for(Object o : this)
		{
			if ( first ) first = false; else buf.append(",");
			buf.append(QuerySpec.NL).append("  ");
			if ( o instanceof CommonTree)
			{
				buf.append(((CommonTree)o).toStringTree());
			}
			else
			{
				buf.append(o.toString());
			}
			String alias = aIt.next();
			if (alias != null && (o instanceof CommonTree) )
			{
				buf.append(" as ").append(alias);
			}
		}
		return buf.toString();
	}
	
	public void setExpressions(ArrayList<ASTNode> expressions)
	{
		this.expressions = expressions;
	}

	public void setWindowFuncs(ArrayList<WindowFunctionSpec> windowFuncs)
	{
		this.windowFuncs = windowFuncs;
	}

	public void setIsWindowFn(ArrayList<Boolean> isWindowFn)
	{
		this.isWindowFn = isWindowFn;
	}

	public void setAliases(ArrayList<String> aliases)
	{
		this.aliases = aliases;
	}

	public ArrayList<String> getAliases()
	{
		return aliases;
	}
	
	public Iterator<Object> getColumnListAndAlias()
	{
		return new ColumnListAndAliasItr();
	}
	
	class ColumnListAndAliasItr implements Iterator<Object>
	{
		int cnt;
		int exprIdx;
		int wdwFnIdx;
		int idx;
		
		ColumnListAndAliasItr()
		{
			cnt = SelectSpec.this.isWindowFn.size();
			idx = 0;
			exprIdx = 0;
			wdwFnIdx = 0;
		}

		@Override
		public boolean hasNext()
		{
			return idx < cnt;
		}

		@Override
		public Object next()
		{
			boolean isWnFn = SelectSpec.this.isWindowFn.get(idx);
			Object alias = SelectSpec.this.aliases.get(idx);
			idx++;
			
			if ( isWnFn )
			{
				return new Object[] { isWnFn, alias, SelectSpec.this.windowFuncs.get(wdwFnIdx++)};
			}
			else
			{
				return new Object[] { isWnFn, alias, SelectSpec.this.expressions.get(exprIdx++)};
			}
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
	}
	
}
