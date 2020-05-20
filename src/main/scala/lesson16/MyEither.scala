package lesson16

sealed trait MyEither[A, B] {
  def map[C](f: B => C): MyEither[A, C] = this match {
    case MyLeft(v) => MyLeft(v)
    case MyRight(v) => MyRight(f(v))
  }

  def flatMap[C](f: B => MyEither[A, C]): MyEither[A, C] = this match {
    case MyRight(v) => f(v)
    case MyLeft(v) => MyLeft(v)
  }
}

final case class MyLeft[A, B](a: A) extends MyEither[A, B]

final case class MyRight[A, B](b: B) extends MyEither[A, B]

