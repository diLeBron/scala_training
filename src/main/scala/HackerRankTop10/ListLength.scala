package HackerRankTop10

object ListLength extends App {
  val in = io.Source.stdin.getLines().take(1).toList

  println(in.head.split(' ').map(x => x.toInt).toList.zipWithIndex.reverse.head._2 + 1)
}
