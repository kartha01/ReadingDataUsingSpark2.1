import org.apache.spark.sql.SparkSession

object ReadDataFromCsv extends App {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("ReadDataFromCsv")
    .getOrCreate()

  val df = spark.read.csv("./src/main/resources/testData.csv")

 // To display dataframe data
 df.show()
}
