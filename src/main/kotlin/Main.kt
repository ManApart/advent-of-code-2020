import java.io.File

fun main() {
//    println(findAndMultiply(2020, 2, parseInputToNumbers(1, 1)))
//    println(findAndMultiply(2020, 3, parseInputToNumbers(1, 1)))
//    println(countValidPasswordsByLetterCount(parseInputToStrings(2, 1)))
//    println(countValidPasswordsByLetterPosition(parseInputToStrings(2, 1)))
//    println(countTrees(3, -1, Grid(parseInputToStrings(3, 1))))
    println(countTreesForMultiplePaths(day3Paths, Grid(parseInputToStrings(3, 1))))
}

private fun parseInputToNumbers(day: Int, problem: Int): List<Int> {
    return File("./input/d${day}p$problem.txt").readLines().map { it.toInt() }
}

private fun parseInputToStrings(day: Int, problem: Int): List<String> {
    return File("./input/d${day}p$problem.txt").readLines()
}