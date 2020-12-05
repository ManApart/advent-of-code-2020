package binaryBoarding

fun parseBoardingPasses(lines: List<String>): List<String> {
    return lines.map { line ->
        line.map {
           if (it == 'B' || it == 'R') {
                1
            } else {
                0
            }
        }.joinToString("")
    }
}