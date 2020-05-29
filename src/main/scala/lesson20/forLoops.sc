val numbers = List(1, 2, 3)
val doubles = numbers.map(_ * 2)
val doublesFor = for {
  number <- numbers
} yield number * 2

val stringsy = for {
  number <- numbers
} yield number.toString

val otherNumbers = List(4, 5, 6)
for { // fors are syntatic sugar for flatmapping
  number <- numbers
  otherNumber <- otherNumbers
      } yield number * otherNumber
numbers.flatMap(number => otherNumbers.map(_ * number)) // same as line 12
val maybeInt0 = Some(2)
val maybeInt1 = Some(3)
val maybeInt2: Option[Int] = None
maybeInt0.flatMap(value => maybeInt1.map(_ * value))
for {
  value <- maybeInt0
  valuee <- maybeInt1
} yield value * valuee
for {
  value <- maybeInt0 // each line in for loop is a generator
  valuee <- maybeInt2
} yield value + valuee
val myMap = Map("Dan" -> 31, "Travis" -> 32)
myMap.get("Maddie")
myMap.get("Dan")