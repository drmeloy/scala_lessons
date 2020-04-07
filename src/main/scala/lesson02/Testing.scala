package lesson02

object Testing extends App {

  trait CanBark {
    def bark(): Unit = println("Bark!")
  }

  class Dog extends CanBark with CanSpeak

  trait CanSpeak {
    def speak(): Unit = println("omg you can talk")
  }

  val spot = new Dog
  spot.bark
  spot.speak
}
