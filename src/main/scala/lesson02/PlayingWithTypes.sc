val example: AnyVal = 1
Int.MaxValue
Short.MaxValue
Long.MaxValue
Float.MaxValue
Double.MaxValue
val example1 = 10
val example2: Float = 10.0F
10.0 + 5
val example3: AnyRef = "AnyRef"

class MySuperClass {
  def sayGoodbye = println("Bye!")
}

class MySubClass extends MySuperClass {
  def sayHello = println("Hello")
}

val mySuperObject = new MySuperClass
val mySubObject = new MySubClass
mySubObject.sayGoodbye
val myNull = null

trait CanBark {
  def bark = println("Bark!")
}

class Dog extends CanBark with CanSpeak

trait CanSpeak {
  def speak = println("omg you can talk")
}

val spot = new Dog
spot.bark
spot.speak