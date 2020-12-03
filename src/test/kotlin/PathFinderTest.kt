import org.testng.annotations.Test
import kotlin.test.assertEquals

class PathFinderTest {
    private val input = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent().split("\n")

    @Test
    fun countTrees() {
        val grid = Grid(input)
        val result = countTrees(3, -1, grid)

        assertEquals(7, result)
    }

    @Test
    fun countTreesMultiplePaths() {
        val grid = Grid(input)
        val steps = listOf(
            Pair(1, -1),
            Pair(3, -1),
            Pair(5, -1),
            Pair(7, -1),
            Pair(1, -2),
        )
        val result = countTreesForMultiplePaths(steps, grid)

        assertEquals(336, result)
    }

}