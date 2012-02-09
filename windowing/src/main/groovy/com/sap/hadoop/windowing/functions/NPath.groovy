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
import com.sap.hadoop.windowing.runtime.InputObj;
import com.sap.hadoop.windowing.runtime.Partition;
import com.sap.hadoop.windowing.runtime.Row;

@FunctionDef(
	name = "npath",
	description="""return rows that meet a specified pattern. Use symbols to specify a list of expressions to match. Pattern is used to specify a Path.
The results list can contain expressions based on the input columns and also the matched Path.
""",
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
The names for symbols don't need to be quoted as long as they are valid groovy names. When in doubt add quotes, for eg:
<LATE: "arrival_delay > 0 and arrival_delay < 60", "LATE*2": "arrival_delay >= 60" >
"""),
		@ArgDef(name="results", typeName="expression", argTypes = [ArgType.SCRIPT], 
			description="""specified as a list. Each entry can be just a string, or a list of 3 elems: [expr, type, name].
If an element is just a string, it is interpreted as a reference to a column in the input to this function or as a Symbol. 
When specified as a list the first element is interepreted as a groovy expression; the second is interpreted as a typename, and the 
third is the expression's alias. For eg <["weight", ["2*weight", "double", 'doubleWeight"]>.
The expressions are evaluated in the context where all the input columns are available, plus the attributes "path", "count", "first", and "last" are available. 
Path is a collection of nodes that represents the matching Path, count, first, last are convenience fns about the Path. 
Each node in the path exposes all the attributes of the corresponding input row.
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
	HashMap<String, TypeInfo> outputShape

	@Override
	protected IPartition execute(IPartition inpPart) throws WindowingException
	{
		rowContext.inputP = inpPart
		ArrayList<Integer> idxList = []
		NPartition op = new NPartition(idxList, inpPart)
		NOutObj orow = op.getRowObject();
		outCols.each {NResColumn oc ->
			orow.resultMap[oc.name] = []
		}
		NRow row = new NRow(0, rowContext)
		evaluate(row, idxList, inpPart, orow)
		return op;
	}
	
	private void evaluate(NRow row, ArrayList<Integer> idxList, IPartition inpPart, NOutObj orow)
	{
		while(row)
		{
			boolean res = row.evaluate(rowContext.rootNode)
			if (res)
			{
				idxList << row.idx
				row.computePath()
				outCols.each {NResColumn oc ->
					row.bind(oc.expr)
					orow.resultMap[oc.name] << oc.expr.run()
				}
			}
			row = row.next()
		}
	}

	@Override
	public Map<String, TypeInfo> getOutputShape()
	{
		return outputShape
	}
	
	private void setupOutputShape(Query qry)
	{
		outputShape = new HashMap<String, TypeInfo>()
		outCols.each { NResColumn rc ->
			outputShape.put(rc.name, rc.typeInfo)
		}
		if ( input instanceof AbstractTableFunction )
		{
			input.getOutputShape().each { entry ->
				outputShape.put(entry.key, entry.value)
			}
		}
		else
		{
			 qry.input.columns.each { Column col ->
				 outputShape.put(col.name, col.typeInfo)
			 }
		}
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
		        n = new NNode(expr : wshell.parse("nstar(\"${node}\")"), optional : true)
		        break;
		    case ~/.+\+/: 
				node = node[0..-2]
				n = new NNode(expr : wshell.parse("nplus(\"${node}\")"), optional : false)
		        break;
		    default:
				n = new NNode(expr : wshell.parse(node), optional : false)
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
				if ( r in rowContext.symbols.name )
				{
					rc.typeInfo = TypeInfoFactory.getPrimitiveTypeInfo("boolean")
				}
				else
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
		setupOutputShape(qry)
	}
	
	TypeInfo getInputTypeInfo(Query qry, String name) throws WindowingException
	{
		if ( input instanceof AbstractTableFunction )
		{
			input.getOutputShape().each { entry ->
				if ( entry.key == name) return entry.value
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
	boolean optional
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

class NRow extends Row
{
	int idx
	NRowContext ctx
	Row irow
	NRow nRow
	NRow lastExprReach
	ArrayList<NRow> path
	
	private static ArrayList<String> pathVariables = ["path", "count", "first", "last"] ;
	private static ArrayList<String> patternfunctions = ["nstar", "nplus"] ;
	
	NRow(int idx, NRowContext ctx)
	{
		this.idx = idx
		this.ctx = ctx
		irow = ctx.inputP[idx]
		setVariable("symbol", this.&symbol)
		setVariable('nstar', this.&nstar)
		setVariable('nplus', this.&nplus)
		setupSymbols()
	}
	
	def getVariable(String name)
	{
		switch(name)
		{
			case ctx.symbols.name:
				return super.getVariable(name)
			case pathVariables:
				return super.getVariable(name)
			case patternfunctions:
				return super.getVariable(name)
			default:
				irow.idx = idx
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
		lastExprReach = this
		bind(node.expr)
		boolean r = node.expr.run()
		
		if ( !r ) return false
		NNode nn = node.next
		if (nn == null ) return true
		
		NRow nr = lastExprReach.next()
		if ( nr == null ) 
		{
			// skip all optional(star) nodes at the end
			while (nn != null && nn.isOptional() ) nn = nn.next
			return nn == null
		}
		
		r = nr.evaluate(nn)
		lastExprReach = nr.lastExprReach
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
	
	boolean nstar(String name)
	{
		boolean res = this."$name"
		
		NRow prev = this
		NRow nr = this
		while ( res  )
		{
			prev = nr
			nr = nr.next()
			res = nr != null && nr."$name"
		}
		lastExprReach = prev
		
		return true
	}
	
	boolean nplus(String name)
	{
		boolean res = this."$name"
		if ( !res )
		{
			return false
		}
		NRow nr = next()
		if ( nr )
		{
			nr.nstar(name)
			lastExprReach = nr.lastExprReach
			return true
		}
		return true
	}
	
	void computePath()
	{
		path = []
		NRow r = this
		NRow e = lastExprReach
		while( r != e)
		{
			path << r
			r = r.next()
		}
		path << r
		
		setVariable("path", path)
		setVariable("count", path.size())
		setVariable("first", this)
		setVariable("lasy", lastExprReach)
	}
}

class NResColumn
{
	String name
	TypeInfo typeInfo
	Script expr
}

class NPartition extends IPartition
{
	ArrayList<Integer> idxList
	Partition inputPartition
	NOutObj outObj
	
	NPartition(ArrayList<Integer> idxList, Partition p)
	{
		this.idxList = idxList
		inputPartition = p
		outObj = new NOutObj();
		outObj.p = p
		outObj.resultMap = [:]
	}
	
	Row getAt(i)
	{
		outObj.iObj = inputPartition[idxList[i]];
		outObj.idx = i
		return outObj;
	}
	int size() { return idxList.size();}
	Row getRowObject() { return outObj; }
}

class NOutObj extends Row
{
	InputObj iObj
	Map resultMap
	int idx
	Partition p
	
	public NOutObj()
	{
	}
	
	def getVariable(String name)
	{
		switch(name)
		{
			case resultMap:
				return resultMap[name][idx]
			default:
				return iObj.getVariable(name)
		}
	}
	
	
}
