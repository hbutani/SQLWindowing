package com.sap.hadoop.windowing.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.hadoop.hive.serde2.Serializer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import static com.sap.hadoop.windowing.Constants.*;

class TableWindowingInput implements WindowingInput
{
	Path tableDirPath;
	Class<? extends Writable> keyClass;
	Class<? extends Writable> valueClass;
	Class<? extends InputFormat<? extends Writable, ? extends Writable>> inputFormatClass;
	FileStatus[] tableFiles;
	JobConf jconf;
	InputFormat<? extends Writable, ? extends Writable> iFmt;
	InputSplit[] iSplits;
	int currSplitNum;
	org.apache.hadoop.mapred.RecordReader<Writable, Writable> rdr;
	private SerDe serDe;
	Writable key;
	Writable value;
	boolean isValueValid;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(InputStream ins, Configuration conf, Properties tbl)
			throws IOException
	{
		try
		{
			setupSerDe(conf, tbl);
			tableDirPath = new Path(conf.get(INPUT_PATH));
			keyClass = (Class<? extends Writable>) Class.forName(conf
					.get(INPUT_KEY_CLASS));
			valueClass = (Class<? extends Writable>) Class.forName(conf
					.get(INPUT_VALUE_CLASS));
			inputFormatClass = (Class<? extends InputFormat<? extends Writable, ? extends Writable>>) Class
					.forName(conf.get(INPUT_INPUTFORMAT_CLASS));

			FileSystem fs = FileSystem.get(tableDirPath.toUri(), conf);
			FileStatus tableDir = fs.getFileStatus(tableDirPath);
			assert tableDir.isDir();
			tableFiles = fs.listStatus(tableDirPath);
			jconf = new JobConf();
			iFmt = inputFormatClass.newInstance();
			if (iFmt instanceof TextInputFormat)
				((TextInputFormat) iFmt).configure(jconf);
			jconf.set("mapred.input.dir", tableDirPath.toString());
			currSplitNum = 0;
			iSplits = iFmt.getSplits(jconf, 1);
			nextSplit();
		}
		catch (Exception e)
		{
			throw new IOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private boolean nextSplit() throws IOException
	{
		if (currSplitNum < iSplits.length)
		{
			if (rdr != null)
				rdr.close();
			InputSplit curriSplit = iSplits[currSplitNum++];
			rdr = (org.apache.hadoop.mapred.RecordReader<Writable, Writable>) iFmt
					.getRecordReader(curriSplit, jconf, Reporter.NULL);
			if (key == null)
			{
				key = rdr.createKey();
				value = rdr.createValue();
				isValueValid = false;
			}
			return true;
		}
		return false;
	}

	@Override
	public Writable createRow() throws IOException
	{
		try
		{
			return valueClass.newInstance();
		}
		catch (Exception e)
		{
			throw new IOException(e);
		}
	}

	@Override
	public int next(Writable row) throws IOException
	{
		if (rdr.next(key, row))
			return 0;

		if (nextSplit())
			return next(row);

		return -1;
	}

	@Override
	public void close() throws IOException
	{
		if (rdr != null)
			rdr.close();
	}

	private void setupSerDe(Configuration conf, Properties serDeProps)
			throws IOException
	{
		try
		{
			serDe = (SerDe) Class.forName(conf.get(INPUT_SERDE_CLASS))
					.newInstance();
			serDe.initialize(conf, serDeProps);
		}
		catch (Exception e)
		{
			throw new IOException(e);
		}
	}

	public Deserializer getDeserializer()
	{
		return serDe;
	}

	public Serializer getSerializer()
	{
		throw new UnsupportedOperationException();
	}

	public boolean hasNext()
	{
		try
		{
		isValueValid = rdr.next(key, value);
		if (!isValueValid)
		{
			if (nextSplit())
				return hasNext();
			else
				return false;
		}
		return isValueValid;
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public Writable next()
	{
		return value;
	}

	public void remove()
	{
		throw new UnsupportedOperationException();
	}

}
