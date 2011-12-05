package com.sap.hadoop.windowing.io;

import java.util.Iterator;

import org.apache.hadoop.hive.ql.exec.RecordReader;
import org.apache.hadoop.hive.serde2.Deserializer;

public interface WindowingInput extends RecordReader, Iterator<Object>
{
	Deserializer getDeserializer();
}