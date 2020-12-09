package validNumbers

import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class ValidNumberCheckerTest {

    @Test
    fun validValue() {
        val input = listOf(1,2,3)

        assertTrue(isValidNumber(4, 3, input))
        assertTrue(isValidNumber(5, 3, input))
        assertTrue(isValidNumber(5, 2, input))
    }


}