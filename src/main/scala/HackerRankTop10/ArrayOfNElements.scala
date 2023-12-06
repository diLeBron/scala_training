package HackerRankTop10

object ArrayOfNElements extends App {
  val end = io.Source.stdin.getLines().take(1).toList.head.toInt

  println(Array.range(0, end).mkString("[", ", ", "]"))
}
