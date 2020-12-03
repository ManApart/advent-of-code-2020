import org.testng.Assert.assertFalse
import org.testng.annotations.Test
import kotlin.test.assertTrue

class GridTest {

    @Test
    fun parsingAndCoordinateSystem() {
        val input = listOf(
            "..",
            ".#"
        )

        val grid = Grid(input)

        assertFalse(grid.isTree(0,1))
        assertFalse(grid.isTree(1,1))
        assertFalse(grid.isTree(0,0))
        assertTrue(grid.isTree(1,0))

    }
}