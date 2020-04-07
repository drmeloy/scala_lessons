package lesson04

case class Cat(name: String, color: String, food: String)

object CatProject extends App {
  val cat0 = Cat("Oswald", "Black", "Milk")
  val cat1 = Cat("Henderson", "Ginger", "Chips")
  val cat2 = Cat("Quentin", "Tabby and white", "Curry")

  object ChipShop {
    def willServe(cat: Cat): Boolean =
      if (cat.food == "Chips") true else false
  }

  ChipShop.willServe(cat0)
  ChipShop.willServe(cat1)
  ChipShop.willServe(cat2)
}
