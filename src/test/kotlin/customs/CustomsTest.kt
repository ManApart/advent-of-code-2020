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

        val result = countAnswersForCustoms(input)
        assertEquals(11, result)
    }

    @Test
    fun singleGroupAllAnswered() {
        val input = listOf("abc")

        val result = countAnswersThatAllAnsweredInGroup(input)
        assertEquals(3, result)
    }

    @Test
    fun singleGroupAllAnsweredNone() {
        val input = listOf("a", "b", "c", "d")

        val result = countAnswersThatAllAnsweredInGroup(input)
        assertEquals(0, result)
    }

    @Test
    fun singleGroupAllAnsweredOverlap() {
        val input = listOf("ab", "ac")

        val result = countAnswersThatAllAnsweredInGroup(input)
        assertEquals(1, result)
    }

    @Test
    fun singleGroupAllAnsweredOverlapDoesNotIncludeDuplicates() {
        val input = listOf("abb", "ac")

        val result = countAnswersThatAllAnsweredInGroup(input)
        assertEquals(1, result)
    }

    @Test
    fun allSingleLetterAllAnswered() {
        val input = listOf("a", "a", "a")

        val result = countAnswersPerGroup(input)
        assertEquals(1, result)
    }

}