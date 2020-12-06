package customs

fun countAnswersForAllGroups(groups: List<List<String>>): Int {
    return groups.sumBy { countAnswersPerGroup(it) }
}

fun countAnswersPerGroup(group: List<String>): Int {
    return group.flatMap { it.toCharArray().toList() }.toSet().size
}