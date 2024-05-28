package com.bcit.lab2towaquimbayo

import java.util.Locale

/*
    Towa Quimbayo
    A01086002
 */
fun main() {
    val sentence = "The quick brown fox went OVER the lazy dog cat horse".lowercase()

    // array and while loop
    val wordsArray = Array(sentence.split(" ").size) { "" }
    var index = 0
    while (index < wordsArray.size) {
        wordsArray[index] = sentence.split(" ")[index].replaceFirstChar{it.uppercaseChar()}
        index++
    }
    println("Words: ${wordsArray.contentToString()}")

    // mutableList and foreach loop
    val mutableList = mutableListOf<String>()
    wordsArray.forEach { mutableList.add(it.length.toString()) }
    println("Words lengths: $mutableList")
    mutableList.clear()

    // for loop
    for (word in wordsArray) {
        if (word.length == wordsArray.maxOf { it.length }) {
            if (mutableList.contains(word)) continue
            mutableList.add(word)
        }
    }
    println("Longest word(s): $mutableList")
    mutableList.clear()

    // for loop
    for (i in wordsArray.size - 1 downTo 0 ) {
        if (wordsArray[i].length == wordsArray.minOf { it.length }) {
            if (mutableList.contains(wordsArray[i])) continue
            mutableList.add(wordsArray[i])
        }
    }
    println("Shortest word(s): $mutableList")
}