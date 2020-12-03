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
    fun countTreeThatIsStartedOn() {

    }

}