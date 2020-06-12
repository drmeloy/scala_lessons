package lesson23

case class Rational(numerator: Int, denominator: Int)

object Rational {
  implicit val ordering = Ordering.fromLessThan[Rational]((a, b) =>
    (a.numerator.toDouble / a.denominator.toDouble) < (b.numerator.toDouble / b.denominator.toDouble))
}

object Runner extends App {
  println(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted)
}