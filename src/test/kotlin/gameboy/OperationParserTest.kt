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
        val result = parseOperation("acc +1")
        val expected = Operation(1, 1, false)
        assertEquals(expected, result)
    }

}