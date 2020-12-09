package validNumbers

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import kotlin.test.assertFalse

class ValidNumberCheckerTest {

    @Test
    fun validValue() {
        val input = listOf(1,2,3)

        assertTrue(isValidNumber(4, 3, input))
        assertTrue(isValidNumber(5, 3, input))
        assertTrue(isValidNumber(5, 2, input))
    }

    @Test
    fun invalidValues() {
        val input = listOf(1,2,3)

        assertFalse(isValidNumber(6, 3, input))
        assertFalse(isValidNumber(4, 2, input))
        assertFalse(isValidNumber(2, 3, input), "Can't use duplicate numbers")
    }


}