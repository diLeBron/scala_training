package StdLibExercises.PartialFunctions

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex4 extends App {
  val doubleEvens: PartialFunction[Int, Int] = {
    case x if (x % 2) == 0 => x * 2
  }
  val tripleOdds: PartialFunction[Int, Int] = {
    case x if (x % 2) != 0 => x * 3
  }

  val printEven: PartialFunction[Int, String] = {
    case x if (x % 2) == 0 => "Even"
  }
  val printOdd: PartialFunction[Int, String] = {
    case x if (x % 2) != 0 => "Odd"
  }

  val whatToDo = doubleEvens orElse tripleOdds andThen (printEven orElse printOdd)

  whatToDo(3) should be(
    "Odd"
  )
  whatToDo(4) should be(
    "Even"
  )
}
