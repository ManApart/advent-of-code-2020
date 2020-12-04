fun parsePassports(lines: List<String>): List<List<String>> {
    return listOf(lines.joinToString("\n ").split(" "))
}