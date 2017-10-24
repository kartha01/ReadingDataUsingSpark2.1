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

