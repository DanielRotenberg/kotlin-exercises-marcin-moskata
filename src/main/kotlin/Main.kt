//fun main() {
//    println("Hello, World!")
//  /*  println(1 + 2 * 3) // ? 7
//    println(10 % 3) // ? 1
//    println(-1 % 3) // ? -1 -> there is no remained at all since it's not dividable
//    println(8.8 / 4) // ? 2 -> correct answer : 2.2 , reason 8.8 is already float so the result is cast to float
//    println(10 / 3) // ? 3
//    println(11.toFloat()) // ? 11.0
//    println(10.10.toInt()) // ? 10
//*/
//
//    /*
//    var a = 10
//    a += 5
//    println(a) // ? 15
//    a -= 3
//    println(a) // ? 12
//    a++
//    println(a) // ? 13
//    println(a++) // ? 13
//    println(a) // ? 14
//    println(--a) // ? 13
//    println(a) // ? 13
//
//    println(true && false) // ? false
//    println(true || false) // ? true
//    println(!!!!true) // ? true
//*/
//
//
//
/////*
//    println('A'.code) // 65
//    println('A' + 1) // ? A1 -> 66 , reason: it's char so it's translate to 66 as Unicode?
//    println('C'.code) // ? 67
//    println("A + B") // ? A + B
//    println("A" + "B") // ?AB
//    println("A" + 1) // ? A1
//    println("A" + 1 + 2) // ? A12
////    */
//}

private val magicNumbers = listOf(7, 13)
fun name(a: Any?): String = when (a) {
    null -> "Nothing"
    1, 2, 3 -> "Small number"
    in magicNumbers -> "Magic number"
    in 4..100 -> "Big number"
    is String -> "String: $a"
    is Int, is Long -> "Int or Long: $a"
    else -> "No idea, really"
}
fun main() {
    println(name(1)) // ?   Small number
    println(name("A")) // ? String: A
    println(name(null)) // ? Nothing
    println(name(5)) // ? Big number
    println(name(100)) // ? Big number
    println(name('A')) // ? No idea, really
    println(name("1")) // ? String: 1
    println(name(-1)) // ? Int or Long: -1
    println(name(101)) // ? Int or Long: 101
    println(name(1L)) // ? ???? Small number ??? -> Int or Long: 1 , reason: number 1 will match Int type not Long type
    println(name(7)) // ? Magic number
    println(name(3)) // ? Small number
    println(name(3.0)) // ? no idea, really
    println(name(100L)) // ?  Int or Long: 100.0 -> range over numbers by default will compare against Int type not Long type
}