package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.functions2.FunctionRegistry.WindowFunctionInfo;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.PartitionDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WindowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;
import com.sap.hadoop.windowing.query2.specification.WindowSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;

import static com.sap.hadoop.Utils.sprintf;

public class WindowFunctionTranslation
{
	public static WindowFunctionDef translate(QueryDef qDef, TableFuncDef windowTableFnDef, WindowFunctionSpec wFnSpec) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		InputInfo iInfo = tInfo.getInputInfo(windowTableFnDef.getInput()); 

		WindowFunctionDef wFnDef = new WindowFunctionDef();
		wFnDef.setSpec(wFnSpec);
		
		/*
		 * translate args
		 */
		ArrayList<ASTNode> args = wFnSpec.getArgs();
		if ( args != null)
		{
			for(ASTNode expr : args)
			{
				ArgDef argDef = translateWindowFunctionArg(qDef, windowTableFnDef, iInfo,  expr);
				wFnDef.addArg(argDef);
			}
		}
		
		if ( RANKING_FUNCS.contains(wFnSpec.getName()))
		{
			setupRankingArgs(qDef, windowTableFnDef, wFnDef, wFnSpec);
		}
		
		WindowDef wDef = translateWindowSpec(qDef, iInfo, wFnSpec);
		wFnDef.setWindow(wDef);
		validateWindowDefForWFn(windowTableFnDef, wFnDef);
		
		setupEvaluator(wFnDef);
		
		return wFnDef;
	}
	
	static void setupEvaluator(WindowFunctionDef wFnDef) throws WindowingException
	{
		try
		{
			WindowFunctionSpec wSpec = wFnDef.getSpec();
			ArrayList<ArgDef> args = wFnDef.getArgs();
			ArrayList<ObjectInspector> argOIs = getWritableObjectInspector(args);
			GenericUDAFEvaluator wFnEval = org.apache.hadoop.hive.ql.exec.FunctionRegistry.getGenericUDAFEvaluator(wSpec.getName(), argOIs, wSpec.isDistinct(), wSpec.isStar());
			ObjectInspector[] funcArgOIs = null;
			
			if ( args != null)
			{
				funcArgOIs = new ObjectInspector[args.size()];
				int i = 0;
				for(ArgDef arg : args)
				{
					funcArgOIs[i++] =arg.getOI();
				}
			}
			
			ObjectInspector OI = wFnEval.init(GenericUDAFEvaluator.Mode.COMPLETE, funcArgOIs);
			
			wFnDef.setEvaluator(wFnEval);
			wFnDef.setOI(OI);
		}
		catch(HiveException he)
		{
			throw new WindowingException(he);
		}
	}
	
	private static ArgDef translateWindowFunctionArg(QueryDef qDef, TableFuncDef tDef, InputInfo iInfo, ASTNode arg) throws WindowingException
	{
		return TranslateUtils.buildArgDef(qDef, iInfo, arg);
	}
	
	static ArrayList<ObjectInspector> getWritableObjectInspector(ArrayList<ArgDef> args)
	{
		ArrayList<ObjectInspector> result = new ArrayList<ObjectInspector>();
		if ( args != null)
		{
			for (ArgDef arg : args)
			{
				ExprNodeDesc expr = arg.getExprNode();
				result.add(expr.getWritableObjectInspector());
			}
		}
		return result;
	}
	
	public static final ArrayList<String> RANKING_FUNCS =  new ArrayList<String>();
	static
	{
		RANKING_FUNCS.add("rank");
		RANKING_FUNCS.add("denserank"); 
		RANKING_FUNCS.add("percentrank"); 
		RANKING_FUNCS.add("cumedist");
	};
	
	static void setupRankingArgs(QueryDef qDef, TableFuncDef windowTableFnDef, 
			WindowFunctionDef wFnDef, WindowFunctionSpec wSpec) throws WindowingException
	{
		if (wSpec.getArgs().size() > 0)
		{
			throw new WindowingException("Ranking Functions can take no arguments");
		}
		
		QueryInputDef inpDef = windowTableFnDef.getInput();
		InputInfo inpInfo = qDef.getTranslationInfo().getInputInfo(inpDef);
		OrderDef oDef = windowTableFnDef.getWindow().getOrderDef();
		ArrayList<OrderColumnDef> oCols = oDef.getColumns();
		for(OrderColumnDef oCol : oCols)
		{
			wFnDef.addArg(TranslateUtils.buildArgDef(qDef, inpInfo, oCol.getExpression()));
		}
	}
	
	public static WindowDef translateWindowSpec(QueryDef qDef, InputInfo iInfo, WindowFunctionSpec wFnSpec) throws WindowingException
	{
		WindowSpec wSpec = wFnSpec.getWindowSpec();
		
		if ( wSpec == null ) return null;
		
		WindowFunctionInfo wFnInfo = FunctionRegistry.getWindowFunctionInfo(wFnSpec.getName());
		String desc = wFnSpec.toString();
		
		if ( wSpec != null && !wFnInfo.isSupportsWindow() )
		{
			throw new WindowingException(sprintf("Function %s doesn't support windowing", desc));
		}
		return WindowSpecTranslation.translateWindowSpecOnInput(qDef, wSpec, iInfo, desc);
	}
	
	public static void validateWindowDefForWFn(TableFuncDef tFnDef, WindowFunctionDef wFnDef)
		throws WindowingException
	{
		WindowDef tWindow = tFnDef.getWindow();
		WindowDef fWindow = wFnDef.getWindow();
		
		PartitionDef tPart = tWindow == null ? null : tWindow.getPartDef();
		PartitionDef fPart = fWindow == null ? null : fWindow.getPartDef();
		
		if ( !TranslateUtils.isCompatible(tPart, fPart))
		{
			throw new WindowingException(
					sprintf("Window Function '%s' has an incompatible partition clause", wFnDef.getSpec()));
		}
		
		OrderDef tOrder = tWindow == null ? null : tWindow.getOrderDef();
		OrderDef fOrder = fWindow == null ? null : fWindow.getOrderDef();
		if ( !TranslateUtils.isCompatible(tOrder, fOrder))
		{
			throw new WindowingException(
					sprintf("Window Function '%s' has an incompatible order clause", wFnDef.getSpec()));
		}
	}
	
	public static void addInputColumnsToList(QueryDef qDef, TableFuncDef windowTableFnDef, 
			ArrayList<String> fieldNames, ArrayList<ObjectInspector> fieldOIs)
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		InputInfo iInfo = tInfo.getInputInfo(windowTableFnDef.getInput()); 
		
		StructObjectInspector OI = (StructObjectInspector) iInfo.getOI();
		for(StructField f : OI.getAllStructFieldRefs() )
		{
			fieldNames.add(f.getFieldName());
			fieldOIs.add(f.getFieldObjectInspector());
		}
	}
}
