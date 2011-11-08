package com.sap.hadoop.windowing.io;

import java.util.Iterator;

import org.apache.hadoop.hive.ql.exec.RecordReader;
import org.apache.hadoop.hive.serde2.SerDe;

public interface WindowingInput extends RecordReader, Iterator<Object>
{
	SerDe getSerDe();
}