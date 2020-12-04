package passport

import org.testng.Assert.assertFalse
import org.testng.Assert.assertTrue
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

        assertFalse(passport.hasAllKeys())
    }

    @Test
    fun isValidAllEight() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm".split(" ")

        val passport = Passport(input)

        assertTrue(passport.hasAllKeys())
    }

    @Test
    fun isValidAllMissingOptional() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 hgt:183cm".split(" ")

        val passport = Passport(input)

        assertTrue(passport.hasAllKeys())
    }

    @Test
    fun birthYearValidation() {
        assertEquals(false, Passport(listOf("byr:abc")).hasValidBirthYear())
        assertEquals(false, Passport(listOf("byr:1919")).hasValidBirthYear())
        assertEquals(true, Passport(listOf("byr:1920")).hasValidBirthYear())
        assertEquals(true, Passport(listOf("byr:2002")).hasValidBirthYear())
        assertEquals(false, Passport(listOf("byr:2003")).hasValidBirthYear())
    }

    @Test
    fun issueYearValidation() {
        assertEquals(false, Passport(listOf("iyr:abc")).hasValidIssueYear())
        assertEquals(false, Passport(listOf("iyr:2009")).hasValidIssueYear())
        assertEquals(true, Passport(listOf("iyr:2010")).hasValidIssueYear())
        assertEquals(true, Passport(listOf("iyr:2020")).hasValidIssueYear())
        assertEquals(false, Passport(listOf("iyr:2021")).hasValidIssueYear())
    }



}