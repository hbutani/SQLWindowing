package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde.Constants;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.io.MRWindowingInput;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.TableInput;
import com.sap.hadoop.windowing.query.TableOutput;
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
	
	void setupWriter(Query qry) throws WindowingException
	{
		// writer not used in MR mode
	}
	
	void validateOutputSpec(TableOutput tblOut) throws WindowingException
	{
		// validate serDeClass
		if ( tblOut.serDeClass == null )
		{
			tblOut.serDeClass = "org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe"
			tblOut.serDeProps.setProperty(Constants.FIELD_DELIM, ',');
		}
		try
		{
			Class.forName(tblOut.serDeClass)
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Unknown SerDe Class %s", tblOut.serDeClass), t)
		}
		
		// validate writer
		tblOut.outputFormat = (tblOut.outputFormat == null ? 
			TableOutput.DEFAULT_FORMAT_CLASS : tblOut.outputFormat)
		try
		{
			Class.forName(tblOut.outputFormat)
		}
		catch(Throwable t)
		{
			throw new WindowingException(
				sprintf("Unknown OutputFormat Class %s", tblOut.outputFormat), t)
		}
		
		// ensure user has not specified a FormatClass
		if ( tblOut.recordwriterClass != null )
		{
			throw new WindowingException("Illegal Output Spec: RecordWriter class not valid in MR mode")
		}
	}
}
