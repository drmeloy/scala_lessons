package lesson04

object Blah extends App {
  val person1 = Person("Mark", 30)
  val person2 = Person("Mark", 30)
  val employee3 = new Person2("Mark", 30)
  val employee4 = new Person2("Mark", 30)
  println(person1)
  println(employee3)
  println(person1 == person2)
  println(employee3 == employee4)
}

case class Person(val name: String, age: Int) {
  def sayName: Unit = println(s"My name is $name")
}

object Person {

}

class Person2(name: String, salary: Int)

