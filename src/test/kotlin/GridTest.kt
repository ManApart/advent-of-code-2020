import org.testng.Assert.assertFalse
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GridTest {

    @Test
    fun parsingAndCoordinateSystem() {
        val grid = Grid(listOf(
            "..",
            ".#"
        ))

        assertFalse(grid.isTree(0,1))
        assertFalse(grid.isTree(1,1))
        assertFalse(grid.isTree(0,0))
        assertTrue(grid.isTree(1,0))
    }

    @Test
    fun parsingTrims() {
        val grid = Grid(listOf(
            ".. ",
            " .#"
        ))

        assertFalse(grid.isTree(0,1))
        assertFalse(grid.isTree(1,1))
        assertFalse(grid.isTree(0,0))
        assertTrue(grid.isTree(1,0))
    }

    @Test
    fun gridWraps() {
        val grid = Grid(listOf(
            "..",
            ".#"
        ))

        assertFalse(grid.isTree(0,0))
        assertTrue(grid.isTree(1,0))

        assertFalse(grid.isTree(2,0))
        assertTrue(grid.isTree(3,0))

        assertFalse(grid.isTree(4,0))
        assertTrue(grid.isTree(5,0))
    }

    @Test
    fun gridWrapsEdgeCase() {
        val grid = Grid(listOf(
            "#.#..##.#.##......#..#.#....#.#"
        ))

        assertTrue(grid.isTree(0,0))
        assertFalse(grid.isTree(29,0))
        assertTrue(grid.isTree(30,0))
        assertTrue(grid.isTree(31,0))
        assertFalse(grid.isTree(32,0))
    }

    @Test
    fun gridDimensions() {
        val grid = Grid(
            listOf(
                "..",
                ".#",
                ".#"
            )
        )
        assertEquals(2, grid.width)
        assertEquals(3, grid.height)

    }

}