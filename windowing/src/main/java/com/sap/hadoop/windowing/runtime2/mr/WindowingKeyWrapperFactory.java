package com.sap.hadoop.windowing.runtime2.mr;

import java.util.Arrays;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.ListObjectsEqualComparer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.StringObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;
import org.apache.hadoop.io.Text;

/*
 * Argh, Copied from org.apache.hadoop.hive.ql.exec.KeyWrapper because interface is not public.
 * Get rid of once we fold into Hive.
 */
public class WindowingKeyWrapperFactory
{
	public WindowingKeyWrapperFactory(ExprNodeEvaluator[] keyFields,
			ObjectInspector[] keyObjectInspectors,
			ObjectInspector[] currentKeyObjectInspectors)
	{
		this.keyFields = keyFields;
		this.keyObjectInspectors = keyObjectInspectors;
		this.currentKeyObjectInspectors = currentKeyObjectInspectors;

	}

	public WindowingKeyWrapper getWindowingKeyWrapper()
	{
		if (keyFields.length == 1
				&& TypeInfoUtils.getTypeInfoFromObjectInspector(
						keyObjectInspectors[0]).equals(
						TypeInfoFactory.stringTypeInfo))
		{
			assert (TypeInfoUtils
					.getTypeInfoFromObjectInspector(currentKeyObjectInspectors[0])
					.equals(TypeInfoFactory.stringTypeInfo));
			soi_new = (StringObjectInspector) keyObjectInspectors[0];
			soi_copy = (StringObjectInspector) currentKeyObjectInspectors[0];
			return new TextWindowingKeyWrapper(false);
		}
		else
		{
			currentStructEqualComparer = new ListObjectsEqualComparer(
					currentKeyObjectInspectors, currentKeyObjectInspectors);
			newKeyStructEqualComparer = new ListObjectsEqualComparer(
					currentKeyObjectInspectors, keyObjectInspectors);
			return new ListWindowingKeyWrapper(false);
		}
	}

	transient ExprNodeEvaluator[] keyFields;
	transient ObjectInspector[] keyObjectInspectors;
	transient ObjectInspector[] currentKeyObjectInspectors;

	transient ListObjectsEqualComparer currentStructEqualComparer;
	transient ListObjectsEqualComparer newKeyStructEqualComparer;

	class ListWindowingKeyWrapper extends WindowingKeyWrapper
	{
		int hashcode;
		Object[] keys;
		// decide whether this is already in hashmap (keys in hashmap are
		// deepcopied
		// version, and we need to use 'currentKeyObjectInspector').
		ListObjectsEqualComparer equalComparer;

		public ListWindowingKeyWrapper(boolean isCopy)
		{
			this(-1, new Object[keyFields.length], isCopy);
		}

		private ListWindowingKeyWrapper(int hashcode, Object[] copiedKeys,
				boolean isCopy)
		{
			super();
			this.hashcode = hashcode;
			keys = copiedKeys;
			setEqualComparer(isCopy);
		}

		private void setEqualComparer(boolean copy)
		{
			if (!copy)
			{
				equalComparer = newKeyStructEqualComparer;
			}
			else
			{
				equalComparer = currentStructEqualComparer;
			}
		}

		@Override
		public int hashCode()
		{
			return hashcode;
		}

		@Override
		public boolean equals(Object obj)
		{
			Object[] copied_in_hashmap = ((ListWindowingKeyWrapper) obj).keys;
			return equalComparer.areEqual(copied_in_hashmap, keys);
		}

		@Override
		public void setHashKey()
		{
			hashcode = Arrays.hashCode(keys);
		}

		@Override
		public void getNewKey(Object row, ObjectInspector rowInspector)
				throws HiveException
		{
			// Compute the keys
			for (int i = 0; i < keyFields.length; i++)
			{
				keys[i] = keyFields[i].evaluate(row);
			}
		}

