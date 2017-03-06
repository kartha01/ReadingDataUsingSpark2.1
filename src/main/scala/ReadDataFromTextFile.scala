import org.apache.spark.sql.SparkSession

object ReadDataFromTextFile extends App {
  val spark = SparkSession
    .builder()
    .master("local")
    .appName("ReadDataFromTextFile")
    .getOrCreate()


  val df = spark.read.text("hdfs://localhost:54311/BabuStore/textFile.txt")
  //To display dataframe data
  df.show()
}
