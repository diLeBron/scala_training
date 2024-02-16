package StdLibExercises.Traversables

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex2 extends App {
  val set = Set(1, 3, 4, 6)
  val result = set.map(_ * 4)
  result.lastOption should be(
    Some(24)
  )
}
