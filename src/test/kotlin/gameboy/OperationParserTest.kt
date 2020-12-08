package gameboy

import org.testng.annotations.Test
import kotlin.test.assertEquals

class OperationParserTest {

    @Test
    fun parseNoOp(){
        val result = parseOperation("nop +0")
        val expected = Operation(0, 1, false)
        assertEquals(expected, result)
    }

    @Test
    fun parseIgnoresSpaces(){
        val result = parseOperation("   nop +0  ")
        val expected = Operation(0, 1, false)
        assertEquals(expected, result)
    }

    @Test
    fun parseAcc(){
        val result = parseOperation("acc +2")
        val expected = Operation(2, 1, false)
        assertEquals(expected, result)
    }

    @Test
    fun parseAccNegative(){
        val result = parseOperation("acc -2")
        val expected = Operation(-2, 1, false)
        assertEquals(expected, result)
    }

    @Test
    fun parseJmp(){
        val result = parseOperation("jmp +4")
        val expected = Operation(0, 4, false)
        assertEquals(expected, result)
    }

    @Test
    fun parseJmpNegative(){
        val result = parseOperation("jmp -4")
        val expected = Operation(0, -4, false)
        assertEquals(expected, result)
    }

}