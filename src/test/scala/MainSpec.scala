import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
class MainSpec extends AnyFunSuite with Matchers {

  test("getmean"){
    val arr:Array[Double] = Array(1,2,3,4,5)
    val result = Main.getMean(arr)
    result should equal(3)
  }

  test("getStandardDeviation"){
    val arr:Array[Double] = Array(1,2,3,4,5)
    val mean = 3
    val result = Main.getStandardDeviation(mean, arr)
    result should equal(Math.sqrt(2))
  }
  test("getRatings"){
    val arr = Main.getRatings
    arr(1) should equal("7.1")
    arr(0) should equal("7.9")
  }
}