package lesson27

import java.util.Date

sealed trait JsValue {
  def stringify: String
}

// Algebraic data type pattern
final case class JsObject(values: Map[String, JsValue]) extends JsValue {
  def stringify = values
    .map { case (name, value) => s""""$name":""" + value.stringify }
    .mkString("{", ",", "}")
}

final case class JsString(value: String) extends JsValue {
  def stringify = "\"" + value.replaceAll("\\|\"", "\\\\$1") + "\""
}

object Main extends App {

  import NewObject.JsUtil

  val randomObject = JsObject(Map("foo" -> JsString("a"), "bar" -> JsString("b"), "baz" -> JsString("c")))
  println(randomObject.stringify)
  val visitors: Seq[Visitor] = Seq(Anonymous("001", new Date), User("003", "dave@xample.com", new Date))
  println(visitors.map(_.toJSON(JsWriter.VisitorJsWriter)))
}

trait JsWriter[A] {
  def write(in: A): JsValue
}

object JsWriter {

  import NewObject.JsUtil

  implicit object VisitorJsWriter extends JsWriter[Visitor] {
    def write(visitor: Visitor): JsValue = {
      visitor match {
        case anon: Anonymous => AnonymousJsWriter.write(anon)
        case user: User => UserJsWriter.write(user)
      }
    }
  }

  implicit object AnonymousJsWriter extends JsWriter[Anonymous] {
    def write(anon: Anonymous): JsValue = JsObject(Map[String, JsValue](
      "id" -> anon.id.toJSON,
      "createdAt" -> anon.createdAt.toJSON))
  }

  implicit object UserJsWriter extends JsWriter[User] {
    def write(user: User): JsValue = JsObject(Map(
      "id" -> user.id.toJSON,
      "email" -> user.email.toJSON,
      "createdAt" -> user.createdAt.toJSON))
  }

  implicit object StringWriter extends JsWriter[String] {
    def write(string: String): JsValue = JsString(string)
  }

  implicit object DateWriter extends JsWriter[Date] {
    def write(date: Date): JsValue = JsString(date.toString)
  }

}

object NewObject {

  implicit class JsUtil[A](in: A) {
    def toJSON[A](implicit writer: JsWriter[A]): JsValue = writer.write(in)
  }

}


