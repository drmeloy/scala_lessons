package lesson27

import java.util.Date

object JsWriterImplicits {

  import TypeInterfaceEnricherObject.JsUtil

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
      "id" -> anon.id.toJSON(StringWriter),
      "createdAt" -> anon.createdAt.toJSON(DateWriter)))
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
