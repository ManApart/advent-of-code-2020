package customs

fun countAnswersForCustoms(lines: List<String>) : Int {
    return countAnswersForAllGroups(parseCustoms(lines))
}

fun countAnswersForAllGroups(groups: List<List<String>>): Int {
    return groups.sumBy { countAnswersPerGroup(it) }
}

fun countAnswersPerGroup(group: List<String>): Int {
    return group.flatMap { it.toCharArray().toList() }.toSet().size
}