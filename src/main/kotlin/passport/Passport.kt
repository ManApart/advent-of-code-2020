package passport

private val requiredFields = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")

class Passport(values: List<String>) {
    val attributes: Map<String, String> = values.associate {
        val parts = it.split(":")
        parts.first() to parts.last()
    }

    fun hasAllKeys(): Boolean {
        return requiredFields.all { attributes.keys.contains(it) }
    }

    fun hasValidBirthYear(): Boolean {
        val year = attributes["byr"]?.toIntOrNull() ?: 0
        return year in 1920..2002
    }

    fun hasValidIssueYear(): Boolean {
        val year = attributes["iyr"]?.toIntOrNull() ?: 0
        return year in 2010..2020
    }

    fun hasValidExpirationYear(): Boolean {
        val year = attributes["eyr"]?.toIntOrNull() ?: 0
        return year in 2020..2030
    }
}