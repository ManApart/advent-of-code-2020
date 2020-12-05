package binaryBoarding

import kotlin.test.Test
import kotlin.test.assertEquals

class BoardingParserTest {

    @Test
    fun parseSingleLine() {
        val input = listOf("FBFBBFFRLR")
        val results = parseBoardingPasses(input)

        assertEquals(1, results.size)
        assertEquals(10, results.first().length)
        assertEquals(listOf("0101100101"), results)
    }

    @Test
    fun parseMultipleLines() {
        val input = """
            BFFFBBFRRR
            FFFBBBFRRR
            BBFFBBFRLL
        """.trimIndent().split("\n")

        val results = parseBoardingPasses(input)

        assertEquals(3, results.size)
        assertEquals(10, results[0].length)
        assertEquals(10, results[1].length)
        assertEquals(10, results[2].length)
        assertEquals("1000110111", results[0])
        assertEquals("0001110111", results[1])
        assertEquals("1100110100", results[2])

    }


}