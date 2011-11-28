package com.sap.hadoop.metadata;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

@SuppressWarnings("rawtypes")
public class CompositeDataType extends DataType<CompositeWritable> implements Writable
{
	DataType<? extends WritableComparable>[] elementTypes;
	Text fieldSep;
	
	public CompositeDataType()
	{
		super();
	}

	public CompositeDataType(String fieldSep, DataType<? extends WritableComparable>... elementTypes)
	{
		super(CompositeWritable.class);
		this.elementTypes = elementTypes;
		this.fieldSep = new Text(fieldSep);
	}
	
	public Text getFieldSep()
	{
		return fieldSep;
	}

	public CompositeWritable create()
	{
		WritableComparable[] elements = new WritableComparable[elementTypes.length];
		int i = 0;
		for (DataType<?> eType : elementTypes)
			elements[i++] = eType.create();
		return new CompositeWritable(this, elements);
	}
	
	public void cast(CompositeWritable val)
	{
		if ( val.getType() != this )
		{
			WritableComparable[] elements = new WritableComparable[elementTypes.length];
			int i = 0;
			for (DataType<?> eType : elementTypes)
				elements[i++] = eType.create();
			val.setElements(elements);
			val.setType(this);
		}
	}
	
	public CompositeWritable create(Configuration conf)
	{
		return create();
	}

	public DataType<?> getType(int i) { return elementTypes[i]; }
	
	/*
	 * Begin: methods from the Writable ifc
	 */
	
	private static String TYPE_BEGIN = "{";
	private static String TYPE_END = "}";
	private static String ELEM_SEP1 = ":";
	private static String ELEM_SEP2 = ",";
	private static String ELEM_SEP3 = "]";
		
	public void write(StringBuffer buf)
	{
		buf.append(TYPE_BEGIN);
		String elemSep = !ELEM_SEP1.contains(fieldSep.toString()) ? ELEM_SEP1 : 
			(!ELEM_SEP2.contains(fieldSep.toString()) ? ELEM_SEP2 : ELEM_SEP3);
		buf.append(elemSep);
		buf.append(fieldSep);
		for(DataType<? extends WritableComparable> etype : elementTypes)
		{
			buf.append(elemSep);
			etype.write(buf);
		}
		buf.append(TYPE_END);
	}
	
	public void write(DataOutput out) throws IOException
	{
		StringBuffer buf = new StringBuffer();
		write(buf);
		Text t = new Text(buf.toString());
		t.write(out);
	}

	@SuppressWarnings("unchecked")
	public void readFields(String s) throws IOException
	{
		ArrayList<DataType<? extends WritableComparable>> types = new ArrayList<DataType<? extends WritableComparable>>();
		String elemSep = s.substring(1, 2);
		s = s.substring(2, s.length() - 1);
		FieldIterator it = new FieldIterator(s, elemSep, TYPE_BEGIN, TYPE_END);
		
		fieldSep = new Text(it.next());
		while(it.hasNext())
		{
			String stype = it.next();
			if (nameToTypeMap.containsKey(stype))
				types.add(nameToTypeMap.get(stype));
			else
			{
				CompositeDataType ctype = new CompositeDataType();
				ctype.readFields(stype);
				types.add(ctype);
			}
		}
		elementTypes = types.toArray((DataType<? extends WritableComparable>[]) Array.newInstance(DataType.class, types.size()));
	}
	
	public void readFields(DataInput in) throws IOException
	{
		Text t = new Text();
		t.readFields(in);
		String s = t.toString();
		readFields(s);
	}
	
	/*
	 * End: methods from the Writable ifc
	 */
		
	@Override
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		write(buf);
		return buf.toString();
	}

}



