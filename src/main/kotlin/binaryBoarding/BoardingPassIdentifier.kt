package binaryBoarding

//fun findGapId(lines: List<String>) : Int {
//    return parseBoardingPasses(lines).map { identifySeatID(it) }.findGapID()
//}

fun List<Int>.findGapID(): Int {
    var last = this.first()

    this.sorted().forEach {
        if (it == last + 2) {
            return it - 1
        }
        last = it
    }
    return 0
}

fun findLargestSeatID(pickLargerSteps: List<List<Boolean>>): Int {
    return pickLargerSteps.map { identifySeatID(it) }.maxOrNull() ?: 0
}

fun identifySeatID(pickLargerSteps: List<Boolean>): Int {
    val row = findNumber(0, 127, pickLargerSteps.subList(0, 7))
    val column = findNumber(0, 7, pickLargerSteps.subList(7, 10))

    return row * 8 + column
}

fun findNumber(absoluteMin: Int, absoluteMax: Int, pickLargerSteps: List<Boolean>): Int {
    var min = absoluteMin
    var max = absoluteMax + 1
    pickLargerSteps.forEach {
        val step = (max - min) / 2
        if (it) {
            min += step
        } else {
            max -= step
        }
    }
    return min
}