package com.sap.hadoop.windowing.runtime2.mr;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

/*
 * Argh, Copied from org.apache.hadoop.hive.ql.exec.KeyWrapper because interface is not public.
 * Get rid of once we fold into Hive.
 */
public abstract class WindowingKeyWrapper 
{
  abstract void getNewKey(Object row, ObjectInspector rowInspector) throws HiveException;
  abstract void setHashKey();
  abstract WindowingKeyWrapper copyKey();
  abstract void copyKey(WindowingKeyWrapper oldWrapper);
  abstract Object[] getKeyArray();
}

