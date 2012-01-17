SQL Windowing
=============

SQL Windowing provides a add-on component for Apache Hive for SQL Analytical functions. 
Windowing Queries can be expressed on any hive Query or Table or on an HDFS file. 
Windowing processing works in MR mode or in Hive mode. MR mode generates a MR job 
to evaluate the windowing functions. In Hive Mode, the Windowing process is invoked 
from the Hive Script Operator. Support for 16 functions divided into: Ranking, Aggregation 
and navigation. Support for both value and range boundaries for Windows. Easy to extend 
through groovy integration.

Details at https://github.com/hbutani/SQLWindowing/blob/master/docs/Windowing.pdf

Getting Started
==============

MR Mode:

- download SQLWindowing jar & the jar-with-dependencies
- copy jar to $HIVE_HOME/lib
- cp $HIVE_HOME/bin/ext/cli.sh $HIVE_HOME/bin/ext/windowCli.sh
- edit windowCli.sh; change to
THISSERVICE=windowingCli
export SERVICE_LIST="${SERVICE_LIST}${THISSERVICE} "

windowingCli () {
  CLASS=com.sap.hadoop.windowing.WindowingHiveCliDriver
  if $cygwin; then
    HIVE_LIB=`cygpath -w "$HIVE_LIB"`
  fi
  JAR=${HIVE_LIB}/com.sap.hadoop.windowing-*.jar
  exec $HADOOP jar $JAR $CLASS "$@"
}

windowingCli_help () {
  windowingCli "--help"
} 

- to run pass -w <jar-with-dependencies> option.

Hive Mode:
- download jar-with-dependencies
- invoke java from Hive Script Transform clause passing the jar in classpath. Use -q option to pass WindowingQuery.


Requirements
============

- Java 1.6
- Hadoop 0.20.x (x >= 1)
- Hive 0.7.1
