val numbers = List(1, 2, 3)
numbers :+ 4 // append to list
5 +: numbers // prepend to list
numbers.length
numbers.size // like .length
val maybeInt = Some(1)
if (maybeInt.isDefined) "It's there!"
val maybeIntt = None
if (maybeIntt.isDefined) "Where is it?"
val chars = List('b', 'a', 'd')
chars.mkString
