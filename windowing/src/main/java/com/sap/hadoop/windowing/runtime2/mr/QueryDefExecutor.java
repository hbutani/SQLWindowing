package com.sap.hadoop.windowing.runtime2.mr;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.DriverContext;
import org.apache.hadoop.hive.ql.exec.ColumnInfo;
import org.apache.hadoop.hive.ql.exec.MapRedTask;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.exec.OperatorFactory;
import org.apache.hadoop.hive.ql.exec.Utilities;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.plan.ExprNodeColumnDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExtractDesc;
import org.apache.hadoop.hive.ql.plan.FileSinkDesc;
import org.apache.hadoop.hive.ql.plan.MapredWork;
import org.apache.hadoop.hive.ql.plan.PlanUtils;
import org.apache.hadoop.hive.ql.plan.ReduceSinkDesc;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;

import com.sap.hadoop.metadata.Order;
import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.specification.QueryOutputSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;

public class QueryDefExecutor {
	private final Log LOG = LogFactory.getLog(QueryDefExecutor.class.getName());

	  private HiveConf hiveConf;
	  private static MapredWork mr;
	  private Hive db;
	  private QueryDef qdef;
	  
	  public QueryDefExecutor(HiveConf hCfg, QueryDef qDef){
		  this.hiveConf = hCfg;
		  this.qdef = qDef;
		  mr = PlanUtils.getMapRedWork();
	  }
	  
	  public ExprNodeColumnDesc getStringColumn(String columnName) {
		    return new ExprNodeColumnDesc(TypeInfoFactory.stringTypeInfo, columnName,
		        "", false);
		  }

	  private ExprNodeDesc getExprDesc(String name, TypeInfo ti){
		  ExprNodeDesc nodeDesc = new ExprNodeColumnDesc(ti, name, "_" + name, false);
		  return nodeDesc;
	  }

	public int executeQuery(){
		int status = 0;
		try {
			createOperatorTree(getHiveTable());
			status = executePlan();
		} catch (SemanticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	  
	private Table getHiveTable(){
		Table hiveMetaTable = null;
		try {
			String tableName = qdef.getInput().getHiveTableDef().
					getHiveTableSpec().getTableName();
			org.apache.hadoop.hive.metastore.api.Table hiveTable = 
					qdef.getTranslationInfo().getHiveMSClient().getTable(tableName);
			String dbName = hiveTable.getDbName();
			db = Hive.get(hiveConf);
			hiveMetaTable = db.getTable(dbName, tableName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return hiveMetaTable;
	}
	  
	  private String serializePlan(){
		  String queryDef = null;
		  ByteArrayOutputStream out = new ByteArrayOutputStream();
		  SerializationUtils.serialize(out, qdef);
		  queryDef = out.toString();
		  return queryDef;
	  }

	
	  @SuppressWarnings("unchecked")
	public void createOperatorTree(Table inputTable) throws SemanticException {
		    mr.setNumReduceTasks(Integer.valueOf(1));

		    TableFuncDef tabDef = (TableFuncDef) qdef.getInput();
		    HiveTableDef hDef = qdef.getInput().getHiveTableDef();
		    InputInfo input = qdef.getTranslationInfo().getInputInfo(hDef);
		    
		    
		    ArrayList<ExprNodeDesc> partCols =  new ArrayList<ExprNodeDesc>();
		    ArrayList<ExprNodeDesc> valueCols = new ArrayList<ExprNodeDesc>();
		    ArrayList<ExprNodeDesc> orderCols =  new ArrayList<ExprNodeDesc>();
		    List<String> outputColumnNames = new ArrayList<String>();

		    ArrayList<ColumnDef> partColList = tabDef.getWindow().getPartDef().getColumns();
		    for (ColumnDef colDef : partColList) {
				partCols.add(colDef.getExprNode());
			}

		    ArrayList<OrderColumnDef> orderColList = tabDef.getWindow().getOrderDef().getColumns();
		    StringBuilder orderString = new StringBuilder();

		    for (OrderColumnDef colDef : orderColList) {
		    	Order order = colDef.getOrder();
		    	if(order.name().equals("ASC")){
		    		orderString.append('+');	
		    	}else{
		    		orderString.append('-');
		    	}
		    	
				orderCols.add(colDef.getExprNode());
				String colName = colDef.getExpression().getChild(0).getText();
				outputColumnNames.add(colName);
			}
		    
		    
		    
		    RowResolver rr = input.getRowResolver();
		    ArrayList<ColumnInfo> colInfoList = rr.getColumnInfos();
		    for (ColumnInfo colInfo : colInfoList) {
				String internalName = colInfo.getInternalName();
				TypeInfo type = colInfo.getType();
				valueCols.add(getExprDesc(internalName, type));
				outputColumnNames.add(internalName);
			}
		    
		    
		    QueryOutputSpec qOutSpec = qdef.getOutput().getOutputSpec();
		    String outputPath = qOutSpec.getPath();


		    //map-side work
		    Operator<ReduceSinkDesc> op1 = OperatorFactory.get(PlanUtils
			        .getReduceSinkDesc(orderCols, valueCols, outputColumnNames, 
			        		true, -1, partCols, orderString.toString(), -1));
		    
		    Utilities.addMapWork(mr, inputTable, hDef.getAlias(), op1);
		    mr.setKeyDesc(op1.getConf().getKeySerializeInfo());
		    mr.getTagToValueDesc().add(op1.getConf().getValueSerializeInfo());

		    // reduce side work
		    Operator<FileSinkDesc> op4 = OperatorFactory.get(new FileSinkDesc(outputPath, 
		    		Utilities.defaultTd, false));
		    
		    Operator<PTFDesc> op3 = WindowingOpFactory.getOperator(new PTFDesc(qdef,
		    		serializePlan()), op4 );

		    Operator<ExtractDesc> op2 = OperatorFactory.get(new ExtractDesc(
		        getStringColumn(Utilities.ReduceField.VALUE.toString())), op3);

		    mr.setReducer(op2);
		  }

	  private int executePlan() throws Exception {
	    MapRedTask mrtask = new MapRedTask();
	    DriverContext dctx = new DriverContext ();
	    mrtask.setWork(mr);
	    mrtask.initialize(hiveConf, null, dctx);
	    return mrtask.execute(dctx);
	    
	  }


}
