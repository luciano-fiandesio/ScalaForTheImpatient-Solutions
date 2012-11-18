import org.scalatest.FunSuite

class Chapter2 extends FunSuite {
    
    test("1. The signum of a number is 1 if the number is positive, -1 if it is negative, and 0 if it is zero.") {
	    assert (0 == signum(0))
        assert (1 == signum(10))
        assert (-1 == signum(-10))
	}

    def signum(i:Int) = {
       if (i==0) 0 else if (i<0) -1 else 1
    }
    
    def isUnit(obj:Any) = obj match {
       case u:Unit => true
       case _ => false
    }

    test("2. What is the value of an empty block expression {}? What is its type?") {
        
        val empty = {}
        assert(isUnit(empty))
    }
    
    // 3. TODO

    test("4. Write a scala equivalent for the Java loop...") {
      	for (i <- 10 to 0 by -1) {
			println (i)
        }
    }

	test("5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.") {
		// No assertion here...
		countdown(55)
	}
	
	def countdown(upperLimit:Int) {
		for (i <- upperLimit to 0 by -1) {
			println (i)
        }
	}
	
	test("6. Write a for loop for computing the product of the Unicode codes of all letters in a string") {
		var unicode:Long = 1
		for (s <- "Hello") {
			unicode *= s.toInt
		}
		assert(9415087488L == unicode)
	}
	
	test("7. Solve the preceding exercise without writing a loop.") {
		assert(9415087488L == "Hello".foldLeft(1L)(_*_))
	}
	
	test("8. Write a function product(s : String) that computes the product") {
		assert(9415087488L == product("Hello"))
	}
	
	def product(s:String) = {
		s.foldLeft(1L)(_*_)
	}
	
	test("9. Make the function of the preceding exercise a recursive function.") {
		assert(9415087488L == productR("Hello"))
	}
	
	def productR(s:String):Long = {
		if(s.length==0) 1 else s(0)*productR(s drop 1)
	}
	
	test("10. Write a function that computes xn, where n is an integer") {
	
		// TODO
	}
	

}