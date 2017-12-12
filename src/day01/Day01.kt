package day01

import java.io.FileReader

fun main(args: Array<String>) {
    val input: String = FileReader("src/day01/input.txt").readText()
    println("Task one=" + taskOne(input))
    println("Task two=" + taskTwo(input))
}

fun taskOne(value: String): Int {
    var prev = value.last()
    var result = 0
    for (i in value.indices) {
        if (prev == value[i]) result += Integer.parseInt(value[i].toString())
        prev = value[i]
    }
    return result
}

fun taskTwo(value: String): Int {
    var result = 0
    for ((i, c) in value.withIndex()) {
        var buddyPos = i + value.length / 2
        if (buddyPos >= value.length) buddyPos -= value.length
        if (c == value[buddyPos]) result += Integer.parseInt(c.toString())
    }
    return result
}