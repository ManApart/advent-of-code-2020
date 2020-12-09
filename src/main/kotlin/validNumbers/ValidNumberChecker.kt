package validNumbers

fun isValidNumber(numberToCheck: Int, lookBack: Int, numbers: List<Int>): Boolean {
    val numbersToCheckAgainst = numbers.subList(numbers.size - lookBack, numbers.size)
    numbersToCheckAgainst.forEach { first ->
        numbersToCheckAgainst.forEach { second ->
            if (first != second && first + second == numberToCheck){
                return true
            }
        }
    }

    return false
}