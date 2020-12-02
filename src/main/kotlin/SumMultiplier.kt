fun findAndMultiply(targetSum: Int, numberToMatch: Int, numbers: List<Int>): Int {
    val matches = findSumMultiplier(targetSum, numberToMatch, numbers)
    if (matches.isEmpty()) {
        throw Exception("Could not find matches!")
    }
    return matches.reduce { acc: Int, i: Int -> i * acc }
}

fun findSumMultiplier(targetSum: Int, numberToMatch: Int, numbers: List<Int>): List<Int> {
    numbers.forEach { first ->
        val possible = findSumMultiplierRecursive(targetSum, numberToMatch - 1, listOf(first), numbers)
        if (possible.isNotEmpty()){
            return possible
        }
    }
    return listOf()
}

private fun findSumMultiplierRecursive(targetSum: Int, depth: Int, matches: List<Int>, numbers: List<Int>): List<Int> {
    if (depth == 0) {
        if (targetSum == matches.sum()) {
            return matches
        }
    } else {
        //The sublist subtracts out the numbers we've already added to matches, so that we don't use the same number twice
        return numbers.subList(matches.size, numbers.size).map {
            findSumMultiplierRecursive(targetSum, depth - 1, matches + listOf(it), numbers)
        }.firstOrNull() { it.isNotEmpty() } ?: listOf()
    }
    return listOf()
}