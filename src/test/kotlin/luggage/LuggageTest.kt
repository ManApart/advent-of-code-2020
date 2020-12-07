package luggage

import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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

    @Test
    fun getAllAncestors() {
        val luggage = Luggage(
            listOf(
                Bag("blue", mapOf("red" to 1)),
                Bag("pink", mapOf("red" to 1)),
                Bag("green", mapOf("blue" to 1)),
                Bag("yellow", mapOf()),
                Bag("red", mapOf())
            )
        )
        val ancestors = luggage.getAllAncestors("red")


        assertEquals(3, ancestors.size)
        assertTrue(ancestors.contains(luggage.bags["blue"]))
        assertTrue(ancestors.contains(luggage.bags["pink"]))
        assertTrue(ancestors.contains(luggage.bags["green"]))
    }

}