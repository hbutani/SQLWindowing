package com.sap.hadoop.windowing.functions2.table.npath;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.runtime2.Partition;

/**
 * return rows that meet a specified pattern. Use symbols to specify a list of expressions to match. 
 * Pattern is used to specify a Path. The results list can contain expressions based on the input columns 
 * and also the matched Path.
 * <ol>
 * <li><b>pattern:</b> pattern for the Path. Path is 'dot' separated list of symbols. 
 * Each element is treated as a symbol. Elements that end in '*' or '+' are interpreted with the 
 * usual meaning of zero or more, one or more respectively. For e.g. "LATE.EARLY*.ONTIMEOREARLY" implies a sequence of flights 
 * where the first occurrence was LATE, followed by zero or more EARLY flights, followed by a ONTIME or EARLY flight.
 * <li><b>symbols</b> specify a list of name, expression pairs. For e.g.
 * 'LATE', arrival_delay > 0, 'EARLY', arrival_delay < 0 , 'ONTIME', arrival_delay == 0.
 * These symbols can be used in the Pattern defined above.
 * <li><b>resultSelectList</b> specified as a select list. 
 * The expressions in the selectList are evaluated in the context where all the input columns are available, plus the attribute 
 * "tpath" is available. Path is a collection of rows that represents the matching Path. 
 * </ol>
 */
public class NPath extends TableFunctionEvaluator
{
	/**
	 * <ul>
	 * <li> check structure of Arguments:
	 * <ol>
	 * <li> First arg should be a String
	 * <li> then there should be an even number of Arguments: String, expression; expression should be Convertible to Boolean.
	 * <li> finally there should be a String.
	 * </ol>
	 * <li> convert pattern into a NNode chain.
	 * <li> convert symbol args into a Symbol Map.
	 * <li> parse selectList into SelectList struct. The inputOI used to translate these expressions should be based on the 
	 * columns in the Input, the 'path.attr'
	 * </ul>
	 */
	@Override
	public void setupOI() throws WindowingException
	{
		
	}
	
	@Override
	public void execute(Partition iPart, Partition outP) throws WindowingException
	{
		
	}
}
