trait HtmlWriter[A] {
  def write(in: A): String
}

final case class Person(name: String, email: String)

implicit object PersonWriter extends HtmlWriter[Person] {
  def write(person: Person) = s"<span>${person.name} &lt;${person.email}&gt;</span>"
}

implicit class ToHtmlWriter[A](in: A) {
  def toHtml(implicit writer: HtmlWriter[A]) = writer.write(in)
}

// Without context bound
def pageTemplate[A](body: A)(implicit writer: HtmlWriter[A]): String = {
  val renderedBody = body.toHtml
  s"<html><head>...</head><body>${renderedBody}</body></html>"
}

val person = Person("Dan", "dan@dan.com")

pageTemplate(person)

// With context bound
def pageTemplateWithContextBounds[A: HtmlWriter](body: A): String = {
  val renderedBody = body.toHtml
  val writer = implicitly[HtmlWriter[A]]
  println("Implicitly htmlwriter, in case we need to use it explicitly: ", writer)
  s"<html><head>...</head><body>${renderedBody}</body></html>"
}

final case class User(name: String)

implicit val user = User("George")
implicitly[User]
pageTemplateWithContextBounds(person)