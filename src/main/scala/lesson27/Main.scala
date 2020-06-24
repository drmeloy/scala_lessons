package lesson27

import java.util.Date

object Main extends App {

  import TypeInterfaceEnricherObject.JsUtil
  import JsWriterImplicits._

  val randomObject = JsObject(Map("foo" -> JsString("a"), "bar" -> JsString("b"), "baz" -> JsString("c")))
  println(randomObject.stringify)
  val visitors: Seq[Visitor] = Seq(Anonymous("001", new Date), User("003", "dave@xample.com", new Date))
  println(visitors.map(_.toJSON))
}
