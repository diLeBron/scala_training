package HackerRankTop10

object SumOfOddElements extends App {
  val in = io.Source.stdin.getLines().take(1).toList

  println(in.head.split(' ').map(x => x.toInt).toList.filter(x => x % 2 != 0).sum)
}
