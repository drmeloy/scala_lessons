import java.util.Date

trait HtmlWriteable {
  def toHtml: String
}

/*
Problems:
1. only one way of rendering a person
	if we only want to show email addresses to logged in users, this won't work.
2. This pattern only works for classes we have defined ourselves
*/
final case class Person(name: String, email: String) extends HtmlWriteable {
  def toHtml = s"<span>$name &lt;$email&gt;</span>"
}

Person("John", "john@example.com").toHtml

// res: String = <span>John &lt;john@example.com&gt;</span>


//This is the typeclass
trait HtmlWriter[A] {
  def write(in: A): String
}


object PersonWriter extends HtmlWriter[Person] {
  def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
}

PersonWriter.write(Person("John", "john@example.com"))


object ObfuscatedPersonWriter extends HtmlWriter[Person] {
  def write(person: Person) =
    s"<span>${person.name} (${person.email.replaceAll("@", " at ")})</span>"
}

ObfuscatedPersonWriter.write(Person("John", "john@example.com"))

// res: String = John (john at example.com).


object DateWriter extends HtmlWriter[Date] {
  def write(in: Date) = s"<span>${in.toString}</span>"
}

DateWriter.write(new Date)
// res: String = <span>Sat Apr 05 16:01:58 BST 2014</span>”