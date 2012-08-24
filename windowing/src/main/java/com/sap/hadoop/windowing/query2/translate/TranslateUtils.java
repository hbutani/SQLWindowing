package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;
import java.util.Iterator;

import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;
import com.sap.hadoop.windowing.query2.translate.TableFunctionChainIterators.QueryInputSpecIterator;
import com.sap.hadoop.windowing.query2.translate.TableFunctionChainIterators.ReverseQueryInputSpecIterator;
import com.sap.hadoop.windowing.query2.translate.TableFunctionChainIterators.ReverseTableFunctionSpecIterator;
import com.sap.hadoop.windowing.query2.translate.TableFunctionChainIterators.TableFunctionSpecIterator;

public class TranslateUtils
{
	public static boolean hasWindowFunctions(QuerySpec qSpec)
	{
		if ( qSpec == null) return false;
		ArrayList<Boolean> isWFns = qSpec.getSelectList().getIsWindowFn();
		return isWFns.contains(true);
	}
	
	public static boolean hasTableFunctions(QuerySpec qSpec)
	{
		return new TableFunctionChainIterators.TableFunctionSpecIterator(qSpec).hasNext();
	}

	public static Iterator<QueryInputSpec> iterateInputSpecs(QuerySpec qSpec, boolean reverse)
	{
		return reverse ? new ReverseQueryInputSpecIterator(qSpec) : new QueryInputSpecIterator(qSpec);
	}
	
	public static Iterator<TableFuncSpec> iterateTableFuncSpecs(QuerySpec qSpec, boolean reverse)
	{
		return reverse ? new ReverseTableFunctionSpecIterator(qSpec) : new TableFunctionSpecIterator(qSpec);
	}
	

}
