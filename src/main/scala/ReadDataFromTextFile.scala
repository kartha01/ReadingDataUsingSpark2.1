import org.apache.spark.sql.SparkSession

object ReadDataFromTextFile extends App {
  val spark = SparkSession
    .builder()
    .master("local")
    .appName("ReadDataFromTextFile")
    .getOrCreate()


  val df = spark.read.text("./src/main/resources/textFile.txt")
  //To display dataframe data
  df.show()
}
