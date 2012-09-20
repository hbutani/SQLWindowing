package org.apache.hadoop.hive.ql.exec;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.DriverContext;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.plan.ExprNodeColumnDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeFieldDesc;
import org.apache.hadoop.hive.ql.plan.ExtractDesc;
import org.apache.hadoop.hive.ql.plan.FileSinkDesc;
import org.apache.hadoop.hive.ql.plan.MapredWork;
import org.apache.hadoop.hive.ql.plan.PlanUtils;
import org.apache.hadoop.hive.ql.plan.ReduceSinkDesc;
import org.apache.hadoop.hive.ql.plan.SelectDesc;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.specification.QueryOutputSpec;
import com.sap.hadoop.windowing.query2.specification.SelectSpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;
import com.sap.hadoop.windowing.query2.translate.Translator;
import com.sap.hadoop.windowing.runtime.hive.EvalContext;
import com.sap.hadoop.windowing.runtime2.Executor;
import com.sap.hadoop.windowing.runtime2.ThriftBasedHiveQueryExecutor;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public class TestPTFOperator extends TestCase {

	  static HiveConf hiveConf;
	  MapredWork mr;
	  static WindowingShell wshell;
      static ByteArrayOutputStream outStream;

	  private static String tmpdir = "/home/pkalmegh/Projects/SQLWindowing/" + System.getProperty("user.name")
	      + "/";
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
		
		wshell = new WindowingShell(hiveConf, new Translator(), new Executor());
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


	  private static void fileDiff(String datafile, String testdir) throws Exception {
	    String testFileDir = hiveConf.get("test.data.files");
	    System.out.println(testFileDir);
	    FileInputStream fi_gold = new FileInputStream(new File(testFileDir,
	        datafile));

	    // inbuilt assumption that the testdir has only one output file.
	    Path di_test = new Path(tmppath, testdir);
	    if (!fs.exists(di_test)) {
	      throw new RuntimeException(tmpdir + testdir + " does not exist");
	    }
	    if (!fs.getFileStatus(di_test).isDir()) {
	      throw new RuntimeException(tmpdir + testdir + " is not a directory");
	    }

	    FSDataInputStream fi_test = fs.open((fs.listStatus(di_test))[0].getPath());

	    if (!Utilities.contentsEqual(fi_gold, fi_test, false)) {
	      System.out.println(di_test.toString() + " does not match " + datafile);
	      assertEquals(false, true);
	    }
	  }

	  @SuppressWarnings("unchecked")
	  private void populateReduceOnlyPlan(Table inputTable, QueryDef qdef) throws SemanticException {
	    mr.setNumReduceTasks(Integer.valueOf(1));

	    TableFuncDef tdef = (TableFuncDef) qdef.getInput();
	    QueryOutputSpec qOutSpec = qdef.getSpec().getOutput();
	    TableFuncSpec qInSpec = (TableFuncSpec) qdef.getSpec().getInput();
	    
	    
	    
	    //get partitiondef, orderdef from windowdef->queryinputdef->tablefuncdef
	    //get rowresolver from querytranslationinfo (getinputinfo or getmapinputinfo)
	    
	    
/*	    ArrayList<ColumnDef> outputColDefs = qdef.getOutput().getColumnDefs();
	    for (ColumnDef columnDef : outputColDefs) {
			String col = columnDef.getExprNode().getName();
			System.out.println("Column - " + col);
		}
*/	    
	    // map-side work
	    ArrayList<ExprNodeDesc> keyCols = Utilities.makeList(getStringColumn("p_mfgr")); 
	    ArrayList<ExprNodeDesc> valueCols = Utilities.makeList(getStringColumn("p_mfgr"),
	    		getStringColumn("p_name"),
	    		getStringColumn("p_size")); 
	    List<String> outputColumnNames = new ArrayList<String>();
	    
	    
/*
	    for (int i = 0; i < 4; i++) {
	    	outputColumnNames.add("_col" + i);
	    }
*/
	    outputColumnNames.add("p_mfgr");
	    outputColumnNames.add("p_mfgr");
	    outputColumnNames.add("p_name");
	    outputColumnNames.add("p_size");
	    
	     Operator<ReduceSinkDesc> op1 = OperatorFactory.get(PlanUtils
	        .getReduceSinkDesc(keyCols, valueCols, outputColumnNames, true,
	        -1, 1, -1));
	    
	    

	    
	    Utilities.addMapWork(mr, inputTable, "part", op1);
	    mr.setKeyDesc(op1.getConf().getKeySerializeInfo());
	    mr.getTagToValueDesc().add(op1.getConf().getValueSerializeInfo());

	    // reduce side work
	    Operator<FileSinkDesc> op4 = OperatorFactory.get(new FileSinkDesc(tmpdir
	        + "reduceOnlyPlan.out", Utilities.defaultTd, false));
	    
	    ArrayList<ExprNodeDesc> selectColList = Utilities.makeList(
	    		getStringColumn("p_mfgr"),
	    		getStringColumn("p_name"),
	    		getStringColumn("p_size"));
	    
	    ArrayList<String> selectOutputColumns = new ArrayList<String>();
	     SelectSpec selSpec = qdef.getSpec().getSelectList();
	     ArrayList<ASTNode> selExprs = selSpec.getExpressions();
	     for (ASTNode astNode : selExprs) {
	    	 selectOutputColumns.add(astNode.getChild(0).getText());
		}


	    
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
		  
		  return wshell.translate("select  p_mfgr,p_name, p_size " +
			  		"from part " +
			  		"partition by p_mfgr " +
			  		"order by p_mfgr " +
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
