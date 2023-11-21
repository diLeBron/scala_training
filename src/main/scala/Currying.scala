object Currying extends App {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(n: Int): Boolean = {
      if (n >= as.length - 1) ordered(as(n - 1), as(n))
      else if (n >= 1) {
        if (ordered(as(n - 1), as(n))) loop(n + 1)
        else false
      }
      else loop(n + 1)
    }

    loop(0)
  }

  println("----------- def isSorted -----------")
  println(isSorted(Array(5, 4, 3, 2, 1), (x: Int, y: Int) => x > y))
  println(isSorted(Array(4, 5, 3, 2, 1), (x: Int, y: Int) => x > y))

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
    (b: B) => f(a, b)
  }

  println("----------- def partial1 -----------")
  val part1 = partial1(10.0, (x: Double, y: Int) => x > y)
  println(part1(5))
  println(part1(15))

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    (a: A) => ((b: B) => f(a, b))
  }

  println("----------- def curry -----------")
  val cur = curry((x: Double, y: Int) => x > y)
  println(cur(5.1)(5))
  println(cur(15.9)(16))

  def uncurry[A,B,C](f: A => (B => C)): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  println("----------- def uncurry -----------")
  val uncur = uncurry((x: Double) => (y: Int) => x > y)
  println(uncur(5.1, 5))
  println(uncur(15.9, 16))

  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a))
  }

  println("----------- def compose -----------")
  val comp = compose((x: Double) => x * 2, (y: Int) => y * 1.0)
  println(comp(5))
  println(comp(15))

  def calculateDiscount(discountRate: Double, minimumPurchaseAmount: Double, purchaseAmount: Double): Double = {
    discountRate * minimumPurchaseAmount * purchaseAmount
  }

  val calculateDiscountCurried: Double => Double => Double => Double = (calculateDiscount _).curried

  val calculateDiscountWithRate = calculateDiscountCurried(0.1)
  val calculateDiscountWithMinPurchaseAmount = calculateDiscountWithRate(1.0)
  val calculateDiscountFinal = calculateDiscountWithMinPurchaseAmount(500.0)

  println("----------- def calculateDiscount -----------")
  println(calculateDiscountFinal)
}


