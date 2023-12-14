package HackerRankTop10

object HelloWorldRepeat extends App {
  def printHelloWorld(repeat: Int): Unit = {
    List.fill(repeat)("Hello World").foreach(println)
  }
  printHelloWorld(4)
}
