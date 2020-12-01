import java.io.File

fun main() {
//    println(findAndMultiply(2020, parseInput(1, 1)))
    println(findAndMultiply3(2020, parseInput(1, 1)))
}

private fun parseInput(day: Int, problem: Int): List<Int> {
    return File("./input/d${day}p$problem.txt").readLines().map { it.toInt() }
}