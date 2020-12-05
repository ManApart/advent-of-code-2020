import kotlin.test.Test
import kotlin.test.assertEquals

class BinaryCounterTest {

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

}