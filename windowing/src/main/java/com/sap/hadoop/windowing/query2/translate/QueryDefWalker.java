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
	
	/**
	 * Use the visitor implementation to walk and reconstruct 
	 * the table functions, where and select constructs and 
	 * the query output definition.
	 * @param qDef
	 * @throws WindowingException
	 */
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
	
	/**
	 * Iterate the table functions and hive table
	 * to reconstruct the definitions  
	 * in reverse order or the order of invocations. 
	 * HiveTableDef->PTF1->PTF2->WINDOWF
	 * @param qDef
	 * @throws WindowingException
	 */
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
	
	/**
	 * 1. Reconstruct the InputInfo during previsit 
	 * 2. setup OIs and Evaluators on the ArgDefs 
	 * 3. setup OIs and Evaluators on the columns in the 
	 *    PartitionDef, OrderDef and WindowFrameDef in the 
	 *    WindowFunction definitions  
	 * 4. walk the functions on the select list to 
	 *    setup the OI and GenericUDAFEvaluators 
	 * 
	 * @param qDef
	 * @param tblFunc
	 * @throws WindowingException
	 */
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
	
	/**
	 * Setup the OIs and evaluators on ArgDefs
	 * @param args
	 * @throws WindowingException
	 */
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
	
	/**
	 * Visit the partition columns and order columns 
	 * Visit the window frame definitions
	 * @param window
	 * @throws WindowingException
	 */
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
	
	/**
	 * Visit all the implementations of 
	 * BoundaryDef
	 * @param boundary
	 * @throws WindowingException
	 */
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
	
	/**
	 * Visit all the columns in the select list 
	 * to setup their OIs and evaluators
	 * @param select
	 * @throws WindowingException
	 */
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
