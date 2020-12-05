package binaryBoarding

fun parseBoardingPasses(lines: List<String>): List<List<Boolean>> {
    return lines.map { line ->
        line.map { it == 'B' || it == 'R' }
    }
}