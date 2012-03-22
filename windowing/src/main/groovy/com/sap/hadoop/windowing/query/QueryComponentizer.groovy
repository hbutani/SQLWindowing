package com.sap.hadoop.windowing.query

/**
 * Responsible for converting the input {@link Query} into a list of component {@link QuerySpec}.
 * The Function Chain is split at the following positions:
 * <ul>
 * <li> If the {@link TableFuncSpec} has a partition specification.
 * <li> If the {@link TableFuncSpec} has a Map Phase.
 * </ul>
 * 
 * The splitting is done in the following way:
 * <ul>
 * <li> The current QuerySpec is cloned into 2 QSpecs: current, rest.
 * <li> For the 'current' QSpec:
 * <ul>
 * <li> The function chain is set from the input function up to the function previous to the split position.
 * <li> The whereExpr is cleared.
 * <li> The selectList is set to Columns based on the previous function's OutputShape.
 * <li> The QuerySpec's tableOutput is changed so that the outputPath is a jobWorking directory; the output
 * SerDe and properties are LazyBinarySerDe. A Temporary table is created based on the OutputShape of the previous
 * function. The QuerySpec's output tableName is set to this Table.
 * </ul>
 * <li> For the 'rest' QSpec:
 * <ul>
 * <li> The function chain is set from the split position upto to the end.
 * <li> The QuerySpec's tableInput is changed to point the table created above. Hive Query is set to a non null String to trigger 
 * deletion of the table at the end of this job. QuerySpec's inputSerDe, format is set based on LazyBinarySerDe.
 * <li>  The split algorithm is recursively applied on the 'rest' QuerySpec.
 * </ul>
 * </ul>
 * @author harish.butani
 *
 */
class QueryComponentizer
{

}
