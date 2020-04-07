package lesson02

object StackOverflower {
  def infiniteMethod(number: Int): Int = {
    number + infiniteMethod(number + 1)
  }

  infiniteMethod(1)
}
