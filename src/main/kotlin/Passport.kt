class Passport(values: List<String>) {
    val attributes: Map<String, String> = values.associate {
        val parts = it.split(":")
        parts.first() to parts.last()
    }

    fun isValid(): Boolean {
        return attributes.keys.size == 8
    }
}