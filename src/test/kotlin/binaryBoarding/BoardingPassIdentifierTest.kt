package binaryBoarding

import org.testng.annotations.Test
import kotlin.test.assertEquals

class BoardingPassIdentifierTest {

    @Test
    fun findSimpleNumber() {
        val pickLargerSteps = listOf(true, false, true)
        val result = findNumber(0, 7, pickLargerSteps)
        assertEquals(5, result)
    }

    @Test
    fun findLongerNumber() {
        val pickLargerSteps = listOf(false, true, false, true, true, false)
        val result = findNumber(0, 127, pickLargerSteps)
        assertEquals(44, result)
    }


    @Test
    fun identifySeats() {
        //first seven == row, last 3 == column
        //id = column + row*8
        val input = parseBoardingPasses(listOf(
            "BFFFBBFRRR",
            "FFFBBBFRRR",
            "BBFFBBFRLL"
        ))
        assertEquals(567, identifySeatID(input[0]))
        assertEquals(119, identifySeatID(input[1]))
        assertEquals(820, identifySeatID(input[2]))
    }

    @Test
    fun findLargestSeatId() {
        val input = parseBoardingPasses(listOf(
            "BFFFBBFRRR",
            "FFFBBBFRRR",
            "BBFFBBFRLL"
        ))
        assertEquals(820, findLargestSeatID(input))
    }

}