package com.sap.hadoop.windowing.runtime.hive

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.ql.parse.UnparseTranslator;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import org.apache.hadoop.io.Writable;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.io.WindowingInput;


class EvalContext
{
	RowResolver rr;
	WindowingInput wIn;
	Deserializer deS;
	ObjectInspector inoI;
	Writable w;
	TypeCheckCtx typeChkCtx;
	
	public EvalContext(HiveConf cfg)
	{
		wIn = IOUtils.createTableWindowingInput(null, "lineitem", cfg)
		deS = wIn.getDeserializer()
		inoI = deS.getObjectInspector()
		w = wIn.createRow();
		rr = HiveUtils.getRowResolver(null, "lineitem", "lineitem", cfg)
		typeChkCtx = new TypeCheckCtx(rr);
		//typeChkCtx.setUnparseTranslator(new UnparseTranslator());
	}
}
