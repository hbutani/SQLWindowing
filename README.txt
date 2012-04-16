SQL Windowing
=============

SQL Windowing provides a add-on component for Apache Hive for SQL Windowing clauses and table functions. 

Windowing Queries can be expressed on any hive Query or Table or on an HDFS file. 
The Engine generates a MR job to evaluate the windowing functions. Support for 16 functions divided into: Ranking, Aggregation 
and navigation. Support for both value and range boundaries for Windows. 

Table functions can be invoked as table expressions in Select statements; Table functions maybe chained together.

Read a detailed introduction at https://github.com/hbutani/SQLWindowing/wiki; a writeup on the 
internal details is at https://github.com/hbutani/SQLWindowing/blob/master/docs/Windowing.pdf

Getting Started
==============
- download com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar
- copy it to $HIVE_HOME/lib
- download groovy-all-1.8.0.jar and copy it to $HIVE_HOME/lib. If you want a more recent version of groovy, download from http://groovy.codehaus.org/Download
- cp $HIVE_HOME/bin/ext/cli.sh $HIVE_HOME/bin/ext/windowCli.sh
- edit windowCli.sh; change to
THISSERVICE=windowingCli
export SERVICE_LIST="${SERVICE_LIST}${THISSERVICE} "

windowingCli () {
  CLASS=com.sap.hadoop.windowing.WindowingHiveCliDriver
  if $cygwin; then
    HIVE_LIB=`cygpath -w "$HIVE_LIB"`
  fi
  JAR=${HIVE_LIB}/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar
  exec $HADOOP jar $JAR $CLASS "$@"
}

windowingCli_help () {
  windowingCli "--help"
} 

- to run invoke:
hive --service windowingCli

- in a session use wmode to switch between hive & windowing mode. For e.g.:
wmode windowing;
from census_q1 partition by county order by county, arealand desc with rank() as r select county, tract, arealand, r into path='/tmp/wout';
wmode hive;
exit;


Requirements
============

- Java 1.6
- Hadoop 0.20.x (x >= 1)
- Hive > 0.7.1
