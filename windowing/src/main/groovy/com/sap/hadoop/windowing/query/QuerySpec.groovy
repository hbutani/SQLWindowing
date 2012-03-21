package com.sap.hadoop.windowing.query

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.sap.hadoop.windowing.runtime.ArgType;
import org.apache.hadoop.io.Writable;

class QuerySpec implements Writable
{
	String queryStr
	TableInput tableIn
	TableFuncSpec tblFuncSpec
	ArrayList<FuncSpec> funcSpecs
	String whereExpr
	TableOutput tableOut
	ArrayList<SelectColumn> selectColumns
	
	QuerySpec()
	{
		tableIn = new TableInput()
		funcSpecs = []
		tableOut = new TableOutput()
		selectColumns = []
	}
	
	public String toString()
	{
		return sprintf(
			"Query:\n\ttableInput=(%s)\n\ttableFuncSpec=%s\n\tfuncSpecs=[%s]\n\tselect=%s\n\twhereExpr=%s\n\ttableOutput=(%s)\n", 
			tableIn, tblFuncSpec, funcSpecs.join(",\n\t\t"), selectColumns.join(", "), whereExpr, tableOut)
	}
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		int nullFlags = 0
		if ( whereExpr != null )             nullFlags |= 0x01
		if ( tblFuncSpec )           nullFlags |= 0x02
		out.writeInt(nullFlags)
		if ( (nullFlags & 0x01) ) org.apache.hadoop.io.Text.writeString(out, whereExpr);
		if ( (nullFlags & 0x02) ) tblFuncSpec.write(out)
		
		org.apache.hadoop.io.Text.writeString(out, queryStr)
		tableIn.write(out)
		int fSz = funcSpecs.size()
		out.writeInt(fSz)
		for(FuncSpec f : funcSpecs)
		{
			f.write(out)
		}
		tableOut.write(out)
		int cSz = selectColumns.size()
		out.writeInt(cSz)
		for(SelectColumn sc : selectColumns)
		{
			sc.write(out)
		}
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		int nullFlags = din.readInt();
		if ( nullFlags & 0x01 )  whereExpr = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x02 )
		{
			tblFuncSpec = new TableFuncSpec()
			tblFuncSpec.readFields(din)
		}
		
		queryStr = org.apache.hadoop.io.Text.readString(din);
		
		tableIn = new TableInput()
		tableIn.readFields(din)
		
		int i
		int fSz = din.readInt()
		for(i=0; i < fSz; i++)
		{
			FuncSpec f = new FuncSpec()
			f.readFields(din)
			funcSpecs << f
		}
		
		tableOut = new TableOutput()
		tableOut.readFields(din)
		
		int cSz = din.readInt()
		for(i=0; i < cSz; i++)
		{
			SelectColumn sc = new SelectColumn()
			sc.readFields(din)
			selectColumns << sc
		}
	}
	
}

/**
 * <ul>
 * <li> if tableName is specified and it is possible to connect to a HIve MetaStore then rest of the information is extracted from MStore
 * <li> o.w. in hiveMode: 
 * </ul>
 * @author "Harish Butani"
 *
 */
class TableInput implements Writable
{
	String tableName
	String hiveQuery
	String windowingInputClass
	String inputPath
	String keyClass
	String valueClass
	String inputFormatClass
	String serDeClass
	Properties serDeProps = new Properties()
	ArrayList<String> partitionColumns
	ArrayList<OrderColumn> orderColumns
	
	TableInput()
	{		
		partitionColumns = []
		orderColumns = []
	}
	
	public String toString()
	{
		if (tableName != null )
		{
			return sprintf('hiveTable=%s\n\t\tpartitionColumns=%s\n\t\torderColumns=%s', tableName, partitionColumns.join(", "), orderColumns.join(", "))
		}
		else if ( hiveQuery != null )
		{
			return sprintf('hiveQuery=<%s>\n\t\tpartitionColumns=%s\n\t\torderColumns=%s', hiveQuery, partitionColumns.join(", "), orderColumns.join(", "))
		}
		return sprintf( 'windowInputClass=%s, inputPath=%s, keyClass=%s, valueClass=%s, inputFormatClass=%s, serDeClass=%s, serDeProps=%s\n\t\tpartitionColumns=%s\n\t\torderColumns=%s', 
			windowingInputClass, inputPath, keyClass, valueClass, inputFormatClass, serDeClass, serDeProps,
			partitionColumns.join(", "), orderColumns.join(", "))
	}

