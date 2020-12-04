import passport.Passport

fun countPassportsWithAllKeys(lines: List<String>): Int {
    return parsePassports(lines).map { Passport(it) }.count { it.hasAllKeys() }
}

fun countValidPassports(lines: List<String>): Int {
    return parsePassports(lines).map { Passport(it) }.count { it.isValid() }
}