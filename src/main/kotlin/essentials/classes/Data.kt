package essentials.classes.data

fun main() {
    // Write your code here

    val john = Person(name = "John", age = 30)
    println(john)
    val jane = john.copy(name = "jane")

    val anotherJane = Person(name = "Jane", age = 30)

    println(jane)
    println(anotherJane)

    println(jane == anotherJane)
    println(jane === anotherJane)
    println(john.hashCode())
    println(jane.hashCode())
    println(anotherJane.hashCode())
    val(name,age) = jane

    println(name)
    println(age)
}

data class Person(val name: String, val age: Int)

/*
1. Create a data class for a Person with a name and age property
of types String and Int.
2. Create a Person instance with name “John” and age 30.
3. Print the Person instance.
4. Create a copy of the Person instance with name “Jane”.
5. Create a new Person instance with name “Jane” and age 30.
6. Check if the two Person instances are equal.
7. Print the hashCode of all the Person instances.
8. Destructure the Person instance created using copy (so the one
with name “Jane”) into two variables, and print values of those
variables.

 */