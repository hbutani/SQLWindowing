package com.sap.hadoop.windowing.runtime.hive

import org.apache.hadoop.hive.ql.exec.ColumnInfo;
import org.apache.hadoop.hive.ql.parse.BaseSemanticAnalyzer;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.TypeCheckProcFactory;
import org.apache.hadoop.hive.ql.plan.ExprNodeColumnDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeConstantDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.SelectDesc;

class ExprNodeBuilder
{
	static SelectDesc select1(RowResolver rr)
	{
		ArrayList<ExprNodeDesc> cols = [];
		ArrayList<String> aliases = ["p_name", "p_size"]
		
		aliases.each { name ->
			cols << column(name, rr)
		}
		
		cols << function("struct", cols[0], cols[1])
		aliases << "s1"
		
		cols << function("substr", column("p_mfgr", rr), constant(1), constant(7))
		aliases << "s2"
		
		//cols << function("map_keys", function("struct", column("p_name", rr), column("p_size", rr)))
		//aliases << "m"
		
		return new SelectDesc(cols, aliases, false)
	}
	

	static ExprNodeDesc filter1(RowResolver rr)
	{
		ExprNodeColumnDesc pSize = column("p_size", rr)
		ExprNodeConstantDesc fifty = constant(45)
		ExprNodeDesc gt = function(">", pSize, fifty)
		
		ExprNodeDesc like = function("like", column("p_name", rr), constant('%indian%'))
		ExprNodeDesc and = function("and", gt, like)
		
		
		return and
	}
	
	
	static ExprNodeColumnDesc column(String name, RowResolver rr)
	{
		String cname = BaseSemanticAnalyzer.unescapeIdentifier(name);
		ColumnInfo colInfo = rr.get(null, cname);
		return new ExprNodeColumnDesc(colInfo.getType(),
				colInfo.getInternalName(),
				colInfo.getTabAlias(),
				colInfo.getIsVirtualCol());
	}
	
	static ExprNodeConstantDesc constant(Object value)
	{
		return new ExprNodeConstantDesc(value)
	}
	
	static ExprNodeDesc function(String name, ExprNodeDesc... args)
	{
		return TypeCheckProcFactory.DefaultExprProcessor.getFuncExprNodeDesc(name, args)
	}
	

}
