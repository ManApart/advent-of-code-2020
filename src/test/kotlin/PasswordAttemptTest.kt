import org.testng.Assert.assertFalse
import org.testng.Assert.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals

class PasswordAttemptTest {

    @Test
    fun parsesFromString() {
        val line = "1-5 t: npxgd"
        val expected = PasswordAttempt('t', 1,5, "npxgd")

        assertEquals(expected, line.toPasswordAttempt())
    }

    @Test
    fun isValid() {
        val pw = PasswordAttempt('a', 1, 3, "abcde")

        assertTrue(pw.isValid())
    }

    @Test
    fun isInvalid() {
        val pw = PasswordAttempt('b', 1, 3, "cdefg")

        assertFalse(pw.isValid())
    }

    @Test
    fun isInvalidOverMax() {
        val pw = PasswordAttempt('b', 1, 2, "bbbb")

        assertFalse(pw.isValid())
    }

}