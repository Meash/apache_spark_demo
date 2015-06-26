package se.studieren.vs

import org.apache.spark._

object RunServer {
  var spark = None: Option[SparkContext]

  def main(args: Array[String]) {
    val slaves = if (args.length > 0) args(0).toInt else 10

    start(slaves)

    readLine()

    stop()
  }

  def stop(): Unit = {
    spark match {
      case None => throw new IllegalStateException("Spark has not been started")
      case Some(value) => value.stop()
    }
  }

  def start(slaves: Int): SparkContext = {
    spark match {
      case None =>
        val conf = new SparkConf()
          .setAppName("SparkTest Server")
          .setMaster("local[" + slaves + "]")
        val sparkContext = new SparkContext(conf)
        spark = Some(sparkContext)
        sparkContext
      case Some(_) =>
        throw new IllegalStateException("Spark has been started already")
    }
  }
}