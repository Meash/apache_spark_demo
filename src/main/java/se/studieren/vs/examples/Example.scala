package se.studieren.vs.examples

import org.apache.spark.SparkContext

trait Example {
  def run(spark: SparkContext)
}