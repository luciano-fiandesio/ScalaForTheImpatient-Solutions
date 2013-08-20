import org.scalatest.FunSuite

class Chapter4 extends FunSuite {


  test("1. ") {
    val prices = Map("productA" -> 10.0, "productB" -> 30.0, "productC" -> 800.0)
    val discountedPrices = prices.mapValues(_ * 0.9)  // 10% discount
    assert(Map[String, Double]("productA" -> 9.0, "productB" -> 27.0, "productC" -> 720.0) == discountedPrices)
  }

  test("2. (Using java.util.Scanner)") {
    val wordCount = collection.mutable.Map[String, Int]()
    val in = new java.util.Scanner(new java.io.File("README.md"))
    while(in.hasNext()) {
      val word = in.next.toLowerCase()
      if(wordCount.contains(word)) wordCount(word) += 1
      else wordCount += (word -> 1)
    }
    assert(wordCount("the") >= 10)
  }


  test("3. Repeat (2) with an Imutable Map") {
    val wordRegexp = "\\b([A-Za-z])+\\b".r
    val wordsIterator = io.Source.fromFile("README.md").getLines.flatMap(l => wordRegexp.findAllIn(l.toLowerCase()).toSeq)
    val countMap = wordsIterator.foldLeft(Map.empty[String, Int]){ (count, word) => count + (word -> (count.getOrElse(word, 0) + 1)) }
    assert(countMap("the") >= 10)
  }


  test("4. Repeat (2) with Sorted Map") {
    val wordRegexp = "\\b([A-Za-z])+\\b".r
    val wordsIterator = io.Source.fromFile("README.md").getLines.flatMap(l => wordRegexp.findAllIn(l.toLowerCase()).toSeq)
    //TODO:
  }

  test("5. Repeat (2) with java.util.TreeMap") {
    val wordRegexp = "\\b([A-Za-z])+\\b".r
    val wordsIterator = io.Source.fromFile("README.md").getLines.flatMap(l => wordRegexp.findAllIn(l.toLowerCase()).toSeq)
    //TODO:
  }

  test("6. ") {
    val weekDays = collection.mutable.LinkedHashMap("Sunday" -> java.util.Calendar.SUNDAY)
    weekDays += ("Monday" -> java.util.Calendar.MONDAY)
    weekDays += ("Tuesday" -> java.util.Calendar.TUESDAY)
    weekDays += ("Wednesday" -> java.util.Calendar.WEDNESDAY)
    weekDays += ("Thursday" -> java.util.Calendar.THURSDAY)
    weekDays += ("Friday" -> java.util.Calendar.FRIDAY)
    weekDays += ("Saturday" -> java.util.Calendar.SATURDAY)

    assert(weekDays.keys.mkString(" ") == "Sunday Monday Tuesday Wednesday Thursday Friday Saturday")
  }

  test("7. ") {
    import collection.JavaConversions.propertiesAsScalaMap
    val propsMap = propertiesAsScalaMap(java.lang.System.getProperties)
    val longestPropLength = propsMap.keySet.maxBy(_.length).length;
    for((k,v) <- propsMap) println(k + " " * (longestPropLength - k.length) + "|" +v)
  }

  test("8. ") {
    assert( minmax(Array(3,1,2,6,9,4)) == (1,9))
  }

  def minmax(values: Array[Int]) = (values.min, values.max)


  test("9. ") {
    assert(lteqgt(Array(4,3,1,2,6,9,4,6,7),4) == (3,2,4))
    assert(lteqgt2(Array(4,3,1,2,6,9,4,6,7),4) == (3,2,4))
  }

  //
  def lteqgt(values:Array[Int],v:Int) =  {
    var lt = 0
    var eq = 0
    var gt = 0
    for(n <- values){
      if(n < v) lt += 1
      else if(n == v) eq += 1
      else gt += 1
    }
    (lt, eq, gt)
  }
  // or using partition:
  def lteqgt2(values:Array[Int],v:Int) =  {
    val lt = values.partition(_ < v)
    val eqgt = lt._2.partition(_ == v)
    (lt._1.length, eqgt._1.length, eqgt._2.length)
  }


}