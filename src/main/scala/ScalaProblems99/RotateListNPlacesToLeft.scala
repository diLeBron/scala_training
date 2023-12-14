package ScalaProblems99

object RotateListNPlacesToLeft extends App {

  def rotate[A](n: Int, list: List[A]): List[A] = {
    val movePart = if (n > 0) list.take(n) else list.takeRight(math.abs(n))
    val staticPart = if (n > 0) list.zipWithIndex.filter(x => x._2 >= n).map(x => x._1) else list.zipWithIndex.filter(x => x._2 < list.length + n).map(x => x._1)
    if (n > 0) staticPart ++ movePart else movePart ++ staticPart
  }

  println(rotate(3, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")))
  println(rotate(-2, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")))

//  println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(rotate(3, List(Symbol("a"), Symbol("b"), Symbol("c"), Symbol("d"), Symbol("e"), Symbol("f"), Symbol("g"), Symbol("h"), Symbol("i"), Symbol("j"), Symbol("k"))))
  println(rotate(-2, List(Symbol("a"), Symbol("b"), Symbol("c"), Symbol("d"), Symbol("e"), Symbol("f"), Symbol("g"), Symbol("h"), Symbol("i"), Symbol("j"), Symbol("k"))))

}
