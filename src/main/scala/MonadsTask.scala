import scala.util.Random

object MonadsTask extends App {
  def randInt(from: Int, to: Int): Int = from + Random.nextInt(to - from + 1)

  def dummy(): Option[Int] = {
    val r = randInt(1, 7)
    if (r <= 5) Some(r)
    else None
  }

//  def getResponse(): String = {
//    val r = randInt(1, 7)
//    if (r <= 5) f"$r"
//    else throw new IOException("ERROR")
//  } //возвращает значения "1", "2", "3", "4", "5" (String) но может выбросить исключение IOException

  def getResponse(): Option[Int] = dummy()

  def runBalanceLogic(): Option[Int] = dummy() // может вернуть значения Some(1), Some(2), Some(3), Some(4), Some(5), None

  def mustOneLogic(): Option[Int] = dummy() // может вернуть значения Some(1), Some(2), Some(3), Some(4), Some(5), None

  def wantLessThenFiveLogic(): Option[Int] = dummy() // может вернуть значения Some(1), Some(2), Some(3), Some(4), Some(5), None

  def tupleTrouble(): Option[Int] = dummy() // может вернуть значения Some(1), Some(2), Some(3), Some(4), Some(5), None

  def doItWithEither(): Option[Int] = dummy() // может вернуть значения Some(1), Some(2), Some(3), Some(4), Some(5), None

  def moreAnswers(): Option[List[Int]] = Some(List(1,2,3,4,5)) // может вернуть значения Some(List(1)), Some(List(1,2)), ..., Some(List(1,2,3,4,5)), None

  def checkItStopIt(): Option[Int] = dummy() // может вернуть значения Some(1), Some(2), Some(3), Some(4), Some(5), None

  def checkItStopItPlease(): Option[Int] = dummy()// может вернуть значения Some(1), Some(2), Some(3), Some(4), Some(5), None

  def finalCalculationLog(whiteCrow: Either[String, Int], sumOptions: Int, sumSubtract: Int): Int = {
    whiteCrow match {
      case Left(_) => 0
      case Right(_) => sumOptions - sumSubtract
    }
  }

  def detected2(x: Int): Option[Unit] = {
    if (x == 2) println("2 detected!")
    Some(())
  }

  val left = Left("either Error! Karr! Karr!")

  val calculation = for {
    response <- getResponse()
    runBalanceLogic <- runBalanceLogic()
    _ <- detected2(runBalanceLogic)
    random = if (runBalanceLogic < 3) response + 1 else response - 1
    mustOneLogic <- mustOneLogic()
    _ <- detected2(mustOneLogic)
    mustOne = if (mustOneLogic == 1) 1 else response
    wantLessThenFiveLogic <- wantLessThenFiveLogic()
    _ <- detected2(wantLessThenFiveLogic)
    lessFive = if (wantLessThenFiveLogic == 5 & List(1,2,3).contains(runBalanceLogic)) (Some(response), Some(runBalanceLogic)) else (Some(random), Some(mustOne))
    tupleTrouble <- tupleTrouble()
    _ <- detected2(tupleTrouble)
    tupleDisaster = if (tupleTrouble <= 2) true else false
    doItWithEither <- doItWithEither()
    _ <- detected2(doItWithEither)
    whiteCrow = if ((Option(doItWithEither).isEmpty & response == 1) || Option(mustOneLogic).isEmpty) left else Right(mustOneLogic)
    moreAnswers <- moreAnswers()
    preSize = runBalanceLogic + mustOneLogic + wantLessThenFiveLogic
    size = if (preSize > moreAnswers.sum) preSize else 1
    checkItStopIt <- checkItStopIt()
    _ <- detected2(checkItStopIt)
    checkItStopItPlease <- checkItStopItPlease()
    _ <- detected2(checkItStopItPlease)
    finalCalculation = finalCalculationLog(
      whiteCrow,
      runBalanceLogic + mustOneLogic + wantLessThenFiveLogic + tupleTrouble + doItWithEither + checkItStopIt + checkItStopItPlease,
      random + mustOne + size
    )
  } yield finalCalculation

  val result = calculation match {
    case None => Left("too much randomization!")
    case Some(a) => Right(s"result is: $a")
  }

  println(result)

}