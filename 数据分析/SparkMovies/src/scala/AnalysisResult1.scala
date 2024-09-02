/**
 * 不同年份上映电影数
 */

import org.apache.spark.sql.{SaveMode, SparkSession}

import java.util.Properties

object AnalysisResult1 {
  def main(args: Array[String]): Unit = {
//    static {
//    System.setProperty("HADOOP_HOME", "C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master")
//    System.setProperty("hadoop.home.dir", "C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master")
//    System.load("C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master\\bin\\hadoop.dll")
//    }
      System.setProperty("HADOOP_HOME", "C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master")
      System.setProperty("hadoop.home.dir", "C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master")
      System.load("C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master\\bin\\hadoop.dll")
    // 创建spark对象
    val spark = SparkSession.builder()
      .appName("movies")
      .master("local[*]")
      .getOrCreate()

    // 读取数据进行数据分析
    val data = spark.read.format("csv")
      .option("header","true")
      .load("hdfs://192.168.79.131:9000/user/moqiling/data.csv")

    // 创建临时表
    data.createTempView("movies")

    // SparkSql数据分析
//    val analysisData = spark.sql("select substr('上映日期',0,4) from movies".stripMargin)
    val analysisData = spark.sql(
      """
        |select substr(`上映日期`,0,4) name, count(1) value from movies where `上映日期` is not null group by name order by value
        |""".stripMargin)
    analysisData.show()

//    analysisData.write.mode(SaveMode.Append).jdbc("jdbc:mysql://192.168.79.131:3306/db_spark_movie", "part1",connectionProperties("root","123"))
  }
  // 创建链接属性对象
  def connectionProperties(user:String, password:String):java.util.Properties={
    val properties = new Properties()
    properties.setProperty("user",user)
    properties.setProperty("password",password)
    properties
  }
}
