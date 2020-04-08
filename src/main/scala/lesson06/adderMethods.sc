case class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}

case class Adder2(amount: Int) {
  def apply(in: Int): Adder2 = Adder2(amount + in)
}

case class Counter(count: Int) {
  def dec: Counter = Counter(count - 1)

  def inc: Counter = Counter(count + 1)

  def adjust(adder: Adder): Counter = Counter(adder(count))
}

val add3 = Adder(3)
add3(add3(2))

val add5 = Adder2(5)
add5(5)(5)(5).amount


def createAdder( // Method name
                 amount: Int): // Method parameters
Int => Int = // Return type
  (x: Int) => amount + x // Anonymous function

val add6 = createAdder(6)
add6(6)

