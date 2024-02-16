package StdLibExercises.Implicits

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object MyPredef {

  class KoanIntWrapper(val original: Int) {
    def isOdd = original % 2 != 0

    def isEven = !isOdd
  }

  implicit def thisMethodNameIsIrrelevant(value: Int) =
    new KoanIntWrapper(value)
}

object Ex2 extends App {

  import MyPredef._
  //imported implicits come into effect within this scope
  19.isOdd should be(
    true
  )
  20.isOdd should be(
    false
  )
}
