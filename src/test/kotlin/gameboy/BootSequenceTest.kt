package gameboy

import org.testng.annotations.Test
import kotlin.test.assertEquals

class BootSequenceTest {

    @Test
    fun exampleTest(){
        val input = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
        """.trimIndent().split("\n")
        val acc = findAccAtLoopStart(parseOperations(input))

        assertEquals(5, acc)
    }

    @Test
    fun findAccAtProgramComplete(){
        val input = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            nop -4
            acc +6
        """.trimIndent().split("\n")
        val acc = findAccAtProgramComplete(parseOperations(input))

        assertEquals(8, acc)
    }

    @Test
    fun part2Test(){
        val input = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
        """.trimIndent().split("\n")
        val acc = findAccAtByFiddlingOps(parseOperations(input))

        assertEquals(8, acc)
    }

}