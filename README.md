# Apache Spark Demo
###### for the course *Verteilte Systeme* at Uni Augsburg, hosted by Prof.Bauer

1. Set up the cluster
    1. Navigate to the spark binaries directory: `cd lib/spark-1.4.0-bin-hadoop2.6/bin`
    1. Start the master: `spark-class.cmd org.apache.spark.deploy.master.Master`
    1. Start at least one worker: `spark-class.cmd org.apache.spark.deploy.worker.Worker spark://192.168.59.3:7077` (make sure the url points to your master)
    1. Make sure the cluster is set up properly by checking `http://192.168.59.3:8080`
1. Build the JAR: `gradle build`
1. Run the examples inside `src/main/java/se/studieren/vs`
    1. Run all examples by running `scala RunAll spark://192.168.59.3:7077` (make sure the url points to your master). You can monitor the jobs at `http://192.168.59.3:4040/jobs`
    1. Or run individual examples by running `scala RunOne spark://192.168.59.3:7077` (make sure the url points to your master)

Note that you should initialize the spark context only once in a real application since this task takes some time.