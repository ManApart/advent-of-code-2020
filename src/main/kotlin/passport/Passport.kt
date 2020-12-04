package passport

private val requiredFields = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")

private val validEyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

class Passport(values: List<String>) {
    val attributes: Map<String, String> = values.associate {
        val parts = it.split(":")
        parts.first() to parts.last()
    }

    fun isValid(): Boolean {
        return hasAllKeys() &&
                hasValidBirthYear() &&
                hasValidIssueYear() &&
                hasValidExpirationYear() &&
                hasValidHeight() &&
                hasValidEyeColor() &&
                hasValidPassportId() &&
                hasValidHairColor()
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

    fun hasValidEyeColor(): Boolean {
        val color = attributes["ecl"]
        return color in validEyeColors
    }

    fun hasValidPassportId(): Boolean {
        val idString = attributes["pid"] ?: ""
        return idString.length == 9 && idString.toIntOrNull() != null
    }

    fun hasValidHairColor(): Boolean {
        val hairColor = attributes["hcl"] ?: ""
        return hairColor.length == 7 &&
                hairColor.startsWith("#") &&
                hairColor.substring(1, 7).isAlphaNumeric()
    }

}

private fun String.isAlphaNumeric() : Boolean {
    return this.length == this.filter { it in 'A'..'Z' || it in 'a'..'z' || it in '0'..'9' }.length
}