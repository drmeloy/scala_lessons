case class Film(
                 name: String,
                 yearOfRelease: Int,
                 imdbRating: Double)

case class Director(
                     firstName: String,
                     lastName: String,
                     yearOfBirth: Int,
                     films: Seq[Film])

val memento = new Film("Memento", 2000, 8.5)
val darkKnight = new Film("Dark Knight", 2008, 9.0)
val inception = new Film("Inception", 2010, 8.8)

val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
val unforgiven = new Film("Unforgiven", 1992, 8.3)
val granTorino = new Film("Gran Torino", 2008, 8.2)
val invictus = new Film("Invictus", 2009, 7.4)

val predator = new Film("Predator", 1987, 7.9)
val dieHard = new Film("Die Hard", 1988, 8.3)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)

val eastwood = new Director("Clint", "Eastwood", 1930,
  Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))

val mcTiernan = new Director("John", "McTiernan", 1951,
  Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))

val nolan = new Director("Christopher", "Nolan", 1970,
  Seq(memento, darkKnight, inception))

val someGuy = new Director("Just", "Some Guy", 1990,
  Seq())

val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

val nolanFilms = for {
  film <- nolan.films
} yield film.name

nolan.films.map(_.name)

directors.flatMap(director => director.films.map(_.name))

for {
  director <- directors
  film <- director.films
} yield film.name

val earliestFilm: Option[Film] = mcTiernan.films.sortWith((a, b) => a.yearOfRelease < b.yearOfRelease).headOption

val filmSeq = for {
  director <- directors
  film <- director.films
} yield film

filmSeq.sortWith((a, b) => a.imdbRating > b.imdbRating)

filmSeq.map(_.imdbRating).reduce((a, b) => a + b) / filmSeq.length

val ratings = for {
  director <- directors
  film <- director.films
} yield film.imdbRating

ratings.reduce((a, b) => a + b) / ratings.length

filmSeq.foldLeft(0.0)((acc, curr) => acc + curr.imdbRating) / filmSeq.length

// following for every film: film name by director

directors.foreach(director => director.films.foreach(film => println(s"${film.name} by ${director.firstName} ${director.lastName}")))

for {
  director <- directors
  film <- director.films
} println(s"${film.name} by ${director.firstName} ${director.lastName}")

val films = for {
  director <- directors
  film <- director.films
} yield film

val earliestFilm: Option[Film] = films.sortWith((a, b) => a.yearOfRelease < b.yearOfRelease).headOption

List(1, 2, 3).zip(List(4, 5, 6))

val map = films.zipWithIndex.toMap
map.get(highPlainsDrifter)

map.map { case (film, index) => (film, index.toString) }

case class Person(name: String, age: Int)

val people = List(Person("Travis", 32), Person("Dan", 31))
people.map { case Person(_, age) => age }