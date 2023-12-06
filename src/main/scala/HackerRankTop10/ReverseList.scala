package HackerRankTop10

import scala.annotation.tailrec

object ReverseList extends App {
  val in = io.Source.stdin.getLines().take(1).toList.head.split(' ').map(x => x.toInt).toList

  def reverse(inList: List[Int]): List[Int] = {
    @tailrec
    def loop(list: List[Int], acc: List[Int]): List[Int] = {
      if (list.isEmpty) acc
      else loop(list.tail, acc.prepended(list.head))
    }

    loop(inList, List.empty)
  }

  reverse(in).foreach(println)
}
