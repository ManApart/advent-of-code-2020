data class PasswordAttempt(val letter: Char, val minCount: Int, val maxCount: Int, val phrase: String) {
    fun isValid(): Boolean {
        return false
    }
}

fun String.toPasswordAttempt(): PasswordAttempt {
    val halves = this.split(":")
    val phrase = halves.last().trim()

    val requirements = halves.first().split(" ")
    val letter = requirements.last().last()

    val range = requirements.first().split("-")
    val min = range.first().toInt()
    val max = range.last().toInt()

    return PasswordAttempt(letter, min, max, phrase)
}