package gameboy

import org.testng.annotations.Test
import kotlin.test.assertEquals

class OperationParserTest {

    @Test
    fun parseNoOp(){
        val result = parseOperation("nop +0")
        val expected = Operation(0)
        assertEquals(expected, result)
    }

}