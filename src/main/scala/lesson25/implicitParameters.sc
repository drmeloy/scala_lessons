trait HtmlWriter[A] {
  def write(in: A): String

  def introduce(in: A): String
}

case class Person(name: String, email: String)

implicit object PersonWriter extends HtmlWriter[Person] {
  def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"

  def introduce(person: Person): String = person.name
}

object HTMLUtil {
  def htmlify[T](data: T)(implicit writer: HtmlWriter[T]): String = writer.write(data)
}

HTMLUtil.htmlify(Person("Dan", "dan@dan.com"))

// *******************************************************************************************

object HtmlWriter {
  def apply[T](implicit writer: HtmlWriter[T]): HtmlWriter[T] = writer
}

HtmlWriter[Person].write(Person("Random", "string"))
HtmlWriter[Person].introduce(Person("Random", "string"))
HtmlWriter[Person]
