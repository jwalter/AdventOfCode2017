package day02

import java.io.FileReader
import java.math.BigDecimal

fun main(args: Array<String>) {
    val input: List<String> = FileReader("src/day02/input.txt").readLines()
    println("Task one=" + taskOne(input))
    println("Task two=" + taskTwo(input))
}

fun taskOne(input: List<String>): Int {
    val inputNumbers: List<List<Int>> = toNumbers(input)
    val diffs: List<Int> = inputNumbers.map { it.max()!! - it.min()!! }
    return diffs.sum()
}

private fun toNumbers(input: List<String>) =
        input.map { it.split("\t").map { it.toInt() } }

fun taskTwo(input: List<String>): Int {
    val inputNumbers: List<List<Int>> = toNumbers(input)
    val sum = inputNumbers.sumBy { it -> division(it) }
    return sum
}

fun division(it: List<Int>): Int {
    val num: Int = it.take(1).first()
    val tail = it.takeLast(it.size - 1)
    val evenDivisor: Int? = tail.firstOrNull { num % it == 0 || it % num == 0 }
    if (evenDivisor != null) {
        if (num % evenDivisor == 0) return num / evenDivisor
        else return  evenDivisor / num
    } else {
        return division(tail)
    }
}
