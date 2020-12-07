package luggage

import org.testng.annotations.Test
import kotlin.test.assertEquals

class LuggageTest {

    @Test
    fun getSingleBagParent() {
        val luggage = Luggage(
            listOf(
                Bag("blue", mapOf("red" to 1)),
                Bag("red", mapOf())
            )
        )
        val parents = luggage.bags["red"]!!.parents


        assertEquals(1, parents.size)
        assertEquals(luggage.bags["blue"], parents.first())
    }

}