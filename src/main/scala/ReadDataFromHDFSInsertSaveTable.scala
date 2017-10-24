val sqlContext = new org.apache.spark.sql.SQLContext(sc)
val df = sqlContext.read.format("com.databricks.spark.csv").option("header", "false").option("inferSchema", "true").load("hdfs:///tmp/testSpark/t1/test.txt")


spark.version
val df = spark.read.csv("hdfs:///tmp/testSpark/t1/")
df.registerTempTable("a1")
spark.sql("Select * from a1").show()

//Make sure hdfs directory has RWX permission to the user
spark.sql("insert into a1 values (3,'ky')")
val df1=spark.sql("Select * from a1")
df1.show()
//save table to query via Hive
df1.write.mode("overwrite").saveAsTable("default.A1")

//continue using the old temp table a1
spark.sql("select * from a1").show()

//No support for UPDATE
//scala> val df2=spark.sql("Update a2 set _c1='tx' where _c0=3")
//org.apache.spark.sql.catalyst.parser.ParseException: {'(', 'SELECT', 'FROM', 'ADD', 'DESC', 'WITH', 'VALUES', 'CREATE', 'TABLE', 'INSERT', 'DELETE', 'DESCRIBE', 'EXPLAIN', 'SHOW', 'USE', 'DROP', 'ALTER', 'MAP', 'SET', 'RESET', 'START', 'COMMIT', 'ROLLBACK', 'REDUCE', 'REFRESH', 'CLEAR', 'CACHE', 'UNCACHE', 'DFS', 'TRUNCATE', 'ANALYZE', 'LIST', 'REVOKE', 'GRANT', 'LOCK', 'UNLOCK', 'MSCK', 'EXPORT', 'IMPORT', 'LOAD'}(line 1, pos 0)

//
// Method 2 with renamed columms
//

spark.version
val df = spark.read.csv("hdfs:///tmp/testSpark/t1/")
df.registerTempTable("a1")
val df1=spark.sql("Select _c0 as c0, _c1 as c1 from a1")
df1.write.mode("overwrite").saveAsTable("default.A1")

//Update via Hive
//hive> describe a1;
//OK
//c0                      string
//c1                      string
//Time taken: 0.105 seconds, Fetched: 2 row(s)
//hive> update a1 set c1='tx' where c0='3';
//FAILED: SemanticException [Error 10294]: Attempt to do update or delete using transaction manager that does not support these operations.

//
//Method 3 to rename columns
//https://community.hortonworks.com/articles/114045/specify-schema-for-csv-files-with-no-header-and-pe.html

