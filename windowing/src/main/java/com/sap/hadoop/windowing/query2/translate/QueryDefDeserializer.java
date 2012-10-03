package com.sap.hadoop.windowing.query2.translate;



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

}
