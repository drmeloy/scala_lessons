def multiply(x: Int)(y: Int): Int = x * y
def double(x: Int): Int = multiply(2)(x)
def doubleTwo: Int => Int = multiply(2)(_)
doubleTwo(8)