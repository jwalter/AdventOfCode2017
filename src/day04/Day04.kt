package day04

import java.io.FileReader

fun main(args: Array<String>) {
    val input: List<String> = FileReader("src/day04/input.txt").readLines()
    println("Task one=" + taskOne(input))
    println("Task two=" + taskTwo(input))
}

fun taskOne(passphrases: List<String>): Int {
    return passphrases.count { it.split(" ").toSet().joinToString(" ").length == it.length }
}

fun taskTwo(passphrases: List<String>): Int {
    return passphrases.count { it.split(" ").map { sort(it) }.toSet().joinToString(" ").length == it.length }
}

fun sort(it: String) = it.toList().sorted().joinToString("")