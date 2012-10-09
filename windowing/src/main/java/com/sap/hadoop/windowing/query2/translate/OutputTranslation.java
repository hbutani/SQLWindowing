package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.antlr.runtime.tree.Tree;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;


import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.Windowing2Parser;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.QueryOutputDef;
import com.sap.hadoop.windowing.query2.definition.SelectDef;
import com.sap.hadoop.windowing.query2.specification.ColumnSpec;
import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;
import com.sap.hadoop.windowing.query2.specification.QueryOutputSpec;
import com.sap.hadoop.windowing.query2.specification.SelectSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;
import com.sap.hadoop.windowing.Constants;

import static com.sap.hadoop.Utils.sprintf;

public class OutputTranslation
{
	public static void translate(QueryDef qDef) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		
		translateSelectExprs(qDef);
		validateOutputSpec(qDef);
		
		QueryOutputDef oDef = new QueryOutputDef();
		oDef.setOutputSpec(qDef.getSpec().getOutput());
		qDef.setOutput(oDef);
				
		setupOutputSerDe(tInfo.getHiveCfg(), qDef.getSelectList(), oDef); 
		
	}
	
	public static void validateOutputSpec(QueryDef qDef) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		QueryOutputSpec spec = qDef.getSpec().getOutput();
		
		// ensure outputPath is specified. It is optional in grammar because it is not required in Hive mode.
		if ( spec.getPath() == null )
		{
			throw new WindowingException("Query doesn't contain an output Path for results");
		}
		
		// if tableName is specified; validate it exists
		Table oTbl = null;
		if ( spec.getHiveTable() != null )
		{
			oTbl = getHiveTableDetails(tInfo.getHiveCfg(), spec.getHiveTable(), qDef.getInput().getHiveTableSpec());
		}
		
		// validate serDeClass
		if ( spec.getSerDeClass() == null )
		{
			if ( oTbl != null && oTbl.getSd().getSerdeInfo().isSetSerializationLib() )
			{
				spec.setSerDeClass(oTbl.getSd().getSerdeInfo().getSerializationLib());
				if ( oTbl.getSd().getSerdeInfo().isSetParameters() )
				{
					Iterator<Map.Entry<String, String>> props = oTbl.getSd().getSerdeInfo().getParameters().entrySet().iterator();
					while(props.hasNext())
					{
						Map.Entry<String, String> e = props.next();
						spec.addSerdeProperty(e.getKey(), e.getValue());
					}
				}
			}
			else
			{
				spec.setSerDeClass(com.sap.hadoop.windowing.Constants.DEFAULT_SERDE_CLASSNAME);
				spec.addSerdeProperty(org.apache.hadoop.hive.serde.Constants.FIELD_DELIM, ",");
			}
		}
		
		try
		{
			Class.forName(spec.getSerDeClass());
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Unknown SerDe Class %s", spec.getSerDeClass()), t);
		}
		
		// validate outputFormat
		if ( spec.getOutputFormatClass() == null )
		{
			if ( oTbl != null )
			{
				spec.setOutputFormatClass(oTbl.getSd().getOutputFormat());
			}
			else
			{
				spec.setOutputFormatClass(Constants.DEFAULT_OUTPUTFORMAT_CLASSNAME);
			}
		}
		try
		{
			Class.forName(spec.getOutputFormatClass());
		}
		catch(Throwable t)
		{
			throw new WindowingException(
				sprintf("Unknown OutputFormat Class %s", spec.getOutputFormatClass()), t);
		}
		
		// ensure user has not specified a FormatClass
		if ( spec.getRecordWriterClass() != null )
		{
			throw new WindowingException("Illegal Output Spec: RecordWriter class not valid in MR mode");
		}
		
	}
	
	public static void translateSelectExprs(QueryDef qDef) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		QueryInputDef iDef = qDef.getInput();
		InputInfo iInfo = tInfo.getInputInfo(iDef);
		SelectDef selectDef = qDef.getSelectList();
		SelectSpec selectSpec = qDef.getSpec().getSelectList();
		Iterator<Object> selectExprsAndAliases = selectSpec.getColumnListAndAlias();
		int i = 0;
		ColumnDef cDef = null;
		ArrayList<String> colAliases = new ArrayList<String>();
		ArrayList<ObjectInspector> colOIs = new ArrayList<ObjectInspector>();
		
		
		while(selectExprsAndAliases.hasNext())
		{
			Object[] o = (Object[]) selectExprsAndAliases.next();
			boolean isWnFn = ((Boolean) o[0]).booleanValue();
			
			if ( isWnFn )
			{
				cDef = translateWindowFnAlias(qDef, iInfo, i++, (String) o[1]);
			}
			else
			{
				cDef = translateSelectExpr(qDef, iInfo, i++, (String) o[1], (ASTNode) o[2]);
			}
			selectDef.addColumn(cDef);
			colAliases.add(cDef.getAlias());
			colOIs.add(cDef.getOI());
		}
		
		selectDef.setOI(ObjectInspectorFactory.getStandardStructObjectInspector(colAliases, colOIs));
	}

	public static ColumnDef translateSelectExpr(QueryDef qDef, InputInfo iInfo, int colIdx, String alias, ASTNode expr) 
		throws WindowingException
	{
		ColumnDef cDef = new ColumnDef((ColumnSpec) null);
		ExprNodeDesc exprNode = TranslateUtils.buildExprNode(expr, iInfo.getTypeCheckCtx());
		ExprNodeEvaluator exprEval = WindowingExprNodeEvaluatorFactory.get(qDef.getTranslationInfo(), exprNode);
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(qDef, exprNode, exprEval, iInfo);
		
		cDef.setExpression(expr);
		cDef.setExprNode(exprNode);
		cDef.setExprEvaluator(exprEval);
		cDef.setOI(oi);
		
		cDef.setAlias(getAlias(alias, expr, colIdx));
		
		return cDef;
	}
	
	public static ColumnDef translateWindowFnAlias(QueryDef qDef, InputInfo iInfo, int colIdx, String alias) 
		throws WindowingException
	{
		ASTNode expr = TranslateUtils.buildASTNode(alias);
		return translateSelectExpr(qDef, iInfo, colIdx, alias, expr);
	}
	
	public static String getAlias(String alias, ASTNode expr, int columnIdx)
	{
		if ( alias != null ) return alias;
		
		if ( expr.getToken().getType() == Windowing2Parser.TABLEORCOL )
		{
			Tree child = expr.getChild(0);
			return child.getText();
		}
		
		return sprintf("col_%i", columnIdx);
	}
	
	public static Table getHiveTableDetails(HiveConf cfg, String tableName, HiveTableSpec inpTblSpec) throws WindowingException
	{
		try
		{
			String db = inpTblSpec.getDbName();
			db = db == null ? Hive.get(cfg).getCurrentDatabase() : db;
			return HiveUtils.getTable(db, tableName, cfg);
		}
		catch(HiveException he)
		{
			throw new WindowingException(he);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void setupOutputSerDe(HiveConf hCfg, SelectDef selectDef, QueryOutputDef oDef) 
			throws WindowingException
	{
		String serDeClassName = oDef.getSpec().getSerDeClass();
		Properties serDeProps = oDef.getSpec().getSerDeProps();
		Class<? extends SerDe> serDeClass;
		SerDe serde;
		
		try
		{
			serDeClass = (Class<? extends SerDe>) Class.forName(serDeClassName);
			serde = serDeClass.newInstance();
		}
		catch(Exception e)
		{
			throw new WindowingException("Internal error, initializing output SerDe", e);
		}
		StringBuilder colNames = new StringBuilder();
		StringBuilder colTypes = new StringBuilder();
		boolean first = true;
		
		for(ColumnDef cDef : selectDef.getColumns())
		{
			if (!first)
			{
				colNames.append(",");
				colTypes.append(",");
			}
			else
				first = false;
			colNames.append(cDef.getAlias());
			colTypes.append(TypeInfoUtils.getTypeInfoFromObjectInspector(cDef.getOI()).getTypeName());
		}
		
		serDeProps.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMNS, colNames.toString());
		serDeProps.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMN_TYPES, colTypes.toString());
		try
		{
			serde.initialize(hCfg, serDeProps);
		}
		catch(SerDeException se)
		{
			throw new WindowingException("Failed to initialize output SerDe", se);
		}
		
		oDef.setSerDe(serde);
		
	}
}
