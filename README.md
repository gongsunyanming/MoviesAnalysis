# 基于 MySQL + Spark + Echarts + Spring Boot 的豆瓣电影数据可视化项目

## 一、项目概述
本项目旨在通过爬取豆瓣电影数据，利用 MySQL 进行数据存储，借助 Spark 进行高效数据分析，并结合 Echarts 和 Spring Boot 搭建一个数据可视化平台，以直观地展示豆瓣电影的各种特征和趋势。

## 二、项目流程

### （一）爬虫部分
1. 运行`getip.py`文件获取代理 IP 池。在使用前需删除`proxy.txt`（存储爬取到的所有代理 IP）和`valid.txt`（存储可用代理 IP）。
2. 运行`GetData.py`，从网页爬取所需内容，并初步保存到`ur.txt`。其中，爬取的 URL 可根据需求进行调整，如`https://movie.douban.com/j/chart/top_list?type=11&interval_id=85%3A75&action=&start=`，这里的`85%3A75`表示爬取评分在前 75%到 85%区间的内容，可根据实际需求自行修改。
3. 运行`clear.py`进行数据处理，并将结果保存到`data.csv`。
4. 修改`upload.py`中的 Hadoop 集群配置信息，运行该文件将`data.csv`上传到 Hadoop 集群。

### （二）数据分析部分
1. 七个数据分析文件都需要运行，注意以下操作：
   - 在每个文件的开头几行，有以下代码需要根据实际路径进行修改：
   ```java
   System.setProperty("HADOOP_HOME", "C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master");
   System.setProperty("hadoop.home.dir", "C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master");
   System.load("C:\\Users\\Administrator\\Desktop\\大数据豆瓣电影数据分析与可视化\\数据分析\\SparkMovies\\apache-hadoop-3.1.3-winutils-master\\bin\\hadoop.dll");
   ```
   - 文件中还涉及 Hadoop 集群配置和 MySQL 配置，需根据实际情况进行修改。MySQL 的数据库需手动创建，数据表的 SQL 文件为`part1~7.sql`。

### （三）数据可视化部分（结合 Spring Boot 和 Echarts）
1. 修改`src/main/resources/application.yml`文件中的 MySQL 配置。完整的表生成语句以及数据文件为`part1~7 完整.sql`。
2. 在 Spring Boot 项目中进行配置和开发，将数据从 MySQL 数据库中读取出来，并通过后端接口提供给前端。
3. 在前端页面中使用 Echarts 库，根据后端提供的数据绘制各种可视化图表，如不同年份上映电影数、电影类型分析、电影类型平均评分、演员平均评分、不同年份电影平均评分、不同评分出现次数等。

## 三、技术栈
1. **MySQL**：用于数据存储，方便后续的数据分析和查询。
2. **Spark**：进行高效的大规模数据分析处理，能够快速处理爬取到的豆瓣电影数据。
3. **Echarts**：实现数据的可视化展示，通过直观的图表呈现豆瓣电影数据的特征和趋势。
4. **Spring Boot**：构建后端服务，提供数据接口，实现前后端分离的开发模式。

## 四、项目成果
1. 通过爬虫获取了豆瓣电影的相关数据，并进行了有效的数据处理和存储。
2. 利用 Spark 对数据进行分析，挖掘出有价值的信息和趋势。
3. 使用 Spring Boot 和 Echarts 搭建了一个数据可视化平台，用户可以通过浏览器直观地查看豆瓣电影数据的各种可视化图表，深入了解豆瓣电影的特点和发展趋势。

## 五、总结与展望
本项目成功实现了基于 MySQL + Spark + Echarts + Spring Boot 的豆瓣电影数据可视化，为电影爱好者、研究者和从业者提供了有价值的数据分析和可视化工具。未来，可以进一步扩展数据来源和分析维度，提高数据的准确性和完整性，同时优化可视化效果，提供更加丰富和交互性强的用户体验。还可以考虑添加更多的功能模块，如用户登录、数据分享等，使项目更加完善和实用。

![image]([https://github.com/MaiEmily/map/blob/master/public/image/20190528145810708.png](https://github.com/gongsunyanming/-/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/index.png
))
![image]([https://github.com/MaiEmily/map/blob/master/public/image/20190528145810708.png](https://github.com/gongsunyanming/-/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/1.png
))![image]([https://github.com/MaiEmily/map/blob/master/public/image/20190528145810708.png](https://github.com/gongsunyanming/-/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/2.png
))![image]([https://github.com/MaiEmily/map/blob/master/public/image/20190528145810708.png](https://github.com/gongsunyanming/-/blob/main/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE/3.png
))
