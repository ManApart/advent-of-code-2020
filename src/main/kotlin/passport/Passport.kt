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

    fun hasValidHeight(): Boolean {
        val heightString = attributes["hgt"]
        if  (heightString == null || heightString.length < 3){
            return false
        }
        val cm = heightString.endsWith("cm")
        val inches = heightString.endsWith("in")
        val height = heightString.substring(0, heightString.length-2).toIntOrNull() ?: 0

        if (cm){
            return height in 150..193
        }

        if (inches){
            return height in 59..76
        }

        return false
    }
}