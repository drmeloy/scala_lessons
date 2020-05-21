package lesson18

sealed trait MyOption[+T] {
  def myMap[U](f: T => U): MyOption[U] =
    this match {
      case MySome(v) => MySome(f(v))
      case MyNone => MyNone
    }

  def myFlatMap[U](f: T => MyOption[U]): MyOption[U] =
    this match {
      case MySome(v) => f(v)
      case MyNone => MyNone
    }
}

final case class MySome[T](value: T) extends MyOption[T]

final case object MyNone extends MyOption[Nothing]

