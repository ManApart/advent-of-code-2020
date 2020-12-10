package adapters

fun findProductOfVoltageCounts(numbers: List<Int>) : Int {
    return 0
}


fun findVoltageCounts(numbers: List<Int>) : Map<Int, Int> {
    val voltageCounts = mutableMapOf<Int, Int>()
    numbers.sorted().windowed(2,1) {
        val diff = it.last() - it.first()
        voltageCounts.putIfAbsent(diff, 0)
        voltageCounts[diff] = voltageCounts[diff]!! + 1
    }

    return voltageCounts
}