import org.apache.spark.sql.SparkSession


object ReadDataFromJson extends App {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("ReadDataFromJson")
    .getOrCreate()


  val df = spark.read.json("hdfs://localhost:54311/BabuStore/testJson.json")
  //To display dataframe data
  df.show()

  //To create a table from a dataframe
  df.registerTempTable("tempTable")
  spark.sqlContext.sql("select * from tempTable").show

}
