fun countValidPassports(lines: List<String>): Int {
    return parsePassports(lines).map { Passport(it) }.count { it.isValid() }
}