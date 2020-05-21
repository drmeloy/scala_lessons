sealed trait Animal

final case class Dog() extends Animal

case class InvariantShelter[T]()

//val invariantShelter: InvariantShelter[Animal] = InvariantShelter[Dog]()
case class CovariantShelter[+T]()

val covariantShelter: CovariantShelter[Animal] = CovariantShelter[Dog]()

case class ContravariantShelter[-T]()

val contravariantShelter: ContravariantShelter[Dog] = ContravariantShelter[Animal]()