	@Override
	public void write(DataOutput out) throws IOException
	{
		int nullFlags = 0
		if ( tableName != null )           nullFlags |= 0x01 
		if ( hiveQuery != null )           nullFlags |= 0x02
		if ( windowingInputClass != null ) nullFlags |= 0x04
		if ( inputPath != null )           nullFlags |= 0x08
		if ( keyClass != null )            nullFlags |= 0x10
		if ( valueClass != null )          nullFlags |= 0x20
		if ( inputFormatClass != null )    nullFlags |= 0x40
		if ( serDeClass != null )          nullFlags |= 0x80
		out.writeInt(nullFlags)
		if ( (nullFlags & 0x01) ) org.apache.hadoop.io.Text.writeString(out, tableName);
		if ( (nullFlags & 0x02) ) org.apache.hadoop.io.Text.writeString(out, hiveQuery);
		if ( (nullFlags & 0x04) ) org.apache.hadoop.io.Text.writeString(out, windowingInputClass);
		if ( (nullFlags & 0x08) ) org.apache.hadoop.io.Text.writeString(out, inputPath);
		if ( (nullFlags & 0x10) ) org.apache.hadoop.io.Text.writeString(out, keyClass);
		if ( (nullFlags & 0x20) ) org.apache.hadoop.io.Text.writeString(out, valueClass);
		if ( (nullFlags & 0x40) ) org.apache.hadoop.io.Text.writeString(out, inputFormatClass);
		if ( (nullFlags & 0x80) ) org.apache.hadoop.io.Text.writeString(out, serDeClass);
		
		int serDePropssz = serDeProps.size();
		out.writeInt(serDePropssz)
		for(Map.Entry<?, ?> entry : serDeProps)
		{
			org.apache.hadoop.io.Text.writeString(out, (String) entry.key);
			org.apache.hadoop.io.Text.writeString(out, (String) entry.value);
		}
		
		int pColssz = partitionColumns.size()
		out.writeInt(pColssz)
		for(String s : partitionColumns)
		{
			org.apache.hadoop.io.Text.writeString(out, s);
		}
		
		int oColsz = orderColumns.size()
		out.writeInt(oColsz)
		for(OrderColumn oc : orderColumns)
		{
			oc.write(out)
		}
	}

	@Override
	public void readFields(DataInput din) throws IOException 
	{
		int nullFlags = din.readInt();
		if ( nullFlags & 0x01 ) tableName = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x02 )  hiveQuery = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x04 )  windowingInputClass = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x08 )  inputPath = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x10 )  keyClass = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x20 )  valueClass = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x40 )  inputFormatClass = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x80 )  serDeClass = org.apache.hadoop.io.Text.readString(din);
		
		int i;
		int serDePropssz = din.readInt();
		for(i=0; i < serDePropssz; i++)
		{
			serDeProps.put(org.apache.hadoop.io.Text.readString(din), org.apache.hadoop.io.Text.readString(din))
		}
		
		int pColssz = din.readInt();
		for(i=0; i < pColssz; i++)
		{
			partitionColumns << org.apache.hadoop.io.Text.readString(din)
		}
		
		int oColsz = din.readInt();
		for(i=0; i < oColsz; i++)
		{
			OrderColumn oc = new OrderColumn()
			oc.readFields(din)
			orderColumns << oc
		}
	}
}

class TableOutput implements Writable
{
	static final String DEFAULT_SERDE_CLASS = "org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe"
	static final String DEFAULT_FORMAT_CLASS = 'org.apache.hadoop.mapred.TextOutputFormat'
	static final String DEFAULT_RECORDWRITER_CLASS = "org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter"
	
	String outputPath
	String serDeClass
	Properties serDeProps = new Properties()
	String outputFormat
	String recordwriterClass
	String tableName
	String partitionClause
	boolean overwrite
	
	public String toString()
	{
		if ( recordwriterClass )
		{
			return sprintf("output(path=%s, serde=%s, serDeProps=%s, recordwriterClass=%s",
				outputPath, serDeClass, serDeProps, recordwriterClass)
		}
		else
		{
			if ( tableName )
			{
				return sprintf("output(path=%s, serde=%s, serDeProps=%s, format=%s, tableName=%s, loadClause=%s, overwrite=%s",
					outputPath, serDeClass, serDeProps, outputFormat, tableName, partitionClause, overwrite)
			}
			else
			{
				return sprintf("output(path=%s, serde=%s, serDeProps=%s, format=%s", 
					outputPath, serDeClass, serDeProps, outputFormat)
			}
		}
		
	}
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		int nullFlags = 0
		if ( outputPath != null )           nullFlags |= 0x01
		if ( serDeClass != null )           nullFlags |= 0x02
		if ( outputFormat != null )         nullFlags |= 0x04
		if ( recordwriterClass != null )    nullFlags |= 0x08
		if ( tableName != null )            nullFlags |= 0x10
		if ( partitionClause != null )      nullFlags |= 0x20
		out.writeInt(nullFlags)
		if ( (nullFlags & 0x01) ) org.apache.hadoop.io.Text.writeString(out, outputPath);
		if ( (nullFlags & 0x02) ) org.apache.hadoop.io.Text.writeString(out, serDeClass);
		if ( (nullFlags & 0x04) ) org.apache.hadoop.io.Text.writeString(out, outputFormat);
		if ( (nullFlags & 0x08) ) org.apache.hadoop.io.Text.writeString(out, recordwriterClass);
		if ( (nullFlags & 0x10) ) org.apache.hadoop.io.Text.writeString(out, tableName);
		if ( (nullFlags & 0x20) ) org.apache.hadoop.io.Text.writeString(out, partitionClause);
		
