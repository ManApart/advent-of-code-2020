fun parsePassports(lines: List<String>): List<List<String>> {
    val results = mutableListOf<List<String>>()
    var passport = ""
    lines.forEach { line ->
        if (line.isBlank()){
            results.add(passport.toChunks())
            passport = ""
        } else {
            passport += " ${line.trim()}"
        }
    }
    results.add(passport.toChunks())
    return results

}

private fun String.toChunks() : List<String> {
    return this.trim().split(" ")
}