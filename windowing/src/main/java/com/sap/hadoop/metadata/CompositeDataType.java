package com.sap.hadoop.metadata;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.io.DataInputBuffer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import com.sap.hadoop.windowing.WindowingException;

@SuppressWarnings("rawtypes")
public class CompositeDataType extends DataType<CompositeWritable> implements Writable
{
	public static final String COMPOSITE_DATA_TYPE = "windowing.composite.datatype";

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
	
	public static CompositeDataType define(StructObjectInspector OI) throws WindowingException
	{
		List<? extends StructField> fields = OI.getAllStructFieldRefs();
		@SuppressWarnings("unchecked")
		DataType<? extends WritableComparable>[] elementTypes = (DataType<? extends WritableComparable>[]) new DataType[fields.size()];
		int i=0;
		for(StructField f : fields)
		{
			ObjectInspector fOI = f.getFieldObjectInspector();
			if ( fOI.getCategory() != Category.PRIMITIVE )
			{
				throw new WindowingException("Cannot handle non primitve fields for partitioning/sorting");
			}
			
			PrimitiveObjectInspector pOI = (PrimitiveObjectInspector) fOI;
			switch(pOI.getPrimitiveCategory())
			{
			case BOOLEAN: 
				elementTypes[i] = BOOLEAN;
				break;
			case DOUBLE:
				elementTypes[i] = DOUBLE;
				break;
			case BYTE:
				elementTypes[i] = BYTE;
				break;
			case FLOAT:
				elementTypes[i] = FLOAT;
				break;
			case INT:
				elementTypes[i] = INT;
				break;
			case LONG:
				elementTypes[i] = LONG;
				break;
			case SHORT:
				elementTypes[i] = SHORT;
				break;
			case STRING:
				elementTypes[i] = TEXT;
				break;
			default :
				throw new WindowingException(Utils.sprintf("Cannot handle datatype %s for partitioning/sorting", pOI.toString()));
			}
			i++;
		}
		
		return new CompositeDataType(",", elementTypes);
	}
	
	public static class CompositeWritableComparator extends WritableComparator implements Configurable
	{
		Configuration conf;
		CompositeDataType recordType;
		CompositeWritable key1;
		CompositeWritable key2;
		private final DataInputBuffer buffer;
		
		protected String useConfigParamName()
		{
			return 	COMPOSITE_DATA_TYPE;
		}
		
		protected CompositeWritableComparator()
		{
			super(CompositeWritable.class);
			key1 = new CompositeWritable();
			key2 = new CompositeWritable();
			buffer = new DataInputBuffer();
		}

		@Override
		public void setConf(Configuration conf)
		{
			this.conf = conf;
			recordType = new CompositeDataType();
			try
			{
				recordType.readFields(conf.get(useConfigParamName()));
				recordType.cast(key1);
				recordType.cast(key2);
			}
			catch(IOException ie)
			{
				throw new RuntimeException(ie);
			}
		}

		@Override
		public Configuration getConf()
		{
			return conf;
		}
		
		@Override
		public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
		    try {
		      buffer.reset(b1, s1, l1);                   // parse key1
		      key1.readFields(buffer);
		      
		      buffer.reset(b2, s2, l2);                   // parse key2
		      key2.readFields(buffer);
		      
		    } catch (IOException e) {
		      throw new RuntimeException(e);
		    }
		    
		    return compare(key1, key2);                   // compare them
		  }
		
	}

}



