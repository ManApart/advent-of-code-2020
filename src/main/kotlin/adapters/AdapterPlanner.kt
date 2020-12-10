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
    return optionsToArrangementCount(count.first, count.second)
}

fun optionsToArrangementCount(optional: Int, partial: Int): Double {
    return 2.toDouble().pow(optional.toDouble()) + partial * 2
}


fun countOptionalNumbers(numbers: List<Int>): Pair<Int, Int> {
    var optionalCount = 0
    var partialCount = 0
    for (i in 0 until numbers.size - 1) {
        val inspected = numbers[i]
        val next = numbers[i + 1]
        val previous = numbers.getOrNull(i-1) ?: 0
        val beforeThat = numbers.getOrNull(i-2) ?: 0

        if (inspected - previous < 3 && next - previous < 3) {
            if (inspected - beforeThat < 3 && next - beforeThat < 3) {
                partialCount++
            } else {
                optionalCount++
            }
        }
    }
//    numbers.sorted().windowed(2, 1).forEach { window ->
//        val inspected = window[1]
//        if (inspected - last <= 3) {
//            //window.first is optional
//            optionalCount++
//        }
//        last = window.first()
//    }

    return Pair(optionalCount, partialCount)
}

fun Int.factorial(): Double {
    return if (this <= 1) {
        this.toDouble()
    } else {
        this.toDouble() * (this - 1).factorial()
    }
}