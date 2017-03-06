import org.apache.spark.sql.SparkSession

object ReadDataFromParquet extends App {
  val spark = SparkSession
    .builder()
    .master("local")
    .appName("ReadDataFromParquet")
    .getOrCreate()


  val df = spark.read.parquet("./src/main/resources/testJson.parquet")
  //To display dataframe data
  df.show()
}
