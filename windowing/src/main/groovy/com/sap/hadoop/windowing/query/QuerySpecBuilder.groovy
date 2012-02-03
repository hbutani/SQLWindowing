package com.sap.hadoop.windowing.query

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.WindowingParser;

class QuerySpecBuilder
{
	CommonTreeAdaptor adaptor;
	QuerySpec qSpec = new QuerySpec()
	boolean processingInput = true
	
	void visit(CommonTree node) throws WindowingException
	{
		boolean isNil = adaptor.isNil(node);
		_preVisit(node);
		for(int i = 0; i < adaptor.getChildCount(node); i++)
		{
			CommonTree child = adaptor.getChild(node, i);
			Object visitResult = visit(child);
		}
		_postVisit(node);
	}
	
	void _preVisit(CommonTree node)
	{
		switch(node.getType())
		{
			case WindowingParser.OUTPUTSPEC:
				processingInput =false
				break;
		}
	}
	
	void _postVisit(CommonTree node) throws WindowingException
	{
		switch(node.getType())
		{
			case WindowingParser.QUERY:
				break;
			case WindowingParser.PARAM:
				if (processingInput) 
					visitInputParam(node, qSpec.tableIn);
				else
					visitOutputParam(node, qSpec.tableOut);
				break;
			case WindowingParser.TABLEINPUT:
				visitTableInput(node, qSpec.tableIn);
				break;
			case WindowingParser.FUNCTION:
				qSpec.funcSpecs << function(node)
				break;
			case WindowingParser.SELECTCOLUMN:
				qSpec.selectColumns << selectColumn(node)
				break;
			case WindowingParser.WHERE:
				qSpec.whereExpr = node.children[0].text
				break;
			case WindowingParser.PARTITION:
				partition(node)
				break;
			case WindowingParser.ORDER:
				order(node)
				break;
			case WindowingParser.OUTPUTSPEC:
				ouputSpec(node, qSpec.tableOut);
				break;
		}
	}
	
	void partition(CommonTree node)
	{
		for(int i = 0; i < adaptor.getChildCount(node); i++)
		{
			CommonTree child = adaptor.getChild(node, i);
			qSpec.tableIn.partitionColumns << child.text
		}
	}
	
	void order(CommonTree node)
	{
		for(int i = 0; i < adaptor.getChildCount(node); i++)
		{
			CommonTree child = adaptor.getChild(node, i);
			qSpec.tableIn.orderColumns << orderColumn(child)
		}
	}
	
	OrderColumn orderColumn(CommonTree node)
	{
		def name = node.children[0].text
		def ord = Order.ASC
		if (node.childCount > 1)
		{
			def otyp = node.children[1].getType()
			ord = otyp == WindowingParser.ASC ? Order.ASC : Order.DESC
		}
		return new OrderColumn(name : name, order: ord)
	}
	
	void visitTableInput(CommonTree node, TableInput tableIn) throws WindowingException
	{
		CommonTree child = node.children[0]
		if ( child.getType() == WindowingParser.ID )
		{
			tableIn.tableName = child.text
		}
		else if ( child.getType() == WindowingParser.GROOVYEXPRESSION )
		{
			tableIn.hiveQuery = child.text
		}
	}
	
	void visitInputParam(CommonTree node, TableInput tableInput)
	{
		String name = node.children[0].text
		String value = node.children[1].text
		
		name = name.toLowerCase()
		switch(name)
		{
			case Constants.INPUT_PATH:
				tableInput.inputPath = value;
				break;
			case Constants.INPUT_KEY_CLASS:
				tableInput.keyClass = value;
				break;
			case Constants.INPUT_VALUE_CLASS:
				tableInput.valueClass = value;
				break;
			case Constants.INPUT_INPUTFORMAT_CLASS:
				tableInput.inputFormatClass = value;
				break;
			case Constants.INPUT_SERDE_CLASS:
				tableInput.serDeClass = value;
				break;
			case Constants.INPUT_RECORD_READER_CLASS:
				tableInput.windowingInputClass = value;
				break;
			default:
				tableInput.serDeProps.setProperty(name, value)
		}
	}
	
