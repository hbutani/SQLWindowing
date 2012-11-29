package com.sap.hadoop.windowing.query2.translate;

import java.util.Map;
import java.util.Properties;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.SerDeUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.HiveQueryDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.QueryOutputDef;
import com.sap.hadoop.windowing.query2.definition.SelectDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WhereDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.ValueBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;

/*
 * An implementation of the {@link QueryDefVisitor} to reconstruct 
 * the OIs, serdes and evaluators on the QueryDef.
 * This follows the same order used in the translation logic.
 */
public class QueryDefDeserializer extends QueryDefVisitor
{
	HiveConf hConf;
	QueryDef qDef;
	QueryInputDef qInDef;
	InputInfo inputInfo;
	QueryTranslationInfo tInfo;
	ObjectInspector inputOI;
	TableFunctionResolver currentTFnResolver;

	// TODO get rid of this dependency
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
	 * Create new instance for the translation info and set the hiveConf on it
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
	 * 1. Determine the serde properties from the hive table definition 
	 * 2. Retrieve the deserializer using the serde class name and 
	 *    initialize it using the serdeproperties 
	 * 3. setup the serde and OI on the hive table definition The OI is 
	 *    used to evaluate expressions in the next PTF in the
	 *    chain. This OI is constructed from the hive meta table info. 
	 * 4. We add the hive table definition to the input 
	 *    map on the query translation info.
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
			hiveTable.setOI((StructObjectInspector) serDe.getObjectInspector());
		}
		catch (SerDeException se)
		{
			throw new WindowingException(se);
		}

		tInfo.addInput(hiveTable);
		inputInfo = tInfo.getInputInfo(hiveTable);
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
	 * If the query has a map phase, the inputInfo is retrieved from the map
	 * output info of the table function definition. This is constructed using
	 * the map output oi of the table function definition. If the query does not
	 * have a map phase, the inputInfo is retrieved from the QueryInputDef
	 * (either HiveTableDef or HiveQueryDef) of the query.
	 */
	@Override
	public void preVisit(TableFuncDef tblFuncDef) throws WindowingException
	{
		TableFunctionEvaluator tEval = tblFuncDef.getFunction();
		currentTFnResolver = FunctionRegistry.getTableFunctionResolver(tEval.getTableDef().getName());
		currentTFnResolver.initialize(qDef, tblFuncDef, tEval);
		if (tEval.isTransformsRawInput())
		{
			currentTFnResolver.setupRawInputOI();
			inputInfo = qDef.getTranslationInfo().getMapInputInfo(tblFuncDef);
		}
		else
		{
			inputInfo = qDef.getTranslationInfo().getInputInfo(qInDef);
		}
	}

	/*
	 * 1. Invoke setupOI on the TableFunctionEvaluator 
	 * 2. Setup serde and OI on the table function definition 
	 * 3. Add the table function definition to input map
	 *    on the query translation info 
	 * 4. Reset the inputInfo to the one associated
	 *    with this table function definition.
	 */
	@Override
	public void visit(TableFuncDef tblFuncDef) throws WindowingException
	{
		TableFunctionEvaluator tEval = tblFuncDef.getFunction();
		currentTFnResolver.setupOutputOI();
		TranslateUtils.setupSerdeAndOI(tblFuncDef, qInDef, tInfo, tEval);
		tInfo.addInput(tblFuncDef);
		inputInfo = qDef.getTranslationInfo().getInputInfo(tblFuncDef);
	}

	/*
	 * Recreate the ExprEvaluator, OI using the current inputInfo This is the
	 * inputInfo on the first InputDef in chain if the query does not have a map
	 * phase; else it is the mapInputInfo on the table function definition
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
	 * Recreate ExprNodeEvaluator, OI using InputInfo of first InputDef in
	 * chain.
	 */
	@Override
	public void visit(ColumnDef column) throws WindowingException
	{
		ExprNodeEvaluator exprEval = WindowingExprNodeEvaluatorFactory.get(
				tInfo, column.getExprNode());
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(qDef,
				column.getExprNode(), exprEval, inputInfo);
		column.setExprEvaluator(exprEval);
		column.setOI(oi);
	}

	/*
	 * Same as visit on {@link ColumnDef}
	 */
	@Override
	public void visit(OrderColumnDef column) throws WindowingException
	{
		visit((ColumnDef) column);
	}

	/*
	 * Recreate the ExprEvaluator, OI using the current inputInfo This is the
	 * inputInfo on the first InputDef in chain if the query does not have a map
	 * phase; else it is the mapInputInfo on the table function definition
	 */
	@Override
	public void visit(ValueBoundaryDef boundary) throws WindowingException
	{
		ExprNodeEvaluator exprEval = WindowingExprNodeEvaluatorFactory.get(
				tInfo, boundary.getExprNode());
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(qDef,
				boundary.getExprNode(), exprEval, inputInfo);
		boundary.setExprEvaluator(exprEval);
		boundary.setOI(oi);
	}

	/*
	 * Setup the evaluators and OIs - Recreate the GenericUDAFEvaluator and use
	 * this and OIs on function arguments to reconstruct the OI on the window
	 * function definition
	 */
	@Override
	public void visit(WindowFunctionDef wFn) throws WindowingException
	{
		WindowFunctionTranslation.setupEvaluator(wFn);
	}

	/*
	 * Recreate ExprNodeEvaluator, OI using InputInfo of first InputDef in
	 * chain.
	 */
	@Override
	public void visit(WhereDef where) throws WindowingException
	{
		ExprNodeEvaluator exprEval = WindowingExprNodeEvaluatorFactory.get(
				tInfo, where.getExprNode());
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(qDef,
				where.getExprNode(), exprEval, inputInfo);
		where.setExprEvaluator(exprEval);
		where.setOI(oi);
	}

	/*
	 * Recreate OI on select list.
	 */
	@Override
	public void visit(SelectDef select) throws WindowingException
	{
		TranslateUtils.setupSelectOI(select);

	}

	/*
	 * Use the serde class name and properties on the query output specification
	 * to recreate the serde and OI on the query output definition
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
