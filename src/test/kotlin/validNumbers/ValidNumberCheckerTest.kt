package validNumbers

import org.testng.Assert.assertTrue
import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test
import kotlin.test.assertFalse

class ValidNumberCheckerTest {

    @Test
    fun validValue() {
        val input = listOf(1,2,3)

        assertTrue(isValidNumber(4, input))
        assertTrue(isValidNumber(5, input))
    }

    @Test
    fun validValueWithDifferentLookback() {
        val input = listOf(2,3)

        assertTrue(isValidNumber(5, input))
    }

    @Test
    fun invalidValues() {
        val input = listOf(1,2,3)

        assertFalse(isValidNumber(6, input))
        assertFalse(isValidNumber(2, input), "Can't use duplicate numbers")
    }

    @Test
    fun invalidValuesWithDifferentLookback() {
        val input = listOf(2,3)

        assertFalse(isValidNumber(4, input))
    }

    @Test
    fun findInvalidCase() {
        val input = listOf(0,2,3,4)

        assertEquals(4, findFirstInvalidNumber(3,  input))
    }

    @Test
    fun part1ExampleTest() {
        val input = """
            35
            20
            15
            25
            47
            40
            62
            55
            65
            95
            102
            117
            150
            182
            127
            219
            299
            277
            309
            576
        """.trimIndent().split("\n").map { it.toInt() }

        assertEquals(127, findFirstInvalidNumber(5,  input))
    }


}