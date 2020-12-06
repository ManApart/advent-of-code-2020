package customs

import org.testng.annotations.Test
import kotlin.test.assertEquals

class CustomsParserTest {

    @Test
    fun parseSingleLine() {
        val input = "abcx"

        val result = parseCustoms(listOf(input))

        //groups
        assertEquals(1, result.size)

        //people in group
        assertEquals(1, result.first().size)

        assertEquals("abcx", result.first().first())
    }

    @Test
    fun parseSingleGroup() {
        val input = """
            abcx
            abcy
            abcz
        """.trimIndent().split("\n")

        val result = parseCustoms(input)

        //groups
        assertEquals(1, result.size)

        //people in group
        assertEquals(3, result.first().size)

        assertEquals("abcx", result.first()[0])
        assertEquals("abcy", result.first()[1])
        assertEquals("abcz", result.first()[2])
    }

    @Test
    fun parseMultiples() {
        val input = """
            abcx
            
            abcz
        """.trimIndent().split("\n")

        val result = parseCustoms(input)

        //groups
        assertEquals(2, result.size)

        //people in group
        assertEquals(1, result.first().size)
        assertEquals(1, result.last().size)

        assertEquals("abcx", result.first()[0])
        assertEquals("abcz", result.last()[0])
    }


}