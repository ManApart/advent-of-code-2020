package gameboy

import org.testng.annotations.Test
import kotlin.test.assertEquals

class OperationParserTest {

    @Test
    fun parseNoOp(){
        val op = parseOperation("nop +0")
        assertEquals("nop", op.type)
        assertEquals(0, op.accInc)
        assertEquals(1, op.indexInc)
    }

    @Test
    fun parseIgnoresSpaces(){
        val op = parseOperation("   nop +0  ")
        assertEquals("nop", op.type)
        assertEquals(0, op.accInc)
        assertEquals(1, op.indexInc)
    }

    @Test
    fun parseAcc(){
        val op = parseOperation("acc +2")
        assertEquals("acc", op.type)
        assertEquals(2, op.accInc)
        assertEquals(1, op.indexInc)
    }

    @Test
    fun parseAccNegative(){
        val op = parseOperation("acc -2")
        assertEquals("acc", op.type)
        assertEquals(-2, op.accInc)
        assertEquals(1, op.indexInc)
    }

    @Test
    fun parseJmp(){
        val op = parseOperation("jmp +4")
        assertEquals("jmp", op.type)
        assertEquals(0, op.accInc)
        assertEquals(4, op.indexInc)
    }

    @Test
    fun parseJmpNegative(){
        val op = parseOperation("jmp -4")
        assertEquals("jmp", op.type)
        assertEquals(0, op.accInc)
        assertEquals(-4, op.indexInc)
    }

    @Test
    fun parseListOfOps(){
        val input = """
            acc +2
            nop +0
            jmp -3
        """.trimIndent().split("\n")
        val results = parseOperations(input)

        assertEquals(3, results.size)
        assertEquals(2, results.first().accInc)
        assertEquals(-3, results.last().indexInc)
    }

}