package lesson02

object StackCaller {
  def method1(): Unit = {
    val number = 1
    method2
  }

  def method2(): Unit = {
    val number = 2
    method3
  }

  def method3(): Unit = {
    val number = 3
    println("This is a test")
  }

  method1
}
