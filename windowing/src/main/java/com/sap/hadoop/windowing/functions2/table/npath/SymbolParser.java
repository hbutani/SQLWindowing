package com.sap.hadoop.windowing.functions2.table.npath;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.table.npath.SymbolFunction.Symbol;
import com.sap.hadoop.windowing.functions2.table.npath.SymbolFunction.Star;
import com.sap.hadoop.windowing.functions2.table.npath.SymbolFunction.Plus;
import com.sap.hadoop.windowing.functions2.table.npath.SymbolFunction.Chain;

import static com.sap.hadoop.Utils.sprintf;

public class SymbolParser
{
	String patternStr;
	String[] symbols;
	HashMap<String, Object[]> symbolExprEvalMap;
	ArrayList<SymbolFunction> symbolFunctions;
	Chain symbolFnChain;
	
	
	public SymbolParser(String patternStr, ArrayList<String> symbolNames,
			ArrayList<ExprNodeEvaluator> symbolExprEvals, ArrayList<ObjectInspector> symbolExprOIs)
	{
		super();
		this.patternStr = patternStr;
		symbolExprEvalMap = new HashMap<String, Object[]>();
		int sz = symbolNames.size();
		for(int i=0; i < sz; i++)
		{
			String symbolName = symbolNames.get(i);
			ExprNodeEvaluator symbolExprEval = symbolExprEvals.get(i);
			ObjectInspector symbolExprOI = symbolExprOIs.get(i);
			symbolExprEvalMap.put(symbolName.toLowerCase(), new Object[] {symbolExprEval, symbolExprOI});
		}
	}
	
	public SymbolFunction getSymbolFunction()
	{
		return symbolFnChain;
	}
	
	public void parse() throws WindowingException
	{
		symbols = patternStr.split("\\.");
		symbolFunctions = new ArrayList<SymbolFunction>();
		
		for(String symbol : symbols)
		{
			boolean isStar = symbol.endsWith("*");
			boolean isPlus = symbol.endsWith("+");
			
			symbol = (isStar || isPlus) ? symbol.substring(0, symbol.length() - 1) : symbol;
			Object[] symbolDetails = symbolExprEvalMap.get(symbol.toLowerCase());
			if ( symbolDetails == null )
			{
				throw new WindowingException(sprintf("Unknown Symbol %s", symbol));
			}
			
			ExprNodeEvaluator symbolExprEval = (ExprNodeEvaluator) symbolDetails[0];
			ObjectInspector symbolExprOI = (ObjectInspector) symbolDetails[1];
			SymbolFunction sFn = new Symbol(symbolExprEval, symbolExprOI);
			
			if ( isStar )
			{
				sFn = new Star(sFn);
			}
			else if ( isPlus )
			{
				sFn = new Plus(sFn);
			}
			symbolFunctions.add(sFn);
		}
		symbolFnChain = new Chain(symbolFunctions);
	}
}
