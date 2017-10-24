val sqlContext = new org.apache.spark.sql.SQLContext(sc)
val df = sqlContext.read.format("com.databricks.spark.csv").option("header", "false").option("inferSchema", "true").load("hdfs:///tmp/testSpark/t1/test.txt")


spark.version
val df = spark.read.csv("hdfs:///tmp/testSpark/t1/")
df.registerTempTable("a1")
spark.sql("Select * from a1").show()
spark.sql("insert into a1 values (3,'ky')")
val df1=spark.sql("Select * from a1")
df1.show()
//save table to query via Hive
df1.write.mode("overwrite").saveAsTable("default.A1")

//continue using the old temp table a1
df1.registerTempTable("a2")

//No support for UPDATE
//scala> val df2=spark.sql("Update a2 set _c1='tx' where _c0=3")
//org.apache.spark.sql.catalyst.parser.ParseException: {'(', 'SELECT', 'FROM', 'ADD', 'DESC', 'WITH', 'VALUES', 'CREATE', 'TABLE', 'INSERT', 'DELETE', 'DESCRIBE', 'EXPLAIN', 'SHOW', 'USE', 'DROP', 'ALTER', 'MAP', 'SET', 'RESET', 'START', 'COMMIT', 'ROLLBACK', 'REDUCE', 'REFRESH', 'CLEAR', 'CACHE', 'UNCACHE', 'DFS', 'TRUNCATE', 'ANALYZE', 'LIST', 'REVOKE', 'GRANT', 'LOCK', 'UNLOCK', 'MSCK', 'EXPORT', 'IMPORT', 'LOAD'}(line 1, pos 0)



