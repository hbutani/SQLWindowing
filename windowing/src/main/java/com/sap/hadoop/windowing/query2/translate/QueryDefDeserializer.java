package com.sap.hadoop.windowing.query2.translate;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.HiveException;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.HiveQueryDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.PartitionDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
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
	

	public QueryDefDeserializer(HiveConf hc){
		this.hConf = hc;
	}
	
	@Override
	public void initialize(QueryDef queryDef) {
		qDef = queryDef;
		QueryTranslationInfo transInfo = new QueryTranslationInfo();
		transInfo.setHiveCfg(hConf);
		try
		{
			transInfo.setHive(Hive.get(hConf));
			transInfo.setHiveMSClient(HiveUtils.getClient(hConf));
		}
		catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qDef.setTranslationInfo(transInfo);

	}
	
	@Override
	public void finish() throws WindowingException
	{
		
	}
	
	@Override
	public void visit(HiveTableDef hiveTable) throws WindowingException
	{
	}
	
	@Override
	public void visit(HiveQueryDef hiveQuery) throws WindowingException
	{
	}
	
	@Override
	public void preVisit(TableFuncDef tblFunc) throws WindowingException
	{
	}
	
	@Override
	public void visit(TableFuncDef tblFunc) throws WindowingException
	{
	}
	
	@Override
	public void visit(ArgDef arg) throws WindowingException
	{
	}
	
	@Override
	public void visit(WindowDef window) throws WindowingException
	{
	}
	
	@Override
	public void visit(PartitionDef partition) throws WindowingException
	{
	}
	
	@Override
	public void visit(OrderDef order) throws WindowingException
	{
	}
	
	@Override
	public void visit(WindowFrameDef windowFrame) throws WindowingException
	{
	}
	
	@Override
	public void visit(ColumnDef column) throws WindowingException
	{
	}
	
	@Override
	public void visit(OrderColumnDef column) throws WindowingException
	{
	}
	
	@Override
	public void visit(CurrentRowDef boundary) throws WindowingException
	{
	}
	
	@Override
	public void visit(RangeBoundaryDef boundary) throws WindowingException
	{
	}
	
	@Override
	public void visit(ValueBoundaryDef boundary) throws WindowingException
	{
	}
	
	@Override
	public void visit(WindowFunctionDef wFn) throws WindowingException
	{
	}
	
	@Override
	public void visit(WhereDef where) throws WindowingException
	{
	}
	
	@Override
	public void visit(SelectDef select) throws WindowingException
	{
	}
	
	@Override
	public void visit(QueryOutputDef output) throws WindowingException
	{
	}


}
