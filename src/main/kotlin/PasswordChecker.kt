fun countValidPasswords(passwordAttempts: List<String>): Int {
    return passwordAttempts.map { it.toPasswordAttempt() }.count { it.isValid() }
}