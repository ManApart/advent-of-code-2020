import org.testng.annotations.Test
import kotlin.test.assertEquals

class PassportParserTest {
//    val input = """
//        ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
//        byr:1937 iyr:2017 cid:147 hgt:183cm
//
//        iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
//        hcl:#cfa07d byr:1929
//
//        hcl:#ae17e1 iyr:2013
//        eyr:2024
//        ecl:brn pid:760753108 byr:1931
//        hgt:179cm
//
//        hcl:#cfa07d eyr:2025 pid:166559648
//        iyr:2011 ecl:brn hgt:59in
//    """.trimIndent()

    @Test
    fun parseSingleLine() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        val result = parsePassports(listOf(input)).first()

        assertEquals(8, result.size)
        assertEquals("ecl:gry", result.first())
        assertEquals("hgt:183cm", result.last())
    }

    @Test
    fun parseMultiLine() {
        val input = """
                iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
                hcl:#cfa07d byr:1929
        """.trimIndent().split("\n")

        val result = parsePassports(input).first()

        assertEquals(7, result.size)
        assertEquals("iyr:2013", result.first())
        assertEquals("byr:1929", result.last())
    }
}