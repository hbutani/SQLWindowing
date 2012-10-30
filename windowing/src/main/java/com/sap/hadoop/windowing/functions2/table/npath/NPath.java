package com.sap.hadoop.windowing.functions2.table.npath;

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.ConstantObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.functions2.table.npath.SymbolFunction.SymbolFunctionResult;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime2.Partition;
import com.sap.hadoop.windowing.runtime2.PartitionIterator;
import com.sap.hadoop.windowing.runtime2.RuntimeUtils;

import static com.sap.hadoop.Utils.sprintf;

/**
 * return rows that meet a specified pattern. Use symbols to specify a list of expressions to match. 
 * Pattern is used to specify a Path. The results list can contain expressions based on the input columns 
 * and also the matched Path.
 * <ol>
 * <li><b>pattern:</b> pattern for the Path. Path is 'dot' separated list of symbols. 
 * Each element is treated as a symbol. Elements that end in '*' or '+' are interpreted with the 
 * usual meaning of zero or more, one or more respectively. For e.g. "LATE.EARLY*.ONTIMEOREARLY" implies a sequence of flights 
 * where the first occurrence was LATE, followed by zero or more EARLY flights, followed by a ONTIME or EARLY flight.
 * <li><b>symbols</b> specify a list of name, expression pairs. For e.g.
 * 'LATE', arrival_delay > 0, 'EARLY', arrival_delay < 0 , 'ONTIME', arrival_delay == 0.
 * These symbols can be used in the Pattern defined above.
 * <li><b>resultSelectList</b> specified as a select list. 
 * The expressions in the selectList are evaluated in the context where all the input columns are available, plus the attribute 
 * "tpath" is available. Path is a collection of rows that represents the matching Path. 
 * </ol>
 */
public class NPath extends TableFunctionEvaluator
{
	private transient String patternStr;
	private transient SymbolsInfo symInfo;
	private transient String resultExprStr;
	private transient SymbolFunction syFn;
	private transient  ArrayList<ExprNodeEvaluator> resultExprEvals;

	
	
	@Override
	public void execute(Partition iPart, Partition outP) throws WindowingException
	{
		PartitionIterator<Object> pItr = iPart.iterator();
		RuntimeUtils.connectLeadLagFunctionsToPartition(getQueryDef(), pItr);
		while (pItr.hasNext())
		{
			Object iRow = pItr.next();
			
			SymbolFunctionResult syFnRes = SymbolFunction.match(syFn, iRow, pItr);
			if (syFnRes.matches )
			{
				int sz = syFnRes.nextRow - (pItr.getIndex() - 1);
				Object selectListInput = NPathUtils.getSelectListInput(iRow, tDef.getInput().getOI(), pItr, sz);
				ArrayList<Object> oRow = new ArrayList<Object>();
				for(ExprNodeEvaluator resExprEval : resultExprEvals)
				{
					try
					{
						oRow.add(resExprEval.evaluate(selectListInput));
					}
					catch(HiveException he)
					{
						throw new WindowingException(he);
					}
				}
				outP.append(oRow);
			}
		}
	}
	
