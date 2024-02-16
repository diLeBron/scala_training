package StdLibExercises.PartialFunctions

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex3 extends App {
  val doubleEvens: PartialFunction[Int, Int] = {
    case x if (x % 2) == 0 => x * 2
  }
  val tripleOdds: PartialFunction[Int, Int] = {
    case x if (x % 2) != 0 => x * 3
  }

  val addFive = (x: Int) => x + 5
  val whatToDo =
    doubleEvens orElse tripleOdds andThen addFive //Here we chain the partial functions together
  whatToDo(3) should be(
    14
  )
  whatToDo(4) should be(
    13
  )
}
