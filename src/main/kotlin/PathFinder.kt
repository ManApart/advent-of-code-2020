fun countTreesForMultiplePaths(steps: List<Pair<Int, Int>>, grid: Grid): Int {
    return steps.map { countTrees(it.first, it.second, grid) }.reduce{acc: Int, i: Int -> i * acc }
}

fun countTrees(stepX: Int, stepY: Int, grid: Grid): Int {
    var x = 0
    var y = grid.height-1
    var count = 0
    while (y >= 0) {
        if (grid.isTree(x, y)){
            count++
        }
        x += stepX
        y += stepY
    }

    return count
}