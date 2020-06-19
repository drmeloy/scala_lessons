package lesson26.exercise761

trait EqualityChecker[T] {
  def doesEqual(a: T, b: T): Boolean
}

object EqualityChecker {

  implicit class EqChecker[T](obj: T) {
    def ===(obj2: T)(implicit checker: EqualityChecker[T]): Boolean = checker.doesEqual(obj, obj2)
  }

  implicit object PersonEmailComparer extends EqualityChecker[Person] {
    def doesEqual(a: Person, b: Person): Boolean =
      a.email == b.email
  }

}

case class Person(name: String, email: String)

object Main2 extends App {

  import EqualityChecker._

  println(Person("Jake", "jake@jake.com").===(Person("Travis", "jake@jake.com")))
}
