// Exercises 7.3.4 in the book

trait EqualityChecker[T] {
  def equals(a: T, b: T): Boolean
}

object EqualityChecker {
  def apply[A](implicit equalityCheckerInstance: EqualityChecker[A]): EqualityChecker[A] =
    equalityCheckerInstance
}

case class Person(name: String, email: String)

object PersonEqualityCheckers {

  implicit object PersonComparer extends EqualityChecker[Person] {
    def equals(a: Person, b: Person): Boolean =
      a.name == b.name && a.email == b.email
  }

  implicit object PersonEmailComparer extends EqualityChecker[Person] {
    def equals(a: Person, b: Person): Boolean =
      a.email == b.email
  }

  implicit object PersonNameComparer extends EqualityChecker[Person] {
    def equals(a: Person, b: Person): Boolean =
      a.name == b.name
  }

}

//PersonNameComparer.equals(Person("Dan", "dan@dan.com"), Person("Travis", "travis@travis.com"))

object Eq {
  def apply[T](a: T, b: T)(implicit equalityChecker: EqualityChecker[T]): Boolean =
    equalityChecker.equals(a, b)
}

import PersonEqualityCheckers.PersonComparer

Eq(Person("Dan", "dan@dan.com"), Person("Maddie", "maddie@maddie.com"))

//import PersonEqualityCheckers.PersonEmailComparer
Eq(Person("Dan", "dan@dan.com"), Person("Maddie", "dan@dan.com"))(PersonEqualityCheckers.PersonEmailComparer)

EqualityChecker[Person].equals(Person("Dan", "dan@dan.com"), Person("Maddie", "maddie@maddie.com"))