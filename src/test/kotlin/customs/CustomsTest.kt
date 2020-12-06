package customs

import org.testng.annotations.Test
import kotlin.test.assertEquals

class CustomsTest {

    @Test
    fun singleGroup() {
        val input = listOf("abc")

        val result = countAnswersPerGroup(input)
        assertEquals(3, result)
    }

    @Test
    fun duplicatesNotCounted() {
        val input = listOf("aaa")

        val result = countAnswersPerGroup(input)
        assertEquals(1, result)
    }

    @Test
    fun multiplePeopleInSingleGroup() {
        val input = listOf("a", "b", "c", "d")

        val result = countAnswersPerGroup(input)
        assertEquals(4, result)
    }

    @Test
    fun countAcrossMultipleGroups() {
        val input = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b
        """.trimIndent().split("\n")

        val result = countAnswersForAllGroups(parseCustoms(input))
        assertEquals(11, result)
    }




}