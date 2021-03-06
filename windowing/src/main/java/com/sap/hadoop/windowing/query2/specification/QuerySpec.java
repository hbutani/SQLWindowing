package com.sap.hadoop.windowing.query2.specification;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.tree.CommonTree;
import org.apache.hadoop.hive.ql.parse.ASTNode;

public class QuerySpec
{
	QueryInputSpec input;
	SelectSpec selectList;
	ASTNode whereExpr;
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
	public ASTNode getWhereExpr()
	{
		return whereExpr;
	}
	public void setWhereExpr(CommonTree whereExpr)
	{
		this.whereExpr = (ASTNode) whereExpr;
	}
	public Map<String, WindowSpec> getWindowSpecs()
	{
		windowSpecs = windowSpecs == null ? new HashMap<String, WindowSpec>() : windowSpecs;
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
	
	public WindowSpec getWindowSpec(String name)
	{
		return windowSpecs == null ? null : windowSpecs.get(name);
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
	
	public static String NL = System.getProperty("line.separator");
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		
		buf.append(selectList).append(NL);
		buf.append("from ").append(input).append(NL);
		if ( whereExpr != null )
		{
			buf.append("where ").append(whereExpr.toStringTree()).append(NL);
		}
		
		if ( windowSpecs != null)
		{
			boolean first = true;
			buf.append("window ");
			for(Map.Entry<String, WindowSpec> wentry : windowSpecs.entrySet())
			{
				if ( first ) 
					first = false; 
				else 
					buf.append(",");
				buf.append(NL).append("  ").append(wentry.getKey()).append(" as ").append(wentry.getValue());
			}
			buf.append(NL);
		}
		
		if ( output != null )
		{
			buf.append("into ").append(output).append(NL);
		}
		
		return buf.toString();
	}
}
