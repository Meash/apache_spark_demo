package se.studieren.vs.examples

import org.apache.log4j.{LogManager, Logger}
import org.apache.spark.SparkContext

import scala.math._

/**
 * @author Martin
 */
object ApproximatePi extends Example {
  final val slices = 2
  val logger = Logger.getLogger(ApproximatePi.getClass)

  override def run(spark: SparkContext) {
    val n = math.min(100000L * slices, Int.MaxValue).toInt // avoid overflow
    val count = spark.parallelize(1 until n, slices).map { i =>
        val x = random * 2 - 1
        val y = random * 2 - 1
        if (x * x + y * y < 1) 1 else 0
      }.reduce(_ + _)
    val message: String = "Pi is roughly " + 4.0 * count / n
    println(message)
    logger.info(message)
  }
}
