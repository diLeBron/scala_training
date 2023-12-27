import cats.{Functor, Monad}
import cats.kernel.Monoid

object Monads extends App {
  val strMonoid = new Monoid[String] {
    override def empty: String = ""

    override def combine(x: String, y: String): String = x + y
  }

//  println(strMonoid.combine("a", "b"))
//  println(strMonoid.empty)

  val listFunctor = new Functor[List] {
    override def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(x => f(x))
  }

  val listMonad = new Monad[List] {
    override def pure[A](x: A): List[A] = List(x)

    override def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] = fa.map(x => f(x).head) // pure needs to used

    override def tailRecM[A, B](a: A)(f: A => List[Either[A, B]]): List[B] = ???
  }

  def toInt(x: String): List[Int] = List(x.toInt)
  val listInt = listMonad.flatMap[String, Int](List("1","2","3"))(toInt)
  println(listInt.sum)
//  println(List("1","2","3").flatMap(x => List(x).map(x=>x.toInt)).sum)

//  val x: Option[Int] = Some(5)
//  val y: Option[Int] = None
//  val z: Option[Int] = Some(10)
//  val res = for {
//    xx <- x
//    yy <- y
//    zz <- z
//  } yield xx + yy
//
//  println(res)

  val x: Either[String, Int] = Right[String, Int](5)
  val y: Either[String, Int] = Left("Error")
  val z: Either[String, Int] = Right(10)
  val res = for {
    xx <- x
    yy <- y
    zz <- z
  } yield xx + yy + zz

//  println(res)


}