		int serDePropssz = serDeProps.size();
		out.writeInt(serDePropssz)
		for(Map.Entry<?, ?> entry : serDeProps)
		{
			org.apache.hadoop.io.Text.writeString(out, (String) entry.key);
			org.apache.hadoop.io.Text.writeString(out, (String) entry.value);
		}
		
		out.writeBoolean(overwrite)
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		int nullFlags = din.readInt();
		if ( nullFlags & 0x01 )  outputPath = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x02 )  serDeClass = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x04 )  outputFormat = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x08 )  recordwriterClass = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x10 )  tableName = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x20 )  partitionClause = org.apache.hadoop.io.Text.readString(din);
		
		int i;
		int serDePropssz = din.readInt();
		for(i=0; i < serDePropssz; i++)
		{
			serDeProps.put(org.apache.hadoop.io.Text.readString(din), org.apache.hadoop.io.Text.readString(din))
		}
		
		overwrite = din.readBoolean()
	}
}

class FuncSpec implements Writable
{
	String name
	String alias
	String typeName
	ArrayList<FuncArg> params; 
	Window window
	
	FuncSpec()
	{
		params = []
	}

	public String toString()
	{
		return sprintf( '%s(alias=%s, param=%s, type=%s, window=%s)', 
			name, alias, params, typeName, window)
	}
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		int nullFlags = 0
		if ( name != null )         nullFlags |= 0x01
		if ( alias != null )        nullFlags |= 0x02
		if ( typeName != null )     nullFlags |= 0x04
		if ( window )       nullFlags |= 0x08
		out.writeInt(nullFlags)
		if ( (nullFlags & 0x01) ) org.apache.hadoop.io.Text.writeString(out, name);
		if ( (nullFlags & 0x02) ) org.apache.hadoop.io.Text.writeString(out, alias);
		if ( (nullFlags & 0x04) ) org.apache.hadoop.io.Text.writeString(out, typeName);
		if ( (nullFlags & 0x08) ) window.write(out)
		int psz = params.size()
		out.writeInt(psz)
		for(FuncArg p : params)
		{
			p.write(out)
		}
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		int nullFlags = din.readInt();
		if ( nullFlags & 0x01 ) name = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x02 ) alias = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x04 ) typeName = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x08 )
		{
			window = new Window()
			window.readFields(din)
		}
		int psz = din.readInt()
		for(int i=0; i < psz; i++)
		{
			FuncArg p = new FuncArg()
			p.readFields(din)
			params << p
		}
	}
}

class FuncArg implements Writable
{
	String str
	String expr
	String id
	int iVal
	
	public String toString()
	{
		switch(argType)
		{
		case ArgType.STRING:
			return sprintf( 'strVal=%s', str)
		case ArgType.SCRIPT:
			return sprintf( 'expr=%s', expr)
		case ArgType.ID:
			return sprintf( 'id=%s', id)
		case ArgType.NUMBER:
			return sprintf( 'intValue=%s', iVal)
		}
	}
	
	ArgType getArgType()
	{
		if ( expr )
			return ArgType.SCRIPT;
		else if ( str )
			return ArgType.STRING;
		else if ( id )
			return ArgType.ID;
		else if ( iVal )
			return ArgType.NUMBER;
		return ArgType.STRING;
	}
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		int nullFlags = 0
		if ( str != null )         nullFlags |= 0x01
		if ( expr != null )        nullFlags |= 0x02
		if ( id != null )          nullFlags |= 0x04
		out.writeInt(nullFlags)
		if ( (nullFlags & 0x01) ) org.apache.hadoop.io.Text.writeString(out, str);
		if ( (nullFlags & 0x02) ) org.apache.hadoop.io.Text.writeString(out, expr);
		if ( (nullFlags & 0x04) ) org.apache.hadoop.io.Text.writeString(out, id);
		out.writeInt(iVal)
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		int nullFlags = din.readInt();
		if ( nullFlags & 0x01 ) str = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x02 ) expr = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x04 ) id = org.apache.hadoop.io.Text.readString(din);
		iVal = din.readInt()
	}
}

