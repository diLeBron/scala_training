package ExceptionHandlerPartialFunc

sealed trait CustomError extends Throwable

case class FirstMyError() extends CustomError

case class SecondMyError() extends CustomError


object Main extends App {
  val exceptionHandler: PartialFunction[Throwable, String] = {
    case _: ArithmeticException => "ArithmeticException was found"
    case _: ArrayIndexOutOfBoundsException => "ArrayIndexOutOfBoundsException was found"
    case _: ClassNotFoundException => "ClassNotFoundException was found"
  }

  val errorHandler: PartialFunction[Throwable, String] = {
    case _: AbstractMethodError => "AbstractMethodError was found"
    case _: AssertionError => "AssertionError was found"
  }

  val customErrorHandler: PartialFunction[Throwable, String] = {
    case _: FirstMyError => "FirstMyError was found"
    case _: SecondMyError => "SecondMyError was found"
  }

  def mainHandler(e: Throwable): String = {
    exceptionHandler.orElse(errorHandler).orElse(customErrorHandler)(e)
  }

  def check(e: Throwable, expectedMsg: String): Unit = {
    val res = if (mainHandler(e) == expectedMsg) "SUCCESS" else "FAILED"
    println(s"TEST: $res")
  }

  check(new ArithmeticException, "ArithmeticException was found")
  check(new ArrayIndexOutOfBoundsException, "ArrayIndexOutOfBoundsException was found")
  check(new AbstractMethodError, "AbstractMethodError was found")
  check(new AssertionError, "AssertionError was found")
  check(new FirstMyError, "FirstMyError was found")
  check(new SecondMyError, "SecondMyError was found")
}
