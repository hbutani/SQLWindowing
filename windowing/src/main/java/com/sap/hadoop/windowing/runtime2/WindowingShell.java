package com.sap.hadoop.windowing.runtime2;

import java.io.IOException;
import java.net.URI;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.ANTLRStringStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.parse.ASTNode;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.QSpecBuilder2;
import com.sap.hadoop.windowing.parser.Windowing2Lexer;
import com.sap.hadoop.windowing.parser.Windowing2Parser;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.translate.TranslateUtils;
import com.sap.hadoop.windowing.query2.translate.Translator;

import static com.sap.hadoop.Utils.sprintf;

public class WindowingShell
{
	private HiveConf cfg;
	Executor executor;
	Translator translator;
	HiveQueryExecutor hiveQryExec;
	
	
	WindowingShell(HiveConf cfg, Translator translator, Executor executor)
	{
		this.cfg = cfg;
		this.executor = executor;
		this.translator = translator;
	}
	
	public HiveConf getCfg()
	{
		return cfg;
	}

	public void setCfg(HiveConf cfg)
	{
		this.cfg = cfg;
	}

	public Executor getExecutor()
	{
		return executor;
	}

	public void setExecutor(Executor executor)
	{
		this.executor = executor;
	}

	public Translator getTranslator()
	{
		return translator;
	}

	public void setTranslator(Translator translator)
	{
		this.translator = translator;
	}

	public HiveQueryExecutor getHiveQryExec()
	{
		return hiveQryExec;
	}

	public void setHiveQryExec(HiveQueryExecutor hiveQryExec)
	{
		this.hiveQryExec = hiveQryExec;
	}

	public void checkQuery(String query) throws WindowingException
	{
		Windowing2Lexer lexer;
		CommonTokenStream tokens;
		Windowing2Parser parser = null;
		@SuppressWarnings("unused")
		CommonTree t;
//		CommonTreeNodeStream nodes;
		String err;
		
		try
		{
			lexer = new Windowing2Lexer(new ANTLRStringStream(query));
			tokens = new CommonTokenStream(lexer);
			parser = new Windowing2Parser(tokens);
			parser.setTreeAdaptor(TranslateUtils.adaptor);
			t = (CommonTree) parser.query().getTree();
			
			err = parser.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
		}
		catch(Throwable te)
		{
			err = parser.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			throw new WindowingException("Parse Error:" + te.toString(), te);
		}
		
	}
	
	public QuerySpec parse(String query) throws WindowingException
	{
		Windowing2Lexer lexer;
		CommonTokenStream tokens;
		Windowing2Parser parser = null;
		CommonTree t;
		CommonTreeNodeStream nodes;
		QSpecBuilder2 qSpecBldr = null;
		String err;
		
		try
		{
			lexer = new Windowing2Lexer(new ANTLRStringStream(query));
			tokens = new CommonTokenStream(lexer);
			parser = new Windowing2Parser(tokens);
			parser.setTreeAdaptor(TranslateUtils.adaptor);
			t = (CommonTree)  parser.query().getTree();
			
			err = parser.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
		}
		catch(Throwable te)
		{
			err = parser.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			throw new WindowingException("Parse Error:" + te.toString(), te);
		}
		
		TranslateUtils.unescapeStringLiterals((ASTNode) t);
		
		try
		{
			
			nodes = new CommonTreeNodeStream(t);
			nodes.setTokenStream(tokens);
			qSpecBldr = new QSpecBuilder2(nodes);
			qSpecBldr.query();
	
			err = qSpecBldr.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			
			return qSpecBldr.getQuerySpec();
		}
		catch(Throwable te)
		{
			err = qSpecBldr.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			throw new WindowingException("Parse Error:" + te.toString(), te);
		}
	}
	
	public QueryDef translate(String query) throws WindowingException
	{
		QuerySpec qSpec = parse(query);
		return translator.translate(qSpec, this);
	}
	
	public QueryDef translate(QuerySpec qSpec, HiveConf hCfg) throws WindowingException
	{
		return translator.translate(qSpec, this);
	}

	public void execute(String query, QueryOutputPrinter outP) throws WindowingException
	{
		QuerySpec qSpec = parse(query);
		QueryDef q = translator.translate(qSpec, this);
		
		execute(q, outP);
		
		/*
		 * FIXME: componentization in next round.

		ArrayList<QueryDef> componentQueries;
		
		
		
		if ( executor.allowQueryComponentization() )
		{
			executor.beforeComponentization(q, this)
			QueryComponentizer qC = new QueryComponentizer(q, this);
			componentQueries = qC.componentize();
		}
		else
		{
			componentQueries = [q]
		}
		
		executor.beforeExecute(q, componentQueries, this);
		try
		{
			componentQueries.each { Query cq ->
				execute(cq, outP);
			}
		}
		finally
		{
			executor.afterExecute(q, this);
		}
		*/
	}
	
	protected void execute(QueryDef q, QueryOutputPrinter outP) throws WindowingException
	{
		QuerySpec qSpec = q.getSpec();
		try
		{
			executor.execute(q, this);
		}
		finally
		{
			/* delete the temporary table created */
			
			/*
			 * FIXME: delete all tables in 1 shot.

			
			if ( qSpec.tableIn.hiveQuery != null && qSpec.tableIn.tableName != null )
			{
				hiveQryExec.dropTable(qSpec.tableIn.tableName)
			}
			*/
		}
		
		if ( qSpec.getOutput().getHiveTable() != null )
		{
			loadToOutputTable(q);
		}
		
		if (outP != null)
		{
			outP.printQueryOutput(q, cfg);
		}
	}
	
	protected void loadToOutputTable(QueryDef qry) throws WindowingException
	{
		//LOAD DATA [LOCAL] INPATH 'filepath' [OVERWRITE] INTO TABLE tablename [PARTITION (partcol1=val1, partcol2=val2 ...)]
		String loadCmd = sprintf("load data inpath '%s'", qry.getOutput().getSpec().getPath());
		if ( qry.getOutput().getSpec().isOverwriteHiveTable())
		{
			loadCmd += " OVERWRITE";
		}
		loadCmd += sprintf(" INTO TABLE %s", qry.getOutput().getSpec().getHiveTable());
		if ( qry.getOutput().getSpec().getPartitionClause() != null )
		{
			loadCmd += sprintf(" PARTITION %s", qry.getOutput().getSpec().getPartitionClause());
		}
		
		/*
		 * delete the _SUCCESS file; comes in the way of doing a load for RcFiles.
		 * also delete _logs directory
		 */
		if ( true )
		{
			try
				{
				FileSystem fs = FileSystem.get(URI.create(qry.getOutput().getSpec().getPath()), cfg);
				Path p = new Path(qry.getOutput().getSpec().getPath(), "_SUCCESS");
				if ( fs.exists(p))
				{
					fs.delete(p, false);
				}
				p = new Path(qry.getOutput().getSpec().getPath(), "_logs");
				if ( fs.exists(p))
				{
					fs.delete(p, true);
				}
			}
			catch(IOException ioe)
			{
				throw new WindowingException(ioe);
			}
		}
		
		hiveQryExec.executeHiveQuery(loadCmd);
	}
	
	public void executeHiveQuery(String hQry) throws WindowingException
	{
		if ( hiveQryExec == null)
			throw new WindowingException("cannot execute hive Query: hiveQryExec not setup");
		hiveQryExec.executeHiveQuery(hQry);
	}
}
