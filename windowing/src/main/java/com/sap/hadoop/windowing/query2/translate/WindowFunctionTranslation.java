package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;

import org.antlr.runtime.CommonToken;
import org.apache.hadoop.hive.ql.exec.ColumnInfo;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;


import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.Windowing2Parser;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;
import com.sap.hadoop.windowing.query2.specification.OrderColumnSpec;
import com.sap.hadoop.windowing.query2.specification.OrderSpec;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;

public class WindowFunctionTranslation
{
	public static WindowFunctionDef translate(QueryDef qDef, TableFuncDef windowTableFnDef, WindowFunctionSpec wSpec) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		InputInfo iInfo = tInfo.getInputInfo(windowTableFnDef.getInput()); 

		WindowFunctionDef wFnDef = new WindowFunctionDef();
		wFnDef.setSpec(wSpec);
		
		/*
		 * translate args
		 */
		ArrayList<ASTNode> args = wSpec.getArgs();
		if ( args != null)
		{
			for(ASTNode expr : args)
			{
				ArgDef argDef = translateWindowFunctionArg(qDef, windowTableFnDef, iInfo,  expr);
				wFnDef.addArg(argDef);
			}
		}
		
		if ( RANKING_FUNCS.contains(wSpec.getName()))
		{
			setupRankingArgs(qDef, windowTableFnDef, wFnDef, wSpec);
		}
		
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
		OrderSpec oSpec = inpDef.getSpec().getOrder();
		ArrayList<OrderColumnSpec> oCols = oSpec.getColumns();
		for(OrderColumnSpec oCol : oCols)
		{
			String cName = oCol.getColumnName();
			//ColumnInfo cInfo = inpInfo.rr.get(null, cName);
			ASTNode aNode = new ASTNode(new CommonToken(Windowing2Parser.TABLEORCOL));
			aNode.addChild(new ASTNode(new CommonToken(Windowing2Parser.Identifier, cName)));
			wFnDef.addArg(TranslateUtils.buildArgDef(qDef, inpInfo, aNode));
		}
	}
}
