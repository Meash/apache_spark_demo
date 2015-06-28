package se.studieren.vs

import org.apache.spark._
import se.studieren.vs.examples.PiExample

object RunOne extends AbstractRun {
  val example = new PiExample

  def main(args: Array[String]) {
    run(args)
  }

  override def execute(spark: SparkContext): Unit =
    example.run(spark)
}