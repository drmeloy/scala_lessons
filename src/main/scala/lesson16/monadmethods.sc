def sqrtOption(num: Double): Option[Double] =
  if (num > 0) Some(Math.sqrt(num))
  else None

val a = Some(5)
a.map(_ * 2)
a.map(x => sqrtOption(x))

val b: Option[Int] = None
b.map(_ * 2)
b.flatMap(sqrtOption(_))

val c: Option[Int] = Some(-1)
c.flatMap(x => sqrtOption(x))

None ++ List(1)
Some(2) ++ List(1)
Some(Some(3)) ++ List(Some(2))

sealed trait MyEither[A, B]
final case class MyLeft[A, B](a: A) extends MyEither[A, B]
final case class MyRight[A, B](b: B) extends MyEither[A, B]

sealed trait MyOption[T] {
  def myMap[U](f: T => U): MyOption[U] =
    this match {
      case MySome(v) => MySome(f(v))
      case MyNone() => MyNone()
    }
}

final case class MySome[T](value: T) extends MyOption[T]

final case class MyNone[T]() extends MyOption[T]

val op1 = MySome(2)
op1.myMap(_ * 2)

def myFind(list: List[Int], target: Int => Boolean): MyOption[Int] =
  list.find(target) match {
    case Some(value) => MySome(value)
    case None => MyNone()
  }

val list = List(1, 2, 3)
val list2 = List(4, 5, 6)
val result1 = myFind(list, _ > 4)
val result2 = myFind(list2, _ > 4)

val doubled: MyOption[Int] =
  result2 match {
    case MySome(value) => MySome(value * 2)
    case MyNone() => MyNone()
  }