package binaryBoarding

import kotlin.test.Test
import kotlin.test.assertEquals

class BoardingParser {

    @Test
    fun parseSingleLine() {
        val input = listOf("FBFBBFFRLR")
        val results = parseBoardingPasses(input)

        assertEquals(1, results.size)
        assertEquals(10, results.first().size)
        assertEquals(listOf(listOf(false,true,false,true,true,false,false,true,false,true)), results)
    }

    @Test
    fun parseMultipleLines() {
        val input ="""
            BFFFBBFRRR
            FFFBBBFRRR
            BBFFBBFRLL
        """.trimIndent().split("\n")

        val results = parseBoardingPasses(input)

        assertEquals(3, results.size)
        assertEquals(10, results[0].size)
        assertEquals(10, results[1].size)
        assertEquals(10, results[2].size)
        assertEquals(true, results[0].first())
        assertEquals(true, results[0].last())
        assertEquals(false, results[1].first())
        assertEquals(true, results[1].last())
        assertEquals(true, results[2].first())
        assertEquals(false, results[2].last())
    }



}