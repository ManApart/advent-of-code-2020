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

    @Test
    fun countAncestorBags() {
        val input = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
        """.trimIndent().split("\n")

        val luggage = Luggage(parseLuggage(input))
        val count = luggage.countAllAncestors("shiny gold")

        assertEquals(4, count)
    }

    @Test
    fun getShortBagDescendants() {
        val luggage = Luggage(
            listOf(
                Bag("pink", mapOf("blue" to 1)),
                Bag("blue", mapOf("red" to 1, "yellow" to 1)),
                Bag("red", mapOf()),
                Bag("yellow", mapOf())
            )
        )
        val count = luggage.countAllDescendants("pink")


        assertEquals(3, count)
    }

    @Test
    fun getLongerBagDescendants() {
        val luggage = Luggage(
            listOf(
                Bag("pink", mapOf("blue" to 1)),
                Bag("blue", mapOf("red" to 2)),
                Bag("red", mapOf("yellow" to 1)),
                Bag("yellow", mapOf())
            )
        )
        val count = luggage.countAllDescendants("pink")


        assertEquals(5, count)
    }

    @Test
    fun countDescendantBags() {
        val input = """
            shiny gold bags contain 2 dark red bags.
            dark red bags contain 2 dark orange bags.
            dark orange bags contain 2 dark yellow bags.
            dark yellow bags contain 2 dark green bags.
            dark green bags contain 2 dark blue bags.
            dark blue bags contain 2 dark violet bags.
            dark violet bags contain no other bags.
        """.trimIndent().split("\n")

        val luggage = Luggage(parseLuggage(input))
        val count = luggage.countAllDescendants("shiny gold")

        assertEquals(126, count)
    }

}