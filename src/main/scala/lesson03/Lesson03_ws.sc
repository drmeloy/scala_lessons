lazy val a = {
  println("Blah")
  val b = 10 * 10
  b
}
a
a
val square = (num: Int) => num * num
val square2 = (num: Int) => num * num
square(10)
def myMap[T](numbers: List[T], fun: T => T) = {
  for (number <- numbers)
    yield fun(number)
}
val ages = List(4, 8, 10, 12)
val names = List("Jake", "John", "Mark")
myMap(names, (name: String) => name.toUpperCase())