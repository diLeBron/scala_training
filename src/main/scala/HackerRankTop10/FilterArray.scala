package HackerRankTop10

object FilterArray extends App {
  val in = io.Source.stdin.getLines().take(2).toList

  def array: Array[Int] = in.tail.head.split(' ').map(x => x.toInt).filter(x => x < in.head.toInt)

  array.foreach(println)
}
