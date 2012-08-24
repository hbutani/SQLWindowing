package com.sap.hadoop.windowing.query2.translate;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;

public interface ITranslationTask
{
	void execute(QueryDef queryDef) throws WindowingException;
}
