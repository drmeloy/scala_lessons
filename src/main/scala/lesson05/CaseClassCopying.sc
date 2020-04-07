case class Person(name: String, var age: Int)

case class Email(to: Person, body: String)

val dan = Person("Dan", 31)
val email0 = Email(dan, "Wussup!")
val email1 = email0.copy(body = "Oh hey")
email0.to.age = 64
email1.to.age