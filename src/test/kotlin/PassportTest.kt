import org.testng.Assert.assertFalse
import org.testng.annotations.Test
import kotlin.test.assertEquals

class PassportTest {

    @Test
    fun parsesValues() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm".split(" ")

        val passport = Passport(input)

        assertEquals(8, passport.attributes.keys.size)
        assertEquals("gry", passport.attributes["ecl"])
        assertEquals("2020", passport.attributes["eyr"])
        assertEquals("#fffffd", passport.attributes["hcl"])
    }

    @Test
    fun isNotValid() {
        val input = "ecl:gry eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm".split(" ")

        val passport = Passport(input)

        assertFalse(passport.isValid())
    }



}