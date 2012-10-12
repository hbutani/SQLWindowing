package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.SerDeUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.HiveQueryDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.PartitionDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.QueryOutputDef;
import com.sap.hadoop.windowing.query2.definition.SelectDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WhereDef;
import com.sap.hadoop.windowing.query2.definition.WindowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.CurrentRowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.RangeBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.ValueBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;

/*
 * Deserialization Steps:
 * 0. Assume HiveConf is passed to this Object on construction.
 * On initialize:
 * - create TranslationInfo and set on QDef
 * - setup HiveCfg and Hive on TranslationInfo
 * On HiveTableDef:
 * - set OI and SerDe using:
 serDe = (SerDe) SerDeUtils.lookupDeserializer(serDeClassName);
 serDe.initialize(conf, tbl);
 // may require adding columns and columnTypes to Properties. See OutputTranslation:setupOutputSerDe line 243
 * - add the inputDef to the TranslationInfo, so it add it to the InfoMap.
 * On HiveQueryDef:
 * - same as HiveTableDef
 * 
 * On TableFuncDef previsit:
 * - have a instance variable that holds onto the InputInfo for this TableFunc
 * - have another instance variable that holds onto the map-side InputInfo for this TableFunc(if TFunc has Map Side processing)
 *   if TblFunc has no map-side set this to the InputInfo from above.
 * - invoke setupMapOI on the TableFunctionEvaluator; enable TFunc to establish MapOI
 * - if TblFunc has a Map Phase:
 *   - invoke tInfo.getMapInputInfo(tFnDef) // this triggers creating and storing the Map-side InputInfo in TranslationInfo
 *   - set this InputInfo as the current map InputInfo.
 * on TblFn Args:
 *   - recreate the ExprEvaluator, OI using the current mapInputInfo
 * on TblFn Window:
 *   - for Partition:
 *     - recreate the ExprEvaluator, OI using the current mapInputInfo
 *   - for Order:
 *     - recreate the ExprEvaluator, OI using the current mapInputInfo
 *   - for ValueBoundary:
 *     - recreate the ExprEvaluator, OI using the current mapInputInfo
 * for WdwTablFunc:
 *   - for WndFnDef
 *     - for Args:
 *       - recreate the ExprEvaluator, OI using the current mapInputInfo
 *     - process WdwDef just like TblFunc's Wdw but use the current mapInputInfo.
 *     - invoke init on the GenericUDAFEvaluator and set the OI.
 * On TableFuncDef visit:
 * - invoke setupOI on the TableFunctionEvaluator
 * - set Serde, OI, and MapOI on tDef: see end of InputTranslation:translate(TblFuncDef) method, from line 221
 * 
 * On WhereDef:
 * - recreate ExprNodeEvaluator, OI using InputInfo of first InputDef in chain.
 * On SelectDef:
 * - On ColumnDef:
 *   - recreate ExprNodeEvaluator, OI using InputInfo of first InputDef in chain.
 * - On QueryOutputDef:
 *   - set SerDe using:
 serDe = (SerDe) SerDeUtils.lookupDeserializer(serDeClassName);
 serDe.initialize(conf, tbl);
 */
public class QueryDefDeserializer extends QueryDefVisitor
{
	HiveConf hConf;
	QueryDef qDef;
	QueryInputDef qInDef;
	InputInfo inputInfo;
	QueryTranslationInfo tInfo;
	ObjectInspector inputOI;

	// todo-get rid of this dependency
	static
	{
		FunctionRegistry.getWindowFunctionInfo("rank");
	}

	public QueryDefDeserializer(HiveConf hc, ObjectInspector inputOI)
	{
		this.hConf = hc;
		this.inputOI = inputOI;
	}

	public QueryDefDeserializer(HiveConf hc)
	{
		this.hConf = hc;
	}

	/*
	 * 0. Assume HiveConf is passed to this Object on construction. On
	 * initialize: - create TranslationInfo and set on QDef - setup HiveCfg and
	 * Hive on TranslationInfo
	 */
	@Override
	public void initialize(QueryDef queryDef)
	{
		super.initialize(queryDef);
		qDef = queryDef;
		tInfo = new QueryTranslationInfo();
		tInfo.setHiveCfg(hConf);
		qDef.setTranslationInfo(tInfo);

	}

	/*
	 * On HiveTableDef: - set OI and SerDe using: serDe = (SerDe)
	 * SerDeUtils.lookupDeserializer(serDeClassName); serDe.initialize(conf,
	 * tbl); may require adding columns and columnTypes to Properties. See
	 * OutputTranslation:setupOutputSerDe line 243 - add the inputDef to the
	 * TranslationInfo, so it add it to the InfoMap.
	 */
	@Override
	public void visit(HiveTableDef hiveTable) throws WindowingException
	{
		this.qInDef = hiveTable;

		String serDeClassName = hiveTable.getTableSerdeClassName();
		Properties serDeProps = new Properties();
		Map<String, String> serdePropsMap = hiveTable.getTableSerdeProps();
		for (String serdeName : serdePropsMap.keySet())
		{
			serDeProps.setProperty(serdeName, serdePropsMap.get(serdeName));
		}

		try
		{
			SerDe serDe = (SerDe) SerDeUtils.lookupDeserializer(serDeClassName);
			serDe.initialize(hConf, serDeProps);
			hiveTable.setSerde(serDe);
			if (inputOI != null)
			{
				hiveTable.setOI((StructObjectInspector) inputOI);
			}
			else
			{
				hiveTable.setOI((StructObjectInspector) serDe
						.getObjectInspector());
			}
		}
		catch (SerDeException se)
		{
			throw new WindowingException(se);
		}

		tInfo.addInput(hiveTable);
	}

