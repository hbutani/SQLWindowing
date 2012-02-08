package com.sap.hadoop.windowing.functions

import groovy.lang.GroovyShell;

import java.util.Map;

import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.query.Column;
import com.sap.hadoop.windowing.query.FuncSpec;
import com.sap.hadoop.windowing.query.OutputColumn;
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
		@ArgDef(name="pattern", typeName="string", argTypes = [ArgType.STRING], 
			description="""pattern for the Path. Path is 'dot' separated list of symbols. 
Each element is treated as a groovy expression. Elements that end in '*' or '+' are interpreted with the 
usual meaning of zero or more, one or more respectively.
For e.g.
"LATE.EARLY*.(ONTIME || EARLY)" implies a sequence of flights where the first occurence was LATE, followed by zero or more EARLY
flights, followed by a ONTIME or EARLY flight.
"""
		),
		@ArgDef(name="symbols", typeName="expression", argTypes = [ArgType.SCRIPT], 
			description="""specify a map from names to expresssions. For e.g.
<[LATE: "arrival_delay > 0", EARLY: "arrival_delay < 0" , ONTIME : "arrival_delay == 0"]>
The outer brackets are are optional, will be added if not specified. So this is valid:
<LATE: "arrival_delay > 0", EARLY: "arrival_delay < 0" , ONTIME : "arrival_delay == 0">
The names for symbols don't need to be quoted as long as they are valid groovy names. When in doubt add quotes, for eg:
<LATE: "arrival_delay > 0 and arrival_delay < 60", "LATE*2": "arrival_delay >= 60" >
"""),
		@ArgDef(name="results", typeName="expression", argTypes = [ArgType.SCRIPT], 
			description="""specified as a list. Each entry can be just a string, or a list of 3 elems: [expr, type, name].
If an element is just a string, it is interpreted as a reference to a column in the input to this function. 
When specified as a list the first element is interepreted as a groovy expression; the second is interpreted as a typename, and the 
third is the expression's alias. For eg <["weight", ["2*weight", "double", 'doubleWeight"]>.
As in results the outer brackets are optional, will be added if not specified.
The expressions are evaluated in the context where all the input columns are available, plus the attribute 'next'and 'previous'. 
Next and previous can be used to navigate the matching path. Each node in the path exposes all the attributes of the corresponding input
row plus the attributes next and previous. So valid expressions are: next.name, next.next.weight. 
""")
	]
)
class NPath extends AbstractTableFunction
{
	String pattern
	Map<String, String> symbols
	List<Object> results
	NRowContext rowContext
	ArrayList<NResColumn> outCols

	@Override
	protected IPartition execute(IPartition inpPart) throws WindowingException
	{
		rowContext.inputP = inpPart
		OutputPartition op = new OutputPartition(inpPart)
		OutputObj orow = op.getRowObject();
		Map resultMap = orow.resultMap
		ArrayList<Integer> idxList = []
		NRow row = new NRow(0, rowContext)
		evaluate(row, idxList)
		println idxList
		return op;
	}
	
	private void evaluate(NRow row, ArrayList<Integer> idxList)
	{
		while(row)
		{
			boolean res = row.evaluate(rowContext.rootNode)
			if (res)
			{
				idxList << row.idx
			}
			row = row.next()
			println row?.idx
		}
	}

	@Override
	public Map<String, TypeInfo> getOutputShape()
	{
		HashMap<String, TypeInfo> m = new HashMap<String, TypeInfo>()
		outCols.each { NResColumn rc ->
			m.put(rc.name, rc.typeInfo)
		}
		return m;
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
		rowContext = new NRowContext(symbols : [])
				
		// setup Path from pattern
		String[] nds = pattern.split("\\.")
		NNode rootNode = null
		NNode currNode = null
		NNode n = null

		nds.each { node ->
		    switch(node)
		    {
		    case ~/.*\*/: 
				node = node[0..-2]
		        n = new NNode(expr : wshell.parse("nstar(\"${node}\")"))
		        break;
		    case ~/.+\+/: 
				node = node[0..-2]
				n = new NNode(expr : wshell.parse("nplus(\"${node}\")"))
		        break;
		    default:
				n = new NNode(expr : wshell.parse(node))
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
			rowContext.symbols << new NSymbol(name : entry.key, expr : sc)
		}
		
		// setup ResultColumns
		outCols = new ArrayList<NResColumn>()
		results.each { r ->
			NResColumn rc = new NResColumn()
			if ( r instanceof String )
			{
				rc.name = r
				rc.typeInfo = getInputTypeInfo(qry, r)
				rc.expr = wshell.parse(r)
			}
			else
			{
				/* specified as [expr, type, name] */
				if ( r.size() != 3)
				{
					throw new WindowingException("Result Column must be specified as [expr, type, name]")
				}
				rc.name = r[2]
				rc.typeInfo = TypeInfoFactory.getPrimitiveTypeInfo(r[1])
				rc.expr = wshell.parse(r[0])
			}
			outCols << rc
		}
	}
	
	TypeInfo getInputTypeInfo(Query qry, String name) throws WindowingException
	{
		if ( input instanceof AbstractTableFunction )
		{
			input.outCols.each { NResColumn oCol ->
				if ( oCol.name == name) return oCol.typeInfo
			}
		}
		else
		{
			 Column iCol = qry.input.columns.find { it.name == name }
			 if ( iCol ) return iCol.typeInfo
		}
		throw new WindowingException(sprintf("Unknown column %s", name))
	}


}

class NNode
{
	Script expr
	NNode next
}

class NSymbol
{
	String name
	Script expr
}

class NRowContext
{
	IPartition inputP
	ArrayList<NSymbol> symbols
	NNode rootNode
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
		setupSymbols()
	}
	
	def getVariable(String name)
	{
		switch(name)
		{
			case ctx.symbols.name:
				return super.getVariable(name)
			default:
				return irow.getVariable(name)
		}
	}
	
	/**
	 * evaluate the Symbols for this node and make them available as boolean properties.
	 */
	void setupSymbols()
	{
		for(NSymbol symbol in ctx.symbols)
		{
			irow.bind(symbol.expr)
			boolean s = symbol.expr.run()
			setVariable(symbol.name, s)
		}
	}
	
	boolean evaluate(NNode node)
	{
		bind(node.expr)
		boolean r = node.expr.run()
		/*
		 * current node consumed rows upto the end of the path. So start at the last row in the chain.
		 */
		NRow nr = last()
		NNode nn = node.next

		if ( r && nn && nr)
		{
			return nr.evaluate(nn)
		}
		
		if ( nn ) return false
		return r
	}
	
	private boolean _eval(NNode node)
	{
		bind(node.expr)
		return node.expr.run()
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
	
	NRow last()
	{
		NRow prev = this
		/* force the move to the next row */
		NRow nr = next()
		while ( nr )
		{
			prev = nr
			/* now only move if row already traversed */
			nr = nr.nRow
		}
		return prev
	}
	
	boolean nstar(String name)
	{
		boolean res = "$name"
		NRow nr = next()
		
		if ( res && nr )
		{
			nr.nstar(name, node)
		}
		
		return true
	}
	
	boolean nplus(String name)
	{
		boolean res = "$name"
		if ( !res )
		{
			return false
		}
		NRow nr = next()
		if ( nr )
			return nr.nstar(name)
		return true
	}
	
}

class NResColumn
{
	String name
	TypeInfo typeInfo
	Script expr
}
