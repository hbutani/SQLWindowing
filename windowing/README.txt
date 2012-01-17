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

Requirements
============

- Java 1.6
- Hadoop 0.20.x (x >= 1)
- Hive 0.7.1
