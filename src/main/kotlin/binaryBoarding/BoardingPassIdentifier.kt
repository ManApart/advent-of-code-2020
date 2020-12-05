package binaryBoarding

fun findGapId(lines: List<String>) : Int {
    return parseBoardingPasses(lines).map { identifySeatID(it) }.findGapInList()
}

fun List<Int>.findGapInList(): Int {
    var last = this.first()

    this.sorted().forEach {
        if (it == last + 2) {
            return it - 1
        }
        last = it
    }
    return 0
}

fun findLargestSeatID(pickLargerSteps: List<String>): Int {
    return pickLargerSteps.map { identifySeatID(it) }.maxOrNull() ?: 0
}

fun identifySeatID(pickLargerSteps: String): Int {
    val row = Integer.parseInt(pickLargerSteps.substring(0, 7), 2)
    val column = Integer.parseInt(pickLargerSteps.substring(7, 10), 2)

    return row * 8 + column
}