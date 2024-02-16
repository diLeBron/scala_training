package StdLibExercises.Asserts

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object AllExs extends App {

  true should be(
    true
  )

  val v1 = 4
  v1 shouldEqual 4

  assert(2 == 1 + 1)

}
