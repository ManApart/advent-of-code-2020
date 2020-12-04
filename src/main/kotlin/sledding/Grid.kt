package sledding

class Grid(lines: List<String>) {
    private val map = buildMap(lines)
    val width = (map.keys.maxOrNull() ?: 0) + 1
    val height = (map.values.flatMap { it.keys }.maxOrNull() ?: 0) + 1

    private fun buildMap(lines: List<String>): Map<Int, Map<Int, Boolean>> {
        val map = mutableMapOf<Int, MutableMap<Int, Boolean>>()
        val totalLines = lines.size-1
        lines.forEachIndexed { lineNumber: Int, line: String ->
            val y = totalLines - lineNumber
            line.trim().toCharArray().forEachIndexed { x: Int, char ->
                val isTree = (char == '#')
                map.putIfAbsent(x, mutableMapOf())
                map[x]!![y] = isTree
            }
        }

        return map
    }

    fun isTree(x: Int, y: Int): Boolean {
        val wrappedX = if (x >= width){
            x % width
        } else {
            x
        }
        return map[wrappedX]?.get(y) ?: false
    }
}