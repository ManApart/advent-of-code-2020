package luggage

fun parseLuggage(lines: List<String>): List<Bag> {
    return lines.map { line ->
        val parts = line.split("bags contain")
        val id = parts[0].trim()
        val contents = parseContents(parts.last())

        Bag(id, contents)
    }
}

private fun parseContents(contentsString: String): Map<String, Int> {
    if (contentsString.trim() == "no other bags."){
        return mapOf()
    }
    val contentsPieces = contentsString
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