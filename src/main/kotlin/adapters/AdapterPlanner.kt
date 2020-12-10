package adapters

import kotlin.math.pow

fun findProductOfVoltageCounts(numbers: List<Int>): Int {
    val counts = findVoltageCounts(numbers)
    return (counts[1] ?: 0) * (counts[3] ?: 0)
}


fun findVoltageCounts(numbers: List<Int>): Map<Int, Int> {
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

fun countChainArrangementOptions(numbers: List<Int>): Double {
    val count = countOptionalNumbers(numbers)
//    return count.factorial()
    return 2.toDouble().pow(count.toDouble())
//    return count * 2.toDouble()
}

fun countOptionalNumbers(numbers: List<Int>): Int {
    var optionalCount = 0
    var last = 0
    numbers.sorted().windowed(2, 1).forEach { window ->
        if (window.last() - last <= 3) {
            //window.first is optional
            optionalCount++
        }
        last = window.first()
    }

    return optionalCount
}

fun Int.factorial(): Double {
    return if (this <= 1) {
        this.toDouble()
    } else {
        this.toDouble() * (this - 1).factorial()
    }
}