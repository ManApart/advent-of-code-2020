fun countValidPasswordsByLetterCount(passwordAttempts: List<String>): Int {
    return passwordAttempts.map { it.toPasswordAttempt() }.count { it.isValidByCount() }
}

fun countValidPasswordsByLetterPosition(passwordAttempts: List<String>): Int {
    return passwordAttempts.map { it.toPasswordAttempt() }.count { it.isValidByPosition() }
}