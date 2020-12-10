package validNumbers

fun findFirstInvalidNumber(lookBack: Int, numbers: List<Long>): Long {
    return numbers.windowed(lookBack + 1, 1).first { window ->
        val possible = window.last()
        !isValidNumber(possible, window.take(lookBack))
    }.last()
}

fun isValidNumber(numberToCheck: Long, numbers: List<Long>): Boolean {
    numbers.forEach { first ->
        numbers.forEach { second ->
            if (first != second && first + second == numberToCheck) {
                return true
            }
        }
    }

    return false
}

fun findAnyContiguousSum(sumToFind: Long, numbers: List<Long>): IntRange {
    for (i in 0..numbers.size) {
        val sum = findContiguousSum(sumToFind, numbers.subList(i, numbers.size))
        if (sum != null) {
            return (sum.first + i)..(sum.last + i)
        }
    }
    return 0..0
}

private fun findContiguousSum(sumToFind: Long, numbers: List<Long>): IntRange? {
    var sum = 0L
    var start = 0
    var end = 0
    numbers.forEachIndexed { i, number ->
        when {
            sum == sumToFind -> {
                return start..end
            }
            sum > sumToFind -> {
                sum = 0
                start = i
            }
            else -> {
                sum += number
                end = i
            }
        }
    }
    if (sum == sumToFind){
        return start..end
    }

    return null
}