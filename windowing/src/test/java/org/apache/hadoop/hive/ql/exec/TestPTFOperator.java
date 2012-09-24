package org.apache.hadoop.hive.ql.exec;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.DriverContext;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.parse.BaseSemanticAnalyzer;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.plan.ExprNodeColumnDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExtractDesc;
import org.apache.hadoop.hive.ql.plan.FileSinkDesc;
import org.apache.hadoop.hive.ql.plan.MapredWork;
import org.apache.hadoop.hive.ql.plan.PlanUtils;
import org.apache.hadoop.hive.ql.plan.ReduceSinkDesc;
import org.apache.hadoop.hive.ql.plan.SelectDesc;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.metadata.Order;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.specification.QueryOutputSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;
import com.sap.hadoop.windowing.query2.translate.Translator;
import com.sap.hadoop.windowing.runtime.hive.EvalContext;
import com.sap.hadoop.windowing.runtime2.LocalExecutor;
import com.sap.hadoop.windowing.runtime2.ThriftBasedHiveQueryExecutor;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public class TestPTFOperator extends TestCase {

	  static HiveConf hiveConf;
	  MapredWork mr;
	  static WindowingShell wshell;
      static ByteArrayOutputStream outStream;

	  private static String tmpdir = "/home/pkalmegh/Projects/SQLWindowing/output" + "/";
	  private static Path tmppath = new Path(tmpdir);
	  private static Hive db;
	  private static FileSystem fs;

	  @Rule
	  public ExpectedException expectedEx = ExpectedException.none();
	  static EvalContext eCtx;

		public static Configuration WORK()
		{
			Configuration conf = new Configuration();
			conf.set("fs.default.name", "hdfs://localhost:9000");
			conf.set("mapred.job.tracker", "localhost:9001");
			conf.set("hive.metastore.uris", "thrift://localhost:9083");
			conf.set("hive.metastore.local", "false");
			conf.set("windowing.jar.file", "/home/saplabs/Projects/SQLWindowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");

			conf.set(Constants.HIVE_THRIFTSERVER, "localhost");
			conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000);
			conf.set("HIVE_HOME", "/home/saplabs/Projects/hive/build/dist");

			return conf;
		}
	  
		public static Configuration HOME()
		{
			Configuration conf = new Configuration();
			conf.set("fs.default.name", "hdfs://localhost:9000");
			conf.set("mapred.job.tracker", "localhost:9001");
			conf.set("hive.metastore.uris", "thrift://localhost:9083");
			conf.set("hive.metastore.local", "false");
			conf.set("windowing.jar.file", "/home/pkalmegh/Projects/SQLWindowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");

			conf.set(Constants.HIVE_THRIFTSERVER, "localhost");
			conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000);
			conf.set("HIVE_HOME", "/home/pkalmegh/Projects/hive/build/dist");

			return conf;
		}
  


	  @Override
	  protected void setUp() {
	    mr = PlanUtils.getMapRedWork();
	    
	    
	    try {
		
		Configuration conf = HOME();
		conf.setBoolean(Constants.WINDOWING_TEST_MODE, true);
		hiveConf = new HiveConf(conf, conf.getClass());
	    outStream = new ByteArrayOutputStream();
		
		wshell = new WindowingShell(hiveConf, new Translator(), new LocalExecutor());
		wshell.setHiveQryExec(new ThriftBasedHiveQueryExecutor(conf));
		eCtx = new EvalContext(wshell.getCfg());
		setupFS();
	    } catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  private void setupFS(){
		    try {
			      fs = FileSystem.get(hiveConf);
			      if (fs.exists(tmppath) && !fs.getFileStatus(tmppath).isDir()) {
			        throw new RuntimeException(tmpdir + " exists but is not a directory");
			      }

			      if (!fs.exists(tmppath)) {
			        if (!fs.mkdirs(tmppath)) {
			          throw new RuntimeException("Could not make scratch directory "
			              + tmpdir);
			        }
			      }

			      for (Object one : Utilities.makeList("windowing-hive-1.out")) {
			        Path onedir = new Path(tmppath, (String) one);
			        if (fs.exists(onedir)) {
			          fs.delete(onedir, true);
			        }
			      }

			    } catch (Throwable e) {
			      e.printStackTrace();
			      throw new RuntimeException("Encountered throwable");
			    }

	  }
	  
	  public static ExprNodeColumnDesc getStringColumn(String columnName) {
		    return new ExprNodeColumnDesc(TypeInfoFactory.stringTypeInfo, columnName,
		        "", false);
		  }

	  private ExprNodeDesc getExprDesc(String name, TypeInfo ti){
		  ExprNodeDesc nodeDesc = new ExprNodeColumnDesc(ti, name, "_" + name, false);
		  return nodeDesc;
	  }

	  @SuppressWarnings("unchecked")
	  private void populateReduceOnlyPlan(Table inputTable, QueryDef qdef) throws SemanticException {
	    mr.setNumReduceTasks(Integer.valueOf(1));

	    TableFuncDef tabDef = (TableFuncDef) qdef.getInput();
	    InputInfo input = qdef.getTranslationInfo().getInputInfo(tabDef);
	    
	    ArrayList<ExprNodeDesc> partCols =  new ArrayList<ExprNodeDesc>();
	    ArrayList<ExprNodeDesc> valueCols = new ArrayList<ExprNodeDesc>();
	    ArrayList<ExprNodeDesc> orderCols =  new ArrayList<ExprNodeDesc>();
	    List<String> outputColumnNames = new ArrayList<String>();
	    ArrayList<ExprNodeDesc> selectColList = new ArrayList<ExprNodeDesc>();
	    ArrayList<String> selectOutputColumns = new ArrayList<String>();


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
	    
	    
	    ArrayList<ColumnDef> selColDefs = qdef.getSelectList().getColumns();
	    for (ColumnDef colDef : selColDefs) {
	    	selectColList.add(colDef.getExprNode());
	    	String name = colDef.getExpression().getChild(0).getText();
	    	selectOutputColumns.add(name);
		}
	    
	    QueryOutputSpec qOutSpec = qdef.getOutput().getOutputSpec();
	    String outputPath = qOutSpec.getPath();


	    //map-side work
	    /*Operator<ReduceSinkDesc> op1 = OperatorFactory.get(PlanUtils
	        .getReduceSinkDesc(partCols, valueCols, outputColumnNames, true,
	        -1, 1, -1));*/
	    
	    
	    Operator<ReduceSinkDesc> op1 = OperatorFactory.get(PlanUtils
		        .getReduceSinkDesc(orderCols, valueCols, outputColumnNames, true, -1, partCols, orderString.toString(), -1));
	    
	    Utilities.addMapWork(mr, inputTable, "_" + inputTable, op1);
	    mr.setKeyDesc(op1.getConf().getKeySerializeInfo());
	    mr.getTagToValueDesc().add(op1.getConf().getValueSerializeInfo());

	    // reduce side work
	    Operator<FileSinkDesc> op4 = OperatorFactory.get(new FileSinkDesc(outputPath, 
	    		Utilities.defaultTd, false));
	    
	    Operator<SelectDesc> op3 = OperatorFactory.get(new SelectDesc(selectColList, 
	    		selectOutputColumns), op4);


	    Operator<ExtractDesc> op2 = OperatorFactory.get(new ExtractDesc(
	        getStringColumn(Utilities.ReduceField.VALUE.toString())), op3);

	    mr.setReducer(op2);
	  }

	  private void executePlan() throws Exception {
		    String testName = new Exception().getStackTrace()[1].getMethodName();
		    MapRedTask mrtask = new MapRedTask();
		    DriverContext dctx = new DriverContext ();
		    mrtask.setWork(mr);
		    mrtask.initialize(hiveConf, null, dctx);
		    int exitVal =  mrtask.execute(dctx);

		    if (exitVal != 0) {
		      System.out.println(testName + " execution failed with exit status: "
		          + exitVal);
		      assertEquals(true, false);
		    }
		    System.out.println(testName + " execution completed successfully");
		  }
	  
	  private QueryDef populateQueryDef() throws Exception{
/*		  return wshell.translate("select  p_mfgr,p_name, p_size, rank() as r, denserank() as dr " +
		  		"from part " +
		  		"partition by p_mfgr " +
		  		"order by p_mfgr " +
		  		"window w1 as rows between 2 preceding and 2 following " +
		  		"into path='/tmp/wout2' " +
		  		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
		  		"with serdeproperties('field.delim'=',') " +
		  		"format 'org.apache.hadoop.mapred.TextOutputFormat'");*/
		  
		  return wshell.translate("select p_mfgr,p_name,p_size,p_comment " +
			  		"from part " +
			  		"partition by p_mfgr " +
			  		"order by p_size " +
			  		"into path='/tmp/wout2' " +
			  		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
			  		"with serdeproperties('field.delim'=',') " +
			  		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
	  }

	@SuppressWarnings("deprecation")
	@Test
	  public void testReduceOnlyPlan() throws Exception {

	    System.out.println("Beginning testReduceOnlyPlan");

	    try {
	      QueryDef qDef = populateQueryDef();
	      System.out.println(qDef.getInput().getAlias());
	      String tableName = "part";
	      org.apache.hadoop.hive.metastore.api.Table hiveTable = qDef.getTranslationInfo().getHiveMSClient().getTable(tableName);
	      String dbName = hiveTable.getDbName();
	      

	      db = Hive.get(hiveConf);
	      Table hiveMetaTable = db.getTable(dbName, tableName);
	      
	      
	      populateReduceOnlyPlan(hiveMetaTable, qDef);
	      executePlan();
	      //fileDiff("kv1.val.sorted.txt", "mapredplan1.out");
	    } catch (Throwable e) {
	      e.printStackTrace();
	      fail("Got Throwable");
	    }
	  }

}
