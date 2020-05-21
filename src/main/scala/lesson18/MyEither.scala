package lesson18

sealed trait MyEither[+A, +B] {
  def map[C](f: B => C): MyEither[A, C] = this match {
    case MyLeft(v) => MyLeft(v)
    case MyRight(v) => MyRight(f(v))
  }

  // C
  def flatMap[AA >: A, C](f: Function1[B, MyEither[AA, C]]): MyEither[AA, C] = this match {
    case MyRight(v) => f(v)
    case MyLeft(v) => MyLeft(v)
  }
}

final case class MyLeft[A](a: A) extends MyEither[A, Nothing]

final case class MyRight[B](b: B) extends MyEither[Nothing, B]

object Testing extends App {
  val myRight: MyRight[String] = MyRight("Hi")

  def lengthConverter(str: String): MyEither[Boolean, Int] =
    if (str.isEmpty) MyLeft(false)
    else MyRight(str.length)

  val results = myRight.flatMap(lengthConverter)
  println(results)
}