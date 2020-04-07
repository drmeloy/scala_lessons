def erroneousMethod = throw new Exception("This is your error message")
def possiblyErroneousMethod(x: Int) = if (false) 1 else erroneousMethod
def produceNull = if (false) "Cool" else null
1 == "1"
"Any string" == null
1 == 1.0
"a" == 'a'
1f == 1.0