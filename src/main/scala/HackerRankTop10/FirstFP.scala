package HackerRankTop10

object FirstFP {
  def main(args: Array[String]): Unit = {
    println(io.Source.stdin.getLines().take(2).map(x => x.toInt).sum)
  }
}
