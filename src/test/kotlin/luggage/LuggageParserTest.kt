package luggage

import org.testng.annotations.Test
import parsePassports
import kotlin.test.assertEquals

class LuggageParserTest {

    @Test
    fun parseSingleLine() {
        val input = "light red bags contain 1 bright white bag, 2 muted yellow bags."

        val bag = parseLuggage(listOf(input)).first()

        assertEquals("light red", bag.id)
        assertEquals(2, bag.contents.keys.size)
        assertEquals(1, bag.contents["bright white"])
        assertEquals(2, bag.contents["muted yellow"])
    }

    @Test
    fun parseNoContents() {
        val input = "faded blue bags contain no other bags."

        val bag = parseLuggage(listOf(input)).first()

        assertEquals("faded blue", bag.id)
        assertEquals(0, bag.contents.keys.size)
    }


}