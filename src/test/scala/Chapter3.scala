import org.scalatest.FunSuite
import scala.util.Random
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
class Chapter3 extends FunSuite with ShouldMatchers {
  
  test("1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).") {
	  
    val a = generateRandomArray(200)
	assert (a.length <= 200)
	for (rndVal <- a) {
	  assert (rndVal <= 200)
	}
  }
  
  def generateRandomArray(n:Int) = {
    
    new Array[Int](Random.nextInt(n)) map(_ => Random.nextInt(n))
    
  }
  
  test("2. Write a loop that swaps adjacent elements of an array of integers.") {
	val array = Array[Int](10,20,30,40,50) 
	for (i <- 0 until (array.length-1,2)) {
    	val xx = array(i)
        array(i) = array(i+1)
        array(i+1) = xx
    }  
	Array[Int](20,10,40,30,50) should equal (array)
	
	
  }
  
  test("3. Repeat the preceding assignment, but produce a new array wit h t he swapped values. Use for/yield.") {
	  val array = Array[Int](10,20,30,40,50) 
	  Array[Int](20,10,40,30,50) should equal ( swapArray (array))
	  
  }
  
  def swapArray(array:Array[Int]) = {
	  (for {
	    b <- array.grouped(2) // returns Iterable
	    c <- b.reverse
	  } yield c).toArray
  }
  
  test ("4. Given an array of integers, produce a new array that contains all positive values of the original array, in their original order, followed by all values that are zero or negative, in their original order.") {
	  val array = Array[Int](10,-20,23,93,5,-2,10,0,3,-903)
	  
	  Array[Int](10,23,93,5,10,3,-20,-2,0,-903) should equal ( fixArray (array))
    
  }
  
  def fixArray(array:Array[Int]) = {
    val pos = for { i <- array if i > 0 } yield i
    val neg = for { i <- array if i <= 0} yield i
    Array concat (pos, neg)
  }
  
  test ("5. Compute average of Array[Double]") {
    
    val array = Array[Double](100,2000,300000, 4000000, 50000000)
    assert (1.086042E7 === avg(array))
    
    
  }
  
  def avg(array:Array[Double]) = {
    array.sum/array.length
  }
  
  test ("6. How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order? How do you do the same with an ArrayBuffer[Int]?") {
	  val array = Array[Int](30,10,20,50,40,60)
	  Array[Int](60,50,40,30,20,10) should equal ( reverseSort (array))		  
	  
	  val arrayB = ArrayBuffer[Int](30,10,20,50,40,60)
	  ArrayBuffer[Int](60,50,40,30,20,10) should equal ( reverseSort (arrayB))	
  }
  
  def reverseSort(array:Array[Int]) = {
	  scala.util.Sorting.quickSort(array)
	  array.reverse
  }
  
  def reverseSort(arrayB:ArrayBuffer[Int]) = {
	  arrayB.sortWith(_ > _)
  }
  
  test ("7. Remove duplicates in Array") {
	  val array = Array[Int](10,20,20,30,40,50,70,70,100,100)
	  Array[Int](10, 20, 30, 40, 50, 70, 100) should equal ( array.distinct)
  }
  
  test ("9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America.Strip off the America/ prefix and sort the result.") {
	 
    val b1 = for { i <- java.util.TimeZone.getAvailableIDs if i.startsWith("America")} yield i.substring("America/".length)
	scala.util.Sorting.quickSort(b1)
	assert (b1(0) === "Adak")
	// 
    
  }

}