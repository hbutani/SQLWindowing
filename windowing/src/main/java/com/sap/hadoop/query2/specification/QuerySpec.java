package com.sap.hadoop.query2.specification;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.tree.CommonTree;

public class QuerySpec
{
	QueryInputSpec input;
	SelectSpec selectList;
	CommonTree whereExpr;
	Map<String, WindowSpec> windowSpecs;
	QueryOutputSpec output;
	
	public QueryInputSpec getInput()
	{
		return input;
	}
	public void setInput(QueryInputSpec input)
	{
		this.input = input;
	}
	public CommonTree getWhereExpr()
	{
		return whereExpr;
	}
	public void setWhereExpr(CommonTree whereExpr)
	{
		this.whereExpr = whereExpr;
	}
	public Map<String, WindowSpec> getWindowSpecs()
	{
		return windowSpecs;
	}
	public void setWindowSpecs(Map<String, WindowSpec> windowSpecs)
	{
		this.windowSpecs = windowSpecs;
	}
	
	public void addWindowSpec(String name, WindowSpec wdwSpec)
	{
		windowSpecs = windowSpecs == null ? new HashMap<String, WindowSpec>() : windowSpecs;
		windowSpecs.put(name, wdwSpec);
	}
	
	public QueryOutputSpec getOutput()
	{
		return output;
	}
	public void setOutput(QueryOutputSpec output)
	{
		this.output = output;
	}
	public SelectSpec getSelectList()
	{
		return selectList;
	}
	public void setSelectList(SelectSpec selectList)
	{
		this.selectList = selectList;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result + ((output == null) ? 0 : output.hashCode());
		result = prime * result
				+ ((selectList == null) ? 0 : selectList.hashCode());
		result = prime * result
				+ ((whereExpr == null) ? 0 : whereExpr.hashCode());
		result = prime * result
				+ ((windowSpecs == null) ? 0 : windowSpecs.hashCode());
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
		QuerySpec other = (QuerySpec) obj;
		if (input == null)
		{
			if (other.input != null)
				return false;
		}
		else if (!input.equals(other.input))
			return false;
		if (output == null)
		{
			if (other.output != null)
				return false;
		}
		else if (!output.equals(other.output))
			return false;
		if (selectList == null)
		{
			if (other.selectList != null)
				return false;
		}
		else if (!selectList.equals(other.selectList))
			return false;
		if (whereExpr == null)
		{
			if (other.whereExpr != null)
				return false;
		}
		else if (!whereExpr.equals(other.whereExpr))
			return false;
		if (windowSpecs == null)
		{
			if (other.windowSpecs != null)
				return false;
		}
		else if (!windowSpecs.equals(other.windowSpecs))
			return false;
		return true;
	}
	
	
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		
		buf.append(selectList);
		buf.append(" from ").append(input);
		if ( whereExpr != null )
		{
			buf.append(" where ").append(whereExpr.toStringTree());
		}
		
		if ( windowSpecs != null)
		{
			boolean first = false;
			buf.append(" window ");
			for(Map.Entry<String, WindowSpec> wentry : windowSpecs.entrySet())
			{
				if ( first ) first = false; else buf.append(", ");
				buf.append(wentry.getKey()).append(" as ").append(wentry.getValue());
			}
		}
		
		if ( output != null )
		{
			buf.append(" into ").append(output);
		}
		
		return buf.toString();
	}
}
