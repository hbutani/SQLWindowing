create table uuid_testtable(
  uuid string,
  c_51 string
); 

LOAD DATA LOCAL INPATH '/tmp/1.txt'
OVERWRITE INTO TABLE uuid_testtable;