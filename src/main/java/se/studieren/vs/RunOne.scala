package se.studieren.vs

import org.apache.spark._
import se.studieren.vs.examples.PiExample

object RunOne {
  val example = new PiExample

  def main(args: Array[String]) {
    val spark =
      if (args.length > 0) {
        val masterUrl = args(0)
        val conf = new SparkConf()
          .setAppName("SparkDemo RunOne")
          .setMaster(masterUrl)
        new SparkContext(conf)
      } else {
        RunServer.start(slaves = 10)
      }

    example.run(spark)

    spark.stop()

  }
}