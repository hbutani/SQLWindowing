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
=======
- download com.sap.hadoop.windowing-0.0.1-SNAPSHOT.jar & com.sap.hadoop.windowing-0.0.1-SNAPSHOT-jar-with-dependencies.jar
- copy com.sap.hadoop.windowing-0.0.1-SNAPSHOT.jar to $HIVE_HOME/lib
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
  JAR=${HIVE_LIB}/com.sap.hadoop.windowing-0.0.1-SNAPSHOT.jar
  exec $HADOOP jar $JAR $CLASS "$@"
}

windowingCli_help () {
  windowingCli "--help"
} 

- to run pass -w <jar-with-dependencies> option. for e.g.
hive --service windowingCli -w /tmp/com.sap.hadoop.windowing-0.0.1-SNAPSHOT-jar-with-dependencies.jar

- in session use wmode to switch between hive & windowing mode. For e.g.:
wmode windowing;
from census_q1 partition by county order by county, arealand desc with rank() as r select county, tract, arealand, r into path='/tmp/wout';
wmode hive;
exit;

Hive Mode:
=========
- download jar-with-dependencies
- Copy jar-with-dependencies to all machines. Say in WINDOWING_LIB_DIR
for rest of doc assume WINDOWING_LIB_DIR=/tmp
- In hive session invoke add jar on hive-contrib-0.9.0-SNAPSHOT.jar
for e.g.:
add jar /media/MyPassport/hadoop/hive2/hive/build/dist/lib/hive-contrib-0.9.0-SNAPSHOT.jar;
- Test an Example
CREATE TABLE windowing_test as
select p_mfgr,p_name, p_size, r
from
(
from (
  from part
  select transform(p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment)
    ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe'
    RECORDWRITER 'org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter'
    USING '/bin/cat'
    as (p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment)
    ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe'
    RECORDREADER 'org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordReader'
    DISTRIBUTE BY p_mfgr
    SORT BY p_mfgr, p_name
) map_output
  select transform(p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment)
    ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe'
    RECORDWRITER 'org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter'
    USING 'java -Xms512m -Xmx2048m -cp "/tmp/com.sap.hadoop.windowing-0.0.1-SNAPSHOT-jar-with-dependencies.jar" com.sap.hadoop.windowing.WindowingDriver -m hive -q "from tableinput(columns = \'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment\', \'columns.types\' = \'int,string,string,string,string,int,string,double,string\' ) partition by p_mfgr order by p_mfgr, p_name with rank() as r select p_mfgr,p_name, p_size, r"'
as (p_mfgr,p_name, p_size, r)
ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe'
RECORDREADER 'org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordReader'
) reduce_output;


Requirements
============

- Java 1.6
- Hadoop 0.20.x (x >= 1)
- Hive 0.7.1
