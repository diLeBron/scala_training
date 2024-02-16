package StdLibExercises.Implicits

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class KoanIntWrapper(val original: Int) {
  def isOdd = original % 2 != 0
}

object Ex1 extends App {
  implicit def thisMethodNameIsIrrelevant(value: Int) =
    new KoanIntWrapper(value)

  19.isOdd should be(
    true
  )
  20.isOdd should be(
    false
  )
}