	/*
	 * On HiveQueryDef: - same as HiveTableDef
	 */
	@Override
	public void visit(HiveQueryDef hiveQuery) throws WindowingException
	{
		visit(hiveQuery.getHiveTableDef());
	}

	/*
	 * On TableFuncDef previsit: - have a instance variable that holds onto the
	 * InputInfo for this TableFunc - have another instance variable that holds
	 * onto the map-side InputInfo for this TableFunc(if TFunc has Map Side
	 * processing) if TblFunc has no map-side set this to the InputInfo from
	 * above. - invoke setupMapOI on the TableFunctionEvaluator; enable TFunc to
	 * establish MapOI - if TblFunc has a Map Phase: - invoke
	 * tInfo.getMapInputInfo(tFnDef) // this triggers creating and storing the
	 * Map-side InputInfo in TranslationInfo - set this InputInfo as the current
	 * map InputInfo.
	 */
	@Override
	public void preVisit(TableFuncDef tblFuncDef) throws WindowingException
	{
		TableFunctionEvaluator tEval = tblFuncDef.getFunction();
		if (!tEval.hasMapPhase())
		{
			inputInfo = qDef.getTranslationInfo().getInputInfo(qInDef);
		}
		else
		{
			tEval.setupMapOI();
			inputInfo = qDef.getTranslationInfo().getMapInputInfo(tblFuncDef);
		}
	}

	/*
	 * On TableFuncDef visit: - invoke setupOI on the TableFunctionEvaluator -
	 * set Serde, OI, and MapOI on tDef: see end of
	 * InputTranslation:translate(TblFuncDef) method, from line 221
	 */
	@Override
	public void visit(TableFuncDef tblFuncDef) throws WindowingException
	{
		TableFunctionEvaluator tEval = tblFuncDef.getFunction();
		tEval.setupOI();
		TranslateUtils.setupSerdeAndOI(tblFuncDef, qInDef, tInfo, tEval);
		tInfo.addInput(tblFuncDef);
		inputInfo = qDef.getTranslationInfo().getInputInfo(tblFuncDef);
	}

	/*
	 * on TblFn Args: - recreate the ExprEvaluator, OI using the current
	 * mapInputInfo
	 */
	@Override
	public void visit(ArgDef arg) throws WindowingException
	{
		ExprNodeDesc exprNodeDesc = arg.getExprNode();
		ExprNodeEvaluator exprEval = WindowingExprNodeEvaluatorFactory.get(
				tInfo, exprNodeDesc);
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(qDef,
				exprNodeDesc, exprEval, inputInfo);

		arg.setExprEvaluator(exprEval);
		arg.setOI(oi);

	}

	/*
	 * - On ColumnDef: - recreate ExprNodeEvaluator, OI using InputInfo of first
	 * InputDef in chain.
	 */
	@Override
	public void visit(ColumnDef column) throws WindowingException
	{
		ExprNodeEvaluator exprEval = ExprNodeEvaluatorFactory.get(column
				.getExprNode());
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(qDef,
				column.getExprNode(), exprEval, inputInfo);
		column.setExprEvaluator(exprEval);
		column.setOI(oi);
	}

	@Override
	public void visit(OrderColumnDef column) throws WindowingException
	{
		visit((ColumnDef) column);
	}

	/*
	 * inputInfo - for ValueBoundary: - recreate the ExprEvaluator, OI using the
	 * current mapInputInfo
	 */
	@Override
	public void visit(ValueBoundaryDef boundary) throws WindowingException
	{
		ExprNodeEvaluator exprEval = ExprNodeEvaluatorFactory.get(boundary
				.getExprNode());
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(qDef,
				boundary.getExprNode(), exprEval, inputInfo);
		boundary.setExprEvaluator(exprEval);
		boundary.setOI(oi);
	}

	/*
	 * for WdwTablFunc: - for WndFnDef - for Args: - recreate the ExprEvaluator,
	 * OI using the current mapInputInfo - process WdwDef just like TblFunc's
	 * Wdw but use the current mapInputInfo. - invoke init on the
	 * GenericUDAFEvaluator and set the OI.
	 */
	@Override
	public void visit(WindowFunctionDef wFn) throws WindowingException
	{
		WindowFunctionTranslation.setupEvaluator(wFn);
	}

	/*
	 * On WhereDef: - recreate ExprNodeEvaluator, OI using InputInfo of first
	 * InputDef in chain.
	 */
	@Override
	public void visit(WhereDef where) throws WindowingException
	{
		ExprNodeEvaluator exprEval = ExprNodeEvaluatorFactory.get(where
				.getExprNode());
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(qDef,
				where.getExprNode(), exprEval, inputInfo);
		where.setExprEvaluator(exprEval);
		where.setOI(oi);
	}

	/*
	 * On SelectDef: - On ColumnDef: - recreate ExprNodeEvaluator, OI using
	 * InputInfo of first InputDef in chain.
	 */
	@Override
	public void visit(SelectDef select) throws WindowingException
	{
		TranslateUtils.setupSelectOI(select);

	}

	/*
	 * - On QueryOutputDef: - set SerDe using: serDe = (SerDe)
	 * SerDeUtils.lookupDeserializer(serDeClassName); serDe.initialize(conf,
	 * tbl);
	 */
	@Override
	public void visit(QueryOutputDef output) throws WindowingException
	{

		String serDeClassName = output.getOutputSpec().getSerDeClass();
		Properties serDeProps = output.getOutputSpec().getSerDeProps();

		try
		{
			SerDe serDe = (SerDe) SerDeUtils.lookupDeserializer(serDeClassName);
			serDe.initialize(hConf, serDeProps);
			output.setSerDe(serDe);
		}
		catch (SerDeException se)
		{
			throw new WindowingException(se);
		}

	}

}
