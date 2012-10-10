package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;
import java.util.Iterator;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.HiveQueryDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.PartitionDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.SelectDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WindowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.BoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.CurrentRowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.RangeBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.ValueBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;

/**
 * encapsulate the Order in which a QueryDef should be processed.
 *
 */
public class QueryDefWalker
{
	QueryDefVisitor visitor;
	
	public QueryDefWalker()
	{
		super();
	}

	public QueryDefWalker(QueryDefVisitor visitor)
	{
		super();
		this.visitor = visitor;
	}
	
	public void walk(QueryDef qDef) throws WindowingException
	{
		visitor.initialize(qDef);
		walkInputChain(qDef);
		
		if ( qDef.getWhere() != null )
		{
			visitor.visit(qDef.getWhere());
		}
		
		walk(qDef.getSelectList());
		visitor.visit(qDef.getOutput());
		
		visitor.finish();
	}
	
	protected void walkInputChain(QueryDef qDef) throws WindowingException
	{
		Iterator<QueryInputDef> it = TranslateUtils.iterateInputDefs(qDef, true);
		while(it.hasNext())
		{
			QueryInputDef nextDef = it.next();
			if (nextDef instanceof HiveTableDef)
			{
				visitor.visit((HiveTableDef) nextDef);
			}
			else if (nextDef instanceof HiveQueryDef)
			{
				visitor.visit((HiveQueryDef) nextDef);
			}
			else
			{
				walk(qDef, (TableFuncDef) nextDef);
			}
		}
	}
	
	protected void walk(QueryDef qDef, TableFuncDef tblFunc) throws WindowingException
	{
		// 1. allow visitor to establish input
		visitor.preVisit(tblFunc);
		
		// 2. visit the Args.
		walk(tblFunc.getArgs());
		
		//3. walk the window objects
		walk(tblFunc.getWindow());
		
		//4. for WindowTable Func walk the Window Functions on the Select List
		String fName = tblFunc.getName();
		if ( fName.equals(FunctionRegistry.WINDOWING_TABLE_FUNCTION))
		{
			SelectDef select = qDef.getSelectList();
			ArrayList<WindowFunctionDef> wFns = select.getWindowFuncs();
			for(WindowFunctionDef wFn : wFns)
			{
				walk(wFn.getWindow());
				walk(wFn.getArgs());
				visitor.visit(wFn);
			}
		}
		
		//5. revisit tblFunc
		visitor.visit(tblFunc);
	}
	
	protected void walk(ArrayList<ArgDef> args) throws WindowingException
	{
		if ( args != null )
		{
			for(ArgDef arg :args)
			{
				visitor.visit(arg);
			}
		}
	}
	
	protected void walk(WindowDef window) throws WindowingException
	{
		if ( window == null ) return;
		
		PartitionDef pDef = window.getPartDef();
		if(pDef != null){
			ArrayList<ColumnDef> cols = pDef.getColumns();
			for(ColumnDef col : cols)
			{
				visitor.visit(col);
			}
			visitor.visit(pDef);
		}

		
		OrderDef oDef = window.getOrderDef();
		if(oDef != null){
			ArrayList<OrderColumnDef> ocols = oDef.getColumns();
			for(OrderColumnDef ocol : ocols)
			{
				visitor.visit(ocol);
			}
			visitor.visit(oDef);
		}
		
		WindowFrameDef wFrmDef = window.getWindow();
		if ( wFrmDef != null)
		{
			walk(wFrmDef.getStart());
			walk(wFrmDef.getEnd());
			visitor.visit(wFrmDef);
		}
		visitor.visit(window);
	}
	
	protected void walk(BoundaryDef boundary) throws WindowingException
	{
		if ( boundary instanceof ValueBoundaryDef )
		{
			visitor.visit((ValueBoundaryDef)boundary);
		}
		else if ( boundary instanceof RangeBoundaryDef)
		{
			visitor.visit((RangeBoundaryDef)boundary);
		}
		else if ( boundary instanceof CurrentRowDef)
		{
			visitor.visit((CurrentRowDef)boundary);
		}
	}
	
	protected void walk(SelectDef select) throws WindowingException
	{
		ArrayList<ColumnDef> cols = select.getColumns();
		if ( cols != null )
		{
			for(ColumnDef col : cols)
			{
				visitor.visit(col);
			}
		}
		visitor.visit(select);
	}
	
	
	public QueryDefVisitor getVisitor()
	{
		return visitor;
	}
	
	public void setVisitor(QueryDefVisitor visitor)
	{
		this.visitor = visitor;
	}
	
}
