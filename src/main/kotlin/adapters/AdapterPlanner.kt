package adapters

fun findProductOfVoltageCounts(numbers: List<Int>) : Int {
    val counts = findVoltageCounts(numbers)
    return (counts[1] ?: 0) * (counts[3] ?: 0)
}


fun findVoltageCounts(numbers: List<Int>) : Map<Int, Int> {
    val voltageCounts = mutableMapOf<Int, Int>()
    var last = 0

    numbers.sorted().forEach {
        val diff = it - last
        last = it
        voltageCounts.putIfAbsent(diff, 0)
        voltageCounts[diff] = voltageCounts[diff]!! + 1
    }
    voltageCounts[3] = voltageCounts[3]!! + 1

    return voltageCounts
}