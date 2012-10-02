import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.apache.hadoop.hive.ql.plan.JoinDesc;

import com.sap.hadoop.windowing.query2.definition.TableFuncDef;

public class EncoderTest {

	
	public static void main(String[] args) throws Exception
	{
		isTransient(TableFuncDef.class, "OI");
		//isTransient(JoinDesc.class, "reversedExprs");
	}
	
	static boolean isTransient(Class type, String pName) {
        if (type == null) {
            return false;
        }
        // This code was mistakenly deleted - it may be fine and
        // is more efficient than the code below. This should
        // all disappear anyway when property descriptors are shared
        // by the introspector.
        /*
        Method getter = pd.getReadMethod();
        Class declaringClass = getter.getDeclaringClass();
        if (declaringClass == type) {
            return Boolean.TRUE.equals(pd.getValue("transient"));
        }
        */
        BeanInfo info = getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; ++i ) {
            PropertyDescriptor pd2 = propertyDescriptors[i];
            if (pName.equals(pd2.getName())) {
                Object value = pd2.getValue("transient");
                if (value != null) {
                    return Boolean.TRUE.equals(value);
                }
            }
        }
        return isTransient(type.getSuperclass(), pName);
    }
	
	public static BeanInfo getBeanInfo(Class type) {
		BeanInfo info = null;
		try {
		    info = Introspector.getBeanInfo(type);
		} catch (Throwable e) {
		    e.printStackTrace();
		} 
		return info;
    }
}
