implicit class SuperString(s: String) {
  def numberOfVowels: Int = {
    val vowels = List('a', 'e', 'i', 'o', 'u')
    s.foldLeft(0)((acc, char) => {
      if (vowels.contains(char)) acc + 1
      else acc
    })
  }
}

implicit class SuperNumber(n: Int) {
  def isEven: Boolean = n % 2 == 0
}

"Travis Lee".numberOfVowels == 4

2.isEven == true