import java.io.File

fun main() {
    val input = File("./input/d1p1.txt").readLines().map { it.toInt() }

    println(findAndMultiply(2020, input))
}