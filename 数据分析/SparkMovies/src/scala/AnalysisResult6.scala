/**
 * 不同年份上映电影数
 */

import org.apache.spark.sql.{SaveMode, SparkSession}

import java.util.Properties

object AnalysisResult6 {
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
      .option("header", "true")
      .load("hdfs://192.168.79.131:9000/user/moqiling/data.csv")

    // 创建临时表
    data.createTempView("movies")

    // SparkSql数据分析
    val yearAverageScoreData = spark.sql(
      """
        |select year as name, round(avg(cast(`评分` as double)), 1) as value
        |from(
        |     select substr(`上映日期`, 0, 4) as year, `评分`
        |     from movies
        |)subquery
        |group by year order by value desc
        |""".stripMargin)

    yearAverageScoreData.show()

    val url = "jdbc:mysql://192.168.79.131:3306"
    val database = "db_spark_movie"
    val user = "root"
    val password = "123"

    yearAverageScoreData.write.mode(SaveMode.Append)
      .jdbc(s"$url/$database", "part6", connectionProperties(user, password))
  }
  // 创建链接属性对象
  def connectionProperties(user:String, password:String):java.util.Properties={
    val properties = new Properties()
    properties.setProperty("user",user)
    properties.setProperty("password",password)
    properties
  }
}
