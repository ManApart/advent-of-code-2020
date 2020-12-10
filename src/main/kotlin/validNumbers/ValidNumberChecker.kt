package validNumbers

fun findFirstInvalidNumber(lookBack: Int, numbers: List<Int>): Int {
    for (i in lookBack..numbers.size) {
        val possible = numbers[i]
        val subsection = numbers.subList(i - lookBack, i)
        if (!isValidNumber(possible, subsection)) {
            return possible
        }
    }
    return -1
}

fun isValidNumber(numberToCheck: Int, numbers: List<Int>): Boolean {
    numbers.forEach { first ->
        numbers.forEach { second ->
            if (first != second && first + second == numberToCheck) {
                return true
            }
        }
    }

    return false
}