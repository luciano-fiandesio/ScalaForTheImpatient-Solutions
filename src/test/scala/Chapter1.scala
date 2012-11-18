import org.scalatest.FunSuite

class Chapter1 extends FunSuite {
	
	/** 1.
	scala> 3.
	%              &              *              +              -              /              >              >=             >>             
	>>>            ^              asInstanceOf   isInstanceOf   toByte         toChar         toDouble       toFloat        toInt          
	toLong         toShort        toString       unary_+        unary_-        unary_~        |
	*/
	
	/** 2.
	
	scala> math.sqrt(3)
	res3: Double = 1.7320508075688772

	scala> math.pow(res3,2)
	res4: Double = 2.9999999999999996
	
	*/
	/** 3.
	scala> 1
	res0: Int = 1

	scala> res0=2
	<console>:8: error: reassignment to val
	       res0=2
	           ^
	*/
	
	/** 4.
	scala> "crazy"*3
	res2: String = crazycrazycrazy
	
	http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.StringOps
	
	*/
	
	/** 5.
	max is a method of BigInt: http://www.scala-lang.org/api/current/index.html#scala.math.BigInt
	Returns the maximum of this and that
	
	*/
	
	/** 6.
	scala> BigInt(2) pow 1024
	res0: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216
	*/
	
	test("6. Using BigInt, compute 2 1024.") {
		val res = new java.math.BigInteger("179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216")
		assert (res==(BigInt(2) pow 1024).bigInteger)
	}
	
	/** 7.
		import scala.math.BigInt
		import scala.util.Random
	*/
	test("8. Convert random int to base 36") {
        val rnd = scala.math.BigInt.probablePrime(100, scala.util.Random)
	    println ("BASE 36: " + (rnd toString 36))
	}
	
	test("9. How do you get the first character of a string in Scala? The last character?") {
		val s = "pippo"
		assert ("p" == s.head.toString)
		assert ("p" == s(0).toString)
		assert ("o" == s.last.toString)
		
	}
	
	test("10. What do t he take, drop, takeRight, and dropRight string functions do?") {
	    val s = "pippo"
	    assert ("pip" == (s take 3))
		assert ("po" == (s drop 3))
		assert ("ppo" == (s takeRight 3))
		assert ("pi" == (s dropRight 3))
		
	}
	
}