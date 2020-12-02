import kotlin.test.Test
import kotlin.test.assertEquals

class PasswordAttemptTest {

    @Test
    fun parsesFromString() {
        val line = "1-5 t: npxgd"
        val expected = PasswordAttempt('t', 1,5, "npxgd")

        assertEquals(expected, line.toPasswordAttempt())
    }

}