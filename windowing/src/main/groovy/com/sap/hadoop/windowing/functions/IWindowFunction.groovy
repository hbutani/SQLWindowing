package com.sap.hadoop.windowing.functions

import com.sap.hadoop.windowing.query.OrderColumn;
import com.sap.hadoop.windowing.query.Window;
import com.sap.hadoop.windowing.runtime.Partition;

abstract class IWindowFunction
{
	OrderColumn[] orderColumns
	Window window
	
	abstract def processPartition(Partition p)
}
