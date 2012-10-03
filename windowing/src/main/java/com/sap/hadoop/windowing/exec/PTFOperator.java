package com.sap.hadoop.windowing.exec;

import java.io.Serializable;
import java.util.Stack;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.api.OperatorType;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo;
import com.sap.hadoop.windowing.runtime2.Partition;

public class PTFOperator extends Operator<PTFDesc> implements
Serializable {

    private static final long serialVersionUID = 1L;
    static QueryDef qDef;
    static Partition inputPart;
    protected transient ExprNodeEvaluator[] eval;
    transient Object[] output;


    @Override
    protected void initializeOp(Configuration hconf) throws HiveException {
    	super.initializeOp(hconf);
		qDef = conf.getQdef();
		output = new Object[eval.length];
		outputObjInspector = qDef.getSelectList().getOI();
		inputPart = createPartition();
    }

    @Override
    protected void closeOp(boolean abort) throws HiveException {
    	super.closeOp(abort);
    	Partition outPart = executePTF(inputPart);
		try {
			//while rows exist in partition, forward one-by-one to next operator
	    	for(int i=0; i < outPart.size(); i++){
					output[i] = outPart.getWritableAt(i);
					forward(output[i], outputObjInspector);
			}
    	} catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	@Override
	public void processOp(Object row, int tag) throws HiveException {
		//hold on to all the rows in partition; required later to execute PTF chain
		try {
			Writable w = (Writable) row; //wIn.createRow();
			inputPart.append(w);
		} catch (WindowingException e) {
			e.printStackTrace();
		}
	}

	private static Partition createPartition()
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		HiveTableSpec hvTblSpec = qDef.getInput().getHiveTableSpec();
		TableFuncDef tabDef = (TableFuncDef) qDef.getInput();
		TableFunctionEvaluator tEval = tabDef.getFunction();
		String partClassName = tEval.getPartitionClass();
		int partMemSize = tEval.getPartitionMemSize();

		WindowingInput wIn;
		Partition part = null;
		try {
			wIn = IOUtils.createTableWindowingInput(hvTblSpec.getDbName(),
					hvTblSpec.getTableName(), tInfo.getHiveCfg());
			SerDe serDe = (SerDe) wIn.getDeserializer();
			StructObjectInspector oI = (StructObjectInspector) serDe
					.getObjectInspector();
			part = new Partition(partClassName, partMemSize,
					serDe, oI);
		} catch (WindowingException e) {
			e.printStackTrace();
		} catch (SerDeException e) {
			e.printStackTrace();
		}
		return part;

	}


	private Partition executePTF(Partition part){
		Stack<TableFuncDef> fnDefs = new Stack<TableFuncDef>();
		QueryInputDef iDef = qDef.getInput();
		while(true)
		{
			if (iDef instanceof TableFuncDef ){
				fnDefs.push((TableFuncDef)iDef);
				iDef = ((TableFuncDef) iDef).getInput();
			}
			else
			{
				break;
			}
		}

		TableFuncDef currFnDef;
		try {
			while( !fnDefs.isEmpty() ){
			currFnDef = fnDefs.pop();
				part = currFnDef.getFunction().execute(part);

			}
		} catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return part;
	}

	  /**
	   * @return the name of the operator
	   */
	  @Override
	  public String getName() {
	    return "PTF";
	  }

	@Override
	public OperatorType getType() {
		return null;
	}

}
