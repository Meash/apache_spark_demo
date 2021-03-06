package se.studieren.vs

import org.apache.spark.{SparkConf, SparkContext}

trait AbstractRun {
  var spark: SparkContext = _

  def run(args: Array[String]): Unit = {
    setUp(if (args.length > 0) Some(args(0)) else None)
    execute(spark)
    tearDown()
  }

  def setUp(masterUrl: Option[String]): Unit = {
    val url = masterUrl match {
      case Some(_url) =>
        _url
      case None =>
        val slaves = 2
        "local[" + slaves + "]"
    }
    val dir = getClass.getResource("").getPath
    val classPath = dir + "../../../../../libs/apache_spark_demo-1.0.jar"
    val conf = new SparkConf()
      .setAppName(getName())
      .setMaster(url)
      .set("spark.executor.extraClassPath", classPath)
    spark = new SparkContext(conf)
  }

  def execute(spark: SparkContext): Unit

  def getName(): String

  def tearDown(): Unit = {
    spark.stop()
  }
}