import scala.math.Ordering

val minOrdering = Ordering.fromLessThan[Int](_ < _)
val maxOrdering = Ordering.fromLessThan[Int](_ > _)
List(3, 4, 2).sorted(minOrdering)
List(3, 4, 2).sorted(maxOrdering)

case class Person(name: String, age: Int)

implicit val personAgeOrdering = Ordering.fromLessThan[Person](_.age < _.age)
List(Person("Dan", 31), Person("Travis", 32), Person("Maddie", 29)).sorted

implicit val years = 1000
def printAge(implicit age: Int) = println(age)
printAge

3.0 / 2.0