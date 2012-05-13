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
}