// Exercises 7.3.4 in the book

trait Equal[T] {
  def equals(a: T, b: T): Boolean
}

case class Person(name: String, email: String)

object PersonComparer extends Equal[Person] {
  def equals(a: Person, b: Person): Boolean =
    a.name == b.name && a.email == b.email
}

object PersonEmailComparer extends Equal[Person] {
  def equals(a: Person, b: Person): Boolean =
    a.email == b.email
}

object PersonNameComparer extends Equal[Person] {
  def equals(a: Person, b: Person): Boolean =
    a.name == b.name
}