package StdLibExercises.ForExpressions

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex1 extends App {
  val xValues = 1 to 4
  val yValues = 1 to 2
  val coordinates = for {
    x <- xValues
    y <- yValues
  } yield (x, y)
  coordinates(4) should be((
    3
    ,
    1
  ))
}
