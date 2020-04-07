package lesson01

object Main extends App {
  println("What's up Scala")

  def sayHello(name: String): String = {
    s"Hello ${capitalize(name)}"
  }

  val dan = new Person("Dan", 31)

  def capitalize(input: String) = input.toUpperCase

  val output: Unit = println(sayHello(dan.name))
  println(output)
}

class Person(val name: String, age: Int)
