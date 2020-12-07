package luggage

fun parseLuggage(lines: List<String>): List<Bag> {
    return lines.map { line ->
        val parts = line.split("bags contain")
        val id = parts[0].trim()
        val contents = parseContents(parts)

        Bag(id, contents)
    }
}

private fun parseContents(parts: List<String>): Map<String, Int> {
    val contentsPieces = parts.last()
        .replace(".", "")
        .replace("bags", "")
        .replace("bag", "")
        .split(",")

    return contentsPieces.associate {
        val words = it.trim().split(" ")
        val count = words.first().toInt()
        val id = words.subList(1, words.size).joinToString(" ")
        id to count
    }
}