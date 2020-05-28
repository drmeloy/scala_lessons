val numbers = Seq(1, 2, 3, 1, 2)
numbers(0)
val empty = Seq()
val empty1 = Seq[Nothing]()
//empty(0)
//empty.head
numbers.head
numbers.tail.tail.tail
Nil == empty
if (empty != Nil) empty.head
empty.headOption match {
  case Some(value) => value
  case None => Nil
}
numbers.contains(2)
numbers.find(_ > 3)
numbers.filter(_ > 1)
val names = List("Steve", "Tom", "John", "Bob")
names.sortWith((a, b) => a.compareTo(b) < 0)
numbers.sortWith((a, b) => a > b)
numbers.sortWith(_ < _)
