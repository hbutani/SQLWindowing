package com.sap.hadoop.windowing.query2.specification;

import java.util.ArrayList;

import org.antlr.runtime.tree.CommonTree;

public class TableFuncSpec extends QueryInputSpec
{
	String name;
	ArrayList<CommonTree> args;
	QueryInputSpec input;
	
	public TableFuncSpec() {}
	public TableFuncSpec(String name)
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public ArrayList<CommonTree> getArgs()
	{
		return args;
	}
	
	public void setArgs(ArrayList<CommonTree> args)
	{
		this.args = args;
	}

	public void addArg(CommonTree arg)
	{
		args = args == null ? new ArrayList<CommonTree>() : args;
		args.add(arg);
	}

	public QueryInputSpec getInput()
	{
		return input;
	}
	public void setInput(QueryInputSpec input)
	{
		this.input = input;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((args == null) ? 0 : args.hashCode());
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableFuncSpec other = (TableFuncSpec) obj;
		if (args == null)
		{
			if (other.args != null)
				return false;
		}
		else if (!args.equals(other.args))
			return false;
		if (input == null)
		{
			if (other.input != null)
				return false;
		}
		else if (!input.equals(other.input))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		
		buf.append(name).append("(");
		buf.append(QuerySpec.NL).append("  ").append(input);
		if ( args != null )
		{
			buf.append(QuerySpec.NL).append("  ");
			boolean first = true;
			for(CommonTree arg : args)
			{
				if ( first) first = false; else buf.append(", ");
				buf.append(arg.toStringTree());
			}
		}
		buf.append(QuerySpec.NL).append("  )");
		if ( partition != null )
		{
			buf.append(" ").append(partition);
			if ( order != null ) buf.append(" ").append(order);
		}
		
		return buf.toString();
	}	
}
