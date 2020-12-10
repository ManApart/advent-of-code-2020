package adapters

import kotlin.test.Test
import kotlin.test.assertEquals

class AdapterPlannerTest {

    @Test
    fun findVoltageCounts() {
        val input = """
            1
            2
            3
            4
            7
        """.trimIndent().split("\n").map { it.toInt() }
        val voltageMath = findVoltageCounts(input)
        val expected = mapOf(1 to 4, 3 to 2)

        assertEquals(expected, voltageMath)
    }

    @Test
    fun findVoltageCountsOutOfOrder() {
        val input = """
            1
            7
            4
            3
            2
        """.trimIndent().split("\n").map { it.toInt() }
        val voltageMath = findVoltageCounts(input)
        val expected = mapOf(1 to 4, 3 to 2)

        assertEquals(expected, voltageMath)
    }

    @Test
    fun part1Example1() {
        val input = """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4
        """.trimIndent().split("\n").map { it.toInt() }
        val voltageMath = findProductOfVoltageCounts(input)

        assertEquals(7*5, voltageMath)
    }


}