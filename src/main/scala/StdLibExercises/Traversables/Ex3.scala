package StdLibExercises.Traversables

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex3 extends App {
  val list = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
  list.flatten should be(
    List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  )
}
