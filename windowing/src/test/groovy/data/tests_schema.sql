CREATE TABLE part_tiny( 
    p_partkey INT,
    p_name STRING,
    p_mfgr STRING,
    p_brand STRING,
    p_type STRING,
    p_size INT,
    p_container STRING,
    p_retailprice DOUBLE,
    p_comment STRING
);

create table partrc_tiny (
    p_partkey INT,
    p_name STRING,
    p_mfgr STRING,
    p_brand STRING,
    p_type STRING,
    p_size INT,
    p_container STRING,
    p_retailprice DOUBLE,
    p_comment STRING
)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.columnar.ColumnarSerDe'
STORED AS RCFILE;

create table census_tiny (
COUNTY STRING,
tract string,
AREALAND DOUBLE,
pop100 int
);

create table flights_tiny (
ORIGIN_CITY_NAME string,
DEST_CITY_NAME string,
YEAR int,
MONTH int,
DAY_OF_MONTH int,
ARR_DELAY float,
FL_NUM string
);

create database test;
use test;
create table p (
    	  p_partkey INT,
    		p_name STRING,
    		p_mfgr STRING,
    		p_brand STRING,
    		p_type STRING,
    		p_size INT,
    		p_container STRING,
    		p_retailprice DOUBLE,
    		p_comment STRING
);