/**
 * <ul>
 * <li> A tableFunction may specify how its input be partitioned and an ordering within each partition.
 * <li> If partitioning is not specified then the function operates on the partitions of the input.
 * <li> It is illegal to specify a partition for a function whose input is the 
 * Query Input ( a hive Qry or table or an hdfs table) because the input clause has a partition specification.
 * </ul>
 */
class TableFuncSpec extends FuncSpec
{
	TableFuncSpec inputFuncSpec
	ArrayList<String> partitionColumns
	ArrayList<OrderColumn> orderColumns
	
	TableFuncSpec()
	{
		partitionColumns = []
		orderColumns = []
	}
	
	public String toString()
	{
		if (!inputFuncSpec )
		{
			return sprintf( '%s(param=%s, partitionColumns=[%s], orderColumns=[%s], window=%s)',
				name, params, partitionColumns?.join(", "), orderColumns?.join(", "), window)
		}
		else
		{
			return sprintf( '%s(%s, param=%s, partitionColumns=[%s], orderColumns=[%s], window=%s)',
				name, inputFuncSpec, params, partitionColumns?.join(", "), orderColumns?.join(", "), window)
		}
	}
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		super.write(out)
		int nullFlags = 0
		if ( inputFuncSpec )             nullFlags |= 0x01
		if ( partitionColumns != null )  nullFlags |= 0x02
		if ( orderColumns != null )      nullFlags |= 0x04
		out.writeInt(nullFlags)
		if ( (nullFlags & 0x01) ) inputFuncSpec.write(out)
		
		if ( nullFlags & 0x02 )
		{
			int pColssz = partitionColumns.size()
			out.writeInt(pColssz)
			for(String s : partitionColumns)
			{
				org.apache.hadoop.io.Text.writeString(out, s);
			}
		}
		
		if ( nullFlags & 0x04 )
		{
			int oColsz = orderColumns.size()
			out.writeInt(oColsz)
			for(OrderColumn oc : orderColumns)
			{
				oc.write(out)
			}
		}
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		super.readFields(din)
		int nullFlags = din.readInt();
		if ( nullFlags & 0x01 ) 
		{
			inputFuncSpec = new TableFuncSpec()
			inputFuncSpec.readFields(din)
		}
		
		if ( nullFlags & 0x02 )
		{
			int pColssz = din.readInt();
			for(i=0; i < pColssz; i++)
			{
				partitionColumns << org.apache.hadoop.io.Text.readString(din)
			}
		}
		else
		{
			partitionColumns = null
		}
		
		if ( nullFlags & 0x04 )
		{
			int oColsz = din.readInt();
			for(i=0; i < oColsz; i++)
			{
				OrderColumn oc = new OrderColumn()
				oc.readFields(din)
				orderColumns << oc
			}
		}
		else
		{
			orderColumns = null
		}
	}
}

enum Order
{
	ASC,
	DESC;
}

class OrderColumn implements Writable
{
	String name
	Order order
	
	public String toString()
	{
		return sprintf( '%s %s', name, order)
	}

	@Override
	public void write(DataOutput out) throws IOException
	{
		org.apache.hadoop.io.Text.writeString(out, name);
		org.apache.hadoop.io.Text.writeString(out, order.name());
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		name = org.apache.hadoop.io.Text.readString(din);
		order = Enum.valueOf(Order, org.apache.hadoop.io.Text.readString(din))
	}
}

class SelectColumn implements Writable
{
	String alias
	String expr
	String typeName
	
	public String toString()
	{
		if ( expr  )
			return sprintf( '%s as %s%s', expr, alias, (typeName ? "[" + typeName + "]" : ""))
		else
			return sprintf( '%s%s', alias, (typeName ? "[" + typeName + "]" : ""))
	}
	
	@Override
	public void write(DataOutput out) throws IOException
	{
		int nullFlags = 0
		if ( alias != null )         nullFlags |= 0x01
		if ( expr != null )          nullFlags |= 0x02
		if ( typeName != null )      nullFlags |= 0x04
		out.writeInt(nullFlags)
		if ( (nullFlags & 0x01) ) org.apache.hadoop.io.Text.writeString(out, alias);
		if ( (nullFlags & 0x02) ) org.apache.hadoop.io.Text.writeString(out, expr);
		if ( (nullFlags & 0x04) ) org.apache.hadoop.io.Text.writeString(out, typeName);
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		int nullFlags = din.readInt();
		if ( nullFlags & 0x01 ) alias = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x02 )  expr = org.apache.hadoop.io.Text.readString(din);
		if ( nullFlags & 0x04 )  typeName = org.apache.hadoop.io.Text.readString(din);
	}
}