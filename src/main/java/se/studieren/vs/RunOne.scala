package se.studieren.vs

import org.apache.spark._
import se.studieren.vs.examples.ApproximatePi

object RunOne extends AbstractRun {
  val example = ApproximatePi

  def main(args: Array[String]) {
    run(args)
  }

  override def execute(spark: SparkContext): Unit =
    example.run(spark)
}