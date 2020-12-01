fun findAndMultiply(targetSum: Int, numbers: List<Int>): Int {
    val matches = findSumMultiplier(targetSum, numbers)
    return matches.first * matches.second
}

fun findSumMultiplier(targetSum: Int, numbers: List<Int>): Pair<Int, Int> {
    numbers.forEach { first ->
        numbers.forEach { second ->
            if (targetSum == first + second) {
                return Pair(first, second)
            }
        }
    }
    return Pair(0, 0)
}