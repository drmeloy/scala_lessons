package lesson26

// Type class!
trait HtmlWriter[A] {
  def write(in: A): String
}

object HtmlWriter {

  // Interface (types) enricher! Adds toHtml method to any type
  implicit class HTMLOps[T](obj: T) {
    def toHtml(implicit writer: HtmlWriter[T]): String =
      writer.write(obj)
  }

  // Type class instance
  implicit object PersonWriter extends HtmlWriter[Person2] {
    def write(person: Person2) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
  }

  // Type class instance
  implicit object AccountWriter extends HtmlWriter[Account] {
    def write(account: Account) = s"<span>${account.username}</span>"
  }

}

case class Person2(name: String, email: String)

case class Account(username: String)

//object Main extends App {
//  import HtmlWriter._
//  println(Account("RolandOfGilead").toHtml)
//  println(Person2("Jake", "jake@jake.com").toHtml)
//}
//
