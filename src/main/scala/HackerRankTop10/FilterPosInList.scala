package HackerRankTop10

object FilterPosInList extends App {
  val in = io.Source.stdin.getLines().take(1).toList

  in.head.split(' ').map(x => x.toInt).toList.zipWithIndex.filter(x => x._2 % 2 != 0).map(x => x._1).foreach(println)
}
