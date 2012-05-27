create table basketdata (
  basketName string,
  itemName string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

load data local inpath '/media/MyPassport/windowing/windowing/src/test/groovy/data/marketbasket/sample/000000_0' overwrite into table basketdata;



create table basketdata_db10000 (
  basketName string,
  itemName string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

load data local inpath '/media/MyPassport/windowing/windowing/src/test/groovy/data/marketbasket/db10000/000000_0' overwrite into table basketdata_db10000;