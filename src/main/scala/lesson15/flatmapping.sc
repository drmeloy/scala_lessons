val names = List("Jake", "John", "Mike")
val nestedNames = List("Jake", List("John", "Mike"))
names.flatMap(_.toCharArray)
names.map(_.toCharArray).flatten
nestedNames.flatMap(_.toString)