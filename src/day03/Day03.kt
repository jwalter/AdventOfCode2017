package day03

val input: Int = 347991

enum class Direction(val x: Int, val y: Int) {
    RIGHT(1, 0), UP(0, 1),LEFT(-1, 0), DOWN(0, -1)
}

fun main(args: Array<String>) {
    println("Task oneB=" + taskOneB(input))
    println("Task two=" + taskTwo(input))
}

fun taskOneB(input: Int): Int {
    var cellValue = 1
    var pos = Pair(0, 0)
    var dir = Direction.RIGHT
    while (cellValue < input) {
        dir = nextDir(dir, pos)
        pos = move(pos, dir)
        cellValue++
    }
    return Math.abs(pos.first) + Math.abs(pos.second)
}

fun nextDir(dir: Direction, pos: Pair<Int, Int>): Direction {
    var doTurn = Math.abs(pos.first) == Math.abs(pos.second)
    if (pos.first >= 0 && pos.second <= 0) {
        doTurn = pos.first + pos.second == 1
    }
    val dirs = Direction.values()
    return if (doTurn) dirs[(dirs.indexOf(dir) + 1) % 4] else dir
}

fun move(pos: Pair<Int, Int>, dir: Direction): Pair<Int, Int> {
    return Pair(pos.first + dir.x, pos.second + dir.y)
}

fun taskTwo(input: Int): Int {
    var cellValue = 1
    var pos = Pair(0, 0)
    var dir = Direction.RIGHT
    val cells = HashMap<Pair<Int, Int>, Int>()
    while (cellValue <= input) {
        cells.put(pos, cellValue)
        dir = nextDir(dir, pos)
        pos = move(pos, dir)
        cellValue = nextValue(pos, cells)
    }
    return cellValue
}

fun nextValue(pos: Pair<Int, Int>, cells: Map<Pair<Int, Int>, Int>): Int {
    var result = 0
    for (x in -1..1) {
        for (y in -1..1) {
            val neighbour = Pair(pos.first + x, pos.second + y)
            if ((x !=0 || y!= 0) && cells.containsKey(neighbour)) {
                result += cells[neighbour]!!
            }
        }
    }
    return result
}
