package lesson13

sealed trait Tree[A] {
  def fold[B](nodeFolder: CombinerFunction[B], leafFolder: ConverterFunction[A, B]): B

  type CombinerFunction[C] = (C, C) => C
  type ConverterFunction[D, E] = D => E
}

case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
  def fold[B](nodeFolder: (B, B) => B, leafFolder: A => B): B =
    nodeFolder(left.fold(nodeFolder, leafFolder), right.fold(nodeFolder, leafFolder))
}

case class Leaf[A](value: A) extends Tree[A] {
  def fold[B](nodeFolder: (B, B) => B, leafFolder: A => B): B = leafFolder(value)
}