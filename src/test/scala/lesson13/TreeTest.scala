package lesson13

import org.specs2.mutable.Specification

class TreeTest extends Specification {
  val tree: Tree[Int] =
    Node(
      Node(
        Leaf(8),
        Leaf(9)),
      Leaf(10))
  "Tree test" >> {
    "Tree fold to string" >> {
      tree.fold((y: String, z: String) => y + z, (x: Int) => x.toString) ===
        "8910"
    }
    "Tree fold to int" >> {
      def adderFunction(y: Int, z: Int): Int = y + z

      tree.fold(adderFunction, (x: Int) => x) ===
        27
    }
  }
}
