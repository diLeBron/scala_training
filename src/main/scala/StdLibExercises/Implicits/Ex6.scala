package StdLibExercises.Implicits

import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Ex6 extends App {
  def howMuchCanIMake_?(hours: Int, amount: BigDecimal = 34, currencyName: String = "Dollars") =
    (amount * hours).toString() + " " + currencyName

  howMuchCanIMake_?(30) should be(
    "1020 Dollars"
  )

  howMuchCanIMake_?(30, 95) should be(
    "2850 Dollars"
  )
}
