package lesson08

sealed trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

sealed trait Rectangular extends Shape {
  def sides: Int = 4
}

final case class Circle(radius: Double) extends Shape {
  val sides: Int = 1
  val perimeter: Double = math.Pi * 2 * radius
  val area: Double = math.Pi * math.pow(radius, 2)
}

final case class Rectangle(sideA: Double, sideB: Double) extends Rectangular {
  val perimeter: Double = 2 * sideA + 2 * sideB
  val area: Double = sideA * sideB
}

final case class Square(side: Double) extends Rectangular {
  val perimeter: Double = 4 * side
  val area: Double = math.pow(side, 2)
}