	/**
	 * <ul>
	 * <li> check structure of Arguments:
	 * <ol>
	 * <li> First arg should be a String
	 * <li> then there should be an even number of Arguments: String, expression; expression should be Convertible to Boolean.
	 * <li> finally there should be a String.
	 * </ol>
	 * <li> convert pattern into a NNode chain.
	 * <li> convert symbol args into a Symbol Map.
	 * <li> parse selectList into SelectList struct. The inputOI used to translate these expressions should be based on the 
	 * columns in the Input, the 'path.attr'
	 * </ul>
	 */
	@Override
	public void setupOI() throws WindowingException
	{
		ArrayList<ArgDef> args = tDef.getArgs();
		int argsNum = args == null ? 0 : args.size();
		
		if ( argsNum < 4 )
		{
			throwErrorWithSignature("at least 4 arguments required");
		}
		
		/*
		 * validate and setup patternStr
		 */
		ArgDef symboPatternArg = args.get(0);
		ObjectInspector symbolPatternArgOI = symboPatternArg.getOI();
		
		if ( !ObjectInspectorUtils.isConstantObjectInspector(symbolPatternArgOI) ||
			  (symbolPatternArgOI.getCategory() != ObjectInspector.Category.PRIMITIVE) ||
			  ((PrimitiveObjectInspector)symbolPatternArgOI).getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.STRING )
		{
			throwErrorWithSignature("Currently the symbol Pattern must be a Constant String.");
		}
		
		patternStr = ((ConstantObjectInspector)symbolPatternArgOI).getWritableConstantValue().toString();
		
		/*
		 * validate and setup SymbolInfo
		 */
		int symbolArgsSz = argsNum - 2;
		if ( symbolArgsSz % 2 != 0)
		{
			throwErrorWithSignature("Symbol Name, Expression need to be specified in pairs: there are odd number of symbol args");
		}
		
		symInfo = new SymbolsInfo(symbolArgsSz/2);
		for(int i=1; i <= symbolArgsSz; i += 2)
		{
			ArgDef symbolNameArg = args.get(i);
			ObjectInspector symbolNameArgOI = symbolNameArg.getOI();
			
			if ( !ObjectInspectorUtils.isConstantObjectInspector(symbolNameArgOI) ||
				  (symbolNameArgOI.getCategory() != ObjectInspector.Category.PRIMITIVE) ||
				  ((PrimitiveObjectInspector)symbolNameArgOI).getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.STRING )
			{
				throwErrorWithSignature(sprintf("Currently a Symbol Name(%s) must be a Constant String", symbolNameArg.getExpression().toStringTree()));
			}
			String symbolName = ((ConstantObjectInspector)symbolNameArgOI).getWritableConstantValue().toString();
			
			ArgDef symolExprArg = args.get(i+1);
			ObjectInspector symolExprArgOI = symolExprArg.getOI();
			if ( (symolExprArgOI.getCategory() != ObjectInspector.Category.PRIMITIVE) ||
					  ((PrimitiveObjectInspector)symolExprArgOI).getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.BOOLEAN )
			{
				throwErrorWithSignature(sprintf("Currently a Symbol Expression(%s) must be a boolean expression", symolExprArg.getExpression().toStringTree()));
			}
			symInfo.add(symbolName, symolExprArg);
		}
		
		/*
		 * validate and setup resultExprStr
		 */
		ArgDef resultExprArg = args.get(argsNum - 1);
		ObjectInspector resultExprArgOI = resultExprArg.getOI();
		
		if ( !ObjectInspectorUtils.isConstantObjectInspector(resultExprArgOI) ||
				  (resultExprArgOI.getCategory() != ObjectInspector.Category.PRIMITIVE) ||
				  ((PrimitiveObjectInspector)resultExprArgOI).getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.STRING )
		{
			throwErrorWithSignature("Currently the result Expr parameter must be a Constant String.");
		}
			
		resultExprStr = ((ConstantObjectInspector)resultExprArgOI).getWritableConstantValue().toString();
		
		/*
		 * setup SymbolFunction chain.
		 */
		SymbolParser syP = new SymbolParser(patternStr, symInfo.symbolExprsNames, symInfo.symbolExprsEvaluators, symInfo.symbolExprsOIs);
		syP.parse();
		syFn = syP.getSymbolFunction();
		
		/*
		 * setup OI for input to resultExpr select list
		 */
		StructObjectInspector selectListInputOI = (StructObjectInspector) NPathUtils.createSelectListInputOI(tDef.getInput().getOI());
		
		/*
		 * parse ResultExpr Str and setup OI.
		 */
		ResultExpressionParser resultExprParser = new ResultExpressionParser(resultExprStr, selectListInputOI);
		resultExprParser.translate();
		resultExprEvals = resultExprParser.getSelectListExprEvaluators();
		OI = resultExprParser.getSelectListOutputOI();
	}
	
	private void throwErrorWithSignature(String message) throws WindowingException
	{
		throw new WindowingException(sprintf(
				"NPath signature is: SymbolPattern, one or more SymbolName, expression pairs, the result expression as a select list. Error %s",
				message));
	}
	
	public static class NPathResolver extends TableFunctionResolver
	{

		@Override
		protected TableFunctionEvaluator createEvaluator(QueryDef qDef, TableFuncDef tDef)
		{
			
			return new NPath();
		}
		
	}
	
	static class SymbolsInfo
	{
		int sz;
		ArrayList<ExprNodeEvaluator> symbolExprsEvaluators;
		ArrayList<ObjectInspector> symbolExprsOIs;
		ArrayList<String> symbolExprsNames;
		
		SymbolsInfo(int sz)
		{
			this.sz = sz;
			symbolExprsEvaluators = new ArrayList<ExprNodeEvaluator>(sz);
			symbolExprsOIs = new ArrayList<ObjectInspector>(sz);
			symbolExprsNames = new ArrayList<String>(sz);
		}
		
		void add(String name, ArgDef arg)
		{
			symbolExprsNames.add(name);
			symbolExprsEvaluators.add(arg.getExprEvaluator());
			symbolExprsOIs.add(arg.getOI());
		}
	}
}
