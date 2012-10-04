package com.sap.hadoop.windowing.query2.translate;

import java.util.Iterator;

import com.sap.hadoop.Utils.Predicate;
import com.sap.hadoop.Utils.ReverseIterator;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;

public class TableFunctionChainIterators
{
	public static Predicate<QueryInputSpec> IsTableFunc = new Predicate<QueryInputSpec>() {
		public boolean apply(QueryInputSpec obj) { return obj != null && obj instanceof TableFuncSpec; }
	};
	
	public static class QueryInputSpecIterator implements Iterator<QueryInputSpec>
	{
		QuerySpec qSpec;
		QueryInputSpec nextInput;
		
		public QueryInputSpecIterator(QuerySpec qSpec)
		{
			this.qSpec = qSpec;
			nextInput = qSpec.getInput();
		}
		
		@Override
		public boolean hasNext()
		{
			return nextInput != null;
		}

		@Override
		public QueryInputSpec next()
		{
			QueryInputSpec curr = nextInput;
			if ( curr instanceof TableFuncSpec)
			{
				TableFuncSpec tFunc = (TableFuncSpec) curr;
				nextInput = tFunc.getInput();
			}
			else
			{
				nextInput = null;
			}
			return curr;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	public static class ReverseQueryInputSpecIterator extends ReverseIterator<QueryInputSpec>
	{
		ReverseQueryInputSpecIterator(QuerySpec qSpec)
		{
			super(new QueryInputSpecIterator(qSpec));
		}
	}
	public static class TableFunctionSpecIterator implements Iterator<TableFuncSpec>
	{
		QueryInputSpecIterator qSpecIt;
		TableFuncSpec nextInput;
		
		public TableFunctionSpecIterator(QuerySpec qSpec)
		{
			qSpecIt = new QueryInputSpecIterator(qSpec);
		}

		@Override
		public boolean hasNext()
		{
			if ( qSpecIt.hasNext())
			{
				QueryInputSpec iSpec = qSpecIt.next();
				if ( iSpec instanceof TableFuncSpec)
				{
					nextInput = (TableFuncSpec) iSpec;
					return true;
				}
			}
			return false;
		}

		@Override
		public TableFuncSpec next()
		{
			return nextInput;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	public static class ReverseTableFunctionSpecIterator extends ReverseIterator<TableFuncSpec>
	{
		ReverseTableFunctionSpecIterator(QuerySpec qSpec)
		{
			super(new TableFunctionSpecIterator(qSpec));
		}
	}
	
	public static class QueryInputDefIterator implements Iterator<QueryInputDef>
	{
		QueryDef qDef;
		QueryInputDef nextInput;
		
		public QueryInputDefIterator(QueryDef qDef)
		{
			this.qDef = qDef;
			nextInput = qDef.getInput();
		}
		
		@Override
		public boolean hasNext()
		{
			return nextInput != null;
		}

		@Override
		public QueryInputDef next()
		{
			QueryInputDef curr = nextInput;
			if ( curr instanceof TableFuncDef)
			{
				TableFuncDef tFunc = (TableFuncDef) curr;
				nextInput = tFunc.getInput();
			}
			else
			{
				nextInput = null;
			}
			return curr;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	public static class ReverseQueryInputDefIterator extends ReverseIterator<QueryInputDef>
	{
		ReverseQueryInputDefIterator(QueryDef qDef)
		{
			super(new QueryInputDefIterator(qDef));
		}
	}
	
}
