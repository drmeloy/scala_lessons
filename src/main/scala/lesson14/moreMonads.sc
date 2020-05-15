case class Pair[A, B](obj1: A, obj2: B) {
  def apply(obj1: A, obj2: B) = {
    println("Custom apply method")
    Pair(obj1, obj2)
  }

}

val pair0 = Pair("Dan", 31)
Tuple3("dan", 2, 45)
val bigTupe = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)
("dan", 2, 45) == ("dan", 2, 45)
Pair("Hi", 3)
println(Pair.apply("hi", 4))
pair0 match {
  case Pair(name, age) => println(name, age)
}
val tupe1 = ("Dan", "the", "man")
tupe1._1
tupe1 match {
  case (_, a, _) if (a.length == 3) => println(a)
}
val people = List(("Dan", 31), ("Travis", 31), ("Dan", 32))
val ages = people.map { case (_, a) => a }
def stringOrInt(bool: Boolean): Either[String, Int] =
  if (bool) Left("True!")
  else Right(1)
stringOrInt(true) match {
  case Left(string) => println(string)
  case Right(int) => println(int)
}

sealed trait MyEither[A, B]

final case class MyLeft[A, B](a: A) extends MyEither[A, B]

final case class MyRight[A, B](b: B) extends MyEither[A, B]

people.find { case (name, _) => name == "Maddie" }
people.find { case (name, _) => name == "Dan" }
people.filter { case (name, _) => name == "Dan" }
people.filter(_._1 == "Dan")