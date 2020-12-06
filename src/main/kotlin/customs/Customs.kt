package customs

fun countAnswersPerGroup(group: List<String>): Int {
    return group.flatMap { it.toCharArray().toList() }.toSet().size
}