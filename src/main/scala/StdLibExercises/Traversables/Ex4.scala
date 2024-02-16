package StdLibExercises.Traversables

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex4 extends App {
  val list = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
  val result = list.flatMap(_.map(_ * 4))
  result should be(
    List(4, 8, 12, 16, 20, 24, 28, 32, 36, 40)
  )
}
