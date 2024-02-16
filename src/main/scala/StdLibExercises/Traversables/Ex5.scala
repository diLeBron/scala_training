package StdLibExercises.Traversables

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex5 extends App {
  val list = List(1, 2, 3, 4, 5)
  val result = list.flatMap(it => if (it % 2 == 0) Some(it) else None)
  result should be(
    List(2, 4)
  )
}
