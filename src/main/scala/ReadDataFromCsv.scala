import org.apache.spark.sql.SparkSession

object ReadDataFromCsv extends App {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("ReadDataFromCsv")
    .getOrCreate()

  val df = spark.read.csv("hdfs://localhost:54311/BabuStore/testData.csv")

 // To display dataframe data
 df.show()
}