		@Override
		public WindowingKeyWrapper copyKey()
		{
			Object[] newDefaultKeys = deepCopyElements(keys,
					keyObjectInspectors, ObjectInspectorCopyOption.WRITABLE);
			return new ListWindowingKeyWrapper(hashcode, newDefaultKeys, true);
		}

		@Override
		public void copyKey(WindowingKeyWrapper oldWrapper)
		{
			ListWindowingKeyWrapper listWrapper = (ListWindowingKeyWrapper) oldWrapper;
			hashcode = listWrapper.hashcode;
			equalComparer = currentStructEqualComparer;
			deepCopyElements(listWrapper.keys, keyObjectInspectors, keys,
					ObjectInspectorCopyOption.WRITABLE);
		}

		@Override
		public Object[] getKeyArray()
		{
			return keys;
		}

		private Object[] deepCopyElements(Object[] keys,
				ObjectInspector[] keyObjectInspectors,
				ObjectInspectorCopyOption copyOption)
		{
			Object[] result = new Object[keys.length];
			deepCopyElements(keys, keyObjectInspectors, result, copyOption);
			return result;
		}

		private void deepCopyElements(Object[] keys,
				ObjectInspector[] keyObjectInspectors, Object[] result,
				ObjectInspectorCopyOption copyOption)
		{
			for (int i = 0; i < keys.length; i++)
			{
				result[i] = ObjectInspectorUtils.copyToStandardObject(keys[i],
						keyObjectInspectors[i], copyOption);
			}
		}
	}

	transient Object[] singleEleArray = new Object[1];
	transient StringObjectInspector soi_new, soi_copy;

	class TextWindowingKeyWrapper extends WindowingKeyWrapper
	{
		int hashcode;
		Object key;
		boolean isCopy;

		public TextWindowingKeyWrapper(boolean isCopy)
		{
			this(-1, null, isCopy);
		}

		private TextWindowingKeyWrapper(int hashcode, Object key, boolean isCopy)
		{
			super();
			this.hashcode = hashcode;
			this.key = key;
			this.isCopy = isCopy;
		}

		@Override
		public int hashCode()
		{
			return hashcode;
		}

		@Override
		public boolean equals(Object other)
		{
			Object obj = ((TextWindowingKeyWrapper) other).key;
			Text t1;
			Text t2;
			if (isCopy)
			{
				t1 = soi_copy.getPrimitiveWritableObject(key);
				t2 = soi_copy.getPrimitiveWritableObject(obj);
			}
			else
			{
				t1 = soi_new.getPrimitiveWritableObject(key);
				t2 = soi_copy.getPrimitiveWritableObject(obj);
			}
			if (t1 == null && t2 == null)
			{
				return true;
			}
			else if (t1 == null || t2 == null)
			{
				return false;
			}
			else
			{
				return t1.equals(t2);
			}
		}

		@Override
		public void setHashKey()
		{
			if (key == null)
			{
				hashcode = 0;
			}
			else
			{
				hashcode = key.hashCode();
			}
		}

		@Override
		public void getNewKey(Object row, ObjectInspector rowInspector)
				throws HiveException
		{
			// Compute the keys
			key = keyFields[0].evaluate(row);
		}

		@Override
		public WindowingKeyWrapper copyKey()
		{
			return new TextWindowingKeyWrapper(hashcode,
					ObjectInspectorUtils.copyToStandardObject(key, soi_new,
							ObjectInspectorCopyOption.WRITABLE), true);
		}

		@Override
		public void copyKey(WindowingKeyWrapper oldWrapper)
		{
			TextWindowingKeyWrapper textWrapper = (TextWindowingKeyWrapper) oldWrapper;
			hashcode = textWrapper.hashcode;
			isCopy = true;
			key = ObjectInspectorUtils.copyToStandardObject(textWrapper.key,
					soi_new, ObjectInspectorCopyOption.WRITABLE);
		}

		@Override
		public Object[] getKeyArray()
		{
			singleEleArray[0] = key;
			return singleEleArray;
		}
	}
}