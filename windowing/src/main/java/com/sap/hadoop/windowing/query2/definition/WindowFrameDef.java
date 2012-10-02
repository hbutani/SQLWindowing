package com.sap.hadoop.windowing.query2.definition;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.BoundarySpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.CurrentRowSpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.Direction;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.RangeBoundarySpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.ValueBoundarySpec;

public class WindowFrameDef
{
	WindowFrameSpec spec;
	BoundaryDef start;
	BoundaryDef end;
	
	public WindowFrameDef(){
		
	}
	
	public WindowFrameDef(WindowFrameSpec spec) { this.spec = spec; }
	
	public BoundaryDef getStart()
	{
		return start;
	}

	public void setStart(BoundaryDef start)
	{
		this.start = start;
	}

	public BoundaryDef getEnd()
	{
		return end;
	}

	public void setEnd(BoundaryDef end)
	{
		this.end = end;
	}
	
	public abstract static class BoundaryDef implements Comparable<BoundaryDef>
	{
		BoundarySpec spec;
		
		public BoundarySpec getSpec() {
			return spec;
		}

		public void setSpec(BoundarySpec spec) {
			this.spec = spec;
		}

		public BoundaryDef(BoundarySpec spec)
		{
			this.spec = spec;
		}
		
		public Direction getDirection() { return spec.getDirection(); }
	}
	
	public static class RangeBoundaryDef extends BoundaryDef
	{
		
		public RangeBoundaryDef(RangeBoundarySpec spec) { super(spec);}
		
		public int getAmt()
		{
			return ((RangeBoundarySpec)spec).getAmt();
		}

		public int compareTo(BoundaryDef other)
		{
			int c = getDirection().compareTo(other.getDirection());
			if ( c != 0) return c;
			RangeBoundaryDef rb = (RangeBoundaryDef) other;
			return getAmt() - rb.getAmt();
		}
	}
	
	public static class CurrentRowDef extends BoundaryDef
	{
		public CurrentRowDef(CurrentRowSpec spec) { super(spec);}
	
		public int compareTo(BoundaryDef other)
		{
			return getDirection().compareTo(other.getDirection());
		}
	}
	
	public static class ValueBoundaryDef extends BoundaryDef
	{
		ExprNodeDesc exprNode;
		transient ExprNodeEvaluator exprEvaluator;
		transient ObjectInspector OI;
		
		public ValueBoundaryDef(ValueBoundarySpec spec) { super(spec);}


		public int getAmt()
		{
			return ((ValueBoundarySpec)spec).getAmt();
		}

		public ExprNodeDesc getExprNode()
		{
			return exprNode;
		}

		public void setExprNode(ExprNodeDesc exprNode)
		{
			this.exprNode = exprNode;
		}

		public ExprNodeEvaluator getExprEvaluator()
		{
			return exprEvaluator;
		}


		public void setExprEvaluator(ExprNodeEvaluator exprEvaluator)
		{
			this.exprEvaluator = exprEvaluator;
		}

		public ObjectInspector getOI()
		{
			return OI;
		}


		public void setOI(ObjectInspector oI)
		{
			OI = oI;
		}

		public int compareTo(BoundaryDef other)
		{
			int c = getDirection().compareTo(other.getDirection());
			if ( c != 0) return c;
			ValueBoundaryDef vb = (ValueBoundaryDef) other;
			return getAmt() - vb.getAmt();
		}
	}

}
