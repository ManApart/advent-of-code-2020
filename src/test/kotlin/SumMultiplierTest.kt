import kotlin.test.Test
import kotlin.test.assertEquals

class SumMultiplierTest {

    @Test
    fun findSimpleSum() {
        val actual = findSumMultiplier(2, listOf(1,1))
        assertEquals(Pair(1,1), actual)
    }

    @Test
    fun findSumFromListOfThree() {
        val actual = findSumMultiplier(2, listOf(1,1,2))
        assertEquals(Pair(1,1), actual)
    }


}