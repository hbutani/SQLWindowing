package com.sap.hadoop.windowing.runtime2.mr;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.plan.OperatorDesc;

/*Copied as is from org.apache.hadoop.hive.ql.exec.OperatorFactory*/
public class WindowingOpFactory {
	static OpTuple<? extends OperatorDesc> o;
	
	static{
		o = new OpTuple<PTFDesc>(PTFDesc.class, PTFOperator.class);
	}
	  
	  
	  public static final class OpTuple<T extends OperatorDesc> {
		    public Class<T> descClass;
		    public Class<? extends Operator<T>> opClass;

		    public OpTuple(Class<T> descClass, Class<? extends Operator<T>> opClass) {
		      this.descClass = descClass;
		      this.opClass = opClass;
		    }
		  }

	  /**
	   * Returns an operator given the conf and a list of children operators.
	   */
	  public static <T extends OperatorDesc> Operator<T> getOperator(T conf,
	    Operator<? extends OperatorDesc>... oplist) {
	    Operator<T> ret = get((Class<T>) conf.getClass());
	    ret.setConf(conf);
	    makeChild(ret, oplist);
	    return (ret);
	  }

	  public static <T extends OperatorDesc> Operator<T> get(Class<T> opClass) {
		  	if (o.descClass == opClass) {
		  		try {
		          Operator<T> op = (Operator<T>) o.opClass.newInstance();
		          op.initializeCounters();
		          return op;
		        } catch (Exception e) {
		          e.printStackTrace();
		          throw new RuntimeException(e);
		        }
			  
		  	}
			return null;
		  }

	  /**
	   * Returns an operator given the conf and a list of children operators.
	   */
	  public static void makeChild(
	    Operator<? extends OperatorDesc> ret,
	    Operator<? extends OperatorDesc>... oplist) {
	    if (oplist.length == 0) {
	      return;
	    }

	    ArrayList<Operator<? extends OperatorDesc>> clist =
	      new ArrayList<Operator<? extends OperatorDesc>>();
	    for (Operator<? extends OperatorDesc> op : oplist) {
	      clist.add(op);
	    }
	    ret.setChildOperators(clist);

	    // Add this parent to the children
	    for (Operator<? extends OperatorDesc> op : oplist) {
	      List<Operator<? extends OperatorDesc>> parents = op.getParentOperators();
	      if (parents == null) {
	        parents = new ArrayList<Operator<? extends OperatorDesc>>();
	      }
	      parents.add(ret);
	      op.setParentOperators(parents);
	    }
	  }

}
