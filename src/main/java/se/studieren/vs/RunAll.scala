package se.studieren.vs

import org.apache.spark.SparkContext
import se.studieren.vs.examples.{ApproximatePi, Example, TextSearch}

object RunAll extends AbstractRun {
  val waitUserInput = true
  val examples: Array[Example] =
    Array(
      ApproximatePi,
      TextSearch
    )

  def main(args: Array[String]) {
    run(args)
  }

  override def execute(spark: SparkContext): Unit = {
    for (example <- examples) {
      if (waitUserInput) {
        println("Press <Enter> to run " + example.getClass.getSimpleName())
        readLine()
      }
      println("Running " + example.getClass.getSimpleName() + "...")
      example.run(spark)
    }
    println("Press <Enter> to quit")
    readLine()
  }

  override def getName(): String = return getClass().getSimpleName()
}