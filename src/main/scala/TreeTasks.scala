sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object TreeTasks extends App {
  def size[A](tr: Tree[A]): Int = {
    def loop(tr: Tree[A], acc: Int): Int = {
      tr match {
        case Leaf(_) => acc + 1
        case Branch(left, right) => loop(left, acc) + loop(right, acc) + 1
      }
    }
    loop(tr, 0)
  }

//  println(size(Leaf[Int](123)))
//  println(
//    size(
//      Branch[Int](
//        Branch[Int](
//          Leaf[Int](4),
//          Branch[Int](
//            Leaf[Int](31),
//            Leaf[Int](33)
//          ),
//        ),
//        Branch[Int](
//          Branch[Int](
//            Leaf[Int](21),
//            Leaf[Int](23)
//          ),
//          Leaf[Int](1)
//        )
//      )
//    )
//  )

  def maximum(tree: Tree[Int]): Int = {
    def loop(tr: Tree[Int], acc: List[Int]): List[Int] = {
      tr match {
        case Leaf(value) => acc.appended(value)
        case Branch(Leaf(value), right) => loop(right, acc.appended(value))
        case Branch(left, Leaf(value)) => loop(left, acc.appended(value))
        case Branch(left, right) => loop(left, loop(right, acc))
      }
    }

    loop(tree, List.empty).max
  }

//    println(maximum(Leaf[Int](123)))
//    println(
//      maximum(
//        Branch[Int](
//          Branch[Int](
//            Leaf[Int](44),
//            Branch[Int](
//              Leaf[Int](31),
//              Leaf[Int](33)
//            ),
//          ),
//          Branch[Int](
//            Branch[Int](
//              Leaf[Int](21),
//              Leaf[Int](23)
//            ),
//            Leaf[Int](111)
//          )
//        )
//      )
//    )

}

