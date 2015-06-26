package se.studieren.vs

import org.apache.spark.{SparkConf, SparkContext}
import se.studieren.vs.examples.{Example, PiExample}

object RunAll {
  val examples: Array[Example] =
    Array(
      new PiExample
    )

  def main(args: Array[String]) {
    val spark =
      if (args.length > 0) {
        val masterUrl = args(0)
        val conf = new SparkConf()
          .setAppName("SparkDemo RunAll")
          .setMaster(masterUrl)
        new SparkContext(conf)
      } else {
        RunServer.start(slaves = 10)
      }

    for (example <- examples) {
      example.run(spark)
    }

    spark.stop()
  }
}