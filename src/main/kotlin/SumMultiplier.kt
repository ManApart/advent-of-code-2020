fun findAndMultiply(targetSum: Int, numbers: List<Int>): Int {
    val matches = findSumMultiplier(targetSum, numbers)
    return matches.reduce {acc: Int, i: Int -> i * acc }
}

fun findSumMultiplier(targetSum: Int, numbers: List<Int>): List<Int> {
    numbers.forEach { first ->
        numbers.forEach { second ->
            if (targetSum == first + second) {
                return listOf(first, second)
            }
        }
    }
    return listOf()
}