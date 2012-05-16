------------------------------------------------------------------

-- CREATE region

create external table region (r_regionkey int,
                     r_name string,
                     r_comment string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
location  '/benchmarks/tpch/datascale5/region';

------------------------------------------------------------------

-- CREATE nation

create external table nation (n_nationkey int,
                     n_name string,
                     n_regionkey int,
                     n_comment string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
location  '/benchmarks/tpch/datascale5/nation';

------------------------------------------------------------------

-- CREATE customer

create external table customer (c_custkey int,
                       c_name string,
                       c_address string,
                       c_nationkey int,
                       c_phone string,
                       c_acctbal double,
                       c_mktsegment string,
                       c_comment string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
location  '/benchmarks/tpch/datascale5/customer';

------------------------------------------------------------------

-- CREATE orders

create external table orders (o_orderkey int,
                     o_custkey int,
                     o_orderstatus string,
                     o_totalprice double,
                     o_orderdate string,
                     o_orderpriority string,
                     o_clerk string,
                     o_shippriority int,
                     o_comment string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
location  '/benchmarks/tpch/datascale5/orders';

------------------------------------------------------------------

-- CREATE part

create external table part (p_partkey int,
                   p_name string,
                   p_mfgr string,
                   p_brand string,
                   p_type string,
                   p_size int,
                   p_container string,
                   p_retailprice double,
                   p_comment string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
location  '/benchmarks/tpch/datascale5/part';

------------------------------------------------------------------

-- CREATE supplier

create external table supplier (s_suppkey int,
                       s_name string,
                       s_address string,
                       s_nationkey int,
                       s_phone string,
                       s_acctbal double,
                       s_comment string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
location  '/benchmarks/tpch/datascale5/supplier';

------------------------------------------------------------------

-- CREATE partsupp

create external table partsupp (ps_partkey int,
                       ps_suppkey int,
                       ps_availqty int,
                       ps_supplycost double,
                       ps_comment string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
location  '/benchmarks/tpch/datascale5/partsupp';

------------------------------------------------------------------

-- CREATE lineitem

create external table lineitem (l_orderkey int,
                       l_partkey  int,
                       l_suppkey int,
                       l_linenumber int,
                       l_quantity double,
                       l_extendedprice double,
                       l_discount double,
                       l_tax double,
                       l_returnflag string,
                       l_linestatus string,
                       l_shipstring string,
                       l_commitstring string,
                       l_receiptstring string,
                       l_shipinstruct   string,
                       l_shipmode string,
                       l_comment string
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY '|'
location  '/benchmarks/tpch/datascale5/lineitem';

