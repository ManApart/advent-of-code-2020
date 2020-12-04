package passport

private val requiredFields = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")

class Passport(values: List<String>) {
    val attributes: Map<String, String> = values.associate {
        val parts = it.split(":")
        parts.first() to parts.last()
    }

    fun isValid(): Boolean {
        return requiredFields.all { attributes.keys.contains(it) }
    }
}