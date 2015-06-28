package se.studieren.vs

import org.apache.spark.SparkContext
import se.studieren.vs.examples.{Example, PiExample}

object RunAll extends AbstractRun {
  val waitUserInput = true
  val examples: Array[Example] =
    Array(
      new PiExample
    )

  def main(args: Array[String]) {
    run(args)
  }

  override def execute(spark: SparkContext): Unit =
    for (example <- examples) {
      if(waitUserInput) {
        println("Press <Enter> to run " + example.getClass.getSimpleName)
        readLine()
      }
      example.run(spark)
    }
}