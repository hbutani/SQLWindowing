package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.conf.Configuration;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.io.MRWindowingInput;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.TableInput;
import com.sap.hadoop.windowing.query.Translator;

class MRTranslator extends Translator
{
	WindowingInput setupWindowingInput(Query qry) throws WindowingException
	{
		TableInput tableIn = qry.qSpec.tableIn
		try
		{
			Configuration cfg = qry.cfg
			WindowingInput rdr = new MRWindowingInput();
			cfg.set(Job.WINDOWING_INPUT_TABLE, tableIn.tableName)
			rdr.initialize(null, cfg, tableIn.serDeProps);
			return rdr;
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
}
