package lesson07

import java.util.Date

sealed trait Visitor {
  def id: String

  def createdAt: Date

  def isOlderThan(that: Visitor): Boolean = this.createdAt.before(that.createdAt)
}

object Visitor {
  def older(visitorA: Visitor, visitorB: Visitor): Visitor = {
    if (visitorA.createdAt.before(visitorB.createdAt)) visitorA else visitorB
  }
}

final case class Anonymous(id: String, createdAt: Date) extends Visitor

final case class Administrator(id: String, createdAt: Date) extends Visitor

final case class User(id: String, email: String, createdAt: Date) extends Visitor

object Main extends App() {
  val visitor0 = User("1234", "email@email.com", new Date())
  val visitor1 = Administrator("1234", new Date())
  VisitorLogger.logVisitor(visitor1)

  println(Visitor.older(visitor0, visitor1))
  println(visitor0.isOlderThan(visitor1))
}

object VisitorLogger {
  def logVisitor(visitor: Visitor): Unit = visitor match {
    case User(id, _, _) => println(s"User $id visited site.")
    case Anonymous(id, _) => println(s"Anonymous $id visited site.")
    case Administrator(id, _) => println(s"Administrator $id visited site.")
  }
}
