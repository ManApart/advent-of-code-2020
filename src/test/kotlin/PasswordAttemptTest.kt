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
    fun isValidByCount() {
        val pw = PasswordAttempt('a', 1, 3, "abcde")

        assertTrue(pw.isValidByCount())
    }

    @Test
    fun isInvalidByCount() {
        val pw = PasswordAttempt('b', 1, 3, "cdefg")

        assertFalse(pw.isValidByCount())
    }

    @Test
    fun isInvalidByCountOverMax() {
        val pw = PasswordAttempt('b', 1, 2, "bbbb")

        assertFalse(pw.isValidByCount())
    }

}