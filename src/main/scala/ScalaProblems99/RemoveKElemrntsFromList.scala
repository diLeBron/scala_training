package ScalaProblems99

object RemoveKElemrntsFromList extends App {

  def removeAt[A](k: Int, list: List[A]): (List[A], A) = {
    (list.zipWithIndex.filter(x => x._2 != k).map(x => x._1), list(k))
  }

  println(removeAt(1, List("a", "b", "c", "d")))
  println(removeAt(1, List(Symbol("a"), Symbol("b"), Symbol("c"), Symbol("d"))))
}
