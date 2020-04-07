package lesson04

case class Film(director: String)

object Dad extends App {
  def rate(film: Film): Double =
    film match {
      case Film("Clint Eastwood") => 10.0
      case Film("John McTiernan") => 7.0
      case _ => 3.0
    }

  println(Dad.rate(Film("Clint Eastwood")))
  println(Dad.rate(Film("John McTiernan")))
  println(Dad.rate(Film("Dan Meloy")))
}


