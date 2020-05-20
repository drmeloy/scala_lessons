package lesson16

sealed trait MyOption[T] {
  def myMap[U](f: T => U): MyOption[U] =
    this match {
      case MySome(v) => MySome(f(v))
      case MyNone() => MyNone()
    }

  def myFlatMap[U](f: T => MyOption[U]): MyOption[U] =
    this match {
      case MySome(v) => f(v)
      case MyNone() => MyNone()
    }
}

final case class MySome[T](value: T) extends MyOption[T]

final case class MyNone[T]() extends MyOption[T]

object Main extends App {
  //  def sqrtOption(num: Double): MyOption[Double] =
  //    if (num > 0) MySome(Math.sqrt(num))
  //    else MyNone()
  //
  //  val op1 = MySome(5)
  //  val op2 = MySome(-5)
  //  println(op1.myMap(_ * 2))
  //  println(op1.myFlatMap(sqrtOption(_)))
  //  println(op2.myFlatMap(sqrtOption(_)))
  val oneOrOther: MyEither[String, Boolean] = MyLeft("Sup nerds?")
  val oneOrOtherzzz: MyEither[String, Boolean] = MyRight(true)
  println(oneOrOther.map((y: Boolean) => 0))
  println(oneOrOtherzzz.map((y: Boolean) => 0))
  println(oneOrOtherzzz.flatMap(bool => MyRight(1)))
}