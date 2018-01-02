package day05

import java.io.FileReader

fun main(args: Array<String>) {
    var instructions = loadInstructions()
    println("Task one=" + jumpUntilExit(instructions, { it + 1 }))
    
    instructions = loadInstructions()
    println("Task two=" + jumpUntilExit(instructions, { if (it >= 3) it - 1 else it + 1 }))
}

fun loadInstructions(): MutableList<Int> {
    return FileReader("src/day05/input.txt").readLines().map { it.toInt() }.toMutableList()
}

fun jumpUntilExit(instructions: MutableList<Int>, nextVal: (Int) -> Int): Int {
    var pos = 0
    var jumps = 0
    while (pos < instructions.size) {
        val nextPos = pos + instructions[pos]
        instructions[pos] = nextVal(instructions[pos])
        pos = nextPos
        jumps++
    }
    return jumps
}