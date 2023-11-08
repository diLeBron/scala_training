import scala.annotation.tailrec

object TailRecursive extends App {
  def fib(n: Int): List[Int] = {
    @tailrec
    def go(k: Int, acc: List[Int]): List[Int] = {
      if (acc.length >= n) acc
      else {
        acc match {
          case head :: next :: Nil => go(k - 1, acc.appended(head + next))
          case _ :: next => go(k - 1, acc.appended(next.last + next.reverse.tail.head))
        }
      }
    }
    go(n, List(0, 1))
  }

  def fibSum(n: Int): Int = fib(n).sum

  def factorial(n: Int): Int = {
    @tailrec
    def go(k: Int, acc: Int): Int = {
      if (k == 1) acc
      else go(k - 1, acc * k)
    }

    go(n, 1)
  }
}
