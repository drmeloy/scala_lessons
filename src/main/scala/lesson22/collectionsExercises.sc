def divide(numerator: Int, denominator: Int): Option[Int] = {
  if (denominator == 0) None
  else Some(numerator / denominator)
}

def divideOptions(option1: Option[Int], option2: Option[Int]): Option[Int] = {
  for {
    a <- option1
    b <- option2
    c <- divide(a, b)
  } yield c
}

divideOptions(Some(4), Some(2))
divideOptions(Some(0), Some(2))
divideOptions(Some(4), Some(0))
divideOptions(Some(4), None)
divideOptions(None, Some(2))

for {
  (a, b) <- List(1, 2, 3).zip(List(4, 5, 6))
} yield a + b

val people = Set(
  "Alice",
  "Bob",
  "Charlie",
  "Derek",
  "Edith",
  "Fred")

val ages = Map(
  "Alice" -> 20,
  "Bob" -> 30,
  "Charlie" -> 50,
  "Derek" -> 40,
  "Edith" -> 10,
  "Fred" -> 60,
  "Dan" -> 100)

val favoriteColors = Map(
  "Bob" -> "green",
  "Derek" -> "magenta",
  "Fred" -> "yellow")

val favoriteLolcats = Map(
  "Alice" -> "Long Cat",
  "Charlie" -> "Ceiling Cat",
  "Edith" -> "Cloud Cat")

def favoriteColor(name: String): Option[String] = favoriteColors.get(name)
def favoriteColor2(name: String): String = favoriteColors.get(name).getOrElse("Dark beige")

favoriteColor2("Bob")
favoriteColor("Alice")

def printColors(map: Map[String, String]): Unit =
  map.foreach { case (_, color) => println(color) }

printColors(favoriteColors)

def lookup[A](name: String, map: Map[String, A]): Option[A] =
  map.get(name)

lookup("Fred", ages)
lookup("Fred", favoriteColors)
lookup("Edith", favoriteLolcats)

def findOldestPersonsFavoriteColor: Option[String] = {
  val oldestName = for {
    (name, age) <- ages.toList.sortWith { case ((_, b), (_, d)) => b > d }.headOption
  } yield name
  oldestName.flatMap(favoriteColors.get(_))
}

val myNone: Option[Int] = None
myNone.map(value => value + 1)
val mySome: Option[Int] = Some(2)
mySome.map(value => value + 1)

findOldestPersonsFavoriteColor