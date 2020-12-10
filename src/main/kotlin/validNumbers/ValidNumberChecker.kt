package validNumbers

fun findFirstInvalidNumber(lookBack: Int, numbers: List<Long>): Long {
    return numbers.windowed(lookBack+1, 1).first { window ->
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