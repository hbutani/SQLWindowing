package com.sap.hadoop.windowing.query2.translate;

import static com.sap.hadoop.Utils.sprintf;

import java.util.Map;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.specification.ColumnSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.BoundarySpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.ValueBoundarySpec;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public class Translator
{
	
	public QueryDef translate(QuerySpec qSpec, WindowingShell wShell) throws WindowingException
	{
		// clone the cfg
		HiveConf qCfg = new HiveConf(wShell.getCfg());
		QueryDef qry = new QueryDef();
		
		QueryTranslationInfo transInfo = new QueryTranslationInfo();
		transInfo.setHiveCfg(qCfg);
		transInfo.setWshell(wShell);
		try
		{
			transInfo.setHive(Hive.get(qCfg));
			transInfo.setHiveMSClient(HiveUtils.getClient(qCfg));
		}
		catch(HiveException he)
		{
			throw new WindowingException(he);
		}
		qry.setTranslationInfo(transInfo);
		
		return qry;
	}
	
	OrderColumnDef translateOrderColumnReference(String tabAlias, Map<String, StructField> fieldMap, ColumnSpec cSpec) throws WindowingException
	{
		OrderColumnDef ocDef = new OrderColumnDef();
		translateColumnReference(ocDef, tabAlias, fieldMap,  cSpec);
		return ocDef;
	}

	ColumnDef translatePartitionColumnReference(String tabAlias, Map<String, StructField> fieldMap, ColumnSpec cSpec) throws WindowingException
	{
		ColumnDef cDef = new ColumnDef();
		translateColumnReference(cDef, tabAlias, fieldMap,  cSpec);
		return cDef;
	}
	
	void  translateColumnReference(ColumnDef cDef, String tabAlias, Map<String, StructField> fieldMap, ColumnSpec cSpec) throws WindowingException
	{
		String colTabName = cSpec.getTableName();
		if (  colTabName != null && !colTabName.equals(tabAlias))
		{
			throw new WindowingException(sprintf("Unknown Table Reference in column", cSpec));
		}
		
		StructField field = fieldMap.get(cSpec.getColumnName().toLowerCase());
		if ( field == null )
		{
			throw new WindowingException(sprintf("Unknown Column Reference %s for table %s", cSpec, tabAlias));
		}
		cDef.setField(field);
		
	}
	
	void translateWindowFrame(WindowFrameSpec wfSpec, TypeCheckCtx typeChkCtx) throws WindowingException
	{
		BoundarySpec s = wfSpec.getStart();
		BoundarySpec e = wfSpec.getEnd();
		translateValueBoundary(s, typeChkCtx);
		translateValueBoundary(e, typeChkCtx);
		
		int cmp = s.compareTo(e);
		if ( cmp > 0 ) 
		{
			throw new WindowingException(sprintf("Window range invalid, start boundary is greater than end boundary: %s", wfSpec));
		}
	}
	
	void translateValueBoundary(BoundarySpec bndSpec, TypeCheckCtx typeChkCtx) throws WindowingException
	{
		if ( bndSpec instanceof ValueBoundarySpec )
		{
			ValueBoundarySpec vBndSpec = (ValueBoundarySpec) bndSpec;
			ExprNodeDesc exprNode = TranslateUtils.buildExprNode(vBndSpec.getExpression(), typeChkCtx);
			vBndSpec.setExprNode(exprNode);
		}
	}
	
	
}
