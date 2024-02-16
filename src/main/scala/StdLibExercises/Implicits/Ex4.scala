package StdLibExercises.Implicits

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex4 extends App {
  def howMuchCanIMake_?(hours: Int)(implicit dollarsPerHour: BigDecimal) =
    dollarsPerHour * hours

  implicit val hourlyRate = BigDecimal(34)

  howMuchCanIMake_?(30) should be(
    1020
  )
}
