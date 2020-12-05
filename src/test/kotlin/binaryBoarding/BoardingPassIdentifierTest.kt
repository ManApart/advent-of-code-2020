package binaryBoarding

import org.testng.annotations.Test
import kotlin.test.assertEquals

class BoardingPassIdentifierTest {

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

    @Test
    fun findGapInListSimple() {
        val input = listOf(1,3)
        assertEquals(2, input.findGapInList())
    }

    @Test
    fun findGapInListMoreNumbers() {
        val input = listOf(1,2,3,4,6,7,8,9,10)
        assertEquals(5, input.findGapInList())
    }

    @Test
    fun findGapInListOutOfOrder() {
        val input = listOf(5,1,4,2)
        assertEquals(3, input.findGapInList())
    }

    @Test
    fun findGapID() {
        val input = listOf(
            "FFFFFFFLLL",
            "FFFFFFFLLR",
            "FFFFFFFLRR",
        )
        assertEquals(2, findGapId(input))
    }

}