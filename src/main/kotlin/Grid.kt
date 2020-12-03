class Grid(lines: List<String>) {
    private val map = buildMap(lines)

    private fun buildMap(lines: List<String>): Map<Int, Map<Int, Boolean>> {
        val map = mutableMapOf<Int, MutableMap<Int, Boolean>>()
        val totalLines = lines.size-1
        lines.forEachIndexed { lineNumber: Int, line: String ->
            val y = totalLines - lineNumber
            line.toCharArray().forEachIndexed { x: Int, char ->
                val isTree = (char == '#')
                map.putIfAbsent(x, mutableMapOf())
                map[x]!![y] = isTree
            }
        }

        return map
    }

    fun isTree(x: Int, y: Int): Boolean {
        return map[x]?.get(y) ?: false
    }
}