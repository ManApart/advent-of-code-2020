package adapters

import kotlin.test.Test
import kotlin.test.assertEquals

class AdapterPlannerTest {

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

        assertEquals(5, voltageMath)
    }


}