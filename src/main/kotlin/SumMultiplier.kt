fun findAndMultiply(targetSum: Int, numbers: List<Int>): Int {
    return 0
}

fun findSumMultiplier(targetSum: Int, numbers: List<Int>): Pair<Int, Int> {
    numbers.forEach { first ->
        numbers.forEach { second ->
            if (targetSum == first + second){
                return Pair(first, second)
            }
        }
    }
    return Pair(0, 0)
}