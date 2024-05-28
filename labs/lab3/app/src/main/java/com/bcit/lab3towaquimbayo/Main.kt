package com.bcit.lab3towaquimbayo

const val YEAR_1492 = 1492
const val YEAR_1601 = 1601
const val YEAR_1632 = 1632
const val YEAR_1838 = 1838
const val YEAR_2020 = 2020

/*
    Towa Quimbayo
    A01086002
 */
fun main() {
    val history = mapOf(
        YEAR_1492 to "Christopher Columbus discovers America",
        YEAR_1601 to "William Shakespeare writes Hamlet",
        YEAR_1632 to "Galileo discovered the acceleration of gravity on Earth to be 9.8m/s",
        YEAR_1838 to "Roughly 9.46 trillion km, the light-year is first used as a measurement in astronomy",
        YEAR_2020 to "Covid 19 Pandemic"
    )
    // Anonymous function
    val anonymous = fun(year: Int, fact: String) = println("$year=$fact")
    history.forEach { anonymous(it.key, it.value) }
    println()

    // function reference/::operator and passing function within a function
    printFact1(history, ::fact)
    printFact2(1, history, ::fact)

    // lambda function
    val getFact3: (event: Map<Int, String>) -> String = { it ->
        it.values.elementAt(2)
    }
    println(getFact3(history))

    // Pass a function as a parameter in the lambda function
    val printFact4: (getIndex: (event: Map<Int, String>) -> Int) -> Unit = {
        println(fact(history.entries.elementAt(it(history)).toPair()))
    }
    printFact4 { e -> getFact4Index(e) }

    printFact5(history)
}

fun fact(event: Pair<Int, String>) = event.second

fun printFact1(event: Map<Int, String>, fact: (Pair<Int, String>) -> String) {
    println(fact(event.entries.elementAt(0).toPair()))
}

fun printFact2(index: Int, event: Map<Int, String>, fact: (Pair<Int, String>) -> String) {
    println(fact(event.entries.elementAt(index).toPair()))
}

fun getFact4Index(event: Map<Int, String>): Int {
    return event.entries.indexOfFirst { it.key == YEAR_1838 }
}

fun printFact5(event: Map<Int, String>) = println(event.values.elementAt(4))
