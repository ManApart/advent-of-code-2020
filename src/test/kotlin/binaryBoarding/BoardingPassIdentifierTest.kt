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

}