import scala.io.Source
object Main {
  def getMean(array: Array[Double]):Double = {
    var len = array.length
    var sum = 0.0
    for (index <- array.indices){
      if(array(index) != -1){
        sum += array(index)
      } else{len -= 1}
    }
    sum / len
  }

  def getStandardDeviation(mean: Double, array: Array[Double]): Double = {
    var sumsqr: Double = 0.0
    var len = array.length
    for(index <- array.indices){
      if (array(index)!= -1){
        sumsqr += Math.pow(Math.abs(mean - array(index)),2)
      } else {len -= 1}
    }
    Math.sqrt(sumsqr / len)
  }


  def main(args: Array[String]): Unit = {
    val ratingString: Array[String] = Main.getRatings
//    println(ratingString(279))
//    for (i <- ratingString.indices) {
//      println(ratingString(i).toDouble, i)
//    }
//
    val ratingDouble: Array[Double] = ratingString
      .map(s => if(s == "" || s.toDouble > 10 || s.toDouble < 0) -1 else s.toDouble)
//    for (i <- ratingDouble.indices) {
//      println(ratingDouble(i))
//    }
    val mean = Main.getMean(array = ratingDouble)
    val stdDev = Main.getStandardDeviation(mean = mean, array = ratingDouble)

    println(s"Mean: $mean")
    println(s"Standard deviation: $stdDev")
  }

  def getRatings: Array[String] = {
    val fileName = "src/main/resources/movie_metadata.csv"
    val columnIndex = 25

    val columnValues = Source.fromFile(fileName).getLines().map(_.split(",")(columnIndex))
      .drop(1).toArray

    Source.fromFile(fileName).close()

    columnValues
  }

}
