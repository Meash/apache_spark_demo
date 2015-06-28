package se.studieren.vs.examples

import org.apache.spark.SparkContext

/**
 * @author Martin
 **/
object TextSearch extends Example {
  override def run(spark: SparkContext): Unit = {
    val textFile = spark.textFile("demo.log")
    val piLogs = textFile.filter(line => line.contains("roughly")).collect()
    println("Found " + piLogs.length + " matching log" + (if(piLogs.length != 1) "s" else ""))
    for(line <- piLogs) {
      println(line)
    }
  }
}
