package lesson06

import org.specs2.mutable.Specification

class TryingOutSpec2Test extends Specification {
  "Trying out Specs2" >> {
    "Square of 2 is 4" >> {
      TryingOutSpec2.square(2) === 4
    }
    "Square of 0 is 0" >> {
      TryingOutSpec2.square(0) === 0
    }
  }
}
