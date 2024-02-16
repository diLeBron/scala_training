package StdLibExercises.Traversables

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex1 extends App {
  val set = Set(1, 9, 10, 22)
  val list = List(3, 4, 5, 10)
  val result = set ++ list
  result.size should be(
    7
  )

  val result2 = list ++ set
  result2.size should be(
    8
  )
}
