package customs

fun parseCustoms(lines: List<String>) : List<List<String>> {
    val results = mutableListOf<List<String>>()
    var group = mutableListOf<String>()
    lines.forEach { line ->
        if (line.isBlank()) {
            if (group.isNotEmpty()){
                results.add(group)
            }
            group = mutableListOf()
        } else {
            group.add(line.trim())
        }
    }
    if (group.isNotEmpty()){
        results.add(group)
    }

    return results
}