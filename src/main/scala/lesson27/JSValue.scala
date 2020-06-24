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

trait JsWriter[A] {
  def write(in: A): JsValue
}

object TypeInterfaceEnricherObject {

  implicit class JsUtil[A](in: A) {
    def toJSON(implicit writer: JsWriter[A]): JsValue = writer.write(in)
  }

}


