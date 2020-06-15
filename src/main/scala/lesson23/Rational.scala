package lesson23

case class Rational(numerator: Int, denominator: Int)

// This is the companion object to our data type Rational
object Rational {

  // This is our type class instance: Ordering[Rational]
  implicit val rationalOrdering: Ordering[Rational] = Ordering.fromLessThan[Rational]((a, b) =>
    (a.numerator.toDouble / a.denominator.toDouble) < (b.numerator.toDouble / b.denominator.toDouble))
}

object Runner extends App {

  // This local scope has priority over the companion object scope, so this Ordering instance will be used implicitly
  implicit val reverseRationalOrdering = Ordering.fromLessThan[Rational]((a, b) =>
    (a.numerator.toDouble / a.denominator.toDouble) > (b.numerator.toDouble / b.denominator.toDouble))
  println(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted)
}