	void visitOutputParam(CommonTree node, TableOutput tableOutput)
	{
		String name = node.children[0].text
		String value = node.children[1].text
		
		tableOutput.serDeProps.setProperty(name, value)
	}
	
	void ouputSpec(CommonTree node, TableOutput tableOut)
	{
		int cCnt = node.children.size()
		tableOut.outputPath = node.children[0].text
		if ( cCnt > 1 )
		{
			CommonTree serDe = node.children[1]
			tableOut.serDeClass = serDe.children[0].text
			CommonTree rWrtrOrFmt = serDe.children[1]
			if ( rWrtrOrFmt.getType() == WindowingParser.RECORDWRITER)
			{
				tableOut.recordwriterClass = rWrtrOrFmt.children[0].text
			}
			else
			{
				tableOut.outputFormat = rWrtrOrFmt.children[0].text
			}
		}
	}
	
	FuncSpec function(CommonTree node)
	{
		FuncSpec fSpec = new FuncSpec()
		fSpec.name = node.children[0].text.toLowerCase()
		fSpec.alias = node.children[1].text
		int idx = 2
		
		while ( node.childCount > idx && (node.children[idx].getType() in [WindowingParser.GROOVYEXPRESSION,WindowingParser.STRING, WindowingParser.ID, WindowingParser.NUMBER] ) )
		{
			fSpec.params = fSpec.params == null ? [] : fSpec.params
			fSpec.params << functionArg(node.children[idx])
			idx++
		}
		
		if ( node.childCount > idx && node.children[idx].getType() == WindowingParser.TYPENAME)
		{
			fSpec.typeName = node.children[idx].children[0].text
			idx++
		}
		
		if ( node.childCount > idx )
		{
			fSpec.window = createwindow(node.children[idx])
		}
		return fSpec
	}
	
	FuncArg functionArg(CommonTree node)
	{
		switch(node.getType())
		{
			case WindowingParser.STRING:
				return new FuncArg(str : node.text)
			case WindowingParser.GROOVYEXPRESSION:
				return new FuncArg(expr : node.text)
			case WindowingParser.ID:
				return new FuncArg(id : node.text)
			case WindowingParser.NUMBER:
				return new FuncArg(iVal : Integer.parseInt(node.text))
		}
	}
	
	Window createwindow(CommonTree node)
	{
		switch(node.getType())
		{
			case WindowingParser.WINDOWRANGE:
				return new Window(start : rowsboundary(node.children[0]), end : rowsboundary(node.children[1]))
			case WindowingParser.WINDOWVALUES:
				return new Window(start : valuesboundary(node.children[0]), end : valuesboundary(node.children[1]))
		}
	}
	
	Boundary rowsboundary(CommonTree node)
	{
		switch(node.getType())
		{
			case WindowingParser.CURRENT:
				return new CurrentRow();
			case WindowingParser.PRECEDING:
			case WindowingParser.FOLLOWING:
				def dir = node.getType() == WindowingParser.PRECEDING ? Direction.PRECEDING : Direction.FOLLOWING
				def c = node.children[0]
				def amt = c.getType() == WindowingParser.UNBOUNDED ? Boundary.UNBOUNDED_AMOUNT : Integer.parseInt(c.getText())
			  return new RangeBoundary(direction: dir, amt: amt)
		}
	}
	
	Boundary valuesboundary(CommonTree node)
	{
		switch(node.getType())
		{
			case WindowingParser.CURRENT:
			case WindowingParser.PRECEDING:
			case WindowingParser.FOLLOWING:
				return rowsboundary(node)
			case WindowingParser.LESS:
			case WindowingParser.MORE:
				def dir =  node.getType() == WindowingParser.LESS ? Direction.PRECEDING : Direction.FOLLOWING
				def expr = node.children[0]
				def amt = Integer.parseInt(node.children[1].getText())
				return new ValueBoundary(direction: dir, exprString: expr, amt: amt)
		}
	}
	
	SelectColumn selectColumn(CommonTree node)
	{
		SelectColumn sc = new SelectColumn()
		sc.alias = node.children[0].text
		if ( node.children.size() > 1)
		{
			sc.expr = node.children[1].text
		}
		if ( node.children.size() > 2)
		{
			sc.typeName = node.children[2].children[0].text
		}
		return sc
	}
}
