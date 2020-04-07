package lesson04

sealed trait Employee

case class IndividualContributor(role: String) extends Employee

case class Manager(teamMembers: Int) extends Employee

case class Executive(title: String) extends Employee {
  def unapply(arg: Executive): String = s"$title (asshole)"
}

object Main extends App {
  val employee0 = IndividualContributor("Cool guy")
  val employee1 = Manager(40)
  val employee2 = Executive("CE Badass")

  def introduce(employee: Employee): Unit = employee match {
    case Manager(teamMembers) => println(s"Hi I'm a manager. I have $teamMembers team members.")
    case IndividualContributor(role) => println(s"Hi I'm an individual contributor. My role is $role.")
    case Executive(title) => println(s"I don't have time to talk to you. I am the $title.")
  }

  introduce(employee0)
  introduce(employee1)
  introduce(employee2)
}