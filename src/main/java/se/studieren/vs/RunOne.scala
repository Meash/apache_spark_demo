package se.studieren.vs

import org.apache.spark._
import se.studieren.vs.examples.TextSearch

object RunOne extends AbstractRun {
  val example = TextSearch

  def main(args: Array[String]) {
    run(args)
  }

  override def execute(spark: SparkContext): Unit =
    example.run(spark)

  override def getName(): String = getClass().getSimpleName + ": " + example.getClass().getSimpleName()
}