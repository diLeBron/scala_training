package HackerRankTop10

object ListReplication extends App {
  val in = io.Source.stdin.getLines().take(2).toList

  def printRepeat(value: Int, repeat: Int): Unit = List.fill(repeat)(value).foreach(println)

  def listReplicator(list: List[Int], repeat: Int): Unit = list.foreach(x => printRepeat(x, repeat))

  listReplicator(in.tail.head.split(' ').toList.map(x => x.toInt), in.head.toInt)
}
