fun findNumber(absoluteMin: Int, absoluteMax: Int, pickLargerSteps: List<Boolean>): Int {
    var min = absoluteMin
    var max = absoluteMax + 1
    pickLargerSteps.forEach {
        val step = (max-min)/2
        if (it){
            min += step
        } else {
            max -= step
        }
    }
    return min
}