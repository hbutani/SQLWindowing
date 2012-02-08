package com.sap.hadoop.windowing.functions

import groovy.lang.GroovyShell;

import java.util.Map;

import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.query.FuncSpec;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.IPartition;
import com.sap.hadoop.windowing.runtime.OutputObj;
import com.sap.hadoop.windowing.runtime.Row;

@FunctionDef(
	name = "npath",
	description="return rows that meet the specified pattern",
	supportsWindow = false,
	args = [
		@ArgDef(name="pattern", typeName="string", argTypes = [ArgType.STRING], description="""pattern for the Path. Path is 'dot' separated list of symbols. 
'*' & '+' have usual meaning of zero or more, one or more respectively"""
		),
		@ArgDef(name="symbols", typeName="script", argTypes = [ArgType.SCRIPT], description="specify a map from expressions(as strings) to names"),
		@ArgDef(name="results", typeName="script", argTypes = [ArgType.SCRIPT], description="specify a map from expressions(as strings) to name,typename list")
	]
)
class NPath extends AbstractTableFunction
{
	String pattern
	Map<String, String> symbols
	List<Object> results
	NRowContext rowContext

	@Override
	protected IPartition execute(IPartition inpPart) throws WindowingException
	{
		OutputPartition op = new OutputPartition(inpPart)
		OutputObj orow = op.getRowObject();
		Map resultMap = orow.resultMap
		ArrayList<Integer> idxList = []
		NRow row = new NRow(0, rowContext)
		evaluate(row, idxList)
		return op;
	}
	
	private void evaluate(NRow row, ArrayList<Integer> idxList)
	{
		while(row)
		{
			EvalResult res = row.evaluate(rowContext.rootNode)
			if (res)
			{
				idxList << row.idx
				row = res.row
			}
			else
			{
				row = row.next()
			}
		}
	}

	@Override
	public Map<String, TypeInfo> getOutputShape()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean match(Row row)
	{
		return false
	}
	
	private void evaluateOutput(Row row, Map resultMap)
	{
		
	}
	
	protected void completeTranslation(GroovyShell wshell, Query qry, FuncSpec funcSpec) throws WindowingException
	{
		rowContext = new NRowContext(symbols : [:])
		
		// setup Path from pattern
		String[] nds = pattern.split("\\.")
		Node rootNode = null
		Node currNode = null
		Node n = null

		nds.each { node ->
		    switch(node)
		    {
		    case ~/.*\*/: 
				node = node[0..-2]
		        n = new Node(expr : wshell.parse("nstar(\"${node}.result\")"))
		        break;
		    case ~/.+\+/: 
				node = node[0..-2]
				n = new Node(expr : wshell.parse("nplus(\"${node}.result\")"))
		        break;
		    default:
				n = new Node(expr : wshell.parse(node))
		    }
			if (currNode)
			{
				currNode.next = n
			}
			if (!rootNode) rootNode = n
			currNode = n
				
		}
		rowContext.rootNode = rootNode
		
		// setup Symbols
		symbols.each { entry ->
			Script sc = wshell.parse(entry.value)
			rowContext.symbols << new Symbol(name : entry.key, expr : sc)
		}
		
		// setup 
	}


}

class Node
{
	Script expr
	Node next
}

class Symbol
{
	String name
	Script expr
}

class NRowContext
{
	IPartition inputP
	Symbol[] symbols
	Node rootNode
}

class EvalResult
{
	NRow row
	boolean result
}

class NRow extends Row
{
	int idx
	NRowContext ctx
	Row irow
	Row nRow
	
	NRow(int idx, NRowContext ctx)
	{
		this.idx = idx
		this.ctx = ctx
		irow = ctx.inputP[idx]
		setVariable("symbol", this.&symbol)
	}
	
	void setupSymbols()
	{
		for(Symbol symbol in ctx.symbols)
		{
			irow.bind(symbol.expr)
			boolean s = symbol.expr.run()
			String name = "${symbol.name}.result"
			setVariable(name, s)
			setVariable(symbol.name, { 
					symbol(name)
				})
		}
	}
	
	EvalResult evaluate(Node node)
	{
		setVariable("node", node)
		EvalResult r = node.expr.run()
		if ( r.result && r.row )
		{
			node = node.next()
			if (node)
				return r.row.evaluate(node)
		}
		return r 
	}	
	
	EvalResult symbol(String name)
	{
		if ( getVariable(name) )
		{
			return new EvalResult(true, next())
		}
		return new EvalResult(false, this)
	}
	
	NRow next()
	{
		if (!nRow )
		{
			if ( idx + 1 >= ctx.inputP.size() )
			{
				nRow = null
			}
			else
				nRow = new NRow(idx +1, ctx)
		}
		return nRow
	}
	
	Node node()
	{
		return getVariable("node")
	}
	
	EvalResult nstar(String name, Node node)
	{
		EvalResult res = symbol(name)
		if ( !res.result || !res.row )
		{
			res.result = true;
			return res
		}
		return res.row.nstar(name, node)
	}
	
	EvalResult nstar(String name)
	{
		return nstar(name, node())
	}
	
	EvalResult nplus(String name, Node node)
	{
		EvalResult res = symbol(name)
		if ( !res.result )
		{
			return res
		}
		return res.row.nstar(name, node)
	}
	
	EvalResult nplus(String name)
	{
		return nplus(name, node())
	}
}
