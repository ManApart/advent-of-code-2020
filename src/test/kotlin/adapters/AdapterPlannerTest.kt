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

    @Test
    fun part1Example2() {
        val input = """
            28
            33
            18
            42
            31
            14
            46
            20
            48
            47
            24
            23
            49
            45
            19
            38
            39
            11
            1
            32
            25
            35
            8
            17
            7
            9
            4
            2
            34
            10
            3
        """.trimIndent().split("\n").map { it.toInt() }
        val voltageMath = findProductOfVoltageCounts(input)

        assertEquals(22*10, voltageMath)
    }


    @Test
    fun part2Example1() {
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
        val voltageMath = countChainArrangementOptions(input)

        assertEquals(7, voltageMath)
    }

}