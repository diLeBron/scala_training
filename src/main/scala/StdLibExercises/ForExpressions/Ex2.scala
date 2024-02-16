package StdLibExercises.ForExpressions

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex2 extends App {
  val nums = List(List(1), List(2), List(3), List(4), List(5))

  val result = for {
    numList <- nums
    num <- numList
    if (num % 2 == 0)
  } yield (num)

  result should be(
    List(2, 4)
  )

  // Which is the same as
  nums.flatMap(numList => numList).filter(_ % 2 == 0) should be(result)

  // or the same as
  nums.flatten.filter(_ % 2 == 0) should be(result)
}
