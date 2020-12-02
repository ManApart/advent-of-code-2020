import kotlin.test.Test
import kotlin.test.assertEquals

class PasswordCheckerTest {

    @Test
    fun passwordsAreValid(){
        val input = """
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc
        """.trimIndent().split("\n")

        val validPasswords = countValidPasswordsByLetterCount(input)
        assertEquals(2, validPasswords)
    }
}