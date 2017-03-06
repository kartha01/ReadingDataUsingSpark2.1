import org.apache.spark.sql.SparkSession

object ReadDataFromParquet extends App {
  val spark = SparkSession
    .builder()
    .master("local")
    .appName("ReadDataFromParquet")
    .getOrCreate()


  val df = spark.read.parquet("hdfs://localhost:54311/user/hduser/testJson.parquet")
  //To display dataframe data
  df.show()
}
